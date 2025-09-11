package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public  void test1() {
	String BaseURI = "http://localhost:3000/employees";
		
		RestAssured.baseURI = BaseURI; // String the URL 
		
		RequestSpecification request = RestAssured.given(); // Creating object of RequestSpecification class(RestAssured is a class of Rest assured)
		
		Response response = request.get(); // Creating a Response class object and assigning the response(Json data) to the object  
		
		String responseBody = response.body().asString(); // converting the response data into string (json to string format)
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());// Status code is a method used to get/read status code frokm response object
		Assert.assertEquals(response.statusCode(),200);
		
		JsonPath jpath = response.jsonPath(); // Expression 
		List<String> names = jpath.get("name");
		
		// Print all the names
		
		for(String indName : names) {
			System.out.println(indName);
		}
		
		
		// Print individual emp name
		
		System.out.println("First emp is " + names.get(0));

		
	}		
	}

