package com.studentAssessment.pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestInstructionPage {
	WebDriver ldriver;

	public TestInstructionPage(WebDriver rdriver){

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//button[@class='btn btn-outline-primary-v2 btn-lg mr-2 pull-right clock active']")
	@CacheLookup
	WebElement timerButoon;

	@FindBy(xpath="//button[@data-original-title='Font Resize']")
	@CacheLookup
	WebElement fontSizeButton;

	@FindBy(xpath="//input[@id='customCheck1']")
	@CacheLookup
	WebElement termsAndCondCheckBox;

	@FindBy(xpath="//a[@data-target='#tool-instructions']")
	@CacheLookup
	WebElement toolInstructionButton;

	@FindBy(xpath="//span[contains(text(),'Start')]")
	@CacheLookup
	WebElement startButton;

	@FindBy(xpath="//span[contains(text(),'Resume')]")
	@CacheLookup
	WebElement resumeButton;

	@FindBy(xpath="//div[@id='tool-instructions']//div//div//div//h4")
	@CacheLookup
	WebElement toolInstructionText;

	@FindBy(xpath="//div[@id='tool-instructions']//div//div//div//button")
	@CacheLookup
	WebElement toolInstructionClosedButton;


	public void timer() {
		for (int i = 0; i < 10; i++) {
			timerButoon.click();
		}
	}
	public void fontSize() {
		fontSizeButton.click();
	}

	public void clickOnCheckbox(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(termsAndCondCheckBox).click().build().perform();
	}

	public void clickOnToolInstruction() throws InterruptedException {

		toolInstructionText.click();
		Thread.sleep(2000);
		String text=toolInstructionText.getText();
		if (text.equals("Tool Instructions")) {
			System.out.println("Tool instruction text is correct");
		}
		else {
			System.out.println("Tool instruction text is wrong");
		}

	}
	public void closeToolInstructionModel() {
		toolInstructionClosedButton.click();
	}

	public void clickOnTestExam(WebDriver driver) {
			//	startbutton.click();
			//	System.out.println("start button is displayed");
		try 
		{
			WebElement resumeBut=driver.findElement(By.xpath("//span[contains(text(),'Resume')]"));
			resumeBut.click();
		}
		catch (org.openqa.selenium.NoSuchElementException ex) 
		{
			WebElement resumeBut=driver.findElement(By.xpath("//span[contains(text(),'Resume')]"));
			resumeBut.click();
		}
			
	}
	public void popupWindow(WebDriver driver) {
		String parent=driver.getWindowHandle();
		Set<String>popup=driver.getWindowHandles();
		Iterator it=popup.iterator();
		while (it.hasNext()) {
			String popupHandler=it.next().toString();
			if (!popupHandler.contains(parent)) {
				driver.switchTo().window(popupHandler);
			}
		}

	}












}
