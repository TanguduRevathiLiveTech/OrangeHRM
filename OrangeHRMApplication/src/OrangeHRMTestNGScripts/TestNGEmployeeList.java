package OrangeHRMTestNGScripts;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestNGEmployeeList extends BaseTest {
	 FileInputStream PropertiesFile;	
	 	Properties ElementProperties;	
		
	
	@Test(priority=1,description= "Login to orangeHrm Application")
	public void Loginpage() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\config\\Element.properties");
		 ElementProperties = new Properties();
		ElementProperties.load(PropertiesFile);
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
	    String  TestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
	    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys(TestDataUserNameValue);
		System.out.println("The Test Data for User name - "+TestDataUserNameValue);
		ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(7);
	    String TestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
        WebElement PassWordProperty=driver.findElement(passWordProperty);
        PassWordProperty.sendKeys(TestDataPasswordValue);
        System.out.println("The Test Data for Password - "+TestDataPasswordValue);
        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	
		Login.click();
		By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 
		
			XSSFCell ExcelTestDataRowOfCell1=ExcelTestDataRow.getCell(8);
			String  HomePageTestData=ExcelTestDataRowOfCell1.getStringCellValue();

			String Expected_HomePageElementText=HomePageTestData;
			System.out.println("The expected Element Text - "+Expected_HomePageElementText);
		 String Actual_HomePageElementText=welcomeAdmin.getText();
		 System.out.println("The Actual  is Element Text - "+Actual_HomePageElementText);
		 
		   if(Actual_HomePageElementText.contains(Expected_HomePageElementText))
		{
		System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		
		
		}
		else
		{
		System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		
		
		
	}
	@Test(priority=2,description= "Navigate to Employee list page")
	public void PIMEmployeeList() throws IOException {
		By PIMElementProperty=By.id("menu_pim_viewPimModule");
		WebElement PIM =driver.findElement(PIMElementProperty);
		PIM.click();
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
		By EmployeeListProperty=By.linkText("Employee List");
		WebElement EmployeeList=driver.findElement(EmployeeListProperty);
		EmployeeList.click();
		///html/body/div[1]/div[3]/div[2]/div
		///html/body/div[1]/div[3]/div[2]/div/form
		
		By EmployyeListFormProperty=By.xpath("/html/body/div[1]/div[3]");
		WebElement EmployyeListForm=driver.findElement(EmployyeListFormProperty);
		//<a href="javascript:submitPage(2)" class="tiptip">Next</a>
		//By NextTablePageProperty=By.linkText("Next");
		// Going to the WebTable and finding the Number of Rows in it
		//List<WebElement>NextTablePage=EmployyeListForm.findElements(NextTablePageProperty);
		//  int Next =NextTablePage.size();
		
		
		By rowProperty=By.tagName("tr");
		// Going to the WebTable and finding the Number of Rows in it
		List<WebElement>rows=EmployyeListForm.findElements(rowProperty);
		System.out.println("The number of rows - "+rows.size());
		
        FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\EmployeeListExcelFile\\EmployeeList.xlsx");
        XSSFWorkbook ExcelworkBook =new XSSFWorkbook(ExcelFile);
        XSSFSheet WorkBookSheet = ExcelworkBook.getSheet("Sheet1");
       
   
    	 
		// in the WebTable - should goto every Row of the WebTable
		for(int rowIndex=1;rowIndex<rows.size();rowIndex++)
		{
		// Going to a particular Row
		
	 WebElement TableRow=rows.get(rowIndex);
	By rowOfCellProperty=By.tagName("td");
	List<WebElement>rowOfCells=TableRow.findElements(rowOfCellProperty);
				
         XSSFRow RowofSheet=WorkBookSheet.createRow(rowIndex);
         
		//  goto every Row of cell
         
		for(int rowOfCellIndex=0;rowOfCellIndex<rowOfCells.size();rowOfCellIndex++)
		{
		WebElement Cells=rowOfCells.get(rowOfCellIndex);
		String EmployeeDetails=Cells.getText();
		
		XSSFCell RowOfCell=RowofSheet.createCell(rowOfCellIndex);
		RowOfCell.setCellValue(EmployeeDetails);
		
		System.out.print(EmployeeDetails+ " | ");

		}
		System.out.println();
		//<a class="current" href="#">2</a>
		
		}
		
     
     
		FileOutputStream EmployeDetailsInExcelFile= new FileOutputStream("C:\\\\Users\\\\revat\\\\OneDrive\\\\Desktop\\\\OrangeHRMApplication\\\\OrangeHRMApplication\\\\src\\\\EmployeeListExcelFile\\\\EmployeeList.xlsx");
		ExcelworkBook.write(EmployeDetailsInExcelFile);
	}
	
	@Test(priority=3,description= "Back to login page")
	public void LogOut() {
		By WelcomeAdminProperty=By.linkText("Welcome Admin");
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 welcomeAdmin.click();
		 By logOutProperty=By.linkText("Logout");
		 WebElement logOut=driver.findElement(logOutProperty);
		 logOut.click();
		 
		 String ExpectedLoginPageText="LOGIN Panel";
			System.out.println("The login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id("logInPanelHeading");
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			

			System.out.println("The Actual login panel should cantains - "+ActualLoginPageText);
			if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
				System.out.println("Successfully navigated to login page - PASS");
				
			}
			else {
				System.out.println("Failed navigated to login page - FAIL");
			
			}
	}///html/body/div[1]/div[3]/div[2]/div/form/div[5]/ul/li[4]
	///html/body/div[1]/div[3]/div[2]/div/form/div[5]/ul/li[5]
	///html/body/div[1]/div[3]
	///html/body/div[1]/div[3]/div[2]/div/form/div[1]/ul/li[4]
}
