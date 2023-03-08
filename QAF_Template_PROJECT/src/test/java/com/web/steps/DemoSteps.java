package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.*;

import static com.web.pages.BasePage.randomestring;

public class DemoSteps{

	LoginPage loginPage = new LoginPage();
	UsersPage userpage = new UsersPage();
	DemoPage demopage = new DemoPage();

    DashboardPage dashboardpage = new DashboardPage();

    @QAFTestStep(description = "User is at Login page")
    public void verifyUserIsAtLoginPage() {
        loginPage.verifyTitle("Conti+");
    }

    @QAFTestStep(description = "Login with {UserName} and {Password}")   
     public void loginWithAnd(String UserName, String Password) {
        loginPage.loginToApp(UserName, Password);
        dashboardpage.handleCookiePopup();
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
    public void createATerritoryManagerForGermanyMaxMustermannAndAndAndAnd(String Fullname1,String Phone,String Profiletype,String Userpassword,String Retypepassword) throws InterruptedException {
        SyncUtil.waitFor(5000);
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
    
    @QAFTestStep(description="Create a Distributor Corporate Belt Associates Corp {companyname} and {Address}")
    public void createADistributorCorporateBeltAssociatesCorp(String companyname, String Address){
    	demopage.clickcorporates();
    	demopage.createcorportae(companyname, "india");
    
    } 
    @QAFTestStep(description="Create a Distributor shop in India Belt Associates India with TM John Doe {companyname1} and {Address1}")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(String companyname1,String Address1){
    	demopage.clickcorporates();
    	demopage.createdistribtorshop(companyname1, "india");
    }
    
    @QAFTestStep(description="Create a Distributor shop in Germany Belt Associates Germany with TM Max Mustermann {companyname2} and {Address2}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String companyname2,String Address2) {
    	demopage.createdistribtorshop2(companyname2, "india");
    }

    @QAFTestStep(description="Create a Customer Corporate Mining Corp {ccCompanyname} and {ccAddress}")
    public void createACustomerCorporateMiningCorp(String ccCompanyname, String ccAddress) throws InterruptedException{
    	demopage.clickcorporates();
    	demopage.createcustomercorporate(ccCompanyname, "india");
    	
    }
    @QAFTestStep(description="Create a Customer site in India Â Mining Corp. India with Distrib Belt Associates India {csCompanyname} and {csAddress}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String csCompanyname, String csAddress){
    	demopage.clickcorporates();
    	demopage.createcustomersiteIndia(csCompanyname, csAddress);
    	
    }
    
    @QAFTestStep(description="Create a Customer site in Germany Mining Corp. Germany with Distrib Belt Associates Germany {csGCompanyname} and {csGAddress}")
    public void createACustomerSiteInGermanyMiningCorpGermanyWithDistribBeltAssociatesGermanyAnd(String csGCompanyname,String csGAddress){
    	demopage.clickcorporates();
    	demopage.createcustomersiteGermany(csGCompanyname, csGAddress);
    }
  
    @QAFTestStep(description="Create a conveyor C{0} Germany at Mining Corp. Germany {conveyorname}")
    public void createAConveyorCGermanyAtMiningCorpGermany(long l0, String conveyorname){
    	demopage.createconveyorc1Germany(conveyorname);
    }
    
    @QAFTestStep(description="Create a conveyor C{0} India at Mining Corp. India {conveyorname1}")
    public void createAConveyorCIndiaAtMiningCorpIndia(long l0, String conveyorname1){
    	demopage.createconveyorc1India(conveyorname1);
    }
    
        
    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin {Searchtext}")
    public void showListOfConveyorsSitesCorporatesAndUsersAsAnAdmin(String Searchtext) throws Throwable{
    	demopage.showconveyorssitescorporatesandusers(Searchtext);
    }
    
    @QAFTestStep(description="Show site page, conveyor page")
    public void showSitePageConveyorPage(){
    
    }
}
