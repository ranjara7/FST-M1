package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Activity2 {
	
	@Test(priority=1)
	public void addNewUser() throws FileNotFoundException {
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userinfo.json");
		
		given()
		.baseUri("https://petstore.swagger.io/v2/user")
		.header("Content-Type", "application/json")
		.body(inputJSON)
		
		.when()
		.post()
		
		.then()
		.log().all()
		.body("code", equalTo(200))
		.body("message", equalTo("2809"));
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
		
		 Response response = given()
		.baseUri("https://petstore.swagger.io/v2/user")
		.header("Content-Type", "application/json")
		.pathParam("username", "thalapathy")
		.log().all()
		
		.when()
		.get("/{username}");
		
		
		String resBody = response.getBody().asPrettyString();
		
		try {
			outputJSON.createNewFile();
			FileWriter writer= new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		}
		catch(IOException exp) {
			exp.printStackTrace();
		}
		
	response.then().body("id", equalTo(2809));
	response.then().body("username", equalTo("thalapathy"));
	response.then().body("firstname", equalTo("vijay"));
	response.then().body("lastname", equalTo("joseph"));
	response.then().body("email", equalTo("thalapathy@mail.com"));
	response.then().body("password", equalTo("password123"));
	response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority=3)
	public void deleteUser() {
		given()
		.baseUri("https://petstore.swagger.io/v2/user")
		.header("Content-Type", "application/json")
		.pathParam("username", "thalapathy")
		.log().all()
		
		.when()
		.delete("/{username}")
		
		.then()
		.log().all()
		.body("code", equalTo(200))
		.body("message", equalTo("thalapathy"));
		
	}

}
