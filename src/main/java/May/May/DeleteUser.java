package May.May;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;

public class DeleteUser {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Maddy\\workspace\\31MayApiAutomationTestingforREQRESwebsite\\src\\main\\java\\Files\\config.properties");
	prop.load(fis);
	}
	
	@Test
	public void deleteUser() {
		RestAssured.baseURI = prop.getProperty("Host");
		given().
		when().
		delete("api/users/2").
		then().assertThat().statusCode(204);
	}
}
