package com.createAssessment.fastrackTestcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.createAssessment.fastrackUtilities.TestListener.class)
public class MBTest {
	
	WebDriver driver;

	@Test
	public void testoutput() {
		
		System.setProperty("webdriver.chrome.driver", "./WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://magicband-test.azurewebsites.net/");
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
	}
	@Test(priority = 1)
	public void secondTest() throws InterruptedException {
		Thread.sleep(2000);
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		Thread.sleep(2000);
		emailId.sendKeys("teacher1@webcraft.co.in");
		WebElement nextButton =driver.findElement(By.xpath("span[contains(text(),'Next')]"));
		
			nextButton.click();
		
	}
	@Test(priority = 2)
	public void thirdTest() {
		
		System.out.println("This is 3rd test");
	}
	
	@Test(priority = 3)
	public void fourTest() {
		
		System.out.println("This is 4th test");
	}
	
	@Test(priority = 4)
	public void fifthTest() {
		
		System.out.println("This is 5th test");
		Assert.assertTrue(false);
	}
	
	
}
