package com.createAssessment.fastrackTestcases;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.createAssessment.fastrackPageObject.FastrackLoginPage;
import com.createAssessment.fastrackPageObject.FeedbackPage;
import com.createAssessment.fastrackPageObject.GeneralDetailsPage;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackPageObject.SchedulePage;
import com.createAssessment.fastrackUtilities.ReadConfig;
//import org.testng.annotations.Parameters;

import atu.testrecorder.ATUTestRecorder;
public class BaseClass {

	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	ReadConfig readconfig=new ReadConfig(); 
	public String baseUrl=readconfig.getReviewUrl();
	public String testUrl=readconfig.getFastrackTestUrl();
	public static WebDriver driver;
	public static FastrackLoginPage fastrackLogin;
	public static ReviewPageQuestions reviewPage;
	

	
	public static ATUTestRecorder record;
	//@Parameters("browser")
	@BeforeClass
	public void steUp() 
	{	
 		/*if(br.equals("chrome"))
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
			//System.setProperty("webdriver.safari.driver",readconfig.getMSEdgePath());
			driver = new SafariDriver();
		}*/
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
 		driver = new ChromeDriver();
 	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser(){
		
		//driver.close();
	}
	
}
