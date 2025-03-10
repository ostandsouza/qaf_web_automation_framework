package com.web.pages;

import com.common.component.CustomElement;
import com.common.utils.MiscUtils;
import com.common.utils.PDFHelper;
import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;
import static java.lang.Double.parseDouble;

public class MinutemanPage extends BasePage{
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(locator = "xpath=(//li//span[text()='Home'])[1]")
    public CustomElement home;

    @FindBy(locator = "xpath=(//div[text()='Home']/../..//li//span[text()='Minuteman'])[1]")
    public CustomElement minuteman;

    @FindBy(locator = "xpath=//span[text()='Minuteman Calculations']")
    public CustomElement minutemanHeader;

    @FindBy(locator = "xpath=//span[contains(text(),'Showing')]")
    public CustomElement pagination;

    @FindBy(locator="xpath=//input[@placeholder='Search']")
    public CustomElement btSearchinput;

    @FindBy(locator = "xpath=(//span[@class='p-button-icon ctp-icon-Add-circle'])[2]")
    public CustomElement btnAdd;

    @FindBy(locator = "xpath=//span[text()='Conveyor']")
    public CustomElement btnConveyor;

    @FindBy(locator = "xpath=//span[text()='Elevator']")
    public CustomElement btnElevator;

    @FindBy(locator = "xpath=//input[@formcontrolname='calculationName']")
    public CustomElement tbCalculationName;

    @FindBy(locator = "xpath=//input[contains(@class,'p-dropdown-filter p-inputtext')]")
    public CustomElement dropdownInput;

    @FindBy(locator = "xpath=//p-dropdown[@datakey='companyId']//div[@role='button']")
    public CustomElement siteDropdown;

    @FindBy(locator = "xpath=//p-dropdown[@datakey='conveyorId']//div[@role='button']")
    public CustomElement conveyorDropdown;

