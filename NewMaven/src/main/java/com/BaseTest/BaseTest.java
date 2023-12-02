package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.utility.Log;



public class BaseTest {
	
	 public static WebDriver driver;
	String ApplicationUrlAddress="https://echoecho.com/";
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		Log.info("**********Successfully navigated to echoecho application*********");
	}
    @AfterTest
	public void TearDown() {
		driver.close();
		Log.info("*********Successfully closed echoecho application*********");
		Log.info("*********************************************************************");		
		
	}
}
