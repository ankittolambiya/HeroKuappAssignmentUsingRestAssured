package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import api.endpoints.BookingEndPoints;
import api.payload.GetBookingIdRequest;
import api.payload.GetBookingIdResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIdTest extends Base_Test{

	GetBookingIdRequest getBookingIdRequest;

	int booking_id;

	ExtentReports extent;

	ExtentTest logger;


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

	}

	@Test
	public void test_GETBooking(ITestContext context)
	{

	//	booking_id = (int)context.getAttribute("booking_id");

		booking_id = CreateBookingTest.bookingid;
		
	//	RestAssured.useRelaxedHTTPSValidation();

		Response response = BookingEndPoints.readBooking(booking_id);

	//	response.then().log().all();

		GetBookingIdResponse getBookingIdResponse = response.then().log().all().extract().response().as(GetBookingIdResponse.class);

		//	Assert.assertEquals(response.getStatusCode(), 200);
		int totalprice = getBookingIdResponse.getTotalprice();

		boolean deposit_paid = getBookingIdResponse.getDepositpaid();



		Assert.assertEquals(getBookingIdResponse.getFirstname(), "Jim","Mismatch in first name");

		Assert.assertEquals(totalprice, 111, "Mismatch in total price value");

		Assert.assertEquals(deposit_paid, true, "Mismatch in deposit paid value");



	}


	@AfterMethod
	public void tearDown()
	{
		System.out.println("*---------This is tear down method---------*");
		
	//	extent.flush();
	}

}