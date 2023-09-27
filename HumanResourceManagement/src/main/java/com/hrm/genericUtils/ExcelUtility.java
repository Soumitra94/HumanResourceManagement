package com.hrm.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility 
{


	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException 
	{
		Workbook book=WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet=book.getSheet(sheetName);
		Row row=sheet.getRow(rowNo);
		Cell cell=row.getCell(cellNo);
		String data=cell.toString();
		return data;
		
	}
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws Throwable, Exception, IOException
	{
		Workbook book=WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet=book.getSheet(sheetName);
		Row row=sheet.createRow(rowNo);
		Cell cell=row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IPathconstants.excelPath);
		book.write(fos);
		book.close();
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook book=WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet=book.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn,WebDriver driver) throws EncryptedDocumentException, IOException
{
//fetching data fromexcel
	FileInputStream fis=new FileInputStream(IPathconstants.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sheet=book.getSheet(sheetName);
	int count=sheet.getLastRowNum();
	
	HashMap<String, String> map=new HashMap<String, String>();//empty map
	for(int i=1;i<=count;i++)
	{
		String key=sheet.getRow(i).getCell(keyColumn).getStringCellValue();
		String value=sheet.getRow(i).getCell(valueColumn).getStringCellValue();
		map.put(key, value);
		
	}
	for(Entry<String, String> s:map.entrySet())
	{
			
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		
	}
	return map;
}

public Object[][] getMultipleSetData(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream(IPathconstants.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sheet=book.getSheet("DP");
	int lastRow=sheet.getLastRowNum();
	int lastCell=sheet.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastRow+1][lastCell];
	for(int i=0;i<=lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	
	
}
}
