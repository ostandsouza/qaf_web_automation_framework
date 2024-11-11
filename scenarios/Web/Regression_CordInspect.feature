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

@CTCP-3513
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user is able to click on Add(+) button

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  Then Click on Belt Scan card and verify it navigates to BeltScan listing page
  And Click on add button and verify navigation to Add BeltScan page

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

@CTCP-3516
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user should get an error message when mandatory Fields are empty in general details page

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Verify create button is disabled
  And Verify error message functionality when belt scan mandatory fields are filled with empty values '${SiteName}' '${ConveyorName}'
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Verify create button is enabled

@Regression3 @CTCP-3519
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AddBeltScan
Scenario: XVerify user able to select the reason for scan dropdown


    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Verify the Reason to scan dropdown list

@CTCP-3525
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user is able to select all values on general details screen

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Click on Next button and verify Add Scan details tab is displayed

@Regression3 @CTCP-3527
@dataFile:resources/data/TestData.xls
@sheetName:Regression

    Then Navigate to Add Belt Scan Page and verify navigation
    And Verify the mandatory fields in belt scan Add general details screen
    And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Verify the mandatory fields in belt scan Add general details screen

@CTCP-3530
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user see the message in Add scanning files in add mode

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Click on Next button and verify Add Scan details tab is displayed
  And Click on Next button and verify Add Scanning files tab is displayed
  And Verify scanning message report message on Add Scanning files page
  And Verify user is able to add '${Note}' on note text box


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

@CTCP-3534
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify the cancel button on belt scan

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Click on cancel button
    And Verify user is in Belt Scan list page

@CTCP-3548
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Verify the pagination and tile count for belt scan
    And Validate the Belt Scan count before deletion
    And Verify search and delete '${SiteName}' functionality
    And Validate the Belt Scan count after deletion
    And Verify select all checkbox functionality
    And Click on actions dropdown button and verify delete option is visible

@CTCP-3551
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${Manager}' and '${Territory}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Delete Customer site with '${CustSiteName}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Verify '${SiteName}' is not present in the list