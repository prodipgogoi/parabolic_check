package com.paraboliccheck.model;

import com.paraboliccheck.entity.OrderModel;

public class OrderRes {

	private long code;
	private String status;
	private String timestamp;
	private String message;
	private OrderModel data;

	public OrderRes() {
		super();
	}

	public OrderRes(long code, String status, String timestamp, String message, OrderModel data) {
		super();
		this.code = code;
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.data = data;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OrderModel getData() {
		return data;
	}

	public void setData(OrderModel data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OrderRes [code=" + code + ", status=" + status + ", timestamp=" + timestamp + ", message=" + message
				+ ", data=" + data + "]";
	}

}
