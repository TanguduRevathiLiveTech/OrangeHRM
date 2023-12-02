package com.Assignments;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;





public class hlo{
	
	

	


		public static void main(String[] args) throws IOException {

			// TODO Auto-generated method stubWebDriver driver;

		
			String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/";

			

			WebDriver driver;

			System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\browserDriverFiles\\chromedriver.exe");

			driver=new ChromeDriver();

			System.out.println("*****Successfully Launched Chrome Browser****");



			
			driver.get(applicationURLAddress);

			System.out.println("*****Successfully Navigated to OrangeHRM Application Login Page****");

			System.out.println("*****Successfully Navigated to OrangeHRM Application Login Page****");

			System.out.println("The URL Address Provided is :- "+applicationURLAddress);



			//Getting Title of OrangeHRM Application Login Page

			String expected_TitleofOrangeHRMApplicationLoginPage="OrangeHRM";

			System.out.println("The Expected Title of OrangeHRM Application LoginPage is:-  "+expected_TitleofOrangeHRMApplicationLoginPage);

			String actual_TitleofOrangeHRMApplicationLoginPage=driver.getTitle();

			System.out.println("The Actual Title of OrangeHRM Application LoginPage is :- "+actual_TitleofOrangeHRMApplicationLoginPage);





			System.out.println("****************");







			//Validating Title of Orange HRM Application Login Page

			if(actual_TitleofOrangeHRMApplicationLoginPage.equals(expected_TitleofOrangeHRMApplicationLoginPage))

			{

			System.out.println("The Title of OrangeHRM Application is MATCHED-PASS");



			}

			else

			{

			System.out.println("The Title of OrangeHRM Application is NOT MAtched-FAIL");



			}

			System.out.println("******Successfully Validated Title of OrangeHRM Application LoginPage***********");





			//Getting URL Address of OrangeHRM Application Login Page

			String expected_URLAddressofOrangeHRMApplicationLoginPage="orangehrm-4.2.0.1";

			System.out.println("The Expected_URLAddress of OrangeHRM Application Login Page is :- "+expected_URLAddressofOrangeHRMApplicationLoginPage);

			String actual_URLAddressofOrangeHRMApplicationLoginPage=driver.getCurrentUrl();

			System.out.println("The Actual_URLAddress of OrangeHRM Application Login Page is :- "+actual_URLAddressofOrangeHRMApplicationLoginPage);





			System.out.println("***********************");



			//Validation of URL Address of OrangeHRM Application Login Page

			if(actual_URLAddressofOrangeHRMApplicationLoginPage.contains(expected_URLAddressofOrangeHRMApplicationLoginPage))

			{

			System.out.println("The URL Address of OrangeHRM Application Login Page is MATCHED-PASS");

			}

			else

			{

			System.out.println("The URL Address of OrangeHRM Application Login Page is NOT MATCHED-FAIL");



			}

			System.out.println("*************Successfully Validated URLAddress of OrangeHRM Application LoginPage*********");

			//Navigating to OrangeHRM Application URL Address

			

			//Identify the Element Username on the OrangeHRM Application Login page by it's Property

			//Identify the Username Element Property on the OrangeHRM Application Login Page By Inspecting

			//<input name="txtUsername" id="txtUsername" type="text">

			//id-Locator

			//txtUsername-Selector

			//driver.findElement(By.id("txtUsername")).sendKeys("supraja");

			

			

	//Identify the File(Excel File) in the system

	FileInputStream multipleTestDataFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\Ner\\new.xlsx");

	//Identify the WorkBook in the Excel File

	XSSFWorkbook workBook =new XSSFWorkbook(multipleTestDataFile);

	//Identify the Sheet in the WorkBook

	XSSFSheet testDataSheet=workBook.getSheet("Sheet1");

	//Identify the Number of active Rows in the Sheet

			int rowCount=testDataSheet.getLastRowNum();

			//Going to Every Active Row in the Sheet

			for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)

			{

				//Go to Particular Row

				XSSFRow testDataRow=testDataSheet.getRow(rowIndex);

				System.out.println(rowIndex);

				//In the Current Active Row finding no of Active RowofCells

				int rowofCellCount=testDataRow.getLastCellNum();

				

				
				

				//In Current Active Row going to every Active Cell

				XSSFCell testDataRowofActiveCell_1=testDataRow.getCell(0);

				

				String testData=testDataRowofActiveCell_1.getStringCellValue();

				

			     

			    System.out.println("userName"+"-"+testData);

			    
			    By userNameProperty=By.id("txtUsername");

				WebElement userName=driver.findElement(userNameProperty);
			    
				userName.sendKeys(testData);

				XSSFCell testDataRowofActiveCell_2=testDataRow.getCell(1);

				String testData1=testDataRowofActiveCell_2.getStringCellValue();

				  

				

				By passwordProperty=By.id("txtPassword");

				WebElement password=driver.findElement(passwordProperty);

			

				password.sendKeys(testData1);

				 System.out.println("password"+"-"+testData1);

				 

				//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

				 By loginProperty=By.id("btnLogin");

				 WebElement login=driver.findElement(loginProperty);

				 

				 login.click();

				 	 

	String validUserName="Revathi";

	String validPassword="Revathi@123";



	if(testData.equals(validUserName)&& testData1.equals(validPassword))

	{

		



	String expected_OrangeHRMApplicationHomePageText= "Welcome Admin";

	System.out.println("The Expected Text of Orange HRM Application HomePage is:-"+expected_OrangeHRMApplicationHomePageText);

					 

	 //<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>



	 By welcomeAdminProperty =By.id("welcome");

	 WebElement welcomeAdmin= driver.findElement(welcomeAdminProperty);

	 

	String	actual_TextofOrangeHRMHomePage=welcomeAdmin.getText();

	System.out.println("The ActualText of Orange HRM Application HomePage is:-"+actual_TextofOrangeHRMHomePage);





	if(actual_TextofOrangeHRMHomePage.contains(expected_OrangeHRMApplicationHomePageText))			

	{

					

				System.out.println("Successfully Navigated to OrangeHRM Application Home Page");

				XSSFCell testResult =testDataRow.createCell(2);

				testResult.setCellValue("Successfully Navigated to OrangeHRM Application Home Page");

	}

	else

	{

		System.out.println("Failed to Navigate to OrangeHRM Application Home Page");

		XSSFCell testResult =testDataRow.createCell(2);

		testResult.setCellValue("Failed to Navigate to OrangeHRM Application Home Page");

	}

	}



	else

	{

					System.out.println("Failed to Navigate to OrangeHRM Application Home Page");

				

				XSSFCell testResult =testDataRow.createCell(2);

			testResult.setCellValue("Failed to Navigate to OrangeHRM Application Home Page");

				

	}		

	FileOutputStream testResultFile =new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\Ner\\new.xlsx");

	workBook.write(testResultFile);

					

			

	driver.navigate().back();

	driver.navigate().refresh();







	}

			

			

		driver.quit();		

			

			





			

			





			

			

		}

		}


