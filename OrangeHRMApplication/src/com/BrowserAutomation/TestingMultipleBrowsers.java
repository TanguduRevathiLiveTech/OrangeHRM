package com.BrowserAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingMultipleBrowsers {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver chromeDriver=new ChromeDriver();
		
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\msedgedriver.exe");
		EdgeDriver edgeDriver=new EdgeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\geckodriver.exe");
	    FirefoxDriver firefoxDriver=new FirefoxDriver();
	}

}
