Feature: Regression High Priority test cases for Master User

Background:
Launch the application through '/'

@RegressionHp1
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Create
Scenario: ZVerify User Add a conveyor from Home page and verify the conveyor is added and count is incremented.

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   wait for conveyors to load
    And   Extract the main card count for '${Module}'
    And   Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${SiteName}'
    And   wait for conveyors to load
    And   Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'

@RegressionHp2
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Create
Scenario: YVerify User Edit a conveyor from Home page and verify the conveyor is Edited and count remains same.

    And   wait for conveyors to load
    And   Extract the main card count for '${Module}'
    When  Edit Conveyor '${ConveyorName}' from conveyor list screen to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${SiteName}'
    And   Click on Clear filter Icon
    And   wait for conveyors to load
    And   Verify the main card count after operation '${Edit}' for '${Module}' with count '${EditCount}'

@RegressionHp3
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Create
Scenario: XVerify User Delete Multiple conveyors and conveyor is deleted from the list and count is updated

    Then Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${SiteName}'
    Then Create a conveyor with '${ConveyorName2}' and '${DistShopName}' and '${SiteName}'
    Then Create a conveyor with '${ConveyorName3}' and '${DistShopName}' and '${SiteName}'
    Then Create a conveyor with '${ConveyorName4}' and '${DistShopName}' and '${SiteName}'
    When Navigate to conveyor list screen
    And  wait for conveyors to load
    And  Extract the main card count for '${Module}'
    And  Search for the record '${ConveyorName}' and verify item is present
    And  Click multiSelect Checkbox and verify delete functionality
    And  Click on Clear filter Icon
    And  wait for conveyors to load
    And  Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCount}'

@RegressionHp4
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Create
Scenario: Verify User add conveyor from site Level adding all conveyor details and check conveyor is added in site level & home level and count updated in site level & home level

    And wait for conveyors to load
    And Extract the main card count for '${Module}'
    Then Navigate to site details for site '${SiteName}'
    And Wait for the list to load
    And Extract the card count in detail page for '${Module}'
    And Click on The Add Icon
    And Enter the conveyor fields with '${ConveyorName}' and '${DistShopName}' and '${SiteName}'
    And Enter the conveyor lite page fields with '${BeltWidth}' '${MaterialName}' '${DriveWrapAngle}' '${SurchargeAngle}' '${IdlerOffSetType}' '${DriveDetails}' '${TakeUpDetails}'
    And Enter the installed belt page fields with '${BeltConfig}' '${BeltConst}' '${TopCompound}' '${CarCass}' '${BeltWidth}' '${Splice}' '${InstallDate}'
    And Enter the material page fields with '${BeltWidth}' '${GranularSize}' '${Aggresivity}' '${LoadingFrequency}' '${FeedingConditions}'
    And Enter the conveyor page fields with '${BeltWidth}' '${Ratio}' '${Stage}' '${TakeUpDetails}' '${BeltTurnOver}'
    And Enter the wear life page fields with '${BeltWidth}'
    And Enter the idlers page fields with '${BeltWidth}' '${IdlerOffSetType}'
    And Enter the pulleys page fields with '${DrivePulley}' '${BrakeDevice}' '${BeltWidth}' '${AngleWrap}' '${LaggingType}'
    And Enter the transitions page fields with '${BeltWidth}'
    And Enter the remarks page fields with '${File}' '${Remark}'
    And Click on create button
    And Search for the record '${ConveyorName}' and verify item is present
    And Click on Clear filter Icon
    And Verify the card count in detail screen after operation '${Addition}' for '${Module}' with count '${AddCount}'
    And wait for conveyors to load
    And Search for the record '${ConveyorName}' and verify item is present
    And Click on Clear filter Icon
    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'

@RegressionHp5
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Edit
Scenario: Verify user edit the above conveyor for few fields from the conveyor details page and validate fields are updated.

    And wait for conveyors to load
    And Click on actions dropdown button and edit the '${ConveyorName}'
    And Edit the technical tab data for the fields '${EditConveyorName}' '${BeltWidth}' '${BeltConfig}' '${DrivePulley}' '${File}' '${Remarks}'
    And wait for conveyors to load
    And Navigate to conveyor details screen for conveyor '${EditConveyorName}'
    And Verify the technical tab data after edit for the fields '${ConveyorName}' '${BeltWidth}' '${BeltConfig}' '${DrivePulley}' '${Remarks}'

@RegressionHp6
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Edit
Scenario: Verify unit conversion functionality from metric to imperial and check values converted.(Belt width, top cover and bottom cover thickness, length)

    And  Add data value in header as imperial
    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And  Verify the technical tab data are in imperial value for fields '${BeltWidthImp}' '${TopCoverThicknessImp}' '${BeltRatingImp}' '${LengthImp}'

@RegressionHp7
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Edit
Scenario: Verify unit conversion functionality from imperial to  metric and check values converted.(Belt width, top cover and bottom cover thickness, length)

    And  wait for conveyors to load
    And  Add data value in header as imperial
    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And  Edit Conveyor belt width value '${BeltWidthImperial}'
    And  Add data value in header as metric
    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And  Verify the technical tab data are in metric value for fields '${BeltWidthMetric}' '${TopCoverThicknessMetric}'
#    And Click on profile and select logout button

@RegressionHp8
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Layout
Scenario: Verify user prefernce functionality

    Then  verify user '${UserName}' is able to add new layout for '${Corporates}' '${BeltWidth}' '${Rating}' '${Length}' with '${Layout_Name}'
    And   Click on profile and select logout button
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to conveyor list screen
    Then  Verify user is able to see newly added layout
    And   verify user is able to delete layout for '${Layout_Name}'

@RegressionHp9
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Create
Scenario: Verify correct pagination and card count displayed on Corporate(Distributor and Customer), Shop and Site level.

    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And  Click on the conveyor card
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And  Click on the conveyor card
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And  Search for the record '${DistShopName}' and verify item is present
    And  Click on view icon
    And  Click on the conveyor card
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to site details for site '${SiteName}'
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'

@RegressionHp10
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:Conveyor_Edit
Scenario: AVerify export pdf and csv file functionality and vaildate correct values are displayed in the exported files.

    Then Create a conveyor with '${ExportConveyorName}' and '${DistShopName}' and '${SiteName}'
    Then Create a conveyor with '${ExportConveyorName1}' and '${DistShopName}' and '${SiteName}'
    Then Create a conveyor with '${ExportConveyorName2}' and '${DistShopName}' and '${SiteName}'
    And  Export PDF and CSV data for '${ExportConveyorName1}' and '${ExportConveyorName1}' and '${ExportConveyorName2}' and '${ExportConveyorName2}'
    And  And wait for conveyors to load
    And  Search for the record '${ExportConveyorName}' and verify item is present
    And  Click multiSelect Checkbox and verify delete functionality

@RegressionHp11
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify user add Monitoring device(MD) by entering all the details from home level and verify the Monitoring device is added and count is incremented

    Then Navigate to Belt Monitoring List screen
    And  Extract the main card count for '${Module}'
    And  Navigate to Add monitoring device screen
    And  Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And  Click on previous button  and verify navigation to Add Location page
    And  Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And  Click on next button and verify navigation to Add Location page
    And  Verify the add location page functionality for add monitoring device page with '${AssociatedDistName}' '${SiteName}' '${Latitude}' '${Longitude}'
    And  Click on save button and verify device '${DeviceName}' is created successfully
    And  Search for the record '${DeviceName}' and verify item is present
    And  Click on Clear filter Icon
    And  Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'

