package com.report.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentWithScreenshot {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws IOException {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("Extent.html");
		final File conf=new File("extent-config.xml");
		spark.loadXMLConfig(conf);
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void tearDown() throws IOException {
		
		extent.flush();
		Desktop.getDesktop().browse(new File("Extent.html").toURI());
	}
	
	@Test
	public void attachScreenshotTest() {
		
		ExtentTest test= extent.createTest("First Test");
		System.setProperty("webdriver.chrome.driver", "./WebDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
		test.pass("value entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		
		if (2>=5) {
			test.pass("value entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			
		}
		else {
			test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
	}
	public String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
	
	
	
	
	
}
