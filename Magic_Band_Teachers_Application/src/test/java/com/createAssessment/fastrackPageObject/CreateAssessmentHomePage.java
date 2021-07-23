package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAssessmentHomePage {

WebDriver ldriver;
	
	public CreateAssessmentHomePage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='icon-box']/h5")
	@CacheLookup
	WebElement fastrackText;
	
	@FindBy(xpath="//div[@class='icon-box']/p")
	@CacheLookup
	WebElement fractrakParagraph;
	

	public void VerifyFastrackText()
	{
		fastrackText.getText();
	}
	
	public void enterPassword()
	{
		fractrakParagraph.getText();
	}
	
	@FindBy(xpath="//a[contains(text(),'Create')]")
	@CacheLookup
	WebElement createButton;
	
	@FindBy(xpath="//a[contains(text(),'Assign')]")
	@CacheLookup
	WebElement assignButton;
	
	@FindBy(xpath="//div[contains(text(),'Filter by Subject')]")
	@CacheLookup
	WebElement subjectFilter;
	
	@FindBy(xpath="//div[contains(text(),'Filter by Grade')]")
	@CacheLookup
	WebElement GradeFilter;
	
	public void clickOnCreateButton()
	{
		fractrakParagraph.click();
	}
	public void clickOnAssignButton()
	{
		assignButton.click();
	}
	
	public void SelectGradeFilter(int i)
	{
		Select s1=new Select(subjectFilter);
		s1.deselectByIndex(i);
	}
	
	
	
	
	
}
