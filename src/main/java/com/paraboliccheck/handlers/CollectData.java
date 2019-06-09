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

import java.net.URI;
import java.time.Instant;

import javax.json.Json;

import org.springframework.stereotype.Component;



/**
 * @author GFDL-Development
 */



public class CollectData {
	public static String EndPoint = "ws://nimblestream.lisuns.com:4526";
    public static String AccessKey = "5b928cd2-2d21-416a-b8e3-705745f58eea";
    
    public static void main(String[] args) throws Exception {
        
        

        /* This is list of function which are available in Websocket API */        
        //String functionName = "SubscribeSnapshot";
        //String functionName = "SubscribeRealtime";
        //String functionName = "GetServerInfo";
        //String functionName = "GetLimitation";
        //String functionName = "GetFundamentalData";
        //String functionName = "GetFundamentalSupportedIndicators";
        //String functionName = "GetFundamentalIndicators";
        //String functionName = "GetFundamentalInstruments";        
        //String functionName = "GetSnapshot";
        //String functionName = "GetLastQuote";
        //String functionName = "GetLastQuoteArray";
        //String functionName = "GetMarketMessages";
        //String functionName = "GetExchangeMessages";
        //String functionName = "GetStrikePrices";
        //String functionName = "GetOptionTypes";
        //String functionName = "GetExpiryDates";
        //String functionName = "GetProducts";
        //String functionName = "GetInstrumentTypes";
        //String functionName = "GetInstruments";
        //String functionName = "GetExchanges";
        String functionName = "GetHistory";
        //String functionName = "GetInstrumentsOnSearch";
    
        final WSClientEndpoint clientEndPoint;
        clientEndPoint = new WSClientEndpoint(new URI(EndPoint));
        
        //Here user is Authenticated using "getAuthenticate" function
        clientEndPoint.sendMessage(getAuthenticate("Authenticate",AccessKey));
        Thread.sleep(5000);
        
        
        if(clientEndPoint.APIConnection)
        {
            switch (functionName) {
                case "GetExchanges":
                    clientEndPoint.sendMessage(GetExchanges("GetExchanges"));
                    Thread.sleep(5000);
                    break;
                case "GetServerInfo":
                    clientEndPoint.sendMessage(GetServerInfo("GetServerInfo"));
                    Thread.sleep(5000);
                    break;
                case "GetLimitation":
                    clientEndPoint.sendMessage(GetLimitation("GetLimitation"));
                    Thread.sleep(5000);
                    break;
                case "SubscribeRealtime":
                    clientEndPoint.sendMessage(SubscribeRealtime("SubscribeRealtime","MCX","FUTCOM_GOLD_05JUN2018__0"));
                    Thread.sleep(30000);
                    break;
                case "SubscribeSnapshot":
                    clientEndPoint.sendMessage(SubscribeSnapshot("SubscribeSnapshot","MCX","FUTCOM_GOLD_05JUN2018__0","MINUTE","false"));
                    Thread.sleep(120000);
                    break;
                case "GetFundamentalData":
                    clientEndPoint.sendMessage(GetFundamentalData("GetFundamentalData","GPPL","GPPL","A"));
                    Thread.sleep(30000);
                    break;
                case "GetFundamentalSupportedIndicators":
                    clientEndPoint.sendMessage(GetFundamentalSupportedIndicators("GetFundamentalSupportedIndicators","GPPL"));
                    Thread.sleep(30000);
                    break;
                case "GetFundamentalIndicators":
                    clientEndPoint.sendMessage(GetFundamentalIndicators("GetFundamentalIndicators"));
                    Thread.sleep(30000);
                    break;
                case "GetFundamentalInstruments":
                    clientEndPoint.sendMessage(GetFundamentalInstruments("GetFundamentalInstruments"));
                    Thread.sleep(30000);
                    break;
                case "GetSnapshot":
                    clientEndPoint.sendMessage(GetSnapshot("SubscribeSnapshot","MCX","CRUDEOIL19JUNFUT","MINUTE",1));
                    Thread.sleep(120000);
                    break;
                case "GetLastQuote":
                    clientEndPoint.sendMessage(GetLastQuote("GetLastQuote","MCX","FUTCOM_GOLD_05JUN2018__0"));
                    Thread.sleep(10000);
                    break;
                case "GetLastQuoteArray":
                    clientEndPoint.sendMessage(GetLastQuoteArray("GetLastQuoteArray","MCX"));
                    Thread.sleep(10000);
                    break;
                case "GetMarketMessages":
                    clientEndPoint.sendMessage(GetMarketMessages("GetMarketMessages"));
                    Thread.sleep(10000);
                    break;
                case "GetExchangeMessages":
                    clientEndPoint.sendMessage(GetExchangeMessages("GetExchangeMessages"));
                    Thread.sleep(10000);
                    break;
                case "GetStrikePrices":
                    clientEndPoint.sendMessage(GetStrikePrices("GetStrikePrices","MCX"));
                    Thread.sleep(10000);
                    break;
                case "GetOptionTypes":
                    clientEndPoint.sendMessage(GetOptionTypes("GetOptionTypes","MCX"));
                    Thread.sleep(10000);
                    break;
                case "GetExpiryDates":
                    clientEndPoint.sendMessage(GetExpiryDates("GetExpiryDates","NFO"));
                    Thread.sleep(10000);
                    break;
                case "GetProducts":
                    clientEndPoint.sendMessage(GetProducts("GetProducts","MCX"));
                    Thread.sleep(10000);
                    break;
                case "GetInstrumentTypes":
                    clientEndPoint.sendMessage(GetInstrumentTypes("GetInstrumentTypes","NFO"));
                    Thread.sleep(10000);
                    break;
                case "GetInstruments":
                    clientEndPoint.sendMessage(GetInstruments("GetInstruments","MCX"));
                    Thread.sleep(10000);
                    break;
                case "GetHistory":
                	
                    clientEndPoint.sendMessage(GetHistory("GetHistory","MCX","CRUDEOIL19JUNFUT","MINUTE",5,0));
                    Thread.sleep(10000);                
        		    
                    break;
                case "GetInstrumentsOnSearch":
                    clientEndPoint.sendMessage(GetInstrumentsOnSearch("GetInstrumentsOnSearch","NSE","TATA"));
                    Thread.sleep(10000);
                    break;
                default:
                    break;
            }
        }
        else
        {
            System.out.println("Connection Failed. Try again...");
        }
     }
    
