package com.AlertWindow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TsrtcHandleAlertWindow {
	
	WebDriver driver;
	String ApplicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
	public void setup() {
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to(ApplicationUrlAddress);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}
	public void AlertWindow() {
		
		//id="searchBtn"
		By CheckAvailableProperty=By.id("searchBtn");
		WebElement CheckAvailble=driver.findElement(CheckAvailableProperty);
		CheckAvailble.click();
		
		Alert AlertMessage=driver.switchTo().alert();
		AlertMessage.accept();//perforn operation for [OK] pop message
		
		//AlertMessage.Dismiss();// perform operation for [Cancel] Pop Meesage
		
       //AlertMessage.Sendkeys("Revathi");// it is used to send a test data into alert pop message	
		
		String ExpectedAlertText="Please select start place.";
		System.out.println("The expected alert text is - "+ExpectedAlertText);
		String ActualAlertText=AlertMessage.getText();
		System.out.println("The Actual Alert text is - "+ActualAlertText);
		if(ActualAlertText.equals(ExpectedAlertText)) {
			
			System.out.println("The Expected alert text is matched with actual alert text - PASS");
		}
		else {
			
			System.out.println("The Expected alert text is  not matched with actual alert text - FAIL");
	
			
		}
		
		
		
		AlertMessage.accept();
	}
	public void TearDown() {
		
		driver.close();
		
	}
	
	public static void main(String[] args) {
		
		TsrtcHandleAlertWindow Alert=new TsrtcHandleAlertWindow();
		Alert.setup();
		Alert.AlertWindow();
		Alert.TearDown();
	}
	

}
