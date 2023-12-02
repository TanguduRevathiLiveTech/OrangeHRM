package OrangeHRMApplicationTestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationWebPages.OrangeHRM_LoginPage;
import com.utility.ExcelOperationMethods;
import com.utility.ExcelOperationMethodsMultipleData;

public class OrangeHRM_LoginPageTest extends BaseTest{
	
	@Test(priority=1,description="Validating OrangeHRM Application LogIn Page Text Test")
public void validatingLogInPanelTextTest() {
		OrangeHRM_LoginPage loginpage= new OrangeHRM_LoginPage();
		loginpage.validatingLogInPanelText();
		

	}
	
	@Test(priority=2,description=" Validating OrangeHRM Application LogIn Page Logo Test ")
	public void validatingOrangeHRMApplicationLogInPageLogoTest()
	{
	OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
	loginpage.validatingOrangeHRMApplicationLogInPageLogo();
	}

	@Test(priority=3,description=" Validating OrangeHRM Application LogIn Page Login Test ")
	public void  ValidatingLogInFunctionalityTest() throws IOException
	{
	 int LastRowCount=ExcelOperationMethodsMultipleData.getRowValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestDataFiles\\Multipledata.xlsx", "Sheet1");
		for(int rowcount=1;rowcount<=LastRowCount;rowcount++) {
		
		String UserName=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestDataFiles\\Multipledata.xlsx", "Sheet1", rowcount,0 );
		String Password=ExcelOperationMethods.getRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestDataFiles\\Multipledata.xlsx", "Sheet1", rowcount,1 );
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();

		loginpage.ValidatingLogInFunctionality(UserName, Password);
		//ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestResultsFiles\\Multipledata TestResults- Copy.xlsx", "Sheet1",rowcount , 2, "Succesfully Navigated to OrangeHRM Application HomePage - PASS");

		//ExcelOperationMethods.setRowOfCellValue("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHrmApplication_POM\\src\\main\\java\\com\\OrangeHRMApplicationTestResultsFiles\\Multipledata TestResults- Copy.xlsx", "Sheet1", rowcount, 2, " Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}
	}		
	
	
	@Test(priority=4,description=" Validating OrangeHRM Application Linkedin Logo Test ")	

		public void ValidatingOrangeHrmFooterBlockLinkedInLogoTest() {
			OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
			loginpage.ValidatingOrangeHrmFooterBlockLinkedInLogo();
			

	}
			
	@Test(priority=5,description=" Validating OrangeHRM Application FaceBook Logo Test ")	

	public void ValidatingOrangeHrmFooterBlockFaceBookLogoTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmFooterBlockFaceBookLogo();
		

}	
	@Test(priority=6,description=" Validating OrangeHRM Application Twitter Logo Test ")	

	public void ValidatingOrangeHrmFooterBlockTwitterLogoTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmFooterBlockTwitterLogo();

}
	@Test(priority=7,description=" Validating OrangeHRM Application YouTube Logo Test ")	

	public void ValidatingOrangeHrmFooterBlockYouTubeLogoTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmFooterBlockYouTubeLogo();
		
	}
	@Test(priority=8,description=" Validating OrangeHRM Application CopyRight Test ")	

	public void ValidatingOrangeHrmFooterBlockCopyRightTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmCopyRight();
		
}
	@Test(priority=9,description=" Validating OrangeHRM Application Alternative Select Option Test ")	

	public void ValidatingOrangeHrmAlternativeSelectOptionTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmAlternativeSelectOption();
	}	
	@Test(priority=10,description=" Validating OrangeHRM Application Alternative Login")

	public void ValidatingOrangeHrmAlternativeLoginTest() {
		OrangeHRM_LoginPage loginpage = new OrangeHRM_LoginPage();
		loginpage.ValidatingOrangeHrmAlternativeLogin();
	}	
}