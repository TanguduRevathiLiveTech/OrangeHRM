package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

import Webages.HTMLRadioButton;

public class HTMLRadioButtonTest extends BaseTest {

	
	
	
@Test(priority=1,description="Html Tutorial")
public void HtmlTutorialTest() throws IOException {
	HTMLRadioButton HTML=new HTMLRadioButton();
	HTML.HtmlTutorial();
}

@Test(priority=2,description="Navigate to Tutorial of Html Pagess")
public void TutorialOfHTMLPageTest() throws IOException {
	HTMLRadioButton HTML=new HTMLRadioButton();
	HTML.TutorialHTMLPage();
}
@Test(priority=3,description="Navigate to Tutorial of Html Radio Buttons")
public void TutorialOfHTMLPageRadioButtonTutorialTest() throws IOException {
	HTMLRadioButton HTML=new HTMLRadioButton();
	HTML.RadioButtonTutorial();
}
@Test(priority=4,description="Navigate to Tutorial of Html Radio Buttons Options of Group 1 ")
public void TutorialOfHTMLPageRadioButtonOptionsTutorialGroup1Test() throws IOException, InterruptedException {
	HTMLRadioButton HTML=new HTMLRadioButton();
	HTML.RadioButtonOptionsGroup1Tutorial();
}
@Test(priority=5,description="Navigate to Tutorial of Html Radio Buttons Options of Group 2 ")
public void TutorialOfHTMLPageRadioButtonOptionsTutorialGroup2Test() throws IOException, InterruptedException {
	HTMLRadioButton HTML=new HTMLRadioButton();
	HTML.RadioButtonOptionsGroup2Tutorial();
}
}
