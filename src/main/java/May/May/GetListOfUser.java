package May.May;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

//This class file for api automatin of the "https://reqres.in" Website.
public class GetListOfUser {
	Properties prop = new Properties();

	@BeforeTest
	public void getData() throws Exception {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Maddy\\workspace\\31MayApiAutomationTestingforREQRESwebsite\\src\\main\\java\\Files\\config.properties");
		prop.load(fis);
	}

	@Test
	public void getUserList() {
		RestAssured.baseURI = prop.getProperty("Host");
		Response res = given().
				param("page", "2").
				when().get("/api/users").
				then().assertThat().statusCode(200).
				contentType(ContentType.JSON).
				extract().response();
		String response = res.asString();
		System.out.println("Response: " + response);

		JsonPath js = new JsonPath(response);
		// Get the email id of the user.
		for (int i = 0; i < 6; i++) {
			System.out.println(js.get("data[" + i + "].email"));
		}
	}
}
