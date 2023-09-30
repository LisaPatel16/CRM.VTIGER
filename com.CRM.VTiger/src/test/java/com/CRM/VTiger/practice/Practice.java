package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		List<WebElement>alllinks=driver.findElements(By.xpath("//a"));
		FileInputStream fis=new FileInputStream("C:\\Users\\Lisa\\Desktop\\Automation\\AmazonPrice.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		int row=0;
		for(WebElement link:alllinks)
		{
			
			String value=link.getAttribute("href");
			sh.createRow(row).createCell(0).setCellValue(value);
			row++;
			}
			
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Lisa\\Desktop\\Automation\\AmazonPrice.xlsx");
		book.write(fos);
		
		
	}

}
