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


@Regression21 @CTCP-1997
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Metric
Scenario: Verify user is able to edit the belt width for the metric unit Conversions

    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Verify site and coporate fields are prefilled
    Then Verify data value in header as metric
    And Edit Conveyor belt width value '${BeltWidth}'
    And Verify data value unit as '${MetricUnit}' in Add Conveyor for beltwidth
    Then Add data value in header as imperial
    And Verify data value unit as '${ImperialUnit}' in Add Conveyor for beltwidth

@Regression17 @CTCP-1865
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_coordinates
Scenario: ZVerify Bread Crumb of the page

     Given User is at Login page
     When Login with '${UserName}' and '${Password}'
     And  Navigate to Add Conveyor screen
     Then Verify the bread crumb of add conveyor page

@Regression17 @CTCP-1866
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: ZeVerify with add conveyor navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And  Navigate to Add Conveyor screen
    Then Verify Conveyor horizontal navigation bar
    And Verify on click of conveyor nagivation bar nagivates to respective pages

@Regression18 @CTCP-1868
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_coordinates
Scenario: Selection of head and tail coordinates


     And  Navigate to Add Conveyor screen
     Then Verify that  GPS Coordinates Head and GPS Coordinates Tail with lat and long is visible
     When User selects a site '${SiteName}' from the dropdown and enter conveyorName '${ConveyorName1}'
     Then Verify that map should display the location of site '${SiteName}'
     And Zoom in and out to reach conveyor location
     And Click on map to set position of head and verify prefilled value for lat and long is displayed
     When Click on location type and select head value from the dropdown
     Then Click on add marker button and verify GPS Coordinates Head is updated with lat long value
     And Click on map to set position of tail and verify prefilled value for lat and long is displayed
     When Click on location type and select tail value from the dropdown
     Then Click on add marker button and verify GPS Coordinates Tail is updated with lat long value

@Regression18 @CTCP-1870
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: ZdVerify closing of image viewer panel

    And  Navigate to Add Conveyor screen
    Then Verify the default image is displayed and on hover camera icon is displayed
    And Verify on click of cameraIcon the Image viewer panel is displayed with upload preview cancel and save button
    When User clicks on Upload Image
    Then Verify that the user is able to upload the image '${imgName}' from the system
    And User clicks on cancel button
    And Verify that the image viewer panel is closed and image is not uploaded

@Regression20 @CTCP-1918
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: Verify the save and close button on remarks tab

          And  Navigate to Add Conveyor screen
          When Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
          And Click on remarks radio button and click on save and close
          Then Verify that user should get conveyor site card

@Regression19 @CTCP-1919
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: ZbVerify the save as draft button on remarks tab

    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustShopName}' with mandatory field
    Then Go to remarks and click on save as button

@Regression21 @CTCP-1920
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: Verify user is able to click the previous button

          And  Navigate to Add Conveyor screen
          When Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
          And Click on remarks radio button and click on previous button
          Then Verify user is navigated to transitions add page


@Regression20 @CTCP-1921
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Count
Scenario: ZcVerify user is able to get the count after deleting the conveyor

    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorNameGer}' and '${DistShopGerName}' and '${CustShopGerName}'
    And Extract the conveyor count from conveyor list page
    Then  Delete Conveyor from Conveyor list screen '${ConveyorName1}'
    And  Verify Deleted Conveyor '${ConveyorName1}' from Conveyor list screen
    And  Navigate to coverWear list screen and wait for data load
    And Navigate to conveyor list screen
    And Verify the conveyor count from conveyor list page


@Regression22 @CTCP-1922
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_createDetails
Scenario: Verify user is able to see the imperial data when imperial radio button is selected

    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}' with mandatory field
    Then Add data value in header as imperial
    And Verify data value in header as '${Unit}' in Add Conveyor


@Regression21 @CTCP-1923
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Add
Scenario: ZaVerify user is able to see the metric data when metric radio button is selected

    And  Navigate to Add Conveyor screen
    And Create a conveyor with '${ConveyorName}' and '${DistShopName}' and '${CustShopName}' with mandatory field
    Then Add data value in header as metric
    And Verify data value in header as '${Unit}' in Add Conveyor

