Feature: Regression of P1 Cord Inspect module

Background:
Launch the application through '/'

@Regression1 @CTCP-3512
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: Verify user is able to click on belt scan tiles card

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page

@Regression2 @CTCP-3514
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: verify user is able to enter data in general details page and move to next screen

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan general Info with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Verify create button is disabled

@Regression3 @CTCP-3519
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: Verify user able to select the reason for scan dropdown

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Verify the Reason to scan dropdown list

@Regression3 @CTCP-3527
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: Verify user is able to select file from backup file

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Verify the mandatory fields in belt scan Add general details screen
    And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Verify the mandatory fields in belt scan Add general details screen


@Regression2 @CTCP-3531
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: verify user is able to enter data in general details page and move to next screen

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan general Info with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Click on Next button and verify Add Scanning files tab is displayed
    And Click on previous button and verify user is on Add Scan details page
    And Click on previous button and verify user is on General Info details page


