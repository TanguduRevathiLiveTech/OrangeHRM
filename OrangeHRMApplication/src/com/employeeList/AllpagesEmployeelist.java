package com.employeeList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AllpagesEmployeelist extends BaseTest {
	FileInputStream PropertyFile;	
 	Properties ElementProperties;
 	XSSFSheet WorkBookSheet;
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
public void PIMEmployeeList() throws IOException {
	By PIMElementProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePagePIMProperty"));
	WebElement PIM =driver.findElement(PIMElementProperty);
	PIM.click();
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
	By EmployeeListProperty=By.linkText(ElementProperties.getProperty("orangeHRMApplicationEmployeeListProperty"));
	WebElement EmployeeList=driver.findElement(EmployeeListProperty);
	EmployeeList.click();
	///html/body/div[1]/div[3]/div[2]/div
	///html/body/div[1]/div[3]/div[2]/div/form
	
	By EmployyeListFormProperty=By.xpath(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormProperty"));
	WebElement EmployyeListForm=driver.findElement(EmployyeListFormProperty);
	By NextPage=By.linkText("Next");
	//<a href="javascript:submitPage(3)" class="tiptip">Next</a>
	WebElement Next=EmployyeListForm.findElement(NextPage);
	
	
	By rowProperty=By.tagName(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormRowsProperty"));
	// Going to the WebTable and finding the Number of Rows in it
	List<WebElement>rows=EmployyeListForm.findElements(rowProperty);
	System.out.println("The number of rows - "+rows.size());
	
    FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\sheets\\sheets.xlsx");
    XSSFWorkbook ExcelworkBook =new XSSFWorkbook(ExcelFile);
    //<a href="javascript:submitPage(3)" class="tiptip">Next</a>
    XSSFSheet WorkBookSheet = ExcelworkBook.getSheet("Sheet1");

    
   for(int i=2;i<=3;i++) {
	  
   

	  

   
	// in the WebTable - should goto every Row of the WebTable
	for(int rowIndex=1;rowIndex<rows.size();rowIndex++)
	{
	// Going to a particular Row
	
  WebElement TableRow=rows.get(rowIndex);
  By rowOfCellProperty=By.tagName(ElementProperties.getProperty("orangeHRMApplicationEmployeeListFormrowOfcellsProperty"));
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
	Next.click();
	 WorkBookSheet = ExcelworkBook.createSheet("Sheet"+i);
   }
    
    
	FileOutputStream EmployeDetailsInExcelFile= new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\sheets\\sheets.xlsx");
	ExcelworkBook.write(EmployeDetailsInExcelFile);
}

  @Test(priority=3,description= "Back to login page")
   public void LogOut() {
	By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
	 //identify the element by using the property
	 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
	 welcomeAdmin.click();
	 By logOutProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageLogOutProperty"));
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
}
}
