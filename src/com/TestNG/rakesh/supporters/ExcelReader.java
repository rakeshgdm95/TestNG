package com.TestNG.rakesh.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
private String filepath ;
private  FileInputStream fip;
private  Workbook workbook;
Sheet sheet;

public ExcelReader(String filepath) throws FileNotFoundException,InvalidFormatException,IOException,EncryptedDocumentException {
	 this.filepath=filepath;
	 fip=new FileInputStream(filepath);
	workbook=WorkbookFactory.create(fip); 
}
public Sheet getsheet(String sheetName) {
	Sheet sheet=null;
	if(workbook!=null)	
	 sheet=workbook.getSheet(sheetName);
	return sheet;
}
public Sheet getsheet(int sheetIndex) {
	Sheet sheet=null;
	if(workbook!=null)
		sheet=workbook.getSheetAt(sheetIndex);
	return sheet;
}
public int getTotalNoofRows(String sheetName) {
	return getsheet(sheetName).getLastRowNum();
}
public int getTotalNoofCells(String sheetName,int rowNum) {
	return getsheet(sheetName).getRow(rowNum).getLastCellNum();
}

public String getSingleCellData(String sheetName,int rowNum,int cellNum) {
	String cellvalue=null;
	Cell cell=getsheet(sheetName).getRow(rowNum).getCell(cellNum);
	if ( cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
		cellvalue=cell.getNumericCellValue()+"";	
	}
	else if (cell.getCellType()==cell.CELL_TYPE_STRING) {
		cellvalue=cell.getStringCellValue();	
	}
	return cellvalue;
}
public List getSingleRowData(String sheetName,int rowNum) {
	List data=new ArrayList();
	String cellvalue=null;
	Row row=getsheet(sheetName).getRow(rowNum);
	for(int i=0;i<row.getLastCellNum();i++) {
		Cell cell=row.getCell(i);
		if(cell.getCellType()==cell.CELL_TYPE_STRING) {
			cellvalue=cell.getStringCellValue();
			data.add(cellvalue);
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
			cellvalue=cell.getNumericCellValue()+"";
			data.add(cellvalue);
		}
	}
	return data;
}

public List getTotalSheetData(String sheetName) {
	List data=new ArrayList();
	String cellvalue=null;
	Sheet sheet=getsheet(sheetName);
	for (int i=0;i<sheet.getLastRowNum()+1;i++)
	{
		Row row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++)
		{
			Cell cell=row.getCell(j);
			if(cell.getCellType()==cell.CELL_TYPE_STRING) {
				cellvalue=cell.getStringCellValue();
				data.add(cellvalue);
			}
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
				cellvalue=cell.getNumericCellValue()+"";
				data.add(cellvalue);
			}
		}
	}
	return data;
}

}