@Regression19 @CTCP-1924
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Duplicate
Scenario: Validation duplicate on Conveyor Name

          Given User is at Login page
          When Login with '${UserName}' and '${Password}'
          And  Navigate to Add Conveyor screen
          When Create a new conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
          And Logout from the current user
          When Login with '${UserName}' and '${Password}'
          And Navigate to conveyor details screen for conveyor '${ConveyorName1}'
          When Create a duplicate conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
          Then Verify that user should get an error message while creating duplicate conveyor

@Regression22 @CTCP-1994
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: ZFields displayed under Conveyor name

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    Then Verify Conveyor Name '${ConveyorName}' is displayed as heading of the page
    And Verify the fields displayed under the conveyor name with prefilled values
    And Look for site Location '${CustSiteName}' in Conveyor trails map with site location should display
    And Look for the fields displayed under technical data and verify it is non editable

@Regression23 @CTCP-1996
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: Verify conveyor location displayed in map


    When  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Verify Conveyor Name '${ConveyorName}' is displayed as heading of the page
    Then Verify that map is displayed in the Conveyor Trail
    And Look for site Location '${CustSiteName}' in Conveyor trails map with site location should display
    And Verify Conveyor Head and Tail location position is displayed in the map
    And Click on pin location of conveyor in map and verify it displays label with conveyor name and cross button

@Regression21 @CTCP-1998
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Imperial
Scenario: ZVerify user is able to edit the belt width for the Imperial unit Conversions

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Add data value in header as imperial
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Verify site and coporate fields are prefilled
    Then Verify data value in header as imperial
    And Edit Conveyor belt width value '${BeltWidth}'
#    And Edit Conveyor for page '${PageName}' for field '${FieldName}' '${FieldInput}' with value '${FieldValue}' and '${Index}'
    And Verify data value unit as '${ImperialUnit}' in Add Conveyor for beltwidth
    Then Add data value in header as metric
    And Verify data value unit as '${MetricUnit}' in Add Conveyor for beltwidth

@Regression21 @CTCP-1999
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Metric
Scenario: Verify user is able to edit the tons per hour peak for the metric unit Conversions

    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Verify site and coporate fields are prefilled
    Then Verify data value in header as metric
    And Edit Conveyor belt width value '${BeltWidth}'
    And Verify data value unit as '${MetricUnit}' in Add Conveyor for beltwidth
    Then Add data value in header as imperial
    And Verify data value unit as '${ImperialUnit}' in Add Conveyor for beltwidth


@Regression24 @CTCP-2005
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_LayoutCreate
Scenario: Verify the table layout picker


    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Verify user is able to open the popup

@Regression25 @CTCP-2007
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout_Create
Scenario: ZVerify user is able to add the layout name

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Click on text box and verify user is able to enter the layout name '${LayoutName}'


@Regression26 @CTCP-2008
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_LayoutCreate
Scenario: Verify the user should get the add button enable


    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Click on text box and verify user is able to enter the layout name '${LayoutName}'
    And Click on back button and verify user lands on table layout settings

@Regression25 @CTCP-2009
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout_Create
Scenario: Verify user is able to click the back button

    And Edit Conveyor tons per hour value '${TonsPerHour}'
    And Verify data value unit as '${MetricUnit}' in Add Conveyor for TonsPerHour
    Then Add data value in header as imperial
    And Verify data value unit as '${ImperialUnit}' in Add Conveyor for TonsPerHour

@Regression27 @CTCP-2010
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout
Scenario: ZVerify user is able to see the newly added layout

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  verify user '${UserName}' is able to add new layout for '${Corporates}' '${BeltWidth}' '${Rating}' '${Length}' with '${Layout_UserName}'
    And Click on profile and select logout button
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to conveyor list screen
    Then Verify user is able to see newly added layout

@Regression25 @CTCP-2011
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout_Create
Scenario: AVerify user is able to click the save set preferrence

    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Click on layout and verify safe set preference button


