package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.BasePage;
import com.web.pages.UsersPage;

import java.util.Map;

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
		userpage.addClick();
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
		userpage.setProfileType(Profiletype);
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
		userpage.setProfileType(Profiletypetu);
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
		userpage.setProfileType(Profiletypeta1);
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
		userpage.setProfileType(Profiletypeta1);
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
		userpage.setProfileType(Profiletypeta);
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
    public void ClickOnLogout() {
		SyncUtil.waitFor(3000);
		userpage.clickOnLogout();
	}

	@QAFTestStep(description="Create a Market manager {FullNameInd} and {Phone} and {EmailInd} and {ProfileType} and {UserPassword} and {RetypePassword}")
	public void createMarketManager(String FullNameInd,String Phone,String EmailInd, String ProfileType,String UserPassword,String RetypePassword) {
		String userid = userpage.apiBase.getUserProfileAPI(EmailInd);
		userpage.apiBase.deleteProfileAPI(userid);
		userpage.apiBase.deleteUserAPI(userid);
		userpage.usersclick();
		userpage.addClick();
		userpage.setfullname(FullNameInd);
		userpage.setPhone("+91",Phone);
		userpage.setemail(EmailInd);
		userpage.setProfileType(ProfileType);
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
		userpage.addClick();
		userpage.setfullname(FullName);
		userpage.setPhone("+91",Phone);
		userpage.setemail(EmailDist);
		userpage.setProfileType(ProfileTypeDist);
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

	@QAFTestStep(description="Add permission rights with {Module} {SubModule} {Add} {Edit} {Delete} {View} {Download} and create user")
	public void addSubModuleWisePermissionForUser(String module, String subModule,String add, String edit, String delete, String view, String download) {
		userpage.setPermission(module, subModule, add, edit, delete, view, download);
		userpage.Clicksaveandclose();
	}

	@QAFTestStep(description="Add permission rights with {Module} {Add} {Edit} {Delete} {View} {Download} and create user")
	public void addModuleWisePermissionForUser(String module, String add, String edit, String delete, String view, String download) {
		userpage.setPermission(module, add, edit, delete, view, download);
		userpage.Clicksaveandclose();
	}

	@QAFTestStep(description = "Verify {FullName} user with market manager for market as {Region} and permission rights as {Add} {Edit} {Delete} {View} {Download}")
	public void verifyMarketAndPermissionForUser(String fullName, String region, String add, String edit, String delete, String view, String download) {
		userpage.goToUsersAndWait();
		userpage.searchUser(fullName);
		userpage.goToEditUserPage(fullName);
		userpage.Nextclick();
		userpage.verifyTerritory(region);
		userpage.Nextclick();
		userpage.verifyPermission(add, edit, delete, view, download);
	}

	@QAFTestStep(description = "Verify {FullName} user with distributor user for market as {Region} and permission rights as {Add} {Edit} {Delete} {View} {Download}")
	public void verifyMarketAndPermissionForDistUser(String fullName, String region, String add, String edit, String delete, String view, String download) {
		userpage.goToUsersAndWait();
		userpage.searchUser(fullName);
		userpage.goToEditUserPage(fullName);
		userpage.Nextclick();
		userpage.Nextclick();
		userpage.verifyPermission(add, edit, delete, view, download);
	}

	@QAFTestStep(description="Delete User with name {userName}")
	public void deleteUserWithName(String userName){
		userpage.deleteUser(userName);
	}

	@QAFTestStep(description="Verify user {0} is deleted")
	public void verifyUserIsDelete(String str0){
		Validator.assertTrue(userpage.verifyUser(str0),"User did not delete properly","User deleted successfully");
	}

	@QAFTestStep(description="Navigate to User Bulk Upload")
	public void verifyUserBulkImportNavigation(){
		Validator.assertTrue(userpage.goToUserBulkUpload(),"User bulk import navigation failed","User bulk import navigation was successful");
	}

	@QAFTestStep(description="Verify the sections is bulk import")
	public void verifyBulkImportSections(){
		Validator.assertTrue(userpage.verifyUploadSections(),"User bulk import header verification failed","User bulk import header verification was successful");
	}

	@QAFTestStep(description="Select {UserType} and verify the UI")
	public void verifyBulkImportUI(String userType){
		Validator.assertTrue(userpage.verifyImportSection(userType),"User bulk import template verification failed","User bulk import template verification was successful");
	}

	@QAFTestStep(description="Download bulk upload template for {0} and {1}")
	public void downloadBulkUploadTemplate(String userType, String corp){
		userpage.checkDownloadTemplate(userType,corp);
		SyncUtil.waitFor(10000);
		Validator.assertTrue(MiscUtils.checkDownloadedFiles("BulkUserTemplate.xlsx"),"User bulk upload template was not found","User bulk upload template was downloaded successfully");
		userpage.verifyTemplateSheet(userType,"BulkUserTemplate.xlsx");
		MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");	}

	@QAFTestStep(description="Verify bulk upload template Columns for {UserType} and file {File}")
	public void verifyTemplateContents(String userType, String fileName){
		userpage.checkDownloadTemplate(userType, fileName);
		SyncUtil.waitFor(10000);
		userpage.verifyTemplateFields(userType,"BulkUserTemplate.xlsx");
		MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
	}

	@QAFTestStep(description="Upload file with name {file}")
	public void verifyFileUpload(String fileName){
		userpage.userFileImport(fileName);
	}

	@QAFTestStep(description="Verify the success message after uploading file with name {file}")
	public void verifySuccessMsgFileUpload(String fileName){
		Validator.assertTrue(userpage.userFileUpload(fileName),"User bulk import file upload failed","User bulk import file upload was successful");
	}

	@QAFTestStep(description="Verify bulk upload analysis result after uploading file with name {file} having count {count}")
	public void verifyBulkImportAnalysis(String fileName, int count){
		userpage.userFileImport(fileName);
		userpage.acknowledgeImport(count);
	}

	@QAFTestStep(description="Verify bulk upload analysis toast message after uploading file with name {0}")
	public void verifyBulkUploadAnalysisToastMessage(String fileName){
		userpage.userFileImport(fileName);
		userpage.verifyMsg();
	}

	@QAFTestStep(description="Verify bulk user import functionality after uploading file with name {File} and user type {UserType}")
	public void verifyBulkImportFunctionality(String fileName, String userType){
		Object[][] obj = MiscUtils.getExcelData(fileName,userType);
		for( int i = obj.length;i>0;i--){
			String userid = userpage.apiBase.getUserProfileAPI(((Map<String,String>)obj[i-1][0]).get("EmailId"));
			userpage.apiBase.deleteProfileAPI(userid);
			userpage.apiBase.deleteUserAPI(userid);
		}
		userpage.userFileImport(fileName);
		Validator.assertTrue(userpage.importUsers(),"Bulk user creation failed","User user creation was successful");
	}

	@QAFTestStep(description="Validate User {FileName} should display in list with same data as filled in excel sheet {UserType}")
	public void verifyBulkImportedUsers(String fileName, String userType){
		userpage.goToUsersAndWait();
		userpage.verifyUploadedUsers(userType, fileName);
	}
}
