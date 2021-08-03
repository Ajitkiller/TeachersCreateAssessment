package com.report.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports1 {

	private ExtentReports1() {
		
	}
	
	private static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	private static ExtentSparkReporter spark;

	public static void initReports() throws IOException {
		if (Objects.isNull(extent)) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";		
		ExtentSparkReporter	spark=new ExtentSparkReporter("./test-output/"+repName);
		extent=new ExtentReports();
		ExtentSparkReporter spark1=new ExtentSparkReporter("Extent.html");
		final File conf=new File("extent-config.xml");
		spark.loadXMLConfig(conf);
		extent.attachReporter(spark);
		}
	}
	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File("Extent.html").toURI());
	}
	
	public static void createTest(String testName) {
		test = extent.createTest(testName).assignAuthor("Ajit").assignCategory("Regression").assignDevice("Chrome 92");
	}
	public static void screenshot() {
		test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		
	}
	public static String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
