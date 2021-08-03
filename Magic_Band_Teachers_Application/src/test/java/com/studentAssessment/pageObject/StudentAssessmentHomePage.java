package com.studentAssessment.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAssessmentHomePage {
WebDriver ldriver;
	
	public StudentAssessmentHomePage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[@id='in-progress-tab']")
	@CacheLookup
	WebElement assignedTab;
	
	@FindBy(xpath="//a[@id='attempted-tab']")
	@CacheLookup
	WebElement doneTab;
	
	@FindBy(xpath="//a[@id='missing-tab']")
	@CacheLookup
	WebElement missingTab;
	
	@FindBy(xpath="//a[@id='upcoming-tab']")
	@CacheLookup
	WebElement upcomingTab;
	
	public void clickOnAssignedTab() 
	{		
		assignedTab.click();
	}
	public void clickOnDoneTab() 
	{		
		doneTab.click();
	}
	public void clickOnMissingTab() 
	{		
		missingTab.click();
	}
	public void clickOnUpcomingTab() 
	{		
		upcomingTab.click();
	}
	
	
	//Assessment link is attached with every start button.
	@FindBy(xpath="//a[@href='https://magicband-test.azurewebsites.net/students/instructions/e7aa4937-9b1e-42db-9792-ad780063ccb3' and contains(text(),'Start')]")
	@CacheLookup
	WebElement assessmentStartButton;
	
	@FindBy(xpath="//a[@href='https://magicband-test.azurewebsites.net/students/instructions/e7aa4937-9b1e-42db-9792-ad780063ccb3' and contains(text(),'Start')]")
	@CacheLookup
	WebElement secondStartButton;
	
	
	public void clickOnStartButton() {
		
		assessmentStartButton.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