@RegressionHp12
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify User edit the added MD from conveyor level and verify MD value is updated in view mode and count remains same

    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on the Belt Monitoring card
    And  Wait for the list to load
    And  Extract the main card count for '${Module}'
    And  Click on actions dropdown button and edit the '${DeviceName}'
    And  Edit the device name to '${EditDeviceName}' for monitoring device
    And  Verify the main card count after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Search and verify the '${EditDeviceName}' is present
    And  Click on view icon
    And  Verify the device name '${EditDeviceName}' in view mode

@RegressionHp13
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify the card count and pagination count in Corporate(Distributor and Customer), Shop, Site and level.

    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on the Belt Monitoring card
    And  Wait for the list to load
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on the Belt Monitoring card
    And  Wait for the list to load
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And  Search for the record '${DistShopName}' and verify item is present
    And  Click on view icon
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on the Belt Monitoring card
    And  Wait for the list to load
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'
    Then Navigate to site details for site '${SiteName}'
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on carousel right icon
    And  Click on the Belt Monitoring card
    And  Wait for the list to load
    And  Extract the card count in detail page for '${Module}'
    And  Verify the card count in detail screen after operation '${Edit}' for '${Module}' with count '${EditCount}'

@RegressionHp14
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify user delete single MD from Home level and check MD is deleted from the list and count is updated.

    Then Navigate to Belt Monitoring List screen
    And Wait for the list to load
    And Extract the main card count for '${Module}'
    And Search for the record '${EditDeviceName}' and verify item is present
    And Click multiSelect Checkbox and verify delete functionality
    And Click on Clear filter Icon
    And Wait for the list to load
    And Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCount}'

@RegressionHp15
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_Master
@key:MonitoringDevice_Create
Scenario: Verify user Add MD from Conveyor level with status as running verify the count(main and flag count should update), edit the MD change status to prior to commissioning validate the count (only flag count will update here) and then delete multiple MD(one with running and another with not in operation) from the conveyor level and validate the card count and the flag count

    Then Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName2}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the status for the monitoring device as '${RunningStatus}'
    And Click on save button and verify device '${DeviceName2}' is created successfully
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName3}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the status for the monitoring device as '${PriorStatus}'
    And Click on save button and verify device '${DeviceName3}' is created successfully
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName4}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the status for the monitoring device as '${NotOpStatus}'
    And Click on save button and verify device '${DeviceName4}' is created successfully
    And Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Wait for the list to load
    And Extract the main card count for '${Module}'
    And Extract the status count for '${Module}' for '${RunningStatusValue}' in '${StatusStored}'
    And Navigate to Add monitoring device screen
    And Add the device details with field '${DeviceNameStatus}' '${DeviceType}' '${RunningStatus}'
    And Click on next button and verify navigation to Add Location page
    And Click on create button
    And Wait for the list to load
    And Search for the record '${DeviceNameStatus}' and verify item is present
    And Click on Clear filter Icon
    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
    And Verify the status card count after operation '${Addition}' for '${Module}' for '${RunningStatusValue}' with count '${AddCount}' in '${StatusStored}'
    And Extract the main card count for '${Module}'
    And Extract the status count for '${Module}' for '${PriorStatusValue}' in '${StatusStored}'
    And Click on actions dropdown button and edit the '${DeviceNameStatus}'
    And Add the status for the monitoring device as '${PriorStatus}'
    And Click on the save button
    And Wait for the list to load
    And Verify the main card count after operation '${Edit}' for '${Module}' with count '${EditCount}'
    And Verify the status card count after operation '${Addition}' for '${Module}' for '${PriorStatusValue}' with count '${AddCount}' in '${StatusStored}'
    And Navigate to Add monitoring device screen
    And Add the device details with field '${DeviceName}' '${DeviceType}' '${RunningStatus}'
    And Click on next button and verify navigation to Add Location page
    And Click on create button
    And Navigate to Add monitoring device screen
    And Add the device details with field '${DeviceNameStatus}' '${DeviceType}' '${NotOpStatus}'
    And Click on next button and verify navigation to Add Location page
    And Click on create button
    And Wait for the list to load
    And Extract the main card count for '${Module}'
    And Extract the status count for '${Module}' for '${PriorStatusValue}' in '${StatusStored}'
    And Extract the status count for '${Module}' for '${NotOpStatusValue}' in '${StatusStored2}'
    And Search for the record '${DeviceNameStatus}' and verify item is present
    And Click multiSelect Checkbox and verify delete functionality
    And Click on Clear filter Icon
    And Wait for the list to load
    And Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCount2}'
    And Wait for the list to load
    And Verify the status card count after operation '${Deletion}' for '${Module}' for '${PriorStatusValue}' with count '${DeleteCount}' in '${StatusStored}'
    And Verify the status card count after operation '${Deletion}' for '${Module}' for '${NotOpStatusValue}' with count '${DeleteCount}' in '${StatusStored2}'

@RegressionHp17
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Export
Scenario: Verify Export pdf and CSV functionality for MD and validate the values (Export functionality should be checked by applying filters, without any filters select few record and without selecting the records)

    Then Navigate to Belt Monitoring List screen
    And Add filter for header with '${Corporate}'
    And Search for the '${DeviceName}' monitoring Device
    And Click the checkbox in the row table
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export Pdf and verify pdf contents for Monitoring device with '${Device}' '${Site}' '${Corporate}'
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export csv and verify csv contents for default header Monitoring device with default '${Device}' '${DeviceType}' '${SerialNumber}' '${Site}' '${Conveyor}' '${Carcass}' '${Territory}' '${Location}' '${Status}' '${LastService}' '${Corporate}'
    And Click on Clear filter Icon
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export Pdf and verify pdf contents for default header Monitoring device with default '${Device}' '${DeviceType}' '${SerialNumber}' '${Site}' '${Conveyor}' '${Carcass}' '${Territory}' '${Location}' '${Status}' '${LastService}' '${BeltSaves}'
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export csv and verify csv contents for default header Monitoring device with default '${Device}' '${DeviceType}' '${SerialNumber}' '${Site}' '${Conveyor}' '${Carcass}' '${Territory}' '${Location}' '${Status}' '${LastService}' '${BeltSaves}'
    And Search for the '${DeviceName}' monitoring Device
    And Click the checkbox in the row table
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export Pdf and verify pdf contents for default header Monitoring device with default '${Device}' '${DeviceType}' '${SerialNumber}' '${Site}' '${Conveyor}' '${Carcass}' '${Territory}' '${Location}' '${Status}' '${LastService}' '${BeltSaves}'
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export csv and verify csv contents for default header Monitoring device with default '${Device}' '${DeviceType}' '${SerialNumber}' '${Site}' '${Conveyor}' '${Carcass}' '${Territory}' '${Location}' '${Status}' '${LastService}' '${BeltSaves}'

@RegressionHp19
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify the maps functionality in the home page and check the count updated after adding device from map view

    Then Navigate to Belt Monitoring List screen
    And Extract the main card count for '${Module}'
    And Verify monitoring device is in map view
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And Click on next button and verify navigation to Add Location page
    And Verify the add location page functionality for add monitoring device page with '${AssociatedDistName}' '${SiteName}' '${Latitude}' '${Longitude}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Verify monitoring device is in map view
    And Validate monitoring device '${DeviceName}' is present in map view
    Then Navigate and validate navigation to list view for monitoring device
    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
    And Extract the main card count for '${Module}'
    And Click on actions dropdown button and edit the '${DeviceName}'
    And Edit the device name to '${EditDeviceName2}' for monitoring device
    Then Search and verify the '${EditDeviceName2}' is present
    And Verify monitoring device is in map view
    And Validate monitoring device '${EditDeviceName2}' is present in map view
    Then Navigate and validate navigation to list view for monitoring device
    And Verify the main card count after operation '${Edit}' for '${Module}' with count '${EditCount}'

