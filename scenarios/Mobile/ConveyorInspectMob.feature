Feature: Regression Flow for Conveyor Inspect

@Regression1 @CTCP-2704
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Navigation
Scenario: Verify the conveyor level navigation for conveyor inspect

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'

@Regression2 @CTCP-2705
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify conveyor level navigation from site level conveyor inspect

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'

@Regression3 @CTCP-2706
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the company dashboard is selected as default tab

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify user is on company site dashboard

@Regression4 @CTCP-2707
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the last updated date from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify last update date from company dashboard '${Conveyor}'

@Regression5 @CTCP-2708
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the graph from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify graph from company dashboard '${Conveyor}'

@Regression6 @CTCP-2709
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the temperature from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify temperature range from company dashboard '${Conveyor}'


@Regression7 @CTCP-2710
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the trend analysis

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify trend analysis on second screen

@Regression8 @CTCP-2711
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify maintenance action on second screen

@Regression9 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action expand functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action expand functionality

@Regression10 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action max idler and env temp

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action max temperature functionality

@Regression11 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action got that fixed button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality

@Regression12 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action undo button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality


@Regression13 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action undo button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality

@Regression14 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the upload files button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation

@Regression15 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the site and conveyor dropdown from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify site {SiteName} is selected
    And   Verify conveyor {ConveyorName} is selected

@Regression16 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the date of flight from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify date of flight is selected

@Regression17 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the time of flight from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify time of flight is selected

@Regression18 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the side selection from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify side is selected

@Regression19 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the color map selection from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify color map is selected

@Regression20 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify cancel image upload functionality from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify conveyor '${ConveyorName}' is selected
    And   Verify date of flight is selected
    And   Verify time of flight is selected
    And   Verify side is selected
    And   Verify color map is selected
    And   Verify cancel button functionalityUpload {irImage} and {rgbImage} images

@Regression211 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify image upload functionality from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Upload '${irName}' and '${rgbName}' images
    And   Verify conveyor '${ConveyorName}' is selected
    And   Verify date of flight is selected
    And   Verify time of flight is selected
    And   Verify side is selected
    And   Verify color map is selected
    And   Verify conveyor inspect upload image form saved successfully

@Regression212 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify single image upload functionality from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Upload only '${irName}' image
    And   Verify conveyor '${ConveyorName}' is selected
    And   Verify date of flight is selected
    And   Verify time of flight is selected
    And   Verify side is selected
    And   Verify color map is selected
    And   Verify error message when incomplete form is submitted


@Regression21 @CTCP-2704
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Navigation
Scenario: Verify the conveyor level navigation for conveyor inspect

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'

@Regression22 @CTCP-2705
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify conveyor level navigation from site level conveyor inspect

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'

@Regression23 @CTCP-2706
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the company dashboard is selected as default tab

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify user is on company site dashboard

@Regression24 @CTCP-2707
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the last updated date from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify last update date from company dashboard '${Conveyor}'

@Regression25 @CTCP-2708
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the graph from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify graph from company dashboard '${Conveyor}'

@Regression26 @CTCP-2709
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Inspection
Scenario: Verify the temperature from company dashboard

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify temperature range from company dashboard '${Conveyor}'


@Regression27 @CTCP-2710
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the trend analysis

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify trend analysis on second screen

@Regression28 @CTCP-2711
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Navigate to conveyor inspect list and go to site level details '${CustSiteName}'
    And   Navigate to inspection tab from site level
    And   Navigate from inspection list to conveyor level inspect '${ConveyorName}'
    And   Verify maintenance action on second screen

@Regression29 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action expand functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action expand functionality

@Regression30 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action max idler and env temp

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action max temperature functionality

@Regression31 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action got that fixed button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality

@Regression32 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action undo button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality


@Regression33 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_Findings
Scenario: Verify the maintenance action undo button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify maintenance action on second screen
    And   Verify maintenance action got that fixed functionality

@Regression34 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the upload files button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And   Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation

@Regression35 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the site and conveyor dropdown from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify site {SiteName} is selected
    And   Verify conveyor {ConveyorName} is selected

@Regression36 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the date of flight from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify date of flight is selected

@Regression37 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the time of flight from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify time of flight is selected

@Regression38 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the side selection from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify side is selected

@Regression39 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify the color map selection from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify color map is selected

@Regression40 @CTCP-2712
@dataFile:resources/data/TestData.xls
@sheetName:RegressionMob
@key:ConveyorInspect_upload
Scenario: Verify cancel image upload functionality from upload files

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    When  Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    Then  Verify navigation to conveyor inspect from conveyor details '${ConveyorName}'
    And   Verify upload files button navigation
    And   Verify conveyor '${ConveyorName}' is selected
    And   Verify date of flight is selected
    And   Verify time of flight is selected
    And   Verify side is selected
    And   Verify color map is selected
    And   Verify cancel button functionality