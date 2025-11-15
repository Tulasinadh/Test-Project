package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateToken {
	
public static String Token;

	@Test
	public static void Create() {
		
		String BaseURI = "http://localhost:8088/oauth/token";

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();
		
		Response response = request.auth()
								.basic("rest-assured", "password")
								.contentType("application/x-www-form-urlencoded")
								.formParam("grant_type", "password")
								.formParam("username", "onlyfullstack")
								.formParam("password", "secret")
								.post();
		
		JsonPath jpath = response.jsonPath();
		Token = jpath.get("access_token");
		System.out.println(Token);
		
	}


}
