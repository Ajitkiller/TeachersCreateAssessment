package com.studentAssessment.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.createAssessment.fastrackPageObject.FastrackLoginPage;
import com.createAssessment.fastrackUtilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentTest test;
	public static FastrackLoginPage loginPage;
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	ReadConfig readconfig=new ReadConfig(); 
	public String baseUrl=readconfig.getBaseurl();

	@BeforeClass
	public void setUp(){

		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@AfterClass
	public void closeBrowser(){

		//driver.close();

	}




}
