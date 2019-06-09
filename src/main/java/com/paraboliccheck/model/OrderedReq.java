package com.paraboliccheck.model;

public class OrderedReq {

	private String transaction_type;
    private String exchange;
    private String symbol;
    private int quantity;
    private String order_type;
    private String product;
	public OrderedReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderedReq(String transaction_type, String exchange, String symbol, int quantity, String order_type,
			String product) {
		super();
		this.transaction_type = transaction_type;
		this.exchange = exchange;
		this.symbol = symbol;
		this.quantity = quantity;
		this.order_type = order_type;
		this.product = product;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderedReq [transaction_type=" + transaction_type + ", exchange=" + exchange + ", symbol=" + symbol
				+ ", quantity=" + quantity + ", order_type=" + order_type + ", product=" + product + "]";
	}
}
