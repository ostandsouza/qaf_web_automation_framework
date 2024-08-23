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

@CTCP-3274
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Navigate to Add conveyor via Home page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Verify user present in home screen
  Then Navigate to add conveyor page via Home and verify navigation

@CTCP-3276
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario:Verify Navigate fields displayed in header

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Click on conveyor symbol and verify it navigates to conveyor list page
  Then Navigate to add conveyor page via Conveyor List page and verify navigation
  And Go back from conveyor details screen
  And Verify user present in conveyor list screen

@CTCP-3279
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify Distributor shop field

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Verify user present in home screen
    Then Navigate to add conveyor page via Home and verify navigation
    And Click on distributor shop dropdown and verify search option
    And Search and select the distributor Shop '${DistShop}'









