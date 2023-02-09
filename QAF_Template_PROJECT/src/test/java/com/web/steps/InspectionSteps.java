package com.web.steps;

import java.awt.AWTException;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.InspectionPage;
import com.web.pages.LoginPage;

public class InspectionSteps {

	LoginPage loginPage = new LoginPage();
	InspectionPage inspectionpage = new InspectionPage();
	
	@QAFTestStep(description = "Login with {UserName} and {Password}")   
    public void loginWithAnd(String UserName, String Password) {
       loginPage.loginToApp(UserName, Password);
   }
	
	@QAFTestStep(description="Select Inspection on the Navigation Pane")
	public void selectInspectionOnTheNavigationPane(){
		inspectionpage.clickinspection();	
	}
	
	@QAFTestStep(description="Verify list page")
	public void verifyListPage(){
	   inspectionpage.verifylistpage();
	}
	
	@QAFTestStep(description="Create add inspection {Inspectionname}")
	public void createAddInspection(String Inspectionname){
		inspectionpage.addinspection(Inspectionname);
	
	}
	
	
	@QAFTestStep(description="Create add inspection item  {Inspectionname}")
	public void createAddInspectionItem(String Inspectionname) throws AWTException{
		inspectionpage.addinspectionitem();
	  
	    inspectionpage.verifyinspection(Inspectionname);
		//inspectionpage.Delete();
		
			}

	
	@QAFTestStep(description="Download PDF")
	public void DownloadPDF() {
		inspectionpage.DownloadPDF();
	}
	
	@QAFTestStep(description="Inspection Delete")
	public void InspectionDelete() throws Throwable {
	    inspectionpage.Location();
	    inspectionpage.Edit();
	    inspectionpage.BreadCrumb();
	    inspectionpage.Inspectiondelete();
	}
	
}
