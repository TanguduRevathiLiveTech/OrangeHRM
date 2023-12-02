package com.ExcelOperation;

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

import com.ExcelCommonMethods.ExcelOperationMethods;
import com.ExcelCommonMethods.ExcelOperationMethodsMultipleData;
import com.utility.Log;

public class TestIngLoginDetails1 extends BaseTest{
	
	
	FileInputStream PropertiesFile;	
	Properties ElementProperties;	
	
		@Test(priority=1,description="validating Login Page with Expected Text Login Panel and Invalid Credentials")
		public void loginPanelTextAndInvalidCredintials() throws IOException {
		//FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
		//XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		//XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\com\\config\\Element.properties");
			 ElementProperties = new Properties();
			ElementProperties.load(PropertiesFile);
		//XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		///XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(0);
		// String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

		//String ExpectedLoginPageText=TestDataLoginPanel;
		//Log.info("The  Expected login page should contains text -"+ExpectedLoginPageText);
		//<div id="logInPanelHeading">LOGIN Panel</div>
			
	String	ExpectedTestDataLoginPanelText=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 0);
		
	Log.info("The  Expected login page should contains text -"+ExpectedTestDataLoginPanelText);
			
	By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
	WebElement LoginPanel=driver.findElement(LoginPanelProperty);
	String ActualLoginPageText=LoginPanel.getText();
	Log.info("The Actual Login Page should Contains - "+ActualLoginPageText);
		
			
			System.out.println("*****************************************************************************");
			
		

		// ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		 //xcelTestDataRowOfCell=ExcelTestDataRow.getCell(1);
	   // String  ExpectedInvalidCrendentialsText=ExcelTestDataRowOfCell.getStringCellValue();

