package com.LoginPageScrrenshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginScrrenshots {
	
	 WebDriver driver;
	 String a="Revathi";
		String b="Revathi@123";
     String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	     public void ApplicationLaunch()
	     {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe"); 
	    	 driver=new ChromeDriver();
	    	 driver.navigate().to(ApplicationUrlAddress);
	     }
	public void LoginPageDetails() throws IOException {
		
		
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHrmApplicationFile\\LoginTest.xlsx");
		//identifyting the WorkBook in the file
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		//identifying the sheet in workbook
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("ExcelTestData");
		//identifying the number of active rows in the sheet
		int rowCount=ExcelTestDataSheet.getLastRowNum();
		System.out.println("The number Active rows in the sheet - "+rowCount);
		
		for(int index=1;index<=rowCount;index++) {
			
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(index);
		System.out.println("The index number of current Row - "+index);
	  // To goto Every Active Row of All the Active Cells
		int rowOfCellsCount=ExcelTestDataRow.getLastCellNum();
		 
         //Going to particular row of cell
		int rowOfCell=0;
		
		//identifying the particular row of cell in the current active row
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(rowOfCell);
		//getting the value of the current active particular row of cell
	    String  TestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
	    System.out.println("The Testdata for the UserName - "+TestDataUserNameValue);
	    //identifying the property of the Username element
	    By UsernameProperty=By.id("txtUsername");
	    //identifying the usernamelement using the property
		WebElement Username=driver.findElement(UsernameProperty);
		//Operation should be performed on the element - UserName
		Username.sendKeys(TestDataUserNameValue);
		
	     
		//Going to next particular row of cell
		int rowOfCell1=1;
		//identifying the next particular row of cell in the current active row
		ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(rowOfCell1);
		//getting the value of the current active particular row of cell
	    String TestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
	    System.out.println("The Testdata for the Password - "+TestDataPasswordValue);
	  //identifying the property of the Password element
        By passWordProperty=By.name("txtPassword");
      //identifying the  Password element using the property
        WebElement PassWordProperty=driver.findElement(passWordProperty);
      //Operation should be performed on the element - Password
        PassWordProperty.sendKeys(TestDataPasswordValue);
        By LoginProperty=By.className("button");
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Login button
		Login.click();
		//validating that login page is navigating into home page or not
		if(TestDataUserNameValue.equals(a) && TestDataPasswordValue.equals(b)) {
			
		 By WelcomeAdminProperty=By.linkText("Welcome Admin");
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 
		 String Expected_ElementText="Admin";
		 System.out.println("The Expected Element Text- "+Expected_ElementText);
		 String Actual_ElementText=welcomeAdmin.getText();
		 System.out.println("The Actual  is Element Text - "+Actual_ElementText);
		 //Validating The text of the Element
		// Validating orangeHrm Home Page
		
		  
		   if(Actual_ElementText.contains(Expected_ElementText))
		{
		System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		
		XSSFCell logInTestResultRowOfCell=ExcelTestDataRow.createCell(2);
		logInTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		}
		else
		{
		System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		
		Cell logInTestResultRowOfCell=ExcelTestDataRow.createCell(2);
		logInTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		
		}
		   
		
		else {
			System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			
			Cell logInTestResultRowOfCell=ExcelTestDataRow.createCell(2);
			logInTestResultRowOfCell.setCellValue("  Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		
		
		System.out.println("****************************************************************");

		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHrmApplicationFile\\LoginTest.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		File currentWebPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(currentWebPageScreenShot, new File("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\Screenshots"+"_"+TestDataUserNameValue+"_"+TestDataPasswordValue+"_"+".png"));


		
		
		driver.navigate().back();
		driver.navigate().refresh();
		}
		
	}
	public void ApplicationClose() {
		
		driver.close();
	}
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		InvalidLoginScrrenshots Screenshots=new InvalidLoginScrrenshots();
		Screenshots.ApplicationLaunch();
		Screenshots.LoginPageDetails();
		Screenshots.ApplicationClose();
		
	}

}
