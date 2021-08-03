package com.createAssessment.fastrackTestcases;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.createAssessment.fastrackPageObject.CreateAssessmentHomePage;
import com.createAssessment.fastrackPageObject.FeedbackPage;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackPageObject.SchedulePage;
import com.report.extentReport.ExtentReports1;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ReassignedAssessment extends BaseClass{
	@Test
	public void fastrackLogin() throws InterruptedException, ATUTestRecorderException 
	{
		ExtentReports1.createTest("fastrackLogin");
		
		record=new ATUTestRecorder("./logs", "Sat-24-Jul", false);
		record.start();
		driver.manage().deleteAllCookies();
		driver.get(readconfig.getBaseurl());
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		ExtentReports1.test.pass("Login page displayed");
	}
	@Test(priority = 1)
	public void clickOnLoginButton() throws InterruptedException
	{
		ExtentReports1.createTest("clickOnLoginButton");
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
		log.info("Login button clicking successfully");
		ExtentReports1.test.pass("Clicking login button.");
	}
	@Test(priority = 2)
	public void enterUsername() throws InterruptedException
	{
		ExtentReports1.createTest("enterUsername");
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		log.info("clear email input area.");
		emailId.sendKeys("teacher1@webcraft.co.in");
		log.info("email entered successfully");
		WebElement nextButton =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();
		ExtentReports1.test.pass("Username entered");
	}
	@Test(priority = 3)
	public void enterPassword() throws InterruptedException
	{
		ExtentReports1.createTest("enterPassword");
		WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		log.info("clear password input area.");
		password.sendKeys("Vision2020");
		log.info("password entered successfully");
		Thread.sleep(2000);
		WebElement nextButton2 =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton2.click();
		log.info("Clicking next button successfully");
		ExtentReports1.test.pass("Password entered successfully");
	}

	@Test(priority = 4)
	public void selectAssignedAssessment() throws InterruptedException, IOException 
	{
		ExtentReports1.createTest("selectAssignedAssessment");
		//Object creation for create assessment home page.
		CreateAssessmentHomePage homeAssessment=new CreateAssessmentHomePage(driver);
		Thread.sleep(3000);
		homeAssessment.selectAssessment(driver);
		log.info("Verify assessment is present.");
		homeAssessment.clickOnAssignButton();
		log.info("Clicking assessment Assign button successfully");
		ExtentReports1.test.pass("Assessment selected successfully");
	}

	@Test(priority = 5)
	public void clickOnNextButton() throws InterruptedException, IOException {
		ExtentReports1.createTest("clickOnNextButton");
		ReviewPageQuestions reviewPage=new ReviewPageQuestions(driver);
		Thread.sleep(4000);
		reviewPage.clickOnNextButton();
		log.info("Clicking Review page next button successfully");
		ExtentReports1.test.pass("Review page displayed & Click on Next button");
	}
	@Test(priority = 6)
	public void clickOnAssignbutton() throws InterruptedException, IOException {
		ExtentReports1.createTest("clickOnAssignbutton");
		SchedulePage schedulePage=new  SchedulePage(driver);
		Thread.sleep(15000);
		schedulePage.assigneeListDropdown();
		log.info("Select all students from assignee list");
		schedulePage.radioQuizButton("200", driver);
		log.info("Clicking Quiz radio button successfully");
		schedulePage.clickOnAssignButton();
		log.info("Clicking Schedule page Assign button");
		schedulePage.verifyTextOnAssignConfirmationBox();
		log.info("Verify Assign confirmation box test");
		schedulePage.clickOnConfirmButton();
		log.info("Click on Confirm button");
		ExtentReports1.test.pass("Schedule page clicking assign button & clicking comfirm button");
	}
	@Test(priority = 7)
	public void verifyFeedbackPage() throws InterruptedException {
		ExtentReports1.createTest("verifyFeedbackPage");
		FeedbackPage feedbackPage=new FeedbackPage(driver);
		
		feedbackPage.clickOnPDFButton(driver);
		log.info("Clicking pdf button successfully");
		Thread.sleep(2000);
		feedbackPage.pageScrollTillEnd(driver);
		log.info("Page scroll till end");
		Thread.sleep(10000);
		String par=driver.getWindowHandle();
		Set<String> popup=driver.getWindowHandles();
		driver.switchTo().window(par);
		log.info("Switching PDF window to main window");
		feedbackPage.clickOnShareButton(driver);
		log.info("Clicking share button successfully");
		feedbackPage.createAssessmentPage();
		log.info("Clicking create assessment button");
		ExtentReports1.test.pass("Click on createAssessment page & return back to assessment home page");

	}




}
