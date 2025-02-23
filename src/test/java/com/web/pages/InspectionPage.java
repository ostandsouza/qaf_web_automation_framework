package com.web.pages;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


public class InspectionPage extends BasePage {

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement lnkHome;

    @FindBy(locator = "xpath=//span[text()='Inspections']")
    public CustomElement lnkInspection;

    @FindBy(locator = "xpath=//h4[text()='Inspection Event']/parent::div//i[contains(@class,'ctp-icon-Inspection-Items-List p-fs-2 items-list')]")
    public CustomElement btnItemlist;

    @FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-edit-conveyors/div[1]/div/app-card-sllider/div/div/div[3]/app-card/div/div/div[3]")
    public CustomElement eleInspectiontile;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btnAddInspection;

    @FindBy(locator = "xpath=//input[@formcontrolname='inspectionName']")
    public CustomElement tbInspectionName;

    @FindBy(locator = "xpath=//label[text()='Site']/parent::div//div[@role='button']")
    public CustomElement ddlSiteCustomername;

    @FindBy(locator = "xpath=//label[text()='Site']/..//input")
    public CustomElement ddlSiteCustomerInput;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement tbInput;

    @FindBy(locator = "xpath=//input[@placeholder='mm/dd/yyyy']")
    public CustomElement tbInspectionDate;

    @FindBy(locator = "xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
    public CustomElement ddlConveyor;

    @FindBy(locator = "xpath=//label[text()='Inspector']/..//input")
    public CustomElement ddlInspectorName;

    @FindBy(locator = "xpath=//p-multiselect[@optionlabel='name']//chevrondownicon")
    public CustomElement ddlCollaborators;

    public String ListItem = "//ul[@role='listbox']//li//span";

    @FindBy(locator = "xpath=(//span//button[@icon=\"ctp-icon-Add-circle\"])[2]")
    public CustomElement btnAddnew;

    @FindBy(locator = "xpath=//div[@class='jodit-wysiwyg']")
    public CustomElement eleSummary;

    @FindBy(locator = "xpath=//label[text()='Asset']/parent::div//div[@role='button']")
    public CustomElement ddlAsset;
    @FindBy(locator = "xpath=//label[text()='Asset']")
    public CustomElement tbAsset;

    @FindBy(locator = "xpath=//label[text()='Detail']/parent::div//div[@role='button']")
    public CustomElement ddlAssetDetail;

    @FindBy(locator = "xpath=//label[text()='Failure Mode']/parent::div//div[@role='button']")
    public CustomElement ddlFailureMode;

    @FindBy(locator = "xpath=//label[text()='Condition']/parent::div//div[@role='button']")
    public CustomElement ddlCondition;

    @FindBy(locator = "xpath=//label[text()='Status']/parent::div//div[@role='button']")
    public CustomElement ddlStatus;

    @FindBy(locator = "xpath=//label[text()='Status']/parent::div//input")
    public CustomElement ddlStatusView;

    @FindBy(locator = "xpath=//textarea[@formcontrolname='observation']")
    public CustomElement eleObservation;

    @FindBy(locator = "xpath=//textarea[@formcontrolname='recommendation']")
    public CustomElement eleRecommendation;

    @FindBy(locator = "xpath=//p-dialog//span[text()='Create']")
    public CustomElement btnCreate;
    @FindBy(locator = "xpath=//p-dialog//span[text()='Save']")
    public CustomElement btnSave;

    @FindBy(locator = "xpath=//button[@icon='ctp-icon-Edit']")
    public CustomElement btnEdit;

    @FindBy(locator = "xpath=//button[@icon='ctp-icon-Delete']")
    public CustomElement btnDelete;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement btnYes;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/inspections/')]")
    public CustomElement eleInspections;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/conveyor/')]")
    public CustomElement eleConveyordetails;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/sites/details/')]")
    public CustomElement eleSitedetails;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/companies/detail/')]")
    public CustomElement eleCompaniesDetails;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component']//li//a[contains(@ng-reflect-router-link,'/secure/companies/list')]")
    public CustomElement eleCompaniesList;

    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement cbCheckbox;

    @FindBy(locator = "xpath=(//td//p-tablecheckbox)[1]//input")
    public CustomElement cbCheckboxInput;

    @FindBy(locator = "xpath=(//button/chevrondownicon)[2]")
//	@FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
    public CustomElement ddlActions;

    @FindBy(locator = "xpath=//li//span[text()='Edit']")
    public CustomElement btnEditInspection;

    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btnDeleteInspection;

    @FindBy(locator = "xpath=(//button[contains(@class,'in p-button p-component p-button-icon-only')])[1]")
    public CustomElement eleArrow;

    @FindBy(locator = "xpath=//td[@class='ng-star-inserted']//following::td//span//i[contains(@class,'marker')]")
    public CustomElement eleLocation;

    @FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-inspection-add/p-dialog/div/div/div[2]/div/div[1]/div/div/div/input")
    public CustomElement tbLabel;

    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header-close p-link ng-star-inserted')]")
    public CustomElement btnClose;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Download')])[1]")
    public CustomElement btnDownload;

    @FindBy(locator = "xpath=(//span[@class='pi pi-search p-button-icon ng-star-inserted'])[1]")
    public CustomElement btnview;

    @FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-site-detail/div[1]/div/app-card-sllider/div/div/div[5]/app-card/div/div/div[3]/span")
    public CustomElement eleInspectionsite;

    @FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-company-detail/div[1]/div[5]/div/app-card/div/div/div[1]")
    public CustomElement eleInspectioncompany;

    @FindBy(locator = "xpath=//a[@ng-reflect-router-link='/secure/dashboard']//span")
    public CustomElement eleHome;

    @FindBy(locator = "xpath=//button//span[text()='Select Files']")
    public CustomElement btnSelectFiles;

    @FindBy(locator = "id=file-input")
    public CustomElement btnUpload;

    @FindBy(locator = "id=autocomplete-address")
    public CustomElement eleAddress;

    @FindBy(locator = "xpath=//input[@placeholder='Search']")
    public CustomElement eleSearch;

    public String eleNameOfInspection = "xpath=//tr[@Class='ng-star-inserted']//td[text()='Test Inspection 2']";

    @FindBy(locator = "xpath=//a[@ng-reflect-router-link='dashboard/inspections']//span")
    public CustomElement lnkInspectionIcon;

    @FindBy(locator = "xpath=//label[text()='Latitude']/parent::div//input")
    public CustomElement tbLat;

    @FindBy(locator = "xpath=//label[text()='Longitude']/parent::div//input")
    public CustomElement tbLong;

    @FindBy(locator = "xpath=//label[text()='Detail']/parent::div//div[@role='button']")
    public CustomElement ddlDetails;

    @FindBy(locator = "xpath=//label[text()='Detail']/parent::div//input")
    public CustomElement ddlDetailInput;

    @FindBy(locator = "xpath=//label[text()='Type']/parent::div//div[@role='button']")
    public CustomElement ddlTypes;

    @FindBy(locator = "xpath=//label[text()='Status']/parent::div//div[@role='button']")
    public CustomElement ddlStatus1;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator = "xpath=(//td//span[contains(@class,'pi-chevron-right')])[1]")
    public CustomElement detailIcon;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Arrow-Right')])[1]")
    public CustomElement ddViewicon;

    @FindBy(locator = "xpath=(//span[contains(@class,'p-panel-title')])[1]")
    public CustomElement inspectionHeader;

    @FindBy(locator = "xpath=//div[text()='Inspection updated.' or text()='Inspection created.']")
    public CustomElement inspectionUpdateMsg;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=//button//span[text()=\"Save\"]")
    public CustomElement ddlSave;

    @FindBy(locator = "xpath=//div[text()='Inspection updated.']")
    public CustomElement inspectionUpdated;

