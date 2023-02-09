package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.web.pages.BasePage;
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
		userpage.setPhone(Phone);
		String Email = "Demotm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email);
		userpage.setprofiletype(Profiletype);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermission();
		
            }                 
	@QAFTestStep(description = "User enter the required details {Fullname1} and {Phone} and {Profiletypetu} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetails1(String Fullname1,String Phone,String Profiletypetu,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname1);
		userpage.setPhone(Phone);
		String Email1 = "Demosc"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypetu);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionsc();
		
            } 
	
	@QAFTestStep(description = "User enter required details {Fullname2} and {Phone} and {Profiletypeta1} and {Userpassword} and {Retypepassword}")
    public void Enteruserdetail(String Fullname2,String Phone,String Profiletypeta1,String Userpassword,String Retypepassword) throws InterruptedException {
		userpage.setfullname(Fullname2);
		userpage.setPhone(Phone);
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
		userpage.setPhone(Phone);
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
		userpage.setPhone(Phone);
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
	
}
