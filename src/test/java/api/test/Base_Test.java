package api.test;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base_Test {

	    public static ExtentReports reports;
	    public static ExtentTest testInfo;
	    public static ExtentHtmlReporter htmlReporter;

	    @BeforeSuite
	    public void reportSetup() 
	    {
	        htmlReporter = new ExtentHtmlReporter("./reports/Execution_Report.html");
	        
	        htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/resources/XML/Extent-Config.xml"),true);
	        
	        reports = new ExtentReports();
	        
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        
	        reports.setSystemInfo("Environment", "Automation");
	        
	        reports.attachReporter(htmlReporter);
	    }

	    @BeforeMethod
	    public void testMethodName(Method method) {
	        String testName = method.getName();
	        testInfo = reports.createTest(testName);
	    }

	    @AfterMethod
	    public void capture_TestStatus(ITestResult result) {
	        try {
	            if (result.getStatus() == ITestResult.SUCCESS) {
	                testInfo.log(Status.PASS, "Test method " + "'" + result.getName() + "'" + result.getStatus());
	            } else if (result.getStatus() == ITestResult.FAILURE) {
	                testInfo.log(Status.FAIL, "Test method " + "'" + result.getName() + "'" + result.getStatus());
	                testInfo.log(Status.FAIL, "Test error " + result.getThrowable());
	            } else if (result.getStatus() == ITestResult.SKIP) {
	                testInfo.log(Status.SKIP, "Test method " + "'" + result.getName() + "'" + result.getStatus());
	            }

	        } catch (Exception e) {    
	            e.printStackTrace();    
	        }
	    }

	    @AfterSuite
	    public void generateReport() {
	        reports.flush();
	    }
}
