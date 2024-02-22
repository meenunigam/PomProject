package com.sf.page.forgotpasswd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sf.pages.base.BasePage;

public class ForgotPassWdPage extends BasePage{
	
	@FindBy(id ="continue") WebElement continueButElement;
	@FindBy(id ="un") WebElement emailFieldElement;
	
	public ForgotPassWdPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver clickContineButton() {
		ClickBut(continueButElement,"clicked continue button");
		return driver;
		}
	
	public void enterEmail(String data) {
		sendingText(emailFieldElement, data, "email field");
	}
	
}
