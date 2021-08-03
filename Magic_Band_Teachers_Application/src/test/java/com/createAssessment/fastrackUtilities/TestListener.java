package com.createAssessment.fastrackUtilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener implements ITestListener{

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Test is started");
		if (Objects.isNull(extent)) {
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName="Test-Report-"+timeStamp+".html";		
			ExtentSparkReporter	spark=new ExtentSparkReporter("./test-output/"+repName);
			extent=new ExtentReports();
			final File conf=new File("extent-config.xml");
			try {
				spark.loadXMLConfig(conf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent.attachReporter(spark);
			}
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" Test is success");
		ExtentTest test= extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		test.pass(result.getName()+" test is passes");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" Test is failed");
		ExtentTest test= extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		File f=new File(screenshotPath);
		if (f.exists()) 
		{
			test.fail("Screenshot is below: " +  test.addScreenCaptureFromPath(screenshotPath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" Test is skiped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName()+" Test is Failed But Within Success Percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getName()+" Test is Failed With Timeout");
	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" Test on start");
	}

	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" on finish");
		extent.flush();
		
	}
	
	
}
