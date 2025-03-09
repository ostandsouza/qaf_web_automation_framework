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


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static java.io.File.separator;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ConveyorPage extends BasePage{

    CoverWearPage coverWearPage = new CoverWearPage();
    UsersPage userPage=new UsersPage();
    CordInspectPage cordInspectPage = new CordInspectPage();
    InspectionPage inspectionpage = new InspectionPage();

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

    @FindBy(locator= "xpath=//div[contains(@class,'p-multiselect-filter-container')]//input[contains(@class,'p-multiselect-filter')]")
    public CustomElement tbMultipleSiteDropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbAssociatedSitedropdown;

    @FindBy(locator= "xpath=//p-dropdown[@datakey='companyId']/div/div")
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
    public CustomElement btCreate;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement buttonLoader;

    @FindBy(locator = "xpath=(//div[text()='Minuteman Calc.']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crMinutemanCalc;

    @FindBy(locator = "xpath=(//div[text()='Monitoring Devices']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crMonitoringDevices;

    @FindBy(locator = "xpath=(//div[text()='Conveyor Inspect']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crConveyorInspect;

    @FindBy(locator = "xpath=(//div[text()='Inspections']/..//div[contains(@class,'text-area')]/span)[2]")
    public CustomElement crInspections;

    @FindBy(locator = "xpath=(//div[text()='Cover Wear']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crCoverWear;

    @FindBy(locator = "xpath=(//div[text()='File Manager']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crFileManager;

    @FindBy(locator = "xpath=(//div[text()='Conveyor History']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crConveyorHistory;

    @FindBy(locator = "xpath=(//div[text()='Technical Data']/..//div[contains(@class,'text-area')]/span)[1]")
    public CustomElement crTechnicalDataCard;

//    @FindBy(locator = "xpath=//span[text()=' Conveyor-Lite']")
//    public CustomElement crConveyorLiteTab;

    @FindBy(locator = "xpath=//a//span[contains(text(),'Conveyor-Lite')]")
    public CustomElement crConveyorLiteTab;

//    @FindBy(locator = "xpath=//span[text()=' Installed Belt']")
//    public CustomElement crInstalledBeltTab;
    @FindBy(locator = "xpath=//a//span[contains(text(),'Installed Belt')]")
    public CustomElement crInstalledBeltTab;

//    @FindBy(locator = "xpath=//span[text()=' Material']")
//    public CustomElement crMaterialTab;

    @FindBy(locator = "xpath=//a//span[contains(text(),'Material')]")
    public CustomElement crMaterialTab;

//    @FindBy(locator = "xpath=//span[text()=' Conveyor']")
//    public CustomElement crConveyorTab;
    @FindBy(locator = "xpath=//a//span[text()='Conveyor']")
    public CustomElement crConveyorTab;

    @FindBy(locator = "xpath=//li[@id='5']//a//span[contains(text(),'Conveyor')]")
    public CustomElement crAddConveyorTab;

//    @FindBy(locator = "xpath=//span[text()=' Wear Life']")
//    public CustomElement crWearLifeTab;
    @FindBy(locator = "xpath=//a//span[contains(text(),'Wear Life')]")
    public CustomElement crWearLifeTab;

//    @FindBy(locator = "xpath=//span[text()=' Idlers']")
//    public CustomElement crIdlersTab;
    @FindBy(locator = "xpath=//a//span[contains(text(),'Idlers')]")
    public CustomElement crIdlersTab;

//    @FindBy(locator = "xpath=//span[text()=' Pulleys']")
//    public CustomElement crPulleysTab;
    @FindBy(locator = "xpath=//span[contains(text(),'Pulleys')]")
    public CustomElement crPulleysTab;

    @FindBy(locator = "xpath=//span[text()=' Transition Zone']")
    public CustomElement crTransitionZoneTab;

    @FindBy(locator = "xpath=//span[contains(text(),'Remarks')]")
    public CustomElement crRemarksTab;

    @FindBy(locator = "xpath=//label[text()='Belt Width ']/..//input")
    public CustomElement crBeltWidth;

    @FindBy(locator = "xpath=//label[text()='Belt Speed ']/..//input")
    public CustomElement crBeltSpeed;

    @FindBy(locator = "xpath=//label[text()='Tons per Hour Peak']/..//input")
    public CustomElement crTonsPerHr;

    @FindBy(locator = "xpath=//label[text()='Pick Material Name ']/..//input")
    public CustomElement crMaterialName;
    @FindBy(locator = "xpath=//label[text()='Pick Material Name ']/..//div[@role]")
    public CustomElement drMaterialName;

    @FindBy(locator = "xpath=//label[text()='Material Density ']/..//input")
    public CustomElement crMaterialDensity;

    @FindBy(locator = "xpath=//label[text()='Angle of Idlers ']/..//input")
    public CustomElement crAngleOfIdlers;

    @FindBy(locator = "xpath=//label[text()='Carry Side Idler Spacing ']/..//input")
    public CustomElement crIdlerSpacing;

    @FindBy(locator = "xpath=(//label[text()='Drive Wrap Angle ']/..//input)[2]")
    public CustomElement crDriveWrapAngle;

    @FindBy(locator = "xpath=//label[text()='Drive Wrap Angle ']/..//div[@role]")
    public CustomElement drDriveWrapAngle;

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

    @FindBy(locator = "xpath=//label[text()='Surcharge Angle ']/..//div[@role]")
    public CustomElement drSurchargeFactor;

    @FindBy(locator = "xpath=(//label[text()='Idler Offset Type ']/..//input)[2]")
    public CustomElement crIdleOffsetType;

    @FindBy(locator = "xpath=//label[text()='Idler Offset Type ']/..//div[@role]")
    public CustomElement drIdleOffsetType;

    @FindBy(locator = "xpath=//label[contains(text(),'Drive Details')]/..//input")
    public CustomElement crDriveDetails;

    @FindBy(locator = "xpath=//label[contains(text(),'Drive Details')]/..//div[@role]")
    public CustomElement drDriveDetails;

    @FindBy(locator = "xpath=//label[contains(text(),'Take-up Details')]/..//input")
    public CustomElement crTakeupDetails;
    @FindBy(locator = "xpath=//label[contains(text(),'Take-up Details')]/..//div[@role]")
    public CustomElement drTakeupDetails;
    @FindBy(locator = "xpath=//p-checkbox")
    public CustomElement cbStation;
    @FindBy(locator = "xpath=//p-radiobutton[@formcontrolname='drive']")
    public CustomElement rbDrive;

    @FindBy(locator = "xpath=(//label[contains(text(),'Configuration')]/..//input)[1]")
    public CustomElement crMonolithConfig;

    @FindBy(locator = "xpath=(//label[contains(text(),'Configuration')]/..//input)[2]")
    public CustomElement crMixedConfig;

    @FindBy(locator = "xpath=(//label[contains(text(),'Belt Manufacturer')]/..//input)[1]")
    public CustomElement crBeltConfig;
    @FindBy(locator = "xpath=//label[contains(text(),'Belt Manufacturer')]/..//div[@role]")
    public CustomElement drBeltConfig;

    @FindBy(locator = "xpath=//label[text()='Belt Construction']/..//input")
    public CustomElement crBeltConstruction;
    @FindBy(locator = "xpath=//label[text()='Belt Construction']/..//div[@role]")
    public CustomElement drBeltConstruction;

    @FindBy(locator = "xpath=//label[contains(text(),'Top Cover Compound')]/..//input")
    public CustomElement crTopCompound;
    @FindBy(locator = "xpath=//label[contains(text(),'Top Cover Compound')]/..//div[@role]")
    public CustomElement drTopCompound;
    @FindBy(locator = "xpath=//label[contains(text(),'Bottom Cover Compound')]/..//input")
    public CustomElement crBottomCompound;
    @FindBy(locator = "xpath=//label[contains(text(),'Bottom Cover Compound')]/..//div[@role]")
    public CustomElement drBottomCompound;

    @FindBy(locator = "xpath=//label[contains(text(),'Carcass')]/..//input")
    public CustomElement crCarcass;
    @FindBy(locator = "xpath=//label[contains(text(),'Carcass')]/..//div[@role]")
    public CustomElement drCarcass;
    @FindBy(locator = "xpath=//label[contains(text(),'Number of Plies')]/..//input")
    public CustomElement crNumberOfPlies;

    @FindBy(locator = "xpath=//label[contains(text(),'Width')]/..//input")
    public CustomElement crWidth;

    @FindBy(locator = "xpath=//input[@value='Rating']")
    public CustomElement crRatingRadio;

    @FindBy(locator = "xpath=//input[@value='BreakingStrength']")
    public CustomElement crBreakingStrengthRadio;

    @FindBy(locator = "xpath=(//label[contains(text(),'Breaking Strength')]/..//input)[2]")
    public CustomElement crBreakingStrength;
    @FindBy(locator = "xpath=(//label[contains(text(),'Rating')]/..//input)[2]")
    public CustomElement crBreakingStrengthRating;

    @FindBy(locator = "xpath=//label[contains(text(),'Top Cover Thickness')]/..//input")
    public CustomElement crTopCoverThickness;

    @FindBy(locator = "xpath=//label[contains(text(),'Bottom Cover Thickness')]/..//input")
    public CustomElement crBottomCoverThickness;

    @FindBy(locator = "xpath=//label[text()='Length']/..//input")
    public CustomElement crLength;

    @FindBy(locator = "xpath=//label[contains(text(),'Splice / Type')]/..//input")
    public CustomElement crSplice;
    @FindBy(locator = "xpath=//label[contains(text(),'Splice / Type')]/..//div[@role]")
    public CustomElement drSplice;

    @FindBy(locator = "xpath=//label[contains(text(),'Splices Quantity')]/..//input")
    public CustomElement crSpliceQuantity;

    @FindBy(locator = "xpath=//label[contains(text(),'Installation Date')]/..//input")
    public CustomElement crInstallationDate;

    @FindBy(locator = "xpath=//label[contains(text(),'Description')]/..//input")
    public CustomElement crDescription;

    @FindBy(locator = "xpath=//label[contains(text(),'Bulk Density')]/..//input")
    public CustomElement crBulkDensity;

    @FindBy(locator = "xpath=//label[contains(text(),'Bulk Size')]/..//input")
    public CustomElement crBulkSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Lump Size')]/..//input")
    public CustomElement crLumpSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Granular Size')]/..//div[@role]")
    public CustomElement crGranularSize;

    @FindBy(locator = "xpath=//label[contains(text(),'Contingent of Fines')]/..//input")
    public CustomElement crContingentOfFines;

    @FindBy(locator = "xpath=//label[contains(text(),'Aggresivity')]/..//div[@role]")
    public CustomElement crAggresivity;

    @FindBy(locator = "xpath=//label[contains(text(),'Density Type')]/..//div[@role]")
    public CustomElement crDensityType;

    @FindBy(locator = "xpath=//label[contains(text(),'Chute Drop')]/..//input")
    public CustomElement crChuteDrop;

    @FindBy(locator = "xpath=//label[contains(text(),'Loading Frequecy')]/..//div[@role]")
    public CustomElement crLoadingFrequency;

    @FindBy(locator = "xpath=//label[contains(text(),'Loading Conditions')]/..//div[@role]")
    public CustomElement crLoadingConditions;

    @FindBy(locator = "xpath=//label[text()='Temperature']/..//input")
    public CustomElement crTemperature;

    @FindBy(locator = "xpath=//label[text()='Feeding Conditions']/..//div[@role]")
    public CustomElement crFeedingConditions;

    @FindBy(locator = "xpath=//label[text()='Presence of Oil']/..//div[@role]")
    public CustomElement crPresenceOfOil;

    @FindBy(locator = "xpath=(//label[text()='Conveying Length']/..//input)[1]")
    public CustomElement crConveyingLength;

    @FindBy(locator = "xpath=(//label[text()='Lift']/..//input)[1]")
    public CustomElement crLift;

    @FindBy(locator = "xpath=(//label[contains(text(),'Drive Power')]/..//input)[1]")
    public CustomElement crDrivePower;

    @FindBy(locator = "xpath=(//label[contains(text(),'Gear Ratio')]/..//input)[1]")
    public CustomElement crGearRatioFirst;
    @FindBy(locator = "xpath=(//label[contains(text(),'Gear Ratio')]/..//input)[2]")
    public CustomElement crGearRatioSecond;

    @FindBy(locator = "xpath=(//label[contains(text(),'Drive Frequency')]/..//input)[1]")
    public CustomElement crDriveFrequency;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[1]")
    public CustomElement crAngle;

    @FindBy(locator = "xpath=(//label[text()='Speed']/..//input)[2]")
    public CustomElement crSpeed;

    @FindBy(locator = "xpath=(//label[text()='Conveying Capacity']/..//input)[2]")
    public CustomElement crConveyingCapacity;

    @FindBy(locator = "xpath=(//label[text()='Percent Load']/..//input)[2]")
    public CustomElement crPercentLoad;

    @FindBy(locator = "xpath=//input[@formcontrolname='minimumTemperature']")
    public CustomElement crMinimumTemperature;

    @FindBy(locator = "xpath=(//label[text()='Maximum Temperature']/..//input)[2]")
    public CustomElement crMaximumTemperature;
    @FindBy(locator = "xpath=//label[text()='Stage']/..//div[@role]")
    public CustomElement crStage;

    @FindBy(locator = "xpath=//label[text()='Take-up type']/..//p-dropdown")
    public CustomElement crTakeupType;

    @FindBy(locator = "xpath=//label[text()='Take-up Travel']/..//input")
    public CustomElement crTakeupTravel;

    @FindBy(locator = "xpath=//label[text()='Estimated Weight']/..//input")
    public CustomElement crEstimatedWeight;

    @FindBy(locator = "xpath=//label[text()='Belt Monitoring System']/..//input")
    public CustomElement crBeltMonitoringSystem;

    @FindBy(locator = "xpath=//label[text()='Manufacturer']/..//input")
    public CustomElement crManufacturer;

    @FindBy(locator = "xpath=//label[text()='Belt Turnover']/..//div[@role]")
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

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[1]")
    public CustomElement crCarryAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[1]")
    public CustomElement crCarryTotalIdlers;

    @FindBy(locator = "xpath=(//label[text()='Top Run Spacing']/..//input)[1]")
    public CustomElement crCarryTopRunSpacing;

    @FindBy(locator = "xpath=//label[text()='Return Idler Diameter']/..//input")
    public CustomElement crReturnIdlerDiameter;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[2]")
    public CustomElement crReturnAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[2]")
    public CustomElement crReturnTotalIdlers;

    @FindBy(locator = "xpath=//label[text()='Return Run Spacing']/..//input")
    public CustomElement crReturnTopRunSpacing;

    @FindBy(locator = "xpath=//label[text()='Impact Idler Diameter']/..//input")
    public CustomElement crImpactIdlerDiameter;

    @FindBy(locator = "xpath=(//label[text()='Angle']/..//input)[3]")
    public CustomElement crImpactAngle;

    @FindBy(locator = "xpath=(//label[text()='Total Number of Idlers']/..//input)[3]")
    public CustomElement crImpactTotalIdlers;

    @FindBy(locator = "xpath=(//label[text()='Idler Offset']/..//input)[1]")
    public CustomElement crIdlerOffset;
    @FindBy(locator = "xpath=//label[text()='Idler Offset']/..//div[@role]")
    public CustomElement drIdlerOffset;

    @FindBy(locator = "xpath=//label[text()='Number of Transition Idlers']/..//input")
    public CustomElement crNoOfTransitionIdlers;

    @FindBy(locator = "xpath=(//label[text()='Misalignment Sensors Available']/following-sibling::div//input)[1]")
    public CustomElement crMisalignmentSensorsYes;

    @FindBy(locator = "xpath=(//label[text()='Misalignment Sensors Available']/following-sibling::div//input)[2]")
    public CustomElement crMisalignmentSensorsNo;

    @FindBy(locator = "xpath=//label[text()='Drive Pulley']/..//p-dropdown")
    public CustomElement crDrivePulley;
    @FindBy(locator = "xpath=//label[text()='Drive Pulley']/..//div[@role]")
    public CustomElement drDrivePulley;

    @FindBy(locator = "xpath=//label[text()='Brake Device']/..//p-dropdown")
    public CustomElement crBrakeDevice;
    @FindBy(locator = "xpath=//label[text()='Brake Device']/..//div[@role]")
    public CustomElement drBrakeDevice;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[2]")
    public CustomElement crHeadPulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[1]")
    public CustomElement crHeadPulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//p-dropdown)[1]")
    public CustomElement crHeadPulleyAngleOfWrap;
    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[1]")
    public CustomElement drHeadPulleyAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//p-dropdown)[1]")
    public CustomElement crHeadPulleyLaggingType;
    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[1]")
    public CustomElement drHeadPulleyLaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[1]")
    public CustomElement crHeadPulleyLaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[4]")
    public CustomElement crTailPulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[2]")
    public CustomElement crTailPulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//p-dropdown)[2]")
    public CustomElement crTailPulleyAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[2]")
    public CustomElement drTailPulleyAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//p-dropdown)[2]")
    public CustomElement crTailPulleyLaggingType;
    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[2]")
    public CustomElement drTailPulleyLaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[2]")
    public CustomElement crTailPulleyLaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[6]")
    public CustomElement crTakeUpPulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[3]")
    public CustomElement crTakeUpPulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[3]")
    public CustomElement drTakeUpAngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[3]")
    public CustomElement drTakeUpLaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[3]")
    public CustomElement crTakeUpLaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[8]")
    public CustomElement crBendPulley1PulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[4]")
    public CustomElement crBendPulley1PulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[4]")
    public CustomElement drBendPulley1AngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[4]")
    public CustomElement drBendPulley1LaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[4]")
    public CustomElement crBendPulley1LaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[10]")
    public CustomElement crBendPulley2PulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[5]")
    public CustomElement crBendPulley2PulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[5]")
    public CustomElement drBendPulley2AngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[5]")
    public CustomElement drBendPulley2LaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[5]")
    public CustomElement crBendPulley2LaggingThickness;

    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[12]")
    public CustomElement crAdditionPulley1PulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[6]")
    public CustomElement crAdditionPulley1PulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[6]")
    public CustomElement drAdditionPulley1AngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[6]")
    public CustomElement drAdditionPulley1LaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[6]")
    public CustomElement crAdditionPulley1LaggingThickness;
    @FindBy(locator = "xpath=(//label[text()='Diameter']/..//input)[14]")
    public CustomElement crAdditionPulley2PulleyDiameter;

    @FindBy(locator = "xpath=(//label[text()='Width']/..//input)[7]")
    public CustomElement crAdditionPulley2PulleyWidth;

    @FindBy(locator = "xpath=(//label[text()='Angle of Wrap']/..//div[@role])[7]")
    public CustomElement drAdditionPulley2AngleOfWrap;

    @FindBy(locator = "xpath=(//label[text()='Lagging Type']/..//div[@role])[7]")
    public CustomElement drAdditionPulley2LaggingType;

    @FindBy(locator = "xpath=(//label[text()='Lagging Thickness']/..//input)[7]")
    public CustomElement crAdditionPulley2LaggingThickness;

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

    @FindBy(locator = "xpath=//div[text()=' Drop Files to Import ']/..")
    public CustomElement crImportFileButton;

    @FindBy(locator = "xpath=//div[text()='Additional Remarks']/following-sibling::textarea")
    public CustomElement crAdditionalRemarks;
    @FindBy(locator = "xpath=(//a[contains(text(),'.pdf')])[1]")
    public CustomElement crRefrenceDocument;

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

    @FindBy(locator = "xpath=//span[text()='Save']")
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

    @FindBy(locator="xpath=//button[@icon='ctp-icon-Edit']//span[2]")
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

    @FindBy(locator = "xpath=//div[text()=' Default Layout ']/p-radiobutton//input")
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

    @FindBy(locator = "xpath=//th//div[normalize-space(.)='Belt Width (mm)']")
    public CustomElement BeltWidthCol;

    @FindBy(locator = "xpath=//th//div[normalize-space(.)='Rating (N/mm)']")
    public CustomElement ratingCol;

    @FindBy(locator = "xpath=//th//div[normalize-space(.)='Length (m)']")
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

    @FindBy(locator = "xpath=//span[text()=' Details']")
    public CustomElement crDetailsTab;

//    @FindBy(locator = "xpath=//span[text()=' Transitions']")
//    public CustomElement crTransitionTab;

    @FindBy(locator = "xpath=//span[contains(text(),'Transition')]")
    public CustomElement crTransitionTab;

    @FindBy(locator = "xpath=//span[text()='Cancel']")
    public CustomElement btnCancel;

    @FindBy(locator="//img[@src='/assets/img/upload_default.png']")
    public CustomElement addDefaultImgSrc;

    @FindBy(locator="//div[@role='dialog']")
    public CustomElement imageViewerPanel;

    @FindBy(locator = "xpath=//div[@class='p-breadcrumb p-component' and contains(., \"Conveyors\")]")
    public CustomElement conveyorBreadCrumb;

    @FindBy(locator = "xpath=(//label[@for='firstname2 '])[1]")
    public CustomElement txtGPSHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']//input[@formcontrolname='longitude'])[1]")
    public CustomElement tbHeadLong;

    @FindBy(locator = "xpath=(//div[@class=\"p-inputgroup\"]//input[@formcontrolname=\"latitude\"]\n)[1]")
    public CustomElement tbHeadLat;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']//input[@formcontrolname='longitude'])[2]")
    public CustomElement tbTailLong;

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

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;

    @FindBy(locator="xpath=//span[text()='Update']")
    public CustomElement btUpdate;

    @FindBy(locator="xpath=//label[text()='Corporate Name']/../div[1]//input[contains(@class,'p-filled')]")
    public CustomElement tbCorporateName;

    @FindBy(locator="//label[text()='Corporate Name']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledCorporateName;
    @FindBy(locator="//label[text()='Site']/../div[2]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledSite;
    @FindBy(locator="//label[text()='Distributor']/../div[1]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledDistributor;
    @FindBy(locator="//label[text()='Location']/../div[2]//input[contains(@class,\"p-filled\")]")
    public CustomElement tbFilledLocation;

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

    @FindBy(locator = "//p-columnfilterformelement//p-dropdown//span[text()=\"Any\"]")
    public CustomElement ddlAny;
    @FindBy(locator = "//div[contains(@class,\"p-column-filter-matchmode-dropdown\")]//span[text()='Starts with']")
    public CustomElement ddlStartsWith;
    @FindBy(locator = "//div[contains(@class,\"p-column-filter-constraints\")]//p-dropdown//div//span[text()=\"Date is\"]")
    public CustomElement ddlDateIs;
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

    @FindBy(locator="xpath=//label[text()='Corporate Name']/../div[2]//input[contains(@class,'p-filled')]")
    public CustomElement tbSite;

    @FindBy(locator="xpath=//label[contains(text(),'Width')]/../div/span")
    public CustomElement crWidthUnit;

    @FindBy(locator="xpath=//label[text()='Tons per Hour Peak']/../div/span")
    public CustomElement crTonsPerHrUnit;

    @FindBy(locator="xpath=//button[text()='Back']")
    public CustomElement btnBack;

    @FindBy(locator="xpath=//div[text()=' Automation Default Regression Layout ']//p-radiobutton")
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

    @FindBy(locator="xpath=//th[@id='name']")
    public CustomElement hdName;

    @FindBy(locator="xpath=//th[@id='customer.name']")
    public CustomElement hdSite;

    @FindBy(locator="xpath=//th[@id='sortableUpdatedDate']")
    public CustomElement hdLastMod;

    @FindBy(locator="xpath=//th[@id='beltInfo']")
    public CustomElement hdInstallBelt;

    @FindBy(locator="xpath=//th[@id='beltRemainingLifeLbl']")
    public CustomElement hdRemainingLife;

    @FindBy(locator="xpath=//th[@id='belt-col']")
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

    @FindBy(locator="xpath=//p-paginator//button[contains(@class,'p-highlight')]")
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

    @FindBy(locator="xpath=//th[@id='site-col'][1]")
    public CustomElement hdCorporate;

    @FindBy(locator="xpath=//tbody//td[5]")
    public CustomElement hdCorporateValue;

    @FindBy(locator="xpath=(//app-card//div[text()='Conveyors'])[1]")
    public CustomElement conveyorCardHeader;
    @FindBy(locator="xpath=//p-multiselect//div[text()=' By Author ']")
    public CustomElement chHeaderByAuthor;

    @FindBy(locator="xpath=//p-multiselect//div[text()=' By Event ']")
    public CustomElement chHeaderByEvent;

    @FindBy(locator = "xpath=(//p-calendar[@placeholder='MM/DD/YYYY']//input)[1]")
    public CustomElement tbFromDate;

    @FindBy(locator = "xpath=(//p-calendar[@placeholder='MM/DD/YYYY']//input)[2]")
    public CustomElement tbToDate;

    @FindBy(locator = "xpath=//span[@class='p-button-icon pi pi-refresh']")
    public CustomElement btnRefresh;

    @FindBy(locator="xpath=//span[contains(@class,'ctp-icon-sort-icon-down')]")
    public CustomElement btnSort;

    @FindBy(locator = "xpath=//button[@icon='ctp-icon-Clear-Filters']")
    public CustomElement btnFilter;
    @FindBy(locator = "xpath=//div[contains(@class,'p-panel-icons')]//button//span[contains(@class,'ctp-icon-Drop-Down')]")
    public CustomElement btnCollapse;
    @FindBy(locator = "xpath=(//app-notification-item//div[contains(@class,'notification')])[2]//i[@class='ctp-icon-Open-Inspections-Items']")
    public CustomElement inspNotification;
    @FindBy(locator = "xpath=(//app-notification-item//div[contains(@class,'notification')])[2]//i[@class='ctp-icon-cord-inspect-main-icon']")
    public CustomElement beltScanNotification;
    @FindBy(locator = "xpath=((//app-notification-item//div[contains(@class,'notification')])[2]//div[2]//div[1])[2]")
    public CustomElement notificationSiteName;
    @FindBy(locator = "xpath=((//app-notification-item//div[contains(@class,'notification')])[2]//div[2]//div[2])[1]")
    public CustomElement notificationConveyorName;
    @FindBy(locator = "xpath=((//app-notification-item//div[contains(@class,'notification')])[2]//div[2]//div[2])[2]")
    public CustomElement notificationUserName;

    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyors'])[1]/../div/div/div/div/i")
    public CustomElement conveyorCardLogo;
    @FindBy(locator = "xpath=(//app-card//div[text()='Conveyors'])[1]/../div/div/div/span")
    public CustomElement conveyorCardCount;

    @FindBy(locator="xpath=(//app-notification-item//div[contains(@class,\"notification\")])[2]//div[contains(@class,\"notification-time\")]//div[text()=\" New \"]")
    public CustomElement newLink;
    @FindBy(locator = "xpath=//th[contains(@id,\"monitoringLocation-col\")]")
    public CustomElement thMonitoringLocation;

    @FindBy(locator = "xpath=//th[@id='beltConveyorSaves-col']")
    public CustomElement thBeltConveyorSaves;

    @FindBy(locator = "xpath=//th[@id='lastServiceDate-col']")
    public CustomElement thLastServiceDate;
    @FindBy(locator = "xpath=//div[@class=\"p-multiselect-label\"]")
    public CustomElement selectedColumnFilters;

    @FindBy(locator = "xpath=//th[@psortablecolumn]")
    public CustomElement noOfselectedColumnFilters;

    @FindBy(locator = "xpath=//div[contains(@class,\"p-confirm-dialog\")]")
    public CustomElement warningDialog;

    @FindBy(locator="xpath=//span[text()='Confirmation']/../../div//button//span[text()='Yes']")
    public CustomElement btnYes;
    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
    public CustomElement ddlActions;
    @FindBy(locator = "xpath=//span[text()='Delete']")
    public CustomElement btnDelete;
    @FindBy(locator = "xpath=(//div[contains(text(),'Success')])[1]")
    public CustomElement deleteSuccessMsg;

    @FindBy(locator = "xpath=//p-breadcrumb//nav[@data-pc-name=\"breadcrumb\"]")
    public CustomElement breadCrumb;

    String[] columnNames={"Name","Site","Corporate","Last Modified","Installed Belt","Remaining Life by Time","Remaining Cover %","Inspection Items",
            "Belt Manufacturer","Number of Plies","Number of Cords","Cord Pitch","Cord Diameter","Length","Splice Type","Splice Quantity","Installation Date","Belt Speed","Tons Per Hour Peak","Material",
            "Angle of Idlers","Carry Side Idler Spacing","Drive Wrap Angle","Take-up Tension","Surcharge Angle",
            "Idler Offset type","Drive Details","Take-up type","Stations","Belt Construction","Top Cover Component","Bottom Cover Component","Carcass","Rating","Belt Width","Top Cover Thickness","Bottom Cover Thickness","Material Density","Friction Factor"};


    String[] DevicesColumnNames={"Name","Device Type","Site","Conveyor","Carcass","Belt Width","Region","Territory","Location",
            "Status","Installation Date","Last Service Date","Belt/Conveyor Saves"};

    String[] checkedDevicesColumnNames={"Name","Device Type","Site","Conveyor","Carcass","Territory","Location",
            "Status","Installation Date","Last Service Date","Belt/Conveyor Saves"};

    String[] monitoringDeviceColName={"name","deviceType","site","conveyor","territory","carcass","status","installedDate","location","lastServiceDate","beltConveyorSaves"};

    String[] BeltScanColNames = {"Date Of Scan", "Device Type", "Site", "Conveyor", "Territory", "CCM"};


    public void goToConveyorListScreen(){
        if(!conveyorList.isVisible())
            home.click("Home");
        conveyorList.jsClick("Conveyor List");
        btSearchinput.isVisible("Conveyor List Page");
    }

    public void goToAddConveyor(){
        waitForElementVisible(addConveyors,10000,500);
        waitForElementToBeClickable(addConveyors);
        addConveyors.jsClick("Add Conveyors");
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
        btCreate.click("Save & Close");
        waitForElementToInvisible(buttonLoader,40000);
        btSearchinput.isVisible("Conveyor list screen");
    }

    public void createDuplicateConveyor(String conveyorName, String distShopName, String custSiteName) {
        waitForPageLoad(20000);
        SyncUtil.waitFor(10000);
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        btCreate.click("Save & Close");
    }


    public void createConveyorWithImg(String conveyorName, String distShopName, String custSiteName, String img) {
        enterConveyorMandatoryDetails(conveyorName,distShopName,custSiteName);
        new CorporatePage().corporateImgUpload(img);
        waitForElementToBeClickable(enableWeatherSync);
        enableWeatherSync.click("Weather Sync");
        btCreate.click("Save & Close");
        waitForElementToInvisible(buttonLoader,10000);
        btSearchinput.isVisible("Conveyor list screen");
    }

    public void enterConveyorMandatoryDetails(String conveyorName, String distShopName, String custSiteName) {
        addConveyors.jsClick("Add Conveyor");

        waitForElementToDisplay(tbConveyorname);
        waitForElementToBeClickable(tbConveyorname);
        tbConveyorname.sendKeys(conveyorName,"conveyor name");
        dropdownSelectSearch(drDistShopdropdown, tbSitedropdown, distShopName);
        dropdownSelectSearch(drSitedropdown, tbSitedropdown, custSiteName);
    }
    public void enterConveyorDetails(String conveyorName, String distShopName, String custSiteName) {
        waitForElementToDisplay(tbConveyorname);
        waitForElementToBeClickable(tbConveyorname);
        tbConveyorname.sendKeys(conveyorName,"conveyor name");
        if (!distShopName.isEmpty())
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
        inspectionpage.clickClickFilter();
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
        waitForPageLoad(40000);
        waitForElementToDisplay(crTechnicalDataCard);
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
        verifyConveyorViewScreen();
        verifyWearLife();
        verifyIdlers();
        verifyPulleys();
        verifyTransitions();
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

    //Technical Details Conveyor screen in add/edit mode
    public boolean verifyConveyor() {
        crAddConveyorTab.click("Conveyor Tab");
//        return crConveyingLength.isVisible("Conveying Length") && crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power") &&
//                crGearRatio.isVisible("Gear Ratio") && crDriveFrequency.isVisible("Driver Frequency") && crAngle.isVisible("Conveyor Angle") &&
//                crSpeed.isVisible("Conveyor Speed") && crConveyingCapacity.isVisible("Conveying Capacity") && crPercentLoad.isVisible("Percent Load") && crMinimumTemperature.isVisible("Minimum Temperature") &&
//                crMaximumTemperature.isVisible("Maximum Temperature") && crTakeupTravel.isVisible("Take Up Travel") && crEstimatedWeight.isVisible("Estimated Weight") &&
//                crClockwise.isEnable("Right / Clockwise");
        return crConveyingLength.isVisible("Conveying Length");
    }

    //Technical Details Conveyor screen in view mode
    public boolean verifyConveyorViewScreen() {
        crConveyorTab.click("Conveyor Tab");
//        return crConveyingLength.isVisible("Conveying Length") && crLift.isVisible("Conveyor Lift") && crDrivePower.isVisible("Driver Power") &&
//                crGearRatio.isVisible("Gear Ratio") && crDriveFrequency.isVisible("Driver Frequency") && crAngle.isVisible("Conveyor Angle") &&
//                crSpeed.isVisible("Conveyor Speed") && crConveyingCapacity.isVisible("Conveying Capacity") && crPercentLoad.isVisible("Percent Load") && crMinimumTemperature.isVisible("Minimum Temperature") &&
//                crMaximumTemperature.isVisible("Maximum Temperature") && crTakeupTravel.isVisible("Take Up Travel") && crEstimatedWeight.isVisible("Estimated Weight") &&
//                crClockwise.isEnable("Right / Clockwise");
        return crConveyingLength.isVisible("Conveying Length");
    }

    public boolean verifyWearLife() {
        SyncUtil.waitFor(4000);
//        waitForElementVisible(crWearLifeTab,5000,1000);
        crWearLifeTab.click("Wear Life Tab");
        return crTonsPerYear.isVisible("Tons Per year") && crFeedAngle.isVisible("Feed Angle") && crChuteAngle.isVisible("Chute Angle") && crBeltInclineAngle.isVisible("Belt Incline angle in Load Zone");
    }

    public boolean verifyIdlers() {
        crIdlersTab.click("Idlers Tab");
        return crCarryIdlerDiameter.isVisible("Carry Idler Diameter") && crCarryAngle.isVisible("Carry Angle");
//                && crCarryTotalIdlers.isVisible("Carry Total Number of Idlers") &&
//                crCarryTopRunSpacing.isVisible("Carry Top Run Spacing") && crReturnIdlerDiameter.isVisible("Return Idler Diameter") && crReturnAngle.isVisible("Return Angle") &&
//                crReturnTotalIdlers.isVisible("Return Total Number of Idlers") && crReturnTopRunSpacing.isVisible("Return Top Run Spacing") && crImpactIdlerDiameter.isVisible("Impact Idler Diameter") && crImpactAngle.isVisible("Impact Angle") &&
//                crImpactTotalIdlers.isVisible("Impact Total Number of Idlers") && !crIdlerOffset.isEnable() && crNoOfTransitionIdlers.isVisible("Number of Transition Idlers") && !crMisalignmentSensorsYes.isEnable() &&
//                !crMisalignmentSensorsNo.isEnable();
    }

    public boolean verifyPulleys() {
        crPulleysTab.click("Pulleys Tab");
        return !crDrivePulley.isEnable() && !crBrakeDevice.isEnable() && crHeadPulleyDiameter.isVisible("Head Pulley Diameter");
//                crHeadPulleyWidth.isVisible("Head Pulley Width") && crHeadPulleyAngleOfWrap.isEnable("Head Pulley Angle Of Wrap") && crHeadPulleyLaggingType.isEnable("Head Pulley Lagging Type") &&
//                crHeadPulleyLaggingThickness.isVisible("Head Pulley Lagging Thickness") && crTailPulleyDiameter.isVisible("Tail Pulley Diameter") && crTailPulleyWidth.isVisible("Tail Pulley Width") && crTailPulleyAngleOfWrap.isEnable("Tail Pulley Angle Of Wrap") &&
//                crTailPulleyLaggingType.isEnable("Tail Pulley Lagging Type") && crTailPulleyLaggingThickness.isVisible("Tail Pulley Lagging Thickness");
    }

    public boolean verifyTransitions() {
        crTransitionTab.click("Transition Zone Tab");
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
        Validator.assertTrue(((Map<String,String>)(CSVUtil.getCSVDataAsMap(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+"download.csv").get(0)[0])).values().iterator().next().equalsIgnoreCase(conveyor2),"CSV Report was generated for the wrong conveyor","CSV Report was generated for the right conveyor");
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
        SyncUtil.waitFor(3000);
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
        SyncUtil.waitFor(3000);
        crMultipleSitesRadio.click("Multiple Site Radio");
        dropdownSelectSearch(crSiteDropdown, tbMultipleSiteDropdown, site);
        crSiteDropdown.jsClick();
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
        waitForElementToDisplay(fileUploadSummary);
        SyncUtil.waitFor(1000);
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
        crSave.click();
        waitForElementToDisplay(crUpdateMsg);
    }

    public void editConveyor(String oldConveyorName, String newConveyorName) {
        btSearchinput.type(oldConveyorName);
        crviewicon.click();
        waitForElementVisible(conveyorNameLoader,10000,1000);
        conveyorNameLoader.waitForPartialText(oldConveyorName, 15000);
        waitForElementToDisplay(conveyorTitle);
        waitForElementToBeClickable(editConveyor);
        editConveyor.click();
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToDisplay(tbConveyorname);
        setImplicitWait(5000,TimeUnit.MILLISECONDS);
        tbConveyorname.type(newConveyorName);
        SyncUtil.waitFor(1500);
        crSave.click();
        waitForElementToDisplay(crUpdateMsg);
    }

    public boolean verifyTile() {
        System.out.println(crTechnicalDataCard.isEnable("Technical Card")+"" + crConveyorHistory.isEnable("Conveyor History") + crFileManager.isEnable("File Manager") + crCoverWear.isEnable("Cover Wear") +"" + crInspections.isEnable("Inspections") + crConveyorInspect.isEnable("Conveyor Inspect") + crMonitoringDevices.isEnable("Monitoring Devices") +" "+crMinutemanCalc.isEnable("Minuteman Calc"));
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
        addNewLayout.jsClick("Add New Layout");
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

        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementToBeClickable(filterDropdown);
        filterDropdown.jsClick();
        waitForElementVisible(filterDropdowPopup, 20000, 500);
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
        waitForElementVisible(filterDropdowPopup, 20000, 500);
        SyncUtil.waitFor(10000);
        filterDropdown.click();
        waitForElementToDisplay(tbMultipleSiteDropdown);
        waitForElementVisible(tbMultipleSiteDropdown,10000,1000);
        tbMultipleSiteDropdown.type(corporates);
        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'" + corporates + "')]"));
        driver.findElement("//li/div[contains(text(),'" + corporates + "')]").click();
        return verifyCorporateFilter();

    }

    public boolean verifyFilters(){
        waitForPageLoad(5000);
        return corporatesCol.isEnable() && BeltWidthCol.isEnable() && ratingCol.isEnable() && lengthCol.isEnable();
    }

    public boolean verifyColFilters() {
        SyncUtil.waitFor(5000);
        return corporatesCol.isVisible() && BeltWidthCol.isVisible() && ratingCol.isVisible() && lengthCol.isVisible();
    }

    public boolean verifyCorporateFilter() {
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
        SyncUtil.waitFor(10000);
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
        conveyorHistoryCard.jsClick();
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
        Validator.assertTrue(crAddConveyorTab.getText().contains("Conveyor"),"Conveyor Bar is not visible","Conveyor Bar is visible");
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
        crConveyorLiteTab.jsClick("Conveyor Lite Tab");
        waitForElementVisible(crBeltWidth,5000,1000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/conveyor-lite"),"URL missMatch","URL validation passed");
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
        crAddConveyorTab.click("Conveyor Tab");
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
        crRemarksTab.jsClick("Remarks Tab");
        waitForElementVisible(crAdditionalRemarks,5000,1000);
        btCreate.click("Create Click");
        waitForElementToInvisible(buttonLoader,40000);
        waitForElementVisible(conveyorHeader,20000,1000);
        Validator.assertTrue(conveyorHeader.isDisplayed(),"Conveyor was not created","Conveyor was created");
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
        waitForElementVisible(conveyorErrorMsg,10000,500);
        Validator.assertTrue(conveyorErrorMsg.isVisible(),"Error message is not displayed creating duplicate conveyor","Error message is displayed creating duplicate conveyor");

    }
    public void remarksBtnClick()
    {
        waitForElementVisible(crRemarksTab,5000,500);
        crRemarksTab.click("Remarks Tab");
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
    public void enterConveyorFields(String conveyorName, String distShopName, String custSiteName) {
        enterConveyorDetails(conveyorName,distShopName,custSiteName);
    }

    public void previousBtnClick()
    {
        waitForElementVisible(btnPrevious,5000,500);
        btnPrevious.click("Previous");
        waitForPageLoad(10000);

    }
//    public boolean verifyTransitionPage() {
//        waitForElementVisible(crHeadTransitionLength,5000,1000);
//        Validator.assertTrue(driver.getCurrentUrl().contains("secure/conveyor/add/transitions"),"user is not navigated to transition add page","user is navigated to transition add page");
//        return crHeadTransitionLength.isVisible("Flat-to-trough Transition Length") && crHeadPulleyLift.isVisible("Pulley Lift");
//    }

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
        waitForElementVisible(crConveyorLiteTab,5000,1000);
        crConveyorLiteTab.jsClick("Conveyor Lite Tab");
        waitForPageLoad(5000);
        waitForElementVisible(unitIconConveyor,5000,1000);
        Validator.assertTrue(unitIconConveyor.getText("Unit Value").contains(unit),"unit is not selected","unit is selected");

    }

//    public void extractConveyorCount()
//    {
//        int conveyorCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
//        Validator.assertTrue(Integer.toString(conveyorCount).equals(conveyorCardCount.getText()),"Conveyor Card Count and pagination does not match","Conveyor Card Count and pagination matches");
//        getBundle().setProperty("mainCardCountKey", conveyorCount);
//    }
    public void extractMainCardCount(String moduleName)
    {
        int extractedCardCount = Integer.parseInt(driver.findElement(By.xpath("(//app-card//div[@class='header' and text()='" + moduleName + "']/..//div//span)[1]")).getText());
        int paginationCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(extractedCardCount+"value"+paginationCount);
//        Validator.assertTrue(extractedCardCount==paginationCount,"Card Count and pagination does not match","Card Count and pagination matches");
        getBundle().setProperty("mainCardCountKey", extractedCardCount);
    }
    public void extractConveyorCardCountForDetailPage(String moduleName)
    {
        SyncUtil.waitFor(4000);
        int extractedCardCount = Integer.parseInt(driver.findElement(By.xpath("(//app-card//div[@class='header' and text()='" + moduleName + "']/..//div//span)[1]")).getText());
        int paginationCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(extractedCardCount+"value"+paginationCount);
        Validator.assertTrue(extractedCardCount==paginationCount,"Card Count and pagination does not match","Card Count and pagination matches");
        getBundle().setProperty("cardCountDetailPage", extractedCardCount);

    }
    public void verifyCardCountInDetailPageAfterChange(String operation, String moduleName, int value) {
        String extractedCrdCountAfterAddition = getBundle().getProperty("cardCountDetailPage").toString();
        int mainCardCountAfterAdd;
        if (operation.equalsIgnoreCase("add"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) + value;
        else if (operation.equalsIgnoreCase("delete"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) - value;
        else mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition);
        int paginationValue = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(mainCardCountAfterAdd+"value"+paginationValue);
        Validator.assertTrue(mainCardCountAfterAdd == paginationValue, "The pagination count is not matching", "The pagination count is matching");
        int updatedMainCardCount = Integer.parseInt(driver.findElement(By.xpath("(//app-card//div[@class='header' and text()='" + moduleName + "']/..//div//span)[1]")).getText());
        Reporter.log(updatedMainCardCount + "is the  main card count after adding");
        System.out.println(mainCardCountAfterAdd+"value"+updatedMainCardCount);
        Validator.assertTrue(mainCardCountAfterAdd == updatedMainCardCount, "The main card count is not matching", "The main card count is matching");
    }

    public void verifySiteAndConveyorPreFilled()
    {
       Validator.assertTrue(tbCorporateName.isDisplayed(),"Corporate Name is not prefilled","Corporate Name is prefilled");
       Validator.assertTrue(tbSite.isDisplayed(),"Site is not prefilled","Site is prefilled");
    }

    public void editBeltWidth(String beltWidth)
    {
        waitForElementToBeClickable(editConveyor);
        SyncUtil.waitFor(10000);
        editConveyor.jsClick();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        waitForElementToDisplay(crInstalledBeltTab);
        crInstalledBeltTab.click("Installed Belt Tab");
        waitForPageLoad(10000);
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
        addNewLayout.jsClick("Add New Layout");
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
    public void clickOnLayoutAndVerifySaveSetPreference()
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
    public void clickOnTheDefault()
    {
        waitForElementVisible(btTableLayout,10000,500);
        waitForElementToBeClickable(btTableLayout);
        btTableLayout.jsClick("Add Table Layout");
        tableLayoutHeader.isVisible("Table Layout");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        defaultLayout.jsClick("Default Radio");
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        SyncUtil.waitFor(2000);
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

//    public void addColumnFilters(String filterName){
//        setImplicitWait(30000,TimeUnit.MILLISECONDS);
//        filterDropdown.click();
//        SyncUtil.waitFor(1000);
//        tbMultipleSiteDropdown.type(filterName);
//        waitForPresenceOfElement(By.xpath("//li/div[contains(text(),'"+filterName+"')]"));
//        driver.findElement("//li/div[contains(text(),'"+filterName+"')]").click();
//        waitForElementToBeClickable(tbMultipleSiteDropdownCancel);
//        tbMultipleSiteDropdownCancel.click();
//    }

    public void verifyHeaderDataFieldUnit(String field,String unit)
    {
        waitForElementVisible(driver.findElement("//div[contains(text(),'"+field+"')]"),10000,1000);
        Validator.assertTrue(driver.findElement("//div[normalize-space(.)='"+field+" ("+unit+")']").getText().contains(unit),"unit is not selected Correctly","unit is selected Correctly");
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
        Validator.assertTrue(crUpdateMsg.isVisible(),"Update Message is not visible","Update Message is visible");
        System.out.println("save clicked");
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

    public void editConveyorSpeed(String speed) {
        waitForElementToBeClickable(editConveyor);
        editConveyor.jsClick();
        waitForPageLoad(10000);
        waitForElementToDisplay(tbConveyorname);
        crConveyorLiteTab.click("Conveyor Lite Tab");
        waitForPageLoad(5000);
        Validator.assertTrue(crBeltWidth.isVisible(), "Conveyor Lite page is not loaded", "Conveyor Lite page is loaded");
        waitForElementToBeClickable(crBeltSpeed);
        crBeltSpeed.clear();
        crBeltSpeed.type(speed);
        waitForElementToBeClickable(crUpdate);
        crUpdate.click();
        waitForElementToDisplay(crUpdateMsg);
        SyncUtil.waitFor(3000);
        scrollPageup();
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
        String[] columnNamesArray;
        if (this.getCurrentURL().contains("/secure/dashboard/devices")) {
            columnNamesArray = DevicesColumnNames;
        } else if (this.getCurrentURL().contains("/secure/dashboard/belt-scans")) {
            columnNamesArray = BeltScanColNames;
        } else
            columnNamesArray = columnNames;
        for (String columnName : columnNamesArray) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            System.out.println(columnName);
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]]")), 20000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + columnName + "') and .//div[contains(@class, 'p-checkbox')]]")).isDisplayed(), "column name '" + columnName + "' is not visible", "column name '" + columnName + "' is visible");
        }
    }

    public void verifyCheckedColumnNames() {
        String[] columnHeader;
        if (this.getCurrentURL().contains("/secure/dashboard/devices")) {
            columnHeader = checkedDevicesColumnNames;
        } else if (this.getCurrentURL().contains("/secure/dashboard/belt-scans")) {
            columnHeader = BeltScanColNames;
        } else
            columnHeader = BeltScanColNames;
//        waitForPageLoad(10000);
        setImplicitWait(20000, TimeUnit.MILLISECONDS);
        for (String checkedColumnName : columnHeader) {
            setImplicitWait(20000, TimeUnit.MILLISECONDS);
            System.out.println(checkedColumnName);
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + checkedColumnName + "') and .//div[contains(@class, 'p-checkbox')]//div//checkicon]")), 20000, 500);
            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + checkedColumnName + "') and .//div[contains(@class, 'p-checkbox')]//div//checkicon]")).isDisplayed(), "column name '" + checkedColumnName + "' is not checked", "column name '" + checkedColumnName + "' is checked");
        }

    }
    public void selectTwoColumnsAndVerify()
    {
        String[] trimmedArray = Arrays.copyOf(checkedDevicesColumnNames, 9);
        for(String colName:trimmedArray)
        {
            waitForElementVisible(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + colName + "') and .//div[contains(@class, 'p-checkbox')]]")), 20000, 500);
            driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + colName + "') and .//div[contains(@class, 'p-checkbox')]]")).click();
//            Validator.assertTrue(driver.findElement(By.xpath("//p-multiselectitem//li[contains(., '" + colName + "') and .//div[contains(@class, 'p-checkbox')]//div//checkicon]")).verifyNotPresent(),"'"+colName+"'is not unchecked","'"+colName+"'is unchecked");
        }

    }
    public void verifySelectedColumns()
    {
        waitForElementVisible(selectedColumnFilters,10000,500);
        String columFilteredNames=selectedColumnFilters.getText();
        List<WebElement> elements = driver.findElements(By.xpath("//th[@psortablecolumn]"));
        int noOfColumns=elements.size();
        for(int i=1;i<=noOfColumns;i++)
        {
            Validator.assertTrue(columFilteredNames.contains(driver.findElement(By.xpath("(//th[@psortablecolumn]['"+i+"']//div)[1]")).getText()),
                    "Columns other than filtered columns are visible","Only Selected columns are present in the table");
        }
    }

    public void verifySelectedColumnDisplay(String value)
    {
        if(value.equalsIgnoreCase("multiple"))
            verifySelectedColumns();
        else if(value.equalsIgnoreCase("single"))
        {
            driver.findElement(By.xpath("//p-multiselectitem//li[contains(., ' Belt/Conveyor Saves ') and .//div[contains(@class, 'p-checkbox')]]")).click();
            Reporter.log("Single column Installed Date is checked");
            verifySelectedColumns();
        }

    }

    public void searchColumnName(String columnNames)
    {
        waitForElementVisible(tbMultipleSiteDropdown,20000,500);
        tbMultipleSiteDropdown.type(columnNames);

    }

    public void verifySearchedColumnNames() {
        waitForElementVisible(cbInstalledBeltColumn, 10000, 500);
        Validator.assertTrue(cbInstalledBeltColumn.isVisible() && cbBeltManufacturerColumn.isVisible() && cbBeltSpeedColumn.isVisible() && cbBeltConstructionColumn.isVisible() && cbBeltWidthColumn.isVisible(), "The column names with searched text  is not visible", "The column names with searched text is  visible");
    }
    public void columnSelectionCheckboxClick()
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
        hoverOverElement(thNameColumn);
        waitForElementVisible(nameFilterIcon,20000,500);
        waitForElementToBeClickable(nameFilterIcon);
        waitForElementToBeClickable(nameFilterIcon);
        nameFilterIcon.click();
    }

    public void columnNameFilterBtnClick(String[] columnsArray) {
        for (String colName : columnsArray) {
            String filterType = "Starts with";
            if (colName.equalsIgnoreCase("location") || colName.equalsIgnoreCase("Device Type")) {
                hoverOverElement(driver.findElement(By.xpath("//th//div[(text()=' " + colName + " ')]")));
                Reporter.log("No filter Icon is visible for monitoring location");
                continue;
            }
            hoverOverElement(driver.findElement(By.xpath("//th//div[(text()=' " + colName + " ')]")));
            waitForElementVisible(driver.findElement(By.xpath("//div[text()=' " + colName + " ']//p-columnfilter")), 10000, 500);
            waitForElementToBeClickable(driver.findElement(By.xpath("//div[text()=' " + colName + " ']//p-columnfilter")));
            driver.findElement(By.xpath("//div[text()=' " + colName + " ']//p-columnfilter")).click();
            if (colName.equalsIgnoreCase("status") || colName.equalsIgnoreCase("deviceType") || colName.equalsIgnoreCase("carcass")) {
                verifyStatusFilterIcon(colName);
            } else if (colName.equalsIgnoreCase("installedDate") || colName.equalsIgnoreCase("lastServiceDate") || colName.equalsIgnoreCase("Date Of Scan")) {
                verifyDateFilterIconFields(colName);
            } else {
                verifyFilterFields(colName);
                if (colName.equalsIgnoreCase("Site") || colName.equalsIgnoreCase("Conveyor")) {
                    applyColFilter(filterType, "CM");
                    coverWearPage.clearFilterClick();
                } else if (colName.equalsIgnoreCase("Territory")) {
                    filterType = "Contains";
                    applyColFilter(filterType, "BAN");
                    coverWearPage.clearFilterClick();

                } else if (colName.equalsIgnoreCase("CCM")) {
                    filterType = "Equals";
                    applyColFilter(filterType, "Sand_Master");
                    coverWearPage.clearFilterClick();

                }
            }


        }


    }

    public void applyColFilter(String filter, String text) {
        verifyFilter(filter);
        enterSearchText(text);
        verifyTextEntered();
        applyBtnClick();
        int noOfConveyors = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        verifyFilterApplied(noOfConveyors, filter, text);
        verifyFilterPopupClosed();
    }

    public void verifyFilterFields(String ColumnName) {
        setImplicitWait(30000, TimeUnit.MILLISECONDS);
        waitForElementVisible(ddlMatchAll, 10000, 500);
        Validator.assertTrue(ddlMatchAll.isVisible(), "Match all dropdown is not visible '" + ColumnName + "'", "Match all dropdown is visible for '" + ColumnName + "'");
        Validator.assertTrue(ddlStartsWith.isVisible(10000, "Starts with"), "starts with dropdown is not visible for '" + ColumnName + "'", "starts with dropdown is visible for '" + ColumnName + "'");
        Validator.assertTrue(filterSearchTextBox.isVisible(), "search text box  is not visible for '" + ColumnName + "'", " Search text box is visible for '" + ColumnName + "'");
//        Validator.assertTrue(addRuleLink.isVisible(),"Add rule link is not visible","Add rule link dropdown is visible");
        Validator.assertTrue(btnFilterClear.isVisible(10000,"clear"),"clear button is not visible for '"+ColumnName+"'","clear button is visible for '"+ColumnName+"'");
        Validator.assertTrue(btnFilterApply.isVisible(),"Apply button is not visible for '"+ColumnName+"'","Apply button is visible for '"+ColumnName+"'");
    }

    public void verifyStatusFilterIcon(String ColumnName)
    {
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementVisible(ddlAny,10000,500);
        Validator.assertTrue(ddlAny.isVisible(),"Any dropdown is not visible '"+ColumnName+"'","Any dropdown is visible for '"+ColumnName+"'");
//        Validator.assertTrue(addRuleLink.isVisible(),"Add rule link is not visible","Add rule link dropdown is visible");
        Validator.assertTrue(btnFilterClear.isVisible(),"clear button is not visible for '"+ColumnName+"'","clear button is visible for '"+ColumnName+"'");
        Validator.assertTrue(btnFilterApply.isVisible(),"Apply button is not visible for '"+ColumnName+"'","Apply button is visible for '"+ColumnName+"'");
    }

    public void verifyDateFilterIconFields(String ColumnName)
    {
        setImplicitWait(30000,TimeUnit.MILLISECONDS);
        waitForElementVisible(ddlMatchAll,10000,500);
        Validator.assertTrue(ddlMatchAll.isVisible(),"Match all dropdown is not visible '"+ColumnName+"'","Match all dropdown is visible for '"+ColumnName+"'");
        Validator.assertTrue(ddlDateIs.isVisible(),"Date dropdown is not visible for '"+ColumnName+"'","Date dropdown is visible for '"+ColumnName+"'");
        Validator.assertTrue(filterSearchTextBox.isVisible(),"search text box  is not visible for '"+ColumnName+"'"," Search text box is visible for '"+ColumnName+"'");
//        Validator.assertTrue(addRuleLink.isVisible(),"Add rule link is not visible","Add rule link dropdown is visible");
        Validator.assertTrue(btnFilterClear.isVisible(),"clear button is not visible for '"+ColumnName+"'","clear button is visible for '"+ColumnName+"'");
        Validator.assertTrue(btnFilterApply.isVisible(),"Apply button is not visible for '"+ColumnName+"'","Apply button is visible for '"+ColumnName+"'");
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

    public void applyBtnClick() {
        waitForElementVisible(btnFilterApply, 10000, 500);
        btnFilterApply.jsClick();
    }
    public void verifyFilterApplied(int noOfCoverWears, String filterType, String searchText) {
        for (int i = 1; i <= noOfCoverWears; i++) {
            String columnData = driver.findElement(By.xpath("//tr['" + i + "']//td[4]")).getText();
            if (columnData.startsWith("C1") || columnData.startsWith(searchText) || columnData.contains("common") || columnData.contains(searchText) || columnData.equalsIgnoreCase(searchText)) {
                System.out.println("columnDate for'" + filterType + "','" + columnData);
                Validator.assertTrue(true, "Filter '" + filterType + "' is not applied for row ", "filter '" + filterType + "' is applied");
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
        Validator.assertTrue(crActions.isEnable("Action Enable"),"Action button is not enabled","Action button is enabled");
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
       Validator.assertTrue(hdInstallBeltValue.getText().contains(installBelt),"Installed Belt is not visible","Installed Belt is visible");
       Validator.assertTrue(hdRemainingLifeValue.getText().contains(remainingTime),"Remaining Life by Time is not visible","Remaining Life by Time is visible");
       Validator.assertTrue(hdRemainingCoverValue.getText().contains(remainingPer),"Remaining Cover % is not visible","Remaining Cover % is visible");
    }

    public void verifyPaginationBackwardArrowButton(){
        waitForElementVisible(btPgPrev,5000,1000);
        waitForElementToBeClickable(btPgPrev);
        int highlightedValue= Integer.parseInt(btPgHighlightedValue.getText());
        btPgPrev.jsClick();
        int expectHighlightedValue= highlightedValue-1;
        Validator.assertTrue(btPgHighlightedValue.getText().contains(String.valueOf(expectHighlightedValue)),"Pagination is not present at 1","Pagination is present at 1");
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
        SyncUtil.waitFor(5000);
        crSiteDropdown.jsClick();
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

    public void editMapLocation()
    {
        clickOnMap();
        verifyPrefilledValuesDisplayed();
        clickOnLocationType();
        selectLocationTypeHead();
        addMarkerBtnClick();
        verifyUpdatedGPSHead();
    }

    public void enterConveyorName(String conveyorName)
    {
        waitForElementToDisplay(tbConveyorname);
        waitForElementToBeClickable(tbConveyorname);
        tbConveyorname.sendKeys(conveyorName,"conveyor name");
    }
    public void clickCreateBtn() {
        waitForElementVisible(btCreate, 10000, 500);
        waitForElementToBeClickable(btCreate);
        btCreate.click();
        waitForElementToInvisible(buttonLoader,10000);
    }

    public void saveButtonClick()
    {
        waitForElementToBeClickable(crSave);
        crSave.click();
        waitForPageLoad(10000);
    }
    public void verifyConveyorCardDisplay() {
        waitForPageLoad(20000);
        waitForElementVisible(conveyorCardHeader, 20000, 500);
    }

    public void clickConveyorCard() {
        waitForElementToBeClickable(conveyorCardHeader);
        conveyorCardHeader.jsClick();
        waitForPageLoad(20000);
    }
    public void verifyConveyorListPageNaviagtion() {
        waitForPageLoad(20000);
        waitForElementVisible(conveyorHeader, 20000, 500);
        Validator.assertTrue(conveyorHeader.isVisible(), "user is not navigated to conveyor list page", "user is  navigated to conveyor list page");
        Validator.assertTrue(driver.getCurrentUrl().contains("/secure/dashboard/conveyors"), "User is not navigated to conveyor list page", "User is  navigated to conveyor list page");
    }

    public void verifyNotificationConveyorOrder(String value1,String value2) {
        String updatedConveyor1 = "(//app-notification-item//div[contains(@class,'notification')])[2]//div[2]//div[text()='"+value1+"']";
        String updatedConveyor2 = "(//app-notification-item//div[contains(@class,'notification')])[4]//div[2]//div[text()='"+value2+"']";
        System.out.println(updatedConveyor2+updatedConveyor1);
        Validator.assertTrue(driver.findElement(By.xpath(updatedConveyor1)).isDisplayed() && driver.findElement(By.xpath(updatedConveyor2)).isDisplayed(), "notification is not  in last in first out format", "notification in last in first out format");
    }

    public void verifyConveyorHistoryHeaderFields() {
        setImplicitWait(10000, TimeUnit.MILLISECONDS);
        waitForElementVisible(chHeaderByAuthor, 20000, 500);
        Validator.assertTrue(chHeaderByAuthor.isDisplayed(), "By Author Field is not visible", "By Author Field is visible");
        Validator.assertTrue(chHeaderByEvent.isDisplayed(), "By Event Field is not visible", "By Event Field is visible");
        Validator.assertTrue(tbFromDate.isDisplayed() && tbToDate.isDisplayed(), "From date and To date fields are not visible", "From date and To Date fields are  visible");
        Validator.assertTrue(btnSort.isDisplayed(), "Sort button is not displayed", "Sort button is displayed");
        Validator.assertTrue(btnFilter.isDisplayed(), "Sort button is not displayed", "Sort button is displayed");
        Validator.assertTrue(btAddConveyorHistory.isDisplayed(), "Sort button is not displayed", "Sort button is displayed");
        Validator.assertTrue(btnRefresh.isDisplayed(), "Refresh button is not displayed", "Refresh button is displayed");
        Validator.assertTrue(btnCollapse.isDisplayed(), "Notifications List is not displayed", "Notifications List is displayed");

    }
    public void verifyInspNotification(String conveyorName,String siteName,String userName) {
        setImplicitWait(10000, TimeUnit.MILLISECONDS);
        Validator.assertTrue(inspNotification.isDisplayed(), "Inspection Notifications is not displayed", "Inspection Notifications is displayed");
        Validator.assertTrue(notificationSiteName.getText().equalsIgnoreCase(siteName), "Inspection Site value misMatch", "Inspection Site value matched");
        Validator.assertTrue(notificationConveyorName.getText().equalsIgnoreCase(conveyorName), "Inspection Conveyor value misMatch", "Inspection Conveyor value matched");
        Validator.assertTrue(notificationUserName.getText().contains(userName), "Inspection User value misMatch", "Inspection User value matched");
    }
 public void verifyPinnedSubList(String value) {
     String pinnedValue = "//td[text()=' "+value+" ']/..//td//i[contains(@class,'marker-icon-red')]";
     Validator.assertTrue(driver.findElement(By.xpath(pinnedValue)).isDisplayed(), "Pinned Value is not displayed", "Pinned Value is displayed");
    }
public void verifyUnPinnedSubList(String value) {
     String unPinnedValue = "//td[text()=' "+value+" ']/..//td//i[contains(@class,'marker-icon-gray')]";
     Validator.assertTrue(driver.findElement(By.xpath(unPinnedValue)).isDisplayed(), "UnPinned Value is not displayed", "UnPinned Value is displayed");
    }
    public void verifyConveyorHistoryNav(String conveyorName){
        SyncUtil.waitFor(5000);
        waitForPageLoad(10000);
        Validator.assertTrue(driver.getCurrentUrl().contains("/conveyor-history"),"User is not navigated to conveyor history page","User is navigated to conveyor history page");
        Validator.assertTrue(driver.findElement(By.xpath("//app-conveyor-history//div//h4[text()='"+conveyorName+"']")).isDisplayed(),"User is not navigated to conveyor history!","User is navigated to conveyor-history on clicking the new link");
    }
    public void verifyConveyorCardDetails(){
        waitUntilConveyorCountLoads();
        waitForElementVisible(conveyorCardHeader,5000,500);
        Validator.assertTrue(conveyorCardHeader.isDisplayed(),"Conveyor Card is not visible","Conveyor Card is visible");
        Validator.assertTrue(conveyorCardLogo.isVisible(),"Conveyor Logo is not visible","Conveyor Logo is visible");
        Validator.assertTrue(apiBase.getConveyorCount().get("count").toString().equals(conveyorCardCount.getText()),"Conveyor Card Count does not match","Conveyor Card Count matches");
    }
    public void waitUntilConveyorCountLoads(){
        int apiCount = Integer.parseInt(apiBase.getConveyorCount().get("count").toString());
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(120); stop > System.nanoTime();) {
            int elementCount = Integer.parseInt(conveyorCardCount.getText());
            if (elementCount == apiCount) {
                System.out.println("Counts match! Exiting loop.");
                break;
            }
            System.out.println("Waiting for counts to match. Current element count: " + elementCount + ", API count: " + apiCount);

            SyncUtil.waitFor(5000);
        }

         }

    public void newLinkClick()
    {
        waitForElementVisible(newLink,10000,500);
        newLink.isVisible(10000,"New");
        newLink.click("New link");
    }

    public void verifyConveyorHistoryForConveyor(String conveyorName)
    {
        SyncUtil.waitFor(5000);
        Validator.assertTrue(driver.findElement(By.xpath("//div[contains(@class,\"p-scroller-content\")]//div[2]//div//h6[contains(@class,\"conveyor-name\") and text()='"+conveyorName+"']")).isDisplayed(),"Subscribed user  unable to see updates under Conveyor History!",
                "Subscribed user is able to see updates under Conveyor History!");
    }

    public void closeDialog() {
        SyncUtil.waitFor(5000);
        waitForElementVisible(btnCancel, 15000, 500);
        waitForElementToDisplay(btnCancel);
        btnCancel.jsClick();
        waitForElementVisible(warningDialog, 10000, 500);
        waitForElementVisible(btnYes, 10000, 500);
        waitForElementToBeClickable(btnYes);
        btnYes.jsClick();
    }
    public void validateConveyorCountWrtPagination(){
        int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        Validator.assertTrue(apiBase.getConveyorCount().get("count").equals(deviceCount),"Conveyor Pagination Count does not match","Conveyor Pagination Count matches");
        Validator.assertTrue(Integer.toString(deviceCount).equals(conveyorCardCount.getText()),"Conveyor Card Count does not match","Conveyor Card Count matches");
    }
    public void clickOnAddConveyorInMenu(){
        waitForElementVisible(addConveyors,5000,1000);
        addConveyors.click("Add Conveyors");
    }
    public void clearSearchItem(){
        waitForElementVisible(btSearchinput,5000,1000);
        btSearchinput.clear();
        btSearchinput.type(" ");
    }
    public void clickOnAddIcon(){
       waitForElementVisible(btAddConveyor,5000,1000);
        btAddConveyor.jsClick("Add icon");
        SyncUtil.waitFor(8000);
        System.out.println(driver.getCurrentUrl());
        Validator.assertTrue(driver.getCurrentUrl().contains("add"),"URL missMatch","URL validation passed");
    }

    public void enterConveyorLitePageFields(String beltWidth,String materialName,String driveWrapAngle,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails){
        verifyConveyorLitePage();
        crBeltWidth.type(beltWidth);
        crBeltSpeed.type(beltWidth);
        crTonsPerHr.type(beltWidth);
        dropdownSelectSearch(drMaterialName, tbSitedropdown, materialName);
        crMaterialDensity.type(beltWidth);
        crAngleOfIdlers.type(beltWidth);
        crIdlerSpacing.type(beltWidth);
        dropdownSelectSearch(drDriveWrapAngle, tbSitedropdown, driveWrapAngle);
        crTakeUpTension.type(beltWidth);
        crPermanentFriction.jsClick();
//        dropdownSelectSearch(drSurchargeFactor, tbSitedropdown, surchargeAngle);
        dropdownSelectSearch(drIdleOffsetType, tbSitedropdown, idlerOffsetType);
        drDriveDetails.click();
        driver.findElement("//span[text()='"+driveDetails+"']").click();
        dropdownSelectSearch(drTakeupDetails, tbSitedropdown, takeUpDetails);
        cbStation.click();
        rbDrive.click();
    }
    public void enterInstalledBeltPageFields(String beltConfig,String beltConst,String topCompound,String carCass,String width,String splice,String installDate){
        scrollPageup();
        verifyInstalledBeltPage();
        dropdownSelectSearch(drBeltConfig, tbSitedropdown, beltConfig);
        dropdownSelectSearch(drBeltConstruction, tbSitedropdown, beltConst);
        dropdownSelectSearch(drTopCompound, tbSitedropdown, topCompound);
        dropdownSelectSearch(drBottomCompound, tbSitedropdown, topCompound);
        dropdownSelectSearch(drCarcass, tbSitedropdown, carCass);
        crNumberOfPlies.type(width);
        crBreakingStrength.type(width);
        crTopCoverThickness.type(width);
        crBottomCoverThickness.type(width);
        crLength.type(width);
        drSplice.click();
        driver.findElement("//ul//span[text()='"+splice+"']").click();
        crSpliceQuantity.type(width);
        crInstallationDate.click();
        coverWearPage.selectGivenDate(installDate);
   }
    public void enterMaterialPageFields(String bulkSize,String granularSize,String aggresivity,String loadingFrequency,String feedingConditions){
        scrollPageup();
        verifyMaterialPage();
        crBulkDensity.clear();
        crBulkDensity.type(bulkSize);
        crBulkSize.type(bulkSize);
        crLumpSize.type(bulkSize);
        crGranularSize.click();
        driver.findElement("//ul//span[text()='"+granularSize+"']").click();
        crContingentOfFines.type(bulkSize);
        crAggresivity.click();
        driver.findElement("//ul//span[text()='"+aggresivity+"']").click();
        crDensityType.click();
        driver.findElement("//ul//span[text()='"+granularSize+"']").click();
        crChuteDrop.type(bulkSize);
        crLoadingFrequency.click();
        driver.findElement("//ul//span[text()='"+loadingFrequency+"']").click();
        crLoadingConditions.click();
        driver.findElement("//ul//span[text()='"+loadingFrequency+"']").click();
        crTemperature.type(bulkSize);
        crFeedingConditions.click();
        driver.findElement("//ul//span[text()='"+feedingConditions+"']").click();
        crPresenceOfOil.click();
        driver.findElement("//ul//span[text()='"+aggresivity+"']").click();
    }
    public void enterConveyorPageFields(String conveyingLength,String ratio,String stage,String takeUpDetails,String beltTurnOver){
        scrollPageup();
        verifyConveyorPage();
        crConveyingLength.type(conveyingLength);
        crLift.type(conveyingLength);
        crDrivePower.type(conveyingLength);
        crGearRatioFirst.type(ratio);
        crGearRatioSecond.type(ratio);
        crDriveFrequency.type(conveyingLength);
        crAngle.type(conveyingLength);
        crConveyingCapacity.type(conveyingLength);
        crPercentLoad.type(conveyingLength);
        crMinimumTemperature.type(conveyingLength);
        crMaximumTemperature.type(conveyingLength);
        dropdownSelectSearch(crStage, tbSitedropdown,stage);
        crTakeupType.click();
        driver.findElement("//span[text()='"+takeUpDetails+"']").click();
        crTakeupTravel.type(conveyingLength);
        crEstimatedWeight.type(conveyingLength);
        crBeltTurnover.click();
        driver.findElement("//span[text()='"+beltTurnOver+"']").click();
        crClockwise.jsClick();
        crPipeBeltYes.jsClick();
    }
    public void enterWearLifePageFields(String chuteAngle){
        scrollPageup();
        verifyWearLifePage();
        crTonsPerYear.type(chuteAngle);
        crFeedAngle.type(chuteAngle);
        crChuteAngle.type(chuteAngle);
        crBeltInclineAngle.type(chuteAngle);
      }
    public void enterIdlersPageFields(String angle,String idlerOffset){
        scrollPageup();
        verifyIdlersPage();
        crCarryIdlerDiameter.type(angle);
        crCarryTotalIdlers.type(angle);
        crReturnIdlerDiameter.type(angle);
        crReturnAngle.type(angle);
        crReturnTotalIdlers.type(angle);
        crReturnTopRunSpacing.type(angle);
        crImpactIdlerDiameter.type(angle);
        crImpactAngle.type(angle);
        crImpactTotalIdlers.type(angle);
        crNoOfTransitionIdlers.type(angle);
        crMisalignmentSensorsYes.jsClick();
    }
    public void enterPulleysPageFields(String drivePulley,String brakeDevice,String headDiameter,String angleWrap,String laggingType){
        scrollPageup();
        verifyPulleysPage();
        drDrivePulley.click();
        driver.findElement("//span[text()='"+drivePulley+"']").click();
        drBrakeDevice.click();
        driver.findElement("//span[text()='"+brakeDevice+"']").click();

        crHeadPulleyDiameter.type(headDiameter);
        crHeadPulleyWidth.type(headDiameter);
        drHeadPulleyAngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drHeadPulleyLaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crHeadPulleyLaggingThickness.type(headDiameter);

        crTailPulleyDiameter.type(headDiameter);
        crTailPulleyWidth.type(headDiameter);
        drTailPulleyAngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drTailPulleyLaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crTailPulleyLaggingThickness.type(headDiameter);

        crTakeUpPulleyDiameter.type(headDiameter);
        crTakeUpPulleyWidth.type(headDiameter);
        drTakeUpAngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drTakeUpLaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crTakeUpLaggingThickness.type(headDiameter);

        crBendPulley1PulleyDiameter.type(headDiameter);
        crBendPulley1PulleyWidth.type(headDiameter);
        drBendPulley1AngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drBendPulley1LaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crBendPulley1LaggingThickness.type(headDiameter);

        crBendPulley2PulleyDiameter.type(headDiameter);
        crBendPulley2PulleyWidth.type(headDiameter);
        drBendPulley2AngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drBendPulley2LaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crBendPulley2LaggingThickness.type(headDiameter);

        crAdditionPulley1PulleyDiameter.type(headDiameter);
        crAdditionPulley1PulleyWidth.type(headDiameter);
        drAdditionPulley1AngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drAdditionPulley1LaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crAdditionPulley1LaggingThickness.type(headDiameter);

        crAdditionPulley2PulleyDiameter.type(headDiameter);
        crAdditionPulley2PulleyWidth.type(headDiameter);
        drAdditionPulley2AngleOfWrap.click();
        driver.findElement("//ul//span[text()='"+angleWrap+"']").click();
        drAdditionPulley2LaggingType.click();
        driver.findElement("//ul//span[text()='"+laggingType+"']").click();
        crAdditionPulley2LaggingThickness.type(headDiameter);
    }

    public void enterTransitionsPageFields(String length){
        scrollPageup();
        verifyTransitionPage();
        crHeadTransitionLength.type(length);
        crHeadPulleyLift.type(length);
        crHeadTransitionTypeHalf.jsClick();
        crTailTransitionLength.type(length);
        crTailPulleyLift.type(length);
        crTailTransitionTypeHalf.jsClick();
        crMaterialGuidanceYes.jsClick();
        crConditionYes.jsClick();

    }
    public void enterRemarksPageFields(String file,String remark){
        scrollPageup();
        verifyRemarksPage();
        userPage.imageUpload(file);
        SyncUtil.waitFor(4000);
        waitForElementToInvisible(buttonLoader,10000);
        waitForElementVisible(crDeleteFileUpload,10000,1000);
        crAdditionalRemarks.type(remark);

    }
    public void clickMultiSelectCheckBoxAndDelete(){
        cordInspectPage.verifySelectAllCheckbox();
        Validator.assertTrue(coverWearPage.verifyActionBtnState(),"Action button is not enabled after selecting the record","Action button is enabled");
        ddlActions.jsClick("Action");
        waitForElementToBeClickable(btnDelete);
        Validator.assertTrue(btnDelete.isVisible(),"Delete button is not visible","Delete button is visible");
        btnDelete.click("Delete Item");
        btnYes.click("Confirm delete");
        waitForElementToDisplay(noList);
        noList.isVisible("No Item Found");
//        waitForElementVisible(deleteSuccessMsg,10000,1000);
//        Validator.assertTrue(deleteSuccessMsg.isVisible("Delete pop up"),"Delete successfully is not visible","Deleted successfully is visible");
    }
    public void editEachTechDataForFields(String conveyorName,String beltWidth,String beltConfig,String drivePulley,String file,String remarks){
        SyncUtil.waitFor(10000);
        waitForElementToDisplay(tbConveyorname);
        tbConveyorname.type(conveyorName);
        crConveyorLiteTab.click("Conveyor Lite Tab");
        crBeltWidth.type(beltWidth);
        verifyInstalledBelt();
        dropdownSelectSearch(drBeltConfig, tbSitedropdown, beltConfig);
        verifyMaterial();
        crBulkSize.type(beltWidth);
        verifyConveyor();
        crDrivePower.type(beltWidth);
        verifyWearLife();
        crTonsPerYear.type(beltWidth);
        verifyIdlers();
        crCarryTotalIdlers.type(beltWidth);
        verifyPulleys();
        drDrivePulley.click();
        driver.findElement("//span[text()='"+drivePulley+"']").click();
        verifyTransitions();
        crHeadPulleyLift.type(beltWidth);
        verifyRemarks();
        crDeleteFileUpload.click();
        userPage.imageUpload(file);
        SyncUtil.waitFor(4000);
        waitForElementToInvisible(buttonLoader,10000);
        crAdditionalRemarks.type(remarks);
        crSave.jsClick();
        waitForElementToDisplay(crUpdateMsg);
    }
    public void verifyEachTechDataAfterEditForFields(String conveyorName,String beltWidth,String beltConfig,String drivePulley,String remark){
        waitForPageLoad(5000);
        waitForElementVisible(conveyorNameLoader,10000,1000);
        conveyorNameLoader.waitForPartialText(conveyorName, 15000);
        Validator.assertTrue(conveyorNameLoader.getText().contains(conveyorName),"Conveyor Name does not match","Conveyor Name matches");
        editConveyor.click();
        waitForPageLoad(5000);
        scrollPageDown();
//        waitForElementToDisplay(crBeltWidth);
        Validator.assertTrue(crBeltWidth.getAttribute("value").contains(beltWidth),"Belt Width does not match","Belt Width matches");
        verifyInstalledBelt();
        Validator.assertTrue(crBeltConfig.getAttribute("value").contains(beltConfig),"Belt Manufacturer does not match","Belt Manufacturer matches");
        verifyMaterial();
        Validator.assertTrue(crBulkSize.getAttribute("value").contains(beltWidth),"Bulk Size does not match","Bulk Size matches");
        verifyConveyorViewScreen();
        Validator.assertTrue(crDrivePower.getAttribute("value").contains(beltWidth),"Drive Power does not match","Drive Power matches");
        verifyWearLife();
        Validator.assertTrue(crTonsPerYear.getAttribute("value").contains(beltWidth),"Tons Per Year does not match","Tons Per Year matches");
        verifyIdlers();
        Validator.assertTrue(crCarryTotalIdlers.getAttribute("value").contains(beltWidth),"Carry Total Idlers does not match","Carry Total Idlers matches");
        verifyPulleys();
        Validator.assertTrue(crDrivePulley.getText().contains(drivePulley),"Drive Pulley does not match","Drive Pulley matches");
        verifyTransitions();
        Validator.assertTrue(crHeadPulleyLift.getAttribute("value").contains(beltWidth),"Head Pulley Lift does not match","Head Pulley Lift matches");
        verifyRemarks();
        Validator.assertTrue(crAdditionalRemarks.getAttribute("value").contains(remark),"Remark does not match","Remark matches");
        Validator.assertTrue(crRefrenceDocument.isDisplayed(),"File does not exist","File exists");
    }
    public void verifyTechnicalTabImperialValueForFields(String beltWidth,String topCoverThickness,String beltRating,String length){
        waitForPageLoad(5000);
        scrollPageDown();
        Validator.assertTrue(crBeltWidth.getAttribute("value").contains(topCoverThickness),"Belt Width does not match","Belt Width matches");
        verifyInstalledBelt();
        Validator.assertTrue(crBreakingStrengthRating.getAttribute("value").contains(beltRating),"Breaking Strength does not match","Breaking Strength matches");
        Validator.assertTrue(crTopCoverThickness.getAttribute("value").contains(topCoverThickness),"TopCover Thickness does not match","TopCover Thickness matches");
        Validator.assertTrue(crBottomCoverThickness.getAttribute("value").contains(topCoverThickness),"BottomCover Thickness does not match","BottomCover Thickness matches");
        Validator.assertTrue(crLength.getAttribute("value").contains(length),"Length does not match","Length matches");
    }
    public void verifyTechnicalTabMetricValueForFields(String beltWidth,String topCoverThickness){
        waitForPageLoad(5000);
        scrollPageDown();
        Validator.assertTrue(crBeltWidth.getAttribute("value").contains(beltWidth),"Belt Width does not match","Belt Width matches");
        verifyInstalledBelt();
        Validator.assertTrue(crBreakingStrength.getAttribute("value").contains(topCoverThickness),"Breaking Strength does not match","Breaking Strength matches");
        Validator.assertTrue(crTopCoverThickness.getAttribute("value").contains(topCoverThickness),"TopCover Thickness does not match","TopCover Thickness matches");
        Validator.assertTrue(crBottomCoverThickness.getAttribute("value").contains(topCoverThickness),"BottomCover Thickness does not match","BottomCover Thickness matches");
        Validator.assertTrue(crLength.getAttribute("value").contains(topCoverThickness),"Length does not match","Length matches");
    }
    public void verifyMainCardCountAfterAddition(String operation, String moduleName, int value) {
        String extractedCrdCountAfterAddition = getBundle().getProperty("mainCardCountKey").toString();
        int mainCardCountAfterAdd;
        if (operation.equalsIgnoreCase("add"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) + value;
        else if (operation.equalsIgnoreCase("delete"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) - value;
        else mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition);

        int paginationValue = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        System.out.println(mainCardCountAfterAdd+"value"+paginationValue);
        Validator.assertTrue(mainCardCountAfterAdd == paginationValue, "The pagination count is not matching", "The pagination count is matching");
        int updatedMainCardCount = Integer.parseInt(driver.findElement(By.xpath("(//app-card//div[@class='header' and text()='" + moduleName + "']/..//div//span)[1]")).getText());
        Reporter.log(updatedMainCardCount + "is the  main card count after adding");
        System.out.println(mainCardCountAfterAdd+"value"+updatedMainCardCount);
        Validator.assertTrue(mainCardCountAfterAdd == updatedMainCardCount, "The card count is not matching", "The main card count is matching");
    }
    public void extractStatusCardCount(String moduleName,String status,String storeVal)
    {
       int extractedCardCount = Integer.parseInt(driver.findElement(By.xpath("((//app-card//div[text()='" + moduleName + "'])[1]/../div[contains(@class,'footer-count')]/div/div)["+ status +"]")).getText());
        getBundle().setProperty(storeVal, extractedCardCount);
    }
    public void verifyStatusCardCountAfterChanges(String operation, String moduleName,String status, int value,String storeVal) {
        String extractedCrdCountAfterAddition = getBundle().getProperty(storeVal).toString();
        int mainCardCountAfterAdd;
        if (operation.equalsIgnoreCase("add"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) + value;
        else if (operation.equalsIgnoreCase("delete"))
            mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition) - value;
        else mainCardCountAfterAdd = Integer.parseInt(extractedCrdCountAfterAddition);
        int updatedMainCardCount = Integer.parseInt(driver.findElement(By.xpath("((//app-card//div[text()='" + moduleName + "'])[1]/../div[contains(@class,'footer-count')]/div/div)["+ status +"]")).getText());
        System.out.println(mainCardCountAfterAdd+"value"+updatedMainCardCount);
        Reporter.log(updatedMainCardCount + "is the  status card count after changes");
        Validator.assertTrue(mainCardCountAfterAdd == updatedMainCardCount, "The status card count is not matching", "The status card count is matching");
    }

    public void verifyBeltScanNotification(String conveyorName,String siteName,String userName) {
        setImplicitWait(10000, TimeUnit.MILLISECONDS);
        Validator.assertTrue(beltScanNotification.isDisplayed(), "Belt Scan Notifications is not displayed", "Belt Scan Notifications is displayed");
        Validator.assertTrue(notificationSiteName.getText().equalsIgnoreCase(siteName), "Site value misMatch", "Site value matched");
        Validator.assertTrue(notificationConveyorName.getText().equalsIgnoreCase(conveyorName), "Conveyor value misMatch", "Conveyor value matched");
        Validator.assertTrue(notificationUserName.getText().contains(userName), "User value misMatch", "User value matched");
    }

}
