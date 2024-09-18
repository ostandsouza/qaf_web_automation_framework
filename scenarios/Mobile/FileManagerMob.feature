Feature: Regression Flow for Mob

  @CTCP-2137
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:FileManager_Details
  Scenario: Navigate to file Manager

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Click on conveyor card in the home page
    And Search and verify '${ConveyorName}' is present
    And Navigate to conveyor details screen
    And Verify the contents in FileManager card
    And Click on FileManager card in the conveyor page
    And Verify navigation to FileManager Page '${ConveyorName}'

  @CTCP-2142
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:FileManager_Details
  Scenario: Verify folders view content & functionality

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Click on conveyor card in the home page
    And Search and verify '${ConveyorName}' is present
    And Navigate to conveyor details screen
    And Click on FileManager card in the conveyor page
    And Verify type displayed FileManager Page for folder view
    And Verify default folders present in FileManager Page
    And Verify grid and list view in FileManager Page
    And Navigate to sub folder and verify breadcrumb in File Manager Page

  @CTCP-2146
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:FileManager_Details
  Scenario:  Verify cancel button functionality via long press

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Click on conveyor card in the home page
    And Search and verify '${ConveyorName}' is present
    And Navigate to conveyor details screen
    And Click on FileManager card in the conveyor page
    And Look for files/folders and long press on a file and very it is selected
    And Look for the popup displayed in footer and verify share move delete and cancel buttons are visible
    And Click and Verify Cancel button for file manager