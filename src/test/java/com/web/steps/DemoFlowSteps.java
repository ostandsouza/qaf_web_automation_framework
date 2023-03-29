package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.MaildropHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.selenium.AssertionService;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.*;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class DemoFlowSteps {

    public static String emailInd;
    public static String emailGer;

    APIBase api = new APIBase();;
	LoginPage loginPage = new LoginPage();
	UsersPage userpage = new UsersPage();
	DemoPage demopage = new DemoPage();
    DashboardPage dashboardpage = new DashboardPage();

    UsermanagementPage uManagementPage = new UsermanagementPage();

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
    	demopage.createdistribtorshop(DistShopIndName, DistShopIndAddress, DistCorpName, "India", FullNameInd);
    }
    
    @QAFTestStep(description="Create a Distributor shop in Germany with {DistShopGerName} and {DistShopGerAddress} and {DistCorpName} and {FullNameGer}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String DistShopGerName,String DistShopGerAddress,String DistCorpName, String FullNameGer) {
        String companyId = api.getCompanyAPI(DistShopGerName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.createdistribtorshop2(DistShopGerName, DistShopGerAddress,DistCorpName,"Germany",FullNameGer);
    }

    @QAFTestStep(description="Create a Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporateMiningCorp(String CustCorpName, String CustCorpAddress){
        String companyId = api.getCompanyAPI(CustCorpName);
        api.deleteCompanyAPI(companyId);
    	demopage.createcustomercorporate(CustCorpName, CustCorpAddress);
    	
    }
    @QAFTestStep(description="Create a Customer site in India {CustShopIndName} and {CustShopIndAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd){
        String companyId = api.getCompanyAPI(CustShopIndName);
        api.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createcustomersiteIndia(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,"India",FullNameInd);
    	
    }
    
    @QAFTestStep(description="Create a Customer site in Germany with {CustShopGerName} and {CustShopGerAddress} and {CustCorpName} and {DistShopGerName} and {FullNameGer}")
    public void createACustomerSiteInGermanyMiningCorpGermanyWithDistribBeltAssociatesGermanyAnd(String CustShopGerName,String CustShopGerAddress,String CustCorpName,String DistShopGerName,String FullNameGer){
        String companyId = api.getCompanyAPI(CustShopGerName);
        api.deleteCompanyAPI(companyId);
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

    @QAFTestStep(description="Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void showListOfCustomerCorporatesAndUsersAsAnAdmin(String CustCorpName, String CustCorpAddress){
        demopage.showconveyorssitescorporatesandusers(CustCorpName,CustCorpAddress);
    }

    @QAFTestStep(description="Edit {ConveyorNameGer1} to {ConveyorNameGer1Edit}")
    public void editAConveyorGermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
        String conveyorId = api.getConveyorsAPI(ConveyorNameGer1Edit);
        api.putConveyorAPI(conveyorId, api.getConveyorAPI(conveyorId), ConveyorNameGer1);
        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
    }

    @QAFTestStep(description="Edit {ConveyorNameGer1} into {ConveyorNameGer1Edit}")
    public void editConveyorGermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
        String conveyorId = api.getConveyorsAPI(ConveyorNameGer1Edit);
        api.deleteConveyorAPI(conveyorId);
        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
    }

    @QAFTestStep(description="Edit {ConveyorNameGer1} name to {ConveyorNameGer1Edit}")
    public void editAConveyorC2GermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
    }

    @QAFTestStep(description="Check {ConveyorNameGer2} at {CustCorpName}")
    public void checkAConveyorC1GermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName){
        demopage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
    }

    @QAFTestStep(description = "Login with normal user {UserName} and {Password}")
    public void loginWith(String UserName, String Password) {
        api = new APIBase();
        if(!MaildropHelper.getMaildropInbox(UserName).isEmpty()) {
            String otp = MaildropHelper.getOtpfromMail(MaildropHelper.getInboxMsg(UserName, MaildropHelper.getLatestMailId(MaildropHelper.getMaildropInbox(UserName))));
            if(api.secretVerifyAPI(UserName, otp)!=200){
                api.resendVerifyAPI(UserName);
                SyncUtil.waitFor(10000);
                if(!MaildropHelper.getMaildropInbox(UserName).isEmpty()) {
                    otp = MaildropHelper.getOtpfromMail(MaildropHelper.getInboxMsg(UserName, MaildropHelper.getLatestMailId(MaildropHelper.getMaildropInbox(UserName))));
                    api.secretVerifyAPI(UserName, otp);
                }
            }
        }
        loginPage.loginToApp(UserName, Password);
        dashboardpage.handleCookiePopup();
    }

    @QAFTestStep(description="Create a Distributor User for Germany {FullNameDistGer} and {Phone} and {EmailDistGer} and {ProfileTypeDist} and {UserPassword} and {RetypePassword} and {CoporateRole} and {DistCorpName} and {DistShopGerName} and {CustSiteGerName}")
    public void createATerritoryManagerForIndiaJohnDoe(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword, String CoporateRole, String DistCorpName, String DistShopGerName, String CustSiteGerName) {
        getBundle().setProperty("email.ind2", EmailInd);
        String userid = api.getUserProfileAPI(EmailInd);
        api.deleteProfileAPI(userid);
        api.deleteUserAPI(userid);
        userpage.usersclick();
        userpage.Addclick();
        userpage.setfullname(FullNameInd);
        userpage.setPhone("+91",Phone);
        userpage.setemail(EmailInd);
        userpage.setprofiletype(ProfileType);
        userpage.setpassword(UserPassword);
        userpage.setretypepassword(RetypePassword);
        userpage.distributorInformation(DistCorpName,CoporateRole);
        userpage.Nextclick();
        uManagementPage.DistributorAssignment(DistShopGerName,CustSiteGerName);
        userpage.setPermission();
        userpage.Clicksaveandclose();
    }

    @QAFTestStep(description="Change permission for {0} to see {1}")
    public void changePermissionForToSee(String FullNameInd,String region) {
        userpage.goToEditUserPage(FullNameInd);
        userpage.clickOnNextBtn();
        userpage.setTerritory(region);
        userpage.clickOnNextBtn();
        userpage.clickOnUpdateBtn();
    }

    @QAFTestStep(description="Logout from the current user")
    public void logoutFromCurrentUser() {
        demopage.logoutUser().verifyUserOnLoginPage();
    }

    @QAFTestStep(description="Delete everything {DistCorpName} and {DistShopIndName} and {DistShopGerName} and {CustCorpName} and {CustSiteIndName} and {CustSiteGerName} and {ConveyorNameGer} and {ConveyorNameInd} and {ConveyorNameGerWeb} and {ConveyorNameInd2} and {ConveyorNameGer2} and {FullNameInd} and {FullNameGer} and {FullNameDistGer}")
    public void deleteEverything(String distCorpName, String distShopIndName, String distShopGerName, String custCorpName, String CustSiteIndName, String CustSiteGerName, String ConveyorNameGer, String ConveyorNameInd, String ConveyorNameGerWeb, String ConveyorNameInd2, String ConveyorNameGer2, String FullNameInd, String FullNameGer, String FullNameDistGer) {
        demopage.deleteConveyor(custCorpName, ConveyorNameGer);
        demopage.verifyConveyor(custCorpName, ConveyorNameGer);
        demopage.deleteConveyor(custCorpName, ConveyorNameInd);
        demopage.verifyConveyor(custCorpName, ConveyorNameInd);
        demopage.deleteConveyor(custCorpName, ConveyorNameGerWeb);
        demopage.verifyConveyor(custCorpName, ConveyorNameGerWeb);
        demopage.deleteConveyor(custCorpName, ConveyorNameInd2);
        demopage.verifyConveyor(custCorpName, ConveyorNameInd2);
        demopage.deleteConveyor(custCorpName, ConveyorNameGer2);
        demopage.verifyConveyor(custCorpName, ConveyorNameGer2);
        demopage.deleteSiteOrShop(custCorpName, CustSiteIndName);
        demopage.verifySiteOrShop(custCorpName, CustSiteIndName);
        demopage.deleteSiteOrShop(custCorpName, CustSiteGerName);
        demopage.verifySiteOrShop(custCorpName, CustSiteGerName);
        demopage.deleteCorporate(custCorpName);
        demopage.verifyCorporate(custCorpName);
        demopage.deleteSiteOrShop(distCorpName, distShopIndName);
        demopage.verifySiteOrShop(custCorpName, distShopIndName);
        demopage.deleteSiteOrShop(distCorpName, distShopGerName);
        demopage.verifySiteOrShop(custCorpName, distShopGerName);
        demopage.deleteCorporate(distCorpName);
        demopage.verifyCorporate(distCorpName);
        demopage.deleteUser(FullNameInd);
        demopage.verifyUser(FullNameInd);
        demopage.deleteUser(FullNameGer);
        demopage.verifyUser(FullNameGer);
        demopage.deleteUser(FullNameDistGer);
        demopage.verifyUser(FullNameDistGer);
    }
}
