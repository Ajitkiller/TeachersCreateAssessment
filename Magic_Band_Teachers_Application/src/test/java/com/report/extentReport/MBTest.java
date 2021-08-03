package com.report.extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
@Listeners(com.createAssessment.fastrackUtilities.TestListener.class)
public class MBTest {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	
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
	public void testoutput() {
		ExtentTest test= extent.createTest("testoutput");
		System.setProperty("webdriver.chrome.driver", "./WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://magicband-test.azurewebsites.net/");
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
	}
	@Test(priority = 1)
	public void secondTest() throws InterruptedException {
		ExtentTest test= extent.createTest("secondTest").assignAuthor("Ajit").assignCategory("Finctional").assignDevice("Windows");
		Thread.sleep(2000);
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		Thread.sleep(2000);
		emailId.sendKeys("teacher1@webcraft.co.in");
		WebElement nextButton =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		
		nextButton.click();
		test.pass("Next button clicking successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		
	}
	@Test(priority = 2)
	public void thirdTest() {
		
		System.out.println("This is 3rd test");
	}
	
	@Test(priority = 3)
	public void fourTest() {
		
		System.out.println("This is 4th test");
	}
	
	@Test(priority = 4)
	public void fifthTest() {
		
		System.out.println("This is 5th test");
		Assert.assertTrue(false);
	}
	public String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
}
