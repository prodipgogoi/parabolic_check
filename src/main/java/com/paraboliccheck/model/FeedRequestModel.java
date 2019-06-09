package com.paraboliccheck.model;

public class FeedRequestModel {

	private String Exchange;
	private String InstrumentIdentifier;
	private String IsShortIdentifier;
	private long From;
	private long To ;
	private int Max;
	private String Periodicity;
	private int Period;
	private String MessageType;
	
	public FeedRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedRequestModel(String exchange, String instrumentIdentifier, String isShortIdentifier, long from, long to,
			int max, String periodicity, int period, String messageType) {
		super();
		Exchange = exchange;
		InstrumentIdentifier = instrumentIdentifier;
		IsShortIdentifier = isShortIdentifier;
		From = from;
		To = to;
		Max = max;
		Periodicity = periodicity;
		Period = period;
		MessageType = messageType;
	}
	public String getExchange() {
		return Exchange;
	}
	public void setExchange(String exchange) {
		Exchange = exchange;
	}
	public String getInstrumentIdentifier() {
		return InstrumentIdentifier;
	}
	public void setInstrumentIdentifier(String instrumentIdentifier) {
		InstrumentIdentifier = instrumentIdentifier;
	}
	public String getIsShortIdentifier() {
		return IsShortIdentifier;
	}
	public void setIsShortIdentifier(String isShortIdentifier) {
		IsShortIdentifier = isShortIdentifier;
	}
	public long getFrom() {
		return From;
	}
	public void setFrom(long from) {
		From = from;
	}
	public long getTo() {
		return To;
	}
	public void setTo(long to) {
		To = to;
	}
	public int getMax() {
		return Max;
	}
	public void setMax(int max) {
		Max = max;
	}
	public String getPeriodicity() {
		return Periodicity;
	}
	public void setPeriodicity(String periodicity) {
		Periodicity = periodicity;
	}
	public int getPeriod() {
		return Period;
	}
	public void setPeriod(int period) {
		Period = period;
	}
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	@Override
	public String toString() {
		return "FeedRequestModel [Exchange=" + Exchange + ", InstrumentIdentifier=" + InstrumentIdentifier
				+ ", IsShortIdentifier=" + IsShortIdentifier + ", From=" + From + ", To=" + To + ", Max=" + Max
				+ ", Periodicity=" + Periodicity + ", Period=" + Period + ", MessageType=" + MessageType + "]";
	}
	
	
}
