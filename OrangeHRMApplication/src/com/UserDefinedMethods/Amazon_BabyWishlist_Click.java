package com.UserDefinedMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;



public class Amazon_BabyWishlist_Click {

	WebDriver driver;
	String ApplicationUrlAddress="https://www.amazon.in/";
	public void ApplicationLaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println( " **** Successfully Launched Chrome Browser ***** ");
        driver.navigate().to(ApplicationUrlAddress);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//id="nav-link-accountList"
	/*identifing the propert for accounts and sign in element
	Locator -id
	selector-nav-link-accountList
	This element type of - Link*/
	public void Accountsignin() {
		By AccountSignInProperty=By.id("nav-link-accountList");
		WebElement SignIn=driver.findElement(AccountSignInProperty);
		// Actions - its a class of Selenium used to perform Operations related to
        // Either Mouse or KeyBorad
       //1. what type of operation should be done
       //2. where the operation should be performed
		Actions AccountSignInMouseHover=new Actions(driver); 
		//helloSignInMouseHover.moveToElement(helloSignIn).build().perform();
		AccountSignInMouseHover.moveToElement(SignIn).build().perform();
			
	}
	public void BabyWishlist_Click() {
		
		//identifying the property of BabyWishlist element
		//<span class="nav-text">BabyWishlist</span>
		By BabyWishlistProperty=By.linkText("Baby Wishlist");
		WebElement BabyWishlist=driver.findElement(BabyWishlistProperty);
		//Performing the operation on element
		BabyWishlist.click();
		
	}
	public void ApplicationClose() {
		
		driver.close();
		
	}
	public static void main(String[] args) {
		Amazon_BabyWishlist_Click Amazon =new Amazon_BabyWishlist_Click();
		Amazon.ApplicationLaunch();
		Amazon.Accountsignin();
		Amazon.BabyWishlist_Click();
		Amazon.ApplicationClose();
	}

}
