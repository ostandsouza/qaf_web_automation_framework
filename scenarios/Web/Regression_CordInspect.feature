Feature: Regression of P1 Cord Inspect module

Background:
Launch the application through '/'

@Regression1 @CTCP-3512
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: ZVerify user is able to click on belt scan tiles card

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page

@Regression2 @CTCP-3514
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: Yverify user is able to enter data in general details page and move to next screen


    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan general Info with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Verify create button is disabled

@Regression3 @CTCP-3519
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: XVerify user able to select the reason for scan dropdown


    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Verify the Reason to scan dropdown list

@Regression3 @CTCP-3527
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: WVerify user is able to select file from backup file


    Then Navigate to Add Belt Scan Page and verify navigation
    And Verify the mandatory fields in belt scan Add general details screen
    And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Verify the mandatory fields in belt scan Add general details screen


@Regression2 @CTCP-3531
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: Vverify user is able to enter data in general details page and move to next screen


    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan general Info with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Click on Next button and verify Add Scanning files tab is displayed
    And Click on previous button and verify user is on Add Scan details page
    And Click on previous button and verify user is on General Info details page

@Regression5 @CTCP-3555
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_ColumnSort
Scenario: Verify sort filter and clear functionality for belt scan listing page


    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Belt Scan List screen and wait
    And Click on column header and verify sorting functionality
    And Click on clear filter button and verify filter is removed
    And Click on each column header and verify filter functionality

@Regression6 @CTCP-3556
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_ColumnSort
Scenario: Verify column selection search and refresh functionality


    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Belt Scan List screen and wait
    And Look for the searchBar in the table and verify search icon and search placeholder is visible
    And Enter the text '${DeviceName}' to search
    And Verify the matching result is displayed or No record found message should display
    And Verify column selection filter is visible
    And Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible
    And Verify user is able to see the column names selected by default
    And Enter the columnName '${ColumnName}' in searchBar and verify all columnName with search text is displayed
    And Select the checkbox of searched column and verify only selected column '${ColumnName}' is displayed in the table and column filter text box







