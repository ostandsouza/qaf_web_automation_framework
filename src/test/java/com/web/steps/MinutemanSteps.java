package com.web.steps;

import com.common.utils.SyncUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web.pages.MinutemanPage;

import java.util.ArrayList;


public class MinutemanSteps {
    MinutemanPage minutemanPage=new MinutemanPage();
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

    @QAFTestStep(description = "User is at add minuteman conveyor page")
    public void userAtMinutemanPage(){
        minutemanPage.gotoAddMinutemanConveyor();
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

    @QAFTestStep(description = "User enters general info {CalculationName} {Site} {ConveyorName} {Description} {Program} {ManufacturingLocation} {Units} and click on next")
    public void userEntersGeneralInfo(String calculationName, String site, String conveyorName, String description, String program, String manufacturingLocation, String units){
        SyncUtil.waitFor(15000);
        minutemanPage.setTbCalculationName(calculationName);
        minutemanPage.setSiteDropdown(site);
        SyncUtil.waitFor(1000);
        minutemanPage.setConveyorDropdown(conveyorName);
        minutemanPage.setTbDescription(description);
        minutemanPage.setTbProgram(program);
        minutemanPage.setTbManufacturingLocation(manufacturingLocation);
        minutemanPage.selectUnit(units);
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
//        minutemanPage.setDriveWrapAngleDropdown(driveWrapAngle);
        minutemanPage.selectFrictionFactor(frictionFactor,lengthFactor);
        minutemanPage.setSurchargeAngleDropdown(surchargeAngle);
        minutemanPage.setIdlerOffsetTypeDropdown(idlerOffset);
        minutemanPage.setDriveDetailsDropdown(driverDetails);
        SyncUtil.waitFor(2000);
        minutemanPage.setTakeUpDetailsDropdown(takeUpDetails);
        SyncUtil.waitFor(2000);
        minutemanPage.setSpliceTypeDropdown(spliceType);
        inputDataPage=minutemanPage.getInputPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters stations {Stations} {DriveLocation} {TakeUpLocation} and click on next")
    public void userEntersStations(String stations, String driverLocation, String takeUpLocation){
        SyncUtil.waitFor(2000);
        minutemanPage.selectStation(stations);
        minutemanPage.selectDriveStation(driverLocation);
        minutemanPage.selectTakeUpStation(takeUpLocation);
        SyncUtil.waitFor(2000);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters flight info for {Stations} {HorzOffset} {ElevOffset} and click on calculate and next")
    public void userEntersFlightInfo(String stations, String[] horzOffset, String[] elevOffset){
        SyncUtil.waitFor(5000);
        minutemanPage.setConveyorFlightsConfiguration(stations,horzOffset,elevOffset);
        minutemanPage.clickOnCalculate();
        SyncUtil.waitFor(6000);
        flightInfoPage=minutemanPage.getFlightConfiguration(stations);
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User enters select belt details {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover}")
    public void userEntersSelectBeltDetails(String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,90000);
        minutemanPage.setTradeNameDropdown(tradeName);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setCoverGradeDropdown(coverGrade);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setRatingDropdown(rating);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setPliesDropdown(plies);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setCoverGaugeUnitDropdown(coverGaugeUnits);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setGaugeTopCoverDropdown(gaugeTopCover);
        minutemanPage.waitForElementToInvisible(minutemanPage.spinner,7000);
        minutemanPage.setGaugePulleyCoverDropdown(gaugePulleyCover);
        SyncUtil.waitFor(7000);
        calculatedData=minutemanPage.getCalculatedDataInSelectBelt();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "Add calculation Name {CalculationName}")
    public void addCalculationName(String calculationName){
        SyncUtil.waitFor(60000);
        minutemanPage.setTbCalculationName(calculationName);
    }

    @QAFTestStep(description = "Verify the pre populated data in general info page {Program} {ManufacturingLocation}")
    public void verifyPrePopulatedDataInGeneralInfoPage(String program,String manufacturingLocation){
        minutemanPage.verifyPerPopulatedDataInGeneralInfoPage(program,manufacturingLocation);
    }

    @QAFTestStep(description = "User click on next")
    public void clickOnNextButton(){
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "Verify the pre populated data in inputs page {BeltWidth} {BeltSpeed} {TonsPerHourPeak} {PickMaterialName} {MaterialDensity} {AngleOfIdler} {CarrySideIdlerSpacing} {DriveWrapAngle} {DriveWrapAngleDegree} {TakeUpTension} {FrictionFactor} {LengthFactor} {SurchargeAngle} {IdlerOffset} {DriverDetails} {TakeUpDetails} {SpliceType}")
    public void verifyPrePopulatedDataInInputPage(String beltWidth,String beltSpeed,String tonsPerHourPeak,String pickMaterialName,String materialDensity, String angleOfIdlers, String carrySideIdler, String driveWrapAngle,String driveWrapAngleDegree,String takeUpTension,String frictionFactor,String lengthFactor,String surchargeAngle,String idlerOffsetType,String driveDetails,String takeUpDetails, String spliceType){
        minutemanPage.verifyPrePopulatedDataInInputsPage(beltWidth,beltSpeed,tonsPerHourPeak,pickMaterialName,materialDensity,angleOfIdlers,carrySideIdler,driveWrapAngle,driveWrapAngleDegree,takeUpTension,frictionFactor,lengthFactor,surchargeAngle,idlerOffsetType,driveDetails,takeUpDetails,spliceType);
    }

    @QAFTestStep(description = "Verify the pre populated data in stations page {Stations} {DriveLocation} {TakeUpLocation}")
    public void verifyPrePopulatedDataInStationPage(String stations,String driveLocation,String takeUpLocation){
        minutemanPage.verifyPrePopulatedDetailsInStationsPage(stations,driveLocation,takeUpLocation);
    }

    @QAFTestStep(description = "Verify the pre populated data in flight info page {Stations} {HorzOffset} {ElevOffset} {SectionAngle} {EstimatedCCLength} {TypeOfConfiguration}")
    public void verifyPrePopulatedDataInFlightInfoPage(String stations,String[] horzOffset,String[] elevOffset, String[] sectionAngle,String estimatedCCLength,String typeOfConfiguration){
        SyncUtil.waitFor(25000);
        minutemanPage.verifyPrePopulatedDetailsInFlightInfo(typeOfConfiguration,stations,horzOffset,elevOffset,sectionAngle,estimatedCCLength);
    }

    @QAFTestStep(description = "Verify the pre populated data in select belt page {TradeName} {CoverGrade} {Rating} {Plies} {CoverGaugeUnits} {GaugeTopCover} {GaugePulleyCover}")
    public void verifyPrePopulatedDataInSelectBeltPage(String tradeName, String coverGrade, String rating, String plies, String coverGaugeUnits, String gaugeTopCover, String gaugePulleyCover){
        SyncUtil.waitFor(30000);
        minutemanPage.verifyPrePopulatedDetailsInSelectBeltPage(tradeName,coverGrade,rating,plies,coverGaugeUnits,gaugeTopCover,gaugePulleyCover);
    }

    @QAFTestStep(description = "Verify the pre populated data in capacity page {BeltSpeed} {TonsPerHourPeak}")
    public void verifyPrePopulatedDataInCapacityPage(String beltSpeed,String tonsPerHourPeak){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInCapacityPage(beltSpeed,tonsPerHourPeak);
    }

    @QAFTestStep(description = "Verify the pre populated data in roll data page {TotalBeltLength} {NumberOfRolls}")
    public void verifyPrePopulatedDataInRollDataPage(String totalBeltLength,String numberOfRolls){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInRollDataPage(totalBeltLength,numberOfRolls);
    }

    @QAFTestStep(description = "Verify the pre populated data in pulleys page {PulleyDiameterHead} {PulleyDiameterDrive} {PulleyDiameterTakeUp} {PulleyDiameterTail}")
    public void verifyPrePopulatedDataInPulleysPage(String pulleyDiameterHead,String pulleyDiameterDrive,String pulleyDiameterTakeUp,String pulleyDiameterTail){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInPulleyPage(pulleyDiameterHead,pulleyDiameterDrive,pulleyDiameterTakeUp,pulleyDiameterTail);
    }

    @QAFTestStep(description = "Verify the pre populated data in transition page {TransitionLengthHead} {TransitionLengthTail}")
    public void verifyPrePopulatedDataInTransitionPage(String transitionLengthHead,String transitionLengthTail){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInTransitionsPage(transitionLengthHead,transitionLengthTail);
    }

    @QAFTestStep(description = "Verify the pre populated data in take up page {TakeUpTensionIfKnown}")
    public void verifyPrePopulatedDataInTakeUpPage(String takeUpTensionIfKnown){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInTakeUpPage(takeUpTensionIfKnown);
    }

    @QAFTestStep(description = "Verify the pre populated data in curves page {CurveRadius1} {CurveRadius2} {CurveRadius3} {CurveRadius4}")
    public void verifyPrePopulatedDataInCurvesPage(String curveRadius1,String curveRadius2,String curveRadius3,String curveRadius4){
        SyncUtil.waitFor(2000);
        minutemanPage.verifyPrePopulatedDetailsInCurvesPage(curveRadius1,curveRadius2,curveRadius3,curveRadius4);
    }

    @QAFTestStep(description = "User should see all the calculated data of capacity page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfCapacityPageAndClickOnNext(){
        SyncUtil.waitFor(2000);
        capacity=minutemanPage.getCapacity();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data of Roll data page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfRollDataPageAndClickOnNext(){
        SyncUtil.waitFor(5000);
        conveyorBeltDataInRollDataPage=minutemanPage.getConveyorBeltDataInRollDataPage();
        conveyorROllDataInRollDataPage=minutemanPage.getConveyorROllDataInRollDataPage();
        conveyorSpliceDimensionsDataInRollDataPage=minutemanPage.getConveyorSpliceDimensionsDataInRollDataPage();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data of pulleys page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfPulleysPageAndClickOnNext(){
        SyncUtil.waitFor(2000);
        pulleysPageData=minutemanPage.getPulleysPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data Add {TransitionLengthHead} {TransitionLengthTail} of transition page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfTransitionPageAndClickOnNext(String transitionLengthHead,String transitionLengthTail){
        SyncUtil.waitFor(2000);
//        minutemanPage.setTbLengthHead(transitionLengthHead);
//        minutemanPage.setTbLengthTail(transitionLengthTail);
//        minutemanPage.clickOnCalculate();
//        SyncUtil.waitFor(5000);
        transitionsPageData=minutemanPage.getTransitionsPageData();
        minutemanPage.clickNext();
    }

    @QAFTestStep(description = "User should see all the calculated data Add {TakeUpTensionIfKnown} of take up page and click on next")
    public void UserShouldSeeAllTheCalculatedDataOfTakeUpPageAndClickOnNext(String takeUpTensionIfKnown){
        SyncUtil.waitFor(2000);
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

    @QAFTestStep(description = "Verify all the data shown in the reports with calculated and entered data {CalculationName} {ConveyorName} {TonsPerHourPeak} {MaterialDensity} {SurchargeAngle} {BeltWidth} {BeltSpeed} {CarrySideIdlerSpacing} {DriveLocation} {TakeUpLocation} {TakeUpDetails}")
    public void verifyTheValuesShownInTheReport(String calculationName,String conveyorName,String tonsPerHourPeak,String materialDensity,String surchargeAngle,String beltWidth,String beltSpeed,String carrySideIdlerSpacing,String driveLocation,String takeUpLocation,String takeUpDetails){
        minutemanPage.verifyConveyorInformation(conveyorBeltDataInRollDataPage,conveyorName,calculationName,"",minutemanPage.getConveyorInformation());
        minutemanPage.verifySystemCoordinates(flightInfoPage,minutemanPage.getSystemCoordinates());
        minutemanPage.verifyMaterialData(tonsPerHourPeak,materialDensity,inputDataPage,minutemanPage.getMaterialData());
        minutemanPage.verifyInputBeltData(beltWidth,beltSpeed,minutemanPage.getInputBeltData());
        minutemanPage.verifySystemData(capacity,carrySideIdlerSpacing,driveLocation,takeUpLocation,inputDataPage,minutemanPage.getSystemData());
        minutemanPage.verifyCalculateData(calculatedData,conveyorROllDataInRollDataPage,minutemanPage.getCalculatedData());
        minutemanPage.verifyBeltData(conveyorBeltDataInRollDataPage,minutemanPage.getBeltData());
        minutemanPage.verifyRollData(conveyorROllDataInRollDataPage,minutemanPage.getRollData());
        minutemanPage.verifyVulcanizedSpliceData(conveyorSpliceDimensionsDataInRollDataPage,minutemanPage.getVulcanizedSpliceData());
        minutemanPage.verifyTakeUpTravel(reviewCalculatedTakeUpTravelDataTakeUpPage,calculatedTakeUpDataInTakeUpPage,takeUpDetails,minutemanPage.getTakeUpTravel());
        minutemanPage.verifyTransitionLength(transitionsPageData,minutemanPage.getTransitionLength());
        minutemanPage.verifyVerticalCurve(calculatedVerticalCurvesDataInCurvesPage,minutemanPage.getVerticalCurves());
    }
}
