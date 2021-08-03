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
	
	public void clickLoginButton(WebDriver driver)
	{
		//loginButton.click();
		try 
		{
			WebElement loginButton=	driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
			loginButton.click();
		
		}
		catch (org.openqa.selenium.NoSuchElementException ex) 
		{
			WebElement loginButton=	driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
			loginButton.click();
		}
	}
	
	public void enterEmailId(WebDriver driver,String email)
	{
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		emailId.sendKeys(email);
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
		password.clear();
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
