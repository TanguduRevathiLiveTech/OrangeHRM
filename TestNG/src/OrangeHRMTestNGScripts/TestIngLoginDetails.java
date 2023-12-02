package OrangeHRMTestNGScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.utility.Log;

public class TestIngLoginDetails extends BaseTest{
	
	
	FileInputStream PropertiesFile;	
	Properties ElementProperties;	
	
		@Test(priority=1,description="validating Login Page with Expected Text Login Panel and Invalid Credentials")
		public void loginPanelTextAndInvalidCredintials() throws IOException {
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\com\\config\\Element.properties");
			 ElementProperties = new Properties();
			ElementProperties.load(PropertiesFile);
			XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(0);
		    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

			String ExpectedLoginPageText=TestDataLoginPanel;
			Log.info("The  Expected login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			
			Log.info("The Actual Login Page should Contains - "+ActualLoginPageText);
		
			
			System.out.println("*****************************************************************************");
			
		

		 ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		 ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(1);
	    String  ExpectedInvalidCrendentialsText=ExcelTestDataRowOfCell.getStringCellValue();

		
		Log.info("The login page should contains text -"+ExpectedInvalidCrendentialsText);
		
		
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
			 Log.info("The actual Login Page should contains "+ActualInvalidCredentialsText);
			
		if(ActualLoginPageText.equals(ExpectedLoginPageText) && ActualInvalidCredentialsText.equals(ExpectedInvalidCrendentialsText)) {
			Log.info("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			Log.info("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("*****************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
		}
		@Test(priority=2,description="Login to OrangeHrm with Valid Test Data ")
		public void TestData() throws IOException  {
			 
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			
			  XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);
		    String  validTestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
		   // By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			//WebElement Username=driver.findElement(UsernameProperty);
			//Username.sendKeys(validTestDataUserNameValue);
			ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		    String validTestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
	       // By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	       // WebElement PassWordProperty=driver.findElement(passWordProperty);
	       // PassWordProperty.sendKeys(validTestDataPasswordValue);
	        //By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    //WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			//Login.click();
			//driver.navigate().back();
			//driver.navigate().refresh();
		
		
		
		
			int rowCount=ExcelTestDataSheet.getLastRowNum();
			Log.info("The number of rows - "+rowCount);
		
			for(int rowindex=1;rowindex<=rowCount;rowindex++) {
			
			
			
			 
			 ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			 ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);
			String TestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
			By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
            WebElement Username=driver.findElement(UsernameProperty);
			Username.sendKeys(TestDataUserNameValue);
			ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		    String TestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
	      By  passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	        WebElement PassWordProperty=driver.findElement(passWordProperty);
	        PassWordProperty.sendKeys(TestDataPasswordValue);
	        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
			Log.info("The User Name is  - "+TestDataUserNameValue);
			Log.info("The Password is - "+TestDataPasswordValue);
			
			
			if(TestDataUserNameValue.equals(validTestDataUserNameValue) && TestDataPasswordValue.equals(validTestDataPasswordValue))
			{

			 ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
			
		    String  ExpectedHomePageText=ExcelTestDataRowOfCell.getStringCellValue();
		    Log.info("The Expected Text Homae page should contains - "+ExpectedHomePageText);
			By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);

			 String Actual_HomePageElementText=welcomeAdmin.getText();
			
			 XSSFCell ActualHomePageTextElement=ExcelTestDataRow.createCell(7);
			 ActualHomePageTextElement.setCellValue(Actual_HomePageElementText);
			 Log.info("The Actual  is Element Text - "+Actual_HomePageElementText);
			 //Validating The text of the Element
			// Validating orangeHrm Home Page
			 
			   if(Actual_HomePageElementText.contains(ExpectedHomePageText))
			{
				   Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			
			XSSFCell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

			}
			else
			{
				Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			
			Cell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			HomePageTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			}
			  
			System.out.println("******************************************************************************************");
		}
			else {
				
				Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");

				Cell logInTestResultRowOfCell=ExcelTestDataRow.createCell(8);
				logInTestResultRowOfCell.setCellValue("  Failed to Navigated to OrangeHRM Application HomePage - FAIL");
				 File currentWebPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(currentWebPageScreenShot, new File("./LoginScreenshots/"+"_"+TestDataUserNameValue+"_"+TestDataPasswordValue+"_"+".png"));
	
			}
			 
					System.out.println("********************************************************************************************************");
					driver.navigate().back();
					driver.navigate().refresh();
			}
			 
		}
		@Test(priority=3,description="Back to login page")
		public void logOut() throws IOException {
			
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			
			XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);		
			String  validTestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
		    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			WebElement Username=driver.findElement(UsernameProperty);
			Username.sendKeys(validTestDataUserNameValue);
			ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		    String validTestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
	        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	        WebElement PassWordProperty=driver.findElement(passWordProperty);
	        PassWordProperty.sendKeys(validTestDataPasswordValue);
	        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
			By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
			 welcomeAdmin.click();
			 By logOutProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageLogOutProperty"));
			 WebElement logOut=driver.findElement(logOutProperty);
			 logOut.click();
			
				
				 ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
				 ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(9);
			    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

				String ExpectedLoginPageText=TestDataLoginPanel;
				Log.info("The login page should contains text -"+ExpectedLoginPageText);
				//<div id="logInPanelHeading">LOGIN Panel</div>
				By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
				WebElement LoginPanel=driver.findElement(LoginPanelProperty);
				String ActualLoginPageText=LoginPanel.getText();
				Cell loginPanel=ExcelTestDataRow.createCell(10);
				loginPanel.setCellValue(ActualLoginPageText);

				Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
				if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
					Log.info("Successfully navigated to login page - PASS");
					Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
				}
				else {
					Log.info("Failed navigated to login page - FAIL");
					Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");
					
				}
				FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
				ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
				
			
		}
	   
		}


		

		