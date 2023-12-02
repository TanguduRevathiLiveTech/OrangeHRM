package com.GoogleApplicationLinkTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

	public static void main(String[] args) {
		ChromeDriver driver;
		String GoogleUrlAddress="https://www.google.com/";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.get(GoogleUrlAddress);
		
		//<a class="gb_za gb_jd gb_Ld gb_ie" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
		//continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top"><span class="gb_Hd">Sign in</span></a>
		//identifying the property of element
		By SignInProperty=By.linkText("Sign in");
		//By SignInProperty1=By.partialLinkText("Sign");
		
		//identifying the element by using the property
		 WebElement SignIn=driver.findElement(SignInProperty);
		 //perform an operation
		 
		 String Actual_AttributeForTarget=SignIn.getAttribute("Target");
		 System.out.println(Actual_AttributeForTarget);
		 String Actual_AttributeForHref=SignIn.getAttribute("href");
		 System.out.println(Actual_AttributeForHref);
		
		
		

	}

}
