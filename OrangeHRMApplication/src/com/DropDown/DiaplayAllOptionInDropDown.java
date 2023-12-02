package com.DropDown;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DiaplayAllOptionInDropDown {
///html/body/div[2]/header/div/div/div/ul/li[9]/select/option
	
	
	WebDriver driver;
	String ApplicationUrlAddress="https://www.osmania.ac.in/";
	public void setup() {
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.navigate().to(ApplicationUrlAddress);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}
	public void SelectDropDownOption() throws IOException {
		
		//id="gtranslate_selector"
		
		//html/body/div[1]/header/div/div/div/ul/li[9]/select	
		///html/body/div[1]/header/div/div/div/ul/li[9]/select/option[1]
		
		By SelectLanguageFromDropDownProperty=By.id("gtranslate_selector");
		WebElement SelectLanguageFromDropDown=driver.findElement(SelectLanguageFromDropDownProperty);
		FileInputStream ExcelFile =new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\DropDownExcelFile\\DropDown.xlsx");
		XSSFWorkbook ExcelworkBook =new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWorkBookSheet =ExcelworkBook.getSheet("Sheet1");
		By AllOptionDropDownProperty=By.tagName("option");
		List<WebElement>AllOptionDropDown=SelectLanguageFromDropDown.findElements(AllOptionDropDownProperty);
		
	       int AllOptionDropDownCount=AllOptionDropDown.size();
	       System.out.println("The Total number of of languages in dropdown - "+AllOptionDropDownCount);
	       
	       
	       
	       for(int OptionIndex=1;OptionIndex<=AllOptionDropDown.size();OptionIndex++) {
	    	  
				
	    	By AllOptionDropDownProperty2=By.xpath("/html/body/div[1]/header/div/div/div/ul/li[9]/select/option["+OptionIndex+"]");
	   		WebElement AllOptionDropDown2=driver.findElement(AllOptionDropDownProperty2);
	   	
	   		String  AllOptionDropDownText =AllOptionDropDown2.getText();
	   		System.out.println("The Language Name in DropDown List - "+AllOptionDropDownText);
	   		
	   		XSSFRow SheetofRow= ExcelWorkBookSheet.createRow(OptionIndex-1);
	   		XSSFCell RowOfCell=SheetofRow.createCell(0);
	   		RowOfCell.setCellValue(AllOptionDropDownText);
	   		FileOutputStream OptionsSelectLanguages=new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\DropDownExcelFile\\DropDown.xlsx");
	   		ExcelworkBook.write(OptionsSelectLanguages);
	   		
	   		
	   		
	   		
	       }
	   		
	
				
	}
			
		public static void main(String[] args) throws IOException {
			
			DiaplayAllOptionInDropDown DropDown=new DiaplayAllOptionInDropDown();
			DropDown.setup();
			DropDown.SelectDropDownOption();
			
		}	
	
	
	
	
}
