Feature: Beltforms

  Background:
  Launch the application through '/'


  @CTCP-388 @CTCP-479 @CTCP-455
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: ZVerify card of monitoring device Home page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Verify Belt Monitoring card details
    And Click on the Belt Monitoring card
    And Verify the table header panel

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

  @CTCP-392 @CTCP-527
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
    And Verify the monitoring device count with respect to pagination

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


  @CTCP-497 @CTCP-498 @CTCP-499  @CTCP-501 @CTCP-502 @CTCP-503 @CTCP-509 @CTCP-518 @CTCP-3673 @CTCP-519 @CTCP-507
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Details
  Scenario: Verify the 2nd stage Add location page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Verify the add location page functionality for add monitoring device page with '${AssociatedDistName}' '${SiteName}' '${Latitude}' '${Longitude}'
    And Click on previous button  and verify navigation to Add Location page
    And Click on next button and verify navigation to Add Location page
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Verify search and delete '${DeviceName}' functionality


  @Regression8 @CTCP-2808 @2807
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice
  Scenario: Verify the functionality of the field "Access to System Software" when passing proper web link

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Validate Access Link Icon is enabled for Monitoring Device
    And Verify search and delete '${DeviceName}' functionality

  @Regression8 @CTCP-2809 @CTCP-3675
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice_SysLink
  Scenario: Verify the functionality of the field "Access to System Software" when wrong web link

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Validate Access Link Icon is disabled for Monitoring Device
    And Verify search and delete '${DeviceName}' functionality

  @Regression8 @CTCP-413
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice
  Scenario: Verify the forward navigation symbol present in each row

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Validate the forward navigation symbol in each row

  @CTCP-521
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice
  Scenario: Verify the card of conveyor Home page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Verify user is on the home page of the application
    And Verify Conveyor card details

  @CTCP-551
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_AddDevice
  Scenario: Verify the forward and backward navigation symbol present in the bottom of the table

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Belt Monitoring List screen
    And Verify pagination forward arrow button
    And Verify pagination backward arrow button
    And Verify pagination double forward arrow button
    And Verify pagination double backward arrow button

  @CTCP-4058
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Map_View
  Scenario: Verify user can see world map including pins for all the Monitoring Devices to access

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
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
    And Navigate to Corporate details screen for corporate '${CorpName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Validate map and list icon are not visible

  @CTCP-4060 @CTCP-400
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Map_View
  Scenario: Verify user should be able to add MD from map view and display the new device on Maps

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Verify monitoring device is in map view
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Verify the add location page functionality for add monitoring device page with '${AssociatedDistName}' '${SiteName}' '${Latitude}' '${Longitude}'
    And Click on save button and verify device '${DeviceName}' is created successfully
    And Verify monitoring device is in map view
    And Validate monitoring device '${DeviceName}' is present in map view

  @CTCP-4061 @CTCP-387
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Monitoring_Device_Map_View
  Scenario: Verify user should be able to add MD from map view and display the new device on Maps

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Click on actions dropdown button and edit the '${DeviceName}'
    And Edit the device name to '${EditDeviceName}' for monitoring device
    Then Search and verify the '${EditDeviceName}' is present
    And Verify monitoring device is in map view
    And Validate monitoring device '${EditDeviceName}' is present in map view
#    Then Navigate and validate navigation to list view for monitoring device
#    And Verify search and delete '${EditDeviceName}' functionality

@CTCP-3628
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Map_View
Scenario: Add “Site” as searchable field

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Validate Site as searchable field
    Then Search and verify the '${SiteName}' is present


@CTCP-4033
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Map_View
Scenario: Verify warning popup is displayed in case the user exists the Monitoring Device without clicking the create in Add Mode

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    Then Click on cancel button
    And Verify warning pop up for monitoring device is not displayed
    And Verify monitoring device is in list view
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on previous button  and verify navigation to Add Location page
    Then Click on cancel button
    And Verify warning pop up for monitoring device is displayed
    And Click on the Close Pop Up
    Then Click on next button and verify navigation to Add Location page
    Then Click on cancel button for add location
    And Verify warning pop up for monitoring device is displayed
    And Click on the Close Pop Up
    Then Click on add conveyor in menu
    And Verify warning pop up for monitoring device is displayed
    And Click on the Close Pop Up
    Then Click on monitoring device bread crumb
    And Verify warning pop up for monitoring device is displayed
    And Click on No button on popup
    Then Click on profile and select logout button
    And Verify warning pop up for monitoring device is displayed
    And Click on Yes button on popup
    And User is at Login page

