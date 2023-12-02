package OrangeHrmApplicationExcelLogin;

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

public class TestNGPIMemployeeList {
     WebDriver driver;
     FileInputStream PropertiesFile;	
 	Properties ElementProperties;	
	String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	
	
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
	@Test(priority=1,description=" Validating OrangeHrm LoginPage Using Loginpanel Text")
	public void LoginPanelText() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");

		 PropertiesFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\config\\Element.properties");
		 ElementProperties = new Properties();
		ElementProperties.load(PropertiesFile);
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(0);
	    String  TestDataLoginPanel=ExcekTestDataRowOfCell.getStringCellValue();

		String ExpectedLoginPageText=TestDataLoginPanel;
		System.out.println("The login page should contains text -"+ExpectedLoginPageText);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
		WebElement LoginPanel=driver.findElement(LoginPanelProperty);
		String ActualLoginPageText=LoginPanel.getText();
		Cell loginPanel=ExcelTestDataRow.createCell(1);
		loginPanel.setCellValue(ActualLoginPageText);

		System.out.println("The Actual login panel should cantains - "+ActualLoginPageText);
		if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
			System.out.println("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(2);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			System.out.println("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(2);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("*****************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
	}
	@Test(priority=2,description=" Validating OrangeHrm LoginPage Using Login page title")
	public void LoginPageTitle() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(3);
		String  TestDataLoginPageTitle=ExcelTestDataRowOfCell.getStringCellValue();

		String ExpectedLoginPageTitle=TestDataLoginPageTitle;		
		System.out.println("The login page should contains Title -"+ExpectedLoginPageTitle);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		String ActualLoginPageTitle=driver.getTitle();
		Cell loginPanel=ExcelTestDataRow.createCell(4);
		loginPanel.setCellValue(ActualLoginPageTitle);

		System.out.println("The Actual login panel should cantains - "+ActualLoginPageTitle);
		if(ActualLoginPageTitle.equals(ExpectedLoginPageTitle)) {
			System.out.println("Successfully navigated to login page - PASS");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(5);
			loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
		}
		else {
			System.out.println("Failed navigated to login page - FAIL");
			Cell loginPanelTestResult=ExcelTestDataRow.createCell(5);
			loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

		}
		System.out.println("***********************************************************************************");
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		
		
		
	}
	@Test(priority=3,description=" Validating OrangeHrm Home Page Using Admin Text")
	public void HomePageValidation() throws IOException
	{
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
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
	    //Operation should be performed on the element - Password
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
		 //Validating The text of the Element
		// Validating orangeHrm Home Page
		 Cell ActualHomePageTestData=ExcelTestDataRow.createCell(9);
		 ActualHomePageTestData.setCellValue(Actual_HomePageElementText);
		  
		   if(Actual_HomePageElementText.contains(Expected_HomePageElementText))
		{
		System.out.println(" Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		
		XSSFCell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(10);
		HomePageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		}
		else
		{
		System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		
		Cell HomePageTestResultRowOfCell=ExcelTestDataRow.createCell(10);
		HomePageTestResultRowOfCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL");
		}
		   FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
			
		System.out.println("******************************************************************************************");
	}
	
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
	@Test(priority=4,description=" Perform operation on PIm alement in Home page")
	public void PImelement() throws IOException {
		
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
		
		
		
		
		
		By PIMElementProperty=By.id(ElementProperties.getProperty("orangehRMApplicationHomePagePIMProperty"));
		WebElement PIM =driver.findElement(PIMElementProperty);
		PIM.click();
		System.out.println("Successfully perform operation on PIM element");
		
	//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
	
		By AddEmployeeElementProperty=By.linkText(ElementProperties.getProperty("orangehRMApplicationHomePageAddEmployeeProperty"));
	
		WebElement AddEmployee =driver.findElement(AddEmployeeElementProperty);
		AddEmployee.click();
		XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
		XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(11);
	    String  PImValidation=ExcelTestDataRowOfCell.getStringCellValue();
		String ExpectedPImValidationText=PImValidation;
	   System.out.println("The Expected Text that Add Employee page should contains - "+ExpectedPImValidationText);
	   //<label class="hasTopFieldHelp">Full Name</label>
	   ///html/body/div[1]/div[3]/div/div[1]      /html/body/div[1]/div[3]/div/div[2]/div[1]
	   By AddEmployeHeadBlockProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationHomePageAddEmployeeHeadBlockProperty"));
	   WebElement AddEmployeHeadBlock =driver.findElement(AddEmployeHeadBlockProperty);
	   By AddEmoloyePageValidationTextProperty=By.tagName(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageTextProperty"));
       WebElement AddEmployeePageValidationText=AddEmployeHeadBlock.findElement(AddEmoloyePageValidationTextProperty);
       
	   String ActualTextofAddEmployee=  AddEmployeePageValidationText.getText();
	   Cell ActualPImValidationText=ExcelTestDataRow.createCell(12);
	   ActualPImValidationText.setCellValue(ActualTextofAddEmployee);
		  
	   System.out.println("The Actual Text that Add Employee page should - " +ActualTextofAddEmployee);
	if(ActualTextofAddEmployee.contains(ExpectedPImValidationText)) {
		System.out.println("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
		XSSFCell PIMPageTestResultRowOfCell=ExcelTestDataRow.createCell(13);
		PIMPageTestResultRowOfCell.setCellValue("Succesfully Navigated to OrangeHRM Application  Addemployee Page - PASS");
	}
		
	else{	
		System.out.println("Failed Navigated to OrangeHRM Application  AddEmployee Page - PASS");
		XSSFCell PIMPageTestResultRowOfCell=ExcelTestDataRow.createCell(13);
		PIMPageTestResultRowOfCell.setCellValue("Failed Navigated to OrangeHRM Application  AddEmployee Page - PASS");

	}
	FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
	ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
	System.out.println("*************************************************************************");
	}
	@Test(priority=5,description="Adding Emplyoee Details and Validating Employee Details")
	public void AddEmployeeDetails() throws IOException {
		FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
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
		ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(15);
	    String TestDataMiddleName=ExcekTestDataRowOfCell.getStringCellValue();
        By MiddleNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageMiddlenameProperty"));
        WebElement MiddleName=driver.findElement(MiddleNameProperty);
        MiddleName.sendKeys(TestDataMiddleName);
        ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
		ExcekTestDataRowOfCell=ExcelTestDataRow.getCell(16);
	    String TestDataLastName=ExcekTestDataRowOfCell.getStringCellValue();
        By LastNameProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageLastnameProperty"));
        WebElement LastName=driver.findElement(LastNameProperty);
        LastName.sendKeys(TestDataLastName);
        //<label for="employeeId">Employee Id</label>
        //<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
        By EmployeeIDProperty=By.name(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageEmployeeIDProperty"));
        WebElement EmployeeID=driver.findElement(EmployeeIDProperty);
        String ExpectedEmployeIDValue=EmployeeID.getAttribute("value");
        
        ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
        XSSFCell PIMPageemployeeID=ExcelTestDataRow.createCell(17);
        PIMPageemployeeID.setCellValue(ExpectedEmployeIDValue);

        
        By SaveProperty=By.id(ElementProperties.getProperty("orangehRMApplicationAddEmoloyePageSaveButtonProperty"));
        WebElement Save=driver.findElement(SaveProperty);
        Save.click();///html/body/div[1]/div[3]/div/div[2]/div[1]
        //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPersonalDetails/empNumber/0020">Personal Details</a>
                ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
        XSSFCell ExcelFirstName=ExcelTestDataRow.getCell(18);
	    String  ExpectedPersonalDetailsPage=ExcelFirstName.getStringCellValue();
	    System.out.println("The Expected Personal Details Page cantains Text - "+ExpectedPersonalDetailsPage);
	    //<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
	    ///html/body/div[1]/div[3]/div/div[2]/div[1]
	    By PersonalDetailsPageValidationProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsProperty"));
        WebElement PersonalDetailsPageValidation=driver.findElement(PersonalDetailsPageValidationProperty);
        By PersonalDetailsPageValidationTextProperty=By.tagName(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsTextProperty"));
        WebElement PersonalDetailsPageValidationText=PersonalDetailsPageValidation.findElement(PersonalDetailsPageValidationProperty);
        
	    String ActualPersonalDetailsPage=PersonalDetailsPageValidationText.getText();
	    System.out.println("The Actual Personal Details Page cantains Text - "+ActualPersonalDetailsPage);
	    Cell PersonalDetailsPage=ExcelTestDataRow.createCell(19);
	    PersonalDetailsPage.setCellValue(ActualPersonalDetailsPage);
	    if(ActualPersonalDetailsPage.contains(ExpectedPersonalDetailsPage)) {
	    	
	    	System.out.println("Successfully navigated to PersonalDetails page - Pass");
	    	XSSFCell personaldetailsvalidationTestResult=ExcelTestDataRow.createCell(20);
	    	personaldetailsvalidationTestResult.setCellValue("Successfully Navigated to OrangeHRM Application PersonalDetails Page - PASS");

	    }
	    else {
	    	System.out.println("Falied navigated to Personal Details page ");
			XSSFCell personaldetailsvalidationTestResult=ExcelTestDataRow.createCell(20);
			personaldetailsvalidationTestResult.setCellValue("Failed Navigated to OrangeHRM Application PersonalDetails Page - PASS");

		}
	    
	    //<input value="T" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name"
	    // id="personal_txtEmpFirstName" disabled="disabled">
	    
	    System.out.println("*********************************************************************");
	    
	    
	    By PersonalDetailsFirstNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsFirstnameProperty"));
	    WebElement PersonalDetailsFirstName=driver.findElement(PersonalDetailsFirstNameproperty);
	    String ActualFirstName=PersonalDetailsFirstName.getAttribute("Value");
	    System.out.println("The Expected First Name - "+TestDataFirstName);
	    System.out.println("The Actual First Name - "+ActualFirstName);
	    Cell ActualFirstNameCell=ExcelTestDataRow.createCell(21);
	    ActualFirstNameCell.setCellValue(ActualFirstName);
	    ///html/body/div[1]/div[3]/div/div[1]/div
	    By ImageProperty=By.xpath(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsImageProperty"));
	    WebElement image=driver.findElement(ImageProperty);
	   By imageFullNameproperty= By.tagName(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsImageEmployeeNameProperty"));
	   WebElement imageFullName=image.findElement(imageFullNameproperty);
	   String imageFL=imageFullName.getText();
	    if( ActualFirstName.equals(TestDataFirstName) && imageFL.contains(ActualFirstName)  )

	    {
	    	System.out.println("***********************************************************");
	    	System.out.println("The Full name of personal details page is matched with Profile pic Full name");
	    	System.out.println("********************************************************");
	    	System.out.println( "Expected first name in personal details matched with actual first name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(22);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected full name in personal details matched with actual full name");
	    	 
	    }
	    else {
	    	System.out.println("***********************************************************");

	    	System.out.println("The Full name of personal details page is NOT matched with Propile pic Full name");
	    	System.out.println("********************************************************");

	    	System.out.println( "Expected first name in personal details is not matched with actual first name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(22);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected first name in personal details is not matched with actual first name");

	    	
	    }
	    
	    //<input value="Tangudu" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
	    By PersonalDetailsMiddleNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsMiddlenameProperty"));
	    WebElement PersonalDetailsMiddleName=driver.findElement(PersonalDetailsMiddleNameproperty);
	    String ActualMiddleName=PersonalDetailsMiddleName.getAttribute("Value");
	    System.out.println("The Expected Middle Name - "+TestDataMiddleName);
	    System.out.println("The Actual Middle Name - "+ActualMiddleName);
	    Cell ActualMiddleNameCell=ExcelTestDataRow.createCell(23);
	    ActualMiddleNameCell.setCellValue(ActualMiddleName);
	    if(ActualMiddleName.equals(TestDataMiddleName)&& imageFL.contains(ActualMiddleName))
	    {
	    	System.out.println("***********************************************************");
         	System.out.println("The Middle name of personal details page is matched with Profile pic Middle name");
    	    System.out.println("********************************************************");
	    	System.out.println( "Expected Middle name in personal details matched with actual Middle name");
	    	XSSFCell personaldetailsvalidationFullNameTestResult=ExcelTestDataRow.createCell(24);
	    	personaldetailsvalidationFullNameTestResult.setCellValue("Expected  middle name in personal details matched with actual  middle name");

	    }
	    else {
	    	System.out.println("***********************************************************");
         	System.out.println("The Middle name of personal details page is  NOT matched with Profile pic Middle name");
    	    System.out.println("********************************************************");
	    	System.out.println( "Expected Middle name in personal details is not matched with actual Middle name");
	    	XSSFCell personaldetailsvalidationMiddleNameTestResult=ExcelTestDataRow.createCell(24);
	    	personaldetailsvalidationMiddleNameTestResult.setCellValue("Expected Middle name in personal details is not matched with actual Middle name");

	    	
	    }
	    
	    //<input value="Revathi" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
	    By PersonalDetailsLastNameproperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsLastnameProperty"));
	    WebElement PersonalDetailslastName=driver.findElement(PersonalDetailsLastNameproperty);
	    String ActualLastName=PersonalDetailslastName.getAttribute("Value");
	    System.out.println("The Expected Last Name - "+TestDataLastName);
	    System.out.println("The  Actual Last Name - "+ActualLastName);
	    Cell ActualLastNameCell=ExcelTestDataRow.createCell(25);
	    ActualLastNameCell.setCellValue(ActualLastName);
	    if( ActualLastName.equals(TestDataLastName)&& imageFL.contains(ActualLastName)) {
	    	System.out.println("***********************************************************");
	    	System.out.println("The Last name of personal details page is matched with Profile pic Last name");
	    	System.out.println("********************************************************");
	    	System.out.println( "Expected Last name in personal details matched with actual last name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(26);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected Last name in personal details matched with actual Last name");

	    }
	    else {
	    	System.out.println("***********************************************************");
	    	System.out.println("The Last name of personal details page is NOT matched with Profile pic Last name");
	    	System.out.println("********************************************************");
	    	System.out.println( "Expected Last name in personal details is not matched with actual Last name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(26);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected Last name in personal details is not matched with actual Last name");

	    	
	    }
	    
	    //<input value="0025" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" 
	    //id="personal_txtEmployeeId" disabled="disabled">
	    
	    By PersonalDetailsEmployeeIDProperty=By.id(ElementProperties.getProperty("orangehRMApplicationPersonalDetailsEmployeeIDProperty"));
        WebElement PersonalDetailsEmployeeID=driver.findElement(PersonalDetailsEmployeeIDProperty);
        String ActualPersonalDetailsEmployeeIDValue=PersonalDetailsEmployeeID.getAttribute("value");
        System.out.println("The Expected EmployeeID - "+ExpectedEmployeIDValue);
	    System.out.println("The  Actual EmployeeID - "+ActualPersonalDetailsEmployeeIDValue);
        
        ExcelTestDataRow=ExcelTestDataSheet.getRow(rowofindex);
        XSSFCell ActualemployeeID=ExcelTestDataRow.createCell(27);
        ActualemployeeID.setCellValue(ActualPersonalDetailsEmployeeIDValue);
        if(ActualPersonalDetailsEmployeeIDValue.equals(ExpectedEmployeIDValue)) {
	    	System.out.println( "Expected EmployeID in personal details matched with actual  EmployeID name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(28);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected  EmployeID name in personal details matched with actual  EmployeID name");

	    }
	    else {
	    	System.out.println( "Expected EmployeID in personal details is not matched with actual  EmployeID name");
	    	XSSFCell personaldetailsvalidationLastNameTestResult=ExcelTestDataRow.createCell(28);
	    	personaldetailsvalidationLastNameTestResult.setCellValue("Expected  EmployeID name in personal details is not matched with actual  EmployeID name");

	    	
	    }
       System.out.println("****************************************************************************");
        driver.navigate().back();
        driver.navigate().refresh();
		}
		FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
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
		 FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
			
			XSSFRow ExcelTestDataRow=ExcelTestDataSheet.getRow(1);
			XSSFCell ExcelTestDataRowOfCell=ExcelTestDataRow.getCell(29);
		    String  TestDataLoginPanel=ExcelTestDataRowOfCell.getStringCellValue();

			String ExpectedLoginPageText=TestDataLoginPanel;
			System.out.println("The login page should contains text -"+ExpectedLoginPageText);
			//<div id="logInPanelHeading">LOGIN Panel</div>
			By LoginPanelProperty=By.id(ElementProperties.getProperty("orangeHRMApplicationLogInPageLoginPanelProperty"));
			WebElement LoginPanel=driver.findElement(LoginPanelProperty);
			String ActualLoginPageText=LoginPanel.getText();
			Cell loginPanel=ExcelTestDataRow.createCell(30);
			loginPanel.setCellValue(ActualLoginPageText);

			System.out.println("The Actual login panel should cantains - "+ActualLoginPageText);
			if(ActualLoginPageText.equals(ExpectedLoginPageText)) {
				System.out.println("Successfully navigated to login page - PASS");
				Cell loginPanelTestResult=ExcelTestDataRow.createCell(31);
				loginPanelTestResult.setCellValue("Successfully navigated to login page - PASS");
			}
			else {
				System.out.println("Failed navigated to login page - FAIL");
				Cell loginPanelTestResult=ExcelTestDataRow.createCell(31);
				loginPanelTestResult.setCellValue("Failed navigated to login page - FAIL");

			}
			FileOutputStream orangeHRMApplicationLogInTestResultFile = new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\TestNgExcelFiles\\AddEmployee.xlsx");
			ExcelWorkBook.write(orangeHRMApplicationLogInTestResultFile);
		System.out.println("*************Successfully closes the Application*****************");
	}
	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