@RegressionHp20
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify the Monitoring device toggle functionality is displayed in home level,site level and conveyor level,corporate level

    Then Navigate to Belt Monitoring List screen
    And Validate map and list icon in monitoring device list page
    And Verify monitoring device is in list view
    And Verify monitoring device is in map view
    Then Navigate and validate navigation to list view for monitoring device
    And Navigate to site details for site '${SiteName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Validate map and list icon are not visible
    And Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Validate map and list icon are not visible
    And Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Validate map and list icon are not visible

@RegressionHp22
@dataFile:resources/data/TestDataHp.xls
@sheetName:Regression_MarketManager
@key:MonitoringDevice_Create
Scenario: Verify user Delete the MD from Customer corporate level and validate the count in site, conveyor and home level

    Then Navigate to Belt Monitoring List screen
    And Extract the main card count for '${Module}'
    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And  Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Wait for the list to load
    And Extract the card count in detail page for '${Module}'
    And Search for the record '${DeviceName}' and verify item is present
    And Click multiSelect Checkbox and verify delete functionality
    And Click on Clear filter Icon
    And Wait for the list to load
    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
    Then Navigate to site details for site '${SiteName}'
    And  Click on carousel right icon
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Wait for the list to load
    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And  Click on carousel right icon
    And  Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Wait for the list to load
    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
    Then Navigate to Belt Monitoring List screen
    And Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'


    @RegressionHp39
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: ZVerify user add belt scan by loading the back-up data and CCM user receive notification of adding belt scan and CCM should upload the analysis and scanning report in the 3rd step by editing the belt scan and view the belt scan and check count updated in home level

        And Navigate to cord inspect list screen and wait to load data
        And Extract the main card count for '${Module}'
        Then Navigate to Add Belt Scan Page and verify navigation
        And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
        And Click on Next button and verify Add Scan details tab is displayed
        And Click on load back up data and verify the scanning toast message
        And Click on create button
        And Navigate to cord inspect list screen and wait to load data
        And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
        And Search for the record '${ConveyorName}' and verify item is present
        And  Click on profile and select logout button
        When Login with '${CCMUserName}' and '${Password}'
        Then Verify user is getting belt scan notification for '${ConveyorName}' with '${SiteName}' by '${User}'
        And Navigate to cord inspect list screen and wait to load data
        And Click on actions dropdown button and edit the '${ConveyorName}'
        And Verify belt scan record is on edit mode
        And Click on the next button
        And Click on the next button
        And Add Belt Scan Scanning files with the file '${File1}' and file '${File3}' and '${Note}'
        And Click on the save button
        And Navigate to cord inspect list screen and wait to load data
        Then Search the '${ConveyorName}' and click on view icon
        And Verify the data for belt scan '${SiteName}' '${ConveyorName}' '${TopCoverCompound}' '${Note}'
        And Navigate to cord inspect list screen and wait to load data
        And Verify search and delete '${ConveyorName}' functionality

    @RegressionHp40
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: YVerify user add belt scan from site level by loading the conveyor technical data and CCM user should upload the analysis and scanning report from Action button and check count is updated in site level

        Then Navigate to site details for site '${SiteName}'
        And  Click on carousel right icon
        And Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Extract the card count in detail page for '${Module}'
        And Click on The Add Icon
        And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
        And Click on Next button and verify Add Scan details tab is displayed
        And Click on load technical data and verify the data values '${TopCompound}' '${BeltWidthTech}'
        And Click on create button
        Then Navigate to site details for site '${SiteName}'
        And  Click on carousel right icon
        And Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Verify the card count in detail screen after operation '${Addition}' for '${Module}' with count '${AddCount}'
        And  Click on profile and select logout button
        When Login with '${CCMUserName}' and '${Password}'
        Then Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Perform upload analysis through action button for '${SiteName}'
        And Upload the file '${File1}'
        And Upload the file '${File3}'
        And Click on upload button
        And Wait for the toast message to display
        And Verify select all checkbox functionality
        And Click on Clear filter Icon
        And Verify search and delete '${SiteName}' functionality

    @RegressionHp41
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: XVerify user create belt scan from conveyor level in the first step and CCM user should load the back up data and upload the analysis and scanning report from action button check card count updated in conveyor level

        And Navigate to conveyor details screen for conveyor '${ConveyorName}'
        And Click on carousel right icon
        And Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Extract the card count in detail page for '${Module}'
        And Click on The Add Icon
        And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
        And Click on Next button and verify Add Scan details tab is displayed
        And Click on Next button and verify Add Scanning files tab is displayed
        And Verify scanning message report message on Add Scanning files page
        And Verify user is able to add '${Note}' on note text box
        And Click on create button
        And Navigate to conveyor details screen for conveyor '${ConveyorName}'
        And Click on carousel right icon
        And Click on carousel right icon
        And Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Verify the card count in detail screen after operation '${Addition}' for '${Module}' with count '${AddCount}'
        And  Click on profile and select logout button
        When Login with '${CCMUserName}' and '${Password}'
        Then Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Click on actions dropdown button and edit the '${ConveyorName}'
        And Verify belt scan record is on edit mode
        And Click on the next button
        And Click on load back up data and verify the scanning toast message
        And Click on the save button
        Then Wait for the toast message to display
        And Navigate to cord inspect list screen and wait to load data
        And Click on Clear filter Icon
        And Perform upload analysis through action button for '${SiteName}'
        And Upload the file '${File1}'
        And Upload the file '${File3}'
        And Click on upload button
        Then Wait for the list to load

    @RegressionHp42
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Export
    Scenario: WVerify the Export functionality for belt scan (Export functionality should be checked by applying filters, without any filters select few record and without selecting the records)

        And Navigate to cord inspect list screen and wait to load data
        And Add column filter for header with '${Corporate}' for belt scan
        And Search for the record '${ExConveyorName}' and verify item is present
        And Click the checkbox in the row table
        And Click on actions dropdown button
        And Click on export csv and verify csv contents for default header belt scan with default '${DateOfScan}' '${DeviceType}' '${Site}' '${Conveyor}' '${Territory}' '${Corporate}' '${BeltInfoScan}' '${RawCaptureFile}' '${ScanningReport}'
        And Remove column filter for header with '${Corporate}'
        And Verify select all checkbox functionality
        And Click on Clear filter Icon
        And Click on actions dropdown button
        And Click on export csv and verify csv contents for default header belt scan with default '${DateOfScan}' '${DeviceType}' '${Site}' '${Conveyor}' '${Territory}' '${Ccm}' '${BeltInfoScan}' '${RawCaptureFile}' '${ScanningReport}'
        And Search for the record '${ExConveyorName}' and verify item is present
        And Click the checkbox in the row table
        And Click on actions dropdown button
        And Click on export csv and verify csv contents for default header belt scan with default '${DateOfScan}' '${DeviceType}' '${Site}' '${Conveyor}' '${Territory}' '${Ccm}' '${BeltInfoScan}' '${RawCaptureFile}' '${ScanningReport}'

    @RegressionHp43
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: Verify user view the belt scan that was added and should be able download the back up, raw capture, analysis and scanning report in the view mode

        And Navigate to cord inspect list screen and wait to load data
        Then Search the '${ConveyorName}' and click on view icon
        And Verify belt scan record is on view mode
        And Click on download button for '${RawCaptureFile}' and verify the functionality with '${File1}' for belt scan
        And Click on download button for '${BackUpFile}' and verify the functionality with '${File2}' for belt scan
        And Click on the next button
        And Click on the next button
        And Click on download button for '${AnalysisFile}' and verify the functionality with '${File1}' for belt scan
        And Click on download button for '${ScanningReportFile}' and verify the functionality with '${File3}' for belt scan

    @RegressionHp44
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Export
    Scenario: UVerify the cord inspect IOT icon is enabled and on click it will take you to cord inspect page and verify all the page navigation from floating menu with bread crumbs

        And Navigate to cord inspect list screen and wait to load data
        And Search for the record '${ConveyorName}' and verify item is present
        And Verify Cord Inspect Icon is enabled
        And Verify navigation to the Cord Inspect page
        And Verify the cord protect details page
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on the main page and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on the floating menu downward arrow
        And Click on menu item '${SpliceThumbnails}' and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on menu item '${SpliceTable}' and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on menu item '${MonitoringThresholds}' and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on the floating menu downward arrow
        And Click on menu item '${DamageOverview}' and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on menu item '${DamageTable}' and verify navigation for floating menu
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on the floating menu downward arrow
        And Click on menu item '${SegmentCondition}' and verify navigation for floating menu with breadcrumb '${SegmentConditionCrumb}'
        And Click on floating menu icon and verify user can get list of links for Cord Inspect
        And Click on menu item '${SegmentTable}' and verify navigation for floating menu with breadcrumb '${SegmentTableCrumb}'


    @RegressionHp45
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: TVerify user edit the added belt scan by changing the values in step1, delete the added raw capture and back up file and then add new bin file for raw capture and back up in step1 and edit values in step2 and save. Validate the edited values are updated

        And Navigate to cord inspect list screen and wait to load data
        And Click on actions dropdown button and edit the '${ConveyorName}'
        And Verify belt scan record is on edit mode
        And Edit all Belt Scan General details with '${EditDateOfScan}' '${DeviceType}' '${ReasonForScan}' '${EditSiteName}' '${EditConveyorName}' '${NotifyCCM}' '${File4}' for '${RawCaptureFile}' and '${File5}' for '${BackUpFile}'
        And Edit all Belt Scan Add Scan details with '${BeltManufacturer}' '${TopCompound}' '${NumberOfCords}' '${InstallationDate}' '${CpuLeft}' '${SensorWidth}' '${PhoneNumber}'
        And Click save and Verify update message
        And Navigate to cord inspect list screen and wait to load data
        Then Search the '${EditConveyorName}' and click on view icon
        And Verify the data for belt scan '${EditSiteName}' '${EditConveyorName}' '${TopCompound}' '${Note}'
