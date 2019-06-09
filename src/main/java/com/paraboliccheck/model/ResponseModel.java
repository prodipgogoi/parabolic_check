package com.paraboliccheck.model;

import java.util.List;

public class ResponseModel {

	private FeedRequestModel Request;
	private List<FeedModel> Result;
	private String MessageType;
	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseModel(FeedRequestModel request, List<FeedModel> result, String messageType) {
		super();
		Request = request;
		Result = result;
		MessageType = messageType;
	}
	public FeedRequestModel getRequest() {
		return Request;
	}
	public void setRequest(FeedRequestModel request) {
		Request = request;
	}
	public List<FeedModel> getResult() {
		return Result;
	}
	public void setResult(List<FeedModel> result) {
		Result = result;
	}
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	@Override
	public String toString() {
		return "ResponseModel [Request=" + Request + ", Result=" + Result + ", MessageType=" + MessageType + "]";
	}
}
