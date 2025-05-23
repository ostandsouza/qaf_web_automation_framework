package com.web.steps;

import com.common.utils.MiscUtils;
import com.common.utils.SyncUtil;
import com.mobile.flutter.app.pages.DashboardPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;
import com.web.pages.ConveyorPage;
import com.web.pages.CorporatePage;
import com.web.pages.MinutemanPage;
import com.web.pages.SitePage;

import java.util.ArrayList;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


public class MinutemanSteps {
    MinutemanPage minutemanPage=new MinutemanPage();
    CorporatePage corpPage=new CorporatePage();
    ConveyorPage conveyorPage=new ConveyorPage();
    SitePage sitePage=new SitePage();

    ArrayList<String> inputDataPage=new ArrayList<>();

    ArrayList<Float> flightInfoPage=new ArrayList<>();
    ArrayList<String> calculatedData=new ArrayList<>();
    ArrayList<String> capacity=new ArrayList<>();
    ArrayList<String> conveyorBeltDataInRollDataPage=new ArrayList<>();
    ArrayList<String> conveyorROllDataInRollDataPage=new ArrayList<>();
    ArrayList<String> conveyorSpliceDimensionsDataInRollDataPage=new ArrayList<>();
    ArrayList<String> pulleysPageData=new ArrayList<>();
    ArrayList<String> transitionsPageData=new ArrayList<>();
    ArrayList<String> reviewCalculatedTakeUpTravelDataTakeUpPage=new ArrayList<>();
    ArrayList<String> calculatedTakeUpDataInTakeUpPage=new ArrayList<>();
    ArrayList<String> calculatedVerticalCurvesDataInCurvesPage=new ArrayList<>();

    ArrayList<String> inputElevatorDataPage=new ArrayList<>();
    ArrayList<String> calculatedElevatorOutputPage=new ArrayList<>();

    @QAFTestStep(description = "User is at add minuteman conveyor page")
    public void userAtMinutemanPage(){
        minutemanPage.gotoAddMinutemanConveyor();
    }

    @QAFTestStep(description = "User is at add minuteman conveyor page {CalculationName}")
    public void userAtMinutemanPageCalc(String calc){
        String minutemanId = minutemanPage.apiBase.getMinutemanAPI(calc);
        System.out.println(minutemanId);
        minutemanPage.apiBase.deleteMinutemanAPI(minutemanId);
        minutemanPage.gotoAddMinutemanConveyor();
    }

    @QAFTestStep(description = "User is at add minuteman conveyor page {CalculationName} from conveyor level {ConveyorName}")
    public void userIsAtAddMinutemanConveyorPageFromConveyorLevel(String calc, String conveyor){
        String minutemanId = minutemanPage.apiBase.getMinutemanAPI(calc);
        System.out.println(minutemanId);
        minutemanPage.apiBase.deleteMinutemanAPI(minutemanId);
        conveyorPage.goToConveyorDetailScreen(conveyor);
        SyncUtil.waitFor(5000);
        minutemanPage.verifyMinutemanCardClick();
    }

    @QAFTestStep(description = "User is at add minuteman conveyor page {CalculationName} from site level {Site}")
    public void userIsAtAddMinutemanConveyorPageFromSiteLevel(String calc, String site){
        String minutemanId = minutemanPage.apiBase.getMinutemanAPI(calc);
        System.out.println(minutemanId);
        minutemanPage.apiBase.deleteMinutemanAPI(minutemanId);
        sitePage.goToSiteDetails(site);
        SyncUtil.waitFor(5000);
        minutemanPage.verifyMinutemanCardClick();
    }

    @QAFTestStep(description = "Station Page {CalculationName} {BeltWidth} {BeltSpeed} {TonsPerHourPeak} {PickMaterialName} {MaterialDensity} {AngleOfIdler} {CarrySideIdlerSpacing} {DriveWrapAngle} {DriveWrapAngleDegree} {TakeUpTension} {FrictionFactor} {LengthFactor} {SurchargeAngle} {IdlerOffset} {DriverDetails} {TakeUpDetails} {SpliceType} {Stations} {DriveLocation} {TakeUpLocation} {HorzOffset} {ElevOffset} {SectionAngle} {EstimatedCCLength} {TypeOfConfiguration} {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover} {CalculationName} {ConveyorName}")
    public void stationScreen(String CalculationName,String beltWidth,String beltSpeed,String tonsPerHourPeak,String pickMaterialName,String materialDensity, String angleOfIdlers, String carrySideIdler, String driveWrapAngle,String driveWrapAngleDegree,String takeUpTension,String frictionFactor,String lengthFactor,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails, String spliceType,String stations,String driveLocation,String takeUpLocation, String[] horzOffset,String[] elevOffset, String[] sectionAngle,String estimatedCCLength,String typeOfConfiguration,String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover,String calculationName,String conveyorName){
        SyncUtil.waitFor(20000);
        minutemanPage.setTbCalculationName(CalculationName);
        minutemanPage.clickNext();
        SyncUtil.waitFor(1000);
//        minutemanPage.clickOnPulley();
//        SyncUtil.waitFor(5000);
        minutemanPage.clickNext();
        SyncUtil.waitFor(1000);
//
        minutemanPage.clickNext();
        SyncUtil.waitFor(10000);
//        System.out.println("This is flight : "+minutemanPage.getFlightConfiguration(stations));
//        flightInfoPage=minutemanPage.getFlightConfiguration(stations);
//
        minutemanPage.clickNext();
        SyncUtil.waitFor(15000);
        minutemanPage.clickOnFinalReport();
        SyncUtil.waitFor(2000);
        System.out.println("This is data : "+minutemanPage.getTransitionLength());
//       minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//       minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        System.out.println("data free string"+minutemanPage.getCalculatedVerticalCurvesDataInCurvesPage());
//        minutemanPage.clickNext();
//        SyncUtil.waitFor(1000);
//        System.out.println("This is data"+calculatedVerticalCurvesDataInCurvesPage);
//        System.out.println("This is data1"+minutemanPage.getVerticalCurves());
//        if(flightInfoPage.equals(minutemanPage.getSystemCoordinates()))
//            System.out.println("Both are equal");
//        SyncUtil.waitFor(10000);
    }

    @QAFTestStep(description="User enters general info {0} {1} {2} {3} {4} {5} {6} and click on next")
    public void userEntersGeneralInfoAndClickOnNext(String calculationName, String site, String conveyorName, String description, String program, String manufacturingLocation, String units){
//        SyncUtil.waitFor(5000);
        minutemanPage.setTbCalculationName(calculationName);
        minutemanPage.selectUnit(units);
        SyncUtil.waitFor(500);
        minutemanPage.handleUnitsPopup(units);
        minutemanPage.setSiteDropdown(site);
        minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.setTbDescription(description);
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacturingLocation);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters general info {CalculationName} {ConveyorName} {Description} {Program} {ManufacturingLocation} {Units} and click on next")
    public void userEntersGeneralInfo(String calculationName, String conveyorName, String description, String program, String manufacturingLocation, String units){
//        SyncUtil.waitFor(5000);
        minutemanPage.setTbCalculationName(calculationName);
        minutemanPage.selectUnit(units);
        SyncUtil.waitFor(500);
        minutemanPage.handleUnitsPopup(units);
        minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.setTbDescription(description);
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacturingLocation);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User is navigates to add minuteman conveyor page from list screen")
    public void navigateToMinutemanConveyor(){
        minutemanPage.goToAddMinutemanConveyorFromList();
    }


