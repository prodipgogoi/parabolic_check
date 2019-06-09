package com.paraboliccheck.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paraboliccheck.entity.OrderModel;
import com.paraboliccheck.handlers.RestHandlers;
import com.paraboliccheck.model.AccountModel;
import com.paraboliccheck.model.OrderRes;
import com.paraboliccheck.model.OrderedReq;
import com.paraboliccheck.service.AccountService;
import com.paraboliccheck.service.OrderHandlerService;
import com.paraboliccheck.service.OrderService;


@Service
public class OrderHandlerServiceImpl implements OrderHandlerService {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestHandlers restHandlers;
	
	private double unitPrice;
	
	private String symbol;

	@Override
	public void placeBuyOrders() {
		List<AccountModel> accounts = accountService.getAllAccounts();
		for(AccountModel model : accounts) {
			double numberOfUnits=model.getBalance()/unitPrice;
			int c = (int) Math.round(numberOfUnits);
			OrderModel order = new OrderModel();
			//order.setAccountId(model.getAccountId());
			//order.setOrderType("BUY");
			order.setSymbol(symbol);
			order = placeOrder(order);
			order = orderService.save(order);
			accountService.updateAccount(model);
		}

	}

	@Override
	public void placeSellOrders() {
		List<AccountModel> accounts = accountService.getAllAccounts();
		for(AccountModel model : accounts) {
			double numberOfUnits=model.getBalance()/unitPrice;
			int c = (int) Math.round(numberOfUnits);
			OrderModel order = new OrderModel();
			//order.setAccountId(model.getAccountId());
			//order.setOrderType("SELL");
			order.setSymbol(symbol);
			order = placeOrder(order);
			order = orderService.save(order);
			accountService.updateAccount(model);
		}


	}

	@Override
	public void closeBuyOrders() {
		
		List<OrderModel> openOrders = orderService.getAllOpenOrders();
		for(OrderModel o : openOrders) {
			o = closeOrder(o);
			//AccountModel account=	accountService.getAccountById(o.getAccountId());
			//account.setBalance(account.getBalance()+o.getProfit());
			//accountService.updateAccount(account);
			orderService.updateOrder(o);
		}
	}

	@Override
	public void closeSellOrder() {		
		List<OrderModel> openOrders = orderService.getAllOpenOrders();
		for(OrderModel o : openOrders) {
			o = closeOrder(o);
			//AccountModel account=	accountService.getAccountById(o.getAccountId());
			//account.setBalance(account.getBalance()+o.getProfit());
			//accountService.updateAccount(account);
			orderService.updateOrder(o);
		}
	}
	

	@Override
	public OrderModel placeOrder(OrderModel order) {
		OrderedReq req = new OrderedReq("b", "MCX_FO", "CRUDEOILM19JUNFUT", 10, "m", "i");
		OrderRes orderRes=restHandlers.placeOrder(req);
		return orderRes.getData();
	}

	@Override
	public OrderModel closeOrder(OrderModel order) {
		
		return null;
	}
	

}
