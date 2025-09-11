package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonFile {
	
	@Test
public void test1() throws IOException {
		
		String BaseURI = "http://localhost:3000/employees";
		
		Map<String, Object> Headers = new HashMap<>();
		Headers.put("Content-Type", ContentType.JSON);
		Headers.put("Accept", ContentType.JSON);
		
		byte[] Body = Files.readAllBytes(Paths.get("data.json"));


		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();
		
		Response response = request.headers(Headers)
									.body(Body)
									.post();
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),201);
			
		
	}


}
