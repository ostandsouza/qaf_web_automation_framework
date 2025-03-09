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