package com.MouseOver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class AmazonSignInMouseOver {
	WebDriver driver;
	String ApplicationurlAddress="http://amazon.in/";
	public void ApplicationLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationurlAddress);
			
	}
	public void SignInMouseOver() {
		//id="nav-link-accountList"
		By SignInProperty = By.id("nav-link-accountList");
		WebElement SignIn =driver.findElement(SignInProperty);
		Actions SignInMouseOver= new Actions(driver);
		SignInMouseOver.moveToElement(SignIn).build().perform();
		
		
		
		
	}

	
	public static void main(String[] args) {
		
		AmazonSignInMouseOver Amazon =new AmazonSignInMouseOver();
		Amazon.ApplicationLaunch();
		Amazon.SignInMouseOver();
		
	}
}