    @FindBy(locator = "xpath=//textarea[@formcontrolname='description']")
    public CustomElement tbDescription;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='program']//span)[1]")
    public CustomElement tbProgram;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='location']//span)[1]")
    public CustomElement tbManufacturingLocation;

    @FindBy(locator = "xpath=//p-radiobutton[@value='imperial']")
    public CustomElement radioImperial;

    @FindBy(locator = "xpath=//p-radiobutton[@value='metric']")
    public CustomElement radioMetric;

    @FindBy(locator = "xpath=//p-radiobutton[@value='metric']//input")
    public CustomElement checkedRadioMetric;

    @FindBy(locator = "xpath=//p-radiobutton[@value='imperial']//input")
    public CustomElement checkedRadioImperial;


    @FindBy(locator = "xpath=//span[text()='Load Data']")
    public CustomElement btnLoadData;

    @FindBy(locator = "xpath=//span[text()='Cancel']")
    public CustomElement btnCancel;

    @FindBy(locator = "xpath=//span[text()='Save & Continue']")
    public CustomElement btnSaveAndContinue;

    @FindBy(locator = "xpath=//span[text()='Save & Close']")
    public CustomElement btnSaveAndClose;

    @FindBy(locator = "xpath=//span[text()='Save']")
    public CustomElement btnSave;

    @FindBy(locator = "xpath=//span[text()='Create']")
    public CustomElement btnCreate;

    @FindBy(locator = "xpath=//div[contains(@class,'p-toast-message-content')]")
    public CustomElement toastMsg;

    @FindBy(locator = "xpath=//span[text()='Next']")
    public CustomElement btnNext;

    @FindBy(locator = "xpath=//span[text()='Previous']")
    public CustomElement btnPrevious;

    @FindBy(locator = "xpath=//label[text()='Belt Width']/following-sibling::div//input")
    public CustomElement tbBeltWidth;

    @FindBy(locator = "xpath=//label[text()='Pick Material Name']/following-sibling::app-master-data-picker//input")
    public CustomElement tbPickMaterialName;

    @FindBy(locator = "xpath=//label[text()='Pick Material Name']/following-sibling::app-master-data-picker//chevrondownicon")
    public CustomElement tbPickMaterialDropdown;

    @FindBy(locator= "xpath=//input[contains(@class,'p-dropdown-filter')]")
    public CustomElement tbDeviceTypedropdown;

    @FindBy(locator = "xpath=//label[text()='Drive Wrap Angle']/following-sibling::app-master-data-picker//div[@role='button']")
    public CustomElement driveWrapAngleDropdown;

    @FindBy(locator = "xpath=//label[text()='Drive Wrap Angle']/following-sibling::app-master-data-picker//span")
    public CustomElement tbDriveWrapAngle;

    @FindBy(locator = "xpath=//label[text()='Surcharge Angle']/following-sibling::app-master-data-picker//div[@role='button']")
    public CustomElement surchargeAngleDropdown;

    @FindBy(locator = "xpath=//label[text()='Surcharge Angle']/following-sibling::app-master-data-picker//span")
    public CustomElement tbSurchargeAngle;

    @FindBy(locator = "xpath=//label[text()='Idler Offset Type']/following-sibling::app-master-data-picker//div[@role='button']")
    public CustomElement idlerOffsetTypeDropdown;

    @FindBy(locator = "xpath=//label[text()='Idler Offset Type']/following-sibling::app-master-data-picker//input")
    public CustomElement tbIdlerOffsetType;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='drivePulleySurface']//span")
    public CustomElement driveDetailsDropdown;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='takeupType']//span")
    public CustomElement takeUpDetailsDropdown;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='spliceInformation']//span")
    public CustomElement spliceTypeDropdown;

    @FindBy(locator = "xpath=//input[@formcontrolname='beltSpeed']")
    public CustomElement tbBeltSpeed;

    @FindBy(locator = "xpath=//input[@formcontrolname='tonsPerHourPeak']")
    public CustomElement tbTonsPerHourPeak;

    @FindBy(locator = "xpath=//input[@formcontrolname='materialDensity']")
    public CustomElement tbMaterialDensity;

    @FindBy(locator = "xpath=//input[@formcontrolname='angleOfIdlers']")
    public CustomElement tbAngleOfIdlers;

    @FindBy(locator = "xpath=//input[@formcontrolname='transitionHeadLength']")
    public CustomElement tbTransitionHeadLength;

    @FindBy(locator = "xpath=//input[@formcontrolname='carryingIdlerSpacing']")
    public CustomElement tbCarrySideIdlerSpacing;

    @FindBy(locator = "xpath=//input[@formcontrolname='driveWrapAngle']")
    public CustomElement tbDriveWrapAngle2;

    @FindBy(locator = "xpath=//input[@formcontrolname='takeupTension']")
    public CustomElement tbTakeUpTension;

    @FindBy(locator = "xpath=//p-radiobutton[@inputid='permanentConveyors']")
    public CustomElement radioPermanentConveyor;

    @FindBy(locator = "xpath=//p-radiobutton[@inputid='permanentConveyors']//input")
    public CustomElement checkedRadioPermanent;

    @FindBy(locator = "xpath=//p-radiobutton[@inputid='temporaryConveyors']")
    public CustomElement radioTemporaryConveyor;

    @FindBy(locator = "xpath=//input[@formcontrolname='frictionFactor']")
    public CustomElement tbFrictionFactorValue;

    @FindBy(locator = "xpath=//input[@formcontrolname='lengthFactor']")
    public CustomElement tbLengthFactorValue;

    @FindBy(locator = "xpath=//p-checkbox[@formcontrolname='station']")
    public CustomElement checkBoxStation;

    @FindBy(locator = "xpath=//p-radiobutton[@formcontrolname='drive']")
    public CustomElement radioDrive;

    @FindBy(locator = "xpath=//p-radiobutton[@formcontrolname='takeup']")
    public CustomElement radioTakeUp;

    @FindBy(locator = "xpath=//input[@formcontrolname='horizontalOffsets']")
    public CustomElement tbHorzOffset;

    @FindBy(locator = "xpath=//input[@formcontrolname='elevationOffsets']")
    public CustomElement tbElevOffset;

    @FindBy(locator = "xpath=//input[@formcontrolname='sectionAngles']")
    public CustomElement tbSectionAngles;

    @FindBy(locator = "xpath=//input[@class='p-inputtext p-component p-element p-filled']")
    public CustomElement tbEstimatedCCLength;

    @FindBy(locator = "xpath=//app-master-data-picker//div[@role='button']")
    public CustomElement typeOfConfigurationDropdown;

    @FindBy(locator = "xpath=(//app-master-data-picker//input)[2]")
    public CustomElement tbTypeOfConfiguration;

    @FindBy(locator = "xpath=//span[text()='Calculate']")
    public CustomElement btnCalculate;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltName']//span)[1]")
    public CustomElement tradeNameDropdown;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltCovergrade']//span)[1]")
    public CustomElement coverGradeDropdown;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltRating']//span)[1]")
    public CustomElement ratingDropdown;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltPlies']//span)[1]")
    public CustomElement pliesDropdown;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname='beltCoverGaugeUnit']//span[1]")
    public CustomElement coverGaugeUnitDropdown;

    @FindBy(locator = "xpath=(//app-master-data-picker[@parentmasterformcontrolname='beltTopCoverGauge']//span)[1]")
    public CustomElement gaugeTopCoverDropdown;

    @FindBy(locator = "xpath=(//app-master-data-picker[@parentmasterformcontrolname='beltPulleyCoverGauge']//span)[1]")
    public CustomElement gaugePulleyCoverDropdown;

    @FindBy(locator = "xpath=//label[text()='Unit Tension']/following-sibling::span")
    public CustomElement textUnitTension;

    @FindBy(locator = "xpath=//label[text()='Maximum Tension']/following-sibling::span[1]")
    public CustomElement textMaximumTension;

    @FindBy(locator = "xpath=//label[text()='Maximum PIW']/following-sibling::span[1]")
    public CustomElement textMaximumPIW;

    @FindBy(locator = "xpath=//label[text()='Effective Tension']/following-sibling::span[1]")
    public CustomElement textEffectiveTension;

    @FindBy(locator = "xpath=//label[text()='Belt Power']/following-sibling::span")
    public CustomElement textBeltPower;

    @FindBy(locator = "xpath=//label[text()='Counterweight Weight']/following-sibling::span[1]")
    public CustomElement textCounterweightWeight;

    @FindBy(locator = "xpath=//label[text()='Counterweight Tension']/following-sibling::span[1]")
    public CustomElement textCounterweightTension;

    @FindBy(locator = "xpath=//label[text()='Weight in Each Bucket']/following-sibling::span[1]")
    public CustomElement textWeightEachBucket;

    @FindBy(locator = "xpath=//label[text()='Percent Loaded']/following-sibling::span[1]")
    public CustomElement textPercentLoaded;

    @FindBy(locator = "xpath=//label[text()='Conveyor Capacity']/following-sibling::span[1]")
    public CustomElement textConveyorCapacity;

    @FindBy(locator = "xpath=//div[contains(text(),'Conveyor Capacity')]")
    public CustomElement textCapacityPageConveyorCapacity;

    @FindBy(locator = "//div[contains(text(),'Angle of Idlers')]")
    public CustomElement textCapacityPageAngleOfIdlers;

    @FindBy(locator = "xpath=(//span[text()='Reset'])[1]")
    public CustomElement btnResetBeltSpeed;

    @FindBy(locator = "xpath=(//span[text()='Reset'])[2]" )
    public CustomElement btnResetTonsPerHourPeak;

    @FindBy(locator = "xpath=(//span[text()='100%'])[1]")
    public CustomElement btn100PercentageBeltSpeed;

    @FindBy(locator = "xpath=(//span[text()='100%'])[2]")
    public CustomElement btn100PercentageTonsPerHourPeak;

    @FindBy(locator = "xpath=(//span[text()='Calculate'])[1]")
    public CustomElement btnCalculateBeltSpeed;

    @FindBy(locator = "xpath=(//span[text()='Calculate'])[2]")
    public CustomElement btnCalculateTonsPerHourPeak;

    @FindBy(locator = "xpath=//label[text()='Belt Specification']/following-sibling::input")
    public CustomElement tbBeltSpecification;

    @FindBy(locator = "xpath=//label[text()='Carcass Material']/following-sibling::input")
    public CustomElement tbCarcassMaterial;

    @FindBy(locator = "xpath=//label[text()='Number of Plies']/following-sibling::input")
    public CustomElement tbNumberOfPlies;

    @FindBy(locator = "xpath=//label[text()='Ply Tensile Strength']/following-sibling::div/input")
    public CustomElement tbPlyTensileStrength;

    @FindBy(locator = "xpath=//label[text()='Belt Tensile Strength ']/following-sibling::div/input")
    public CustomElement tbBeltTensileStrength;

    @FindBy(locator = "xpath=//label[text()='Elastic Modules']/following-sibling::div/input")
    public CustomElement tbElasticModules;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Rating']/following-sibling::div/input")
    public CustomElement tbVulcanizedRating;

    @FindBy(locator = "xpath=//label[text()='Mechanical Rating']/following-sibling::div/input")
    public CustomElement tbMechanicalRating;

    @FindBy(locator = "xpath=//label[text()='Carcass Gauge']/following-sibling::div/input")
    public CustomElement tbCarcassGauge;

    @FindBy(locator = "xpath=//label[text()='Total Cover Gauge']/following-sibling::div/input")
    public CustomElement tbTotalCoverGauge;

    @FindBy(locator ="xpath=//label[text()='Total Belt Gauge']/following-sibling::div/input" )
    public CustomElement tbTotalBeltGauge;

    @FindBy(locator = "xpath=//label[text()='Carcass Weight']/following-sibling::div/input")
    public CustomElement tbCarcassWeight;

    @FindBy(locator = "xpath=//label[text()='Total Cover Weight']/following-sibling::div/input")
    public CustomElement tbTotalCoverWeight;

    @FindBy(locator = "xpath=//label[text()='Total Belt Weight']/following-sibling::div/input")
    public CustomElement tbTotalBeltWeight;

    @FindBy(locator = "xpath=//label[text()='Total Belt Length']/following-sibling::div/input")
    public CustomElement tbTotalBeltLength;

    @FindBy(locator = "xpath=//label[text()='Number of Rolls']/following-sibling::input")
    public CustomElement tbNumberOfRollsConveyorRollData;

    @FindBy(locator = "xpath=//label[text()='Roll Length (each)']/following-sibling::div/input")
    public CustomElement tbRollLength;

    @FindBy(locator = "xpath=//label[text()='Roll Diameter']/following-sibling::div/input")
    public CustomElement tbRollDiameter;

    @FindBy(locator = "xpath=//label[text()='Roll Weight']/following-sibling::div/input")
    public CustomElement tbRollWeight;

    @FindBy(locator = "xpath=//label[text()='Cubage']/following-sibling::div/input")
    public CustomElement tbCubage;

    @FindBy(locator = "xpath=//span[text()='Reset']")
    public CustomElement btnReset;

    @FindBy(locator = "xpath=//label[text()='Number of Rolls']/following-sibling::div/input")
    public CustomElement tbNumberOfRollsConveyorSpliceDimensions;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Angle']/following-sibling::div/input")
    public CustomElement tbVulcanizedSpliceAngle;

    @FindBy(locator = "xpath=//label[text()='Step Length']/following-sibling::div/input")
    public CustomElement tbStepLength;

    @FindBy(locator = "xpath=//label[text()='Bias Length']/following-sibling::div/input")
    public CustomElement tbBiasLength;

    @FindBy(locator = "xpath=//label[text()='Splice Length']/following-sibling::div/input")
    public CustomElement tbSpliceLength;

    @FindBy(locator = "xpath=//label[text()='Extra Belt Length']/following-sibling::div/input")
    public CustomElement tbExtraBeltLength;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[1]")
    public CustomElement tbStationNumberHead;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[2]")
    public CustomElement tbStationNumberDrive;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[3]")
    public CustomElement tbStationNumberTakeUp;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[4]")
    public CustomElement tbStationNumberTail;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[5]")
    public CustomElement tbBeltTensionHead;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[6]")
    public CustomElement tbBeltTensionDrive;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[7]")
    public CustomElement tbBeltTensionTakeUp;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[8]")
    public CustomElement tbBeltTensionTail;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[9]")
    public CustomElement tbMinPulleyDiameterHead;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[10]")
    public CustomElement tbMinPulleyDiameterDrive;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[11]")
    public CustomElement tbMinPulleyDiameterTakeUp;

    @FindBy(locator = "xpath=(//input[@class='p-inputtext p-component p-element p-filled'])[12]")
    public CustomElement tbMinPulleyDiameterTail;

    @FindBy(locator = "xpath=//input[@formcontrolname='pulleyHeadDiameter']")
    public CustomElement tbPulleyHeadDiameter;

    @FindBy(locator = "xpath=//input[@formcontrolname='pulleyDriveDiameter']")
    public CustomElement tbPulleyDriveDiameter;

    @FindBy(locator = "xpath=//input[@formcontrolname='pulleyTakeupDiameter']")
    public CustomElement tbPulleyTakeUpDiameter;

    @FindBy(locator = "xpath=//input[@formcontrolname='pulleyTailDiameter']")
    public CustomElement tbPulleyTailDiameter;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[1]")
    public CustomElement tbBeltTensionHeadTransitionLengthPage;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[2]")
    public CustomElement tbBeltTensionTailTransitionLengthPage;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[3]")
    public CustomElement tbIdlerAngleHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[4]")
    public CustomElement tbIdlerAngleTail;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[5]")
    public CustomElement tbTroughDepthHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[6]")
    public CustomElement tbTroughDepthTail;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[7]")
    public CustomElement tbLengthHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[8]")
    public CustomElement tbLengthTail;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[9]")
    public CustomElement tbEdgeTensionHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[10]")
    public CustomElement tbEdgeTensionTail;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[11]")
    public CustomElement tbEdgeTensionHeadPercentage;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[12]")
    public CustomElement tbEdgeTensionTailPercentage;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[13]")
    public CustomElement tbCenterTensionHead;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[14]")
    public CustomElement tbCenterTensionTail;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[15]")
    public CustomElement tbCenterTensionHeadPercentage;

    @FindBy(locator = "xpath=(//div[@class='p-inputgroup']/input)[16]")
    public CustomElement tbCenterTensionTailPercentage;

    @FindBy(locator = "xpath=//app-transition//p")
    public CustomElement textMinimumAndMaximumOfBeltRatedTension;

    @FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='transitionHeadTroughDepthType'])[1]")
    public CustomElement radioTransitionHeadTroughDepthFull;

    @FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='transitionHeadTroughDepthType'])[2]")
    public CustomElement radioTransitionHeadTroughDepthHalf;

    @FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='transitionTailTroughDepthType'])[1]")
    public CustomElement radioTransitionTailTroughDepthFull;

    @FindBy(locator = "xpath=(//p-radiobutton[@formcontrolname='transitionTailTroughDepthType'])[2]")
    public CustomElement radioTransitionTailTroughDepthHalf;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[1]")
    public CustomElement tbTakeUpTensionTakeUpLevel;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[2]")
    public CustomElement tbCounterWeight;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[5]")
    public CustomElement tbMaximumBeltTension;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[6]")
    public CustomElement tbAverageBeltTension;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[7]")
    public CustomElement tbEstimatedTakeUpMovementDueToPermanentElongation;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[8]")
    public CustomElement tbEstimatedTakeUpMovementDueToElasticElongation;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[9]")
    public CustomElement tbTotalEstimatedTakeUpMovementPercentage;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[10]")
    public CustomElement tbEstimatedBeltCCLength;

    @FindBy(locator = "xpath=(//div[@class='col-4']//input)[11]")
    public CustomElement tbTotalEstimatedTakeUpMovement;

    @FindBy(locator = "xpath=//input[@formcontrolname='takeupTension']")
    public CustomElement tbTakeUpTensionifknown;

    @FindBy(locator = "xpath=//p-radiobutton[@value='V']")
    public CustomElement radioVulcanizedTypeOfSplice;

    @FindBy(locator = "xpath=//p-radiobutton[@value='V']//input")
    public CustomElement checkedRadioVulcanized;

    @FindBy(locator = "xpath=//p-radiobutton[@value='M']")
    public CustomElement radioMechanicalTypeOfSplice;

    @FindBy(locator = "xpath=//p-radiobutton[@value='M']//input")
    public CustomElement checkedRadioMechanical;

    @FindBy(locator = "xpath=(//input[@type='text'])[1]")
    public CustomElement tbStationLocation1;

    @FindBy(locator = "xpath=(//input[@type='text'])[2]")
    public CustomElement tbStationLocation2;

    @FindBy(locator = "xpath=(//input[@type='text'])[3]")
    public CustomElement tbStationLocation3;

    @FindBy(locator = "xpath=(//input[@type='text'])[4]")
    public CustomElement tbStationLocation4;

    @FindBy(locator = "xpath=(//input[@type='text'])[5]")
    public CustomElement tbCurveDescription1;

    @FindBy(locator = "xpath=(//input[@type='text'])[6]")
    public CustomElement tbCurveDescription2;

    @FindBy(locator = "xpath=(//input[@type='text'])[7]")
    public CustomElement tbCurveDescription3;

    @FindBy(locator = "xpath=(//input[@type='text'])[8]")
    public CustomElement tbCurveDescription4;

    @FindBy(locator = "xpath=(//input[@type='text'])[9]")
    public CustomElement tbMaximumBeltTension1;

    @FindBy(locator = "xpath=(//input[@type='text'])[10]")
    public CustomElement tbMaximumBeltTension2;

    @FindBy(locator = "xpath=(//input[@type='text'])[11]")
    public CustomElement tbMaximumBeltTension3;

    @FindBy(locator = "xpath=(//input[@type='text'])[12]")
    public CustomElement tbMaximumBeltTension4;

    @FindBy(locator = "xpath=(//input[@type='text'])[13]")
    public CustomElement tbMinimumBeltTension1;

    @FindBy(locator = "xpath=(//input[@type='text'])[14]")
    public CustomElement tbMinimumBeltTension2;

    @FindBy(locator = "xpath=(//input[@type='text'])[15]")
    public CustomElement tbMinimumBeltTension3;

    @FindBy(locator = "xpath=(//input[@type='text'])[16]")
    public CustomElement tbMinimumBeltTension4;

    @FindBy(locator = "xpath=(//input[@type='text'])[17]")
    public CustomElement tbCurveRadius1;

    @FindBy(locator = "xpath=(//input[@type='text'])[18]")
    public CustomElement tbCurveRadius2;

    @FindBy(locator = "xpath=(//input[@type='text'])[19]")
    public CustomElement tbCurveRadius3;

    @FindBy(locator = "xpath=(//input[@type='text'])[20]")
    public CustomElement tbCurveRadius4;

    @FindBy(locator = "xpath=(//input[@type='text'])[21]")
    public CustomElement tbProjectedLength1;

    @FindBy(locator = "xpath=(//input[@type='text'])[22]")
    public CustomElement tbProjectedLength2;

    @FindBy(locator = "xpath=(//input[@type='text'])[23]")
    public CustomElement tbProjectedLength3;

    @FindBy(locator = "xpath=(//input[@type='text'])[24]")
    public CustomElement tbProjectedLength4;

    @FindBy(locator = "xpath=(//input[@type='text'])[25]")
    public CustomElement tbCenterTension1;

    @FindBy(locator = "xpath=(//input[@type='text'])[26]")
    public CustomElement tbCenterTension2;

    @FindBy(locator = "xpath=(//input[@type='text'])[27]")
    public CustomElement tbCenterTension3;

    @FindBy(locator = "xpath=(//input[@type='text'])[28]")
    public CustomElement tbCenterTension4;

    @FindBy(locator = "xpath=(//input[@type='text'])[29]")
    public CustomElement tbCenterTensionPercentage1;

    @FindBy(locator = "xpath=(//input[@type='text'])[30]")
    public CustomElement tbCenterTensionPercentage2;

    @FindBy(locator = "xpath=(//input[@type='text'])[31]")
    public CustomElement tbCenterTensionPercentage3;

    @FindBy(locator = "xpath=(//input[@type='text'])[32]")
    public CustomElement tbCenterTensionPercentage4;

    @FindBy(locator = "xpath=(//input[@type='text'])[33]")
    public CustomElement tbEdgeTension1;

    @FindBy(locator = "xpath=(//input[@type='text'])[34]")
    public CustomElement tbEdgeTension2;

    @FindBy(locator = "xpath=(//input[@type='text'])[35]")
    public CustomElement tbEdgeTension3;

    @FindBy(locator = "xpath=(//input[@type='text'])[36]")
    public CustomElement tbEdgeTension4;

    @FindBy(locator = "xpath=(//input[@type='text'])[37]")
    public CustomElement tbEdgeTensionPercentage1;

    @FindBy(locator = "xpath=(//input[@type='text'])[38]")
    public CustomElement tbEdgeTensionPercentage2;

    @FindBy(locator = "xpath=(//input[@type='text'])[39]")
    public CustomElement tbEdgeTensionPercentage3;

    @FindBy(locator = "xpath=(//input[@type='text'])[40]")
    public CustomElement tbEdgeTensionPercentage4;

    @FindBy(locator = "xpath=(//input[@type='text'])[41]")
    public CustomElement tbEstimatedLiftOff1;

    @FindBy(locator = "xpath=(//input[@type='text'])[42]")
    public CustomElement tbEstimatedLiftOff2;

    @FindBy(locator = "xpath=(//input[@type='text'])[43]")
    public CustomElement tbEstimatedLiftOff3;

    @FindBy(locator = "xpath=(//input[@type='text'])[44]")
    public CustomElement tbEstimatedLiftOff4;

    @FindBy(locator = "xpath=//div[contains(text(),'Estimated C-C Length')]")
    public CustomElement txtEstimatedCCLength;

    @FindBy(locator = "xpath=(//div[text()='Conveyor Information']/following-sibling::div[1]//span)[1]")
    public CustomElement txtCustomer;

    @FindBy(locator = "xpath=(//div[text()='Conveyor Information']/following-sibling::div[1]//span)[2]")
    public CustomElement txtConveyor;

    @FindBy(locator = "xpath=//div[text()='Conveyor Information']/following-sibling::div[2]")
    public CustomElement txtDescription;

    @FindBy(locator = "xpath=//label[text()='Material Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtMaterialDataTonsPerHr;

    @FindBy(locator = "xpath=//label[text()='Material Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtMaterialDataMaterialDensity;

    @FindBy(locator = "xpath=//label[text()='Material Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtMaterialDataSurchargeAngle;

    @FindBy(locator = "xpath=//label[text()='Input Belt Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtInputBeltDataWidth;

    @FindBy(locator = "xpath=//label[text()='Input Belt Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtInputBeltDataSpeed;

    @FindBy(locator = "xpath=//label[text()='Input Belt Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtInputBeltDataWeight;

    @FindBy(locator = "xpath=//label[text()='Input Belt Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtInputBeltDataOAG;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtSystemData;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtSystemDataAngleOfIdlers;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtSystemDataCarrySideIdlerSpacing;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtSystemDataStationLocationDrive;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtSystemDataStationLocationTakeUp;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[5]/div[2]")
    public CustomElement txtSystemDataWeightOfMovingParts;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[6]/div[2]")
    public CustomElement txtSystemDataDriveFactor;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[7]/div[2]")
    public CustomElement txtSystemDataFrictionFactor;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[8]/div[2]")
    public CustomElement txtSystemDataLengthFactor;

    @FindBy(locator = "xpath=//label[text()='System Data']/following-sibling::div[9]/div[2]")
    public CustomElement txtSystemDataDriveWrap;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtCalculateDataUnitTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtCalculateDataMaximumTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtCalculateDataEffectiveTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtCalculateDataBeltPower;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[5]/div[2]")
    public CustomElement txtCalculateDataCounterWeightW;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[6]/div[2]")
    public CustomElement txtCalculateDataCounterWeightTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[7]/div[2]")
    public CustomElement txtCalculateDataConveyorCapacity;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::div[8]/div[2]")
    public CustomElement txtCalculateDataEstimatedBeltLength;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtBeltDataCarcassMaterial;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtBeltDataNoOfPlies;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtBeltDataPlyTensileStrength;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtBeltDataBeltTensileStrength;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[5]/div[2]")
    public CustomElement txtBeltDataVulcanizedRating;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[6]/div[2]")
    public CustomElement txtBeltDataMechanicalRating;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[7]/div[2]")
    public CustomElement txtBeltDataElasticModulus;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[8]/div[2]")
    public CustomElement txtBeltDataCarcassGauge;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[9]/div[2]")
    public CustomElement txtBeltDataCoverGauge;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[10]/div[2]")
    public CustomElement txtBeltDataBeltGauge;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[11]/div[2]")
    public CustomElement txtBeltDataCarcassWeight;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[12]/div[2]")
    public CustomElement txtBeltDataCoverWeight;

    @FindBy(locator = "xpath=//label[text()='Belt Data']/following-sibling::div[13]/div[2]")
    public CustomElement txtBeltDataTotalBeltWeight;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtRollDataTotalBeltLength;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtRollDataNoOfRolls;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtRollDataRollLength;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtRollDataRollDiameter;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[5]/div[2]")
    public CustomElement txtRollDataRollWeight;

    @FindBy(locator = "xpath=//label[text()='Roll Data']/following-sibling::div[6]/div[2]")
    public CustomElement txtRollDataCubage;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[1]/div[2]")
    public CustomElement txtVulcanizedSpliceDataNoOfSplice;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[2]/div[2]")
    public CustomElement txtVulcanizedSpliceDataVulcanizerBiasAngle;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[3]/div[2]")
    public CustomElement txtVulcanizedSpliceDataFabricStepLength;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[4]/div[2]")
    public CustomElement txtVulcanizedSpliceDataBiasLength;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[5]/div[2]")
    public CustomElement txtVulcanizedSpliceDataSpliceLength;

    @FindBy(locator = "xpath=//label[text()='Vulcanized Splice Data']/following-sibling::div[6]/div[2]")
    public CustomElement txtVulcanizedSpliceDataExtraBeltLength;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[1]/div[2]")
    public CustomElement txtTakeUpTravelTypeOfTakeUp;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[2]/div[2]")
    public CustomElement txtTakeUpTravelTypeOfSplice;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[3]/div[2]")
    public CustomElement txtTakeUpTravelMaximumBeltTension;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[4]/div[2]")
    public CustomElement txtTakeUpTravelAverageBeltTension;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[6]/div[2]")
    public CustomElement txtTakeUpTravelTakeUpMovementPermanent;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[8]/div[2]")
    public CustomElement txtTakeUpTravelTakeUpMovementElastic;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[9]/div[2]")
    public CustomElement txtTakeUpTravelEstimatedTakeUpMovementPercentage;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[10]/div[2]")
    public CustomElement txtTakeUpTravelConveyorLength;

    @FindBy(locator = "xpath=//label[text()='Take-Up Travel']/following-sibling::div[11]/div[2]")
    public CustomElement txtTakeUpTravelEstimatedTakeUpMovement;

    @FindBy(locator = "xpath=//label[text()='Vertical Curves']/following-sibling::table/tr[1]/td[2]")
    public CustomElement txtVerticalCurves;

    @FindBy(locator = "xpath=//label[text()='Transition Lengths']/following-sibling::table/tr[2]/td[2]")
    public CustomElement txtTransitionLength;

    @FindBy(locator = "xpath=//div[@class='p-progress-spinner']")
    public CustomElement spinner;

    @FindBy(locator = "xpath=//p-skeleton")
    public CustomElement skeleton;

    @FindBy(locator ="tagName=canvas")
    public CustomElement canvas;

    @FindBy(locator = "xpath=//span[text()='1']")
    public CustomElement generalInfo;

    @FindBy(locator = "xpath=//span[text()='2']")
    public CustomElement inputs;

    @FindBy(locator = "xpath=//span[text()='3']")
    public CustomElement stations;

    @FindBy(locator = "xpath=//span[text()='4']")
    public CustomElement flightInfo;

    @FindBy(locator = "xpath=//span[text()='5']")
    public CustomElement selectBelt;

    @FindBy(locator = "xpath=//span[text()='6']")
    public CustomElement capacity;

    @FindBy(locator = "xpath=//span[text()='7']")
    public CustomElement rollData;

    @FindBy(locator = "xpath=//span[contains(text(),'8')]")
    public CustomElement pulleys;

    @FindBy(locator = "xpath=//span[contains(text(),'9')]")
    public CustomElement transitions;

    @FindBy(locator = "xpath=//span[contains(text(),'10')]")
    public CustomElement takeUp;

    @FindBy(locator = "xpath=//span[contains(text(),'11')]")
    public CustomElement curves;

    @FindBy(locator = "xpath=//span[contains(text(),'12')]")
    public CustomElement finalReport;

    @FindBy(locator = "xpath=//label[text()='System Coordinates']/following-sibling::div[3]//div[@class='col-2']/div")
    public CustomElement systemCoordinates;

    @FindBy(locator = "xpath=//label[text()='Pulley Data']/following-sibling::table/tr[2]/td[2]")
    public CustomElement pulleyData;

    @FindBy(locator = "xpath=//span[text()='Create & Download']")
    public CustomElement btnSaveAndDownload;

    @FindBy(locator = "xpath=//span[text()='Download']")
    public CustomElement btnDownload;

    @FindBy(locator="xpath=(//td//p-tablecheckbox)[1]")
    public CustomElement crCheckbox;

    @FindBy(locator="xpath=(//button/chevrondownicon)[2]")
    public CustomElement crActions;

    @FindBy(locator="xpath=//li//span[text()='Edit']")
    public CustomElement crEdit;

    @FindBy(locator="xpath=//span[text()='Delete']")
    public CustomElement crDelete;

    @FindBy(locator = "xpath=//li/a/span[text()='Edit']")
    public CustomElement editBreadCrumb;

    @FindBy(locator="xpath=//button[contains(@class,'p-button-loading')]")
    public CustomElement buttonLoader;

    @FindBy(locator = "xpath=//span[text()='Yes']")
    public CustomElement crYesConfirmation;

    @FindBy(locator = "xpath=//td[contains(text(),'No')]")
    public CustomElement noList;

    @FindBy(locator = "xpath=//label[text()='Stations - Please chose the number of Stations, Drives and Take-ups']")
    public CustomElement stationLabel;

    @FindBy(locator = "xpath=//label[text()='Conveyor Profile']")
    public CustomElement flightHeader;

    @FindBy(locator = "xpath=//div[text()='Select Conveyor Belt']")
    public CustomElement selectBeltHeader;

    @FindBy(locator = "xpath=//div[text()='Capacity']")
    public CustomElement capacityHeader;

    @FindBy(locator = "xpath=//label[text()='Conveyor Belt Data']")
    public CustomElement rollDataHeader;

    @FindBy(locator = "xpath=//label[text()='Review Calculated Pulley']")
    public CustomElement pulleyHeader;

    @FindBy(locator = "xpath=//label[text()='Review Calculated Transition Length']")
    public CustomElement transactionHeader;

    @FindBy(locator = "xpath=//label[text()='Review Calculated Take-Up Travel']")
    public CustomElement takeUpHeader;

    @FindBy(locator = "xpath=//label[text()='Review Calculated Vertical Curves']")
    public CustomElement curvesHeader;

    @FindBy(locator="xpath=//span[text()='No']")
    public CustomElement unitNo;

    @FindBy(locator="xpath=//span[text()='Yes']")
    public CustomElement unitYes;

    @FindBy(locator="xpath=//span[text()='Changing the unit of measure will reset the form with default values. Are you sure you want to change it?']")
    public CustomElement unitsPopup;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='conveyorType']//span)[1]")
    public CustomElement tbConveyorType;

    @FindBy(locator = "xpath=//p-dropdown[@formcontrolname=\"conveyorType\"]/../../following-sibling::div//span")
    public CustomElement conveyorTypeText;

    @FindBy(locator = "xpath=(//label[text()='Density']/following-sibling::div//input)[1]")
    public CustomElement tbDensity;

    @FindBy(locator = "xpath=(//label[text()='Material/hr']/following-sibling::div//input)[1]")
    public CustomElement tbTonPerHrPeak;

    @FindBy(locator = "xpath=//input[@formcontrolname='materialPerHour']")
    public CustomElement tbMaterialPerHrPeak;

    @FindBy(locator = "xpath=(//label[text()='Length']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialLength;

    @FindBy(locator = "xpath=(//label[text()='Projection']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialProjection;

    @FindBy(locator = "xpath=(//label[text()='C-C Spacing']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialSpacing;

    @FindBy(locator = "xpath=(//label[text()='Weight']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialWeight;

    @FindBy(locator = "xpath=(//label[text()='Volume']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialVolume;

    @FindBy(locator = "xpath=(//label[text()='No. of Rows']/following-sibling::div//input)[1]")
    public CustomElement tbBucketRows;

    @FindBy(locator = "xpath=(//label[text()='Width']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialWidth;

    @FindBy(locator = "xpath=(//label[text()='Height']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialHeight;

    @FindBy(locator = "xpath=(//label[text()='Speed']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialSpeed;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltDrivePulley']//span)[1]")
    public CustomElement tbDrivePulley;

    @FindBy(locator = "xpath=(//p-dropdown[@formcontrolname='beltTakeupType']//span)[1]")
    public CustomElement tbTakeUpType;

    @FindBy(locator = "xpath=(//label[text()='Maximum Tension']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialTension;

    @FindBy(locator = "xpath=(//label[text()='Maximum PIW']/following-sibling::div//input)[1]")
    public CustomElement tbMaterialPIW;

    @FindBy(locator = "xpath=(//label[text()='Effective Tension']/following-sibling::div//input)[1]")
    public CustomElement tbEffectiveTension;

    @FindBy(locator = "xpath=(//label[text()='Belt Horsepower']/following-sibling::div//input)[1]")
    public CustomElement tbBeltHorsepower;

    @FindBy(locator = "xpath=(//label[text()='Percent Loaded ']/following-sibling::div//input)[1]")
    public CustomElement tbPercentLoaded;

    @FindBy(locator = "xpath=(//label[text()='Counterweight Tension']/following-sibling::div//input)[1]")
    public CustomElement tbCounterweightTensionn;

    @FindBy(locator = "xpath=(//label[text()='Counterweight Weight']/following-sibling::div//input)[1]")
    public CustomElement tbCounterweightWeight;

    @FindBy(locator = "xpath=(//label[text()='Weight in Each Bucket']/following-sibling::div//input)[1]")
    public CustomElement tbEachBucketWeight;

    @FindBy(locator = "xpath=(//label[text()='Min Head Pulley Diameter']/following-sibling::div//input)[1]")
    public CustomElement tbHeadPulleyDeameter;

    @FindBy(locator = "xpath=(//label[text()='Min Tail Pulley Diameter']/following-sibling::div//input)[1]")
    public CustomElement tbTailPulleyDiaeter;

    @FindBy(locator = "xpath=(//label[text()='Maximum Projection']/following-sibling::div//input)[1]")
    public CustomElement tbMaximumProjection;

    @FindBy(locator = "xpath=(//label[text()='Approximate Number']/following-sibling::div//input)[1]")
    public CustomElement tbApproximateNumber;

    @FindBy(locator = "xpath=//div[text()='Conveyor Information']/following-sibling::div/table/tr/td[1]")
    public CustomElement txtElevatorCustomer;

    @FindBy(locator = "xpath=//p-dropdown[@datakey='conveyorId']/div")
    public CustomElement conveyorDropdownStatus;

    @FindBy(locator = "xpath=//div[text()='Conveyor Information']/following-sibling::div/table/tr/td[2]")
    public CustomElement txtElevatorConveyor;

    @FindBy(locator = "xpath=//div[text()='Conveyor Information']/following-sibling::div/table/tr/td[3]")
    public CustomElement txtElevatorRepresentive;

    @FindBy(locator = "xpath=//div[text()='Conveyor Information']/following-sibling::div/table/tr/td[4]")
    public CustomElement txtElevatorBeltDescription;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[1]/td")
    public CustomElement txtElevatorConveyorType;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[2]/td/span[1]")
    public CustomElement txtElevatorBucketProjection;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[3]/td/span[1]")
    public CustomElement txtElevatorBucketLength;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[4]/td/span[1]")
    public CustomElement txtElevatorBucketVolume;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[5]/td/span[1]")
    public CustomElement txtElevatorBeltWidth;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[6]/td/span[1]")
    public CustomElement txtElevatorBeltHeight;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[7]/td/span[1]")
    public CustomElement txtElevatorBeltSpeed;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[8]/td/span[1]")
    public CustomElement txtElevatortonPerPeak;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[9]/td/span[1]")
    public CustomElement txtElevatorMaterialDensity;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[10]/td/span[1]")
    public CustomElement txtElevatorTakeUp;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[11]/td/span[1]")
    public CustomElement txtElevatorDrivePulley;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[12]/td/span[1]")
    public CustomElement txtElevatorBucketWeight;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[13]/td/span[1]")
    public CustomElement txtElevatorBeltWeight;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[14]/td/span[1]")
    public CustomElement txtElevatorBucketSpacing;

    @FindBy(locator = "xpath=//label[text()='Given Data']/following-sibling::table/tr[15]/td")
    public CustomElement txtElevatorBucketRows;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[1]/td/span[1]")
    public CustomElement txtElevatorMaximumTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[2]/td/span[1]")
    public CustomElement txtElevatorEffectiveTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[3]/td/span[1]")
    public CustomElement txtElevatorMaximumPIW;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[4]/td/span[1]")
    public CustomElement txtElevatorBeltHorsepower;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[5]/td/span[1]")
    public CustomElement txtElevatorCounterweightTension;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[6]/td/span[1]")
    public CustomElement txtElevatorCounterweightWeight;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[7]/td/span[1]")
    public CustomElement txtElevatorEachBucketWeight;

    @FindBy(locator = "xpath=//label[text()='Calculated Data']/following-sibling::table/tr[8]/td/span[1]")
    public CustomElement txtElevatorBucketCapacity;

    @FindBy(locator = "xpath=//label[text()='Additional Data']/following-sibling::table/tr[1]/td/span[1]")
    public CustomElement txtElevatorMinHeadPulleyDiameter;

    @FindBy(locator = "xpath=//label[text()='Additional Data']/following-sibling::table/tr[2]/td/span[1]")
    public CustomElement txtElevatorMaxBucketProjection;

    @FindBy(locator = "xpath=//label[text()='Additional Data']/following-sibling::table/tr[3]/td/span[1]")
    public CustomElement txtElevatorBucketNumber;

    @FindBy(locator = "xpath=//input[@formcontrolname='name']")
    public CustomElement tbElevatorCalculationName;

    @FindBy(locator = "xpath=//span[contains(text(),'Are you sure, you want')]")
    public CustomElement warningPopup;

    @FindBy(locator = "xpath=(//app-card//div[text()='Minuteman Calc.']/..//span)[1]")
    public CustomElement txtMinutemanCount;

    @FindBy(locator = "xpath=(//app-card//div[text()='Minuteman Calc.'])[1]")
    public CustomElement txtMinutemanCard;

    @FindBy(locator="xpath=//button[contains(@class,'p-carousel-next')]")
    public CustomElement btRightCarousel;

    @FindBy(locator="xpath=//button[@icon='ctp-icon-Arrow-Right']")
    public CustomElement viewMinuteman;

    @FindBy(locator="xpath=//span[text()='Load Data']/..")
    public CustomElement loadData;

    @FindBy(locator="xpath=//div[text()='Technical data load was completed successfully']")
    public CustomElement loadDataToastMsg;

    @FindBy(locator="xpath=//div[text()='*Counterweight Tension was manually entered.']")
    public CustomElement counterWeightNote;

    @FindBy(locator="xpath=//div[text()='*Estimated length only and is not be used for ordering. Actual length should be obtained from engineering drawings.']")
    public CustomElement estimatedLengthNote;

    @FindBy(locator="xpath=//div[text()='*Transition Length is not recommended.']")
    public CustomElement transitionLengthNote;

    @FindBy(locator="xpath=//div[text()='*Pulley Diameter is not recommended. The guideline for ply tensions is 200% max  and -100% min.']")
    public CustomElement pulleyNote;

    @FindBy(locator="xpath=//div[text()='*Curve Radius is not recommended']")
    public CustomElement curvesNote;


    private static final double PERCENTAGE_THRESHOLD = 1.0;
    String listItem="//ul[@role='listbox']//p-dropdownitem//li//span";

    @FindBy(locator = "xpath=(//button[@pripple]/../span)[1]")
    public CustomElement paginationEntry;
    @FindBy(locator = "xpath=(//app-card//div[text()='Minuteman Calc.'])[1]/../div/div/div/span")
    public CustomElement minutemanCardCount;

    public void gotoMinutemanScreen(){
        SyncUtil.waitFor(1000);
        if(!minuteman.isVisible())
            home.click("Home");
        SyncUtil.waitFor(1000);
        minuteman.click("Minuteman");
        waitForElementToDisplay(minutemanHeader);
        btSearchinput.isVisible("Minuteman Page");
    }

    public void gotoMinutemanScreenWait(){
        gotoMinutemanScreen();
        scrollPageDown();
        String val="";
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(120); stop>System.nanoTime();) {
            if (val.equalsIgnoreCase(pagination.getText("Pagination"))) {
                break;
            }
            val = pagination.getText();
            SyncUtil.waitFor(8000);
        }
    }

    public void verifyMinutemanCardClick(){
        waitForPageLoad(5000);
        while(!txtMinutemanCard.isVisible()){
            btRightCarousel.jsClick("Carousel right");
        }
        txtMinutemanCard.jsClick();
        waitForPageLoad(5000);
        Validator.assertTrue(minutemanHeader.isDisplayed(),"Minuteman Page is not loaded","Minuteman Page is loaded");
    }

    public void goToMinutemanCalculation(String calc){
        searchMinuteman(calc);
        viewMinuteman.click("View");
        SyncUtil.waitFor(3000);
        waitForElementToDisplay(tbCalculationName);
    }

    public void gotoAddMinutemanConveyor(){
        gotoMinutemanScreen();
        btnAdd.click("Add");
        btnConveyor.click("Conveyor");
    }

    public void goToAddMinutemanConveyorFromList(){
        btnAdd.click("Add");
        btnConveyor.click("Conveyor");
    }

    public ArrayList<Float> getSystemCoordinates(){
        ArrayList<Float> systemCoordinates=new ArrayList<>();
        String estimatedCCLength=txtEstimatedCCLength.getText().split("\\s")[3].split("\\(")[0].trim();
        for (int i=1;i<=11;i++){
                WebElement element=driver.findElement(By.xpath("(//label[text()='System Coordinates']/following-sibling::div[1]//div[contains(@class,'col-3')]/div)["+i+"]"));
                String text=element.getText();
                if(element.getText().isEmpty()) {
                    systemCoordinates.add(Float.valueOf(estimatedCCLength));
                    return systemCoordinates;
                }
                systemCoordinates.add(Float.valueOf(text));
            }
        systemCoordinates.add(Float.valueOf(estimatedCCLength));
        return systemCoordinates;
    }

    public ArrayList<String> getConveyorInformation(){
        String[] data=txtDescription.getText().split("\\r?\\n");
        System.out.println(txtDescription.getText());
        System.out.println(Arrays.toString(data));
        String beltDescription = data[data.length-1].trim();
        String customer=txtCustomer.getText();
        String conveyor = txtConveyor.getText();
        return new ArrayList<> (Arrays.asList(beltDescription,customer,conveyor));
    }


    public ArrayList<String> getMaterialData(){
        String tonsPerHour = txtMaterialDataTonsPerHr.getText().trim();
        String materialDensity = txtMaterialDataMaterialDensity.getText().trim();
        String surchargeAngle = txtMaterialDataSurchargeAngle.getText().trim();
        return new ArrayList<> (Arrays.asList(tonsPerHour, materialDensity, surchargeAngle));
    }

    public ArrayList<String> getInputBeltData(){
        String width = txtInputBeltDataWidth.getText().trim();
        String speed = txtInputBeltDataSpeed.getText().trim();
        String weight = txtInputBeltDataWeight.getText().trim();
        String oAG = txtInputBeltDataOAG.getText().trim();
        return new ArrayList<> (Arrays.asList(width, speed, weight, oAG));
    }

    public ArrayList<String> getSystemData(){
        String troughAngleOfIdlers = txtSystemDataAngleOfIdlers.getText().trim();
        String carrySideIdlerSpacing = txtSystemDataCarrySideIdlerSpacing.getText().trim();
        String stationLocationOfDrive = txtSystemDataStationLocationDrive.getText().trim();
        String stationLocationOfTakeUp = txtSystemDataStationLocationTakeUp.getText().trim();
        String weightOfMovingParts = txtSystemDataWeightOfMovingParts.getText().trim();
        String driveFactor = txtSystemDataDriveFactor.getText().trim();
        String frictionFactor = txtSystemDataFrictionFactor.getText().trim();
        String lengthFactor = txtSystemDataLengthFactor.getText().trim();
        String driveWrap = txtSystemDataDriveWrap.getText().trim();
        return new ArrayList<> (Arrays.asList(troughAngleOfIdlers, carrySideIdlerSpacing, stationLocationOfDrive, stationLocationOfTakeUp,
                weightOfMovingParts, driveFactor, frictionFactor, lengthFactor, driveWrap));
    }

    public ArrayList<String> getCalculatedData(){
        String unitTension = txtCalculateDataUnitTension.getText().trim();
        String maximumTension = txtCalculateDataMaximumTension.getText().trim();
        String effectiveTension = txtCalculateDataEffectiveTension.getText().trim();
        String beltPower = txtCalculateDataBeltPower.getText().trim();
        String counterweightWeight = txtCalculateDataCounterWeightW.getText().trim();
        String counterweightTension = txtCalculateDataCounterWeightTension.getText().trim();
        String conveyorCapacity = txtCalculateDataConveyorCapacity.getText().replace("%","").trim();
        String estimatedBeltLength = txtCalculateDataEstimatedBeltLength.getText().trim();
        return new ArrayList<>(Arrays.asList(unitTension, maximumTension, effectiveTension, beltPower, counterweightWeight, counterweightTension,
                conveyorCapacity, estimatedBeltLength));
    }

    public ArrayList<String> getBeltData(){
        String carcassMaterial = txtBeltDataCarcassMaterial.getText().trim();
        String numberOfPlies = txtBeltDataNoOfPlies.getText().trim();
        String plyTensileStrength = txtBeltDataPlyTensileStrength.getText().trim();
        String beltTensileStrength = txtBeltDataBeltTensileStrength.getText().trim();
        String vulcanizedRating = txtBeltDataVulcanizedRating.getText().trim();
        String mechanicalRating = txtBeltDataMechanicalRating.getText().trim();
        String elasticModulus = txtBeltDataElasticModulus.getText().trim();
        String carcassGauge = txtBeltDataCarcassGauge.getText().trim();
        String totalCoverGauge = txtBeltDataCoverGauge.getText().trim();
        String totalBeltGauge = txtBeltDataBeltGauge.getText().trim();
        String carcassWeight = txtBeltDataCarcassWeight.getText().trim();
        String totalCoverWeight = txtBeltDataCoverWeight.getText().trim();
        String totalBeltWeight = txtBeltDataTotalBeltWeight.getText().trim();
        return new ArrayList<>(Arrays.asList(carcassMaterial, numberOfPlies, plyTensileStrength, beltTensileStrength, vulcanizedRating,
                mechanicalRating, elasticModulus, carcassGauge, totalCoverGauge, totalBeltGauge, carcassWeight,
                totalCoverWeight, totalBeltWeight));
    }

    public ArrayList<String> getRollData(){
        String totalBeltLength = txtRollDataTotalBeltLength.getText().trim();
        String numberOfRolls = txtRollDataNoOfRolls.getText().trim();
        String rollLength = txtRollDataRollLength.getText().trim();
        String rollDiameter = txtRollDataRollDiameter.getText().trim();
        String rollWeight = txtRollDataRollWeight.getText().trim();
        String cubage = txtRollDataCubage.getText().trim();
        return new ArrayList<>(Arrays.asList(totalBeltLength, numberOfRolls, rollLength, rollDiameter, rollWeight, cubage));
    }

    public ArrayList<String> getVulcanizedSpliceData(){
        String numberOfSplices = txtVulcanizedSpliceDataNoOfSplice.getText().trim();
        String vulcanizerBiasAngle = txtVulcanizedSpliceDataVulcanizerBiasAngle.getText().trim();
        String fabricStepLength = txtVulcanizedSpliceDataFabricStepLength.getText().trim();
        String biasLength = txtVulcanizedSpliceDataBiasLength.getText().trim();
        String spliceLength = txtVulcanizedSpliceDataSpliceLength.getText().trim();
        String extraBeltLength = txtVulcanizedSpliceDataExtraBeltLength.getText().trim();
        return new ArrayList<>(Arrays.asList(numberOfSplices, vulcanizerBiasAngle, fabricStepLength, biasLength, spliceLength,
                extraBeltLength));
    }

    public ArrayList<String> getTakeUpTravel(){
        String typeOfTakeUp = txtTakeUpTravelTypeOfTakeUp.getText().trim();
        String typeOfSplice = txtTakeUpTravelTypeOfSplice.getText().trim();
        String maximumBeltTension = txtTakeUpTravelMaximumBeltTension.getText().trim();
        String averageBeltTension = txtTakeUpTravelAverageBeltTension.getText().trim();
        String estPermanentElongation = txtTakeUpTravelTakeUpMovementPermanent.getText().trim();
        String estElasticElongation = txtTakeUpTravelTakeUpMovementElastic.getText().trim();
        String estimatedTotalTakeUpMovementPercentage = txtTakeUpTravelEstimatedTakeUpMovementPercentage.getText().trim();
        String conveyorCCLength = txtTakeUpTravelConveyorLength.getText().trim();
        String estimatedTotalTakeUpMovement = txtTakeUpTravelEstimatedTakeUpMovement.getText().trim();
        return new ArrayList<>(Arrays.asList(typeOfTakeUp, typeOfSplice, maximumBeltTension, averageBeltTension, estPermanentElongation,
                estElasticElongation, estimatedTotalTakeUpMovementPercentage, conveyorCCLength, estimatedTotalTakeUpMovement));
    }

    public ArrayList<String> getPulleyData(){
        ArrayList<String> pulleyData=new ArrayList<>();
        for(int i=2;i<=3;i++){
            for(int j=2;j<=5;j++){
                WebElement element=driver.findElement(By.xpath("//label[text()='Pulley Data']/following-sibling::div["+i+"]/div["+j+"]"));
                pulleyData.add(element.getText());
            }
        }
        return pulleyData;
    }

    public ArrayList<String> getVerticalCurves(){
        ArrayList<String> verticalCurves=new ArrayList<>();
        for (int i=2;i<=5;i++){
            WebElement element=driver.findElement(By.xpath("//label[text()='Vertical Curves']/following-sibling::div[1]/div["+i+"]"));
            verticalCurves.add(element.getText().split("\\s")[1].trim());
        }
        for (int i=2;i<=11;i++){
            for (int j=2;j<=5;j++){
                WebElement element=driver.findElement(By.xpath("//label[text()='Vertical Curves']/following-sibling::div["+i+"]/div["+j+"]"));
                verticalCurves.add(element.getText());
            }
        }
        return verticalCurves;
    }

    public ArrayList<String> getTransitionLength(){
        ArrayList<String> transitionLength=new ArrayList<>();
        for(int i=2;i<=8;i++){
            for(int j=2;j<=3;j++){
                WebElement element=driver.findElement(By.xpath("//label[text()='Transition Lengths']/following-sibling::div["+i+"]/div["+j+"]"));
                transitionLength.add(element.getText());
            }
        }
        return transitionLength;
    }

    public void clickNext(){
        waitForElementToDisplay(btnNext);
        btnNext.click("Next");
    }

    public void setTbCalculationName(String calculationName){
        tbCalculationName.type(calculationName,"Calculation Name");
    }

    public void setSiteDropdown(String site){
        dropdownSelectSearch(siteDropdown,dropdownInput,site);
    }

    public void setConveyorDropdown(String conveyorName){
        dropdownSelectSearch(conveyorDropdown,dropdownInput,conveyorName);
    }

    public void setTbDescription(String description){
        tbDescription.type(description);
    }

    public void setTbProgram(String program){
        dropdownSelect(tbProgram,listItem,program);
    }

    public void setTbManufacturingLocation(String manufacturingLocation){
        dropdownSelect(tbManufacturingLocation,listItem,manufacturingLocation);
    }

    public void clickOnLoadData(){
        btnLoadData.click("Load Data");
    }

    public void selectUnit(String units){
        if(units.equalsIgnoreCase("Metric")){
            radioMetric.click("Metric");
            handleUnitsPopup("Imperial");
        }else if (units.equalsIgnoreCase("Imperial")){
            radioImperial.click("Imperial");
        }
    }

    public void clickCancel(){
        btnCancel.click("Cancel");
    }

    public void clickSaveAndContinue(){
        btnSaveAndContinue.click("Save & Continue");
    }

    public void clickSaveAndClose(){
        btnSaveAndClose.click("Save & Close");
    }

    public void setTbBeltWidth(String beltWidth){
        tbBeltWidth.type(beltWidth,"Belt Width");
    }

    public void setTbBeltSpeed(String beltSpeed){
        tbBeltSpeed.type(beltSpeed,"Belt Speed");
    }

    public void setTbTonsPerHourPeak(String tonsPerHourPeak){
        tbTonsPerHourPeak.type(tonsPerHourPeak,"Tons Per Hour Peak");
    }

    public void setTbPickMaterialName(String pickMaterialName){
//        tbPickMaterialName.type(pickMaterialName,"Pick Material Name");
        dropdownSelectSearch(tbPickMaterialDropdown, tbDeviceTypedropdown, pickMaterialName);
    }

    public void setTbMaterialDensity(String materialDensity){
        tbMaterialDensity.type(materialDensity,"Material Density");
    }

    public void setTbAngleOfIdlers(String angleOfIdlers){
        tbAngleOfIdlers.type(angleOfIdlers,"Angle of Idlers");
    }

    public void setTbCarrySideIdlerSpacing(String carrySideIdlerSpacing){
        tbCarrySideIdlerSpacing.type(carrySideIdlerSpacing,"Carry Side Idler Spacing");
    }

    public void setDriveWrapAngleDropdown(String driveWrapAngle){
        dropdownSelectSearchContains(driveWrapAngleDropdown,dropdownInput,driveWrapAngle);
    }

    public void selectFrictionFactor(String frictionFactor,String lengthFactor){
        if(frictionFactor.equals("0.022")&&lengthFactor.equals("200")){
            radioPermanentConveyor.click("Permanent Conveyor");
        } else if (frictionFactor.equals("0.03")&&lengthFactor.equals("150")) {
            radioTemporaryConveyor.click("Temporary Conveyor");
        }else
            Reporter.log("Invalid Friction factor and Length Factor",MessageTypes.Fail);
    }

    public void setSurchargeAngleDropdown(String surchargeAngle){
        dropdownSelectSearch(surchargeAngleDropdown,dropdownInput,surchargeAngle);
    }

    public void setIdlerOffsetTypeDropdown(String idlerOffsetType){
        dropdownSelectSearch(idlerOffsetTypeDropdown,dropdownInput,idlerOffsetType);
    }

    public void setDriveDetailsDropdown(String driveDetails){
       dropdownSelect(driveDetailsDropdown,listItem,driveDetails);
    }

    public void setTakeUpDetailsDropdown(String takeUpDetails){
        dropdownSelect(takeUpDetailsDropdown,listItem,takeUpDetails);
    }

    public void setSpliceTypeDropdown(String spliceType){
        dropdownSelect(spliceTypeDropdown,listItem,spliceType);
    }

    public void clickPrevious(){
        btnPrevious.click("Previous");
    }

    public void selectStation(String station){
        driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station'])["+station+"]")).click();
        Reporter.log("Clicked On Station "+station);
    }

    public void selectDriveStation(String driveStation){
        SyncUtil.waitFor(1500);
        driver.findElement(By.xpath("(//p-radiobutton[@formcontrolname='drive'])["+driveStation+"]")).click();
        Reporter.log("Selected Drive station "+driveStation);
    }

    public void selectTakeUpStation(String takeUpStation){
       driver.findElement(By.xpath("(//p-radiobutton[@formcontrolname='takeup'])["+takeUpStation+"]")).click();
       Reporter.log("Selected Take-Up station "+takeUpStation);
    }

    public void setConveyorFlightsConfiguration(String station,String[] horzOffset,String[] elevOffset){
        for(int i=1;i<=Integer.parseInt(station);i++){
            driver.findElement(By.xpath("(//input[@formcontrolname='horizontalOffsets'])["+i+"]")).clear();
            driver.findElement(By.xpath("(//input[@formcontrolname='horizontalOffsets'])["+i+"]")).sendKeys(horzOffset[i-1]);
            Reporter.log("Entered Horz Offset value "+horzOffset[i-1],MessageTypes.Pass);
            driver.findElement(By.xpath("(//input[@formcontrolname='elevationOffsets'])["+i+"]")).clear();
            driver.findElement(By.xpath("(//input[@formcontrolname='elevationOffsets'])["+i+"]")).sendKeys(elevOffset[i-1]);
            Reporter.log("Entered Elev Offset value "+elevOffset[i-1],MessageTypes.Pass);
        }
    }
    
    public void getPointsOnGraph() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var points = []; \n" +
                "                         var ctx = arguments[0].getContext('2d'); \n" +
                "                         var imageData = ctx.getImageData(0, 0, arguments[0].width, arguments[0].height); \n" +
                "                         for (var y = 0; y < arguments[0].height; y++) { \n" +
                "                             for (var x = 0; x < arguments[0].width; x++) { \n" +
                "                                 var index = (y * arguments[0].width + x) * 4; \n" +
                "                                 var red = imageData.data[index]; \n" +
                "                                 var green = imageData.data[index + 1]; \n" +
                "                                 var blue = imageData.data[index + 2]; \n" +
                "                                 // Extract points based on your graph's color scheme \n" +
                "                                 if (red === 0 && green === 0 && blue === 0 ) { \n" +
                "                                     points.push({ x: x, y: y }); \n" +
                "                                 } \n" +
                "                             } \n" +
                "                         } \n" +
                "                         return points;";

        String script1="var canvas = arguments[0];\n" +
                "var context = canvas.getContext('2d');\n" +
                "var points = [];\n" +
                "var imageData = context.getImageData(0, 0, canvas.width, canvas.height);\n" +
                "var tolerance = 10;\n" +
                "for (var y = 0; y < canvas.height; y++) {\n" +
                "  for (var x = 0; x < canvas.width; x++) {\n" +
                "    var index = (y * canvas.width + x) * 4;\n" +
                "    var red = imageData.data[index];\n" +
                "    var green = imageData.data[index + 1];\n" +
                "    var blue = imageData.data[index + 2];\n" +
                "    var isBlack = Math.abs(red - 0) <= tolerance && Math.abs(green - 0) <= tolerance && Math.abs(blue - 0) <= tolerance;\n" +
                "    if (isBlack) {\n" +
                "      points.push({ x: x, y: y });\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "return points;";

        List<Object> points = (List<Object>) js.executeScript(script1, canvas);

        // Process the extracted points
        for (Object point : points) {
            System.out.println("Point: " + point.toString());
        }
    }
    public void clickOnCalculate(){
        btnCalculate.click("Calculate");
    }

    public void setTradeNameDropdown(String tradeName){
        dropdownSelect(tradeNameDropdown,listItem,tradeName);
    }

    public void setCoverGradeDropdown(String coverGrade){
        dropdownSelect(coverGradeDropdown,listItem,coverGrade);
    }

    public void setRatingDropdown(String rating){
        dropdownSelect(ratingDropdown,listItem,rating);
    }

    public void setPliesDropdown(String plies){
        dropdownSelect(pliesDropdown,listItem,plies);
    }

    public void setCoverGaugeUnitDropdown(String coverGaugeUnit){
        dropdownSelect(coverGaugeUnitDropdown,listItem,coverGaugeUnit);
    }

    public void setGaugeTopCoverDropdown(String gaugeTopCover){
        dropdownSelectSearch(gaugeTopCoverDropdown,dropdownInput,gaugeTopCover);
    }

    public void setGaugePulleyCoverDropdown(String gaugePulleyCover){
        dropdownSelectSearch(gaugePulleyCoverDropdown,dropdownInput,gaugePulleyCover);
    }

    public ArrayList<String> getCalculatedDataInSelectBelt(){
        String[] unitTension = textUnitTension.getText().trim().split("\\s");
        String[] maximumTension = textMaximumTension.getText().trim().split("\\s");
        String[] effectiveTension = textEffectiveTension.getText().trim().split("\\s");
        String[] beltPower = textBeltPower.getText().trim().split("\\s");
        String[] counterweightWeight = textCounterweightWeight.getText().trim().split("\\s");
        String[] counterweightTension = textCounterweightTension.getText().trim().split("\\s");
        String[] conveyorCapacity = textConveyorCapacity.getText().trim().split("\\s");
        return new ArrayList<>(Arrays.asList(unitTension[0], maximumTension[0], effectiveTension[0], beltPower[0], counterweightWeight[0], counterweightTension[0],
                conveyorCapacity[0]));
    }

    public ArrayList<String> getCapacity(){
        String[] conveyorCapacity = textCapacityPageConveyorCapacity.getText().split("=")[1].trim().split("\\s");
        String angleOfIdlers = textCapacityPageAngleOfIdlers.getText().split("=")[1].trim();
        return new ArrayList<>(Arrays.asList(conveyorCapacity[0],angleOfIdlers));
    }

    public void clickOnResetOfBeltSpeed(){
        btnResetBeltSpeed.click("Reset");
    }

    public void clickOnResetOfTonsPerHourPeak(){
        btnResetTonsPerHourPeak.click("Reset");
    }

    public void clickOn100PercentBeltSpeed(){
        btn100PercentageBeltSpeed.click("100%");
    }

    public void clickOn100PercentTonsPerHourPeak(){
        btn100PercentageTonsPerHourPeak.click("100%");
    }

    public void clickOnCalculateBeltSpeed(){
        btnCalculateBeltSpeed.click("Calculate");
    }

    public void clickOnCalculateTonsPerHourPeak(){
        btnCalculateTonsPerHourPeak.click("Calculate");
    }

    public void clickOnGeneralInfo(){
       generalInfo.click("General Info");
    }

    public void clickOnInputs(){
        inputs.click("Inputs");
    }

    public void clickOnStations(){
        stations.click("Stations");
    }

    public void clickOnFlightInfo(){
        flightInfo.click("Flight Info");
    }

    public void clickOnSelectBelt(){
        selectBelt.click("Select Belt");
    }

    public void clickOnCapacity(){
        capacity.click("Capacity");
    }

    public void clickOnRollData(){
        rollData.click("Roll Data");
    }
    public void clickOnPulley(){
        pulleys.click("Pulley");
    }

    public void clickOnTransitions(){
        transitions.click("Transitions");
    }

    public void clickOnTakeUp(){
        takeUp.click("Take-Up");
    }

    public void clickOnCurves(){
        curves.click("Curves");
    }

    public void clickOnFinalReport(){
        finalReport.click("Final Report");
    }

    public void setTbTotalBeltLength(String totalBeltLength){
        tbTotalBeltLength.type(totalBeltLength,"Total Belt Length");
    }

    public void setTbNumberOfRollsConveyorRollData(String numberOfRolls){
        tbNumberOfRollsConveyorRollData.type(numberOfRolls,"Number Of Rolls");
    }

    public void setTbPulleyHeadDiameter(String pulleyHeadDiameter){
        tbPulleyHeadDiameter.type(pulleyHeadDiameter,"Pulley Diameter Head");
    }

    public void setTbPulleyDriveDiameter(String pulleyDriveDiameter){
        tbPulleyDriveDiameter.type(pulleyDriveDiameter,"Pulley Diameter Drive");
    }

    public void setTbPulleyTakeUpDiameter(String pulleyTakeUpDiameter){
        tbPulleyTakeUpDiameter.type(pulleyTakeUpDiameter,"Pulley Diameter TakeUp");
    }

    public void setTbPulleyTailDiameter(String pulleyTailDiameter){
        tbPulleyTailDiameter.type(pulleyTailDiameter,"Pulley Diameter Tail");
    }

    public void selectTroughDepthHead(String troughDepthHead) {
        if (troughDepthHead.equalsIgnoreCase("Full")) {
            radioTransitionHeadTroughDepthFull.click("Full");
        } else if (troughDepthHead.equalsIgnoreCase("Half")) {
            radioTransitionHeadTroughDepthHalf.click("Half");
        }
    }

    public void selectTroughDepthTail(String troughDepthTail){
        if (troughDepthTail.equalsIgnoreCase("Full")) {
            radioTransitionTailTroughDepthFull.click("Full");
        } else if (troughDepthTail.equalsIgnoreCase("Half")) {
            radioTransitionTailTroughDepthHalf.click("Half");
        }
    }

    public void setTbLengthHead(String lengthHead){
        tbLengthHead.type(lengthHead,"Length Head");
    }

    public void setTbLengthTail(String lengthTail){
        tbLengthTail.type(lengthTail,"Length Tail");
    }

    public void selectSpliceType(String spliceType){
        if(spliceType.equalsIgnoreCase("Vulcanized")){
            radioVulcanizedTypeOfSplice.click("Vulcanized");
        }else if(spliceType.equalsIgnoreCase("Mechanical")){
            radioMechanicalTypeOfSplice.click("Mechanical");
        }
    }

    public void setTbTakeUpTensionifknown(String takeUpTension){
        tbTakeUpTensionifknown.type(takeUpTension,"Take-Up tension (If Known");
    }

    public void setTbCurveRadius1(String curveRadius1){
        tbCurveRadius1.type(curveRadius1,"Curve Radius 1");
    }

    public void setTbCurveRadius2(String curveRadius2){
        tbCurveRadius2.type(curveRadius2,"Curve Radius 2");
    }

    public void setTbCurveRadius3(String curveRadius3){
        tbCurveRadius3.type(curveRadius3,"Curve Radius 3");
    }

    public void setTbCurveRadius4(String curveRadius4){
        tbCurveRadius4.type(curveRadius4,"Curve Radius 4");
    }

    public String getFrictionFactor(){
        return tbFrictionFactorValue.getAttribute("value");
    }

    public String getLengthFactor(){
//        return tbLengthFactorValue.getAttribute("Value");
//        waitForElementToBeClickable(tbLengthFactorValue);
        return tbLengthFactorValue.getAttribute("value");
//        return (String) js.executeScript("return arguments[0].value;",tbLengthFactorValue);
    }

    public String getDriveWrapAngle(){
        return tbDriveWrapAngle2.getAttribute("value");
    }

    public String getSurchargeAngle(){
        return tbSurchargeAngle.getText();
    }

    public String getTbBeltSpecification(){
        return tbBeltSpecification.getAttribute("value");
    }

    public String getTbCarcassMaterial(){
        return tbCarcassMaterial.getAttribute("value");
    }

    public String getTbNumberPlies(){
        return tbNumberOfPlies.getAttribute("value");
    }

    public String getTbPlyTensileStrength(){
        return tbPlyTensileStrength.getAttribute("value");
    }

    public String getTbBeltTensileStrength(){
        return tbBeltTensileStrength.getAttribute("value");
    }

    public String getTbElasticModules(){
        return tbElasticModules.getAttribute("value");
    }

    public String getTbVulcanizedRating(){
        return tbVulcanizedRating.getAttribute("value");
    }

    public String getTbMechanicalRating(){
        return tbMechanicalRating.getAttribute("value");
    }

    public String getTbCarcassGauge(){
        return tbCarcassGauge.getAttribute("value");
    }

    public String getTbTotalCoverGauge(){
        return tbTotalCoverGauge.getAttribute("value");
    }

    public String getTbTotalBeltGauge(){
        return tbTotalBeltGauge.getAttribute("value");
    }

    public String getTbCarcassWeight(){
        return tbCarcassWeight.getAttribute("value");
    }

    public String getTbTotalCoverWeight(){
        return tbTotalCoverWeight.getAttribute("value");
    }

    public String getTbTotalBeltWeight(){
        return tbTotalBeltWeight.getAttribute("value");
    }

    public String getTotalBeltLength(){
        return tbTotalBeltLength.getAttribute("value");
    }

    public String getNumberOfRolls(){
        return tbNumberOfRollsConveyorRollData.getAttribute("value");
    }

    public String getTbRollLength(){
        return tbRollLength.getAttribute("value");
    }

    public String getTbRollDiameter(){
        return tbRollDiameter.getAttribute("value");
    }

    public String getTbRollWeight(){
        return tbRollWeight.getAttribute("value");
    }

    public String getTbCubage(){
        return tbCubage.getAttribute("value");
    }

    public String getTbNumberOfRollsConveyorSpliceDimension(){
        return tbNumberOfRollsConveyorSpliceDimensions.getAttribute("value");
    }

    public String getTbVulcanizedSpliceAngle(){
        return tbVulcanizedSpliceAngle.getAttribute("value");
    }

    public String getTbStepLength(){
        return tbStepLength.getAttribute("value");
    }

    public String getTbBiasLength(){
        return tbBiasLength.getAttribute("value");
    }

    public String getTbSpliceLength(){
        return tbSpliceLength.getAttribute("value");
    }

    public String getTbExtraBeltLength(){
        return tbExtraBeltLength.getAttribute("value");
    }

    public String getTbStationNumberHead(){
        return tbStationNumberHead.getAttribute("value");
    }

    public String getTbStationNumberDrive(){
        return tbStationNumberDrive.getAttribute("value");
    }

    public String getTbStationNumberTakeUp(){
        return tbStationNumberTakeUp.getAttribute("value");
    }

    public String getTbStationNumberTail(){
        return tbStationNumberTail.getAttribute("value");
    }

    public String getTbBeltTensionHead(){
        return tbBeltTensionHead.getAttribute("value");
    }

    public String getTbBeltTensionDrive(){
        return tbBeltTensionDrive.getAttribute("value");
    }

    public String getTbBeltTensionTakeUp(){
        return tbBeltTensionTakeUp.getAttribute("value");
    }

    public String getTbBeltTensionTail(){
        return tbBeltTensionTail.getAttribute("value");
    }

    public String getTbMinPulleyDiameterHead(){
        return tbMinPulleyDiameterHead.getAttribute("value");
    }

    public String getTbMinPulleyDiameterDrive(){
        return tbMinPulleyDiameterDrive.getAttribute("value");
    }

    public String getTbMinPulleyDiameterTakeUp(){
        return tbMinPulleyDiameterTakeUp.getAttribute("value");
    }

    public String getTbMinPulleyDiameterTail(){
        return tbMinPulleyDiameterTail.getAttribute("value");
    }

    public String getTbPulleyDiameterHead(){
        String str = tbPulleyHeadDiameter.getAttribute("value");
        while(str.endsWith("0") || str.endsWith("."))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getTbPulleyDiameterDrive(){
        String str = tbPulleyDriveDiameter.getAttribute("value");
        while(str.endsWith("0") || str.endsWith("."))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getTbPulleyDiameterTakeUp(){
        return tbMinPulleyDiameterTakeUp.getAttribute("value");
    }

    public String getTbPulleyDiameterTail(){
        return tbMinPulleyDiameterTail.getAttribute("value");
    }

    public String getTbBeltTensionHeadTransitionLengthPage(){
        return tbBeltTensionHeadTransitionLengthPage.getAttribute("value");
    }

    public String getTbBeltTensionTailTransitionLengthPage(){
        return tbBeltTensionTailTransitionLengthPage.getAttribute("value");
    }

    public String getTbIdlerAngleHead(){
        return tbIdlerAngleHead.getAttribute("value");
    }

    public String getTbIdlerAngleTail(){
        return tbIdlerAngleTail.getAttribute("value");
    }

    public String getTbTroughDepthHead(){
        String str = tbTroughDepthHead.getAttribute("value");
        if(str.endsWith("0"))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getTbTroughDepthTail(){
        String str = tbTroughDepthTail.getAttribute("value");
        if(str.endsWith("0"))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getLengthHead(){
        String str =  tbLengthHead.getAttribute("value");
        if(str.endsWith("0"))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getLengthTail(){
        String str = tbLengthTail.getAttribute("value");
        if(str.endsWith("0"))
            str = str.substring(0, str.length() - 1);
        return str;
    }

    public String getTbEdgeTensionHead(){
        return tbEdgeTensionHead.getAttribute("value");
    }

    public String getTbEdgeTensionTail(){
        return tbEdgeTensionTail.getAttribute("value");
    }

    public String getTbEdgeTensionHeadPercentage(){
        return tbEdgeTensionHeadPercentage.getAttribute("value");
    }

    public String getTbEdgeTensionTailPercentage(){
        return tbEdgeTensionTailPercentage.getAttribute("value");
    }

    public String getTbCenterTensionHead(){
        return tbCenterTensionHead.getAttribute("value");
    }

    public String getTbCenterTensionTail(){
        return tbCenterTensionTail.getAttribute("value");
    }

    public String getTbCenterTensionHeadPercentage(){
        return tbCenterTensionHeadPercentage.getAttribute("value");
    }

    public String getTbCenterTensionTailPercentage(){
        return tbCenterTensionTailPercentage.getAttribute("value");
    }

    public String getTbTakeUpTensionTakeUpLevel(){
        return tbTakeUpTensionTakeUpLevel.getAttribute("value");
    }

    public String getTbCounterweightWeightTakeUpLevel(){
        return tbCounterWeight.getAttribute("value");
    }

    public String getTbMaximumBeltTension(){
        return tbMaximumBeltTension.getAttribute("value");
    }

    public String getTbAverageBeltTension(){
        return tbAverageBeltTension.getAttribute("value");
    }

    public String getTbEstimatedTakeUpMovementDueToPermanentElongation(){
        return tbEstimatedTakeUpMovementDueToPermanentElongation.getAttribute("value");
    }

    public String getTbEstimatedTakeUpMovementDueToElasticElongation(){
        return tbEstimatedTakeUpMovementDueToElasticElongation.getAttribute("value");
    }

    public String getTbTotalEstimatedTakeUpMovementPercentage(){
        return tbTotalEstimatedTakeUpMovementPercentage.getAttribute("value");
    }

    public String getTbEstimatedBeltLength(){
        return tbEstimatedBeltCCLength.getAttribute("value");
    }

    public String getTbTotalEstimatedTakeUpMovement(){
        return tbTotalEstimatedTakeUpMovement.getAttribute("value");
    }

    public String getTbTakeUPTensionIfKnown(){
        return tbTakeUpTensionifknown.getAttribute("value");
    }

    public String getTbStationLocation1(){
        return tbStationLocation1.getAttribute("value");
    }

    public String getTbStationLocation2(){
        return tbStationLocation2.getAttribute("value");
    }

    public String getTbStationLocation3(){
        return tbStationLocation3.getAttribute("value");
    }

    public String getTbStationLocation4(){
        return tbStationLocation4.getAttribute("value");
    }

    public String getTbCurveDescription1(){
        return tbCurveDescription1.getAttribute("value");
    }

    public String getTbCurveDescription2(){
        return tbCurveDescription2.getAttribute("value");
    }

    public String getTbCurveDescription3(){
        return tbCurveDescription3.getAttribute("value");
    }

    public String getTbCurveDescription4(){
        return tbCurveDescription4.getAttribute("value");
    }

    public String getTbMaximumBeltTension1(){
        return tbMaximumBeltTension1.getAttribute("value");
    }

    public String getTbMaximumBeltTension2(){
        return tbMaximumBeltTension2.getAttribute("value");
    }

    public String getTbMaximumBeltTension3(){
        return tbMaximumBeltTension3.getAttribute("value");
    }

    public String getTbMaximumBeltTension4(){
        return tbMaximumBeltTension4.getAttribute("value");
    }

    public String getTbMinimumBeltTension1(){
        return tbMinimumBeltTension1.getAttribute("value");
    }

    public String getTbMinimumBeltTension2(){
        return tbMinimumBeltTension2.getAttribute("value");
    }

    public String getTbMinimumBeltTension3(){
        return tbMinimumBeltTension3.getAttribute("value");
    }

    public String getTbMinimumBeltTension4(){
        return tbMinimumBeltTension4.getAttribute("value");
    }

    public String getTbCurveRadius1(){
        String value = tbCurveRadius1.getAttribute("value");
//        if(value.isEmpty())
//            Reporter.log("Curve Radius value is null",MessageTypes.Fail);
        if(value.equals("0.00"))
            return "0";
        else
            return value;
    }

    public String getTbCurveRadius2(){
        String value = tbCurveRadius2.getAttribute("value");
//        if(value.isEmpty())
//            Reporter.log("Curve Radius value is null",MessageTypes.Fail);
        if(value.equals("0.00"))
            return "0";
        else
            return value;
    }

    public String getTbCurveRadius3(){
        String value = tbCurveRadius3.getAttribute("value");
//        if(value.isEmpty())
//            Reporter.log("Curve Radius value is null",MessageTypes.Fail);
        if(value.equals("0.00"))
            return "0";
        else
            return value;
    }

    public String getTbCurveRadius4(){
        String value = tbCurveRadius4.getAttribute("value");
//        if(value.isEmpty())
//            Reporter.log("Curve Radius value is null",MessageTypes.Fail);
        if(value.equals("0.00"))
            return "0";
        else
            return value;
    }


    public String getTbProjectedLength1(){
        return tbProjectedLength1.getAttribute("value");
    }

    public String getTbProjectedLength2(){
        return tbProjectedLength2.getAttribute("value");
    }

    public String getTbProjectedLength3(){
        return tbProjectedLength3.getAttribute("value");
    }

    public String getTbProjectedLength4(){
        return tbProjectedLength4.getAttribute("value");
    }

    public String getTbCenterTension1(){
        String value= tbCenterTension1.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Center Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbCenterTension2(){
        String value= tbCenterTension2.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Center Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbCenterTension3(){
        String value= tbCenterTension3.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Center Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbCenterTension4(){
        String value= tbCenterTension4.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Center Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbCenterTensionPercentage1(){
        return tbCenterTensionPercentage1.getAttribute("value");
    }

    public String getTbCenterTensionPercentage2(){
        return tbCenterTensionPercentage2.getAttribute("value");
    }

    public String getTbCenterTensionPercentage3(){
        return tbCenterTensionPercentage3.getAttribute("value");
    }

    public String getTbCenterTensionPercentage4(){
        return tbCenterTensionPercentage4.getAttribute("value");
    }

    public String getTbEdgeTension1(){
        String value= tbEdgeTension1.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Edge Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEdgeTension2(){
        String value= tbEdgeTension2.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Edge Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEdgeTension3(){
        String value= tbEdgeTension3.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Edge Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEdgeTension4(){
        String value= tbEdgeTension4.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Edge Tension value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEdgeTensionPercentage1(){
        return tbEdgeTensionPercentage1.getAttribute("value");
    }

    public String getTbEdgeTensionPercentage2(){
        return tbEdgeTensionPercentage2.getAttribute("value");
    }

    public String getTbEdgeTensionPercentage3(){
        return tbEdgeTensionPercentage3.getAttribute("value");
    }

    public String getTbEdgeTensionPercentage4(){
        return tbEdgeTensionPercentage4.getAttribute("value");
    }

    public String getTbEstimatedLiftOff1(){
        String value= tbEstimatedLiftOff1.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Estimated Lift off value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEstimatedLiftOff2(){
        String value= tbEstimatedLiftOff2.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Estimated Lift off value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEstimatedLiftOff3(){
        String value= tbEstimatedLiftOff3.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Estimated Lift off value is null",MessageTypes.Fail);
        return value;
    }

    public String getTbEstimatedLiftOff4(){
        String value= tbEstimatedLiftOff4.getAttribute("value");
        if(value.isEmpty())
            Reporter.log("Estimated Lift off value is null",MessageTypes.Fail);
        return value;
    }

    public String getStationCheckBox(){
        String ele="";
        for(int i=1;i<=6;i++){
            WebElement element=driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)["+i+"]"));
             if(element.isSelected()){
                ele=element.getAttribute("value");
             }else
                 break;
        }
        return ele;
    }

    public String getDriveStation(){
        String ele="";
        for (int i=1;i<=6;i++){
            WebElement element=driver.findElement(By.xpath("(//p-radiobutton[@formcontrolname='drive']//input)["+i+"]"));
            if(element.isSelected()){
                ele=element.getAttribute("value");
                break;
            }

        }return ele;
    }

    public String getTakeUpStation(){
        String ele="";
        for (int i=1;i<=6;i++){
            WebElement element=driver.findElement(By.xpath("(//p-radiobutton[@formcontrolname='takeup']//input)["+i+"]"));
            if(element.isSelected()){
                ele=element.getAttribute("value");
                break;
            }

        }return ele;
    }

    public ArrayList<String> getHorzOffsets(String stations){
        ArrayList<String> array=new ArrayList<>();
        for (int i=1;i<=Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='horizontalOffsets'])["+i+"]"));
            array.add(element.getAttribute("value").replaceAll(",",""));
        }
        return array;
    }

    public ArrayList<Float> getHorzOffset(String stations){
        ArrayList<Float> array=new ArrayList<>();
        for (int i=1;i<=Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='horizontalOffsets'])["+i+"]"));
            array.add(Float.parseFloat(element.getAttribute("value").replaceAll(",","")));
        }
        return array;
    }

    public ArrayList<Float> getElevOffset(String stations){
        ArrayList<Float> array=new ArrayList<>();
        for (int i=1;i<=Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='elevationOffsets'])["+i+"]"));
            array.add(Float.parseFloat(element.getAttribute("value").replaceAll(",","")));
        }
        return array;
    }

    public ArrayList<String> getElevOffsets(String stations){
        ArrayList<String> array=new ArrayList<>();
        for (int i=1;i<=Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='elevationOffsets'])["+i+"]"));
            array.add(element.getAttribute("value").replaceAll(",",""));
        }
        return array;
    }

    public ArrayList<Float> getSectionAngle(String stations){
        ArrayList<Float> array=new ArrayList<>();
        for (int i=1;i<Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='sectionAngles'])["+i+"]"));
            array.add(Float.valueOf(element.getAttribute("value")));
        }
        return array;
    }

    public ArrayList<String> getSectionAngles(String stations){
        ArrayList<String> array=new ArrayList<>();
        for (int i=1;i<Integer.parseInt(stations);i++){
            WebElement element=driver.findElement(By.xpath("(//input[@formcontrolname='sectionAngles'])["+i+"]"));
            array.add(element.getAttribute("value"));
        }
        return array;
    }



    public void verifyPerPopulatedDataInGeneralInfoPage(String program,String manufacturingLocation){
        Validator.assertTrue(tbProgram.getText().equalsIgnoreCase(program),"The initial value provided for the Program field does not match the expected value.","The initial value provided for the Program field matches the expected value.");
        Validator.assertTrue(tbManufacturingLocation.getText().equalsIgnoreCase(manufacturingLocation),"The initial value provided for the Manufacturing Location field does not match the expected value.","The initial value provided for the Manufacturing Location field matches the expected value.");
        Validator.assertTrue(checkedRadioMetric.isSelected(),"Metric radio button is should be selected","Metric radio button is selected as expected");
    }

    public void verifyPerPopulatedDataInGeneralInfoPageImperial(String program,String manufacturingLocation){
        Validator.assertTrue(tbProgram.getText().equalsIgnoreCase(program),"The initial value provided for the Program field does not match the expected value.","The initial value provided for the Program field matches the expected value.");
        Validator.assertTrue(tbManufacturingLocation.getText().equalsIgnoreCase(manufacturingLocation),"The initial value provided for the Manufacturing Location field does not match the expected value.","The initial value provided for the Manufacturing Location field matches the expected value.");
        Validator.assertTrue(checkedRadioImperial.isSelected(),"Imperial radio button is should be selected","Imperial radio button is selected as expected");
    }

    public void verifyPrePopulatedDataInInputsPage(String beltWidth,String beltSpeed,String tonsPerHourPeak,String pickMaterialName,String materialDensity, String angleOfIdlers, String carrySideIdler, String driveWrapAngle,String driveWrapAngleDegree,String takeUpTension,String frictionFactor,String lengthFactor,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails, String spliceType){
        Validator.assertTrue(tbBeltWidth.getAttribute("value").equalsIgnoreCase(beltWidth),"The initial value provided for the Belt Width field does not match the expected value.","The initial value provided for the Belt Width field matches the expected value.");
        Validator.assertTrue(tbBeltSpeed.getAttribute("value").equalsIgnoreCase(beltSpeed),"The initial value provided for the Belt Speed field does not match the expected value.","The initial value provided for the Belt Speed field matches the expected value.");
        System.out.println(tbTonsPerHourPeak.getAttribute("value"));
        System.out.println(tonsPerHourPeak);
//        Validator.assertTrue(tbTonsPerHourPeak.getAttribute("value").equalsIgnoreCase(tonsPerHourPeak),"The initial value provided for the Tons Per Hour Peak field does not match the expected value.","The initial value provided for the Tons Per Hour Peak field matches the expected value.");
//        Validator.assertTrue(tbPickMaterialName.getAttribute("value").equalsIgnoreCase(pickMaterialName),"The initial value provided for the Pick Material Name field does not match the expected value.","The initial value provided for the Pick Material Name field matches the expected value.");
        Validator.assertTrue(tbMaterialDensity.getAttribute("value").equalsIgnoreCase(materialDensity),"The initial value provided for the Material Density field does not match the expected value.","The initial value provided for the Material Density field matches the expected value.");
        Validator.assertTrue(tbAngleOfIdlers.getAttribute("value").equalsIgnoreCase(angleOfIdlers),"The initial value provided for the Angle Of Idlers field does not match the expected value.","The initial value provided for the Angle Of Idlers field matches the expected value.");
        Validator.assertTrue(tbCarrySideIdlerSpacing.getAttribute("value").equalsIgnoreCase(carrySideIdler),"The initial value provided for the Carry Side Idler Spacing field does not match the expected value.","The initial value provided for the Carry Side Idler Spacing field matches the expected value.");
        //Validator.assertTrue(tbDriveWrapAngle.getAttribute("value").equalsIgnoreCase(driveWrapAngle),"The initial value provided for the Drive Wrap Angle field does not match the expected value.","The initial value provided for the Drive Wrap Angle field matches the expected value.");
        System.out.println(tbDriveWrapAngle2.getAttribute("value"));
        System.out.println(driveWrapAngleDegree);
        Validator.assertTrue(tbDriveWrapAngle2.getAttribute("value").equalsIgnoreCase(driveWrapAngleDegree),"The initial value provided for the Drive Wrap Angle field does not match the expected value.","The initial value provided for the Drive Wrap Angle field matches the expected value.");
        System.out.println(tbTakeUpTension.getAttribute("value"));
        System.out.println(takeUpTension);
        Validator.assertTrue(tbTakeUpTension.getAttribute("value").equalsIgnoreCase(takeUpTension),"The initial value provided for the Take-Up Tension field does not match the expected value.","The initial value provided for the Take-Up Tension field matches the expected value.");
        Validator.assertTrue(checkedRadioPermanent.isSelected(),"Conveyors with permanent or other well aligned structures with normal maintenance radio button is should be selected.","Conveyors with permanent or other well aligned structures with normal maintenance radio button is selected as expected.");
        Validator.assertTrue(tbFrictionFactorValue.getAttribute("value").equalsIgnoreCase(frictionFactor),"The initial value provided for the Friction Factor field does not match the expected value.","The initial value provided for the Friction Factor field matches the expected value.");
        Validator.assertTrue(tbLengthFactorValue.getAttribute("value").equalsIgnoreCase(lengthFactor),"The initial value provided for the Length Factor field does not match the expected value.","The initial value provided for the Length Factor field matches the expected value.");
        System.out.println(surchargeAngle.replaceAll("\\s+", " ").trim());
        System.out.println(tbSurchargeAngle.getText());
        Validator.assertTrue(tbSurchargeAngle.getText().equalsIgnoreCase(surchargeAngle.replaceAll("\\s+", " ").trim()),"The initial value provided for the Surcharge Angle field does not match the expected value.","The initial value provided for the Surcharge Angle field matches the expected value.");
        Validator.assertTrue(tbIdlerOffsetType.getAttribute("value").equalsIgnoreCase(idlerOffsetType),"The initial value provided for the Idler Offset Type field does not match the expected value.","The initial value provided for the Idler Offset Type field matches the expected value.");
        Validator.assertTrue(driveDetailsDropdown.getText().equalsIgnoreCase(driveDetails),"The initial value provided for the Drive Details field does not match the expected value.","The initial value provided for the Drive Details field matches the expected value.");
        Validator.assertTrue(takeUpDetailsDropdown.getText().equalsIgnoreCase(takeUpDetails),"The initial value provided for the Take-Up Details field does not match the expected value.","The initial value provided for the Take-Up Details field matches the expected value.");
        Validator.assertTrue(spliceTypeDropdown.getText().equalsIgnoreCase(spliceType),"The initial value provided for the Splice Type field does not match the expected value.","The initial value provided for the Spice Type field matches the expected value.");
    }

    public void verifyBucketElevatorPrePopulatedDataInInputsPage(String conveyorType,String materialDensity,String tonsPerHourPeak,String materialLength,String materialProjection, String bucketSpacing, String bucketWeight, String bucketVolume,String bucketRows,String beltWidth,String beltHeight,String beltSpeed,String drivePulley,String takeUpType){
        System.out.println(tbConveyorType.getText());
        System.out.println(conveyorType);
        Validator.assertTrue(tbConveyorType.getText().equalsIgnoreCase(conveyorType),"The initial value provided for the conveyor type field does not match the expected value.","The initial value provided for the conveyor type field matches the expected value.");
        Validator.assertTrue(conveyorTypeText.getText("Conveyor Text").contains(getConveyorTypeToText(conveyorType)),"Conveyor type text is improper","Conveyor type text is verified successfully");
        System.out.println(tbDensity.getAttribute("value"));
        System.out.println(materialDensity);
        Validator.assertTrue(tbDensity.getAttribute("value").equalsIgnoreCase(materialDensity),"The initial value provided for the material density field does not match the expected value.","The initial value provided for the material density field matches the expected value.");
        Validator.assertTrue(tbMaterialPerHrPeak.getAttribute("value").equalsIgnoreCase(tonsPerHourPeak),"The initial value provided for the Tons Per Hour Peak field does not match the expected value.","The initial value provided for the Tons Per Hour Peak field matches the expected value.");
//        Validator.assertTrue(tbPickMaterialName.getAttribute("value").equalsIgnoreCase(pickMaterialName),"The initial value provided for the Pick Material Name field does not match the expected value.","The initial value provided for the Pick Material Name field matches the expected value.");
        System.out.println(tbMaterialLength.getAttribute("value"));
        System.out.println(materialLength);
        Validator.assertTrue(tbMaterialLength.getAttribute("value").equalsIgnoreCase(materialLength),"The initial value provided for the Material Length field does not match the expected value.","The initial value provided for the Material Length field matches the expected value.");
        Validator.assertTrue(tbMaterialProjection.getAttribute("value").equalsIgnoreCase(materialProjection),"The initial value provided for the material projection field does not match the expected value.","The initial value provided for the material projection field matches the expected value.");
        Validator.assertTrue(tbMaterialSpacing.getAttribute("value").equalsIgnoreCase(bucketSpacing),"The initial value provided for the material Spacing field does not match the expected value.","The initial value provided for material Spacing field matches the expected value.");
        //Validator.assertTrue(tbDriveWrapAngle.getAttribute("value").equalsIgnoreCase(driveWrapAngle),"The initial value provided for the Drive Wrap Angle field does not match the expected value.","The initial value provided for the Drive Wrap Angle field matches the expected value.");
        System.out.println(tbMaterialWeight.getAttribute("value"));
        System.out.println(bucketWeight);
        Validator.assertTrue(tbMaterialWeight.getAttribute("value").equalsIgnoreCase(bucketWeight),"The initial value provided for the material weight field does not match the expected value.","The initial value provided for the material weight field matches the expected value.");
        System.out.println(tbMaterialVolume.getAttribute("value"));
        System.out.println(bucketVolume);
        Validator.assertTrue(tbMaterialVolume.getAttribute("value").equalsIgnoreCase(bucketVolume),"The initial value provided for the material volume field does not match the expected value.","The initial value provided for the material volume field matches the expected value.");
        Validator.assertTrue(tbBucketRows.getAttribute("value").equalsIgnoreCase(bucketRows),"The initial value provided for the bucket rows field does not match the expected value.","The initial value provided for the bucket rows field matches the expected value.");
        Validator.assertTrue(tbMaterialWidth.getAttribute("value").equalsIgnoreCase(beltWidth),"The initial value provided for the material width field does not match the expected value.","The initial value provided for the material width field matches the expected value.");
        System.out.println(beltHeight);
        System.out.println(tbMaterialHeight.getAttribute("value"));
        Validator.assertTrue(tbMaterialHeight.getAttribute("value").equalsIgnoreCase(beltHeight),"The initial value provided for the material height field does not match the expected value.","The initial value provided for the material height field matches the expected value.");
        System.out.println(beltSpeed);
        System.out.println(tbMaterialSpeed.getAttribute("value"));
        Validator.assertTrue(tbMaterialSpeed.getAttribute("value").equalsIgnoreCase(beltSpeed),"The initial value provided for the material speed field does not match the expected value.","The initial value provided for the material speed field matches the expected value.");
        Validator.assertTrue(tbDrivePulley.getText().equalsIgnoreCase(drivePulley),"The initial value provided for the Drive pulley field does not match the expected value.","The initial value provided for the Drive pulley field matches the expected value.");
        Validator.assertTrue(tbTakeUpType.getText().equalsIgnoreCase(takeUpType),"The initial value provided for the Take-Up Details field does not match the expected value.","The initial value provided for the Take-Up Details field matches the expected value.");
    }


    public void verifyPrePopulatedDetailsInStationsPage(String stations,String driveLocation,String takeUpLocation){
        Validator.assertTrue(getStationCheckBox().equals(stations),"Number of Station selected is not matching with the expected value","Number of Stations selected is matching with the expected value");
        System.out.println("ABCD: = "+getDriveStation());
        System.out.println("ABCD: = "+driveLocation);
        Validator.assertTrue(getDriveStation().equals(driveLocation),"Drive station selected is not matching with the expected value","Drive station selected is matching with the expected value");
        Validator.assertTrue(getTakeUpStation().equals(takeUpLocation),"Take-Up station selected is not matching with the expected value","Take-Up station selected is matching with the expected value");
    }

    public void verifyPrePopulatedDetailsInFlightInfo(String typeOfConfiguration,String stations, String[] horzOffset,String[] elevOffset,String[] sectionAngle,String estimatedCCLength){
        Validator.assertTrue(tbTypeOfConfiguration.getAttribute("value").equalsIgnoreCase(typeOfConfiguration),"The initial value provided for the Type of Configuration field does not match the expected value.","The initial value provided for the Type of Configuration field matches the expected value.");
        System.out.println("ABCD: = "+getHorzOffsets(stations));
        System.out.println("ABCD: = "+Arrays.asList(horzOffset));
        Validator.assertTrue(getHorzOffsets(stations).equals(Arrays.asList(horzOffset)),"The initial value provided for the Horz Offset field does not match the expected value.","The initial value provided for the Horz Offset field matches the expected value.");
        Validator.assertTrue(getElevOffsets(stations).equals(Arrays.asList(elevOffset)),"The initial value provided for the Elev Offset field does not match the expected value.","The initial value provided for the Elev Offset field matches the expected value.");
        Validator.assertTrue(getSectionAngles(stations).equals(Arrays.asList(sectionAngle)),"The initial value provided for the Section Angle field does not match the expected value.","The initial value provided for the Section Angle field matches the expected value.");
        Validator.assertTrue(tbEstimatedCCLength.getAttribute("value").equals(estimatedCCLength),"The initial value provided for the Estimated C-C Length field does not match the expected value.","The initial value provided for the Estimated C-C Length field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInSelectBeltPage(String tradeName,String coverGrade,String rating,String plies,String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
        Validator.assertTrue(tradeNameDropdown.getText().equalsIgnoreCase(tradeName),"The initial value provided for the Trade Name field does not match the expected value.","The initial value provided for the Trade Name field matches the expected value.");
        Validator.assertTrue(coverGradeDropdown.getText().equalsIgnoreCase(coverGrade),"The initial value provided for the Cover Grade field does not match the expected value.","The initial value provided for the Cover Grade field matches the expected value.");
        Validator.assertTrue(ratingDropdown.getText().equalsIgnoreCase(rating),"The initial value provided for the Rating field does not match the expected value.","The initial value provided for the Rating field matches the expected value.");
        Validator.assertTrue(pliesDropdown.getText().equalsIgnoreCase(plies),"The initial value provided for the Plies field does not match the expected value.","The initial value provided for the Plies field matches the expected value.");
        Validator.assertTrue(coverGaugeUnitDropdown.getText().equalsIgnoreCase(coverGaugeUnits),"The initial value provided for the Cover Gauge Units field does not match the expected value.","The initial value provided for the Cover Gauge Units field matches the expected value.");
        Validator.assertTrue(gaugeTopCoverDropdown.getText().equalsIgnoreCase(gaugeTopCover),"The initial value provided for the Gauge Top Cover field does not match the expected value.","The initial value provided for the Gauge Top Cover field matches the expected value.");
        Validator.assertTrue(gaugePulleyCoverDropdown.getText().equalsIgnoreCase(gaugePulleyCover),"The initial value provided for the Gauge Pulley Cover field does not match the expected value.","The initial value provided for the Gauge Pulley Cover field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInCapacityPage(String beltSpeed,String tonsPerHourPeak){
        Validator.assertTrue(tbBeltSpeed.getAttribute("value").equalsIgnoreCase(beltSpeed),"The initial value provided for the Belt Speed field does not match the expected value.","The initial value provided for the Belt Speed field matches the expected value.");
        Validator.assertTrue(tbTonsPerHourPeak.getAttribute("value").equalsIgnoreCase(tonsPerHourPeak),"The initial value provided for the Tons Per Hour Peak field does not match the expected value.","The initial value provided for the Tons Per Hour Peak field matches the expected value.");

    }

    public void verifyPrePopulatedDetailsInRollDataPage(String totalBeltLength,String numberOfRolls){
        Validator.assertTrue(tbTotalBeltLength.getAttribute("value").equalsIgnoreCase(totalBeltLength),"The initial value provided for the Total Belt Length field does not match the expected value.","The initial value provided for the Total Belt Length field matches the expected value.");
        Validator.assertTrue(tbNumberOfRollsConveyorRollData.getAttribute("value").equalsIgnoreCase(numberOfRolls),"The initial value provided for the Number Of Rolls field does not match the expected value.","The initial value provided for the Number Of Rolls field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInPulleyPage(String pulleyHeadDiameter,String pulleyDriveDiameter,String pulleyTakeUpDiameter,String pulleyTailDiameter){
        Validator.assertTrue(tbPulleyHeadDiameter.getAttribute("value").equalsIgnoreCase(pulleyHeadDiameter),"The initial value provided for the Pulley Head Diameter field does not match the expected value.","The initial value provided for the Pulley Head Diameter field matches the expected value.");
        Validator.assertTrue(tbPulleyDriveDiameter.getAttribute("value").equalsIgnoreCase(pulleyDriveDiameter),"The initial value provided for the Pulley Drive Diameter field does not match the expected value.","The initial value provided for the Pulley Drive Diameter field matches the expected value.");
        Validator.assertTrue(tbPulleyTakeUpDiameter.getAttribute("value").equalsIgnoreCase(pulleyTakeUpDiameter),"The initial value provided for the Pulley Take-Up Diameter field does not match the expected value.","The initial value provided for the Pulley Take-Up Diameter field matches the expected value.");
        Validator.assertTrue(tbPulleyTailDiameter.getAttribute("value").equalsIgnoreCase(pulleyTailDiameter),"The initial value provided for the Pulley Tail Diameter field does not match the expected value.","The initial value provided for the Pulley Tail Diameter field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInTransitionsPage(String transitionLengthHead,String transitionLengthTail){
        Validator.assertTrue(tbLengthHead.getAttribute("value").equalsIgnoreCase(transitionLengthHead),"The initial value provided for the Transition Length Head field does not match the expected value.","The initial value provided for the Transition Length Head field matches the expected value.");
        Validator.assertTrue(tbLengthTail.getAttribute("value").equalsIgnoreCase(transitionLengthTail),"The initial value provided for the Transition Length Tail field does not match the expected value.","The initial value provided for the Transition Length Tail field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInTakeUpPage(String takeUpTensionIfKnown){
        System.out.println("ABCD: ="+tbTakeUpTensionifknown.getAttribute("value"));
        System.out.println("ABCD: ="+takeUpTensionIfKnown);
        Validator.assertTrue(tbTakeUpTensionifknown.getAttribute("value").equalsIgnoreCase(takeUpTensionIfKnown),"The initial value provided for the Take-Up tension (if known) field does not match the expected value.","The initial value provided for the Take-Up tension (if known) field matches the expected value.");
    }

    public void verifyPrePopulatedDetailsInCurvesPage(String curveRadius1,String curveRadius2,String curveRadius3,String curveRadius4){
        Validator.assertTrue(tbCurveRadius1.getAttribute("value").equalsIgnoreCase(curveRadius1),"The initial value provided for the Curve Radius 1 field does not match the expected value.","The initial value provided for the Curve Radius 1 field matches the expected value.");
        Validator.assertTrue(tbCurveRadius2.getAttribute("value").equalsIgnoreCase(curveRadius2),"The initial value provided for the Curve Radius 2 field does not match the expected value.","The initial value provided for the Curve Radius 2 field matches the expected value.");
        Validator.assertTrue(tbCurveRadius3.getAttribute("value").equalsIgnoreCase(curveRadius3),"The initial value provided for the Curve Radius 3 field does not match the expected value.","The initial value provided for the Curve Radius 3 field matches the expected value.");
        Validator.assertTrue(tbCurveRadius4.getAttribute("value").equalsIgnoreCase(curveRadius4),"The initial value provided for the Curve Radius 4 field does not match the expected value.","The initial value provided for the Curve Radius 4 field matches the expected value.");
    }

    public ArrayList<String> getInputPageData(){
        String frictionFactor=getFrictionFactor();
        String lengthFactor=getLengthFactor();
        String driveWrapAngle=getDriveWrapAngle();
        String surchargeAngle=getSurchargeAngle().split("\\(")[1].split("\\s")[0];
        return new ArrayList<>(Arrays.asList(frictionFactor,lengthFactor,driveWrapAngle,surchargeAngle));
    }

    public ArrayList<Float> getFlightConfiguration(String station){
        ArrayList<Float> horzOffset=getHorzOffset(station);
        ArrayList<Float> elevOffset=getElevOffset(station);
        ArrayList<Float> sectionAngle=getSectionAngle(station);
        ArrayList<Float> flightConfiguration=new ArrayList<>();
        for (int i=0;i<Integer.parseInt(station)-1;i++){
            flightConfiguration.add(horzOffset.get(i));
            flightConfiguration.add(elevOffset.get(i));
            flightConfiguration.add(sectionAngle.get(i));
        }
        for (int i=Integer.parseInt(station)-1;i<=Integer.parseInt(station)-1;i++){
            flightConfiguration.add(horzOffset.get(i));
            flightConfiguration.add(elevOffset.get(i));
        }
        flightConfiguration.add(Float.valueOf(tbEstimatedCCLength.getAttribute("value")));
        System.out.println(flightConfiguration);
        return flightConfiguration;
    }

    public ArrayList<String> getConveyorBeltDataInRollDataPage(){
        String beltSpecification=getTbBeltSpecification();
        String carcassMaterial=getTbCarcassMaterial();
        String numberOfPlies=getTbNumberPlies();
        String plyTensionStrength=getTbPlyTensileStrength();
        String beltTensileStrength=getTbBeltTensileStrength();
        String elasticModules=getTbElasticModules();
        String vulcanizedRating=getTbVulcanizedRating();
        String mechanicalRating=getTbMechanicalRating();
        String carcassGauge=getTbCarcassGauge();
        String totalCoverGauge=getTbTotalCoverGauge();
        String totalBeltGauge=getTbTotalBeltGauge();
        String carcassWeight=getTbCarcassWeight();
        String totalCoverWeight=getTbTotalCoverWeight();
        String totalBeltWeight=getTbTotalBeltWeight();
        return new ArrayList<>(Arrays.asList(beltSpecification,carcassMaterial,numberOfPlies,plyTensionStrength,beltTensileStrength,
                elasticModules,vulcanizedRating,mechanicalRating,carcassGauge,totalCoverGauge,totalBeltGauge,
                carcassWeight,totalCoverWeight,totalBeltWeight));
    }

    public ArrayList<String> getConveyorROllDataInRollDataPage(){
        String totalBeltLength=getTotalBeltLength();
        String numberOfRolls=getNumberOfRolls();
        String rollLength=getTbRollLength();
        String rollDiameter=getTbRollDiameter();
        String rollWeight=getTbRollWeight();
        String cubage=getTbCubage();
        return new ArrayList<>(Arrays.asList(totalBeltLength,numberOfRolls,rollLength,rollDiameter,rollWeight,cubage));
    }

    public ArrayList<String> getConveyorSpliceDimensionsDataInRollDataPage(){
        String numberOfRolls=getTbNumberOfRollsConveyorSpliceDimension();
        String vulcanizedSpliceAngle=getTbVulcanizedSpliceAngle();
        String stepLength=getTbStepLength();
        String biasLength=getTbBiasLength();
        String spliceLength=getTbSpliceLength();
        String extraBeltLength=getTbExtraBeltLength();
        return new ArrayList<>(Arrays.asList(numberOfRolls,vulcanizedSpliceAngle,stepLength,biasLength,spliceLength,extraBeltLength));
    }

   public ArrayList<String> getPulleysPageData(){
//        String stationNumberHead=getTbStationNumberHead();
//        String stationNumberDrive=getTbStationNumberDrive();
//        String stationNumberTakeUp=getTbStationNumberTakeUp();
//        String stationNumberTail=getTbStationNumberTail();
        String beltTensionHead=getTbBeltTensionHead();
        String beltTensionDrive=getTbBeltTensionDrive();
        String beltTensionTakeUp=getTbBeltTensionTakeUp();
        String beltTensionTail=getTbBeltTensionTail();
//        String minPulleyDiameterHead=getTbMinPulleyDiameterHead();
//        String minPulleyDiameterDrive=getTbMinPulleyDiameterDrive();
//        String minPulleyDiameterTakeUp=getTbMinPulleyDiameterTakeUp();
//        String minPulleyDiameterTail=getTbMinPulleyDiameterTail();
        String pulleyDiameterHead=getTbPulleyDiameterHead();
        String pulleyDiameterDrive=getTbPulleyDiameterDrive();
        String pulleyDiameterTakeUp=getTbPulleyDiameterTakeUp();
        String pulleyDiameterTail=getTbPulleyDiameterTail();
        return new ArrayList<>(Arrays.asList(
                beltTensionHead,beltTensionDrive,beltTensionTakeUp,beltTensionTail,pulleyDiameterHead,pulleyDiameterDrive,pulleyDiameterTakeUp,pulleyDiameterTail));
   }

   public ArrayList<String> getTransitionsPageData(){
        String beltTensionHead=getTbBeltTensionHeadTransitionLengthPage();
        String beltTensionTail=getTbBeltTensionTailTransitionLengthPage();
//        String idlerAngleHead=getTbIdlerAngleHead();
//        String idlerAngleTail=getTbIdlerAngleTail();
        String troughDepthHead=getTbTroughDepthHead();
        String troughDepthTail=getTbTroughDepthTail();
        String lengthHead=getLengthHead();
        String lengthTail=getLengthTail();
        String edgeTensionHead=getTbEdgeTensionHead();
        String edgeTensionTail=getTbEdgeTensionTail();
        String edgeTensionPercentageHead=getTbEdgeTensionHeadPercentage();
        String edgeTensionPercentageTail=getTbEdgeTensionTailPercentage();
        String centerTensionHead=getTbCenterTensionHead();
        String centerTensionTail=getTbCenterTensionTail();
        String centerTensionPercentageHead=getTbCenterTensionHeadPercentage();
        String centerTensionPercentageTail=getTbCenterTensionTailPercentage();
        return new ArrayList<>(Arrays.asList(beltTensionHead,beltTensionTail,troughDepthHead,troughDepthTail,
                lengthHead,lengthTail,edgeTensionHead,edgeTensionTail,edgeTensionPercentageHead,edgeTensionPercentageTail,centerTensionHead,
                centerTensionTail,centerTensionPercentageHead,centerTensionPercentageTail));
   }

   public ArrayList<String> getReviewCalculatedTakeUpTravelDataTakeUpPage(){
        String takeUpTension=getTbTakeUpTensionTakeUpLevel();
        String counterweightWeight=getTbCounterweightWeightTakeUpLevel();
        String typeOfSplice="";
        SyncUtil.waitFor(2000);
        if(checkedRadioVulcanized.isVisible()) {
            takeUp.jsClick();
            takeUp.click();
        }
        SyncUtil.waitFor(1500);
        if (checkedRadioVulcanized.isSelected()){
            typeOfSplice="Vulcanized";
        }else if(checkedRadioMechanical.isSelected()){
            typeOfSplice="Mechanical";
        }
        return new ArrayList<>(Arrays.asList(takeUpTension,counterweightWeight,typeOfSplice));
   }

   public ArrayList<String> getCalculatedTakeUpDataInTakeUpPage(){
        String maximumBeltTension=getTbMaximumBeltTension();
        String averageBeltTension=getTbAverageBeltTension();
        String permanentElongation=getTbEstimatedTakeUpMovementDueToPermanentElongation();
        String elasticElongation=getTbEstimatedTakeUpMovementDueToElasticElongation();
        String totalEstimatedTakeUpMovementPercentage=getTbTotalEstimatedTakeUpMovementPercentage();
        String estimatedBeltCCLength=getTbEstimatedBeltLength();
        String totalEstimatedTakeUpMovement=getTbTotalEstimatedTakeUpMovement();
        String takeUpTensionIfKnown=getTbTakeUPTensionIfKnown();
        return new ArrayList<>(Arrays.asList(maximumBeltTension,averageBeltTension,permanentElongation,elasticElongation,
                totalEstimatedTakeUpMovementPercentage,estimatedBeltCCLength,totalEstimatedTakeUpMovement,takeUpTensionIfKnown));
   }

   public ArrayList<String> getCalculatedVerticalCurvesDataInCurvesPage(){
        String stationLocation1=getTbStationLocation1();
        String stationLocation2=getTbStationLocation2();
        String stationLocation3=getTbStationLocation3();
        String stationLocation4=getTbStationLocation4();
        String curveDescription1=getTbCurveDescription1();
        String curveDescription2=getTbCurveDescription2();
        String curveDescription3=getTbCurveDescription3();
        String curveDescription4=getTbCurveDescription4();
        String maximumBeltTension1=getTbMaximumBeltTension1();
        String maximumBeltTension2=getTbMaximumBeltTension2();
        String maximumBeltTension3=getTbMaximumBeltTension3();
        String maximumBeltTension4=getTbMaximumBeltTension4();
        String minimumBeltTension1=getTbMinimumBeltTension1();
        String minimumBeltTension2=getTbMinimumBeltTension2();
        String minimumBeltTension3=getTbMinimumBeltTension3();
        String minimumBeltTension4=getTbMinimumBeltTension4();
        String curveRadius1=getTbCurveRadius1();
        String curveRadius2=getTbCurveRadius2();
        String curveRadius3=getTbCurveRadius3();
        String curveRadius4=getTbCurveRadius4();
        String projectedLength1=getTbProjectedLength1();
        String projectedLength2=getTbProjectedLength2();
        String projectedLength3=getTbProjectedLength3();
        String projectedLength4=getTbProjectedLength4();
        String centerTension1=getTbCenterTension1();
        String centerTension2=getTbCenterTension2();
        String centerTension3=getTbCenterTension3();
        String centerTension4=getTbCenterTension4();
        String centerTensionPercentage1=getTbCenterTensionPercentage1();
        String centerTensionPercentage2=getTbCenterTensionPercentage2();
        String centerTensionPercentage3=getTbCenterTensionPercentage3();
        String centerTensionPercentage4=getTbCenterTensionPercentage4();
        String edgeTension1=getTbEdgeTension1();
        String edgeTension2=getTbEdgeTension2();
        String edgeTension3=getTbEdgeTension3();
        String edgeTension4=getTbEdgeTension4();
        String edgeTensionPercentage1=getTbEdgeTensionPercentage1();
        String edgeTensionPercentage2=getTbEdgeTensionPercentage2();
        String edgeTensionPercentage3=getTbEdgeTensionPercentage3();
        String edgeTensionPercentage4=getTbEdgeTensionPercentage4();
        String estimatedLiftOff1=getTbEstimatedLiftOff1();
        String estimatedLiftOff2=getTbEstimatedLiftOff2();
        String estimatedLiftOff3=getTbEstimatedLiftOff3();
        String estimatedLiftOff4=getTbEstimatedLiftOff4();
        return new ArrayList<>(Arrays.asList(stationLocation1,stationLocation2,stationLocation3,stationLocation4,
                curveDescription1,curveDescription2,curveDescription3,curveDescription4,maximumBeltTension1,maximumBeltTension2,
                maximumBeltTension3,maximumBeltTension4,minimumBeltTension1,minimumBeltTension2,minimumBeltTension3,
                minimumBeltTension4,curveRadius1,curveRadius2,curveRadius3,curveRadius4,projectedLength1,projectedLength2,
                projectedLength3,projectedLength4,centerTension1,centerTension2,centerTension3,centerTension4,centerTensionPercentage1,
                centerTensionPercentage2,centerTensionPercentage3,centerTensionPercentage4,edgeTension1,edgeTension2,
                edgeTension3,edgeTension4,edgeTensionPercentage1,edgeTensionPercentage2,edgeTensionPercentage3,edgeTensionPercentage4,
                estimatedLiftOff1,estimatedLiftOff2,estimatedLiftOff3,estimatedLiftOff4));
   }

    public static boolean compareWithPercentageDifference(double value1, double value2) {
        double difference = Math.abs(value1 - value2);
        double average = (value1 + value2) / 2.0;
        double percentageDifference = (difference / average) * 100.0;
        return percentageDifference <= PERCENTAGE_THRESHOLD;
    }

   public void verifyConveyorInformation(ArrayList<String> beltData,String conveyorName,String calculationName,String customer,ArrayList<String> conveyorInformationReport){
        Validator.assertTrue(beltData.get(0).equals(conveyorInformationReport.get(0)),"Belt description in reports is not matching with the entered value","Belt description in reports is matching with the entered value");
       System.out.println(customer);
       System.out.println(conveyorInformationReport.get(1));
        Validator.assertTrue(customer.equals(conveyorInformationReport.get(1)),"Customer in reports is not matching with the calculated value","customer in reports is not matching with the calculated value");
//       Validator.assertTrue(calculationName.equals(conveyorInformationReport.get(2).trim()),"Name in reports is not matching with the entered value","Name in reports is not matching with the entered value");
       System.out.println(conveyorName);
       System.out.println(conveyorInformationReport.get(2));
       Validator.assertTrue(conveyorName.equals(conveyorInformationReport.get(2).trim()),"Conveyor in reports is not matching with the entered value","Conveyor in reports is not matching with the entered value");
   }

    public void verifyConveyorInformation(String conveyorName,String calculationName,String customer,ArrayList<String> conveyorInformationReport){
        Validator.assertTrue(conveyorInformationReport.get(0).contains("AgriFlex"),"Belt description in reports is not matching with the entered value","Belt description in reports is matching with the entered value");
    }

   public void verifySystemCoordinates(ArrayList<Float> flightInformation,ArrayList<Float> systemCoordinatesReport){
       System.out.println("ABCD: = "+flightInformation);
       System.out.println("ABCD: = "+systemCoordinatesReport);
        Validator.assertTrue(flightInformation.equals(systemCoordinatesReport),"System coordinates in reports is not matching with entered value","System coordinates in reports is matching with entered value");
   }

   public void verifyMaterialData(String tonsPerHourPeak,String materialDensity,ArrayList<String> inputData,ArrayList<String> materialDataReport){
       Validator.assertTrue(tonsPerHourPeak.equals(materialDataReport.get(0).trim()),"Tons per hour peak in reports is not matching with the calculated value","Tons per hour in reports is not matching with the calculated value");
       System.out.println("ABCD:= "+materialDensity);
       System.out.println("ABCD:= "+materialDataReport.get(1).trim());
       Validator.assertTrue(materialDensity.equals(materialDataReport.get(1).trim()),"Material Density in reports is not matching with the calculated value","Material Density in reports is not matching with the calculated value");
       Validator.assertTrue(inputData.get(3).equals(materialDataReport.get(2).trim()),"Surcharge Angle in reports is not matching with the calculated value","Surcharge Angle in reports is not matching with the calculated value");
   }

   public void verifyInputBeltData(String beltWidth,String beltSpeed, ArrayList<String> inputBeltDataReport, ArrayList<String> rollDataReport){
       Validator.assertTrue(beltWidth.equals(inputBeltDataReport.get(0).trim()),"Width in reports is not matching with the calculated value","Width in reports is not matching with the calculated value");
       Validator.assertTrue(beltSpeed.equals(inputBeltDataReport.get(1).trim()),"Speed in reports is not matching with the calculated value","Speed in reports is not matching with the calculated value");
       Validator.assertTrue(rollDataReport.get(13).equals(inputBeltDataReport.get(2)),"Weight in reports is not matching with the calculated value","Weight in reports is not matching with the calculated value");
       Validator.assertTrue(rollDataReport.get(10).equals(inputBeltDataReport.get(3)),"OAG in reports is not matching with the calculated value","OAG in reports is not matching with the calculated value");
   }

   public void verifySystemData(ArrayList<String> capacity,String carrySideIdlerSpacing,String driveLocation,String takeUpLocation,ArrayList<String> inputData,ArrayList<String> systemDataReport){
       Validator.assertTrue(capacity.get(1).equals(systemDataReport.get(0)),"Trough Angle of Idlers in reports is not matching with the calculated value","Trough Angle of Idlers in reports is not matching with the calculated value");
       Validator.assertTrue(carrySideIdlerSpacing.equals(systemDataReport.get(1)),"Carry Side Idler Spacing in reports is not matching with the calculated value","Carry Side Idler Spacing in reports is not matching with the calculated value");
       Validator.assertTrue(driveLocation.equals(systemDataReport.get(2).trim()),"Station Location of Drive in reports is not matching with the calculated value","Station Location of Drive in reports is not matching with the calculated value");
       Validator.assertTrue(takeUpLocation.equals(systemDataReport.get(3).trim()),"Station Location of Take-up in reports is not matching with the calculated value","Station Location of Take-up in reports is not matching with the calculated value");
//       Validator.assertTrue(" ".equals(systemDataReport.get(4)),"Weight of Moving Parts in reports is not matching with the calculated value","Weight of Moving Parts in reports is not matching with the calculated value");
//       Validator.assertTrue(" ".equals(systemDataReport.get(5)),"Drive Factor in reports is not matching with the calculated value","Drive Factor reports is not matching with the calculated value");
       Validator.assertTrue(inputData.get(0).equals(systemDataReport.get(6)),"Friction factor in reports is not matching with the calculated value","Friction factor in reports is not matching with the calculated value");
       Validator.assertTrue(inputData.get(1).equals(systemDataReport.get(7)),"Length factor in reports is not matching with the calculated value","Length factor in reports is not matching with the calculated value");
       Validator.assertTrue(inputData.get(2).equals(systemDataReport.get(8)),"Drive wrap in reports is not matching with the calculated value","Drive wrap in reports is not matching with the calculated value");
   }

   public void verifyCalculateData(ArrayList<String> calculatedData,ArrayList<String> rollData,ArrayList<String> calculatedDataReport){
        System.out.println("This is the unit"+calculatedData.get(0)+" "+calculatedDataReport.get(0));
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(0)),parseDouble(calculatedDataReport.get(0))),"Unit tension in reports is not matching with the calculated value","Unit tension in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(1)),parseDouble(calculatedDataReport.get(1))),"Maximum tension in reports is not matching with the calculated value","Maximum tension in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(2)),parseDouble(calculatedDataReport.get(2))),"Effective tension in reports is not matching with the calculated value","Effective tension in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(3)),parseDouble(calculatedDataReport.get(3))),"Belt power in reports is not matching with the calculated value","Belt power in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(4)),parseDouble(calculatedDataReport.get(4))),"Counterweight Weight in reports is not matching with the calculated value","Counterweight Weight in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(5)),parseDouble(calculatedDataReport.get(5))),"Counterweight tension in reports is not matching with the calculated value","Counterweight tension in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(calculatedData.get(6)),parseDouble(calculatedDataReport.get(6))),"Conveyor capacity in reports is not matching with the calculated value","Conveyor capacity in reports is not matching with the calculated value");
       Validator.assertTrue(compareWithPercentageDifference(parseDouble(rollData.get(0)),parseDouble(calculatedDataReport.get(7))),"Estimated belt length in reports is not matching with the calculated value","Estimated belt length in reports is not matching with the calculated value");
   }

   public void verifyBeltData(ArrayList<String> beltData,ArrayList<String> beltDataReport){
        Validator.assertTrue(beltData.get(1).equals(beltDataReport.get(0)),"Carcass material in reports is not matching with the calculated value","Carcass material in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(2).equals(beltDataReport.get(1)),"Number of Plies in reports is not matching with the calculated value","Number of Plies in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(3).equals(beltDataReport.get(2)),"Ply tension in reports is not matching with the calculated value","Ply tension in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(4).equals(beltDataReport.get(3)),"Belt tensile strength in reports is not matching with the calculated value","Belt tensile strength in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(6).equals(beltDataReport.get(4)),"Vulcanized rating in reports is not matching with the calculated value","Vulcanized rating in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(7).equals(beltDataReport.get(5)),"Mechanical rating in reports is not matching with the calculated value","Mechanical rating reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(5).equals(beltDataReport.get(6)),"Elastic modulus in reports is not matching with the calculated value","Elastic modulus in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(8).equals(beltDataReport.get(7)),"Carcass gauge in reports is not matching with the calculated value","Carcass gauge in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(9).equals(beltDataReport.get(8)),"Total cover gauge in reports is not matching with the calculated value","Total cover gauge in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(10).equals(beltDataReport.get(9)),"Total belt gauge in reports is not matching with the calculated value","Total belt gauge in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(11).equals(beltDataReport.get(10)),"Carcass weight in reports is not matching with the calculated value","Carcass weight in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(12).equals(beltDataReport.get(11)),"Total cover weight in reports is not matching with the calculated value","Total cover weight in reports is not matching with the calculated value");
        Validator.assertTrue(beltData.get(13).equals(beltDataReport.get(12)),"Total belt weight in reports is not matching with the calculated value","Total belt weight in reports is not matching with the calculated value");
   }

   public void verifyRollData(ArrayList<String> rollData,ArrayList<String> rollDataReport){
       System.out.println("ABCD:= "+rollData.get(0));
       System.out.println("ABCD:= "+rollDataReport.get(0));
        Validator.assertTrue(rollData.get(0).equals(rollDataReport.get(0)),"Total belt length in reports is not matching with the calculated value","Total belt length in reports is not matching with the calculated value");
       Validator.assertTrue(rollData.get(1).equals(rollDataReport.get(1)),"Number of rolls in reports is not matching with the calculated value","Number of rolls in reports is not matching with the calculated value");
       Validator.assertTrue(rollData.get(2).equals(rollDataReport.get(2)),"Roll length in reports is not matching with the calculated value","Roll length in reports is not matching with the calculated value");
       Validator.assertTrue(rollData.get(3).equals(rollDataReport.get(3)),"Roll diameter in reports is not matching with the calculated value","Roll diameter in reports is not matching with the calculated value");
       Validator.assertTrue(rollData.get(4).equals(rollDataReport.get(4)),"Roll weight in reports is not matching with the calculated value","Roll weight in reports is not matching with the calculated value");
       Validator.assertTrue(rollData.get(5).equals(rollDataReport.get(5)),"Cubage in reports is not matching with the calculated value","Cubage in reports is not matching with the calculated value");
   }

   public void verifyVulcanizedSpliceData(ArrayList<String> vulcanizedSpliceData,ArrayList<String> vulcanizedSpliceDataReport){
       Validator.assertTrue(vulcanizedSpliceData.get(0).equals(vulcanizedSpliceDataReport.get(0)),"Number of splice in reports is not matching with the calculated value","Number of splice in reports is not matching with the calculated value");
       Validator.assertTrue(vulcanizedSpliceData.get(1).equals(vulcanizedSpliceDataReport.get(1)),"Vulcanizer bias angle in reports is not matching with the calculated value","Vulcanizer bias angle in reports is not matching with the calculated value");
       Validator.assertTrue(vulcanizedSpliceData.get(2).equals(vulcanizedSpliceDataReport.get(2)),"Fabric step length in reports is not matching with the calculated value","Fabric step length in reports is not matching with the calculated value");
       Validator.assertTrue(vulcanizedSpliceData.get(3).equals(vulcanizedSpliceDataReport.get(3)),"Bias length in reports is not matching with the calculated value","Bias length in reports is not matching with the calculated value");
       Validator.assertTrue(vulcanizedSpliceData.get(4).equals(vulcanizedSpliceDataReport.get(4)),"Splice length in reports is not matching with the calculated value","Splice length in reports is not matching with the calculated value");
       Validator.assertTrue(vulcanizedSpliceData.get(5).equals(vulcanizedSpliceDataReport.get(5)),"Extra belt length in reports is not matching with the calculated value","Vulcanizer bias angle in reports is not matching with the calculated value");
   }

   public void verifyTakeUpTravel(ArrayList<String> reviewCalculatedTakeUpTravelData,ArrayList<String> calculatedTakeUpData,String typeOfTakeUp,ArrayList<String> takeUpTravelReport){
       System.out.println("This is im printing: "+takeUpTravelReport.get(0)+" "+typeOfTakeUp);
        Validator.assertTrue(takeUpTravelReport.get(0).contains(typeOfTakeUp),"Type of take-up reports is not matching with the calculated value","Type of take-up in reports is not matching with the calculated value");
       Validator.assertTrue(reviewCalculatedTakeUpTravelData.get(2).equals(takeUpTravelReport.get(1)),"Type of splice in reports is not matching with the calculated value","Type of splice in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(0).equals(takeUpTravelReport.get(2)),"Maximum belt tension in reports is not matching with the calculated value","Maximum belt tension in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(1).equals(takeUpTravelReport.get(3)),"Average belt tension in reports is not matching with the calculated value","Average belt tension in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(2).equals(takeUpTravelReport.get(4)),"Est. Take-up Movement due to Permanent Elongation in reports is not matching with the calculated value","Est. Take-up Movement due to Permanent Elongation in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(3).equals(takeUpTravelReport.get(5)),"Est. Take-up Movement due to Elastic Elongation in reports is not matching with the calculated value","Est. Take-up Movement due to Elastic Elongation in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(4).equals(takeUpTravelReport.get(6)),"Estimated Total Take-up Movement percentage in reports is not matching with the calculated value","Estimated Total Take-up Movement percentage in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(5).equals(takeUpTravelReport.get(7)),"Conveyor C-C length in reports is not matching with the calculated value","Conveyor C-C length in reports is not matching with the calculated value");
       Validator.assertTrue(calculatedTakeUpData.get(6).equals(takeUpTravelReport.get(8)),"Estimated Total Take-up Movement in reports is not matching with the calculated value","Estimated Total Take-up Movement in reports is not matching with the calculated value");
   }

   public void verifyVerticalCurve(ArrayList<String> verticalCurve,ArrayList<String> verticalCurveReport){
       System.out.println(verticalCurve);
       System.out.println(verticalCurveReport);
       Validator.assertTrue(verticalCurve.equals(verticalCurveReport),"Vertical curve data shown in reports is not matching with entered value","Vertical curve data shown in reports is matching with entered value");
   }

    public void verifyTransitionLength(ArrayList<String> transitionLength,ArrayList<String> transitionLengthReport){
        System.out.println("ABCD:= "+transitionLength);
        System.out.println("ABCD:= "+transitionLengthReport);
        Validator.assertTrue(transitionLength.equals(transitionLengthReport),"Transition Length data shown in reports is not matching with entered value","Transition Length data shown in reports is matching with entered value");
    }

    public void verifyPulleyData(ArrayList<String> pulleyData,ArrayList<String> pulleyDataReport){
        System.out.println("ABCD:= "+pulleyData);
        System.out.println("ABCD:= "+pulleyDataReport);
        Validator.assertTrue(pulleyData.equals(pulleyDataReport),"Pulley data shown in reports is not matching with entered value","Pulley data shown in reports is matching with entered value");
    }

    public void clickOnSaveAndDownload(){
        if(btnSaveAndDownload.isVisible())
            btnSaveAndDownload.click("Save & Download");
        else btnDownload.click();
    }

    public boolean clickOnCreateCalc(){
        btnCreate.click("Create");
        waitForElementToInvisible(buttonLoader,7000);
        waitForElementToDisplay(toastMsg);
//        SyncUtil.waitFor(60000);
//        toastMsg.getText().contains("created successfully");
        return btSearchinput.isVisible();
    }

    public boolean verifyFailureOnCreateCalc(){
        btnCreate.click("Create");
        waitForElementToDisplay(toastMsg);
        return toastMsg.getText().contains("Failed to create minuteman:");
    }

    public void verifyPDFContents(String calc, ArrayList<String> conveyorInformationReport){
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+calc+".pdf");
        try {
            Validator.assertTrue(PDFHelper.getPageCount(doc) ==2,"PDF Report has incorrect no of pages","PDF report has valid no of pages");
            System.out.println(PDFHelper.getPDFImagesCount(doc));
//            Validator.assertTrue(PDFHelper.getPDFImagesCount(doc) == 2,"PDF Report has unaccepted no of images","PDF report has valid images");
            System.out.println(calc);
            String val = PDFHelper.getPageContent(doc);
            Validator.assertTrue(val.replaceAll("\r\n", " ").replaceAll("\n", " ").trim().contains(conveyorInformationReport.get(2)),"PDF Report was generated for the wrong conveyor","PDF Report was generated for the right conveyor");
            PDFHelper.PDFBoxExtractImages(doc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void verifyPDFContentsBucketElevator(String calc){
        PDDocument doc =  PDFHelper.getPDFData(System.getProperty("user.dir")+separator+"target"+separator+"downloads"+separator+calc+".pdf");
        try {
            Validator.assertTrue(PDFHelper.getPageCount(doc) ==1,"PDF Report has incorrect no of pages","PDF report has valid no of pages");
            System.out.println(PDFHelper.getPDFImagesCount(doc));
//            Validator.assertTrue(PDFHelper.getPDFImagesCount(doc) == 2,"PDF Report has unaccepted no of images","PDF report has valid images");
            String val = PDFHelper.getPageContent(doc);
//            Validator.assertTrue(val.replaceAll("\r\n", " ").replaceAll("\n", " ").trim().contains(calc),"PDF Report was generated for the wrong conveyor","PDF Report was generated for the right conveyor");
            PDFHelper.PDFBoxExtractImages(doc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean goToEditMinutemanCalc(String calc){
        searchMinuteman(calc);
        SyncUtil.waitFor(1000);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        waitForElementVisible(crEdit, 20000,500);
        crEdit.click("Edit");
        return editBreadCrumb.isVisible("Edit breadcrumb");
    }

    public void editMinutemanCalc(String calc, String newCalc){
        goToEditMinutemanCalc(calc);
        setTbCalculationName(newCalc);
        finalReport.jsClick();
//        waitForElementToDisplay(txtName);
//        Validator.assertTrue(newCalc.equals(txtName.getText().trim()),"Name in reports is not matching with the entered value","Name in reports is not matching with the entered value");
        waitForElementToInvisible(spinner,7000);
        scrollPageDown();
        btnSave.click();
        waitForElementToInvisible(buttonLoader,10000);
    }

    public boolean searchMinuteman(String calc){
        gotoMinutemanScreenWait();
        waitForPageLoad(10000);
        btSearchinput.type(calc, "Calc Search");
//        SyncUtil.waitFor(10000);
        waitForElementVisible(crCheckbox,20000,1000);
        waitForElementToDisplay(crCheckbox);
        return crCheckbox.isVisible("Conveyor Found");
    }

    public boolean deleteMinutemanCalc(String calc){
        searchMinuteman(calc);
        SyncUtil.waitFor(1000);
        crCheckbox.check("Conveyor Checkbox");
        crActions.click("Actions");
        waitForElementVisible(crDelete, 20000,500);
        crDelete.click("Delete");
        crYesConfirmation.click("Confirm");
        waitForElementToDisplay(noList);
        SyncUtil.waitFor(2000);
        return noList.isVisible();
    }

    public void verifyDeletedCalc(String calc) {
        gotoMinutemanScreenWait();
        waitForPageLoad(10000);
        btSearchinput.type(calc, "Calc Search");
        Validator.assertTrue(noList.isVisible(),"Delete Calculation was still found in Conveyor list screen","Calculation deleted successfully");
    }

    public boolean verifyAddMinutemanBtnContents(){
        gotoMinutemanScreen();
        btnAdd.click("Add");
        return btnConveyor.isVisible("Elevator") && btnElevator.isVisible("Elevator");
    }

    public void gotoAddMinutemanBucketElevator(){
        gotoMinutemanScreen();
        btnAdd.click("Add");
        btnElevator.click("Elevator");
    }

    public boolean goToAddMinutemanCalc(){
        btnAdd.click("Add");
        btnConveyor.click("Conveyor");
        return tbCalculationName.isVisible();
    }

    public void verifyUnitsRadioPage(){
        Validator.assertTrue(checkedRadioMetric.isSelected(),"Metric radio button should not be selected","Metric radio button is selected as expected");
        Validator.assertTrue(!checkedRadioImperial.isSelected(),"Imperial radio button is selected","Imperial radio button is not selected as expected");
        radioImperial.click("Imperial Unit");
        Validator.assertTrue(checkedRadioImperial.isSelected(),"Imperial radio button should not be selected","Imperial radio button is selected as expected");
        Validator.assertTrue(!checkedRadioMetric.isSelected(),"Metric radio button is selected","Metric radio button is not selected as expected");
        handleUnitsPopup("Imperial");
    }

    public boolean isStationScreen(){
        return stationLabel.isVisible("Station Label");
    }

    public boolean isFlightScreen(){
        return flightHeader.isVisible("Flight Label");
    }

    public boolean isBeltScreen(){
        return selectBeltHeader.isVisible("Select Belt Header");
    }

    public boolean isCapacityScreen(){
        return capacityHeader.isVisible("Capacity Header");
    }

    public boolean isRollDataScreen(){
        return rollDataHeader.isVisible("Roll Data Header");
    }

    public boolean isPulleyScreen(){
        return pulleyHeader.isVisible("Pulley Header");
    }

    public boolean isTransactionScreen(){
        return transactionHeader.isVisible("Transaction Header");
    }

    public boolean isCurvesScreen(){
        return curvesHeader.isVisible("Curves Header");
    }

    public boolean isFinalReportScreen(){
        return btnSaveAndDownload.isVisible("Final Report Header");
    }

    public void deleteMinuteman(String name){
        btSearchinput.type(name);
        waitForElementToDisplay(crCheckbox);
        crCheckbox.check("minuteman Checkbox");
        crActions.click("Actions");
        crDelete.click("delete");
    }

    public void verifyStationSelection(){
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[1]")).isSelected(),"Station 1 radio button should not be selected","Station 1 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[2]")).isSelected(),"Station 2 radio button should not be selected","Station 2 radio button is selected as expected");
        Validator.assertTrue(!driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[3]")).isSelected(),"Station 3 radio button is selected","Station 3 radio button is not selected as expected");
        Validator.assertTrue(!driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[4]")).isSelected(),"Station 4 radio button is selected","Station 4 radio button is not selected as expected");
        Validator.assertTrue(!driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[5]")).isSelected(),"Station 5 radio button is selected","Station 5 radio button is not selected as expected");
        Validator.assertTrue(!driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[6]")).isSelected(),"Station 6 radio button is selected","Station 6 radio button is not selected as expected");
        SyncUtil.waitFor(1000);
        driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station'])[3]")).click();
        waitForElementToInvisible(spinner,10000);
        driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station'])[4]")).click();
        waitForElementToInvisible(spinner,10000);
        driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station'])[5]")).click();
        waitForElementToInvisible(spinner,10000);
        driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station'])[6]")).click();
        waitForElementToInvisible(spinner,10000);
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[1]")).isSelected(),"Station 1 radio button should not be selected","Station 1 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[2]")).isSelected(),"Station 2 radio button should not be selected","Station 2 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[3]")).isSelected(),"Station 3 radio button should not be selected","Station 3 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[4]")).isSelected(),"Station 4 radio button should not be selected","Station 4 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[5]")).isSelected(),"Station 5 radio button should not be selected","Station 5 radio button is selected as expected");
        Validator.assertTrue(driver.findElement(By.xpath("(//p-checkbox[@formcontrolname='station']//input)[6]")).isSelected(),"Station 6 radio button should not be selected","Station 6 radio button is selected as expected");
    }

    public void setTbConveyorType(String conveyorType){
        dropdownSelect(tbConveyorType,listItem,conveyorType);
    }

    public void setTbDensity(String materialDensity){
        tbDensity.type(materialDensity,"Material Density");
    }

    public void settbTonPerHrPeak(String tbTonsPerHrPeak){
        tbTonPerHrPeak.type(tbTonsPerHrPeak,"Tons per hour peak");
    }

    public void settbMaterialLength(String materialLength){
        tbMaterialLength.type(materialLength,"material Length");
    }

    public void settbMaterialProjection(String materialProjection){
        tbMaterialProjection.type(materialProjection,"material Projection");
    }

    public void settbMaterialSpacing(String materialSpacing){
        tbMaterialSpacing.type(materialSpacing,"material Spacing");
    }

    public void settbMaterialWeight(String materialSpacing){
        tbMaterialWeight.type(materialSpacing,"material Spacing");
    }

    public void settbMaterialVolume(String materialVolume){
        tbMaterialVolume.type(materialVolume,"material Volume");
    }

    public void settbBucketRows(String bucketRows){
        tbBucketRows.type(bucketRows,"bucket Rows");
    }

    public void settbMaterialWidth(String materialWidth){
        tbMaterialWidth.type(materialWidth,"material Width");
    }

    public void settbMaterialHeight(String materialHeight){
        tbMaterialHeight.type(materialHeight,"material Height");
    }

    public void settbMaterialSpeed(String materialSpeed){
        tbMaterialSpeed.type(materialSpeed,"material Speed");
    }

    public void settbDrivePulley(String drivePulley){
        dropdownSelect(tbDrivePulley,listItem,drivePulley);
    }

    public void settbTakeUpType(String takeUpType){
        dropdownSelect(tbTakeUpType,listItem,takeUpType);
    }

    public String getTbMaterialTension(){
        return tbMaterialTension.getAttribute("value");
    }

    public String getTbMaximumPIW(){
        return tbMaterialPIW.getAttribute("value");
    }

    public String getTbEffectiveTension(){
        return tbEffectiveTension.getAttribute("value");
    }

    public String getTbBeltHorsepower(){
        return tbBeltHorsepower.getAttribute("value");
    }

    public String getTbPercentLoaded(){
        return tbPercentLoaded.getAttribute("value");
    }

    public String getTbCounterweightTension(){
        return tbCounterweightTensionn.getAttribute("value");
    }

    public String getTbCounterweightWeight(){
        return tbCounterweightWeight.getAttribute("value");
    }

    public String getTbEachBucketWeight(){
        return tbEachBucketWeight.getAttribute("value");
    }

    public String getTbHeadPulleyDiameter(){
        return tbHeadPulleyDeameter.getAttribute("value");
    }

    public String getTbTailPulleyDiameter(){
        return tbTailPulleyDiaeter.getAttribute("value");
    }

    public String getTbMaximumProjection(){
        return tbMaximumProjection.getAttribute("value");
    }

    public String getTbApproximateNumber(){
        return tbApproximateNumber.getAttribute("value");
    }

    public String getTbMaterialDensity(){
        return tbDensity.getAttribute("value");
    }

    public String getTbTonPerHrPeak(){
        return tbTonPerHrPeak.getAttribute("value");
    }

    public String getTbMaterialLength(){
        return tbMaterialLength.getAttribute("value");
    }

    public String getTbMaterialProjection(){
        return tbMaterialProjection.getAttribute("value");
    }

    public String getTbMaterialSpacing(){
        return tbMaterialSpacing.getAttribute("value");
    }

    public String getTbMaterialWeight(){
        return tbMaterialWeight.getAttribute("value");
    }

    public String getTbMaterialVolume(){
        return tbMaterialVolume.getAttribute("value");
    }

    public String getTbBucketRows(){
        return tbBucketRows.getAttribute("value");
    }

    public String getTbMaterialWidth(){
        return tbMaterialWidth.getAttribute("value");
    }

    public String getTbMaterialHeight(){
        return tbMaterialHeight.getAttribute("value");
    }

    public String getTbMaterialSpeed(){
        return tbMaterialSpeed.getAttribute("value");
    }

    public String getTbDrivePulley(){
        return tbDrivePulley.getAttribute("value");
    }

    public String getTbTakeUpType(){
        return tbTakeUpType.getAttribute("value");
    }

    public void setTbElevatorCalculationName(String calculationName){
        tbElevatorCalculationName.type(calculationName,"Calculation Name");
    }


    public ArrayList<String> getElevatorInputPageData(){
        String materialDensity=getTbMaterialDensity();
        String tonPerHrPeak=getTbTonPerHrPeak();
        String materialLength=getTbMaterialLength();
        String materialProjection=getTbMaterialProjection();
        String materialSpacing=getTbMaterialSpacing();
        String materialWeight=getTbMaterialWeight();
        String materialVolume=getTbMaterialVolume();
        String bucketRows=getTbBucketRows();
        String materialWidth=getTbMaterialWidth();
        String materialHeight=getTbMaterialHeight();
        String materialSpeed=getTbMaterialSpeed();
        String drivePulley=getTbDrivePulley();
        String takeUpType=getTbTakeUpType();
        return new ArrayList<>(Arrays.asList(materialDensity,tonPerHrPeak,materialLength,materialProjection,
                materialSpacing,materialWeight,materialVolume,bucketRows,materialWidth,materialHeight,materialSpeed,drivePulley,takeUpType));
    }

    public ArrayList<String> getCalculatedOutputPage(){
        String maximumTension=getTbMaterialTension();
        String maximumPIW=getTbMaximumPIW();
        String effectiveTension=getTbEffectiveTension();
        String beltHorsepower=getTbBeltHorsepower();
        String percentLoaded=getTbPercentLoaded();
        String counterweightTensionn=getTbCounterweightTension();
        String counterweightWeight=getTbCounterweightWeight();
        String eachBucketWeight=getTbEachBucketWeight();
        String headPulleyDiameter=getTbHeadPulleyDiameter();
        String tailPulleyDiameter=getTbTailPulleyDiameter();
        String maximumProjection=getTbMaximumProjection();
        String approximateNumber=getTbApproximateNumber();
        return new ArrayList<>(Arrays.asList(maximumTension,maximumPIW,effectiveTension,beltHorsepower,percentLoaded,counterweightTensionn,counterweightWeight,
                eachBucketWeight,headPulleyDiameter,tailPulleyDiameter,maximumProjection,approximateNumber));
    }

    public void isInputsScreen(){
        tbConveyorType.isVisible("Conveyor Type");
    }

    public String getConveyorTypeToText(String conveyorType){
        if(conveyorType.equalsIgnoreCase("A"))
            return "Grain Service";
        else if(conveyorType.equalsIgnoreCase("B"))
            return "Spaced Bucket, Industrial Service";
        else return "Continuous Bucket, Industrial Service";
    }

    public void getConveyorTypeText(String conveyorType){
        Validator.assertTrue(conveyorTypeText.getText("Conveyor Text").contains(getConveyorTypeToText(conveyorType)),"Conveyor type text is improper","Conveyor type text is verified successfully");
    }
    public void verifyElevatorConveyorInformation(String customer,String calculationName,String tradeName,ArrayList<String> conveyorInformationReport){
        System.out.println(txtElevatorBeltDescription.getText());
        System.out.println(tradeName);
//        Validator.assertTrue(txtElevatorBeltDescription.getText().contains(tradeName),"Belt description in reports is not matching with the entered value","Belt description in reports is matching with the entered value");
        Validator.assertTrue(customer.equals(conveyorInformationReport.get(0)),"Customer in reports is not matching with the calculated value","customer in reports is not matching with the calculated value");
//        Validator.assertTrue(calculationName.equals(conveyorInformationReport.get(2).trim()),"Name in reports is not matching with the entered value","Name in reports is matching with the entered value");
         Validator.assertTrue(txtElevatorConveyor.getText().equals("-"),"Conveyor in reports is not matching with the entered value","Conveyor in reports is not matching with the entered value");
    }

    public void verifyElevatorConveyorInformation(String customer,String calculationName,ArrayList<String> conveyorInformationReport){
        Validator.assertTrue(txtElevatorConveyor.getText().equals("-"),"Conveyor in reports is not matching with the entered value","Conveyor in reports is not matching with the entered value");
    }

    public void verifyGivenData(String ConveyorType,String materialDensity,String tonsPerHourPeak,String materialProjection, String materialLength,String materialSpacing,String materialWeight,String materialVolume,String bucketRows,String materialWidth,String materialHeight,String materialSpeed,String beltWeight,String drivePulley,String takeUpType){
        System.out.println(materialDensity);
        System.out.println(txtElevatorMaterialDensity.getText());
        Validator.assertTrue(txtElevatorMaterialDensity.getText().equals(materialDensity),"materialDensity in reports is not matching with the calculated value","materialDensity in reports is not matching with the calculated value");
        System.out.println(getConveyorTypeToText(ConveyorType));
        System.out.println(txtElevatorConveyorType.getText());
        Validator.assertTrue(txtElevatorConveyorType.getText().equals(getConveyorTypeToText(ConveyorType)),"ConveyorType in reports is not matching with the calculated value","ConveyorType in reports is not matching with the calculated value");
        System.out.println(tonsPerHourPeak);
        System.out.println(txtElevatortonPerPeak.getText());
        Validator.assertTrue(txtElevatortonPerPeak.getText().equals(tonsPerHourPeak),"tonsPerHourPeak in reports is not matching with the calculated value","tonsPerHourPeak in reports is not matching with the calculated value");
        System.out.println(materialProjection);
        System.out.println(txtElevatorBucketProjection.getText());
        Validator.assertTrue(txtElevatorBucketProjection.getText().contains(materialProjection),"Material Projection in reports is not matching with the calculated value","Material Projection in reports is not matching with the calculated value");
        System.out.println(materialLength);
        System.out.println(txtElevatorBucketLength.getText());
        Validator.assertTrue(txtElevatorBucketLength.getText().equals(materialLength),"Material Length in reports is not matching with the calculated value","Material Length in reports is not matching with the calculated value");
        System.out.println(materialVolume);
        System.out.println(txtElevatorBucketVolume.getText());
        Validator.assertTrue(txtElevatorBucketVolume.getText().equals(materialVolume),"Material Volume in reports is not matching with the calculated value","Material Volume in reports is not matching with the calculated value");
        System.out.println(materialWidth);
        System.out.println(txtElevatorBeltWidth.getText());
        Validator.assertTrue(txtElevatorBeltWidth.getText().equals(materialWidth),"Belt Width in reports is not matching with the calculated value","Belt Width in reports is not matching with the calculated value");
        System.out.println(materialHeight);
        System.out.println(txtElevatorBeltHeight.getText());
        Validator.assertTrue(txtElevatorBeltHeight.getText().equals(materialHeight),"Belt Height in reports is not matching with the calculated value","Belt Height in reports is not matching with the calculated value");
        System.out.println(materialSpeed);
        System.out.println(txtElevatorBeltSpeed.getText());
        Validator.assertTrue(txtElevatorBeltSpeed.getText().equals(materialSpeed),"Belt Speed in reports is not matching with the calculated value","Belt Speed in reports is not matching with the calculated value");
        System.out.println(takeUpType);
        System.out.println(txtElevatorTakeUp.getText());
        Validator.assertTrue(txtElevatorTakeUp.getText().equals(takeUpType),"TakeUp Type in reports is not matching with the calculated value","TakeUp Type in reports is not matching with the calculated value");
        System.out.println(drivePulley);
        System.out.println(txtElevatorDrivePulley.getText());
        Validator.assertTrue(txtElevatorDrivePulley.getText().equals(drivePulley),"Drive Pulley in reports is not matching with the calculated value","Drive Pulley in reports is not matching with the calculated value");
        System.out.println(materialWeight);
        System.out.println(txtElevatorBucketWeight.getText());
        Validator.assertTrue(txtElevatorBucketWeight.getText().equals(materialWeight),"Material Weight in reports is not matching with the calculated value","Material Weight in reports is not matching with the calculated value");
        System.out.println(beltWeight);
        System.out.println(txtElevatorBeltWeight.getText());
        Validator.assertTrue(txtElevatorBeltWeight.getText().equals(beltWeight),"materialDensity in reports is not matching with the calculated value","materialDensity in reports is not matching with the calculated value");
        System.out.println(materialSpacing);
        System.out.println(txtElevatorBucketSpacing.getText());
        Validator.assertTrue(txtElevatorBucketSpacing.getText().equals(materialSpacing),"Bucket Spacing in reports is not matching with the calculated value","Bucket Spacing in reports is not matching with the calculated value");
        System.out.println(bucketRows);
        System.out.println(txtElevatorBucketRows.getText());
        Validator.assertTrue(txtElevatorBucketRows.getText().equals(bucketRows),"Bucket Rows in reports is not matching with the calculated value","Bucket Rows in reports is not matching with the calculated value");
    }

    public void verifyCalculatedData(String maximumTension,String maximumPIW,String effectiveTension,String beltHorsepower,String percentLoaded,String counterweightTension,String counterweightWeight,String weightInEachBucket){
        System.out.println(effectiveTension);
        System.out.println(txtElevatorEffectiveTension.getText());
        Validator.assertTrue(txtElevatorEffectiveTension.getText().equals(effectiveTension),"effectiveTension in reports is not matching with the calculated value","effectiveTension in reports is not matching with the calculated value");
        System.out.println(maximumTension);
        System.out.println(txtElevatorMaximumTension.getText());
        Validator.assertTrue(txtElevatorMaximumTension.getText().equals(maximumTension),"maximumTension in reports is not matching with the calculated value","maximumTension in reports is not matching with the calculated value");
        System.out.println(counterweightTension);
        System.out.println(txtElevatorCounterweightTension.getText());
        Validator.assertTrue(txtElevatorCounterweightTension.getText().equals(counterweightTension),"counterweightTension in reports is not matching with the calculated value","counterweightTension in reports is not matching with the calculated value");
        System.out.println(counterweightWeight);
        System.out.println(txtElevatorCounterweightWeight.getText());
        Validator.assertTrue(txtElevatorCounterweightWeight.getText().equals(counterweightWeight),"counterweightWeight in reports is not matching with the calculated value","counterweightWeight in reports is not matching with the calculated value");
        System.out.println(weightInEachBucket);
        System.out.println(txtElevatorEachBucketWeight.getText());
        Validator.assertTrue(txtElevatorEachBucketWeight.getText().equals(weightInEachBucket),"counterweightWeight in reports is not matching with the calculated value","counterweightWeight in reports is not matching with the calculated value");
        System.out.println(beltHorsepower);
        System.out.println(txtElevatorBeltHorsepower.getText());
        Validator.assertTrue(txtElevatorBeltHorsepower.getText().equals(beltHorsepower),"beltHorsepower in reports is not matching with the calculated value","beltHorsepower in reports is not matching with the calculated value");
        System.out.println(percentLoaded);
        System.out.println(txtElevatorBucketCapacity.getText());
        Validator.assertTrue(txtElevatorBucketCapacity.getText().split("\\s")[0].equals(percentLoaded),"percentLoaded in reports is not matching with the calculated value","percentLoaded in reports is not matching with the calculated value");
        System.out.println(maximumPIW);
        System.out.println(txtElevatorMaximumPIW.getText());
        Validator.assertTrue(txtElevatorMaximumPIW.getText().equals(maximumPIW),"maximumPIW in reports is not matching with the calculated value","maximumPIW in reports is not matching with the calculated value");

    }

    public void verifyAdditionalData(String mimTailPulleyDiameter,String maximumProjection,String appropriateNumber){
        System.out.println(maximumProjection);
        System.out.println(txtElevatorMaxBucketProjection.getText());
        Validator.assertTrue(txtElevatorMaxBucketProjection.getText().equals(maximumProjection),"maximumProjection in reports is not matching with the calculated value","maximumProjection in reports is not matching with the calculated value");
        System.out.println(mimTailPulleyDiameter);
        System.out.println(txtElevatorMinHeadPulleyDiameter.getText());
        Validator.assertTrue(txtElevatorMinHeadPulleyDiameter.getText().equals(mimTailPulleyDiameter),"mimTailPulleyDiameter in reports is not matching with the calculated value","mimTailPulleyDiameter in reports is not matching with the calculated value");
        System.out.println(appropriateNumber);
        System.out.println(txtElevatorBucketNumber.getText());
        Validator.assertTrue(txtElevatorBucketNumber.getText().equals(appropriateNumber),"appropriateNumber in reports is not matching with the calculated value","appropriateNumber in reports is not matching with the calculated value");


    }

    public void closeWarning(){
        if(warningPopup.isVisible())
            unitYes.click();
        else {
            home.click();
            if (warningPopup.isVisible())
                unitYes.click();
        }
    }

    public void handleUnitsPopup(String units){
//        if (units.equalsIgnoreCase("Imperial")){
          if(unitsPopup.isVisible()){
            waitForElementToDisplay(unitsPopup);
            if(unitsPopup.isVisible())
                unitYes.click();
        }
    }

    public ArrayList<String> getElevatorConveyorInformation(){
//        String[] data=txtElevatorBeltDescription.getText().split("\\r?\\n");
//        String beltDescription = data[1].split(":")[1].trim();
        String customer=txtElevatorCustomer.getText();
//        String conveyor = txtElevatorConveyor.getText();
        return new ArrayList<> (Arrays.asList(customer));
    }

    public boolean isConveyorDropdownDisabled(){
        return conveyorDropdownStatus.getAttribute("class").contains("disabled");
    }

    public boolean isSelectBeltScreen(){
        return tradeNameDropdown.isVisible("Trade Dropdown");
    }

    public ArrayList<String> getCalculatedDataInElevatorSelectBelt(){
        String[] unitTension = textMaximumTension.getText().trim().split("\\s");
        String[] maximumTension = textMaximumPIW.getText().trim().split("\\s");
        String[] effectiveTension = textEffectiveTension.getText().trim().split("\\s");
        String[] beltPower = textBeltPower.getText().trim().split("\\s");
        String[] counterweightWeight = textCounterweightWeight.getText().trim().split("\\s");
        String[] counterweightTension = textCounterweightTension.getText().trim().split("\\s");
        String[] conveyorCapacity = textWeightEachBucket.getText().trim().split("\\s");
        String[] percentLoaded = textPercentLoaded.getText().trim().split("\\s");
        return new ArrayList<>(Arrays.asList(unitTension[0], maximumTension[0], effectiveTension[0], beltPower[0], counterweightWeight[0], counterweightTension[0],
                conveyorCapacity[0],percentLoaded[0]));
    }

    public void validateMinutemanCountWrtPagination(){
        int deviceCount = Integer.parseInt(MiscUtils.regexExtractor(paginationEntry.getText(), "(\\d+)(?!.*\\d)"));
        Validator.assertTrue(apiBase.getMinutemanCount().get("count").equals(deviceCount),"Minuteman Pagination Count does not match","Minuteman Pagination Count matches");
        Validator.assertTrue(Integer.toString(deviceCount).equals(minutemanCardCount.getText()),"Minuteman Card Count does not match","Minuteman Card Count matches");
    }

    public int getTotalMinutemanCount(){
        SyncUtil.waitFor(3000);
        return Integer.parseInt(txtMinutemanCount.getText("Minuteman count"));
    }

    public void editMinutemanCalcUnit(String calc, String units, String program, String location){
        goToEditMinutemanCalc(calc);
        selectUnit(units);
        SyncUtil.waitFor(500);
        handleUnitsPopup(units);
        setTbProgram(program);
        setTbManufacturingLocation(location);
        clickOnSelectBelt();
        waitForElementToInvisible(spinner,7000);
        SyncUtil.waitFor(1500);
        waitForElementToBeClickable(finalReport);
        finalReport.jsClick();
//        waitForElementToDisplay(txtName);
//        Validator.assertTrue(newCalc.equals(txtName.getText().trim()),"Name in reports is not matching with the entered value","Name in reports is not matching with the entered value");
        waitForElementToInvisible(spinner,7000);
        scrollPageDown();
        btnSave.click();
        waitForElementToInvisible(buttonLoader,10000);
    }

    public void editBucketMinutemanCalcUnit(String calc, String units, String program, String location){
        goToEditMinutemanCalc(calc);
        selectUnit(units);
        SyncUtil.waitFor(500);
        handleUnitsPopup(units);
        setTbProgram(program);
        setTbManufacturingLocation(location);
        clickOnStations();
        waitForElementToInvisible(skeleton,7000);
        clickOnSelectBelt();
        waitForElementToInvisible(skeleton,7000);
        scrollPageDown();
        btnSave.click();
        waitForElementToInvisible(buttonLoader,10000);
    }

    public boolean isLoadData(){
        return loadData.isEnabled();
    }

    public boolean  loadDataFunctionality(){
        loadData.click("load data");
        return loadDataToastMsg.isVisible("load data toast");
    }

    public void calculateTransition(String val){
        transitions.jsClick();
        tbTransitionHeadLength.type(val);
        btnCalculate.click();
        waitForElementToInvisible(spinner,7000);
    }

    public void calculateCurves(String val){
        curves.click();
        tbCurveRadius1.type(val);
        btnCalculate.click();
        waitForElementToInvisible(spinner,7000);
    }

    public void calculatePulleys(String val){
        pulleys.click();
        tbPulleyHeadDiameter.type(val);
        btnCalculate.click();
        waitForElementToInvisible(spinner,7000);
    }

    public void calculateTakeUp(String val){
        takeUp.jsClick();
        tbTakeUpTension.type(val);
        btnCalculate.click();
        waitForElementToInvisible(spinner,7000);
    }

    public boolean verifyNotesFromFinalReport(){
        SyncUtil.waitFor(1000);
        finalReport.click();
        waitForElementToInvisible(spinner,7000);
        return counterWeightNote.isVisible("Counter Weight notes") && pulleyNote.isVisible("Pulley Notes") && curvesNote.isVisible("Curves Notes")
                && estimatedLengthNote.isVisible("Estimated Length notes") && transitionLengthNote.isVisible("Transition notes");
    }

}