package RestAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequestBDD {

	@Test
	public void test1() {
		
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get()
					.then()
					.log()
					.all()
					.statusCode(200);
					
		
	}
	
	// With path parameter
	
	@Test
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get("1")
					.then()
					.log()
					.all()
					.statusCode(200)
		            .body("name", Matchers.equalTo("Latha"))
		            .body("salary", Matchers.equalTo("60000"));

	}
	// with query params
	
		@Test
		public void test3() {
			RestAssured.given()
						.queryParam("CUSTOMER_ID", "68195")
						.queryParam("PASSWORD", "1234!")
						.queryParam("Account_No", "1")
						.baseUri("http://demo.guru99.com/V4/sinkministatement.php")
						.when()
						.get()
						.then()
						.log()
						.all()
						.statusCode(200);
		}



}
