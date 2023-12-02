package tsrtclinksvalidation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TsrtcHeaderScrrenshots {

	WebDriver driver;
	
	String ApplicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
	public void Applicationlaunch() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public void TsrtcHeaderBlock() throws IOException {
		By HeaderBlockProperty=By.className("menu-wrap");
		WebElement HeaderBlock=driver.findElement(HeaderBlockProperty);
		By headerBlockLinksProperty=By.tagName("a");
		// Goto the Header Block and find the Elements of the Header Block
		List<WebElement>tsrtc_HeaderBlockLinks=HeaderBlock.findElements(headerBlockLinksProperty);
		int tsrtc_HeaderBlockLinks_Count=tsrtc_HeaderBlockLinks.size();
		System.out.println(" The number of links in the Header Block of TSRTC Application are :- "+tsrtc_HeaderBlockLinks_Count);
	
	
	for(int linksIndex=0;linksIndex<tsrtc_HeaderBlockLinks_Count;linksIndex=linksIndex+1)
	{

	String tsrtc_HeaderBlockLinkName=tsrtc_HeaderBlockLinks.get(linksIndex).getText();
	System.out.println(linksIndex+" - "+tsrtc_HeaderBlockLinkName);

	//getting the attribute value of href ( url which is set by the developer in the property )
	String expected_LinkPageCurrentUrlAddress=tsrtc_HeaderBlockLinks.get(linksIndex).getAttribute("href");
	System.out.println(expected_LinkPageCurrentUrlAddress);

	// Performing a click Operation on the Element of the Header Block
	tsrtc_HeaderBlockLinks.get(linksIndex).click();

	String actual_LinkPageTitle=driver.getTitle();
	String actual_LinkPageCurrentUrlAddress=driver.getCurrentUrl();

	System.out.println(actual_LinkPageTitle);
	System.out.println(actual_LinkPageCurrentUrlAddress);

	if(actual_LinkPageCurrentUrlAddress.equals(expected_LinkPageCurrentUrlAddress))
	{
	System.out.println(" Url Address Matched - Successfully Navigated to Expected Link WebPage - PASS");
	}
	else
	{
	System.out.println(" Url Address NOT Matched - Failed to Navigated to Expected Link WebPage - FAIL");
	}
	
		
	
	File bingScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(bingScreenShot, new File("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\Screenshots/1.png"));
	
		driver.navigate().back();
		
		HeaderBlock=driver.findElement(HeaderBlockProperty);
		tsrtc_HeaderBlockLinks=HeaderBlock.findElements(headerBlockLinksProperty);
	}
	
	}
	 public static void main(String[] args) throws IOException {
		
		TsrtcHeaderScrrenshots Tsrtc=new TsrtcHeaderScrrenshots();
		Tsrtc.Applicationlaunch();
		
	    Tsrtc.TsrtcHeaderBlock();
		
		
        
       
	}
	

}
