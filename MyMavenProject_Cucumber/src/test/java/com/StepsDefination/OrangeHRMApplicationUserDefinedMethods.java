package com.StepsDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationUserDefinedMethods {

	 public static  WebDriver driver;
		String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@Given("^User should be open a chrome browser in the system$")
	public void user_should_be_open_a_chrome_browser_in_the_system()  {
		System.setProperty("webdriver.chrome.driver","./MyMavenProject_Cucumber/ChromeDriver/chromedriver.exe");
	    driver=new ChromeDriver();
	    Log.info("***********Successfully Launched Chrome Browser*************");
	}

	@When("^User enter a url address of OrangeHrm Application$")
	public void user_enter_a_url_address_of_OrangeHrm_Application()  {
		driver.navigate().to(ApplicationUrlAddress);
		Log.info("SuccessFully navigated to OrangeHRM Application");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   
	}

	@Then("^User should be navigated to OrangeHRM Application login page$")
	public void user_should_be_navigated_to_OrangeHRM_Application_login_page() {
		String ExpectedLoginPanelText="LOGIN Panel";
		Log.info("The Expected OrangeHRM Application Login Panel Text"+ExpectedLoginPanelText);
		By LoginPanelProperty= By.id("logInPanelHeading");
		WebElement LoginPanel=driver.findElement(LoginPanelProperty);
		
		String ActualLoginPanelText=LoginPanel.getText();
		Log.info("The Actual OrangeHRM Application Login Panel Text"+ActualLoginPanelText);
		if(ActualLoginPanelText.equals(ExpectedLoginPanelText)) {
			Log.info("SuccessFully navigated to OrangeHRM Application Login Page - PASS ");
		}
		else {
			Log.info("Failed To navigate OrangeHRM Application Login Page - FAIL");
		}
	}

	@Then("^User should be close the OrangeHRM application Along with the browser$")
	public void user_should_be_close_the_OrangeHRM_application_Along_with_the_browser() {
	driver.quit();
	Log.info("****************SuccessFully Close the OrangeHRM Application Along With Browser");
	}


	
}
