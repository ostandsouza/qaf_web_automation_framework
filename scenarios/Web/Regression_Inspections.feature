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

    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Navigate to Add Inspection screen from list screen
    Then  Verify placeholder for inspection name
    And   Enter inspection name as '${InspectionName}'
    And   Verify default date in inspection date field
    And   Verify auto-population of inspector name '${Inspector}'
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
    And   Verify default Site selection '${CustSiteName}'
    And   Verify auto-population of inspector name '${Inspector}'


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
    And   Verify default Site selection '${CustSiteName}'
    And   Verify auto-population of inspector name '${Inspector}'


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
    And   Verify default Site selection '${CustSiteName}'
    And   Verify auto-population of inspector name '${Inspector}'

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify add all new items in inspection and close

     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}'
     And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify a delete inspection in inspection page

     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     When  Delete inspection item '${ConveyorName}' from inspection list
     Then  Verify inspection item '${ConveyorName}' is deleted from inspection list


@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddSiteInspection
Scenario: Verify success message after saving inspection event

     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}'
     And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'


 @Regression24
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Inspection_AddSiteInspection
 Scenario: Verify success message after updating inspection event

      When  Navigate to site details for site '${CustSiteName}'
      Then  Verify navigation to inspection tile
      And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}'
      And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}' '${lat}' '${long}' '${observation}' '${recommendation}' '${address}' '${img}'


 @Regression25
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Inspection_AddSiteInspection
 Scenario: Verify map location at inspection list

     When  Navigate to site details for site '${CustSiteName}'
     Then  Verify navigation to inspection tile
     And   Navigate to Add Inspection screen from list screen


 @Regression25
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:InspectionItem_Edit
 Scenario: Verify a edit inspection event

    When  Navigate to site details for site '${CustSiteName}'
    Then  Verify navigation to inspection tile
    And   Edit inspection Item status for '${ConveyorName}' to '${EditStatus}' from list view
    Then  Verify the status changes '${EditStatus}' for '${ConveyorName}'


@Regression32 @CTCP-26546
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able to open the inspections from the corporate level

  And Click on corporates and open corperate '${Corporate}'
  Then Click on inspections and verify user is able to open inspections

@Regression32 @CTCP-26576
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able to see number of inspection items in condition

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  And Click on corporates and open corperate '${Corporate}'
  Then Click on inspections and verify user is able to open inspections
  And Click on inspection dashboard symbol and verify user is able to click on dashboard
  And Verify number of inpection items for '${Total}' '${Critical}' '${Poor}' '${Fault}' '${Good}'

@Regression32 @CTCP-26706
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able select the multiple sites via drop down

    And Click on corporates and open corperate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on site dropdown and verify user is able to select multiple site '${SiteName}' '${SiteName2}'

@Regression26 @CTCP-724
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Navigation
Scenario: ZVerify the breadcrumb of the page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to inspection list screen and wait for data load
    Then Verify the breadcrumb of the page


@Regression27 @CTCP-747
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddConveyor
Scenario: Verify delete button functionality in add files section

    And Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And Click on add new button and verify that add files to upload section is visible
    When Click on select files to upload image
    Then Select the image '${imgName}' to upload and verify user is able to upload the image
    And Verify that the loader is visible and selected image is displayed in the section
    And Verify delete button is visible and click on delete button
    And Verify that selected image is deleted

@Regression30 @CTCP-748
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_BreadCrumb
Scenario: Verify breadcrumb of inspection

       And Navigate to Inspection detail page of the InspectionEvent '${InspectionEvent}'
       Then Click on conveyor '${ConveyorName}' name in breadcrumb anf verify it navigates to conveyor technical data screen
       And Click on Inspection tile and verify it displays only corresponding conveyor '${ConveyorName}' inspections
       And Click on site name '${CustSiteName}' in breadcrumb anf verify it navigates to site page
       And Click on Inspection tile and verify it displays only corresponding site '${CustSiteName}' inspections
       And Click on corporate name '${CustCorp}' in inspection breadcrumb anf verify it navigates to corporate page
       And Click on Inspection tile and verify it displays only corresponding corporate '${CustCorp}' inspections
       And Click on corporates breadcrumb and verify it navigates to corporate page

 @Regression26 @CTCP-773
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Inspection_Navigation
  Scenario: ZVerify Inspection tile on home screen

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Navigate to inspection list screen and wait for data load
    Then Verify inspection total count is displayed
    Then Verify number of the to be completed inspection is displayed

