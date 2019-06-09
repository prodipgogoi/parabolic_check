package com.paraboliccheck.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderNo;
	private String client_id;
	private String exchange;
	private int token;
    private String symbol;
    private String product;
    private String order_type;
    private String duration;
    private double price;
    private double trigger_price;
    private long quantity;
    private long disclosed_quantity;
    private String transaction_type;
    private double average_price;
    private double traded_quantity;
    private String message;
    private String exchange_order_id;
    private String parent_order_id;
    private String order_id;
    private String exchange_time;
    private String time_in_micro;
    private String status;
    private boolean is_amo;
    private String valid_date;
    private String order_request_id;
    private String report;
    private String text;
    private String user_comment;
    private String trading_symbol;
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderModel(long orderNo, String client_id, String exchange, int token, String symbol, String product,
			String order_type, String duration, double price, double trigger_price, long quantity,
			long disclosed_quantity, String transaction_type, double average_price, double traded_quantity,
			String message, String exchange_order_id, String parent_order_id, String order_id, String exchange_time,
			String time_in_micro, String status, boolean is_amo, String valid_date, String order_request_id,
			String report, String text, String user_comment, String trading_symbol) {
		super();
		this.orderNo = orderNo;
		this.client_id = client_id;
		this.exchange = exchange;
		this.token = token;
		this.symbol = symbol;
		this.product = product;
		this.order_type = order_type;
		this.duration = duration;
		this.price = price;
		this.trigger_price = trigger_price;
		this.quantity = quantity;
		this.disclosed_quantity = disclosed_quantity;
		this.transaction_type = transaction_type;
		this.average_price = average_price;
		this.traded_quantity = traded_quantity;
		this.message = message;
		this.exchange_order_id = exchange_order_id;
		this.parent_order_id = parent_order_id;
		this.order_id = order_id;
		this.exchange_time = exchange_time;
		this.time_in_micro = time_in_micro;
		this.status = status;
		this.is_amo = is_amo;
		this.valid_date = valid_date;
		this.order_request_id = order_request_id;
		this.report = report;
		this.text = text;
		this.user_comment = user_comment;
		this.trading_symbol = trading_symbol;
	}
	public long getOrderId() {
		return orderNo;
	}
	public void setOrderId(long orderNo) {
		this.orderNo = orderNo;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTrigger_price() {
		return trigger_price;
	}
	public void setTrigger_price(double trigger_price) {
		this.trigger_price = trigger_price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getDisclosed_quantity() {
		return disclosed_quantity;
	}
	public void setDisclosed_quantity(long disclosed_quantity) {
		this.disclosed_quantity = disclosed_quantity;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getAverage_price() {
		return average_price;
	}
	public void setAverage_price(double average_price) {
		this.average_price = average_price;
	}
	public double getTraded_quantity() {
		return traded_quantity;
	}
	public void setTraded_quantity(double traded_quantity) {
		this.traded_quantity = traded_quantity;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExchange_order_id() {
		return exchange_order_id;
	}
	public void setExchange_order_id(String exchange_order_id) {
		this.exchange_order_id = exchange_order_id;
	}
	public String getParent_order_id() {
		return parent_order_id;
	}
	public void setParent_order_id(String parent_order_id) {
		this.parent_order_id = parent_order_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getExchange_time() {
		return exchange_time;
	}
	public void setExchange_time(String exchange_time) {
		this.exchange_time = exchange_time;
	}
	public String getTime_in_micro() {
		return time_in_micro;
	}
	public void setTime_in_micro(String time_in_micro) {
		this.time_in_micro = time_in_micro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isIs_amo() {
		return is_amo;
	}
	public void setIs_amo(boolean is_amo) {
		this.is_amo = is_amo;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	public String getOrder_request_id() {
		return order_request_id;
	}
	public void setOrder_request_id(String order_request_id) {
		this.order_request_id = order_request_id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	public String getTrading_symbol() {
		return trading_symbol;
	}
	public void setTrading_symbol(String trading_symbol) {
		this.trading_symbol = trading_symbol;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderNo + ", client_id=" + client_id + ", exchange=" + exchange + ", token="
				+ token + ", symbol=" + symbol + ", product=" + product + ", order_type=" + order_type + ", duration="
				+ duration + ", price=" + price + ", trigger_price=" + trigger_price + ", quantity=" + quantity
				+ ", disclosed_quantity=" + disclosed_quantity + ", transaction_type=" + transaction_type
				+ ", average_price=" + average_price + ", traded_quantity=" + traded_quantity + ", message=" + message
				+ ", exchange_order_id=" + exchange_order_id + ", parent_order_id=" + parent_order_id + ", order_id="
				+ order_id + ", exchange_time=" + exchange_time + ", time_in_micro=" + time_in_micro + ", status="
				+ status + ", is_amo=" + is_amo + ", valid_date=" + valid_date + ", order_request_id="
				+ order_request_id + ", report=" + report + ", text=" + text + ", user_comment=" + user_comment
				+ ", trading_symbol=" + trading_symbol + "]";
	}
    
    

}
