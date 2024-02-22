package com.sf.automationTests;

import static org.testng.Assert.assertEquals;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sf.base.BaseTestSF;
import com.sf.page.forgotpasswd.ForgotPassWdPage;
import com.sf.pages.home.HomePage;
import com.sf.pages.login.LoginPage;
import com.sf.utilities.Constants;
import com.sf.utilities.ExtentReportsUtility;
import com.sf.utilities.PropertiesUtility;

public class TestScriptLogin extends BaseTestSF {
	//BaseTestSF baseObj = new BaseTestSF();
	protected Logger TestScriptLog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();

	
	@Test
	public void loginSFTC1() throws InterruptedException {
		
		//createDriver("https://login.salesforce.com");
		//Thread.sleep(5000);
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		TestScriptLog.info("------login to salesforce without password------");
		String expected = "Please enter your password.";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		//loginPage.enterPassword("");
		
		Thread.sleep(2000);
		
		driver = loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		
		String actualMessage = loginPage.readText();
		
		Thread.sleep(2000);
		
		org.testng.Assert.assertEquals(actualMessage,expected );
		
		TestScriptLog.info("-------in login method with blank password field------");
	}
	
	@Test
	public void loginSFTC2() throws InterruptedException {
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		TestScriptLog.info("------login to salesforce with valid username and password------");
		String expected = "Home";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		
		Thread.sleep(2000);
		
		driver = loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		HomePage homePage = new HomePage(driver);
		
		String actualMessage = homePage.readText();//to read text from home page
		
		Thread.sleep(2000);
		
		org.testng.Assert.assertEquals(actualMessage,expected );
		
		TestScriptLog.info("-------in login method with blank password field------");
	}

	@Test
	public void loginSFTC3() throws InterruptedException {
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		TestScriptLog.info("------Started logout test case------");
		String expected = "Home";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		
		loginPage.clickRememberMe();
		
		Thread.sleep(2000);
		
		driver = loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		HomePage homePage = new HomePage(driver);
		
		String actualMessage = homePage.readText();//to read text from home page
		
		org.testng.Assert.assertEquals(actualMessage,expected );
		
		Thread.sleep(2000);
		
		homePage.userMenu();
		Thread.sleep(3000);
		
		driver = homePage.clickLogOutButton();
		
		Thread.sleep(2000);
		
		String userNameActual = loginPage.readUserName();
		
		org.testng.Assert.assertEquals(userNameActual,userName);
		
		Thread.sleep(1000);
		
		
		TestScriptLog.info("-------completed logout test case------");
}
	@Test
	public void loginSFTC4() throws InterruptedException {
		
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		TestScriptLog.info("------starting forgot password test case TC4------");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		driver = loginPage.clickForgotPasswd();
		
		Thread.sleep(2000);
		
		ForgotPassWdPage forgotPage = new ForgotPassWdPage(driver);
		
		String pageTitle = forgotPage.getPageTitle();
		org.testng.Assert.assertEquals(pageTitle,"Forgot Your Password | Salesforce");
	
		//System.out.println("Page Title is " + pageTitle);
		forgotPage.enterEmail("meenunigam@gmail.com");
		driver = forgotPage.clickContineButton();
		
		Thread.sleep(2000);
		
		String checkEmailPageTitle = forgotPage.getPageTitle();
		org.testng.Assert.assertEquals(checkEmailPageTitle,"Check Your Email | Salesforce");
		
		Thread.sleep(1000);
	
		TestScriptLog.info("-------Completed forgot Password test  Case TC4------");
}
	@Test
	public void loginSFTC5() throws InterruptedException {
	
		//String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		TestScriptLog.info("------Starting incorrect username password test case TC5------");
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("123");
		loginPage.enterPassword("22131");
		
		Thread.sleep(2000);
		
		driver = loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		
		String actualMessage = loginPage.readErrText();//to read text from home page
		
		Thread.sleep(2000);
		
		org.testng.Assert.assertEquals(actualMessage,expected );
		
		TestScriptLog.info("-------completed incorrect username password test case TC5------");

}


}