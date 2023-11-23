package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CorporatePage;

public class CorporateSteps {

    CorporatePage corpPage = new CorporatePage();
    ConveyorPage conveyorPage = new ConveyorPage();

    @QAFTestStep(description="Create a Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void createADistributorCorporateBeltAssociatesCorp(String DistCorpName, String DistCorpAddress){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(DistCorpName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        SyncUtil.waitFor(5000);
        corpPage.clickCorporates();
        corpPage.goToAddCorp();
        corpPage.createDistributorCorporate(DistCorpName, DistCorpAddress);

    }
    @QAFTestStep(description="Create a Distributor shop with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullName} and {TerritoryInd}")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(String DistShopIndName,String DistShopIndAddress, String DistCorpName,String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(DistShopIndName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.goToAddCorp();
        corpPage.createDistributorShop(DistShopIndName, DistShopIndAddress, DistCorpName, territory, FullNameInd);
    }

    @QAFTestStep(description="Create a Distributor shop in Germany with {DistShopGerName} and {DistShopGerAddress} and {DistCorpName} and {FullNameGer}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String DistShopGerName,String DistShopGerAddress,String DistCorpName, String FullNameGer) {
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(DistShopGerName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.createDistributorShop(DistShopGerName, DistShopGerAddress,DistCorpName,"Germany",FullNameGer);
    }

    @QAFTestStep(description="Create a Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporateMiningCorp(String CustCorpName, String CustCorpAddress){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(CustCorpName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.goToAddCorp();
        corpPage.createCustomerCorporate(CustCorpName, CustCorpAddress);

    }

    @QAFTestStep(description="Create a Customer site in India {CustShopIndName} and {CustShopIndAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd} and '${territory}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(CustShopIndName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.goToAddCorp();
        corpPage.createCustomerSite(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,territory,FullNameInd);
    }

    @QAFTestStep(description="Create a Customer site {0} and {1} and {2} and {3} and {4} and {5}")
    public void createACustomerSiteAndAndAndAndAnd(String CustShopGerName,String CustShopGerAddress,String CustCorpName,String DistShopGerName,String FullNameGer, String territory){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(CustShopGerName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.goToAddCorp();
        corpPage.createCustomerSite(CustShopGerName, CustShopGerAddress,CustCorpName,DistShopGerName,territory,FullNameGer);
    }

    @QAFTestStep(description="Edit Customer Corporate with {CustCorpName} and {EditCustCorpName}")
    public void editCustomerCorporateName(String custCorpName,String editCustCorpName){
        corpPage.editCorporateName(custCorpName, editCustCorpName);
    }

    @QAFTestStep(description="Add {CorpImageName} image to Corporate and save changes")
    public void addImageToCustomerCorp(String corpImageName){
        corpPage.corporateImgUpload(corpImageName);
        corpPage.updateCorp();
    }

    @QAFTestStep(description="Verify the Distributor Corp details with {EditCustCorpName} and {CorpImageName}")
    public void verifyCustomerCorp(String editCustCorpName, String corpImageName){
        corpPage.verifyCorporateEdit(editCustCorpName);
    }

    @QAFTestStep(description="Edit Customer site with {CustSiteName} and {EditCustSiteName} using corporate {EditCustCorpName}")
    public void editCustomerSiteName(String custSiteName,String editCustSiteName, String corp){
        corpPage.editCustomerSite(custSiteName, editCustSiteName, corp);
    }

    @QAFTestStep(description="Verify the Customer site details with {EditCustSiteName} and {CorpImageName} using corporate {EditCustCorpName}")
    public void verifyCustomerSite(String editCustSiteName, String corpImageName, String editCorpName){
        corpPage.verifySiteOrShopEdit(editCorpName, editCustSiteName);
    }

    @QAFTestStep(description="Delete Distributor Shop for Corporate {DistCorpName} with {DistShopIndName}")
    public void deleteDistributorShop(String distCorpName, String distShopIndName){
        corpPage.deleteSiteOrShop(distCorpName, distShopIndName);
    }

    @QAFTestStep(description="Verify Deleted Distributor shop with {distCorpName} with {DistShopIndName}")
    public void verifyDeleteDistributorShop(String distCorpName, String distShopIndName){
        corpPage.verifySiteOrShopDelete(distCorpName, distShopIndName);
    }

    @QAFTestStep(description="Navigate to Corporate details screen for corporate {CustCorpName}")
    public void navigateToCorporateDetails(String custCorpName){
        corpPage.goToCorporateDetails(custCorpName);
    }

    @QAFTestStep(description="Verify card count in details screen for {CustCorpName}")
    public void verifyTheCardDetails(String custCorpName){
        corpPage.verifyCardDetails(custCorpName);
    }

//    @QAFTestStep(description="Delete Corporate with name {CustCorpName}")
//    public void deleteCorporate(String custCorpName){
//        corpPage.deleteCorporate(custCorpName);
//    }

    @QAFTestStep(description="Delete Corporate with name {0}")
    public void deleteCorporateWithName(String str0){
        corpPage.deleteCorporate(str0);
    }

    @QAFTestStep(description="Verify Deleted corporate {CustCorpName}")
    public void verifyDeleteCorporate(String distCorpName) {
        Validator.assertTrue(corpPage.verifyCorporate(distCorpName),"Corporate did not delete properly","Corporate deleted successfully");
    }

    @QAFTestStep(description="Navigate to Add Company screen")
    public void verifyAddCompanyNavigation(){
        corpPage.goToAddCompany();
    }

    @QAFTestStep(description="Verify image upload functionality with {imageName}")
    public void verifyImageUpload(String fileName){
        corpPage.corporateImgUpload(fileName);
        corpPage.verifyImageUpload();
    }

    @QAFTestStep(description="Add Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void createDistributorCorporate(String DistCorpName, String DistCorpAddress){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(DistCorpName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.goToAddCompany();
        corpPage.createDistributorCorporate(DistCorpName, DistCorpAddress);

    }
    @QAFTestStep(description="Add Distributor shop with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullName} and {TerritoryInd}")
    public void createDistributorShop(String DistShopIndName,String DistShopIndAddress, String DistCorpName,String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(DistShopIndName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.goToAddCompany();
        corpPage.createDistributorShop(DistShopIndName, DistShopIndAddress, DistCorpName, territory, FullNameInd);
    }

    @QAFTestStep(description="Add Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporate(String CustCorpName, String CustCorpAddress){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(CustCorpName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.goToAddCompany();
        corpPage.createCustomerCorporate(CustCorpName, CustCorpAddress);
        SyncUtil.waitFor(10000);
    }

    @QAFTestStep(description="Add Customer site {CustShopName} and {CustShopAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd} and {territory}")
    public void addCustomerSite(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(CustShopIndName));
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.goToAddCompany();
        corpPage.createCustomerSite(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,territory,FullNameInd);
        SyncUtil.waitFor(10000);
    }

    @QAFTestStep(description="Navigation of corporate list screen")
    public void verifyCorporateListNavigation(){
        corpPage.verifyCorporateNav();
    }

    @QAFTestStep(description="Verify market type {Type} for Corporate with name {DistCorpName}")
    public void verifyMarketTypeForCorp(String type, String corp){
        corpPage.searchCorporate(corp);
        corpPage.verifyMarketType(type);
    }

    @QAFTestStep(description="Verify navigation to {DistShopName} detail screen")
    public void verifyShopDetailsNavigation(String site){
        SyncUtil.waitFor(20000);
        corpPage.goToShopSiteDetails(site);
    }

    @QAFTestStep(description="Edit Customer shop with {DistShopName} and {EditDistShopName} using corporate {DistCorpName}")
    public void editDistributorShopName(String custSiteName,String editCustSiteName, String corp){
        corpPage.editDistributorShop(custSiteName, editCustSiteName, corp);
        corpPage.updateCorp();
    }

    @QAFTestStep(description="Verify expected card count in details screen is {Count}")
    public void verifySiteShopCardDetails(String count){
        corpPage.verifyShopSiteCardCount(count);
    }

    @QAFTestStep(description="Go to add Corporates from details screen")
    public void goToAddCorp(){
        corpPage.goToAddCorp();
    }

    @QAFTestStep(description="Verify distributor corporate dropdown contains {CustCorpName}")
    public void verifyAddDistCorporateDropdown(String corp){
        corpPage.verifyAddDistCorporateDropdown(corp);
    }

    @QAFTestStep(description="Verify customer corporate dropdown contains {CustCorpName}")
    public void verifyAddCustCorporateDropdown(String corp){
        corpPage.verifyAddCustCorporateDropdown(corp);
    }

    @QAFTestStep(description="Create a conveyor with {ConveyorName} and {CustSiteName}")
    public void verifyNavigationFromSiteToConveyor(String conveyorName, String custSiteName){
        corpPage.goToAddConveyor();
        corpPage.createConveyor(conveyorName,custSiteName);
    }

    @QAFTestStep(description="Delete conveyor {conveyor} customer site {custSite} with Corporate name {CorpName}")
    public void deleteConveyor(String conveyor, String custSite, String corpName){
        corpPage.goToCorporateDetails(corpName);
        corpPage.goToShopSiteDetails(custSite);
        corpPage.deleteConveyor(conveyor);
    }

    @QAFTestStep(description="Verify Deleted conveyor {conveyor} customer site {custSite} with Corporate name {CorpName}")
    public void verifyConveyorDelete(String conveyor, String custSite, String corpName){
        corpPage.goToCorporateDetails(corpName);
        corpPage.goToShopSiteDetails(custSite);
        corpPage.verifyDeleteConveyor(conveyor);
    }

    @QAFTestStep(description="Edit Conveyor {ConveyorName} to {EditCustCorpName}")
    public void editAConveyorC2Germany(String conveyorName, String conveyorNameEdit){
        conveyorPage.editConveyorDetails(conveyorNameEdit);
    }

    @QAFTestStep(description="Edit Conveyor {ConveyorName} from site list screen to {EditCustCorpName}")
    public void editAConveyorC2GermanyAtMiningCorpGermany(String conveyorName, String conveyorNameEdit){
        conveyorPage.editConveyor(conveyorName, conveyorNameEdit);
    }

    @QAFTestStep(description="Verify navigation from site detail to conveyor details screen of {0}")
    public void verifyNavigationFromSiteDetailToConveyorDetailsScreenOf(String conveyorName){
        SyncUtil.waitFor(20000);
        corpPage.goToConveyorDetails(conveyorName);
    }

    @QAFTestStep(description="Save edited Corporate changes")
    public void editCorporateChanges(){
        corpPage.updateCorp();
    }

}
