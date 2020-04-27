package com.apiTesting.parsing;

import java.util.List;

import io.restassured.response.Response;

/**
 * 
 * @author PoojaNehare
 *
 */
public class JsonClass {
	
	/**
	 * getjsonstring returns the json value from the specified jsonpath
	 * 
	 * @param response
	 * @param key
	 * @return
	 */
	public static String getjsonString(Response response, String jsonpath) {
		return response.getBody().jsonPath().getString(jsonpath).toString();
	}

	/**
	 * getJsonList method returns the value of json array from jsonpath
	 * 
	 * @param response
	 * @param key
	 * @param index
	 * @return
	 */

	public static List<String> getJsonList(Response response, String jsonpath) {
		return response.getBody().jsonPath().getList(jsonpath);

	}

}
