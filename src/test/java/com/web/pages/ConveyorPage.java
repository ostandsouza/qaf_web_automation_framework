package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.ClasspathResourceHelper;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.CSVUtil;
import com.qmetry.qaf.automation.util.PoiExcelUtil;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.mobile.flutter.app.component.CustomFlutterElement;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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

    @FindBy(locator= "xpath=//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
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

    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
//    @FindBy(locator="xpath=(//button/span[contains(@class,'pi-chevron-down')])[2]")
    public CustomElement crActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
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

    @FindBy(locator = "xpath=//span[contains(@class,'p-button-loading-icon')]")
    public CustomElement loader;

    @FindBy(locator = "xpath=//div[contains(@class,'p-toast-message-text')]//div[text()='Conveyor Updated Successfully.']")
    public CustomElement successToast;

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

    @FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]")
    public CustomElement crDeleteFileUpload;

    @FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]/../preceding-sibling::div")
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

    @FindBy(locator="xpath=//div[@class='records-bulk']/div[contains(@class,'font-bold')]")
//    @FindBy(locator="xpath=//div[contains(@class,'p-text-bol')]")
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

    @FindBy(locator = "xpath=//span[text()='Next']")
    public CustomElement btNext;

    @FindBy(locator = "xpath=//input[@id='layoutName']")
    public CustomElement layoutInput;

    @FindBy(locator = "xpath=//button[text()='Add']")
    public CustomElement addLayout;

    @FindBy(locator = "xpath=//button[contains(@class,'p-dialog-header-close')]")
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

    @FindBy(locator = "xpath=//th/div[contains(text(),'Corporate')]")
    public CustomElement corporatesCol;

    @FindBy(locator = "xpath=//th/div[contains(text(),'Belt Width (mm)')]")
    public CustomElement BeltWidthCol;

    @FindBy(locator = "xpath=//th/div[contains(text(),'Rating (N/mm)')]")
    public CustomElement ratingCol;

    @FindBy(locator = "xpath=//th/div[contains(text(),'Length (m)')]")
    public CustomElement lengthCol;

    @FindBy(locator = "xpath=//div[contains(@class,'p-multiselect-trigger')]")
    public CustomElement filterDropdown;
    @FindBy(locator = "xpath=//div[contains(@class,'p-multiselect-panel')]")
    public CustomElement filterDropdowPopup;



    @FindBy(locator = "xpath=//div[text()='Layout created successfully']")
    public CustomElement layoutSuccessMsg;

    @FindBy(locator = "xpath=//span[text()='Conveyor']")
    public CustomElement conveyorTab;

    @FindBy(locator = "xpath=(//div[contains(@id,'titlebar')]/span)[1]")
    public CustomElement conveyorNameLoader;

    @FindBy(locator = "xpath=//label[text()='Analyzing Conveyors']")
    public CustomElement analysingConveyors;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component' and contains(., \"Conveyors\")]")
    public CustomElement conveyorBreadCrumb;

    @FindBy(locator = "xpath=(//label[@for='firstname2 '])[1]")
    public CustomElement txtGPSHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']//input[@formcontrolname='longitude'])[1]")
    public CustomElement tbHeadLong ;

    @FindBy(locator = "xpath=(//div[@class=\"p-inputgroup\"]//input[@formcontrolname=\"latitude\"]\n)[1]")
    public CustomElement tbHeadLat;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']//input[@formcontrolname='longitude'])[2]")
    public CustomElement tbTailLong ;

    @FindBy(locator = "xpath=(//div[@class=\"p-inputgroup\"]//input[@formcontrolname=\"latitude\"]\n)[2]")
    public CustomElement tbTailLat;

    @FindBy(locator = "xpath=//label[@for='firstname2' and contains(text(), 'GPS Coordinates Tail')]")
    public CustomElement txtGPSTail;

    @FindBy(locator = "xpath=//input[contains(@class, 'p-dropdown-filter') and contains(@class, 'p-inputtext') and contains(@class, 'p-component')]\n")
    public CustomElement btSiteSearchInput;
    @FindBy(locator = "//button[@title='Zoom in']")
    public CustomElement btnZoomIn;

    @FindBy(locator = "//button[@title='Zoom out']")
    public CustomElement btnZoomOut;

