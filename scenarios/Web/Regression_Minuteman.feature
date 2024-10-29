Feature: Regression for Minuteman feature


Background:
  Launch the application through '/'


 @Regression1 @CTCP-944
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify navigation to minuteman from card

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     Then  Navigate to minuteman screen from site card

 @Regression2 @CTCP-945
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify minuteman add icon navigation
     And   Navigate to minuteman screen from site card
     Then  Verify user is able to click on add icon


 @Regression3 @CTCP-950
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify minuteman program dropdown
     And   User is at add minuteman conveyor page
     Then  Verify the program dropdown contents

 @Regression4 @CTCP-951
 @dataFile:resources/data/LegacyMetricA.json
 @key:minuteman
 Scenario: Verify minuteman manufacturing dropdown
     And   User is at add minuteman conveyor page
     Then  Verify the manufacturing dropdown contents for '${Program}'

 @Regression5 @CTCP-952
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify minuteman units radio button
     And   User is at add minuteman conveyor page
     Then  Verify the units radio button
     And   Close warning popup

 @Regression6 @CTCP-967
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman for station navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     Then  Verify the stations screen navigation
     And   Close warning popup

 @Regression6 @CTCP-967
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman for station navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     Then  Verify the stations screen navigation
     And   Close warning popup

 @Regression7 @CTCP-968
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman station radio button
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     Then  Verify the stations radio button selections
     And   Close warning popup

 @Regression8 @CTCP-972
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman flight screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     Then  Verify the flight screen navigation
     And   Close warning popup

 @Regression9 @CTCP-982
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman select belt screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     Then  Verify the select belt screen navigation
     And   Close warning popup

 @Regression10 @CTCP-989
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman select belt calculated data
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     Then  User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   Close warning popup

 @Regression11 @CTCP-991
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman capacity screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     Then  Verify capacity screen navigation
     And   Close warning popup

 @Regression12 @CTCP-1006
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman roll data screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     Then  Verify roll data screen navigation
     And   Close warning popup

 @Regression13 @CTCP-1017
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman pulley data screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     Then  Verify pulley data screen navigation
     And   Close warning popup

 @Regression14 @CTCP-1023
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman transition screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     Then  Verify transition screen navigation
     And   Close warning popup

 @Regression15 @CTCP-1028
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman curves screen navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
     And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
     Then  Verify curves screen navigation
     And   Close warning popup

 @Regression16 @CTCP-1031
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman final report navigation
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
     And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
     And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
     Then  Verify final report screen navigation
     And   Close warning popup

 @Regression17 @CTCP-1031
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman final report download
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
     And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
     And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
     Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
     Then  Verify download report option on final report
     And   Close warning popup

 @Regression18 @CTCP-1042
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify delete created minuteman calculation
     And   Navigate to minuteman screen from site card
     And   Delete the created minuteman calculation '${CalculationName}'
     Then  Verify the minuteman calculation is deleted '${CalculationName}'

 @Regression19 @CTCP-1042
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify delete created minuteman calculation
     And   Navigate to minuteman screen from site card
     And   Delete the created minuteman calculation '${CalculationName}'
     Then  Verify the minuteman calculation is deleted '${CalculationName}'


 @Regression20 @CTCP-1042
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:minuteman
 Scenario: Verify delete created minuteman calculation
     And   Navigate to minuteman screen from site card
     And   Delete the created minuteman calculation '${CalculationName}'
     Then  Verify the minuteman calculation is deleted '${CalculationName}'

 @Regression21 @CTCP-1048
 @dataFile:resources/data/MinutemanPrePopulated.json
 Scenario: Verify minuteman Pre Populated values in the minuteman calculation page for metric
     And  User is at add minuteman conveyor page
     And  Add calculation Name '${CalculationName}'
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
     And   Close warning popup


 @Regression22 @CTCP-1049
 @dataFile:resources/data/MinutemanPrePopulatedImperial.json
 Scenario: Verify minuteman Pre Populated values in the minuteman calculation page for imperial
     And  User is at add minuteman conveyor page
     And  Add calculation Name '${CalculationName}'
     Then Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
     When User switches the units to imperial from metric
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
     And   Close warning popup

 @Regression23 @CTCP-1031
 @dataFile:resources/data/LegacyMetricA.json
 Scenario: Verify minuteman calculation for legacy minuteman metric flow
     And   User is at add minuteman conveyor page
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
     And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
     And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
     Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
     And   Close warning popup


  @Regression24 @CTCP-1080 @CTCP-1081 @CTCP-1081 @CTCP-1082 @CTCP-1083 @CTCP-1084 @CTCP-1085 @CTCP-1086 @CTCP-1087 @CTCP-1088 @CTCP-1089 @CTCP-1090 @CTCP-1091 @CTCP-1092
  @dataFile:resources/data/LegacyImperialCaculation.json
  Scenario: Verify minuteman calculation for legacy minuteman imperial flow
      And   User is at add minuteman conveyor page
      When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
      And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
      And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
      And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
      And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
      And   User should see all the calculated data of capacity page and click on next
      And   User should see all the calculated data of Roll data page and click on next
      And   User should see all the calculated data of pulleys page and click on next
      And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
      And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
      And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
      Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
      And   Close warning popup

   @Regression25 @CTCP-968
   @dataFile:resources/data/LegacyMetricA.json
   Scenario: Verify minuteman station radio button
       And   User is at add minuteman conveyor page
       When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
       And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
       Then  Verify the stations radio button selections
       And   Close warning popup

   @Regression26 @CTCP-972
   @dataFile:resources/data/LegacyMetricA.json
   Scenario: Verify minuteman flight screen navigation
       And   User is at add minuteman conveyor page
       When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
       And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
       And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
       Then  Verify the flight screen navigation
       And   Close warning popup