package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCallBDD {

	@Test
	public void test1() {
		
		String BaseURI = "http://localhost:3000/employees";
		
		Map<String, Object> Headers = new HashMap<>();
		Headers.put("Content-Type", ContentType.JSON);
		Headers.put("Accept", ContentType.JSON);
		
		Map<String,String> Body = new HashMap<>();
		Body.put("name", "Rohit");
		Body.put("salary", "9000");
		Body.put("id", "10");
		
		RestAssured.given()
					.headers(Headers)
					.body(Body)
					.baseUri(BaseURI)
					.when()
					.post()
					.then()
					.log()
					.all()
					.statusCode(201);
		
		
		
	}


	
}
