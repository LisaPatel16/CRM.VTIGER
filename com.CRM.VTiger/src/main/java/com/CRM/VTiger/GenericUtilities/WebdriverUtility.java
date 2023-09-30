package com.CRM.VTiger.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {
	/**
	 * This method maximize the browser window
	 * 
	 * @param driver
	 */

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method minimize the browser window
	 * 
	 * @param driver
	 */

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method wait for the webdriver for some time until the condition met
	 * 
	 * @param driver
	 */
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.implicitwaitDuration));
	}

	public void visibility(WebDriver driver, WebElement elemnt) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(elemnt));
	}

	public void elementToBeClickable(WebDriver driver, WebElement elemnt) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(elemnt));
	}

	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.ExplicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * in below we are achiving method overloading- it is an example of compile time
	 * polymorphism
	 * 
	 * @param elemnt
	 * @param indexNo
	 */

	public void handleDropdown(WebElement elemnt, int indexNo) {
		Select s = new Select(elemnt);
		s.selectByIndex(0);
	}

	public void handleDropdown(WebElement elemnt, String value) {
		Select s = new Select(elemnt);
		s.selectByValue(value);
	}

	public void handleDropdown(String text, WebElement elemnt) {
		Select s = new Select(elemnt);
		s.selectByVisibleText(text);
	}
	// method overloading means compile time polymosphism

	/**
	 * alert popup -to click on accept
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * alert popup -to click on dismiss
	 * 
	 * @param driver
	 */

	public void DismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * alert popup -to get text from alert popup
	 * 
	 * @param driver
	 */
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * alert popup -to pass the data to alert popup
	 * 
	 * @param driver
	 */

	public void sendTextToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * By using this method we can handle the frame element using index
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void frameByindex(WebDriver driver, int indexNo) {
		driver.switchTo().frame(indexNo);
	}

	/**
	 * By using this method we can handle the frame element using nameOrid
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void frameBynameorid(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * By using this method we can handle the frame element using web Element
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void frameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * by using this method we can move the driver focus to immediate parent
	 * 
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * by using this method we can move the driver focus to main page
	 * 
	 * @param driver
	 */
	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to move the mouse to particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);// driver-address of current page
		act.moveToElement(element).perform();
	}

	/**
	 * this method is used to perform right click
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);// driver-address of current page
		act.contextClick(element).perform();
	}

	/**
	 * this method is used to perform right click anywhere in the webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAnywhere(WebDriver driver) {
		Actions act = new Actions(driver);// driver-address of current page
		act.contextClick().perform();
	}

	/**
	 * this method is used to perform double click
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);// driver-address of current page
		act.doubleClick(element).perform();
	}

	/**
	 * this method is used to perform double click anywhere in the webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAnywhere(WebDriver driver) {
		Actions act = new Actions(driver);// driver-address of current page
		act.doubleClick().perform();
	}

	public void dragAnddrop(WebDriver driver, WebElement srcElement, WebElement destElement) {
		Actions act = new Actions(driver);// driver-address of current page
		act.dragAndDrop(srcElement, destElement).perform();
	}

	public void dragAnddropby(WebDriver driver, WebElement srcElement, WebElement destElement) {
		Actions act = new Actions(driver);// driver-address of current page
		act.dragAndDropBy(destElement, 0, 0).perform();
	}

	public void windowHandling(WebDriver driver) {
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			if (!(mainid.equals(id))) {
				driver.switchTo().window(id);
			}
		}
	}

	/**
	 * this method is used to change the driver focus to a particular window
	 * 
	 * @param driver
	 * @param partialTitle
	 */

	public void windowHandlingTitle(WebDriver driver, String partialTitle) {
		// capture all the window ids
		Set<String> id = driver.getWindowHandles();

		// navigate to each window capture the title
		for (String wid : id) {
			String currentTitle = driver.switchTo().window(wid).getTitle();
			// compare the title with the required window title
			if (currentTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	/**
	 * this method is used to capture the whole page
	 * 
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String screenshot(WebDriver driver, String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		JavaUtility jutil = new JavaUtility();
		String currentdate = jutil.modifiedDate();

		File dest = new File("./ScreenShot/" + currentdate + screenshotname + ".png");

		Files.copy(src, dest);
		return dest.getAbsolutePath();// extent report

	}

	/**
	 * this method is used to capture the particular web Element
	 * 
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws Throwable
	 */
	public String screenshot(WebElement Element, String screenshotname) throws Throwable {

		File src = Element.getScreenshotAs(OutputType.FILE);
		// TakesScreenshot ts=(TakesScreenshot)Element;
		// File src = ts.getScreenshotAs(OutputType.FILE);

		JavaUtility jutil = new JavaUtility();
		String currentdate = jutil.modifiedDate();

		File dest = new File("./ScreenShot/" + currentdate + screenshotname + ".png");

		Files.copy(src, dest);
		return dest.getAbsolutePath();// extent report

	}

	/**
	 * this method is used to upload the file
	 * 
	 * @param path
	 * @param element
	 */
	public void fileupload(String path, WebElement element) {
		File f = new File(path);
		String abspath = f.getAbsolutePath();
		element.sendKeys(abspath);

	}

	/**
	 * this method is used to scroll the webpage
	 * 
	 * @param driver
	 */
	public void scrollthewebpage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");

	}

	/**
	 * this method is used to scroll the webelement to particular element by using
	 * java concept we have to scroll the webpage in real time
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollthewebpageElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();

		js.executeScript("window.scrollBy(0," + y + ")", element);

	}

}

//is it possible to switch one frame to another frame
//ans:- no first we have to switch focus to main window and then switch to another frame
//in window it is possible to switch one window to another window
//in three ways we can switch the window 1)by using id 2) by using title 3)by using URL
//Outputtype is a enum and enum is constant
