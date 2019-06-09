package com.paraboliccheck.handlers;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.paraboliccheck.model.OrderRes;
import com.paraboliccheck.model.OrderedReq;
import com.paraboliccheck.model.SnapshortModel;
import com.paraboliccheck.utils.JsonParserUtil;


@Component
public class RestHandlers {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public SnapshortModel getSnapShort(int period, String symbol) {
		SnapshortModel model=null;
		List<SnapshortModel> models = sendRequest(period, symbol);
		if(models==null || models.isEmpty() || models.size()==0) {
			models = sendRequest(period, symbol);
		}
		if(models != null && !models.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			model = models.get(0);
		}
		return model;
	}
	
	
	private List<SnapshortModel> sendRequest(int period, String symbol) {
		
		String url="http://nimblerest.lisuns.com:4531/GetSnapshot/?accessKey=5b928cd2-2d21-416a-b8e3-705745f58eea&xml=false&exchange=MCX&instrumentIdentifiers="+symbol+"&periodicity=MINUTE&period="+period;
		
		List<SnapshortModel> model=null;
		
		String message = "";
		
		message = restTemplate.getForObject(url, String.class);
		System.out.println(message);
		
		try {
			model = JsonParserUtil.getObjectListByJsonStr(message, SnapshortModel.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			// throw e;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			// throw e;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// throw e;
			e.printStackTrace();
		}
		return model;
	}
	
	
	public OrderRes placeOrder(OrderedReq orderReq) {
		String entityResponse = null;
		String endPoint="https://api.upstox.com/live/orders";
		OrderRes orderRes=null;
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("authorization", "Bearer a1d8dfb91d3d62d3ebe6988bc886f6866631ae5b");
			httpHeaders.set("x-api-key", "UfyLo47QaCaZQ78g4bjH8JjOVtggMSe6yhNPSCU2");
			httpHeaders.set("Content-Type", "application/json");

			HttpEntity<Object> httpEntity = new HttpEntity<Object>(orderReq, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(endPoint, httpEntity, String.class);
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				entityResponse = responseEntity.getBody();
				orderRes=JsonParserUtil.getObjectByJsonStr(entityResponse, OrderRes.class);
				System.out.println(entityResponse);
			}
		} catch (HttpStatusCodeException exception) {
			// LOGGER.error(Constants.ERROR_MESSAGE_TEXT + "Error found in
			// responseEntity.getStatusCode() !!!");
		} catch (com.fasterxml.jackson.core.JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderRes;
	}
	
	
	public String sendMessage(Object message, String endPoint, String accessKey) {
		String entityResponse = null;
		RestTemplate restTemplate = new RestTemplate();

		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("WEB2PY-USER-TOKEN", accessKey);
			httpHeaders.set("Content-Type", "application/json");

			HttpEntity<Object> httpEntity = new HttpEntity<Object>(message, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(endPoint, httpEntity, String.class);
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				entityResponse = responseEntity.getBody();
			}
		} catch (HttpStatusCodeException exception) {
			// LOGGER.error(Constants.ERROR_MESSAGE_TEXT + "Error found in
			// responseEntity.getStatusCode() !!!");
		}
		return entityResponse;
	}
}
