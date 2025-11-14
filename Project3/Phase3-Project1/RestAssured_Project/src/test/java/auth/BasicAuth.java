package auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {
	
    @Test
	public void test1() {

		String BaseURI = "http://httpbin.org";

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();

		Response response = request.auth()
								.basic("user", "passwd")
								.get("basic-auth/user/passwd");

		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);

	}

}
