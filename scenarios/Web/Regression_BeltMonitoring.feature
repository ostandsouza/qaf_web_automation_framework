Feature: Regression of P1 Belt Monitoring module

Background:
Launch the application through '/'

@Regression1 @CTCP-389
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Verify action button is preset in the device table

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify user is able to find the action button and is enabled by default

@Regression2 @CTCP-391
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Verify the update and delete options in the Actions dropdown

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify user is able to find the action button and is enabled by default
    And Search for the MonitoringDevice '${Device1}' and select the checkbox
    And Click on action dropdown and verify edit and delete options are visible
    And Search for the MonitoringDevice '${Device2}' and select the checkbox
    And Click on action dropdown and verify only delete option is visible

@Regression3 @CTCP-393
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Verify the device name associated conveyor test field in the table

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify column selection filter is visible
    And Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible
    And Enter the columnName '${ColumnName}' in searchBar and verify all columnName with search text is displayed in monitoring device

@Regression6 @CTCP-405
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: AVerify the update and delete options in the Actions dropdown

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify user is able to find the action button and is enabled by default
    And Search for the MonitoringDevice '${Device1}' and select the checkbox
    And Click on action dropdown and verify Scan QR is visible
    And Click on the scanner symbol and verify fields '${Device1}'
    And Click on the download button and verify QR is downloaded with the proper name '${Device1}'

@Regression4 @CTCP-401
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Verify the filter functionality in DeviceName

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Click on the filter icon and verify all fields are visible for columnName '${ColName}'

@Regression5 @CTCP-412
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Filter
Scenario: Verify the ascending and descending arrow are available with each elements

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    Then Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column and verify sorting should be in increasing order
    And Click on column header '${ColumnHeader}' of '${ColumnNumber}' nd column again and verify sorting should be in decreasing order



@Regression7 @CTCP-478
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Navigate to belt monitoring device page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen

@Regression8 @CTCP-481
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_Navigation
Scenario: Verify the breadcrumb of the page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Verify the bread crumb of add monitoring device page

@Regression8 @CTCP-483 @CTCP-484
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the Device Name, Device Type

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'


@Regression8 @CTCP-485 @CTCP-486 @CTCP-487 @CTCP-488 @CTCP-482
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify all fields in the Add Device

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}'


@Regression8 @CTCP-494 @517 @506
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the cancel button

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on Cancel button and verify warning popup is displayed and click on yes button
    And Verify user is navigated to monitoring device listing page

@Regression8 @CTCP-495
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the save button

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on save button and verify device '${DeviceName}' is created successfully

@Regression8 @CTCP-493
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the status dropdown

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Click on the status dropdown and verify the dropdown values

@Regression8 @CTCP-489
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the installation date text field

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Verify the format of the installation date field and click on it and verify calendar popup is displayed
    And Click on the month in calender and verify month chart is displayed and next and verify previous buttons functionality
    And Click on the year in calender and verify year chart is displayed and next and verify previous buttons functionality

@Regression8 @CTCP-492
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: AVerify the mandatory elements

 Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Verify save button is enabled

@Regression8 @CTCP-490
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the commissioning date text field

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Verify the format of the commissioning date field and click on it and verify calendar popup is displayed
    And Click on the month in calender and verify month chart is displayed and next and verify previous buttons functionality
    And Click on the year in calender and verify year chart is displayed and next and verify previous buttons functionality
    And Click on any past commissioning date user should be able to select only past date


@Regression8 @CTCP-491
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the Belt/Conveyor Saves text field

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Click on the belt/conveyor saves text field and verify the upward and downward functionality


@Regression8 @CTCP-3672
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceTerritory_TerritoryUser
Scenario:  Verify user is able to add the monitoring device on territory manager

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on save button and verify device '${DeviceName}' is created successfully


@Regression8 @CTCP-3671
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDevice_MarketUser
Scenario: Verify user is able to add the monitoring device on market manager

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on save button and verify device '${DeviceName}' is created successfully

@Regression8 @CTCP-3673
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDevice_CustomerUser
Scenario: Verify user is able to add the monitoring device on customer user

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on save button and verify device '${DeviceName}' is created successfully

@Regression8 @CTCP-3674
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDevice_DistributorUser
Scenario: Verify user is able to add the monitoring device on distributor user

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List page
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on save button and verify device '${DeviceName}' is created successfully

@Regression8 @CTCP-3977
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_AddDeviceNonMandatory
Scenario: Verify the labels and colors for buttons of Add Monitoring Device page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Verify create and cancel buttons are displayed
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Verify create and cancel button colors

@Regression8 @CTCP-3978
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_EditDevice
Scenario: Verify the labels and colors for buttons of Edit Monitoring Device page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Search for the device '${DeviceName}' and navigate to edit device page
    And Click on next button and verify navigation to Add Location page
    And Verify save and cancel buttons are displayed
    And Verify create and cancel button colors

@Regression8 @CTCP-4022
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_EditDevice
Scenario: Verify the device type names space is removed between the names

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Verify the values under the device type dropdown
    And Click on cancel button and verify navigation to monitoring device list page
    And Search for the device '${DeviceName}' and navigate to edit device page
    And Verify the values under the device type dropdown
    And Click on cancel button and verify navigation to monitoring device list page
    And Search for the device '${DeviceName}' and navigate to view device page
    And Verify the deviceType '${DeviceType}' in monitoring device view page

@Regression8 @CTCP-394 @CTCP-396 @CTCP-397
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:BeltMonitoring_EditDevice
Scenario: verify the functionality of column selection filter button

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify column selection filter is visible
    And Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible
    And Verify user is able to see the column names selected by default
    And Select only two columns and verify the selected columns are visible in the table


 @Regression8 @CTCP-402
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:BeltMonitoring_EditDevice
 Scenario: Click and verify the filter Icon in all default columns

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     Then  Navigate to Belt Monitoring List screen
     And Click on each column header and verify filter icon fields











