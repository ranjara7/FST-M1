package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class Activity1 {
	
	@Test(priority=1)
	public void addNewPet() {
		
		//request body
		Map<String, Object> reqBody= new HashMap<>();
		reqBody.put("id", 67456);
		reqBody.put("name", "allen");
		reqBody.put("status", "alive");
		
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.body(reqBody)
		
		.when()
		.post()
		
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("allen"))
		.body("status", equalTo("alive"));
	}
	
	@Test(priority=2)
	public void getPetInfo() {
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.pathParam("petId", 67456)
		.log().all()
		
		.when()
		.get("/{petId}")
		
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("allen"))
		.body("status", equalTo("alive"));
		
	}
	
	@Test(priority=3)
	public void deletePet() {
		given()
		.baseUri("https://petstore.swagger.io/v2/pet")
		.header("Content-Type", "application/json")
		.pathParam("petId", 67456)
		.log().all()
		
		.when()
		.delete("/{petId}")
		
		.then()
		.log().all()
		.statusCode(200)
		.body("message", equalTo("67456"));
		
	}

}
