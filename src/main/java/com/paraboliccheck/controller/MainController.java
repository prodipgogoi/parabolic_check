package com.paraboliccheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.paraboliccheck.data.CommonData;
import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.model.CompareModel;
import com.paraboliccheck.model.FeedModel;
import com.paraboliccheck.service.MainService;


@RestController
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/test")
	public List<PriceFeedModel> test(){
		return mainService.test();
	}
	
	@PostMapping(value = "/uploaddocument")
	public List<PriceFeedModel> uploadDocument(@RequestParam("document") MultipartFile file,
			@RequestParam(value = "minAF", required = true) double minAF,
			@RequestParam(value = "maxAF", required = true) double maxAF,
			@RequestParam(value = "dacc", required = true) double dacc) {
		return mainService.saveDocument(file, minAF, maxAF, dacc);
	}
	
	
	@PostMapping(value = "/compare")
	public List<CompareModel> compareDocument(@RequestParam("document") MultipartFile file,@RequestParam("documentT") MultipartFile tfile,
			@RequestParam(value = "minAFV", required = true) double minAF,
			@RequestParam(value = "maxAFV", required = true) double maxAF,
			@RequestParam(value = "minAFTh", required = true) double tminAF,
			@RequestParam(value = "maxAFTh", required = true) double tmaxAF) {
		return mainService.compareData(file, minAF, maxAF, tfile, tminAF, tmaxAF);
	}
	
	@GetMapping("/five-min-data")
	public List<PriceFeedModel> getFiveMinData(){
		return CommonData.fiveMinPriceFeeds;
	}
	
	@GetMapping("/thirty-min-data")
	public List<PriceFeedModel> getThirtyMinData(){
		return CommonData.thirtyMinPriceFeeds;
	}
	
	
	@GetMapping("/feed")
	public List<FeedModel> getFeeds(){
		return mainService.getFeeds();
	}
}
