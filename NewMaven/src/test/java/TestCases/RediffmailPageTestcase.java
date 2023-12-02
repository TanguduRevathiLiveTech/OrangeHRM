package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.RediffmailBaseTest;


import Webages.RediffmailPage;

public class RediffmailPageTestcase extends RediffmailBaseTest{

	
	@Test(priority=1,description="RediffMail Creating a new Account")
	public void RediffmailPageTest() throws IOException {
		RediffmailPage Rediffmail=new RediffmailPage();
		Rediffmail.RediffmailNewAccount();
	}
	@Test(priority=2,description="RediffMail Creating a new Account sending Full Name")
	public void RediffmailNewAccountFullnameTest() throws IOException, InterruptedException {
		RediffmailPage Rediffmail=new RediffmailPage();
		Rediffmail.RediffmailNewAccountFullname("Tangudu Revathi");
	}
}