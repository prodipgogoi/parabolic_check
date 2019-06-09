package com.paraboliccheck.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.model.CompareModel;
import com.paraboliccheck.model.FeedModel;
import com.paraboliccheck.service.MainService;



@Service
public class MainServiceImpl implements MainService {

	
	@Autowired
	private ParabolicCalculator parabolicCalculator;
	
	@Autowired
	private Comparator comparator;
	
	@Autowired
	private RealTimeFeedCollector feedCollector;
	
	@Override
	public List<PriceFeedModel> test() {
		// TODO Auto-generated method stub
		return parabolicCalculator.testTheCalculation();
	}

	@Override
	public List<PriceFeedModel> saveDocument(MultipartFile file, double minAF, double maxAF, double dacc) {
		// TODO Auto-generated method stub
		return parabolicCalculator.readCSV(file, minAF, maxAF, dacc);
	}

	@Override
	public List<CompareModel> compareData(MultipartFile fileFive, double minAfFive, double maxAfFive, MultipartFile fileThirty,
			double minAfThirty, double maxAfThirty) {
		// TODO Auto-generated method stub
		return comparator.compareTheResult(fileFive, minAfFive, maxAfFive, fileThirty, minAfThirty, maxAfThirty);
	}

	@Override
	public List<FeedModel> getFeeds() {
		// TODO Auto-generated method stub
		return feedCollector.getFeeds("NSE_EQ", "RELIANCE", "5", "27-05-2019", "28-05-2019");
	}
	
	

	
	
}
