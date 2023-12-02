package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMHomePageValidation {
	
	public static void main(String[] args) {
		
		ChromeDriver driver;
		String OrangehrmApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		//launching the Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//navigating to OrangeHRM Application
		driver.get(OrangehrmApplicationUrl);
		
		//validating home page using expected title
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
		 
		 //validating home page using expected url
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
		
	
		//validating the home page by expected text= "Admin"
		
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		 //identifying the property of elememt
		 By WelcomeAdminProperty=By.linkText("Welcome Admin");
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 
		 String Expected_ElementText="Admin";
		 System.out.println("The Expected Element Text- "+Expected_ElementText);
		 String Actual_ElementText=welcomeAdmin.getText();
		 System.out.println("The Actual  is Element Text - "+Actual_ElementText);
		 //Validating The text of the Element
		 if(Actual_ElementText.contains(Expected_ElementText)) {
			 
			 System.out.println("Successfully Navigated to OrangeHRM Home Page = PASS");
		 }
		 else {
			 System.out.println("Failed to navigated into OrangeHRM Home Page = FAIL");
		 }
		
		 //perform an operation on element
		 welcomeAdmin.click();
		
		
	
		
	}

}
