package com.paraboliccheck.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paraboliccheck.data.CommonData;
import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.handlers.PushBulletHandler;
import com.paraboliccheck.model.FeedModel;
import com.paraboliccheck.repository.PriceFeedRepository;
import com.paraboliccheck.service.DataFeedService;
import com.paraboliccheck.service.OrderHandlerService;


@Service
public class DataFeedServiceImpl implements DataFeedService {

	@Autowired
	private OrderHandlerService orderHandlerService;
	
	@Autowired
	private PriceFeedRepository priceFeedRepository;

	@Autowired
	private ParabolicCalculator caculator;
	
	@Autowired
	private PushBulletHandler pushBullet;

	private PriceFeedModel prevModelFiveMin;

	private PriceFeedModel currentModelFiveMin;

	private PriceFeedModel prevModelThirtyMin;

	private PriceFeedModel currentModelThirtyMin;

	private String symbol;

	private boolean orderPlacedBuy = false;

	private boolean orderPlacedSell = false;

	

	private String formate = "dd-MM-yyyy  HH:mm";

	@Override
	public void saveDataFeed(FeedModel feed, int period) {
		prepearPriceModel(feed, period);
		if (CommonData.thirtyMinPriceFeeds.size() > 3) {
			checkForOrders();
		}
	}

	private void checkForOrders() {
		if (currentModelFiveMin.getSignal().equals(currentModelThirtyMin.getSignal())) {
			if (currentModelFiveMin.getSignal().equals("BUY") && !orderPlacedBuy) {

				// close sell order orderPlacedSell is true
				if (orderPlacedSell) {
					pushBullet.sendBullet("Close all sell orders");
					//orderHandlerService.closeSellOrder();
				}
				// place a buy order
				if (!orderPlacedBuy) {
					pushBullet.sendBullet("Open all buy orders");
					//orderHandlerService.placeBuyOrders();
				}
				orderPlacedBuy = true;
				orderPlacedSell = false;
			} else if (currentModelFiveMin.getSignal().equals("SELL") && !orderPlacedSell) {

				// close buy order orderPlacedBuy is true
				if (orderPlacedBuy) {
					pushBullet.sendBullet("Close all buy orders");
					//orderHandlerService.closeBuyOrders();
				}
				// open sell order
				if (!orderPlacedSell) {
					pushBullet.sendBullet("Open all sell orders");
					//orderHandlerService.placeSellOrders();
				}
				orderPlacedBuy = false;
				orderPlacedSell = true;
			}
		} else {
			// close all order
			if (orderPlacedBuy) {
				// close all buy order
				pushBullet.sendBullet("Close all buy orders");
				//orderHandlerService.closeBuyOrders();
				orderPlacedBuy = false;
			}

			if (orderPlacedSell) {
				pushBullet.sendBullet("Close all sell orders");
				//orderHandlerService.closeSellOrder();
				// close all sell order
				orderPlacedSell = false;
			}

		}
	}

	private void prepearPriceModel(FeedModel model, int period) {

		long epoch = 0;
		try {
			if (period == 5) {
				if(currentModelFiveMin!=null) {
				if (model.getLastTradeTime() != currentModelFiveMin.getTimestamp()) {					
					prevModelFiveMin = currentModelFiveMin;					
					currentModelFiveMin = createModel(model, 5);					
					CommonData.fiveMinFeeds.add(model);
					CommonData.fiveMinPriceFeeds.add(currentModelFiveMin);
					if (CommonData.fiveMinPriceFeeds.size() == 3) {
						caculator.prepareTheInitialData(CommonData.fiveMinPriceFeeds);
						priceFeedRepository.save(currentModelFiveMin);
					} else if (CommonData.fiveMinPriceFeeds.size() > 3) {
						caculator.calculateParabolic(prevModelFiveMin, currentModelFiveMin, 0.03, 0.05, 0.01);
						priceFeedRepository.save(currentModelFiveMin);
					}
				}
				}else {
					currentModelFiveMin = createModel(model, 5);
					CommonData.fiveMinFeeds.add(model);
					CommonData.fiveMinPriceFeeds.add(currentModelFiveMin);
					priceFeedRepository.save(currentModelFiveMin);
				}
			} else {
				if(currentModelThirtyMin!=null) {
				if (model.getLastTradeTime() != currentModelThirtyMin.getTimestamp()) {
					prevModelThirtyMin = currentModelThirtyMin;
					currentModelThirtyMin = createModel(model, 30);
					CommonData.thirtyMinFeeds.add(model);
					CommonData.thirtyMinPriceFeeds.add(currentModelThirtyMin);
					if (CommonData.thirtyMinPriceFeeds.size() == 3) {
						caculator.prepareTheInitialData(CommonData.thirtyMinPriceFeeds);
						priceFeedRepository.save(currentModelThirtyMin);
					} else {
						caculator.calculateParabolic(prevModelThirtyMin, currentModelThirtyMin, 0.02, 0.33, 0.22);
						priceFeedRepository.save(currentModelThirtyMin);
					}
				}
				}else {
					currentModelThirtyMin = createModel(model, 30);
					CommonData.thirtyMinFeeds.add(model);
					CommonData.thirtyMinPriceFeeds.add(currentModelThirtyMin);
					priceFeedRepository.save(currentModelThirtyMin);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private PriceFeedModel createModel(FeedModel model, int minute) {
		PriceFeedModel priceModel = new PriceFeedModel();
		String date = new java.text.SimpleDateFormat(formate)
				.format(new java.util.Date(model.getLastTradeTime() * 1000));
		priceModel.setTimestamp(model.getLastTradeTime());
		priceModel.setTime(date);
		priceModel.setOpen(model.getOpen());
		priceModel.setHigh(model.getHigh());
		priceModel.setLow(model.getLow());
		priceModel.setClose(model.getClose());
		priceModel.setVolume(model.getTradedQty());
		priceModel.setMinute(minute);
		return priceModel;
	}

}
