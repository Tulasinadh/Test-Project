package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://api.github.com/repos/Tulasinadh/Rest_Repo";
		
		RequestSpecification  request = RestAssured.given();
		String Accesstoken ="";// Need to add access token from github
		
		Response response = request.auth().oauth2(Accesstoken)
							.delete();
		
		System.out.println("The Response body is " + response.body().asString());
	}

}
