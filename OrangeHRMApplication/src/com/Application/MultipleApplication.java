package com.Application;

import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleApplication {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver chrome=new ChromeDriver();
		
		chrome.get("https://www.google.com/");
		chrome.navigate().to("https://www.youtube.com/");
		chrome.close();
	}
	}

