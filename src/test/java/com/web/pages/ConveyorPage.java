package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.CSVUtil;
import com.qmetry.qaf.automation.util.PoiExcelUtil;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

public class ConveyorPage extends BasePage{

    @FindBy(locator = "xpath=//span[text()='Add Conveyor']")
    public CustomElement addConveyors;

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Conveyors'])[1]")
    public CustomElement conveyorList;

    @FindBy(locator = "xpath=//input[@id='firstname1']")
    public CustomElement tbConveyorname;

    @FindBy(locator= "xpath=//label[text()='Site']/following::span[1]")
    public CustomElement drSitedropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbSitedropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-multiselect-filter')]")
    public CustomElement tbMultipleSiteDropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbAssociatedSitedropdown;

    @FindBy(locator= "xpath=//p-dropdown[@datakey='companyId']/div/div[2]")
    public CustomElement drDistShopdropdown;

    @FindBy(locator = "xpath=//span[@class='p-menuitem-text ng-star-inserted'][text()='Home']")
    public CustomElement breakcrumHome;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon pi pi-refresh'])[2]")
    public CustomElement btRefresh;

    @FindBy(locator="xpath=(//td//img)[1]")
    public CustomElement crImg;

    @FindBy(locator="xpath=(//td//i)[1]")
    public CustomElement crPin;

    @FindBy(locator="xpath=(//td[4])[1]")
    public CustomElement crName;

    @FindBy(locator="xpath=(//td[5])[1]")
    public CustomElement crSite;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=//span[text()='Save and Close']")
    public CustomElement btSaveandclose;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement buttonLoader;

