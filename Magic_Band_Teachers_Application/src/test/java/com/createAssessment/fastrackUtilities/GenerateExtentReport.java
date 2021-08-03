package com.createAssessment.fastrackUtilities;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {

	
	ExtentReports extent;
	
	@BeforeClass
	public void startReport() throws IOException {
		
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./test-output/Extent.html");
		
		final File conf=new File("extent-config.xml");
		spark.loadXMLConfig(conf);
		
		
		
		/*spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Reports Demo");*/
		extent.attachReporter(spark);
	}
		@Test
		public void test1() {
		ExtentTest test = extent.createTest("MagicBand Teachers app").assignAuthor("Ajit").assignCategory("Smoke").assignCategory("Regression").assignDevice("Chrome 92");
		test.pass("Login test is started successfully");
		test.info("Url is loaded");
		test.pass("Login test completed successfully");
		}
		@Test
		public void test2() {
		ExtentTest test1 = extent.createTest("MagicBand Students app").assignAuthor("Ajit kumar").assignCategory("Retest").assignDevice("Safari 13");
		test1.pass("Login test is started successfully");
		test1.info("Url is loaded");
		test1.pass("Login test completed successfully");
	
		
	}
		@AfterSuite
		public void flushtest() 
		{
		extent.flush();
		}
}
