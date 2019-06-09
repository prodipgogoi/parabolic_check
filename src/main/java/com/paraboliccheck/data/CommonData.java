package com.paraboliccheck.data;

import java.util.ArrayList;
import java.util.List;

import com.paraboliccheck.entity.PriceFeedModel;
import com.paraboliccheck.model.FeedModel;

public class CommonData {
	public static List<FeedModel> fiveMinFeeds = new ArrayList<FeedModel>();

	public static List<FeedModel> thirtyMinFeeds = new ArrayList<FeedModel>();

	public static List<PriceFeedModel> fiveMinPriceFeeds = new ArrayList<PriceFeedModel>();

	public static List<PriceFeedModel> thirtyMinPriceFeeds = new ArrayList<PriceFeedModel>();
	
	public static void clearLists() {
		fiveMinFeeds.clear();
		thirtyMinFeeds.clear();
		fiveMinPriceFeeds.clear();
		thirtyMinPriceFeeds.clear();
	}
}
