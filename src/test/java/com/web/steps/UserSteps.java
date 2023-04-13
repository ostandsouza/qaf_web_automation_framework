package com.web.steps;

import com.common.utils.APIBase;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import com.web.pages.UsersPage;

public class UserSteps extends BasePage {
	UsersPage userpage = new UsersPage();
	
	@QAFTestStep(description = "User is at home page")
    public void verifyUserIsAtHomePage() {
		userpage.verifyTitle("Conti+");
            }
	
	@QAFTestStep(description = "Click on users link")
    public void clickonuserslink() throws Throwable {
		
		userpage.usersclick();
		SyncUtil.waitFor(5000);
            }
	
	@QAFTestStep(description = "User can view list of users page")
    public void verifyuserspage() {
		 	if (userpage.getCurrentURL().endsWith("secure/users/list"))
	            Reporter.log("Users page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Users page is not displayed", MessageTypes.Fail);
	    }
	
	@QAFTestStep(description = "Click on Add button")
    public void clickonaddbutton() {
		SyncUtil.waitFor(5000);
		userpage.Addclick();
            }  
	
	@QAFTestStep(description = "User can view add user page")
    public void verifyadduserspage() {
		 	if (userpage.getCurrentURL().endsWith("secure/users/add/user-info"))
	            Reporter.log("Add Users page is displayed", MessageTypes.Pass);
	        else
	            Reporter.log("Add Users page is not displayed", MessageTypes.Fail);
	    }
	
	@QAFTestStep(description = "User enter all required details {Fullname} and {Phone} and {Profiletype} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetails(String Fullname,String Phone,String Profiletype,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname);
		userpage.setPhone("+91",Phone);
		String Email = "Demotm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email);
		userpage.setprofiletype(Profiletype);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setTerritory("APAC");
		
            }                 
	@QAFTestStep(description = "User enter the required details {Fullname1} and {Phone} and {Profiletypetu} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetails1(String Fullname1,String Phone,String Profiletypetu,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname1);
		userpage.setPhone("+91",Phone);
		String Email1 = "Demosc"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypetu);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setPermissions();
		
            } 
	
	@QAFTestStep(description = "User enter required details {Fullname2} and {Phone} and {Profiletypeta1} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetail(String Fullname2,String Phone,String Profiletypeta1,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname2);
		userpage.setPhone("+91",Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta1);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		
            } 	
	@QAFTestStep(description = "User enter required details {Fullname3} and {Phone} and {Profiletypeta1} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetailta2(String Fullname3,String Phone,String Profiletypeta1,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname3);
		userpage.setPhone("+91",Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta1);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		
            } 
	
	@QAFTestStep(description = "User enter required details {Fullname4} and {Phone} and {Profiletypeta} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetailta(String Fullname4,String Phone,String Profiletypeta,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname4);
		userpage.setPhone("+91",Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		
            } 
	
	@QAFTestStep(description = "Click on Save and close button")
    public void Clickonsaveandclose() {
		userpage.Clicksaveandclose();
		SyncUtil.waitFor(3000);
		Reporter.log( "User is cretaed", MessageTypes.Pass);
	}
	
	@QAFTestStep(description = "Admin navigated to user page with created new user")
    public void verifyuserpagewithnewuser() {
		/*if (userpage.getCurrentURL().endsWith("/secure/users/list"))
            Reporter.log("Users page is displayed", MessageTypes.Pass);
        else
            Reporter.log("Users page is not displayed", MessageTypes.Fail);*/
	}
	
	@QAFTestStep(description = "Click on profile and select logout button")
    public void Clickonlogout() {
		SyncUtil.waitFor(3000);
		userpage.clickonlogout();
	}

	@QAFTestStep(description="Create a Market manager {FullNameInd} and {Phone} and {EmailInd} and {ProfileType} and {UserPassword} and {RetypePassword}")
	public void createMarketManager(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword) {
		String userid = userpage.apiBase.getUserProfileAPI(EmailInd);
		userpage.apiBase.deleteProfileAPI(userid);
		userpage.apiBase.deleteUserAPI(userid);
		userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(FullNameInd);
		userpage.setPhone("+91",Phone);
		userpage.setemail(EmailInd);
		userpage.setprofiletype(ProfileType);
		userpage.setpassword(UserPassword);
		userpage.setretypepassword(RetypePassword);
		userpage.Nextclick();
	}

	@QAFTestStep(description="Create a Distributor User {FullName} and {Phone} and {EmailDist} and {ProfileTypeDist} and {UserPassword} and {RetypePassword} and {CoporateRole} and {DistCorpName} and {DistShopName} and {CustSiteName}")
	public void createDistributorUserForIndiaJohnDoe(String FullName,String Phone,String EmailDist, String ProfileTypeDist,String UserPassword,String RetypePassword, String CoporateRole, String DistCorpName, String DistShopName, String CustSiteName) {
		String userid = userpage.apiBase.getUserProfileAPI(EmailDist);
		userpage.apiBase.deleteProfileAPI(userid);
		userpage.apiBase.deleteUserAPI(userid);
		userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(FullName);
		userpage.setPhone("+91",Phone);
		userpage.setemail(EmailDist);
		userpage.setprofiletype(ProfileTypeDist);
		userpage.setpassword(UserPassword);
		userpage.setretypepassword(RetypePassword);
		userpage.distributorInformation(DistCorpName,CoporateRole);
		userpage.Nextclick();
		userpage.DistributorAssignment(DistShopName,CustSiteName);
	}
	@QAFTestStep(description="Add territory as {Region} for the user")
	public void addTerritoryForUser(String region) {
		userpage.setTerritory(region);
	}

	@QAFTestStep(description="Add permission rights with {Add} {Edit} {Delete} {View} {Download} and create user")
	public void addPermissionForUser(String add, String edit, String delete, String view, String download) {
		userpage.setPermission(add, edit, delete, view, download);
		userpage.Clicksaveandclose();
	}

	@QAFTestStep(description = "Verify {FullName} user with market manager for market as {Region} and permission rights as {Add} {Edit} {Delete} {View} {Download}")
	public void verifyMarketAndPermissionForUser(String fullName, String region, String add, String edit, String delete, String view, String download) {
		userpage.goToUsers();
		userpage.searchUser(fullName);
		userpage.goToEditUserPage(fullName);
		userpage.Nextclick();
		userpage.verifyTerritory(region);
		userpage.Nextclick();
		userpage.verifyPermission(add, edit, delete, view, download);
	}

	@QAFTestStep(description = "Verify {FullName} user with distributor user for market as {Region} and permission rights as {Add} {Edit} {Delete} {View} {Download}")
	public void verifyMarketAndPermissionForDistUser(String fullName, String region, String add, String edit, String delete, String view, String download) {
		userpage.goToUsers();
		userpage.searchUser(fullName);
		userpage.goToEditUserPage(fullName);
		userpage.Nextclick();
		userpage.Nextclick();
		userpage.verifyPermission(add, edit, delete, view, download);
	}
}
