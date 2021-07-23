package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FastrackLoginPage {

WebDriver ldriver;
	
	public FastrackLoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create')]")
	@CacheLookup
	WebElement createButton;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath="//input[@id='identifierId']")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	@CacheLookup
	WebElement passCheckbox;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	public void clickCreateButton()
	{
		createButton.click();
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void enterEmailId(WebDriver driver)
	{
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.sendKeys("teacher1@webcraft.co.in");
	}
	
	public void clickNextButton()
	{
		nextButton.click();
	}
	
	public void clickPasswordCheckbox()
	{
		passCheckbox.click();
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void nextButton(WebDriver driver)
	{
	
	try 
	{
		WebElement nextbut=	driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextbut.click();
	
	}
	catch (org.openqa.selenium.NoSuchElementException ex) 
	{
		WebElement nextbut=	driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextbut.click();
		
		
	}
	
	
	}
}
