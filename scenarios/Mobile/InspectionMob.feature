@Regression1 @CTCP-2267
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddItems
Scenario: Validating fields in add new item page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page
  And Click on asset/component dropdown and select option '${Asset}' and verify based on the selected option rest of the dropdowns and fields are visible and enter data '${Data}' and '${type}' in respective field
  And Select required details from the failure mode dropdown '${failureMode}' and enter value '${Observation}' in observation field
  And Click on the condition dropdown and verify is able to select '${Condition}' condition of inspection
  And Click the radio button to select the status and verify user is able to select the status
  And Enter the data in the recommendation field '${Recommendation}' and verify user is able to enter the recommendation
  And Click on save and close and verify user is navigated to inspection page and able to see the count '${count}' of added items

@Regression2 @CTCP-2280
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddItems
Scenario: Adding Inspection through inspection card from home page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via clicking on Inspection tile and verify navigation
  And Click on the add icon button and verify user is navigated to new inspection page
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page
  And Click on asset/component dropdown and select option '${Asset}' and verify based on the selected option rest of the dropdowns and fields are visible and enter data '${Data}' and '${type}' in respective field
  And Select required details from the failure mode dropdown '${failureMode}' and enter value '${Observation}' in observation field
  And Click on the condition dropdown and verify is able to select '${Condition}' condition of inspection
  And Click the radio button to select the status and verify user is able to select the status
  And Enter the data in the recommendation field '${Recommendation}' and verify user is able to enter the recommendation
  And Click on save and close and verify user is navigated to inspection page and able to see the count '${count}' of added items

@Regression3 @CTCP-2281
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddItems
Scenario: Adding inspection from inspection category in footer

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page by clicking on Inspection button in the footer and verify navigation
  And Click on the add icon button and verify user is navigated to new inspection page
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page
  And Click on asset/component dropdown and select option '${Asset}' and verify based on the selected option rest of the dropdowns and fields are visible and enter data '${Data}' and '${type}' in respective field
  And Select required details from the failure mode dropdown '${failureMode}' and enter value '${Observation}' in observation field
  And Click on the condition dropdown and verify is able to select '${Condition}' condition of inspection
  And Click the radio button to select the status and verify user is able to select the status
  And Enter the data in the recommendation field '${Recommendation}' and verify user is able to enter the recommendation
  And Click on save and close and verify user is navigated to inspection page and able to see the count '${count}' of added items

@Regression4 @CTCP-2283
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_AddItems
Scenario:Verifying the Single and Multiple Inspection types are available while creating new Inspection.

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  Then Click on add icon in home page and verify Add Inspection Add Conveyor Add Site/Shop Add Corporate are visible
  And Click on Add Inspection link and verify the fields in Add New Inspection page
  And Click o Inspection info and verify single and multiple inspection types options are available

@CTCP-2254
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Login in the application

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  Then Verify user present in home screen

@CTCP-2255
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating home page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Verify user present in home screen
  And Verify home screen details

@CTCP-2256
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating + button in home page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Verify user present in home screen
  And Verify home page Add Icon navigation

@CTCP-2257
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating Add Inspection link

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Verify add New Inspection page details

@CTCP-2260
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating the fields by providing the data

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectiorName}'

@CTCP-2262
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating Belt Specs link

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectionName}'
  And Add inspection belt scan

@CTCP-2265
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating Add Inspection items link

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectionName}'
  And Add inspection belt scan
  And Verify add inspection items fields


@CTCP-2266
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating + add inspection button in new inspection page

  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page

@CTCP-2268
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating the flag,status icon and the count on displaying on them
  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page
  And Verify the condition flags in the add inspection item page
  And Verify the status options in the add inspection item page

@CTCP-2276
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating sign off link
  Given Verify user is on continental login page
  And  Login to the application with '${UserName}' and '${Password}'
  And Navigate to add inspection page via Home and verify navigation
  And Add inspection custom distributor logo
  And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
  And Add inspection belt scan
  And Click Add New Item and verify navigation to Add New Item page
  And Add '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Observation}' '${Recommendation}' '${Length}' for Add New Item Page
  And Click Next Button for inspection Add Page
  And Verify and Add '${Summary}' for Sign Off Page

@CTCP-2278
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating save and close button in new inspection page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Navigate to add inspection page via Home and verify navigation
    And Add inspection custom distributor logo
    And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
    And Add inspection belt scan
    And Click Add New Item and verify navigation to Add New Item page
    And Add '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Observation}' '${Recommendation}' '${Length}' for Add New Item Page
    And Click Next Button for inspection Add Page
    And Verify and Add '${Summary}' for Sign Off Page
    Then Verify user present in home screen

@CTCP-2275
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating + add new item button in add inspection item in new inspection page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Navigate to add inspection page via Home and verify navigation
    And Add inspection custom distributor logo
    And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
    And Add inspection belt scan
    And Click Add New Item and verify navigation to Add New Item page
    And Add '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Observation}' '${Recommendation}' '${Length}' for Add New Item Page
    And Add '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Observation}' '${Recommendation}' '${Length2}' for Add New Item Page

@CTCP-2277
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Inspection_Mobile
Scenario: Validating save draft button in new inspection page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Navigate to add inspection page via Home and verify navigation
    And Add inspection custom distributor logo
    And Add inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'
    And Add inspection belt scan
    And Click Add New Item and verify navigation to Add New Item page
    And Add '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Observation}' '${Recommendation}' '${Length}' for Add New Item Page
    And Click and verify save draft button and user is present in same page
    And Verify the data for inspection info with '${InspectionName}' '${ConveyorName}' '${CustSiteName}' '${InspectorName}'