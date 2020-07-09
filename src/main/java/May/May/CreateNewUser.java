package May.May;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewUser {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Maddy\\workspace\\31MayApiAutomationTestingforREQRESwebsite\\src\\main\\java\\Files\\config.properties");
	prop.load(fis);
	}
	
	@Test
	public void createUser(){
		RestAssured.baseURI = prop.getProperty("Host");
		Response res = given().
		body("{"+
    "\"name\": \"morpheus\","+
    "\"job\": \"leader\" "+
    "}").
		when().
		post("/api/users").
		then().assertThat().statusCode(201).contentType(ContentType.JSON).
		extract().response();
		String response = res.asString();
		
		//Print response
		
		System.out.println(response);
	}
}
