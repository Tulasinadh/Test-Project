package auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllRepo {
	
@Test
	public void test1() {
		
		String BaseURL="https://api.github.com";	 
		RestAssured.baseURI=BaseURL;
		RequestSpecification request = RestAssured.given();
		String Accesstoken="";// need to add access token from github
		Response response= request.auth().oauth2(Accesstoken).get("users/Tulasinadh/repos");
		
		String Responsebody=response.body().asString();
		System.out.println(Responsebody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);
		
	}
}