package com.ExcelOperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.utility.Log;



public class BaseTest {
	
	WebDriver driver;
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Log.info("**********Successfully navigated to OrangeHRM application*********");
	}
@AfterTest
	public void TearDown() {
		driver.close();
		Log.info("*********Successfully closed OrangeHRM application*********");
		Log.info("*********************************************************************");		
		
	}
}
