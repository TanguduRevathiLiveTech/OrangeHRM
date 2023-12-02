package com.DropDown;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownScrrenshots {
	
	
		
		
		WebDriver driver;
		String ApplicationUrlAddress="https://www.osmania.ac.in/";
		public void setup() {
			
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}


// By SelectLanguageFromDropDownProperty=By.id("gtranslate_selector");


public void SelectDropDownOption() throws IOException {
	
	//id="gtranslate_selector"
	
	//html/body/div[1]/header/div/div/div/ul/li[9]/select	
	///html/body/div[1]/header/div/div/div/ul/li[9]/select/option[1]
	//By AllOptionDropDownProperty=By.xpath("/html/body/div[1]/header/div/div/div/ul/li[9]/select/option");
	//List<WebElement>AllOptionDropDown=driver.findElements(AllOptionDropDownProperty);
	
	By SelectLanguageFromDropDownProperty=By.id("gtranslate_selector");
	WebElement SelectLanguageFromDropDown=driver.findElement(SelectLanguageFromDropDownProperty);
	SelectLanguageFromDropDown.click();
	
   	
   		

   	//<a id=":1.close" class="VIpgJd-ZVi9od-TvD9Pc-hSRGPd" href="#" title="Close"><img src="https://www.google.com/images/cleardot.gif" width="15" height="15" alt="Close" style="background-image:url(https://translate.googleapis.com/translate_static/img/te_ctrl3.gif);background-position:-28px 0px"></a>
   	Select LanguageSelection=new Select(SelectLanguageFromDropDown);
   	//class="VIpgJd-ZVi9od-TvD9Pc-hSRGPd"
   	LanguageSelection.selectByIndex(11);
   		///html/body/table/tbody/tr/td[7]/a
   	
   By closeproperty=By.className("VIpgJd-ZVi9od-TvD9Pc-hSRGPd");
   WebElement close=driver.findElement(closeproperty);
   close.click();
   	
   	
       }
   

			

		
	public static void main(String[] args) throws IOException {
		
		DropDownScrrenshots DropDown=new DropDownScrrenshots();
		DropDown.setup();
		DropDown.SelectDropDownOption();
		
	}

	
		
	}	

