package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.MaildropHelper;
import com.common.utils.MiscUtils;
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
        String userid = demopage.apiBase.getUserProfileAPI(EmailInd);
        demopage.apiBase.deleteProfileAPI(userid);
        demopage.apiBase.deleteUserAPI(userid);
//        getBundle().setProperty("email.ind", EmailInd);
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
        String userid = demopage.apiBase.getUserProfileAPI(EmailGer);
        demopage.apiBase.deleteProfileAPI(userid);
        demopage.apiBase.deleteUserAPI(userid);
//        getBundle().setProperty("email.ger", EmailGer);
        SyncUtil.waitFor(2000);
        userpage.usersclick();
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
        String companyId = demopage.apiBase.getCompanyAPI(DistCorpName);
        demopage.apiBase.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createcorporate(DistCorpName, DistCorpAddress);
    
    } 
    @QAFTestStep(description="Create a Distributor shop in India with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullNameInd}")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(String DistShopIndName,String DistShopIndAddress, String DistCorpName,String FullNameInd){
        String companyId = demopage.apiBase.getCompanyAPI(DistShopIndName);
        demopage.apiBase.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createdistribtorshop(DistShopIndName, DistShopIndAddress, DistCorpName, "India", FullNameInd);
    }
    
    @QAFTestStep(description="Create a Distributor shop in Germany with {DistShopGerName} and {DistShopGerAddress} and {DistCorpName} and {FullNameGer}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String DistShopGerName,String DistShopGerAddress,String DistCorpName, String FullNameGer) {
        String companyId = demopage.apiBase.getCompanyAPI(DistShopGerName);
        demopage.apiBase.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
        demopage.createdistribtorshop2(DistShopGerName, DistShopGerAddress,DistCorpName,"Germany",FullNameGer);
    }

    @QAFTestStep(description="Create a Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporateMiningCorp(String CustCorpName, String CustCorpAddress){
        String companyId = demopage.apiBase.getCompanyAPI(CustCorpName);
        demopage.apiBase.deleteCompanyAPI(companyId);
    	demopage.createcustomercorporate(CustCorpName, CustCorpAddress);
    	
    }
    @QAFTestStep(description="Create a Customer site in India {CustShopIndName} and {CustShopIndAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd){
        String companyId = demopage.apiBase.getCompanyAPI(CustShopIndName);
        demopage.apiBase.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createcustomersiteIndia(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,"India",FullNameInd);
    	
    }
    
    @QAFTestStep(description="Create a Customer site in Germany with {CustShopGerName} and {CustShopGerAddress} and {CustCorpName} and {DistShopGerName} and {FullNameGer}")
    public void createACustomerSiteInGermanyMiningCorpGermanyWithDistribBeltAssociatesGermanyAnd(String CustShopGerName,String CustShopGerAddress,String CustCorpName,String DistShopGerName,String FullNameGer){
        String companyId = demopage.apiBase.getCompanyAPI(CustShopGerName);
        demopage.apiBase.deleteCompanyAPI(companyId);
        demopage.clickcorporates();
    	demopage.createcustomersiteGermany(CustShopGerName, CustShopGerAddress,CustCorpName,DistShopGerName,"Germany",FullNameGer);
    }
  
    @QAFTestStep(description="Create a conveyor Germany with {ConveyorNameGer} and {DistShopGerName} and {CustShopGerName}")
    public void createAConveyorCGermanyAtMiningCorpGermany(String ConveyorNameGer, String DistShopGerName, String CustShopGerName){
        String conveyorId = demopage.apiBase.getConveyorsAPI(ConveyorNameGer);
        demopage.apiBase.deleteConveyorAPI(conveyorId);
        demopage.createConveyorGermany(ConveyorNameGer, DistShopGerName, CustShopGerName);
    }
    
    @QAFTestStep(description="Create a conveyor India with {ConveyorNameInd} and {DistShopIndName} and {CustShopIndName}")
    public void createAConveyorCIndiaAtMiningCorpIndia(String ConveyorNameInd, String DistShopIndName, String CustShopIndName){
        String conveyorId = demopage.apiBase.getConveyorsAPI(ConveyorNameInd);
        demopage.apiBase.deleteConveyorAPI(conveyorId);
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
        String conveyorId = demopage.apiBase.getConveyorsAPI(ConveyorNameGer1Edit);
        demopage.apiBase.putConveyorAPI(conveyorId, demopage.apiBase.getConveyorAPI(conveyorId), ConveyorNameGer1);
        demopage.editConveyorGermany(ConveyorNameGer1, ConveyorNameGer1Edit);
    }

    @QAFTestStep(description="Edit {ConveyorNameGer1} into {ConveyorNameGer1Edit}")
    public void editConveyorGermanyAtMiningCorpGermany(String ConveyorNameGer1, String ConveyorNameGer1Edit){
        String conveyorId = demopage.apiBase.getConveyorsAPI(ConveyorNameGer1Edit);
        demopage.apiBase.deleteConveyorAPI(conveyorId);
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
        String otp;
        String userid = demopage.apiBase.getUserProfileAPI(UserName);
        if(!demopage.apiBase.getUserAPI(userid)) {
            if (!MiscUtils.isNewEmailTriggered(UserName)) {
                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                if (demopage.apiBase.secretVerifyAPI(UserName, otp) != 200) {
                    demopage.apiBase.resendVerifyAPI(UserName);
                    if (!MiscUtils.isNewEmailTriggered(UserName)) {
                        otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                        demopage.apiBase.secretVerifyAPI(UserName, otp);
                    }
                }
            } else {
                demopage.apiBase.resendVerifyAPI(UserName);
                otp = MiscUtils.getOtpfromMail(MiscUtils.getLatestEmailBody(UserName));
                demopage.apiBase.secretVerifyAPI(UserName, otp);
            }
        }
        loginPage.loginToApp(UserName, Password);
        dashboardpage.handleCookiePopup();
    }

    @QAFTestStep(description="Create a Distributor User for Germany {FullNameDistGer} and {Phone} and {EmailDistGer} and {ProfileTypeDist} and {UserPassword} and {RetypePassword} and {CoporateRole} and {DistCorpName} and {DistShopGerName} and {CustSiteGerName}")
    public void createDistributorUserForIndiaJohnDoe(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword, String CoporateRole, String DistCorpName, String DistShopGerName, String CustSiteGerName) {
//        getBundle().setProperty("email.ind2", EmailInd);
        String userid = demopage.apiBase.getUserProfileAPI(EmailInd);
        demopage.apiBase.deleteProfileAPI(userid);
        demopage.apiBase.deleteUserAPI(userid);
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
        userpage.goToUsers();
        userpage.searchUser(FullNameInd);
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
        Validator.assertTrue(demopage.verifyConveyor(custCorpName, ConveyorNameGer),"Conveyor did not delete properly","Conveyor deleted successfully");
        demopage.deleteConveyor(custCorpName, ConveyorNameInd);
        Validator.assertTrue(demopage.verifyConveyor(custCorpName, ConveyorNameInd),"Conveyor did not delete properly","Conveyor deleted successfully");
        demopage.deleteConveyor(custCorpName, ConveyorNameGerWeb);
        Validator.assertTrue(demopage.verifyConveyor(custCorpName, ConveyorNameGerWeb),"Conveyor did not delete properly","Conveyor deleted successfully");
        demopage.deleteConveyor(custCorpName, ConveyorNameInd2);
        Validator.assertTrue(demopage.verifyConveyor(custCorpName, ConveyorNameInd2),"Conveyor did not delete properly","Conveyor deleted successfully");
        demopage.deleteConveyor(custCorpName, ConveyorNameGer2);
        Validator.assertTrue(demopage.verifyConveyor(custCorpName, ConveyorNameGer2),"Conveyor did not delete properly","Conveyor deleted successfully");
        demopage.deleteSiteOrShop(custCorpName, CustSiteIndName);
        Validator.assertTrue(demopage.verifySiteOrShop(custCorpName, CustSiteIndName),"Site did not delete properly","Site deleted successfully");
        demopage.deleteSiteOrShop(custCorpName, CustSiteGerName);
        Validator.assertTrue(demopage.verifySiteOrShop(custCorpName, CustSiteGerName),"Site did not delete properly","Site deleted successfully");
        demopage.deleteCorporate(custCorpName);
        Validator.assertTrue(demopage.verifyCorporate(custCorpName),"Corporate did not delete properly","Corporate deleted successfully");
        demopage.deleteSiteOrShop(distCorpName, distShopIndName);
        Validator.assertTrue(demopage.verifySiteOrShop(custCorpName, distShopIndName),"Shop did not delete properly","Shop deleted successfully");
        demopage.deleteSiteOrShop(distCorpName, distShopGerName);
        Validator.assertTrue(demopage.verifySiteOrShop(custCorpName, distShopGerName),"Shop did not delete properly","Shop deleted successfully");
        demopage.deleteCorporate(distCorpName);
        Validator.assertTrue(demopage.verifyCorporate(distCorpName),"Corporate did not delete properly","Corporate deleted successfully");
        demopage.deleteUser(FullNameInd);
        Validator.assertTrue(demopage.verifyUser(FullNameInd),"User did not delete properly","User deleted successfully");
        demopage.deleteUser(FullNameGer);
        Validator.assertTrue(demopage.verifyUser(FullNameGer),"User did not delete properly","User deleted successfully");
        demopage.deleteUser(FullNameDistGer);
        Validator.assertTrue(demopage.verifyUser(FullNameDistGer),"User did not delete properly","User deleted successfully");
    }
}
