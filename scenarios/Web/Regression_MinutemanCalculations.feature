Feature: Regression for Minuteman feature


Background:
  Launch the application through '/'

 @Regression1 @CTCP-1079
 @dataFile:resources/data/LegacyMetricCalcaultion.json
 Scenario: zVerify minuteman calculation for legacy minuteman metric flow

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     And   Close warning popup
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
     Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
      Then  Verify download report option on final report '${CalculationName}'
      When  Click on create button for minuteman calculation
      Then  Verify the minuteman calculation '${CalculationName}' in list screen
      When  Edit minuteman calculation '${CalculationName}' to '${NewCalculationName}'
      Then  Verify the minuteman calculation '${NewCalculationName}' in list screen
      When  Delete minuteman calculation '${NewCalculationName}'
      Then  Verify the deleted minuteman calculation '${NewCalculationName}' in list screen


 @Regression2 @CTCP-1080 @CTCP-1081 @CTCP-1081 @CTCP-1082 @CTCP-1083 @CTCP-1084 @CTCP-1085 @CTCP-1086 @CTCP-1087 @CTCP-1088 @CTCP-1089 @CTCP-1090 @CTCP-1091 @CTCP-1092
 @dataFile:resources/data/LegacyImperialCaculation.json
 Scenario: Verify minuteman calculation for legacy minuteman imperial flow

     And   Close warning popup
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
     Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'

  @Regression3 @CTCP-1080 @CTCP-1081 @CTCP-1081 @CTCP-1082 @CTCP-1083 @CTCP-1084 @CTCP-1085 @CTCP-1086 @CTCP-1087 @CTCP-1088 @CTCP-1089 @CTCP-1090 @CTCP-1091 @CTCP-1092
  @dataFile:resources/data/LegacyMetricB.json
  Scenario: Verify minuteman calculation for legacy minuteman metric B flow
      And   Close warning popup
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
      Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'

   @Regression4 @CTCP-1080 @CTCP-1081 @CTCP-1081 @CTCP-1082 @CTCP-1083 @CTCP-1084 @CTCP-1085 @CTCP-1086 @CTCP-1087 @CTCP-1088 @CTCP-1089 @CTCP-1090 @CTCP-1091 @CTCP-1092
   @dataFile:resources/data/MinutemanImperialB.json
   Scenario: Verify minuteman calculation for legacy minuteman imperial B flow

       And   Close warning popup
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
       Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'

  @Regression5 @CTCP-1048
  @dataFile:resources/data/MinutemanPrePopulated.json
  Scenario: Verify minuteman Pre Populated values in the minuteman calculation page for metric

      And   Close warning popup
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


  @Regression6 @CTCP-1049
  @dataFile:resources/data/MinutemanPrePopulatedImperial.json
  Scenario: Verify minuteman Pre Populated values in the minuteman calculation page for imperial

      And  Close warning popup
      And  User is at add minuteman conveyor page
      And  Add calculation Name '${CalculationName}'
      Then Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
      When Switch the unit conversion to 'Imperial'
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