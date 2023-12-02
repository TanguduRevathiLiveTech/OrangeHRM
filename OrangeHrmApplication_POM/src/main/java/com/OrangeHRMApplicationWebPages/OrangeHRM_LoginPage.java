package com.OrangeHRMApplicationWebPages;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseTest.BaseTest;
import com.utility.ExcelOperationMethods;
import com.utility.ExcelOperationMethodsMultipleData;
import com.utility.Log;

public class OrangeHRM_LoginPage extends BaseTest {

	//object repository 
	public OrangeHRM_LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	//id="logInPanelHeading"
	
	
	@FindBy(id="logInPanelHeading")
	WebElement logInPanel;
	public void validatingLogInPanelText() // Business Logic
	{

	String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	Log.info(" The expected Text of the OrangeHRM Application LogIn Page is :- "+expected_OrangeHRMApplicationLogInPageText);


	String actual_OrangeHRMApplicationLogInPageText=logInPanel.getText();
	Log.info(" The actual Text of the OrangeHRM Application LogIn Page is :- "+actual_OrangeHRMApplicationLogInPageText);
//Log.info(actual_OrangeHRMApplicationLogInPageText);
	if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
	{
	Log.info(" OrangeHRM Application LogIn Page Text Validation Successfull - PASS ");
	}
	else
	{
	Log.info(" OrangeHRM Application LogIn Page Text Validation UNSuccessfull - FAIL ");
	}
	}
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/img")
	WebElement OrangeHRMLogo;

	public void validatingOrangeHRMApplicationLogInPageLogo()
	{
	boolean flag=OrangeHRMLogo.isDisplayed();
	if(flag)
	{
	Log.info("OrangeHRM Applicaiton LogIn WebPage Contains Logo - PASS ");
	}
	else
	{
	Log.info("OrangeHRM Applicaiton LogIn WebPage doesn Contain Logo - Fail ");
	}

	}
	// id="txtUsername"
			@FindBy(id="txtUsername")
			WebElement userName;

			// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

			// name="txtPassword"
			@FindBy(name="txtPassword")
			WebElement password;

			// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

			@FindBy(className = "button")
			WebElement logInButton;
			@FindBy(id="welcome")
			WebElement welComeAdminProperty;
			//@FindBy(linkText="Logout")
			
		//	WebElement logOutProperty;
					
			public void ValidatingLogInFunctionality(String UserName,String Password) throws IOException
			{
			userName.sendKeys(UserName);
			password.sendKeys(Password);
			logInButton.click();
			String ExpectedUserNameOfLoginPage="Revathi";
			String ExpectedPassWordOfLoginPage="Revathi@123";
		
			String expected_OrangeHRMApplicationHomePageText="Admin";

			Log.info(" The Expected Text of OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);
			// id="welcome" - Property of WelCome Admin Element
			
		if(UserName.equals(ExpectedUserNameOfLoginPage)&&Password.equals(ExpectedPassWordOfLoginPage)) {

			//WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
           
			String actual_OrangeHRMApplicationHomePageText=welComeAdminProperty.getText();

			Log.info(" The actual Text of OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
			
			if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))

			{
           Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");
           
			ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestResultsFiles\\Multipledata TestResults- Copy.xlsx", "Sheet1", 1, 2, "Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			}
		
			driver.navigate().back();
			driver.navigate().refresh();
		}
			else {

			Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestResultsFiles\\Multipledata TestResults- Copy.xlsx", "Sheet1", 1, 2, " Failed to Navigate to OrangeHRM Application HomePage - FAIL");
			}
			}
			
			//<div id="social-icons">
		       // <a href="http://www.linkedin.com/groups?home=&amp;gid=891077" target="_blank">
		       // <img src="/orangehrm-4.2.0.1/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/linkedin.png" alt="LinkedIn OrangeHRM group"></a>&nbsp;
		  ///  <a href="http://www.facebook.com/OrangeHRM" target="_blank">
		      //  <img src="/orangehrm-4.2.0.1/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/facebook.png" alt="OrangeHRM on Facebook"></a>&nbsp;
		   // <a href="http://twitter.com/orangehrm" target="_blank">
		      //  <img src="/orangehrm-4.2.0.1/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/twiter.png" alt="OrangeHRM on twitter"></a>&nbsp;
		    //<a href="http://www.youtube.com/orangehrm" target="_blank">
		       // <img src="/orangehrm-4.2.0.1/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/youtube.png" alt="OrangeHRM on youtube"></a>&nbsp;
	
				@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[1]")
				WebElement LinkedinLink;
				
