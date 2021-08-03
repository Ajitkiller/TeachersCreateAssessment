package com.createAssessment.fastrackPageObject;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageQuestions {

WebDriver ldriver;
	
	public ReviewPageQuestions(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Previous')]")
	@CacheLookup
	WebElement previousButton;
	
	@FindBy(xpath="//button[@id='scheduleTab']")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(xpath="//button[@data-questionnumber='1']//i")
	@CacheLookup
	WebElement swapButton;
	
	@FindBy(xpath="//button[@data-id='1']//i")
	@CacheLookup
	WebElement previewButton;
	
	public void clickOnPreviousButton() {
		
		previousButton.click();	
	}
	
	public void clickOnNextButton() {
		
		nextButton.click();	
	}
	
	public void clickOnSwapButton(WebDriver driver) {
		
		//swapButton.click();	
		try {
			WebElement swapButton = driver.findElement(By.xpath("//button[@data-questionnumber='1']//i"));
			swapButton.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement swapButton = driver.findElement(By.xpath("//button[@data-questionnumber='1']//i"));
			swapButton.click();
		}
		
	}
	
	public void clickOnPreviewButton(WebDriver driver) {
		
			
		try {
			WebElement swapButton = driver.findElement(By.xpath("//button[@data-id='1']//i"));
			swapButton.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement swapButton = driver.findElement(By.xpath("//button[@data-id='1']//i"));
			swapButton.click();
		}
	}
	
	// Preview section Elements list.
	
	@FindBy(xpath="//div[@id='preview']//div//div//div//h4")
	@CacheLookup
	WebElement textPreview;
	
	@FindBy(xpath="//div[@id='preview']//div//div//div//div//div//button//i[@data-original-title='Swap']")
	@CacheLookup
	WebElement btnPreviewSwap;
	
	@FindBy(xpath="//div[@id='preview']//div//div//div//div//div//button//i[@data-original-title='Report']")
	@CacheLookup
	WebElement btnPreviewReport;
	
	@FindBy(xpath="//div[@id='preview']//div//div//div//div//div//button//i[@class='fa  fa-caret-left']")
	@CacheLookup
	WebElement btnPreviewLeftQuestion;
	
	@FindBy(xpath="//div[@id='preview']//div//div//div//div//div//button//i[@class='fa  fa-caret-right']")
	@CacheLookup
	WebElement btnPreviewRightQuestion;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	@CacheLookup
	WebElement previewCloseBtn;
	
	public void verifyPreviewText() {
		
		String text=textPreview.getText();	
		
		if (text.contains("Preview")) {
			System.out.println("This is preview model text");
		}
		else {
			System.out.println("This is not preview model text");
		}
		
	}
	
	public void previewModelFunctionality(WebDriver driver) throws InterruptedException {
		
		btnPreviewSwap.click();	
		Thread.sleep(4000);
		for (int i = 0; i < 3; i++) {
			try {
				WebElement btnPreviewRightQuestion = driver.findElement(By.xpath("//div[@id='preview']//div//div//div//div//div//button//i[@class='fa  fa-caret-right']"));
				btnPreviewRightQuestion.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement btnPreviewRightQuestion = driver.findElement(By.xpath("//div[@id='preview']//div//div//div//div//div//button//i[@class='fa  fa-caret-right']"));
				btnPreviewRightQuestion.click();
			}
			
			System.out.println("Move to right next question");
			Thread.sleep(2000);
			
			btnPreviewSwap.click();
			Thread.sleep(3000);
		}
		for (int i = 2; i < 3; i++) {
			btnPreviewLeftQuestion.click();
			System.out.println("Move to Left before question");
			Thread.sleep(2000);
			btnPreviewSwap.click();
			Thread.sleep(3000);
		}
		
	}
	
	
	
	public void clickPreviewReportButton() throws InterruptedException {
		
		btnPreviewReport.click();	
		Thread.sleep(2000);
	}
	
	public void clickOnPreviewModelClose() throws InterruptedException {
		
		//btnPreviewReport.click();	
		Thread.sleep(2000);
		btnReport.click();
		Thread.sleep(2000);
		if (btnReport.isEnabled()) {
			System.out.println("Report button is enable");
		}
		
		else {
			System.out.println("Test fail");
			System.out.println("Report button is disable because without enter options clicking report button..");
		}
		
		Thread.sleep(1000);
		previewCloseBtn.click();

	}
	
	//types of report element in report field.
	
	@FindBy(xpath="//input[@id='customCheckmJaeCq95']/..//label")
	@CacheLookup
	WebElement checkQuestionIncorrectReport;
	
	@FindBy(xpath="//input[@id='customCheckQejtm3hh']/..//label")
	@CacheLookup
	WebElement checkAnswerIsIncorrectReport;
	
	@FindBy(xpath="//input[@id='customCheckXcjmE6ah']/..//label")
	@CacheLookup
	WebElement checkAnswerChoiceIsIncorrectReport;
	
	@FindBy(xpath="//input[@id='customCheckUhif5cdC']/..//label")
	@CacheLookup
	WebElement CheckIssueWithDiagramReport;
	
	@FindBy(xpath="//input[@id='customCheckbmpvIIa7']/..//label")
	@CacheLookup
	WebElement CheckOtherReport;
	
	@FindBy(xpath="//button[contains(text(),'Report')]")
	@CacheLookup
	WebElement btnReport;
	
	@FindBy(xpath="//div[contains(text(),'The question has been reported successfully.')]")
	@CacheLookup
	WebElement afterReportText;
	
	
	public void verifyReportFunctionality() throws InterruptedException 
	{
		
	
		
		btnPreviewReport.click();	
		Thread.sleep(2000);
		checkQuestionIncorrectReport.click();
		checkAnswerIsIncorrectReport.click();
		checkAnswerChoiceIsIncorrectReport.click();
		CheckIssueWithDiagramReport.click();
		CheckOtherReport.click();
		Thread.sleep(2000);
		btnReport.click();
		Thread.sleep(2000);
		
		String Expected="The question has been reported successfully.";
		String Actual =afterReportText.getText();
		if (Actual.equalsIgnoreCase(Expected)) {
			System.out.println(" Report error message is correct");
		}
		else {
			System.out.println("Report error message is wrong.");
		}
		
		previewCloseBtn.click();
	}
	
	public void pageScrollByPixel(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		 js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void pageScrollTillEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}
