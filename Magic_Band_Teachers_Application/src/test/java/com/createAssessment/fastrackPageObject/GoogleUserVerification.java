package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleUserVerification {
	
WebDriver ldriver;
	
	public GoogleUserVerification(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//h1[@id='headingText']//span")
	@CacheLookup
	WebElement gooogleUserVerificationText;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	@CacheLookup
	WebElement btnContinue;
	
	// magicband-test.azurewebsites.net wants access to your Google Account
	
	@FindBy(xpath="//h1[@id='headingText']//span//div")
	@CacheLookup
	WebElement magicbandSignInDetails;
	
	
	@FindBy(xpath="//div[contains(text(),'Sign in with Google')]")
	@CacheLookup
	WebElement signInWithGoogle;
	
	@FindBy(xpath="//input[@id='i3']")
	@CacheLookup
	WebElement concentsOne;
	
	@FindBy(xpath="//input[@id='i6']")
	@CacheLookup
	WebElement concentsTwo;
	
	@FindBy(xpath="//input[@id='i9']")
	@CacheLookup
	WebElement concentsThree;
	
	@FindBy(xpath="//input[@id='i12']")
	@CacheLookup
	WebElement concentsFour;
	
	@FindBy(xpath="//input[@id='i15']")
	@CacheLookup
	WebElement concentsFive;
	
	@FindBy(xpath="//input[@id='i18']")
	@CacheLookup
	WebElement concentsSix;
	
	@FindBy(xpath="//input[@id='i21']")
	@CacheLookup
	WebElement concentsSeven;
	
	@FindBy(xpath="//input[@id='i24']")
	@CacheLookup
	WebElement concentsEight;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement btnCancel;
	
	
	public void verifyGoogleVerificationText() {
		
		String Actual=gooogleUserVerificationText.getText();
		String Expected= "Google hasn’t verified this app";
		
		if (Actual.equalsIgnoreCase(Expected)) {
			
			btnContinue.click();
			
		}
		
	}
	
	public void verifyAndContinueWithConcents(WebDriver driver) throws InterruptedException
	{
		
		String Actual=signInWithGoogle.getText();
		String Expected= "sign in with google";
		System.out.println(Actual);
		if (Actual.equalsIgnoreCase(Expected)) {
			Thread.sleep(3000);
			
				concentsOne.click();
			
				concentsTwo.click();
			
				concentsThree.click();
			
				concentsFour.click();
			
				concentsFive.click();
			
				concentsSix.click();
			
				concentsSeven.click();
			
				concentsEight.click();

			
			try {
			    WebElement continueBtn = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
			    continueBtn.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
			    WebElement continueBtn = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
			    continueBtn.click();
			}
			
			
			
			
		}
		
		
	}
	
	
	
}
