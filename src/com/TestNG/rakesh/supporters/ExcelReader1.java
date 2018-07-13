package com.TestNG.rakesh.supporters;

import java.io.FileInputStream;
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

public class ExcelReader1 {
	private String filePath;
	private FileInputStream fip;
	private Workbook workbook;
	public ExcelReader1(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fip);
	}
	
	public Sheet getSheet(String sheetName)
	{
		Sheet sheet=null;
		if (workbook!=null) 
			sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public Sheet getSheet(int sheetIndex)
	{
		Sheet sheet=null;
		if (workbook!=null) 
			sheet = workbook.getSheetAt(sheetIndex);
		return sheet;
	}
	
	
	public int getTotalNoOfRows(String sheetName)
	{
		return getSheet(sheetName).getLastRowNum();
	}
	
	public int getTotalNoOfCells(String sheetName,int rowNum)
	{
		return getSheet(sheetName).getRow(rowNum).getLastCellNum();
	}
	
	
	public String getSingleCellData(String sheetName,int rowNum,int cellNum)
	{
		String cellValue = null;
		Cell cell=  getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		if (cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
			cellValue = cell.getNumericCellValue()+"";
		}
		else if (cell.getCellType()==cell.CELL_TYPE_STRING) {
			cellValue=cell.getStringCellValue();
		}
		return cellValue;
	}
	
	public List  getSingleRowData(String sheetName,int rowNum)
	{
		List data = new ArrayList();
		String cellValue=null;
		Row row = getSheet(sheetName).getRow(rowNum);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			Cell cell = row.getCell(i);
			if (cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
				cellValue = cell.getNumericCellValue()+"";
				data.add(cellValue);
			}
			else if (cell.getCellType()==cell.CELL_TYPE_STRING) {
				cellValue=cell.getStringCellValue();
				data.add(cellValue);
			}
		}
		return data;
	}
	
	
	public List getTotalSheetData(String sheetName)
	{
		List data = new ArrayList();
		Sheet sheet=getSheet(sheetName);
		for(int i=0;i<sheet.getLastRowNum()+1;i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				if (cell.getCellType()==cell.CELL_TYPE_STRING) {
					System.out.println(cell.getStringCellValue());
					data.add(cell.getStringCellValue());
				}
				else if (cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
					System.out.println(cell.getNumericCellValue());
					data.add(cell.getNumericCellValue());
				}
			}
		}
		return data;
	}

}
