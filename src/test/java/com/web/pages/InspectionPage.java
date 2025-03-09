package com.web.pages;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.common.component.Condition;
import com.common.component.CustomElement;
import com.common.component.InspectionItemSequencing;
import com.common.component.Item;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import groovyjarjarantlr4.v4.codegen.model.Sync;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.*;
import org.testng.Assert;


public class InspectionPage extends BasePage {

	@FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
	public CustomElement lnkHome;

	@FindBy(locator = "xpath=//span[text()='Inspections']")
	public CustomElement lnkInspection;

	@FindBy(locator = "xpath=//h4[text()='Inspection Event']/parent::div//i[contains(@class,'ctp-icon-Inspection-Items-List p-fs-2 items-list')]")
	public CustomElement btnItemlist;

	@FindBy(locator = "xpath=/html/body/app-root/app-layout/div/div[2]/div/app-edit-conveyors/div[1]/div/app-card-sllider/div/div/div[3]/app-card/div/div/div[3]")
	public CustomElement eleInspectiontile;

	@FindBy(locator = "xpath=//div[@class='p-progress-spinner']")
	public CustomElement spinner;

	@FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
	public CustomElement buttonLoader;

	@FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
	public CustomElement btnAddInspection;

	@FindBy(locator = "xpath=//input[@formcontrolname='inspectionName']")
	public CustomElement tbInspectionName;

	@FindBy(locator = "xpath=//label[text()='Site']/following::span[1]")
	public CustomElement ddlSiteCustomername;

	@FindBy(locator = "xpath=//label[text()='Site/Customer Name']/..//input")
	public CustomElement ddlSiteCustomerInput;

	@FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
	public CustomElement tbInput;

	@FindBy(locator = "xpath=//input[@placeholder='mm/dd/yyyy']")
	public CustomElement tbInspectionDate;

	@FindBy(locator = "xpath=//label[text()='Inspector']/..//input")
	public CustomElement ddlInspectorName;

	@FindBy(locator = "xpath=//p-multiselect[@optionlabel='name']//chevrondownicon")
	public CustomElement ddlCollaborators;

	public String ListItem = "//ul[@role='listbox']//li//span";

	@FindBy(locator = "xpath=(//span[text()='Create']/..)[1]")
	public CustomElement createBtnEvent;

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-header')]/..//span[text()='Create']/..")
	public CustomElement createBtnItem;

	@FindBy(locator = "xpath=(//span[text()='Cancel']/..)[1]")
	public CustomElement cancelBtn;

	@FindBy(locator = "xpath=(//span//button[@icon=\"ctp-icon-Add-circle\"])[2]")
	public CustomElement btnAddnew;

	@FindBy(locator = "xpath=//div[@class='jodit-wysiwyg']")
	public CustomElement eleSummary;

	@FindBy(locator = "xpath=//span[@class='total-no']")
	public CustomElement totalEvent;

	@FindBy(locator = "xpath=//h5[text()=' TO BE COMPLETED ']/following-sibling::p//span")
	public CustomElement toBeCompleted;

	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Add-circle')])[2]")
	public CustomElement btAddInspectionItem;

