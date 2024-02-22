package com.sf.base;

import static org.testng.Assert.assertEquals;


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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.sf.utilities.Constants;
import com.sf.utilities.ExtentReportsUtility;
import com.sf.utilities.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.sf.utilities.sfListenerUtility.class)

public class BaseTestSF {
	
	protected static WebDriver driver = null;
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
	protected Logger BaseTestSFLog = LogManager.getLogger();
	
	@BeforeMethod
	@Parameters("browserName")
public void setUpBeforeMethod(@Optional("chrome") String name,ITestResult result) {
		
		BaseTestSFLog.info(".........BeforeMethod setUpBeforeMethod executed---------------");
		launchBrowser(name);
		
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		BaseTestSFLog.info("******tearDownAfterTestMethod executed***********");
	}
	
	
	
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			BaseTestSFLog.info("browser instance chrome created.");
			//extentReport.logTestInfo("browser instance chrome created");
			driver.manage().window().maximize();
			BaseTestSFLog.info("window is maximized");
			System.out.println(driver);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			BaseTestSFLog.info("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		BaseTestSFLog.info(url + "is entered");
		
	}
	
	public void closeBrowser() {
		driver.close();
		BaseTestSFLog.info("browser instance closed");
		driver=null;
	}
	public void quitBrowser() {
		driver.quit();
		BaseTestSFLog.info("all browser closed");
		driver=null;
		
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			BaseTestSFLog.info("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseTestSFLog.info("went wrong when capturing the screen");
			
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		
	}

}
