package com.ApplicationTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatationApplicationTitle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		ChromeDriver chromedriver=new ChromeDriver();
		chromedriver.get("https://google.com/");
		
	   String ExpectedResult="google"; // should be developed as "google"
	   System.out.println("The Expected title of home page should be "+ExpectedResult);	
		String ActualResult=chromedriver.getTitle();
		System.out.println("The title of google application is- "+ActualResult);
		chromedriver.quit();
		if (ActualResult.equals(ExpectedResult)) {
			System.out.println("The title of google home page is matched with expected result - Pass");
		}
		else {
			System.out.println("The Title og google home page is not matched with expected result -Fail");
		}

	}

}
