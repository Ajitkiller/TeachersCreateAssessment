package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage {

WebDriver ldriver;
	
	public SchedulePage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//button[@title='Assignee List']")
	@CacheLookup
	WebElement btnAssignList;
	
	@FindBy(xpath="//*[@id=\"scheduleDiv\"]/div/div[1]/div/div/span/div[2]/div/button[1]/span/label")
	@CacheLookup
	WebElement selectAllStudents;
	
	@FindBy(xpath="//input[@id='customCheck101']")
	@CacheLookup
	WebElement radioQuizType;
	
	@FindBy(xpath="//input[@name='schedule_minutes']")
	@CacheLookup
	WebElement inputDuration;
	
	@FindBy(xpath="//input[@id='customCheck102']")
	@CacheLookup
	WebElement radioAssessmentType;
	
	@FindBy(xpath="//input[@id='test-schedule-date']")
	@CacheLookup
	WebElement testScheduleDate;
	
	@FindBy(xpath="//input[@id='test-due-date']")
	@CacheLookup
	WebElement testDueDate;
	
	@FindBy(xpath="//input[@id='test-published-on']")
	@CacheLookup
	WebElement testPublishDate;
	
	@FindBy(xpath="//html[@dir='ltr']/body")
	@CacheLookup
	WebElement testInstructionInputArea;
	
	@FindBy(xpath="//label[@for='questionsCheck']")
	@CacheLookup
	WebElement checkAllQuestionsAreRequired;
	
	@FindBy(xpath="//label[@for='dontUseCalculator']")
	@CacheLookup
	WebElement checkDontUseCalculator;
	
	@FindBy(xpath="//label[@for='eachQuestion']")
	@CacheLookup
	WebElement checkEachQuestion;
	
	@FindBy(xpath="//button[@id='assign']")
	@CacheLookup
	WebElement assignButton;
	
	@FindBy(xpath="//button[@id='schedulePreviousTab']")
	@CacheLookup
	WebElement previousButton;
	
	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	@CacheLookup
	WebElement confirmButton;
	
	@FindBy(xpath="//button[@id='close-confirm']")
	@CacheLookup
	WebElement cancelButton;
	
	@FindBy(xpath="//div[@class='modal-body']//h5")
	@CacheLookup
	WebElement confirmBoxText;
	
	
	
	
	public void assigneeListDropdown() {
		btnAssignList.click();
		selectAllStudents.click();
		btnAssignList.click();
	}
	
	public void radioQuizButton(String enterNum, WebDriver driver) {
		//radioQuizType.click();
		Actions act =  new Actions(driver);
		act.moveToElement(radioQuizType).click().perform();

		inputDuration.sendKeys(enterNum);
	}
	
	
	public void radioAssessmentType(WebDriver driver) {
		//radioAssessmentType.click();
		Actions act =  new Actions(driver);
		act.moveToElement(radioAssessmentType).click().perform();

	}
	
	public void enterTestScheduleDate() {
		testScheduleDate.sendKeys();
	}
	
	public void enterDueDate() {
		testDueDate.click();
	}
	
	public void enterPublishDate() {
		testPublishDate.click();
	}
	
	public void enterTestInstruction(String text) {
		testInstructionInputArea.sendKeys(text);
	}
	
	public void allQuestionRequiredCheckbox() {
		checkAllQuestionsAreRequired.click();
	}
	
	public void dontUseCalculatorCheckbox() {
		checkDontUseCalculator.click();
	}
	
	public void eachQuestionCheckbox() {
		checkEachQuestion.click();
	}
	
	public void clickOnAssignButton() {
		assignButton.click();
	}
	
	public void clickOnPreviousButton() {
		previousButton.click();
	}
	
	public void clickOnConfirmButton() {
		
		
		confirmButton.click();
	}
	
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	
	public void enterScheduleAssessmentDate(WebDriver driver) 
	{
		testScheduleDate.clear();
		testScheduleDate.sendKeys("Mon, Jul 26, 14:00 PM");
		//testScheduleDate.sendKeys(Keys.TAB);
		testDueDate.clear();
		testDueDate.sendKeys("Tue, Jul 27, 18:00 PM");
		testDueDate.sendKeys(Keys.TAB);
		testPublishDate.clear();
		testPublishDate.sendKeys("Thu, Jul 29, 20:00 PM");
		testPublishDate.sendKeys(Keys.TAB);
	}
	
	public void verifyTextOnAssignConfirmationBox() {
		
		String text = confirmBoxText.getText();
		
		if (text.equalsIgnoreCase("Are you sure you want to Assign the assessment?")) {
			
			System.out.println("Confirmation text is correct");
		}
		else {
			
			System.out.println("Confirmation text is wrong");
		}
	}
	
	
	
	
	
	
	
}
