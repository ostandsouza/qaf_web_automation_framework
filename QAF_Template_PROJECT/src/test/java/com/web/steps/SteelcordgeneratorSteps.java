package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.BasePage;
import com.web.pages.SteelcordgeneratorPage;

public class SteelcordgeneratorSteps extends BasePage {
	
	SteelcordgeneratorPage steelpage = new SteelcordgeneratorPage();
	
	
	

	@QAFTestStep(description="Create a new steel cord generator")
	public void createANewSteelCordGenerator(){
		steelpage.clicksteelcord();
	    steelpage.createsteelcord();
	    
	}
}
