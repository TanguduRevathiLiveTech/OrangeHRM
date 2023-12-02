package com.DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	

	WebDriver driver;
	String ApplicationUrlAddress="https://www.osmania.ac.in/";
	public void setup() {
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to(ApplicationUrlAddress);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}
	public void SelectDropDownOption() {
		
		//id="gtranslate_selector"
		By SelectLanguageFromDropDownProperty=By.id("gtranslate_selector");
		WebElement SelectLanguageFromDropDown=driver.findElement(SelectLanguageFromDropDownProperty);
		SelectLanguageFromDropDown.click();
		
		System.out.println(SelectLanguageFromDropDown);
		Select LanguageSelection=new Select(SelectLanguageFromDropDown);
	
		LanguageSelection.selectByIndex(10);
		LanguageSelection.selectByValue("en|te");
		LanguageSelection.selectByVisibleText("Dutch");
		
	}
			
		public static void main(String[] args) {
			
			SelectDropDown DropDown=new SelectDropDown();
			DropDown.setup();
			DropDown.SelectDropDownOption();
			
		}	
	
	
	
	
}

