Feature: Regression HP Belt Monitoring module

Background:
Launch the application through '/'








@Regression5
@dataFile:resources/data/BeltMonitoringHP.json
Scenario: Verify the cord protect page is displayed when clicked on IOT icon, also validate the bread crumbs for all the menu selected from the floating menu

    Given User is at Login page
    When  Login with '${UserNameMaster}' and '${Password}'
    And   Navigate to Belt Monitoring List screen
    Then  Verify the monitoring device '${DeviceName}' in list screen
    When  Navigate to cord protect iot window
    And Click on floating menu icon and verify user can get list of links
    And Click on menu item '${RipInsert}' '${RipInsertThumbNails}' and verify breadcrumb for '${DeviceName}' with '${RipInsertBreadCrumb}'
    And Click on menu item '${RipInsert}' '${RipInsertThumbNails}' and verify breadcrumb for '${DeviceName}' with '${RipInsertBreadCrumb}'

