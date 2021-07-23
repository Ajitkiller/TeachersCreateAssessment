package com.createAssessment.fastrackTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tests {

	@Test
	public void testingVilla(){
		
	System.setProperty("webdriver.chrome.driver","./WebDrivers\\chromedriver.exe");
		 
	 WebDriver driver = new ChromeDriver();
     String url = "";
     driver.get(url);
     driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
     // identify element
     WebElement l = driver.findElement(By.id("search-strings"));
     // enter text then ctrl+a with Keys.chord()
     l.sendKeys("Selenium");
     String s = Keys.chord(Keys.CONTROL, "a");
     Keys.chord(Keys.SHIFT, "TAB");
     l.sendKeys(s);
     
     
	}
}
