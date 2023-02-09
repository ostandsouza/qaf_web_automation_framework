package com.web.steps;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.BasePage;
import com.web.pages.UsermanagementPage;
import com.web.pages.UsersPage;


public class UsermanagementSteps extends BasePage{
	
	
UsersPage userpage = new UsersPage();
UsermanagementPage usermpage = new UsermanagementPage();
	
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
	
	//Master
	@QAFTestStep(description = "User enter required details {FullnameMaster} and {Phone} and {Profiletypemaster} and {Userpassword} and {Retypepassword} and {Templatename}")
    public void userEnterRequiredDetails(String FullnameMaster,String Phone,String Profiletypemaster,String Userpassword,String Retypepassword,String Templatename) throws InterruptedException {
		userpage.setfullname(FullnameMaster);
		
	    //assertEquals(FullnameMaster, "Test Master 2");
		userpage.setPhone(Phone);
assertEquals(Phone, "+919676736246");
		String Email1 = "Demomas"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypemaster);
		//assertEquals(Profiletypemaster, "Master");
		userpage.setpassword(Userpassword);
		assertEquals(Userpassword, "Abc@123456");
		userpage.setretypepassword(Retypepassword);
		assertEquals(Retypepassword, "Abc@123456");
		userpage.Nextclick();
		usermpage.MasterAssignment();
		usermpage.Createtemplate(Templatename);
		usermpage.DeleteTemplate(Templatename);
		userpage.Nextclick();
		usermpage.MasterPermission();
		userpage.Clicksaveandclose();
		usermpage.verifyuser(FullnameMaster);
		
            } 
	//Market Manager
	@QAFTestStep(description="User enter required detail {FullnameMarketManager} and {Phone} and {Profiletypemarketmanager} and {Userpassword} and {Retypepassword} and {Templatename}")
	public void userEnterRequiredDetailAndAndAndAndAnd(String FullnameMarketManager,String Phone,String Profiletypemarketmanager,String Userpassword,String Retypepassword,String Templatename) throws InterruptedException{
		userpage.setfullname(FullnameMarketManager);
		userpage.setPhone(Phone);
		assertEquals(Phone, "+919676736246");
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypemarketmanager);
		assertEquals(Profiletypemarketmanager, "Market manager");
		userpage.setpassword(Userpassword);
		assertEquals(Userpassword, "Abc@123456");
		userpage.setretypepassword(Retypepassword);
		assertEquals(Retypepassword, "Abc@123456");
		userpage.Nextclick();
		usermpage.MasterAssignment();
		//usermpage.Createtemplate(Templatename);
		userpage.Nextclick();
		usermpage.MasterPermission();
		userpage.Clicksaveandclose();    
	}

	
	//Territory Manager
	@QAFTestStep(description = "User enter all required details {Fullnametr} and {Phone} and {Profiletypetr} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetails(String Fullnametr,String Phone,String Profiletypetr,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullnametr);
		//assertEquals(Fullnametr, "Test tr manager");
		userpage.setPhone(Phone);
		assertEquals(Phone, "+919676736246");
		String Email = "Demotm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email);
		userpage.setprofiletype(Profiletypetr);
		assertEquals(Profiletypetr, "Territory Manager");
		userpage.setpassword(Userpassword);
		assertEquals(Userpassword, "Abc@123456");
		userpage.setretypepassword(Retypepassword);
		assertEquals(Retypepassword, "Abc@123456");
		userpage.Nextclick();
		usermpage.MasterAssignment();
		userpage.Nextclick();
		usermpage.setpermission();
		userpage.Clicksaveandclose();
            } 
	//Standard Continental User
	@QAFTestStep(description = "User enter the required details {Fullnamescu} and {Phone} and {Profiletypescu} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetails1(String Fullnamescu,String Phone,String Profiletypescu,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullnamescu);
		//assertEquals(Fullnamescu, "Test scu user");
		userpage.setPhone(Phone);
		assertEquals(Phone, "+919676736246");
		String Email1 = "Demosc"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypescu);
		assertEquals(Profiletypescu, "Standard Continental User");
		userpage.setpassword(Userpassword);
		assertEquals(Userpassword, "Abc@123456");
		userpage.setretypepassword(Retypepassword);
		assertEquals(Retypepassword, "Abc@123456");
		userpage.Nextclick();
		usermpage.Standardassignment();
		userpage.Nextclick();
		usermpage.setpermission();
		userpage.Clicksaveandclose();
		
            } 
	//Distributor User
	@QAFTestStep(description = "User enter the required details db user {Fullnamedb} and {Phone} and {Profiletypedb} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetaildb(String Fullnamedb,String Phone,String Profiletypedb,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullnamedb);
		//assertEquals(Fullnamedb, "Test Db user");
		userpage.setPhone(Phone);
		assertEquals(Phone, "+919676736246");
		String Email1 = "Demodb"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypedb);
		assertEquals(Profiletypedb, " Distributor user ");
		userpage.setpassword(Userpassword);
		assertEquals(Userpassword, "Abc@123456");
		userpage.setretypepassword(Retypepassword);
		assertEquals(Retypepassword, "Abc@123456");
		SyncUtil.waitFor(3000);
		userpage.Distributorinformation();
		userpage.Nextclick();
		usermpage.DistributorAssignment();
		userpage.Nextclick();
		usermpage.setpermission();
		userpage.Clicksaveandclose();
	}
	
	//Customer User
		@QAFTestStep(description = "User enter the required details cu user {Fullnamecu} and {Phone} and {Profiletypecu} and {Userpassword} and {Retypepassword}")
	    public void Enteruserdetailcu(String Fullnamecu,String Phone,String Profiletypecu,String Userpassword,String Retypepassword) throws InterruptedException {
			userpage.setfullname(Fullnamecu);
			//assertEquals(Fullnamecu, "Test Cu user");
			userpage.setPhone(Phone);
			assertEquals(Phone, "+919676736246");
			String Email1 = "Democu"+randomestring()+"@mailinator.com";
			userpage.setemail(Email1);
			userpage.setprofiletype(Profiletypecu);
			assertEquals(Profiletypecu, " Customer user ");
			userpage.setpassword(Userpassword);
			assertEquals(Userpassword, "Abc@123456");
			userpage.setretypepassword(Retypepassword);
			assertEquals(Retypepassword, "Abc@123456");
			SyncUtil.waitFor(3000);
			userpage.Customerinformation();
			userpage.Nextclick();
			usermpage.CustomerAssignment();
			userpage.Nextclick();
			usermpage.setpermission();
			userpage.Clicksaveandclose();
		}

	//Edit User
		@QAFTestStep(description = "Verify Edit user")
		public void Verifyedituser() {
			userpage.Edituser();
		}
		
	//Delete User	
		@QAFTestStep(description = "Verify Delete user {FullnameMaster}")
		public void Verifydeleteuser(String FullnameMaster) {
			userpage.Deleteuser();
			usermpage.verifyuser(FullnameMaster);
		}
		
}