//    @FindBy(locator = "//div[@class='map-container']//div[@class='gm-style']/div/div[2]")
//    public CustomElement mapArea;

    @FindBy(locator ="//div[@class='map-container']//div[@class='gm-style']/div/div[2]")
    public CustomElement mapLocation;
    @FindBy(locator = "//div[@title='Head']")
    public CustomElement headMapLocation;
    @FindBy(locator = "//div[@title='Tail']")
    public CustomElement tailMapLocation;

    @FindBy(locator = "//div[@role='dialog']")
    public CustomElement positionDialog;

    @FindBy(locator = "//input[@id='lat' and contains(@class, 'p-filled')]")
    public CustomElement tbLatValue;

    @FindBy(locator = "//input[@id='lng' and contains(@class, 'p-filled')]")
    public CustomElement tbLongValue;

    @FindBy(locator = "//p-dropdown[@class='p-element p-inputwrapper']//div[@aria-label='dropdown trigger']")
    public CustomElement ddlLocationType;

    @FindBy(locator = "//p-dropdown[@class='p-element p-inputwrapper p-inputwrapper-filled']//div[@class='p-dropdown p-component']")
    public CustomElement ddlLocationTwoType;

    @FindBy(locator = "//li[@aria-label=\"Head\"]")
    public CustomElement optionsHead;

    @FindBy(locator = "//li[@aria-label=\"Tail\"]")
    public CustomElement optionsTail;

    @FindBy(locator = "//button[@label=\"Add Marker\"]")
    public CustomElement btnAddMarker;

    @FindBy(locator = "//input[@formcontrolname=\"latitude\" and contains(@class,'p-filled')]")
    public CustomElement tbFilledHeadLat;

    @FindBy(locator = "//div[@formgroupname='tail']/descendant::span[@class='p-inputgroup-addon'][normalize-space()='Lat']/following-sibling::input[contains(@class,\"p-filled\")]\n")
    public CustomElement tbFilledTailLat;

    @FindBy(locator = "//input[@formcontrolname=\"longitude\" and contains(@class,'p-filled')]")
    public CustomElement tbFilledHeadLong;//div[@formgroupname='tail']/descendant::span[@class='p-inputgroup-addon'][normalize-space()='Lon']/following-sibling::input[contains(@class,"p-filled")]
    @FindBy(locator = "//div[@formgroupname='tail']/descendant::span[@class='p-inputgroup-addon'][normalize-space()='Lon']/following-sibling::input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledTailLong;

    @FindBy(locator = "//div[contains(@class, \"p-toast-detail\") and contains(text(), \"Failed to create conveyor: Conveyor already exists\")]")
    public CustomElement conveyorErrorMsg;

    @FindBy(locator="xpath=//div[contains(@class,'p-panel-header') and .//span[contains(text(),'Cust Automation Common India')]]")
    public CustomElement siteHeader;

    @FindBy(locator = "//button[@icon=\"pi pi-angle-left\"]")
    public CustomElement btnPrevious;

    @FindBy(locator="xpath=//li[@class='topbar-item scale']")
    public CustomElement unitIcon;

    @FindBy(locator="xpath=//h6[text()='Metric']/../..//div[@class='p-radiobutton p-component p-radiobutton-checked']")
    public CustomElement cbMetricUnit;

    @FindBy(locator="xpath=//h6[text()='Imperial']/../..//div[@class='p-radiobutton p-component p-radiobutton-checked']")
    public CustomElement cbImperialUnit;

    @FindBy(locator="xpath=//h6[text()='Imperial']")
    public CustomElement btImperialUnit;

    @FindBy(locator="//label[@for='firstname2']/../div//app-master-data-picker/../span")
    public CustomElement unitIconConveyor;

    @FindBy(locator="//label[text()='Corporate Name']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledCorporateName;
    @FindBy(locator="//label[text()='Site']/../div[2]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledSite;
    @FindBy(locator="//label[text()='Distributor']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledDistributor;
    @FindBy(locator="//label[text()='Location']/../div[2]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledLocation;
    @FindBy(locator="//label[text()='Corporate Name']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbCorporateName;
    @FindBy(locator="//label[text()='Territory']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledTerritory;
    @FindBy(locator="//label[text()='Territory Manager']/../div[2]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledTerritoryManager;

    @FindBy(locator = "//div[@role=\"dialog\"]//div[text()=\"Head\"]")
    public CustomElement conveyorNameLabel;

    @FindBy(locator = "//button[@aria-label=\"Close\"]")
    public CustomElement locationCloseBtn;

    @FindBy(locator = "//button[text()=\"Add\" and @disabled]")
    public CustomElement addBtnDisabled;

    @FindBy(locator = "//p-toast//div[text()='Failed to create table layout: Bad request: Table layout is already exists']")
    public CustomElement layoutToastError;
    @FindBy(locator = "xpath=//div[@class='p-element p-multiselect-label-container']")
    public CustomElement columnNameFilter;
    @FindBy(locator = "xpath=//button[contains(@class,\"p-multiselect-close\")]")
    public CustomElement btnColumnNameFilterClose;
    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Installed Belt') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbInstalledBeltColumn;
    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Manufacturer') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltManufacturerColumn;
    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Speed') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltSpeedColumn;
    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Construction') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltConstructionColumn;
    @FindBy(locator = "xpath=//p-multiselectitem//li[contains(., 'Belt Width') and .//div[contains(@class, 'p-checkbox')]]")
    public CustomElement cbBeltWidthColumn;

    @FindBy(locator = "//div[contains(@class,\"p-multiselect-header\")]//div[@role=\"checkbox\"]")
    public CustomElement cbAllColumnNames;
    @FindBy(locator = "//th[@id=\"install-col\"]")
    public CustomElement thInstalledBelt;
    @FindBy(locator = "//th[@id=\"beltManufacturer_name\"]")
    public CustomElement thbeltManufacturer;
    @FindBy(locator = "//th[@id=\"beltContraction_name\"]")
    public CustomElement thBeltContraction;

    @FindBy(locator = "//th[@id=\"beltWidth-col\"]")
    public CustomElement thBeltWidth;

    @FindBy(locator = "//th[@id=\"beltSpeed-col\"]")
    public CustomElement thBeltSpeed;

    @FindBy(locator = "//div[contains(@class,\"p-multiselect-panel\")]")
    public CustomElement columnFilterPanel;

    @FindBy(locator = "//th[@id=\"name-col\"]")
    public CustomElement thNameColumn;
    @FindBy(locator = "//p-columnfilter[@field='name']")
    public CustomElement nameFilterIcon;

    @FindBy(locator = "//p-columnfilter[@field='name']//button[contains(@class,\"p-column-filter-menu-button-active\")]")
    public CustomElement nameFilterIconHighlighted;
    @FindBy(locator = "//div[contains(@class,\"p-column-filter-operator-dropdown\")]//span[text()=\"Match All\"]")
    public CustomElement ddlMatchAll;
    @FindBy(locator = "//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//span[text()=\"Contains\"]")
    public CustomElement ddlContains;
    @FindBy(locator = "//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//span[text()='Starts with']")
    public CustomElement ddlStartsWith;
    @FindBy(locator = "//div[contains(@class,'p-column-filter-matchmode-dropdown')]//li[@aria-selected='true']//span[text()='Starts with']")
    public CustomElement ddlStartsWithSelected;
    @FindBy(locator = "//p-columnfilterformelement//input[@pinputtext]")
    public CustomElement filterSearchTextBox;

    @FindBy(locator = "//input[contains(@class,'p-filled')]")
    public CustomElement filterSearchTextBoxFilled ;
    @FindBy(locator = "//button//span[text()=\"Add Rule\"]")
    public CustomElement addRuleLink;

    @FindBy(locator = "//button//span[text()='Clear']")
    public CustomElement btnFilterClear;
    @FindBy(locator = "//button//span[text()='Apply']")
    public CustomElement btnFilterApply;
    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;
    @FindBy(locator = "xpath=//div[contains(@class,\"p-column-filter-overlay\")]")
    public CustomElement filterPopup;
    @FindBy(locator = "xpath=//span[text()='Table Layout Settings']/ancestor::div[contains(@role, 'dialog')]")
    public CustomElement layoutDialog;
    @FindBy(locator = "xpath=//div//label[text()='Belt Width ']/..//p-dropdown[contains(@class,'p-inputwrapper-filled')]")
    public CustomElement tbPrefilledBeltWidth;
    @FindBy(locator = "xpath=//div//label[text()='Belt Width ']/..//p-dropdown[contains(@class,\"p-inputwrapper-filled\")]//div//div//input[@disabled]")
    public CustomElement tbDisabledPrefilledBeltWidth;
    @FindBy(locator = "xpath=//div//label[text()='Belt Speed ']/..//div//input[contains(@class,\"p-filled\") and @disabled]")
    public CustomElement tbPrefilledBeltSpeed;
    @FindBy(locator = "xpath=//div//label[text()='Material Density ']/..//div//input[contains(@class,\"p-filled\") and @disabled]")
    public CustomElement tbMaterialDensity;
    @FindBy(locator = "xpath=//div//label[text()='Belt Manufacturer']/..//p-dropdown[contains(@class,\"p-inputwrapper-filled\")]//div//div//input[@disabled]")
    public CustomElement tbPrefilledBeltManufacturer;
    @FindBy(locator = "xpath=//div//label[text()='Belt Construction']/..//p-dropdown[contains(@class,\"p-inputwrapper-filled\")]//div//div//input[@disabled]")
    public CustomElement tbPrefilledBeltConstruction;
    @FindBy(locator = "xpath=//div//label[text()='Description']/..//p-dropdown[contains(@class,\"p-inputwrapper-filled\")]//div//div//input[@disabled]")
    public CustomElement tbPrefilledDescription;
    @FindBy(locator = "xpath=//div//label[text()='Bulk Density']/..//div//input[contains(@class,\"p-filled\") and @disabled]")
    public CustomElement tbPrefilledBulkDensity;
    @FindBy(locator = "xpath=//div//label[text()='Conveying Length']/..//div//input[contains(@class,\"p-filled\") and @disabled]")
    public CustomElement tbPrefilledConveyingLength;
    @FindBy(locator = "xpath=//div//label[text()='Lift']/..//div//input[contains(@class,\"p-filled\") and @disabled]")
    public CustomElement tbPrefilledLift;
    @FindBy(locator = "xpath=//div[@class=\"p-tabview-nav-container\"]//span[text()='Installed Belt']")
    public CustomElement tabInstalledBelt;
    @FindBy(locator = "xpath=//div[@class=\"p-tabview-nav-container\"]//span[text()='Material']")
    public CustomElement tabMaterial;
    @FindBy(locator = "xpath=//div[@class=\"p-tabview-nav-container\"]//span[text()='Conveyor']")
    public CustomElement tabConveyor;
    @FindBy(locator="xpath=//label[text()='Tons per Hour Peak']/../div/span")
    public CustomElement crTonsPerHrUnit;

    @FindBy(locator="xpath=//label[text()='Corporate Name']/../div[2]//input[contains(@class,'p-filled')]")
    public CustomElement tbSite;









    String[] columnNames={"Name","Site","Corporate","Last Modified","Installed Belt","Remaining Life by Time","Remaining Cover %","Inspection Items",
            "Belt Manufacturer","Number of Plies","Number of Cords","Cord Pitch","Cord Diameter","Length","Splice Type","Splice Quantity","Installation Date","Belt Speed","Tons Per Hour Peak","Material",
            "Angle of Idlers","Carry Side Idler Spacing","Drive Wrap Angle","Take-up Tension","Surcharge Angle",
            "Idler Offset type","Drive Details","Take-up type","Stations","Belt Construction","Top Cover Component","Bottom Cover Component","Carcass","Rating","Belt Width","Top Cover Thickness","Bottom Cover Thickness","Material Density","Friction Factor"};

    public void goToConveyorListScreen(){
        if(!conveyorList.isVisible())
            home.click("Home");
        conveyorList.jsClick("Conveyor List");
        btSearchinput.isVisible("Conveyor List Page");
    }

    public void goToAddConveyor(){
        waitForElementVisible(addConveyors,10000,500);
        waitForElementToBeClickable(addConveyors);
        addConveyors.click("Add Conveyors");
        waitForPageLoad(10000);
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
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(280); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(30000);
        }
    }

    public void createConveyor(String conveyorName, String distShopName, String custSiteName) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        btSaveandclose.click("Save & Close");
        waitForElementToInvisible(buttonLoader,40000);
        btSearchinput.isVisible("Conveyor list screen");
    }

    public void createDuplicateConveyor(String conveyorName, String distShopName, String custSiteName) {
        waitForPageLoad(20000);
        SyncUtil.waitFor(10000);
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        btSaveandclose.click("Save & Close");
    }

    public void clickSaveBtn()
    {
        waitForElementVisible(btSaveandclose,10000,500);
        btSaveandclose.click("Save & Close");
        waitForElementToInvisible(buttonLoader,40000);
        waitForPageLoad(20000);

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
        addConveyors.jsClick("Add Conveyor");
        System.out.println("clickable before ++++++++++++");

        waitForElementToDisplay(tbConveyorname);
//        tbConveyorname.type(conveyorName);
        waitForElementToBeClickable(tbConveyorname);
        System.out.println("clickable ++++++++++++");
        tbConveyorname.sendKeys(conveyorName,"conveyor name");
        dropdownSelectSearch(drDistShopdropdown, tbSitedropdown, distShopName);
        dropdownSelectSearch(drSitedropdown, tbSitedropdown, custSiteName);
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
        waitForPageLoad(20000);
        btSearchinput.type(conveyorName, "Conveyor Search");
//        SyncUtil.waitFor(10000);
        waitForElementVisible(crCheckbox,20000,1000);
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Conveyor Found");
    }

    public void selectConveyor()
    {
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Checkbox");

    }
    public void searchSite(String siteName)
    {
        btSiteSearchInput.type(siteName,"Site Search");
        WebElement searchedSite=driver.findElement(By.xpath("//p-dropdownitem//li[@role='option' and contains(@aria-label, '"+siteName+"')]"));
        waitForElementToDisplay(searchedSite);
        searchedSite.click();
    }

    public void deleteConveyor(String conveyorName) {
        searchConveyor(conveyorName);
        SyncUtil.waitFor(1000);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        waitForElementVisible(crDelete, 10000,500);
        crDelete.click("Delete");
        crYesConfirmation.click("Confirm");
        waitForElementToDisplay(noList);
        SyncUtil.waitFor(2000);
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
        waitForPageLoad(10000);
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
                crIdlerSpacing.isVisible("Idler Spacing") && crDriveWrapAngle.isVisible("Drive Wrap Angle") && crTakeUpTension.isVisible("Take up Tension") &&
                crTemporaryFriction.isEnable("Friction Factor Temporary") && crFrictionFactor.isVisible("Friction Factor") && crLengthFactor.isVisible("Length Factor") &&
                crSurchargeFactor.isVisible("Surcharge Angle") && crIdleOffsetType.isVisible("Idler Offset Type ") && crDriveDetails.isEnable("Drive Details") && crTakeupDetails.isEnable("Take-up Details");
    }

    public boolean verifyInstalledBelt() {
        crInstalledBeltTab.click("Installed Belt Tab");
        return  !crMixedConfig.isEnabled() && crManufacturer.isEnable("Belt Manufacturer") &&
                crBeltConstruction.isVisible("Belt Construction") && crTopCompound.isVisible("Top Cover Compound") && crBottomCompound.isVisible("Bottom Cover Compound") &&
                crCarcass.isVisible("Carcass") && crWidth.isEnable("Width") && !crRatingRadio.isEnabled() && crBreakingStrengthRadio.isEnable("Breaking Strength Radio") &&
                crBreakingStrength.isVisible("Breaking Strength") && crTopCoverThickness.isVisible("Top Cover Thickness") && crBottomCoverThickness.isVisible("Bottom Cover Thickness") &&
                crLength.isVisible("Belt Length") && crSplice.isEnable("Splice Type ") && crSpliceQuality.isVisible("Splice Quality") && crInstallationDate.isVisible("Installation Date");
    }

    public boolean verifyMaterial() {
        crMaterialTab.click("Material Tab");
        return crDescription.isVisible("Material Description") && crBulkDensity.isVisible("Bulk Density") && crBulkSize.isVisible("Bulk Size") &&
                crLumpSize.isVisible("Lump Size") && crContingentOfFines.isVisible("Contingent of Fines") && crChuteDrop.isVisible("Chute Drop") &&
                crLoadingConditions.isEnable("Loading Conditions") && crTemperature.isVisible("Material Temperature") && crPresenceOfOil.isEnable("Presence of Oil");
    }

    public boolean verifyConveyor() {
        crConveyorTab.click("Conveyor Tab");
        return crConveyingLength.isVisible("Conveying Length") && crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power") &&
                crGearRatio.isVisible("Gear Ratio") && crDriveFrequency.isVisible("Driver Frequency") && crAngle.isVisible("Conveyor Angle") &&
                crSpeed.isVisible("Conveyor Speed") && crConveyingCapacity.isVisible("Conveying Capacity") && crPercentLoad.isVisible("Percent Load") && crMinimumTemperature.isVisible("Minimum Temperature") &&
                crMaximumTemperature.isVisible("Maximum Temperature") && crTakeupTravel.isVisible("Take Up Travel") && crEstimatedWeight.isVisible("Estimated Weight") && crManufacturer.isVisible("Conveyor Manufacturer") &&
                crDirectionTurnover.isEnable("Direction Turnover") && crClockwise.isEnable("Right / Clockwise");
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
                crImpactTotalIdlers.isVisible("Impact Total Number of Idlers") && !crIdlerOffset.isEnable() && crNoOfTransitionIdlers.isVisible("Number of Transition Idlers") && !crMisalignmentSensorsYes.isEnable() &&
                !crMisalignmentSensorsNo.isEnable();
    }

    public boolean verifyPulleys() {
        crPulleysTab.click("Pulleys Tab");
        return !crDrivePulley.isEnable() && !crBrakeDevice.isEnable() && crHeadPulleyDiameter.isVisible("Head Pulley Diameter");
//                crHeadPulleyWidth.isVisible("Head Pulley Width") && crHeadPulleyAngleOfWrap.isEnable("Head Pulley Angle Of Wrap") && crHeadPulleyLaggingType.isEnable("Head Pulley Lagging Type") &&
//                crHeadPulleyLaggingThickness.isVisible("Head Pulley Lagging Thickness") && crTailPulleyDiameter.isVisible("Tail Pulley Diameter") && crTailPulleyWidth.isVisible("Tail Pulley Width") && crTailPulleyAngleOfWrap.isEnable("Tail Pulley Angle Of Wrap") &&
//                crTailPulleyLaggingType.isEnable("Tail Pulley Lagging Type") && crTailPulleyLaggingThickness.isVisible("Tail Pulley Lagging Thickness");
    }

    public boolean verifyTransitionZone() {
        crTransitionZoneTab.click("Transition Zone Tab");
        return crHeadTransitionLength.isVisible("Flat-to-trough Transition Length") && crHeadPulleyLift.isVisible("Pulley Lift") && crTailTransitionLength.isVisible("Trough-to-flat Transition Length") && crTailPulleyLift.isVisible("Tail Pulley Lift") &&
                !crHeadTransitionTypeFull.isEnable() && !crHeadTransitionTypeHalf.isEnable() && !crTailTransitionTypeFull.isEnable() && !crTailTransitionTypeHalf.isEnable() &&
                !crMaterialGuidanceNo.isEnable() && !crMaterialGuidanceYes.isEnable() && !crConditionYes.isEnable() && !crConditionNo.isEnable();
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
        waitForElementToInvisible(analysingConveyors,15000);
        waitForElementToDisplay(fileAnalysedMsg);
    }

    public void acknowledgeImport(int count){
        waitForElementToDisplay(crImport);
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[1].contains(String.valueOf(count)),"Total Imported conveyors incorrect","All conveyors imported successfully");
        crImport.click("Import");
        waitForElementToDisplay(crImportSuccessful);
        waitForElementToDisplay(btSearchinput);
    }

    public void verifyUploadedConveyor(String siteName, String fileName) {
        SyncUtil.waitFor(6000);
        Object[][] obj = MiscUtils.getExcelData(fileName,siteName);
        for( int i = obj.length-1;i>0;i--)
            Validator.assertTrue(searchConveyor(((Map<String,String>)obj[i][0]).get("Name")),"Imported Conveyor was not created successfully","Imported conveyor created successfully");
    }

    public void editConveyorDetails(String newConveyorName) {
        scrollPageup();
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

    public void editConveyor(String oldConveyorName, String newConveyorName) {
        btSearchinput.type(oldConveyorName);
        crviewicon.click();
        conveyorNameLoader.waitForPartialText(oldConveyorName, 15000);
        waitForElementToDisplay(conveyorTitle);
        waitForElementToBeClickable(editConveyor);
        editConveyor.click();
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(tbConveyorname);
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        tbConveyorname.type(newConveyorName);
        SyncUtil.waitFor(1500);
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
        return crExportPDF.isEnable("Export PDF") && crExportCSV.isEnable("Export CSV") && crEdit.isEnable("Edit Conveyor") && crDelete.isEnable("Delete Conveyor");
    }

    public void addLayout(String corporates, String beltWidth, String rating, String length, String layoutName){
        addFilters(corporates,beltWidth,rating,length);
        btTableLayout.click("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        addNewLayout.click("Add New Layout");
        layoutInput.type(layoutName);
        addLayout.click("Add");
        waitForElementToInvisible(buttonLoader,20000);
        waitForElementToDisplay(layoutSuccessMsg);
        closeLayout.click("Close Layout");
    }

    public void addDuplicateLayout(String corporates, String beltWidth, String rating, String length, String layoutName) {
        addFilters(corporates, beltWidth, rating, length);
        btTableLayout.click("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        addNewLayout.click("Add New Layout");
        layoutInput.type(layoutName);
        addLayout.click("Add");

    }

    public boolean addFilters(String corporates, String beltWidth, String rating, String length){
//        waitForPageLoad(10000);
//        SyncUtil.waitFor(10000);
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToBeClickable(filterDropdown);
        filterDropdown.click();
        System.out.println("clicked");
        waitForElementVisible(filterDropdowPopup,20000,500);
//        SyncUtil.waitFor(10000);
//        filterDropdown.click();
        waitForElementToDisplay(tbMultipleSiteDropdown);
        tbMultipleSiteDropdown.type(corporates);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+corporates+"')]"));
        driver.findElement("//li/div[contains(text(),'"+corporates+"')]").click();

        tbMultipleSiteDropdown.type(beltWidth);
        waitForElementVisible(driver.findElement(By.xpath("//li/div[contains(text(),'"+beltWidth+"')]")),10000,500);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+beltWidth+"')]"));
        driver.findElement("//li/div[contains(text(),'"+beltWidth+"')]").click();

        tbMultipleSiteDropdown.type(rating);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+rating+"')]"));
        driver.findElement("//li/div[contains(text(),'"+rating+"')]").click();

        tbMultipleSiteDropdown.type(length);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+length+"')]"));
        driver.findElement("//li/div[contains(text(),'"+length+"')]").click();
        setImplicitWait(1000,TimeUnit.MILLISECONDS);
//        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, corporates);
//        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, beltWidth);
//        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, rating);
//        dropdownSelectSearch(filterDropdown, tbMultipleSiteDropdown, length);
        return verifyFilters();
    }

    public boolean addColumnFilters(String corporates) {
        waitForPageLoad(10000);
        SyncUtil.waitFor(10000);
        setImplicitWait(30000, TimeUnit.MILLISECONDS);
        waitForElementToBeClickable(filterDropdown);
        filterDropdown.click();
        System.out.println("clicked");
        waitForElementVisible(filterDropdowPopup, 20000, 500);
        SyncUtil.waitFor(10000);
        filterDropdown.click();
        waitForElementToDisplay(tbMultipleSiteDropdown);
        tbMultipleSiteDropdown.type(corporates);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'" + corporates + "')]"));
        driver.findElement("//li/div[contains(text(),'" + corporates + "')]").click();
        return verifyFilters();

    }

    public boolean verifyFilters(){
        return corporatesCol.isEnable() && BeltWidthCol.isEnable() && ratingCol.isEnable() && lengthCol.isEnable();
    }
    public boolean verifyCorporateFilter()
    {
        return corporatesCol.isEnable();

    }


    public void deleteLayout(String layoutName){
        waitForElementVisible(btTableLayout,10000,500);
        waitForElementToBeClickable(btTableLayout);
        btTableLayout.jsClick("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementVisible(defaultLayout,10000,500);
        waitForElementToBeClickable(defaultLayout);
        defaultLayout.jsClick("Default Radio");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+layoutName+"')]/following-sibling::div//span[contains(@class,'ctp-icon-Delete')]")),20000,500);
        driver.findElement(By.xpath("//div[contains(text(),'"+layoutName+"')]/following-sibling::div//span[contains(@class,'ctp-icon-Delete')]")).click();
        waitForElementVisible(deleteLayoutHeader,10000,500);
        deleteLayoutHeader.isVisible("Delete Header");
        deleteBtn.click("Delete");
        waitForElementToInvisible(buttonLoader,20000);
    }

    public boolean verifyViewRights(String conveyorName){
        searchConveyor(conveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        return btAddConveyor.isNotVisible(1000) && crEdit.isNotVisible(1000) && crDelete.isNotVisible(1000);
    }

    public void verifyConveyorBreadCrumb()
    {
        waitForPageLoad(15000);
        waitForElementVisible(conveyorBreadCrumb,10000,500);
        Assert.assertTrue(conveyorBreadCrumb.isDisplayed(), "Breadcrumb element is not displayed");
        assertEquals(conveyorBreadCrumb.getText(), "Home\nConveyors\nAdd", "Breadcrumb text does not match expected");

    }

    public void verifyGPSCoordinatesVisibility()
    {
        waitForElementVisible(txtGPSHead,10000,500);
        waitForElementVisible(tbHeadLong,5000,500);
        waitForElementVisible(tbHeadLat,5000,500);
        Validator.assertTrue(txtGPSHead.isVisible() && tbHeadLat.isVisible() && tbHeadLong.isVisible(),"The GPS Coordinate Head with lat and long textBox is not visible","The GPS Coordinate Head with lat and long textBox is visible");
        waitForElementVisible(txtGPSTail,10000,500);
        waitForElementVisible(tbTailLat,5000,500);
        waitForElementVisible(tbTailLat,5000,500);
        Validator.assertTrue(txtGPSTail.isVisible() && tbTailLat.isVisible() &&tbTailLong.isVisible(),"The GPS Coordinate Head with lat and long textBox is not visible","The GPS Coordinate Head with lat and long textBox is visible");

    }
    public void clickSiteDropDown()
    {
        waitForElementVisible(crSiteDropdown,5000,500);
        crSiteDropdown.click();

    }
    public void selectSiteName(String siteName)
    {
        searchSite(siteName);

    }
    public void verifyMapDisplaysSiteLocation(String siteName)
    {
        waitForPageLoad(20000);
        waitForElementVisible(driver.findElement(By.xpath("(//div[@title='"+siteName+"'])[1]")),20000,500);
        Validator.assertTrue(driver.findElement(By.xpath("(//div[@title='"+siteName+"'])[1]")).isDisplayed(),"Map is not displaying location","Map displays location of the site");

    }
    public void clickOnZoomIn()
    {
        waitForElementVisible(btnZoomIn,5000,500);
        btnZoomIn.jsClick();

    }
    public void clickOnZoomOut()
    {
        waitForElementVisible(btnZoomOut,5000,500);
        btnZoomOut.jsClick();
    }
    public void clickOnMap()
    {

            waitForElementVisible(mapLocation,10000,500);
            waitForElementToBeClickable(mapLocation);
            mapLocation.jsClick();
    }
    public void verifyPrefilledValuesDisplayed()
    {
        SyncUtil.waitFor(10000);
        waitForElementVisible(positionDialog,10000,500);
        waitForElementVisible(tbLatValue,10000,500);
        waitForElementVisible(tbLongValue,10000,500);
        Validator.assertTrue(tbLatValue.isVisible() && tbLongValue.isVisible(),"The prefilled values for lat and long is not visible","The prefilled values for lat and long is visible");
    }

    public void clickOnLocationType()
    {
        waitForElementVisible(ddlLocationType,10000,500);
        waitForElementToBeClickable(ddlLocationType);
        ddlLocationType.jsClick();

    }

    public void clickOnLocationTwoType()
    {
        waitForElementVisible(ddlLocationTwoType,10000,500);
        waitForElementToBeClickable(ddlLocationTwoType);
        ddlLocationTwoType.jsClick();

    }
    public void selectLocationTypeHead()
    {
        waitForElementVisible(optionsHead,10000,500);
        waitForElementToBeClickable(optionsHead);
        optionsHead.jsClick();

    }
    public void addMarkerBtnClick()
    {
        waitForElementVisible(btnAddMarker,5000,500);
        waitForElementToBeClickable(btnAddMarker);
        btnAddMarker.click();
        waitForPageLoad(10000);

    }
    public void verifyUpdatedGPSHead()
    {
        SyncUtil.waitFor(5000);
        waitForElementVisible(tbFilledHeadLat,10000,500);
        waitForElementVisible(tbFilledHeadLong,10000,500);
        Validator.assertTrue(tbFilledHeadLat.isVisible() && tbFilledHeadLong.isVisible(),"GPS Coordinates Head is not updated with lat long value","GPS Coordinates Head is updated with lat long value");

    }

    public void selectLocationTypeTail()
    {
        waitForElementVisible(optionsTail,10000,500);
        waitForElementToBeClickable(optionsTail);
        optionsTail.jsClick();

    }

    public void verifyUpdatedGPSTail()
    {
        SyncUtil.waitFor(10000);
        waitForElementVisible(tbFilledTailLat,10000,500);
        waitForElementVisible(tbFilledTailLong,10000,500);
        Validator.assertTrue(tbFilledTailLat.isVisible() && tbFilledTailLong.isVisible(),"GPS Coordinates Tail is not updated with lat long value","GPS Coordinates Tail is updated with lat long value");

    }
    public void verifyErrorMessageIsDisplayed()
    {
        waitForPageLoad(20000);
//        System.out.println("created duplicate conveyor");
//        SyncUtil.waitFor(10000);
        waitForElementVisible(conveyorErrorMsg,10000,500);
        Validator.assertTrue(conveyorErrorMsg.isVisible(),"Error message is not displayed creating duplicate conveyor","Error message is displayed creating duplicate conveyor");

    }
    public void remarksBtnClick()
    {
        waitForElementVisible(crRemarksTab,5000,500);
        crRemarksTab.click("Remarks Tab");
        waitForPageLoad(10000);

    }

    public void clickOnSaveAndCloseBtn()
    {
        waitForElementVisible(btSaveandclose,10000,500);
        btSaveandclose.click("Save & Close");
        waitForPageLoad(10000);

    }

    public void verifyNavigationToConveyorSiteCard()
    {

		SyncUtil.waitFor(50000);
            waitForPageLoad(10000);
            waitForElementVisible(siteHeader,10000,500);
            Validator.assertTrue(siteHeader.isVisible(),"User is not navigated to site page on save and close","User is navigated to site detail page on save and close");
            Validator.assertTrue(driver.getCurrentUrl().contains("/secure/sites/details"),"User is not navigated to site page on save and close","User is navigated to site  page on save and close");

    }

    public void createConveyorWithRequiredField(String conveyorName, String distShopName, String custSiteName) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
    }

    public void previousBtnClick()
    {
        waitForElementVisible(btnPrevious,5000,500);
        btnPrevious.click("Previous");
        waitForPageLoad(10000);

    }
    public boolean verifyTransitionPage() {
        waitForElementVisible(crHeadTransitionLength,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/transitions"),"user is not navigated to transition add page","user is navigated to transition add page");
        return crHeadTransitionLength.isVisible("Flat-to-trough Transition Length") && crHeadPulleyLift.isVisible("Pulley Lift");
    }

    public void addDataAsImperial(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        unitIcon.click();
        waitForElementVisible(btImperialUnit,5000,1000);
        waitForElementToBeClickable(btImperialUnit);
        btImperialUnit.click();
    }
    public void verifyDataHeaderUnitInAddConveyor(String unit)
    {
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForPageLoad(5000);
        waitForElementVisible(unitIconConveyor,5000,1000);
        Validator.assertTrue(unitIconConveyor.getText("Unit Value").contains(unit),"Metric unit is not selected","Metric unit is selected");

    }
    public void navigateToAddConveyorPage()
    {
        waitForElementVisible(btAddConveyor,10000,500);
        btAddConveyor.click("Add icon");
        tbConveyorname.isVisible("Conveyor Name");
    }

    public void verifyConveyorHeading(String conveyorName)
    {
        waitForPageLoad(20000);
        SyncUtil.waitFor(5000);
        String conveyorHeading="(//div[contains(@class,'p-panel-header')]/span)[1]";
        waitForElementVisible(driver.findElement(By.xpath(conveyorHeading)),20000,500);
        Assert.assertEquals(conveyorName,driver.findElement(By.xpath(conveyorHeading)).getText(),"The Conveyor Header is not displayed");
    }

    public void verifyPrefilledConveyorValues()
    {
        waitForElementVisible(tbFilledCorporateName,10000,500);
        Validator.assertTrue(tbFilledCorporateName.isVisible(),"The Corporate Name with prefilled value is not visible","The Corporate Name with prefilled value is not visible");
        Validator.assertTrue(tbFilledSite.isVisible(),"The Site with prefilled value is not visible","The Site with prefilled value is not visible");
//        Validator.assertTrue(tbFilledDistributor.isVisible(),"The Distributor with prefilled value is not visible","The Distributor with prefilled value is not visible");
        Validator.assertTrue(tbFilledLocation.isVisible(),"The Location with prefilled value is not visible","The Location with prefilled value is not visible");
        Validator.assertTrue(tbFilledTerritory.isVisible(),"The Territory with prefilled value is not visible","The Territory with prefilled value is not visible");
        Validator.assertTrue(tbFilledTerritoryManager.isVisible(),"The Territory Manager with prefilled value is not visible","The Territory Manager with prefilled value is not visible");


    }

    public void verifyMapIsVisible()
    {
        waitForPageLoad(10000);
        waitForElementVisible(mapLocation,10000,500);
        Validator.assertTrue(mapLocation.isVisible(),"The map is not visible","The map is visible");

    }
    public void verifyHeadLocationDisplayInMap()
    {
        waitForElementVisible(headMapLocation,10000,500);
        Validator.assertTrue(headMapLocation.isVisible(),"Conveyor head location is not visible","Conveyor head location is visible");

    }
    public void verifyTailLocationDisplayInMap()
    {
        waitForElementVisible(tailMapLocation,10000,500);
        Validator.assertTrue(tailMapLocation.isVisible(),"Conveyor tail location is not visible","Conveyor tail location is visible");

    }
    public void pinLocationClick()
    {
        waitForElementVisible(headMapLocation,10000,500);
        waitForElementToBeClickable(headMapLocation);
        headMapLocation.jsClick();
        waitForPageLoad(10000);

    }

    public void verifyHeadConveyorName()
    {
        waitForElementVisible(conveyorNameLabel,10000,500);
        waitForElementVisible(locationCloseBtn,10000,500);
        Validator.assertTrue(conveyorNameLabel.isVisible() && locationCloseBtn.isVisible(),"Label with conveyorName and cross button is not displayed","Label with conveyorName and cross button is displayed");
    }
    public void closeBtnClick()
    {
        waitForElementVisible(locationCloseBtn,10000,500);
        waitForElementToBeClickable(locationCloseBtn);
        locationCloseBtn.jsClick("close button clicked");


    }
    public void verifyLabelIsClosed()
    {
        Validator.assertTrue(conveyorNameLabel.verifyNotPresent(),"Label is not closed","Label is closed");

    }

    public void clickOnLayoutPicker()
    {
        waitForElementVisible(btTableLayout,10000,500);
        btTableLayout.click("Add Table Layout");

    }

    public void verifyLayoutPopupDisplay()
    {
        waitForElementVisible(tableLayoutHeader,10000,500);
        tableLayoutHeader.isVisible("Table Layout");
        Validator.assertTrue(tableLayoutHeader.isVisible(),"The layout popup is not visible","The layout popup is visible");
    }
    public void addNewLayoutBtnClick()
    {
        waitForElementVisible(addNewLayout,10000,500);
        addNewLayout.click("Add New Layout");
    }

    public void verifySetLayoutName(String layoutName)
    {
        waitForElementVisible(layoutInput,10000,500);
        layoutInput.type(layoutName,"layoutName");
    }

    public void verifyAddBtnEnabled()
    {
        Validator.assertTrue(addBtnDisabled.verifyNotPresent()&& addLayout.isVisible(),"add button is disabled","add button is enabled");

    }

    public void verifyDuplicateLayoutError()
    {
        waitForElementVisible(layoutToastError,5000,1000);
        Validator.assertTrue(layoutToastError.isDisplayed(),"the error message for duplicate layout is not visible","The error message for duplicate layout is visible");
    }

    public void verifyColumnNameFilterIsVisible()
    {
        waitForPageLoad(10000);
        waitForElementVisible(columnNameFilter,10000,500);
        Validator.assertTrue(columnNameFilter.isVisible(),"The column name filter is not visible","The column name filter is visible");

    }

    public void verifyColumnNameFields()
    {
        waitForElementVisible(tbMultipleSiteDropdown,10000,500);
        Validator.assertTrue(tbMultipleSiteDropdown.isVisible(),"SearchBar is not visible","SearchBar is visible");
        verifyColumnNamesArray();
        waitForElementVisible(btnColumnNameFilterClose,10000,500);
        Validator.assertTrue(btnColumnNameFilterClose.isVisible(),"Cross button is not visible","Cross button is visible");

    }

    public void verifyColumnNamesArray()
    {

        for (String columnName : columnNames) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            System.out.println(columnName);
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]]")), 20000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]]")).isDisplayed(), "column name '" + columnName + "' is not visible", "column name '" + columnName + "' is visible");
        }
    }

    public void verifyCheckedColumnNames()
    {
        waitForPageLoad(10000);
        setImplicitWait(20000,TimeUnit.MILLISECONDS);
        for (String columnName : columnNames) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            System.out.println(columnName);
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]//div//checkicon]")), 20000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]//div//checkicon]")).isDisplayed(), "column name '" + columnName + "' is not checked", "column name '" + columnName + "' is checked");
        }

    }
    public void searchColumnName(String columnNames)
    {
        waitForElementVisible(tbMultipleSiteDropdown,20000,500);
        tbMultipleSiteDropdown.type(columnNames);

    }
    public void verifySearchedColumnNames()
    {
        waitForElementVisible(cbInstalledBeltColumn,10000,500);
        Validator.assertTrue(cbInstalledBeltColumn.isVisible() && cbBeltManufacturerColumn.isVisible() &&cbBeltSpeedColumn.isVisible() &&cbBeltConstructionColumn.isVisible() && cbBeltWidthColumn.isVisible() ,"The column names with searched text  is not visible","The column names with searched text is  visible");
    }
    public void checkboxClick()
    {
        waitForElementVisible(cbAllColumnNames,10000,500);
        cbAllColumnNames.jsClick("checkbox checked");
    }

    public void verifySearchedColumnNamesInTable()
    {
        waitForElementVisible(thInstalledBelt,10000,500);
        Validator.assertTrue(thInstalledBelt.isVisible() && thBeltContraction.isVisible() && thBeltSpeed.isVisible() && thBeltWidth.isVisible()
        && thbeltManufacturer.isVisible(),"Table names of searched column is not visible","Table names of searched column is  visible");
    }

    public void clearSearchBar()
    {
        waitForElementVisible(tbMultipleSiteDropdown,20000,500);
        tbMultipleSiteDropdown.clear();
        tbMultipleSiteDropdown.sendKeys(" ");
        setImplicitWait(20000,TimeUnit.MILLISECONDS);

    }
    public void closeColumnFilterBtnClick()
    {
        waitForElementVisible(btnColumnNameFilterClose,10000,500);
        btnColumnNameFilterClose.jsClick("close button");

    }
    public void verifyAllColumnsVisibleInTable()
    {
        for (String columnName : columnNames) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            System.out.println(columnName);
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., ' " + columnName + " ') and .//div[contains(@class, 'p-checkbox')]]")), 20000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., ' " + columnName + " ') and .//div[contains(@class, 'p-checkbox')]]")).isDisplayed(), "column name '" + columnName + "' is not visible in table", "column name '" + columnName + "' is visible in table");
        }

    }
    public void verifyColumnFilterClosed()
    {
        Validator.assertTrue(columnFilterPanel.verifyNotPresent(),"the column filter panel is visible","The column filter panel is closed");
    }
    public void hoverOverColumn()
    {
        waitForElementVisible(thNameColumn,10000,500);
        hoverOverElement(thNameColumn);
    }
    public void verifyFilterIconVisible()
    {
        waitForElementVisible(nameFilterIcon,10000,500);
        Validator.assertTrue(nameFilterIcon.isVisible(),"The filter icon is not visible on hover","The filter icon is visible on hover");

    }
    public void verifyFilterIconHighlighted()
    {
        waitForElementVisible(nameFilterIconHighlighted,20000,500);
        Validator.assertTrue(nameFilterIconHighlighted.isVisible(),"The filter icon is not highlighted on hover","The filter icon is  highlighted on hover");

    }
    public void filterIconClick()
    {
        waitForElementVisible(nameFilterIcon,20000,500);
        waitForElementToBeClickable(nameFilterIcon);
        waitForElementToBeClickable(nameFilterIcon);
        nameFilterIcon.click();
    }
    public void verifyFilterFields(String filter)
    {
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementVisible(ddlMatchAll,10000,500);
        Validator.assertTrue(ddlMatchAll.isVisible(),"Match all dropdown is not visible","Match all dropdown is visible");
//        String filterField="//div[contains(@class,'p-column-filter-matchmode-dropdown')]//span[text()='"+filter+"']";
//        setImplicitWait(20000,TimeUnit.MILLISECONDS);

//        waitForElementVisible(driver.findElement(By.xpath(filterField)),10000,500);
        Validator.assertTrue(ddlStartsWith.isVisible(),"starts with dropdown is not visible","starts with dropdown is visible");
        Validator.assertTrue(filterSearchTextBox.isVisible(),"search text box  is not visible"," Search text box is visible");
        Validator.assertTrue(addRuleLink.isVisible(),"Add rule link is not visible","Add rule link dropdown is visible");
        Validator.assertTrue(btnFilterClear.isVisible(),"clear button is not visible","clear button is visible");
        Validator.assertTrue(btnFilterApply.isVisible(),"Apply button is not visible","Apply button is visible");
    }

    public void StartsWithFilterClick() {
        waitForElementVisible(ddlContains,10000,500);
        ddlContains.click();
        waitForElementVisible(ddlStartsWith,10000,500);
        ddlStartsWith.click();
    }
    public void FilterClick(String filter)
    {
        String filterName="//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//span[text()='"+filter+"']";
        waitForElementVisible(driver.findElement(By.xpath(filterName)),10000,500);
        driver.findElement(By.xpath(filterName)).click();
    }

