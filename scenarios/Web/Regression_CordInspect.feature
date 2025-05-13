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
@key:Notification_AddBeltScan
Scenario: WVerify user is able to select file from backup file


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

@CTCP-3548
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Details
Scenario: Verify user able to delete the belt scan record

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then Wait for the list to load
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


@CTCP-3535 @CTCP-3537 @CTCP-3687
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify the user able to upload the scanning report on edit mode

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
   And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustSiteName}'
    Then And Navigate to cord inspect list screen and wait to load data
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${CustConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Click on the next button
    And Add Belt Scan Scanning files with the file '${File3}' and file '${File4}' and '${Note}'
    And Click on create button
    And Navigate to cord inspect list screen and wait to load data
    And Click on actions dropdown button and edit the '${CustSiteName}'
    And Verify belt scan record is on edit mode
    And Edit all Belt Scan General details with '${EditDateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' for '${FieldName1}' and '${File2}' for '${FieldName2}'
    And Edit all Belt Scan Add Scan details with '${BeltManufacturer}' '${TopCoverCompound}' '${NumberOfCords}' '${InstallationDate}' '${CpuLeft}' '${SensorWidth}' '${PhoneNumber}'
    And Click on the next button
    And Edit all Belt Scan Add Scanning files with the file '${File3}' for '${FieldName3}' and file '${File4}' for '${FieldName4}' and '${Note}'
    And Click save and Verify update message
    And Navigate to cord inspect list screen and wait to load data
    And Delete Conveyor from Conveyor list screen '${ConveyorName}'

@CTCP-3597
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario: Verify the user able to edit all the 3 steps for belt scan - Raise bug

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustSiteName}'
    Then And Navigate to cord inspect list screen and wait to load data
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${CustConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on actions dropdown button and edit the '${CustSiteName}'
    And Verify belt scan record is on edit mode
    And Edit all Belt Scan General details with '${EditDateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' for '${FieldName1}' and '${File2}' for '${FieldName2}'
    And Edit all Belt Scan Add Scan details with '${BeltManufacturer}' '${TopCoverCompound}' '${NumberOfCords}' '${InstallationDate}' '${CpuLeft}' '${SensorWidth}' '${PhoneNumber}'
    And Click on the next button
    And Add Belt Scan Scanning files with the file '${File3}' and file '${File4}' and '${EditNote}'
    And Click on the save button
    And Navigate to cord inspect list screen and wait to load data
    Then Search the '${ConveyorName}' and click on view icon
    And Verify the data for belt scan '${SiteName}' '${ConveyorName}' '${TopCoverCompound}' '${EditNote}'
#    And Verify search and delete '${ConveyorName}' functionality delete not

  @CTCP-3604
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:BeltScan_EditConveyor
  Scenario: Verify user is able to download the enabled report, belt info, raw capture file on listing screen

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to cord inspect list screen and wait to load data
    And Search for the record '${ConveyorName}' and verify item is present
    And Verify the Belt Scan List Download Functionality for '${BeltInfoFile}' '${File1}' '${File4}'

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
    And Click on actions dropdown button and edit the '${SiteName}'
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
    Then Search the '${SiteName}' and click on view icon
    And Verify belt scan tab highlight functionality
    And Click on cancel button
    And Click on add button and verify navigation to Add BeltScan page
    And Click on Add scanning files tab and verify highlight functionality

@CTCP-3600
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_EditConveyor
Scenario:Verify user is able to see the scanning files on disable mode when no scanning files were uploaded

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteName}' '${CustConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Enter the text '${CustSiteName}' to search
    And Verify the scanning report is in disable mode

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


@CTCP-3682
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload_User
Scenario: Verify user is able to add the belt scan record on the customer user

  Given User is at Login page
  When Login with '${CustomerUserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Click on Next button and verify Add Scan details tab is displayed
  And Verify all the data in add scan details screen is empty
  And Click on create button
  And Navigate to cord inspect list screen and wait to load data
  And Search for the record '${ConveyorName}' and verify item is present
  And Verify search and delete '${ConveyorName}' functionality

@CTCP-3683 @CTCP-3964
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload_User
Scenario: Verify user is able to add the belt scan record on the standard continental user

  Given User is at Login page
  When Login with '${StandardUserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Click on Next button and verify Add Scan details tab is displayed
  And Click on load back up data and verify the scanning toast message
  And Click on create button
  And Navigate to cord inspect list screen and wait to load data
  And Search for the record '${ConveyorName}' and verify item is present
  And Verify search and delete '${ConveyorName}' functionality

@CTCP-3591 @CTCP-3532
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload_User
Scenario: Verify user is able to add the belt scan by loading technical data

  Given User is at Login page
  When Login with '${StandardUserName}' and '${Password}'
  Then Navigate to Add Belt Scan Page and verify navigation
  And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
  And Click on Next button and verify Add Scan details tab is displayed
  And Click on load technical data and verify the data values '${TopCoverCompound}' '${BeltWidth}'
  And Click on create button
  And Navigate to cord inspect list screen and wait to load data
  And Search for the record '${ConveyorName}' and verify item is present
  And Click on Clear filter Icon
  And Verify select all checkbox functionality
  And Verify select all checkbox functionality
  And Verify search and delete '${ConveyorName}' functionality


@CTCP-3686
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload_User
Scenario: verify user is able to  get the cord protect symbol enabled when we upload correct bin files - raise

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    And Click on Next button and verify Add Scan details tab is displayed
    And Click on the next button
    And Add Belt Scan Scanning files with the file '${File2}' and file '${File4}' and '${Note}'
    And Click on create button
    And Navigate to cord inspect list screen and wait to load data
#    And Click on actions dropdown button and edit the '${SiteName}'
#    And Verify belt scan record is on edit mode
#    And Edit all Belt Scan Add Scan details with '${BeltManufacturer}' '${TopCoverCompound}' '${NumberOfCords}' '${InstallationDate}' '${CpuLeft}' '${SensorWidth}' '${PhoneNumber}'
#    And Click save and Verify update message
#    And Navigate to cord inspect list screen and wait to load data





@CTCP-3991
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload_User
Scenario: Verify all the file should be uploaded in the background when moved from step 1 - step 2

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Add Belt Scan Page and verify navigation
    And Add general details '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}'
    And Verify while uploading '${File1}' and '${File2}' next button is disabled





@CTCP-36011
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltScan_Upload
Scenario:Verify card count for different tile

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to site list screen
    And Verify the site count with respect to pagination
    And Navigate to conveyor list screen and wait to load data
    Then Verify the conveyor count with respect to pagination
#    And Navigate to inspection list screen and wait to load data
#    Then Verify the inspection count with respect to pagination
    And Navigate to cord inspect list screen and wait to load data
    Then Verify the belt Scan count with respect to pagination
    And Navigate to Belt Monitoring List screen
    Then Verify the monitoring device count with respect to pagination
    And Navigate to iot dashboard list screen and wait to load data
    Then Verify the iot dashboard count with respect to pagination
    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    Then Verify the heavy equipment count with respect to pagination
    And Navigate to minuteman list screen and wait to load data
    Then Verify the minuteman count with respect to pagination



