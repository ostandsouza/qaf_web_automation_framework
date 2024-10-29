Feature: Conveyor inspect for Web

Background:
Launch the application through '/'

 @Regression1
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZzVerify conveyor inspect user navigation

     Given User is at Login page
     When  Login with '${UserName}' and '${Password}'
     Then  Navigate to Conveyor inspect screen

 @Regression2
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZxVerify conveyor inspect screen

     When  Navigate to Conveyor inspect screen
     Then  Verify the conveyor inspect list headers

 @Regression3
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZwVerify conveyor inspect upload functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Upload drone files with '${Side}' '${colorMap}' '${irName}' '${rgbName}'

 @Regression4
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZvVerify conveyor inspect user default radio upload option

     When  Go to conveyor inspect for conveyor '${ConveyorName}' for Corporate '${CustCorpName}' with site '${CustSiteName}' with fileNames '${CorpFileName}' '${SiteFileName}' '${ConvFileName}'
     Then  verify default upload option in upload files

 @Regression5
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZuVerify conveyor inspect upload images functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select image upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colorMap}'
     And   Upload file with '${irName}'
     Then  Verify upload button is enabled after image upload

 @Regression6
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_video
 Scenario: ZtVerify conveyor inspect upload video functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}' for Corporate '${CustCorpName}' with site '${CustSiteName}' with fileNames '${CorpFileName}' '${SiteFileName}' '${ConvFileName}'
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select video upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colorMap}'
     And   Upload file with '${movName}'
     Then  Verify upload video file
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select video upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colorMap}'
     And   Upload file with '${seqName}'
     Then  Verify upload video file
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select video upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colorMap}'
     And   Upload file with '${srtName}'
     Then  Verify upload button functionality

 @Regression7
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZsVerify conveyor inspect edit functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Verify edit functionality at conveyor level

 @Regression8
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZrVerify conveyor inspect edit functionality

     When  Go to conveyor inspect for site '${CustSiteName}'
     Then  Verify edit functionality at site level

 @Regression9
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZqVerify conveyor inspect temperature range

     When  Go to conveyor inspect for site '${CustSiteName}'
     Then  Open temperature range dialog window
     And   Change critical temperature range '${Min}' to '${Max}'
     And   Set temperature range to default
     Then  Save change to temp range setting

 @Regression10
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect
 Scenario: ZpVerify conveyor inspect user assign object detection model panel


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
 Scenario: ZoVerify conveyor inspect conveyor status

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Verify conveyor status is selected by default
     And   Verify Last inspection date '${InspectionDate}'
     And   Verify Gauge metrics for conveyor status

 @Regression12
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZnVerify conveyor inspect trend analysis

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to trend analysis tab
     And   Verify mouse over data on the graph

 @Regression13
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZmVerify conveyor inspect maintenance action

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify maintenance action table

  @Regression14
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Conveyor_Inspect_CI
  Scenario: ZVerify conveyor inspect finding maintenance table

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify maintenance action findings '${ConveyorName}'

 @Regression15
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZkVerify conveyor inspect finding go fixed that

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify go fix that button


 @Regression16
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZjVerify conveyor inspect finding save as PDF

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify findings save as PDF

 @Regression17
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZiVerify conveyor inspect findings range

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify findings range

 @Regression18
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZhVerify conveyor inspect findings observation

   Given User is at Login page
   When  Login with '${UserName}' and '${Password}'
     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify findings observations

 @Regression19
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZgVerify conveyor inspect finding image functionality

     When  Go to conveyor inspect for conveyor '${ConveyorName}'
     Then  Go to maintenance action tab
     And   Verify image functionality

 @Regression20
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_CI
 Scenario: ZfVerify conveyor inspect button got that fixed finding

      When  Go to conveyor inspect for conveyor '${ConveyorName}'
      Then  Go to maintenance action tab
      And   Verify got that fixed findings message box


 @Regression21
 @dataFile:resources/data/TestData.xls
 @sheetName:Regression
 @key:Conveyor_Inspect_flir
 Scenario: ZeVerify conveyor inspect for flir images

     When  Go to conveyor inspect for conveyor '${ConveyorName}' for Corporate '${CustCorpName}' with site '${CustSiteName}' with fileNames '${CorpFileName}' '${SiteFileName}' '${ConvFileName}'
     And   Open upload files dialog window
     Then  Verify upload button is disabled by default
     And   Select image upload radio button
     Then  Verify company site dropdown is disabled with '${CustSiteName}'
     Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
     And   Select date of flight as current date
     And   Select time of flight as current time
     And   Select side dropdown as '${Side}'
     And   Select colormap dropdown as '${colorMap}'
     And   Upload file with '${flirName}'
     Then  Verify upload button functionality

  @Regression22
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Conveyor_Inspect
  Scenario: ZdVerify conveyor inspect for RGB single image

      When  Go to conveyor inspect for conveyor '${ConveyorName}'
      And   Open upload files dialog window
      Then  Verify upload button is disabled by default
      And   Select image upload radio button
      Then  Verify company site dropdown is disabled with '${CustSiteName}'
      Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
      And   Select date of flight as current date
      And   Select time of flight as current time
      And   Select side dropdown as '${Side}'
      And   Select colormap dropdown as '${colorMap}'
      And   Upload file with '${rgbName}'
      Then  Verify upload button negative scenario

  @Regression23
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Conveyor_Inspect
  Scenario: ZcVerify conveyor inspect for RGB double images

      When  Go to conveyor inspect for conveyor '${ConveyorName}'
      And   Open upload files dialog window
      Then  Verify upload button is disabled by default
      And   Select image upload radio button
      Then  Verify company site dropdown is disabled with '${CustSiteName}'
      Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
      And   Select date of flight as current date
      And   Select time of flight as current time
      And   Select side dropdown as '${Side}'
      And   Select colormap dropdown as '${colorMap}'
      And   Upload file with '${rgbName}'
      And   Upload file with '${rgbName}'
      Then  Verify upload button negative scenario

  @Regression24
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Conveyor_Inspect
  Scenario: ZbVerify conveyor inspect for IR single image

      When  Go to conveyor inspect for conveyor '${ConveyorName}'
      And   Open upload files dialog window
      Then  Verify upload button is disabled by default
      And   Select image upload radio button
      Then  Verify company site dropdown is disabled with '${CustSiteName}'
      Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
      And   Select date of flight as current date
      And   Select time of flight as current time
      And   Select side dropdown as '${Side}'
      And   Select colormap dropdown as '${colorMap}'
      And   Upload file with '${irName}'
      Then  Verify upload button negative scenario

  @Regression25
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Conveyor_Inspect
  Scenario: ZaVerify conveyor inspect for IR double images

      When  Go to conveyor inspect for conveyor '${ConveyorName}'
      And   Open upload files dialog window
      Then  Verify upload button is disabled by default
      And   Select image upload radio button
      Then  Verify company site dropdown is disabled with '${CustSiteName}'
      Then  Verify conveyor dropdown is disabled with '${ConveyorName}'
      And   Select date of flight as current date
      And   Select time of flight as current time
      And   Select side dropdown as '${Side}'
      And   Select colormap dropdown as '${colorMap}'
      And   Upload file with '${irName}'
      And   Upload file with '${irName}'
      Then  Verify upload button negative scenario