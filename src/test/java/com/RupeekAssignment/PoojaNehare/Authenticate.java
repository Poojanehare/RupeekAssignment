package com.RupeekAssignment.PoojaNehare;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.apiTesting.commonlib.BasicLib;
import com.apiTesting.commonlib.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Authenticate extends BasicLib {
	String token;
	JSONObject requestparamas = new JSONObject();

	@BeforeMethod
	public void getTokenTest() {

		requestparamas.put("username", "rupeek");
		requestparamas.put("password", "password");

		// Authenticate user and get token
		Response response = given().contentType(ContentType.JSON).and().body(requestparamas.toString())
				.post(EndPoints.GET_TOKEN);
		token = response.path("token");
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void getallUsersTest1() {
		Response users = given().auth().oauth2(token).get(EndPoints.GET_ALL_CUSTOMERS);
		Assert.assertEquals(users.getStatusCode(), 200);
	}

	@Test
	public void getOneUserTest() {
		String phone = (String) requestparamas.get("phone");
		String getuser = EndPoints.GET_USER_PHONENO + phone;
		Response getsingleuser = given().auth().oauth2(token).get(getuser);
		Assert.assertEquals(getsingleuser.getStatusCode(), 200);

	}

}
