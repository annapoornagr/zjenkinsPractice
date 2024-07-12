package GenericUtilites;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * This class provides implementation to ITestListener interface of testNG
 * @author chand
 */


public class ListenersImplementation implements ITestListener
{
	ExtentReports report;     //made them as Global
	ExtentTest test;          //made them as Global
	
	
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test execution started-----");
		
		//Create a @Test in extent Reports
		 test = report.createTest(methodName);
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test PASS ----- ");
		
		//Log the status as PASS in extent Reports
		test.log(Status.PASS, methodName+" ----- Test PASS ----- ");
		}

	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test FAIL ----- ");
		
		//Log the status as FAIL in extent Reports
		test.log(Status.FAIL, methodName+" ----- Test FAIL ----- ");
		
		//capture screen shot
		 SeleniumUtility s = new SeleniumUtility();   //object creation of seleniumutility
		 JavaUtility j = new JavaUtility();          //object creation of javaUtility
		 
		 String screenshotName = methodName+"-"+j.getDate();
		 
		 try
		 {
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);
			
			//attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		 } 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}

	
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test SKIP ----- ");
		
		//Log the status as SKIP in extent Reports
		test.log(Status.SKIP,methodName+" ----- Test SKIP ----- ");
		}
	

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}


	public void onStart(ITestContext context) {
		System.out.println(" ----- Suite execution started ----- ");
		
		//Configuration pf extent reports
		ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Reports");      //calling the config method
		rep.config().setReportName("Vtiger Execution Report");   //calling the config method
		rep.config().setTheme(Theme.DARK);
		
		 report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reported Name", "Annapoorna");
		
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println(" ----- Suite execution Finished ----- ");
		
		//Generate the extent report
		report.flush();
		
		
	}
	


}
