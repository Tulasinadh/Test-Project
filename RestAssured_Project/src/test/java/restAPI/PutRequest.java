package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
public void test1() {
		
		String BaseURI = "http://localhost:3000/employees";
		
		Map<String, Object> Headers = new HashMap<>();
		Headers.put("Content-Type", ContentType.JSON);
		Headers.put("Accept", ContentType.JSON);
		
		Map<String,String> Body = new HashMap<>();
		Body.put("name", "Ganesh Volley");
		Body.put("salary", "28500");
		Body.put("id", "7");
		

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();
		
		Response response = request.headers(Headers)
									.body(Body)
									.put("7");
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);
			
		}


}
