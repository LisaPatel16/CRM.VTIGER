//package com.CRM.VTiger.practice;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//
//public class Olyampics {
//
//	public static void main(String[] args) {
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
//
//        List<WebElement> countries = driver.findElements(By.cssSelector("[data-cy='country-name']"));
//        List<WebElement> goldMedals = driver.findElements(By.cssSelector("[data-medal-type='gold']"));
//        List<WebElement> silverMedals = driver.findElements(By.cssSelector("[data-medal-type='silver']"));
//        List<WebElement> bronzeMedals = driver.findElements(By.cssSelector("[data-medal-type='bronze']"));
//
//        for (int i = 0; i < countries.size(); i++) {
//            String countryName = countries.get(i).getText();
//            int goldCount = Integer.parseInt(goldMedals.get(i).getText());
//            int silverCount = Integer.parseInt(silverMedals.get(i).getText());
//            int bronzeCount = Integer.parseInt(bronzeMedals.get(i).getText());
//
//            System.out.println(
//                   countryName + ": Gold " + goldCount + ", Silver " + silverCount + ", Bronze " + bronzeCount
//                );
//            }
//
//            driver.quit();
//            
//        }
//    }
