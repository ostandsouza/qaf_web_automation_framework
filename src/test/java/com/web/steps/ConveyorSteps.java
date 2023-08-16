package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CorporatePage;
import groovyjarjarantlr4.v4.codegen.model.Sync;

import java.util.Map;

public class ConveyorSteps {

    ConveyorPage conveyorPage = new ConveyorPage();
    CorporatePage corporatePage = new CorporatePage();

    @QAFTestStep(description="Create a conveyor with {ConveyorNameGer} and {DistShopGerName} and {CustShopGerName}")
    public void createAConveyor(String conveyorName, String distShopName, String custSiteName){
        String conveyorId = conveyorPage.apiBase.getConveyorsAPI(conveyorName);
        conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        conveyorPage.createConveyor(conveyorName, distShopName, custSiteName);
    }

    @QAFTestStep(description="Verify conveyor technical data with {ConveyorName1}")
    public void verifyTechnicalData(String conveyorName){
        conveyorPage.verifyTechnicalData(conveyorName);
    }

    @QAFTestStep(description="Delete Conveyor from Conveyor list screen {ConveyorName1}")
    public void deleteConveyorFromConveyorListScreen(String conveyorName){
        conveyorPage.deleteConveyor(conveyorName);
    }

    @QAFTestStep(description="Verify Deleted Conveyor {ConveyorName1} from Conveyor list screen")
    public void verifyDeleteConveyor(String conveyorName){
        conveyorPage.verifyDeleteConveyor(conveyorName);
    }

    @QAFTestStep(description="Verify red pin on conveyor list with {ConveyorName2} and {ConveyorName5}")
    public void verifyRedPin(String conveyor2, String conveyor5){
        conveyorPage.verifyDefaultPin(conveyor2);
        conveyorPage.verifyActivePin(conveyor5);
    }

