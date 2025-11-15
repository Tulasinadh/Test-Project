package Project2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CRUDpostcalls {
	
	@Test
	public void  _01Createuser() {
    String BaseURI = "https://reqres.in/";

    Map<String, Object> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("x-api-key", "reqres-free-v1");
    
    String body = "{\n" +
            "  \"name\": \"vasu\",\n" +
            "  \"job\": \"lead\"\n" +
            "}";

    RestAssured.given()
    .headers(headers)
    .body(body)
    .baseUri(BaseURI)
   .when()
    .post("/api/users")
    .then()
    .log().all()
    .statusCode(201);

	}
	
	@Test
	public void  _02Registersuccess() {
	    String BaseURI = "https://reqres.in/";

	    Map<String, Object> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("x-api-key", "reqres-free-v1");
	    
		String body = "{\n" +
	            "  \"email\": \"eve.holt@reqres.in\",\n" +
	            "  \"password\": \"pistol\"\n" +
	            "}";

	    RestAssured.given()
	    .headers(headers)
	    .body(body)
	    .baseUri(BaseURI)
	   .when()
	    .post("/api/register")
	    .then()
	    .log().all()
	    .statusCode(200);

		}
	
	@Test
	public void  _03Registerunsuccess() {
	    String BaseURI = "https://reqres.in/";

	    Map<String, Object> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("x-api-key", "reqres-free-v1");
	    
	    String body = "{\n" +
	              "  \"email\": \"sydney@fife\"\n" +
	              "}";
	    
	    RestAssured.given()
	    .headers(headers)
	    .body(body)
	    .baseUri(BaseURI)
	   .when()
	    .post("/api/register")
	    .then()
	    .log().all()
	    .statusCode(400);

		}
	
	
	@Test
	public void  _04Loginsuccess() {
	    String BaseURI = "https://reqres.in/";

	    Map<String, Object> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("x-api-key", "reqres-free-v1");
	    
	    String body = "{\n" +
	    		"    \"email\": \"eve.holt@reqres.in\",\n" +
	    		"    \"password\": \"cityslicka\"\n" +
	    		"}";

	    
	    RestAssured.given()
	    .headers(headers)
	    .body(body)
	    .baseUri(BaseURI)
	   .when()
	    .post("/api/Login")
	    .then()
	    .log().all()
	    .statusCode(200);

		}
	
	@Test
	public void  _04Loginunsuccess() {
	    String BaseURI = "https://reqres.in/";

	    Map<String, Object> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("x-api-key", "reqres-free-v1");
	    
	    String body = "{\n" +
	    		"    \"email\": \"peter@klaven\"\n" +
	    		"}";
    
	    RestAssured.given()
	    .headers(headers)
	    .body(body)
	    .baseUri(BaseURI)
	   .when()
	    .post("/api/Login")
	    .then()
	    .log().all()
	    .statusCode(400);

		}	
	


	
	
	
	
	

}
