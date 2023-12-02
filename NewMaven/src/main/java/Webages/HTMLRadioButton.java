package Webages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseTest.BaseTest;
import com.utility.Log;
import com.utility.PropertiesUserDefined;

public  class HTMLRadioButton extends BaseTest{

	//<a href="school.htm">Tutorials</a>
	public static void HtmlTutorial() throws IOException 
	{
  String property=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialElementLinkProperty" );
	
		By HtmlTutorialLinkProperty=By.linkText(property);
		WebElement HtmlTutorialLink=driver.findElement(HtmlTutorialLinkProperty);
		HtmlTutorialLink.click();
		
		
	}//<a href="html.htm"><span class="link">HTML</span></a>
	public static void TutorialHTMLPage() throws IOException {
		  String property=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageProperty" );

		By TutorialHTMLPageProperty=By.linkText(property);
		WebElement TutorialOfHTMLPage=driver.findElement(TutorialHTMLPageProperty);
		TutorialOfHTMLPage.click();
		
	
	}
	//<a href="htmlforms10.htm">���RADIO BUTTON</a>
	public static void RadioButtonTutorial() throws IOException {
		  String property=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageRadioButtonProperty" );
		  By RadioButtonTutorialProperty=By.linkText(property);
			WebElement RadioButtonTutorial=driver.findElement(RadioButtonTutorialProperty);
			RadioButtonTutorial.click();
			
	}//<input type="radio" name="group1" value="Milk">
	public static void RadioButtonOptionsGroup1Tutorial() throws IOException, InterruptedException {
		  String property=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageRadioButtonTableProperty" );
		  By RadioButtonOptionsTutorialProperty=By.className(property);
			WebElement RadioButtonOptionsTutorial=driver.findElement(RadioButtonOptionsTutorialProperty);
			
	  String Group1property1=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageRadioButtonTableGroup1Property" );
	  By RadioButtonOptionsGroup1TutorialProperty=By.name(Group1property1);
	List <WebElement> RadioButtonOptionsGroup1Tutorial=driver.findElements(RadioButtonOptionsGroup1TutorialProperty);
	int RadioButtonOptionsGroup1Tutorial_count=RadioButtonOptionsGroup1Tutorial.size();
	Log.info("The total Elements in group 1 - "+RadioButtonOptionsGroup1Tutorial_count);
	for(int OptionIndex=0; OptionIndex<RadioButtonOptionsGroup1Tutorial_count; OptionIndex++)
	{

	String RadioButtonOptionsGroup1Name=RadioButtonOptionsGroup1Tutorial.get(OptionIndex).getAttribute("value");
    Log.info("The name of the Radio Button Options of Group 1 - "+RadioButtonOptionsGroup1Name);
Thread.sleep(10000);
	RadioButtonOptionsGroup1Tutorial.get(OptionIndex).click();
	}
	}
	public static void RadioButtonOptionsGroup2Tutorial() throws IOException, InterruptedException {
		  String property=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageRadioButtonTableProperty" );
		  By RadioButtonOptionsTutorialProperty=By.className(property);
			WebElement RadioButtonOptionsTutorial=driver.findElement(RadioButtonOptionsTutorialProperty);
			//name="group2"
	  String Group2property1=PropertiesUserDefined.getproperty("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\NewMaven\\src\\main\\java\\com\\Config\\Elements.properties","EchoechoTutorialHTMLPageRadioButtonTableGroup2Property" );
	  By RadioButtonOptionsGroup2TutorialProperty=By.name(Group2property1);
	List <WebElement> RadioButtonOptionsGroup2Tutorial=driver.findElements(RadioButtonOptionsGroup2TutorialProperty);
	int RadioButtonOptionsGroup1Tutorial_count=RadioButtonOptionsGroup2Tutorial.size();
	Log.info("The total Elements in group 2 - "+RadioButtonOptionsGroup1Tutorial_count);
	for(int OptionIndex=0; OptionIndex<RadioButtonOptionsGroup1Tutorial_count; OptionIndex++)
	{

	String RadioButtonOptionsGroup1Name=RadioButtonOptionsGroup2Tutorial.get(OptionIndex).getAttribute("value");
  Log.info("The name of the Radio Button Options of Group 2 - "+RadioButtonOptionsGroup1Name);
Thread.sleep(10000);
	RadioButtonOptionsGroup2Tutorial.get(OptionIndex).click();
	}
	}
}