    public static String getAuthenticate(String msgType, String message) {
        return Json.createObjectBuilder().add("MessageType", msgType).add("Password", message).build().toString();
    }
    
    private static String GetExchanges(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType).build().toString();
    }
    
    private static String GetServerInfo(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType).build().toString();
    }
    
    private static String GetLimitation(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType).build().toString();
    }
    
    private static String SubscribeSnapshot(String msgType,
            String ExchangeName,
            String InstIdentifier,
            String Periodicity,
            String Unsubscribe) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", InstIdentifier)
                .add("Periodicity", Periodicity)
                .add("Unsubscribe", Unsubscribe)
                .build().toString();
    }
    
    private static String SubscribeRealtime(String msgType,
            String ExchangeName,
            String InstIdentifier) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", InstIdentifier)
                .build().toString();
    }
    
    private static String GetFundamentalData(String msgType,
            String Instrument,
            String IndicatorCode,
            String FrequrencyCode) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Instrument", Instrument)
                .add("IndicatorCode", IndicatorCode)
                .add("FrequrencyCode", FrequrencyCode)
                .build().toString();
    }
    
    private static String GetFundamentalSupportedIndicators(String msgType,
            String Instrument) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Instrument", Instrument)
                .build().toString();
    }
    
    private static String GetFundamentalIndicators(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType).build().toString();
    }
    
    private static String GetFundamentalInstruments(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType).build().toString();
    }
    
    private static String GetSnapshot(String msgType,
            String ExchangeName,
            String InstIdentifier,
            String Periodicity,
            int Period) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", InstIdentifier)
                .add("Periodicity", Periodicity)
                .add("Period", Period)
                .build().toString();
    }
    
    private static String GetLastQuote(String msgType,
            String ExchangeName,
            String InstIdentifier) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", InstIdentifier)
                .build().toString();
    }
    
    private static String GetLastQuoteArray(String msgType,
            String ExchangeName) {
        String lstInst = "{\"Value\":\"FUTCOM_GOLD_05JUN2018__0\"},{\"Value\":\"FUTCOM_CRUDEOIL_21MAY2018__0\"}";
        String strreq = "{\"MessageType\":\"GetLastQuoteArray\",\"Exchange\":\"" + ExchangeName + "\",\"InstrumentIdentifiers\":[" + lstInst + "]}";
        /*return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", "[" + lstInst + "]")
                .build().toString();*/
        return strreq;
    }
    
    private static String GetMarketMessages(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .build().toString();
    }
    
    private static String GetExchangeMessages(String msgType) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .build().toString();
    }
    
    private static String GetStrikePrices(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetOptionTypes(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetExpiryDates(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetProducts(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetInstrumentTypes(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetInstruments(String msgType,String ExchangeName) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .build().toString();
    }
    
    private static String GetHistory(String msgType,
            String ExchangeName,
            String InstIdentifier,
            String Periodicity,
            int Period,
            int Max) {
    	
    	Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		
		
		System.out.println(timeStampSeconds);
		
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("InstrumentIdentifier", InstIdentifier)
                .add("Periodicity", Periodicity)
                .add("isShortIdentifier", true)
                .add("Period", Period)
                .add("From", (timeStampSeconds-3600))
                .add("To", timeStampSeconds)
                .add("Max", Max)
                .build().toString();
    }
    
    private static String GetInstrumentsOnSearch(String msgType,
            String ExchangeName,
            String Search) {
        return Json.createObjectBuilder().add("MessageType", msgType)
                .add("Exchange", ExchangeName)
                .add("Search", Search)
                .build().toString();
    }
}
