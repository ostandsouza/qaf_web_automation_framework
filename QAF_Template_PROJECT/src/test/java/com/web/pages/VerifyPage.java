package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;

public class VerifyPage extends BasePage{

	 @FindBy(locator = "xpath=//a[text()='Verify']")
	    public CustomElement lVerify;
	 
	 @FindBy(locator = "xpath=//input[@formcontrolname='email']")
	    public CustomElement tbemail;
	 
	 @FindBy(locator = "xpath=//input[@formcontrolname='secret']")
	    public CustomElement tbsecret;
	 
	 @FindBy(locator = "xpath=//span[text()='Submit']")
	    public CustomElement btSubmit;
	 
	 @FindBy(locator = "xpath=//a[text()='Login']")
	    public CustomElement lLogin;
	 
	 public void verify() {
		 lVerify.click();
	 }
	 
	 public void Verify(String email, String secret)  { 	
	        tbemail.type(email, "Randomemail"); 
	        tbsecret.type(secret, "Secret");
	        btSubmit.click();
	        SyncUtil.waitFor(5000);
	    }
}
