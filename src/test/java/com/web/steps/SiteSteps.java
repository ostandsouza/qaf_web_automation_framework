package com.web.steps;

import com.common.utils.APIBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.SitePage;

public class SiteSteps  {

    SitePage sitePage = new SitePage();

    @QAFTestStep(description="Delete Customer site with {CustSiteName}")
    public void deleteCustomerSite(String custSiteName){
        sitePage.deleteSite(custSiteName);
    }

    @QAFTestStep(description="Verify Deleted Customer site with {CustSiteName}")
    public void verifyDeleteCustomerSite(String custSiteName){
        sitePage.verifySiteDelete(custSiteName);
    }
}
