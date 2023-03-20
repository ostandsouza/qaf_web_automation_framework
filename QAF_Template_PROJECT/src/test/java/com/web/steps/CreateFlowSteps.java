package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.*;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class CreateFlowSteps {

    public static String emailInd;
    public static String emailGer;

    APIBase api;
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
        api = new APIBase();
        loginPage.loginToApp(UserName, Password);
        dashboardpage.handleCookiePopup();
    }

    @QAFTestStep(description="Check profile")
    public void checkProfile(){
        demopage.goToUserProfile();
    	if (loginPage.getCurrentURL().endsWith("#/secure/users/user-profile"))
            Reporter.log("profile page is displayed", MessageTypes.Pass);
        else
            Reporter.log("profile page is not displayed", MessageTypes.Fail);
    }

    @QAFTestStep(description="Create a Territory manager for India {FullNameInd} and {Phone} and {EmailInd} and {ProfileType} and {UserPassword} and {RetypePassword}")
    public void createATerritoryManagerForIndia(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword) {
        String userid = api.getUserProfileAPI(EmailInd);
        api.deleteProfileAPI(userid);
        api.deleteUserAPI(userid);
        getBundle().setProperty("email.ind", EmailInd);
        userpage.usersclick();
    	userpage.Addclick();
    	userpage.setfullname(FullNameInd);
		userpage.setPhone("+91",Phone);
        emailInd = EmailInd;
		userpage.setemail(EmailInd);
		userpage.setprofiletype(ProfileType);
		userpage.setpassword(UserPassword);
		userpage.setretypepassword(RetypePassword);
		userpage.Nextclick();
		userpage.setTerritory("APAC");
        userpage.setPermission();
		userpage.Clicksaveandclose();
    }

    @QAFTestStep(description="Create a Territory manager for Germany {FullNameGer} and {Phone} and {EmailGer} and {ProfileType} and {UserPassword} and {RetypePassword}")
    public void createATerritoryManagerForGermanyMaxMustermannAndAndAndAnd(String FullNameGer,String Phone,String EmailGer,String ProfileType,String UserPassword,String RetypePassword){
        String userid = api.getUserProfileAPI(EmailGer);
        api.deleteProfileAPI(userid);
        api.deleteUserAPI(userid);
        getBundle().setProperty("email.ger", EmailGer);
        SyncUtil.waitFor(2000);
        userpage.Addclick();
    	userpage.setfullname1(FullNameGer);
		userpage.setPhone("+91",Phone);
        emailGer = EmailGer;
		userpage.setemail(EmailGer);
		userpage.setprofiletype(ProfileType);
		userpage.setpassword(UserPassword);
		userpage.setretypepassword(RetypePassword);
		userpage.Nextclick();
		userpage.setTerritory("EMEA");
        userpage.setPermission();
		userpage.Clicksaveandclose();
		
    }
    
    @QAFTestStep(description="Create a Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void createADistributorCorporateBeltAssociatesCorp(String DistCorpName, String DistCorpAddress){
        String companyId = api.getCompanyAPI(DistCorpName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createcorporate(DistCorpName, DistCorpAddress);
    
    } 
    @QAFTestStep(description="Create a Distributor shop in India with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullNameInd}")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(String DistShopIndName,String DistShopIndAddress, String DistCorpName,String FullNameInd){
        String companyId = api.getCompanyAPI(DistShopIndName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.goToCorporate();
        demopage.clickcorporates();
    	demopage.createdistribtorshop(DistShopIndName, DistShopIndAddress, DistCorpName, "Indonesia", FullNameInd);
    }
    
    @QAFTestStep(description="Create a Distributor shop in Germany with {DistShopGerName} and {DistShopGerAddress} and {DistCorpName} and {FullNameGer}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String DistShopGerName,String DistShopGerAddress,String DistCorpName, String FullNameGer) {
        String companyId = api.getCompanyAPI(DistShopGerName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.goToCorporate();
        demopage.clickcorporates();
        demopage.createdistribtorshop2(DistShopGerName, DistShopGerAddress,DistCorpName,"Germany",FullNameGer);
    }

    @QAFTestStep(description="Create a Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporateMiningCorp(String CustCorpName, String CustCorpAddress){
        String companyId = api.getCompanyAPI(CustCorpName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.goToCorporate();
        demopage.clickcorporates();
    	demopage.createcustomercorporate(CustCorpName, CustCorpAddress);
    	
    }
    @QAFTestStep(description="Create a Customer site in India {CustShopIndName} and {CustShopIndAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd){
        String companyId = api.getCompanyAPI(CustShopIndName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.goToCorporate();
        demopage.clickcorporates();
    	demopage.createcustomersiteIndia(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,"Indonesia",FullNameInd);
    	
    }
    
    @QAFTestStep(description="Create a Customer site in Germany with {CustShopGerName} and {CustShopGerAddress} and {CustCorpName} and {DistShopGerName} and {FullNameGer}")
    public void createACustomerSiteInGermanyMiningCorpGermanyWithDistribBeltAssociatesGermanyAnd(String CustShopGerName,String CustShopGerAddress,String CustCorpName,String DistShopGerName,String FullNameGer){
        String companyId = api.getCompanyAPI(CustShopGerName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.goToCorporate();
        demopage.clickcorporates();
    	demopage.createcustomersiteGermany(CustShopGerName, CustShopGerAddress,CustCorpName,DistShopGerName,"Germany",FullNameGer);
    }
  
    @QAFTestStep(description="Create a conveyor Germany with {ConveyorNameGer} and {DistShopGerName} and {CustShopGerName}")
    public void createAConveyorCGermanyAtMiningCorpGermany(String ConveyorNameGer, String DistShopGerName, String CustShopGerName){
        String conveyorId = api.getConveyorsAPI(ConveyorNameGer);
        api.deleteConveyorAPI(conveyorId);
        demopage.createConveyorGermany(ConveyorNameGer, DistShopGerName, CustShopGerName);
    }
    
    @QAFTestStep(description="Create a conveyor India with {ConveyorNameInd} and {DistShopIndName} and {CustShopIndName}")
    public void createAConveyorCIndiaAtMiningCorpIndia(String ConveyorNameInd, String DistShopIndName, String CustShopIndName){
        String conveyorId = api.getConveyorsAPI(ConveyorNameInd);
        api.deleteConveyorAPI(conveyorId);
    	demopage.createconveyorc1India(ConveyorNameInd,DistShopIndName,CustShopIndName);
    }
    
        
    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void showListOfDistCorporatesAndUsersAsAnAdmin(String DistCorpName, String DistCorpAddress){
    	demopage.showconveyorssitescorporatesandusers(DistCorpName,DistCorpAddress);
    }

//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Distributor shop in India with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullNameInd}")
//    public void showListOfDistributorShopAndUsersAsAnAdmin(String DistShopIndName, String DistShopIndAddress,String DistCorpName, String FullNameInd){
//        demopage.showconveyorssitescorporatesandusers(DistShopIndName,DistShopIndAddress);
//    }

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress){
        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
    }

//    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer site in Germany with {CustShopGerName} and {CustShopGerAddress} and {CustCorpName} and {DistShopGerName} and {FullNameGer}")
//    public void showListOfCustomerSitesAndUsersAsAnAdmin(String CustShopGerName, String CustShopGerAddress,String CustCorpName, String DistShopGerName, String FullNameGer){
//        demopage.showconveyorssitescorporatesandusers(CustShopGerName,CustShopGerAddress);
//    }

//    @QAFTestStep(description="Show site page, conveyor page")
//    public void showSitePageConveyorPage(){
//        //TODO: remove NotYetImplementedException and call test steps
////        throw new NotYetImplementedException();
//    }


    @QAFTestStep(description="Edit {ConveyorNameGer1} name to {ConveyorNameGer1Edit}")
    public void editAConveyorC1GermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
        String conveyorId = api.getConveyorsAPI(ConveyorNameGer1Edit);
        api.putConveyorAPI(conveyorId, api.getConveyorAPI(conveyorId), ConveyorNameGer1Edit);
        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
    }

    @QAFTestStep(description="Check {ConveyorNameGer2} at {CustCorpName}")
    public void checkAConveyorC1GermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName){
        demopage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
    }
}
