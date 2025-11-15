package Project2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CRUDGetRequests {

	@Test
	public void _01Listusers() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
        .queryParam("page", 2)   // passing query param
         .when()
        .get("/api/users")
        .then()
        .log().all()
        .statusCode(200);
			
	}
	
	@Test
	public void _02singleuser() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
         .when()
        .get("api/users/2")
        .then()
        .log().all()
        .statusCode(200);
			
	}	
	
	@Test
	public void _03singleusernotfound() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
         .when()
        .get("api/users/23")
        .then()
        .log().all()
        .statusCode(401);
			
	}
	
	@Test
	public void _04Listresourses() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
         .when()
        .get("api/unknown")
        .then()
        .log().all()
        .statusCode(200);
			
	}
	
	
	@Test
public void _05singleuser() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
         .when()
        .get("api/unknown/2")
        .then()
        .log().all()
        .statusCode(200);
			
	}
	
	@Test
public void _06singleresoursenotfound() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
	    RestAssured.given()
        .baseUri("https://reqres.in")
         .when()
        .get("api/unknown/23")
        .then()
        .log().all()
        .statusCode(401);
			
	}
	
	
}
