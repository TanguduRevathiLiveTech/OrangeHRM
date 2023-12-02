package com.ApplicationTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationApplicationTitle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver chromedriver=new ChromeDriver();
		chromedriver.get("https://google.com/");
		 String Actualresult =chromedriver.getTitle();
		 System.out.println("The title of google application is- "+Actualresult);
		chromedriver.quit();
		
		

	}

}
