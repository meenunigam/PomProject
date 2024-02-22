package com.sf.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sf.pages.base.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath ="//*[@id=\"home_Tab\"]/a") WebElement homePageElement;
	@FindBy(id ="userNav-arrow") WebElement userMenuElement;
	
	@FindBy(xpath ="//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logOutElement;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String readText() {
		return gettingText(homePageElement, "Home Tab");
	}
	
	public void userMenu() {
		ClickBut(userMenuElement,"clicked user menu");
	}
	
	public WebDriver clickLogOutButton() {
		ClickBut(logOutElement,"clicked logout button");
		return driver;
		}
	
	
	
	/*public String getTextFromStudentRegistrationFormText() {
		waitForVisibility(studentRegistration, 30,"studetn resitration text area");
		String data= getTextFromElement(studentRegistration, "stu regi form text");
		System.out.println("text extracted from registartion page="+data);
		return data;
	}*/
}


