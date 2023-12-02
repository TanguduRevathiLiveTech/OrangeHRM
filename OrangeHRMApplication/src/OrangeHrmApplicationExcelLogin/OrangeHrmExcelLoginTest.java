package OrangeHrmApplicationExcelLogin;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmExcelLoginTest {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		String OrangeHrmUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(OrangeHrmUrlAddress);
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHrmApplicationFile\\LoginTest.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("ExcelTestData");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(0);
	    String  TestDataUserNameValue=ExcekTestDataRowOfCell.getStringCellValue();
	    By UsernameProperty=By.id("txtUsername");
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys(TestDataUserNameValue);
		ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(1);
	    String TestDataPasswordValue=ExcekTestDataRowOfCell.getStringCellValue();
        By passWordProperty=By.name("txtPassword");
        WebElement PassWordProperty=driver.findElement(passWordProperty);
        PassWordProperty.sendKeys(TestDataPasswordValue);
        By LoginProperty=By.className("button");
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		
        
        
       
	}

}
