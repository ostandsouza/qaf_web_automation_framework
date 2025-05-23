Feature: Regression for Minuteman feature


Background:
  Launch the application through '/'

 @Regression1 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify zbucket elevator add minuteman navigation
     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     Then  Navigate to minuteman screen from site card

 @Regression2 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator add minuteman dropdown contents
     Then  Verify the add minuteman dropdown contents

 @Regression3 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify user able to select bucket elevator from add minuteman dropdown
     Then  User is at add minuteman bucket elevator page

 @Regression4 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify user able to select bucket elevator from add minuteman dropdown
     And   User is at add minuteman bucket elevator page
     Then  User enters elevator general info '${CalculationName}' and click on next

 @Regression5 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator program dropdown
     And   User is at add minuteman bucket elevator page
     Then  Verify the program dropdown contents

 @Regression6 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator for legacy minuteman program
     And   User is at add minuteman bucket elevator page
     Then  Verify the program dropdown selection with 'Legacy Minuteman'

 @Regression7 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator for cypher program
     And   User is at add minuteman bucket elevator page
     Then  Verify the program dropdown selection with 'Legacy Cypher'

 @Regression8 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator for minuteman program
     And   User is at add minuteman bucket elevator page
     Then  Verify the program dropdown selection with 'Minuteman'

 @Regression9 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator units radio button
     And   User is at add minuteman bucket elevator page
     Then  Verify the units radio button

 @Regression10 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator conveyor dropdown is disabled
     And   User is at add minuteman bucket elevator page
     Then  Verify the conveyor dropdown is disabled

 @Regression11 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator conveyor type A
     And   User is at add minuteman bucket elevator page
     And   User enters elevator general info '${CalculationName}' and click on next
     Then  Verify selection of conveyor type for 'A'

 @Regression12 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator conveyor type B
     And   User is at add minuteman bucket elevator page
     And   User enters elevator general info '${CalculationName}' and click on next
     Then  Verify selection of conveyor type for 'B'

 @Regression13 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator conveyor type C
     And   User is at add minuteman bucket elevator page
     And   User enters elevator general info '${CalculationName}' and click on next
     Then  Verify selection of conveyor type for 'C'

 @Regression14 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator take up type dropdown
     And   User is at add minuteman bucket elevator page
     And   User enters elevator general info '${CalculationName}' and click on next
     Then  Verify the take up type dropdown contents

 @Regression15 @CTCP-1079
 @dataFile:resources/data/LegacyMetricBucketElevator.json
 Scenario: Verify bucket elevator select belt screen navigation
     And   User is at add minuteman bucket elevator page
     And   User enters elevator general info '${CalculationName}' and click on next
     And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
     Then  Verify the select belt screen navigation

@Regression16 @CTCP-3394
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_duplicate
Scenario: Verify duplicate name creation on the bucket elevator

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName1}' '${CustSiteName}' '${ConveyorName}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName1}' '${CustSiteName}' '${ConveyorName}'
     When  Click on create button for minuteman calculation
     Then  Verify the minuteman calculation '${CalculationName1}' in list screen
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName2}' '${CustSiteName}' '${ConveyorName2}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName2}' '${CustSiteName}' '${ConveyorName2}'
     When  Click on create button for minuteman calculation
     Then  Verify the minuteman calculation '${CalculationName2}' in list screen
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName1}' '${CustSiteName}' '${NoConveyor}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName1}' '${CustSiteName}' '${NoConveyor}'
     When  Click on create button and verify failure toast
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName1}' '${CustSiteName1}' '${ConveyorName1}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName1}' '${CustSiteName1}' '${ConveyorName1}'
     When  Click on create button for minuteman calculation
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName1}' '${NoSite}' '${NoConveyor}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName1}' '${NoSite}' '${NoConveyor}'
     When  Click on create button for minuteman calculation
     And   User is at add minuteman bucket elevator page
     When  User enters elevator general info '${CalculationName1}' '${NoSite}' '${NoConveyor}' and click on next
     And   User enters elevator select belt details and click on final report
     Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName1}' '${NoSite}' '${NoConveyor}'
     When  Click on create button and verify failure toast