//    public void verifyFilterSelected()
//    {
//        setImplicitWait(20000,TimeUnit.MILLISECONDS);
//        ddlStartsWith.jsClick();
//        setImplicitWait(20000,TimeUnit.MILLISECONDS);
//        SyncUtil.waitFor(10000);
//        waitForElementVisible(ddlStartsWithSelected,20000,500);
//        Validator.assertTrue(ddlStartsWithSelected.isVisible(),"The starts with filter is not selected","The starts with filter is highlighted");
//    }

    public void verifyFilter(String filter) {
        waitForElementVisible(ddlStartsWith, 10000, 500);
        waitForElementToBeClickable(ddlStartsWith);
        ddlStartsWith.click();
        SyncUtil.waitFor(5000);
        System.out.println("First time clicked before selecting");

        String filterType = "//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//span[text()='" + filter + "']";
        if (!filter.equals("Starts with")) {
            try {
                driver.findElement(By.xpath(filterType)).click();
                SyncUtil.waitFor(5000); // Wait for a short period after clicking
                waitForElementVisible(driver.findElement(By.xpath(filterType)),20000,500);
                driver.findElement(By.xpath(filterType)).click(); // Double click to ensure selection
                SyncUtil.waitFor(5000);
                String filterTypeHighlighted = "//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//li[@aria-selected=\"true\"]//span[text()='" + filter + "']";
                waitForElementVisible(driver.findElement(By.xpath(filterTypeHighlighted)), 10000, 500);
                Validator.assertTrue(driver.findElement(By.xpath(filterTypeHighlighted)).isDisplayed(), "The '" + filter + "' filter is not selected", "The '" + filter + "' filter is highlighted");
            } catch (NoSuchElementException e) {
                Assert.fail("Filter option '" + filter + "' not found.");
            }
        } else {
            System.out.println("After click verifying");
            SyncUtil.waitFor(5000);
            waitForElementVisible(ddlStartsWithSelected, 20000, 500);
            Validator.assertTrue(ddlStartsWithSelected.isVisible(), "The starts with filter is not selected", "The starts with filter is highlighted");
        }
    }

    public void enterSearchText(String searchText)
    {
        waitForElementVisible(filterSearchTextBox,10000,500);
        filterSearchTextBox.clear();
        filterSearchTextBox.type(searchText,"searchText");

    }
    public void verifyTextEntered()
    {
        waitForElementVisible(filterSearchTextBoxFilled,10000,500);
        Validator.assertTrue(filterSearchTextBoxFilled.isVisible(),"Text is not entered","Text is entered");
    }
    public void applyBtnClick()
    {
        waitForElementVisible(btnFilterApply,10000,500);
        btnFilterApply.click();
    }
    public void verifyFilterApplied(int noOfCoverWears,String filterType)
    {
        for(int i=1;i<=noOfCoverWears;i++)
        {
            String columnData=driver.findElement(By.xpath("//tr['"+i+"']//td[4]")).getText();
            if(columnData.startsWith("C1") ||columnData.contains("common"))
            {
                Validator.assertTrue(true, "Filter '"+filterType+"' is not applied for row ","filter '"+filterType+"' is applied");
            }

        }

    }
    public void verifyFilterPopupClosed()
    {
        Validator.assertTrue(filterPopup.verifyNotPresent(),"The filter popup is not closed","Filter popup is closed");
    }
    public void clearFilterPopupButtonClick()
    {
        waitForElementVisible(btnFilterClear,10000,500);
        btnFilterClear.click();

    }
    public void verifyFilterRemoved()
    {
        Validator.assertTrue(filterSearchTextBoxFilled.verifyNotPresent(),"the filter is not removed","The filter is removed");
    }
    public void verifyDragAndDrop()
    {
        waitForElementVisible(tableLayoutHeader,10000,500);
        waitForElementVisible(layoutDialog,10000,500);


        int initialX = layoutDialog.getLocation().getX();
        int initialY = layoutDialog.getLocation().getY();
        System.out.println("Initial Position: (" + initialX + ", " + initialY + ")");
        SyncUtil.waitFor(10000);

        hoverOverElement(tableLayoutHeader);
        SyncUtil.waitFor(10000);
        dragAndDrop(tableLayoutHeader,btTableLayout);

        waitForElementVisible(layoutDialog,10000,500);


        int newX = layoutDialog.getLocation().getX();
        int newY = layoutDialog.getLocation().getY();
        System.out.println("New Position: (" + newX + ", " + newY + ")");

        // Verify the element has moved
        if (initialX == newX && initialY == newY) {
            throw new AssertionError("X and Y coordinates did not change");
        }

    }

    public void actionBtnClick()
    {
        waitForElementVisible(crActions,10000,500);
        crActions.jsClick("Actions");

    }
    public void selectEditOption()
    {
        waitForElementVisible(crEdit,10000,500);
        crEdit.jsClick("Edit");
    }
    public void verifyConveyorDetailPageNavigation()
    {
        SyncUtil.waitFor(20000);

        waitForPageLoad(20000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/conveyor/update/details"),"User is not navigated to conveyor details page ","User is  navigated to conveyor details page");

    }
    public void updateConveyorLiteField()
    {
        btNext.click("NextBtn");
        waitForPageLoad(10000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/conveyor/update/conveyor-lite"),"User is not navigated to conveyor-lite page ","User is  navigated to conveyor-lite page");
        waitForElementToBeClickable(crBeltSpeed);
        crBeltSpeed.clear();
        crBeltSpeed.type("500");

    }
    public void updateBtnClick()
    {
        waitForElementVisible(crUpdate,10000,500);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
    }
    public void verifyConveyorUpdation()
    {
        waitForElementVisible(successToast,20000,500);
        Validator.assertTrue(successToast.isVisible(),"The conveyor is not updated","The conveyor is updated");
    }
    public void verifyPrefilledFieldsInConveyorLite()
    {
        scrollPageDown();
        waitForElementVisible(tbPrefilledBeltWidth,10000,500);
        Validator.assertTrue(tbPrefilledBeltWidth.isVisible() && tbPrefilledBeltSpeed.isVisible() && tbMaterialDensity.isVisible(),"non-editable prefilled value is not present in conveyor-lite page","non-editable prefilled value is  present in conveyor-lite page");

    }
    public void verifyPrefilledFieldsInInstalledBelt()
    {
        waitForElementVisible(tabInstalledBelt,10000,500);
        tabInstalledBelt.click();
        waitForPageLoad(10000);
        Validator.assertTrue(tbPrefilledBeltManufacturer.isPresent() && tbPrefilledBeltConstruction.isPresent(),"non-editable prefilled value is not present in installed-belt page","non-editable prefilled value is  present in installed-belt page");

    }
    public void verifyPrefilledFieldsInMaterial()
    {
        waitForElementVisible(tabMaterial,10000,500);
        tabMaterial.click();
        waitForPageLoad(10000);
        Validator.assertTrue(tbPrefilledDescription.isPresent() && tbPrefilledBulkDensity.isPresent(),"non-editable prefilled value is not present in material page","non-editable prefilled value is  present in material page");
    }
    public void verifyPrefilledFieldsInConveyor()
    {
        waitForElementVisible(tabConveyor,10000,500);
        tabConveyor.click();
        waitForPageLoad(10000);
        Validator.assertTrue(tbPrefilledConveyingLength.isPresent() && tbPrefilledLift.isPresent(),"non-editable prefilled value is not present in conveyor page","non-editable prefilled value is  present in conveyor page");
    }

    public void editTonsPerHour(String tonsPerHour)
    {
        waitForElementToBeClickable(editConveyor);
        editConveyor.click();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltWidth.isVisible(),"Conveyor Lite page is not loaded","Conveyor Lite page is loaded");
        waitForElementToBeClickable(crTonsPerHr);
        crTonsPerHr.clear();
        crTonsPerHr.type(tonsPerHour);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
        SyncUtil.waitFor(3000);
        scrollPageup();
    }
    public void verifyDataUnitInAddConveyorForTonsPerHour(String unit)
    {
        waitForElementVisible(crTonsPerHrUnit,10000,1000);
        Validator.assertTrue(crTonsPerHrUnit.getText("Unit Value").contains(unit),"unit is not selected Correctly","unit is selected Correctly");
    }
    public void verifyDataHeaderUnitAsMetric(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        unitIcon.click();
        waitForElementVisible(cbMetricUnit,5000,1000);
        Validator.assertTrue(cbMetricUnit.isDisplayed(),"Metric unit is not selected","Metric unit is selected");
//        unitIcon.click();
    }
    public void verifyDataHeaderUnitAsImperial(){
        waitForPageLoad(5000);
        waitForElementVisible(unitIcon,5000,1000);
        waitForElementToBeClickable(unitIcon);
        SyncUtil.waitFor(5000);
        unitIcon.click();
        SyncUtil.waitFor(10000);
        waitForElementVisible(cbImperialUnit,5000,1000);
        Validator.assertTrue(cbImperialUnit.isDisplayed(),"Imperial unit is not selected","Imperial unit is selected");
    }
    public void verifySiteAndConveyorPreFilled()
    {
        Validator.assertTrue(tbCorporateName.isDisplayed(),"Corporate Name is not prefilled","Corporate Name is prefilled");
        Validator.assertTrue(tbSite.isDisplayed(),"Site is not prefilled","Site is prefilled");
    }
    public void editMapLocation()
    {
        clickOnMap();
        verifyPrefilledValuesDisplayed();
        clickOnLocationType();
        selectLocationTypeHead();
        addMarkerBtnClick();
        verifyUpdatedGPSHead();
    }



}
