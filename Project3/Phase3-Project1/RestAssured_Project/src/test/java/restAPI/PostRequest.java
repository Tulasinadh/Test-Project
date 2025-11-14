package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test

	public void test1() {

		String BaseURI = "http://localhost:3000/employees";
		
		Map<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", ContentType.JSON);
		headers.put("Accept", ContentType.JSON);
		
		String Body = "{\r\n"
				+ "    \"name\": \"Aman\",\r\n"
				+ "    \"salary\": \"9000\",\r\n"
				+ "    \"id\": \"6\"\r\n"
				+ "}";

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();
		
		Response response = request.headers(headers)
									.body(Body)
									.post();
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),201);
		
	}	
}