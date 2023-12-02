package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OrangeHRMApplicationLoginPage {

	public static void main(String[] args) {
		ChromeDriver driver;
		String OrangehrmApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		//launching the Chrome browser
		
		
		
		
		
		
		
		
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//navigating to OrangeHRM Application
		driver.get(OrangehrmApplicationUrl);
		
		//validating OrangeHRM Application login page
		 String Expected_OrangeHRMLoginPageTitle="OrangeHRM";// should be "OrangeHRM"
		 System.out.println("The Expected OrangeHRM Login page title is - "+Expected_OrangeHRMLoginPageTitle);
		 String Actual_OrangeHRMLoginPageTitle=driver.getTitle();
		 System.out.println("The Actual orangeHRM login page title is - "+Actual_OrangeHRMLoginPageTitle);
		 if(Actual_OrangeHRMLoginPageTitle.equals(Expected_OrangeHRMLoginPageTitle))
		 {
			 System.out.println("Successfully Navigated to OrangeHRM Login Page = PASS");
		 }
		 else{
			 System.out.println("Failed to navigated into OrangeHRM Login Page = FAIL");
		 }
		 
		 
		 System.out.println("*********************************************************************************");
		
		//Validating OrangeHRM Application Login page URL Address
		 String Expected_OrangeHRMLoginPageURLAddress ="orangehrm-4.2.0.1";// should have "orangehrm-4.2.0.1"
		 System.out.println("The Expected OrangeHRM Login page Url Address is - "+Expected_OrangeHRMLoginPageURLAddress);
		 String Actual_OrangeHRMLoginPageURLAddress=driver.getCurrentUrl();
		 System.out.println("The Actual orangeHRM login page url address is - "+Actual_OrangeHRMLoginPageURLAddress);
		 if(Actual_OrangeHRMLoginPageURLAddress.contains(Expected_OrangeHRMLoginPageURLAddress)) {
			 System.out.println("The Actual OrangeHRM login page url address should cantains Expected OrangeHRMLogin Page URL Address");
		 }
		 else {
			 System.out.println("The Actual OrangeHRM login page url address should not cantains Expected OrangeHRMLogin Page URL Address");
		 }
		 
		System.out.println("##############################################################################");
		
		
		
       //Login to the application with valid test date
		//<input name="txtUsername" id="txtUsername" type="text">
		// Test date is giving to User name element
		String UserNameTestData="Revathi";
		//identifying the property of User name  element
		 By UsernameProperty=By.id("txtUsername");
		 //Finding the User name element by using property in the current page
		WebElement Username=driver.findElement(UsernameProperty);
		//Operation should be performed on the element - User Name
		Username.sendKeys(UserNameTestData);
		
		//<input name="txtPassword" id="txtPassword" auto complete="off" type="password">
		//identifying the property of Password Element
		//Test date is giving to Password element
		String PasswordTestDate="Revathi@123";
		By PasswordProperty=By.name("txtPassword");
		//Finding the element by using property in the current page
		WebElement Password=driver.findElement(PasswordProperty);
		//<input name="txtUsername" id="txtUsername" type="text">
		
		//Operation should be performed on the element - Password
		Password.sendKeys(PasswordTestDate);
		
		
		//identifying the property of Login button Element
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	    By LoginProperty=By.className("button");
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		
		//Validating OrangeHRM Application Home Page
		String Expected_OrangeHRMHomePageTitle="OrangeHRM";// should be "OrangeHRM"
		 System.out.println("The Expected OrangeHRM Home page title is - "+Expected_OrangeHRMHomePageTitle);
		 String Actual_OrangeHRMHomePageTitle=driver.getTitle();
		 System.out.println("The Actual orangeHRM Home page title is - "+Actual_OrangeHRMHomePageTitle);
		 if(Actual_OrangeHRMHomePageTitle.equals(Expected_OrangeHRMHomePageTitle))
		 {
			 System.out.println("Successfully Navigated to OrangeHRM Home Page = PASS");
		 }
		 else{
			 System.out.println("Failed to navigated into OrangeHRM Home Page = FAIL");
		 }
		 
		 
		 String Expected_OrangeHRMHomePageUrlAddress="orangehrm-4.2.0.1/symfony/web";// should have "orangehrm-4.2.0.1/symfony/web"
		 System.out.println("The Expected OrangeHRM Home page title is - "+Expected_OrangeHRMHomePageUrlAddress);
		 String Actual_OrangeHRMHomePageUrladdress=driver.getCurrentUrl();
		 System.out.println("The Actual orangeHRM Home page title is - "+Actual_OrangeHRMHomePageTitle);
		 if(Actual_OrangeHRMHomePageUrladdress.contains(Expected_OrangeHRMHomePageUrlAddress))
		 {
			 System.out.println("Successfully Navigated to OrangeHRM Home Page = PASS");
		 }
		 else{
			 System.out.println("Failed to navigated into OrangeHRM Home Page = FAIL");
		 }
		 
		
		



		 		
	}
}