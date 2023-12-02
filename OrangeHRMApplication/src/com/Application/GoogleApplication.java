package com.Application;

import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver chromedriver=new ChromeDriver();
		
		
		chromedriver.get("https://www.google.com/");
		chromedriver.close();

	}

}
