package com.paraboliccheck.utils;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for JsonParser operations
 * 
 * @author kanhaiya.sahu
 *
 */
public class JsonParserUtil {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Convert JsonString to JSON Object of Type T by passing JsonStr and
	 * classOfT
	 * 
	 * @param json
	 * @param classOfT
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T getObjectByJsonStr(String json, Class<T> classOfT) throws JsonParseException, JsonMappingException, IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.readValue(json.trim(), (Class<T>) classOfT);
	}
	
	/**
	 * Convert JsonString to list of JSON Object of Type T by passing JsonStr and
	 * classOfT
	 * @param <T>
	 * 
	 * @param json
	 * @param classOfT
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> List<T> getObjectListByJsonStr(String json, Class<T> classOfT) throws JsonParseException, JsonMappingException, IOException {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.readValue(json.trim(), mapper.getTypeFactory().constructCollectionType(List.class, (Class<T>) classOfT));
	}


	/**
	 * Convert Object to JSON String
	 * 
	 * @param src
	 * @throws JsonProcessingException 
	 */
	public static String toJsonString(Object src) throws JsonProcessingException {
		 return mapper.writeValueAsString(src);
	}
}
