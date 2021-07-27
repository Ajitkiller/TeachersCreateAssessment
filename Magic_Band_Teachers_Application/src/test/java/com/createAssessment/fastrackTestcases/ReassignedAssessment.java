package com.createAssessment.fastrackTestcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.createAssessment.fastrackPageObject.CreateAssessmentHomePage;
import com.createAssessment.fastrackPageObject.FastrackLoginPage;
import com.createAssessment.fastrackPageObject.FeedbackPage;
import com.createAssessment.fastrackPageObject.GeneralDetailsPage;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackPageObject.SchedulePage;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ReassignedAssessment extends BaseClass{



	@Test
	public void fastrackLogin() throws InterruptedException, ATUTestRecorderException 
	{
		record=new ATUTestRecorder("./logs", "Sat-24-Jul", false);
		record.start();
		driver.manage().deleteAllCookies();
		driver.get(readconfig.getBaseurl());
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}
	@Test(priority = 1)
	public void clickOnLoginButton() throws InterruptedException
	{
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
	}
	@Test(priority = 2)
	public void enterUsername() throws InterruptedException
	{
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		emailId.sendKeys("teacher1@webcraft.co.in");
		WebElement nextButton =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();
	}
	@Test(priority = 3)
	public void enterPassword() throws InterruptedException
	{
		WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Vision2020");
		Thread.sleep(2000);
		WebElement nextButton2 =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton2.click();

	}

	@Test(priority = 4)
	public void selectAssignedAssessment() throws InterruptedException 
	{
		CreateAssessmentHomePage homeAssessment=new CreateAssessmentHomePage(driver);
		Thread.sleep(3000);
		homeAssessment.selectAssessment(driver);
		homeAssessment.clickOnAssignButton();

	}

	@Test(priority = 5)
	public void clickOnNextButton() throws InterruptedException {
		ReviewPageQuestions reviewPage=new ReviewPageQuestions(driver);
		Thread.sleep(4000);
		reviewPage.clickOnNextButton();


	}
	@Test(priority = 6)
	public void clickOnAssignbutton() throws InterruptedException {
		SchedulePage schedulePage=new  SchedulePage(driver);
		Thread.sleep(15000);
		schedulePage.radioQuizButton("200", driver);
		schedulePage.assigneeListDropdown();
		schedulePage.clickOnAssignButton();
		schedulePage.verifyTextOnAssignConfirmationBox();
		schedulePage.clickOnConfirmButton();

	}
	@Test(priority = 7)
	public void verifyFeedbackPage() throws InterruptedException {
		FeedbackPage feedbackPage=new FeedbackPage(driver);
		feedbackPage.clickOnPDFButton(driver);
		Thread.sleep(2000);
		feedbackPage.pageScrollTillEnd(driver);
		Thread.sleep(10000);
		String par=driver.getWindowHandle();
		Set<String> popup=driver.getWindowHandles();
		driver.switchTo().window(par);
		feedbackPage.clickOnShareButton(driver);
		feedbackPage.createAssessmentPage();


	}




}
