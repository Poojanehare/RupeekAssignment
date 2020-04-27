package com.apiTesting.commonlib;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;

import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author Pooja Nehare
 *
 */
public class BasicLib {

	/**
	 * To initialize the base URI,port and authentication
	 */
	@BeforeSuite
	public void config()
	{
     baseURI = "http://13.126.80.194";
	 port=8080;
	 
	 
	}
}
