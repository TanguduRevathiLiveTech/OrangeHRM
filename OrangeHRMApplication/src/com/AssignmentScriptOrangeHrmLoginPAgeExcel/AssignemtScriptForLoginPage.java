package com.AssignmentScriptOrangeHrmLoginPAgeExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class AssignemtScriptForLoginPage {
	WebDriver driver;
String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	
	
	
	public void Applicationlaunch() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.navigate().to(ApplicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("SuccessFully Automated  to Chrome Browser");
		System.out.println("***************************************************************");
	
		
	}
	public void LoginPanelTextAndInvalidCredintials() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(0);
	    String  TestDataLoginPanel=ExcekTestDataRowOfCell.getStringCellValue();

		String ExpectedLoginPageText=TestDataLoginPanel;
		System.out.println("The  Expected login page should contains text -"+ExpectedLoginPageText);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		By LoginPanelProperty=By.id("logInPanelHeading");
		WebElement LoginPanel=driver.findElement(LoginPanelProperty);
		String ActualLoginPageText=LoginPanel.getText();
		 System.out.println("The Actual Login PAge should Contains - "+ActualLoginPageText);
	
		
		System.out.println("*****************************************************************************");
		
	

	 ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
	XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(1);
    String  ExpectedInvalidCrendentialsText=ExcelTestDataRowOfCell.getStringCellValue();

	
	System.out.println("The login page should contains text -"+ExpectedInvalidCrendentialsText);
	
	
    By UsernameProperty=By.id("txtUsername");
	WebElement Username=driver.findElement(UsernameProperty);
	Username.sendKeys("hbgrt");
	
	
    By passWordProperty=By.name("txtPassword");
    WebElement PassWordProperty=driver.findElement(passWordProperty);
    PassWordProperty.sendKeys("gehr");
        By LoginProperty=By.className("button");
    //Finding the element by using property in the current page
    WebElement Login=driver.findElement(LoginProperty);
    //Operation should be performed on the element - Password
	Login.click();
	//<span id="spanMessage">Invalid credentials</span>
		By InvalidcredentialsProperty=By.id("spanMessage");
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
	FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
	ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
	
	}
	public void ValidLoginTestData() throws IOException {
		
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(4);
	    String  TestDataUserNameValue=ExcekTestDataRowOfCell.getStringCellValue();
	    By UsernameProperty=By.id("txtUsername");
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys(TestDataUserNameValue);
		ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(5);
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
	public void HomepageValidation() throws IOException {
		
		FileInputStream ExcelFile=new FileInputStream("C:\\\\Users\\\\revat\\\\OneDrive\\\\Desktop\\\\OrangeHRMApplication\\\\OrangeHRMApplication\\\\src\\\\OrangeHRMLogonPageExcelSheet\\\\OHRM_LogInTestData (1).xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");

		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
	    String  ExpectedHomePageText=ExcelTestDataRowOfCell.getStringCellValue();
		System.out.println("The Expected Text Homae page should contains - "+ExpectedHomePageText);
		By WelcomeAdminProperty=By.linkText("Welcome Admin");
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
		public void LogOut() throws IOException {
			By WelcomeAdminProperty=By.linkText("Welcome Admin");
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
			 welcomeAdmin.click();
			 By logOutProperty=By.linkText("Logout");
			 WebElement logOut=driver.findElement(logOutProperty);
			 logOut.click();
			 FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
				XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
				XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
				
				XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
				XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(9);
			    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

				String ExpectedLoginPageText=TestDataLoginPanel;
				System.out.println("The login page should contains text -"+ExpectedLoginPageText);
				//<div id="logInPanelHeading">LOGIN Panel</div>
				By LoginPanelProperty=By.id("logInPanelHeading");
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
				FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHRMLogonPageExcelSheet\\OHRM_LogInTestData (1).xlsx");
				ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
			
			
			
		}
		public void ApplicationClose() {
			driver.close();
		}
	public static void main(String[] args) throws IOException {
		
	
	
	AssignemtScriptForLoginPage LoginPage=new AssignemtScriptForLoginPage();
	LoginPage.Applicationlaunch();
	LoginPage.LoginPanelTextAndInvalidCredintials();
	LoginPage.ValidLoginTestData();
	LoginPage.HomepageValidation();
	LoginPage.LogOut();
	LoginPage.ApplicationClose();
	
	
	
	
	}
}