				@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[1]/img")
			    WebElement LinkedinLinkLogo;
				public void ValidatingOrangeHrmFooterBlockLinkedInLogo() {
				
				//	String ExpectedLinkedinUrl=LinkedinLink.getAttribute("href");
					//Log.info("The expectedlinkedinurl - "+ExpectedLinkedinUrl);

					LinkedinLink.click();
					///String ActualLinkedinUrl=driver.getCurrentUrl();
					//ssssLog.info("The  Actual linkedinurl - "+ActualLinkedinUrl);

			       boolean flag=LinkedinLinkLogo.isDisplayed();
			       if(flag) {
						Log.info(" The linkedin Logo is displayed SuccessFully");

					}
					else {
						Log.info(" The linkedin Logo is not displayed SuccessFully");

					}
					/*if(ActualLinkedinUrl.equals(ExpectedLinkedinUrl)) {
						
						Log.info("Succussfully Navigated to Linkedin Page ");
					}
					else {
						Log.info("Failed Navigated to Linkedin Page ");

					}*/
				
					
				}
				///html/body/div[1]/div/div[4]/div[2]/a[2]/img
				///html/body/div[1]/div/div[4]/div[2]/a[2]
				@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[2]")
				WebElement FaceBookLink;
				@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[2]/img")
			    WebElement FaceBookLogo;
          public void ValidatingOrangeHrmFooterBlockFaceBookLogo() {
					
					//String ExpectedfaceBookUrl=FaceBookLink.getAttribute("href");
					//Log.info("The expected face book url - "+ExpectedfaceBookUrl);
					FaceBookLink.click();
					//String ActualFaceBookUrl=driver.getCurrentUrl();
					//Log.info("The Actual facebook url - "+ActualFaceBookUrl);
					 boolean flag=FaceBookLogo.isDisplayed();
			if(flag) {
				Log.info(" The Facebook Logo is displayed SuccessFully");


			}
			else {
				Log.info(" The facebook Logo is not displayed SuccessFully");

			}
			
			       //boolean flag=FaceBookLogo.isDisplayed();
					/*if(ActualFaceBookUrl.equals(ExpectedfaceBookUrl) ) {
						
						Log.info("Succussfully Navigated to FaceBook Page ");
					}
					else {
						Log.info("Failed Navigated to FaceBook Page ");

					}*/
					
					
				}
          @FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[3]")
			WebElement TwitterLink;
			@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[3]/img")
		    WebElement TwitterLogo;
          public void ValidatingOrangeHrmFooterBlockTwitterLogo() {
				
				//String ExpectedTwitterUrl=TwitterLink.getAttribute("href");
				//Log.info("The expected Twitter url - "+ExpectedTwitterUrl);
				TwitterLink.click();
				//String ActualTwitterUrl=driver.getCurrentUrl();
				//Log.info("The Actual Twitter url - "+ActualTwitterUrl);

		       boolean flag=TwitterLogo.isDisplayed();
		       if(flag) {
					Log.info(" The YouTube Logo is displayed SuccessFully");

				}
				else {
					Log.info(" The YouTube Logo is not displayed SuccessFully");

				}
				/*if(ActualTwitterUrl.equals(ExpectedTwitterUrl) ) {
					
					Log.info("Succussfully Navigated to Twitter Page ");
				}
				else {
					Log.info("Failed Navigated to Twitter Page ");

				}*/
				
			}
          @FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[4]")
			WebElement YouTubeLink;
			@FindBy(xpath="/html/body/div[1]/div/div[4]/div[2]/a[4]/img")
		    WebElement YouTubeLogo;
          public void ValidatingOrangeHrmFooterBlockYouTubeLogo() {
				
				//String ExpectedYouTubeUrl=YouTubeLink.getAttribute("href");
				//Log.info("The expected YouTube url - "+ExpectedYouTubeUrl);
				YouTubeLink.click();
				//String ActualYouTubeUrl=driver.getCurrentUrl();
				//Log.info("The Actual YouTube url - "+ActualYouTubeUrl);

		       boolean flag=YouTubeLogo.isDisplayed();
		       if(flag) {
					Log.info(" The YouTube Logo is displayed SuccessFully");
				}else {
					Log.info(" The YouTube Logo is  not displayed SuccessFully");

				}
				/*if(ActualYouTubeUrl.equals(ExpectedYouTubeUrl)) {
					
					Log.info("Succussfully Navigated to YouTube Page ");
				}
				else {
					Log.info("Failed Navigated to YouTube Page ");

				}*/
				
			}
          ///html/body/div[1]/div/div[4]/div[1]
          @FindBy(linkText="OrangeHRM, Inc")
          WebElement CopyRightProperty;
          public void ValidatingOrangeHrmCopyRight() {
        	String ExpectedCopyRight="OrangeHRM, Inc";
        	 Log.info("The expected coptRight - "+ExpectedCopyRight);
        	 String ActualCopyRight=CopyRightProperty.getText();
        	  Log.info("The actual CopyRight - "+ActualCopyRight);
        	  CopyRightProperty.click();
        	  if(ActualCopyRight.equals(ExpectedCopyRight))
        	  {
            	  Log.info("The expected coptRight matched with actual copyright");

        	  }
        	  else {
            	  Log.info("The expected coptRight is NOT matched with actual copyright");

        	  }
          }
          ///html/body/div[1]/div/div[4]/div[1]/text()[1]
          //<select name="openIdProvider" id="openIdProvider">
          //<option value="" selected="selected">-- Select --</option>
         // </select>
          @FindBy(name="openIdProvider")
          WebElement AlternativeSelectProperty;
          @FindBy(xpath="/html/body/div[1]/div/div[3]/div/form/select/option")
          WebElement AlternativeSelectOptionProperty;
          public void ValidatingOrangeHrmAlternativeSelectOption() {
        	  String ExpectedAlternativeSelectOption="-- Select --";
        	  
        	 Log.info("The expected Alternative Select Option - "+ExpectedAlternativeSelectOption);
        	 AlternativeSelectProperty.click();
        	  String ActualAlternativeSelectOption=AlternativeSelectOptionProperty.getText();
        	  Log.info("The actual AlternativeSelectOption - "+ActualAlternativeSelectOption);
        	 
          
          }
          
          //<input type="button" value="Login" name="openIdLogin" id="openIdLogin" disabled="disabled">
          @FindBy(name="openIdLogin")
          WebElement AlternativeLoginProperty;
          public void ValidatingOrangeHrmAlternativeLogin() {
        	  String ExpectedAlternativeLogin="Login";
        	  
        	 Log.info("The expected Alternative Login - "+ExpectedAlternativeLogin);
        	
        	  String ActualAlternativeLogin=AlternativeLoginProperty.getAttribute("value");
        	  Log.info("The actual Alternative Login - "+ActualAlternativeLogin);
        	  AlternativeLoginProperty.click();
          }
}



		

