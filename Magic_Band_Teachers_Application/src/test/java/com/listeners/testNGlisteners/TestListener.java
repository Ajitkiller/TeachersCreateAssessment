package com.listeners.testNGlisteners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Listeners class used to generate Extent report


public class TestListener implements ITestListener,ISuiteListener {

	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;


	public void onTestStart(ITestResult result) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";		
		spark=new ExtentSparkReporter("./test-output/"+repName);
		
		extent =new ExtentReports();
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "ajit");
		
		final File conf=new File("extent-config.xml");
		try {
			spark.loadXMLConfig(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		test=extent.createTest(result.getName()).assignAuthor("Ajit").assignCategory("Functional").assignDevice("Chrome 91");  //Create new entry in the report.
		test.log(Status.INFO, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName()).assignAuthor("Ajit").assignCategory("Functional").assignDevice("Chrome 91");  //Create new entry in the report.
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		test.pass(result.getName()+" is completed successfullty");
	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName()).assignAuthor("Ajit").assignCategory("Functional").assignDevice("Chrome 91");  //Create new entry in the report.
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File f=new File(screenshotPath);
		
		if (f.exists()) 
		{
			try 
			{
			test.fail("Screenshot is below: "  +  test.addScreenCaptureFromPath(screenshotPath));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName()).assignAuthor("Ajit").assignCategory("Functional").assignDevice("Chrome 92");  //Create new entry in the report.
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		test.skip(result.getName()+" test is skiped");
	}

	
}