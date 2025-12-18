package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
 public static ExtentReports getReportObject() {
	 String path=System.getProperty("user.dir")+"//reports//index.html";
	 ExtentSparkReporter reporter=new ExtentSparkReporter(path);//this is helper class used for configuring the extent report
	 reporter.config().setReportName("Web Automation Results");
	 reporter.config().setDocumentTitle("Test Results");
	 
	 ExtentReports extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester","Ambica Shakelli");
	 return extent;
 }
}
