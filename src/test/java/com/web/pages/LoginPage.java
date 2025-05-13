package com.web.pages;
import java.util.concurrent.TimeUnit;

import com.common.utils.APIBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;


public class LoginPage extends BasePage {
	


    @FindBy(locator = "xpath=//input[@id='email']")
    public CustomElement tbUserName;

    @FindBy(locator = "css=#password > div > input")
    public CustomElement tbPassword;

    @FindBy(locator = "xpath=//span[text()='Login']")
    public CustomElement btnLogIn;

	@FindBy(locator = "xpath=//p-password[@formcontrolname=\"oldPassword\"]//div//input")
	public CustomElement tbOldPassword;
	@FindBy(locator = "xpath=//p-password[@formcontrolname=\"password\"]//div//input")
	public CustomElement tbNewPassword;
	@FindBy(locator = "xpath=//p-password[@formcontrolname=\"confirmPassword\"]//div//input")
	public CustomElement tbConfirmPassword;
	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement btnSave;


	public boolean verifyUserOnLoginPage()  {
		waitForElementToDisplay(tbUserName);
		tbUserName.isVisible(10000,"UserName");
		return tbUserName.isDisplayed();
	}

	public void loginToApp(String userName, String password)  {
//		SyncUtil.waitFor(5000);
		
		
		/*
		 * driver.switchTo().alert().getText();
		 * driver.switchTo().alert().sendKeys("Uie68917");
		 * driver.switchTo().alert().sendKeys("Conti@2021");
		 * driver.switchTo().alert().accept();
		 */
		/*
		 * Proxy proxy = new Proxy(); proxy.setHttpProxy("http://cias3basic.conti.de" +
		 * ":" + 8080); proxy.setFtpProxy("http://cias3basic.conti.de" + ":" + 8080);
		 * proxy.setSocksUsername("Uie68917"); proxy.setSocksPassword("Conti@2021");
		 * 
		 * DesiredCapabilities desiredcapabilities = DesiredCapabilities.chrome();
		 * desiredcapabilities.setCapability(CapabilityType.PROXY,proxy);
		 * 
		 * driver = ChromeDriver(desiredcapabilities);
		 */
		System.out.println("entered login to app");

		waitForElementVisible(tbUserName,20000,500);
		tbUserName.type(userName, "UserName");
        tbPassword.type(password, "Password");
        btnLogIn.click("LOGIN");
		waitForElementToInvisible(btnLogIn,15000);
    }


	private QAFExtendedWebDriver ChromeDriver(DesiredCapabilities desiredcapabilities) {
		// TODO Auto-generated method stub
		return null;
	}
	public void changePassword(String password,String newPassword,String confirmPassword){
		tbOldPassword.isVisible(10000,"Current password");
		tbOldPassword.type(password,"Current password");
		tbNewPassword.type(newPassword,"New Password");
		tbConfirmPassword.type(confirmPassword,"Confirm Password");
		btnSave.click("Save");
		waitForElementToInvisible(btnSave,75000);
	}

}
