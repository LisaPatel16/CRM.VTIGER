package com.CRM.VTiger.practice;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class UploadFile {

	public static void main(String[] args) {
	
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/Lisa/Desktop/Uploadfile.html");
		WebElement ele = driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		File f=new File("./src/test/java/com/CRM/VTiger/practice/liz.png");
		String path=f.getAbsolutePath();
		ele.sendKeys(path);
	}

}
