package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class test_1 {/*
@Test
	public void test1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("body"+response.getBody());
		System.out.println("Type"+response.getHeader("content-type"));
    	int time = response.getStatusCode();
		System.out.println(time);
		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusCode());
         Assert.assertEquals(time, 200);

	}*/

	//@Test
	public void test2() {
		baseURI = "https://reqres.in/api"; 
		given().
		get("/unknown").
		then().
		statusCode(200).body("support.url", equalTo("https://reqres.in/#support-heading")).log().all();
	}

	//@Test
	public void test_Get() {
		baseURI="https://reqres.in/api";

		given().
		get("/unknown").
		then().
		body("data[3].year", equalTo(2003)).
		body("data.year",hasItems(2001,2002,2003));

	}
	@Test
	public void test_post() {

		Map<String, Object> map = new HashMap<String, Object>();
		/*	map.put("name", "Hussam");
		map.put("Age", "25 years");
		map.put("Address", "Cairo,Egypt");
		 */
		//	System.out.println(map);

		JSONObject req = new JSONObject(map);
		req.put("name", "Hussam");
		req.put("Age", "25 years");
		req.put("Address", "Cairo,Egypt");
		req.put("id", 320);
		 System.out.println(req.toString());
		 
			baseURI="https://reqres.in/api";
           
		 given().
			 header("content-type","application/json").
		//	contentType(ContentType.JSON).
		//	accept(ContentType.JSON).
			  body(req.toJSONString()).
		  when().
			 post("/unknown").
		  then(). 
			 statusCode(201).
			 log().all();
			
	}

}
