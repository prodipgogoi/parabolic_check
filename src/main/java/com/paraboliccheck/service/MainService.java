package com.paraboliccheck.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.model.CompareModel;
import com.paraboliccheck.model.FeedModel;

public interface MainService {

	List<PriceFeedModel> test();

	List<PriceFeedModel> saveDocument(MultipartFile file, double minAF, double maxAF, double dacc);
	
	List<CompareModel> compareData(MultipartFile file, double minAF, double maxAF, MultipartFile tfile, double tminAF, double tmaxAF);

	List<FeedModel> getFeeds();

}
