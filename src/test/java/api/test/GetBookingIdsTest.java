package api.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.endpoints.BookingEndPoints;
import api.payload.GetBookingIdsResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdsTest extends Base_Test{
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("*----------This is set up method-----------*");
		
	//	CreateTestData createTestData = new CreateTestData();
		
	//	BookingEndPoints bookingEndPoints = new BookingEndPoints();
		
	//	 createBodyPayload = createTestData.addBooking();
		
	}
	
	@Test
	public void test_GetBookingIdsList()
	{
		RestAssured.useRelaxedHTTPSValidation();
				
		Response response = BookingEndPoints.readBookingIds();
		
	//	response.then().log().all();
		
		GetBookingIdsResponse [] getBookingIdsResponse = response.then().log().all().extract().response().as(GetBookingIdsResponse[].class);
		
	//	Assert.assertEquals(response.getStatusCode(), 200);
				
		System.out.println("Value of first booking id is "+getBookingIdsResponse);
		
	//	System.out.println(createBookingResponse.getBooking().getFirstname());
	}
	 
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
	}

}