    @FindBy(locator = "xpath=(//div[text()='Inspections']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crInspections;

    @FindBy(locator = "xpath=//p-panel//span[text()='Inspection Events']")
    public CustomElement inspectionEventHeader;

    @FindBy(locator = "xpath=(//div//button//span[contains(@class,'ctp-icon-Technical-Data')])[2]")
    public CustomElement inspectionGroupView;

    @FindBy(locator = "xpath=(//div//button//span[contains(@class,'ctp-icon-detail-report')])[2]")
    public CustomElement inspectionListView;

    @FindBy(locator = "xpath=//th/div[text()=' Name of Inspection ']")
    public CustomElement nameOfInspectionCol;

    @FindBy(locator = "xpath=//th/div[text()=' Inspection Date ']")
    public CustomElement inspectionDateCol;

    @FindBy(locator = "xpath=//th/div[text()=' Last Updated ']")
    public CustomElement lastUpdatedCol;

    @FindBy(locator = "xpath=//th/div[text()=' Corporate ']")
    public CustomElement corporatesCol;

    @FindBy(locator = "xpath=//th/div[text()=' Site ']")
    public CustomElement siteCol;

    @FindBy(locator = "xpath=//th/div[text()=' Conveyor ']")
    public CustomElement conveyorCol;

    @FindBy(locator = "xpath=//th/div[text()=' Inspector ']")
    public CustomElement inspectorCol;

    @FindBy(locator = "xpath=//th/div[text()=' Condition ']")
    public CustomElement conditionCol;

    @FindBy(locator = "xpath=//th/div[text()=' Status ']")
    public CustomElement statusCol;

    @FindBy(locator = "xpath=//th[text()='More']")
    public CustomElement moreCol;

    @FindBy(locator = "xpath=//th/div[text()=' Asset ']")
    public CustomElement assetCol;

    @FindBy(locator = "xpath=//th/div[text()=' Photo ']")
    public CustomElement photoCol;

    @FindBy(locator = "xpath=//th/div[text()=' Observations ']")
    public CustomElement observationCol;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btAddInspection;

    @FindBy(locator = "xpath=//td[contains(@class,'p-datepicker-today')]")
    public CustomElement btTodayDate;

    @FindBy(locator = "xpath=//input[contains(@class,'p-multiselect-filter')]")
    public CustomElement tbMultipleDropdown;

    @FindBy(locator = "xpath=//span[@class='total-no']")
    public CustomElement totalEvent;

    @FindBy(locator = "xpath=//div[text()=' CRITICAL ']/following-sibling::div//span")
    public CustomElement criticalEvent;

    @FindBy(locator = "xpath=//div[text()=' POOR ']/following-sibling::div//span")
    public CustomElement poorEvent;

    @FindBy(locator = "xpath=//div[text()=' FAULT ']/following-sibling::div//span")
    public CustomElement faultEvent;

    @FindBy(locator = "xpath=//div[text()=' GOOD ']/following-sibling::div//span")
    public CustomElement goodEvent;

    @FindBy(locator = "xpath=//div[contains(@class,'NgxEditor__Content')]/p")
    public CustomElement summaryField;

    @FindBy(locator = "xpath=//span[contains(@class,'pi-window-maximize')]")
    public CustomElement summaryMaximize;

    @FindBy(locator = "xpath=//span[contains(@class,'pi-window-minimize')]/..")
    public CustomElement summaryMinimize;

    @FindBy(locator = "xpath=//div[@class='p-progress-spinner']")
    public CustomElement btSpinner;

    @FindBy(locator = "xpath=//p-galleriaitemslot/app-image-viewer")
    public CustomElement appImgViewer;

    @FindBy(locator = "xpath=//li/a/span[text()='Edit']")
    public CustomElement editBreadCrumb;

    @FindBy(locator = "xpath=(//td//img)[1]")
    public CustomElement imageAvatar;

    @FindBy(locator = "xpath=//i[@class='ctp-icon-Photos']")
    public CustomElement photoIcon;

    @FindBy(locator = "xpath=//img[contains(@class,'wrapper-image-item')]")
    public CustomElement imgPopup;

    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header-icon')]")
    public CustomElement closePopup;

    @FindBy(locator = "xpath=//div[text()='Failed to update inspection: Unauthorized']")
    public CustomElement inspectionAddErrorMsg;

    @FindBy(locator = "xpath=//timesicon")
    public CustomElement crossButton;

    @FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//span)[1]")
    public CustomElement txtInspCount;

    @FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//span)[2]")
    public CustomElement txtInspCompleteCount;
    @FindBy(locator = "xpath=//span[@class='sub-table-status ng-star-inserted']")
    public CustomElement txtStatusValue;

    @FindBy(locator = "xpath=//span[@class='condition-status']")
    public CustomElement txtConditionValue;

    @FindBy(locator = "xpath=//label[text()='Status']//..//div//input")
    public CustomElement txtStatusTotalValue;

    @FindBy(locator = "xpath=//label[text()='Condition']//..//div//input")
    public CustomElement txtConditionTotalValue;

    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement inspectionsBreadcrumb;

    @FindBy(locator = "xpath=//p-progressspinner//div[@role=\"progressbar\"]")
    public CustomElement imageLoader;

    @FindBy(locator = "xpath=//app-image-viewer[@cssclassname=\"wrapper-image\"]")
    public CustomElement uploadedImage;

    @FindBy(locator = "xpath=//button[contains(@icon,\"pi-trash\")]")
    public CustomElement deleteBtn;

    @FindBy(locator = "xpath=//li//span[text()='Export PDF']")
    public CustomElement btnExportInspection;
    @FindBy(locator = "xpath=//span[contains(@class,'ctp-icon-File-PDF')]")
    public CustomElement btnExportPDFIcon;


    @FindBy(locator = "xpath=//div[contains(@class,\"p-confirm-dialog\")]")
    public CustomElement deleteDialogbox;

    @FindBy(locator = "xpath=//checkicon[contains(@class,\"p-icon-wrapper\")]")
    public CustomElement confirmBtn;

    @FindBy(locator = "xpath=//span[text()='CV Common Regression']")
    public CustomElement conveyorBreadCrumb;

    @FindBy(locator = "xpath=//span[text()=\"Cust Automation Common India\"]")
    public CustomElement siteBreadCrumb;

    @FindBy(locator = "xpath=//span[text()=\"Cust Automation Common Corp\"]")
    public CustomElement corpBreadCrumb;

    @FindBy(locator = "xpath=//img[@src=\"/assets/img/upload_default.png\"]")
    public CustomElement defaultImage;
    @FindBy(locator = "xpath=//input[@id=\"file-input\"]")
    public CustomElement fileInput;

    @FindBy(locator = "xpath=//p-breadcrumb[.//*[self::span[text()='Technical Data']]]")
    public CustomElement technicalDataHeader;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Cust Automation Common India')]]")
    public CustomElement siteHeader;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Cust Automation Common Corp')]]")
    public CustomElement corpHeader;

    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Corporates')]]")
    public CustomElement headerCorporate;

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;

    @FindBy(locator = "xpath=//span[contains(@class,'p-carousel-prev-icon pi pi-chevron-right')]")
    public CustomElement btRightCarousel;

    @FindBy(locator = "xpath=//div[text()='Error'")
    public CustomElement inspectionErrorMsg;

    @FindBy(locator = "xpath=(//span[text()=\"Corporates\"])[2]")
    public CustomElement corporateLink;

    @FindBy(locator = "xpath=(//div[@class='card-inner-wrapper' and contains(div, 'Inspections')])[1]")
    public CustomElement btInspectionCard;

    @FindBy(locator = "xpath=//span[text()='Inspections']")
    public CustomElement txtInspectionEvent;

    @FindBy(locator = "xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement btviewicon;

    @FindBy(locator = "xpath=(//app-card//div[text()='Sites' or text()='Shops'] /..//span)[1]")
    public CustomElement btSiteShopCardNo;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Bar-Chart')])[2]")
    public CustomElement iconBarChart;

    @FindBy(locator = "xpath=//p-card//div[text()=' GOOD ']/../div/span")
    public CustomElement statusCardGoodCount;

    @FindBy(locator = "xpath=//p-card//div[text()=' TOTAL ']/../div/span")
    public CustomElement statusCardTotalCount;

    @FindBy(locator = "xpath=//p-card//div[text()=' POOR ']/../div/span")
    public CustomElement statusCardPoorCount;

    @FindBy(locator = "xpath=//p-card//div[text()=' FAULT ']/../div/span")
    public CustomElement statusCardFaultCount;

    @FindBy(locator = "xpath=//p-card//div[text()=' CRITICAL ']/../div/span")
    public CustomElement statusCardCriticalCount;

    @FindBy(locator = "xpath= //p-card//div[text()=' GOOD ']")
    public CustomElement cardStatusGood;

    @FindBy(locator = "xpath= //p-card//div[text()=' FAULT '] ")
    public CustomElement cardStatusFault;

    @FindBy(locator = "xpath= //p-card//div[text()=' POOR ']")
    public CustomElement cardStatusPoor;

    @FindBy(locator = "xpath= //p-card//div[text()=' CRITICAL ']")
    public CustomElement cardStatusCritical;

    @FindBy(locator = "xpath= //p-card//div[text()=' TOTAL ']")
    public CustomElement cardStatusTotal;

    @FindBy(locator = "xpath= //div//label[text()='Select Site']/..//p-multiselect[@optionvalue='companyId']")
    public CustomElement ddlSiteDropdown;
    @FindBy(locator = "xpath=//div[contains(@class,'p-multiselect-panel')]//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
    public CustomElement tbMultipleSiteDropdwn;

    @FindBy(locator = "xpath=//button[contains(@class,'p-multiselect-close')]")
    public CustomElement multiSelectCloseBtn;

    @FindBy(locator = "xpath=//button//span[text()='Actions']")
    public CustomElement btnActions;
    @FindBy(locator = "xpath=//span[text()='Clear Filters']")
    public CustomElement clearFilterBtn;

    @FindBy(locator = "//div//h6[text()=\"Section 1 Chutes/Load Area\"]/following-sibling::div//p[text()=\"Add New Item\"]")
    public CustomElement btnChutesAddNewItem;

    @FindBy(locator = "xpath=(//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div//span)[1]")
    public CustomElement inspectionMainCardCount;
    @FindBy(locator = "xpath=//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div[contains(text(),\"To be completed\")]//span")
    public CustomElement inspectionToBeCompletedCount;
    @FindBy(locator = "xpath=//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div[contains(@class,\"footer-count\")]//div[@style=\"background: rgb(45, 185, 40);\"]")
    public CustomElement inspectionGoodCount;
    @FindBy(locator = "xpath=//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div[contains(@class,\"footer-count\")]//div[@style=\"background: rgb(255, 198, 0);\"]")
    public CustomElement inspectionFaultCount;
    @FindBy(locator = "xpath=//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div[contains(@class,\"footer-count\")]//div[@style=\"background: rgb(255, 138, 0);\"]")
    public CustomElement inspectionPoorCount;
    @FindBy(locator = "xpath=//app-card//div[@class=\"header\" and text()=\"Inspections\"]/..//div[contains(@class,\"footer-count\")]//div[@style=\"background: rgb(255, 0, 0);\"]")
    public CustomElement inspectionCriticalCount;


    public void goToInspection() {
        if (!lnkInspection.isVisible())
            lnkHome.click("Home");
        waitForElementVisible(lnkInspection, 10000, 500);
        lnkInspection.jsClick();
        waitForPageLoad(10000);
        waitForElementVisible(btSearchinput, 5000, 500);
        SyncUtil.waitFor(2000);
//		lnkInspection.click("Inspection List");
        btSearchinput.isVisible("Inspection List Page");
    }

    public void goToInspectionScreenAndWait() {
        goToInspection();
        scrollPageDown();
        String val = "";
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(120); stop > System.nanoTime(); ) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(5000);
        }
    }

    public boolean searchInspection(String inspectionName) {
        goToInspectionScreenAndWait();
        btSearchinput.type(inspectionName, "Inspection Search");
        waitForElementToDisplay(cbCheckbox);
        return cbCheckbox.isVisible("Inspection Found");
    }

    public boolean searchInspectionItem(String conveyorName) {
        goToInspectionScreenAndWait();
        scrollPageup();
        if (inspectionGroupView.isVisible())
            inspectionGroupView.click("List View");
        btSearchinput.type(conveyorName, "Inspection Search");
        waitForElementToDisplay(cbCheckbox);
        return cbCheckbox.isVisible("Inspection Found");
    }

    public void verifyListPage() {
        btnItemlist.click();
    }

    public void addInspection(String inspectionName, String siteName, String fullName) {
        waitForPageLoad(5000);
        waitForElementToDisplay(btnAddInspection);
        waitForElementVisible(btnAddInspection, 20000, 1000);
        waitForElementToBeClickable(btnAddInspection);
//		SyncUtil.waitFor(5000);
        btnAddInspection.jsClick("Add Inspection btn");
        tbInspectionName.type(inspectionName);
        waitForElementToBeClickable(ddlSiteCustomername);
        dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
//		dropdownselectsearch(ddlConveyor, tbInput, conveyorName);
//		ddlInspectorName.verifyText(fullName,"Inspector Name");
        Reporter.log("Inspection is created", MessageTypes.Pass);
    }

    public void addNewInspectionEvent(String inspectionName, String siteName, String fullName) {
        waitForPageLoad(5000);
        waitForElementToDisplay(btnAddInspection);
        waitForElementVisible(btnAddInspection, 20000, 1000);
        waitForElementToBeClickable(btnAddInspection);
//		SyncUtil.waitFor(5000);
        btnAddInspection.jsClick("Add Inspection btn");
        waitForElementToBeClickable(ddlSiteCustomername);
        dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
        Validator.assertTrue(tbInspectionName.getText().contains(siteName), "site name is not populated as inspection name ", "site name is populated as inspection name ");
        tbInspectionName.type(inspectionName);
        ddlInspectorName.verifyText(fullName, "Inspector Name");
        Reporter.log("Inspection is created", MessageTypes.Pass);
    }

    public void addInspection(String inspectionName) {
        btnAddInspection.click("Add Inspection btn");
        tbInspectionName.type(inspectionName);
        Reporter.log("Inspection is created", MessageTypes.Pass);
    }

    public void saveInspectionItem() {
        waitForElementToBeClickable(btnCreate);
        btnCreate.jsClick("Create");
        waitForElementToDisplay(inspectionUpdateMsg);
        SyncUtil.waitFor(10000);
        Reporter.log("Inspection Item is created", MessageTypes.Pass);
    }

    public void updateInspectionItem() {
        waitForElementToBeClickable(btnSave);
        btnSave.jsClick();
        waitForElementToDisplay(inspectionUpdateMsg);
        SyncUtil.waitFor(10000);
        Reporter.log("Inspection Item is updated", MessageTypes.Pass);
    }


    public void addItemMandatoryField(String conveyorName, String assetName, String assetDetail, String failureMode, String condition, String status) {
        waitForElementToBeClickable(btnAddnew);
        SyncUtil.waitFor(4000);
        btnAddnew.click("Add New Inspection");
        dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
//        dropdownSelectSearch(ddlAsset, tbInput, assetName);
        waitForElementVisible(driver.findElement(By.xpath("//div//h6[contains(text(),'" + assetName + "')]/following-sibling::div//p[text()='Add New Item']")), 10000, 500);
        driver.findElement(By.xpath("//div//h6[contains(text(),'" + assetName + "')]/following-sibling::div//p[text()='Add New Item']")).click();
        waitForElementToDisplay(tbAsset);
        if (ddlDetails.isVisible())
            dropdownSelect(ddlDetails, ListItem, assetDetail);
        if (ddlTypes.isVisible())
            dropdownSelect(ddlTypes, ListItem, assetDetail);
        if (ddlDetailInput.isVisible())
            ddlDetailInput.type(assetDetail);
        dropdownSelectSearch(ddlFailureMode, tbInput, failureMode);
        dropdownSelect(ddlCondition, ListItem, condition);
        waitForElementVisible(driver.findElement(By.xpath("//div//label[text()=\"Status\"]/..//div//label[text()='" + status + "']/..//p-radiobutton[@name=\"status\"]")), 10000, 500);
        driver.findElement(By.xpath("//div//label[text()=\"Status\"]/..//div//label[text()='" + status + "']/..//p-radiobutton[@name=\"status\"]")).click();
    }

    public void addItemOptionalField(String lat, String longitude, String observation, String recommendation, String address, String img) {
        tbLong.type(lat, "Latitude");
        tbLat.type(longitude, "Longitude");
        eleObservation.type(observation, "Observation");
        eleRecommendation.type(recommendation, "Recommendation");
        if (eleAddress.isVisible())
            eleAddress.type(address, "Address");
        String file_path = ClasspathResourceHelper.getPropertyFile(img, "test_files").getAbsolutePath();
        btnUpload.sendKeys(file_path, "File Path");
        waitForElementToInvisible(btSpinner, 30000);
        appImgViewer.isVisible("App Image Viewer");
    }

    public void goToInspectionDetailScreen(String inspectionName) {
        searchInspection(inspectionName);
        waitForElementVisible(detailIcon, 10000, 500);
        waitForElementToDisplay(detailIcon);
        ddViewicon.click("Inspection Detail");
//		waitForPageLoad(10000);
//		waitForElementInvisible(btSpinner,10000,500);
        SyncUtil.waitFor(3000);
        inspectionHeader.verifyText(inspectionName, "Inspection Header");
    }

    public void edit() {
        btnEdit.click();
        dropdownSelectSearch(ddlFailureMode, tbInput, "Broken");
        btnSave.click();
        Reporter.log("Inspection Item is updated", MessageTypes.Pass);
    }

    public void delete() {
        waitForPageLoad(3000);
        btnDelete.click();
        btnYes.click();
        Reporter.log("Inspection Item is deleted", MessageTypes.Pass);
    }

    public void BreadCrumb() throws Throwable {
        //lnkInspection.click();
        //	btnview.click();
        //waitForPageLoad(3000);
        //eleInspections.click();
        scrollPageup();
        eleConveyordetails.click();
        eleInspectiontile.click();
        eleSitedetails.click();
        eleInspectionsite.click();
        eleCompaniesDetails.click();
        eleInspectioncompany.click();
        eleCompaniesList.click();
        eleHome.click();
        Reporter.log("Bread Crumb is passed", MessageTypes.Pass);
    }

    public void inspectionDelete() {
        cbCheckbox.check("Inspection Checkbox");
        ddlActions.click("Actions");
        waitForElementVisible(btnDeleteInspection, 10000, 500);
        btnDeleteInspection.click("Delete");
        btnYes.click("Confirm");
        waitForElementToDisplay(noList);
        Reporter.log("Inspection Item is deleted", MessageTypes.Pass);
    }

    public void Location() {
        //eleArrow.click();
        cbCheckbox.click();
        ddlActions.click();
        btnEditInspection.click();
        eleLocation.click();
        tbLabel.type("Added label");
        btnClose.click();
        Reporter.log("Verified location", MessageTypes.Pass);
    }

    public void downloadPDF() {

        btnDownload.click();
        SyncUtil.waitFor(10000);
        Reporter.log("PDF is downloaded", MessageTypes.Pass);
    }

    public void verifyInspection(String inspectionName, String itemCount) {
        Validator.assertTrue(searchInspection(inspectionName), "Inspection event is not found", "Inspection event is found");
        waitForElementToDisplay(detailIcon);
        ddViewicon.click("Inspection Detail");
        SyncUtil.waitFor(3000);
        inspectionHeader.verifyText("Inspection Event", "Inspection Header");
        scrollPageDown();
        SyncUtil.waitFor(3000);
        Validator.assertTrue(pagination.getText("Inspection Item").contains(itemCount), "All Inspections Items are not listed", "All Inspections Items are listed");
    }

    public void verifyPDFContents(String fullName, String custSiteName, String conveyorName, String inspectionName, String inspectionId) {
        PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + custSiteName + "-Multiple-" + inspectionName + ".pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            Validator.assertTrue(val.contains(fullName), "PDF Report was generated for the wrong inspector", "PDF Report was generated for the right inspector");
            Validator.assertTrue(val.contains(custSiteName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
            Validator.assertTrue(val.contains(conveyorName) || val.contains("Multiple"), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
            Validator.assertTrue(val.contains(inspectionName), "PDF Report was generated for the wrong inspection", "PDF Report was generated for the right inspection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyInspectionDashboardContents(String custSiteName, String corp) {
        PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + corp + "-inspection-dashboard.pdf");
        try {
            String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
            System.out.println(val);
            Validator.assertTrue(val.contains(custSiteName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyDeleteInspection(String inspectionName) {
        goToInspectionScreenAndWait();
        btSearchinput.type(inspectionName, "Inspection Search");
        Validator.assertTrue(noList.isVisible("No Inspection"), "Inspection list was found", "Inspection list was not found");
        noList.isVisible("No Inspection List");
    }

    public void editInspection(String inspectionName) {
        searchInspection(inspectionName);
        cbCheckbox.check("Select Checkbox");
        ddlActions.click("Actions");
        waitForElementVisible(btnEditInspection, 10000, 500);
        btnEditInspection.click("Edit");
        ddlSave.isVisible("Edit save");
    }

    public void editInspectionName(String inspectionName, String newInspName) {
        editInspection(inspectionName);
        waitForElementToDisplay(tbInspectionName);
        SyncUtil.waitFor(1500);
        tbInspectionName.type(newInspName);
        SyncUtil.waitFor(4000);
        saveInspectionEvent();
    }

    public void editInspectionItem(String inspectionItem, String newStatus) {
        btSearchinput.type(inspectionItem, "Inspection Search");
        waitForElementToDisplay(cbCheckbox);
        btnEdit.click("Edit Inspection Item");
        waitForElementVisible(driver.findElement(By.xpath("//div//label[text()=\"Status\"]/..//div//label[text()='" + newStatus + "']/..//p-radiobutton[@name=\"status\"]")), 10000, 500);
        driver.findElement(By.xpath("//div//label[text()=\"Status\"]/..//div//label[text()='" + newStatus + "']/..//p-radiobutton[@name=\"status\"]")).click();
        btnSave.jsClick("Save");
        waitForElementToDisplay(inspectionUpdateMsg);
        Reporter.log("Inspection Item is Updated", MessageTypes.Pass);
    }

    public void deleteInspectionItem(String inspectionItem) {
        waitForElementToDisplay(btSearchinput);
        btSearchinput.type(inspectionItem, "Inspection Search");
        waitForElementToDisplay(cbCheckbox);
        SyncUtil.waitFor(3000);
        cbCheckbox.click("Checkbox");
        ddlActions.click("Action");
        waitForElementToBeClickable(btnDelete);
        btnDelete.click("Delete Inspection Item");
        btnYes.click("Confirm delete");
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
    }

    public void saveInspectionEvent() {
        waitForElementToBeClickable(ddlSave);
        ddlSave.jsClick("Save Inspection Event");
//		waitForElementToDisplay(inspectionUpdated);
        SyncUtil.waitFor(1000);
        inspectionUpdated.isEnable("Inspection Update Toast");
    }

    public void goToInspectionsFromTile() {
        waitForElementToBeClickable(crInspections);
        crInspections.jsClick("Inspection Tile");
        SyncUtil.waitFor(5000);
        inspectionEventHeader.isVisible("Inspection Event Header");
    }

    public boolean verifyDefaultViewSelection() {
        return inspectionGroupView.isVisible("Group View") && !inspectionListView.isVisible();
    }

    public boolean verifyDefaultViewColumns() {
        return nameOfInspectionCol.isEnable("Name Of inspection") && inspectionDateCol.isEnable("Inspection Date") && lastUpdatedCol.isEnable("Last Updated") && corporatesCol.isEnable("Corporates") && siteCol.isEnable("Site") && conveyorCol.isEnable("Conveyor") && inspectorCol.isEnable("Inspector") && conditionCol.isEnable("Condition") && statusCol.isEnable("Status") && moreCol.isEnable("More");
    }

    public boolean verifySwitchView() {
        inspectionGroupView.click("List View");
        return inspectionListView.isVisible("List View") && !inspectionGroupView.isVisible();
    }

    public boolean verifyListViewColumns() {
        setImplicitWait(10000, TimeUnit.MILLISECONDS);
        return inspectionDateCol.isEnable("Inspection Date") && lastUpdatedCol.isEnable("Last Updated") && siteCol.isEnable("Site") && conveyorCol.isEnable("Conveyor") && inspectorCol.isEnable("Inspector") && conditionCol.isEnable("Condition") && statusCol.isEnable("Status") && moreCol.isEnable("More") && assetCol.isEnable("Asset") && photoCol.isEnable("Photo") && observationCol.isEnable("Observation");
    }

    public boolean verifyAddInspectionFromList() {
        waitForElementVisible(btAddInspection, 10000, 500);
        waitForElementToBeClickable(btAddInspection);
        btAddInspection.click("Add Inspection Icon");
        return inspectionHeader.isVisible("Inspection Header");
    }

    public boolean verifyPlaceHolderForInspectionName() {
        return ddlInspectorName.getAttribute("placeholder").equalsIgnoreCase("Type Inspection Name");
    }

    public boolean verifyDefaultDateField() {
        return tbInspectionDate.getAttribute("placeholder").equalsIgnoreCase("Type Inspection Name");
    }

    public boolean verifyDefaultInspectionDate() {
        tbInspectionDate.click("Inspection Date");
        return btTodayDate.isVisible("Today Date");
    }

    public void verifySiteSelection(String siteName) {
        dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
    }

    public void verifyDefaultSite(String siteName) {
        ddlSiteCustomerInput.getAttribute("value").equalsIgnoreCase(siteName);
    }

    public void verifyCollaboratorSelection(String collaboratorName) {
        ddlCollaborators.click();
        setImplicitWait(40000, TimeUnit.MILLISECONDS);
        waitForPresenceOfElement(By.xpath("//span[text()='" + collaboratorName + "']"));
        tbMultipleDropdown.sendKeys(collaboratorName);
        driver.findElement("//span[text()='" + collaboratorName + "']").click();
        setImplicitWait(1000, TimeUnit.MILLISECONDS);
    }

    public boolean verifyDefaultTileCount(String val) {
        return totalEvent.getText("Total Event").equalsIgnoreCase(val) && criticalEvent.getText("Critical Event").equalsIgnoreCase(val) && poorEvent.getText("Poor Event").equalsIgnoreCase(val) && faultEvent.getText("Fault Event").equalsIgnoreCase(val) && goodEvent.getText("Good Event").equalsIgnoreCase(val);
    }

    public boolean verifyInspectionCount(String total, String val) {
        return totalEvent.getText("Total Event").equalsIgnoreCase(total) && criticalEvent.getText("Critical Event").equalsIgnoreCase(val) && poorEvent.getText("Poor Event").equalsIgnoreCase(val) && faultEvent.getText("Fault Event").equalsIgnoreCase(val) && goodEvent.getText("Good Event").equalsIgnoreCase(val);
    }

    public boolean verifySummaryField(String val) {
        summaryField.sendKeys(val);
        SyncUtil.waitFor(5000);
        return summaryField.getText("Summary Field").equalsIgnoreCase(val);
    }

    public boolean verifyInspectorName(String val) {
        return ddlInspectorName.getAttribute("value").equalsIgnoreCase(val);
    }

    public boolean verifyMaximize() {
        summaryMaximize.click("Summary window Maximize");
        return !summaryMaximize.isVisible() && summaryMinimize.isVisible("Summary window Minimize");
    }

    public boolean verifyMinimize() {
        summaryMinimize.jsClick("Summary window Minimize");
        return !summaryMinimize.isVisible() && summaryMaximize.isVisible("Summary window Maximize");
    }

    public boolean verifySaveBtn() {
        return !btnAddnew.isEnable();
    }

    public void selectInspection() {
        cbCheckbox.check("Checkbox");
    }

    public boolean verifyActionBtnState() {
        return ddlActions.isEnable();
    }

    public boolean verifyDropDown() {
        ddlActions.click("Actions");
        return btnEditInspection.isVisible("Edit Conveyor") && btnDeleteInspection.isVisible("Delete Conveyor");
    }

    public boolean verifyEditBreadcrumb() {
        btnEditInspection.click("Edit Inspection");
        return editBreadCrumb.isVisible("Edit Breadcrumb");
    }

    public void editInspectionName(String name) {
        waitForElementToDisplay(tbInspectionName);
        tbInspectionName.type(name);
    }

    public void editInspectorName(String name) {
        waitForElementToDisplay(ddlInspectorName);
        ddlInspectorName.type(name);
    }

    public boolean verifyEditChanges(String eventName, String inspectorName) {
        return ddlInspectorName.getAttribute("value").equalsIgnoreCase(inspectorName);
    }

    public void editInspectionItemList(String conveyorName) {
        searchInspectionItem(conveyorName);
        cbCheckbox.check("Select Checkbox");
        ddlActions.click("Actions");
        waitForElementVisible(btnEditInspection, 10000, 500);
        btnEditInspection.click("Edit");
        btnSave.isVisible("Edit save");
    }

    public void editInspectionIemStatus(String status) {
        waitForElementToDisplay(ddlStatus);
        dropdownSelect(ddlStatus, ListItem, status);
        btnSave.jsClick("Save");
        waitForElementToDisplay(inspectionUpdateMsg);
        Reporter.log("Inspection Item is Updated", MessageTypes.Pass);
    }

    public boolean verifyEditedItemChanges(String conveyorName, String status) {
        goToInspection();
        verifySwitchView();
        searchInspection(conveyorName);
        ddViewicon.click("Inspection Detail");
        return ddlStatusView.getAttribute("value").equalsIgnoreCase(status);
    }

    public String verifyInspectionGroupedView(String inspectionName) {
        searchInspection(inspectionName);
        detailIcon.click("Expand Inspection");
        return imageAvatar.getAttribute("src");
    }

    public void verifyImageViewerGrouped() {
        imageAvatar.click("photo");
        waitForElementToDisplay(imgPopup);
        imgPopup.isVisible("Image");
        closePopup.click();
    }

    public boolean verifyInspectionListView(String conveyor) {
        searchInspectionItem(conveyor);
        return photoIcon.isVisible("Photo icon");
    }

    public void verifyImageViewerList() {
        photoIcon.click("photo");
        waitForElementToDisplay(imgPopup);
        imgPopup.isVisible("Image");
        closePopup.click();
    }

    public void verifyDeleteInspectionItem(String conveyor) {
        goToInspectionScreenAndWait();
        btSearchinput.type(conveyor, "Inspection Search");
        Validator.assertTrue(pagination.getText().contains("0"), "Inspection items were not deleted", "Inspection item list was not found");
    }

    public void enterInspectionName(String inspectionName) {
        tbInspectionName.type(inspectionName);
    }

    public void verifyInspectionCount() {
        waitForPageLoad(5000);
        waitForElementToDisplay(txtInspCount);
        waitForElementVisible(txtInspCount, 10000, 1000);
        Validator.assertTrue(txtInspCount.isDisplayed(), "Inspection Tile Count is not visible", "Inspection Tile Count is visible");
    }

    public void verifyInspectionCompleteCount() {
        waitForPageLoad(5000);
        waitForElementToDisplay(txtInspCompleteCount);
        waitForElementVisible(txtInspCompleteCount, 5000, 1000);
        Validator.assertTrue(txtInspCompleteCount.isDisplayed(), "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
    }

    public void extractStatusValue() {
        waitForElementVisible(txtStatusValue, 5000, 1000);
        String statValue = txtStatusValue.getText();
        getBundle().setProperty("statusValue", statValue);
    }

    public void extractConditionValue() {
        waitForElementVisible(txtConditionValue, 5000, 1000);
        String conValue = txtConditionValue.getText();
        getBundle().setProperty("conditionValue", conValue);
    }

    public void clickOnViewBtn() {
        waitForElementVisible(ddViewicon, 10000, 1000);
        ddViewicon.click();
    }

    public void verifyStatusValue() {
        String expectedValue = getBundle().getProperty("statusValue").toString().toLowerCase();
        String actualValue = txtStatusTotalValue.getAttribute("value").toLowerCase();
        Assert.assertEquals(expectedValue, actualValue, "Status value matched");
    }


    public void verifyConditionValue() {
        String expectedValue = getBundle().getProperty("conditionValue").toString().toLowerCase();
        String actualValue = txtConditionTotalValue.getAttribute("value").toLowerCase();
        Assert.assertEquals(expectedValue, actualValue, "Condition value matched");
    }

    public void verifyDulpicateInspection(String inspectionName) {
        btSearchinput.type(inspectionName, "Inspection Search");
        waitForElementToDisplay(cbCheckbox);
        int noOfCorporates = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        waitForPageLoad(5000);
        Assert.assertEquals(noOfCorporates, 1, "Number of corporates is not 1");
    }

    public void saveDulpicateInspectionItem() {
        waitForElementToBeClickable(btnSave);
        btnSave.click("Save");
        waitForElementToDisplay(inspectionErrorMsg);
        Validator.assertTrue(inspectionErrorMsg.isDisplayed(), "Error message is not displayed", "Error message is displayed");
    }

    public void viewAndVerifyCorporatePage() {
        waitForElementVisible(btviewicon, 5000, 1000);
        btviewicon.click();
        waitForPageLoad(5000);
        Validator.assertTrue(btSiteShopCardNo.isDisplayed(), "Corporate Page is not loaded", "Corporate Page is loaded");
    }

    public void verifyInspectionCardClick() {
        waitForPageLoad(5000);
        waitForElementVisible(btInspectionCard, 5000, 1000);
        waitForElementToBeClickable(btInspectionCard);
        Validator.assertTrue(btInspectionCard.isEnable(), "Inspection Card is not clickable", "Inspection Card is clickable");
        btInspectionCard.click();
        waitForPageLoad(5000);
        Validator.assertTrue(txtInspectionEvent.isDisplayed(), "Inspection Page is not loaded", "Inspection Page is loaded");
    }

    public void verifyUserBreadCrumb() {
        waitForElementVisible(inspectionHeader, 5000, 500);
        Validator.assertTrue(inspectionHeader.isVisible(), "inspections header is not visible", "inspections header is visible");
        waitForElementVisible(inspectionsBreadcrumb, 10000, 500);
        Validator.assertTrue(inspectionsBreadcrumb.isDisplayed(), "Breadcrumb element is not displayed", "Breadcrumb text is displayed");
        assertEquals(inspectionsBreadcrumb.getText(), "Home\nInspections", "Breadcrumb text does not match expected");

    }

    public void addNewBtnClick() {
        scrollPageDown();
        waitForElementVisible(btnAddnew, 5000, 500);
        waitForElementToBeClickable(btnAddnew);
        SyncUtil.waitFor(4000);
        btnAddnew.click("Add New Inspection");
    }

    public void verifyAddFilesToUploadBtn() {
//		waitForElementVisible(fileInput,10000,500);
//		Validator.assertTrue(fileInput.isVisible(),"Add files section is not visible","Add files section is visible");
        waitForElementVisible(btnSelectFiles, 5000, 500);
        Validator.assertTrue(btnSelectFiles.isVisible(), "User is not able to view add files to upload section", "User is able to see add files to upload section");

    }

    public void selectFilesBtnClick() {
        waitForPageLoad(5000);
        waitForElementVisible(btnSelectFiles, 5000, 500);
        btnSelectFiles.jsClick();

    }

    public void verifyLoader() {
        waitForElementVisible(imageLoader, 1000, 500);
        Validator.assertTrue(imageLoader.isVisible(), "the loader is not visible", "the loader is visible");
    }

    public void verifyUploadedImage() {
//		waitForElementVisible(defaultImage,5000,500);
//		waitForElementToInvisible(defaultImage);
        waitForPageLoad(20000);
        SyncUtil.waitFor(8000);
//        waitForElementVisible(uploadedImage, 10000, 5000);
        Validator.assertTrue(uploadedImage.isVisible(), "the image is not visible", "the uploaded image is visible");

    }

    public void verifyDeleteBtn() {
        waitForElementVisible(deleteBtn, 10000, 500);
        Validator.assertTrue(deleteBtn.isVisible(), "The delete button is not visible", "The delete button is visible");
    }

    public void deleteBtnClick() {
        waitForElementVisible(deleteBtn, 10000, 500);
        waitForElementToBeClickable(deleteBtn);
        deleteBtn.click();
        waitForElementVisible(deleteDialogbox, 5000, 500);
        waitForElementVisible(confirmBtn, 5000, 500);
        waitForElementToBeClickable(confirmBtn);
        confirmBtn.click();

    }

    public void verifyImageDeletion() {
        Validator.assertTrue(uploadedImage.verifyNotPresent(), "The image is failed to delete", "The image is not uploaded");
    }

    public void exportBtnClick() {
        waitForElementVisible(ddlActions, 5000, 500);
        ddlActions.click("Actions");
        waitForElementVisible(btnExportInspection, 10000, 500);
        btnExportInspection.jsClick("Export pdf");


    }

    public void exportPDFConveyor(String conveyorName) {
        searchInspectionItem(conveyorName);
        selectInspection();
        waitForElementVisible(ddlActions, 5000, 500);
        ddlActions.click("Actions");
        SyncUtil.waitFor(10000);
        waitForElementVisible(btnExportInspection, 10000, 500);
        btnExportInspection.jsClick("Export pdf");

    }

    public void searchForInspectionItem(String conveyorName) {
        waitForElementVisible(btSearchinput, 5000, 500);
        btSearchinput.type(conveyorName, "Inspection Search");
        waitForElementVisible(cbCheckbox, 10000, 500);
        waitForElementToDisplay(cbCheckbox);
    }

    public void viewInspectionItem() {
        waitForElementVisible(ddViewicon, 5000, 500);
        ddViewicon.click();
    }

    public void conveyorNameClick(String conveyorName) {
        String conveyorBreadCrumb = "//span[text()='" + conveyorName + "']";
        waitForElementVisible(driver.findElement(By.xpath(conveyorBreadCrumb)), 10000, 500);
//		waitForElementVisible(siteBreadCrumb, 5000, 500);
        scrollPageup();
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(driver.findElement(By.xpath(conveyorBreadCrumb)));
        driver.findElement(By.xpath(conveyorBreadCrumb)).click();
//		waitForElementVisible(conveyorBreadCrumb,5000,500);
//		conveyorBreadCrumb.jsClick("Conveyor name");

    }


    public void verifyConveyorPageNavigation() {
        SyncUtil.waitFor(10000);
        waitForPageLoad(15000);
        waitForElementVisible(technicalDataHeader, 10000, 500);
        Validator.assertTrue(technicalDataHeader.isVisible(), "User is not navigated to conveyor detail page", "User is navigated to conveyor detail page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/conveyor/details"), "User is not navigated to conveyor detail page", "User is navigated to conveyor detail page");

    }

    public void verifyInspections(int noOfData, String breadCrumbValue, int row) {
        waitForPageLoad(10000);

        for (int i = 1; i <= noOfData; i++) {
            WebElement locator = driver.findElement(By.xpath("//tr[" + i + "]/td[" + row + "][contains(., '" + breadCrumbValue + "')]"));

            try {
                waitForElementVisible(locator, 5000, 500);
                Validator.assertTrue(locator.isDisplayed(), "Inspections of " + breadCrumbValue + " is not visible", "Inspections of " + breadCrumbValue + " is visible");
            } catch (TimeoutException e) {
                Validator.assertTrue(false, "No inspections found for " + breadCrumbValue, " inspections found for " + breadCrumbValue);
                break; // Exit the loop if no inspections are found
            }
        }
    }

    public void siteNameClick(String siteName) {
        String xpath = "//span[text()='" + siteName + "']";
        waitForElementVisible(driver.findElement(By.xpath(xpath)), 10000, 500);
//		waitForElementVisible(siteBreadCrumb, 5000, 500);
        scrollPageup();
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        SyncUtil.waitFor(10000);

    }

    public void verifySitePageNavigation(String siteName) {
        // Wait for the page to load completely
        waitForPageLoad(20000);
        SyncUtil.waitFor(5000);
        // Construct the XPath for the site header
        String siteHeader = "//div[contains(@class,'p-panel-header') and .//span[contains(text(),'" + siteName + "')]]";

        // Wait for the site header to be visible
        waitForElementVisible(driver.findElement(By.xpath(siteHeader)), 20000, 500);

        // Wait for the site header to be displayed
        waitForElementToDisplay(driver.findElement(siteHeader));

        // Check if the site header is displayed
        Validator.assertTrue(driver.findElement(By.xpath(siteHeader)).isDisplayed(), "User is not navigated to site page", "User is navigated to site detail page");

        // Check if the current URL contains the expected path
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/sites/details"), "User is not navigated to site page", "User is navigated to site page");
    }


    public void corporateNameClick(String corpName) {
        String corpBreadCrumb = "//span[text()='" + corpName + "']";
//		waitForElementVisible(corpBreadCrumb,5000,500);
        waitForElementVisible(driver.findElement(By.xpath(corpBreadCrumb)), 10000, 500);
//		waitForElementVisible(siteBreadCrumb, 5000, 500);
        scrollPageup();
        SyncUtil.waitFor(5000);
        waitForElementToBeClickable(driver.findElement(By.xpath(corpBreadCrumb)));
        driver.findElement(By.xpath(corpBreadCrumb)).click();
        SyncUtil.waitFor(10000);

    }


    public void verifyCorporatePageNavigation(String corpName) {
        waitForPageLoad(15000);
        String corpHeader = "//div[contains(@class,'p-panel-header') and .//span[contains(text(),'" + corpName + "')]]";
        waitForElementVisible(driver.findElement(By.xpath(corpHeader)), 20000, 500);
        waitForElementToDisplay(driver.findElement(corpHeader));
//		waitForElementVisible(siteHeader,10000,500);
        Validator.assertTrue(driver.findElement(By.xpath(corpHeader)).isDisplayed(), "User is not navigated to corporate detail page", "User is navigated to corporate detail page");
//		waitForElementVisible(corpHeader,10000,500);
//		Validator.assertTrue(corpHeader.isVisible(),"User is not navigated to corporate detail page","User is navigated to corporate detail page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/companies/detail"), "User is not navigated to corporate detail page", "User is navigated to corporate page");

    }


    public void corpBreadCrumbClick() {
        waitForElementVisible(corporateLink, 5000, 500);
        corporateLink.jsClick();
    }

    public void verifyCorporateListPageNavigation() {
//		SyncUtil.waitFor(10000);
        waitForPageLoad(15000);
        waitForElementVisible(headerCorporate, 10000, 500);
        Validator.assertTrue(headerCorporate.isVisible(), "User is not navigated to corporate list page", "User is navigated to corporate list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/companies/list"), "User is not navigated to corporate list page", "User is navigated to corporate list page");

    }

    public void inspectionDashboardBtnClick() {
        waitForElementVisible(iconBarChart, 5000, 500);
        waitForElementToBeClickable(iconBarChart);
        iconBarChart.jsClick("inspection dashboard");
        Validator.assertTrue(iconBarChart.isEnabled(), "Inspection dashboard is clickable", "Inspection dashboard is  clickable");
    }

    public void verifyInspectionItemsCounts(String total, String critical, String poor, String fault, String good) {
        waitForPageLoad(5000);
        waitForElementVisible(statusCardCriticalCount, 5000, 500);
        SyncUtil.waitFor(5000);
        Validator.assertTrue(statusCardTotalCount.getText().contains(total), "Total Count doesn't match", "Critical Count match");
        Validator.assertTrue(statusCardCriticalCount.getText().contains(critical), "Critical Count doesn't match", "Critical Count match");
        Validator.assertTrue(statusCardPoorCount.getText().contains(poor), "Poor Count doesn't match", "Poor Count match");
        Validator.assertTrue(statusCardFaultCount.getText().contains(fault), "Fault Count doesn't match", "Fault Count match");
        Validator.assertTrue(statusCardGoodCount.getText().contains(good), "Good Count doesn't match", "Good Count match");

    }

    public void verifyInspectionDashboardCards() {
        waitForElementVisible(cardStatusTotal, 10000, 500);
        Validator.assertTrue(cardStatusTotal.isVisible() && cardStatusCritical.isVisible() && cardStatusPoor.isVisible()
                && cardStatusFault.isVisible() && cardStatusGood.isVisible(), "User cannot see all cards in inspection dashboard", "User can see Total, Critical,Poor,Fault and Good cards in inspection dashboard");
    }

    public void siteDropDownClick() {
        waitForElementVisible(ddlSiteDropdown, 10000, 500);
        waitForElementToBeClickable(ddlSiteDropdown);
        ddlSiteDropdown.click();
        SyncUtil.waitFor(10000);
    }

    public void verifyMultiSelInSiteDropDown(String siteName, String siteName2) {
        waitForElementVisible(multiSelectCloseBtn, 10000, 500);
        multiSelectCloseBtn.click();
        waitForElementVisible(ddlSiteDropdown, 10000, 500);
        ddlSiteDropdown.click();
        setImplicitWait(30000, TimeUnit.MILLISECONDS);
        String site = "//p-multiselectitem//li[@aria-label='" + siteName + "']";
        waitForElementVisible(driver.findElement(By.xpath(site)), 10000, 500);
        driver.findElement(By.xpath(site)).click();
        String site2 = "//p-multiselectitem//li[@aria-label='" + siteName2 + "']";
        waitForElementVisible(driver.findElement(By.xpath(site2)), 10000, 500);
        driver.findElement(By.xpath(site2)).click();
        waitForElementToDisplay(tbMultipleSiteDropdwn);
        waitForElementVisible(tbMultipleSiteDropdwn, 20000, 500);
        String siteSelected = "//p-multiselectitem//li[@aria-label='" + siteName + "' and contains(@class, 'p-highlight')]";
        String siteSelected2 = "//p-multiselectitem//li[@aria-label='" + siteName2 + "' and contains(@class, 'p-highlight')]";
        waitForElementVisible(driver.findElement(By.xpath(siteSelected)), 10000, 500);
        Validator.assertTrue(driver.findElement(By.xpath(siteSelected)).isDisplayed(), "The user is not able to select site", "The user is  able to select site");
        Validator.assertTrue(driver.findElement(By.xpath(siteSelected2)).isDisplayed(), "The user is not able to select site2", "The user is  able to select site2");
    }

    public void verifySiteDropDownClicked(String siteName) {
        waitForElementVisible(multiSelectCloseBtn, 10000, 500);
        multiSelectCloseBtn.click();
    }

    public void verifyViewRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
        searchInspection(inspectionName);
        waitForElementToDisplay(cbCheckbox);
        Validator.assertTrue(!cbCheckboxInput.isEnabled(), "Inspection checkbox should not be enabled with only view rights", "Inspection checkbox is disabled with only view rights");
        Validator.assertTrue(!btnAddInspection.isVisible(), "Add inspection should not be visible with view only rights", "Add inspection is not visible with view only rights");
        goToInspectionDetailScreen(inspectionName);
        Validator.assertTrue(!btnAddnew.isVisible(), "Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
//		addItemMandatoryField(conveyorName, assetName, assetDetail, failureMode, condition, status);
//		waitForElementToBeClickable(btnSave);
//		btnSave.click("Save");
//		SyncUtil.waitFor(3000);
//		verifyAddInspectionItemErrorMsg();
//		crossButton.click("Cross Button");
//		edit();
//		verifyAddInspectionItemErrorMsg();
//		SyncUtil.waitFor(3000);
//		crossButton.click("Cross Button");
//		SyncUtil.waitFor(5000);
//		delete();
//		verifyAddInspectionItemErrorMsg();
//		SyncUtil.waitFor(3000);
    }

    public void verifyViewAndEditRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
        goToInspectionScreenAndWait();
        editInspection(inspectionName);
        //	btnSave.click("Save");
        waitForElementToDisplay(inspectionUpdateMsg);
        addItemMandatoryField(conveyorName, assetName, assetDetail, failureMode, condition, status);
        verifyAddInspectionItemErrorMsg();
        SyncUtil.waitFor(3000);
        crossButton.click("Cross Button");
        SyncUtil.waitFor(3000);
        delete();
        verifyAddInspectionItemErrorMsg();
    }

    public void verifyViewAndAddRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
        searchInspection(inspectionName);
        waitForElementToDisplay(cbCheckbox);
        Validator.assertTrue(!cbCheckboxInput.isEnabled(), "Inspection checkbox should not be enabled with only view rights", "Inspection checkbox is disabled with only view rights");
        Validator.assertTrue(btnAddInspection.isVisible(), "Add inspection is visible with add rights", "Add inspection is not visible with add rights");
        goToInspectionDetailScreen(inspectionName);
        Validator.assertTrue(!btnAddnew.isVisible(), "Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
        Validator.assertTrue(!btnEdit.isVisible(), "Edit inspection item should not be visible with view only rights", "Edit inspection item is not visible with view only rights");
        Validator.assertTrue(!btnDelete.isVisible(), "Delete inspection item should not be visible with view only rights", "Delete inspection item is not visible with view only rights");
//		addItemMandatoryField(conveyorName, assetName, assetDetail, failureMode, condition, status);
//		btnSave.click("Save");
//		waitForElementToDisplay(inspectionUpdateMsg);
//		btnEdit.click();
//		btnSave.click("Save");
//		verifyAddInspectionItemErrorMsg();
//		SyncUtil.waitFor(3000);
//		crossButton.click("Cross Button");
//		SyncUtil.waitFor(3000);
//		delete();
//		verifyAddInspectionItemErrorMsg();
    }

    public void verifyViewAndDeleteRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
        searchInspection(inspectionName);
        waitForElementToDisplay(cbCheckbox);
        Validator.assertTrue(cbCheckboxInput.isEnabled(), "Inspection checkbox is not be enabled with only delete rights", "Inspection checkbox is enabled for delete rights");
        Validator.assertTrue(!btnAddInspection.isVisible(), "Add inspection is visible with delete rights", "Add inspection is visible with delete rights");
        cbCheckbox.click("checkbox");
        ddlActions.click("action");
        Validator.assertTrue(!btnEditInspection.isVisible(), "Edit inspection is visible with delete rights", "Edit inspection is not visible with delete rights");
        Validator.assertTrue(btnDeleteInspection.isVisible(), "Delete inspection is not visible with delete rights", "Delete inspection is visible with delete rights");
        goToInspectionDetailScreen(inspectionName);
        Validator.assertTrue(!btnAddnew.isVisible(), "Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
        Validator.assertTrue(!btnEdit.isVisible(), "Edit inspection item should not be visible with view only rights", "Edit inspection item is not visible with view only rights");
        Validator.assertTrue(!btnDelete.isVisible(), "Delete inspection item should not be visible with view only rights", "Delete inspection item is not visible with view only rights");
//		goToInspectionDetailScreen(inspectionName);
//		inspectionDelete();
//		waitForElementToDisplay(inspectionUpdateMsg);
//		addItemMandatoryField(conveyorName, assetName, assetDetail, failureMode, condition, status);
//		btnSave.click("Save");
//		verifyAddInspectionItemErrorMsg();
//		SyncUtil.waitFor(3000);
//		crossButton.click("Cross Button");
//		SyncUtil.waitFor(3000);
//		btnEdit.click();
//		btnSave.click("Save");
//		verifyAddInspectionItemErrorMsg();
//		crossButton.click("Cross Button");

    }

    public void verifyAddInspectionItemErrorMsg() {
        waitForElementToDisplay(inspectionAddErrorMsg);
        Reporter.log("Add Inspection error message is displayed", MessageTypes.Pass);
    }


    public void verifyActionBtnEnabled() {
        Validator.assertTrue(btnActions.isPresent(), "The actions button is not present in inspection dashboard", "The actions button is present in inspection dashboard");
        Validator.assertTrue(btnActions.isEnabled(), "The actions button is not enabled by default in inspection dashboard", "The actions button is enabled by default in inspection dashboard");

    }

    public void verifyExportPDFIsVisible() {
        waitForElementVisible(btnExportInspection, 10000, 500);
        Validator.assertTrue(btnExportInspection.isVisible() && btnExportPDFIcon.isVisible(), "User is not able to see Export PDF along with PDF Symbol", "User is able to see Export PDF along with PDF Symbol");
    }

    public void clickClickFilter() {
        waitForElementVisible(clearFilterBtn, 5000, 1000);
        Validator.assertTrue(clearFilterBtn.isDisplayed(), "Clear Button is not found", "Clear Button is found");
        clearFilterBtn.jsClick();
        waitForPageLoad(10000);
    }

    public void verifyInspectionMainCardDetails() {
        inspectionMainCardCount.isVisible(10000, "Main Card");
        Validator.assertTrue(inspectionMainCardCount.isVisible(10000, "Main Card Count"), "Total number of inspection event is not visible in the card!", "Total number of inspection event is  visible in the card!");
        Validator.assertTrue(inspectionToBeCompletedCount.isVisible(10000, "To Be Completed Count"), "Total number of inspection event with 'to be completed status' is not visible", "Total number of inspection event with 'to be completed status' is not visible!");
        Validator.assertTrue(inspectionGoodCount.isVisible(10000, "Good Card Count"), "Number of inspection items with condition 'good' and status 'to be completed' is not visible!", "Number of inspection items with condition 'good' and status 'to be completed' is  visible!");
        Validator.assertTrue(inspectionFaultCount.isVisible(10000, "Fault Count Card"), "Number of inspection items with condition 'fault' and status 'to be completed' is not visible!", "Number of inspection items with condition 'fault' and status 'to be completed' is  visible!");
        Validator.assertTrue(inspectionPoorCount.isVisible(10000, "Poor Card Count"), "Number of inspection items with condition 'poor' and status 'to be completed' is not visible!", "Number of inspection items with condition 'poor' and status 'to be completed' is  visible!");
        Validator.assertTrue(inspectionCriticalCount.isVisible(10000, "Critical Card Count"), "Number of inspection items with condition 'critical' and status 'to be completed' is not visible!", "Number of inspection items with condition 'critical' and status 'to be completed' is  visible!");
    }

    public void extractInspectionCardDetails() {
        setProperty("inspectionMainCount", inspectionMainCardCount);
        setProperty("inspectionMainToBeCompletedCount", inspectionToBeCompletedCount);
        setProperty("inspectionMainGoodCount", inspectionGoodCount);
        setProperty("inspectionMainCardGoodCount", inspectionGoodCount);
        setProperty("inspectionMainCardFaultCount", inspectionFaultCount);
        setProperty("inspectionMainCardPoorCount", inspectionPoorCount);
        setProperty("inspectionMainCardCriticalCount", inspectionCriticalCount);
    }

    private void setProperty(String propertyName, WebElement element) {
        String value = element.getAttribute("value");
        getBundle().setProperty(propertyName, value);
    }

    public void verifyInspectionHomeCardCount(String condition) {
        // Common counts that are always verified
        Map<String, WebElement> commonCounts = Map.of(
                "inspectionMainCount", inspectionMainCardCount,
                "inspectionMainToBeCompletedCount", inspectionToBeCompletedCount
        );

        // Condition-specific counts
        Map<String, WebElement> conditionCounts = Map.of(
                "Good", inspectionGoodCount,
                "Fault", inspectionFaultCount,
                "Poor", inspectionPoorCount,
                "Critical", inspectionCriticalCount
        );

        // Verify common counts
        commonCounts.forEach((propertyKey, element) ->
                verifyCountUpdate(
                        propertyKey,
                        element,
                        propertyKey + " is not updated after adding a new inspection event",
                        propertyKey + " is updated after adding a new inspection event"
                )
        );

        // Verify condition-specific count
        if (condition != null && !condition.isEmpty()) {
            WebElement element = conditionCounts.get(condition);
            if (element != null) {
                verifyCountUpdate(
                        "inspectionMain" + condition + "Count",
                        element,
                        "Inspection condition with '" + condition + "' count is not updated after adding a new inspection event",
                        "Inspection condition with '" + condition + "' count is updated after adding a new inspection event"
                );
            } else {
                throw new IllegalArgumentException("Invalid condition: " + condition);
            }
        } else {
            // If no specific condition is provided, verify all condition-specific counts
            conditionCounts.forEach((key, element) ->
                    verifyCountUpdate(
                            "inspectionMain" + key + "Count",
                            element,
                            "Inspection condition with '" + key + "' count is not updated after adding a new inspection event",
                            "Inspection condition with '" + key + "' count is updated after adding a new inspection event"
                    )
            );
        }
    }


    public void verifyCountUpdate(String propertyName, WebElement element, String failMessage, String passMessage) {
        int incrementedCount = Integer.parseInt(element.getText());
        int storedCount = Integer.parseInt(getBundle().getProperty(propertyName).toString());
        Validator.assertTrue(
                incrementedCount == storedCount + 1,
                failMessage,
                passMessage
        );
    }


}
