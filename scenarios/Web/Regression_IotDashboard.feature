Feature: Regression of P1 Inspection module

  Background:
  Launch the application through '/'

  @Regression1 @CTCP-4063
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_FirstTime
  Scenario: zzVerify create new dashboard button

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Verify the create new iot dashboard functionality

  @Regression2 @CTCP-4064
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_FirstTime
  Scenario: zfVerify add new dashboard using create new dashboard button

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Verify the add new iot dashboard functionality

  @Regression3 @CTCP-4062
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_admin
  Scenario: zeVerify user able to access IOT dashboard

    And   Logout from the current user
    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen and wait to load data
    Then  Verify if the iot card is highlighted
    And   Navigate to site list page
    And   Verify if the iot card is not highlighted
    And   Navigate to iot dashboard list screen after card click
    And   Verify if the iot card is highlighted


  @Regression4 @CTCP-4065
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_admin
  Scenario: zdVerify the pagination functionality

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen and wait to load data
    Then  Verify the iot dashboard count with respect to pagination
    And   Verify the pagination limit functionality

  @Regression5 @CTCP-4066
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_admin
  Scenario: zcVerify the action button functionality

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen and wait to load data
    Then  Select the iot dashboard '${DashboardName}'
    And   Verify the action button functionality for single selection
    Then  Select the iot dashboard '${DashboardName1}'
    And   Verify the action button functionality for multi selection

  @Regression6 @CTCP-4067
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_admin
  Scenario: zbVerify the duplicate button functionality

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen and wait to load data
    And   Verify the duplicate button functionality for '${DashboardName}'

  @Regression7 @CTCP-4068
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: zaVerify the add dashboard functionality

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Create iot dashboard with '${DashboardName}' '${SiteName}'
    Then  Verify the list for iot dashboard '${DashboardName}'

  @Regression8 @CTCP-4070
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: yVerify the add widget ui

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Navigate to the iot dashboard '${DashboardName}'
    And   Verify field on add new widget
    And   Verify add new widget subtext

  @Regression9 @CTCP-4069
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: wVerify the add widget functionality for newly created dashboard

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Navigate to the iot dashboard '${DashboardName}'
    And   Verify create new widget is visible for newly created dashboard
    And   Verify add new widget navigation
    And   Verify the different options available when creating widgets
    And   Verify the cancel functionality when creating widget
    And   Add widget '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'

  @Regression10 @CTCP-4071
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: vVerify the newly added widget ui

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Add widget '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    And   Verify the fields for unliked widget

  @Regression11 @CTCP-4072
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: tVerify user configure the widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Add widget '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    And   Configure a monitoring device '${MonitoringDevice}' to an unliked widget

  @Regression12 @CTCP-4073
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: sVerify user widget buttons functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget '${WidgetName}'
    Then  Verify the monitoring device '${MonitoringDevice}' configured for widget
    Then  Verify the expand widget functionality for '${WidgetName}' and '${MonitoringDevice}'
    Then  Verify the info widget functionality for '${WidgetName}'
    Then  Verify the more widget functionality


  @Regression13 @CTCP-4074
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify the edit functionality of the dashboard when one/none of the widgets are configured

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Create iot dashboard with '${DashboardName}' '${SiteName}'
    And   Add widget for the first time '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    Then  Verify the edit button functionality when widgets are unliked
    And   Configure a monitoring device '${MonitoringDevice}' to an unliked widget
    And   Add widget '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    Then  Verify the edit button functionality when widgets are unliked


  @Regression14 @CTCP-4075
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify the edit functionality when one / all of the widgets are configured

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Create iot dashboard with '${DashboardName}' '${SiteName}'
    And   Add widget for the first time '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    And   Configure a monitoring device '${MonitoringDevice}' to an unliked widget
    Then  Verify the edit button functionality when widgets are configured
    And   Verify the edit dashboard functionality
    And   Verify the save dashboard functionality

  @Regression15 @CTCP-4076
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify cancel functionality when widgets are in edit mode

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Create iot dashboard with '${DashboardName}' '${SiteName}'
    And   Add widget for the first time '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    And   Configure a monitoring device '${MonitoringDevice}' to an unliked widget
    Then  Verify the edit button functionality when widgets are configured
    And   Verify the edit dashboard functionality
    And   Verify the cancel dashboard functionality

  @Regression16 @CTCP-4077
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify delete functionality of the Widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify the delete widget functionality '${WidgetName}'

  @Regression17 @CTCP-4078
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify delete functionality of dashboard

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Verify the delete dashboard functionality '${DashboardName}'

  @Regression18 @CTCP-4079
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify the Action functionality on dashboard listing screen

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    Then  Select the iot dashboard '${DashboardName}'
    And   Verify the action button functionality for single selection
    Then  Select the iot dashboard '${DashboardName1}'
    And   Verify the action button functionality for multi selection

  @Regression19 @CTCP-4080
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify configure functionality for already configured widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    And   Add widget '${WidgetName}' to '${DashboardName}'
    And   Verify newly created widget '${WidgetName}'
    And   Configure a monitoring device '${MonitoringDevice}' to an unliked widget
    Then  Verify the confiure existing widget functionality


  @Regression20 @CTCP-4081
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user adds Splice summary widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget '${WidgetName}'
    Then  Verify the monitoring device '${MonitoringDevice}' configured for widget

  @Regression21 @CTCP-4082
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user adds Cord Damage summary widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget '${WidgetName}'
    Then  Verify the monitoring device '${MonitoringDevice}' configured for widget

  @Regression22 @CTCP-4083
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user adds Segment summary widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget '${WidgetName}'
    Then  Verify the monitoring device '${MonitoringDevice}' configured for widget

  @Regression23 @CTCP-4084
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user adds link widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget '${WidgetName}'
    Then  Configure a link widget from an unliked widget '${Title}' '${Url}' '${Description}'

  @Regression24 @CTCP-4185
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify the widget loading symbol displayed for new data loading

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality

  @Regression25 @CTCP-4186
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify No DataAavailable for any of the widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality

  @Regression28 @CTCP-4190
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user add single splice parameter widget

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality


  @Regression27 @CTCP-4188
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify the configuration is done for multiple splice parameter

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality

  @Regression29 @CTCP-4192
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user add Damage density widget and verify widget is displayed

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality

  @Regression30 @CTCP-4194
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user add a belt focused dashboard

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality

  @Regression31 @CTCP-4195
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Iot_Dashboard_New
  Scenario: Verify user should be able to edit the belt focused dashboard

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to iot dashboard list screen
    And   Navigate to the iot dashboard '${DashboardName}'
    Then  Verify newly created widget {WidgetName}
    Then  Verify the monitoring device {MonitoringDevice} configured for widget
    Then  Verify the expand widget functionality for {WidgetName} and {MonitoringDevice}
    Then  Verify the info widget functionality for {WidgetName}
    Then  Verify the more widget functionality