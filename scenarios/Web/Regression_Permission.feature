Feature: Regression for Login feature

  Background:
  Launch the application through '/'

  @Regression1
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission
  Scenario: Verify only view permission for user account for site module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify card display in home screen for basic permission
    Then Verify option display in left navigation menu
    Then Verify only view permission right for site '${siteName}'
    Then Verify only view permission right for corporate '${CorporateName}'
    And  Navigate to Corporate details screen for corporate '${CorporateName}'
    Then Verify card display in corporate details screen
    Then Verify add corporate button from corporate details screen for site view permission
    Then Verify only view permission right for CoverWear '${ConveyorName}'
    Then Verify only view permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view permission right for measurement Details screen '${ConveyorName}'
    Then Verify only view permission right for conveyors '${ConveyorName}'
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify conveyor detail screen card display
    And  User clicks on Conveyor History
    Then User should not see dropdown with belt failure options for view rights


  @Regression2
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_1
  Scenario: Verify view and add permission for user account for site module
    Given Login with '${UserName}' and '${Password}'
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
    Then Verify only view and add permission right for site '${siteName}'
    Then Verify only view permission right for corporate '${CorporateName}'
    And  Navigate to Corporate details screen for corporate '${CorporateName}'
    Then Verify card display in corporate details screen
    And  Navigate to add corporate from corporate details screen
    Then Verify type of company dropdown contents for only site permission
    Then Verify only view permission right for CoverWear '${ConveyorName}'
    Then Verify only view permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view permission right for measurement Details screen '${ConveyorName}'
    Then Verify only view permission right for conveyors '${ConveyorName}'
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify conveyor detail screen card display
    And  User clicks on Conveyor History
    Then User should not see dropdown with belt failure options for view rights

  @Regression3
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_2
  Scenario: Verify view and edit permission for user account for site module
    Given Login with '${UserName}' and '${Password}'
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
    Then Verify only view and edit permission right for site '${siteName}'
    Then Verify only view permission right for corporate '${CorporateName}'
    And  Navigate to Corporate details screen for corporate '${CorporateName}'
    Then Verify card display in corporate details screen
    Then Verify add corporate button from corporate details screen for site view permission
    Then Verify only view permission right for CoverWear '${ConveyorName}'
    Then Verify only view permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view permission right for measurement Details screen '${ConveyorName}'
    Then Verify only view permission right for conveyors '${ConveyorName}'
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify conveyor detail screen card display
    And  User clicks on Conveyor History
    Then User should not see dropdown with belt failure options for view rights

  @Regression4
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_3
  Scenario: Verify view add edit and delete permission for user account for site module
    Given Login with '${UserName}' and '${Password}'
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
    Then Verify only view permission right for CoverWear '${ConveyorName}'
    Then Verify only view permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view permission right for measurement Details screen '${ConveyorName}'
    Then Verify only view permission right for conveyors '${ConveyorName}'
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify conveyor detail screen card display
    And  User clicks on Conveyor History
    Then User should not see dropdown with belt failure options for view rights

  @Regression5
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_4
  Scenario: Verify view and edit permission for user account for conveyor module
#    Given Login with '${UserName}' and '${Password}'
#    When User clicks on Users link present in navigation bar
#    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
#    Then Reset all permissions
#    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
#    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
#    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
#    Then Click on Update btn
#    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view and edit permission right for conveyors '${ConveyorName}'
    Then Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify Edit button is visible on details screen

  @Regression6
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_5
  Scenario: Verify view and Delete permission for user account for conveyor module
    Given Login with '${UserName}' and '${Password}'
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
    Then Verify only view and delete permission right for conveyor '${ConveyorName}'

  @Regression7
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_6
  Scenario: Verify view and Add permission for user account for conveyor module
    Given Login with '${UserName}' and '${Password}'
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

  @Regression8
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_7
  Scenario: Verify view and Download permission for user account for conveyor module
    Given Login with '${UserName}' and '${Password}'
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
    Then Verify only view and download permission right for conveyor '${ConveyorName}'

  @Regression9
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_8
  Scenario: Verify view and edit permission for user account for corporate module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view and edit permission right for corporate '${CorporateName}'
    Then Verify edit button visible on Corp Details Page '${CorporateName}'


  @Regression10
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_9
  Scenario: Verify view and delete permission for user account for corporate module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view and delete permission right for corporate '${CorporateName}'


  @Regression11
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_10
  Scenario: Verify view permission for user account for corporate module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view permission right for corporate '${CorporateName}'


  @Regression12
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_11
  Scenario: Verify view permission for user account for inspection module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then wait for conveyors to load
    Then Verify only view permission right for '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'

  @Regression13
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_12
  Scenario: Verify view and edit permission for user account for inspection module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then wait for conveyors to load
    Then Verify only view and edit permission right for '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'


  @Regression14
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_13
  Scenario: Verify view and add permission for user account for inspection module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then wait for conveyors to load
    Then Verify only view and add permission right for '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'

  @Regression15
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_13.5
  Scenario: Verify view and delete permission for user account for inspection module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then wait for conveyors to load
    Then Verify only view and delete permission right for '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'

  @Regression16
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_14
  Scenario: Verify only view permission for user account for cover wear module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view permission right for CoverWear '${ConveyorName}'
    Then Verify only view permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view permission right for measurement Details screen '${ConveyorName}'

  @Regression17
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_15
  Scenario: Verify only view and add permission for user account for cover wear module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view & add permission right for CoverWear '${ConveyorName}'
    Then Verify only view and add permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view and add permission right for measurement Details screen '${ConveyorName}'

  @Regression18
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_16
  Scenario: Verify only view and edit permission for user account for cover wear module
    Given Login with '${UserName}' and '${Password}'
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

  @Regression19
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_17
  Scenario: Verify only view and delete permission for user account for cover wear module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view & delete permission right for CoverWear '${ConveyorName}'
    Then Verify only view and delete permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view and delete permission right for measurement Details screen '${ConveyorName}'

  @Regression20
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_18
  Scenario: Verify only view and download permission for user account for cover wear module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then Verify only view & download permission right for CoverWear '${ConveyorName}'
    Then Verify only view and download permission right for CoverWear Details screen '${ConveyorName}'
    Then Verify only view and download permission right for measurement Details screen '${ConveyorName}'

  @Regression21
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_19
  Scenario: Verify only view permission for user account for conveyor history module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then user clicks on conveyor view arrow
    Then User clicks on Conveyor History
    Then User clicks on add button
    Then User should  not see dropdown with belt failure Options

  @Regression22
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_20
  Scenario: Verify only view and add permission for user account for conveyor history module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then user clicks on conveyor view arrow
    Then User clicks on Conveyor History
    Then User clicks on add button
    Then User should see dropdown with Options

  @Regression23
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Regression_Permission_21
  Scenario: Verify no view permission for user account for conveyor history module
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Search '${FullName}' User on List page and then edit the same and navigate to permission screen
    Then Reset all permissions
    Then Add permission rights under '${MainModule}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule1}' with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Update user
    Then Add permission rights under '${MainModule2}' '${SubModule}' with '${Add1}' '${Edit1}' '${Delete1}' '${View1}' '${Download1}' and Update user
    Then Click on Update btn
    Then Click on profile and select logout button
    Then Login with '${MktMgrUser}' and '${Password1}'
    Then user clicks on conveyor view arrow
    Then Conveyor History card is not visible

