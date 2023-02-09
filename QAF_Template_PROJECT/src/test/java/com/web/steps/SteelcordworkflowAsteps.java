package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import com.web.pages.UsersPage;

public class SteelcordworkflowAsteps extends BasePage{

	LoginPage loginpage = new LoginPage(); 
    UserSteps us = new UserSteps();
    UsersPage userpage = new UsersPage();
	
	@QAFTestStep(description = "User is at Login page")
	public void verifyUserIsAtLoginPage() {
		loginpage.verifyTitle("Conti+"); 
	}

	@QAFTestStep(description = "Login with {UserName} and {Password}")
	public void loginWithAnd(String UserName, String Password) {
		loginpage.loginToApp(UserName, Password);
		
	}
	
	
	  @QAFTestStep( description="Create territorymanager TestDesigner.SC {Fullname} and {Phone} and {Profiletype} and {Userpassword} and {Retypepassword}") 
	  public void createTerritorymanagerTestDesignerSC(String Fullname,String Phone,String Profiletype,String Userpassword,String Retypepassword) throws InterruptedException{ 
	  userpage.usersclick();
	  userpage.Addclick();
	  userpage.setfullname(Fullname);
	  userpage.setPhone(Phone); 
	  String Email ="Demotm"+randomestring()+"@mailinator.com"; 
	  userpage.setemail(Email);
	  userpage.setprofiletype(Profiletype); 
	  userpage.setpassword(Userpassword);
	  userpage.setretypepassword(Retypepassword); 
	  userpage.Nextclick();
	  userpage.setpermission(); 
	  userpage.Clicksaveandclose();
	  }
	 
	
	@QAFTestStep(description="Create Standard Continental User TestUser.SC {Fullnametu} and {Phone} and {Profiletypetu} and {Userpassword} and {Retypepassword}")
	public void createStandardContinentalUserTestUserSC(String Fullnametu,String Phone,String Profiletypetu,String Userpassword,String Retypepassword) throws InterruptedException{
		//userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(Fullnametu);
		userpage.setPhone(Phone);
		String Email1 = "Demosc"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypetu);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionsc();
		userpage.Clicksaveandclose();
		
	}
	
	@QAFTestStep(description="Create MarketManager Test Approver {Fullnameta1} and {Phone} and {Profiletypeta1} and {Userpassword} and {Retypepassword}")
	public void createMarketManagerTestApprover(String Fullnameta1,String Phone,String Profiletypeta1,String Userpassword,String Retypepassword) throws InterruptedException{
		userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(Fullnameta1);
		userpage.setPhone(Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta1);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		userpage.Clicksaveandclose();
	}
	
	@QAFTestStep(description="Create MarketManager Test Approver {Fullnameta2} and {Phone} and {Profiletypeta1} and {Userpassword} and {Retypepassword}")
	public void createMarketManagerTestApproversc2(String Fullnameta2,String Phone,String Profiletypeta1,String Userpassword,String Retypepassword) throws InterruptedException{
		userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(Fullnameta2);
		userpage.setPhone(Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta1);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		userpage.Clicksaveandclose();
	}
	
	
	
	@QAFTestStep(description="Create MarketUser Test admin.SC  {Fullnameta} and {Phone} and {Profiletypeta} and {Userpassword} and {Retypepassword}")
	public void createMarketUserTestAdminSCAndAndAndAnd(String Fullnameta,String Phone,String Profiletypeta,String Userpassword,String Retypepassword) throws InterruptedException{
		userpage.usersclick();
		userpage.Addclick();
		userpage.setfullname(Fullnameta);
		userpage.setPhone(Phone);
		String Email1 = "Demomm"+randomestring()+"@mailinator.com";
		userpage.setemail(Email1);
		userpage.setprofiletype(Profiletypeta);
		userpage.setpassword(Userpassword);
		userpage.setretypepassword(Retypepassword);
		userpage.Nextclick();
		userpage.setpermissionmm1();
		userpage.Clicksaveandclose();
	}
	
	
}
