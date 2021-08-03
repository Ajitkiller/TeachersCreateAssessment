package com.studentAssessment.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestExperiencePage {

	WebDriver ldriver;
	
	public TestExperiencePage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Report Error')]")
	@CacheLookup
	WebElement reportErrorButton;
	
	@FindBy(xpath="//span[contains(text(),' Bookmark')]")
	@CacheLookup
	WebElement bookmarkButton;
	
	@FindBy(xpath="//span[contains(text(),'Clear Answer')]")
	@CacheLookup
	WebElement clearAnswerButton;
	
	@FindBy(xpath="//button[@class='btn btn-outline-primary-v2 btn-lg mr-2 pull-right clock active']")
	@CacheLookup
	WebElement timerButoon;
	
	@FindBy(xpath="//button[@data-original-title='Font Resize']")
	@CacheLookup
	WebElement fontSizeButton;
	
	@FindBy(xpath="//span[contains(text(),' Question Paper')]")
	@CacheLookup
	WebElement viewQuestionPaper;
	
	@FindBy(xpath="//div[@id='full-paper']//div//div//div//button")
	@CacheLookup
	WebElement QuestPaperCloseButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary-v2 btn-lg pull-right finishBtn SubmitAndReviewScreen']")
	@CacheLookup
	WebElement finishButton;
	
	//This is review page header Submit button
	@FindBy(xpath="//div[@class='header-right']//div//button[3]")
	@CacheLookup
	WebElement submitButton;
	
	//This is confirmation submit button, which is displayed after clicking Submit button.
	@FindBy(xpath="//div[@class='modal-body']//button[contains(text(),'Submit')]")
	@CacheLookup
	WebElement confSubmitButton;
	
	@FindBy(xpath="//div[@id='confirm']//div//div//h5")
	@CacheLookup
	WebElement submitAssessmentText;
	
	@FindBy(xpath="//button[contains(text(),'View Assessment Instructions')]")
	@CacheLookup
	WebElement viewAssessmentInstruction;
	
	@FindBy(xpath="//div[@id='tool-modal']//div//div//div//button")
	@CacheLookup
	WebElement viewAsseInstruCloseButton;
	
	@FindBy(xpath="//button[@class='btn btn-outline-primary uploadGlobalFileBtn  btn-block mb-3']")
	@CacheLookup
	WebElement addAttachments;
	
	@FindBy(xpath="//select[@class='form-control select-legend select-attempted-type']")
	@CacheLookup
	WebElement allQuestions;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(xpath="//button[contains(text(),'Previous')]")
	@CacheLookup
	WebElement previousButton;
	
	public void clickOnReportQuestion()
	{
		reportErrorButton.click();
	}
	public void clickOnBookmark()
	{
		bookmarkButton.click();
	}
	public void clickOnClearAnswer()
	{
		clearAnswerButton.click();
	}
	public void clickOnTimerButton()
	{
		timerButoon.click();
	}
	public void clickOnAssessmentInstruction() {
		
		viewAssessmentInstruction.click();
		
	}
	public void clickOnAssessmentCloseButton()
	{
		viewAsseInstruCloseButton.click();
	}
	
	public void viewQuestionPaper()
	{
		viewQuestionPaper.click();
	}
	public void clickOnQuestionPaperCloseButton()
	{
		QuestPaperCloseButton.click();
	}
	public void clickNextButton()
	{
		nextButton.click();
	}
	public void clickPreviousButton()
	{
		previousButton.click();
	}
	
	public void clickOnFinishButton() {
		finishButton.click();
	}
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	
	public void clickOnConfirmationSubmitButton() {
		confSubmitButton.click();
	}
	public void clickOnConfirmationCancelButton() {
		submitButton.click();
	}
	
	public void verifySubmitText() {
		String text=submitAssessmentText.getText();
		if (text.equalsIgnoreCase("Are you sure you want to submit the assessment?")) {
			System.out.println("Confirmation text is correct");
		}
		else {
			System.out.println("Confirmation text is not matching with spec doc.");
		}
	}
	
	
	
	
	
	
	
	
}
