package mercariextentreport;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	@Test
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"//reports//Report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Mercari Web Automation Test Report");
		reporter.config().setDocumentTitle("Mercari Web Automation Test Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}
	