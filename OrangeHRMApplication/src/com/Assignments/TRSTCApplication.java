package com.Assignments;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TRSTCApplication {

	public static void main(String[] args) {
		WebDriver driver;

		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		 
		
		By linksCommonProperty=By.tagName("a");
	
		
		List<WebElement>srini=driver.findElements(linksCommonProperty);
		
		
    int tsrtc_HomePageLinksCount=srini.size();
	System.out.println(" The number of links on the TSRTC Application HomePage are :- "+tsrtc_HomePageLinksCount);

	for(int index=0;index<srini.size();index++) 
	{
		
		WebElement ElementIndex=srini.get(index);
		String ElementName=ElementIndex.getText();
		System.out.println(ElementName);
		
			
		}
	
	
	driver.quit();
		
	}
}

		
	
		
	

	
	

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


