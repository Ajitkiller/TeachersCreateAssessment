package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {

	
WebDriver ldriver;
	
	public FeedbackPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Go to Dashboard')]")
	@CacheLookup
	WebElement goToDashboard;
	
	@FindBy(xpath="//a[contains(text(),'Create new Assessment')]")
	@CacheLookup
	WebElement createNewAssessment;
	
	@FindBy(xpath="//h3[@class='text-center mt-2']")
	@CacheLookup
	WebElement feedbackText;
	
	public void createAssessmentPage() 
	{
		createNewAssessment.click();
	}
	
	public void goToDashboardPage() 
	{
		goToDashboard.click();
	}
	
	public void verifyFeedbackText() 
	{
		String text=feedbackText.getText();
		if (text.equalsIgnoreCase("Please share your experience.")) {
			System.out.println("This is feedback page.");
		}
		else {
			System.out.println("This is not a feedback page.");
		}
	}
	
	
}