@Regression28 @CTCP-2014
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_DuplicateLayout
Scenario: Verify duplicate name of the layout


    Then  verify user '${UserName}' is able to add new layout for '${Corporates}' '${BeltWidth}' '${Rating}' '${Length}' with '${Layout_Name}'
    And Create a duplicate layout '${Corporates}' '${BeltWidth}' '${Rating}' '${Length}' with '${Layout_Name}'
    And Verify user should get an error message saying layout exists

@Regression25 @CTCP-2015
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Layout_Create
Scenario: Verify user is able to click the back button

    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Click on cross button in layout setting popUp

@Regression26 @CTCP-2016
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_LayoutCreate
Scenario: User should able to drag and drop the table Layout settings popup


    When  Navigate to conveyor list screen
    Then Click on layout picker
    And Verify user is able to open the popup
    And Mouse over the popup click and drag and verify user is able to drag and drop the popup

@Regression25 @CTCP-1957
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_List_Page
Scenario: Verify heading and column displayed in conveyor list table

    And Navigate to conveyor list screen
    And Verify Conveyor list page header as Conveyor
    Then Verify Conveyor column name
    Then  Verify Conveyor column data '${Name}' '${Site}' '${LastModified}' '${InstallBelt}' '${RemainingTime}' '${RemainingPer}'

@Regression29 @CTCP-1958
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_ColumnFilter
Scenario: ZSelect table column as per column selection filter

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    When  Navigate to conveyor list screen
    Then Verify column selection filter is visible
    And Click on the column name filter and verify searchBar all columnNames with checkbox and cross button is visible
    And Enter the columnName '${ColumnName}' in searchBar and verify all columnName with search text is displayed
    And Select the checkbox of searched column and verify only selected column is displayed in the table and column filter text box
    And Remove the entered text from the searchBar and verify all columns are displayed in the dropdown
    And Select the parent checkbox and verify all child column checkbox and all selected column is visible in the table
    And Click on cross button and verify column filter is closed

@Regression30 @CTCP-1959
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Position
Scenario: Search conveyor in conveyor list


    When  Navigate to conveyor list screen
    Then Look for the searchBar in the table and verify search icon and search placeholder is visible
    When Enter the text '${ConveyorName}' to search
    And Verify the matching result is displayed or No record found message should display
    When Enter the text '${ConveyorNameInvalid}' to search
    And Verify the matching result is displayed or No record found message should display

@Regression31 @CTCP-1962
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_ColumnFilter
Scenario: Apply and remove 'Start With' filter

    When  Navigate to conveyor list screen
    Then Hover on a column and verify filter icon is displayed
    And Click on the filter icon and verify all fields '${StartsWithFilterType}' are visible
    And Select '${StartsWithFilterType}' from filter dropdown and verify it is selected
    And Enter the text in the search text '${SearchText}' box and verify user is able to enter
    And Click on apply button and verify all results with entered text and filter '${StartsWithFilterType}' is visible in list and filter popup is closed
    And Hover over column name and verify filter icon is highlighted
    Then Click on clear button in popup and verify filter is removed


@Regression31 @CTCP-1963
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_ColumnFilter
Scenario: Apply and remove 'Contains' filter


    When  Navigate to conveyor list screen
    Then Hover on a column and verify filter icon is displayed
    And Click on the filter icon and verify all fields '${ContainsFilterType}' are visible
    And Select '${ContainsFilterType}' from filter dropdown and verify it is selected
    And Enter the text in the search text '${ContainsSearchText}' box and verify user is able to enter
    And Click on apply button and verify all results with entered text and filter '${ContainsFilterType}' is visible in list and filter popup is closed
    And Hover over column name and verify filter icon is highlighted
    Then Click on clear button in popup and verify filter is removed

