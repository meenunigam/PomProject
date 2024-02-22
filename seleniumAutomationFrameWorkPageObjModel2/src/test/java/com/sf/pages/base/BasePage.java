package com.sf.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.google.common.io.Files;
import com.sf.utilities.ExtentReportsUtility;

public class BasePage {
	
	public WebDriver driver = null;
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
	protected Logger BasePageLog = LogManager.getLogger();
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void sendingText(WebElement ele, String data,String objectName ) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			BasePageLog.info("data is entered in " + objectName + " textbox");
			extentReport.logTestInfo("data is entered in " + objectName + " textbox");
			
		} else {
			BasePageLog.info(objectName + " element is not displayed");
		}
		
	}
	
	public void ClickBut(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			BasePageLog.info(objectName + "button is clicked");
			extentReport.logTestInfo(objectName + "button is clicked");
			
		} else {
			BasePageLog.info(objectName+" element is not enabled");
			
		}
	}
	
	public String gettingText(WebElement ele, String objectName) {
		String data = ele.getText();
		BasePageLog.info("text is extracted from "+objectName);
		extentReport.logTestInfo("text is extracted from "+objectName);
		return data;
	}
	
	public void maximiseBrowser() {
		driver.manage().window().maximize();
		//baseTestlog.info("browser window has maximized");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		BasePageLog.info("page is refreshed");

	}


	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			BasePageLog.info(ObjectName + " is cleared");
		} else {
			BasePageLog.info(ObjectName + " element is not displayed");
		}
	}
	
	public String isEleDisplayed(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			String data = gettingText(ele,"username element");
			BasePageLog.info(objectName + "Element is enabled");
			extentReport.logTestInfo(objectName + "Element is enabled");
			return data;
			
		} else {
			BasePageLog.info(objectName+" element is not enabled");
		}
	}
	
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}

	
	public Alert switchToAlert() {
		return null;
		
	}
	
public void AcceptAlert(Alert alert) {

	}

	public String getAlertText(Alert alert, String objectname) {
		return null;
		

	}

	public void dismisAlert() {

		

	}
	// ******************************alert ends**************************************

	// ******************************Action class reusable methods**************************************
	

	public void mouseOverOnElement(WebElement ele, String objName) {
		
	}

	public void ContextClickOnElement(WebElement ele, String objName) {
		
	}

	// ******************************Action class reusable method ends**************************************

	// ******************************Select class reusable method starts*************************************

	public void selectByTextData(WebElement element, String text, String objName) {
		

	}

	public void selectByIndexData(WebElement element, int index, String objName) {
		

	}

	public void selectByValueData(WebElement element, String text, String objName) {
		
	}
	
	public WebElement selectFromListUsingText(List<WebElement> list, String text) {
		return null;
		

	}

	// ******************************select class reusable method ends**************************************

	// ******************************wait reusable method starts**************************************

	public void waitUntilPageLoads() {
		
	}
	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		
	}

	public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
		

	}

	public void waitUntilElementToBeClickable(By locator, String objName) {
		
	}

	public void waitForVisibility(WebElement ele, int time, String objectName) {
		
	}

	public void waitForAlertPresent(int time) {
		
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			BasePageLog.info("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BasePageLog.info("went wrong when capturing the screen");
			
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		
	}


}
