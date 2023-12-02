package com.employeeList;

import org.testng.annotations.Test;

public class TestNG {
	@Test(priority=1,description=" Launching Gmail Application ")
	public void gmailApplicationLaunch()
	{
	System.out.println(" ***** Gmail Application Launch Successfull ****** ");
	}

	@Test(priority=2,description=" Gmail Application  LogIn Test")
	public void gmailApplicationLogInTest()
	{
	System.out.println(" Gmail Application LogIn Functionality Test Successfull ");
	}

	@Test(priority=3,description=" Gmail Application  InBOX Test")
	public void gmailApplicationInBoxTest()
	{
	System.out.println(" Gmail Application InBox Functionality Test Successfull ");
	}

	@Test(priority=4,description=" Gmail Application  ComposeMail Test")
	public void GmailApplicationComposeMailTest()
	{
	System.out.println(" Gmail Application ComposeMail Functionality Test Successfull ");
	}

	@Test(enabled=false,description=" Gmail Application Drafts Test") // this represents to a false Test Case - the TestNG during the
	                    //    Test Run Ignores the current Test case and will proceed to
	                    //    execute the remaining Test Cases

	                    // the default status of the Test case is - enabled=true

	public void GmailApplicationDraftsMailTest()
	{
	System.out.println(" Gmail Application DraftsMail Functionality Test Successfull ");
	}

	@Test(priority=6,description=" Gmail Application SentMail Test")
	public void GmailApplicationSentMailTest()
	{
	System.out.println(" Gmail Application SentMail Functionality Test Successfull ");
	}

	@Test(priority=7,description=" Gmail Application  Close")
	public void GmailApplicationClose()
	{
	System.out.println(" ********** Gmail Application Closed Successfully  ******** ");
	}

	


}
