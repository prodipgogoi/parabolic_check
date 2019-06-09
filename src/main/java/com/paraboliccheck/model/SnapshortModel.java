package com.paraboliccheck.model;

public class SnapshortModel {
	private double CLOSE;
    private String EXCHANGE;
    private double HIGH;
    private String INSTRUMENTIDENTIFIER;
    private double TRADEDQTY;
    private long LASTTRADETIME;
    private double LOW;
    private double OPEN;
    private double OPENINTEREST;
    
	public SnapshortModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SnapshortModel(double cLOSE, String eXCHANGE, double hIGH, String iNSTRUMENTIDENTIFIER, double tRADEDQTY,
			long lASTTRADETIME, double lOW, double oPEN, double oPENINTEREST) {
		super();
		CLOSE = cLOSE;
		EXCHANGE = eXCHANGE;
		HIGH = hIGH;
		INSTRUMENTIDENTIFIER = iNSTRUMENTIDENTIFIER;
		TRADEDQTY = tRADEDQTY;
		LASTTRADETIME = lASTTRADETIME;
		LOW = lOW;
		OPEN = oPEN;
		OPENINTEREST = oPENINTEREST;
	}
	
	public double getCLOSE() {
		return CLOSE;
	}
	public void setCLOSE(double cLOSE) {
		CLOSE = cLOSE;
	}
	public String getEXCHANGE() {
		return EXCHANGE;
	}
	public void setEXCHANGE(String eXCHANGE) {
		EXCHANGE = eXCHANGE;
	}
	public double getHIGH() {
		return HIGH;
	}
	public void setHIGH(double hIGH) {
		HIGH = hIGH;
	}
	public String getINSTRUMENTIDENTIFIER() {
		return INSTRUMENTIDENTIFIER;
	}
	public void setINSTRUMENTIDENTIFIER(String iNSTRUMENTIDENTIFIER) {
		INSTRUMENTIDENTIFIER = iNSTRUMENTIDENTIFIER;
	}
	public double getTRADEDQTY() {
		return TRADEDQTY;
	}
	public void setTRADEDQTY(double tRADEDQTY) {
		TRADEDQTY = tRADEDQTY;
	}
	public long getLASTTRADETIME() {
		return LASTTRADETIME;
	}
	public void setLASTTRADETIME(long lASTTRADETIME) {
		LASTTRADETIME = lASTTRADETIME;
	}
	public double getLOW() {
		return LOW;
	}
	public void setLOW(double lOW) {
		LOW = lOW;
	}
	public double getOPEN() {
		return OPEN;
	}
	public void setOPEN(double oPEN) {
		OPEN = oPEN;
	}
	public double getOPENINTEREST() {
		return OPENINTEREST;
	}
	public void setOPENINTEREST(double oPENINTEREST) {
		OPENINTEREST = oPENINTEREST;
	}
	@Override
	public String toString() {
		return "SnapshortModel [CLOSE=" + CLOSE + ", EXCHANGE=" + EXCHANGE + ", HIGH=" + HIGH
				+ ", INSTRUMENTIDENTIFIER=" + INSTRUMENTIDENTIFIER + ", TRADEDQTY=" + TRADEDQTY + ", LASTTRADETIME="
				+ LASTTRADETIME + ", LOW=" + LOW + ", OPEN=" + OPEN + ", OPENINTEREST=" + OPENINTEREST + "]";
	}
    
    
}
