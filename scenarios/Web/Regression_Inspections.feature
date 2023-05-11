Feature: Regression of P1 Inspection module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: Verify with inspection navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then  Verify navigation to inspection tile

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: Verify the view type in inspection list

    When  Navigate to inspection list screen
    Then  Verify default view type is grouped view
    And   Verify columns under group view
    And   Verify if is able to switch from group view to list view
    And   Verify the columns under list view

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: Verify the add button functionality

    When  Navigate to inspection list screen
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Verify default date in inspection date field
    And   Verify conveyor '${ConveyorName}' selection from dropdown
    And   Verify auto-population of inspection name '${ConveyorName}'
    And   Verify user is able to select collaborator '${ConveyorName}'
    And   Verify all the default tile value displayed as '0'
    And   Verify user is able to enter text in summary field
    And   Verify user is able to maximize the summary window size
    And   Verify the add new button is enabled/disabled

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Create
Scenario: Verify the add button functionality with save

    When  Add inspection Event for conveyor '${InspectionName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'


@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Create
Scenario: Verify the count functionality at tiles

    When  Navigate to the inspection details screen for '${InspectionName}'
    Then  Verify tile count for critical poor fault good and completed

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Edit
Scenario: Verify the count functionality at tiles

    When  Edit inspection Event from '${InspectionName}' to '${EditInspectionName}'
    And   Edit inspection Item status for '${ConveyorName}' to '${EditStatus}'