@Regression32 @CTCP-1967
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_ColumnFilter
Scenario: Apply and remove ' Equals' filter


    When  Navigate to conveyor list screen
    Then Hover on a column and verify filter icon is displayed
    And Click on the filter icon and verify all fields '${ContainsFilterType}' are visible
    And Select '${EqualsFilterType}' from filter dropdown and verify it is selected
    And Enter the text in the search text '${EqualsSearchText}' box and verify user is able to enter
    And Click on apply button and verify all results with entered text and filter '${EqualsFilterType}' is visible in list and filter popup is closed
    And Hover over column name and verify filter icon is highlighted
    Then Click on clear button in popup and verify filter is removed

@Regression25 @CTCP-1986
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Imperial
Scenario: ZzVerify the unit conversions for top cover thickness on conveyor Listing screen for imperial

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Add data value in header as imperial
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Edit Conveyor top cover thickness value '${TopCoverThickness}'
    Then Navigate to conveyor list screen
    And Add filter for header with '${TopFilterName}'
    And Verify header field '${TopHeader}' is present in unit '${ImperialUnit}'
    And Add data value in header as metric
    And Verify header field '${TopHeader}' is present in unit '${MetricUnit}'

@Regression25 @CTCP-1987
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Imperial
Scenario: ZyVerify the unit conversions for bottom cover thickness on conveyor Listing screen for metric

    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Edit Conveyor bottom cover thickness value '${BottomCoverThickness}'
    Then Navigate to conveyor list screen
    And Add filter for header with '${BottomFilterName}'
    And Verify header field '${BottomHeader}' is present in unit '${MetricUnit}'
    And Add data value in header as imperial
    And Verify header field '${BottomHeader}' is present in unit '${ImperialUnit}'

@Regression25 @CTCP-1989
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Imperial
Scenario: ZvVerify the unit conversions for speed on conveyor Listing screen for metric

    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Edit Conveyor speed value '${SpeedMt}'
    Then Navigate to conveyor list screen
    And Add filter for header with '${SpeedFilterName}'
    And Verify header field '${SpeedHeader}' is present in unit '${SpeedMetricUnit}'
    And Add data value in header as imperial
    And Verify header field '${SpeedHeader}' is present in unit '${SpeedImperialUnit}'

@Regression25 @CTCP-1990
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Belt_Imperial
Scenario: ZxVerify the unit conversions for speed on conveyor Listing screen for imperial

    And Add data value in header as imperial
    And  Navigate to conveyor details screen for conveyor '${ConveyorName}'
    And Edit Conveyor speed value '${SpeedImp}'
    Then Navigate to conveyor list screen
    And Add filter for header with '${SpeedFilterName}'
    And Verify header field '${SpeedHeader}' is present in unit '${SpeedImperialUnit}'
    And Add data value in header as metric
    And Verify header field '${SpeedHeader}' is present in unit '${SpeedMetricUnit}'


@Regression25 @CTCP-1970
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Navigation_Count
Scenario: Verify pagination functionality

    And Navigate to conveyor list screen
    And Verify pagination format
    And Create a conveyor with '${ConveyorNameGer}' and '${DistShopGerName}' and '${CustShopGerName}'
    And Extract the conveyor count from conveyor list page
    Then Delete Conveyor from Conveyor list screen '${ConveyorNameGer}'
    And  Navigate to coverWear list screen and wait for data load
    And Navigate to conveyor list screen
    And Verify the conveyor count from conveyor list page
    Then Verify pagination forward arrow button
    And Verify pagination backward arrow button
    And Verify add button is enabled

@Regression33 @CTCP-1974
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_update
Scenario: Verify update functionality for Conveyor lite page

    When  Navigate to conveyor list screen
    And Search for the conveyor '${ConveyorName}' and select the checkbox to edit and verify user is able to select checkbox
    Then Click on Action button and select edit option and verify user is navigated to conveyor detail page
    And Click on map to set position of head and verify prefilled value for lat and long is displayed
    When Click on location type and select head value from the dropdown
    Then Click on add marker button and verify GPS Coordinates Head is updated with lat long value
    And Update the fields of Conveyor-Lite page and verify user is able to update the fields
    And Click on update button and verify all changes are saved and navigated to conveyor list page





