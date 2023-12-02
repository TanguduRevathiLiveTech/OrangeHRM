package OrangeHRMTestNGScripts;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.Log;

public class TestNGAddEmployee extends BaseTest{
     FileInputStream PropertiesFile;	
 	Properties ElementProperties;	
	
	
	
	
	@Test(priority=1,description=" Validating OrangeHrm LoginPage Using Loginpanel Text")
	public void LoginPanelText() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");

		 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\com\\config\\Element.properties");
		 ElementProperties = new Properties();
		ElementProperties.load(PropertiesFile);
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(0);
	    String  TestDataLoginPanel=ExcekTestDataRowOfCell.getStringCellValue();

		String ExpectedLoginPageText=TestDataLoginPanel;
		Log.info("The login page should contains text -"+ExpectedLoginPageText);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
		WebElement LoginPanel=driver.findElement(LoginPanelProperty);
		String ActualLoginPageText=LoginPanel.getText();
		Cell loginPanel=ExcelTestDataRow.createCell(1);
		loginPanel.setCellValue(ActualLoginPageText);

		Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
		if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
			Log.info("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(2);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			Log.info("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(2);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("*****************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
	}
	@Test(priority=2,description=" Validating OrangeHrm LoginPage Using Login page title")
	public void LoginPageTitle() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(3);
		String  TestDataLoginPageTitle=ExcelTestDataRowOfCell.getStringCellValue();

		String ExpectedLoginPageTitle=TestDataLoginPageTitle;		
		Log.info("The login page should contains Title -"+ExpectedLoginPageTitle);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		String ActualLoginPageTitle=driver.getTitle();
		Cell loginPanel=ExcelTestDataRow.createCell(4);
		loginPanel.setCellValue(ActualLoginPageTitle);

		Log.info("The Actual login panel should cantains - "+ActualLoginPageTitle);
		if(ActualLoginPageTitle.equals(ExpectedLoginPageTitle)) {
			Log.info("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(5);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			Log.info("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(5);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("***********************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
		
		
	}
	@Test(priority=3,description=" Validating OrangeHrm Home Page Using Admin Text")
	public void HomePageValidation() throws IOException
	{
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(6);
	    String  TestDataUserNameValue=ExcelTestDataRowOfCell.getStringCellValue();
	    By UsernameProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement Username=driver.findElement(UsernameProperty);
		Username.sendKeys(TestDataUserNameValue);
		Log.info("The Test Data for User name - "+TestDataUserNameValue);
		
		
		//ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(7);
	    String TestDataPasswordValue=ExcelTestDataRowOfCell.getStringCellValue();
        By passWordProperty=By.name(ElementProperties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
        WebElement PassWordProperty=driver.findElement(passWordProperty);
        PassWordProperty.sendKeys(TestDataPasswordValue);
        Log.info("The Test Data for Password - "+TestDataPasswordValue);
        By LoginProperty=By.className(ElementProperties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    //Finding the element by using property in the current page
	    WebElement Login=driver.findElement(LoginProperty);
	    //Operation should be performed on the element - Password
		Login.click();
		 By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 
		
			XSSFCell ExcelTestDataRowOfCell1=ExcelTestDataRow.getCell(8);
			String  HomePageTestData=ExcelTestDataRowOfCell1.getStringCellValue();

			String Expected_HomePageElementText=HomePageTestData;
			Log.info("The expected Element Text - "+Expected_HomePageElementText);
		 String Actual_HomePageElementText=welcomeAdmin.getText();
		 Log.info("The Actual  is Element Text - "+Actual_HomePageElementText);
		
		 Cell ActualHomePageTestData=ExcelTestDataRow.createCell(9);
		 ActualHomePageTestData.setCellValue(Actual_HomePageElementText);
		  
		   if(Actual_HomePageElementText.contains(Expected_HomePageElementText))
		{
			   Log.info(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		
		XSSFCell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(10);
		HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		}
		else
		{
			Log.info(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		
		Cell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(10);
		HomePageTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		   FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
			
		System.out.println("******************************************************************************************");
	}
	
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
	@Test(priority=4,description=" Perform operation on PIm alement in Home page")
	public void PImelement() throws IOException {
		
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		
		
		
		
		By PIMElementProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePagePIMProperty"));
		WebElement PIM =driver.findElement(PIMElementProperty);
		PIM.click();
		Log.info("Successfully perform operation on PIM element");
		
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
	
		By AddEmployeeElementProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageAddEmployeeProperty"));
	
		WebElement AddEmployee =driver.findElement(AddEmployeeElementProperty);
		AddEmployee.click();
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(11);
	    String  AddEmployeText=ExcelTestDataRowOfCell.getStringCellValue();
		String ExpectedAddEmployeText=AddEmployeText;
		Log.info("The Expected Text that Add Employee page should contains - "+ExpectedAddEmployeText);
	   //<label class="hasTopFieldHelp">Full Name</label>
	   ///html/body/div[1]/div[3]/div/div[1]      /html/body/div[1]/div[3]/div/div[2]/div[1]
	   By AddEmployeHeadBlockProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationHomePageAddEmployeeHeadBlockProperty"));
	   WebElement AddEmployeHeadBlock =driver.findElement(AddEmployeHeadBlockProperty);
	   By AddEmoloyePageValidationTextProperty=By.tagName(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageTextProperty"));
       WebElement AddEmployeePageValidationText=AddEmployeHeadBlock.findElement(AddEmoloyePageValidationTextProperty);
       
	   String ActualTextofAddEmployee=  AddEmployeePageValidationText.getText();
	   
	   Cell ActualPImValidationText=ExcelTestDataRow.createCell(12);
	   ActualPImValidationText.setCellValue(ActualTextofAddEmployee);
		  
	   Log.info("The Actual Text that Add Employee page should - " +ActualTextofAddEmployee);
	if(ActualTextofAddEmployee.contains(ExpectedAddEmployeText)) {
		Log.info("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
		XSSFCell PIMPageTestResultRowOfCell=ExcelTestDataRow.createCell(13);
		PIMPageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
	}
		
	else{	
		Log.info("Failed Navigated to OrangeHRM Application  AddEmployee Page - PASS");
		XSSFCell PIMPageTestResultRowOfCell=ExcelTestDataRow.createCell(13);
		PIMPageTestResultRowOfCell.setCellValue("Failed Navigated to OrangeHRM Application  AddEmployee Page - PASS");

	}
	FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
	ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
	System.out.println("*************************************************************************");
	}
	@Test(priority=5,description="Adding Emplyoee Details and Validating Employee Details")
	public void AddEmployeeDetails() throws IOException, InterruptedException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		for(int rowofindex=1;rowofindex<=3;rowofindex++) {
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(14);
	    String  TestDataFirstName=ExcekTestDataRowOfCell.getStringCellValue();
	  //  <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
	    By FirstNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageFirstnameProperty"));
		WebElement FirstName=driver.findElement(FirstNameProperty);
		
		FirstName.sendKeys( TestDataFirstName);
		Log.info("The First Name is - "+TestDataFirstName);
		Actions keyBoardActions = new Actions(driver);
		keyBoardActions.sendKeys(Keys.TAB).build().perform();

		ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(15);
	    String TestDataMiddleName=ExcekTestDataRowOfCell.getStringCellValue();
	    
	    keyBoardActions.sendKeys(TestDataMiddleName).build().perform();
	    Log.info("The Middle Name is - "+TestDataMiddleName);
	   // ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
		//ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(16);
	   // String TestDataLastName=ExcekTestDataRowOfCell.getStringCellValue();
		keyBoardActions.sendKeys(Keys.TAB).build().perform(); 
		// will move to EmployeeId
		 ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
			ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(16);
		    String TestDataLastName=ExcekTestDataRowOfCell.getStringCellValue();
		keyBoardActions.sendKeys(TestDataLastName).build().perform();
		Log.info("The Last Name is - "+TestDataLastName);
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		 // will move to EmployeeId
		  By EmployeeIDProperty=By.name(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageEmployeeIDProperty"));
	        WebElement EmployeeID=driver.findElement(EmployeeIDProperty);
	        String ExpectedEmployeIDValue=EmployeeID.getAttribute("value");
	//	keyBoardActions.sendKeys(Keys.TAB).build().perform();
	        
	        
		  ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
	        XSSFCell PIMPageemployeeID=ExcelTestDataRow.createCell(17);
	        PIMPageemployeeID.setCellValue(ExpectedEmployeIDValue);
// will move to Photograph
	        keyBoardActions.sendKeys(Keys.TAB).build().perform();
		keyBoardActions.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(10000);//C:\\Users\\revat\\OneDrive\\Desktop\\Photograph.exe
		java.lang.Runtime.getRuntime().exec("C:\\Users\\revat\\OneDrive\\Desktop\\Photograph.exe");
		//java.lang.Runtime.getRuntime().exec("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\AutoIt\\EmployeeProfile.exe");
		Thread.sleep(10000);
		//id="empPic"
		
		 
        //<label for="employeeId">Employee Id</label>
        //<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
       // By EmployeeIDProperty=By.name(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageEmployeeIDProperty"));
      //  WebElement EmployeeID=driver.findElement(EmployeeIDProperty);
        //String ExpectedEmployeIDValue=EmployeeID.getAttribute("value");
        
        //ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
       // XSSFCell PIMPageemployeeID=ExcelTestDataRow.createCell(17);
       // PIMPageemployeeID.setCellValue(ExpectedEmployeIDValue);

        
        By SaveProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageSaveButtonProperty"));
        WebElement Save=driver.findElement(SaveProperty);
        Save.click();///html/body/div[1]/div[3]/div/div[2]/div[1]
        //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPersonalDetails/empNumber/0020">Personal Details</a>
        ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
        XSSFCell ExcelFirstName=ExcelTestDataRow.getCell(18);
	    String  ExpectedPersonalDetailsPage=ExcelFirstName.getStringCellValue();
	    Log.info("The Expected Personal Details Page cantains Text - "+ExpectedPersonalDetailsPage);
	    //<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
	    ///html/body/div[1]/div[3]/div/div[2]/div[1]
	    By PersonalDetailsPageValidationProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsProperty"));
        WebElement PersonalDetailsPageValidation=driver.findElement(PersonalDetailsPageValidationProperty);
        By PersonalDetailsPageValidationTextProperty=By.tagName(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsTextProperty"));
        WebElement PersonalDetailsPageValidationText=PersonalDetailsPageValidation.findElement(PersonalDetailsPageValidationProperty);
        
	    String ActualPersonalDetailsPage=PersonalDetailsPageValidationText.getText();
	    Log.info("The Actual Personal Details Page cantains Text - "+ActualPersonalDetailsPage);
	    Cell PersonalDetailsPage=ExcelTestDataRow.createCell(19);
	    PersonalDetailsPage.setCellValue(ActualPersonalDetailsPage);
	    if(ActualPersonalDetailsPage.contains(ExpectedPersonalDetailsPage)) {
	    	
	    	Log.info("Successfully navigated to PersonalDetails page - Pass");
	    	XSSFCell personaldetailsvalidationTestResult=ExcelTestDataRow.createCell(20);
	    	personaldetailsvalidationTestResult.setCellValue("Successfully Navigated to OrangeHRM Application PersonalDetails Page - PASS");

	    }
	    else {
	    	Log.info("Falied navigated to Personal Details page");
			XSSFCell personaldetailsvalidationTestResult=ExcelTestDataRow.createCell(20);
			personaldetailsvalidationTestResult.setCellValue("Failed Navigated to OrangeHRM Application PersonalDetails Page - PASS");

		}
	    
	    //<input value="T" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name"
	    // id="personal_txtEmpFirstName" disabled="disabled">
	    
	    System.out.println("*********************************************************************");
	    
	    
	    By PersonalDetailsFirstNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsFirstnameProperty"));
	    WebElement PersonalDetailsFirstName=driver.findElement(PersonalDetailsFirstNameproperty);
	    String ActualFirstName=PersonalDetailsFirstName.getAttribute("Value");
	    Log.info("The Expected First Name - "+TestDataFirstName);
	    Log.info("The Actual First Name - "+ActualFirstName);
	    Cell ActualFirstNameCell=ExcelTestDataRow.createCell(21);
	    ActualFirstNameCell.setCellValue(ActualFirstName);
	    ///html/body/div[1]/div[3]/div/div[1]/div
	    By ImageProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsImageProperty"));
	    WebElement image=driver.findElement(ImageProperty);
	   By imageFullNameproperty= By.tagName(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsImageEmployeeNameProperty"));
	   WebElement imageFullName=image.findElement(imageFullNameproperty);
	   String ImageUpperSideFullName=imageFullName.getText();
	   
	    if( ActualFirstName.equals(TestDataFirstName) && ImageUpperSideFullName.contains(ActualFirstName)  )

	    {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual First Name - "+ActualFirstName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	Log.info("The Full name of personal details page is matched with Profile pic Full name");
	    	System.out.println("********************************************************");
	    	Log.info( "Expected first name in personal details matched with actual first name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(22);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected full name in personal details matched with actual full name");
	    	 
	    }
	    else {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual First Name - "+ActualFirstName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	Log.info("The Full name of personal details page is NOT matched with Propile pic Full name");
	    	System.out.println("********************************************************");

	    	Log.info( "Expected first name in personal details is not matched with actual first name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(22);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected first name in personal details is not matched with actual first name");

	    	
	    }
	    
	    
	    //<input value="Tangudu" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
	    By PersonalDetailsMiddleNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsMiddlenameProperty"));
	    WebElement PersonalDetailsMiddleName=driver.findElement(PersonalDetailsMiddleNameproperty);
	    String ActualMiddleName=PersonalDetailsMiddleName.getAttribute("Value");
	    Log.info("The Expected Middle Name - "+TestDataMiddleName);
	    Log.info("The Actual Middle Name - "+ActualMiddleName);
	    Cell ActualMiddleNameCell=ExcelTestDataRow.createCell(23);
	    ActualMiddleNameCell.setCellValue(ActualMiddleName);
	    if(ActualMiddleName.equals(TestDataMiddleName)&& ImageUpperSideFullName.contains(ActualMiddleName))
	    {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual Middle Name - "+ActualMiddleName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	Log.info("The Middle name of personal details page is matched with Profile pic Middle name");
    	    System.out.println("********************************************************");
    	    Log.info( "Expected Middle name in personal details matched with actual Middle name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(24);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected  middle name in personal details matched with actual  middle name");

	    }
	    else {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual Middle Name - "+ActualMiddleName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	Log.info("The Middle name of personal details page is  NOT matched with Profile pic Middle name");
    	    System.out.println("********************************************************");
    	    Log.info( "Expected Middle name in personal details is not matched with actual Middle name");
	    	XSSFCell personaldetailsvalidationMiddleNameTestResult=ExcelTestDataRow.createCell(24);
	    	personaldetailsvalidationMiddleNameTestResult.setCellValue("Expected Middle name in personal details is not matched with actual Middle name");

	    	
	    }
	    
	    //<input value="Revathi" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
	    By PersonalDetailsLastNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsLastnameProperty"));
	    WebElement PersonalDetailslastName=driver.findElement(PersonalDetailsLastNameproperty);
	    String ActualLastName=PersonalDetailslastName.getAttribute("Value");
	    Log.info("The Expected Last Name - "+TestDataLastName);
	    Log.info("The  Actual Last Name - "+ActualLastName);
	    Cell ActualLastNameCell=ExcelTestDataRow.createCell(25);
	    ActualLastNameCell.setCellValue(ActualLastName);
	    if( ActualLastName.equals(TestDataLastName)&& ImageUpperSideFullName.contains(ActualLastName)) {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual Middle Name - "+ActualLastName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	System.out.println("The Last name of personal details page is matched with Profile pic Last name");
	    	System.out.println("********************************************************");
	    	Log.info( "Expected Last name in personal details matched with actual last name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(26);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected Last name in personal details matched with actual Last name");

	    }
	    else {
	    	System.out.println("***********************************************************");
	    	Log.info("The Actual Last Name - "+ActualLastName);
	    	Log.info("The ImageUpperSideFullName - "+ImageUpperSideFullName);
	    	Log.info("The Last name of personal details page is NOT matched with Profile pic Last name");
	    	System.out.println("********************************************************");
	    	Log.info( "Expected Last name in personal details is not matched with actual Last name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(26);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected Last name in personal details is not matched with actual Last name");

	    	
	    }
	    
	    //<input value="0025" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" 
	    //id="personal_txtEmployeeId" disabled="disabled">
	    
	    By PersonalDetailsEmployeeIDProperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsEmployeeIDProperty"));
        WebElement PersonalDetailsEmployeeID=driver.findElement(PersonalDetailsEmployeeIDProperty);
        String ActualPersonalDetailsEmployeeIDValue=PersonalDetailsEmployeeID.getAttribute("value");
        Log.info("The Expected EmployeeID - "+ExpectedEmployeIDValue);
        Log.info("The  Actual EmployeeID - "+ActualPersonalDetailsEmployeeIDValue);
        
        ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
        XSSFCell ActualemployeeID=ExcelTestDataRow.createCell(27);
        ActualemployeeID.setCellValue(ActualPersonalDetailsEmployeeIDValue);
        if(ActualPersonalDetailsEmployeeIDValue.equals(ExpectedEmployeIDValue)) {
        	Log.info( "Expected EmployeID in personal details matched with actual  EmployeID name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(28);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected  EmployeID name in personal details matched with actual  EmployeID name");

	    }
	    else {
	    	Log.info( "Expected EmployeID in personal details is not matched with actual  EmployeID name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(28);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected  EmployeID name in personal details is not matched with actual  EmployeID name");

	    	
	    }
        By ImageValidationProperty=By.id(ElementProperties.getProperty("OrangeHRMApplicationPersonalDetailsProfileProperty"));
		WebElement ImageValidation=driver.findElement(ImageValidationProperty);
		 boolean flag=ImageValidation.isDisplayed();
		 if(flag) {
			 Log.info("The Profile is Displayed SuccessFully in the Personal Details Page - "+flag);
		 }
		 else {
			 Log.info("The Profile is  Not Displayed SuccessFully in the Personal Details Page - "+flag);

		 }
       System.out.println("****************************************************************************");
        driver.navigate().back();
        driver.navigate().refresh();
		}
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
	}
	@Test(priority=6,description=" Back to Login Page")
	public void LogOut() throws IOException {
		By WelcomeAdminProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePageWelComAdminProperty"));
		 //identify the element by using the property
		 WebElement welcomeAdmin=driver.findElement(WelcomeAdminProperty);
		 welcomeAdmin.click();
		 By logOutProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageLogOutProperty"));
		 WebElement logOut=driver.findElement(logOutProperty);
		 logOut.click();
		 FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(29);
		    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

			String ExpectedLoginPageText=TestDataLoginPanel;
			Log.info("The login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			Cell loginPanel=ExcelTestDataRow.createCell(30);
			loginPanel.setCellValue(ActualLoginPageText);

			Log.info("The Actual login panel should cantains - "+ActualLoginPageText);
			if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
				Log.info("Successfully navigated to login page - PASS");
				Cell loginPanelTestResult=ExcelTestDataRow.createCell(31);
				loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
			}
			else {
				Log.info("Failed navigated to login page - FAIL");
				Cell loginPanelTestResult=ExcelTestDataRow.createCell(31);
				loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

			}
			FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\TestNG\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		    Log.info("******************************************************************************8");
	}
	

}