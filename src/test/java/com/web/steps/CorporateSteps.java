package com.web.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.CorporatePage;

public class CorporateSteps {

    CorporatePage corpPage = new CorporatePage();

    @QAFTestStep(description="Create a Distributor Corporate with {DistCorpName} and {DistCorpAddress}")
    public void createADistributorCorporateBeltAssociatesCorp(String DistCorpName, String DistCorpAddress){
        String companyId = corpPage.apiBase.getCompanyAPI(DistCorpName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.createDistributorCorporate(DistCorpName, DistCorpAddress);

    }
    @QAFTestStep(description="Create a Distributor shop with {DistShopIndName} and {DistShopIndAddress} and {DistCorpName} and {FullName} and {TerritoryInd}")
    public void createADistributorShopInIndiaBeltAssociatesIndiaWithTMJohnDoe(String DistShopIndName,String DistShopIndAddress, String DistCorpName,String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyAPI(DistShopIndName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.createDistributorShop(DistShopIndName, DistShopIndAddress, DistCorpName, territory, FullNameInd);
    }

    @QAFTestStep(description="Create a Distributor shop in Germany with {DistShopGerName} and {DistShopGerAddress} and {DistCorpName} and {FullNameGer}")
    public void CreateaDistributorshopinGermanyBeltAssociatesGermanywithTMMaxMustermann(String DistShopGerName,String DistShopGerAddress,String DistCorpName, String FullNameGer) {
        String companyId = corpPage.apiBase.getCompanyAPI(DistShopGerName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.createDistributorShop(DistShopGerName, DistShopGerAddress,DistCorpName,"Germany",FullNameGer);
    }

    @QAFTestStep(description="Create a Customer Corporate with {CustCorpName} and {CustCorpAddress}")
    public void createACustomerCorporateMiningCorp(String CustCorpName, String CustCorpAddress){
        String companyId = corpPage.apiBase.getCompanyAPI(CustCorpName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.createCustomerCorporate(CustCorpName, CustCorpAddress);

    }

    @QAFTestStep(description="Create a Customer site in India {CustShopIndName} and {CustShopIndAddress} and {CustCorpName} and {DistShopIndName} and {FullNameInd} and '${territory}")
    public void createACustomerSiteInIndiaMiningCorpIndiaWithDistribBeltAssociatesIndia(String CustShopIndName, String CustShopIndAddress,String CustCorpName, String DistShopIndName, String FullNameInd, String territory){
        String companyId = corpPage.apiBase.getCompanyAPI(CustShopIndName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
        corpPage.createCustomerSite(CustShopIndName, CustShopIndAddress,CustCorpName,DistShopIndName,territory,FullNameInd);
    }

    @QAFTestStep(description="Create a Customer site {0} and {1} and {2} and {3} and {4} and {5}")
    public void createACustomerSiteAndAndAndAndAnd(String CustShopGerName,String CustShopGerAddress,String CustCorpName,String DistShopGerName,String FullNameGer, String territory){
        String companyId = corpPage.apiBase.getCompanyAPI(CustShopGerName);
        corpPage.apiBase.deleteCompanyAPI(companyId);
        corpPage.clickCorporates();
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
}
