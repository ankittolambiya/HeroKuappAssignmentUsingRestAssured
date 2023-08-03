package api.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HeroKuappStandALoneProgram {

	String createdTokenValue;

	@Test
	public void createToken()
	{	
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";

		Response res = given().header("Content-Type","application/json")
				.body(payload)
				.when().post("/auth")
				.then().assertThat().extract().response();

		//	JsonPath jp = new JsonPath(res.asString());

		//	createdTokenValue = jp.getString("token");

	//	System.out.println("Value of token is "+createdTokenValue);
			

		String responseBody= res.getBody().asString();
		System.out.println(responseBody);

		//Print Response in console window
		JsonPath jsonpath= res.jsonPath(); 

		System.out.println(jsonpath.getString("token"));

	}
}
