package com.paraboliccheck.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.model.CompareModel;



@Component
public class Comparator {
	
	
	@Autowired
	private ParabolicCalculator parabolicCalculator;
	
	String lastOrderType="BUY";
	
	public List<CompareModel> compareTheResult(MultipartFile fileFive, double minAfFive, double maxAfFive, MultipartFile fileThirty, double minAfThirty, double maxAfThirty){
		List<PriceFeedModel> fiveMinPrices = parabolicCalculator.readCSV(fileFive, minAfFive, maxAfFive, 0.01);
		List<PriceFeedModel> thertyMinPrices = parabolicCalculator.readCSV(fileThirty, minAfThirty, maxAfThirty, 0.1);
		List<CompareModel> compModel=new ArrayList<CompareModel>();
		boolean isOpen=false;
		
		fiveMinPrices.forEach(p->{			
			final String thirtyMin=getThirtyMinString(p.getTime());
			List<PriceFeedModel> thirtyList=thertyMinPrices.stream().filter(q->q.getTime().equals(thirtyMin)).collect(Collectors.toList());
			if(thirtyList != null && !thirtyList.isEmpty()) {
				PriceFeedModel t=thirtyList.get(0);
				if(p.getSignal()!=null && t.getSignal()!=null) {
					if(t.getSignal().equals(p.getSignal()) && !t.getSignal().equals(lastOrderType)) {
						compModel.add(new CompareModel(p.getTime(), p.getOpen(), p.getHigh(), p.getLow(), p.getClose(), p.getVolume(), p.getSar(), p.getEp(), p.getEpsar(), p.getAf(), p.getAfdiff(), p.getSignal(), t.getTime(), t.getOpen(), t.getHigh(), t.getLow(), t.getClose(), t.getVolume(), t.getSar(), t.getEp(), t.getEpsar(), t.getAf(), t.getAfdiff(), t.getSignal(),"Entry, Exit"));
						lastOrderType=t.getSignal();
					}else {
						compModel.add(new CompareModel(p.getTime(), p.getOpen(), p.getHigh(), p.getLow(), p.getClose(), p.getVolume(), p.getSar(), p.getEp(), p.getEpsar(), p.getAf(), p.getAfdiff(), p.getSignal(), t.getTime(), t.getOpen(), t.getHigh(), t.getLow(), t.getClose(), t.getVolume(), t.getSar(), t.getEp(), t.getEpsar(), t.getAf(), t.getAfdiff(), t.getSignal()));
					}
				}
			}
			
		});
		
		return compModel;
		
	}
	
	private String getThirtyMinString(String fiveMinString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");		
		Date date=null;
		String thirtyMin="";
		try {
			date = formatter.parse(fiveMinString);
			 System.out.println(date);
				int min=date.getMinutes();				
				if(min>=30) {
					thirtyMin=fiveMinString.substring(0, fiveMinString.length()-3)+":30";
				}else {
					thirtyMin=fiveMinString.substring(0, fiveMinString.length()-3)+":00";
				}				
				System.out.println(thirtyMin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return thirtyMin;
	}

}
