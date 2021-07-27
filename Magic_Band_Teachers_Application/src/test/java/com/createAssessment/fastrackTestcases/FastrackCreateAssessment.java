package com.createAssessment.fastrackTestcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.createAssessment.fastrackPageObject.FastrackLoginPage;
import com.createAssessment.fastrackPageObject.FeedbackPage;
import com.createAssessment.fastrackPageObject.GeneralDetailsPage;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackPageObject.SchedulePage;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class FastrackCreateAssessment extends BaseClass{
	FastrackLoginPage fastrackLogin;
	GeneralDetailsPage generalPage;
	 ReviewPageQuestions reviewPage;
	 FeedbackPage feedbackPage;
	 
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
	public void clickOnCreateButton() throws InterruptedException {
		Thread.sleep(6000);
		WebElement createButton =driver.findElement(By.xpath("//a[contains(text(),'Create')]"));
		createButton.click();
		Thread.sleep(4000);
		generalPage=new GeneralDetailsPage(driver);
		System.out.println("name active");
		generalPage.inputAssessmentName("Celebration meet", driver);
		generalPage.selectBoardName();
		Thread.sleep(1000);
		generalPage.selectGrade10();
		Thread.sleep(1000);
		generalPage.selectSubjectName();
		Thread.sleep(1000);
		generalPage.selectTopic_Subtopic(driver);
		generalPage.moveDifficultyLevel(driver);
	}
	@Test(priority = 5)
	public void createTemplateFormat() throws InterruptedException 
	{
		generalPage.predefineFormat(driver);
	/*	generalPage.clickOnCreateFormat();
		Thread.sleep(2000);
		generalPage.SelectMultiChoiceType("20","3", driver);
		generalPage.SelectFIBType("20","3", driver);
		generalPage.SelectLongQuestionType("1", "3", driver);
		generalPage.SelectShortQuestionType("20", "5", driver);
		generalPage.SelectTrueOrFalseType("20", "1", driver);
		generalPage.enterFormatName("Happy format");*/
		
		generalPage.clickOnSaveButton(driver);
		System.out.println("Save button clicking successfully");
	}


	@Test(priority = 6)
	public void clickOnNextButton() throws InterruptedException 
	{
		Thread.sleep(4000);
		generalPage.clickOnNextButton();
		System.out.println("General page Next button clicking successfully");
	}
	@Test(priority = 7)
	public void clickOnSwapFunctionality() throws InterruptedException 
	{
		ReviewPageQuestions reviewPage=new ReviewPageQuestions(driver);
		Thread.sleep(5000);
		reviewPage.clickOnSwapButton(driver);
		Thread.sleep(4000);
		reviewPage.clickOnSwapButton(driver);
		System.out.println("pass swap");
	}
	@Test(priority = 8)
	public void verifyPreviewText() throws InterruptedException 
	{
		Thread.sleep(4000);
		reviewPage.clickOnPreviewButton();
		Thread.sleep(4000);
		reviewPage.verifyPreviewText();
	}
	@Test(priority = 9)
	public void verifyPreviewModelFunctionality() throws InterruptedException 
	{
		reviewPage.previewModelFunctionality(driver);
		reviewPage.clickPreviewReportButton();
		System.out.println("pass report");
		reviewPage.clickOnPreviewModelClose();
		System.out.println("pass model close");
	}
	@Test(priority = 10)
	public void verifyReportFunctionality() throws InterruptedException 
	{
		Thread.sleep(2000);
		reviewPage.clickOnPreviewButton();
		System.out.println("pass preview button");
		reviewPage.verifyReportFunctionality();
		System.out.println("pass report functionality");
		Thread.sleep(6000);
		reviewPage.clickOnNextButton();
		System.out.println("Review page Next button clicking successfully");
	}
	@Test(priority = 12)
	public void selectAssessmentType() throws InterruptedException
	{
		SchedulePage schedulePage=new SchedulePage(driver);
		Thread.sleep(15000);
		schedulePage.radioAssessmentType(driver);
		System.out.println("assessment type selected");
		schedulePage.radioQuizButton("200", driver);
		System.out.println("quiz type selected");
	}
	@Test(priority = 13)
	public void selectAssigneeList() throws InterruptedException
	{		SchedulePage schedulePage=new SchedulePage(driver);

		schedulePage.assigneeListDropdown();
		Thread.sleep(2000);
	}
	@Test(priority = 14)
	public void selectAssessmentDate() throws InterruptedException
	{		SchedulePage schedulePage=new SchedulePage(driver);

		schedulePage.enterScheduleAssessmentDate(driver);
	}
	@Test(priority = 15)
	public void selectTestInstruction() throws InterruptedException
	{
		SchedulePage schedulePage=new SchedulePage(driver);

		schedulePage.allQuestionRequiredCheckbox();
		schedulePage.dontUseCalculatorCheckbox();
		schedulePage.eachQuestionCheckbox();
	}
	@Test(priority = 16)
	public void verifyAssignButton() throws InterruptedException
	{		SchedulePage schedulePage=new SchedulePage(driver);

		schedulePage.clickOnAssignButton();
		System.out.println("Assign button clicking successfully");
	}
	@Test(priority = 17)
	public void verifyConfirmationBox() throws InterruptedException {
		SchedulePage schedulePage=new SchedulePage(driver);

		schedulePage.verifyTextOnAssignConfirmationBox();
		Thread.sleep(1000);
		schedulePage.clickOnConfirmButton();
	}
	@Test(priority = 18)
	public void verifyTextAndResultDate() throws InterruptedException, ATUTestRecorderException {
		Thread.sleep(15000);
		feedbackPage.verifyFeedbackText();
		feedbackPage.verifyResultdate();
	}
	@Test(priority = 19)
	public void clickOn_PDF_Button() throws InterruptedException
	{
		String par=driver.getWindowHandle();
		Set<String> popup=driver.getWindowHandles();
		feedbackPage.clickOnPDFButton(driver);
		driver.switchTo().window(par);
	}
	@Test(priority = 20)
	public void clickOnShareButton() throws InterruptedException
	{
		//feedbackPage.clickOnShareButton(driver);
		Thread.sleep(2000);
	}
	@Test(priority = 21)
	public void clickOnCreateAssessmentPage() throws InterruptedException, ATUTestRecorderException
	{
		feedbackPage.createAssessmentPage();
		System.out.println("Assessment created successfully");
		record.stop();
	}







}