			String	ExpectedTestDataInavalidCredentials=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 1);

		Log.info("The Expected login page should contains text -"+ExpectedTestDataInavalidCredentials);
		
		
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
	    //C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx
		Login.click();
		//<span id="spanMessage">Invalid credentials</span>
		///TestNG/src/TestNgExcelFiles/OHRM_LogInTestData (1).xlsx
			By InvalidcredentialsProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageInvalidCredentialsProperty"));
			WebElement Invalidcredentials=driver.findElement(InvalidcredentialsProperty);
			 String ActualInvalidCredentialsText=Invalidcredentials.getText();
			// ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			// Cell Actual=ExcelTestDataRow.createCell(2);
			 //Actual.setCellValue(ActualLoginPageText+ " , "+ActualInvalidCredentialsText);
			 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 2, ActualInvalidCredentialsText);
			 Log.info("The actual Login Page should contains "+ActualInvalidCredentialsText);
			
		if(ActualLoginPageText.equals(ExpectedTestDataLoginPanelText) && ActualInvalidCredentialsText.equals(ExpectedTestDataInavalidCredentials)) {
			Log.info("Successfully navigated to login page - PASS");
			//Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 2,"Successfully navigated to Login page - PASS" );

			//loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		
		else {
			Log.info("Failed navigated to login page - FAIL");
			//Cell loginPanelTestResult=ExcelTestDataRow.createCell(3);
			//loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");
			 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 2,"Failed navigated to login page - FAIL" );

		}
	
		System.out.println("*****************************************************************************");
	//	FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
		//ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
		}
		@Test(priority=2,description="Login to OrangeHrm with Valid Test Data ")
		public void TestData() throws IOException  {
			/* 
			FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			
			  XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);
		    String  validTestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
		    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
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
		*/
			String	ValidUsername=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 4);
			By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			WebElement Username=driver.findElement(UsernameProperty);
			Username.sendKeys(ValidUsername);
			
			String	ValidPassword=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 5);
			By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		       WebElement PassWordProperty=driver.findElement(passWordProperty);
		       PassWordProperty.sendKeys(ValidPassword);		
			//int rowCount=ExcelTestDataSheet.getLastRowNum();
			//Log.info("The number of rows - "+rowCount);
		
		       driver.navigate().back();
			   driver.navigate().refresh();
		 int row=ExcelOperationMethodsMultipleData.getRowValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1");
			//int rowCount=sheet.getLastRowNum();
			for( int rows=1;rows<=row;rows++) {
			//XSSFRow row =  sheet.getRow(rows);
			
			 
			// ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			// ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);
			//String TestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
			 UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
            Username=driver.findElement(UsernameProperty);
            String	TestDataUsername=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", rows, 4);
			//String	TestdatPassword=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 5);
			Username.sendKeys(TestDataUsername);
			//ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			//ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		   // String TestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
			String	TestdataPassword=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", rows, 5);

	        passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	        PassWordProperty=driver.findElement(passWordProperty);
	        PassWordProperty.sendKeys(TestdataPassword);
	        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		    //Finding the element by using property in the current page
		    WebElement Login=driver.findElement(LoginProperty);
		    //Operation should be performed on the element - Password
			Login.click();
			Log.info("The User Name is  - "+TestDataUsername);
			Log.info("The Password is - "+TestdataPassword);
			
			
			if(TestDataUsername.equals(ValidUsername) && TestdataPassword.equals(ValidPassword))
			{

			// ExcelTestDataRow=ExcelTestDataSheet.getRow(rowindex);
			//ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
				String	ExpectedHomePageText=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 5);

		    //String  ExpectedHomePageText=ExcelTestDataRowOfCell.getStringCellValue();
		    Log.info("The Expected Text Homae page should contains - "+ExpectedHomePageText);
			By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
			 //identify the element by using the property
			 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);

			 String Actual_HomePageElementText=welcomeAdmin.getText();
			
			 //XSSFCell ActualHomePageTextElement=ExcelTestDataRow.createCell(7);
			// ActualHomePageTextElement.setCellValue(Actual_HomePageElementText);
			 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 7, Actual_HomePageElementText);

			 Log.info("The Actual  is Element Text - "+Actual_HomePageElementText);
			 //Validating The text of the Element
			// Validating orangeHrm Home Page
			 
			   if(Actual_HomePageElementText.contains(ExpectedHomePageText))
			{
				   Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

					 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", rows, 8,"SuccessFully to Navigated to OrangeHRM Application HomePage - PASS" );

			//XSSFCell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			//HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");
				   
			}
			else
			{
				Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
				 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", rows, 8,"Failed to Navigated to OrangeHRM Application HomePage - FAIL" );

			//Cell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(8);
			//HomePageTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			}
			  
			System.out.println("******************************************************************************************");
		}
			else {
				
				Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
				 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", rows, 8,"Failed to Navigated to OrangeHRM Application HomePage - FAIL" );

				//Cell logInTestResultRowOfCell=ExcelTestDataRow.createCell(8);
				//logInTestResultRowOfCell.setCellValue("  Failed to Navigated to OrangeHRM Application HomePage - FAIL");
				 File currentWebPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(currentWebPageScreenShot, new File("./LoginScreenshots/"+"_"+TestDataUsername+"_"+TestdataPassword+"_"+".png"));
	
			}
			 
					System.out.println("********************************************************************************************************");
					driver.navigate().back();
					driver.navigate().refresh();
			}
			 
		}
		
		@Test(priority=3,description="Back to login page")
		public void logOut() throws IOException {
			
			//FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx");
			//XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			//XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			
			//XSSFRow  ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			//XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(4);		
			//String  validTestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
			//String	TestdataPassword=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 5);
			String	TestdataUserName=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 4);

			By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
			WebElement Username=driver.findElement(UsernameProperty);
			Username.sendKeys(TestdataUserName);
			String	TestdataPassword=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 5);

			//ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			//ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(5);
		    //String validTestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
	        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
	        WebElement PassWordProperty=driver.findElement(passWordProperty);
	        PassWordProperty.sendKeys(TestdataPassword);
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
			
				
				 //ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			//	 ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(9);
			  //  String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();
			 String ExpectedLoginPageText =ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 9);
				//String ExpectedLoginPageText=TestDataLoginPanel;
				Log.info("The login page should contains text -"+ExpectedLoginPageText);
				//<div id="logInPanelHeading">LOGIN Panel</div>
				By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
				WebElement LoginPanel=driver.findElement(LoginPanelProperty);
				String ActualLoginPageText=LoginPanel.getText();
				//Cell loginPanel=ExcelTestDataRow.createCell(10);
				//loginPanel.setCellValue(ActualLoginPageText);
                ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1, 10, ActualLoginPageText);
				Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
				if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
					Log.info("Successfully navigated to login page - PASS");
					ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1,11, "Successfully navigated to login page - PASS");

					//Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					//loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
				}
				else {
					Log.info("Failed navigated to login page - FAIL");
					ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\OHRM_LogInTestData (1).xlsx", "Sheet1", 1,11, "Failed navigated to login page - FAIL");

					//Cell loginPanelTestResult=ExcelTestDataRow.createCell(11);
					//loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");
					
				}
				
			
		}
	   
		}


		

		