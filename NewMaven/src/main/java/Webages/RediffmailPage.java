package Webages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseTest.RediffmailBaseTest;
import com.utility.Log;
import com.utility.PropertiesUserDefined;


public class RediffmailPage extends RediffmailBaseTest {

	//Create a new account
	public static void RediffmailNewAccount() throws IOException {
		
	String Property =PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","RediffmailPageCreateAccountProperty");
	By RediffmailNewAccountProperty=By.linkText(Property);
	WebElement RediffmailNewAccount=driver.findElement(RediffmailNewAccountProperty);
	RediffmailNewAccount.click();
	
	}
	public static void RediffmailNewAccountFullname(String FullName) throws IOException, InterruptedException {
		//String Property =PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","RediffmailPageCreateAccountTableProperty");

		//By Tableproperty=By.xpath(Property);
		//WebElement Table=driver.findElement(Tableproperty);
		String Property1 =PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","RediffmailPageCreateAccountFullNameProperty");
		By RediffmailNewAccountFullNameProperty=By.xpath(Property1);
		WebElement RediffmailNewAccountFullName=driver.findElement(RediffmailNewAccountFullNameProperty);
		Log.info("The full name is - "+FullName);
		RediffmailNewAccountFullName.sendKeys(FullName);
		Thread.sleep(10000);
	}
}