#        And Navigate to cord inspect list screen and wait to load data
#        And Verify search and delete '${EditConveyorName}' functionality



    @RegressionHp47
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:BeltScan_Create
    Scenario: SVerify user delete the multiple belt scan,check belt scan is deleted from the listing screen and validate the card and pagination count is updated in corporate level, shop level, site level, conveyor level and home level

        And Navigate to cord inspect list screen and wait to load data
        And Click on The Add Icon
        And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
        And Click on create button
        And Click on The Add Icon
        And Add the Mandatory fields in the Belt Scan with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${SiteName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
        And Click on create button
        And Wait for the list to load
        And Extract the main card count for '${Module}'
        Then Navigate to Corporate details screen for corporate '${CustCorpName}'
        And  Click on carousel right icon
        And Click on Belt Scan card and verify it navigates to BeltScan listing page
        And Extract the card count in detail page for '${Module}'
        And Search for the record '${ConveyorName}' and verify item is present
        And Click multiSelect Checkbox and verify delete functionality
        And Click on Clear filter Icon
        And Wait for the list to load
#    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
#    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
#    And Search for the record '${DistShopName}' and verify item is present
#    And Click on view icon
#    And  Click on carousel right icon
#    And Click on Belt Scan card and verify it navigates to BeltScan listing page
#    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
#    Then Navigate to site details for site '${SiteName}'
#    And  Click on carousel right icon
#    And Click on carousel right icon
#    And Click on Belt Scan card and verify it navigates to BeltScan listing page
#    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
#    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
#    And  Click on carousel right icon
#    And  Click on carousel right icon
#    And Click on Belt Scan card and verify it navigates to BeltScan listing page
#    And Verify the card count in detail screen after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'
#    And Navigate to cord inspect list screen and wait to load data
#    And Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCountMul}'

    @RegressionHp52
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario: ZVerify user is able to navigate to cover wear list from home page

        Then Verify user is on the home page of the application
        And Click on coverWear card and verify it navigates to coverWear list page
        And Verify the breadCrumb of coverWear page

    @RegressionHp53
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario: YVerify search functionality is working as expected

        And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${SiteName}'
        And Navigate to cover wear listing screen
        Then Wait for the list to load
        Then Add Cover Wear for conveyor '${ConveyorName}' and site '${SiteName}' with data '${FullName}' '${AddPosition}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
        And Navigate to cover wear listing screen
        Then Look for the searchBar in the table and verify search icon and search placeholder is visible
        When Enter the text '${ConveyorName}' to search
        And Verify the matching result is displayed or No record found message should display

    @RegressionHp54
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario: XVerify action button Edit functionality is working as expected

        And Click on coverWear card and verify it navigates to coverWear list page
        Then Wait for the list to load
        And Click on actions dropdown button and edit the '${ConveyorName}'


    @RegressionHp55
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario:Verify user is able to delete cover wear measurement

        And Navigate to coverWear list screen and wait for data load
        And Navigation to Cover Wear Details Screen for conveyor '${ConveyorName}'
        Then Scroll the page down
        And Verify search and delete '${PositionName}' functionality
        And Verify Delete Cover wear measurement position '${PositionName}'

    @RegressionHp57
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario:UVerify user is able to delete entire cover wear record

        And Delete Cover wear measurement for conveyor '${ConveyorName}'
        Then Wait for the list to load
        And Verify Delete Cover wear measurement for conveyor '${ConveyorName}'
        And wait for conveyors to load
        And Verify search and delete '${ConveyorName}' functionality


    @RegressionHp58
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario:TVerify user is able to delete entire cover wear record

        And Create a conveyor with '${CoverWearConveyor}' and '${DistShopName}' and '${SiteName}'
        And Navigate to coverWear list screen and wait for data load
        Then Add Cover Wear for conveyor '${CoverWearConveyor}' and site '${SiteName}' with data '${FullName}' '${AddPosition}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
        And wait for conveyors to load
        And Verify search and delete '${CoverWearConveyor}' functionality
        And Navigate to coverWear list screen and wait for data load
        When Enter the text '${CoverWearConveyor}' to search
        And Verify the matching result is displayed or No record found message should display


    @RegressionHp59
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_Tech
    Scenario: SVerify added conveyor technical data should reflected on cover wear specification screen

        Then Go to Add Cover Wear for conveyor '${ConveyorName}' and site '${SiteName}' with data '${AddPosition}'
        And Click on the edit button
        And Verify the technical data is loaded for the coverWear '${ConveyorName}' with data '${BeltWidth}' '${TopCoverThickness}' '${TopCoverCompound}'

    @RegressionHp60
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario: RVerify without technical data of conveyor, user should able to add mandatory parameter in cover wear specification screen

        And Create a conveyor with '${TechConveyorName}' and '${DistShopName}' and '${SiteName}'
        Then Add Cover Wear for conveyor '${TechConveyorName}' and site '${SiteName}' with data '${FullName}' '${AddPosition}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
        And Navigate to coverWear list screen and wait for data load
        When Enter the text '${TechConveyorName}' to search
        And Verify the matching result is displayed or No record found message should display
        And wait for conveyors to load
        And Verify search and delete '${TechConveyorName}' functionality

    @RegressionHp61
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_MetricAdd
    Scenario: QUnit selected (In metric)Fill all mandatory parameter with data position selected as default 7, add measurement and download the report

        And Verify data value in header as metric
        And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${SiteName}'
        Then Add Cover Wear for conveyor '${ConveyorName}' and site '${SiteName}' with data '${FullName}' '${AddPosition}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
        When Navigate to coverWear list screen and wait for data load
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Standard}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'

    @RegressionHp62
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_MetricAdd
    Scenario: PUnit selected (In metric)Fill all mandatory parameter with data position selected as 50mm/2inch , add measurement and download the report

        Given User is at Login page
        When  Login with '${UserName}' and '${Password}' and wait for pageload
        And Verify data value in header as metric
        When Navigate to coverWear list screen and wait for data load
        And Wait for the list to load
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Every}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'

    @RegressionHp63
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_MetricAdd
    Scenario: OUnit selected (In metric)Fill all mandatory parameter with data position selected as custom, add measurement and download the report

        And Verify data value in header as metric
        When Navigate to coverWear list screen and wait for data load
        And Wait for the list to load
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Custom}'
        When  Enter data point count as '${Count}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'
        And Click on Clear filter Icon


    @RegressionHp64
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_ImperialAdd
    Scenario:Unit selected (In Imperial)Fill all mandatory parameter with data position selected as default 7, add measurement and download the report

        And  Add Cover Wear for conveyor '${ConveyorName}' and site '${SiteName}' with data '${AddPosition}' '${BeltWidth}'
        And Add data value in header as imperial
        When Navigate to coverWear list screen and wait for data load
        And Verify data value in header as imperial
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Standard}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'
        Then  Verify the PDF report for single conveyor

    @RegressionHp65
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_ImperialAdd
    Scenario:Unit selected (In Imperial)Fill all mandatory parameter with data position selected as 50mm/2inch , add measurement and download the report

        And Add data value in header as imperial
        When Navigate to coverWear list screen and wait for data load
        And Verify data value in header as imperial
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Every}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'
        Then  Verify the PDF report for single conveyor

    @RegressionHp66
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create_ImperialAdd
    Scenario:Unit selected (In Imperial)Fill all mandatory parameter with data position selected as custom, add measurement and download the report

        And Add data value in header as imperial
        When Navigate to coverWear list screen and wait for data load
        And Verify data value in header as imperial
        When Enter the text '${ConveyorName}' to search
        Then Click on view icon
        When  Navigate to position details screen for '${PositionName}'
        When  Open add new measurement window from position details screen
        Then  Verify the selected customer site is '${SiteName}'
        Then  Verify selected conveyor is '${ConveyorName}'
        Then  Verify selected position is '${PositionName}'
        Then  Verify Inspector name is prefilled with '${InspectorName}'
        Then  Verify dropdown behaviour with '${Standard}' and '${Every}' and '${Custom}'
        When  Data point is select as '${Custom}'
        When  Enter data point count as '${Count}'
        When  Enter Temperature '${Temperature}' and verify
        When  Select Inspection date as '${InspectionDate}'
        When  Enter the current tons conveyor '${TonsConveyed}' and verify
        When  Add new measurement for current date with '${Thickness}' and '${Durometer}'
        Then  Verify Add and remove new measurement readings
        And  Scroll the page down
        Then  Verify file upload functionality with '${ImageName}'
        Then  Verify comments sections with '${Comment}'
        Then  Verify save functionality for new measurement
        When  Navigate to cover wear listing screen
        Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
        Then  Download report for date range '${FromDate}' to '${ToDate}'
        Then  Verify the download functionality with '${ConveyorName}' and '${SiteName}' for '${FullName}'
        Then  Verify the PDF report for single conveyor

    @RegressionHp67
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:CoverWear_Create
    Scenario: KVerify delete button functionality is working as expected

        And Click on coverWear card and verify it navigates to coverWear list page
        And Wait for the list to load
        And Extract the main card count for '${Module}'
        And Search for the record '${SiteName}' and verify item is present
        And Click multiSelect Checkbox and verify delete functionality
        And Click on Clear filter Icon
        And Verify the main card count after operation '${Deletion}' for '${Module}' with count '${DeleteCount}'

    @RegressionHp87
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:Regression_Permission_3
    Scenario: Verify view add edit and delete permission for user account for site module

        When User clicks on Users link present in navigation bar
        Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
        Then Reset all permissions
        Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
        Then Click on Update btn
        Then Click on profile and select logout button
        Then Login with '${MktMgrUser}' and '${Password1}'
        Then Verify card display in home screen for basic permission
        Then Verify option display in left navigation menu
        Then Verify only view add edit and delete permission right for site '${siteName}'
        Then Verify only view permission right for corporate '${CorporateName}'
        And  Navigate to Corporate details screen for corporate '${CorporateName}'
        Then Verify card display in corporate details screen
        And  Navigate to add corporate from corporate details screen
        Then Verify type of company dropdown contents for only site permission
        Then Verify only view permission right for CoverWear '${CoverWearName}'
        Then Verify only view permission right for CoverWear Details screen '${CoverWearName}'
        Then Verify only view permission right for measurement Details screen '${CoverWearName}'
        Then Verify only view permission right for conveyors '${ConveyorName}'
        And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
        Then Verify conveyor detail screen card display
        And  User clicks on Conveyor History
        Then User should not see dropdown with belt failure options for view rights

    @RegressionHp88
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:Regression_Permission_6
    Scenario: Verify view and Add permission for user account for conveyor module

        When User clicks on Users link present in navigation bar
        Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
        Then Reset all permissions
        Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
        Then Click on Update btn
        Then Click on profile and select logout button
        Then Login with '${MktMgrUser}' and '${Password1}'
        Then Navigate to conveyor list screen
        Then Verify only view and add permission right for conveyor '${ConveyorName}'


    @Regression89
    @dataFile:resources/data/TestDataHp.xls
    @sheetName:Regression_MarketManager
    @key:Regression_Permission_16
    Scenario: Verify only view and edit permission for user account for cover wear module

        When User clicks on Users link present in navigation bar
        Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
        Then Reset all permissions
        Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
        Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
        Then Click on Update btn
        Then Click on profile and select logout button
        Then Login with '${MktMgrUser}' and '${Password1}'
        Then Verify only view & edit permission right for CoverWear '${ConveyorName}'
        Then Verify only view and edit permission right for CoverWear Details screen '${ConveyorName}'
        Then Verify only view and edit permission right for measurement Details screen '${ConveyorName}'

  @Regression1
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User Add a site from home page and verify the site is added and count is incremented for market manager.

    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Navigate to Add Site page from home and create a Customer site '${CustSiteIndNameMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'

  @Regression2
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User edit a site from home page and Verify the site is edited and count remains same for market manager.

    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Search for the site '${CustSiteIndNameMarket}' and edit the site name '${EditCustSiteNameMarket}'
    Then  Verify the Customer site details with '${EditCustSiteNameMarket}' using corporate '${CustCorpName}'
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Edit}' for '${Sites}' with count '${multipleValue}' at module level '${HomeLevel}'

  @Regression3
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario:Verify User Delete Mulitple sites and sites is deleted from the list and count is updated for master  for market manager.

    And Verify user is on home page of the application
    And Create a Customer site '${CustSiteNameDel1Market}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Create a Customer site '${CustSiteIndNameDelMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Click on Home Link to redirect to home page
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Search for the record '${CustSiteNameDel1Market}'
    And Click multiSelect Checkbox and verify delete functionality
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${multipleValue}' at module level '${HomeLevel}'

  @Regression4
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User add site from customer corporate level and check site is added in customer corporate level & home level and count updated in customer corporate level & home level for market manager

    And   Verify user is on home page of the application
    And   Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And   Extract the card count for '${Sites}' at '${CorporateLevel}' level and Create a Customer site in India '${CustomerSiteIndNameMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullNameInd}' and '${TerritoryInd}'
    Then  Verify the Customer site details with '${CustomerSiteIndNameMarket}' using corporate '${CustCorpName}'
    And   Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${CorporateLevel}'
    And   Click on Home Link to redirect to home page
    And   Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'

  @Regression5
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify correct pagination and card count displayed on Customer Corporate and home level for market manager.

    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Verify correct pagination and card count is displayed at '${HomeLevel}' page for '${Sites}'
    And Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Extract the main card count in '${CorporateLevel}' page for '${Sites}'
    And Verify correct pagination and card count is displayed at '${CorporateLevel}' page for '${Sites}'

  @Regression6
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify when Site is deleted respective conveyor should be deleted and count should be updated for market manager.

    And   Verify user is on home page of the application
    And   Extract the main card count in '${HomeLevel}' page for '${Sites}'
    When  Create a conveyor with '${SiteConveyorNameMarket}' and '${DistShopIndName}' and '${CustomerSiteIndNameMarket}'
    When  Delete Customer site with '${CustomerSiteIndNameMarket}'
    Then  Verify Deleted Customer site with '${CustomerSiteIndNameMarket}'
    Then  Verify Deleted Conveyor '${SiteConveyorNameMarket}' from Conveyor list screen
    And   Verify user is on home page of the application
    And   Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'


  @Regression7
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to add distributor corporate for market manager user

    When  Add Distributor Corporate with '${DistCorporateMarket}' and '${DistCorpAddress}'



  @Regression8
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to add customer corporate for Market user

    And   Create a Customer Corporate with '${CustCorporateMarket}' and '${CustCorpAddress}'


  @Regression9
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to map sites to customer corporate and it reflecting in view mode post addition for Market user

    And   Create a Customer site '${CustSite_HP_Market}' and '${CustCorpAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify navigation to '${CustSite_HP_Market}' detail screen

  @Regression10
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to map shop to Distributor corporate and it reflecting in view mode post addition for market manager

    And   Create a Distributor shop with '${DistShop_HP_Market}' and '${DistShopIndAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify navigation to '${DistShop_HP_Market}' detail screen

  @Regression11
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify action button Edit functionality is working as expected for market manager user

    When  Edit Customer Corporate with '${DistCorporateMarket}' and '${EditDistCorporateMarket}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    Then  Verify the Distributor Corp details with '${EditDistCorporateMarket}' and '${CorpImageName}'


  @Regression12
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify search functionality is working as expected for market manager

    And Navigate to Corporate List screen and wait
    And Search for the record '${EditDistCorporateMarket}'

  @Regression13
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify on deleting site, the count should update in site card count on corporate details screen for market user

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Extract the main card count in '${CorporateLevel}' page for '${Sites}'
    And   Verify search and delete '${CustSite_HP_Market}' functionality
    And   Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${SingleValue}' at module level '${CorporateLevel}'


  @Regression14
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from site level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And   Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName1}' level
    And   Verify default folder for site level
    When  Add Folder by the name '${FolderName}' under site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And   Verify count in the file manager tile

  @Regression15
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from conveyor level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And   Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}' level
    And   Verify default folder for conveyor level
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And   Verify count in the file manager tile


  @Regression16
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify file manager card count is not updated when multiple folders created and validate the count of file manager in site and conveyor level.

    And   Navigate to file manager for conveyor '${Market_FMD_ConveyorName}'
    And   Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FMD_ConveyorName}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FMD_ConveyorName}'
    And   Verify the main card count after operation '${Edit}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And   Verify count in the file manager tile
    And   Click on site name '${Market_FM_SiteName}' in breadcrumb anf verify it navigates to site page
    And   Verify count in the file manager tile


  @Regression17
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify the user should be able to move the folder from one folder to another folder, move files from one folder to another folder,validate folder and files are moved, rename the folder & files and validate files are renamed and delete multiple file and folders from conveyor level and count should be updated accordingly.

    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName2}' under conveyor '${Market_FM_ConveyorName2}'
    And   Upload file '${ImgName}' into the folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFile}'
    When  Add Folder by the name '${FolderNameNested}' inside the folder '${FolderName1}'
    And   Click on the folder '${FolderName1}'
    And   Move the file with '${FolderNameNested}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNested}'
    And   Rename file with name '${FolderNameNested}' to '${FolderNameNestedNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNestedNew}'
    And   Rename file with name '${pdfFile}' to '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFileNew}'
    And   Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    And   Delete multiple file inside folder '${FolderName2}'
    Then  Verify the deleted file '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify the deleted file '${FolderNameNestedNew}' inside folder '${FolderName2}'
    And   Verify the main card count after operation '${Deletion}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'


  @Regression18
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify user should be able to preview and download the uploaded files,multiple downloads should be allowed, duplicate files should not be uploaded,default folders should not be deleted, from site and conveyor level.

    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And   Open file with name '${videoFile}' inside folder '${FolderName}'
    And   Open file with name '${wordFile}' inside folder '${FolderName}'
    And   Open file with name '${excelFile}' inside folder '${FolderName}'
    And   Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted
    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And   Open file with name '${videoFile}' inside folder '${FolderName}'
    And   Open file with name '${wordFile}' inside folder '${FolderName}'
    And   Open file with name '${excelFile}' inside folder '${FolderName}'
    And   Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted




  @Regression19
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to add heavy equipment for market manager

    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentNameMarket}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}'
    And Search for the heavy equipment '${HeavyEquipmentNameMarket}'


  @Regression20
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify heavy equipment should be displayed on home page, Distributor corporate and shop details page only for Market

    And   Verify user is on home page of the application
    And   Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And   Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page
    Then  Navigate to Corporate details screen for corporate '${DistCorpName}'
    And   Verify navigation to '${DistShopName}' detail screen
    And   Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And   Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page
    Then  Navigate to Corporate details screen for corporate '${DistCorpName}'
    And   Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And   Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page


  @Regression21
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able edit heavy equipment for market manager

    And Search for the heavy equipment '${HeavyEquipmentNameMarket}'
    And Navigate to edit heavy equipment page
    And Edit the Heavy Equipment '${HeavyEquipmentNameMarket_Edit}' '${Category}'
    And Click on add Icon and upload the file '${ImageName}'
    And Click on add Icon and upload the file '${PdfFile}'
    And Click on save button and verify the Heavy Equipment '${HeavyEquipmentNameMarket_Edit}' is edited



  @Regression22
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to see image and pdf file in review mode on view details page of heavy equipment

    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${HeavyEquipmentNameMaster_Edit}'
    And Click on view more icon
    And Verify and view the image uploaded '${ImageName}'
    And Verify and view the pdf file uploaded '${PdfFile}'


  @Regression23
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to delete image and pdf file for market manager

    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${HeavyEquipmentNameMarket_Edit}'
    And Click on view more icon
    And Click on the edit button
    And Verify search and delete document '${ImageName}' functionality
    And Verify search and delete document '${PdfFile}' functionality


  @Regression24
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to delete heavy equipment record and card count should also get updated for market manager

    And Verify user is on home page of the application
    And Verify heavy equipment card visibility
    And Extract the main card count in '${HomeLevel}' page for '${HeavyEquipments}'
    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify search and delete '${HeavyEquipmentNameMarket_Edit}' functionality
    And Refresh the screen
    And Verify heavy equipment card visibility
    And Verify the main card count after operation '${Deletion}' for '${HeavyEquipments}' with count '${SingleValue}' at module level '${HomeLevel}'


  @Regression25
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario:Verify correct count should display in heavy equipment record for market

    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify the heavy equipment count with respect to pagination
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Verify navigation to '${DistShopName}' detail screen
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the heavy equipment count with respect to pagination
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the heavy equipment count with respect to pagination



  @Regression4
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression_HP
  @key:FreeTools_BreadCrumb
  Scenario: Verify all the free tools functionality with bread crumbs validation for distributor.

    And   Navigate to free tools capacity and verify the breadcrumb  for '${Capacity}'
    Then  Navigate to free tools troughability and verify the breadcrumb for '${Troughability}'
    And   Navigate to free tools Roll Length and verify the breadcrumb for '${RollLength}'
    And   Navigate to free tools Safety factor and verify the breadcrumb for '${SafetyFactor}'
    And   Navigate to free tools Units Converter and verify the breadcrumb for '${UnitsConverter}'
    And   Navigate to free tools Belt Revolution and verify the breadcrumb for '${BeltRevolution}'
    And   Navigate to free tools Wrap Angle and verify the breadcrumb for '${WrapAngle}'






  @Regression7
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Conveyor all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    And   Create a Customer site '${CustSiteNameGeneric}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    When  Create a conveyor with '${GenericConveyorName1}' and '${DistShopIndName}' and '${CustSiteNameGeneric}'
    When  Create a conveyor with '${GenericConveyorName2}' and '${DistShopIndName}' and '${CustSiteNameGeneric}'
    When  Add Cover Wear for conveyor '${GenericConveyorName1}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName1}'
    Then  Click on Belt Scan card and verify it navigates to BeltScan listing page
    And   Click on add button and verify navigation to Add BeltScan page
    And   Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName1}' is present in list screen
    Then  Navigate to Belt Monitoring List screen
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceName}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName1}'
    And   Click on save button and verify device '${DeviceName}' is created successfully
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen
    When  Delete Conveyor from Conveyor list screen '${GenericConveyorName1}'
    Then  Verify Deleted Conveyor '${GenericConveyorName1}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName1}'
    And   Refresh the screen
    Then  Verify the deleted Belt Scan '${GenericConveyorName1}' in list screen
    Then  Verify the deleted monitoring device '${DeviceName}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationName}' in list screen


  @Regression26
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Site all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    When  Add Cover Wear for conveyor '${GenericConveyorName2}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName2}'
    Then  Click on Belt Scan card and verify it navigates to BeltScan listing page
    And   Click on add button and verify navigation to Add BeltScan page
    And   Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName2}' is present in list screen
    Then  Navigate to Belt Monitoring List screen
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceNameSite}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName2}'
    And   Click on save button and verify device '${DeviceNameSite}' is created successfully
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationNameSite}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationNameSite}' in list screen
    When  Delete Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Conveyor '${GenericConveyorName2}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName2}'
    And   Refresh the screen
    Then  Verify the deleted Belt Scan '${GenericConveyorName2}' in list screen
    Then  Verify the deleted monitoring device '${DeviceNameSite}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationNameSite}' in list screen

  @Regression27
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Conveyor all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    And   Create a Customer site '${CustSiteNameGeneric}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    When  Create a conveyor with '${GenericConveyorName1}' and '${DistShopName}' and '${CustSiteNameGeneric}'
    When  Create a conveyor with '${GenericConveyorName2}' and '${DistShopName}' and '${CustSiteNameGeneric}'
    When  Add Cover Wear for conveyor '${GenericConveyorName1}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName1}'
    Then  Click on Belt Scan card and verify it navigates to BeltScan listing page
    And   Click on add button and verify navigation to Add BeltScan page
    And   Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName1}' is present in list screen
    Then  Navigate to Belt Monitoring List screen
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceName}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName1}'
    And   Click on save button and verify device '${DeviceName}' is created successfully
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen
    When  Delete Conveyor from Conveyor list screen '${GenericConveyorName1}'
    Then  Verify Deleted Conveyor '${GenericConveyorName1}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName1}'
    Then  Verify the deleted Belt Scan '${GenericConveyorName1}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationName}' in list screen
    And   Refresh the screen
    Then  Verify the deleted monitoring device '${DeviceName}' in list screen



  @Regression28
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Site all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    When  Add Cover Wear for conveyor '${GenericConveyorName2}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName2}'
    Then  Click on Belt Scan card and verify it navigates to BeltScan listing page
    And   Click on add button and verify navigation to Add BeltScan page
    And   Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName2}' is present in list screen
    Then  Navigate to Belt Monitoring List screen
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceNameSite}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName2}'
    And   Click on save button and verify device '${DeviceNameSite}' is created successfully
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationNameSite}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationNameSite}' in list screen
    When  Delete Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Conveyor '${GenericConveyorName2}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName2}'
    Then  Verify the deleted Belt Scan '${GenericConveyorName2}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationNameSite}' in list screen
    And   Refresh the screen
    Then  Verify the deleted monitoring device '${DeviceNameSite}' in list screen

  @Regression29
  @dataFile:resources/data/BeltMonitoringHP.json
  Scenario: Verify search and filter functionality for default columns in Monitoring device list page for market manager user.

    Then  Navigate to Belt Monitoring List screen
    And   Click on each column header and verify filter icon fields


