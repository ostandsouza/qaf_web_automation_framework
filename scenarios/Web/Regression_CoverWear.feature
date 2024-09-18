Feature: Regression of P2 Inspection module

  Background:
  Launch the application through '/'

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

@Regression1 @CTCP-1363
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: ZVerify the breadcrumb functionality of the page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Verify user is on the home page of the application
    And Click on coverWear card and verify it navigates to coverWear list page
    And Verify the breadCrumb of coverWear page
    And Click on home link in breadCrumb and verify it navigates to home page

@Regression6 @CTCP-1364
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Durometer
Scenario: AVerify the count displayed in cover wear card

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    Then Look for the count displayed in yellow of durometer and verify the count
    And Look for the count displayed in red of durometer and verify the count
    And Look for the count displayed in green of durometer and verify the count

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
    And Click on the view button
    Then  Verify the CoverGrade value


@Regression4 @CTCP-1373
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of column name

    And Navigate to cover wear listing screen
    Then Click on the column name and verify the column names
    And Select any column name to be displayed and verify the column is displayed

@Regression2 @CTCP-1374
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: Verify search functionality


    And Navigate to cover wear listing screen
    Then Look for the searchBar in the table and verify search icon and search placeholder is visible
    When Enter the text '${ConveyorName}' to search
    And Verify the matching result is displayed or No record found message should display

@Regression5 @CTCP-1375
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of sorting

    And Navigate to cover wear listing screen
   Then Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column and verify sorting should be in increasing order
   And Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column again and verify sorting should be in decreasing order


@Regression3 @CTCP-1376
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of clear filter

    And Navigate to cover wear listing screen
    When Apply sorting or filter on column name
    Then Verify that the filter is applied
    And Click on clear filter and verify filter is removed

 @Regression3 @CTCP-1377
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:CoverWear_Value
 Scenario: ZxVerify the pagination functionality

    And   Navigate to coverWear list screen and wait for data load
    Then Verify pagination dropdown
    And Verify pagination forward arrow button

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



@Regression7 @CTCP-1425
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: ZVerify bread crumb

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Click on conveyor position '${Position}' and navigate to position screen
    And Verify the bread crumb of cover wear position page with position '${Position}' conveyor '${ConveyorName}' site '${CustSiteName}' corporate '${CustCorp}'
    And Verify user navigates to respective page on bread crumb click '${CustSiteName}' '${CustCorp}' '${ConveyorName}'

@Regression14 @CTCP-1426
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Verify Specification details for position

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Click on conveyor position '${Position}' and navigate to position screen
    Then Verify the Position headings as '${Position}'
    And Verify the Specification format as '${BeltConstruction}' '${BeltWidth}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}'
    And Verify the date of installation format as '${InstalledDate}'
    And Verify the durometer value format as '${NewDurometerValue}'
    And Verify date of installation '${Date}' and specification '${BeltConstruction}' '${BeltWidth}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}' is same in technical data



@Regression8 @CTCP-1428
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: Verify data displayed in Gauge meter in case measurement already exist

    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Extract the data from the position '${Position}' and navigate to position detail page
    Then Verify Gauge image is displayed in specification field
    And Verify that all the data is displayed in the gauge meter
    And Verify the data in gauge meter matches with data in the position detail page

@Regression11 @CTCP-1429
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Guaze_Data
Scenario: Verify data displayed in Gauge meter in case measurment already exist

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Click on conveyor position '${Position}' and navigate to position screen
    Then Verify Gauge image is displayed in specification field
    And Verify no data is displayed in guaze


@Regression10 @CTCP-1431
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementDetails
Scenario: Verify enter in table for installed data


    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    And Extract the installed date data from the position '${Position}' and navigate to position detail page
    Then Verify the installed date in the table is same as installed date in the position detail screen
    And Verify edit and attachment link should be displayed for installed date entry row
    And Click on edit link user should be able to edit the measurement details '${Thickness}' '${DurometerVal}'
    And Click on attachment link user should be able to upload image

@Regression13 @CTCP-1439
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Verify Wear Rate Statistics & Projections table

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Click on conveyor position '${Position}' and navigate to position screen
    Then Verify Wear Rate Statistics and Projection table
    And Verify fields in the Wear Rate Statistics and Projection table

