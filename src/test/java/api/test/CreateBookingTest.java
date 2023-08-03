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
import api.endpoints.BookingEndPoints;
import api.payload.CreateBookingRequest;
import api.payload.CreateBookingResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBookingTest extends Base_Test{

	CreateBookingRequest createBodyPayload;

	ExtentReports extent;
	ExtentTest logger;

	public static int bookingid;
	
	@BeforeMethod
	public void setUp()
	{

		System.out.println("*----------This is set up method-----------*");

	//	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Execution_Report.html");
		
	//	reporter.config().setDocumentTitle("Automation Report");
		
    //	reporter.config().setReportName("report");

	//	reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	//	extent = new ExtentReports();

	//	extent.attachReporter(reporter);
		
	//	logger = extent.createTest("test_POSTBooking");


		CreateTestData createTestData = new CreateTestData();


		createBodyPayload = createTestData.addBooking();

	}

	@Test
	public void test_POSTBooking()
	{
		RestAssured.useRelaxedHTTPSValidation();

		Response response = BookingEndPoints.createBooking(createBodyPayload);

		//	response.then().log().all();

		CreateBookingResponse createBookingResponse = response.then().log().all().extract().response().as(CreateBookingResponse.class);

		//	Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertNotNull(createBookingResponse.getBookingid());

		System.out.println(createBookingResponse.getBookingid());

		System.out.println(createBookingResponse.getBooking().getFirstname());

	//	context.setAttribute("booking_id", createBookingResponse.getBookingid());
		
		bookingid = createBookingResponse.getBookingid();

	}


	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
		
	//	extent.flush();
	}

}
