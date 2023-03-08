package com.web.pages;
import java.util.concurrent.TimeUnit;

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

   
	public void loginToApp(String userName, String password)  {
    	
		SyncUtil.waitFor(5000);
		
		
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
		
		
		tbUserName.type(userName, "UserName"); 
        tbPassword.type(password, "Password");
        btnLogIn.click("LOGIN");
		waitForElementToInvisible(btnLogIn,15000);
    }


	private QAFExtendedWebDriver ChromeDriver(DesiredCapabilities desiredcapabilities) {
		// TODO Auto-generated method stub
		return null;
	}

}