    @QAFTestStep(description="User enters general info with {0} {1} {2} {3} {4} and click on next")
    public void userEntersGeneralInfoAndClickOnNext(String calculationName, String description, String program, String manufacturingLocation, String units){
//        SyncUtil.waitFor(5000);
        minutemanPage.setTbCalculationName(calculationName);
        minutemanPage.selectUnit(units);
        SyncUtil.waitFor(500);
        minutemanPage.handleUnitsPopup(units);
        minutemanPage.setTbDescription(description);
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacturingLocation);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters inputs {BeltWidth} {BeltSpeed} {TonsPerHourPeak} {PickMaterialName} {MaterialDensity} {AngleOfIdler} {CarrySideIdlerSpacing} {DriveWrapAngle} {FrictionFactor} {LengthFactor} {SurchargeAngle} {IdlerOffset} {DriverDetails} {TakeUpDetails} {SpliceType} and click on next")
    public void userEntersInputDetails(String beltWidth, String beltSpeed, String tonsPerHourPeak, String pickMaterialName, String materialDensity, String angleOfIdler, String carrySideIdlerSpacing, String driveWrapAngle, String frictionFactor, String lengthFactor, String surchargeAngle, String idlerOffset, String driverDetails, String takeUpDetails, String spliceType){
        SyncUtil.waitFor(2000);
        minutemanPage.setTbBeltWidth(beltWidth);
        minutemanPage.setTbBeltSpeed(beltSpeed);
        minutemanPage.setTbTonsPerHourPeak(tonsPerHourPeak);
        minutemanPage.setTbPickMaterialName(pickMaterialName);
        minutemanPage.setTbMaterialDensity(materialDensity);
        minutemanPage.setTbAngleOfIdlers(angleOfIdler);
        minutemanPage.setTbCarrySideIdlerSpacing(carrySideIdlerSpacing);
        minutemanPage.setDriveWrapAngleDropdown(driveWrapAngle);
        minutemanPage.selectFrictionFactor(frictionFactor,lengthFactor);
        minutemanPage.setSurchargeAngleDropdown(surchargeAngle);
        minutemanPage.setIdlerOffsetTypeDropdown(idlerOffset);
        minutemanPage.setDriveDetailsDropdown(driverDetails);
//        SyncUtil.waitFor(2000);
        minutemanPage.setTakeUpDetailsDropdown(takeUpDetails);
//        SyncUtil.waitFor(2000);
        minutemanPage.setSpliceTypeDropdown(spliceType);
        inputDataPage=minutemanPage.getInputPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters stations {Stations} {DriveLocation} {TakeUpLocation} and click on next")
    public void userEntersStations(String stations, String driverLocation, String takeUpLocation){
//        SyncUtil.waitFor(2000);
        minutemanPage.selectStation(stations);
        minutemanPage.selectDriveStation(driverLocation);
        minutemanPage.selectTakeUpStation(takeUpLocation);
//        SyncUtil.waitFor(2000);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters flight info for {Stations} {HorzOffset} {ElevOffset} and click on calculate and next")
    public void userEntersFlightInfo(String stations, String[] horzOffset, String[] elevOffset){
        SyncUtil.waitFor(1500);
        minutemanPage.setConveyorFlightsConfiguration(stations,horzOffset,elevOffset);
        minutemanPage.clickOnCalculate();
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,5000);
        SyncUtil.waitFor(2000);
        flightInfoPage=minutemanPage.getFlightConfiguration(stations);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters select belt details {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover}")
    public void userEntersSelectBeltDetails(String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,4000);
        minutemanPage.setTradeNameDropdown(tradeName);
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,4000);
        minutemanPage.setCoverGradeDropdown(coverGrade);
        minutemanPage.setRatingDropdown(rating);
        minutemanPage.setPliesDropdown(plies);
        minutemanPage.setCoverGaugeUnitDropdown(coverGaugeUnits);
        minutemanPage.setGaugeTopCoverDropdown(gaugeTopCover);
        minutemanPage.setGaugePulleyCoverDropdown(gaugePulleyCover);
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,7000);
        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "Add calculation Name {CalculationName}")
    public void addCalculationName(String calculationName){
//        SyncUtil.waitFor(60000);
        minutemanPage.setTbCalculationName(calculationName);
    }

    @QAFTestStep(description = "Verify the pre populated data in general info page {Program} {ManufacturingLocation}")
    public void verifyPrePopulatedDataInGeneralInfoPage(String program,String manufacturingLocation){
        minutemanPage.verifyPerPopulatedDataInGeneralInfoPage(program,manufacturingLocation);
    }

    @QAFTestStep(description = "Verify the pre populated data in general info page for imperial {Program} {ManufacturingLocation}")
    public void verifyPrePopulatedDataInGeneralInfoPageImperial(String program,String manufacturingLocation){
        minutemanPage.verifyPerPopulatedDataInGeneralInfoPageImperial(program,manufacturingLocation);
    }

    @QAFTestStep(description = "User click on next")
    public void clickOnNextButton(){
        minutemanPage.clickNext();
    }

    @QAFTestStep(description="User click on previous")
    public void userClickOnPrevious(){ minutemanPage.clickPrevious();
    }

    @QAFTestStep(description = "Verify the pre populated data in inputs page {BeltWidth} {BeltSpeed} {TonsPerHourPeak} {PickMaterialName} {MaterialDensity} {AngleOfIdler} {CarrySideIdlerSpacing} {DriveWrapAngle} {DriveWrapAngleDegree} {TakeUpTension} {FrictionFactor} {LengthFactor} {SurchargeAngle} {IdlerOffset} {DriverDetails} {TakeUpDetails} {SpliceType}")
    public void verifyPrePopulatedDataInInputPage(String beltWidth,String beltSpeed,String tonsPerHourPeak,String pickMaterialName,String materialDensity, String angleOfIdlers, String carrySideIdler, String driveWrapAngle,String driveWrapAngleDegree,String takeUpTension,String frictionFactor,String lengthFactor,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails, String spliceType){
        minutemanPage.verifyPrePopulatedDataInInputsPage(beltWidth,beltSpeed,tonsPerHourPeak,pickMaterialName,materialDensity,angleOfIdlers,carrySideIdler,driveWrapAngle,driveWrapAngleDegree,takeUpTension,frictionFactor,lengthFactor,surchargeAngle,idlerOffsetType,driveDetails,takeUpDetails,spliceType);
    }

    @QAFTestStep(description = "Verify the bucket elevator pre populated data in inputs page {ConveyorType} {MaterialDensity} {TonsPerHourPeak} {MaterialLength} {MaterialProjection} {BucketSpacing} {BucketWeight} {BucketVolume} {BucketRows} {BeltWidth} {BeltHeight} {BeltSpeed} {DrivePulley} {TakeUpType}")
    public void verifyBucketElevatorPrePopulatedDataInInputPage(String conveyorType,String materialDensity,String tonsPerHourPeak,String materialLength,String materialProjection, String bucketSpacing, String bucketWeight, String bucketVolume,String bucketRows,String beltWidth,String beltHeight,String beltSpeed,String drivePulley,String takeUpType){
        minutemanPage.verifyBucketElevatorPrePopulatedDataInInputsPage(conveyorType,materialDensity,tonsPerHourPeak,materialLength,materialProjection,bucketSpacing,bucketWeight,bucketVolume,bucketRows,beltWidth,beltHeight,beltSpeed,drivePulley,takeUpType);
    }

    @QAFTestStep(description = "Verify the pre populated data in stations page {Stations} {DriveLocation} {TakeUpLocation}")
    public void verifyPrePopulatedDataInStationPage(String stations,String driveLocation,String takeUpLocation){
        minutemanPage.verifyPrePopulatedDetailsInStationsPage(stations,driveLocation,takeUpLocation);
    }

    @QAFTestStep(description = "Verify the pre populated data in flight info page {Stations} {HorzOffset} {ElevOffset} {SectionAngle} {EstimatedCCLength} {TypeOfConfiguration}")
    public void verifyPrePopulatedDataInFlightInfoPage(String stations,String[] horzOffset,String[] elevOffset, String[] sectionAngle,String estimatedCCLength,String typeOfConfiguration){
//        SyncUtil.waitFor(25000);
        minutemanPage.verifyPrePopulatedDetailsInFlightInfo(typeOfConfiguration,stations,horzOffset,elevOffset,sectionAngle,estimatedCCLength);
    }

    @QAFTestStep(description = "Verify the pre populated data in select belt page {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover}")
    public void verifyPrePopulatedDataInSelectBeltPage(String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
//        SyncUtil.waitFor(30000);
        minutemanPage.verifyPrePopulatedDetailsInSelectBeltPage(tradeName,coverGrade,rating,plies,coverGaugeUnits,gaugeTopCover,gaugePulleyCover);
    }

    @QAFTestStep(description = "Verify the pre populated data in capacity page {BeltSpeed} {TonsPerHourPeak}")
    public void verifyPrePopulatedDataInCapacityPage(String beltSpeed,String tonsPerHourPeak){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInCapacityPage(beltSpeed,tonsPerHourPeak);
    }

    @QAFTestStep(description = "Verify the pre populated data in roll data page {TotalBeltLength} {NumberOfRolls}")
    public void verifyPrePopulatedDataInRollDataPage(String totalBeltLength,String numberOfRolls){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInRollDataPage(totalBeltLength,numberOfRolls);
    }

    @QAFTestStep(description = "Verify the pre populated data in pulleys page {PulleyDiameterHead} {PulleyDiameterDrive} {PulleyDiameterTakeUp} {PulleyDiameterTail}")
    public void verifyPrePopulatedDataInPulleysPage(String pulleyDiameterHead,String pulleyDiameterDrive,String pulleyDiameterTakeUp,String pulleyDiameterTail){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInPulleyPage(pulleyDiameterHead,pulleyDiameterDrive,pulleyDiameterTakeUp,pulleyDiameterTail);
    }

    @QAFTestStep(description = "Verify the pre populated data in transition page {TransitionLengthHead} {TransitionLengthTail}")
    public void verifyPrePopulatedDataInTransitionPage(String transitionLengthHead,String transitionLengthTail){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInTransitionsPage(transitionLengthHead,transitionLengthTail);
    }

    @QAFTestStep(description = "Verify the pre populated data in take up page {TakeUpTensionIfKnown}")
    public void verifyPrePopulatedDataInTakeUpPage(String takeUpTensionIfKnown){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInTakeUpPage(takeUpTensionIfKnown);
    }

    @QAFTestStep(description = "Verify the pre populated data in curves page {CurveRadius1} {CurveRadius2} {CurveRadius3} {CurveRadius4}")
    public void verifyPrePopulatedDataInCurvesPage(String curveRadius1,String curveRadius2,String curveRadius3,String curveRadius4){
//        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInCurvesPage(curveRadius1,curveRadius2,curveRadius3,curveRadius4);
    }

    @QAFTestStep(description = "User should see all the calculated data of capacity page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfCapacityPageAndClickOnNext(){
//        SyncUtil.waitFor(2000);
        capacity=minutemanPage.getCapacity();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data of Roll data page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfRollDataPageAndClickOnNext(){
//        SyncUtil.waitFor(5000);
        conveyorBeltDataInRollDataPage=minutemanPage.getConveyorBeltDataInRollDataPage();
        conveyorROllDataInRollDataPage=minutemanPage.getConveyorROllDataInRollDataPage();
        conveyorSpliceDimensionsDataInRollDataPage=minutemanPage.getConveyorSpliceDimensionsDataInRollDataPage();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data of pulleys page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfPulleysPageAndClickOnNext(){
        SyncUtil.waitFor(500);
        pulleysPageData=minutemanPage.getPulleysPageData();
        System.out.println(pulleysPageData);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data Add {TransitionLengthHead} {TransitionLengthTail} of transition page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfTransitionPageAndClickOnNext(String transitionLengthHead,String transitionLengthTail){
        SyncUtil.waitFor(1000);
//        minutemanPage.setTbLengthHead(transitionLengthHead);
//        minutemanPage.setTbLengthTail(transitionLengthTail);
//        minutemanPage.clickOnCalculate();
//        SyncUtil.waitFor(5000);
        transitionsPageData=minutemanPage.getTransitionsPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data Add {TakeUpTensionIfKnown} of take up page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfTakeUpPageAndClickOnNext(String takeUpTensionIfKnown){
//        SyncUtil.waitFor(2000);
//        minutemanPage.setTbTakeUpTensionifknown(takeUpTensionIfKnown);
//        minutemanPage.clickOnCalculate();
//        SyncUtil.waitFor(5000);
        reviewCalculatedTakeUpTravelDataTakeUpPage=minutemanPage.getReviewCalculatedTakeUpTravelDataTakeUpPage();
        calculatedTakeUpDataInTakeUpPage=minutemanPage.getCalculatedTakeUpDataInTakeUpPage();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data Add {CurveRadius1} {CurveRadius2} {CurveRadius3} {CurveRadius4} of curves and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfCurvesPageAndClickOnNext(String curveRadius1,String curveRadius2,String curveRadius3,String curveRadius4){
        SyncUtil.waitFor(2000);
//        minutemanPage.setTbCurveRadius1(curveRadius1);
//        minutemanPage.setTbCurveRadius2(curveRadius2);
//        minutemanPage.setTbCurveRadius3(curveRadius3);
//        minutemanPage.setTbCurveRadius4(curveRadius4);
//        minutemanPage.clickOnCalculate();
//        SyncUtil.waitFor(5000);
        calculatedVerticalCurvesDataInCurvesPage=minutemanPage.getCalculatedVerticalCurvesDataInCurvesPage();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "Verify all the data shown in the reports with calculated and entered data {CalculationName} {Site} {ConveyorName} {TonsPerHourPeak} {MaterialDensity} {SurchargeAngle} {BeltWidth} {BeltSpeed} {CarrySideIdlerSpacing} {DriveLocation} {TakeUpLocation} {TakeUpDetails}")
    public void verifyAllTheDataShownInTheReportsWithCalculatedAndEnteredData(String calculationName,String site, String conveyorName,String tonsPerHourPeak,String materialDensity,String surchargeAngle,String beltWidth,String beltSpeed,String carrySideIdlerSpacing,String driveLocation,String takeUpLocation,String takeUpDetails){
        minutemanPage.verifyConveyorInformation(conveyorBeltDataInRollDataPage,conveyorName,calculationName,site,minutemanPage.getConveyorInformation());
        minutemanPage.verifySystemCoordinates(flightInfoPage,minutemanPage.getSystemCoordinates());
        minutemanPage.verifyMaterialData(tonsPerHourPeak,materialDensity,inputDataPage,minutemanPage.getMaterialData());
        minutemanPage.verifyInputBeltData(beltWidth,beltSpeed,minutemanPage.getInputBeltData(),conveyorBeltDataInRollDataPage);
        minutemanPage.verifySystemData(capacity,carrySideIdlerSpacing,driveLocation,takeUpLocation,inputDataPage,minutemanPage.getSystemData());
        minutemanPage.verifyCalculateData(calculatedData,conveyorROllDataInRollDataPage,minutemanPage.getCalculatedData());
        minutemanPage.verifyBeltData(conveyorBeltDataInRollDataPage,minutemanPage.getBeltData());
        minutemanPage.verifyRollData(conveyorROllDataInRollDataPage,minutemanPage.getRollData());
        minutemanPage.verifyVulcanizedSpliceData(conveyorSpliceDimensionsDataInRollDataPage,minutemanPage.getVulcanizedSpliceData());
        minutemanPage.verifyTakeUpTravel(reviewCalculatedTakeUpTravelDataTakeUpPage,calculatedTakeUpDataInTakeUpPage,takeUpDetails,minutemanPage.getTakeUpTravel());
        minutemanPage.verifyTransitionLength(transitionsPageData,minutemanPage.getTransitionLength());
        minutemanPage.verifyVerticalCurve(calculatedVerticalCurvesDataInCurvesPage,minutemanPage.getVerticalCurves());
        minutemanPage.verifyPulleyData(pulleysPageData,minutemanPage.getPulleyData());
    }

    @QAFTestStep(description = "Verify all the data shown in the reports with calculated and entered data {CalculationName} {TonsPerHourPeak} {MaterialDensity} {SurchargeAngle} {BeltWidth} {BeltSpeed} {CarrySideIdlerSpacing} {DriveLocation} {TakeUpLocation} {TakeUpDetails}")
    public void verifyAllTheDataShownInTheReportsWithCalculatedData(String calculationName,String tonsPerHourPeak,String materialDensity,String surchargeAngle,String beltWidth,String beltSpeed,String carrySideIdlerSpacing,String driveLocation,String takeUpLocation,String takeUpDetails){
        minutemanPage.verifyConveyorInformation(conveyorBeltDataInRollDataPage,"",calculationName,"",minutemanPage.getConveyorInformation());
        minutemanPage.verifySystemCoordinates(flightInfoPage,minutemanPage.getSystemCoordinates());
        minutemanPage.verifyMaterialData(tonsPerHourPeak,materialDensity,inputDataPage,minutemanPage.getMaterialData());
        minutemanPage.verifyInputBeltData(beltWidth,beltSpeed,minutemanPage.getInputBeltData(),conveyorBeltDataInRollDataPage);
        minutemanPage.verifySystemData(capacity,carrySideIdlerSpacing,driveLocation,takeUpLocation,inputDataPage,minutemanPage.getSystemData());
        minutemanPage.verifyCalculateData(calculatedData,conveyorROllDataInRollDataPage,minutemanPage.getCalculatedData());
        minutemanPage.verifyBeltData(conveyorBeltDataInRollDataPage,minutemanPage.getBeltData());
        minutemanPage.verifyRollData(conveyorROllDataInRollDataPage,minutemanPage.getRollData());
        minutemanPage.verifyVulcanizedSpliceData(conveyorSpliceDimensionsDataInRollDataPage,minutemanPage.getVulcanizedSpliceData());
        minutemanPage.verifyTakeUpTravel(reviewCalculatedTakeUpTravelDataTakeUpPage,calculatedTakeUpDataInTakeUpPage,takeUpDetails,minutemanPage.getTakeUpTravel());
        minutemanPage.verifyTransitionLength(transitionsPageData,minutemanPage.getTransitionLength());
        minutemanPage.verifyVerticalCurve(calculatedVerticalCurvesDataInCurvesPage,minutemanPage.getVerticalCurves());
        minutemanPage.verifyPulleyData(pulleysPageData,minutemanPage.getPulleyData());
    }

    @QAFTestStep(description="Verify download report option on final report {CalculationName}")
    public void verifyDownloadReportOptionOnFinalReport(String calc){
        minutemanPage.clickOnSaveAndDownload();
        SyncUtil.waitFor(3000);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,15000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(calc+".pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        minutemanPage.verifyPDFContents(calc, minutemanPage.getConveyorInformation());
    }

    @QAFTestStep(description="Click on create button for minuteman calculation")
    public void clickOnCreateBtnMinutemanCalc(){
        Validator.assertTrue(minutemanPage.clickOnCreateCalc(),"Minuteman toast msg was not found", "Minuteman toast msg verified successfully");
    }

    @QAFTestStep(description="Click on create button and verify failure toast")
    public void verifyFailureOnCreateBtnMinutemanCalc(){
        Validator.assertTrue(minutemanPage.verifyFailureOnCreateCalc(),"Minuteman toast msg was not found", "Minuteman toast msg verified successfully");
    }

    @QAFTestStep(description="Edit minuteman calculation {CalculationName} to {NewCalculationName}")
    public void editMinutemanCalculationTo(String calc, String newCalc){
        minutemanPage.editMinutemanCalc(calc, newCalc);
    }

    @QAFTestStep(description="Edit bucket elevator minuteman calculation {CalculationName} to {NewCalculationName}")
    public void editBucketMinutemanCalculationTo(String calc, String newCalc){
        minutemanPage.editBucketMinutemanCalc(calc, newCalc);
    }

    @QAFTestStep(description="Navigate to edit mode for bucket elevator minuteman calculation {CalculationName}")
    public void navigateToEditBucketMinutemanCalculation(String calc){
        minutemanPage.goToEditMinutemanCalc(calc);
    }

    @QAFTestStep(description="Duplicate minuteman calculation {CalculationName} to {NewCalculationName}")
    public void duplicateMinutemanCalculationTo(String calc, String newCalc){
        minutemanPage.duplicateMinutemanCalc(calc, newCalc);
    }

    @QAFTestStep(description="Verify the minuteman calculation {NewCalculationName} in list screen")
    public void editMinutemanCalc(String newCalc){
        Validator.assertTrue(minutemanPage.searchMinuteman(newCalc),"Minuteman calculation was not found","Minuteman calculation was found and verified successfully");
    }

    @QAFTestStep(description="Delete minuteman calculation {CalculationName}")
    public void deleteMinutemanCalc(String newCalc){
        Validator.assertTrue(minutemanPage.deleteMinutemanCalc(newCalc),"Minuteman calculation was found","Minuteman calculation was not found and verified successfully");
    }

    @QAFTestStep(description="Verify the deleted minuteman calculation {CalculationName} in list screen")
    public void verifyDeletedMinutemanCalc(String newCalc){
        minutemanPage.verifyDeletedCalc(newCalc);
    }

    @QAFTestStep(description = "Verify the add minuteman dropdown contents")
    public void verifyMinutemanDropdownContents(){
        minutemanPage.verifyAddMinutemanBtnContents();
    }

    @QAFTestStep(description = "User is at add minuteman bucket elevator page")
    public void userAtMinutemanBucketElevatorPage(){
        minutemanPage.gotoAddMinutemanBucketElevator();
    }


    @QAFTestStep(description = "User enters elevator general info {CalculationName} {Site} {ConveyorName} {Description} {Program} {ManufacturingLocation} {Units} and click on next")
    public void userEntersElevatorGeneralInfo(String calculationName, String site, String conveyorName, String description, String program, String manufacturingLocation, String units){
        SyncUtil.waitFor(2000);
        minutemanPage.setTbElevatorCalculationName(calculationName);
        minutemanPage.setSiteDropdown(site);
        SyncUtil.waitFor(1000);
//        minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.setTbDescription(description);
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacturingLocation);
        minutemanPage.selectUnit(units);
        minutemanPage.handleUnitsPopup(units);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters elevator general info {CalculationName} {Site} {ConveyorName} and click on next")
    public void userEntersElevatorGeneralInfo1(String calculationName, String site, String conveyorName){
        SyncUtil.waitFor(2000);
        minutemanPage.setTbElevatorCalculationName(calculationName);
        if(site != null)
            minutemanPage.setSiteDropdown(site);
        SyncUtil.waitFor(1000);
//        minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.clickOnStations();
    }

    @QAFTestStep(description = "User enters elevator general info {CalculationName} and click on next")
    public void userEntersLimitedElevatorGeneralInfo(String calculationName){
        SyncUtil.waitFor(2000);
        minutemanPage.setTbElevatorCalculationName(calculationName);
        minutemanPage.clickNext();
        minutemanPage.isInputsScreen();
    }

    @QAFTestStep(description = "User enters elevator general info {CalculationName} and click on save")
    public void userEntersLimitedElevatorGeneralInfoSave(String calculationName){
        SyncUtil.waitFor(2000);
        minutemanPage.setTbElevatorCalculationName(calculationName);
        minutemanPage.verifyFailureOnCreateCalc();
    }

    @QAFTestStep(description = "Verify toast message when partially filled bucket elevator")
    public void verifyPartiallyFilledBucketElevatorToast(){
        Validator.assertTrue(minutemanPage.clickOnCreateCalcPartialFilled(),"Invalid minuteman toast message not found", "Invalid minuteman toast verified successfully");
    }

    @QAFTestStep(description = "User enters elevator inputs {ConveyorType} {MaterialDensity} {TonsPerHourPeak} {MaterialLength} {MaterialProjection} {MaterialSpacing} {MaterialWeight} {MaterialVolume} {BucketRows} {MaterialWidth} {MaterialHeight} {MaterialSpeed} {DrivePulley} {TakeUpType} and click on next")
    public void userEntersElevatorInputDetails(String conveyorType, String materialDensity, String tonsPerHourPeak, String materialLength, String materialProjection, String materialSpacing, String materialWeight, String materialVolume, String bucketRows, String materialWidth, String materialHeight, String materialSpeed, String drivePulley, String takeUpType){
        SyncUtil.waitFor(500);
        minutemanPage.setTbConveyorType(conveyorType);
        minutemanPage.setTbDensity(materialDensity);
        minutemanPage.settbTonPerHrPeak(tonsPerHourPeak);
        minutemanPage.settbMaterialLength(materialLength);
        minutemanPage.settbMaterialProjection(materialProjection);
        minutemanPage.settbMaterialSpacing(materialSpacing);
        minutemanPage.settbMaterialWeight(materialWeight);
        minutemanPage.settbMaterialVolume(materialVolume);
        minutemanPage.settbBucketRows(bucketRows);

        minutemanPage.settbMaterialWidth(materialWidth);
        minutemanPage.settbMaterialHeight(materialHeight);
        minutemanPage.settbMaterialSpeed(materialSpeed);
        minutemanPage.settbDrivePulley(drivePulley);
        minutemanPage.settbTakeUpType(takeUpType);
        inputElevatorDataPage=minutemanPage.getElevatorInputPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description="Verify all the elevator data shown in the reports with calculated and entered data {0} {1} {2} {3} {4} {5} {6} {7} {8} {9} {10} {11} {12} {13} {14} {15} {16} {17} {18} {19} {20} {21} {22} {23} {24} {25} {26} {27} {28} {29} {30}")
    public void verifyAllTheElevatorDataShownInTheReportsWithCalculatedAndEnteredData(String ConveyorType, String calculationName,String customer,String conveyorName,String conveyorType,String tradeName,String materialDensity,String tonsPerHourPeak,String materialLength,String materialProjection,String materialSpacing, String materialWeight, String materialVolume,String bucketRows,String materialWidth,String materialHeight,String materialSpeed, String beltWeight,String drivePulley,String takeUpType,String maximumTension,String maximumPIW,String effectiveTension,String beltHorsepower,String percentLoaded,String counterweightTension,String counterweightWeight,String weightInEachBucket,String mimTailPulleyDiameter,String maximumProjection,String appropriateNumber){
        minutemanPage.verifyElevatorConveyorInformation(customer,calculationName,tradeName,minutemanPage.getElevatorConveyorInformation());
        minutemanPage.verifyGivenData(ConveyorType,materialDensity,tonsPerHourPeak,materialProjection,materialLength,materialSpacing,materialWeight,materialVolume,bucketRows,materialWidth,materialHeight,materialSpeed,beltWeight,drivePulley,takeUpType);
        minutemanPage.verifyCalculatedData(maximumTension,maximumPIW,effectiveTension,beltHorsepower,percentLoaded,counterweightTension,counterweightWeight,weightInEachBucket);
        minutemanPage.verifyAdditionalData(mimTailPulleyDiameter,maximumProjection,appropriateNumber);
    }

    @QAFTestStep(description="Verify all the elevator data shown in the reports with calculated and entered data {0} {1} {2} {3}")
    public void verifyAllTheElevatorDataShownInTheReportsWithCalculatedAndEnteredData1(String ConveyorType, String calculationName,String customer,String conveyorName){
        minutemanPage.verifyElevatorConveyorInformation(customer,calculationName,minutemanPage.getElevatorConveyorInformation());
//        minutemanPage.verifyGivenData(ConveyorType,materialDensity,tonsPerHourPeak,materialLength,materialSpacing,materialVolume,bucketRows,materialWidth,materialHeight,materialSpeed,drivePulley,takeUpType);
//        minutemanPage.verifyCalculatedData(maximumTension,maximumPIW,effectiveTension,beltHorsepower,percentLoaded,counterweightTension,counterweightWeight,weightInEachBucket);
//        minutemanPage.verifyAdditionalData(mimTailPulleyDiameter,maximumProjection,appropriateNumber);
    }

    @QAFTestStep(description = "Navigate to minuteman screen from site card")
    public void navigateToMinutemanCalc(){
        minutemanPage.gotoMinutemanScreen();
    }

    @QAFTestStep(description = "Verify user is able to click on add icon")
    public void navigateToAddMinutemanCalc(){
        minutemanPage.goToAddMinutemanCalc();
    }

    @QAFTestStep(description = "Verify the program dropdown contents")
    public void verifyProgramDropdown(){
        minutemanPage.setTbProgram("Legacy Minuteman");
        SyncUtil.waitFor(2000);
        minutemanPage.setTbProgram("Legacy Cypher");
        SyncUtil.waitFor(2000);
        minutemanPage.setTbProgram("Minuteman");
    }

    @QAFTestStep(description = "Verify the program dropdown selection with {Program}")
    public void verifyProgramDropdownSelection(String program){
        minutemanPage.setTbProgram(program);
        SyncUtil.waitFor(2000);
        verifyManufacturingDropdown(program);
    }

    @QAFTestStep(description = "Verify the conveyor dropdown is disabled")
    public void verifyConveyorDropdown(){
        Validator.assertTrue(minutemanPage.isConveyorDropdownDisabled(),"Conveyor dropdown is not disabled","Conveyor dropdown is disabled");
    }

    @QAFTestStep(description = "Verify the manufacturing dropdown contents for {Program}")
    public void verifyManufacturingDropdown(String program){
        if(program.equalsIgnoreCase("Minuteman")) {
            minutemanPage.setTbManufacturingLocation("North America");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("South America");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("APAC");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("EMEA");
        }
        else if(program.equalsIgnoreCase("Legacy Cypher")) {
            minutemanPage.setTbManufacturingLocation("United States");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("Canada");
        }
        else if(program.equalsIgnoreCase("Legacy Minuteman")) {
            minutemanPage.setTbManufacturingLocation("United States");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("Australia");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("Brazil");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("Canada");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("China");
            SyncUtil.waitFor(2000);
            minutemanPage.setTbManufacturingLocation("South Africa");
        }
    }

    @QAFTestStep(description = "Verify the units radio button")
    public void verifyUnitsRadio(){
        minutemanPage.verifyUnitsRadioPage();
    }

    @QAFTestStep(description = "Verify the stations screen navigation")
    public void verifyStationNavigation(){
        minutemanPage.isStationScreen();
    }

    @QAFTestStep(description = "Verify the stations radio button selections")
    public void verifyStationSelection(){
        minutemanPage.verifyStationSelection();
    }

    @QAFTestStep(description = "Verify the flight screen navigation")
    public void verifyFlightNavigation(){
        minutemanPage.isFlightScreen();
    }

    @QAFTestStep(description = "Verify the select belt screen navigation")
    public void verifySelectBeltNavigation(){
        minutemanPage.isBeltScreen();
    }

    @QAFTestStep(description = "Verify capacity screen navigation")
    public void verifyCapacityNavigation(){
        minutemanPage.isCapacityScreen();
    }

    @QAFTestStep(description = "Verify roll data screen navigation")
    public void verifyRollDataNavigation(){
        minutemanPage.isRollDataScreen();
    }

    @QAFTestStep(description = "Verify pulley data screen navigation")
    public void verifyPulleyNavigation(){
        minutemanPage.isPulleyScreen();
    }

    @QAFTestStep(description = "Verify transition screen navigation")
    public void verifyTransactionNavigation(){
        minutemanPage.isTransactionScreen();
    }

    @QAFTestStep(description = "Verify curves screen navigation")
    public void verifyCurvesNavigation(){
        minutemanPage.isCurvesScreen();
    }

    @QAFTestStep(description = "Verify final report screen navigation")
    public void verifyFinalReportNavigation(){
        minutemanPage.isFinalReportScreen();
    }

    @QAFTestStep(description = "Delete the created minuteman calculation {CalculationName}")
    public void deleteMinuteman(String calcName){
        minutemanPage.deleteMinuteman(calcName);
    }

    @QAFTestStep(description = "Verify the minuteman calculation is deleted {CalculationName}")
    public void verifyDeleteMinuteman(String calcName){
        minutemanPage.searchMinuteman(calcName);
    }

    @QAFTestStep(description = "Verify selection of conveyor type for {ConveyorType}")
    public void verifyConveyorTypeSelection(String conveyorType){
        minutemanPage.setTbConveyorType(conveyorType);
        minutemanPage.getConveyorTypeText(conveyorType);

    }

    @QAFTestStep(description = "Verify the take up type dropdown contents")
    public void verifyTakeUpTypeSelection(){
        minutemanPage.settbTakeUpType("Counterweight");
        SyncUtil.waitFor(2000);
        minutemanPage.settbTakeUpType("Screw");
    }

    @QAFTestStep(description = "User should see all the calculated data Add {MaximumTension} {MaximumPIW} {EffectiveTension} {BeltHorsePower} {PercentLoaded} {CounterweightTension} {CounterweightWeight} {EachBucketWeight} {PulleyDiameter} {BucketProjection} {BucketNumber} and click on next")
    public void UserShouldSeeAllTheCalculatedDataAndClickOnNext(String maximumTension,String maximumPIW,String effectiveTension,String beltHorsePower,String percentLoaded,String counterweightTension,String counterweightWeight,String eachBucketWeight,String pulleyDiameter,String bucketProjection,String bucketNumber){
        SyncUtil.waitFor(500);
        calculatedElevatorOutputPage=minutemanPage.getCalculatedOutputPage();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "Verify all the data shown in the reports with calculated and entered data {CalculationName} {ConveyorName} {TonsPerHourPeak} {MaterialDensity} {SurchargeAngle} {BeltWidth} {BeltSpeed} {CarrySideIdlerSpacing} {DriveLocation} {TakeUpLocation} {TakeUpDetails}")
    public void verifyTheValuesShownInTheReport(String calculationName,String conveyorName,String tonsPerHourPeak,String materialDensity,String surchargeAngle,String beltWidth,String beltSpeed,String carrySideIdlerSpacing,String driveLocation,String takeUpLocation,String takeUpDetails){
        minutemanPage.verifyConveyorInformation(conveyorBeltDataInRollDataPage,conveyorName,calculationName,"",minutemanPage.getConveyorInformation());
        minutemanPage.verifySystemCoordinates(flightInfoPage,minutemanPage.getSystemCoordinates());
        minutemanPage.verifyMaterialData(tonsPerHourPeak,materialDensity,inputDataPage,minutemanPage.getMaterialData());
        minutemanPage.verifyInputBeltData(beltWidth,beltSpeed,minutemanPage.getInputBeltData(), conveyorBeltDataInRollDataPage);
        minutemanPage.verifySystemData(capacity,carrySideIdlerSpacing,driveLocation,takeUpLocation,inputDataPage,minutemanPage.getSystemData());
        minutemanPage.verifyCalculateData(calculatedData,conveyorROllDataInRollDataPage,minutemanPage.getCalculatedData());
        minutemanPage.verifyBeltData(conveyorBeltDataInRollDataPage,minutemanPage.getBeltData());
        minutemanPage.verifyRollData(conveyorROllDataInRollDataPage,minutemanPage.getRollData());
        minutemanPage.verifyVulcanizedSpliceData(conveyorSpliceDimensionsDataInRollDataPage,minutemanPage.getVulcanizedSpliceData());
        minutemanPage.verifyTakeUpTravel(reviewCalculatedTakeUpTravelDataTakeUpPage,calculatedTakeUpDataInTakeUpPage,takeUpDetails,minutemanPage.getTakeUpTravel());
        minutemanPage.verifyTransitionLength(transitionsPageData,minutemanPage.getTransitionLength());
        minutemanPage.verifyVerticalCurve(calculatedVerticalCurvesDataInCurvesPage,minutemanPage.getVerticalCurves());
        minutemanPage.verifyPulleyData(pulleysPageData,minutemanPage.getPulleyData());
    }

    @QAFTestStep(description="Close warning popup")
    public void closeWarningPopup(){minutemanPage.closeWarning();
    }

    @QAFTestStep(description = "User enters select elevator belt details {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover}")
    public void userEntersElevatorSelectBeltDetails(String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,4000);
        minutemanPage.setTradeNameDropdown(tradeName);
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,4000);
        minutemanPage.setCoverGradeDropdown(coverGrade);
        minutemanPage.setRatingDropdown(rating);
        minutemanPage.setPliesDropdown(plies);
        minutemanPage.setCoverGaugeUnitDropdown(coverGaugeUnits);
        minutemanPage.setGaugePulleyCoverDropdown(gaugePulleyCover);
        minutemanPage.setGaugeTopCoverDropdown(gaugeTopCover);
        minutemanPage.waitForElementToInvisible(minutemanPage.skeleton,7000);
        calculatedData=minutemanPage.getCalculatedDataInElevatorSelectBelt();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description="Verify download report option for bucket elevator on final report {CalculationName}")
    public void verifyDownloadReportOptionBucketElevator(String calc){
        MiscUtils.deleteDownloadedFiles("[\\D\\S]+.pdf");
        minutemanPage.clickOnSaveAndDownload();
        SyncUtil.waitFor(3000);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,20000);
        Validator.assertTrue(MiscUtils.checkDownloadedFiles(calc+".pdf"), "PDF report was not found", "PDF report was downloaded successfully");
        minutemanPage.verifyPDFContentsBucketElevator(calc);
    }

    @QAFTestStep(description = "User enters general info {CalculationName} {Site} {ConveyorName} and click on select belt")
    public void userEntersGeneralInfoAndClickOnSelectBelt(String calculationName, String site, String conveyorName){
//        SyncUtil.waitFor(5000);
        minutemanPage.setTbDescription("abcd");
        minutemanPage.setTbCalculationName(calculationName);
        if(site != null)
            minutemanPage.setSiteDropdown(site);
        if(conveyorName != null)
            minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.clickOnSelectBelt();
    }
    @QAFTestStep(description = "Navigate to minuteman list screen and wait to load data")
    public void verifyTheMinutemanListNavAndWait() {
        minutemanPage.gotoMinutemanScreenWait();
    }
    @QAFTestStep(description = "Verify the minuteman count with respect to pagination")
    public void validateTheMinutemanCountWrtPagination()
    {
        minutemanPage.validateMinutemanCountWrtPagination();
    }

    @QAFTestStep(description = "User enters select belt details and click on final report")
    public void userEntersBeltDetails(){
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        SyncUtil.waitFor(1500);
//        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickOnFinalReport();
    }

    @QAFTestStep(description = "User navigates to final report screen")
    public void finalReportNav(){
        SyncUtil.waitFor(1500);
//        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickOnFinalReport();
    }

    @QAFTestStep(description = "User enters elevator select belt details and click on final report")
    public void userEnterElevatorBeltDetailsReport(){
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        SyncUtil.waitFor(1000);
//        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickOnSelectBelt();
    }

    @QAFTestStep(description = "User enters elevator select belt details")
    public void userEnterElevatorBeltDetails(){
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        SyncUtil.waitFor(1000);
        minutemanPage.clickOnStations();
    }

    @QAFTestStep(description = "User enters elevator select belt details and click on next")
    public void userEnterElevatorBeltDetailsNext(){
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        SyncUtil.waitFor(1000);
//        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickOnStations();
        SyncUtil.waitFor(1000);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description="Verify all the data shown in the reports with calculated and entered data {0} {1} {2}")
    public void verifyAllTheDataShownInTheReportsWithCalculatedAndEnteredData1(String calculationName,String site,String conveyorName){
        minutemanPage.verifyConveyorInformation(conveyorName,calculationName,site,minutemanPage.getConveyorInformation());
    }

    @QAFTestStep(description="Extract the minuteman card data")
    public void extractMinutemanCardCount(){
        int totalMinuteman = minutemanPage.getTotalMinutemanCount();
        System.out.println(totalMinuteman);
        getBundle().setProperty("totalMinuteman",totalMinuteman);
    }

    @QAFTestStep(description="Verify the minuteman card count with the api")
    public void verifyMinutemanCardCountAPI(){
        SyncUtil.waitFor(3000);
        Validator.assertTrue((int) getBundle().getProperty("totalMinuteman") == minutemanPage.getTotalMinutemanCount(),"Minuteman Tile Count is not matching", "Minuteman Tile Count is matching") ;
    }

    @QAFTestStep(description="Verify the minuteman card count")
    public void verifyMinutemanCardCount(){
        SyncUtil.waitFor(3000);
        Validator.assertTrue((int) getBundle().getProperty("totalMinuteman") + 1 == minutemanPage.getTotalMinutemanCount(),"Minuteman Tile Count is not matching", "Minuteman Tile Count is matching") ;
    }

    @QAFTestStep(description="Verify for delete minuteman card count")
    public void verifyDeleteMinutemanCardCount(){
        SyncUtil.waitFor(3000);
        Validator.assertTrue((int) getBundle().getProperty("totalMinuteman") - 1 == minutemanPage.getTotalMinutemanCount(),"Minuteman Tile Count is not matching", "Minuteman Tile Count is matching") ;
        getBundle().setProperty("totalMinuteman",(int) getBundle().getProperty("totalMinuteman") - 1);
    }

    @QAFTestStep(description="Edit calculation {CalculationName} units to {1} with {2} {3}")
    public void verifyEditMinutemanUnit(String calcName, String units, String program, String location){
        minutemanPage.editMinutemanCalcUnit(calcName,units,program,location);
    }

    @QAFTestStep(description="Edit bucket calculation {CalculationName} units to {1} with {2} {3}")
    public void verifyBucketElevatorEditUnit(String calcName, String units, String program, String location){
        minutemanPage.editBucketMinutemanCalcUnit(calcName,units,program,location);
    }

    @QAFTestStep(description="Navigate the minuteman calculation {CalculationName} in list screen")
    public void navigateTheMinutemanCalculationInListScreen(String calcName){
        minutemanPage.goToMinutemanCalculation(calcName);
    }

    @QAFTestStep(description="Verify the load data functionality in user info for {CalculationName} {Site} {ConveyorName} {Program} {ManufacturingLocation} {Units} and click on next")
    public void verifyLoadDataFunctionality(String calcName, String site, String conveyorName, String program, String manufacture, String units){
        minutemanPage.setTbCalculationName(calcName);
        minutemanPage.selectUnit(units);
        SyncUtil.waitFor(500);
        minutemanPage.handleUnitsPopup(units);
        minutemanPage.setSiteDropdown(site);
        Validator.assertTrue(!minutemanPage.isLoadData(),"Load data should not be enabled", "Load data verified successfully");
        minutemanPage.setConveyorDropdown(conveyorName);
        Validator.assertTrue(minutemanPage.isLoadData(),"Load data should be enabled", "Load data verified successfully");
//        Validator.assertTrue(minutemanPage.loadDataFunctionality(),"Load data was not successful", "Load data verified successfully");
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacture);
        minutemanPage.clickNext();
    }


    @QAFTestStep(description="Navigate to the curves and calculate with {0}")
    public void navigateTheCurvesForCalculation(String val){
        minutemanPage.calculateCurves(val);
    }

    @QAFTestStep(description="Navigate to the pulley and calculate with {0}")
    public void navigateThePulleyForCalculation(String val){
        minutemanPage.calculatePulleys(val);
    }

    @QAFTestStep(description="Navigate to the take up and calculate with {0}")
    public void navigateTheTakeUpForCalculation(String val){
        minutemanPage.calculateTakeUp(val);
    }

    @QAFTestStep(description="Navigate to the transition and calculate with {0}")
    public void navigateTheTransitionForCalculation(String val){
        minutemanPage.calculateTransition(val);
    }

    @QAFTestStep(description="Verify all the notes are present in final report")
    public void verifyNotesFromReports(){
        Validator.assertTrue(minutemanPage.verifyNotesFromFinalReport(),"All notes are visible in final report", "Notes from final reports verified successfully");
    }

    @QAFTestStep(description="Verify warning popup on exiting calculation")
    public void verifyWarningPopup(){
        Validator.assertTrue(minutemanPage.verifyWarningPopup(),"Warning popup was not seen on exiting calculation form", "Warning popup verified successfully");
    }

    @QAFTestStep(description="Verify cancel button functionality when partially filled")
    public void verifyCancelPartial(){
        Validator.assertTrue(minutemanPage.verifyCancelButton(),"Warning popup was not seen on cancelling partial form", "Warning popup verified successfully");
    }

    @QAFTestStep(description="Verify cancel button functionality when blank")
    public void verifyCancelBlank(){
        Validator.assertFalse(minutemanPage.verifyCancelButton(),"Warning popup was seen on cancelling blank form", "Warning popup verified successfully");
    }

    @QAFTestStep(description="Verify help button functionality for bucket elevator")
    public void verifyHelpPage(){
        Validator.assertTrue(minutemanPage.navigateToHelpPage(),"Help popup was not seen on click help icon", "Help popup verified successfully");
    }

    @QAFTestStep(description="Verify the next navigation in help page")
    public void verifyNextHelpPage(){
        Validator.assertTrue(minutemanPage.navigateToNextHelpPage(),"Help popup next navigation failed", "Help popup next navigation verified successfully");
    }

    @QAFTestStep(description="Verify the previous navigation in help page")
    public void verifyPreviousHelpPage(){
        Validator.assertTrue(minutemanPage.navigateToPreviousHelpPage(),"Help popup previous navigation failed", "Help popup previous navigation verified successfully");
    }

    @QAFTestStep(description="Verify the close button functionality for help page")
    public void verifyCloseHelpPage(){
        Validator.assertTrue(minutemanPage.closeHelpPage(),"Help popup close failed", "Help popup close verified successfully");
    }

    @QAFTestStep(description="Verify the 100% calculated output capacity on output screen")
    public void verifyCalculatedOutput(){
        Validator.assertTrue(minutemanPage.calculatedOutput(),"Calculated output capacity 100% button not working", "Calculated output capacity 100% button verified successfully");
    }

    @QAFTestStep(description="Verify the reset for calculated output capacity on output screen")
    public void verifyCalculatedOutputReset(){
        Validator.assertTrue(minutemanPage.calculatedOutputReset(),"Calculated output capacity reset button not working", "Calculated output capacity reset button successfully");
    }

    @QAFTestStep(description = "Verify the bucket elevator general info screen navigation")
    public void verifyGeneralElevatorNavigation(){
        Validator.assertTrue(minutemanPage.isBucketElevatorGeneralScreen(),"Expected general info screen not found", "General info screen verified successfully");
    }

    @QAFTestStep(description = "Verify the bucket elevator input screen navigation")
    public void verifyInputsElevatorNavigation(){
        Validator.assertTrue(minutemanPage.isBucketElevatorInputsScreen(),"Expected input screen not found", "Input screen verified successfully");
    }

    @QAFTestStep(description = "Verify the bucket elevator output screen navigation")
    public void verifyOutputsElevatorNavigation(){
        Validator.assertTrue(minutemanPage.isBucketElevatorOutputsScreen(),"Expected output screen not found", "Output screen verified successfully");
    }

    @QAFTestStep(description = "Verify the bucket elevator final report navigation")
    public void verifyFinalReportBucketElevatorNavigation(){
        Validator.assertTrue(minutemanPage.isBucketElevatorFinalScreen(),"Expected final report screen not found", "Final Report screen verified successfully");
    }

    @QAFTestStep(description = "Verify the save functionality on edit mode")
    public void verifySaveOnEditMode(){
        Validator.assertTrue(minutemanPage.clickOnSaveBtn(),"Save toast message was not found", "Save toast message verified successfully");
    }

    @QAFTestStep(description="Navigate to minuteman list from minuteman card at corporate level {DistCorpName} and {type}")
    public void navigateToInspectionFromDistributor(String distCorpName, String type){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(distCorpName));
        int count = corpPage.apiBase.getMinutemanCountAPI(type,companyId);
        getBundle().setProperty("totalMinuteman",count);
        System.out.println("count:= "+count);
        corpPage.goToCorporateDetails(distCorpName);
        minutemanPage.verifyMinutemanCardAndWaitForCount();
    }

    @QAFTestStep(description="Navigate to minuteman list from minuteman card at site/shop level {DistCorpName} and {type}")
    public void navigateToInspectionFromSiteShop(String shopName, String type){
        String companyId = corpPage.apiBase.getCompanyID(corpPage.apiBase.getCompanyAPI(shopName));
        int count = corpPage.apiBase.getMinutemanCountAPI(type,companyId);
        getBundle().setProperty("totalMinuteman",count);
        System.out.println("count:= "+count);
        minutemanPage.verifyMinutemanCardAndWaitForCount();
        SyncUtil.waitFor(3000);
    }

    @QAFTestStep(description="Navigate to minuteman list from minuteman card at conveyor level {ConveyorName} and {type}")
    public void navigateToInspectionFromConveyor(String conveyorName, String type){
        String conveyorId = corpPage.apiBase.getConveyorID(corpPage.apiBase.getConveyorsAPI(conveyorName));
        int count = corpPage.apiBase.getMinutemanCountAPI(type,conveyorId);
        getBundle().setProperty("totalMinuteman",count);
        System.out.println("count:= "+count);
        minutemanPage.verifyMinutemanCardAndWaitForCount();
        SyncUtil.waitFor(3000);
    }

    @QAFTestStep(description = "Verify the fields in calculated outputs are disabled")
    public void verifyOutputFieldsState(){
        Validator.assertFalse(minutemanPage.isOutputFieldsEnabled(),"Not all output fields are disabled", "Output fields verified successfully");
    }

    @QAFTestStep(description = "Verify the cancel and create button are visible when newly creating calculation")
    public void verifyAddCalculationFormButtons(){
        Validator.assertTrue(minutemanPage.isCreateCalculationButton(),"Cancel or create button not not found in adding calculations", "Cancel and create button verified successfully");
    }

    @QAFTestStep(description = "Verify the cancel and save button are visible when editing calculation")
    public void verifyEditCalculationFormButtons(){
        Validator.assertTrue(minutemanPage.isEditCalculationButton(),"Cancel or save button not not found in editing calculations", "Cancel and save button verified successfully");
    }
}

