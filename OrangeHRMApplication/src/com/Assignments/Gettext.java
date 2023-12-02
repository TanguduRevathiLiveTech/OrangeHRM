package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gettext {

	public static void main(String[] args) {
		
		

		String applicationUrlAddress="http://google.com";

		// Automating the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Navigating to Google Home Page
		driver.get(applicationUrlAddress);

		// Identifying the properties of Sign In Element
		// <a  href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
		//continue=https://www.google.com/&amp;ec=GAZAmgQ"
		// target="_top"><span >Sign in</span></a>

		/*
		  a -  an anchor Tag
		href - an attribute

		  Then the element is of Type - link

		  To Automate the link using WebDriver
		-----------------------------------------------

		 locator - linkText
		 Selector - Sign in
		*/

		// Identifying the Property of the element
		By signInPropety=By.linkText("Sign in");

		// Identifying the element with the property on the Current Webpage
		WebElement signIn=driver.findElement(signInPropety);
		System.out.println(signIn);


		String expected_GoogleHomePageSignInText="Sign in";
		System.out.println(" The Expected Text of the SignIn of Google Home Page is :- "+expected_GoogleHomePageSignInText);

		// Getting the text of the Element - SignIn of Google HomePage

		// getText() - is used to get the text of an element
		// getText() - the return type of the method is String

		String actual_GoogleHomePageSignInText=signIn.getText();
		
		System.out.println(" The actual Text of the SignIn of Google Home Page is :- "+actual_GoogleHomePageSignInText);

		if(actual_GoogleHomePageSignInText.equals(expected_GoogleHomePageSignInText))
		{
		System.out.println(" Google Home Page SignIn Text matched - PASS ");
		}
		else
		{
		System.out.println("Google Home Page SignIn Text NOT matched - FAIL ");
		}


		driver.quit();

		}




}
