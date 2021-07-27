package com.createAssessment.fastrackTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.createAssessment.fastrackPageObject.GeneralDetailsPage;
import com.createAssessment.fastrackPageObject.NotificationErrorValidation;

public class FastrackNotification extends BaseClass {

	
	//Fastrack Teachers login process.
	
	@Test
	public void fastrackLogin() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get(readconfig.getBaseurl());
		
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
		
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.sendKeys("teacher1@webcraft.co.in");
		WebElement nextButton =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();
		
		WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Vision2020");
		Thread.sleep(2000);
		WebElement nextButton2 =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton2.click();
	}
	//After Magic band Teachers Login create assessment page is displayed
	//Click on create button from fastrack test format.
	@Test(priority = 1)
	public void clickOnCreateButton() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement createButton =driver.findElement(By.xpath("//a[contains(text(),'Create')]"));
		createButton.click();
		
	}
	
	//Repetitive Question type in test format: 2
	//Only 2 sets of one question type are allowed.
	
	@Test(priority = 2)
	public void verifyTwoSetOfQuestionType() throws InterruptedException {
		
		Thread.sleep(4000);
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		generalPage.clickOnCreateFormat();
		generalPage.SelectFIBType("30", "1", driver);
		generalPage.SelectFIBType("20", "2", driver);
		generalPage.SelectFIBType("25", "1", driver);
		generalPage.SelectFIBType("35", "2", driver);
		generalPage.enterFormatName("123566");
		generalPage.clickOnSaveButton(driver);
		Thread.sleep(2000);
		NotificationErrorValidation validate=new NotificationErrorValidation(driver);
		validate.verifyAlertMessage();
		validate.verifyTwoSetOfFormat();
		GeneralDetailsPage gen=new GeneralDetailsPage(driver);
		gen.delete1stQuestionType(driver);
		gen.delete1stQuestionType(driver);
		Thread.sleep(5000);
		generalPage.clickOnSaveButton(driver);
	}
	
	
	// Format Name Word Limit: 20 characters 
	//Maximum 20 characters are allowed.
	//Duplicate format Name
	
	@Test(priority = 3)
	public void verifyFormatNameCharLimit() throws InterruptedException {
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		Thread.sleep(4000);
		generalPage.clickOnCreateFormat();
		generalPage.SelectFIBType("30", "1", driver);
		Thread.sleep(2000);
		generalPage.enterFormatName("Only two set of format");
		generalPage.clickOnSaveButton(driver);
		NotificationErrorValidation validate=new NotificationErrorValidation(driver);
		generalPage.enterFormatName("only 20 char supp");
		System.out.println("Format name is under 20 character");
		Thread.sleep(2000);
		generalPage.clickOnSaveButton(driver);
		validate.verifyAlertMessage();
		validate.verifyDuplicateFormatName();
		Thread.sleep(3000);
		generalPage.enterFormatName("102Test");
		System.out.println("Format name is changed ");
		generalPage.clickOnSaveButton(driver);
		System.out.println("New format created");
	}
	
	//Marks per question max count: 50 
	//Maximum 50 points allowed.

	
	@Test(priority = 4)
	public void verifyMaxPointLimit() throws InterruptedException {
		
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		Thread.sleep(4000);
		generalPage.clickOnCreateFormat();
		generalPage.SelectFIBType("30", "1", driver);
		generalPage.enterNumber("52");
		generalPage.clickOnSaveButton(driver);
		NotificationErrorValidation validate=new NotificationErrorValidation(driver);
		validate.verifyMaxPointsPerQuestion();
		validate.requiredFieldText();
		Thread.sleep(2000);
		generalPage.enterFormatName("1000254");
		Thread.sleep(3000);
		generalPage.enterNumber("2");
		generalPage.clickOnSaveButton(driver);
		
	}
	//Questions per each Question type max count: 200
	//Maximum 200 questions for each question type are allowed. 
	
	@Test(priority = 5)
	public void verifyMaxCountLimit() throws InterruptedException {
		
	GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
	Thread.sleep(4000);
	generalPage.clickOnCreateFormat();
	generalPage.SelectFIBType("30", "1", driver);
	Thread.sleep(2000);
	generalPage.enterCount("210");
	generalPage.clickOnSaveButton(driver);
	NotificationErrorValidation validate=new NotificationErrorValidation(driver);
	validate.verifyMaxCountPerQuestions();
	Thread.sleep(3000);
	generalPage.enterCount("200");
	generalPage.enterFormatName("Test10421");
	generalPage.clickOnSaveButton(driver);
	
	}
	
	
	//Max 200 questions per test format
	//You are allowed to add a maximum of 200 questions.

@Test(priority = 6)
	public void verifyTotalQuestionCountLimitForTestFormat() throws InterruptedException {
		
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		Thread.sleep(4000);
		generalPage.clickOnCreateFormat();
		generalPage.SelectFIBType("30", "1", driver);
		generalPage.SelectLongQuestionType("50", "1", driver);
		generalPage.SelectShortQuestionType("30", "1", driver);
		generalPage.SelectTrueOrFalseType("30", "1", driver);
		generalPage.SelectMultiChoiceType("30", "1", driver);
		generalPage.SelectFIBType("40", "1", driver);
		Thread.sleep(6000);
		generalPage.enterFormatName("Test105125");
		generalPage.clickOnSaveButton(driver);
		NotificationErrorValidation validate=new NotificationErrorValidation(driver);
		validate.verifyMaxCountPerTestFormat();
		generalPage.delete1stQuestionType(driver);
		Thread.sleep(2000);
		generalPage.clickOnSaveButton(driver);
		
	}
	
	@Test(priority = 7)
	public void verifyQuestionNotAvailableErrorMessage() throws InterruptedException
	{
		Thread.sleep(3000);
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		generalPage.inputAssessmentName("Error message", driver);
		generalPage.selectBoardName();
		generalPage.selectGrade9();
		generalPage.selectSubjectName();
		generalPage.selectTopic_Subtopic(driver);
		NotificationErrorValidation validate=new NotificationErrorValidation(driver);
		validate.noQuestionAvailableError();
		generalPage.clickOnNextButton();
	}
	
	
	
	
	
	
	
	
	
}
