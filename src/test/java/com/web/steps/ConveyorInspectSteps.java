package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorInspectPage;
import com.web.pages.ConveyorPage;
import com.web.pages.SitePage;

public class ConveyorInspectSteps {

    ConveyorInspectPage conveyorInspectPage = new ConveyorInspectPage();
    ConveyorPage conveyorPage = new ConveyorPage();

    SitePage sitePage = new SitePage();


    @QAFTestStep(description="Go to conveyor inspect for conveyor {ConveyorName}")
    public void goToConveyorInspectViaConveyor(String conveyorName){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        conveyorInspectPage.goToConveyorInspect();
    }

    @QAFTestStep(description="Go to conveyor inspect for conveyor {0} for Corporate {1} with site {2}")
    public void goToConveyorInspectForConveyorForCorporateWithSite(String conveyorName, String custCorp, String custSite) {
        String companyId = conveyorInspectPage.apiBase.getCompanyID(conveyorInspectPage.apiBase.getCompanyAPI(custCorp));
        conveyorInspectPage.apiBase.deleteCompanyAPI(companyId);
        companyId = conveyorInspectPage.apiBase.getCompanyID(conveyorInspectPage.apiBase.getCompanyAPI(custSite));
        conveyorInspectPage.apiBase.deleteCompanyAPI(companyId);
        String conveyorId = conveyorInspectPage.apiBase.getConveyorsAPI(conveyorName);
        conveyorInspectPage.apiBase.deleteConveyorAPI(conveyorId);
        companyId = conveyorInspectPage.apiBase.createCustomerCorpAPI();
        String siteCompanyId = conveyorInspectPage.apiBase.createCustomerSiteAPI(companyId);
        conveyorInspectPage.apiBase.createConveyorAPI(companyId, siteCompanyId);
        conveyorInspectPage.browserRefresh();
        conveyorPage.goToConveyorDetailScreen(conveyorName);
        conveyorInspectPage.goToConveyorInspect();
    }

    @QAFTestStep(description="Navigate to Conveyor inspect screen")
    public void goToConveyorInspectList(){
        conveyorInspectPage.goToConveyorInspectList();
    }

    @QAFTestStep(description="Verify the conveyor inspect list headers")
    public void verifyConveyorInspectHeaders(){
        conveyorInspectPage.verifyConveyorListHeaders();
    }

    @QAFTestStep(description="Go to conveyor inspect for site {CustSiteName}")
    public void goToConveyorInspectViasite(String CustSiteName){
        sitePage.goToSiteDetails(CustSiteName);
        conveyorInspectPage.goToConveyorInspect();
    }

    @QAFTestStep(description="Open upload files dialog window")
    public void goToUploadFile(){
        conveyorInspectPage.goToUploadFiles();
    }

    @QAFTestStep(description="Verify upload button is disabled by default")
    public void verifyUploadBtnStatus(){
        Validator.assertFalse(conveyorInspectPage.uploadBtnStatus(),"File uploaded is disabled by default","File uploaded is enabled by default");
    }

    @QAFTestStep(description="Select image upload radio button")
    public void selectImageBtn(){
        conveyorInspectPage.imgSelection();
    }

    @QAFTestStep(description="Select video upload radio button")
    public void selectVideoBtn(){
        conveyorInspectPage.videoSelection();
    }

    @QAFTestStep(description="Verify company site dropdown is disabled with {CustSiteName}")
    public void verifyCompanySiteDropdown(String siteName){
        conveyorInspectPage.companySiteContents(siteName);
    }

    @QAFTestStep(description="Verify conveyor dropdown is disabled with {conveyor}")
    public void verifyConveyorDropdownIsDisabledWith(String conveyor){
        conveyorInspectPage.conveyorContents(conveyor);
    }

    @QAFTestStep(description="Select date of flight as current date")
    public void flightDateSelection(){
        conveyorInspectPage.flightDate();
    }

    @QAFTestStep(description="Select time of flight as current time")
    public void flightTimeSelection(){
        conveyorInspectPage.flightTime();
    }

    @QAFTestStep(description="Select side dropdown as {Side}")
    public void sideDropdownSelection(String side){
        conveyorInspectPage.sideDropdown(side);
    }

    @QAFTestStep(description="Select colormap dropdown as {colormap}")
    public void colorMapDropdownSelection(String colormap){
        conveyorInspectPage.colorMapDropdown(colormap);
    }

    @QAFTestStep(description="Upload file with {imgName}")
    public void uploadImageFiles(String imgName){
        conveyorInspectPage.imageUpload(imgName);
    }

    @QAFTestStep(description="delete uploaded file {imgName}")
    public void deleteUploadedFiles(String imgName){
        conveyorInspectPage.deleteImg(imgName);
    }

    @QAFTestStep(description="Verify edit functionality at conveyor level")
    public void editFunctionalityAtConveyor(){
        conveyorInspectPage.editFunctionalityConveyorLevel();
    }