@100HP @Regression29
@dataFile:resources/data/LegacyImperialA.json
Scenario: zVerify minuteman functionality for legacy minuteman calculation at home level

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    And   User is at add minuteman conveyor page '${CalculationName}'
    When  User enters general info with '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman card count
    When  Navigate the minuteman calculation '${CalculationName}' in list screen
    And   User navigates to final report screen
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    And   Verify download report option on final report '${CalculationName}'
    When  Navigate to minuteman screen from site card
    And   Edit calculation '${CalculationName}' units to 'Metric' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the pre populated data in inputs page '${BeltWidthM}' '${BeltSpeedM}' '${TonsPerHourPeakM}' '${PickMaterialNameM}' '${MaterialDensityM}' '${AngleOfIdlerM}' '${CarrySideIdlerSpacingM}' '${DriveWrapAngleM}' '${DriveWrapAngleDegreeM}' '${TakeUpTensionM}' '${FrictionFactorM}' '${LengthFactorM}' '${SurchargeAngleM}' '${IdlerOffsetM}' '${DriverDetailsM}' '${TakeUpDetailsM}' '${SpliceTypeM}'


@100HP @Regression30
@dataFile:resources/data/MinutemanMetricA.json
Scenario: Verify minuteman functionality for minuteman calculation at conveyor level

    And   Close warning popup
    And   User is at add minuteman conveyor page '${CalculationName}' from conveyor level '${ConveyorName}'
    And   Extract the minuteman card data
    And   User is navigates to add minuteman conveyor page from list screen
    When  User enters general info with '${CalculationName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    When  Click on create button for minuteman calculation
    And   Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And   Navigate to minuteman from the card
    Then  Verify the minuteman card count
    When  Edit minuteman calculation '${CalculationName}' to '${NewCalculationName}'
    Then  Verify all the data shown in the reports with calculated and entered data '${NewCalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    And   Verify download report option on final report '${NewCalculationName}'
    When  Navigate to minuteman screen from site card
    And   Edit calculation '${NewCalculationName}' units to 'Imperial' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${NewCalculationName}' in list screen
    Then  Verify the pre populated data in general info page for imperial '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the pre populated data in inputs page '${BeltWidthM}' '${BeltSpeedM}' '${TonsPerHourPeakM}' '${PickMaterialNameM}' '${MaterialDensityM}' '${AngleOfIdlerM}' '${CarrySideIdlerSpacingM}' '${DriveWrapAngleM}' '${DriveWrapAngleDegreeM}' '${TakeUpTensionM}' '${FrictionFactorM}' '${LengthFactorM}' '${SurchargeAngleM}' '${IdlerOffsetM}' '${DriverDetailsM}' '${TakeUpDetailsM}' '${SpliceTypeM}'

