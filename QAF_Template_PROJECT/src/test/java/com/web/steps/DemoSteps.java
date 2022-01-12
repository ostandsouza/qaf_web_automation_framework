package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.BasePage;
import com.web.pages.DemoPage;
import com.web.pages.LoginPage;
import com.web.pages.UsersPage;

public class DemoSteps extends BasePage {

	LoginPage loginPage = new LoginPage();
	UsersPage userpage = new UsersPage();
	DemoPage demopage = new DemoPage();

    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
        loginPage.verifyTitle("Conti+");
    }

    @QAFTestStep(description = "Login with {UserName} and {Password}")   
     public void loginWithAnd(String UserName, String Password) {
        loginPage.loginToApp(UserName, Password);
    }
    @QAFTestStep(description="Check profile")
    public void checkProfile(){
    	if (loginPage.getCurrentURL().endsWith("#/auth/login"))
            Reporter.log("profile page is displayed", MessageTypes.Pass);
        else
            Reporter.log("profile page is not displayed", MessageTypes.Fail);
    	SyncUtil.waitFor(4000);
    }
    @QAFTestStep(description="Create a Territory manager for India John Doe {Fullname} and {Phone} and {Profiletype} and {Userpassword} and {Retypepassword}")
    public void createATerritoryManagerForIndiaJohnDoe(String Fullname,String Phone,String Profiletype,String Userpassword,String Retypepassword) throws InterruptedException {
	    userpage.usersclick();
    	userpage.Addclick();
    	userpage.setfullname(Fullname);
		userpage.setPhone(Phone);
		String Email = "Demotm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email);
		userpage.setprofiletype(Profiletype);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermission();
		userpage.Clicksaveandclose();
    }
    @QAFTestStep(description="Create a Territory manager for Germany Max Mustermann {Fullname1} and {Phone} and {Profiletype} and {Userpassword} and {Retypepassword}")
    public void createATerritoryManagerForGermanyMaxMustermannAndAndAndAnd(String Fullname1,String Phone,String Profiletype,String Userpassword,String Retypepassword) throws InterruptedException{
    	SyncUtil.waitFor(2000);
    	userpage.Addclick();
    	userpage.setfullname1(Fullname1);
		userpage.setPhone(Phone);
		String Email = "Demotm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email);
		userpage.setprofiletype(Profiletype);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermission();
		userpage.Clicksaveandclose();
    }
    @QAFTestStep(description="Create a Distributor Corporate Belt Associates Corp {companyname}")
    public void createADistributorCorporateBeltAssociatesCorp(String companyname){
    	demopage.clickcorporates();
    	demopage.createcorportae(companyname);
    
    }
    @QAFTestStep(description="Create a Distributor shop in India Belt Associates India with TM John Doe")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(){
    	
    }
    

}
