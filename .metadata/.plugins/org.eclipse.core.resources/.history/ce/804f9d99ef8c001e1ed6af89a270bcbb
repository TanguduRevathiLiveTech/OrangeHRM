package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hwpf.model.PropertyNode;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationMethodsMultipleData {
	/*
	public static String getRowOfCellValue
	(String excelFilePath,String sheetName,int rowIndex, int cellIndex) throws IOException {

	FileInputStream excelFile = new FileInputStream(excelFilePath);
	XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
	XSSFSheet sheet = workBook.getSheet(sheetName);
	int rowCount=sheet.getLastRowNum();

	XSSFRow row =  sheet.getRow(rowIndex);
	XSSFCell rowOfCell=row.getCell(cellIndex);

	String rowOfCellValue = rowOfCell.getStringCellValue();

	return rowOfCellValue;
	
	}*/
	public static int getRowValue
	(String excelFilePath,String sheetName) throws IOException {

	FileInputStream excelFile = new FileInputStream(excelFilePath);
	XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
	XSSFSheet sheet = workBook.getSheet(sheetName);
	
	int rowCount=sheet.getLastRowNum();
	return rowCount;
	
	}
	public static int getRowofCellValue
	(String excelFilePath,String sheetName, int RowIndex) throws IOException {

	FileInputStream excelFile = new FileInputStream(excelFilePath);
	XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
	XSSFSheet sheet = workBook.getSheet(sheetName);
	XSSFRow row =  sheet.getRow(RowIndex);
	int RowOfCellCount=row.getLastCellNum();
	return RowOfCellCount
			;
	
	}

/*
	public static void setRowOfCellValue
	(String excelFilePath,String sheetName,int rowIndex,int cellIndex,
	    String data) throws IOException
	{
	FileInputStream excelFile = new FileInputStream(excelFilePath);
	XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
	XSSFSheet sheet = workBook.getSheet(sheetName);

	XSSFRow row =  sheet.getRow(rowIndex);
	XSSFCell RowOfNewCellCreated=row.createCell(cellIndex);

	RowOfNewCellCreated.setCellValue(data);

	FileOutputStream saveFile = new FileOutputStream(excelFilePath);
	workBook.write(saveFile);
	saveFile.close();
	}*/

	
	
	
	
	
	
	
	
	
}
