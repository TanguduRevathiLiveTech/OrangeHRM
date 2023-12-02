package com.autoit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoItFirstScript {
	WebDriver driver;
    FileInputStream PropertyFile;	
	Properties ElementProperties;	
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("SuccessFully Automated  to Chrome Browser");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("***************************************************************");
	}
	@Test(priority=1,description= "Login to orangeHrm Application")
	public void Loginpage() throws IOException {
	   PropertyFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\config\\Element.properties");
		 ElementProperties=new Properties();
		ElementProperties.load(PropertyFile);
		FileInputStream ExcelFile =new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\ValidTestData\\ValidData.xlsx");
		XSSFWorkbook ExcelWorkBook= new XSSFWorkbook(ExcelFile);
		XSSFSheet WorkBookSheet=ExcelWorkBook.getSheet("Sheet1");
		XSSFRow SheetOfRow=WorkBookSheet.getRow(1);
		XSSFCell RowofCell=SheetOfRow.getCell(0);
	String	UserNameTestData=RowofCell.getStringCellValue();
		//identifying the property of User name  element
		 By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		 //Finding the User name element by using property in the current page
		WebElement Username=driver.findElement(UsernameProperty);
		//Operation should be performed on the element - User Name
		Username.sendKeys(UserNameTestData);
		
		//<input name="txtPassword" id="txtPassword" auto complete="off" type="password">
		//identifying the property of Password Element
		//Test date is giving to Password element
		 SheetOfRow=WorkBookSheet.getRow(1);
		 RowofCell=SheetOfRow.getCell(1);
	     String	PasswordTestData=RowofCell.getStringCellValue();
	     By PasswordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		//Finding the element by using property in the current page
		WebElement Password=driver.findElement(PasswordProperty);
		//<input name="txtUsername" id="txtUsername" type="text">
		
		//Operation should be performed on the element - Password
		Password.sendKeys(PasswordTestData);
		
		
		//identifying the property of Login button Element
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	    By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		
		
		
	}
	@Test(priority=2,description= "Navigate to Employee list page")
	public void PIMEmployeeList() throws IOException, InterruptedException {
		
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\ValidTestData\\ValidData.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		By PIMElementProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePagePIMProperty"));
		WebElement PIM =driver.findElement(PIMElementProperty);
		PIM.click();
		System.out.println("Successfully perform operation on PIM element");
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
			By AddEmployeeElementProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageAddEmployeeProperty"));
		
			WebElement AddEmployee =driver.findElement(AddEmployeeElementProperty);
			AddEmployee.click();
			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(2);
		    String  TestDataFirstName=ExcekTestDataRowOfCell.getStringCellValue();
		  //  <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		    By FirstNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageFirstnameProperty"));
			WebElement FirstName=driver.findElement(FirstNameProperty);
			
			FirstName.sendKeys( TestDataFirstName);
			
			Actions keyBoardActions = new Actions(driver);
			keyBoardActions.sendKeys(Keys.TAB).build().perform();

			
			ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(3);
		    String TestDataMiddleName=ExcekTestDataRowOfCell.getStringCellValue();
	       // By MiddleNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageMiddlenameProperty"));
	        //WebElement MiddleName=driver.findElement(MiddleNameProperty);
	      //  MiddleName.sendKeys(TestDataMiddleName);
	        
		   keyBoardActions.sendKeys(TestDataMiddleName).build().perform();

		// shifting the focus from the Middle Name to LastName
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(4);
	   String TestDataLastName=ExcekTestDataRowOfCell.getStringCellValue();
	   
		keyBoardActions.sendKeys(TestDataLastName).build().perform();

		keyBoardActions.sendKeys(Keys.TAB).build().perform(); // will move to EmployeeId

		keyBoardActions.sendKeys(Keys.TAB).build().perform(); // will move to Photograph

		keyBoardActions.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(10000);
		//java.lang.Runtime.getRuntime().exec("C:\\Users\\revat\\OneDrive\\Desktop\\Photograph.exe");
		java.lang.Runtime.getRuntime().exec("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\AutoIt\\EmployeeProfile.exe");
		Thread.sleep(10000);
		
		
	       // By LastNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageLastnameProperty"));
	       // WebElement LastName=driver.findElement(LastNameProperty);
	       // LastName.sendKeys(TestDataLastName);
	        //<label for="employeeId">Employee Id</label>
	        //<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
	        By EmployeeIDProperty=By.name(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageEmployeeIDProperty"));
	        WebElement EmployeeID=driver.findElement(EmployeeIDProperty);
	        String ExpectedEmployeIDValue=EmployeeID.getAttribute("value");
	        
	        By SaveProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageSaveButtonProperty"));
	        WebElement Save=driver.findElement(SaveProperty);
	        Save.click();
	}
}
	
