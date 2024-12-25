package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	//Ui of the report like title and theme
	public ExtentSparkReporter spark;
	//populate common info on the report like fields
	public ExtentReports report;
	//this will create test and update status of the test
	public ExtentTest test;
	
	
	public void onStart(ITestContext context)
	{
		spark=new ExtentSparkReporter("C:\\Selenium_Automation\\Mukesh_Automation_Framework\\reports\\report.html");
		spark.config().setDocumentTitle("Openkart");
		spark.config().setReportName("Testcase Report");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("Computer name", "Hp");
		report.setSystemInfo("Tester", "Mukesh");
		report.setSystemInfo("Env", "Test");
		report.setSystemInfo("Browser", "Edge");
	}
	
	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.PASS, result.getName());
	  }
	public void onTestFailure(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.FAIL, result.getName());
	  }
	public void onTestSkipped(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.SKIP, result.getName());	  
		}
	public void onFinish(ITestContext context) {
		report.flush();
	  }

}