    @QAFTestStep(description="Export PDF and CSV data for {ConveyorName2} and {ConveyorName3} and {ConveyorName5} and {ConveyorName6}")
    public void verifyExportConveyor(String conveyor2, String conveyor3, String conveyor5, String conveyor6){
        conveyorPage.exportPDFConveyor(conveyor5);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("conveyor.pdf"),"PDF report was not found","PDF report was downloaded successfully");
        conveyorPage.verifyPDFContents(conveyor5);
        corporatePage.clickCorporates();
        conveyorPage.exportCSVConveyor(conveyor2);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download.csv"),"CSV report was not found","CSV report was downloaded successfully");
        conveyorPage.verifyCSVContents(conveyor2);
    }


    @QAFTestStep(description="Download bulk upload template for distributor {DistCorpName} and with sites {CustSiteName} and {CustSite2Name}")
    public void verifyTemplateDownload(String distCorpName, String custSiteName, String custSite2Name){
        conveyorPage.checkDownloadTemplateForOneSite(distCorpName,custSiteName);
        SyncUtil.waitFor(15000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"),"Conveyor bulk upload template for single site was not found","Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
        conveyorPage.checkDownloadTemplateForMultipleSite(distCorpName,custSiteName, custSite2Name);
        SyncUtil.waitFor(15000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("ConveyorTemplate-Metric.xlsx"),"Conveyor bulk upload template for multiple sites was not found","Conveyor bulk upload template for single site was downloaded successfully");
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.xlsx");
    }

    @QAFTestStep(description="Add two conveyor via bulk upload in site {CustSiteName} with file {FileName}")
    public void conveyorBulkUpload(String custSiteName, String fileName){
//        Validator.assertTrue(conveyorPage.conveyorFileImport(fileName).contains("2"),"Not all conveyors were imported successfully","All conveyors imported successfully");
        Object[][] obj = MiscUtils.getExcelData(fileName,custSiteName);
        for( int i = obj.length;i>0;i--){
            String conveyorId = conveyorPage.apiBase.getConveyorsAPI(((Map<String,String>)obj[i-1][0]).get("Name"));
            conveyorPage.apiBase.deleteConveyorAPI(conveyorId);
        }
        conveyorPage.conveyorFileImport(fileName);
        conveyorPage.acknowledgeImport(obj.length-1);
    }

    @QAFTestStep(description="Validate conveyor {CustSiteName} should display in list with same data as filled in exel sheet {FileName}")
    public void verifyConveyorBulkUpload(String siteName, String fileName){
        conveyorPage.verifyUploadedConveyor(siteName,fileName);
    }

    @QAFTestStep(description="Edit Conveyor {0} from conveyor list screen to {1}")
    public void editConveyorFromConveyorListScreenTo(String ConveyorName,String ConveyorNameEdit){
        conveyorPage.goToConveyorListScreenAndWait();
        conveyorPage.editConveyor(ConveyorName, ConveyorNameEdit);
        SyncUtil.waitFor(5000);
    }

    @QAFTestStep(description="Verify Edited conveyor details with {EditCustCorpName} for Corporate {EditCustCorpName}")
    public void checkAConveyorC1GermanyAtMiningCorpGermany(String ConveyorNameGer2, String CustCorpName){
        conveyorPage.checkConveyorGermany(ConveyorNameGer2, CustCorpName);
    }

    @QAFTestStep(description="Navigate to Add Conveyor screen")
    public void verifyNavigationToAddConveyor(){
        conveyorPage.goToAddConveyor();
    }

    @QAFTestStep(description="Navigate to Add Conveyor screen")
    public void verifyNavigationToListConveyor(){
        conveyorPage.goToConveyorListScreen();
    }

    @QAFTestStep(description="Navigate to conveyor details screen for conveyor {conveyorName}")
    public void verifyConveyorDetailsNavigation(String conveyorName){
        conveyorPage.goToConveyorDetailScreen(conveyorName);
    }

    @QAFTestStep(description="Create a conveyor with {ConveyorName1} and {DistShopAusName} and {CustSiteNZName} with {ImageName}")
    public void createConveyorWithImage(String conveyorName, String distShop, String siteName, String imgName){
        conveyorPage.createConveyorWithImg(conveyorName, distShop, siteName, imgName);
    }

    @QAFTestStep(description="Verify all the tiles in conveyor detail screen")
    public void verifyConveyorTile(){
        conveyorPage.verifyTile();
    }

    @QAFTestStep(description="Export CSV data for {ConveyorName2}")
    public void verifyCSVExport(String conveyor){
        conveyorPage.exportCSVConveyor(conveyor);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("download.csv"),"CSV report was not found","CSV report was downloaded successfully");
        conveyorPage.verifyCSVContents(conveyor);
    }

    @QAFTestStep(description="Export PDF for {ConveyorName2}")
    public void verifyPDFExport(String conveyor){
        conveyorPage.exportPDFConveyor(conveyor);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles("conveyor.pdf"),"PDF report was not found","PDF report was downloaded successfully");
        conveyorPage.verifyPDFContents(conveyor);
    }

    @QAFTestStep(description="Navigate to Add Conveyor screen from list screen")
    public void verifyAddIconFunctionality(){
        conveyorPage.goToAddConveyorFromList();
    }

    @QAFTestStep(description="verify all fields in conveyor tab")
    public void verifyConveyorTabFieldInAdd(){
        conveyorPage.verifyConveyor();
    }

    @QAFTestStep(description="Verify the actions dropdown for conveyor with {ConveyorName2}")
    public void verifyActionDropdown(String conveyorName){
        Validator.assertTrue(conveyorPage.verifyDropDown(conveyorName),"All Items are not present in conveyor dropdown","Conveyor Dropdown was successfully verified");
    }

    @QAFTestStep(description="Navigate to conveyor list screen")
    public void verifyConveyorListNav(){
        conveyorPage.goToConveyorListScreen();
    }

    @QAFTestStep(description="verify user {Email} is able to add new layout for {Corporates} {BeltWidth} {Rating} {Length} with {Layout_Name}")
    public void verifyAddLayout(String email, String corporates, String beltWidth, String rating, String length, String layoutName){
        String userId= conveyorPage.apiBase.getUserProfileAPI(email);
        String prefId= conveyorPage.apiBase.getPreferenceAPI(userId, layoutName);
        conveyorPage.apiBase.deletePreferencesAPI(userId,prefId);
        conveyorPage.goToConveyorListScreen();
        conveyorPage.addLayout(corporates, beltWidth, rating, length, layoutName);
        Validator.assertTrue(conveyorPage.verifyFilters(),"All filters are applied in table layout","All filters were successfully verified");
    }

    @QAFTestStep(description="verify user is able to delete layout for {Layout_Name}")
    public void verifyDeleteLayout(String layoutName){
        conveyorPage.goToConveyorListScreen();
        conveyorPage.deleteLayout(layoutName);
        Validator.assertFalse(conveyorPage.verifyFilters(),"All filters are applied in table layout","All filters were successfully verified");
    }

    @QAFTestStep(description="verify user {Email} is able to add new layout for {Corporates} {BeltWidth} {Rating} {Length} with {Layout_Name}")
    public void verifyUserPreference(String email, String corporates, String beltWidth, String rating, String length, String layoutName){
        String userId= conveyorPage.apiBase.getUserProfileAPI(email);
        String prefId= conveyorPage.apiBase.getPreferenceAPI(userId, layoutName);
        conveyorPage.apiBase.deletePreferencesAPI(userId,prefId);
        conveyorPage.goToConveyorListScreen();
        conveyorPage.addLayout(corporates, beltWidth, rating, length, layoutName);
        Validator.assertTrue(conveyorPage.verifyFilters(),"All filters are not applied in table layout","All filters were successfully verified");
    }

    @QAFTestStep(description="Verify user is able see saved preference")
    public void verifySavedPreference(){
        Validator.assertTrue(conveyorPage.verifyFilters(),"All saved filters are not available in layout","All filters were successfully verified");
    }


}
