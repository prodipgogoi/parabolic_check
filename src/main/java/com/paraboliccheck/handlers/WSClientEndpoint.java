/*
 * This is sample application which is created to show, How Websocket API of
 * Global Datafeeds can be consumed using JAVA. In this sample .jar files used
 * are given in the below list
 *  1. javax.json-1.1.2.jar
 *  2. javax.json-api-1.1.2.jar
 *  3. javax.websocket-api-1.1.jar
 *  4. javax.websocket-api-1.1-sources.jar
 *  5. tyrus-standalone-client-1.9.jar
 */
package com.paraboliccheck.handlers;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.paraboliccheck.model.ResponseModel;
import com.paraboliccheck.service.DataFeedService;
import com.paraboliccheck.utils.JsonParserUtil;
/**
 * @author GFDL-Development
 */
@ClientEndpoint
public class WSClientEndpoint {
    Session userSession = null;
    boolean APIConnection = false;
    
    @Autowired
    private DataFeedService dataFeedService;
    
    public WSClientEndpoint(URI endpointURI){
        try
        {
            WebSocketContainer container = ContainerProvider
                    .getWebSocketContainer();
            container.connectToServer(this, endpointURI);
            container.setDefaultMaxBinaryMessageBufferSize(420000);
            container.setDefaultMaxTextMessageBufferSize(300000);           
            container.setDefaultMaxSessionIdleTimeout(3600);
            System.out.println(container.getDefaultMaxSessionIdleTimeout());
        }
        catch(IOException | DeploymentException Ex)
        {
            throw new RuntimeException(Ex);
        }
    }
    
    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
    }
    
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        this.userSession = null;
        System.out.println(reason);
    }
    
    @OnMessage
    public void onMessage(String message) {
        if (message != null)
        {
            if(message.contains("\"Complete\":true") || message.contains("\"AllowVMRunning\":false") ||  message.contains("\"AllowServerOSRunning\":false"))
            {
                APIConnection = true;
                System.out.println("Authentication Complete!");            
            }
            else
            {
            	System.out.println("messsage");
                System.out.println(message);   
                try {
                	ResponseModel response = JsonParserUtil.getObjectByJsonStr(message, ResponseModel.class);
                	if(response!=null &&response.getResult()!=null && response.getResult().size()>0) {
                		System.out.println("get result");
                		System.out.println(response.getResult().size());
                		System.out.println(response.getResult().get(1).getLastTradeTime());
                		//dataFeedService.saveDataFeed(response.getResult(), response.getRequest().getPeriod());
                	}
                	
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
            }
        }
    }
    
    public void sendMessage(String message) {
        System.out.println(message);
        this.userSession.getAsyncRemote().sendText(message);
    }
    
    public static interface MessageHandler {
        public void handleMessage(String message);
    }
}
