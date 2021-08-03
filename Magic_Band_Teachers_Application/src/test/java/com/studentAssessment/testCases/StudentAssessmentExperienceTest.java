package com.studentAssessment.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.studentAssessment.pageObject.StudentAssessmentHomePage;
import com.studentAssessment.pageObject.TestExperiencePage;
import com.studentAssessment.pageObject.TestInstructionPage;

public class StudentAssessmentExperienceTest extends BaseClass
{

	ExtentReports extent;
	ExtentTest test;
	

	@BeforeSuite
	public void extentSetUp() throws IOException {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";	
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./test-output/"+repName);
		final File conf=new File("extent-config.xml");
		spark.loadXMLConfig(conf);
		extent.attachReporter(spark);
	}

	@AfterSuite
	public void tearDown() throws IOException 
	{
		extent.flush();
	}

	@Test
	public void magicBand_Login() throws InterruptedException {
		test=extent.createTest("ExtentTest test").assignCategory("Automation").assignAuthor("Ajit").assignDevice("chrome 91");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get(baseUrl);
		test.pass("value entered", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		WebElement loginButton =driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		loginButton.click();
	}

	@Test(priority = 1)
	public void studentLoginAssess() throws InterruptedException
	{
		test=extent.createTest("studentLoginAssess").assignCategory("Automation").assignAuthor("Ajit").assignDevice("chrome 91");
		WebElement emailId =driver.findElement(By.xpath("//input[@id='identifierId']"));
		emailId.clear();
		emailId.sendKeys("student1@webcraft.co.in");
		WebElement nextButton =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();

		test.pass("Username entered successfully.");
		Thread.sleep(2000);
		WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Vision2020");
		WebElement nextButton2 =driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton2.click();
		test.pass("Clicking next button successfully.");
		Thread.sleep(3000);
		test.pass("Student home page pic", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
	}

	@Test(priority = 2)
	public void verifyStudentHomePage() throws InterruptedException {
		test=extent.createTest("verifyStudentHomePage");
		for (int i = 0; i <1; i++) 
		{	
			StudentAssessmentHomePage studentHomePage=new StudentAssessmentHomePage(driver);
			WebElement assigned=driver.findElement(By.xpath("//a[@id='in-progress-tab']"));
			String text= assigned.getText();
			System.out.println(text);
			if (assigned.getText().contains("Assigned")) {
				Thread.sleep(1000);
				studentHomePage.clickOnDoneTab();
				Thread.sleep(1000);
				studentHomePage.clickOnMissingTab();
				Thread.sleep(1000);
				studentHomePage.clickOnUpcomingTab();
				Thread.sleep(1000);
				studentHomePage.clickOnAssignedTab();
			}
			else {
				test.fail("Student home page is not displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			}
		}
		test.pass("Verify student page successfully");
	}

	@Test(priority = 3)
	public void selectTestAssessment() throws InterruptedException 
	{
		StudentAssessmentHomePage studentHomePage=new StudentAssessmentHomePage(driver);
		test=extent.createTest("selectTestAssessment");
		Thread.sleep(2000);
		studentHomePage.clickOnAssignedTab();
		studentHomePage.clickOnStartButton();
		test.pass("Assessment start button clicking successfully");

	}
	@Test(priority = 4)
	public void verifyInstructionPage() throws InterruptedException 
	{
		test=extent.createTest("verifyInstructionPage");
		test.pass("Student test instruction page picture", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		TestInstructionPage page=new TestInstructionPage(driver);
		page.popupWindow(driver);
		System.out.println("test-1");
		page.timer();
		for (int i = 0; i < 8; i++) {
			page.fontSize();
		}
		System.out.println("font size 8 times clicking");
		Thread.sleep(4000);
		page.clickOnCheckbox(driver);
		test.pass("Checkbox clicking successfully"); 
		//WebDriverWait some_element = new WebDriverWait(driver,100); 
		//some_element.until(ExpectedConditions.visibilityOfElementLocated(By.id("//span[contains(text(),'Start')]")));
		page.clickOnTestExam(driver);
		System.out.println("Start exam button clicking successfully");
		//page.clickOnToolInstruction();
		test.pass("tool instruction page picture", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		//page.closeToolInstructionModel();
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void viewAssessmentInstruction() throws InterruptedException {
		Thread.sleep(10000);
		driver.manage().window().maximize();
		test=extent.createTest("verifyTestAssessmentFunctiopnality");
		TestExperiencePage TestExp=new TestExperiencePage(driver);
		TestExp.clickOnAssessmentInstruction();
		test.pass("Assessment instruction is displayed");
		Thread.sleep(2000);
		TestExp.clickOnAssessmentCloseButton();
		test.pass("Assessment instruction is closed");

	}
	@Test(priority = 6)
	public void viewQuestionPaperModel() throws InterruptedException {
		test=extent.createTest("viewQuestionPaperModel");
		TestExperiencePage TestExp=new TestExperiencePage(driver);
		TestExp.viewQuestionPaper();
		test.pass("Question paper is displayed");
		Thread.sleep(2000);
		TestExp.clickOnQuestionPaperCloseButton();
		test.pass("Question paper is closed");
	}

	@Test(priority = 7)
	public void clickOnNextQuestion() {
		test=extent.createTest("clickOnNextQuestion");
		TestExperiencePage TestExp=new TestExperiencePage(driver);

		for (int i = 0; i < 5; i++) {
			TestExp.clickNextButton();
		}
		test.pass("Next button clicking");
		for (int i = 0; i < 4; i++) {
			TestExp.clickPreviousButton();
		}
		test.pass("Previous button clicking");
	}

	@Test(priority = 8)
	public void finishButton() throws InterruptedException {
		test=extent.createTest("finishButton");
		TestExperiencePage TestExp=new TestExperiencePage(driver);
		TestExp.clickOnFinishButton();
		test.pass("Successfully clicking finish button");
		Thread.sleep(1000);
		TestExp.clickOnSubmitButton();
		test.pass("Successfully clicking submit button");
		Thread.sleep(1000);
		TestExp.verifySubmitText();
		test.pass("Assessment submit text is correct");
		TestExp.clickOnConfirmationCancelButton();
		test.pass("Confirmation text is correct & cancel test submition");
	}





	public String screenshot() {

		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

	}


}
