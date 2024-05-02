Feature: Regression of P1 Conveyor module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation
Scenario: Verify with add conveyor navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Add Conveyor screen

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_create
Scenario: Verify the creation of new conveyor

    When  Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustSiteName}' with '${ImageName}'

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify the conveyor tab in add conveyor screen

    When  Navigate to Add Conveyor screen
    Then  verify all fields in conveyor tab

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify the actions dropdown list

    Then  Verify the actions dropdown for conveyor with '${ConveyorName}'

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation
Scenario: Verify navigation to conveyor list

    When  Navigate to conveyor list screen

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify navigation to add conveyor from list screen

    Then  Navigate to Add Conveyor screen from list screen

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify navigation from conveyor list to conveyor details screen

    When  Navigate to conveyor details screen for conveyor '${ConveyorName}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_imageUpload
Scenario: Verify image upload functionality

    When  Navigate to Add Conveyor screen
    Then  Verify image upload functionality with '${ImageName}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify for the tiles in conveyor details screen

   When  Navigate to conveyor details screen for conveyor '${ConveyorName}'
   Then  Verify all the tiles in conveyor detail screen

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify export csv file for conveyor

    When  Export CSV data for '${ConveyorName}'

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Details
Scenario: Verify export PDF file for conveyor

    When  Export PDF for '${ConveyorName}'

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_edit
Scenario: Verify editing the conveyor details

    When  Edit Conveyor '${ConveyorName}' from conveyor list screen to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${CustSiteName}'

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_edit
Scenario: Verify conveyor delete functionality from list

    When  Delete Conveyor from Conveyor list screen '${EditConveyorName}'
    Then  Verify Deleted Conveyor '${EditConveyorName}' from Conveyor list screen

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout
Scenario: Verify a user is able to add new layout

    Then  verify user '${UserName}' is able to add new layout for '${Corporates}' '${BeltWidth}' '${Rating}' '${Length}' with '${Layout_Name}'

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout
Scenario: Verify a user is able to Get selected layout post re-login

    When  Navigate to conveyor list screen
    Then  Verify user is able see saved preference
    When  Click on profile and select logout button
    When  Login with '${UserName}' and '${Password}'
    Then  Verify user is able see saved preference

@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout
Scenario: Verify a user is able to Delete layout

    Then  verify user is able to delete layout for '${Layout_Name}'

@Regression17 @CTCP-1865
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserManagement_Master
Scenario: Verify Bread Crumb of the page

     Given User is at Login page
     When Login with '${UserName}' and '${Password}'
     And  Navigate to Add Conveyor screen
     Then Verify the bread crumb of add conveyor page

@Regression18 @CTCP-1868
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_coordinates
Scenario: Selection of head and tail coordinates

     Given User is at Login page
     When Login with '${UserName}' and '${Password}'
     And  Navigate to Add Conveyor screen
     Then Verify that  GPS Coordinates Head and GPS Coordinates Tail with lat and long is visible
     When User selects a site '${SiteName}' from the dropdown
     Then Verify that map should display the location of site '${SiteName}'
     And Zoom in and out to reach conveyor location
     And Click on map to set position of head and verify prefilled value for lat and long is displayed
     When Click on location type and select head value from the dropdown
     Then Click on add marker button and verify GPS Coordinates Head is updated with lat long value
     And Click on map to set position of tail and verify prefilled value for lat and long is displayed
     When Click on location type and select tail value from the dropdown
     Then Click on add marker button and verify GPS Coordinates Tail is updated with lat long value

@Regression19 @CTCP-1924
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Duplicate
Scenario: Validation duplicate on Conveyor Name


          Given User is at Login page
          When Login with '${UserName}' and '${Password}'
          And  Navigate to Add Conveyor screen
          When Create a new conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
          And Navigate to conveyor list screen and search for the created conveyor '${ConveyorName1}'
          When Create a duplicate conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
          Then Verify that user should get an error message while creating duplicate conveyor

@Regression20 @CTCP-1918
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: verify the save and close button on remarks tab

          Given User is at Login page
          When Login with '${UserName}' and '${Password}'
          And  Navigate to Add Conveyor screen
          When Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
          And Click on remarks radio button and click on save and close
          Then Verify that user should get conveyor site card


@Regression21 @CTCP-1920
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: verify user is able to click the previous button

          Given User is at Login page
          When Login with '${UserName}' and '${Password}'
          And  Navigate to Add Conveyor screen
          When Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
          And Click on remarks radio button and click on previous button
          Then Verify user is navigated to transitions add page

@Regression22 @CTCP-1922
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: Verify user is able to see the imperial data when imperial radio button is selected

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
    Then Add data value in header as imperial
    And Verify data value in header as '${Unit}' in Add Conveyor



