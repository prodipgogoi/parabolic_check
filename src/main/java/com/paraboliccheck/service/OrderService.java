package com.paraboliccheck.service;

import java.util.Date;
import java.util.List;

import com.paraboliccheck.entity.OrderModel;

public interface OrderService {

	List<OrderModel> getAllOrders(Date fromDate, Date todate);
	
	List<OrderModel> getOrderByAccount(long accountId);
	
	List<OrderModel> getAllOpenOrders();
	
	List<OrderModel> getOpenOrderByAccount(long accountId);

	void updateOrder(OrderModel o);

	OrderModel save(OrderModel order);
}
