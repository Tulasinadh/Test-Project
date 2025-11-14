package RestAPIBDD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		
		@Test
		public void test2() throws IOException {
				
				String BaseURI = "https://api.github.com";
				String token = "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";
				
				Map<String, Object> Headers = new HashMap<>();
				Headers.put("Content-Type", ContentType.JSON);
				Headers.put("Accept", ContentType.JSON);
				
				byte[] Body = Files.readAllBytes(Paths.get("data2.json"));
				
			    RestAssured.given()
			    .auth().oauth2(token)
				.headers(Headers)
				.body(Body)
				.baseUri(BaseURI)
				.when()
				.post("user/repos")
				.then()
				.log()
				.all()
				.statusCode(201);
		}
		}

