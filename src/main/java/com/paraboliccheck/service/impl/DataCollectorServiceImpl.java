package com.paraboliccheck.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paraboliccheck.handlers.CollectData;
import com.paraboliccheck.handlers.RestHandlers;
import com.paraboliccheck.handlers.WSClientEndpoint;
import com.paraboliccheck.model.FeedModel;
import com.paraboliccheck.model.SnapshortModel;
import com.paraboliccheck.service.DataCollectorService;
import com.paraboliccheck.service.DataFeedService;


@Service
public class DataCollectorServiceImpl implements DataCollectorService {

	
	@Autowired
	private RestHandlers restHandlers;
	
	@Autowired
	private DataFeedService dataFeedService;
	
	@Override
	public FeedModel getCurrentFeeds(String symbol, String period) {
		SnapshortModel model = null;
		FeedModel feedModel=null;
		int periods=Integer.parseInt(period);
		model = restHandlers.getSnapShort(periods, symbol);
		if(model!=null && model.getCLOSE()!=0.0) {
			feedModel=new FeedModel();
			feedModel.setClose(model.getCLOSE());
			feedModel.setHigh(model.getHIGH());
			feedModel.setLastTradeTime(model.getLASTTRADETIME());
			feedModel.setLow(model.getLOW());
			feedModel.setOpen(model.getOPEN());
			feedModel.setOpenInterest(model.getOPENINTEREST());
			feedModel.setTradedQty(model.getTRADEDQTY());
		}else {
			
			feedModel = getCurrentFeeds(symbol, period);
			
		}
		dataFeedService.saveDataFeed(feedModel,periods);
		return feedModel;		
	}
}
