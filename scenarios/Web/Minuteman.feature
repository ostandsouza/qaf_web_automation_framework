Feature: Minuteman


Background:
  Launch the application through '/'

@Test
@dataFile:resources/data/MinutemanPrePopulated.json
Scenario: Testing xpath
  Given Login with '${UserName}' and '${Password}'
  When User is at add minuteman conveyor page
  And Station Page '${CalculationName}' '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${DriveWrapAngleDegree}' '${TakeUpTension}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' '${Stations}' '${DriveLocation}' '${TakeUpLocation}' '${HorzOffset}' '${ElevOffset}' '${SectionAngle}' '${EstimatedCCLength}' '${TypeOfConfiguration}' '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}' '${CalculationName}' '${ConveyorName}'

@Minuteman1 @All
@dataFile:resources/data/MinutemanPrePopulated.json
Scenario: Verify the Pre Populated values in the minuteman calculation page
  Given Login with '${UserName}' and '${Password}'
  When User is at add minuteman conveyor page
  And Add calculation Name '${CalculationName}'
  Then Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
  When User click on next
  Then Verify the pre populated data in inputs page '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${DriveWrapAngleDegree}' '${TakeUpTension}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}'
  When User click on next
  Then Verify the pre populated data in stations page '${Stations}' '${DriveLocation}' '${TakeUpLocation}'
  When User click on next
  Then Verify the pre populated data in flight info page '${Stations}' '${HorzOffset}' '${ElevOffset}' '${SectionAngle}' '${EstimatedCCLength}' '${TypeOfConfiguration}'
  When User click on next
  Then Verify the pre populated data in select belt page '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  When User click on next
  Then Verify the pre populated data in capacity page '${BeltSpeed}' '${TonsPerHourPeak}'
  When User click on next
  Then Verify the pre populated data in roll data page '${TotalBeltLength}' '${NumberOfRolls}'
  When User click on next
  Then Verify the pre populated data in pulleys page '${PulleyDiameterHead}' '${PulleyDiameterDrive}' '${PulleyDiameterTakeUp}' '${PulleyDiameterTail}'
  When User click on next
  Then Verify the pre populated data in transition page '${TransitionLengthHead}' '${TransitionLengthTail}'
  When User click on next
  Then Verify the pre populated data in take up page '${TakeUpTensionIfKnown}'
  When User click on next
  Then Verify the pre populated data in curves page '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}'

@Minuteman2 @All
@dataFile:resources/data/MinutemanMetricA.json
Scenario: Minuteman Metric North America
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman2 @All
@dataFile:resources/data/MinutemanMetricB.json
Scenario: Minuteman Metric North America
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman3 @All
@dataFile:resources/data/MinutemanImperialA.json
Scenario: Minuteman Imperial North America
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman4 @All
@dataFile:resources/data/LegacyMetricA.json
Scenario: Legacy Minuteman Metric United States
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman5 @All
@dataFile:resources/data/LegacyImperialA.json
Scenario: Legacy Minuteman Imperial United States
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman6 @All
@dataFile:resources/data/CypherMetricA.json
Scenario: Legacy Cypher Metric United States
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'


@Minuteman7 @All
@dataFile:resources/data/CypherImperialA.json
Scenario: Legacy Cypher Imperial United States
  Given Login with '${UserName}' and '${Password}'
  And User is at add minuteman conveyor page
  When User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
  And User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
  And User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
  And User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  Then User should see all the calculated data of capacity page and click on next
  And User should see all the calculated data of Roll data page and click on next
  And User should see all the calculated data of pulleys page and click on next
  And User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
  And User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
  And User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
  And Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
