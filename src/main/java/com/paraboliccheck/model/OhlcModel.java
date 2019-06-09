package com.paraboliccheck.model;

import java.util.List;

public class OhlcModel {
	
	private int code;
	private String status;
	private String timestemp;
	private String message;
	private List<FeedModel> data;
	public OhlcModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OhlcModel(int code, String status, String timestemp, String message, List<FeedModel> data) {
		super();
		this.code = code;
		this.status = status;
		this.timestemp = timestemp;
		this.message = message;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestemp() {
		return timestemp;
	}
	public void setTimestemp(String timestemp) {
		this.timestemp = timestemp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FeedModel> getData() {
		return data;
	}
	public void setData(List<FeedModel> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ohlcModel [code=" + code + ", status=" + status + ", timestemp=" + timestemp + ", message=" + message
				+ ", data=" + data + "]";
	}

	
}
