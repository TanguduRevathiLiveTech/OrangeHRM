package com.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.BaseTest.BaseTest;

public  class OrangeHrmLogin {
	
	
	 public static WebDriver driver;
		static String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
			
			
	// public static OrangeHrmLogin hi=new OrangeHrmLogin();
		public static String  LoginFunctionality(String UserNameTestData,String PasswordTestData)
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\ChromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(ApplicationUrlAddress);
			
			 By UsernameProperty=By.id("txtUsername");
			 
			WebElement Username=driver.findElement(UsernameProperty);
			
			
			//<input name="txtPassword" id="txtPassword" auto complete="off" type="password">
			//identifying the property of Password Element
			//Test date is giving to Password element
			
			By PasswordProperty=By.name("txtPassword");
			
			WebElement Password=driver.findElement(PasswordProperty);
			
			
			
			
		    By LoginProperty=By.className("button");
		  
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
				
			Username.sendKeys(UserNameTestData);
			Password.sendKeys(PasswordTestData);
			Login.click();
			return LoginFunctionality(UserNameTestData, PasswordTestData);
			
		}
		
		}
		
		
		

	

