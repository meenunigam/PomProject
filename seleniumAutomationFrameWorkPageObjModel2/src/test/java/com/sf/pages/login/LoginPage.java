package com.sf.pages.login;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sf.pages.base.BasePage;

	public class LoginPage extends BasePage{
		@FindBy(id="username") WebElement userNameElement;
		@FindBy(id="password") WebElement passwordElement;
		@FindBy(id="Login") WebElement loginButtonElement;
		@FindBy(id="error") WebElement errorMsg;
		@FindBy(id="rememberUn") WebElement rememberMeElement;
		@FindBy(id="forgot_password_link") WebElement forgotPassWordElement;
		@FindBy(id="idcard-identity") WebElement userNameAfterLogOut;
		@FindBy(id ="forgot_password_link") WebElement forgotPasswdElement;
		
		public LoginPage(WebDriver driver) {
			super(driver);
		}
		
		public void enterUserName(String data) {
			//userNameElement.sendKeys(data);
			sendingText(userNameElement, data, "Username textbox");
			//extentReport.logTestInfo("username data is entered in username field");
		}
		public void enterPassword(String data) {
			sendingText(passwordElement, data, "password field");
		}
		
		public WebDriver clickLoginButton() {
			ClickBut(loginButtonElement,"login button");
			return driver;
			
		}
		
		public WebDriver clickForgotPasswd() {
			ClickBut(forgotPasswdElement,"clicked Forgot Password");
			return driver;
			
		}
		public void clickRememberMe() {
			ClickBut(rememberMeElement,"clicked remember me check box");
		}
		
		
		public String readText() {
			return gettingText(errorMsg, "Error Message");
		}
		
		public String readErrText() {
			return gettingText(errorMsg, "Error Message");
		}
		
		public String readUserName() {
			return gettingText(userNameAfterLogOut,"UserName Field read");
		}
		
		
		public String getTitleOfThePage() {
			//waitUntilPageLoads();
			return getPageTitle();
		}
		public Alert switchToErrorAlert() {
			return switchToAlert();
		}
		public String extractTextFromAlert(Alert a) {
			return getAlertText(a,"LOginError Alert");
		}
		public void acceptErrorAlert(Alert a) {
			AcceptAlert(a);
		}
		
		
		

		
}


