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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;

public class ConveyorPage extends BasePage{

    @FindBy(locator = "xpath=//span[text()='Add Conveyor']")
    public CustomElement addConveyors;

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//li//span[text()='Conveyors'])[1]")
    public CustomElement conveyorList;

    @FindBy(locator = "xpath=(//app-card//div[text()='File Manager'])[1]")
    public CustomElement fileManagerCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Technical Data'])[1]")
    public CustomElement technicalDataCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyor History'])[1]")
    public CustomElement conveyorHistoryCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Cover Wear'])[1]")
    public CustomElement coverWearCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Inspections'])[1]")
    public CustomElement inspectionCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyor Inspect'])[1]")
    public CustomElement conveyorInspectCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Belt Scans'])[1]")
    public CustomElement beltScanCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Monitoring Devices'])[1]")
    public CustomElement monitoringDevicesCard;

    @FindBy(locator = "xpath=(//app-card//div[text()='Minuteman Calc.'])[1]")
    public CustomElement minutemanCard;

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

    @FindBy(locator = "xpath=//span[text()='Create']")
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

    @FindBy(locator = "xpath=//span[text()='Save']")
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

    @FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]")
    public CustomElement crDeleteFileUpload;

    @FindBy(locator = "xpath=//i[contains(@class,'ctp-icon-Delete')]/../preceding-sibling::div")
    public CustomElement crUploadedFileName;

    @FindBy(locator = "xpath=//div[contains(text(),'Conveyors will be created.')]")
    public CustomElement crUploadSuccessText;

    @FindBy(locator = "xpath=//div[contains(text(),'1 or more conveyor needs attention.')]")
    public CustomElement crUploadWarningText;

    @FindBy(locator = "xpath=//div[contains(text(),'Please review before continue.')]")
    public CustomElement crUploadReviewText;

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

    @FindBy(locator = "xpath=//div[text()='Layout created successfully']")
    public CustomElement layoutSuccessMsg;

    @FindBy(locator = "xpath=//span[text()='Conveyor']")
    public CustomElement conveyorTab;

    @FindBy(locator = "xpath=(//div[contains(@id,'titlebar')]/span)[1]")
    public CustomElement conveyorNameLoader;

    @FindBy(locator = "xpath=//label[text()='Analyzing Conveyors']")
    public CustomElement analysingConveyors;

    @FindBy(locator = "xpath=//h6[text()='Bulk Steps:']")
    public CustomElement bulkSteps;

    @FindBy(locator = "xpath=//h6[text()='Import Form']")
    public CustomElement importForm;

    @FindBy(locator = "xpath=//h6[text()='File Drop or Select']")
    public CustomElement fileDrop;

    @FindBy(locator = "xpath=//p-radiobutton[@id='skipHeader']")
    public CustomElement skipRadio;

    @FindBy(locator = "xpath=//p-radiobutton[@id='updateHeader']")
    public CustomElement updateRadio;

    @FindBy(locator = "xpath=//p-radiobutton[@id='copyHeader']")
    public CustomElement copyRadio;

    @FindBy(locator = "xpath=//span[text()='Continue']")
    public CustomElement crContinue;

    @FindBy(locator = "xpath=//span[text()='Back']")
    public CustomElement crBack;

    @FindBy(locator = "xpath=//div[@class='p-progress-spinner']")
    public CustomElement spinner;

    @FindBy(locator = "xpath=//span[contains(@class,'ctp-icon-sort-icon-down')]/..")
    public CustomElement conveyorHistorySort;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[1]")
    public CustomElement btAddConveyorHistory;

    @FindBy(locator = "xpath=//span[text()='Belt Failure']")
    public CustomElement conveyorHistoryBeltFailure;

    @FindBy(locator = "xpath=//span[text()='Component Change']")
    public CustomElement conveyorHistoryComponentChange;

    @FindBy(locator = "xpath=//span[text()='Custom Event']")
    public CustomElement conveyorHistoryCustomEvent;

    @FindBy(locator = "xpath=//span[text()='Details']")
    public CustomElement crDetailsTab;

    @FindBy(locator = "xpath=//span[text()='Transitions']")
    public CustomElement crTransitionTab;

    @FindBy(locator = "xpath=//span[text()='Cancel']")
    public CustomElement btnCancel;

    @FindBy(locator="//img[@src='/assets/img/upload_default.png']")
    public CustomElement addDefaultImgSrc;

    @FindBy(locator="//div[@role='dialog']")
    public CustomElement imageViewerPanel;

    @FindBy(locator="//label[@for='firstname2']/../div//app-master-data-picker/../span")
    public CustomElement unitIconConveyor;

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;

    @FindBy(locator="xpath=//span[text()='Update']")
    public CustomElement btUpdate;

    @FindBy(locator="xpath=//label[text()='Corporate Name']/../div[1]//input[contains(@class,'p-filled')]")
    public CustomElement tbCorporateName;

    @FindBy(locator="xpath=//label[text()='Corporate Name']/../div[2]//input[contains(@class,'p-filled')]")
    public CustomElement tbSite;

    @FindBy(locator="xpath=//label[contains(text(),'Width')]/../div/span")
    public CustomElement crWidthUnit;

    @FindBy(locator="xpath=//label[text()='Tons per Hour Peak']/../div/span")
    public CustomElement crTonsPerHrUnit;

    @FindBy(locator="xpath=//button[text()='Back']")
    public CustomElement btnBack;

    @FindBy(locator="xpath=//div[text()=' Common Regression Layout ']//p-radiobutton")
    public CustomElement rdBtnCommonLayout;

    @FindBy(locator="xpath=//button[text()='Save Set Preference']")
    public CustomElement btnSaveSetPreference;

    @FindBy(locator= "xpath=//input[contains(@class,'p-multiselect-filter')]/../../button")
    public CustomElement tbMultipleSiteDropdownCancel;

    @FindBy(locator= "xpath=//th[@id='topCoverThickness']//div")
    public CustomElement thTopCoverThickness;

    @FindBy(locator = "xpath=//div/span[text()='Conveyors']")
    public CustomElement conveyorHeader;

    @FindBy(locator="xpath=//th[@id='img-column']")
    public CustomElement hdImage;

    @FindBy(locator="xpath=//th[@id='name-col']")
    public CustomElement hdName;

    @FindBy(locator="xpath=//th[@id='site-col']")
    public CustomElement hdSite;

    @FindBy(locator="xpath=//th[@id='lastmodified-col']")
    public CustomElement hdLastMod;

    @FindBy(locator="xpath=//th[@id='install-col']")
    public CustomElement hdInstallBelt;

    @FindBy(locator="xpath=//th[@psortablecolumn='beltLife']")
    public CustomElement hdRemainingLife;

    @FindBy(locator="xpath=//th[@psortablecolumn='percentage']")
    public CustomElement hdRemainingCover;

    @FindBy(locator="xpath=//th[@id='inspec-col']")
    public CustomElement hdInspectionItem;

    @FindBy(locator="xpath=//th[@id='more-col']")
    public CustomElement hdMore;

    @FindBy(locator="xpath=//tbody//td[4]")
    public CustomElement hdNameValue;

    @FindBy(locator="xpath=//tbody//td[5]")
    public CustomElement hdSiteValue;

    @FindBy(locator="xpath=//tbody//td[6]")
    public CustomElement hdLastModValue;

    @FindBy(locator="xpath=//tbody//td[7]")
    public CustomElement hdInstallBeltValue;

    @FindBy(locator="xpath=//tbody//td[8]")
    public CustomElement hdRemainingLifeValue;

    @FindBy(locator="xpath=//tbody//td[9]")
    public CustomElement hdRemainingCoverValue;

    @FindBy(locator="xpath=//anglelefticon")
    public CustomElement btPgPrev;

    @FindBy(locator="xpath=//button[@class='p-ripple p-element p-paginator-page p-paginator-element p-link ng-star-inserted p-highlight']")
    public CustomElement btPgHighlightedValue;

    @FindBy(locator = "xpath=//span[text()='Bulk Import']")
    public CustomElement bulkImport;

    @FindBy(locator = "xpath=//h6[text()='File Drop or Select']")
    public CustomElement fileDropHeader;

    @FindBy(locator = "xpath=//span[text()='Back']")
    public CustomElement btBack;
    @FindBy(locator = "xpath=//span[text()='Continue']")
    public CustomElement btnContinue;
    @FindBy(locator = "xpath=//p-radiobutton[@value='skip']")
    public CustomElement rdBtnSkip;
    @FindBy(locator = "xpath=//p-radiobutton[@value='update']")
    public CustomElement rdBtnUpdate;
    @FindBy(locator = "xpath=//p-radiobutton[@value='copy']")
    public CustomElement rdBtnCopy;
    @FindBy(locator = "xpath=//th[text()=' Errors ']")
    public CustomElement txtErrors;
    @FindBy(locator = "xpath=//label[text()='Distributor']/..//p-dropdown[@datakey='companyId']")
    public CustomElement drpDownDistributor;
    @FindBy(locator = "xpath=//div[contains(@class,'p-dropdown-panel')]")
    public CustomElement drpDownDistPopUp;
    @FindBy(locator="xpath=//div[contains(@class,'p-dropdown-filter-container')]//input")
    public CustomElement drpDownSearchInput;
    @FindBy(locator="xpath=//label[text()='Yes']/../p-radiobutton")
    public CustomElement rdBtnYes;

    @FindBy(locator="xpath=//span[text()='Select']")
    public CustomElement btSelectInput;
    @FindBy(locator="xpath=//p-multiselectitem")
    public CustomElement multiSelectSite;
    @FindBy(locator="xpath=//span[text()='Download Template']")
    public CustomElement btDownloadTemp;


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
        waitForElementToInvisible(buttonLoader,40000);
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
        dropdownSelectSearch(drDistShopdropdown, tbSitedropdown, distShopName);
        dropdownSelectSearch(drSitedropdown, tbSitedropdown, custSiteName);
    }

    public void checkConveyorGermany(String conveyorName, String custCorpName) {
        goToConveyorListScreen();
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
        SyncUtil.waitFor(1000);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        waitForElementVisible(crDelete, 20000,500);
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
//        return crBeltWidth.isVisible("Belt Width") && crBeltSpeed.isVisible("Belt Speed") && crTonsPerHr.isVisible("Tons Per hr") &&
//                crMaterialName.isVisible("Material Name") && crMaterialDensity.isVisible("Material Density") && crAngleOfIdlers.isVisible("Angle Of Idlers") &&
//                crIdlerSpacing.isVisible("Idler Spacing") && crDriveWrapAngle.isVisible("Drive Wrap Angle") && crTakeUpTension.isVisible("Take up Tension") &&
//                crTemporaryFriction.isEnable("Friction Factor Temporary") && crFrictionFactor.isVisible("Friction Factor") && crLengthFactor.isVisible("Length Factor") &&
//                crSurchargeFactor.isVisible("Surcharge Angle") && crIdleOffsetType.isVisible("Idler Offset Type ") && crDriveDetails.isEnable("Drive Details") && crTakeupDetails.isEnable("Take-up Details");
        return crBeltWidth.isVisible("Belt Width");
    }

    public boolean verifyInstalledBelt() {
        crInstalledBeltTab.click("Installed Belt Tab");
//        return  !crMixedConfig.isEnabled() &&
//                crBeltConstruction.isVisible("Belt Construction") && crTopCompound.isVisible("Top Cover Compound") && crBottomCompound.isVisible("Bottom Cover Compound") &&
//                crCarcass.isVisible("Carcass") && crWidth.isEnable("Width") && !crRatingRadio.isEnabled() && crBreakingStrengthRadio.isEnable("Breaking Strength Radio") &&
//                crBreakingStrength.isVisible("Breaking Strength") && crTopCoverThickness.isVisible("Top Cover Thickness") && crBottomCoverThickness.isVisible("Bottom Cover Thickness") &&
//                crLength.isVisible("Belt Length") && crSplice.isEnable("Splice Type ") && crSpliceQuality.isVisible("Splice Quality") && crInstallationDate.isVisible("Installation Date");
        return crBeltConstruction.isVisible("Belt Construction");
    }

    public boolean verifyMaterial() {
        crMaterialTab.click("Material Tab");
//        return crDescription.isVisible("Material Description") && crBulkDensity.isVisible("Bulk Density") && crBulkSize.isVisible("Bulk Size") &&
//                crLumpSize.isVisible("Lump Size") && crContingentOfFines.isVisible("Contingent of Fines") && crChuteDrop.isVisible("Chute Drop") &&
//                crTemperature.isVisible("Material Temperature") && crPresenceOfOil.isEnable("Presence of Oil");
        return crDescription.isVisible("Material Description");
    }

    public boolean verifyConveyor() {
        crConveyorTab.click("Conveyor Tab");
//        return crConveyingLength.isVisible("Conveying Length") && crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power") &&
//                crGearRatio.isVisible("Gear Ratio") && crDriveFrequency.isVisible("Driver Frequency") && crAngle.isVisible("Conveyor Angle") &&
//                crSpeed.isVisible("Conveyor Speed") && crConveyingCapacity.isVisible("Conveying Capacity") && crPercentLoad.isVisible("Percent Load") && crMinimumTemperature.isVisible("Minimum Temperature") &&
//                crMaximumTemperature.isVisible("Maximum Temperature") && crTakeupTravel.isVisible("Take Up Travel") && crEstimatedWeight.isVisible("Estimated Weight") &&
//                crClockwise.isEnable("Right / Clockwise");
        return crConveyingLength.isVisible("Conveying Length");
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
        crPin.jsClick("Pin");
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
        crSave.jsClick("Save File Upload");
        Validator.assertTrue(analysingConveyors.isDisplayed(),"Analysis Bar is not displayed","Analysis Bar is displayed");
        waitForElementToInvisible(analysingConveyors,15000);
        waitForElementToDisplay(fileAnalysedMsg);
    }

    public void conveyorFileImportWithoutWait(String fileName) {
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
        waitForElementToInvisible(spinner,10000);
        waitForElementToDisplay(crImportSuccessful);
        waitForElementToDisplay(btSearchinput);
        btRefresh.click("refresh");
    }

    public void verifyUploadedConveyor(String siteName, String fileName) {
        SyncUtil.waitFor(10000);
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

    public boolean addFilters(String corporates, String beltWidth, String rating, String length){
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        filterDropdown.click();
        SyncUtil.waitFor(1000);
        tbMultipleSiteDropdown.type(corporates);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+corporates+"')]"));
        driver.findElement("//li/div[contains(text(),'"+corporates+"')]").click();
        tbMultipleSiteDropdown.type(beltWidth);
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

    public boolean verifyFilters(){
        return corporatesCol.isEnable() && BeltWidthCol.isEnable() && ratingCol.isEnable() && lengthCol.isEnable();
    }

    public void deleteLayout(String layoutName){
        btTableLayout.click("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        defaultLayout.click("Default Radio");
        driver.findElement(By.xpath("//div[contains(text(),'"+layoutName+"')]/following-sibling::div//span[contains(@class,'ctp-icon-Delete')]")).click();
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

    public boolean verifyAddConveyorPermission(){
        return addConveyors.isVisible();
    }

    public boolean verifySectionsFromBulkImport(){
        return bulkSteps.isVisible("Bulk Steps") && importForm.isVisible("Import Form") && fileDrop.isVisible("File Drop") && crSave.isVisible("Save");
    }

    public boolean verifyImportReport(){
        return skipRadio.isVisible("Skip Radio") && updateRadio.isVisible("Update Radio") && copyRadio.isVisible("Copy Radio");
    }

    public void verifySkipRadioBtn(int count){
        skipRadio.click("Skip Radio");
        crContinue.click("Continue btn");
        waitForElementToDisplay(crImport);
        System.out.println(fileUploadSummary.getText().split("\\r?\\n")[0]);
        System.out.println(fileUploadSummary.getText().split("\\r?\\n")[1]);
        System.out.println(fileUploadSummary.getText().split("\\r?\\n")[2]);
        System.out.println(fileUploadSummary.getText().split("\\r?\\n")[3]);
        System.out.println(fileUploadSummary.getText().split("\\r?\\n")[4]);
        System.out.println(count);
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[0].contains(String.valueOf(count)),"Total Imported conveyors incorrect","All conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[1].contains("0"),"Total Created conveyors incorrect","All Created conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[2].contains("0"),"Total Updated conveyors incorrect","All Updated conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[3].contains("0"),"Total Copied conveyors incorrect","All Copied conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[4].contains(String.valueOf(count)),"Total Skipped conveyors incorrect","All Skipped conveyors imported successfully");
    }

    public void verifyUpdateRadioBtn(int count){
        updateRadio.click("Skip Radio");
        crContinue.click("Continue btn");
        waitForElementToDisplay(crImport);
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[0].contains(String.valueOf(count)),"Total Imported conveyors incorrect","All conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[1].contains("0"),"Total Created conveyors incorrect","All Created conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[2].contains(String.valueOf(count)),"Total Updated conveyors incorrect","All Updated conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[3].contains("0"),"Total Copied conveyors incorrect","All Copied conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[4].contains("0"),"Total Skipped conveyors incorrect","All Skipped conveyors imported successfully");
    }

    public void verifyCopyRadioBtn(int count){
        copyRadio.click("Skip Radio");
        crContinue.click("Continue btn");
        waitForElementToDisplay(crImport);
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[0].contains(String.valueOf(count)),"Total Imported conveyors incorrect","All conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[1].contains("0"),"Total Created conveyors incorrect","All Created conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[2].contains("0"),"Total Updated conveyors incorrect","All Updated conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[3].contains(String.valueOf(count)),"Total Copied conveyors incorrect","All Copied conveyors imported successfully");
        Validator.assertTrue(fileUploadSummary.getText().split("\\r?\\n")[4].contains("0"),"Total Skipped conveyors incorrect","All Skipped conveyors imported successfully");
    }

    public boolean goBackToImportReport(){
        crBack.click("Back Btn");
        return skipRadio.isVisible("Skip Radio");
    }

    public boolean verifyMessages(){
        return crUploadSuccessText.isVisible("Success Message") && crUploadWarningText.isVisible("Warning Message") && crUploadReviewText.isVisible("Review Message");
    }

    public boolean verifyFileAnalyseMessages(){
        return fileAnalysedMsg.isVisible("File Analyse Message");
    }

    public void conveyorUpload(){
        crImport.click("Import");
        waitForElementToDisplay(crImportSuccessful);
        waitForElementToDisplay(btSearchinput);
    }

    public boolean verifyViewPermissionRights(String ConveyorName) {
        goToConveyorListScreenAndWait();
        searchConveyor(ConveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Name");
        crActions.click("Actions");
        return btAddConveyor.isNotVisible(1000) && crEdit.isNotVisible(1000) && crDelete.isNotVisible(1000) && crExportCSV.isNotVisible(1000) && crExportPDF.isNotVisible(1000);
    }

    public boolean verifyViewAndEditRights(String ConveyorName) {
        goToConveyorListScreenAndWait();
        searchConveyor(ConveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Name");
        crActions.click("Actions");
        return btAddConveyor.isNotVisible(1000) && crEdit.isVisible(1000) && crDelete.isNotVisible(1000) && crExportCSV.isNotVisible(1000) && crExportPDF.isNotVisible(1000);
    }

    public boolean verifyViewAndDeleteRights(String ConveyorName) {
        goToConveyorListScreenAndWait();
        searchConveyor(ConveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Name");
        crActions.click("Actions");
        return btAddConveyor.isNotVisible(1000) && crEdit.isNotVisible(1000) && crDelete.isVisible(1000)&& crExportCSV.isNotVisible(1000)&& crExportPDF.isNotVisible(1000);
    }

    public boolean verifyViewAndAddRights(String ConveyorName) {
        goToConveyorListScreenAndWait();
        searchConveyor(ConveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Name");
        crActions.click("Actions");
        return btAddConveyor.isVisible(1000) && crEdit.isNotVisible(1000) && crDelete.isNotVisible(1000)&& crExportCSV.isNotVisible(1000)&& crExportPDF.isNotVisible(1000);
    }

    public boolean verifyViewAndDownloadRights(String ConveyorName) {
        goToConveyorListScreenAndWait();
        searchConveyor(ConveyorName);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("Conveyor Name");
        crActions.click("Actions");
        return btAddConveyor.isNotVisible(1000) && crEdit.isNotVisible(1000) && crDelete.isNotVisible(1000)&& crExportCSV.isVisible(1000)&& crExportPDF.isVisible(1000);
    }

    public boolean editButtonVisiblityOnConveyorDetailsPage() {
        return crEdit.isVisible(1000);
    }

    public boolean verifyConveyorDetailCardsDisplayForBasics(){
        return technicalDataCard.isVisible() && conveyorHistoryCard.isVisible() && coverWearCard.isVisible() && fileManagerCard.isVisible(500) && inspectionCard.isNotVisible(500) && conveyorInspectCard.isNotVisible(500) && beltScanCard.isNotVisible(500) && monitoringDevicesCard.isNotVisible(500) && minutemanCard.isNotVisible(500);
    }

    public boolean navigateToConveyorHistoryFromDetails() {
        conveyorHistoryCard.click();
        return conveyorHistorySort.isVisible("Conveyor History Sort");
    }

    public boolean verifyaddConveyorHistoryViewRights() {
        btAddConveyorHistory.click();
        return conveyorHistoryBeltFailure.isNotVisible(500) && conveyorHistoryCustomEvent.isNotVisible(500) && conveyorHistoryComponentChange.isNotVisible(500);
    }

    public void verifyConveyorHorizontalNavBar(){
        waitForElementVisible(crDetailsTab,5000,1000);
        Validator.assertTrue(crDetailsTab.getText().contains("Details"),"Details Bar is not visible","Details Bar is visible");
        Validator.assertTrue(crConveyorLiteTab.getText().contains("Conveyor-Lite"),"Conveyor-Lite Bar is not visible","Conveyor-Lite Bar is visible");
        Validator.assertTrue(crInstalledBeltTab.getText().contains("Installed Belt"),"Installed Belt Bar is not visible","Installed Belt Bar is visible");
        Validator.assertTrue(crMaterialTab.getText().contains("Material"),"Material Bar is not visible","Material Bar is visible");
        Validator.assertTrue(crConveyorTab.getText().contains("Conveyor"),"Conveyor Bar is not visible","Conveyor Bar is visible");
        Validator.assertTrue(crWearLifeTab.getText().contains("Wear Life"),"Wear Life Bar is not visible","Wear Life Bar is visible");
        Validator.assertTrue(crIdlersTab.getText().contains("Idlers"),"Idlers Bar is not visible","Idlers Bar is visible");
        Validator.assertTrue(crPulleysTab.getText().contains("Pulleys"),"Pulleys Bar is not visible","Pulleys Bar is visible");
        Validator.assertTrue(crTransitionTab.getText().contains("Transitions"),"Transitions Bar is not visible","Transitions Bar is visible");
        Validator.assertTrue(crRemarksTab.getText().contains("Remarks"),"Remarks Bar is not visible","Remarks Bar is visible");
    }

    public boolean verifyDetailsPage() {
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/details"),"URL missMatch","URL validation passed");
        return tbConveyorname.isVisible("Material Description") && drDistShopdropdown.isVisible("Bulk Density") && drSitedropdown.isVisible("Bulk Size");
    }

    public boolean verifyConveyorLitePage() {
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForElementVisible(crBeltWidth,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/conveyor-lite"),"URL missMatch","URL validation passed");
        return crBeltWidth.isVisible("Belt Width") && crBeltSpeed.isVisible("Belt Speed");
    }

    public boolean verifyInstalledBeltPage() {
        crInstalledBeltTab.click("Installed Belt Tab");
        waitForElementVisible(crBeltConstruction,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/installed-belt"),"URL missMatch","URL validation passed");
        return crBeltConstruction.isVisible("Belt Construction") && crTopCompound.isVisible("Top Cover Compound");
    }

    public boolean verifyMaterialPage() {
        crMaterialTab.click("Material Tab");
        waitForElementVisible(crDescription,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/material"),"URL missMatch","URL validation passed");
        return crDescription.isVisible("Material Description") && crBulkDensity.isVisible("Bulk Density");
    }

    public boolean verifyConveyorPage() {
        crConveyorTab.click("Conveyor Tab");
        waitForElementVisible(crLift,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/conveyor"),"URL missMatch","URL validation passed");
        return crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power");
    }
    public boolean verifyWearLifePage() {
        crWearLifeTab.click("Wear Life Tab");
        waitForElementVisible(crTonsPerYear,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/wear-life"),"URL missMatch","URL validation passed");
        return crTonsPerYear.isVisible("Tons Per year") && crFeedAngle.isVisible("Feed Angle") && crChuteAngle.isVisible("Chute Angle") && crBeltInclineAngle.isVisible("Belt Incline angle in Load Zone");
    }

    public boolean verifyIdlersPage() {
        crIdlersTab.click("Idlers Tab");
        waitForElementVisible(crCarryIdlerDiameter,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/idlers"),"URL missMatch","URL validation passed");
        return crCarryIdlerDiameter.isVisible("Carry Idler Diameter") && crCarryAngle.isVisible("Carry Angle");
    }

    public boolean verifyPulleysPage() {
        crPulleysTab.click("Pulleys Tab");
        waitForElementVisible(crHeadPulleyDiameter,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/pulleys"),"URL missMatch","URL validation passed");
        return crHeadPulleyDiameter.isVisible("Head Pulley Diameter") &&  crHeadPulleyWidth.isVisible("Head Pulley Width");
    }
    public boolean verifyTransitionPage() {
        crTransitionTab.click("Transition Zone Tab");
        waitForElementVisible(crHeadTransitionLength,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/transitions"),"URL missMatch","URL validation passed");
        return crHeadTransitionLength.isVisible("Flat-to-trough Transition Length") && crHeadPulleyLift.isVisible("Pulley Lift");
    }
    public boolean verifyRemarksPage() {
        crRemarksTab.click("Remarks Tab");
        waitForElementVisible(crAdditionalRemarks,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/remarks"),"URL missMatch","URL validation passed");
        return crAdditionalRemarks.isVisible("Additional Remarks");
    }


    public void verifyConveyorNavigationOnClick() {
        Validator.assertTrue(verifyDetailsPage(),"Detail Page is not displayed","Detail Page is displayed");
        Validator.assertTrue(verifyConveyorLitePage(),"Conveyor Lite Page is not displayed","Conveyor Lite Page is displayed");
        Validator.assertTrue(verifyInstalledBeltPage(),"Installed Belt Page is not displayed","Installed Belt Page is displayed");
        Validator.assertTrue(verifyMaterialPage(),"Material Page is not displayed","Material Page is displayed");
        Validator.assertTrue(verifyConveyorPage(),"Conveyor Page is not displayed","Conveyor Page is displayed");
        Validator.assertTrue(verifyWearLifePage(),"Wear Life Page is not displayed","Wear Life Page is displayed");
        Validator.assertTrue(verifyIdlersPage(),"Idlers Page is not displayed","Idlers Page is displayed");
        Validator.assertTrue(verifyPulleysPage(),"Pulleys Page is not displayed","Pulleys Page is displayed");
        Validator.assertTrue(verifyTransitionPage(),"Transition Page is not displayed","Transition Page is displayed");
        Validator.assertTrue(verifyRemarksPage(),"Remarks Page is not displayed","Remarks Page is displayed");
    }

    public void cancelBtnClick()
    {
        btnCancel.click();
    }

    public void verifyImageViewPanelClosed()
    {
        waitForElementVisible(addDefaultImgSrc,5000,500);
        Validator.assertTrue(addDefaultImgSrc.isVisible(),"The selected image is uploaded","The selected image is not uploaded");
        Validator.assertTrue(imageViewerPanel.verifyNotPresent(),"Image view panel is still visible","Image viewer panel is not visible");
        Validator.assertTrue(addDefaultImgSrc.getAttribute("src").contains("/assets/img/upload_default.png"), "Image was uploaded", "Image was not uploaded");

    }

    public void createConveyorWithMan(String conveyorName, String distShopName, String custSiteName) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
    }

    public void clickRemarkAndSave()
    {
        crRemarksTab.click("Remarxks Tab");
        waitForElementVisible(crAdditionalRemarks,5000,1000);
        crSave.click("Save Click");
        waitForElementToInvisible(buttonLoader,40000);
        waitForElementVisible(btUpdate,5000,1000);
        Validator.assertTrue(btUpdate.isDisplayed(),"Save button is displayed","Save is displayed");
    }

    public void verifyDataHeaderUnitInAddConveyor(String unit)
    {
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForPageLoad(5000);
        waitForElementVisible(unitIconConveyor,5000,1000);
        Validator.assertTrue(unitIconConveyor.getText("Unit Value").contains(unit),"unit is not selected","unit is selected");

    }

    public void extractConveyorCount()
    {
        int conveyorCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        getBundle().setProperty("conveyorListCount", conveyorCount);
    }
    public void verifyConveyorCount()
    {
        int paginationValue = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        Integer extractedValue = Integer.parseInt(getBundle().getProperty("conveyorListCount").toString());
        Integer expectedValue= extractedValue - 1;
        Validator.assertTrue(expectedValue.equals(paginationValue),"Expected value is not returned","Expected value is returned");
    }

    public void verifySiteAndConveyorPreFilled()
    {
       Validator.assertTrue(tbCorporateName.isDisplayed(),"Corporate Name is not prefilled","Corporate Name is prefilled");
       Validator.assertTrue(tbSite.isDisplayed(),"Site is not prefilled","Site is prefilled");
    }

    public void editBeltWidth(String beltWidth)
    {
        waitForElementToBeClickable(editConveyor);
        editConveyor.click();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crInstalledBeltTab.click("Installed Belt Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltConstruction.isVisible(),"Installed Belt page is not loaded","Installed Belt page is loaded");
        waitForElementToBeClickable(crWidth);
        crWidth.clear();
        crWidth.type(beltWidth);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
       SyncUtil.waitFor(3000);
       scrollPageup();

    }
    public void verifyDataUnitInAddConveyorForBeltWidth(String unit)
    {
        waitForElementVisible(crWidthUnit,10000,1000);
        Validator.assertTrue(crWidthUnit.getText("Unit Value").contains(unit),"unit is not selected Correctly","unit is selected Correctly");
    }

    public void clickOnLayoutPicker()
    {
        waitForElementVisible(btTableLayout,10000,500);
        btTableLayout.click("Add Table Layout");

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
    public void clickBackBtn()
    {
        waitForElementVisible(btnBack,10000,500);
        btnBack.click();
        waitForElementVisible(tableLayoutHeader,10000,1000);
        Validator.assertTrue(tableLayoutHeader.isVisible(),"Table Layout Settings is not visible","Table Layout Settings is visble");
    }
    public void clickOnLayoutAndVerifySafeSetPreference()
    {
        waitForElementVisible(rdBtnCommonLayout,10000,500);
        rdBtnCommonLayout.click();
        waitForElementVisible(btnSaveSetPreference,10000,1000);
        waitForElementToBeClickable(btnSaveSetPreference);
        Validator.assertTrue(btnSaveSetPreference.isEnable(),"Save Set Preference is not clickable","Save Set Preference is clickable");
    }
    public void clickOnCloseLayoutSetting()
    {
        waitForElementVisible(closeLayout,10000,500);
        closeLayout.click();
        SyncUtil.waitFor(2000);
        Validator.assertTrue(!(tableLayoutHeader.isPresent()),"Dailog Table Layout Settings is not closed","Dailog Table Layout Settings is closed");
    }

//    public void editConveyorPageWithFieldAndValue(String page,String field,String input,String value,String index)
//    {
//        waitForElementToBeClickable(editConveyor);
//        editConveyor.click();
//        waitForPageLoad(10000);
//        waitForElementToDisplay(tbConveyorname);
//        driver.findElement("//span[text()='"+page+"']").click();
//        waitForPageLoad(5000);
//        waitForElementVisible(driver.findElement("(//label[text()='"+field+"']/..//input)[2]"),5000,1000);
//        Validator.assertTrue(driver.findElement("(//label[text()='"+field+"']/..//input)[2]").isDisplayed(),"Page is not loaded","Page is loaded");
//        waitForElementToBeClickable(driver.findElement("(//label[text()='"+input+"']/..//input)["+index+"]"));
//        driver.findElement("(//label[text()='"+input+"']/..//input)["+index+"]").clear();
//        driver.findElement("(//label[text()='"+input+"']/..//input)["+index+"]").sendKeys(value);
//        waitForElementToBeClickable(crUpdate);
//        crUpdate.click();
//        waitForElementToDisplay(crUpdateMsg);
//        SyncUtil.waitFor(3000);
//        scrollPageup();
//    }

    public void addColumnFilters(String filterName){
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        filterDropdown.click();
        SyncUtil.waitFor(1000);
        tbMultipleSiteDropdown.type(filterName);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+filterName+"')]"));
        driver.findElement("//li/div[contains(text(),'"+filterName+"')]").click();
        waitForElementToBeClickable(tbMultipleSiteDropdownCancel);
        tbMultipleSiteDropdownCancel.click();
    }

    public void verifyHeaderDataFieldUnit(String field,String unit)
    {
        waitForElementVisible(driver.findElement("//th[@id='"+field+"']//div"),10000,1000);
        Validator.assertTrue(driver.findElement("//th[@id='"+field+"']//div").getText().contains(unit),"unit is not selected Correctly","unit is selected Correctly");
    }

    public void editConveyorTopCoverThickness(String topCoverThickness)
    {
        waitForElementToBeClickable(editConveyor);
        editConveyor.jsClick();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crInstalledBeltTab.click("Installed Belt Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltConstruction.isVisible(),"Installed Belt page is not loaded","Installed Belt page is loaded");
        waitForElementToBeClickable(crTopCoverThickness);
        crTopCoverThickness.clear();
        crTopCoverThickness.type(topCoverThickness);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
        SyncUtil.waitFor(3000);
        scrollPageup();
    }

    public void editConveyorBottomCoverThickness(String bottomCoverThickness)
    {
        waitForElementToBeClickable(editConveyor);
        editConveyor.jsClick();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crInstalledBeltTab.click("Installed Belt Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltConstruction.isVisible(),"Installed Belt page is not loaded","Installed Belt page is loaded");
        waitForElementToBeClickable(crBottomCoverThickness);
        crBottomCoverThickness.clear();
        crBottomCoverThickness.type(bottomCoverThickness);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
        SyncUtil.waitFor(3000);
        scrollPageup();
    }

    public void editConveyorSpeed(String speed)
    {
        waitForElementToBeClickable(editConveyor);
        editConveyor.jsClick();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltWidth.isVisible(),"Conveyor Lite page is not loaded","Conveyor Lite page is loaded");
        waitForElementToBeClickable(crBeltSpeed);
        crBeltSpeed.clear();
        crBeltSpeed.type(speed);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
        SyncUtil.waitFor(3000);
        scrollPageup();
    }

    public void verifyCoveyorListPageHeader()
    {
        waitForElementVisible(conveyorHeader,5000,1000);
        Validator.assertTrue(conveyorHeader.getText().equalsIgnoreCase("Conveyors"),"Conveyors is not visible","Conveyors is visible");
    }

    public void verifyConveyorCoulmnName(){
       waitForElementVisible(hdName,5000,1000);
       Validator.assertTrue(hdName.getText().contains("Name"),"Name is not visible","Name is visible");
       Validator.assertTrue(hdSite.getText().contains("Site"),"Site is not visible","Site is visible");
       Validator.assertTrue(hdImage.getText().contains(""),"Image is not visible","Image is visible");
       Validator.assertTrue(hdLastMod.getText().contains("Last Modified"),"Last Modified is not visible","Last Modified is visible");
       Validator.assertTrue(hdInstallBelt.getText().contains("Installed Belt"),"Installed Belt is not visible","Installed Belt is visible");
       Validator.assertTrue(hdRemainingLife.getText().contains("Remaining Life by Time"),"Remaining Life by Time is not visible","Remaining Life by Time is visible");
       Validator.assertTrue(hdRemainingCover.getText().contains("Remaining Cover %"),"Remaining Cover % is not visible","Remaining Cover % is visible");
       Validator.assertTrue(hdInspectionItem.getText().contains("Inspection Items"),"Inspection Items is not visible","Inspection Items is visible");
       Validator.assertTrue(hdMore.getText().contains("More"),"More is not visible","More is visible");
    }

    public void verifyConveyorCoulmnData(String name,String site,String lastModified,String installBelt,String remainingTime,String remainingPer){
       waitForElementVisible(btSearchinput,10000,1000);
       btSearchinput.type(name, "Conveyor Search");
       waitForElementToDisplay(crCheckbox);
       waitForElementToDisplay(hdNameValue);
       Validator.assertTrue(hdNameValue.getText().contains(name),"Name is not visible","Name is visible");
       Validator.assertTrue(hdSiteValue.getText().contains(site),"Site is not visible","Site is visible");
       Validator.assertTrue(hdLastModValue.getText().contains(lastModified),"Last Modified is not visible","Last Modified is visible");
//       Validator.assertTrue(hdInstallBeltValue.getText().contains(installBelt),"Installed Belt is not visible","Installed Belt is visible");
       Validator.assertTrue(hdRemainingLifeValue.getText().contains(remainingTime),"Remaining Life by Time is not visible","Remaining Life by Time is visible");
       Validator.assertTrue(hdRemainingCoverValue.getText().contains(remainingPer),"Remaining Cover % is not visible","Remaining Cover % is visible");
    }

    public void verifyPaginationBackwardArrowButton(){
        waitForElementVisible(btPgPrev,5000,1000);
        waitForElementToBeClickable(btPgPrev);
        btPgPrev.jsClick();
        Validator.assertTrue(btPgHighlightedValue.getText().contains("1"),"Pagination is not present at 2","Pagination is present at 2");
    }
    public void verifyPaginationFormat(){
        waitForElementVisible(pagination,5000,1000);
        Validator.assertTrue(pagination.getText().matches("Showing \\d+ to \\d+ of \\d+ entries"),"Pagination is not in format","Pagination is in format");
    }

    public void verifyImportReportPageData(){
        Validator.assertTrue(rdBtnSkip.isDisplayed(),"Skip button is not displayed","Skip button is not displayed");
        Validator.assertTrue(rdBtnUpdate.isDisplayed(),"Update button is not displayed","Update button is not displayed");
        Validator.assertTrue(rdBtnCopy.isDisplayed(),"Copy button is not displayed","Copy button is displayed");
        Validator.assertTrue(btBack.isDisplayed(),"Back button is not displayed","Back button is displayed");
        Validator.assertTrue(btnContinue.isDisplayed(),"Continue button is not displayed","Continue button is displayed");
        Validator.assertTrue(txtErrors.isDisplayed(),"Errors is not selected","Errors is selected");
    }

    public void selectSiteForUpload(String site1,String site2){
        crMultipleSitesRadio.click("Multiple Site Radio");
        dropdownSelectSearch(crSiteDropdown, tbMultipleSiteDropdown, site1);
        crSiteDropdown.click();
        tbMultipleSiteDropdown.clear();
        SyncUtil.waitFor(1000);
        dropdownSelectSearch(crSiteDropdown, tbMultipleSiteDropdown, site2);
        SyncUtil.waitFor(5000);
        waitForElementVisible(crTemplateDownload,5000,1000);
        waitForElementToBeClickable(crTemplateDownload);
        crTemplateDownload.jsClick("Download Template");
        SyncUtil.waitFor(5000);
    }
    public void verifySheetNames(String fileName,String site1,String site2){
        List<String> sheetNames = MiscUtils.getDownloadedExcelSheet(fileName);
        Validator.assertTrue(sheetNames.toString().contains(site1),"SheetName is not present","SheetName is present");
        Validator.assertTrue(sheetNames.toString().contains(site2),"SheetName is not present","SheetName is present");
    }
    public void verifyConveyorSheetData(String fileName,String site){
        Object[][] sheetData  = MiscUtils.getDownloadedExcelData(fileName,site);
        String data =  Arrays.deepToString(sheetData);
        Validator.assertTrue(data.contains("Name"),"Name is not present","Name is present");
        Validator.assertTrue(data.contains("Belt Width"),"Belt Width is not present","Belt Width is present");
        Validator.assertTrue(data.contains("Belt Speed"),"Belt Speed is not present","Belt Speed is present");
        Validator.assertTrue(data.contains("Tons per Hour Peak"),"Tons per Hour Peakis not present","Tons per Hour Peak is present");
        Validator.assertTrue(data.contains("Pick Material name"),"Pick Material name is not present","Pick Material name is present");
        Validator.assertTrue(data.contains("Material Density"),"Material Density is not present","Material Density is present");
        Validator.assertTrue(data.contains("Angle of Idlers"),"Angle of Idlers is not present","Angle of Idlers is present");
        Validator.assertTrue(data.contains("Carry Side Idler Spacing"),"Carry Side Idler Spacing is not present","Carry Side Idler Spacing is present");
        Validator.assertTrue(data.contains("Drive wrap angle"),"Drive wrap angle is not present","Drive wrap angle is present");
        Validator.assertTrue(data.contains("TakeUp Tension"),"TakeUp Tension is not present","TakeUp Tension is present");
        Validator.assertTrue(data.contains("Friction factor"),"Friction factor is not present","Friction factor is present");
        Validator.assertTrue(data.contains("Surcharge Angle"),"Surcharge Angle is not present","Surcharge Angle is present");
        Validator.assertTrue(data.contains("Idler Offset Type"),"Idler Offset Type is not present","Idler Offset Type is present");
        Validator.assertTrue(data.contains("Drive Details"),"Drive Details is not present","Drive Details is present");
        Validator.assertTrue(data.contains("Take-up Details"),"Take-up Details is not present","Take-up Details is present");
        Validator.assertTrue(data.contains("Stations"),"Stations is not present","Stations is present");
        Validator.assertTrue(data.contains("Belt Manufacturer"),"Belt Manufacturer is not present","Belt Manufacturer is present");
        Validator.assertTrue(data.contains("Belt Construction"),"Belt Construction is not present","Belt Construction is present");
        Validator.assertTrue(data.contains("Top Cover Compound"),"Top Cover Compound is not present","Top Cover Compound is present");
        Validator.assertTrue(data.contains("Bottom Cover Compound"),"Bottom Cover Compound is not present","Bottom Cover Compound is present");
        Validator.assertTrue(data.contains("Carcass"),"Carcass is not present","Carcass is present");
        Validator.assertTrue(data.contains("Number of Plies"),"Number of Plies is not present","Number of Plies is present");
        Validator.assertTrue(data.contains("Number of Cords"),"Number of Cords is not present","Number of Cords is present");
        Validator.assertTrue(data.contains("Cord Pitch"),"Cord Pitch is not present","Cord Pitch is present");
        Validator.assertTrue(data.contains("Cord Diameter"),"Cord Diameter is not present","Cord Diameter is present");
        Validator.assertTrue(data.contains("Rating/Breaking Strength"),"Rating/Breaking Strength is not present","Rating/Breaking Strength is present");
        Validator.assertTrue(data.contains("Rating"),"Rating is not present","Rating is present");
        Validator.assertTrue(data.contains("Breaking Strength"),"Breaking Strength is not present","Breaking Strength is present");
        Validator.assertTrue(data.contains("Top Cover Thickness"),"Top Cover Thickness is not present","Top Cover Thickness is present");
        Validator.assertTrue(data.contains("Bottom CoverThickness"),"Bottom CoverThickness is not present","Bottom CoverThickness is present");
        Validator.assertTrue(data.contains("Length"),"Length is not present","Length is present");
        Validator.assertTrue(data.contains("Splice / Type"),"Splice / Type is not present","Splice / Type is present");
        Validator.assertTrue(data.contains("Splices Quantity"),"Splices Quantity is not present","Splices Quantity is present");
        Validator.assertTrue(data.contains("Installation Date"),"Installation Date is not present","Installation Date is present");

    }

}
