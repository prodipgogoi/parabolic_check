package com.paraboliccheck.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paraboliccheck.entity.OrderModel;
import com.paraboliccheck.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<OrderModel> getAllOrders(Date fromDate, Date todate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOrderByAccount(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getAllOpenOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOpenOrderByAccount(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(OrderModel o) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderModel save(OrderModel order) {
		// TODO Auto-generated method stub
		return null;
	}

}
