package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
public void test1() {
		
		String BaseURI = "http://localhost:3000/employees";

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("7");
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
	}


}
