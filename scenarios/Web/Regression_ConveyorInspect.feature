Feature: Conveyor inspect for Web

Background:
Launch the application through '/'

 @Regression1
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect user navigation

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     Then  Navigate to Conveyor inspect screen

 @Regression2
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect screen

     When  Navigate to Conveyor inspect screen
     Then  Verify the conveyor inspect list headers

 @Regression3
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect upload functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Upload drone files with '${Side}' '${colorMap}' '${irName}' '${rgbName}'

 @Regression4
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect user default radio upload option

     When  Go to conveyor inspect for conveyor '${ConveyorName}' for Corporate '${CustCorpName}' with site '${CustSiteName}'
     Then  verify default upload option in upload files

 @Regression5
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect upload images functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select image upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colormap}'
     And   Upload file with '${irName}'
     Then  Verify upload button is enabled after image upload

 @Regression6
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect upload video functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select video upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colormap}'
     And   Upload file with '${irName}'
     Then  Verify upload button is enabled after image upload

 @Regression7
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect edit functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Verify edit functionality at conveyor level

 @Regression8
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect edit functionality

     When  Go to conveyor inspect for site '${CustSiteName}'
     Then  Verify edit functionality at site level

 @Regression9
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect temperature range

     When  Go to conveyor inspect for site '${CustSiteName}'
     Then  Open temperature range dialog window
     And   Change critical temperature range '${Min}' to '${Max}'
     And   Set temperature range to default
     Then  Save change to temp range setting

 @Regression10
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: Verify conveyor inspect user assign object detection model panel

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     And   Open assign object detection model window
     Then  Verify the company dropdown status
     And   Verify the site dropdown status
     And   Verify the conveyor dropdown status
     And   Verify the model dropdown status
     And   Assign Object detection model '${DetectionModel}'

 @Regression11
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: Verify conveyor inspect conveyor status

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Verify conveyor status is selected by default
     And   Verify Last inspection date '${InspectionDate}'
     And   Verify Gauge metrics for conveyor status

 @Regression12
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: Verify conveyor inspect trend analysis

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to trend analysis tab
     And   Verify mouse over data on the graph

 @Regression13
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: Verify conveyor inspect maintenance action

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify maintenance action table

 @Regression14
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: Verify conveyor inspect go fixed that

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify maintenance action table


 @Regression15
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: Verify conveyor inspect

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify maintenance action table