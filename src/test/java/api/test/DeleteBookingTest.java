package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import api.endpoints.BookingEndPoints;
import api.payload.DeleteBookingRequest;
import api.payload.DeleteBookingResponse;
import io.restassured.response.Response;

public class DeleteBookingTest extends Base_Test{

	DeleteBookingRequest deleteBookingRequest;

	int booking_id;

	ExtentReports extent;

	ExtentTest logger;


	@BeforeMethod
	public void setUp()
	{
		System.out.println("*----------This is set up method-----------*");

	}

	@Test
	public void test_DELETEBooking(ITestContext context)
	{

		booking_id = CreateBookingTest.bookingid;

		Response response = BookingEndPoints.deleteBooking(booking_id);

	//	response.then().log().all();

		DeleteBookingResponse deleteBookingResponse = response.then().log().all().extract().response().as(DeleteBookingResponse.class);

		//	Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println(deleteBookingResponse);
		
		int status_code = response.getStatusCode();

        Assert.assertEquals(status_code, 201, "Delete operation not performed successfully");

	}


	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
		
	}

}
