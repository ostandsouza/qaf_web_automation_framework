@Regression1 @CTCP-3275
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Navigate to Add conveyor via conveyor list page

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify that the conveyor tile is visible in home page and click on it
    And Click on add button in conveyor list page and verify it navigates to add conveyor page


@Regression2 @CTCP-3278
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Add_ConveyorMob
Scenario: Verify conveyor name field

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then  Navigate to the Add Conveyor Page with '${ConveyorName}'
    And Add conveyor with '${ConveyorName}' '${CustSiteName}' '${DistShopName}'
    Then  Navigate to the Add Conveyor Page with '${ConveyorName}'
    And Add conveyor without conveyorName '${CustSiteName}' '${DistShopName}'

@Regression3 @CTCP-3280
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Add_ConveyorMob
Scenario: Verify customer site field

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then  Navigate to the Add Conveyor Page with '${ConveyorName}'
    And Add Conveyor with distributor '${ConveyorName}' '${DistShopName}' '${CustSiteName}'









