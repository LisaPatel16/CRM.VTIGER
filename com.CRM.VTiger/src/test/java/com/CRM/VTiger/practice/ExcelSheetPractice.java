package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(0);
		Cell c = r.getCell(0);
		String un = c.getStringCellValue();
		System.out.println(un);
		
		// 1] To avoid IllegalStateException in the below case use '10 in excel sheet and save
		String value = wb.getSheet("Sheet2").getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		
		// 2]  To avoid IllegalStateException in the below case use toString();
		String value1 = wb.getSheet("Sheet2").getRow(1).getCell(0).toString();
		System.out.println(value1);
		
		// 3] To avoid IllegalStateException in the below case use 
		/* create object of DataFormater and use formatCellValue() */
		DataFormatter df = new DataFormatter();
		String value2 = df.formatCellValue(wb.getSheet("Sheet2").getRow(0).getCell(0));
		System.out.println(value2);
	}

}
		
		
		