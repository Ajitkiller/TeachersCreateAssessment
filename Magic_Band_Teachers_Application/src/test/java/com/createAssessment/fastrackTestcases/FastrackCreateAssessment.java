package com.createAssessment.fastrackTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.createAssessment.fastrackPageObject.FeedbackPage;
import com.createAssessment.fastrackPageObject.GeneralDetailsPage;
import com.createAssessment.fastrackPageObject.GoogleUserVerification;
import com.createAssessment.fastrackPageObject.ReviewPageQuestions;
import com.createAssessment.fastrackPageObject.SchedulePage;


public class FastrackCreateAssessment extends BaseClass{

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
	@Test(priority = 1)
	public void clickOnCreateButton() throws InterruptedException {
		//Thread.sleep(2000);

		/*GoogleUserVerification auth=new GoogleUserVerification(driver);
		auth.verifyGoogleVerificationText();
		Thread.sleep(4000);
		auth.verifyAndContinueWithConcents(driver);

		Thread.sleep(3000);*/
		WebElement createButton =driver.findElement(By.xpath("//a[contains(text(),'Create')]"));
		createButton.click();
	
		
		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);

		generalPage.inputAssessmentName("Automation testing");
		//Thread.sleep(000);
		generalPage.selectBoardName();
		Thread.sleep(1000);
		generalPage.selectGrade10();
		Thread.sleep(1000);
		generalPage.selectSubjectName();
		Thread.sleep(1000);
		generalPage.selectTopic_Subtopic(driver);
		
		Thread.sleep(4000);
		generalPage.moveDifficultyLevel(driver);
		
		
	}
	@Test(priority = 2)
	public void createTemplateFormat() {

		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		generalPage.clickOnCreateFormat();

		generalPage.SelectMultiChoiceType("20","3", driver);
		generalPage.SelectFIBType("20","3", driver);
		generalPage.SelectLongQuestionType("1", "3", driver);
		generalPage.SelectShortQuestionType("20", "5", driver);
		generalPage.SelectTrueOrFalseType("20", "1", driver);
		generalPage.enterFormatName("Test 11");
		generalPage.clickOnSaveButton(driver);
		System.out.println("Save button clicking successfully");
	}

	@Test(priority = 3)
	public void clickOnNextButton() throws InterruptedException {

		GeneralDetailsPage generalPage=new GeneralDetailsPage(driver);
		Thread.sleep(2000);
		generalPage.clickOnNextButton();
		System.out.println("General page Next button clicking successfully");
	}

//	@Test(priority = 4)
	public void openSchedulePage() throws InterruptedException 
	{
		ReviewPageQuestions reviewPage=new ReviewPageQuestions(driver);
		Thread.sleep(5000);
		reviewPage.clickSwapButton();
	//	reviewPage.clickOnNextButton();
		System.out.println("Review page Next button clicking successfully");
	}

//	@Test(priority = 5)
	public void verifySchedulePage() throws InterruptedException
	{
		SchedulePage schedulePage=new SchedulePage(driver);
		Thread.sleep(15000);

		schedulePage.radioAssessmentType(driver);
		System.out.println("assessment type selected");
		schedulePage.radioQuizButton("200", driver);
		System.out.println("quiz type selected");

		schedulePage.assigneeListDropdown();
		schedulePage.allQuestionRequiredCheckbox();
		schedulePage.dontUseCalculatorCheckbox();
		schedulePage.eachQuestionCheckbox();
		schedulePage.clickOnAssignButton();
		System.out.println("Assign button clicking successfully");
	}

//	@Test(priority = 6)
	public void clickOnConfirmButton() throws InterruptedException {
		SchedulePage schedulePage=new SchedulePage(driver);
		Thread.sleep(1000);
		schedulePage.clickOnConfirmButton();

	}

	//@Test(priority = 7)
	public void verifyFeedbackPage() throws InterruptedException {
		FeedbackPage feedbackPage=new FeedbackPage(driver);
		Thread.sleep(15000);
		feedbackPage.verifyFeedbackText();
		feedbackPage.createAssessmentPage();


	}







}
