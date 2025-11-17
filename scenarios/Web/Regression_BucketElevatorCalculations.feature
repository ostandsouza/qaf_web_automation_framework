Feature: Regression for Minuteman feature


Background:
  Launch the application through '/'

 @Regression1 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevatorB.json
 Scenario: Verify zbucket elevator calculation for legacy minuteman metric flow

     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
     And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
     Then  Verify download report option for bucket elevator on final report '${CalculationName}'
     When  Click on create button for minuteman calculation
     Then  Verify the minuteman calculation '${CalculationName}' in list screen


@Regression2 @CTCP-1079
@dataFile:resources/data/LegacyImperialBucketElevatorB.json
Scenario: Verify bucket elevator calculation for legacy minuteman imperial flow

  And   Close warning popup
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
  And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
  Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
  Then  Verify download report option for bucket elevator on final report '${CalculationName}'
  When  Click on create button for minuteman calculation
  Then  Verify the minuteman calculation '${CalculationName}' in list screen

@Regression3 @CTCP-1079
@dataFile:resources/data/CipherMetricBucketElevatorB.json
Scenario: Verify bucket elevator calculation for cipher metric flow

   And   Close warning popup
   And   User is at add minuteman bucket elevator page
   When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
   And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
   And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
   And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
   Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
   Then  Verify download report option for bucket elevator on final report '${CalculationName}'
   When  Click on create button for minuteman calculation
   Then  Verify the minuteman calculation '${CalculationName}' in list screen

@Regression4 @CTCP-1079
@dataFile:resources/data/CipherImperialBucketElevatorB.json
Scenario: Verify bucket elevator calculation for cipher imperial flow

    And   Close warning popup
    And   User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    Then  Verify download report option for bucket elevator on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen


@Regression5 @CTCP-1079
@dataFile:resources/data/MinutemanMetricBucketElevatorB.json
Scenario: Verify bucket elevator calculation for minuteman metric flow

  Given User is at Login page
  When  Login with '${UserName}' and '${Password}'
    And   Close warning popup
    And   User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    Then  Verify download report option for bucket elevator on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen

@Regression6 @CTCP-1079
@dataFile:resources/data/MinutemanImperialBucketElevatorB.json
Scenario: Verify bucket elevator calculation for minuteman imperial flow

    And   Close warning popup
    And   User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    Then  Verify download report option for bucket elevator on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen

 @Regression7
 @dataFile:resources/data/LegacyMetricBucketElevatorA.json
 Scenario: Verify bucket elevator calculation for legacy minuteman metric flow

     And   Close warning popup
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
     And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
     Then  Verify download report option for bucket elevator on final report '${CalculationName}'
     When  Click on create button for minuteman calculation
     Then  Verify the minuteman calculation '${CalculationName}' in list screen

@Regression8
@dataFile:resources/data/LegacyImperialBucketElevatorA.json
Scenario: Verify bucket elevator calculation for legacy minuteman imperial flow

  And   Close warning popup
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
  And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
  Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
  Then  Verify download report option for bucket elevator on final report '${CalculationName}'
  When  Click on create button for minuteman calculation
  Then  Verify the minuteman calculation '${CalculationName}' in list screen