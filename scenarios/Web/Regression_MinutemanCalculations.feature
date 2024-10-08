Feature: Regression for Minuteman feature


Background:
  Launch the application through '/'

 @Regression1 @CTCP-1079
 @dataFile:resources/data/LegacyMetricCalcaultion.json
 Scenario: Verify minuteman calculation for legacy minuteman metric flow
     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
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


 @Regression2 @CTCP-1080 @CTCP-1081 @CTCP-1081 @CTCP-1082 @CTCP-1083 @CTCP-1084 @CTCP-1085 @CTCP-1086 @CTCP-1087 @CTCP-1088 @CTCP-1089 @CTCP-1090 @CTCP-1091 @CTCP-1092
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