	@FindBy(locator = "xpath=//label[text()='Conveyor']/parent::div//div[@role='button']")
	public CustomElement ddlConveyor;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Conveyor Belt']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetConveyorBelt;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Cleaning Equipment']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetCleaningEquipment;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Rollers/Idlers']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetRollersIdlers;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Pulley']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetPulley;

	@FindBy(locator = "xpath=//h6[text()='Section 5 Chutes/Load Area']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetChutes;

	@FindBy(locator = "xpath=//h6[text()='Section 6 Roller Frames']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetRollerFrames;

	@FindBy(locator = "xpath=//h6[text()='Section 7 Tracking Frames']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetTrackingFrames;

	@FindBy(locator = "xpath=//h6[text()='Section 8 Counterweight']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetCounterweight;

	@FindBy(locator = "xpath=//h6[text()='Section 9 Drive Motor']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetDriveMotor;

	@FindBy(locator = "xpath=//h6[text()='Section 10 Conveyor Structure']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetConveyorStructure;

	@FindBy(locator = "xpath=//h6[text()='Section 11 Other']/following-sibling::div//p[text()='Add New Item']/..")
	public CustomElement ddlAssetOthers;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Tail Pulley']")
	public CustomElement ddlAssetTailPulley;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']")
	public CustomElement ddlAssetBelt;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Other Pulleys']")
	public CustomElement ddlAssetOtherPulley;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Belt Alignment']")
	public CustomElement ddlAssetBeltAlignment;

	@FindBy(locator = "xpath=//h6[text()='Section 5 Idlers']")
	public CustomElement ddlAssetIdlers;

	@FindBy(locator = "xpath=//h6[text()='Section 6 Drive Pulley']")
	public CustomElement ddlAssetDrivePulley;

	@FindBy(locator = "xpath=//label[text()='Conveyor']/parent::div//input")
	public CustomElement ddlConveyorView;

	@FindBy(locator = "xpath=//label[text()='Asset']/parent::div//input")
	public CustomElement ddlAssetView;

	@FindBy(locator = "xpath=//label[text()='Type']/parent::div//div[@role='button']")
	public CustomElement ddlAssetDetail;

	@FindBy(locator = "xpath=//label[text()='Failure Mode']/parent::div//div[@role='button']")
	public CustomElement ddlFailureMode;

	@FindBy(locator = "xpath=//label[text()='Failure Mode']/parent::div//input")
	public CustomElement ddlFailureModeView;

	@FindBy(locator = "xpath=//label[text()='Condition']/parent::div//div[@role='button']")
	public CustomElement ddlCondition;

	@FindBy(locator = "xpath=//label[text()='Condition']/parent::div//input")
	public CustomElement ddlConditionView;

	@FindBy(locator = "xpath=//label[text()='To Be Completed']/preceding-sibling::p-radiobutton")
	public CustomElement ddlStatusToBeCompleted;

	@FindBy(locator = "xpath=//label[text()='To Be Completed']/preceding-sibling::p-radiobutton//input")
	public CustomElement ddlStatusToBeCompletedView;

	@FindBy(locator = "xpath=//label[text()='Completed']/preceding-sibling::p-radiobutton")
	public CustomElement ddlStatusCompleted;

	@FindBy(locator = "xpath=//label[text()='Completed']/preceding-sibling::p-radiobutton//input")
	public CustomElement ddlStatusCompletedView;

	@FindBy(locator = "xpath=//textarea[@formcontrolname='observation']")
	public CustomElement eleObservation;

	@FindBy(locator = "xpath=//label[text()='Observation']/parent::div//textarea")
	public CustomElement eleObservationView;

	@FindBy(locator = "xpath=//textarea[@formcontrolname='recommendation']")
	public CustomElement eleRecommendation;

	@FindBy(locator = "xpath=//label[text()='Recommendation']/parent::div//textarea")
	public CustomElement eleRecommendationView;

	@FindBy(locator = "xpath=//span[text()='Save']")
	public CustomElement btnSave;
	@FindBy(locator = "xpath=//p-dialog//span[text()='Save']")
	public CustomElement btnDialogSave;

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-footer')]//span[text()='Save']")
	public CustomElement btnSaveItem;

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

	@FindBy(locator = "xpath=//button[@icon='pi pi-refresh']/parent::div[not(@class)]")
	public CustomElement cbRefresh;

	@FindBy(locator="xpath=(//td//p-tablecheckbox)[1]//input")
	public CustomElement cbCheckboxInput;

	@FindBy(locator="xpath=(//button/chevrondownicon)[2]")
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

	@FindBy(locator = "xpath=//button[text()='Select Files']")
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

	@FindBy(locator = "xpath=//label[text()='Asset']/../following-sibling::div[1]/div/div[1]/label")
	public CustomElement ddlAssetDetailField;

	@FindBy(locator = "xpath=//label[text()='Asset']/../following-sibling::div[1]/div/div[1]//input")
	public CustomElement ddlAssetDetailInput;

	@FindBy(locator = "xpath=//label[text()='Asset']/../following-sibling::div[1]/div/div[2]//input")
	public CustomElement ddlFailureModeInput;

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

	@FindBy(locator = "xpath=(//div//button//span[contains(@class,'ctp-icon-Technical-Data')])[2]/..")
	public CustomElement inspectionGroupView;

	@FindBy(locator = "xpath=(//div//button//span[contains(@class,'ctp-icon-detail-report')])[2]/..")
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

	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Add-circle')])[2]")
	public CustomElement btAddInspection;

	@FindBy(locator = "xpath=//td[contains(@class,'p-datepicker-today')]")
	public CustomElement btTodayDate;

	@FindBy(locator = "xpath=//input[contains(@class,'p-multiselect-filter')]")
	public CustomElement tbMultipleDropdown;

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

	@FindBy(locator = "xpath=//app-image-viewer[@cssclassname='zoom-image']")
	public CustomElement imgWindow;

	@FindBy(locator = "xpath=//i[@class='pi pi-search-minus']")
	public CustomElement appImgMinimize;

	@FindBy(locator = "xpath=//i[@class='pi pi-search-plus']")
	public CustomElement appImgMaximize;

	@FindBy(locator = "xpath=//div[contains(@class,'zoom-controls')]/../..//button[contains(@class,'p-dialog-header-icon')]")
	public CustomElement imgClose;

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

	@FindBy(locator = "xpath=//div[contains(@class,'p-dialog-header')]/span")
	public CustomElement popupHeader;

	@FindBy(locator = "xpath=//div[text()='Failed to update inspection: Unauthorized']")
	public CustomElement inspectionAddErrorMsg;

	@FindBy(locator = "xpath=//timesicon")
	public CustomElement crossButton;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//span)[1]")
	public CustomElement txtInspCount;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/following-sibling::p-skeleton)[1]")
	public CustomElement txtInspCardLoader;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//span)[2]")
	public CustomElement txtInspCompleteCount;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//div[contains(@class,'footer-count')]/div)[1]")
	public CustomElement txtInspGoodCount;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//div[contains(@class,'footer-count')]/div)[2]")
	public CustomElement txtInspFaultCount;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//div[contains(@class,'footer-count')]/div)[3]")
	public CustomElement txtInspPoorCount;

	@FindBy(locator = "xpath=(//app-card//div[text()='Inspections']/..//div[contains(@class,'footer-count')]/div)[4]")
	public CustomElement txtInspCriticalCount;

	@FindBy(locator = "xpath=//div[@class='sub-table-status ng-star-inserted']")
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

	@FindBy(locator="xpath=//app-image-viewer[@cssclassname=\"wrapper-image\"]")
	public CustomElement uploadedImage;

	@FindBy(locator="xpath=//button[contains(@icon,\"ctp-icon-Delete\")]")
	public CustomElement deleteBtn;

	@FindBy(locator="xpath=//li//span[text()='Export PDF']")
	public CustomElement btnExportInspection;

	@FindBy(locator="xpath=//span[contains(@class,'ctp-icon-File-PDF')]")
	public CustomElement btnExportPDFIcon;

	@FindBy(locator="xpath=//app-confirmation-dialog")
	public CustomElement deleteDialogbox;

	@FindBy(locator="xpath=//span[text()='Yes']/..")
	public CustomElement confirmBtn;

	@FindBy(locator="xpath=//span[text()='CV Common Regression']")
	public CustomElement conveyorBreadCrumb;

	@FindBy(locator="xpath=//span[text()=\"Cust Automation Common India\"]")
	public CustomElement siteBreadCrumb;

	@FindBy(locator="xpath=//span[text()=\"Cust Automation Common Corp\"]")
	public CustomElement corpBreadCrumb;

	@FindBy(locator="xpath=//img[@src=\"/assets/img/upload_default.png\"]")
	public CustomElement defaultImage;
	@FindBy(locator="xpath=//input[@id=\"file-input\"]")
	public CustomElement fileInput;

	@FindBy(locator="xpath=//p-breadcrumb[.//*[self::span[text()='Technical Data']]]")
	public CustomElement technicalDataHeader;

	@FindBy(locator="xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Cust Automation Common India')]]")
	public CustomElement siteHeader;

	@FindBy(locator="xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Cust Automation Common Corp')]]")
	public CustomElement corpHeader;

	@FindBy(locator="xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Corporates')]]")
	public CustomElement headerCorporate;

	@FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
	public CustomElement paginationEntry;

	@FindBy(locator="xpath=//p-paginator//button[@aria-label='Next Page']")
	public CustomElement btNextPage;

	@FindBy(locator="xpath=//p-paginator//button[@aria-label='Last Page']")
	public CustomElement btLastPage;

	@FindBy(locator="xpath=//span/button[@aria-current='page']")
	public CustomElement btCurrentPage;

	@FindBy(locator="xpath=//div[@aria-label='dropdown trigger']/preceding-sibling::span")
	public CustomElement btPageLimit;

	@FindBy(locator="xpath=//div[@aria-label='dropdown trigger']")
	public CustomElement btPageDropdown;

	@FindBy(locator = "xpath=//div[text()='Error'")
	public CustomElement inspectionErrorMsg;

	@FindBy(locator = "xpath=(//span[text()=\"Corporates\"])[2]")
	public CustomElement corporateLink;

	@FindBy(locator="xpath=(//div[@class='card-inner-wrapper' and contains(div, 'Inspections')])[1]")
	public CustomElement btInspectionCard;

	@FindBy(locator = "xpath=//span[text()='Inspections']")
	public CustomElement txtInspectionEvent;

	@FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
	public CustomElement btviewicon;

	@FindBy(locator="xpath=(//app-card//div[text()='Sites' or text()='Shops'] /..//span)[1]")
	public CustomElement btSiteShopCardNo;

	@FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Bar-Chart')])[2]")
	public CustomElement iconBarChart;

	@FindBy(locator= "xpath=//p-card//div[text()=' GOOD ']/../div/span")
	public CustomElement statusCardGoodCount;

	@FindBy(locator= "xpath=//p-card//div[text()=' TOTAL ']/../div/span")
	public CustomElement statusCardTotalCount;

	@FindBy(locator= "xpath=//p-card//div[text()=' POOR ']/../div/span")
	public CustomElement statusCardPoorCount;

	@FindBy(locator= "xpath=//p-card//div[text()=' FAULT ']/../div/span")
	public CustomElement statusCardFaultCount;

	@FindBy(locator= "xpath=//p-card//div[text()=' CRITICAL ']/../div/span")
	public CustomElement statusCardCriticalCount;

	@FindBy(locator= "xpath= //p-card//div[text()=' GOOD ']")
	public CustomElement cardStatusGood;

	@FindBy(locator= "xpath= //p-card//div[text()=' FAULT '] ")
	public CustomElement cardStatusFault;

	@FindBy(locator= "xpath= //p-card//div[text()=' POOR ']")
	public CustomElement cardStatusPoor;

	@FindBy(locator= "xpath= //p-card//div[text()=' CRITICAL ']")
	public CustomElement cardStatusCritical;

	@FindBy(locator= "xpath= //p-card//div[text()=' TOTAL ']")
	public CustomElement cardStatusTotal;

	@FindBy(locator= "xpath= //div//label[text()='Select Site']/..//p-multiselect[@optionvalue='companyId']")
	public CustomElement ddlSiteDropdown;

	@FindBy(locator= "xpath=//label[text()='Site']/..//input")
	public CustomElement ddlSiteDropdownView;

	@FindBy(locator= "xpath=//div[contains(@class,'p-multiselect-panel')]//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
	public CustomElement tbMultipleSiteDropdwn;

	@FindBy(locator= "xpath=//div[contains(@aria-label,'All items')]")
	public CustomElement ddlMultipleSelection;

	@FindBy(locator= "xpath=(//p-multiselectitem//checkicon/..)[1]")
	public CustomElement inspectionItemFilterCheckbox;

	@FindBy(locator="xpath=//button[contains(@class,'p-multiselect-close')]")
	public CustomElement multiSelectCloseBtn;

	@FindBy(locator="xpath=//button//span[text()='Actions']")
	public CustomElement btnActions;

	@FindBy(locator = "xpath=//span[text()='Clear Filters']")
	public CustomElement clearFilterBtn;

	@FindBy(locator= "xpath=(//p-multiselect)[1]")
	public CustomElement columnSelectionBtn;

	@FindBy(locator="xpath=//div[@title='Bold']")
	public CustomElement btBold;

	@FindBy(locator="xpath=//div[@title='Italic']")
	public CustomElement btItalics;

	@FindBy(locator="xpath=//div[@title='Underline']")
	public CustomElement btUnderline;

	@FindBy(locator="xpath=//div[@title='Bullet List']")
	public CustomElement btList;

	@FindBy(locator="xpath=//div[contains(@class,'ProseMirror')]/p/strong")
	public CustomElement boldLetters;

	@FindBy(locator="xpath=//div[contains(@class,'ProseMirror')]/p/em")
	public CustomElement italicsLetters;

	@FindBy(locator="xpath=//div[contains(@class,'ProseMirror')]/p//u")
	public CustomElement underlineLetters;

	@FindBy(locator="xpath=//div[contains(@class,'ProseMirror')]/ul")
	public CustomElement listLetters;

	@FindBy(locator="xpath=//div[@title='Head']")
	public CustomElement headMapPointer;

	@FindBy(locator="xpath=//div[@title='Tail']")
	public CustomElement tailMapPointer;

	@FindBy(locator="xpath=//div[@role='dialog']")
	public CustomElement mapLocationDialog;

	@FindBy(locator="xpath=//div[@role='dialog']//button")
	public CustomElement mapLocationDialogClose;

	@FindBy(locator="xpath=//p-columnfilterformelement//input")
	public CustomElement inspectionFilterInput;

	@FindBy(locator="xpath=//p-columnfilterformelement//div[contains(text(),'')]/../following-sibling::div[@class='p-multiselect-trigger']")
	public CustomElement inspectionFilterDropdown;

	@FindBy(locator="xpath=//p-columnfilterformelement//span/following-sibling::div[@class='p-dropdown-trigger']")
	public CustomElement inspectionStatusFilterDropdown;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspectionName']//button")
	public CustomElement inspectionDetailsItemNameFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspectionDate']//button")
	public CustomElement inspectionDetailsItemDateFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='site.customerCorporate.name']//button")
	public CustomElement inspectionDetailsItemCorporateFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='site.name']//button")
	public CustomElement inspectionDetailsItemSiteFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='conveyorInInspections']//button")
	public CustomElement inspectionDetailsItemConveyorFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspector.name']//button")
	public CustomElement inspectionDetailsItemInspectorFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='updatedDate']//button")
	public CustomElement inspectionDetailsItemLastModifiedFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='itemCondition']//button")
	public CustomElement inspectionDetailsItemConditionFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspectionComplitionStatus']//button")
	public CustomElement inspectionDetailsItemStatusFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspectionName']//button")
	public CustomElement inspectionItemNameFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspectionDate']//button")
	public CustomElement inspectionItemDateFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='site.customerCorporate.name']//button")
	public CustomElement inspectionItemCorporateFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='site.name']//button")
	public CustomElement inspectionItemSiteFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='conveyor.name']//button")
	public CustomElement inspectionItemConveyorFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='inspector.name']//button")
	public CustomElement inspectionItemInspectorFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='updatedDate']//button")
	public CustomElement inspectionItemLastModifiedFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='asset.name']//button")
	public CustomElement inspectionItemAssetFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='condition']//button")
	public CustomElement inspectionItemConditionFilter;

	@FindBy(locator="xpath=//p-columnfilter[@field='status']//button")
	public CustomElement inspectionItemStatusFilter;

	@FindBy(locator="xpath=//span[text()='Apply']")
	public CustomElement applyFilter;

	@FindBy(locator="xpath=//button[contains(@class,'p-datepicker-prev')]")
	public CustomElement calendarPrev;

	@FindBy(locator="xpath=//button[contains(@class,'p-datepicker-next')]")
	public CustomElement calendarNext;

	@FindBy(locator="xpath=//button[contains(@class,'p-datepicker-month')]")
	public CustomElement calendarMonth;

	@FindBy(locator="xpath=//button[contains(@class,'p-datepicker-year')]")
	public CustomElement calendarYear;

	@FindBy(locator="xpath=(//i[@pbadge and contains(@class,'Open')])[1]/span")
	public CustomElement statusIncompleteIcon;

	@FindBy(locator="xpath=//i[contains(@class,'complete')]")
	public CustomElement statusCompleteIcon;

	@FindBy(locator="xpath=(//div[text()='To Be Completed'])[1]")
	public CustomElement statusIncomplete;

	@FindBy(locator="xpath=(//div[text()='Completed'])[1]")
	public CustomElement statusComplete;

	@FindBy(locator="id=number")
	public CustomElement numberColumn;

	@FindBy(locator="id=photo")
	public CustomElement pictureColumn;

	@FindBy(locator="id=conveyor")
	public CustomElement conveyorColumn;

	@FindBy(locator="id=asset")
	public CustomElement assetColumn;

	@FindBy(locator="id=detail")
	public CustomElement detailColumn;

	@FindBy(locator="id=mode")
	public CustomElement failureModeColumn;

	@FindBy(locator="id=location")
	public CustomElement locationColumn;

	@FindBy(locator="id=condition")
	public CustomElement conditionColumn;

	@FindBy(locator="id=status")
	public CustomElement statusColumn;

	@FindBy(locator="id=more")
	public CustomElement moreColumn;

	@FindBy(locator="id=tablenumber")
	public CustomElement numberColumnExpand;

	@FindBy(locator="id=photo")
	public CustomElement pictureColumnExpand;

	@FindBy(locator="id=conveyorname")
	public CustomElement conveyorColumnExpand;

	@FindBy(locator="id=assetname")
	public CustomElement assetColumnExpand;

	@FindBy(locator="id=itemdDetail")
	public CustomElement detailColumnExpand;

	@FindBy(locator="id=itemdFailureMode")
	public CustomElement failureModeColumnExpand;

	@FindBy(locator="id=labellocation")
	public CustomElement locationColumnExpand;

	@FindBy(locator="id=labelcondition")
	public CustomElement conditionColumnExpand;

	@FindBy(locator="id=labelstatus")
	public CustomElement statusColumnExpand;

	@FindBy(locator="id=beforemore")
	public CustomElement moreColumnExpand;

	@FindBy(locator="id=photo")
	public CustomElement pictureColumnItemList;

	@FindBy(locator="id=inspectiondate")
	public CustomElement inspectionDateItemList;

	@FindBy(locator="id=corporate")
	public CustomElement corporateColumnItemList;

	@FindBy(locator="id=sitename")
	public CustomElement siteColumnItemList;

	@FindBy(locator="id=conveyorname")
	public CustomElement conveyorColumnItemList;

	@FindBy(locator="id=inspectionname")
	public CustomElement inspectorColumnItemList;

	@FindBy(locator="id=assetname")
	public CustomElement assetColumnItemList;

	@FindBy(locator="id=detailDescription")
	public CustomElement detailColumnItemList;

	@FindBy(locator="id=failureDescription")
	public CustomElement failureModeColumnItemList;

	@FindBy(locator="id=updateddate")
	public CustomElement modifiedDateColumnItemList;

	@FindBy(locator="id=condition")
	public CustomElement conditionColumnItemList;

	@FindBy(locator="id=status")
	public CustomElement statusColumnItemList;

	@FindBy(locator="id=inventoryStatus")
	public CustomElement moreColumnItemList;

	@FindBy(locator = "xpath=//span[contains(@class,'p-dialog-title')]")
	public CustomElement itemDialogTitle;

	@FindBy(locator = "xpath=//i[@class='ctp-icon-unit']/..")
	public CustomElement unitConv;

	@FindBy(locator = "xpath=//div/h6[text()='Imperial']/../../p-radiobutton")
	public CustomElement imperial;

	@FindBy(locator = "xpath=//div/h6[text()='Metric']/../../p-radiobutton")
	public CustomElement metric;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Tail Pulley']/../div/div[1]//p[text()='Lagging Condition']")
	public CustomElement laggingConditionTail;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Tail Pulley']/../div/div[2]//p[text()='v-Plow Wiper Rubber Condition']")
	public CustomElement wiperConditionTail;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Tail Pulley']/../div/div[3]//p[text()='Skirt Rubber Condition']")
	public CustomElement skirtConditionTail;

	@FindBy(locator = "xpath=//h6[text()='Section 1 Tail Pulley']/../div/div[4]//p[text()='Load Zone']")
	public CustomElement loadZoneTail;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']/../div/div[1]//p[text()='Splice condition -1']")
	public CustomElement spliceCondition1Belt;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']/../div/div[2]//p[text()='Splice condition -2']")
	public CustomElement spliceCondition2Belt;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']/../div/div[3]//p[text()='Top Cover wear']")
	public CustomElement topCoverBelt;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']/../div/div[4]//p[text()='Bottom Cover Wear']")
	public CustomElement bottomCoverBelt;

	@FindBy(locator = "xpath=//h6[text()='Section 2 Belt']/../div/div[5]//p[text()='Visible Damage']")
	public CustomElement visibleDamageBelt;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Other Pulleys']/../div/div[1]//p[text()='High Tension Takeup']")
	public CustomElement tensionTakeUp;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Other Pulleys']/../div/div[2]//p[text()='Snub Pulley']")
	public CustomElement snubPulleyTakeUp;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Other Pulleys']/../div/div[3]//p[text()='Bin Pulley']")
	public CustomElement binPulleyTakeUp;

	@FindBy(locator = "xpath=//h6[text()='Section 3 Other Pulleys']/../div/div[4]//p[text()='Counterweight']")
	public CustomElement counterWeightTakeUp;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Belt Alignment']/../div/div[1]//p[text()='Take-up']")
	public CustomElement takeUpBeltAlignment;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Belt Alignment']/../div/div[2]//p[text()='Head Pulley']")
	public CustomElement headBeltAlignment;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Belt Alignment']/../div/div[3]//p[text()='Tail']")
	public CustomElement tailBeltAlignment;

	@FindBy(locator = "xpath=//h6[text()='Section 4 Belt Alignment']/../div/div[4]//p[text()='Overall']")
	public CustomElement overallBeltAlignment;

	@FindBy(locator = "xpath=//h6[text()='Section 5 Idlers']/../div/div[1]//p[text()='Broken/Frozen']")
	public CustomElement brokenIdler;

	@FindBy(locator = "xpath=//h6[text()='Section 6 Drive Pulley']/../div/div[1]//p[text()='Lagging Condition']")
	public CustomElement laggingConditionDrive;

	@FindBy(locator = "xpath=//h6[text()='Section 6 Drive Pulley']/../div/div[2]//p[text()='Primary Cleaner Condition']")
	public CustomElement primaryConditionDrive;

	@FindBy(locator = "xpath=//h6[text()='Section 6 Drive Pulley']/../div/div[3]//p[text()='Secondary Cleaner Condition']")
	public CustomElement secondaryConditionDrive;

	@FindBy(locator = "xpath=//p[contains(text(),'Fault - Off-L or Off-R')]")
	public CustomElement beltAlignmentDetailsMsg1;

	@FindBy(locator = "xpath=//p[contains(text(),'Good - Centered')]")
	public CustomElement beltAlignmentDetailsMsg2;

	@FindBy(locator = "xpath=//p[contains(text(),'Critical - Broken, imminent threat to belt or safety')]")
	public CustomElement generalDetailsMsg1;

	@FindBy(locator = "xpath=//p[contains(text(),'Fault - Frozen, not critical')]")
	public CustomElement generalDetailsMsg2;

	@FindBy(locator = "xpath=//p[contains(text(),'Good - Operating within specification')]")
	public CustomElement generalDetailsMsg3;

	@FindBy(locator = "xpath=//label[text()='Observation']/em")
	public CustomElement observationAsterisk;

	@FindBy(locator = "xpath=//google-map//*[@class='gm-style']")
	public CustomElement googleMap;

	@FindBy(locator = "xpath=(//app-inspection-dashboard-view//span)[1]")
	public CustomElement dashboardHeader;

	@FindBy(locator="xpath=//p-multiselect[@formcontrolname='site']//chevrondownicon")
	public CustomElement siteDashboardFilter;

	@FindBy(locator= "xpath=//p-multiselect[@formcontrolname='site']//div[@class='p-multiselect-label']")
	public CustomElement tbSiteDropdownView;

	@FindBy(locator= "xpath=//input[contains(@class,'p-multiselect-filter')]")
	public CustomElement tbSiteDropdownInput;

	@FindBy(locator="xpath=//p-calendar[@formcontrolname='inspectionStartDate']")
	public CustomElement inspectionStartDateView;

	@FindBy(locator="xpath=//p-calendar[@formcontrolname='inspectionEndDate']")
	public CustomElement inspectionEndDateView;

	@FindBy(locator="xpath=//p-calendar[@formcontrolname='inspectionStartDate']//input")
	public CustomElement inspectionStartDate;

	@FindBy(locator="xpath=//p-calendar[@formcontrolname='inspectionEndDate']//input")
	public CustomElement inspectionEndDate;

	@FindBy(locator = "xpath=//div[contains(text(),'TOTAL')]/../../div[@class='p-card-body']//span")
	public CustomElement txtDashboardTotalCount;

	@FindBy(locator = "xpath=//div[contains(text(),'GOOD')]/../../div[@class='p-card-body']//span")
	public CustomElement txtDashboardGoodCount;

	@FindBy(locator = "xpath=//div[contains(text(),'FAULT')]/../../div[@class='p-card-body']//span")
	public CustomElement txtDashboardFaultCount;

	@FindBy(locator = "xpath=//div[contains(text(),'POOR')]/../../div[@class='p-card-body']//span")
	public CustomElement txtDashboardPoorCount;

	@FindBy(locator = "xpath=//div[contains(text(),'CRITICAL')]/../../div[@class='p-card-body']//span")
	public CustomElement txtDashboardCriticalCount;

	@FindBy(locator = "xpath=//p-card//h6[text()='INSPECTION ITEMS BY STATUS']")
	public CustomElement inspectionItemStatusPieChart;

	@FindBy(locator = "xpath=//p-card//h6[text()='INSPECTION ITEMS BY ASSET']")
	public CustomElement inspectionItemAssetPieChart;

	@FindBy(locator = "xpath=//div[contains(text(),'Asset')]/..")
	public CustomElement assetsCol;

	@FindBy(locator = "xpath=//div[contains(text(),'Failure Mode')]/..")
	public CustomElement failureModeCol;

	@FindBy(locator = "xpath=//div[contains(text(),'Inspection Item %')]/..")
	public CustomElement inspectionItemPercentageCol;

	@FindBy(locator = "xpath=//div[contains(text(),'Inspection Item Σ')]/..")
	public CustomElement inspectionItemCol;

	public void goToInspection() {
		if(!lnkInspection.isVisible())
			lnkHome.click("Home");
		waitForElementVisible(lnkInspection, 10000,500);
		lnkInspection.jsClick();
		waitForPageLoad(10000);
		waitForElementVisible(btSearchinput,5000,500);
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
		waitForElementVisible(btnAddInspection,20000,1000);
		waitForElementToBeClickable(btnAddInspection);
		SyncUtil.waitFor(1000);
		btnAddInspection.jsClick("Add Inspection btn");
		waitForElementToBeClickable(ddlSiteCustomername);
		waitForElementVisible(ddlSiteCustomername,8000,1000);
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		tbInspectionName.type(inspectionName);
//		dropdownselectsearch(ddlConveyor, tbInput, conveyorName);
//		ddlInspectorName.verifyText(fullName,"Inspector Name");
		System.out.println(ddlInspectorName.getAttribute("value"));
		Validator.assertTrue(ddlInspectorName.getAttribute("value").equalsIgnoreCase(fullName),"Inspector Name mismatched","Inspector Name matched");
		Reporter.log("Inspection is created",MessageTypes.Pass);
	}

	public void addInspection(String inspectionName) {
		btnAddInspection.jsClick("Add Inspection btn");
		tbInspectionName.type(inspectionName);
		Reporter.log("Inspection is created", MessageTypes.Pass);
	}

	public void saveInspectionItem() {
		waitForElementToBeClickable(btnSaveItem);
		btnSaveItem.click("Save");
		waitForElementToDisplay(inspectionUpdateMsg);
		Reporter.log("Inspection Item is created", MessageTypes.Pass);
	}

	public void createInspectionItem() {
		if(createBtnItem.isVisible()) {
			waitForElementToBeClickable(createBtnItem);
			createBtnItem.click("Save");
		}
		else{
			waitForElementToBeClickable(btnSaveItem);
			btnSaveItem.click("Save");
		}
		waitForElementToDisplay(inspectionUpdateMsg);
		waitForElementToInvisible(spinner,15000);
		Reporter.log("Inspection Item is created", MessageTypes.Pass);
	}

	public void addItemMandatoryField(String conveyorName, String assetName, String assetDetail, String failureMode, String condition, String status) {
		waitForElementToBeClickable(btnAddInspection);
		waitForElementToInvisible(spinner,10000);
		btnAddInspection.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		defaultAssetTemplateSelection(assetName);
		Validator.assertTrue(!ddlConveyorView.isEnabled()," Conveyor dropdown for add item popup is not disabled", "Conveyor dropdown for add item popup is verified successfully");
		Validator.assertTrue(!ddlAssetView.isEnabled()," Asset name dropdown for add item popup is not disabled", "Asset name dropdown for add item popup is verified successfully");
		if (ddlDetails.isVisible())
			dropdownSelect(ddlDetails, ListItem, assetDetail);
		if (ddlTypes.isVisible())
			dropdownSelect(ddlTypes, ListItem, assetDetail);
		if (ddlDetailInput.isVisible())
			ddlDetailInput.type(assetDetail);
		if (!(ddlAssetDetailField.getText().contains("Type") || ddlAssetDetailField.getText().contains("Detail")))
			ddlAssetDetailInput.type(assetDetail);
		if(ddlFailureMode.isVisible())
			dropdownSelectSearch(ddlFailureMode, tbInput, failureMode);
		else ddlFailureModeInput.type(failureMode);
		dropdownSelect(ddlCondition, ListItem, condition);
		if(status.equalsIgnoreCase("completed"))
			ddlStatusCompleted.click();
		else ddlStatusToBeCompleted.click();
	}

	private void defaultAssetTemplateSelection(String asset){
		switch (asset) {
			case "Conveyor Belt":
				ddlAssetConveyorBelt.click();
				break;
			case "Cleaning Equipment":
				ddlAssetCleaningEquipment.click();
				break;
			case "Rollers/Idlers":
				ddlAssetRollersIdlers.click();
				break;
			case "Pulley":
				ddlAssetPulley.click();
				break;
			case "Chutes/Load Area":
				ddlAssetChutes.click();
				break;
			case "Roller Frames":
				ddlAssetRollerFrames.click();
				break;
			case "Tracking Frames":
				ddlAssetTrackingFrames.click();
				break;
			case "Counterweight":
				ddlAssetCounterweight.click();
				break;
			case "Drive Motor":
				ddlAssetDriveMotor.click();
				break;
			case "Conveyor Structure":
				ddlAssetConveyorStructure.click();
				break;
			default:
				ddlAssetOthers.click();
				break;
		}
	}

	public void addItemMandatoryFieldVMC(String conveyorName, String assetName, String assetDetail, String condition, String status, String... observation) {
		waitForElementToBeClickable(btnAddInspection);
		SyncUtil.waitFor(4000);
		btnAddInspection.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		assetVMCTemplateSelection(assetName, assetDetail);
		Validator.assertTrue(!ddlConveyorView.isEnabled()," Conveyor dropdown for add item popup is not disabled", "Conveyor dropdown for add item popup is verified successfully");
		Validator.assertTrue(!ddlAssetView.isEnabled()," Asset name dropdown for add item popup is not disabled", "Asset name dropdown for add item popup is verified successfully");
		Validator.assertTrue(!ddlAssetView.isEnabled(),"Asset detail dropdown for add item popup is not disabled", "Asset detail dropdown for add item popup is verified successfully");
		dropdownSelect(ddlCondition, ListItem, condition);
		if(status.equalsIgnoreCase("completed"))
			ddlStatusCompleted.click();
		else ddlStatusToBeCompleted.click();
		if(!condition.equalsIgnoreCase("good"))
			eleObservation.type(observation[0]);
	}

	private void assetVMCTemplateSelection(String asset, String detail){
		switch (asset) {
			case "Tail Pulley":
				driver.findElement(By.xpath("//h6[text()='Section 1 Tail Pulley']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			case "Belt":
				driver.findElement(By.xpath("//h6[text()='Section 2 Belt']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			case "Other Pulleys":
				driver.findElement(By.xpath("//h6[text()='Section 3 Other Pulleys']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			case "Belt Alignment":
				driver.findElement(By.xpath("//h6[text()='Section 4 Belt Alignment']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			case "Idlers":
				driver.findElement(By.xpath("//h6[text()='Section 5 Idlers']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			case "Drive Pulley":
				driver.findElement(By.xpath("//h6[text()='Section 6 Drive Pulley']/following-sibling::div//p[text()='"+detail+"']")).click();
				break;
			default:
				break;
		}
	}

	private boolean isVMCDuplicateTemplateSelection(String asset, String detail){
		switch (asset) {
			case "Tail Pulley":
				return isLocatorVisible(By.xpath("//h6[text()='Section 1 Tail Pulley']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 1 Tail Pulley']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			case "Belt":
				return isLocatorVisible(By.xpath("//h6[text()='Section 2 Belt']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 2 Belt']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			case "Other Pulleys":
				return isLocatorVisible(By.xpath("//h6[text()='Section 3 Other Pulleys']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 3 Other Pulleys']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			case "Belt Alignment":
				return isLocatorVisible(By.xpath("//h6[text()='Section 4 Belt Alignment']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 4 Belt Alignment']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			case "Idlers":
				return isLocatorVisible(By.xpath("//h6[text()='Section 5 Idlers']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 5 Idler']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			case "Drive Pulley":
				return isLocatorVisible(By.xpath("//h6[text()='Section 6 Drive Pulley']/following-sibling::div//span[@class='ctp-icon-add_circle_outline']/following-sibling::p[text()='"+detail+"']")) && !isLocatorVisible(By.xpath("//h6[text()='Section 6 Drive Pulley']/following-sibling::div//span[@class='ctp-icon-pencil']/following-sibling::p[text()='"+detail+"']"));
			default:
				return false;
		}
	}


	public String getInspectorNameFromItem() {
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(4000);
		btnAddnew.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		return ddlInspectorName.getText();
	}

	public String getConveyorHeaderFromItem() {
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(4000);
		btnAddnew.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		return popupHeader.getText();
	}

	public boolean isMapHeader() {
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(4000);
		btnAddnew.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		return headMapPointer.isVisible() && tailMapPointer.isVisible();
	}

	public boolean isLocationLabel() {
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(4000);
		btnAddnew.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		new ConveyorPage().clickOnMap();
		SyncUtil.waitFor(2000);
		new ConveyorPage().clickOnMap();
		boolean flag = mapLocationDialog.isVisible();
		mapLocationDialogClose.click();
		return flag && !mapLocationDialogClose.isVisible();
	}

//	public void verifyLonLatFromItem() {
//		waitForElementToBeClickable(btnAddnew);
//		SyncUtil.waitFor(4000);
//		btnAddnew.click("Add New Inspection");
//		waitForElementToDisplay(ddlConveyor);
//		Validator.assertFalse(tbLat.getAttribute("class").contains("p-filled"),"Latitude field is already prefilled","Latitude field is verified successfully");
//		Validator.assertFalse(tbLong.getAttribute("class").contains("p-filled"),"Longitude field is already prefilled","Longitude field is verified successfully");
//		new ConveyorPage().clickOnMap();
//		Validator.assertTrue(tbLat.getAttribute("class").contains("p-filled"),"Latitude field is not filled after click on map","Latitude field is verified successfully");
//		Validator.assertTrue(tbLong.getAttribute("class").contains("p-filled"),"Longitude field is not filled after click on map","Longitude field is verified successfully");
//		tbLat.clear();
//		tbLat.sendKeys("123");
//		System.out.println(tbLat.getAttribute("value"));
//		Validator.assertTrue(tbLat.getAttribute("value").equalsIgnoreCase("123"),"Latitude field did not enter given value","Latitude field is verified successfully");
//		tbLong.clear();
//		tbLong.sendKeys("456");
//		Validator.assertTrue(tbLong.getAttribute("value").equalsIgnoreCase("456"),"Latitude field did not enter given value","Latitude field is verified successfully");;
//	}

	public void addItemOptionalField(String observation, String recommendation, String address, String img) {
		eleObservation.type(observation, "Observation");
		eleRecommendation.type(recommendation, "Recommendation");
		if (eleAddress.isVisible())
			eleAddress.type(address, "Address");
		if(address.equalsIgnoreCase("click"))
			googleMap.jsClick("google map");
		String file_path = ClasspathResourceHelper.getPropertyFile(img, "test_files").getAbsolutePath();
		btnUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btSpinner, 30000);
//		appImgViewer.isVisible("App Image Viewer");
	}

	public void addItemOptionalFieldVMC(String recommendation, String address, String img) {
		eleRecommendation.type(recommendation, "Recommendation");
		if (eleAddress.isVisible())
			eleAddress.type(address, "Address");
		if(address.equalsIgnoreCase("click"))
			googleMap.jsClick("google map");
		String file_path = ClasspathResourceHelper.getPropertyFile(img, "test_files").getAbsolutePath();
		btnUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btSpinner, 30000);
//		appImgViewer.isVisible("App Image Viewer");
	}

	public void goToInspectionDetailScreen(String inspectionName) {
		searchInspection(inspectionName);
		waitForElementVisible(detailIcon,10000,500);
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		inspectionHeader.verifyText("Inspection Event", "Inspection Header");
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
		waitForElementToInvisible(buttonLoader,5000);
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
		waitForElementToInvisible(spinner,20000);
		SyncUtil.waitFor(5000);
		Reporter.log("PDF is downloaded", MessageTypes.Pass);
	}

	public void verifyInspection(String inspectionName, String itemCount) {
		Validator.assertTrue(searchInspection(inspectionName), "Inspection event is not found", "Inspection event is found");
		waitForElementToDisplay(detailIcon);
		ddViewicon.click("Inspection Detail");
		waitForElementToInvisible(spinner,10000);
		inspectionHeader.verifyText("Inspection Event", "Inspection Header");
		Integer inspectionCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		Validator.assertTrue(inspectionCount.toString().equalsIgnoreCase(itemCount), "All Inspections Items are not listed", "All Inspections Items are listed");
	}

	public void verifyPDFContents(String fullName, String custSiteName, String conveyorName, String inspectionName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains(fullName), "PDF Report was generated for the wrong inspector", "PDF Report was generated for the right inspector");
			Validator.assertTrue(val.contains(custSiteName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
			Validator.assertTrue(val.contains(conveyorName) || val.contains("Multiple"), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
			Validator.assertTrue(val.contains(inspectionName), "PDF Report was generated for the wrong inspection", "PDF Report was generated for the right inspection");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyInspectionDashboardContents(String custSiteName,String corp) {
		PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+ corp+"-inspection-dashboard.pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains(custSiteName),"PDF Report was generated for the wrong customer Site","PDF Report was generated for the right customer Site");
		}catch(Exception e){
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

	public void editInspectionFromViewMode(String inspectionName) {
		searchInspection(inspectionName);
		ddViewicon.click();
		waitForElementToInvisible(spinner,3000);
		btnEdit.isVisible("Edit");
		btnEdit.click("edit Btn");
		waitForElementToInvisible(spinner,3000);
		btnSave.isVisible("Save");
	}

	public void editInspectionName(String inspectionName, String newInspName) {
		editInspection(inspectionName);
		waitForElementToInvisible(spinner,5000);
		tbInspectionName.type(newInspName);
		SyncUtil.waitFor(2000);
		saveInspectionEvent();
	}

	public void editInspectionItem(String inspectionItem, String newStatus) {
		btSearchinput.type(inspectionItem, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		btnEdit.click("Edit Inspection Item");
//		itemDialogTitle.verifyText("Edit Inspection Item - "+inspectionItem);
		itemDialogTitle.verifyPartialText(false,"Edit Inspection Item - ",2000);
		if(newStatus.equalsIgnoreCase("completed"))
			ddlStatusCompleted.click();
		else ddlStatusToBeCompleted.click();
		btnSaveItem.click("Save");
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
		btnDeleteInspection.click("Delete Inspection Item");
		btnYes.click("Confirm delete");
		waitForElementToInvisible(buttonLoader,5000);
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
	}

	public void saveInspectionEvent() {
		waitForElementToBeClickable(btnSave);
		btnSave.jsClick("Save Inspection Event");
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
		scrollPageup();
		inspectionGroupView.click("List View");
		SyncUtil.waitFor(2000);
		return inspectionListView.isVisible("List View") && !inspectionGroupView.isVisible();
	}

	public boolean verifyGroupSwitchView() {
		scrollPageup();
		inspectionListView.click("List View");
		return !inspectionListView.isVisible() && inspectionGroupView.isVisible("Group View");
	}

	public boolean verifyListViewColumns() {
		setImplicitWait(10000, TimeUnit.MILLISECONDS);
		return inspectionDateCol.isEnable("Inspection Date") && lastUpdatedCol.isEnable("Last Updated") && siteCol.isEnable("Site") && conveyorCol.isEnable("Conveyor") && inspectorCol.isEnable("Inspector") && conditionCol.isEnable("Condition") && statusCol.isEnable("Status") && moreCol.isEnable("More") && assetCol.isEnable("Asset") && photoCol.isEnable("Photo") && observationCol.isEnable("Observation");
	}

	public boolean verifyAddInspectionFromList() {
		waitForElementVisible(btAddInspection,10000,500);
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

	public void verifyDefaultInspectionDate() {
		Validator.assertTrue(tbInspectionDate.getAttribute("value").equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))),"Inspection date is not defaulted to current date", "Inspection date validation successful");
	}

	public boolean verifySiteSelectionForDefault(String siteName) {
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		Validator.assertTrue(failureModeColumn.isVisible("failure mode"),"failure mode for default is not visible","Failure mode verified successfully");
		return cardStatusTotal.isVisible("Total") && cardStatusGood.isVisible("Good") && cardStatusCritical.isVisible("Critical") &&
				cardStatusFault.isVisible("Fault") && cardStatusPoor.isVisible("Poor");
	}

	public boolean verifySiteSelectionForVMC(String siteName) {
		dropdownSelectSearch(ddlSiteCustomername, tbInput, siteName);
		Validator.assertTrue(!failureModeColumn.isVisible(),"failure mode for VMC is visible","Failure mode for VMC verified successfully");
		return cardStatusTotal.isVisible("Total") && cardStatusGood.isVisible("Good") && cardStatusCritical.isVisible("Critical") &&
				cardStatusFault.isVisible("Fault") && !cardStatusPoor.isVisible();
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
		tbInspectionName.type(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+" "+name);
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


	public void editInspectionItemStatus(String status) {
		if(status.equalsIgnoreCase("completed"))
			ddlStatusCompleted.click();
		else ddlStatusToBeCompleted.click();
		waitForElementToDisplay(btnSaveItem);
		btnSaveItem.click("Save");
		waitForElementToInvisible(buttonLoader,5000);
		Reporter.log("Inspection Item is Updated", MessageTypes.Pass);
	}

	public boolean verifyEditedItemChanges(String conveyorName, String status) {
		goToInspection();
		verifySwitchView();
		searchInspection(conveyorName);
		ddViewicon.click("Inspection Detail");
		if(status.equalsIgnoreCase("completed"))
			return ddlStatusCompletedView.getAttribute("aria-checked").equalsIgnoreCase("true");
		else
			return
					ddlStatusToBeCompletedView.getAttribute("aria-checked").equalsIgnoreCase("true");
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

	public void verifyDeleteItem(String conveyor) {
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
		waitForElementVisible(txtInspCount,10000,1000);
		Validator.assertTrue(txtInspCount.isDisplayed(), "Inspection Tile Count is not visible", "Inspection Tile Count is visible");
	}

	public void verifyInspectionCompleteCount() {
		waitForPageLoad(5000);
		waitForElementToDisplay(txtInspCompleteCount);
		waitForElementVisible(txtInspCompleteCount,5000,1000);
		Validator.assertTrue(txtInspCompleteCount.isDisplayed(), "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
	}

	public void verifyInspectionCounts(int inspCount, int inspComplete, int inspGood, int inspFault, int inspPoor, int inspCritical) {
		waitForPageLoad(5000);
//		waitForElementToDisplay(txtInspCompleteCount);
//		waitForElementVisible(txtInspCompleteCount,5000,1000);
		System.out.println(txtInspCount.getText());
		System.out.println(inspCount);
		Validator.assertTrue(Integer.parseInt(txtInspCount.getText()) == inspCount ,"Inspection Tile Count is not visible", "Inspection Tile Count is visible");
		Validator.assertTrue(Integer.parseInt(txtInspCompleteCount.getText()) == inspComplete , "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
		Validator.assertTrue(Integer.parseInt(txtInspGoodCount.getText()) == inspGood , "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
		Validator.assertTrue(Integer.parseInt(txtInspFaultCount.getText()) == inspFault , "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
		Validator.assertTrue(Integer.parseInt(txtInspPoorCount.getText()) == inspPoor , "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
		Validator.assertTrue(Integer.parseInt(txtInspCriticalCount.getText()) == inspCritical , "Inspection Tile Complete Count is not visible", "Inspection Tile Complete Count is visible");
	}

	public int getDashboardTotalCount(){
		waitForElementToDisplay(txtDashboardTotalCount);
		return Integer.parseInt(txtDashboardTotalCount.getText());
	}

	public int getDashboardCriticalCount(){
		waitForElementToDisplay(txtDashboardCriticalCount);
		return Integer.parseInt(txtDashboardCriticalCount.getText());
	}

	public int getDashboardPoorCount(){
		waitForElementToDisplay(txtDashboardPoorCount);
		return Integer.parseInt(txtDashboardPoorCount.getText());
	}

	public int getDashboardFaultCount(){
		waitForElementToDisplay(txtDashboardFaultCount);
		return Integer.parseInt(txtDashboardFaultCount.getText());
	}

	public int getDashboardGoodCount(){
		waitForElementToDisplay(txtDashboardGoodCount);
		return Integer.parseInt(txtDashboardGoodCount.getText());
	}

	public int getTotalInspectionCount(){
		waitForElementToInvisible(txtInspCardLoader,15000);
		return Integer.parseInt(txtInspCount.getText());
	}

	public int getToBeCompletedInspectionCount(){
		return Integer.parseInt(txtInspCompleteCount.getText());
	}

	public int getInspectionGoodCount(){
		return txtInspGoodCount.isVisible()? Integer.parseInt(txtInspGoodCount.getText()) : 0;
	}

	public int getInspectionPoorCount(){
		return txtInspPoorCount.isVisible()? Integer.parseInt(txtInspPoorCount.getText()): 0;
	}

	public int getInspectionFaultCount(){
		return txtInspFaultCount.isVisible()? Integer.parseInt(txtInspFaultCount.getText()): 0;
	}

	public int getInspectionCriticalCount(){
		return txtInspCriticalCount.isVisible()? Integer.parseInt(txtInspCriticalCount.getText()): 0;
	}


	public void extractStatusValue(){
		waitForPageLoad(5000);
		waitForElementVisible(txtStatusValue,20000,1000);
		String statValue = txtStatusValue.getText();
		System.out.println(statValue);
		getBundle().setProperty("statusValue", statValue);
	}

	public void extractConditionValue(){
		waitForPageLoad(5000);
		waitForElementVisible(txtConditionValue,5000,1000);
		String  conValue = txtConditionValue.getText();
		System.out.println(conValue);
		getBundle().setProperty("conditionValue", conValue);
	}

	public void clickOnViewBtn(){
		waitForElementVisible(ddViewicon,10000,1000);
		ddViewicon.click();
	}

	public void verifyStatusValue() {
		String expectedValue = getBundle().getProperty("statusValue").toString().toLowerCase();
		waitForPageLoad(50000);
		waitForElementVisible(txtStatusTotalValue,10000,1000);
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
		boolean value= noOfCorporates>1;
		System.out.println(value+"value");
		Validator.assertTrue(value,"Dulpicate cant be created","Dulpicate can be created");
	}

	public void saveDulpicateInspectionItem() {
		waitForElementToBeClickable(btnSave);
		btnSave.click("Save");
		waitForElementToDisplay(inspectionErrorMsg);
		Validator.assertTrue(inspectionErrorMsg.isDisplayed(), "Error message is not displayed", "Error message is displayed");
	}

	public void viewAndVerifyCorporatePage(){
		waitForElementVisible(btviewicon,5000,1000);
		btviewicon.click();
		waitForPageLoad(5000);
		Validator.assertTrue(btSiteShopCardNo.isDisplayed(),"Corporate Page is not loaded","Corporate Page is loaded");
	}

	public void verifyInspectionCardClick(){
		waitForPageLoad(5000);
		waitForElementVisible(btInspectionCard,5000,1000);
		waitForElementToBeClickable(btInspectionCard);
		Validator.assertTrue(btInspectionCard.isEnable(),"Inspection Card is not clickable","Inspection Card is clickable");
		btInspectionCard.click();
		waitForPageLoad(5000);
		Validator.assertTrue(inspectionHeader.isDisplayed(),"Inspection Page is not loaded","Inspection Page is loaded");
	}

	public void verifyUserBreadCrumb()
	{
		waitForElementVisible(inspectionHeader,5000,500);
		Validator.assertTrue(inspectionHeader.isVisible(),"inspections header is not visible","inspections header is visible");
		waitForElementVisible(inspectionsBreadcrumb,10000,500);
		Validator.assertTrue(inspectionsBreadcrumb.isDisplayed(), "Breadcrumb element is not displayed","Breadcrumb text is displayed");
		assertEquals(inspectionsBreadcrumb.getText(), "Home\nInspections", "Breadcrumb text does not match expected");

	}
	public void addNewBtnClick()
	{
		waitForElementVisible(btnAddnew,5000,500);
		waitForElementToBeClickable(btnAddnew);
		SyncUtil.waitFor(4000);
		btnAddnew.click("Add New Inspection");
	}

	public void verifyAddFilesToUploadBtn()
	{
//		waitForElementVisible(fileInput,10000,500);
//		Validator.assertTrue(fileInput.isVisible(),"Add files section is not visible","Add files section is visible");
		waitForElementVisible(btnSelectFiles,5000,500);
		Validator.assertTrue(btnSelectFiles.isVisible(),"User is not able to view add files to upload section","User is able to see add files to upload section");

	}

	public void selectFilesBtnClick()
	{
		waitForPageLoad(5000);
		waitForElementVisible(btnSelectFiles,5000,500);
		btnSelectFiles.jsClick();

	}
	public void verifyLoader()
	{
		waitForElementVisible(imageLoader,1000,500);
		Validator.assertTrue(imageLoader.isVisible(),"the loader is not visible","the loader is visible");
	}
	public void verifyUploadedImage()
	{
//		waitForElementVisible(defaultImage,5000,500);
//		waitForElementToInvisible(defaultImage);
		waitForPageLoad(20000);
		SyncUtil.waitFor(8000);
//        waitForElementVisible(uploadedImage, 10000, 5000);
		Validator.assertTrue(uploadedImage.isVisible(), "the image is not visible", "the uploaded image is visible");

	}
	public void verifyDeleteBtn()
	{
		waitForElementVisible(deleteBtn,10000,500);
		Validator.assertTrue(deleteBtn.isVisible(),"The delete button is not visible","The delete button is visible");
	}

	public boolean isDeleteBtn()
	{
		return deleteBtn.isVisible();
	}

	public void deleteBtnClick()
	{
		waitForElementVisible(deleteBtn,10000,500);
		waitForElementToBeClickable(deleteBtn);
		deleteBtn.click();
		waitForElementVisible(deleteDialogbox,5000,500);
		waitForElementVisible(btnYes,5000,500);
		waitForElementToBeClickable(btnYes);
		btnYes.click();
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
	}

	public void verifyImageDeletion()
	{
		Validator.assertTrue(uploadedImage.verifyNotPresent(),"The image is failed to delete","The image is not uploaded");
	}

	public void exportBtnClick()
	{
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnExportInspection, 10000,500);
		btnExportInspection.jsClick("Export pdf");
	}

	public void exportPDFForMultiRecordItems()
	{
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnExportInspection, 10000,500);
		Validator.assertTrue(btnDeleteInspection.isVisible("Delete btn") && btnExportInspection.isVisible("Inspection Btn") && !btnEditInspection.isVisible(), "Action available for multi inspection items selection is incorrect", "Action available for multi inspection items verified successfully");
		btnExportInspection.jsClick("Export pdf");
		SyncUtil.waitFor(2000);
		waitForElementToInvisible(spinner,20000);
	}

	public void exportPDFDashboard()
	{
		SyncUtil.waitFor(2000);
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnExportInspection, 10000,500);
		btnExportInspection.jsClick("Export pdf");
		SyncUtil.waitFor(2000);
		waitForElementToInvisible(spinner,20000);
	}

	public void exportPDFForSingleRecordItems()
	{
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnExportInspection, 10000,500);
		Validator.assertTrue(btnDeleteInspection.isVisible("Delete btn") && btnExportInspection.isVisible("Inspection Btn") && btnEditInspection.isVisible(), "Action available for multi inspection items selection is incorrect", "Action available for multi inspection items verified successfully");
		btnExportInspection.jsClick("Export pdf");
		SyncUtil.waitFor(2000);
		waitForElementToInvisible(spinner,20000);
	}

	public void verifyPDFConveyor(String inspectionName, String conveyorName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName+".pdf");
		String val = null;
		try {
			val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		clickClearFilter();
		List<String> conveyorNames = getRowData().stream().map(Item::asset).collect(Collectors.toList());
		System.out.println(conveyorNames);
		System.out.println(val);
		if (conveyorNames.stream().anyMatch(name -> name.equalsIgnoreCase(conveyorName))) {
			Validator.assertTrue(val.contains(conveyorName), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
			System.out.println("if: ="+conveyorName);
		}else {
			Validator.assertTrue(!val.contains(conveyorName), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
			System.out.println("else: ="+conveyorName);
		}
	}

	public void verifyPDFDashboardContents(String corpName, String fullName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + corpName+"-inspection-dashboard.pdf");
		String val = null;
		try {
			val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			Validator.assertTrue(val.contains("Generated By: "+fullName), "PDF Report was generated for the wrong inspector", "PDF Report was generated for the right inspector");
			Validator.assertTrue(val.contains(corpName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
//			Validator.assertTrue(val.contains("Generated Date: "+LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))), "PDF Report was generated for the wrong date", "PDF Report was generated for the right date");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean searchForInspectionItem(String conveyorName)
	{
		waitForElementVisible(btSearchinput,5000,500);
		btSearchinput.type(conveyorName, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		Integer inspectionCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		return cbCheckbox.isVisible("checkbox") && inspectionCount == 1;
	}

	public boolean searchForInspectionEvent(String searchTxt)
	{
		waitForElementVisible(btSearchinput,5000,500);
		btSearchinput.type(searchTxt, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		System.out.println(cbCheckbox.isVisible());
		System.out.println(isLocatorVisible(By.xpath("//tbody//td[contains(text(),'"+searchTxt+"')]")));
		System.out.println(isLocatorVisible(By.xpath("//tbody//td/span[text()='"+searchTxt+"']")));
		return cbCheckbox.isVisible("checkbox") && (isLocatorVisible(By.xpath("//tbody//td[contains(text(),'"+searchTxt+"')]")) || isLocatorVisible(By.xpath("//tbody//td/span[text()='"+searchTxt+"']")));
	}

	public boolean searchForDashboardEvent(String searchTxt)
	{
		waitForElementVisible(btSearchinput,5000,500);
		btSearchinput.type(searchTxt, "Inspection Search");
		System.out.println(isLocatorVisible(By.xpath("//tbody//td[contains(text(),'"+searchTxt+"')]")));
		System.out.println(isLocatorVisible(By.xpath("//tbody//td/span[text()='"+searchTxt+"']")));
		return (isLocatorVisible(By.xpath("//tbody//td[contains(text(),'"+searchTxt+"')]")) || isLocatorVisible(By.xpath("//tbody//td/span[text()='"+searchTxt+"']")));
	}

	public void viewInspectionItem()
	{
		waitForElementVisible(ddViewicon,5000,500);
		ddViewicon.click();
	}

	public void conveyorNameClick(String conveyorName)
	{
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



	public void verifyConveyorPageNavigation()
	{
		SyncUtil.waitFor(10000);
		waitForPageLoad(15000);
		waitForElementVisible(technicalDataHeader,10000,500);
		Validator.assertTrue(technicalDataHeader.isVisible(),"User is not navigated to conveyor detail page","User is navigated to conveyor detail page");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/conveyor/details"),"User is not navigated to conveyor detail page","User is navigated to conveyor detail page");

	}

	public void verifyInspections(int noOfData, String breadCrumbValue,int row) {
		waitForPageLoad(10000);

		for(int i = 1; i <= noOfData; i++) {
			WebElement locator = driver.findElement(By.xpath("//tr["+i+"]/td["+row+"][contains(., '" + breadCrumbValue + "')]"));

			try {
				waitForElementVisible(locator,5000,500);
				Validator.assertTrue(locator.isDisplayed(), "Inspections of " + breadCrumbValue + " is not visible", "Inspections of " + breadCrumbValue + " is visible");
			} catch (TimeoutException e) {
				Validator.assertTrue(false, "No inspections found for " + breadCrumbValue, " inspections found for " + breadCrumbValue);
				break; // Exit the loop if no inspections are found
			}
		}
	}

	public void siteNameClick(String siteName) {
		String xpath = "//span[text()='"+siteName+"']";
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
		String siteHeader = "//div[contains(@class,'p-panel-header') and .//span[contains(text(),'"+siteName+"')]]";

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


	public void verifyCorporatePageNavigation(String corpName)
	{
		waitForPageLoad(15000);
		String corpHeader="//div[contains(@class,'p-panel-header') and .//span[contains(text(),'"+corpName+"')]]";
		waitForElementVisible(driver.findElement(By.xpath(corpHeader)), 20000, 500);
		waitForElementToDisplay(driver.findElement(corpHeader));
//		waitForElementVisible(siteHeader,10000,500);
		Validator.assertTrue(driver.findElement(By.xpath(corpHeader)).isDisplayed(),"User is not navigated to corporate detail page","User is navigated to corporate detail page");
//		waitForElementVisible(corpHeader,10000,500);
//		Validator.assertTrue(corpHeader.isVisible(),"User is not navigated to corporate detail page","User is navigated to corporate detail page");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/companies/detail"),"User is not navigated to corporate detail page","User is navigated to corporate page");

	}



	public void corpBreadCrumbClick()
	{
		waitForElementVisible(corporateLink,5000,500);
		corporateLink.jsClick();
	}

	public void verifyCorporateListPageNavigation()
	{
//		SyncUtil.waitFor(10000);
		waitForPageLoad(15000);
		waitForElementVisible(headerCorporate,10000,500);
		Validator.assertTrue(headerCorporate.isVisible(),"User is not navigated to corporate list page","User is navigated to corporate list page");
		Validator.assertTrue(driver.getCurrentUrl().contains("/secure/companies/list"),"User is not navigated to corporate list page","User is navigated to corporate list page");

	}

	public void inspectionDashboardBtnClick()
	{
		waitForPageLoad(5000);
		waitForElementVisible(iconBarChart,5000,500);
		waitForElementToBeClickable(iconBarChart);
		iconBarChart.jsClick("inspection dashboard");
		waitForPageLoad(10000);
		SyncUtil.waitFor(1000);
		Validator.assertTrue(iconBarChart.isEnabled(),"Inspection dashboard is clickable","Inspection dashboard is  clickable");
	}

	public void verifyInspectionItemsCounts(String total,String critical,String poor,String fault,String good )
	{
		waitForPageLoad(5000);
		waitForElementVisible(statusCardCriticalCount,5000,500);
		SyncUtil.waitFor(30000);
		System.out.println(statusCardTotalCount.getText()+"text"+statusCardCriticalCount.getText()+statusCardPoorCount.getText()+statusCardFaultCount.getText()+statusCardGoodCount.getText());
		Validator.assertTrue(statusCardTotalCount.getText().contains(total),"Total Count doesn't match","Critical Count match");
		Validator.assertTrue(statusCardCriticalCount.getText().contains(critical),"Critical Count doesn't match","Critical Count match");
		Validator.assertTrue(statusCardPoorCount.getText().contains(poor),"Poor Count doesn't match","Poor Count match");
		Validator.assertTrue(statusCardFaultCount.getText().contains(fault),"Fault Count doesn't match","Fault Count match");
		Validator.assertTrue(statusCardGoodCount.getText().contains(good),"Good Count doesn't match","Good Count match");

	}

	public void verifyInspectionDashboardCards()
	{
		waitForElementVisible(cardStatusTotal,10000,500);
		Validator.assertTrue(cardStatusTotal.isVisible() && cardStatusCritical.isVisible() && cardStatusPoor.isVisible()
				&& cardStatusFault.isVisible() && cardStatusGood.isVisible(),"User cannot see all cards in inspection dashboard","User can see all cards in inspection dashboard");
	}

	public void siteDropDownClick()
	{
		waitForElementVisible(ddlSiteDropdown,10000,500);
		waitForElementToBeClickable(ddlSiteDropdown);
		ddlSiteDropdown.click();
		SyncUtil.waitFor(10000);
	}

	public void verifyMultiSelInSiteDropDown(String siteName,String siteName2)
	{
		SyncUtil.waitFor(20000);
		waitForElementVisible(multiSelectCloseBtn,10000,500);
		multiSelectCloseBtn.click();
		waitForElementVisible(ddlSiteDropdown,10000,500);
		ddlSiteDropdown.click();
		setImplicitWait(30000,TimeUnit.MILLISECONDS);
		String site="//p-multiselectitem//li[@aria-label='"+siteName+"']";
		waitForElementVisible(driver.findElement(By.xpath(site)),10000,500);
		driver.findElement(By.xpath(site)).click();
		String site2="//p-multiselectitem//li[@aria-label='"+siteName2+"']";
		waitForElementVisible(driver.findElement(By.xpath(site2)),10000,500);
		driver.findElement(By.xpath(site2)).click();
		waitForElementToDisplay(tbMultipleSiteDropdwn);
		waitForElementVisible(tbMultipleSiteDropdwn,20000,500);
		String siteSelected="//p-multiselectitem//li[@aria-label='"+siteName+"' and contains(@data-p-highlight, 'true')]";
		String siteSelected2="//p-multiselectitem//li[@aria-label='"+siteName2+"' and contains(@data-p-highlight,'true')]";
		waitForElementVisible(driver.findElement(By.xpath(siteSelected)),10000,500);
		Validator.assertTrue(driver.findElement(By.xpath(siteSelected)).isDisplayed(),"The user is not able to select site","The user is  able to select site");
		Validator.assertTrue(driver.findElement(By.xpath(siteSelected2)).isDisplayed(),"The user is not able to select site2","The user is  able to select site2");
	}

	public void verifySiteDropDownClicked(String siteName) {
		waitForElementVisible(multiSelectCloseBtn, 10000, 500);
		multiSelectCloseBtn.click();
	}

	public void verifyViewRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
		searchInspection(inspectionName);
		waitForElementToDisplay(cbCheckbox);
		Validator.assertTrue(!cbCheckboxInput.isEnabled(), "Inspection checkbox should not be enabled with only view rights", "Inspection checkbox is disabled with only view rights");
		Validator.assertTrue(!btnAddInspection.isVisible(),"Add inspection should not be visible with view only rights", "Add inspection is not visible with view only rights");
		goToInspectionDetailScreen(inspectionName);
		Validator.assertTrue(!btnAddnew.isVisible(),"Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
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

	public void verifyViewAddEditDeleteRights(String inspectionName) {
		searchInspection(inspectionName);
		waitForElementToDisplay(cbCheckbox);
		Validator.assertTrue(cbCheckboxInput.isEnabled(), "Inspection checkbox should not be enabled with only view rights", "Inspection checkbox is disabled with only view rights");
		Validator.assertTrue(btnAddInspection.isVisible(),"Add inspection is visible with add rights", "Add inspection is not visible with add rights");
		cbCheckbox.click("checkbox");
		ddlActions.click("action");
		Validator.assertTrue(btnEditInspection.isVisible(),"Edit inspection is visible with delete rights", "Edit inspection is not visible with delete rights");
		Validator.assertTrue(btnDeleteInspection.isVisible(),"Delete inspection is not visible with delete rights", "Delete inspection is visible with delete rights");
		goToInspectionDetailScreen(inspectionName);
		Validator.assertTrue(btnAddnew.isVisible(),"Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
		cbCheckbox.click("checkbox");
		ddlActions.click("action");
		Validator.assertTrue(btnEditInspection.isVisible(),"Edit inspection item should not be visible with view only rights", "Edit inspection item is not visible with view only rights");
		Validator.assertTrue(btnDeleteInspection.isVisible(),"Delete inspection item should not be visible with view only rights", "Delete inspection item is not visible with view only rights");
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

	public void verifyViewAndAddRights(String conveyorName, String inspectionName, String assetName, String assetDetail, String failureMode, String condition, String status) {
		searchInspection(inspectionName);
		waitForElementToDisplay(cbCheckbox);
		Validator.assertTrue(!cbCheckboxInput.isEnabled(), "Inspection checkbox should not be enabled with only view rights", "Inspection checkbox is disabled with only view rights");
		Validator.assertTrue(btnAddInspection.isVisible(),"Add inspection is visible with add rights", "Add inspection is not visible with add rights");
		goToInspectionDetailScreen(inspectionName);
		Validator.assertTrue(!btnAddnew.isVisible(),"Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
		Validator.assertTrue(!btnEdit.isVisible(),"Edit inspection item should not be visible with view only rights", "Edit inspection item is not visible with view only rights");
		Validator.assertTrue(!btnDelete.isVisible(),"Delete inspection item should not be visible with view only rights", "Delete inspection item is not visible with view only rights");
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
		Validator.assertTrue(!btnAddInspection.isVisible(),"Add inspection is visible with delete rights", "Add inspection is visible with delete rights");
		cbCheckbox.click("checkbox");
		ddlActions.click("action");
		Validator.assertTrue(!btnEditInspection.isVisible(),"Edit inspection is visible with delete rights", "Edit inspection is not visible with delete rights");
		Validator.assertTrue(btnDeleteInspection.isVisible(),"Delete inspection is not visible with delete rights", "Delete inspection is visible with delete rights");
		goToInspectionDetailScreen(inspectionName);
		Validator.assertTrue(!btnAddnew.isVisible(),"Add inspection item should not be visible with view only rights", "Add inspection item is not visible with view only rights");
		Validator.assertTrue(!btnEdit.isVisible(),"Edit inspection item should not be visible with view only rights", "Edit inspection item is not visible with view only rights");
		Validator.assertTrue(!btnDelete.isVisible(),"Delete inspection item should not be visible with view only rights", "Delete inspection item is not visible with view only rights");
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


	public void verifyActionBtnEnabled()
	{
		Validator.assertTrue(btnActions.isPresent(),"The actions button is not present in inspection dashboard","The actions button is present in inspection dashboard");
		Validator.assertTrue(btnActions.isEnabled(),"The actions button is not enabled by default in inspection dashboard","The actions button is enabled by default in inspection dashboard");

	}

	public void verifyExportPDFIsVisible()
	{
		waitForElementVisible(btnExportInspection, 10000,500);
		Validator.assertTrue(btnExportInspection.isVisible() && btnExportPDFIcon.isVisible(),"User is not able to see Export PDF along with PDF Symbol","User is able to see Export PDF along with PDF Symbol");

	}

	public boolean isGroupViewSelected(){
		return inspectionGroupView.isVisible() && !inspectionListView.isVisible();
	}

	public boolean isListViewSelected(){
		scrollPageup();
		inspectionGroupView.click();
		return !inspectionGroupView.isVisible() && inspectionListView.isVisible();
	}

	public boolean verifyGroupDetailsNav(String inspectionName){
		searchInspection(inspectionName);
		if(inspectionListView.isVisible())
			inspectionGroupView.click();
		ddViewicon.click();
		return inspectionHeader.isVisible();
	}

	public boolean verifyListDetailsNav(String conveyor){
		searchInspectionItem(conveyor);
		if(inspectionGroupView.isVisible())
			inspectionListView.click();
		ddViewicon.click();
		boolean flag = btnClose.isVisible();
		btnClose.click();
		return flag;
	}

	public boolean verifyListItems() {
		System.out.println(ddlConveyorView.isVisible() && ddlAssetView.isVisible() && ddlFailureModeView.isVisible() && ddlConditionView.isVisible() && ddlStatusToBeCompleted.isVisible() && tbLat.isVisible() && tbLong.isVisible() && eleObservationView.isVisible() && eleRecommendationView.isVisible());
		System.out.println(ddlConveyorView.isEnable() && ddlAssetView.isEnable() && ddlFailureModeView.isEnable() && ddlConditionView.isEnable() && ddlStatusToBeCompleted.isEnable() && tbLat.isEnable() && tbLong.isEnable() && eleObservationView.isEnable() && eleRecommendationView.isEnable());
		return ddlConveyorView.isEnable() && ddlAssetView.isEnable() && ddlFailureModeView.isEnable() && ddlConditionView.isEnable() && ddlStatusToBeCompleted.isEnable() && tbLat.isEnable() && tbLong.isEnable() && eleObservationView.isEnable() && eleRecommendationView.isEnable();
	}

	public boolean verifyBoldSummaryField(){
		summaryField.clear();
		btBold.click();
		summaryField.sendKeys("Abc");
		btBold.click();
		return boldLetters.isEnable();
	}

	public boolean verifyItalicsSummaryField(){
		summaryField.clear();
		btItalics.click();
		summaryField.sendKeys("Abc");
		summaryField.sendKeys(Keys.CONTROL + "a");
		btItalics.click();
		return italicsLetters.isEnable();
	}

	public boolean verifyUnderlineSummaryField(){
		summaryField.clear();
		btUnderline.click();
		summaryField.sendKeys("Abc");
		summaryField.sendKeys(Keys.CONTROL + "a");
		btUnderline.click();
		return underlineLetters.isEnable();
	}

	public boolean verifyListSummaryField(){
		btList.click();
		boolean flag = listLetters.isVisible() && !summaryField.isVisible();
		btList.click();
		summaryField.clear();
		return flag;
	}

	public void verifyInspectionCountChange(String inspCount, String inspComplete, String inspGood, String inspPoor, String inspFault, String inspCritical) {
		waitForPageLoad(5000);
		waitForElementToInvisible(txtInspCardLoader,15000);
//		waitForElementToDisplay(txtInspCompleteCount);
//		waitForElementVisible(txtInspCompleteCount,5000,1000);
		scrollPageup();
		System.out.println(txtInspCount.getText());
		System.out.println(txtInspCompleteCount.getText());
		System.out.println(txtInspGoodCount.getText());
		System.out.println(txtInspFaultCount.getText());
		System.out.println(txtInspPoorCount.getText());
		System.out.println(txtInspCriticalCount.getText());
		System.out.println("=======");
		System.out.println(inspCount);
		System.out.println(inspComplete);
		System.out.println(inspGood);
		System.out.println(inspFault);
		System.out.println(inspPoor);
		System.out.println(inspCritical);
		Validator.assertTrue(txtInspCount.getText().equalsIgnoreCase(inspCount) ,"Inspection Tile Count is not matching", "Inspection Tile Count is matching");
		Validator.assertTrue(txtInspCompleteCount.getText().equalsIgnoreCase(inspComplete) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspGoodCount.getText().equalsIgnoreCase(inspGood) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspFaultCount.getText().equalsIgnoreCase(inspFault) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspPoorCount.getText().equalsIgnoreCase(inspPoor) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspCriticalCount.getText().equalsIgnoreCase(inspCritical) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
	}


	public void verifyDashboardCountChange(String inspCount, String inspGood, String inspPoor, String inspFault, String inspCritical) {
		waitForPageLoad(5000);
		waitForElementToInvisible(txtInspCardLoader,15000);
//		waitForElementToDisplay(txtInspCompleteCount);
//		waitForElementVisible(txtInspCompleteCount,5000,1000);
		scrollPageup();
		System.out.println(txtDashboardTotalCount.getText());
		System.out.println(txtDashboardGoodCount.getText());
		System.out.println(txtDashboardFaultCount.getText());
		System.out.println(txtDashboardPoorCount.getText());
		System.out.println(txtDashboardCriticalCount.getText());
		System.out.println("=======");
		System.out.println(inspCount);
		System.out.println(inspGood);
		System.out.println(inspFault);
		System.out.println(inspPoor);
		System.out.println(inspCritical);
		Validator.assertTrue(txtDashboardTotalCount.getText().equalsIgnoreCase(inspCount) ,"Dashboard Tile Count is not matching", "Dashboard Tile Count is matching");
		Validator.assertTrue(txtDashboardGoodCount.getText().equalsIgnoreCase(inspGood) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
		Validator.assertTrue(txtDashboardFaultCount.getText().equalsIgnoreCase(inspFault) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
		Validator.assertTrue(txtDashboardPoorCount.getText().equalsIgnoreCase(inspPoor) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
		Validator.assertTrue(txtDashboardCriticalCount.getText().equalsIgnoreCase(inspCritical) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
	}

	public void verifyInspectionCountChangeVMC(String inspCount, String inspComplete, String inspGood, String inspFault, String inspCritical) {
		waitForPageLoad(5000);
		waitForElementToInvisible(txtInspCardLoader,15000);
//		waitForElementToDisplay(txtInspCompleteCount);
//		waitForElementVisible(txtInspCompleteCount,5000,1000);
		scrollPageup();
		System.out.println(txtInspCount.getText());
		System.out.println(txtInspCompleteCount.getText());
		System.out.println(txtInspGoodCount.getText());
		System.out.println(txtInspFaultCount.getText());
		System.out.println(txtInspCriticalCount.getText());
		System.out.println("=======");
		System.out.println(inspCount);
		System.out.println(inspComplete);
		System.out.println(inspGood);
		System.out.println(inspFault);
		System.out.println(inspCritical);
		Validator.assertTrue(txtInspCount.getText().equalsIgnoreCase(inspCount) ,"Inspection Tile Count is not matching", "Inspection Tile Count is matching");
		Validator.assertTrue(txtInspCompleteCount.getText().equalsIgnoreCase(inspComplete) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspGoodCount.getText().equalsIgnoreCase(inspGood) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspFaultCount.getText().equalsIgnoreCase(inspFault) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
		Validator.assertTrue(txtInspCriticalCount.getText().equalsIgnoreCase(inspCritical) , "Inspection Tile Complete Count is not matching", "Inspection Tile Complete Count is matching");
	}

	public void verifyDashboardCountChangeVMC(String inspCount, String inspGood, String inspFault, String inspCritical) {
		waitForPageLoad(5000);
		waitForElementToInvisible(txtInspCardLoader,15000);
//		waitForElementToDisplay(txtInspCompleteCount);
//		waitForElementVisible(txtInspCompleteCount,5000,1000);
		scrollPageup();
		System.out.println(txtDashboardTotalCount.getText());
		System.out.println(txtDashboardCriticalCount.getText());
		System.out.println(txtDashboardFaultCount.getText());
		System.out.println(txtDashboardGoodCount.getText());
		System.out.println("=======");
		System.out.println(inspCount);
		System.out.println(inspGood);
		System.out.println(inspFault);
		System.out.println(inspCritical);
		Validator.assertTrue(txtDashboardTotalCount.getText().equalsIgnoreCase(inspCount) ,"Dashboard Tile Count is not matching", "Dashboard Tile Count is matching");
		Validator.assertTrue(txtDashboardGoodCount.getText().equalsIgnoreCase(inspGood) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
		Validator.assertTrue(txtDashboardFaultCount.getText().equalsIgnoreCase(inspFault) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
		Validator.assertTrue(txtDashboardCriticalCount.getText().equalsIgnoreCase(inspCritical) , "Dashboard Tile Complete Count is not matching", "Dashboard Tile Complete Count is matching");
	}


	public void verifyInspectionListCount() {
		goToInspectionScreenAndWait();
		waitForElementToDisplay(cbCheckbox);
		Integer inspectionCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		System.out.println(inspectionCount);
		waitForPageLoad(5000);
		Validator.assertTrue(inspectionCount.toString().equalsIgnoreCase(txtInspCount.getText()), "Number of inspection in tile and list doesnt match","Inspection count verification was successful");
	}

	public void verifyAddNewBtn() {
		Validator.assertTrue(!btnAddnew.isEnabled(), "Add new button should be disabled", "Add new button should is disabled");
		tbInspectionName.type("abc");
		Validator.assertTrue(btnAddnew.isEnabled(), "Add new button should be enabled", "Add new button should is enabled");
	}

	public void verifyAddItemWithoutMandatoryFields(){
		tbInspectionName.type("abc");
		btnAddnew.click();
		Validator.assertTrue(!btnSave.isEnabled(), "Inspection item save should be disabled", "Inspection item save should is disabled");
	}

	public boolean verifyDownloadViewIcons(){
		return btnDownload.isVisible() && ddViewicon.isVisible();
	}

	public boolean verifyImgUploadInspectionItem(String img){
		tbInspectionName.type("abc");
		btnAddnew.click();
		String file_path = ClasspathResourceHelper.getPropertyFile(img, "test_files").getAbsolutePath();
		btnUpload.sendKeys(file_path, "File Path");
		waitForElementToInvisible(btSpinner, 30000);
		return appImgViewer.isVisible();
	}

	public boolean verifyDeleteUploadedImg(){
		deleteBtn.click();
		waitForElementVisible(deleteDialogbox,5000,500);
		waitForElementVisible(confirmBtn,5000,500);
		waitForElementToBeClickable(confirmBtn);
		deleteDialogbox.isVisible("Dialog box");
		confirmBtn.click();
		return !appImgViewer.isVisible();
	}

	public void inspectionItemsListCount(String insp){
		Integer inspectionCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		System.out.println(inspectionCount);
		waitForPageLoad(5000);
		Validator.assertTrue(inspectionCount.toString().equalsIgnoreCase(insp), "Number of inspection in pagination list doesnt match","Inspection count for inspection item verification was successful");
	}

	public void searchResult(String search) {
		waitForPageLoad(10000);
		SyncUtil.waitFor(10000);
		btSearchinput.type(search, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		Validator.assertTrue(cbCheckbox.isDisplayed(), "Result is not found", "Result is found");
	}

	public void clickClearFilter() {
		waitForElementVisible(clearFilterBtn,5000,1000);
		Validator.assertTrue(clearFilterBtn.isDisplayed(), "Clear Button is not found", "Clear Button is found");
		clearFilterBtn.jsClick();
		waitForPageLoad(10000);
	}

	public boolean columnSelection(String column) {
		columnSelectionBtn.click();
		tbMultipleSiteDropdwn.type(column);
		inspectionItemFilterCheckbox.click();
		multiSelectCloseBtn.click();
		return isLocatorVisible(By.xpath("(//thead//th/div[contains(text(),'"+column+"')])[1]"));
	}

	public void verifyInspectionItemsCountsForCorp(String corporate)
	{
		waitForPageLoad(20000);
		waitForElementVisible(statusCardCriticalCount,5000,500);
//		SyncUtil.waitFor(40000);
//		System.out.println(statusCardTotalCount.getText()+statusCardCriticalCount.getText()+statusCardPoorCount.getText()+statusCardFaultCount.getText()+statusCardGoodCount.getText()+"count");
//		Validator.assertTrue(statusCardTotalCount.getText().contains(total),"Total Count doesn't match","Critical Count match");
//		Validator.assertTrue(statusCardCriticalCount.getText().contains(critical),"Critical Count doesn't match","Critical Count match");
//		Validator.assertTrue(statusCardPoorCount.getText().contains(poor),"Poor Count doesn't match","Poor Count match");
//		Validator.assertTrue(statusCardFaultCount.getText().contains(fault),"Fault Count doesn't match","Fault Count match");
//		Validator.assertTrue(statusCardGoodCount.getText().contains(good),"Good Count doesn't match","Good Count match");

	}

	public List<Item> getRowData() {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		List<Item> rowData = new ArrayList<>();
		int index = 1;
		for (WebElement row : rows) {
			String conveyor = driver.findElement(By.xpath("//tbody/tr["+index+"]/td[4]")).getText().trim();
			String asset = driver.findElement(By.xpath("//tbody/tr["+index+"]/td[5]")).getText().trim();
			String condition;
			String status;
			if(isLocatorVisible(By.xpath("//tbody/tr["+index+"]/td[9]/span/span"))) {
				condition = driver.findElement(By.xpath("//tbody/tr[" + index + "]/td[9]/span/span")).getText().trim();
				status = driver.findElement(By.xpath("//tbody/tr[" + index + "]/td[10]/div")).getText().trim();
			}
			else{
				condition = driver.findElement(By.xpath("//tbody/tr[" + index + "]/td[8]/span/span")).getText().trim();
				status = driver.findElement(By.xpath("//tbody/tr[" + index + "]/td[9]/div")).getText().trim();
			}
			rowData.add(new Item(conveyor,asset,new InspectionItemSequencing().assignFlag(condition),status.equalsIgnoreCase("Completed")));
			index++;
		}
		return rowData;
	}


	private List<String> getColumnData(int columnNumber) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(rows + " rows");
		List<String> columnData = new ArrayList<>();
		int index = 1;
		for (WebElement row : rows) {
			WebElement cell = driver.findElement(By.xpath("//tbody/tr["+index+"]/td[" + columnNumber + "]"));
			String cellText = cell.getText().trim();
			System.out.println("Cell ID: " + cell.getAttribute("id"));
			System.out.println("Cell Text: " + cellText);
			columnData.add(cellText);
			index++;
		}
		System.out.println(columnData + " columnData");
		return columnData;
	}

	public boolean verifyAscendingOrderSorting(int columnNumber) {
		List<String> columnDataAfterSortingAscending = getColumnData(columnNumber);
		List<String> expectedSortedDataAscending = new ArrayList<>(columnDataAfterSortingAscending);
		boolean val = false;

		// Normalize data: Trim, convert to lowercase, and remove hidden characters
		columnDataAfterSortingAscending = columnDataAfterSortingAscending.stream()
				.map(String::trim)
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		expectedSortedDataAscending = expectedSortedDataAscending.stream()
				.map(String::trim)
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		// Sort the expected data in increasing order
		expectedSortedDataAscending.sort(null);

		// Debugging
		for (int i = 0; i < columnDataAfterSortingAscending.size(); i++) {
			System.out.println("Index " + i + ": Actual [" + columnDataAfterSortingAscending.get(i)
					+ "] Expected [" + expectedSortedDataAscending.get(i) + "]");
		}
		if ((columnDataAfterSortingAscending.equals(expectedSortedDataAscending)))
			val = true;
		return val;

	}

	public boolean verifyDecreasingOrderSorting(int columnNumber) {
		List<String> columnDataAfterSortingDescending = getColumnData(columnNumber);
		List<String> expectedSortedDataDescending = new ArrayList<>(columnDataAfterSortingDescending);
		boolean val = false;

		// Normalize data: Trim, convert to lowercase, and remove hidden characters
		columnDataAfterSortingDescending = columnDataAfterSortingDescending.stream()
				.map(String::trim)
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		expectedSortedDataDescending = expectedSortedDataDescending.stream()
				.map(String::trim)
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		// Sort the expected data in reverse order
		expectedSortedDataDescending.sort(Collections.reverseOrder());

		// Debugging
		for (int i = 0; i < columnDataAfterSortingDescending.size(); i++) {
			System.out.println("Index " + i + ": Actual [" + columnDataAfterSortingDescending.get(i)
					+ "] Expected [" + expectedSortedDataDescending.get(i) + "]");
		}
		if ((columnDataAfterSortingDescending.equals(expectedSortedDataDescending)))
			val = true;
		return val;


	}

	public String selectGivenDate(String date) {
		String day = null;
		String month = null;
		String year = null;
		String formattedDate = null;
		String month1 = null;
		DateTimeFormatter format = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy-MM-dd").toFormatter(Locale.ENGLISH);
		LocalDate formatDate = LocalDate.parse(date, format);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateformat;
		try {
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
			SimpleDateFormat monthFormat1 = new SimpleDateFormat("M");
			SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.ENGLISH);
			dateformat = simpleDateFormat.parse(formatDate.toString());
			day = dateFormat.format(dateformat);
			month = monthFormat.format(dateformat);
			year = yearFormat.format(dateformat);
			month1 = monthFormat1.format(dateformat);

			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
			formattedDate = simpleDateFormat1.format(dateformat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int val;
		SyncUtil.waitFor(1000);
		calendarMonth.click("Calendar Month");
		val = parseInt(calendarYear.getText("Calendar year")) - parseInt(year);
		if (val > 0)
			for (int i = 0; i < abs(val); i++)
				calendarPrev.click("Calendar Decrement");
		else if (val < 0)
			for (int i = 0; i < abs(val); i++)
				calendarNext.click("Calendar Increment");
		SyncUtil.waitFor(500);
		waitForElementToBeClickable(By.xpath("//span[contains(text(),\"" + month + "\")]"));
		driver.findElement(By.xpath("//span[contains(text(),\"" + month + "\")]")).click();
		waitForElementToBeClickable(By.xpath("(//td[contains(@class,'ng-star-inserted')]//span[text()=\"" + day + "\" ])[1]"));
		driver.findElement(By.xpath("(//td[contains(@class,'ng-star-inserted')]//span[text()=\"" + day + "\" ][@data-date='"+year+"-"+month1+"-"+day+"'])[1]")).click();
//            waitForElementToBeClickable(By.xpath("(//span[text()=\"" + day + "\" and not(contains(@class,'p-disabled'))])[1]"));
//            driver.findElement(By.xpath("(//span[text()=\"" + day + "\" and not(contains(@class,'p-disabled'))])[1]")).click();
		return formattedDate;
	}

	public void verifyColumnFunctionality(String columnHeader, String colNum) {
		scrollPageup();
		SyncUtil.waitFor(2000);
		waitForElementVisible(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")), 5000, 500);
		waitForElementToBeClickable(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")));
		System.out.println(isLocatorVisible(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]")));
		//		Validator.assertTrue(isLocatorVisible(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")),"Header is not visible", "Header is successfully verified");
		Validator.assertTrue(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).getAttribute("aria-sort").equalsIgnoreCase("none"),"Default sorting must be none", "Default sorting verified successfully");
		driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).click();
		Validator.assertTrue(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).getAttribute("aria-sort").equalsIgnoreCase("ascending"),"After one click sorting must be ascending", "After first clicking sorting verified successfully");
		verifyAscendingOrderSorting(Integer.parseInt(colNum));
		driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).click();
		Validator.assertTrue(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).getAttribute("aria-sort").equalsIgnoreCase("descending"),"After another click sorting must be ascending", "After second clicking sorting verified successfully");
		verifyDecreasingOrderSorting(Integer.parseInt(colNum));
	}

	public void verifyNameFilterFunctionality(String val, String colNum){
//		SyncUtil.waitFor(30000);
		inspectionDetailsItemNameFilter.jsClick("Inspection Name filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		System.out.println(driver.findElement(By.xpath("//tbody//td[" + colNum + "]")).getText().trim());
		Validator.assertTrue(driver.findElement(By.xpath("//tbody//td[" + colNum + "]")).getText().trim().equalsIgnoreCase(val),"Name filter is not working as expected", "Name filter verified successfully");
	}

	public void verifyInspectionDateFilterFunctionality(String val, String colNum){
		inspectionDetailsItemDateFilter.jsClick("Inspection Date filter");
		inspectionFilterInput.click("Calendar");
		selectGivenDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		applyFilter.click();
		SyncUtil.waitFor(1500);
		System.out.println(driver.findElement(By.xpath("//td[" + colNum + "]")).getText());
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))),"Date filter is not working as expected", "Date filter verified successfully");
	}

	public void verifyInspectionCorporateFilterFunctionality(String val, String colNum){
		inspectionDetailsItemCorporateFilter.jsClick("Inspection Corporate filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(val),"Corporate filter is not working as expected", "Corporate filter verified successfully");
	}

	public void verifyInspectionSiteFilterFunctionality(String val, String colNum){
		inspectionDetailsItemSiteFilter.jsClick("Inspection Site filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(val),"Site filter is not working as expected", "Site filter verified successfully");
	}

	public void verifyInspectionConveyorFilterFunctionality(String val, String colNum){
		inspectionDetailsItemConveyorFilter.jsClick("Inspection conveyor filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElements(By.xpath("//tbody/tr")).size() == 1,"Conveyor filter is not working as expected", "Conveyor filter verified successfully");
	}

	public void verifyConveyorColumn(String count, String colNum){
		System.out.println(driver.findElement(By.xpath("//td[" + colNum + "]")).getText());
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(count),"Conveyor filter is not working as expected", "Conveyor filter verified successfully");
	}

	public void verifyPaginationCount(int count){
		Validator.assertTrue(driver.findElements(By.xpath("//tbody/tr")).size() == count,"Filter is not working as expected", "Filter verified successfully");
	}

	public void verifyResetPaginationCount(int count){
		Validator.assertFalse(driver.findElements(By.xpath("//tbody/tr")).size() == count,"Filter is not working as expected", "Filter verified successfully");
	}

	public void verifyInspectionInspectorFilterFunctionality(String val, String colNum){
		inspectionDetailsItemInspectorFilter.jsClick("Inspection inspector filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(val),"Inspector filter is not working as expected", "Inspector filter verified successfully");
	}

	public void verifyInspectionLastModifiedFilterFunctionality(String val, String colNum){
		inspectionDetailsItemLastModifiedFilter.jsClick("Inspection last modified filter");
		inspectionFilterInput.type(val);
		val = selectGivenDate(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElement(By.xpath("//td[" + colNum + "]")).getText().equalsIgnoreCase(val),"Last modified filter is not working as expected", "Last modified filter verified successfully");
	}

	public void verifyLastModifiedDate(String inspName){
		searchInspection(inspName);
		Validator.assertTrue(driver.findElement(By.xpath("//tbody//td[4]")).getText().equalsIgnoreCase(driver.findElement(By.xpath("//tbody//td[9]")).getText()),"Last modified date is not working as expected", "Last modified date verified successfully");
	}

	public void verifyConditionFilter(String condition, String columnNum){
		if(!inspectionFilterDropdown.isEnable())
			inspectionDetailsItemConditionFilter.jsClick("Inspection condition filter");
		if(inspectionFilterDropdown.isEnable())
			inspectionFilterDropdown.click("filter dropdown");
		driver.findElement(By.xpath("//span[text()='"+condition+"']/../..//div[@class='p-checkbox-box']")).click();
		SyncUtil.waitFor(2000);
		Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'"+condition.toLowerCase()+"')])[1]")).isDisplayed(),"Condition filter is not working as expected", "Condition filter verified successfully");
	}

	public void verifyConditionFilter(List<Item> items, String columnNum){
		if(items.stream().anyMatch(x -> x.condition().toString().equalsIgnoreCase("critical")))
			Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'critical')]/span)[1]")).getText().equalsIgnoreCase(String.valueOf(items.stream().filter(x -> x.condition().toString().equalsIgnoreCase("critical")).count())),"Condition filter is not working as expected for critical flag", "Condition filter for critical flag verified successfully");
		else
			Validator.assertFalse(isLocatorVisible((By.xpath("(//td[" + columnNum + "]/span[contains(@class,'critical')]/span)[1]"))),"Critical flag should not be displayed", "Critical flag verified successfully");
		if(items.stream().anyMatch(x -> x.condition().toString().equalsIgnoreCase("fault")))
			Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'fault')]/span)[1]")).getText().equalsIgnoreCase(String.valueOf(items.stream().filter(x -> x.condition().toString().equalsIgnoreCase("fault")).count())),"Condition filter is not working as expected for fault flag", "Condition filter for fault flag verified successfully");
		else Validator.assertFalse(isLocatorVisible((By.xpath("(//td[" + columnNum + "]/span[contains(@class,'fault')]/span)[1]"))),"Fault flag should not be displayed", "Fault flag verified successfully");
		if(items.stream().anyMatch(x -> x.condition().toString().equalsIgnoreCase("poor")))
			Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'poor')]/span)[1]")).getText().equalsIgnoreCase(String.valueOf(items.stream().filter(x -> x.condition().toString().equalsIgnoreCase("poor")).count())),"Condition filter is not working as expected for poor flag", "Condition filter for fault poor verified successfully");
		else Validator.assertFalse(isLocatorVisible((By.xpath("(//td[" + columnNum + "]/span[contains(@class,'poor')]/span)[1]"))),"Poor flag should not be displayed", "Poor flag verified successfully");
		if(items.stream().anyMatch(x -> x.condition().toString().equalsIgnoreCase("good")))
			Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'good')]/span)[1]")).getText().equalsIgnoreCase(String.valueOf(items.stream().filter(x -> x.condition().toString().equalsIgnoreCase("good")).count())),"Condition filter is not working as expected for good flag", "Condition filter for good flag verified successfully");
		else Validator.assertFalse(isLocatorVisible((By.xpath("(//td[" + columnNum + "]/span[contains(@class,'good')]/span)[1]"))),"Good flag should not be displayed", "Good flag verified successfully");
	}

	public void verifyStatusFilter(String status){
		SyncUtil.waitFor(1000);
		inspectionDetailsItemStatusFilter.jsClick("Inspection status filter");
		dropdownSelect(inspectionStatusFilterDropdown, ListItem, status);
		applyFilter.click();
		if(status.equalsIgnoreCase("to be completed"))
			Validator.assertTrue(statusIncompleteIcon.isVisible(), "Status filter for to be completed is not working as expected", "Status filter for to be completed verified successfully");
		else
			Validator.assertTrue(statusCompleteIcon.isVisible(),"Status filter for completed is not working as expected", "Status filter for completed verified successfully");
	}

	public void verifyStatusFilter(String status, Long inProgressItemsCount){
		SyncUtil.waitFor(2000);
		inspectionDetailsItemStatusFilter.jsClick("Inspection status filter");
		dropdownSelect(inspectionStatusFilterDropdown, ListItem, status);
		applyFilter.click();
		if(status.equalsIgnoreCase("to be completed")) {
			Validator.assertTrue(statusIncompleteIcon.isVisible(), "Status filter for to be completed is not working as expected", "Status filter for to be completed verified successfully");
			Validator.assertTrue(statusIncompleteIcon.getText().equalsIgnoreCase(inProgressItemsCount.toString()),"Status count for to be completed is incorrect", "Status count for to be completed verified successfully");
		}
		else
			Validator.assertTrue(statusCompleteIcon.isVisible(),"Status filter for completed is not working as expected", "Status filter for completed verified successfully");
	}

	public void verifyInspectionName(String siteName){
		Validator.assertTrue(tbInspectionName.getAttribute("value").equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))+ " " + siteName),"Inspection name is not as expected", "Inspection name verified successfully");
	}

	public void verifyInspectionEventCreation(){
		createBtnEvent.click("Create event");
		setImplicitWait(20000,TimeUnit.MILLISECONDS);
		Validator.assertTrue(isLocatorVisible(By.xpath("//div[text()='Inspection updated.' or text()='Inspection created']")),"Inspection toast message on creation/updating not visible","Inspection toast message verified successfully");
		setImplicitWait(5000,TimeUnit.MILLISECONDS);
	}

	public boolean verifyInspectionItemsColumns(){
		SyncUtil.waitFor(1000);
		return numberColumn.isVisible("number column") && pictureColumn.isVisible("picture column") && conveyorColumn.isVisible("conveyor column") && assetColumn.isVisible("asset column") &&
				detailColumn.isVisible("detail column") && failureModeColumn.isVisible("Failure Mode column") && locationColumn.isVisible("location column") && conditionColumn.isVisible("condition column") && statusColumn.isVisible("Status column") && moreColumn.isVisible("more column");
	}

	public boolean verifyInspectionItemsColumnsVMC(){
		SyncUtil.waitFor(1000);
		return numberColumn.isVisible("number column") && pictureColumn.isVisible("picture column") && conveyorColumn.isVisible("conveyor column") && assetColumn.isVisible("asset column") &&
				detailColumn.isVisible("detail column") && locationColumn.isVisible("location column") && conditionColumn.isVisible("condition column") && statusColumn.isVisible("Status column") && moreColumn.isVisible("more column");
	}

	public boolean verifyAddInspectionItem(){
		waitForElementToBeClickable(btnAddInspection);
		btnAddInspection.click("Add New Inspection");
		waitForElementToDisplay(ddlConveyor);
		return popupHeader.getText().equalsIgnoreCase("Add Inspection item");
	}

	public boolean verifyCloseInspectionItem(){
		closePopup.click();
		SyncUtil.waitFor(500);
		return !popupHeader.isVisible();
	}

	public void verifyConveyorSelection(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
	}

	public void verifyItemSequencingDefault(List<Item> items) {
		int index = 1;
		SyncUtil.waitFor(2000);
		for(Item item: items){
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[5]")).getText());
			System.out.println(item.asset());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[5]")).getText().equalsIgnoreCase(item.asset()),"Asset sequencing for inspection item failed", "Asset sequencing for inspection item verified successfully");
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[9]/span/span")).getText());
			System.out.println(item.condition());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[9]/span/span")).getText().equalsIgnoreCase(item.condition().name()),"Condition sequencing for inspection item failed", "Condition sequencing for inspection item verified successfully");
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[4]")).getText());
			System.out.println(item.conveyorName());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[4]")).getText().equalsIgnoreCase(item.conveyorName()),"Conveyor sequencing for inspection item failed", "Conveyor sequencing for inspection item verified successfully");
			index++;
		}
	}

	public void verifyItemSequencingVMC(List<Item> items) {
		int index = 1;
		for(Item item: items){
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[5]")).getText());
			System.out.println(item.asset());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[5]")).getText().equalsIgnoreCase(item.asset()),"Asset sequencing for inspection item failed", "Asset sequencing for inspection item verified successfully");
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[8]/span/span")).getText());
			System.out.println(item.condition());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[8]/span/span")).getText().equalsIgnoreCase(item.condition().name()),"Condition sequencing for inspection item failed", "Condition sequencing for inspection item verified successfully");
			System.out.println(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[4]")).getText());
			System.out.println(item.conveyorName());
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr["+index+"]/td[4]")).getText().equalsIgnoreCase(item.conveyorName()),"Conveyor sequencing for inspection item failed", "Conveyor sequencing for inspection item verified successfully");
			index++;
		}
	}

	public void isSiteDisabledOnEdit(){
		Validator.assertTrue(!ddlSiteDropdownView.isEnabled(),"Site dropdown is enabled on edit mode", "Site dropdown on edit mode verified successfully");
	}

	public void searchInspectionItem(String conveyorItem, String assetName, String condition) {
		btSearchinput.type(conveyorItem, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		SyncUtil.waitFor(2000);
		if(assetColumn.isVisible())
			hoverOverElement(assetColumn);
		else hoverOverElement(assetColumnItemList);
		inspectionItemAssetFilter.click("Inspection asset filter");
		inspectionFilterInput.type(assetName);
		applyFilter.click();
		inspectionItemConditionFilter.jsClick("Inspection condition filter");
		inspectionFilterDropdown.click("filter dropdown");
		driver.findElement(By.xpath("//span[text()='"+condition+"']/../..//div[@class='p-checkbox-box']")).click();
		SyncUtil.waitFor(2000);
		cbCheckbox.isVisible("Inspection Item found");
	}

	public void goToEditInspectionItem(){
		cbCheckbox.click("checkbox");
		btnEdit.click();
		Validator.assertTrue(!ddlConveyorView.isEnabled() || ddlAssetView.isEnabled(),"Conveyor/asset field in edit inspection item is editable", "Edit inspection item fields verified successfully");
	}

	public void editInspectionConditionItem(String newCondition) {
		dropdownSelect(ddlCondition, ListItem, newCondition);
	}

	public void verifyInspectionAssetFilterFunctionality(String val, String colNum){
		SyncUtil.waitFor(1000);
		if(assetColumn.isVisible())
			hoverOverElement(assetColumn);
		else hoverOverElement(assetColumnItemList);
		SyncUtil.waitFor(1000);
		inspectionItemAssetFilter.click("Inspection Asset filter");
		inspectionFilterInput.type(val);
		applyFilter.click();
		Validator.assertTrue(driver.findElements(By.xpath("//tbody/tr")).size() == 1,"Asset filter is not working as expected", "Asset filter verified successfully");
	}

	public String getColumnFunctionality(String columnHeader) {
		scrollPageup();
		SyncUtil.waitFor(2000);
		waitForElementVisible(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")), 5000, 500);
		waitForElementToBeClickable(driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")));
		return driver.findElement(By.xpath("//th[@role='columnheader']/div[contains(text(),'" + columnHeader + "')]/..")).getAttribute("aria-sort");
	}

	public void selectingInspection(String conveyorName)
	{
		SyncUtil.waitFor(500);
		waitForElementVisible(btSearchinput,5000,500);
		btSearchinput.type(conveyorName, "Inspection Search");
		waitForElementToDisplay(cbCheckbox);
		cbCheckbox.click();
	}

	public void deleteInspectionItem() {
		ddlActions.click("Action");
		waitForElementToBeClickable(btnDelete);
		btnDeleteInspection.click("Delete Inspection Item");
		btnYes.click("Confirm delete");
		waitForElementToInvisible(buttonLoader,3000);
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
	}

	public void verifyDeleteInspectionItem(String conveyor) {
		btSearchinput.type(conveyor, "Inspection Search");
		waitForElementToDisplay(noList);
		noList.isVisible("No Item Found");
		Validator.assertTrue(Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)")) == 0, "Inspection items were not deleted", "Inspection item list was not found");
	}

	public void verifyMultiEventActionBtn()
	{
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnDeleteInspection, 10000,500);
		Validator.assertTrue(btnDeleteInspection.isVisible("Delete btn") && !btnEditInspection.isVisible(), "Action available for multi inspection event selection is incorrect", "Action available for multi inspection event verified successfully");
	}

	public void verifySingleEventActionBtn()
	{
		waitForElementVisible(ddlActions,5000,500);
		ddlActions.click("Actions");
		waitForElementVisible(btnDeleteInspection, 10000,500);
		Validator.assertTrue(btnDeleteInspection.isVisible("Delete btn") && btnEditInspection.isVisible(), "Action available for multi inspection event selection is incorrect", "Action available for multi inspection event verified successfully");
	}

	public void verifyDeleteBtnClick()
	{
		waitForElementVisible(btnDeleteInspection,10000,500);
		waitForElementToBeClickable(btnDeleteInspection);
		btnDeleteInspection.click();
		waitForElementVisible(deleteDialogbox,5000,500);
		waitForElementVisible(btnYes,5000,500);
		waitForElementToBeClickable(btnYes);
		btnYes.click();
		waitForElementToDisplay(noList);
		SyncUtil.waitFor(1000);
	}

	public void verifyStatusForToBeCompleted(String inspectionName, String statusCount) {
		searchInspection(inspectionName);
		Validator.assertTrue(statusIncompleteIcon.isVisible(),"Status icon for to be completed is not displayed", "Status icon for to be completed verified successfully");
		Validator.assertTrue(statusIncompleteIcon.getText().equalsIgnoreCase(statusCount), "Status count for to be completed is incorrect", "Status count for to be completed verified successfully");
	}

	public void verifyStatusForCompleted(String inspectionName) {
		searchInspection(inspectionName);
		Validator.assertTrue(statusCompleteIcon.isVisible(),"Status icon for completed is not displayed", "Status icon for completed verified successfully");
	}


	public void verifyFlagColumn(List<Item> allItems, String count) {
		allItems.forEach(
				x-> {
					if(!x.isCompleted()) {
						Validator.assertTrue(driver.findElement(By.xpath("(//td[10]/span[contains(@class,'" + x.condition().name().toLowerCase() + "')])[1]")).isDisplayed(), "Condition flags is not working as expected", "Condition flags verified successfully");
						Validator.assertTrue(driver.findElement(By.xpath("(//td[10]/span[contains(@class,'" + x.condition().name().toLowerCase() + "')])[1]/span")).getText().equalsIgnoreCase(count), "Condition flags count is not working as expected", "Condition flags count verified successfully");
					}
					else Validator.assertFalse(isLocatorVisible(By.xpath("(//td[10]/span[contains(@class,'"+x.condition().name().toLowerCase()+"')])[1]")),"Condition flags is not working as expected", "Condition flags verified successfully");
				});
	}

	public void verifyInspectionExpand(String inspectionName) {
		searchInspection(inspectionName);
		detailIcon.click();
		Validator.assertTrue(pictureColumnExpand.isVisible(),"Item table is not visible on expand", "Item table on expand verified successfully");
	}

	public boolean verifyExpandedListViewColumns() {
		setImplicitWait(10000, TimeUnit.MILLISECONDS);
		return numberColumnExpand.isEnable("Inspection Number") && pictureColumnExpand.isEnable("Picture") && conveyorColumnExpand.isEnable("Conveyor") && assetColumnExpand.isEnable("Asset") && detailColumnExpand.isEnable("Details") && failureModeColumnExpand.isEnable("Failure Mode") && locationColumnExpand.isEnable("Location") && conditionColumnExpand.isEnable("Condition") && statusColumnExpand.isEnable("Status") && moreColumnExpand.isEnable("More");
	}

	public void verifyAllInspectionItems(List<Item> allItems) {
		SyncUtil.waitFor(2000);
		AtomicInteger i = new AtomicInteger(1);
		allItems.forEach(x -> {
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(x.conveyorName()), "Conveyor name in expanded list table is not as expected", "Conveyor name in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(x.asset()), "Asset name in expanded list table is not as expected", "Asset name in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[8]/span/span")).getText().equalsIgnoreCase(x.condition().name()), "Condition in expanded list table is not as expected", "Condition in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[9]/span")).getText().equalsIgnoreCase(x.isCompleted()?"Completed": "To be Completed"), "Status in expanded list table is not as expected", "Status in expanded list table verified successfully");
			i.incrementAndGet();
		});
	}

	public void verifyAllInspectionItemsVMC(List<Item> allItems) {
		SyncUtil.waitFor(2000);
		AtomicInteger i = new AtomicInteger(1);
		allItems.forEach(x -> {
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(x.conveyorName()), "Conveyor name in expanded list table is not as expected", "Conveyor name in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[4]")).getText().equalsIgnoreCase(x.asset()), "Asset name in expanded list table is not as expected", "Asset name in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[7]/span/span")).getText().equalsIgnoreCase(x.condition().name()), "Condition in expanded list table is not as expected", "Condition in expanded list table verified successfully");
			Validator.assertTrue(driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr["+i+"]/td[8]/span")).getText().equalsIgnoreCase(x.isCompleted()?"Completed": "To be Completed"), "Status in expanded list table is not as expected", "Status in expanded list table verified successfully");
			i.incrementAndGet();
		});
	}

	public void verifyExpandedListMapLocation() {
		Validator.assertTrue(driver.findElements(By.xpath("//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr/td[7]//span[not(@class='disableMap')]")).size() == 1, "Location in expanded list table is not as expected", "Location in expanded list table verified successfully");
		driver.findElement(By.xpath("(//tbody/tr/td[contains(@class,'expansion-col')]//tbody/tr/td[7]//span[not(@class='disableMap')])[1]")).click();
		Validator.assertTrue(mapLocationDialog.isVisible(),"Map Location popup verification failed", "Map Location popup verified successfully");
		mapLocationDialogClose.click();
	}

	public void inspectionEventsListCount(String insp){
		Integer inspectionCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		System.out.println(inspectionCount);
		waitForPageLoad(5000);
		Validator.assertTrue(inspectionCount.toString().equalsIgnoreCase(insp), "Number of inspection events in pagination list doesnt match","Inspection count for inspection events verification was successful");
	}


	public void inspectionPaginationFunctionality(){
		Validator.assertTrue(btCurrentPage.getText().equalsIgnoreCase("1"),"Pagination first page is not highlighted", "Pagination for first page is verified successfully");
		btNextPage.click();
		Validator.assertTrue(btCurrentPage.getText().equalsIgnoreCase("2"),"Pagination second page is not highlighted", "Pagination for second page is verified successfully");
	}

	public void inspectionPaginationLimit(){
		Validator.assertTrue(btPageLimit.getText().equalsIgnoreCase(String.valueOf(driver.findElements(By.xpath("//tbody/tr")).size())),"Pagination initial page limit is incorrect", "Pagination for page limit is verified successfully");
		dropdownSelect(btPageDropdown, ListItem, "50");
		Validator.assertTrue(btPageLimit.getText().equalsIgnoreCase(String.valueOf(driver.findElements(By.xpath("//tbody/tr")).size())),"Pagination after change page limit is incorrect", "Pagination for page limit is verified successfully");
	}

	public void verifyInspectionListWithCardCount(int totalInspectionsCountFromCard){
		Integer inspectionCountFromList = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
		System.out.println(inspectionCountFromList);
		waitForPageLoad(5000);
		Validator.assertTrue(inspectionCountFromList == totalInspectionsCountFromCard, "Number of inspection items in pagination list doesnt match","Inspection count for inspection items verification was successful");
	}

	public void addItemStatusFilter(String status){
		inspectionItemStatusFilter.jsClick("Inspection status filter");
		dropdownSelect(inspectionStatusFilterDropdown, ListItem, status);
		applyFilter.click();
		if(status.equalsIgnoreCase("to be completed"))
			Validator.assertTrue(statusIncomplete.isVisible(),"Status filter for to be completed is not working as expected", "Status filter for to be completed verified successfully");
		else
			Validator.assertTrue(statusComplete.isVisible(),"Status filter for completed is not working as expected", "Status filter for completed verified successfully");
	}

	public void addItemConditionFilter(String condition){
		inspectionItemConditionFilter.jsClick("Inspection condition filter");
		inspectionFilterDropdown.click("filter dropdown");
		SyncUtil.waitFor(500);
		driver.findElement(By.xpath("//span[text()='"+condition+"']/../..//div[@class='p-checkbox-box']")).click();
	}

	public void verifyItemConditionFilter(String condition, String columnNum){
		if(!inspectionFilterDropdown.isEnable())
			inspectionItemConditionFilter.jsClick("Inspection condition filter");
		if(inspectionFilterDropdown.isEnable())
			inspectionFilterDropdown.click("filter dropdown");
		driver.findElement(By.xpath("//span[text()='"+condition+"']/../..//div[@class='p-checkbox-box']")).click();
		SyncUtil.waitFor(2000);
		Validator.assertTrue(driver.findElement(By.xpath("(//td["+columnNum+"]/span[contains(@class,'"+condition.toLowerCase()+"')])[1]")).isDisplayed(),"Condition filter is not working as expected", "Condition filter verified successfully");
	}

	public boolean verifyColumnInspectionItems(){
		return pictureColumnItemList.isVisible("Picture column") && inspectionDateItemList.isVisible("Inspection Date column") && corporateColumnItemList.isVisible("corporate column") && siteColumnItemList.isVisible("site column") &&
				conveyorColumnItemList.isVisible("conveyor column") && inspectorColumnItemList.isVisible("inspector column") && assetColumnItemList.isVisible("asset column") && detailColumnItemList.isVisible("detail column") && failureModeColumnItemList.isVisible("failure mode column") && modifiedDateColumnItemList.isVisible("modified date column")
				&& conditionColumnItemList.isVisible("condition column") && statusColumnItemList.isVisible("status column") && moreColumnItemList.isVisible("more column");
	}

	public void enableAllColumnSelection(){
		columnSelectionBtn.click("Column Selection");
		if(ddlMultipleSelection.getAttribute("aria-label").contains("unselected"))
			ddlMultipleSelection.click("Select all column");
		multiSelectCloseBtn.click();
	}

	public void verifyEditInspectionItemListNav(String asset, String newStatus){
		if(cbCheckboxInput.getAttribute("aria-label") == null || cbCheckboxInput.getAttribute("aria-label").equalsIgnoreCase("Row Selected"))
			cbCheckbox.click();
		ddlActions.click("Actions");
		waitForElementVisible(btnEditInspection, 10000, 500);
		btnEditInspection.click("Edit");
		waitForElementToInvisible(spinner,4000);
		itemDialogTitle.verifyText("Edit Inspection Item - "+asset);
		if(newStatus.equalsIgnoreCase("completed"))
			ddlStatusCompleted.click();
		else ddlStatusToBeCompleted.click();
		btnSaveItem.click("Save");
		waitForElementToDisplay(inspectionUpdateMsg);
		new InspectionItemSequencing().addItems(getRowData());
		Reporter.log("Inspection Item is Updated", MessageTypes.Pass);
	}

	public void verifyDeleteInspectionItemListNav(String inspectionName){
		if(!cbCheckboxInput.isEnabled())
			cbCheckbox.click();
		ddlActions.click("Actions");
		waitForElementVisible(btnDeleteInspection, 10000, 500);
		btnDeleteInspection.click("Delete");
		waitForElementVisible(deleteDialogbox,5000,500);
		waitForElementVisible(confirmBtn,5000,500);
		waitForElementToBeClickable(confirmBtn);
		confirmBtn.click();
		waitForElementToDisplay(noList);
		SyncUtil.waitFor(1000);
		Reporter.log("Inspection Item is Deleted", MessageTypes.Pass);
	}

	public void refreshTable(){
		scrollPageup();
		cbRefresh.click();
		SyncUtil.waitFor(10000);
	}

	public void verifyPDFHeader(String fullName, String custSiteName, String inspectionName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains("Generated By: "+fullName), "PDF Report was generated for the wrong inspector", "PDF Report was generated for the right inspector");
			Validator.assertTrue(val.contains(custSiteName), "PDF Report was generated for the wrong customer Site", "PDF Report was generated for the right customer Site");
			Validator.assertTrue(val.contains(inspectionName), "PDF Report was generated for the wrong inspection", "PDF Report was generated for the right inspection");
			Validator.assertTrue(val.contains("Generated Date: "+LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))), "PDF Report was generated for the wrong date", "PDF Report was generated for the right date");
			Validator.assertTrue(val.matches(".*" + "Continental AG 2025. All Rights Reserved.".replaceAll("\\d{4}", "\\\\d{4}") + ".*"), "PDF Report was generated with incorrect footer", "PDF Report was generated with the right footer");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPDFInspection(String conveyor, String asset, String condition, String status, String inspectionName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains(asset), "PDF Report was generated for the wrong asset", "PDF Report was generated for the right asset");
			Validator.assertTrue(val.contains("Inspections - "+conveyor), "PDF Report was generated for the wrong conveyor", "PDF Report was generated for the right conveyor");
			Validator.assertTrue(val.contains(condition), "PDF Report was generated for the wrong condition", "PDF Report was generated for the right condition");
			Validator.assertTrue(val.contains(status), "PDF Report was generated for the wrong status", "PDF Report was generated for the right status");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void verifyMetricUnitPDF(String inspectionName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains("Belt Width (mm)"), "PDF Report for belt width metric verification failed", "PDF Report for belt width metric verified successfully");
			Validator.assertTrue(val.contains("Breaking Strength (N/mm)"), "PDF Report for Breaking Strength metric verification failed", "PDF Report for Breaking Strength metric verified successfully");
			Validator.assertTrue(val.contains("Top Cover Thickness (mm)"), "PDF Report for Top Cover Thickness metric verification failed", "PDF Report for Top Cover Thickness metric verified successfully");
			Validator.assertTrue(val.contains("Bottom Cover Thickness (mm)"), "PDF Report for Bottom Cover Thickness metric verification failed", "PDF Report for Bottom Cover Thickness metric verified successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyImperialUnitPDF(String inspectionName) {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		try {
			String val = PDFHelper.getPageContent(doc).replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
			System.out.println(val);
			Validator.assertTrue(val.contains("Belt Width (in)"), "PDF Report for belt width imperial verification failed", "PDF Report for belt width imperial verified successfully");
			Validator.assertTrue(val.contains("Belt Rating (piw)"), "PDF Report for Breaking Strength imperial verification failed", "PDF Report for Breaking Strength imperial verified successfully");
			Validator.assertTrue(val.contains("Top Cover Thickness (in)"), "PDF Report for Top Cover Thickness imperial verification failed", "PDF Report for Top Cover Thickness imperial verified successfully");
			Validator.assertTrue(val.contains("Bottom Cover Thickness (in)"), "PDF Report for Bottom Cover imperial metric verification failed", "PDF Report for Bottom Cover Thickness imperial verified successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchUnits(String val){
		unitConv.click();
		if(val.equalsIgnoreCase("imperial"))
			imperial.click();
		else metric.click();
	}

	public boolean assetDisplaySequenceVMC(){
		return ddlAssetTailPulley.isVisible("Tail Pulley") && ddlAssetBelt.isVisible("Asset Belt") && ddlAssetOtherPulley.isVisible("Other Pulley") &&
				ddlAssetBeltAlignment.isVisible("Asset Belt Alignment") && ddlAssetIdlers.isVisible("Asset Idlers") && ddlAssetDrivePulley.isVisible("Drive Pulley");
	}

	public boolean assetTailPulleyVMC(){
		return laggingConditionTail.isVisible("Lagging Condition") && wiperConditionTail.isVisible("Wiper Condition") && skirtConditionTail.isVisible("Skirt Condition") && loadZoneTail.isVisible("Load Zone");
	}

	public boolean assetBeltVMC(){
		return spliceCondition1Belt.isVisible("Splice Condition 1") && spliceCondition2Belt.isVisible("Splice Condition 2") && topCoverBelt.isVisible("Top Cover") && bottomCoverBelt.isVisible("Bottom Cover") && visibleDamageBelt.isVisible("Visible damage");
	}

	public boolean assetOtherPulleyVMC(){
		return tensionTakeUp.isVisible("Tension takeup") && snubPulleyTakeUp.isVisible("Snub Pulley") && binPulleyTakeUp.isVisible("Bin Pulley") && counterWeightTakeUp.isVisible("CounterWeight");
	}

	public boolean assetBeltAlignmentVMC(){
		return takeUpBeltAlignment.isVisible("Take-up") && headBeltAlignment.isVisible("Head Pulley") && tailBeltAlignment.isVisible("Tail Pulley") && overallBeltAlignment.isVisible("Overall");
	}

	public boolean assetIdlersVMC(){
		return brokenIdler.isVisible("Broken/Frozen");
	}

	public boolean assetDefault() {
		return ddlAssetConveyorBelt.isVisible("Conveyor Belt") && ddlAssetRollersIdlers.isVisible("Roller Idlers") && ddlAssetPulley.isVisible("Pulley") && ddlAssetChutes.isVisible("Chutes") && ddlAssetRollerFrames.isVisible("Roller Frames")
				&& ddlAssetTrackingFrames.isVisible("Tracking Frames") && ddlAssetCounterweight.isVisible("Counterweight") && ddlAssetDriveMotor.isVisible("Drive Motor") && ddlAssetConveyorStructure.isVisible("Conveyor Structure") && ddlAssetOthers.isVisible("Others");
	}

	public boolean assetDetailsDefaultForChutes(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetChutes.click();
		ddlDetails.click();
		List<String> chutesDetails = List.of("Chute","Impact Bed","Impact Rails","Line Plates","Poly Skirt Rubber","Skirt Board","Skirt Plate Rails","Skirt Plate","Skirt Rubber","Skirting System","Other");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(chutesDetails);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(chutesDetails);
	}

	public boolean assetDetailsDefaultForCounterweight(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetCounterweight.click();
		ddlDetails.click();
		List<String> counterweightDetails = List.of("Counterweight Structural Guides","Counterweight Wire Rope","Grease Lines","Pulley Deflector Plate","Pulleys","Screw Take Up Tension","Sheave Blocks","Trolley Structure","Other");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(counterweightDetails);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(counterweightDetails);
	}

	public boolean assetDetailsDefaultForConveyorStructure(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetConveyorStructure.click();
		ddlDetails.click();
		List<String> conveyorStructureDetails = List.of("Decking (Grid Mesh)","Guarding","Roller Frame","Stringers","Support Beams","Support Beams","Support Legs","Walkways","Other");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(conveyorStructureDetails);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(conveyorStructureDetails);
	}

	public boolean assetFailureModeDefaultForChutes(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetChutes.click();
		ddlFailureMode.click();
		List<String> chutesFailureMode = List.of("Bent","Broken","Causing damage to the belt","Corroded","Damaged","Loose/Needs Adjusting","Missing","Out of Alignment","Poly Skirt Worn","Skirt Plate","Skit Rubber Worn","Wear Observed on Impact Rails","Other");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(chutesFailureMode);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(chutesFailureMode);
	}

	public boolean assetFailureModeDefaultForCounterweight(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetConveyorStructure.click();
		ddlFailureMode.click();
		List<String> chutesFailureMode = List.of("Bent","Broken","Causing damage to the belt","Corroded","Damaged","Loose/Needs Tightening","Missing","Out of Alignment","Spillage","Other");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(chutesFailureMode);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(chutesFailureMode);
	}

	public boolean assetFailureModeDefaultForConveyorStructure(String conveyorName) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		ddlAssetConveyorStructure.click();
		ddlFailureMode.click();
		List<String> chutesFailureMode = List.of("Bent","Broken","Out of Alignment","Corroded","Damaged","Missing","Out of Alignment","Causing damage to the belt");
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(chutesFailureMode);
		verifyCloseInspectionItem();
		return dropdownValues.stream().distinct().toList().equals(chutesFailureMode);
	}

	public boolean assetDrivePulleyVMC() {
		return laggingConditionDrive.isVisible("Lagging Condition") && primaryConditionDrive.isVisible("Primary cleaning condition") && secondaryConditionDrive.isVisible("Secondary cleaning condition");
	}

	public boolean verifyBeltAlignmentMsg() {
		return beltAlignmentDetailsMsg1.isVisible("Fault message") && beltAlignmentDetailsMsg2.isVisible("Good message");
	}

	public boolean verifyGeneralMsg() {
		return generalDetailsMsg1.isVisible("Critical message") && generalDetailsMsg2.isVisible("Fault message") && generalDetailsMsg3.isVisible("Good message");
	}

	public boolean verifyNoGeneralMsg() {
		return !generalDetailsMsg1.isVisible() && !generalDetailsMsg2.isVisible() && !generalDetailsMsg3.isVisible();
	}

	public boolean verifyDetailsWithConditionVMC(String asset, String details, String conveyorName, List<String> conditions){
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		assetVMCTemplateSelection(asset, details);
		ddlCondition.click();
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(conditions);
		return dropdownValues.stream().distinct().toList().equals(conditions);
	}

	public boolean verifyDetailsWithConditionDefault(String asset, String details, String conveyorName, List<String> conditions){
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		defaultAssetTemplateSelection(asset);
		ddlCondition.click();
		List<String> dropdownValues = driver.findElements(ListItem)
				.stream()
				.map(element -> element.getAttribute("innerText").trim())
				.collect(Collectors.toList());
		System.out.println(dropdownValues.stream().distinct().toList());
		System.out.println(conditions);
		return dropdownValues.stream().distinct().toList().equals(conditions);
	}

	public boolean verifyObservationAsterisk(String condition) {
		ddlCondition.click();
		dropdownSelect(ddlCondition, ListItem, condition);
		return observationAsterisk.isEnable("Observation asterisk") && !createBtnItem.isEnabled();
	}

	public boolean verifyObservationNonMandatory(String condition) {
		ddlCondition.click();
		dropdownSelect(ddlCondition, ListItem, condition);
		return !observationAsterisk.isEnable() && createBtnItem.isEnabled();
	}

	public boolean verifyObservationMandatory() {
		eleObservation.sendKeys("test");
		return createBtnItem.isEnabled();
	}

	public void imageZoomOutFunctionality(){
		appImgViewer.click("image viewer");
		SyncUtil.waitFor(3000);
		System.out.println(imgWindow.getAttribute("style"));
		double intVal = Double.parseDouble(MiscUtils.regexExtractor(imgWindow.getAttribute("style"), "([-+]?[0-9]*\\.?[0-9]+)"));
		appImgMinimize.jsClick();
		SyncUtil.waitFor(3000);
		System.out.println(imgWindow.getAttribute("style"));
		double finalVal = Double.parseDouble(MiscUtils.regexExtractor(imgWindow.getAttribute("style"), "([-+]?[0-9]*\\.?[0-9]+)"));
		Validator.assertTrue(intVal>finalVal, "Image minimize not working as expected","Image minimize verified successfully");
		imgClose.click();
	}

	public void imageZoomInFunctionality(){
		appImgViewer.click("image viewer");
		SyncUtil.waitFor(3000);
		System.out.println(imgWindow.getAttribute("style"));
		double intVal = Double.parseDouble(MiscUtils.regexExtractor(imgWindow.getAttribute("style"), "([-+]?[0-9]*\\.?[0-9]+)"));
		appImgMaximize.jsClick();
		SyncUtil.waitFor(3000);
		System.out.println(imgWindow.getAttribute("style"));
		double finalVal = Double.parseDouble(MiscUtils.regexExtractor(imgWindow.getAttribute("style"), "([-+]?[0-9]*\\.?[0-9]+)"));
		Validator.assertTrue(intVal<finalVal, "Image maximize not working as expected","Image maximize verified successfully");
		imgClose.click();
	}

	public void getPdfImages(String inspectionName) throws IOException {
		PDDocument doc = PDFHelper.getPDFData(System.getProperty("user.dir") + separator + "target" + separator + "downloads" + separator + inspectionName + ".pdf");
		System.out.println(PDFHelper.getPDFImagesCount(doc));
	}

	public void verifyDuplicateItemRecordsVMC(String conveyorName, String assetName, String assetDetails) {
		dropdownSelectSearch(ddlConveyor, tbInput, conveyorName);
		Validator.assertFalse(isVMCDuplicateTemplateSelection(assetName,assetDetails),"Duplicate records allowed in VMC", "Duplicate items records for VMC verified successfully");
	}

	public boolean verifyDashboardHeader() {
		return dashboardHeader.isVisible();
	}

	public boolean verifyActionDropdownDashbaord() {
		ddlActions.click();
		return btnExportInspection.isVisible();
	}

	public boolean verifyDashboardOptions() {
		return dashboardHeader.isVisible() && clearFilterBtn.isVisible() && columnSelectionBtn.isVisible() && btSearchinput.isVisible() && siteDashboardFilter.isVisible() &&
				inspectionStartDate.isVisible() && inspectionEndDate.isVisible() && inspectionItemStatusPieChart.isVisible() && inspectionItemAssetPieChart.isVisible();
	}

	public boolean verifyConditionCards(){
		return txtDashboardTotalCount.isVisible() && txtDashboardGoodCount.isVisible() && txtDashboardFaultCount.isVisible() && txtDashboardPoorCount.isVisible() && txtDashboardCriticalCount.isVisible();
	}

	public boolean verifyConditionCardsVMC(){
		return txtDashboardTotalCount.isVisible() && txtDashboardGoodCount.isVisible() && txtDashboardFaultCount.isVisible() && !txtDashboardPoorCount.isVisible() && txtDashboardCriticalCount.isVisible();
	}

	public boolean verifyDashboardPieChart() {
		return inspectionItemStatusPieChart.isVisible() && inspectionItemAssetPieChart.isVisible();
	}

	public boolean verifyDashboardTable() {
		return assetsCol.isVisible() && failureModeCol.isVisible() && inspectionItemPercentageCol.isVisible() && inspectionItemCol.isVisible();
	}

	public boolean verifyDashboardTableVMC() {
		return assetsCol.isVisible() && !failureModeCol.isVisible() && inspectionItemPercentageCol.isVisible() && inspectionItemCol.isVisible();
	}

	public String verifySiteSelection(String siteName) {
		dropdownSelectSearch(siteDashboardFilter,tbSiteDropdownInput,siteName);
		return tbSiteDropdownView.getText();
	}

	public String verifyDateSelection(String siteName) {
		inspectionStartDateView.click();
		selectGivenDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(inspectionStartDate.getAttribute("value"));
		return inspectionStartDate.getAttribute("value");
	}

	public String verifyEndDateSelection(String siteName) {
		inspectionEndDateView.click();
		selectGivenDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(inspectionStartDate.getAttribute("value"));
		return inspectionStartDate.getAttribute("value");
	}
}