@100HP @Regression31
@dataFile:resources/data/CypherMetricA.json
Scenario: Verify minuteman functionality for cipher calculation at site level

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    And   User is at add minuteman conveyor page '${CalculationName}' from site level '${Site}'
    And   User is navigates to add minuteman conveyor page from list screen
    When  User enters general info '${CalculationName}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    And   Verify download report option on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman card count
    When  Navigate to minuteman screen from site card
    And   Edit calculation '${CalculationName}' units to 'Imperial' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the pre populated data in general info page for imperial '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the pre populated data in inputs page '${BeltWidthM}' '${BeltSpeedM}' '${TonsPerHourPeakM}' '${PickMaterialNameM}' '${MaterialDensityM}' '${AngleOfIdlerM}' '${CarrySideIdlerSpacingM}' '${DriveWrapAngleM}' '${DriveWrapAngleDegreeM}' '${TakeUpTensionM}' '${FrictionFactorM}' '${LengthFactorM}' '${SurchargeAngleM}' '${IdlerOffsetM}' '${DriverDetailsM}' '${TakeUpDetailsM}' '${SpliceTypeM}'


@100HP @Regression32
@dataFile:resources/data/CypherImperialB.json
Scenario: Verify minuteman functionality for load data calculation

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    And   User is at add minuteman conveyor page '${CalculationName}'
    When  Verify the load data functionality in user info for '${CalculationName}' '${Site}' '${ConveyorName}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    And   Verify download report option on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman card count

