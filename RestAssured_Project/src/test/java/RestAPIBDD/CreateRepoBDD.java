package RestAPIBDD;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepoBDD {
	
	@Test
	public void test1() throws IOException {
		
		
	     byte[] file = Files.readAllBytes(Paths.get("data2.json"));

	        String Accesstoken = "";// need to add access token from git

	        RestAssured.baseURI = "https://api.github.com";

	        RestAssured.given()
	            .auth()
	            .oauth2(Accesstoken)
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)
	            .body(file)
	        .when()
	            .post("/user/repos")
	        .then()
	            .statusCode(201) // expected status for successful repo creation
	            .body("name", notNullValue())// verify repo name is returned
	            .log()
	            .all();
	}

}
