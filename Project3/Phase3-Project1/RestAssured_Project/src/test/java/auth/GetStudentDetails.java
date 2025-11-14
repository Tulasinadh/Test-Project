package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStudentDetails {
	
	@Test
public void test1() {
		
		GenerateToken.Create();
		String access_token = GenerateToken.Token;
		
		System.out.println("Token value is " + access_token);
		
		String BaseURI = "http://localhost:8088/students/2";
		
		RestAssured.baseURI = BaseURI;
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth()
									.oauth2(access_token)
									.get();
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
}
}