@Regression17 @CTCP-4038
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: zVerify user is able to rename the duplicate bucket elevator calculation

  Given User is at Login page
  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  And   User enters elevator select belt details and click on final report
  Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${CustSiteName}' '${ConveyorName}'
  When  Click on create button for minuteman calculation
  Then  Verify the minuteman calculation '${CalculationName}' in list screen
  When  Duplicate minuteman calculation '${CalculationName}' to '${NewCalculationName}'
  Then  Verify the minuteman calculation '${NewCalculationName}' in list screen
  When  Edit bucket elevator minuteman calculation '${NewCalculationName}' to '${EditCalculationName}'
  Then  Verify the minuteman calculation '${EditCalculationName}' in list screen

@Regression18 @CTCP-3331
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify user is able to click cancel button on add screen

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup
  When  User is at add minuteman bucket elevator page
  Then  Verify cancel button functionality when blank
  And   Close warning popup

@Regression19 @CTCP-3353
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify user is able to click help button on input screen

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  Then  Verify help button functionality for bucket elevator
  And   Verify the next navigation in help page
  And   Verify the previous navigation in help page
  When  Verify the close button functionality for help page
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

  @Regression20 @CTCP-3358
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:minuteman_rename
  Scenario: Verify user is able to click help button on input screen

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' and click on save
    Then  Verify toast message when partially filled bucket elevator


@Regression21 @CTCP-3382
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify user is able to click calculated outputs button on output screen

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  Then  User enters elevator select belt details and click on next
  Then  Verify the 100% calculated output capacity on output screen
  Then  Verify the reset for calculated output capacity on output screen
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

@Regression22 @CTCP-3388
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify previous and next functionality on all screens

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  Then  Verify the bucket elevator input screen navigation
  When  User click on next
  Then  Verify the select belt screen navigation
  When  User click on next
  Then  Verify the bucket elevator output screen navigation
  When  User click on next
  Then  Verify the bucket elevator final report navigation
  When  User click on previous
  Then  Verify the bucket elevator output screen navigation
  When  User click on previous
  Then  Verify the select belt screen navigation
  When  User click on previous
  Then  Verify the bucket elevator input screen navigation
  When  User click on previous
  Then  Verify the bucket elevator general info screen navigation
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

@Regression23 @CTCP-3390
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify user is able to click save button on final screen in edit mode

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  And   User enters elevator select belt details and click on next
  When  Click on create button for minuteman calculation
  When  Navigate to edit mode for bucket elevator minuteman calculation '${CalculationName}'
  Then  Verify the program dropdown selection with 'Legacy Cypher'
  When  User click on next
  Then  Verify selection of conveyor type for 'B'
  When  User click on next
  Then  Verify the select belt screen navigation
  When  User click on next
  Then  Verify the bucket elevator output screen navigation
  When  User click on next
  Then  Verify the bucket elevator final report navigation
  And   Verify the save functionality on edit mode

@Regression24 @CTCP-3396
@dataFile:resources/data/LegacyMetricBucketElevatorA.json
Scenario: Verify user is able to change to imperial on edit mode

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  When  User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
  And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
  And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
  And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
  Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
  When  Click on create button for minuteman calculation
  And   Edit bucket calculation '${CalculationName}' units to 'Imperial' with '${Program}' '${ManufacturingLocation}'
  And   Navigate the minuteman calculation '${CalculationName}' in list screen
  Then  Verify the pre populated data in general info page for imperial '${Program}' '${ManufacturingLocation}'
  When  User click on next
  Then  Verify the bucket elevator pre populated data in inputs page '${ConveyorTypeM}' '${MaterialDensityM}' '${TonsPerHourPeakM}' '${MaterialLengthM}' '${MaterialProjectionM}' '${BucketSpacingM}' '${BucketWeightM}' '${BucketVolumeM}' '${BucketRowsM}' '${BeltWidthM}' '${BeltHeightM}' '${BeltSpeedM}' '${DrivePulleyM}' '${TakeUpTypeM}'


