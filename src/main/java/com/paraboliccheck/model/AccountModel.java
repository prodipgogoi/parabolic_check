package com.paraboliccheck.model;

import java.util.Date;

public class AccountModel {
	
	private long accountId;
	private String accountName;
	private String address;
	private String phoneNo;
	private double balance;
	private double lastBalance;
	private Date createDate;
	private Date modifiedDate;
	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountModel(long accountId, String accountName, String address, String phoneNo, double balance,
			double lastBalance, Date createDate, Date modifiedDate) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.balance = balance;
		this.lastBalance = lastBalance;
		this.createDate = createDate;
		modifiedDate = modifiedDate;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getLastBalance() {
		return lastBalance;
	}
	public void setLastBalance(double lastBalance) {
		this.lastBalance = lastBalance;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "AccountModel [accountId=" + accountId + ", accountName=" + accountName + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", balance=" + balance + ", lastBalance=" + lastBalance + ", createDate="
				+ createDate + ", ModifiedDate=" + modifiedDate + "]";
	}
	
	

}
