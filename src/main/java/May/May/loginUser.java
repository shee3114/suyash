package May.May;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class loginUser {

	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws Exception{
		FileInputStream fis = new FileInputStream("C:\\Users\\Maddy\\workspace\\31MayApiAutomationTestingforREQRESwebsite\\src\\main\\java\\Files\\config.properties");
		prop.load(fis);
	}

	@Test
	public void login() {
		RestAssured.baseURI = prop.getProperty("Host");
		given().
		body("{" +
    "\"email\": \"eve.holt@reqres.in\"," +
    "\"password\": \"pistol\" " +
	"}").
		when().
		post("/api/register").
		then().assertThat().statusCode(200);
	}
}
