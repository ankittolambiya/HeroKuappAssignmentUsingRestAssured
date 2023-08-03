package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestData.CreateTestData;
import TestData.UpdateBookingTestData;
import api.endpoints.BookingEndPoints;
import api.payload.CreateBookingRequest;
import api.payload.CreateBookingResponse;
import api.payload.UpdateBookingRequest;
import api.payload.UpdateBookingResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateBookingTest extends Base_Test{

	UpdateBookingRequest updateBodyPayload;
	
//	CreateBookingTest createBookingTest;

	ExtentReports extent;
	ExtentTest logger;
	
	int booking_id;
	
	ITestContext context;

	@BeforeMethod
	public void setUp()
	{

		System.out.println("*----------This is set up method-----------*");

//		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Execution_Report.html");
		
//		reporter.config().setDocumentTitle("Automation Report");
		
//		reporter.config().setReportName("report");

//		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

//		extent = new ExtentReports();

//		extent.attachReporter(reporter);
		
//		logger = extent.createTest("test_PUTBooking");

	//	createBookingTest = new CreateBookingTest();
		
	//	createBookingTest.setUp();
		
	//	createBookingTest.test_POSTBooking();
		

		UpdateBookingTestData updateBookingTestData = new UpdateBookingTestData();


		updateBodyPayload = updateBookingTestData.updateBooking();

	}

	@Test
	public void test_PUTBooking(ITestContext context)
	{
	//	booking_id = (int)context.getAttribute("booking_id");
		
		booking_id = CreateBookingTest.bookingid;
		
		RestAssured.useRelaxedHTTPSValidation();

		Response response = BookingEndPoints.updateBooking(booking_id, updateBodyPayload);

		//	response.then().log().all();

		UpdateBookingResponse updateBookingResponse = response.then().log().all().extract().response().as(UpdateBookingResponse.class);

		//	Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println(updateBookingResponse.getAdditionalneeds());
		
	   System.out.println(response.getStatusCode());

	}


	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
		
	//	extent.flush();
	}

}