@100HP @Regression33
@dataFile:resources/data/MinutemanPrePopulatedImperial.json
Scenario: Verify minuteman functionality for private calculation

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    And   User is at add minuteman conveyor page '${CalculationName}'
    When  User enters general info with '${CalculationName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    And   Verify download report option on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    And   Verify the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the minuteman card count

@100HP @Regression34
@dataFile:resources/data/CypherImperialB.json
Scenario: Verify minuteman functionality for final report notes

    And   Close warning popup
    And   User is at add minuteman conveyor page '${CalculationName}'
    When  User enters general info with '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    And   User should see all the calculated data of Roll data page and click on next
    And   User should see all the calculated data of pulleys page and click on next
    And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
    And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
    And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
    When  Navigate to the pulley and calculate with '1'
    When  Navigate to the take up and calculate with '1'
    When  Navigate to the curves and calculate with '1'
    When  Navigate to the transition and calculate with '1'
    And   Verify all the notes are present in final report
    And   Verify download report option on final report '${CalculationName}'


@100HP @Regression35
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_duplicate
Scenario: Verify duplicate name creation on the minuteman

    And   Close warning popup
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${CustSiteName}' '${ConveyorName}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${CustSiteName}' '${ConveyorName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName1}' in list screen
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName2}' '${CustSiteName}' '${ConveyorName2}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName2}' '${CustSiteName}' '${ConveyorName2}'
    When  Click on create button for minuteman calculation
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${CustSiteName}' '${NoConveyor}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${CustSiteName}' '${NoConveyor}'
    When  Click on create button and verify failure toast
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${CustSiteName1}' '${ConveyorName1}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${CustSiteName1}' '${ConveyorName1}'
    When  Click on create button for minuteman calculation
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${NoSite}' '${NoConveyor}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${NoSite}' '${NoConveyor}'
    When  Click on create button for minuteman calculation
    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName1}' '${NoSite}' '${NoConveyor}' and click on select belt
    And   User enters select belt details and click on final report
    Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName1}' '${NoSite}' '${NoConveyor}'
    When  Click on create button and verify failure toast

