Feature: Regression for Login feature

Background:
  Launch the application through '/'

@CTCP-3513
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user is able to click on Add(+) button

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  Then Click on Belt Scan card and verify it navigates to BeltScan listing page
  And Click on add button and verify navigation to Add BeltScan page

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
Scenario: Verify user able to delete the belt scan record

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
@key:BeltScan_DeleteSite
Scenario: Verify user not able to see the belt scan record when added site is deleted

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Create a Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${Manager}' and '${Territory}'
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustSiteName}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Navigate to site list screen
    And Delete Customer site with '${CustSiteName}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Verify '${CustSiteName}' is not present in the list

@CTCP-3552
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_DeleteConveyor
Scenario: Verify user not able to see the belt scan record when added conveyor is deleted

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustSiteName}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Delete Conveyor from Conveyor list screen '${ConveyorName}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Verify '${ConveyorName}' is not present in the list


@CTCP-3535 @CTCP-3537
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify the user able to upload the scanning report on edit mode

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${CustConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on actions dropdown button and edit the '${CustSiteName}'
    And Verify belt scan record is on edit mode
    And Edit all Belt Scan General details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' for '${FieldName1}' and '${File2}' for '${FieldName2}'
    And Edit all Belt Scan Add Scan details with '${BeltManufacturer}' '${TopCoverCompound}' '${NumberOfCords}' '${InstallationDate}' '${CpuLeft}' '${SensorWidth}' '${PhoneNumber}'
    And Click on the next button
    And Edit all Belt Scan Add Scanning files with the file '${File3}' for '${FieldName3}' and file '${File4}' for '${FieldName4}' and '${Note}'
    And Click save and Verify update message

@CTCP-3988
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify previous step number is highlighted when user is inside the particular step - Add mode

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Verify belt scan tab highlight functionality
    And Click on cancel button
    And Click on add button and verify navigation to Add BeltScan page
    And Click on Add scanning files tab and verify highlight functionality

@CTCP-3992 @CTCP-3560
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify previous step number is highlighted when user is inside the particular step - Edit mode

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on actions dropdown button and edit the '${CustSiteName}'
    And Verify belt scan tab highlight functionality
    And Click on cancel button
    And Click on add button and verify navigation to Add BeltScan page
    And Click on Add scanning files tab and verify highlight functionality

@CTCP-3993
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify previous step number is highlighted when user is inside the particular step - View mode

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    Then Search the '${CustSiteName}' and click on view icon
    And Verify belt scan tab highlight functionality
    And Click on cancel button
    And Click on add button and verify navigation to Add BeltScan page
    And Click on Add scanning files tab and verify highlight functionality

@CTCP-4055
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario:Verify only single file uploaded is allowed for Raw capture, Backup, analysis and scanning file

  Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on actions dropdown button and edit the '${CustSiteName}'
    And Click on the next button
    And Click on the next button
    And ReUpload multiple files '${File1}' '${File2}' for field '${FieldName3}' and verify user is unable to upload simultaneously
    And Upload the file '${File1}'
    And ReUpload multiple files '${File4}' '${File4}' for field '${FieldName4}' and verify user is unable to upload simultaneously
    Then Navigate to Add Belt Scan Page and verify navigation
    And Upload multiple files '${File1}' '${File2}' and verify user is unable to upload simultaneously
    And Upload the file '${File1}'
    And Upload multiple files '${File1}' '${File2}' and verify user is unable to upload simultaneously
    And Click on cancel button
    And Perform upload analysis through action button for '${CustSiteName}'
    And Upload multiple files '${File1}' '${File2}' and verify user is unable to upload simultaneously
    And Upload the file '${File1}'
    And Upload multiple files '${File4}' '${File4}' and verify user is unable to upload simultaneously

@CTCP-3561 @CTCP-3562 @CTCP-3563 @CTCP-3564
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario:Verify user is able to click the upload analysis result from dropdown

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Perform upload analysis through action button for '${CustSiteName}'
    And Upload the file '${File3}'
    And Upload the file '${File4}'
    And Click on upload button

@CTCP-3600
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario:Verify user is able to see the scanning files on disable mode when no scanning files were uploaded

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Search for the record '${CustSiteName}'
    And Verify the scanning report is in disable mode