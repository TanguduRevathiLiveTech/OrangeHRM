package com.AssignmentScriptOrangeHrmLoginPAgeExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestIngLoginDetails {
	
	WebDriver driver;
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	FileInputStream PropertiesFile;	
	Properties ElementProperties;	
		
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
		@Test(priority=1,description="validating Login Page with Expected Text Login Panel and Invalid Credentials")
		public void loginPanelTextAndInvalidCredintials() throws IOException {
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\config\\Element.properties");
			 ElementProperties = new Properties();
			ElementProperties.load(PropertiesFile);
			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(0);
		    String  TestDataLoginPanel=ExcekTestDataRowOfCell.getStringCellValue();

			String ExpectedLoginPageText=TestDataLoginPanel;
			System.out.println("The  Expected login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			 System.out.println("The Actual Login Page should Contains - "+ActualLoginPageText);
		
			
			System.out.println("*****************************************************************************");
			
		

		 ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(1);
	    String  ExpectedInvalidCrendentialsText=ExcelTestDataRowOfCell.getStringCellValue();

		
		System.out.println("The login page should contains text -"+ExpectedInvalidCrendentialsText);
		
		
	    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys("hbgrt");
		
		
	    By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	    WebElement PassWordProperty=driver.findElement(passWordProperty);
	    PassWordProperty.sendKeys("gehr");
	        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		//<span id="spanMessage">Invalid credentials</span>
			By InvalidcredentialsProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageInvalidCredentialsProperty"));
			WebElement Invalidcredentials=driver.findElement(InvalidcredentialsProperty);
			 String ActualInvalidCredentialsText=Invalidcredentials.getText();
			 ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			 Cell Actual=ExcelTestDataRow.createCell(2);
			 Actual.setCellValue(ActualLoginPageText+ " , "+ActualInvalidCredentialsText);
			System.out.println("The actual Login Page should contains "+ActualInvalidCredentialsText);
			
		if(ActualLoginPageText.equals(ExpectedLoginPageText) && ActualInvalidCredentialsText.equals(ExpectedInvalidCrendentialsText)) {
			System.out.println("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			System.out.println("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("*****************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
		}
		@Test(priority=2,description="Login to OrangeHrm with Valid Test Data ")
		public void TestData() throws IOException {
			
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(4);
		    String  TestDataUserNameValue=ExcekTestDataRowOfCell.getStringCellValue();
		    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			WebElement Username=driver.findElement(UsernameProperty);
			Username.sendKeys(TestDataUserNameValue);
			ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		    String TestDataPasswordValue=ExcekTestDataRowOfCell.getStringCellValue();
	        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	        WebElement PassWordProperty=driver.findElement(passWordProperty);
	        PassWordProperty.sendKeys(TestDataPasswordValue);
	        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
	        
		}
		@Test(priority=3,description="validating Home Page with Expected Text Admin")
		public void homePageValidation() throws IOException {
			
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");

			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
		    String  ExpectedHomePageText=ExcelTestDataRowOfCell.getStringCellValue();
			System.out.println("The Expected Text Homae page should contains - "+ExpectedHomePageText);
			By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);

			 String Actual_HomePageElementText=welcomeAdmin.getText();
			 XSSFCell ActualHomePageTextElement=ExcelTestDataRow.createCell(7);
			 ActualHomePageTextElement.setCellValue(Actual_HomePageElementText);
			 System.out.println("The Actual  is Element Text - "+Actual_HomePageElementText);
			 //Validating The text of the Element
			// Validating orangeHrm Home Page
			 
			   if(Actual_HomePageElementText.contains(ExpectedHomePageText))
			{
			System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			
			XSSFCell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			}
			else
			{
			System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			
			Cell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			HomePageTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			}
			   FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
				ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
				
			System.out.println("******************************************************************************************");
		}
		@Test(priority=4,description="Back to login page")
		public void logOut() throws IOException {
			By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
			 welcomeAdmin.click();
			 By logOutProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageLogOutProperty"));
			 WebElement logOut=driver.findElement(logOutProperty);
			 logOut.click();
			 FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
				XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
				XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
				
				XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
				XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(9);
			    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

				String ExpectedLoginPageText=TestDataLoginPanel;
				System.out.println("The login page should contains text -"+ExpectedLoginPageText);
				//<div id="logInPanelHeading">LOGIN Panel</div>
				By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
				WebElement LoginPanel=driver.findElement(LoginPanelProperty);
				String ActualLoginPageText=LoginPanel.getText();
				Cell loginPanel=ExcelTestDataRow.createCell(10);
				loginPanel.setCellValue(ActualLoginPageText);

				System.out.println("The Actual login panel should cantains - "+ActualLoginPageText);
				if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
					System.out.println("Successfully navigated to login page - PASS");
					Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
				}
				else {
					System.out.println("Failed navigated to login page - FAIL");
					Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

				}
				FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
				ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
						
			
			
		}
	    @AfterTest
		public void tearDown() {
			driver.close();
		}
}

		

		