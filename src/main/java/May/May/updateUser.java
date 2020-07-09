package May.May;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class updateUser {

	 Properties prop = new Properties();

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Maddy\\workspace\\31MayApiAutomationTestingforREQRESwebsite\\src\\main\\java\\Files\\config.properties");
		prop.load(fis);
	}

	@Test

	public void updateUserList() {

		RestAssured.baseURI = prop.getProperty("Host");
		given().
		body("{" +
		   " \"name\": \"morpheus\", " +
		   " \"job\": \"zion resident\"," +
		    "\"updatedAt\": \"2020-06-02T19:26:03.029Z\"" +
		"}").
		when().
		put("api/users/2").
		then().assertThat().statusCode(200);
	}
}