@Regression28 @CTCP-788
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ExportFunction
Scenario: Verify Export functionality under Inspection details screen.


    And Navigate to Inspection detail page of the InspectionEvent '${InspectionEvent}'
    And Search for the InspectionItem '${ConveyorName}'
    Then Click on Export Button of InspectionItem and verify user is able to download pdf

  @Regression26 @CTCP-789
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Inspection_Navigation_Status
  Scenario: Verify inspection item status value after view button is clicked

    And   Navigate to inspection list screen and wait for data load
    When  Navigate to the inspection details screen for '${Inspection}'
    Then Extract inspection item status value for '${Conveyor}'
    And Click on the view button
    Then Verify the inspection item status value

  @Regression26 @CTCP-790
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Inspection_Navigation_Status
  Scenario: Verify inspection item condition value after view button is clicked

    And   Navigate to inspection list screen and wait for data load
    When  Navigate to the inspection details screen for '${Inspection}'
    Then Extract inspection item condition value for '${Conveyor}'
    And Click on the view button
    Then Verify the inspection item condition value

@Regression29 @CTCP-791
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_ImageFunctionality
Scenario: Verify uploaded image under inspection item

       And Navigate to Inspection detail page of the InspectionEvent '${InspectionEvent}'
       And Search for the InspectionItem '${ConveyorName}'
       Then Click on view icon and verify the uploaded image is visible


  @Regression26 @CTCP-792
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Inspection_AddEvent_SiteInspection
  Scenario: Verify Duplicate inspections under inspection list

    And   Navigate to inspection list screen and wait for data load
    And   Add the inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    Then  Navigate to inspection list screen and wait for data load
    And   Add the inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    Then  Navigate to inspection list screen and wait for data load
    Then Verify duplicate inspection event for '${InspectionName}'
    When  Delete inspection item '${InspectionName}' from inspection list
    When  Delete inspection item '${InspectionName}' from inspection list
    Then  Verify inspection item '${InspectionName}' is deleted from inspection list


@Regression32 @CTCP-2655
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Zverify user is able click on the dashboard symbol

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard

@Regression32 @CTCP-2656
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able to see the cards conditions

    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Verify user is able to see the cards

@Regression32 @CTCP-2669
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able select the site via dropdown


    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on site dropdown and verify user is able to select a site '${SiteName}'


@Regression32 @CTCP-2956
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify the Actions button by default under inspection dashboard page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Verify actions button is present and is enabled by default

@Regression32 @CTCP-2957
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify the values under Actions dropdown button.


    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on actions dropdown button and verify 'export button' with PDF symbol is visible

@Regression32 @CTCP-2958
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: ZClick on 'Export PDF' value from Actions button and verify the functionality.

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on Export PDF button and verify PDF is downloaded for company '${Corporate}'

@Regression32 @CTCP-2960
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: ZVerify that the particular selected site is visible under Exported PDF.

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on site dropdown and verify user is able to select a site '${SiteName}'
    And  Click on Export PDF button and verify PDF is downloaded for company '${Corporate}'
    And Verify that the selected site for '${SiteName}' and company '${Corporate}' is visible under downloaded PDF under Site Selection

@Regression32 @CTCP-2961
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify all sites are visible under exported PDF When user did not select any particular site under site selection

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And  Click on Export PDF button and verify PDF is downloaded for company '${Corporate}'
    And Verify that the selected site for '${AllSiteName}' and company '${Corporate}' is visible under downloaded PDF under Site Selection

@CTCP-2654
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able to open the inspections from the corporate level

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  And Navigate to Corporate details screen for corporate '${Corporate}'
  Then Click on inspections and verify user is able to open inspections

@CTCP-2657
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able to see number of inspection items in condition

  Given User is at Login page
  When Login with '${UserName}' and '${Password}'
  And Navigate to Corporate details screen for corporate '${Corporate}'
  Then Click on inspections and verify user is able to open inspections
  And Click on inspection dashboard symbol and verify user is able to click on dashboard
  And Verify number of inpection items for '${Total}' '${Critical}' '${Poor}' '${Fault}' '${Good}'

@CTCP-2670
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Dashboard
Scenario: Verify user is able select the multiple sites via drop down

    Given User is at Login page
     When Login with '${UserName}' and '${Password}'
    And Navigate to Corporate details screen for corporate '${Corporate}'
    Then Click on inspections and verify user is able to open inspections
    And Click on inspection dashboard symbol and verify user is able to click on dashboard
    And Click on site dropdown and verify user is able to select multiple site '${SiteName}' '${SiteName2}'