@Regression11 @CTCP-1440
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementImage
Scenario: Verify attachment functionality

    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Click on conveyor position '${Position}' and navigate to position screen
    And Look for measurement table and verify data is available in measurement table
    And Look for attachment link and verify the background is highlighted when image is not attached
    And Click link to upload image '${imgName}' and Click save button and verify image is uploaded
    And Verify the background color is removed after the image is uploaded
    When Click on add icon button and verify user is able to add more attachment '${imgNameTwo}'
    Then Look for more attachment file in corosal additional image should be displayed
    And Click on image below in the corrosal respective image should get maximized
    And Click on delete button at the top and verify respective image should be deleted

@Regression12 @CTCP-1442
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: Observe life displayed in projection table should be displayed in years

    And  Navigate to coverWear list screen and wait for data load
    And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
    And Click on conveyor position '${Position}' and navigate to position screen
    Then Verify Wear Rate Statistics and Projection table
    And Verify Wear Rate Statistics table values are in years

@Regression9 @CTCP-1443
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Management_Add_Position
Scenario: ZVerify temperature and Tons conveyed are not mandatory values in position

   Given User is at Login page
   When Login with '${UserName}' and '${Password}'
   And Navigate to coverWear list screen and wait for data load
   And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
   And Click on conveyor position '${Position}' and navigate to position screen
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
    And Click on conveyor position '${Position}' and navigate to position screen
    And  Click on Add in Position Detail screen and verify Add new measurement pop up
    Then Add temperature and tons conveyed value as '${Zero}'
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And  Verify save functionality for new measurement

@Regression9 @CTCP-1445
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_AddMeasurementDetails
Scenario: Verify user is able to add device details while adding measurement

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Click on conveyor position '${Position}' and navigate to position screen
    And Click on add new measurement and verify the pop-up to add measurement is visible
    And Verify fields to add device details is displayed
    When User adds the value for instrument '${Instrument}' velocity '${Velocity}' Calibration thickness '${CalibrationThickness}' surfaceTemperature '${SurfaceTemperature}' test Position '${TestPosition}'
    And Add readings durometer values '${DurometerValue}' and '${Value}'
    And Click on save button and verify measurement is saved
    Then Click on edit button and verify measurement popup is opened with user saved data '${SurfaceTemperature}' '${TestPosition}'
    And Click on delete button to delete the added measurement value


@Regression12 @CTCP-1386
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_BreadCrumb
Scenario: ZVerify the breadcrumb functionality of the page


    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Click on coverWear card and verify it navigates to coverWear list page
    Then Verify the breadCrumb of the cover wear listing page '${CustSiteName}' '${CustCorp}' '${ConveyorName}'
    And Verify user navigates to respective page on bread crumb click of cover wear '${CustSiteName}' '${CustCorp}'

    @Regression13 @CTCP-1387
    @dataFile:resources/data/TestData.xls
    @sheetName:Regression
    @key:CoverWear_BreadCrumb
    Scenario: Verify value displayed in cover wear card


        And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
        And Verify that the gauge meter with lowest belt cover % is visible in the card
        And Verify remaining life and duro meter value is displayed in the card

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


@Regression14 @CTCP-1396
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: Verify the functionality of column name


    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Click on the column names of the conveyor cover wear and verify the column names
    And Click on any column name in cover wear details page and verify only those data is displayed in the table


@Regression5 @CTCP-1398
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_DetailSorting
Scenario: Verify the functionality of sorting


    And Search for the conveyor '${ConveyorName}' in cover wear listing screen and navigate
    Then Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column and verify sorting should be in increasing order
    And Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column again and verify sorting should be in decreasing order

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

@Regression6 @CTCP-1452
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Report
Scenario: Verify data displayed in report for single coverWear


    Then Navigate to cover wear listing screen
    And Click on '${CoverWearName}' report download button
    And Select all fields '${FromDate}' '${ToDate}' in the popup and verify user is able to fill respective fields
    And Look for the date in generated report and verify if it is in the expected format '${CoverWearName}' and '${CustSiteName}' '${CorporateName}' and '${Contributor}' and '${FromDate}' '${ToDate}'

@Regression7 @CTCP-1449
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_ColumnReport
Scenario: ZDownload pop-up in case specific column is selected


    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Navigate to cover wear listing screen
    And Click on the column name and verify the column names
    And Select the column '${Corporate}' and verify only those columns are displayed in the table
    And Verify the download functionality in list screen for columnNames
