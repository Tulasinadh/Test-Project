package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
	@Test
	public void test1() {
		String BaseURL="http://localhost:3000/employees";
		
		RestAssured.baseURI=BaseURL;
		RequestSpecification  request= RestAssured.given();
		
		Response response = request.get("1");
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
	}

}