@Regression25 @CTCP-3397
@dataFile:resources/data/CipherImperialBucketElevatorB.json
Scenario: Verify user is able to change to metric on edit mode

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    When  User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen
    And   Edit bucket calculation '${CalculationName}' units to 'Metric' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the bucket elevator pre populated data in inputs page '${ConveyorTypeM}' '${MaterialDensityM}' '${TonsPerHourPeakM}' '${MaterialLengthM}' '${MaterialProjectionM}' '${BucketSpacingM}' '${BucketWeightM}' '${BucketVolumeM}' '${BucketRowsM}' '${BeltWidthM}' '${BeltHeightM}' '${BeltSpeedM}' '${DrivePulleyM}' '${TakeUpTypeM}'

@Regression26 @CTCP-3398
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify user is able to move from general info to select belt

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  And   User enters elevator select belt details
  Then  Verify the select belt screen navigation

@Regression27 @CTCP-3609
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify minuteman count from distributor corporate level

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  When  Navigate to minuteman list from minuteman card at corporate level '${DistCorpName}' and 'distributor_corporate'
  Then  Verify the minuteman card count with the api


@Regression28 @CTCP-3610
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify minuteman count from distributor shop level

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   Navigate to distributor shop detail screen for '${DistCorpName}' with '${DistShop}'
  When  Navigate to minuteman list from minuteman card at site/shop level '${DistShop}' and 'shop'
  Then  Verify the minuteman card count with the api

@Regression29 @CTCP-3611
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify minuteman count from customer corporate level

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  When  Navigate to minuteman list from minuteman card at corporate level '${CustCorpName}' and 'customer_corporate'
  Then  Verify the minuteman card count with the api

@Regression30 @CTCP-3612
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify minuteman count from conveyor level

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  When  Navigate to conveyor details screen for conveyor '${ConveyorName}'
  Then  Navigate to minuteman list from minuteman card at conveyor level '${ConveyorName}' and 'conveyor'
  Then  Verify the minuteman card count with the api

@Regression31 @CTCP-3613
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: zVerify fields in calculated output screen are disabled.

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  And   User enters elevator select belt details and click on next
  Then  Verify the fields in calculated outputs are disabled
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

@Regression32 @CTCP-3865
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify information content in input screen for all programs

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  And   Verify selection of conveyor type for 'A'
  And   Verify selection of conveyor type for 'B'
  And   Verify selection of conveyor type for 'C'
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

@Regression33 @CTCP-3972
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify cancel and create button are visible when newly creating calculation

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  And   User enters elevator select belt details and click on final report
  Then  Verify the cancel and create button are visible when newly creating calculation
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

@Regression34 @CTCP-3973
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify warning popup when exiting new calculation

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' '${CustSiteName}' '${ConveyorName}' and click on next
  And   User enters elevator select belt details and click on final report
  And   Navigate to minuteman screen from site card
  Then  Verify warning popup on exiting calculation
  And   Close warning popup

@Regression35 @CTCP-3974
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify cancel and save button are visible when editing calculation

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   User is at add minuteman bucket elevator page
  When  User enters elevator general info '${CalculationName}' and click on next
  And   User enters elevator select belt details and click on next
  When  Click on create button for minuteman calculation
  When  Navigate to edit mode for bucket elevator minuteman calculation '${CalculationName}'
  When  User click on next
  When  User click on next
  When  User click on next
  When  User click on next
  Then  Verify the cancel and save button are visible when editing calculation
  Then  Verify cancel button functionality when partially filled
  And   Close warning popup

  @Regression36 @CTCP-3975
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:minuteman_rename
  Scenario: Verify warning popup when exiting edit calculation

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' and click on next
    And   User enters elevator select belt details and click on next
    When  Click on create button for minuteman calculation
    When  Navigate to edit mode for bucket elevator minuteman calculation '${CalculationName}'
    And   User enters elevator general info '${NewCalculationName}' and click on next
    And   Navigate to minuteman screen from site card
    Then  Verify warning popup on exiting calculation
    And   Close warning popup

@Regression37 @CTCP-4048
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_rename
Scenario: Verify minuteman count from site level

#  Given User is at Login page
#  When  Login with '${UserName}' and '${Password}'
  And   Navigate to distributor shop detail screen for '${CustCorpName}' with '${CustSiteName}'
  When  Navigate to minuteman list from minuteman card at site/shop level '${CustSiteName}' and 'site'
  Then  Verify the minuteman card count with the api