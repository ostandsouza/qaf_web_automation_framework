Feature: Beltforms

  Background:
  Launch the application through '/'


  @CTCP-388
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: ZVerify card of monitoring device Home page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Click on carousel left icon
    And Verify Belt Monitoring card details

  @CTCP-390 @CTCP-2812
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify the Action button disable ,while uncheck the check box

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${MonitoringDevice}' monitoring Device
    And Click the checkbox in the row table
    And Verify Action button is enabled with delete edit and scan option available
    And Click the checkbox in the row table
    And Verify Action button is enabled without delete edit and scan option

  @CTCP-392
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify clearing the applied filters by using clear filter button

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Belt Monitoring List screen
    When Apply sorting or filter on column name '${cloumnName}' '${filterName}' '${filter}'
    Then Verify that the filter is applied for '${cloumnName}' '${filter}'
    And Click on clear filter and verify filter '${cloumnName}' is removed

  @CTCP-398
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify the Entered Device name appear in the search text field

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${MonitoringDevice}' monitoring Device

  @CTCP-406
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario:Verify the Monitoring location icon are present in each row

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${MonitoringDevice}' monitoring Device
    Then Click on location symbol and verify location pop up details for '${MonitoringDevice}'
    And Verify Map and Satellite button selection
#     And Verify PegMan hover and drag functionality
    And Zoom in and out to reach conveyor location

  @CTCP-3676
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify user is able to click on enabled map on the listing screen

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${MonitoringDevice}' monitoring Device
    Then Click on location symbol and verify location pop up details for '${MonitoringDevice}'

  @CTCP-479
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify the card of monitoring device

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Click on carousel left icon
    And Verify Belt Monitoring card details
    And Click on the Belt Monitoring card
    And Verify the tabel header panel

  @CTCP-497 @CTCP-498 @CTCP-499  @CTCP-501 @CTCP-502 @CTCP-503 @CTCP-509 @CTCP-518 @CTCP-3673 @CTCP-519 @CTCP-507
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify the 2nd stage Add location page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Verify the add location page functionality for add monitoring device page with '${AssociatedDistName}' '${SiteName}' '${Latitude}' '${Longitude}'
    And Click on previous button  and verify navigation to Add Location page
    And Click on next button and verify navigation to Add Location page
    And Click on save button and verify device '${DeviceName}' is created successfully


  @Regression8 @CTCP-2808 @2807
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice
  Scenario: Verify the functionality of the field "Access to System Software" when passing proper web link

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Validate Access Link Icon is enabled for Monitoring Device

  @Regression8 @CTCP-2809 @CTCP-3675
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice_SysLink
  Scenario: Verify the functionality of the field "Access to System Software" when wrong web link

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${InstallationDate}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Validate Access Link Icon is disabled for Monitoring Device