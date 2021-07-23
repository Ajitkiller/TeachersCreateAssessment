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
	
	@FindBy(xpath="//div[@class=' text-center']//p[2]")
	@CacheLookup
	WebElement textOfResultDate;
	
	@FindBy(xpath="//a[@title='Share']/..//a[@title='PDF']")
	@CacheLookup
	WebElement pdfButton;
	
	@FindBy(xpath="//a[@title='Share']/..//a[2]")
	@CacheLookup
	WebElement shareButton;
	
	@FindBy(xpath="//span[contains(text(),'Copy link')]")
	@CacheLookup
	WebElement copyLinkButton;
	
	@FindBy(xpath="//button[@class='close']")
	@CacheLookup
	WebElement linkModelClose;
	
	
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
	public void verifyResultdate() {
		
		String text = textOfResultDate.getText();
				
				if (text.contains("Results on")) {
					
					System.out.println("Feedback page result :"+text);
				}
				else {
					System.out.println("Result date not available.");
				}
				
			}
	public void clickOnPDFButton(WebDriver driver) throws InterruptedException {
		
		pdfButton.click();
		Thread.sleep(15000);
		driver.close();
		
	}
	public void clickOnShareButton() throws InterruptedException {
		
		shareButton.click();
		Thread.sleep(1000);
		copyLinkButton.click();
		Thread.sleep(3000);
		linkModelClose.click();
		
		
		
		
	}
}
