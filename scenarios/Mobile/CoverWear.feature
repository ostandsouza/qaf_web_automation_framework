@Regression1 @CTCP-2442
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Navigation
Scenario: Verify Add Site back button functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify user is on home page by default
    And Verify that the conveyor tile is visible in home page and click on it
    And Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to conveyor home page
    And Click on coverWear tile and verify user is navigated to Add New Screen

@Regression2 @CTCP-2451
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDel
Scenario: Verify delete position via header three dots

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    And Click on coverWear card in the home page
    And Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to position listing screen
    And  Long press on the position '${Position}' and click on checkbox and verify it is selected
    And Click on three dots and select delete option and verify the position '${Position}' is deleted

@Regression3 @CTCP-2443
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDel
Scenario: Verify count of measurement on cover wear tile on Home page

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    And Look for the cover Wear tile and verify the count displayed

@Regression4 @CTCP-2444
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Measurement
Scenario: Verify position screen in case measurement already done

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    And Click on coverWear card in the home page
    And Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to position listing screen
    And Verify the gauge tile is present at the top and all the details are displayed in the tile
    And Verify top/bottom position status and values displayed along the position

@Regression5 @CTCP-2445
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_SpecDetails
Scenario: Verify cover wear specification in case conveyor technical data present

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    And Click on coverWear card in the home page
    And Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to position listing screen
    And Click on the gauge tile in the position screen and navigate to specification screen
    And Verify that siteName '${SiteName}' conveyor '${ConveyorName}' beltWidth '${BeltWidth}' BeltLength '${BeltLength}' comes with default values and are non editable

@Regression6 @CTCP-2456
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_PositionDetails
Scenario: Verify position detail screen

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    And Click on coverWear card in the home page
    And Search for a conveyor '${ConveyorName}' and click on it and verify it navigates to position listing screen
    And Click on any of the position '${position}' and verify it navigates to position details screen and verify the heading
    And Verify temperature adjusted measurements header and default installation field with measurement date and edit link are visible
    And Click on the edit button and verify user is able is edit installation '${Instrument}' '${Velocity}' '${SurfaceTension}' and verify user can delete measurement


