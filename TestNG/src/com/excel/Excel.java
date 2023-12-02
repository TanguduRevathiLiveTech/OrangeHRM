package com.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {
	
	 public static Excel Logfile =new Excel();
	
	
	public  void read(String excelFile, String excelTestDataSheet ,int ExcelTestDataRow,int ExcelTestDataRowOfCell) throws IOException {
		FileInputStream ExcelFile=new FileInputStream(excelFile);
		try (XSSFWorkbook ExcelWorkBook1 = new XSSFWorkbook(ExcelFile)) {
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook1.getSheet(excelTestDataSheet);
			XSSFRow  ExcelTestDataRow1=ExcelTestDataSheet.getRow(ExcelTestDataRow);
			XSSFCell ExcelTestDataRowOfCell1=ExcelTestDataRow1.getCell(ExcelTestDataRowOfCell);
			 ExcelTestDataRowOfCell1.getStringCellValue();
		}
		Logfile.read(excelFile, excelTestDataSheet, ExcelTestDataRow, ExcelTestDataRowOfCell);
	

	}
	public void write(String excelFile,  String excelTestDataSheet ,int ExcelTestDataRow,int ExcelTestDataRowOfCell,String getcellvalue) throws IOException {
		FileInputStream ExcelFile=new FileInputStream(excelFile);
		try (XSSFWorkbook ExcelWorkBook = new XSSFWorkbook(ExcelFile)) {
			XSSFSheet ExcelTestDataSheet= ExcelWorkBook.getSheet(excelTestDataSheet);
			XSSFRow  ExcelTestDataRow1=ExcelTestDataSheet.createRow(ExcelTestDataRow);
			XSSFCell ExcelTestDataRowOfCell1=ExcelTestDataRow1.createCell(ExcelTestDataRowOfCell);
			ExcelTestDataRowOfCell1.setCellValue(getcellvalue);
		}
		Logfile.write(excelFile, excelTestDataSheet, ExcelTestDataRow, ExcelTestDataRowOfCell, getcellvalue);

	}

}
