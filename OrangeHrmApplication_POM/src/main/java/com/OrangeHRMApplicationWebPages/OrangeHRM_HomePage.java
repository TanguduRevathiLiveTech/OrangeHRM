package com.OrangeHRMApplicationWebPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;

import com.utility.Log;


public   class OrangeHRM_HomePage extends BaseTest{
	
	public  OrangeHRM_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id="txtUsername")
	WebElement userName;

	// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

	// name="txtPassword"
	@FindBy(name="txtPassword")
	WebElement password;

	// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

	@FindBy(className = "button")
	WebElement logInButton;
	
	//@FindBy(linkText="Logout")
	
//	WebElement logOutProperty;
			
	public void ValidatingHomepageLogInFunctionality(String UserName,String Password) throws IOException
	{
	userName.sendKeys(UserName);
	password.sendKeys(Password);
	logInButton.click();
	}
	@FindBy(id="welcome")
	WebElement welComeAdminProperty;
	public void HomePageWelcomeAdminFunctionality() {
		

	String expected_OrangeHRMApplicationHomePageText="Admin";
	Log.info(" The Expected Text of OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

	String actual_OrangeHRMApplicationHomePageText=welComeAdminProperty.getText();

	Log.info(" The actual Text of OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
	
	welComeAdminProperty.click();
	if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText)) {
		Log.info("Succeesfully Navigated to Home page");
	}
	else {
		Log.info("Falied to navigate to Home Page");
	}
	}
	@FindBy(xpath="/html/body/div[1]/div[1]/a[1]/img")
	WebElement OrangeHRMHomePageLogo;
	public void ValidatingOrangeHRMHomePageLogo() {
		
		boolean flag=OrangeHRMHomePageLogo.isDisplayed();
		if(flag)
		{
		Log.info("OrangeHRM Applicaiton Home Page Contains Logo - PASS ");
		}
		else
		{
		Log.info("OrangeHRM Applicaiton Home Page does not Contain Logo - Fail ");
		}

		}
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/h1")
	WebElement OrangeHrmHomePageText;
	public void ValidatitingOrangeHrmHomePageText(){
		
		String ExpectedOrangeHrmHomePageText="Dashboard";
		Log.info("The Expected Home Page Text - "+ExpectedOrangeHrmHomePageText);
		String ActualOrangeHrmHomePageText=OrangeHrmHomePageText.getText();
		Log.info("The Actual Home Page Text - "+ActualOrangeHrmHomePageText);
		if(ActualOrangeHrmHomePageText.equals(ExpectedOrangeHrmHomePageText)) {
			Log.info("OrangeHRM Applicaiton Home Page Contains Text - PASS ");
		}
		else {
			Log.info("OrangeHRM Applicaiton Home Page  Does Not Contains Text - PASS ");

		}
	}
	@FindBy(linkText="Admin")
	WebElement AdminElement;
	public void ValidatitingOrangeHrmHomePageAdminElement() {
		
		Actions MouseOver=new Actions(driver);
		MouseOver.moveToElement(AdminElement).build().perform();
	}
	
	
	
	}
	
	

