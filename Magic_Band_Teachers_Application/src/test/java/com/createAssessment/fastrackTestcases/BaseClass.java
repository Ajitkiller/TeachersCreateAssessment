package com.createAssessment.fastrackTestcases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.createAssessment.fastrackPageObject.FastrackLoginPage;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackUtilities.ReadConfig;
//import org.testng.annotations.Parameters;
import com.report.extentReport.ExtentReports1;

import atu.testrecorder.ATUTestRecorder;
public class BaseClass {

	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	ReadConfig readconfig=new ReadConfig(); 
	public String baseUrl=readconfig.getReviewUrl();
	public static WebDriver driver;
	public static FastrackLoginPage fastrackLogin;
	public static ReviewPageQuestions reviewPage;
	public static ExtentReports1 extent;
	public static ATUTestRecorder record;
	@Parameters("browser")
	@BeforeClass
	public void steUp(String br) 
	{	
		
 		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			// Instantiate a ChromeDriver class.
			driver=new ChromeDriver();
		}
		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getMSEdgePath());
			driver = new EdgeDriver();
		}
		else if (br.equals("safari")) 
		{
			System.setProperty("webdriver.safari.driver",readconfig.getMSEdgePath());
			driver = new SafariDriver();
		}
		//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		//driver = new ChromeDriver();
 	
	//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser(){
		
		//driver.close();
		
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") +"/Screenshots/"+ tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
			
	}
	public String randomestring() {
		String generateString=RandomStringUtils.randomAlphabetic(15);
		return(generateString);
	}
	public String randomeNum() {
		String generateString=RandomStringUtils.randomNumeric(15);
		return(generateString);
	}
	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentReports1.initReports();
	}
	@AfterSuite
	public void afterSuite() throws IOException {
		ExtentReports1.flushReports();
	}
}
