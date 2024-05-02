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

@Regression17 @CTCP-1866
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: Verify with add conveyor navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    Then Verify Conveyor horizontal navigation bar
    And Verify on click of conveyor nagivation bar nagivates to respective pages

@Regression18 @CTCP-1870
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: Verify closing of image viewer panel

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    Then Verify the default image is displayed and on hover camera icon is displayed
    And Verify on click of cameraIcon the Image viewer panel is displayed with upload preview cancel and save button
    When User clicks on Upload Image
    Then Verify that the user is able to upload the image '${imgName}' from the system
    And User clicks on cancel button
    And Verify that the image viewer panel is closed and image is not uploaded

@Regression19 @CTCP-1919
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: Verify the save as draft button on remarks tab

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustShopName}' with mandatory field
    Then Go to remarks and click on save as button


@Regression20 @CTCP-1921
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Count
Scenario: Verify user is able to get the count after deleting the conveyor

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorNameGer}' and '${DistShopGerName}' and '${CustShopGerName}'
    And Extract the conveyor count from conveyor list page
    Then  Delete Conveyor from Conveyor list screen '${ConveyorName1}'
    And  Verify Deleted Conveyor '${ConveyorName1}' from Conveyor list screen
    And Verify the conveyor count from conveyor list page


@Regression21 @CTCP-1923
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: Verify user is able to see the metric data when metric radio button is selected

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustShopName}' with mandatory field
    Then Add data value in header as metric
    And Verify data value in header as '${Unit}' in Add Conveyor