@100HP @Regression36
@dataFile:resources/data/CipherImperialBucketElevatorB.json
Scenario: yVerify bucket elevator functionality for legacy cipher

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    When  User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the minuteman card count
    When  Navigate the minuteman calculation '${CalculationName}' in list screen
    And   User enters elevator select belt details and click on final report
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    Then  Verify download report option for bucket elevator on final report '${CalculationName}'
    When  Navigate to minuteman screen from site card
    And   Edit bucket calculation '${CalculationName}' units to 'Metric' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the pre populated data in general info page '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the bucket elevator pre populated data in inputs page '${ConveyorTypeM}' '${MaterialDensityM}' '${TonsPerHourPeakM}' '${MaterialLengthM}' '${MaterialProjectionM}' '${BucketSpacingM}' '${BucketWeightM}' '${BucketVolumeM}' '${BucketRowsM}' '${BeltWidthM}' '${BeltHeightM}' '${BeltSpeedM}' '${DrivePulleyM}' '${TakeUpTypeM}'


@100HP @Regression37
@dataFile:resources/data/LegacyMetricBucketElevatorA.json
Scenario: sVerify bucket elevator functionality for legacy minuteman

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    When  User is at add minuteman bucket elevator page
    When  User enters elevator general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters elevator inputs '${ConveyorType}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${DrivePulley}' '${TakeUpType}' and click on next
    And   User enters select elevator belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data Add '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}' and click on next
    Then  Verify all the elevator data shown in the reports with calculated and entered data '${ConveyorType}' '${CalculationName}' '${Site}' '${ConveyorName}' '${ConveyorType}' '${TradeName}' '${MaterialDensity}' '${TonsPerHourPeak}' '${MaterialLength}' '${MaterialProjection}' '${BucketSpacing}' '${BucketWeight}' '${BucketVolume}' '${BucketRows}' '${BeltWidth}' '${BeltHeight}' '${BeltSpeed}' '${BeltWeight}' '${DrivePulley}' '${TakeUpType}' '${MaximumTension}' '${MaximumPIW}' '${EffectiveTension}' '${BeltHorsepower}' '${PercentLoaded}' '${CounterweightTension}' '${CounterweightWeight}' '${WeightInEachBucket}' '${MimTailPulleyDiameter}' '${MaximumProjection}' '${AppropriateNumber}'
    Then  Verify download report option for bucket elevator on final report '${CalculationName}'
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the minuteman card count
    When  Navigate to minuteman screen from site card
    And   Edit bucket calculation '${CalculationName}' units to 'Imperial' with '${Program}' '${ManufacturingLocation}'
    And   Navigate the minuteman calculation '${CalculationName}' in list screen
    Then  Verify the pre populated data in general info page for imperial '${Program}' '${ManufacturingLocation}'
    When  User click on next
    Then  Verify the bucket elevator pre populated data in inputs page '${ConveyorTypeM}' '${MaterialDensityM}' '${TonsPerHourPeakM}' '${MaterialLengthM}' '${MaterialProjectionM}' '${BucketSpacingM}' '${BucketWeightM}' '${BucketVolumeM}' '${BucketRowsM}' '${BeltWidthM}' '${BeltHeightM}' '${BeltSpeedM}' '${DrivePulleyM}' '${TakeUpTypeM}'

@100HP @Regression38
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:minuteman_delete
Scenario: oVerify delete functionality for minuteman and bucket elevator

    And   Close warning popup
    When  Navigate to minuteman screen from site card
    And   Extract the minuteman card data
    When  Delete minuteman calculation '${CalculationName1}'
    Then  Verify the deleted minuteman calculation '${CalculationName1}' in list screen
    Then  Verify for delete minuteman card count
    When  Delete minuteman calculation '${CalculationName2}'
    Then  Verify the deleted minuteman calculation '${CalculationName2}' in list screen
    Then  Verify for delete minuteman card count
