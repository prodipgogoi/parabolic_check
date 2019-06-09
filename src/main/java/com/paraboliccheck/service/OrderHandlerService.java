package com.paraboliccheck.service;

import java.util.Date;
import java.util.List;

import com.paraboliccheck.entity.OrderModel;

public interface OrderHandlerService {
	
	void placeBuyOrders();
	
	void placeSellOrders();
	
	void closeBuyOrders();
	
	void closeSellOrder();

	OrderModel placeOrder(OrderModel order);	
	
	OrderModel closeOrder(OrderModel order);	
	
}
