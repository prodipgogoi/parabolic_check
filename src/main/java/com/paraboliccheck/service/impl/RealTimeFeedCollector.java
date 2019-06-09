package com.paraboliccheck.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.paraboliccheck.model.FeedModel;
import com.paraboliccheck.model.OhlcModel;
import com.paraboliccheck.utils.JsonParserUtil;



@Component
public class RealTimeFeedCollector {
	
	private String apiKey ="UfyLo47QaCaZQ78g4bjH8JjOVtggMSe6yhNPSCU2";
	private String apiSecret = "nikw6hjup3";
	private String token="d673330d48f043ae0c5152c82301d00b5db97959";

	
	public List<FeedModel> getFeeds(String exchange, String symbol, String interval, String startDate, String endDate){
		OhlcModel ohlc=SendMultipartFile(exchange, symbol, interval, startDate, endDate);
		return ohlc.getData();
	}
	
	
	public OhlcModel SendMultipartFile(String exchange, String symbol, String interval, String startDate, String endDate) {

		String endPoint="https://api.upstox.com/historical/"+exchange+"/"+symbol+"/"+interval+"?start_date="+startDate+"&end_date="+endDate;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.set("x-api-key", apiKey);
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(endPoint, HttpMethod.GET, requestEntity, String.class);
		OhlcModel resp = null;
		try {
			resp = JsonParserUtil.getObjectByJsonStr(response.getBody(), OhlcModel.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}


}