    @QAFTestStep(description="Verify edit functionality at site level")
    public void editFunctionalityAtSite(){
        conveyorInspectPage.editFunctionalitySiteLevel();
    }

    @QAFTestStep(description="Open temperature range dialog window")
    public void openTemperatureRange(){
        conveyorInspectPage.invokeTemperatureRange();
    }

    @QAFTestStep(description="Change critical temperature range {Min} to {Max}")
    public void setCriticalTemperature(String min, String max){
        conveyorInspectPage.changeCriticalTemp(Integer.parseInt(min),Integer.parseInt(max));
    }

    @QAFTestStep(description="Change poor temperature range {Min1} to {Max1}")
    public void setPoorTemperature(String min, String max){
        conveyorInspectPage.changePoorTemp(Integer.parseInt(min),Integer.parseInt(max));
    }

    @QAFTestStep(description="Set temperature range to default")
    public void setDefaultTempRange(){
//        conveyorInspectPage.setDefaultTemp();
    }

    @QAFTestStep(description="Save change to temp range setting")
    public void saveTempRange(){
        conveyorInspectPage.saveTempRange();
    }

    @QAFTestStep(description="Verify upload button is enabled after image upload")
    public void verifyUploadBtnStatusAfterUpload(){
        Validator.assertTrue(conveyorInspectPage.uploadBtnStatus(),"File uploaded is enabled after img upload","File uploaded is disabled after img upload");
        conveyorInspectPage.closeDialog();
    }

    @QAFTestStep(description="Open assign object detection model window")
    public void invokeObjectModelWindow(){
        conveyorInspectPage.invokeObjectDetectionModel();
    }

    @QAFTestStep(description="Verify the company dropdown status")
    public void verifyCompanyDropdown(){
        Validator.assertFalse(conveyorInspectPage.companyDropdownStatus(),"Company dropdown is disabled","company dropdown is enabled");
    }

    @QAFTestStep(description="Verify the site dropdown status")
    public void verifySiteDropdown(){
        Validator.assertFalse(conveyorInspectPage.siteDropdownStatus(),"Site dropdown is disabled","Site dropdown is enabled");
    }

    @QAFTestStep(description="Verify the conveyor dropdown status")
    public void verifyConveyorDropdown(){
        Validator.assertFalse(conveyorInspectPage.conveyorDropdownStatus(),"Conveyor dropdown is disabled","Conveyor dropdown is enabled");
    }

    @QAFTestStep(description="Verify the model dropdown status")
    public void verifyModelDropdown(){
        Validator.assertTrue(conveyorInspectPage.modelDropdownStatus(),"Model dropdown is enabled","Model dropdown is disabled");
    }

    @QAFTestStep(description="Assign Object detection model {model}")
    public void assignObjectDetectionModel(String model){
        conveyorInspectPage.modelSelection(model);
    }

    @QAFTestStep(description="Verify conveyor status is selected by default")
    public void verifyConveyorStatusIsSelectedByDefault(){
        conveyorInspectPage.defaultTabSelection();
    }

    @QAFTestStep(description="Verify Last inspection date {InspectionDate}")
    public void verifyDefaultTabSelection(String inspectionDate){
        conveyorInspectPage.lastInspectionDate(inspectionDate);
    }

    @QAFTestStep(description="Verify Gauge metrics for conveyor status")
    public void verifyGaugeMetrics(){
        conveyorInspectPage.gaugeMetrics();
    }

    @QAFTestStep(description="Go to trend analysis tab")
    public void goToTrendAnalysis(){
        conveyorInspectPage.goToTrendAnalysis();
    }

    @QAFTestStep(description="Verify mouse over data on the graph")
    public void verifyMouseOverData(){
        conveyorInspectPage.mouseOverGraphAnalysis();
    }

    @QAFTestStep(description="Go to maintenance action tab")
    public void goToMaintenanceTab(){
        conveyorInspectPage.goToMaintenanceAction();
    }

    @QAFTestStep(description="Verify maintenance action table")
    public void verifyMaintenanceTab(){
        conveyorInspectPage.maintenanceTable();
    }

    @QAFTestStep(description="verify default upload option in upload files")
    public void verifyDefaultUploadOptionInUploadFiles(){
        conveyorInspectPage.goToUploadFiles();
        conveyorInspectPage.imgDefaultSelection();
        conveyorInspectPage.closeDialog();
    }
    @QAFTestStep(description="Assign Object detection model {DetectionModel} for Corporate {CustCorpName} with site {CustSiteName} and conveyor {ConveyorName}")
    public void assigningModel(String model, String custCorp, String custSite, String conveyorName){
        String companyId = conveyorInspectPage.apiBase.getCompanyID(conveyorInspectPage.apiBase.getCompanyAPI(custCorp));
        conveyorInspectPage.apiBase.deleteCompanyAPI(companyId);
        companyId = conveyorInspectPage.apiBase.getCompanyID(conveyorInspectPage.apiBase.getCompanyAPI(custSite));
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
