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
@key:Inspection_AddEvent
Scenario: Verify the add button functionality

    When  Navigate to inspection list screen
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Verify default date in inspection date field
    And   Verify Site '${CustSiteName}' selection from dropdown
    And   Verify auto-population of inspector name '${Inspector}'
    And   Verify user is able to select collaborator '${Collaborator}'
    And   Verify all the default tile value displayed as '${DefaultVal}'
    And   Verify user is able to enter text '${Text}' in summary field
    And   Verify user is able to maximize the summary window size
    And   Verify the add new button is disabled

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Create
Scenario: Verify the add button functionality with save

    When  Add inspection Event for conveyor '${InspectionName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status2}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName3}' '${AssetDetail3}' '${FailureMode3}' '${Condition3}' '${Status2}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName4}' '${AssetDetail4}' '${FailureMode4}' '${Condition4}' '${Status2}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'


@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Count
Scenario: Verify count functionality at tiles

    When  Navigate to the inspection details screen for '${InspectionName}'
    Then  Verify tile count '${TotalCount}' for critical poor fault good and completed '${Val}'

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Download
Scenario: Verify download report from grouped inspection view

    When  Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify data displayed in report for '${FullName}' '${CustSiteName}' '${ConveyorName}' '${InspectionName}'

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Create
Scenario: Verify image upload functionality

    When  Verify the uploaded image in inspection grouped view for '${InspectionName}'
    Then  Verify the uploaded image in inspection list view for '${ConveyorName}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Edit
Scenario: Verify Inspection Event edit functionality

    When  Verify the actions button is disabled
    Then  Verify after select inspection '${InspectionName}' action button is enabled
    And   Verify the contents of action dropdown
    And   Navigate to edit inspection Event and verify the breadcrumb
    When  Edit Inspection event to '${EditInspectionName}' and inspector name to '${EditInspectorName}'
    Then  Verify the changes '${EditInspectorName}' for Inspection event '${EditInspectionName}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:InspectionItem_Edit
Scenario: Verify Inspection Item edit functionality

    And   Edit inspection Item status for '${ConveyorName}' to '${EditStatus}' from list view
    Then  Verify the status changes '${EditStatus}' for '${ConveyorName}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Edit
Scenario: Verify Delete inspection item

   When  Delete inspection item '${ConveyorName}' from inspection list
   Then  Verify inspection item '${ConveyorName}' is deleted from inspection list

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Edit
Scenario: Verify Delete inspection event

   When  Delete inspection '${EditInspectionName}' from inspection list
   Then  Verify inspection '${EditInspectionName}' is deleted from inspection list

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify the site inspection flow

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${Inspector}'
    And   Verify user is able to select collaborator '${Collaborator}'
    And   Verify all the default tile value displayed as '${DefaultVal}'
    And   Verify user is able to enter text '${Text}' in summary field
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify site inspection navigation

    And   Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then  Verify navigation to inspection tile


@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify site inspection page

    And   Navigate to conveyor details screen for conveyor '${ConveyorName}'
    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Verify default date in inspection date field
    And   Verify Site '${CustSiteName}' selection from dropdown
    And   Verify auto-population of inspector name '${Inspector}'
    And   Verify user is able to select collaborator '${Collaborator}'


@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify site sections for inspection details page

    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Verify default date in inspection date field
    And   Verify Site '${CustSiteName}' selection from dropdown
    And   Verify auto-population of inspector name '${Inspector}'
    And   Verify user is able to select collaborator '${Collaborator}'


@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify site condition for inspection dashboard section page

    When  Navigate to the inspection details screen for '${InspectionName}'
    Then  Verify tile count '${TotalCount}' for critical poor fault good and completed '${Val}'


@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify default tab for inspection dashboard section page

    When  Navigate to the inspection details screen for '${InspectionName}'
    Then  Verify tile count '${TotalCount}' for critical poor fault good and completed '${Val}'

@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify to be completed graph

    When  Navigate to inspection list screen
    Then  Verify default view type is grouped view
    And   Verify columns under group view
    And   Verify if is able to switch from group view to list view
    And   Verify the columns under list view

@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify summary text area in inspection page

     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Navigate to Add Inspection screen from list screen
     And   Verify all the default tile value displayed as '${DefaultVal}'
     And   Verify user is able to enter text '${Text}' in summary field

@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify action button functionality in inspection page

    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    When  Verify the actions button is disabled
    Then  Verify after select inspection '${InspectionName}' action button is enabled
    And   Verify the contents of action dropdown

@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify values are available at inspection level

    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Verify default date in inspection date field
    And   Verify Site '${CustSiteName}' selection from dropdown
    And   Verify auto-population of inspector name '${Inspector}'
    And   Verify user is able to select collaborator '${Collaborator}'

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify add all new items in inspection and close

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Navigate to Add Inspection screen from list screen
     And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify delete inspection in inspection page

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     When  Delete inspection item '${ConveyorName}' from inspection list
     Then  Verify inspection item '${ConveyorName}' is deleted from inspection list


@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify success message after saving inspection event

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Navigate to Add Inspection screen from list screen
     And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'


 @Regression24
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Inspection_AddSiteInspection
 Scenario: Verify success message after updating inspection event

      Given User is at Login page
      When  Login with '${UserName}' and '${Password}'
      When  Navigate to site details for site '${CustSiteName}'
      Then  Verify navigation to inspection tile
      And   Navigate to Add Inspection screen from list screen
      And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'


 @Regression25
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Inspection_AddSiteInspection
 Scenario: Verify map location at inspection list

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Navigate to Add Inspection screen from list screen


 @Regression25
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Inspection_AddSiteInspection
 Scenario: Verify edit inspection event

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
    And   Edit inspection Item status for '${ConveyorName}' to '${EditStatus}' from list view
    Then  Verify the status changes '${EditStatus}' for '${ConveyorName}'