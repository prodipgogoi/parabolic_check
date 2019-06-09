package com.paraboliccheck.service;

import java.util.List;

import com.paraboliccheck.model.FeedModel;

public interface DataCollectorService {
	
	FeedModel getCurrentFeeds(String symbol, String period);

}
