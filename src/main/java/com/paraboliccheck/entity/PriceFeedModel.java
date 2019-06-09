package com.paraboliccheck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "PriceFeed")
public class PriceFeedModel {
	
	
	@Id	
	private long timestamp;
	@Column(name="time")
	private String time;
	@Column(name="open")
	private double open;
	@Column(name="high")
	private double high;
	@Column(name="low")
	private double low;
	@Column(name="close")
	private double close;
	@Column(name="volume")
	private double volume;
	@Column(name="sar")
	private double sar;
	@Column(name="ep")
	private double ep;
	@Column(name="epsar")
	private double epsar;
	@Column(name="af")
	private double af;
	@Column(name="afdiff")
	private double afdiff;
	@Column(name="finalSignel")
	private String signal;
	@Column(name="minute")
	private int minute;
	
	public PriceFeedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PriceFeedModel(String time, long timestamp ,double open, double high, double low, double close, double volume, int minute) {
		super();
		this.time = time;
		this.timestamp=timestamp;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		
	}


	public PriceFeedModel(String time, double open, double high, double low, double close, double volume, double sar,
			double ep, double epsar, double af, double afdiff, String signal) {
		super();
		this.time = time;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.sar = sar;
		this.ep = ep;
		this.epsar = epsar;
		this.af = af;
		this.afdiff = afdiff;
		this.signal = signal;
		this.minute=minute;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSar() {
		return sar;
	}

	public void setSar(double sar) {
		this.sar = sar;
	}

	public double getEp() {
		return ep;
	}

	public void setEp(double ep) {
		this.ep = ep;
	}

	public double getEpsar() {
		return epsar;
	}

	public void setEpsar(double epsar) {
		this.epsar = epsar;
	}

	public double getAf() {
		return af;
	}

	public void setAf(double af) {
		this.af = af;
	}

	public double getAfdiff() {
		return afdiff;
	}

	public void setAfdiff(double afdiff) {
		this.afdiff = afdiff;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}	
	

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "PriceFeedModel [time=" + time + ", timestamp=" + timestamp + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", volume=" + volume + ", sar=" + sar + ", ep=" + ep
				+ ", epsar=" + epsar + ", af=" + af + ", afdiff=" + afdiff + ", signal=" + signal + "]";
	}
}
