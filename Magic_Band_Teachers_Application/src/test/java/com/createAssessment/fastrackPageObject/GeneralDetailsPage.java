package com.createAssessment.fastrackPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralDetailsPage {

	WebDriver ldriver;

	public GeneralDetailsPage(WebDriver rdriver){

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//input[@name='input_title']")
	@CacheLookup
	WebElement assessmentName;

	@FindBy(xpath="//div[contains(text(),'Select board')]")
	@CacheLookup
	WebElement selectBoard;

	@FindBy(xpath="//span[contains(text(),'CBSE')]")
	@CacheLookup
	WebElement select_CBSE;
	
	@FindBy(xpath="//span[contains(text(),'Select board')]")
	@CacheLookup
	WebElement spanSelectBoard;
	
	@FindBy(xpath="//div[contains(text(),'CBSE')]")
	@CacheLookup
	WebElement preSelected_CBSE;
	
	@FindBy(xpath="//div[contains(text(),'Select grade')]")
	@CacheLookup
	WebElement selectGrade;

	@FindBy(xpath="//span[contains(text(),'9')]")
	@CacheLookup
	WebElement grade9;

	@FindBy(xpath="//span[contains(text(),'10')]")
	@CacheLookup
	WebElement grade10;

	@FindBy(xpath="//span[contains(text(),'11')]")
	@CacheLookup
	WebElement grade11;

	@FindBy(xpath="//span[contains(text(),'12')]")
	@CacheLookup
	WebElement grade12;

	@FindBy(xpath="//div[contains(text(),'Select subject')]")
	@CacheLookup
	WebElement selectSubject;

	@FindBy(xpath="//*[@id=\"informationDiv\"]/div/div[1]/div[2]/div/div[1]/div/div[3]/div/div[2]/div/div/div/ul/li[3]/a/span[2]")
	@CacheLookup
	WebElement ScienceSub;

	@FindBy(xpath="//span[contains(text(),'Social Science')]")
	@CacheLookup
	WebElement socialScienceSub;

	@FindBy(xpath="//span[contains(text(),'Select topic and subtopic')]")
	@CacheLookup
	WebElement selectTopicAndSubtopic;

	@FindBy(xpath="//label[contains(text(),' Select all')]")
	@CacheLookup
	WebElement selectAll_TopicAndSubtopic;

	// Create format button
	@FindBy(xpath="//div[contains(text(),'Create Format')]")
	@CacheLookup
	WebElement createFormat;

	@FindBy(xpath="//div[@data-id='de7e646a-ad6b-4e7d-9c53-ad6b00e1edd5']")
	@CacheLookup
	WebElement application_script;

	//Question type details in model
	@FindBy(xpath="//div[contains(text(),'Select question type')]")
	@CacheLookup
	WebElement selectQuestionType;

	@FindBy(xpath="//span[contains(text(),'Fill in the blank')]")
	@CacheLookup
	WebElement selectFIBType;

	@FindBy(xpath="//span[contains(text(),'Long question')]")
	@CacheLookup
	WebElement selectLongQuestionType;

	@FindBy(xpath="//span[contains(text(),'Multi choice')]")
	@CacheLookup
	WebElement selectMultiChoiceType;

	@FindBy(xpath="//span[contains(text(),'Short question')]")
	@CacheLookup
	WebElement selectShortQuestionType;

	@FindBy(xpath="//span[contains(text(),'True or false')]")
	@CacheLookup
	WebElement selectTrueOrFalseType;

	//Count input field on the template create module.
	@FindBy(css="input[class='form-control table-input is_number enter_counter']")
	@CacheLookup
	WebElement questionCount;

	@FindBy(css="input[class='form-control table-input is_number enter_marks']")
	@CacheLookup
	WebElement questionMarks;

	@FindBy(xpath="//input[@name='template_title']")
	@CacheLookup
	WebElement templateFormatName;

	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	@CacheLookup
	WebElement cancelButton;

	@FindBy(xpath="//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement saveButton;

	////button[contains(text(),'Next ')][1]
	@FindBy(xpath="//button[contains(text(),'Next ')][1]")
	@CacheLookup
	WebElement btnNext;

	@FindBy(xpath="//button[contains(text(),'Next ')][1]")
	@CacheLookup
	WebElement onlyTwoSetOfFormat;

	@FindBy(xpath="//tbody[@class='ui-sortable']//tr[1]//td[6]//span")
	@CacheLookup
	WebElement deleteQuestionType;


	@FindBy(xpath="//tbody[@class='ui-sortable']//tr//td[4]//input")
	@CacheLookup
	WebElement pointInput;

	@FindBy(xpath="//tbody[@class='ui-sortable']//tr//td[3]//input")
	@CacheLookup
	WebElement countInput;

	@FindBy(xpath="//div[@class='range-slider-box']//div//div[6]")
	@CacheLookup
	WebElement difficultyLevel;
	
	@FindBy(xpath="//div[@style='left: 0%;' and @aria-valuenow='1' and @class='slider-handle min-slider-handle round']")
	@CacheLookup
	WebElement difficultyLevelOne;
	

	public void inputAssessmentName(String Aname,WebDriver driver) 
	{
		try {
		WebElement name=driver.findElement(By.xpath("//input[@name='input_title']"));
		name.clear();
		name.sendKeys(Aname);
		}
		catch(java.lang.NullPointerException e){
			WebElement name=driver.findElement(By.xpath("//input[@name='input_title']"));
			name.clear();
			name.sendKeys(Aname);
		}
	}

	public void selectBoardName() throws InterruptedException 
	{
			
	Thread.sleep(1000);
	if (selectBoard.isDisplayed()) {
		selectBoard.click();
		select_CBSE.click();
		System.out.println("Board selected");
	}
	else {
		preSelected_CBSE.click();
		spanSelectBoard.click();
		System.out.println("Preselected CBSE ");
		Thread.sleep(1000);
		selectBoard.click();
		select_CBSE.click();
		System.out.println("Select to default & again select CBSE");
	}
	
			
		
		Thread.sleep(1000);
	}

	public void selectGrade9() throws InterruptedException 
	{
		selectGrade.click();
		grade9.click();
		Thread.sleep(1000);
	}

	public void selectGrade10() throws InterruptedException 
	{
		
		selectGrade.click();
		grade10.click();
		Thread.sleep(1000);
	}
	public void selectGrade11() throws InterruptedException 
	{
		selectGrade.click();
		grade11.click();
		Thread.sleep(1000);
	}
	public void selectGrade12() throws InterruptedException 
	{
		selectGrade.click();
		grade12.click();
		Thread.sleep(1000);
	}

	public void selectTopic_Subtopic(WebDriver driver) throws InterruptedException 
	{
		selectTopicAndSubtopic.click();
		Thread.sleep(1000);
		selectAll_TopicAndSubtopic.click();
	}

	public void selectSubjectName() 
	{		
		selectSubject.click();
		ScienceSub.click();
	}

	public void moveDifficultyLevel(WebDriver driver) throws InterruptedException {

		WebElement difficultyLevel = driver.findElement(By.xpath("//div[@class='range-slider-box']//div//div[6]"));
		difficultyLevel.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(1000);
		difficultyLevel.sendKeys(Keys.ARROW_RIGHT);
		difficultyLevel.sendKeys(Keys.ARROW_LEFT);
		difficultyLevel.sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(1000);
		difficultyLevel.sendKeys(Keys.ARROW_RIGHT);
	}



	// Create template format details are define here

	public void clickOnCreateFormat() 
	{
		createFormat.click();
		//application_script.click();
	}

	public void SelectMultiChoiceType(String count, String mark, WebDriver driver) {

		selectQuestionType.click();
		selectMultiChoiceType.click();
		questionCount.sendKeys(count);
		questionMarks.sendKeys(mark);
		WebElement TypeMCQ =driver.findElement(By.xpath("//div[contains(text(),'Multi choice')]"));
		TypeMCQ.click();

	}

	public void SelectFIBType(String count, String mark, WebDriver driver) {

		selectQuestionType.click();
		//selectFIBType.click();
		try {
			WebElement date = driver.findElement(By.xpath("//span[contains(text(),'Fill in the blank')]"));
			date.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement date = driver.findElement(By.xpath("//span[contains(text(),'Fill in the blank')]"));
			date.click();
		}
		questionCount.sendKeys(count);
		questionMarks.sendKeys(mark);
		WebElement typeFIB =driver.findElement(By.xpath("//div[contains(text(),'Fill in the blank')]"));
		typeFIB.click();

	}

	public void SelectLongQuestionType(String count, String mark, WebDriver driver) {

		selectQuestionType.click();
		selectLongQuestionType.click();
		questionCount.sendKeys(count);
		questionMarks.sendKeys(mark);
		WebElement typeLongQuestion =driver.findElement(By.xpath("//div[contains(text(),'Long question')]"));
		typeLongQuestion.click();

	}

	public void SelectShortQuestionType(String count, String mark, WebDriver driver) {

		selectQuestionType.click();
		selectShortQuestionType.click();
		questionCount.sendKeys(count);
		questionMarks.sendKeys(mark);
		WebElement typeShortQuestion =driver.findElement(By.xpath("//div[contains(text(),'Short question')]"));
		typeShortQuestion.click();

	}

	public void SelectTrueOrFalseType(String count, String mark, WebDriver driver) {

		selectQuestionType.click();
		selectTrueOrFalseType.click();
		questionCount.sendKeys(count);
		questionMarks.sendKeys(mark);
		WebElement typeShortQuestion =driver.findElement(By.xpath("//div[contains(text(),'True or false')]"));
		typeShortQuestion.click();

	}

	public void enterFormatName(String Name) {
		templateFormatName.clear();
		templateFormatName.sendKeys(Name);
	}


	public void clickOnSaveButton(WebDriver driver) {

		//saveButton.click();
		try {
			WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			saveButton.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			saveButton.click();
		}
	}

	public void clickOnCancelButton() {

		cancelButton.click();
	}

	public void clickOnNextButton() {

		btnNext.click();
	}

	public void delete1stQuestionType(WebDriver driver) {

		try {
			WebElement deleteQuestionType = driver.findElement(By.xpath("//tbody[@class='ui-sortable']//tr[1]//td[6]//span"));
			deleteQuestionType.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement deleteQuestionType = driver.findElement(By.xpath("//tbody[@class='ui-sortable']//tr[1]//td[6]//span"));
			deleteQuestionType.click();
		}
		//deleteQuestionType.click();
	}

	public void enterCount(String num) {
		countInput.clear();
		countInput.sendKeys(num);
	}


	public void enterNumber(String num) {
		pointInput.clear();
		pointInput.sendKeys(num);
	}

	public void predefineFormat(WebDriver driver) {
		
		driver.findElement(By.xpath("//*[@id='informationDiv']//div//div[2]//div//div//div[2]//div//div[1]//div//div[1]//div//a//div//div[1]")).click();
			
		}



}

