package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

WebDriver ldriver;
	
	public ReviewPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//h1[@id='headingText']//span")
	@CacheLookup
	WebElement gooogleUserVerificationText;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	@CacheLookup
	WebElement btnContinue;
	
	
}
