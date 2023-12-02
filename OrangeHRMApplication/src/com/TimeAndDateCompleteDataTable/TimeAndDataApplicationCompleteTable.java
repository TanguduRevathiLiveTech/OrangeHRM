package com.TimeAndDateCompleteDataTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeAndDataApplicationCompleteTable {
        WebDriver driver;
        String ApplicationUrlAddress="https://www.timeanddate.com/worldclock/";
	     public void ApplicationLaunch()
	     {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\ChromeDriver\\chromedriver.exe"); 
	    	 driver=new ChromeDriver();
	    	 driver.navigate().to(ApplicationUrlAddress);
	     }
	    	 public void Excelfile() throws IOException {
	    		 FileInputStream ExcelFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\TimeANdDateExcelFile\\TimeandDateCompleteTable.xlsx");
	    			XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFile);
	    			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet("Sheet1");
	    			    	 
	     ///html/body/div[5]/section[1]/div/section/div[1]/div/table/thead/tr[1]
	    	
	    	 By TableDataRowProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr");
	    	 List<WebElement> tableData=driver.findElements(TableDataRowProperty);

	    	 
	    	 int tableDataRowCount=tableData.size();
	    	 
	    	 System.out.println("The Number of rows in a table - "+ tableDataRowCount);
	    	 
	    	 ///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
	    	 By TableDataRowOfCellProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td");
		    	

	    	 List<WebElement> TableDataRowOfCell=driver.findElements(TableDataRowOfCellProperty);
	    
	    	 
	    	 int TableDataRowOfCellCount=TableDataRowOfCell.size();
	    	 
	    	 System.out.println("The Number of rows of cells in a table - "+ TableDataRowOfCellCount);

	    	 for(int rowOfIndex=1;rowOfIndex<=tableDataRowCount;rowOfIndex++)
	    	 {
	    	 // To goto Every Row of All the Cells
	    		 XSSFRow ExcelTestDataRow=ExcelTestDataSheet.createRow(rowOfIndex-1);//1
	    	 for(int rowOfCellIndex=1;rowOfCellIndex<=TableDataRowOfCellCount;rowOfCellIndex++)
	    	 {
	    	 By tableDataProperty=By.xpath
	    	 ("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowOfIndex+
	    	 "]/td["+rowOfCellIndex+"]");

	    	 WebElement tableData1=driver.findElement(tableDataProperty);

	    	 String tableDataText=tableData1.getText();
	    	 
	    	      
	    	 System.out.print(tableDataText+"   |   ");

	    	 
	    	 
	    	
 			XSSFCell ExcekTestDataRowOfCell=ExcelTestDataRow.createCell(rowOfCellIndex-1);
 			
 			ExcekTestDataRowOfCell.setCellValue(tableDataText);
 			 FileOutputStream TimeAndDataApplicationTAbleTestResult=new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\com\\TimeANdDateExcelFile\\TimeandDateCompleteTable.xlsx");
	    	 ExcelWorkBook.write(TimeAndDataApplicationTAbleTestResult);
 			
 		 
	    	
	    	 }
	    	 System.out.println();
	    	 
	    	 }	 
	    	 }
	    	 
	    	 public void Applicationclose() {
	    		 driver.close();
	    	 }
	    	
	      
	     
	     public static void main(String[] args) throws IOException {
	    	 TimeAndDataApplicationCompleteTable Table= new TimeAndDataApplicationCompleteTable();
	    	 Table.ApplicationLaunch();
	    	 Table.Excelfile();
	    	 Table.Applicationclose();
	    	 
		}
	 
}



