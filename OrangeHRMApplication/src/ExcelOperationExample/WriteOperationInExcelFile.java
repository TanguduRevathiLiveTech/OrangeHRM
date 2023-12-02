package ExcelOperationExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteOperationInExcelFile {

	public static void main(String[] args) throws IOException {
//identifying the file(Excel) in the system
		FileInputStream ExcelFile= new FileInputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\ExcelFiles\\firstExcelFile.xlsx");
	//identifying the workbook in the file
		XSSFWorkbook ExcelFileWorkBook=new XSSFWorkbook(ExcelFile);
		//identifying the sheet in the workbook
		XSSFSheet ExcelFileSheet=ExcelFileWorkBook.getSheet("TestData");
		//creating the row in the sheet
		Row excelFileRowCreated=ExcelFileSheet.createRow(2);
		
				//creating the cell in a particular row
		Cell excelcreatedrowofcell=excelFileRowCreated.createCell(4);
		//creating the value into the row of cell
		excelcreatedrowofcell.setCellValue("TanguduRevathi");		//saving the value in a excel file
		FileOutputStream Resultvalue=new FileOutputStream("C:\\Users\\revat\\OneDrive\\Desktop\\OrangeHRMApplication\\OrangeHRMApplication\\src\\OrangeHrmFileOtherFile\\firstExcelFile1.xlsx");
		ExcelFileWorkBook.write(Resultvalue);

	}
	}


