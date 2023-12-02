package OrangeHRMTestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
@AfterTest
	public void TearDown() {
		driver.close();
		
	}
}