    @FindBy(locator = "xpath=(//div[text()='Minuteman Calc.']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crMinutemanCalc;

    @FindBy(locator = "xpath=(//div[text()='Monitoring Devices']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crMonitoringDevices;

    @FindBy(locator = "xpath=(//div[text()='Conveyor Inspect']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crConveyorInspect;

    @FindBy(locator = "xpath=(//div[text()='Inspections']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crInspections;

    @FindBy(locator = "xpath=(//div[text()='Cover Wear']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crCoverWear;

    @FindBy(locator = "xpath=(//div[text()='File Manager']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crFileManager;

    @FindBy(locator = "xpath=(//div[text()='Conveyor History']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crConveyorHistory;

    @FindBy(locator = "xpath=(//div[text()='Technical Data']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crTechnicalDataCard;

    @FindBy(locator = "xpath=//span[text()='Conveyor-Lite']")
    public CustomElement crConveyorLiteTab;

    @FindBy(locator = "xpath=//span[text()='Installed Belt']")
    public CustomElement crInstalledBeltTab;

    @FindBy(locator = "xpath=//span[text()='Material']")
    public CustomElement crMaterialTab;

    @FindBy(locator = "xpath=//span[text()='Conveyor']")
    public CustomElement crConveyorTab;

    @FindBy(locator = "xpath=//span[text()='Wear Life']")
    public CustomElement crWearLifeTab;

    @FindBy(locator = "xpath=//span[text()='Idlers']")
    public CustomElement crIdlersTab;

    @FindBy(locator = "xpath=//span[text()='Pulleys']")
    public CustomElement crPulleysTab;

    @FindBy(locator = "xpath=//span[text()='Transition Zone']")
    public CustomElement crTransitionZoneTab;

    @FindBy(locator = "xpath=//span[text()='Remarks']")
    public CustomElement crRemarksTab;

    @FindBy(locator = "xpath=(//label[text()='Belt Width ']/..//input)[2]")
    public CustomElement crBeltWidth;

    @FindBy(locator = "xpath=//label[text()='Belt Speed ']/..//input")
    public CustomElement crBeltSpeed;

    @FindBy(locator = "xpath=//label[text()='Tons per Hour Peak']/..//input")
    public CustomElement crTonsPerHr;

    @FindBy(locator = "xpath=(//label[text()='Pick Material Name ']/..//input)[2]")
    public CustomElement crMaterialName;

    @FindBy(locator = "xpath=//label[text()='Material Density ']/..//input")
    public CustomElement crMaterialDensity;

    @FindBy(locator = "xpath=//label[text()='Angle of Idlers ']/..//input")
    public CustomElement crAngleOfIdlers;

    @FindBy(locator = "xpath=//label[text()='Carry Side Idler Spacing ']/..//input")
    public CustomElement crIdlerSpacing;

    @FindBy(locator = "xpath=(//label[text()='Drive Wrap Angle ']/..//input)[2]")
    public CustomElement crDriveWrapAngle;

    @FindBy(locator = "xpath=//label[text()='Take-up Tension (if known) ']/..//input")
    public CustomElement crTakeUpTension;

    @FindBy(locator = "xpath=(//label[text()='Friction Factor ']/../..//input[@type='radio'])[1]")
    public CustomElement crPermanentFriction;

    @FindBy(locator = "xpath=(//label[text()='Friction Factor ']/../..//input[@type='radio'])[2]")
    public CustomElement crTemporaryFriction;

    @FindBy(locator = "xpath=//label[text()='Friction Factor']/..//input")
    public CustomElement crFrictionFactor;

    @FindBy(locator = "xpath=//label[text()='Length factor']/..//input")
    public CustomElement crLengthFactor;

    @FindBy(locator = "xpath=(//label[text()='Surcharge Angle ']/..//input)[2]")
    public CustomElement crSurchargeFactor;

    @FindBy(locator = "xpath=(//label[text()='Idler Offset Type ']/..//input)[2]")
    public CustomElement crIdleOffsetType;

    @FindBy(locator = "xpath=//label[contains(text(),'Drive Details')]/..//input")
    public CustomElement crDriveDetails;

    @FindBy(locator = "xpath=//label[contains(text(),'Take-up Details')]/..//input")
    public CustomElement crTakeupDetails;

    @FindBy(locator = "xpath=(//label[contains(text(),'Configuration')]/..//input)[1]")
    public CustomElement crMonolithConfig;

    @FindBy(locator = "xpath=(//label[contains(text(),'Configuration')]/..//input)[2]")
    public CustomElement crMixedConfig;

    @FindBy(locator = "xpath=(//label[contains(text(),'Belt Manufacturer')]/..//input)[2]")
    public CustomElement crBeltConfig;

    @FindBy(locator = "xpath=(//label[contains(text(),'Belt Construction')]/..//input)[2]")
    public CustomElement crBeltConstruction;

    @FindBy(locator = "xpath=(//label[contains(text(),'Top Cover Compound')]/..//input)[2]")
    public CustomElement crTopCompound;

    @FindBy(locator = "xpath=(//label[contains(text(),'Bottom Cover Compound')]/..//input)[2]")
    public CustomElement crBottomCompound;

    @FindBy(locator = "xpath=(//label[contains(text(),'Carcass')]/..//input)[2]")
    public CustomElement crCarcass;

    @FindBy(locator = "xpath=(//label[contains(text(),'Width')]/..//input)[2]")
    public CustomElement crWidth;

    @FindBy(locator = "xpath=//input[@value='Rating']")
    public CustomElement crRatingRadio;

    @FindBy(locator = "xpath=//input[@value='BreakingStrength']")
    public CustomElement crBreakingStrengthRadio;

    @FindBy(locator = "xpath=(//label[contains(text(),'Breaking Strength')]/..//input)[2]")
    public CustomElement crBreakingStrength;

    @FindBy(locator = "xpath=(//label[contains(text(),'Top Cover Thickness')]/..//input)[2]")
    public CustomElement crTopCoverThickness;

    @FindBy(locator = "xpath=(//label[contains(text(),'Bottom Cover Thickness')]/..//input)[2]")
    public CustomElement crBottomCoverThickness;

    @FindBy(locator = "xpath=(//label[contains(text(),'Length')]/..//input)[2]")
    public CustomElement crLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Splice / Type')]/..//input")
    public CustomElement crSplice;

    @FindBy(locator = "xpath=//label[contains(text(),'Splices Quantity')]/..//input")
    public CustomElement crSpliceQuality;

    @FindBy(locator = "xpath=//label[contains(text(),'Installation Date')]/..//input")
    public CustomElement crInstallationDate;

    @FindBy(locator = "xpath=(//label[contains(text(),'Description')]/..//input)[2]")
    public CustomElement crDescription;

    @FindBy(locator = "xpath=//label[contains(text(),'Bulk Density')]/..//input")
    public CustomElement crBulkDensity;

    @FindBy(locator = "xpath=//label[contains(text(),'Bulk Size')]/..//input")
    public CustomElement crBulkSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Lump Size')]/..//input")
    public CustomElement crLumpSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Granular Size')]/..//input")
    public CustomElement crGranularSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Contingent of Fines')]/..//input")
    public CustomElement crContingentOfFines;

    @FindBy(locator = "xpath=//label[contains(text(),'Aggresivity')]/..//input")
    public CustomElement crAggresivity;

    @FindBy(locator = "xpath=//label[contains(text(),'Density Type')]/..//input")
    public CustomElement crDensityType;

    @FindBy(locator = "xpath=//label[contains(text(),'Chute Drop')]/..//input")
    public CustomElement crChuteDrop;

    @FindBy(locator = "xpath=//label[contains(text(),'Loading Frequecy')]/..//input")
    public CustomElement crLoadingFrequency;

    @FindBy(locator = "xpath=//label[contains(text(),'Loading Conditions')]/..//input")
    public CustomElement crLoadingConditions;

    @FindBy(locator = "xpath=//label[text()='Temperature']/..//input")
    public CustomElement crTemperature;

    @FindBy(locator = "xpath=//label[text()='Feeding Conditions']/..//input")
    public CustomElement crFeedingConditions;

    @FindBy(locator = "xpath=//label[text()='Presence of Oil']/..//input")
    public CustomElement crPresenceOfOil;

    @FindBy(locator = "xpath=(//label[text()='Conveying Length']/..//input)[2]")
    public CustomElement crConveyingLength;

    @FindBy(locator = "xpath=(//label[text()='Lift']/..//input)[2]")
    public CustomElement crLift;

    @FindBy(locator = "xpath=(//label[contains(text(),'Drive Power')]/..//input)[2]")
    public CustomElement crDrivePower;

    @FindBy(locator = "xpath=(//label[contains(text(),'Gear Ratio')]/..//input)[2]")
    public CustomElement crGearRatio;

    @FindBy(locator = "xpath=(//label[contains(text(),'Drive Frequency')]/..//input)[2]")
    public CustomElement crDriveFrequency;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[1]")
    public CustomElement crAngle;

    @FindBy(locator = "xpath=(//label[text()='Speed']/..//input)[2]")
    public CustomElement crSpeed;

    @FindBy(locator = "xpath=(//label[text()='Conveying Capacity']/..//input)[2]")
    public CustomElement crConveyingCapacity;

    @FindBy(locator = "xpath=(//label[text()='Percent Load']/..//input)[2]")
    public CustomElement crPercentLoad;

    @FindBy(locator = "xpath=(//label[text()='Minimum Temperature']/..//input)[2]")
    public CustomElement crMinimumTemperature;

    @FindBy(locator = "xpath=(//label[text()='Maximum Temperature']/..//input)[2]")
    public CustomElement crMaximumTemperature;

    @FindBy(locator = "xpath=//label[text()='Take-up type']/..//input")
    public CustomElement crTakeupType;

    @FindBy(locator = "xpath=//label[text()='Take-up Travel']/..//input")
    public CustomElement crTakeupTravel;

    @FindBy(locator = "xpath=//label[text()='Estimated Weight']/..//input")
    public CustomElement crEstimatedWeight;

    @FindBy(locator = "xpath=//label[text()='Belt Monitoring System']/..//input")
    public CustomElement crBeltMonitoringSystem;

    @FindBy(locator = "xpath=//label[text()='Manufacturer']/..//input")
    public CustomElement crManufacturer;

    @FindBy(locator = "xpath=(//label[text()='Belt Turnover']/..//input)[1]")
    public CustomElement crBeltTurnover;

    @FindBy(locator = "xpath=(//label[text()='Pipe Belt']/following-sibling::div//input)[1]")
    public CustomElement crPipeBeltYes;

    @FindBy(locator = "xpath=(//label[text()='Pipe Belt']/following-sibling::div//input)[2]")
    public CustomElement crPipeBeltNo;

    @FindBy(locator = "xpath=//label[text()='Direction Turnover']/following-sibling::div//input")
    public CustomElement crDirectionTurnover;

    @FindBy(locator = "xpath=//label[text()='Right / Clockwise']/preceding-sibling::p-radiobutton//input")
    public CustomElement crClockwise;

    @FindBy(locator = "xpath=//label[text()='Tons Per Year']/..//input")
    public CustomElement crTonsPerYear;

    @FindBy(locator = "xpath=//label[text()='Feed Angle']/..//input")
    public CustomElement crFeedAngle;

    @FindBy(locator = "xpath=//label[text()='Chute Angle']/..//input")
    public CustomElement crChuteAngle;

    @FindBy(locator = "xpath=//label[text()='Belt Incline angle in Load Zone']/..//input")
    public CustomElement crBeltInclineAngle;

    @FindBy(locator = "xpath=//label[text()='Carry Idler Diameter']/..//input")
    public CustomElement crCarryIdlerDiameter;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[2]")
    public CustomElement crCarryAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[1]")
    public CustomElement crCarryTotalIdlers;

    @FindBy(locator = "xpath=(//label[text()='Top Run Spacing']/..//input)[1]")
    public CustomElement crCarryTopRunSpacing;

    @FindBy(locator = "xpath=//label[text()='Return Idler Diameter']/..//input")
    public CustomElement crReturnIdlerDiameter;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[3]")
    public CustomElement crReturnAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[2]")
    public CustomElement crReturnTotalIdlers;

    @FindBy(locator = "xpath=//label[text()='Return Run Spacing']/..//input")
    public CustomElement crReturnTopRunSpacing;

    @FindBy(locator = "xpath=//label[text()='Impact Idler Diameter']/..//input")
    public CustomElement crImpactIdlerDiameter;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[4]")
    public CustomElement crImpactAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[3]")
    public CustomElement crImpactTotalIdlers;

    @FindBy(locator = "xpath=(//label[text()='Idler Offset']/..//input)[2]")
    public CustomElement crIdlerOffset;

    @FindBy(locator = "xpath=//label[text()='Number of Transition Idlers']/..//input")
    public CustomElement crNoOfTransitionIdlers;

    @FindBy(locator = "xpath=(//label[text()='Misalignment Sensors Available']/following-sibling::div//input)[1]")
    public CustomElement crMisalignmentSensorsYes;

    @FindBy(locator = "xpath=(//label[text()='Misalignment Sensors Available']/following-sibling::div//input)[2]")
    public CustomElement crMisalignmentSensorsNo;

    @FindBy(locator = "xpath=//label[text()='Drive Pulley']/..//input")
    public CustomElement crDrivePulley;

    @FindBy(locator = "xpath=//label[text()='Brake Device']/..//input")
    public CustomElement crBrakeDevice;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[2]")
    public CustomElement crHeadPulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[3]")
    public CustomElement crHeadPulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//input)[1]")
    public CustomElement crHeadPulleyAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//input)[1]")
    public CustomElement crHeadPulleyLaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[1]")
    public CustomElement crHeadPulleyLaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[4]")
    public CustomElement crTailPulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[4]")
    public CustomElement crTailPulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//input)[2]")
    public CustomElement crTailPulleyAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//input)[2]")
    public CustomElement crTailPulleyLaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[2]")
    public CustomElement crTailPulleyLaggingThickness;

    @FindBy(locator = "xpath=//label[text()='Flat-to-trough Transition Length']/..//input")
    public CustomElement crHeadTransitionLength;

    @FindBy(locator = "xpath=(//label[text()='Pulley Lift']/..//input)[1]")
    public CustomElement crHeadPulleyLift;

    @FindBy(locator = "xpath=(//label[text()='Transition Type']/following-sibling::div//input)[1]")
    public CustomElement crHeadTransitionTypeHalf;

    @FindBy(locator = "xpath=(//label[text()='Transition Type']/following-sibling::div//input)[2]")
    public CustomElement crHeadTransitionTypeFull;

    @FindBy(locator = "xpath=//label[text()='Trough-to-flat Transition Length']/..//input")
    public CustomElement crTailTransitionLength;

    @FindBy(locator = "xpath=(//label[text()='Pulley Lift']/..//input)[2]")
    public CustomElement crTailPulleyLift;

    @FindBy(locator = "xpath=(//label[text()='Transition Type']/following-sibling::div//input)[3]")
    public CustomElement crTailTransitionTypeHalf;

    @FindBy(locator = "xpath=(//label[text()='Transition Type']/following-sibling::div//input)[4]")
    public CustomElement crTailTransitionTypeFull;

    @FindBy(locator = "xpath=(//label[text()='Material Guidance']/following-sibling::div//input)[1]")
    public CustomElement crMaterialGuidanceYes;

    @FindBy(locator = "xpath=(//label[text()='Material Guidance']/following-sibling::div//input)[2]")
    public CustomElement crMaterialGuidanceNo;

    @FindBy(locator = "xpath=(//label[text()='Condition (Pressure on Outer Idlers)']/following-sibling::div//input)[1]")
    public CustomElement crConditionYes;

    @FindBy(locator = "xpath=(//label[text()='Condition (Pressure on Outer Idlers)']/following-sibling::div//input)[2]")
    public CustomElement crConditionNo;

    @FindBy(locator = "xpath=//span[text()='Import File']/..")
    public CustomElement crImportFileButton;

    @FindBy(locator = "xpath=//div[text()='Additional Remarks']/following-sibling::textarea")
    public CustomElement crAdditionalRemarks;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;

    @FindBy(locator="xpath=(//button[@icon='pi pi-chevron-down'])[2]")
    public CustomElement crActions;

    @FindBy(locator="xpath=//span[text()='Edit']")
    public CustomElement crEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement crDelete;

    @FindBy(locator="xpath=//span[text()='Export CSV']")
    public CustomElement crExportCSV;

    @FindBy(locator="xpath=//span[text()='Export PDF']")
    public CustomElement crExportPDF;

    @FindBy(locator="xpath=(//button[@icon='ctp-icon-Arrow-Right'])[1]")
    public CustomElement crviewicon;

    @FindBy(locator = "xpath=//span[text()='Update']")
    public CustomElement crUpdate;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement crYesConfirmation;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=//span[text()='Bulk Import']")
    public CustomElement crBulkImport;

    @FindBy(locator = "xpath=//label[text()='Distributor']/..//div[@aria-label='dropdown trigger']")
    public CustomElement crDistributorDropdown;

    @FindBy(locator = "xpath=//label[text()='Site']/..//div[@aria-label='dropdown trigger' or contains(@class,'p-multiselect-trigger')]")
    public CustomElement crSiteDropdown;

    @FindBy(locator = "xpath=(//label[text()='Multiple Site']/..//input)[1]")
    public CustomElement crInputMultipleSiteRadio;

    @FindBy(locator = "xpath=(//label[text()='Multiple Site']/..//input)[2]")
    public CustomElement crInputSingleSiteRadio;

    @FindBy(locator = "xpath=(//label[text()='Multiple Site']/..//p-radiobutton)[1]")
    public CustomElement crMultipleSitesRadio;

    @FindBy(locator = "xpath=(//label[text()='Multiple Site']/..//p-radiobutton)[2]")
    public CustomElement crSingleSitesRadio;

    @FindBy(locator = "xpath=//span[text()='Download Template']")
    public CustomElement crTemplateDownload;

    @FindBy(locator = "xpath=//input[@type='file']")
    public CustomElement crFileUpload;

    @FindBy(locator = "xpath=//span[text()='Save']")
    public CustomElement crSave;

    @FindBy(locator = "xpath=//i[contains(@class,'pi-trash')]")
    public CustomElement crDeleteFileUpload;

    @FindBy(locator = "xpath=//i[contains(@class,'pi-trash')]/preceding-sibling::span")
    public CustomElement crUploadedFileName;

    @FindBy(locator = "xpath=//div[contains(text(),'Conveyors will be created.')]")
    public CustomElement crUploadSuccessText;

    @FindBy(locator = "xpath=//span[text()='Import']")
    public CustomElement crImport;

    @FindBy(locator = "xpath=//div[contains(text(),'Total Records:')]")
    public CustomElement crTotalImportedRecords;

    @FindBy(locator="xpath=//div[text()='Conveyors are successfully imported']")
    public CustomElement crImportSuccessful;

    @FindBy(locator="xpath=//button[@icon='pi pi-pencil']//span[2]")
    public CustomElement editConveyor;

    @FindBy(locator = "xpath=//div[text()='Conveyor Updated Successfully.']")
    public CustomElement crUpdateMsg;

    @FindBy(locator="xpath=(//div[contains(@class,'p-panel-header')]/span)[1]")
    public CustomElement conveyorTitle;

    @FindBy(locator="xpath=//div[text()='The file has been analysed. Please review the results below before performing the import.']")
    public CustomElement fileAnalysedMsg;

    @FindBy(locator="xpath=//div[contains(@class,'p-text-bold')]")
    public CustomElement fileUploadSummary;

    @FindBy(locator="xpath=//p-inputswitch")
    public CustomElement enableWeatherSync;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btAddConveyor;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Table-Layout')])[2]")
    public CustomElement btTableLayout;

    @FindBy(locator = "xpath=//span[text()='Table Layout Settings']")
    public CustomElement tableLayoutHeader;

    @FindBy(locator = "xpath=//div[text()=' Default Layout ']/p-radiobutton")
    public CustomElement defaultLayout;

    @FindBy(locator = "xpath=//button[text()='Save Set Preference']")
    public CustomElement saveSetPreference;

    @FindBy(locator = "xpath=//button[text()='Add New Layout']")
    public CustomElement addNewLayout;

    @FindBy(locator = "xpath=//input[@id='layoutName']")
    public CustomElement layoutInput;

    @FindBy(locator = "xpath=//button[text()='Add']")
    public CustomElement addLayout;

    @FindBy(locator = "xpath=//span[contains(@class,'p-dialog-header-close-icon')]")
    public CustomElement closeLayout;

    @FindBy(locator = "xpath=(//span[contains(@class,'ctp-icon-Delete')])[1]")
    public CustomElement deleteLayout;

    @FindBy(locator = "xpath=//span[text()='Delete Layout']")
    public CustomElement deleteLayoutHeader;

    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement deleteBtn;

    @FindBy(locator = "xpath=//th/div[text()=' Name ']")
    public CustomElement nameCol;

    @FindBy(locator = "xpath=//th/div[text()=' Site ']")
    public CustomElement siteCol;

    @FindBy(locator = "xpath=//th/div[text()=' Last Modified ']")
    public CustomElement lastModifiedCol;

    @FindBy(locator = "xpath=//th/div[text()=' Installed Belt ']")
    public CustomElement installedBeltCol;

    @FindBy(locator = "xpath=//th/div[text()=' Remaining Life by Time ']")
    public CustomElement lifetimeCol;

    @FindBy(locator = "xpath=//th/div[text()=' Remaining Cover % ']")
    public CustomElement remainingCoverCol;

    @FindBy(locator = "xpath=//th/div[text()=' Inspection Items ']")
    public CustomElement inspectionItemsCol;

    @FindBy(locator = "xpath=//th/div[text()=' Corporates ']")
    public CustomElement corporatesCol;

    @FindBy(locator = "xpath=//th/div[text()=' Belt Width (mm) ']")
    public CustomElement BeltWidthCol;

    @FindBy(locator = "xpath=//th/div[text()=' Rating (N/mm) ']")
    public CustomElement ratingCol;

    @FindBy(locator = "xpath=//th/div[text()=' Length (m) ']")
    public CustomElement lengthCol;

    @FindBy(locator = "xpath=//span[contains(@class,'p-multiselect-trigger')]/..")
    public CustomElement filterDropdown;

    @FindBy(locator = "xpath=//div[text()='Layout created successfully']")
    public CustomElement layoutSuccessMsg;

    @FindBy(locator = "xpath=//span[text()='Conveyor']")
    public CustomElement conveyorTab;

    public void goToConveyorListScreen(){
        if(!conveyorList.isVisible())
            home.click("Home");
        conveyorList.jsClick("Conveyor List");
        btSearchinput.isVisible("Conveyor List Page");
    }

    public void goToAddConveyor(){
        addConveyors.click("Add Conveyors");
        tbConveyorname.isVisible("Conveyor Name");
    }

    public void goToAddConveyorFromList(){
        goToConveyorListScreen();
        btAddConveyor.click("Add icon");
        tbConveyorname.isVisible("Conveyor Name");
    }

    public void goToConveyorListScreenAndWait() {
        goToConveyorListScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(180); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(10000);
        }
    }

    public void createConveyor(String conveyorName, String distShopName, String custSiteName) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        btSaveandclose.click("Save & Close");
        waitForElementToInvisible(buttonLoader,10000);
        btSearchinput.isVisible("Conveyor list screen");
    }

    public void createConveyorWithImg(String conveyorName, String distShopName, String custSiteName, String img) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        new CorporatePage().corporateImgUpload(img);
        waitForElementToBeClickable(enableWeatherSync);
        enableWeatherSync.click("Weather Sync");
        btSaveandclose.click("Save & Close");
        waitForElementToInvisible(buttonLoader,10000);
        btSearchinput.isVisible("Conveyor list screen");
    }

    public void enterConveyorMandatoryDetails(String conveyorName, String distShopName, String custSiteName) {
        addConveyors.click("Add Conveyor");
        waitForElementToDisplay(tbConveyorname);
        tbConveyorname.type(conveyorName,"Conveyor Name");
        dropdownSelectSearch(drSitedropdown, tbSitedropdown, custSiteName);
        dropdownSelectSearch(drDistShopdropdown, tbSitedropdown, distShopName);
    }

    public void checkConveyorGermany(String conveyorName, String custCorpName) {
        scrollPageup();
        breakcrumHome.click("Conveyor Home");
        waitForElementVisible(btSearchinput, 10000,500);
        btSearchinput.type(conveyorName, "Conveyor Name");
        waitForElementToDisplay(crCheckbox);
        Validator.assertTrue(crCheckbox.isDisplayed(),"Search conveyor is not present","Searched conveyor is present");
        Reporter.log("Image :="+crImg.isDisplayed());
        Reporter.log("Name :="+crName.getText());
        Reporter.log("Site :="+crSite.getText());
    }

    public boolean searchConveyor(String conveyorName){
        goToConveyorListScreenAndWait();
        btSearchinput.type(conveyorName, "Conveyor Search");
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Conveyor Found");
    }

    public void deleteConveyor(String conveyorName) {
        searchConveyor(conveyorName);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        waitForElementVisible(crDelete, 10000,500);
        crDelete.click("Delete");
        crYesConfirmation.click("Confirm");
        waitForElementToDisplay(noList);
    }

    public void clearConveyorSearch() {
        btSearchinput.clear();
        SyncUtil.waitFor(1000);
    }

    public void exportCSVConveyor(String conveyorName) {
        searchConveyor(conveyorName);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        crExportCSV.jsClick("Export CSV");
    }

    public void exportPDFConveyor(String conveyorName) {
        searchConveyor(conveyorName);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        crExportPDF.jsClick("Export PDF");
    }


    public void goToConveyorDetailScreen(String conveyorName) {
        searchConveyor(conveyorName);
        waitForElementToDisplay(crviewicon);
        crviewicon.click("Conveyor Detail");
        crTechnicalDataCard.isEnable("Technical Data");
    }

    public void verifyDeleteConveyor(String conveyorName) {
        goToConveyorListScreen();
        btSearchinput.type(conveyorName, "Conveyor Search");
        Validator.assertTrue(noList.isVisible(),"Delete conveyor was still found in Conveyor list screen","Conveyor deleted successfully");
    }

    public void verifyTechnicalData(String conveyorName) {
        goToConveyorDetailScreen(conveyorName);
        crTechnicalDataCard.isEnable("Technical Card");
        scrollPageDown();
        verifyConveyorLiteFields();
        verifyInstalledBelt();
        verifyMaterial();
        verifyConveyor();
        verifyWearLife();
        verifyIdlers();
        verifyPulleys();
        verifyTransitionZone();
        verifyRemarks();
        scrollPageup();
    }

    public boolean verifyConveyorLiteFields() {
        return crBeltWidth.isVisible("Belt Width") && crBeltSpeed.isVisible("Belt Speed") && crTonsPerHr.isVisible("Tons Per hr") &&
                crMaterialName.isVisible("Material Name") && crMaterialDensity.isVisible("Material Density") && crAngleOfIdlers.isVisible("Angle Of Idlers") &&
                crIdlerSpacing.isVisible("Idler Spacing") && crDriveWrapAngle.isVisible("Drive Wrap Angle") && crTakeUpTension.isVisible("Take up Tension") && crPermanentFriction.isEnable("Friction Factor Permanent") &&
                crTemporaryFriction.isEnable("Friction Factor Temporary") && crFrictionFactor.isVisible("Friction Factor") && crLengthFactor.isVisible("Length Factor") &&
                crSurchargeFactor.isVisible("Surcharge Angle") && crIdleOffsetType.isVisible("Idler Offset Type ") && crDriveDetails.isEnable("Drive Details") && crTakeupDetails.isEnable("Take-up Details");
    }

    public boolean verifyInstalledBelt() {
        crInstalledBeltTab.click("Installed Belt Tab");
        return crMonolithConfig.isEnable("Monolithic Radio") && !crMixedConfig.isEnabled() && crManufacturer.isEnable("Belt Manufacturer") &&
                crBeltConstruction.isVisible("Belt Construction") && crTopCompound.isVisible("Top Cover Compound") && crBottomCompound.isVisible("Bottom Cover Compound") &&
                crCarcass.isVisible("Carcass") && crWidth.isEnable("Width") && !crRatingRadio.isEnabled() && crBreakingStrengthRadio.isEnable("Breaking Strength Radio") &&
                crBreakingStrength.isVisible("Breaking Strength") && crTopCoverThickness.isVisible("Top Cover Thickness") && crBottomCoverThickness.isVisible("Bottom Cover Thickness") &&
                crLength.isVisible("Belt Length") && crSplice.isEnable("Splice Type ") && crSpliceQuality.isVisible("Splice Quality") && crInstallationDate.isVisible("Installation Date");
    }

    public boolean verifyMaterial() {
        crMaterialTab.click("Material Tab");
        return crDescription.isVisible("Material Description") && crBulkDensity.isVisible("Bulk Density") && crBulkSize.isVisible("Bulk Size") &&
                crLumpSize.isVisible("Lump Size") && crGranularSize.isEnable("Granular Size") && crContingentOfFines.isVisible("Contingent of Fines") &&
                crAggresivity.isEnable("Aggresivity") && crDensityType.isEnable("Density Type") && crChuteDrop.isVisible("Chute Drop") && crLoadingFrequency.isEnable("Loading Frequency") &&
                crLoadingConditions.isEnable("Loading Conditions") && crTemperature.isVisible("Material Temperature") && crFeedingConditions.isEnable("Feeding Conditions") && crPresenceOfOil.isEnable("Presence of Oil");
    }

    public boolean verifyConveyor() {
        crConveyorTab.click("Conveyor Tab");
        return crConveyingLength.isVisible("Conveying Length") && crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power") &&
                crGearRatio.isVisible("Gear Ratio") && crDriveFrequency.isVisible("Driver Frequency") && crAngle.isVisible("Conveyor Angle") &&
                crSpeed.isVisible("Conveyor Speed") && crConveyingCapacity.isVisible("Conveying Capacity") && crPercentLoad.isVisible("Percent Load") && crMinimumTemperature.isVisible("Minimum Temperature") &&
                crMaximumTemperature.isVisible("Maximum Temperature") && crTakeupType.isEnable("Take Up Type") && crTakeupTravel.isVisible("Take Up Travel") && crEstimatedWeight.isVisible("Estimated Weight") &&
                crBeltMonitoringSystem.isEnable("Belt Monitoring System") && crManufacturer.isVisible("Conveyor Manufacturer") && crBeltTurnover.isEnable("Belt Turnover") && crPipeBeltYes.isEnable("Pipe Belt Yes") &&
                crPipeBeltNo.isEnable("Pipe Belt No") && crDirectionTurnover.isEnable("Direction Turnover") && crClockwise.isEnable("Right / Clockwise");
    }

    public boolean verifyWearLife() {
        crWearLifeTab.click("Wear Life Tab");
        return crTonsPerYear.isVisible("Tons Per year") && crFeedAngle.isVisible("Feed Angle") && crChuteAngle.isVisible("Chute Angle") && crBeltInclineAngle.isVisible("Belt Incline angle in Load Zone");
    }

    public boolean verifyIdlers() {
        crIdlersTab.click("Idlers Tab");
        return crCarryIdlerDiameter.isVisible("Carry Idler Diameter") && crCarryAngle.isVisible("Carry Angle") && crCarryTotalIdlers.isVisible("Carry Total Number of Idlers") &&
                crCarryTopRunSpacing.isVisible("Carry Top Run Spacing") && crReturnIdlerDiameter.isVisible("Return Idler Diameter") && crReturnAngle.isVisible("Return Angle") &&
                crReturnTotalIdlers.isVisible("Return Total Number of Idlers") && crReturnTopRunSpacing.isVisible("Return Top Run Spacing") && crImpactIdlerDiameter.isVisible("Impact Idler Diameter") && crImpactAngle.isVisible("Impact Angle") &&
                crImpactTotalIdlers.isVisible("Impact Total Number of Idlers") && crIdlerOffset.isVisible("Idler Offset") && crNoOfTransitionIdlers.isVisible("Number of Transition Idlers") && crMisalignmentSensorsYes.isEnable("Misalignment Sensors Available") &&
                crMisalignmentSensorsNo.isEnable("Misalignment Sensors Not Available");
    }

    public boolean verifyPulleys() {
        crPulleysTab.click("Pulleys Tab");
        return crDrivePulley.isEnable("Drive Pulley") && crBrakeDevice.isEnable("Brake Device") && crHeadPulleyDiameter.isVisible("Head Pulley Diameter") &&
                crHeadPulleyWidth.isVisible("Head Pulley Width") && crHeadPulleyAngleOfWrap.isEnable("Head Pulley Angle Of Wrap") && crHeadPulleyLaggingType.isEnable("Head Pulley Lagging Type") &&
                crHeadPulleyLaggingThickness.isVisible("Head Pulley Lagging Thickness") && crTailPulleyDiameter.isVisible("Tail Pulley Diameter") && crTailPulleyWidth.isVisible("Tail Pulley Width") && crTailPulleyAngleOfWrap.isEnable("Tail Pulley Angle Of Wrap") &&
                crTailPulleyLaggingType.isEnable("Tail Pulley Lagging Type") && crTailPulleyLaggingThickness.isVisible("Tail Pulley Lagging Thickness");
    }

    public boolean verifyTransitionZone() {
        crTransitionZoneTab.click("Transition Zone Tab");
        return crHeadTransitionLength.isVisible("Flat-to-trough Transition Length") && crHeadPulleyLift.isVisible("Pulley Lift") && crTailTransitionLength.isVisible("Trough-to-flat Transition Length") && crTailPulleyLift.isVisible("Tail Pulley Lift") &&
                crHeadTransitionTypeFull.isEnable("Head Transition Type Full") && crHeadTransitionTypeHalf.isEnable("Head Transition Type Half") && crTailTransitionTypeFull.isEnable("Tail Transition Type Full") && crTailTransitionTypeHalf.isEnable("Tail Transition Type Half") &&
                crMaterialGuidanceNo.isEnable("Material Guidance No") && crMaterialGuidanceYes.isEnable("Material Guidance Yes") && crConditionYes.isEnable("Condition Yes") && crConditionNo.isEnable("Condition No");
    }

    public boolean verifyRemarks() {
        crRemarksTab.click("Remarks Tab");
        return crAdditionalRemarks.isVisible("Additional Remarks");
    }

    public boolean verifyDefaultPin(String conveyorName) {
        searchConveyor(conveyorName);
        return crPin.getAttribute("class").contains("marker-icon-gray");
    }

    public boolean verifyActivePin(String conveyorName) {
        searchConveyor(conveyorName);
        crPin.click("Pin");
        SyncUtil.waitFor(3000);
        return crPin.getAttribute("class").contains("marker-icon-red");
    }

    public void verifyCSVContents(String conveyor2) {
        Validator.assertTrue(((Map<String,String>)(CSVUtil.getCSVDataAsMap(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+"download.csv").get(0)[0])).get("Name").equalsIgnoreCase(conveyor2),"CSV Report was generated for the wrong conveyor","CSV Report was generated for the right conveyor");
        Validator.assertTrue(CSVUtil.getCSVDataAsMap(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+"download.csv").get(0).length == 1,"CSV Report has incorrect no of conveyors","CSV report has valid no of conveyors");
    }

    public void verifyPDFContents(String conveyor5) {
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+"conveyor.pdf");
        try {
            Validator.assertTrue(PDFHelper.getPageCount(doc) ==1,"PDF Report has incorrect no of pages","PDF report has valid no of pages");
            Validator.assertTrue(PDFHelper.getPDFImagesCount(doc) == 2,"PDF Report has unaccepted no of images","PDF report has valid images");
            String val = PDFHelper.getPageContent(doc);
            Validator.assertTrue(val.replaceAll("\r\n", " ").replaceAll("\n", " ").trim().contains(conveyor5),"PDF Report was generated for the wrong conveyor","PDF Report was generated for the right conveyor");
            PDFHelper.PDFBoxExtractImages(doc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean goToBulkImport() {
        addConveyors.click("Add Conveyor");
        crBulkImport.click("Bulk Import");
        return crFileUpload.isEnable("File Upload");
    }

    public void checkDownloadTemplateForOneSite(String distributor, String site) {
        goToBulkImport();
        dropdownSelectSearch(crDistributorDropdown,tbSitedropdown, distributor);
        crSingleSitesRadio.click("Single Site Radio");
        dropdownSelectSearch(crSiteDropdown, tbSitedropdown, site);
        crTemplateDownload.click("Download Template");
    }

    public void checkDownloadTemplateForMultipleSite(String distributor, String site,String site2) {
        goToBulkImport();
//        dropdownselectsearch(crDistributorDropdown,tbSitedropdown, distributor);
        crMultipleSitesRadio.click("Multiple Site Radio");
        dropdownSelectSearch(crSiteDropdown, tbMultipleSiteDropdown, site);
        crSiteDropdown.click();
        tbMultipleSiteDropdown.clear();
        SyncUtil.waitFor(1000);
        dropdownSelectSearch(crSiteDropdown, tbMultipleSiteDropdown, site2);
        crTemplateDownload.jsClick("Download Template");
    }

    public void conveyorFileImport(String fileName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
        crFileUpload.sendKeys(file_path, "File Path");
        crDeleteFileUpload.assertVisible("Delete File upload");
        crUploadedFileName.assertVisible("File Uploaded Name");
        crSave.click("Save File Upload");
        waitForElementToDisplay(fileAnalysedMsg);
    }

    public void acknowledgeImport(int count){
        waitForElementToDisplay(crImport);
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[1].contains(String.valueOf(count)),"Total Imported conveyors incorrect","All conveyors imported successfully");
        crImport.click("Import");
        waitForElementToDisplay(crImportSuccessful);
        waitForElementToDisplay(btSearchinput);
    }
    public Object[][] getExcelData(String fileName, String sheetName) {
        String file_path = ClasspathResourceHelper.getPropertyFile(fileName, "excel_data").getAbsolutePath();
        Object[][] obj = PoiExcelUtil.getExcelDataAsMap(file_path,sheetName);
        return obj;
    }

    public void verifyUploadedConveyor(String siteName, String fileName) {
        Object[][] obj = getExcelData(fileName,siteName);
        for( int i = obj.length-1;i>0;i--)
            Validator.assertTrue(searchConveyor(((Map<String,String>)obj[i][0]).get("Name")),"Imported Conveyor was not created successfully","Imported conveyor created successfully");
    }

    public void editConveyor(String oldConveyorName, String newConveyorName) {
        btSearchinput.type(oldConveyorName);
        crviewicon.click();
        waitForElementToDisplay(conveyorTitle);
        waitForElementToBeClickable(editConveyor);
        editConveyor.click();
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(tbConveyorname);
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        tbConveyorname.type(newConveyorName);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
    }

    public boolean verifyTile() {
        return crTechnicalDataCard.isEnable("Technical Card") && crConveyorHistory.isEnable("Conveyor History") && crFileManager.isEnable("File Manager") && crCoverWear.isEnable("Cover Wear") && crInspections.isEnable("Inspections") && crConveyorInspect.isEnable("Conveyor Inspect") && crMonitoringDevices.isEnable("Monitoring Devices") && crMinutemanCalc.isEnable("Minuteman Calc");
    }

    public boolean verifyDropDown(String conveyorName){
        searchConveyor(conveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        return crExportPDF.isVisible("Export PDF") && crExportCSV.isVisible("Export CSV") && crEdit.isVisible("Edit Conveyor") && crDelete.isVisible("Delete Conveyor");
    }

    public void addLayout(String corporates, String beltWidth, String rating, String length, String layoutName){
        addFilters(corporates,beltWidth,rating,length);
        btTableLayout.click("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        addNewLayout.click("Add New Layout");
        layoutInput.type(layoutName);
        addLayout.click("Add");
        waitForElementToDisplay(layoutSuccessMsg);
        closeLayout.click("Close Layout");
    }

    public boolean addFilters(String corporates, String beltWidth, String rating, String length){
        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, corporates);
        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, beltWidth);
        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, rating);
        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, length);
        return verifyFilters();
    }

    public boolean verifyFilters(){
        return corporatesCol.isVisible() && BeltWidthCol.isVisible() && ratingCol.isVisible() && lengthCol.isVisible();
    }

    public void deleteLayout(String layoutName){
        btTableLayout.click("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        defaultLayout.click("Default Radio");
        driver.findElement(By.xpath("//div[contains(text(),'"+layoutName+"')]/following-sibling::div//span[contains(@class,'ctp-icon-Delete')]")).click();
        deleteLayout.click("Delete Layout");
        deleteLayoutHeader.isVisible("Delete Header");
        deleteBtn.click("Delete");
    }
}
