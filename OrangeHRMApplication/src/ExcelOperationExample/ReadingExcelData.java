package ExcelOperationExample;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingExcelData {

	public static void main(String[] args) throws IOException   {

        //identifying the file(Excel0 in the system
		FileInputStream ExcelTestDataFile=new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\ExcelFiles\\firstExcelFile.xlsx");
		//identifying the workbook in file(excel)
				XSSFWorkbook ExcelTestDataworkbook=new XSSFWorkbook(ExcelTestDataFile);
				
				//identifing the particular sheet in work book
			    XSSFSheet ExcelTestDataSheet=ExcelTestDataworkbook.getSheet("TestData");
			    //identifying the row in sheet
			   Row ExcelTestDataRow=ExcelTestDataSheet.getRow(0);
			   
			   //identifying the row of the cell in a particular row
			   Cell ExcelTestDataCell=ExcelTestDataRow.getCell(0);
			 
			   //getting the value in row of cell  
			   String  TestDataValue=ExcelTestDataCell.getStringCellValue();
			   System.out.println("The value in particural row of cell is "+TestDataValue);
			   
			   //identifyimg the second value in tthe row of cell
			 Row  ExcelTestDataRow1=ExcelTestDataSheet.getRow(9);
			 Cell ExcelTestDataCell1=ExcelTestDataRow1.getCell(3);
			 System.out.println("The value in particular row of cell is "+ExcelTestDataCell1);
	
	}
	
	
}
