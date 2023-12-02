package OrangeHRMApplicationTestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationWebPages.OrangeHRM_HomePage;


public class OrangeHRM_HomepageTest extends BaseTest{
	
	
	
	
	@Test(priority=1,description=" Validating OrangeHRM Application Home page Welcome Test ")
	public void validatingWelcomeAdminFunctionalityTest() throws IOException
	{
		
		OrangeHRM_HomePage HomePage = new OrangeHRM_HomePage();
		HomePage.ValidatingHomepageLogInFunctionality("Revathi", "Revathi@123");
		HomePage.HomePageWelcomeAdminFunctionality();

}
	@Test(priority=2,description=" Validating OrangeHRM Application Home page Logo Test ")
	public void ValidatingOrangeHRMHomePageLogoTest() throws IOException
	{
		
		OrangeHRM_HomePage HomePage = new OrangeHRM_HomePage();
		HomePage.ValidatingHomepageLogInFunctionality("Revathi", "Revathi@123");
		HomePage.ValidatingOrangeHRMHomePageLogo();
	}
	@Test(priority=3,description=" Validating OrangeHRM Application Home page Text Test ")
	public void ValidatingOrangeHRMHomePageTextTest() throws IOException
	{
		
		OrangeHRM_HomePage HomePage = new OrangeHRM_HomePage();
		HomePage.ValidatingHomepageLogInFunctionality("Revathi", "Revathi@123");
		HomePage.ValidatitingOrangeHrmHomePageText();
	}
	
	
	@Test(priority=4,description=" Validating OrangeHRM Application Home page Admin Element Test ")
	public void ValidatingOrangeHRMHomePageAdminElementTest() throws IOException
	{
		
		OrangeHRM_HomePage HomePage = new OrangeHRM_HomePage();
		HomePage.ValidatingHomepageLogInFunctionality("Revathi", "Revathi@123");
		HomePage.ValidatitingOrangeHrmHomePageAdminElement();
	}
}