@CTCP-4034
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Map_View
Scenario: Verify warning popup is displayed in case the user exists the Monitoring Device without clicking the create in Add Mode

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Click on actions dropdown button and edit the '${EditDeviceName}'
    Then Click on cancel button
    And Verify warning pop up for monitoring device is not displayed
    And Verify monitoring device is in list view
    And Click on actions dropdown button and edit the '${DeviceName}'
    And Add the non-mandatory fields for device with '${Brand}' '${SerialNumber}' '${RemoteConnection}' '${CommisioningDate}' and '${BeltConveyorSaves}' and '${FirmWareVersion}' and '${SystemLink}'
    Then Click on cancel button
    And Verify warning pop up for monitoring device is displayed
    And Click on the Close Pop Up
    Then Click on add conveyor in menu
    And Verify warning pop up for monitoring device is displayed
    And Click on the Close Pop Up
    Then Click on monitoring device bread crumb
    And Verify warning pop up for monitoring device is displayed
    And Click on No button on popup
    Then Click on profile and select logout button
    And Verify warning pop up for monitoring device is displayed
    And Click on Yes button on popup
    And User is at Login page

@CTCP-2814
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Map_View
Scenario: Click on "Export Pdf" option from the Action Dropdown then verify the functionality

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${EditDeviceName}' monitoring Device
    And Click the checkbox in the row table
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible
    And Click on export Pdf and verify pdf contents for Monitoring device with '${EditDeviceName}' '${SiteName}' '${ConveyorName}'

@CTCP-2791
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Map_View
Scenario: Verify the data is displayed under "Territory" column column

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Search for the '${EditDeviceName}' monitoring Device
    And Verify the territory data '${Territory}' is displayed for Monitoring device

@CTCP-470
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Corporate
Scenario: Verify the data is displayed under "Territory" column column change

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Corporate details screen for corporate '${CorpName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Extract the main card count for '${Module}'
    Then Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on create button
    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
    And Verify search and delete '${DeviceName}' functionality

@CTCP-472
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Corporate
Scenario: Verify the data is displayed under "Territory" column column changed

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to site details for site '${SiteName}'
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on carousel right icon
    And Click on the Belt Monitoring card
    And Extract the main card count for '${Module}'
    Then Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And Click on create button
    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
    And Verify search and delete '${DeviceName}' functionality

@CTCP-3979
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Monitoring_Device_Corporate
Scenario: Verify the table changes in the monitoring device listing page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Belt Monitoring List screen
    Then Verify table column and header names in the monitoring device

#@CTCP-3979
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Monitoring_Device_Corporate
#Scenario: Verify the table changes in the monitoring device listing page
#
#    Given User is at Login page
#    When Login with '${UserName}' and '${Password}'
#    And Add Distributor shop with '${DistShopName}' and '${ShopAddress}' and '${DistCorpName}' and '${FullName}' and '${Territory}'
#    And Create a Customer site '${CustSiteAusName}' and '${CustSiteAusAddress}' and '${CustCorpName}' and '${DistShopAusName}' and '${FullName}' and '${TerritoryAus}'
#    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustShopName}'
#    And Navigate to Corporate details screen for corporate '${CustCorpName}'
#    And Search thes '${ShopName}' and click on view icon
#    And  Click on carousel right icon
#    And Click on carousel right icon
#    And Click on the Belt Monitoring card
#    And Extract the main card count for '${Module}'
#    Then Navigate to Add monitoring device screen
#    And Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
#    And Click on create button
#    And Verify the main card count after operation '${Addition}' for '${Module}' with count '${AddCount}'
#    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
#    And Verify search and delete '${BeltScan}' functionality
