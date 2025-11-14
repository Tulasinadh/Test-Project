package Project1;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Dummy_sample_rest_Apis {
	
	int EmployeeId; 
	
	@Test
	public void GetAllEmployee() {
		
		String BaseURI = "https://dummy.restapiexample.com/api/v1/employees";
		
		RestAssured.baseURI = BaseURI; // String the URL 
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String responseBody = response.body().asString(); // converting the response data into string (json to string format)
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());// Status code is a method used to get/read status code frokm response object
		Assert.assertEquals(response.statusCode(),200);
		
		
	}
	@Test
	
	public void GetSingleEmployee() {
	
			String BaseURI = "https://dummy.restapiexample.com/api/v1/employee/1";
			RestAssured.baseURI = BaseURI;
			RequestSpecification request = RestAssured.given();
			
			Response response = request.get();
			
			String responseBody = response.body().asString(); // converting the response data into string (json to string format)
			System.out.println(responseBody);
			
			System.out.println(response.statusCode());// Status code is a method used to get/read status code frokm response object
			Assert.assertEquals(response.statusCode(),200);
			
			// Extracting the list of names from the JSON response
			
			JsonPath jpath = response.jsonPath();  
			String EmployeeName = jpath.getString("data.employee_name");
			  EmployeeId = jpath.getInt("data.id");

			String expectedName = "Tiger Nixon";

			// Validate if the first name in the list matches the expected name
		if( EmployeeName.equalsIgnoreCase(expectedName)) {
			System.out.println("Actual and Expected Employee name is same");
			System.out.println("Employee name"+" : "+EmployeeName);
		}
		else {
			System.out.println("Actual and Expected Employee names are not same");
		}
			}
	
	@Test
	public void CreateEmployee() {
		
		String BaseURI = "https://dummy.restapiexample.com/api/v1/create";
		
		RestAssured.baseURI = BaseURI;
		
		Map<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", ContentType.JSON);
		headers.put("Accept", ContentType.JSON);
		
		
		String Body = "{\r\n"
				+ "	\"name\":\"Vasu kotla\",\r\n"
				+ "\"salary\":\"11644\",\r\n"
				+ "	\"age\":\"28\"\r\n"
				+ "}\r\n"
				+ "";
		
		RequestSpecification request = RestAssured.given();
		Response response = request.headers(headers)
				.body(Body)
				.post();
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),201);
		
		
		JsonPath jpath = response.jsonPath();
		String status = jpath.getString("status");
		Assert.assertEquals(status, "success");
			
	}
	
	@Test
	public void DeleteEmployee() {
		
		String BaseURI = "https://dummy.restapiexample.com";
		 RestAssured.baseURI =BaseURI ;

		RequestSpecification request = RestAssured.given();
		
		  Response response = RestAssured
			        .given()
			        .pathParam("emp_id", EmployeeId)
			        .delete("/api/v1/delete/{emp_id}");
		
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200);
		
		JsonPath jpath = response.jsonPath();
		
	    String status = jpath.getString("status");
	    Assert.assertEquals(status, "success", "Expected status to be 'success'");

	    // Validate "message"
	    String message = jpath.getString("message");
	    String expectedMessage = "successfully! deleted Records";
	    Assert.assertEquals(message, expectedMessage, "Expected message mismatch");


	}
	
	
	@Test
	public void TestDeletedEmployee(){
		String BaseURI = "https://dummy.restapiexample.com";
		 RestAssured.baseURI =BaseURI ;

		RequestSpecification request = RestAssured.given();
		
		  Response response = RestAssured
			        .given()
			        .pathParam("emp_id", EmployeeId)
			        .get("/api/v1/employee/{emp_id}");
		
			String responseBody = response.body().asString();
			System.out.println(responseBody);
			
			System.out.println(response.statusCode());
			Assert.assertEquals(response.statusCode(),200);
			
			JsonPath jpath = response.jsonPath();
			
		    String datavalue = jpath.getString("data");
		    Assert.assertEquals(datavalue, "success", "null");
		
	}
	
	
	
	

}
