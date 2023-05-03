package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.ConveyorInspectPage;
import com.web.pages.ConveyorPage;

public class ConveyorInspectSteps {

    ConveyorInspectPage conveyorInspectPage = new ConveyorInspectPage();
    ConveyorPage conveyorPage = new ConveyorPage();

    @QAFTestStep(description="Assign Object detection model {DetectionModel} for Corporate {CustCorpName} with site {CustSiteName} and conveyor {ConveyorName}")
    public void assigningModel(String model, String custCorp, String custSite, String conveyorName){
        String companyId = conveyorInspectPage.apiBase.getCompanyAPI(custCorp);
        conveyorInspectPage.apiBase.deleteCompanyAPI(companyId);
        companyId = conveyorInspectPage.apiBase.getCompanyAPI(custSite);
        conveyorInspectPage.apiBase.deleteCompanyAPI(companyId);
        String conveyorId = conveyorInspectPage.apiBase.getConveyorsAPI(conveyorName);
        conveyorInspectPage.apiBase.deleteConveyorAPI(conveyorId);
        companyId= conveyorInspectPage.apiBase.createCustomerCorpAPI();
        String siteCompanyId= conveyorInspectPage.apiBase.createCustomerSiteAPI(companyId);
        conveyorInspectPage.apiBase.createConveyorAPI(companyId, siteCompanyId);
        conveyorInspectPage.browserRefresh();
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        conveyorInspectPage.goToConveyorInspect();
        conveyorInspectPage.assignModel(model);
    }

    @QAFTestStep(description="Upload drone files with {Side} {colorMap} {irName} {rgbName}")
    public void uploadImages(String side, String colorMap, String ir_Name, String rgb_Name){
        conveyorInspectPage.uploadDroneImgFiles(side, colorMap, ir_Name, rgb_Name);
    }
}
