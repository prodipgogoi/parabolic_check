package com.paraboliccheck.service;

import java.util.List;

import com.paraboliccheck.model.FeedModel;

public interface DataFeedService {
	
	void saveDataFeed(FeedModel feed, int period);

}
