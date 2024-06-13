Feature: Regression of P2 Inspection module

  Background:
  Launch the application through '/'

  @Regression1 @CTCP-1365
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Value
  Scenario: ZzLook for data display in cover wear summary listing screen

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to coverWear list screen and wait for data load
    Then Verify CoverWear header as Cover Wear Summary
    And Verify CoverWear column name


  @Regression2 @CTCP-1366
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Value
  Scenario: ZyVerify the logic of displaying cover grade

    And   Navigate to coverWear list screen and wait for data load
    And Search '${ConveyorName}' coverWear
    Then Extract CoverGrade value
    And Click on view button
    Then  Verify the CoverGrade value


  @Regression3 @CTCP-1377
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Value
  Scenario: ZxVerify the pagination functionality

    And   Navigate to coverWear list screen and wait for data load
    Then Verify pagination dropdown
    And Verify pagination forward arrow button


  @Regression4 @CTCP-1382
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Management
  Scenario: XzVerify temperature and Tons  conveyed are not mandatory values

#    Then Add Cover Wear for conveyor '${ConveyorName}' and site '${CustSiteName}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to coverWear list screen and wait for data load
    And  Click on Add and verify Add new measurement pop up
    Then  Verify Temperature and Tons Conveyed are not mandatory
    And  Add details '${CustSiteName}' '${ConveyorName}' '${Position}' for measurement pop up
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And   Verify save functionality for new measurement

  @Regression5 @CTCP-1383
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Management
  Scenario: XyVerify user able to save temperature value and tons conveyed value as zero

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to coverWear list screen and wait for data load
    And  Click on Add and verify Add new measurement pop up
    Then  Add details '${CustSiteName}' '${ConveyorName}' '${Position}' for measurement pop up
    And  Add temperature and tons conveyed value as '${Zero}'
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And   Verify save functionality for new measurement

  @Regression6 @CTCP-1384
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CoverWear_Management
  Scenario: XxVerify user is able to add device while adding measurement

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to coverWear list screen and wait for data load
    And  Click on Add and verify Add new measurement pop up
    Then  Add details '${CustSiteName}' '${ConveyorName}' '${Position}' for measurement pop up
    And Add details '${Device}' '${Velocity}' '${CalThickness}' '${SurfaceTemp}' '${TestPosition}' for measurement pop up
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And   Verify save functionality for new measurement
    Then Edit Cover wear measurement for conveyor '${ConveyorName}'
    And Verify the measurement details '${CustSiteName}' '${ConveyorName}'


  @Regression7 @CTCP-1380
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CovereWear_Management_Position_Metric
  Scenario: Verify metric to imperial conversion

    And   Navigate to coverWear list screen and wait for data load
    And   Verify data value in header as metric
    And  Add Cover Wear for conveyor '${ConveyorName}' and site '${CustSiteName}' with data '${PositionName}' '${BeltWidth}'
    Then Verify data value are in metric with value '${MetricValue}'
    And   Navigate to coverWear list screen and wait for data load
    And Edit Cover wear measurement for conveyor '${ConveyorName}'
    Then Add data value in header as imperial
    And Verify data value are in imperial with value '${ImperialValue}'

  @Regression8 @CTCP-1381
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:CovereWear_Management_Position_Imperial
  Scenario: Verify imperial to metric conversion

    And   Navigate to coverWear list screen and wait for data load
    And Add data value in header as imperial
    And   Verify data value in header as imperial
    And  Add Cover Wear for conveyor '${ConveyorName}' and site '${CustSiteName}' with data '${PositionName}' '${BeltWidth}'
    Then Verify data value are in imperial with value '${ImperialValue}'
    And   Navigate to coverWear list screen and wait for data load
    And Edit Cover wear measurement for conveyor '${ConveyorName}'
    Then Add data value in header as metric
    And Verify data value are in metric with value '${MetricValue}'

@Regression9 @CTCP-1443
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: ZVerify temperature and Tons conveyed are not mandatory values in position

   Given User is at Login page
   When Login with '${UserName}' and '${Password}'
   And Navigate to coverWear list screen and wait for data load
   And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
   And Navigation to Position Details Screen for position '${Position}'
   And Click on Add in Position Detail screen and verify Add new measurement pop up
   Then Verify Temperature and Tons Conveyed are not mandatory
   And Add readings durometer values '${DurometerValue}' and '${Value}'
   And Verify save functionality for new measurement


@Regression10 @CTCP-1444
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Verify user is able to save temperature value and tons conveyed value is zero

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Navigation to Position Details Screen for position '${Position}'
    And  Click on Add in Position Detail screen and verify Add new measurement pop up
    Then Add temperature and tons conveyed value as '${Zero}'
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And  Verify save functionality for new measurement


@Regression11 @CTCP-1429
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Guaze_Data
Scenario: Verify data displayed in Gauge meter in case measurment already exist

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Navigation to Position Details Screen for position '${Position}'
    Then Verify Guaze image is displayed in specification field
    And Verify no data is displayed in guaze


@Regression12 @CTCP-1442
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Observe life displayed in projection table should be displayed in years

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Navigation to Position Details Screen for position '${Position}'
    Then Verify Wear Rate Statistics and Projection table
    And Verify Wear Rate Statistics table values are in years

@Regression13 @CTCP-1439
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Verify Wear Rate Statistics & Projections table

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Navigation to Position Details Screen for position '${Position}'
    Then Verify Wear Rate Statistics and Projection table
    And Verify fields in the Wear Rate Statistics and Projection table

@Regression14 @CTCP-1426
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Verify Specification details for position

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Navigation to Position Details Screen for position '${Position}'
    Then Verify the Position headings as '${Position}'
    And Verify the Specification format as '${BeltConstruction}' '${BeltWidth}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}'
    And Verify the date of installation format as '${Date}'
    And Verify the durometer value format as '${NewDurometerValue}'
    And Verify date of installation '${Date}' and specification '${BeltConstruction}' '${BeltWidth}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}' is same in technical data


@Regression14 @CTCP-1388
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: ZzLook for data display in cover wear summary listing screen

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    Then Verify CoverWear Position table header as Positions
    And Verify CoverWear Position Table column name

@Regression14 @CTCP-1402
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_CoverWear_Management
Scenario: Verify user is able to add Tons conveyed with values as '0'

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Click on Add New Position
    Then Verify customer as '${CustSiteName}' conveyor as '${ConveyorName}' width as '${BeltWidth}' for add position popUp
    And Add segment as '${Segment}' tons conveyed as '${Zero}' durometer as '${DurometerValue}'
    And Click Top/Bottom radio button and verify selection
    And Click save and verify segment '${PositionName}' creation

@Regression14 @CTCP-1404
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: ZyVerify fields displayed Specification Section

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    Then Verify Specification header
    And Verify Specification table Fields

@Regression14 @CTCP-1395
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: ZxVerify download functionality via Action button

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Verify after selecting cover wear position '${Position}' action button is enabled
    Then Verify the contents of action dropdown for position
    And Click on export and verify export popup


@CTCP-1453
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Report_Download
Scenario: Verify data displayed in UI and downloaded report is same

   Given User is at Login page
   When  Login with '${UserName}' and '${Password}'
   And Navigate to coverWear list screen and wait for data load
   And Extract the CoverWear Data for '${CoverWearName}'
   And Click on coverWear report download button
   And Select all fields '${FromDate}' '${ToDate}' in the pop and verify user is able to fill respective fields
  Then Verify the coverWear pdf report for '${CoverWearName}' with '${SiteName}'
