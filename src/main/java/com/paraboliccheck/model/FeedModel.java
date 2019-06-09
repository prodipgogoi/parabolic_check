package com.paraboliccheck.model;




public class FeedModel {

	private long LastTradeTime;
	private double QuotationLot;
	private double TradedQty;
	private double OpenInterest;
	private double Open;
	private double High;
	private double Low;
	private double Close;
	public FeedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedModel(long lastTradeTime, double quotationLot, double tradedQty, double openInterest, double open,
			double high, double low, double close) {
		super();
		LastTradeTime = lastTradeTime;
		QuotationLot = quotationLot;
		TradedQty = tradedQty;
		OpenInterest = openInterest;
		Open = open;
		High = high;
		Low = low;
		Close = close;
	}
	public long getLastTradeTime() {
		return LastTradeTime;
	}
	public void setLastTradeTime(long lastTradeTime) {
		LastTradeTime = lastTradeTime;
	}
	public double getQuotationLot() {
		return QuotationLot;
	}
	public void setQuotationLot(double quotationLot) {
		QuotationLot = quotationLot;
	}
	public double getTradedQty() {
		return TradedQty;
	}
	public void setTradedQty(double tradedQty) {
		TradedQty = tradedQty;
	}
	public double getOpenInterest() {
		return OpenInterest;
	}
	public void setOpenInterest(double openInterest) {
		OpenInterest = openInterest;
	}
	public double getOpen() {
		return Open;
	}
	public void setOpen(double open) {
		Open = open;
	}
	public double getHigh() {
		return High;
	}
	public void setHigh(double high) {
		High = high;
	}
	public double getLow() {
		return Low;
	}
	public void setLow(double low) {
		Low = low;
	}
	public double getClose() {
		return Close;
	}
	public void setClose(double close) {
		Close = close;
	}
	@Override
	public String toString() {
		return "FeedModel [LastTradeTime=" + LastTradeTime + ", QuotationLot=" + QuotationLot + ", TradedQty="
				+ TradedQty + ", OpenInterest=" + OpenInterest + ", Open=" + Open + ", High=" + High + ", Low=" + Low
				+ ", Close=" + Close + "]";
	}
	
	
	
	
}
