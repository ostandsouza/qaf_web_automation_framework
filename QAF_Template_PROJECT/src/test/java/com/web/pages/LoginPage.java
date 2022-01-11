package com.web.pages;
import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;


public class LoginPage extends BasePage {
	


    @FindBy(locator = "id=email")
    public CustomElement tbUserName;

    @FindBy(locator = "css=#password > div > input")
    public CustomElement tbPassword;

    @FindBy(locator = "xpath=//span[text()='Login']")
    public CustomElement btnLogIn;

   
	public void loginToApp(String userName, String password)  {
    	
        tbUserName.type(userName, "UserName"); 
        tbPassword.type(password, "Password");
        btnLogIn.click("LOGIN");
        SyncUtil.waitFor(5000);
    }

}
