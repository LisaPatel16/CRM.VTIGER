package com.CRM.VTiger.practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartElectronic {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(@class,'_2doB4z')]")).click();

		WebElement electronics = driver.findElement(By.xpath("//div[text()='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(electronics).perform();

		WebElement gaming = driver.findElement(By.xpath("//a[text()='Gaming']"));
		act.moveToElement(gaming).perform();

		driver.findElement(By.linkText("Gamepads")).click();

		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();

		WebElement title = driver.findElement(By.xpath("//a[contains(text(),'Gonsgadapp Pubg Controller Transparent')]"));
		String msg = title.getText();
		title.click();
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			if (!(mainid.equals(id))) {
				driver.switchTo().window(id);
			}
		}

		driver.findElement(By.className("_6Up2sF")).click();
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();

		String msg1 = driver.findElement(By.xpath("//a[contains(text(),'Gonsgadapp Pubg Controller Transparent')]"))
				.getText();
		if (msg.equals(msg1)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		driver.quit();
	}
}
 