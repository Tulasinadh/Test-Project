package Project2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CRUDputPatchcall {
	
	@Test
	public void _01Update() {
		
		 String BaseURI = "https://reqres.in/";
		 Map<String, Object> headers = new HashMap<>();
		    headers.put("Content-Type", "application/json");
		    headers.put("x-api-key", "reqres-free-v1");
		    String body = "{\n" +
		    		"    \"name\": \"morpheus\",\n" +
		    		"    \"job\": \"zion resident\"\n" +
		    		"}";

		    RestAssured.given()
		    .headers(headers)
		    .body(body)
		    .baseUri(BaseURI)
		   .when()
		    .put("/api/users/2")
		    .then()
		    .log().all()
		    .statusCode(200);
		    		    
	}
	
	@Test
	public void _02UpdatePatch() {
		
		 String BaseURI = "https://reqres.in/";
		 Map<String, Object> headers = new HashMap<>();
		    headers.put("Content-Type", "application/json");
		    headers.put("x-api-key", "reqres-free-v1");
		    String body = "{\n" +
		    		"  \"name\": \"morpheus\",\n" +
		    		"  \"job\": \"zion resident\"\n" +
		    		"}";


		    RestAssured.given()
		    .headers(headers)
		    .body(body)
		    .baseUri(BaseURI)
		   .when()
		    .patch("/api/users/2")
		    .then()
		    .log().all()
		    .statusCode(200);
		    		    
	}
	
	
	
	

}
