package Project1;

import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Project1BDD {
	int employeeId; 
	
@Test
	public void _01GetAllEmployee() {
	  
	    RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";

	    RestAssured.given()
	    .when()
	    .get()
	    .then()
	    .log().all().statusCode(200);
	    
	}
		
@Test
public void _02GetSingleEmployee() {
    RestAssured. baseURI = "https://dummy.restapiexample.com/api/v1/";
RestAssured.given()
    .when()
        .get("employee/1")
    .then()
        .log().all()
        .statusCode(200)
        .body("data.employee_name", Matchers.equalTo("Tiger Nixon"));
}

@Test
public void  _03CreateEmployee() {
    String BaseURI = "https://dummy.restapiexample.com/api/v1";

    Map<String, Object> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("Accept", "application/json");

    String body = "{\n"
            + "  \"name\": \"Tod Jackson \",\n"
            + "  \"salary\": \"123\",\n"
            + "  \"age\": \"23\"\n"
            + "}";

    employeeId =RestAssured.given()
        .headers(headers)
        .body(body)
        .baseUri(BaseURI)
       .when()
        .post("/create")
        .then()
        .log().all()
        .statusCode(201)
        .body("status",Matchers.equalTo("success"))
        .extract()
        .path("data.id");
    
    System.out.println("Created Employee ID: " + employeeId);
}


@Test
public void _04DeleteEmployee() {
  
    RestAssured.baseURI = "https://dummy.restapiexample.com";

RestAssured.given()
            .pathParam("emp_id", employeeId)
            .when()
            .delete("/api/v1/delete/{emp_id}")
            .then()
            .log().all()
            .statusCode(200)
            .body("status",Matchers.equalTo("success"));
}

@Test
public void _05TestDeletedEmployee() {

    RestAssured.baseURI = "https://dummy.restapiexample.com";
    
        RestAssured.given()
            .pathParam("emp_id", employeeId)
            .when()
            .get("/api/v1/employee/{emp_id}")
            .then()
            .log().all()
            .statusCode(200)
            .body("data",Matchers.equalTo("null"));
        
}
	
}
