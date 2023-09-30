package com.CRM.VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelFileUtility {
	/**
	 * Here we want to fetch,update or delete the data from Excel Sheet
	 * @author Lisa
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcel(String Sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream(IPathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		
		String value=wb.getSheet(Sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	
	public void updateExcelData(String Sheetname, int rowno, int cellno, String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream(IPathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		
		wb.getSheet(Sheetname).createRow(rowno).createCell(cellno).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstant.excelfilepath);
		wb.write(fos);
		
	}
	@DataProvider
	public Object[][] multipleData() throws Throwable
	{
		FileInputStream f=new FileInputStream(IPathConstant.excelfilepath);
		Sheet s=WorkbookFactory.create(f).getSheet("Sheet2");
		int row=s.getLastRowNum()+1;
		int cell=s.getRow(0).getLastCellNum();
		Object[][] ob=new Object[row][cell];
		DataFormatter da=new DataFormatter();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				ob[i][j]=da.formatCellValue(s.getRow(i).getCell(j));
			}
		}
		return ob;
	}

} 
