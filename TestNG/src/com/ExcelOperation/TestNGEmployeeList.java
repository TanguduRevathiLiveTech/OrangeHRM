package com.ExcelOperation;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ExcelCommonMethods.ExcelOperationMethods;
import com.utility.Log;

public class TestNGEmployeeList extends BaseTest {
	 FileInputStream PropertiesFile;	
	 	Properties ElementProperties;	
	 	
	
	@Test(priority=1,description= "Login to orangeHrm Application")
	public void Loginpage() throws IOException {
		
		 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\com\\config\\Element.properties");
		 ElementProperties = new Properties();
		ElementProperties.load(PropertiesFile);
		
	    String  TestDataUserNameValue=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx","Sheet1", 1, 0);
	    		
	    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username=driver.findElement(UsernameProperty);
		
		
		Username.sendKeys(TestDataUserNameValue);
		Log.info("The Test Data for User name - "+TestDataUserNameValue);
		
		String TestDataPasswordValue=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 1);
        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
        WebElement PassWordProperty=driver.findElement(passWordProperty);
       PassWordProperty.sendKeys(TestDataPasswordValue);
       Log.info("The Test Data for Password - "+TestDataPasswordValue);
         By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	     WebElement Login=driver.findElement(LoginProperty);
	
		Login.click();
		By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 
		
			
		 String Expected_HomePageElementText=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 2);
			Log.info("The expected Element Text - "+Expected_HomePageElementText);
		 String Actual_HomePageElementText=welcomeAdmin.getText();
		
		 ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 3, Actual_HomePageElementText);
		 Log.info("The Actual  is Element Text - "+Actual_HomePageElementText);
		 
		   if(Actual_HomePageElementText.contains(Expected_HomePageElementText))
		{
			   Log.info("Succesfully Navigated to OrangeHRM Application HomePage - PASS");
			  
ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 4, "Succesfully Navigated to OrangeHRM Application HomePage - PASS");
		
		
		}
		else
		{
			Log.info("Failed to Navigated to OrangeHRM Application HomePage - FAIL");
			
ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 4, "Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		
		  
	}
	@Test(priority=2,description= "Navigate to Employee list page")
	public void PIMEmployeeList() throws IOException {
		
		
        
		By PIMElementProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePagePIMProperty"));
		WebElement PIM =driver.findElement(PIMElementProperty);
		PIM.click();
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
		By EmployeeListProperty=By.linkText(ElementProperties.getProperty("orangeHRMApplicationEmployeeListProperty"));
		WebElement EmployeeList=driver.findElement(EmployeeListProperty);
		EmployeeList.click();
		;
		String  ExpectedEmployeeListPageText=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 5);
		Log.info("The Expected EmployeeList Page Text - "+ExpectedEmployeeListPageText);

		By EmployeeListpropertyText=By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1");
		WebElement EmployeeListText=driver.findElement(EmployeeListpropertyText);
		String ActualEmployeeListText=EmployeeListText.getText();
		Log.info("The Actual Home Page Text - "+ActualEmployeeListText);
		
		ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 6, ActualEmployeeListText);
		if(ActualEmployeeListText.equals(ExpectedEmployeeListPageText)) {
			Log.info("Succesfully Navigated to OrangeHRM Application Employee list Page - PASS");
			   
				ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 7, "Succesfully Navigated to OrangeHRM Application Employee list Page - PASS");
		
		}
		else
		{
			Log.info("Failed to Navigated to OrangeHRM Application Employee list Page - FAIL");
		
			ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 7,"Failed to Navigated to OrangeHRM Application Employee list Page - FAIL" );

		}
		
		
		}
	@Test(priority=3,description= "Navigate to Employee list page and Display Employee Details")
		public void EmployeeDetails() throws IOException {
			
	        
	        
		By EmployyeListFormProperty=By.xpath(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormProperty"));
		WebElement EmployyeListForm=driver.findElement(EmployyeListFormProperty);
		//<a href="javascript:submitPage(2)" class="tiptip">Next</a>
		//By NextTablePageProperty=By.linkText("Next");
		// Going to the WebTable and finding the Number of Rows in it
		//List<WebElement>NextTablePage=EmployyeListForm.findElements(NextTablePageProperty);
		//  int Next =NextTablePage.size();
		
		
		By rowProperty=By.tagName(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormRowsProperty"));
		// Going to the WebTable and finding the Number of Rows in it
		List<WebElement>rows=EmployyeListForm.findElements(rowProperty);
		Log.info("The number of rows - "+rows.size());
		
        
       
   
    	 
		// in the WebTable - should goto every Row of the WebTable
		for(int rowIndex=1;rowIndex<rows.size();rowIndex++)
		{
		// Going to a particular Row
		
	 WebElement TableRow=rows.get(rowIndex);
	By rowOfCellProperty=By.tagName(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormrowOfcellsProperty"));
	List<WebElement>rowOfCells=TableRow.findElements(rowOfCellProperty);
				
     
         
		for(int rowOfCellIndex=0;rowOfCellIndex<rowOfCells.size();rowOfCellIndex++)
		{
		WebElement Cells=rowOfCells.get(rowOfCellIndex);
		String EmployeeDetails=Cells.getText();
		
		ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList.xlsx", "Sheet1", rowIndex, rowOfCellIndex, EmployeeDetails);
		Log.info(EmployeeDetails+ " | ");

		}
		
		//<a class="current" href="#">2</a>
		
		}
		
     
     
		
	}
	
	@Test(priority=4,description= "Back to login page")
	public void LogOut() throws IOException {
		
		
		By WelcomeAdminProperty=By.linkText("Welcome Admin");
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 welcomeAdmin.click();
		 By logOutProperty=By.linkText("Logout");
		 WebElement logOut=driver.findElement(logOutProperty);
		 logOut.click();
		
		 String  ExpectedLoginPageText=	ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 8);
			Log.info("The login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id("logInPanelHeading");
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			
		
			ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 9, ActualLoginPageText);

			 Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
			if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
				Log.info("Successfully navigated to login page - PASS");
				
				ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 10, "Succesfully Navigated to OrangeHRM Application Login Page - PASS");

				
			}
			else {
				Log.info("Failed navigated to login page - FAIL");
			
			ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\EmployeeList (2).xlsx", "Sheet1", 1, 10, "Failed Navigated to OrangeHRM Application Login Page - FAIL");
				
			}
			
	}
}
