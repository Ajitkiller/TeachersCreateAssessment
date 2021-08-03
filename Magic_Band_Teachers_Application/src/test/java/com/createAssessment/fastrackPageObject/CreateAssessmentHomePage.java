package com.createAssessment.fastrackPageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.createAssessment.fastrackTestcases.BaseClass;
import com.report.extentReport.ExtentReports1;

public class CreateAssessmentHomePage {
	BaseClass bc;
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
	
	
	public void SelectGradeFilter(int i)
	{
		Select s1=new Select(subjectFilter);
		s1.deselectByIndex(i);
	}
	@FindBy(xpath="//a[contains(text(),'GOKsTrUjxgTXFwA ')]")
	@CacheLookup
	WebElement AssessmentName;
	
	@FindBy(xpath="//*[@id=\"card-list\"]/div[1]/div/div/div[1]/div[2]/div/div[2]")
	@CacheLookup
	WebElement templateDetails;
	
	@FindBy(xpath="//*[@id='card-list']//div[1]//div//div//div[1]//div[2]//div//a")
	@CacheLookup
	WebElement assignButton;
	public void selectAssessment(WebDriver driver) throws InterruptedException, IOException {
		if (AssessmentName.isDisplayed()) {
			System.out.println("Assessment is available in create assesment home page.");
			
			Actions act=new Actions(driver);
			act.moveToElement(templateDetails).build().perform();
			bc=new BaseClass();
			Thread.sleep(5000);
			ExtentReports1.test.pass("Assessment ");
		}
		else {
			ExtentReports1.createTest("selectAssessment");
			ExtentReports1.screenshot();
			
		}
				
	}
	public void clickOnAssignButton() {
		
		assignButton.click();
		
		
		
	}
	
	
	
}
