package com.createAssessment.fastrackPageObject;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NotificationErrorValidation {

	
WebDriver ldriver;
	
	public NotificationErrorValidation(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='text-danger error-msg']")
	@CacheLookup
	WebElement errorMax20CharFormatName;
	
	
	@FindBy(xpath="//div[contains(text(),'Alert')]")
	@CacheLookup
	WebElement alertMessage;
	
	@FindBy(xpath="//div[contains(text(),'Duplicate assignment format name')]")
	@CacheLookup
	WebElement duplicateFormatName;
	
	
	@FindBy(xpath="//div[contains(text(),'Only 2 sets of one question type are allowed.')]")
	@CacheLookup
	WebElement TwoFormatOnly;
	
	@FindBy(xpath="//div[contains(text(),'Required field.')]")
	@CacheLookup
	WebElement formatRequiredField;
	
	@FindBy(xpath="//div[contains(text(),'Minimum 1 and Maximum 50 points allowed.')]")
	@CacheLookup
	WebElement pointsPerQuestion;
	
	@FindBy(xpath="//div[contains(text(),'You are allowed to add a maximum of 200 questions.')]")
	@CacheLookup
	WebElement max200Questions;
	
	@FindBy(xpath="//div[contains(text(),'You are allowed to add a maximum of 200 questions.')]")
	@CacheLookup
	WebElement max200QuestionsForTest;
	
	
	@FindBy(xpath="//div[@id='toast-container']//div//div[2]")
	@CacheLookup
	WebElement noQuestionAvailableErrorMessage;
	
	
	
	public void formatNameCharLimit() {
		
	
	String errorText = errorMax20CharFormatName.getText();
	String Expected="Maximum 20 characters are allowed. ";
	if (errorText.equalsIgnoreCase(Expected)) {
		
		System.out.println(errorText);
		System.out.println("Format name is under or equal to 20 character");
	}
	else
		System.out.println("Format name is more than 20 character");
	
	}
	
	public void verifyAlertMessage() {
		
		String type= alertMessage.getText();
		System.out.println("Message type is :"+ type);
		
		
	}
	 
	
	 public void verifyDuplicateFormatName() {
			
			String Actual=duplicateFormatName.getText();
			String Expected="Duplicate assignment format name";
			if (Actual.equalsIgnoreCase(Expected)) {
				System.out.println("Duplicate format name, Please remove");
			}
			
			
		}
	
	
	 public void verifyTwoSetOfFormat() {
		 
		 String Actual=TwoFormatOnly.getText();
			String Expected="Only 2 sets of one question type are allowed.";
			System.out.println(Actual);
		 if (Actual.equalsIgnoreCase(Expected)) {
			
			 System.out.println("Only 2 sets of one question type are allowed.");
		}
	 }
	
	
	public void requiredFieldText() {
		String text=formatRequiredField.getText();
		System.out.println("Text is :"+text);
		
		
		if (text.equalsIgnoreCase("Required field.")) {
			System.out.println("message is display under the template format name");
		}
		else {
			System.out.println("Required field message is not available");
		}
	}
	
	public void verifyMaxPointsPerQuestion() {
		
	String text=pointsPerQuestion.getText();
	if (text.contains("Maximum 50 points allowed.")) {
		System.out.println("Correct error message is displayed");
	}
	else {
		System.out.println("Error message is wrong");
	}
		
		
	}
	
	public void verifyMaxCountPerQuestions() {
		
		String text=max200Questions.getText();
				if (text.contains("Maximum 200 questions for each question type are allowed")) {
					System.out.println("Correct error message is displayed for counts per questions");
				}
				else {
					System.out.println("Error message is wrong- counts per question.");
				}
	}
	
	public void verifyMaxCountPerTestFormat() {
		
		String text=max200QuestionsForTest.getText();
				if (text.contains("You are allowed to add a maximum of 200 questions")) {
					System.out.println("Correct error message - Max 200 questions per test format");
				}
				else {
					System.out.println("Error message is wrong- Max 200 questions per test format.");
				}
	}
	
	public void noQuestionAvailableError()
	{
		String text = noQuestionAvailableErrorMessage.getText();
		if (text.contains(" Oops! Maximum Questions are available for selected filters in the question bank. Please create a new assessment format.")) {
			System.out.println("Correct error message -Question not available in Question bank");
		}
		else {
			System.out.println("Error message is wrong- MQuestion not available in Question bank");
		}
		
		
	}
	
	
	
	
	
}
