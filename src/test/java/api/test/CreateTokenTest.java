package api.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestData.GenerateTokenTestData;
import api.endpoints.BookingEndPoints;
import api.payload.CreateTokenRequest;
import api.payload.CreateTokenResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateTokenTest extends Base_Test{

CreateTokenRequest createTokenPayload;

public static String token;
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("*----------This is set up method-----------*");
		
		GenerateTokenTestData generateTokenTestData = new GenerateTokenTestData();
		
	//	BookingEndPoints bookingEndPoints = new BookingEndPoints();
		
		createTokenPayload = generateTokenTestData.generateToken();
		
	}
	
	@Test
	public void test_POSTGenerateToken()
	{
		RestAssured.useRelaxedHTTPSValidation();
				
		Response response = BookingEndPoints.createToken(createTokenPayload);
		
		response.then().log().all();
		
		CreateTokenResponse createTokenResponse = response.then().extract().response().as(CreateTokenResponse.class);
		
	//	Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertNotNull(createTokenResponse, "Token value is empty");
		
		token = createTokenResponse.getToken();
		
		System.out.println(createTokenResponse.getToken());
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
	}
}
