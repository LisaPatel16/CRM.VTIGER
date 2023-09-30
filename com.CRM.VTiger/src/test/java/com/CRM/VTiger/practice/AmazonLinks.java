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

public class AmazonLinks 
{

	
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			
			List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
			
			FileInputStream fis=new FileInputStream("./src/test/resources/AmazonPrice.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet("links");
			
			int rownum = 0;
			for(WebElement link :allLinks)
			{
				String value = link.getAttribute("href");
				sh.createRow(rownum).createCell(0).setCellValue(value);
				rownum++;
					
			}
			FileOutputStream fos=new FileOutputStream("./src/test/resources/AmazonPrice.xlsx");
			book.write(fos);
		}


}