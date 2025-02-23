Feature: Regression High Priority cases market manager module

  Background:
  Launch the application through '/'


  @Regression1
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User Add a site from home page and verify the site is added and count is incremented for market manager.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Navigate to Add Site page from home and create a Customer site '${CustSiteIndNameMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'

  @Regression2
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User edit a site from home page and Verify the site is edited and count remains same for market manager.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Search for the site '${CustSiteIndNameMarket}' and edit the site name '${EditCustSiteNameMarket}'
    Then  Verify the Customer site details with '${EditCustSiteNameMarket}' using corporate '${CustCorpName}'
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Edit}' for '${Sites}' with count '${multipleValue}' at module level '${HomeLevel}'

  @Regression3
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario:Verify User Delete Mulitple sites and sites is deleted from the list and count is updated for master  for market manager.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Create a Customer site '${CustSiteNameDel1Market}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Create a Customer site '${CustSiteIndNameDelMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And Click on Home Link to redirect to home page
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Search for the record '${CustSiteNameDel1Market}'
    And Click multiSelect Checkbox and verify delete functionality
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${multipleValue}' at module level '${HomeLevel}'

  @Regression4
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify User add site from customer corporate level and check site is added in customer corporate level & home level and count updated in customer corporate level & home level for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Extract the card count for '${Sites}' at '${CorporateLevel}' level and Create a Customer site in India '${CustomerSiteIndNameMarket}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullNameInd}' and '${TerritoryInd}'
    Then  Verify the Customer site details with '${CustomerSiteIndNameMarket}' using corporate '${CustCorpName}'
    And Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${CorporateLevel}'
    And Click on Home Link to redirect to home page
    And Verify the main card count after operation '${Addition}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'

  @Regression5
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify correct pagination and card count displayed on Customer Corporate and home level for market manager.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    And Verify correct pagination and card count is displayed at '${HomeLevel}' page for '${Sites}'
    And Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Extract the main card count in '${CorporateLevel}' page for '${Sites}'
    And Verify correct pagination and card count is displayed at '${CorporateLevel}' page for '${Sites}'

  @Regression6
  @dataFile:resources/data/SitesRegressionHP.json
  Scenario: Verify when Site is deleted respective conveyor should be deleted and count should be updated for market manager.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Extract the main card count in '${HomeLevel}' page for '${Sites}'
    When  Create a conveyor with '${SiteConveyorNameMarket}' and '${DistShopIndName}' and '${CustomerSiteIndNameMarket}'
    When  Delete Customer site with '${CustomerSiteIndNameMarket}'
    Then  Verify Deleted Customer site with '${CustomerSiteIndNameMarket}'
    Then  Verify Deleted Conveyor '${SiteConveyorNameMarket}' from Conveyor list screen
    And Verify user is on home page of the application
    And Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${SingleValue}' at module level '${HomeLevel}'


  @Regression7
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to add distributor corporate for market manager user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    When  Add Distributor Corporate with '${DistCorporateMarket}' and '${DistCorpAddress}'



  @Regression8
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to add customer corporate for Market user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Create a Customer Corporate with '${CustCorporateMarket}' and '${CustCorpAddress}'


  @Regression9
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to map sites to customer corporate and it reflecting in view mode post addition for Market user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Create a Customer site '${CustSite_HP_Market}' and '${CustCorpAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify navigation to '${CustSite_HP_Market}' detail screen

  @Regression10
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify user is able to map shop to Distributor corporate and it reflecting in view mode post addition for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Create a Distributor shop with '${DistShop_HP_Market}' and '${DistShopIndAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify navigation to '${DistShop_HP_Market}' detail screen

  @Regression11
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify action button Edit functionality is working as expected for market manager user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    When  Edit Customer Corporate with '${DistCorporateMarket}' and '${EditDistCorporateMarket}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    Then  Verify the Distributor Corp details with '${EditDistCorporateMarket}' and '${CorpImageName}'


  @Regression12
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify search functionality is working as expected for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Navigate to Corporate List screen and wait
    And Search for the record '${EditDistCorporateMarket}'

  @Regression13
  @dataFile:resources/data/CorporatesRegressionHP.json
  Scenario: Verify on deleting site, the count should update in site card count on corporate details screen for market user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Extract the main card count in '${CorporateLevel}' page for '${Sites}'
    And Verify search and delete '${CustSite_HP_Market}' functionality
    And Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${SingleValue}' at module level '${CorporateLevel}'


  @Regression14
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from site level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName1}' level
    And Verify default folder for site level
    When  Add Folder by the name '${FolderName}' under site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And Verify count in the file manager tile

  @Regression15
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario: Verify user navigate to file manager from conveyor level, verify the bread crumb, verify default folder displayed for all conveyors,  Create folder, add files inside the folder (upload image, pdf, video, csv, word, excel), validate the count is incremented based on total files uploaded.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And Verify the breadcrumb of the page for file manager at '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}' level
    And Verify default folder for conveyor level
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Upload file '${csvFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${csvFile}'
    When  Upload file '${wordFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${wordFile}'
    When  Upload file '${excelFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${excelFile}'
    And Verify count in the file manager tile


  @Regression16
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify file manager card count is not updated when multiple folders created and validate the count of file manager in site and conveyor level.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FMD_ConveyorName}'
    And Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    When  Add Folder by the name '${FolderName}' under conveyor '${Market_FMD_ConveyorName}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FMD_ConveyorName}'
    And Verify the main card count after operation '${Edit}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'
    Then  Navigate to file manager for conveyor '${CustCorp}' '${Market_FM_SiteName}' '${Market_FM_ConveyorName}'
    And Verify count in the file manager tile
    And Click on site name '${Market_FM_SiteName}' in breadcrumb anf verify it navigates to site page
    And Verify count in the file manager tile


  @Regression17
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify the user should be able to move the folder from one folder to another folder, move files from one folder to another folder,validate folder and files are moved, rename the folder & files and validate files are renamed and delete multiple file and folders from conveyor level and count should be updated accordingly.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName1}' under conveyor '${Market_FM_ConveyorName2}'
    When  Add Folder by the name '${FolderName2}' under conveyor '${Market_FM_ConveyorName2}'
    And   Upload file '${ImgName}' into the folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFile}'
    When  Add Folder by the name '${FolderNameNested}' inside the folder '${FolderName1}'
    And Click on the folder '${FolderName1}'
    And   Move the file with '${FolderNameNested}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNested}'
    And   Rename file with name '${FolderNameNested}' to '${FolderNameNestedNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${FolderNameNestedNew}'
    And   Rename file with name '${pdfFile}' to '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify folder '${FolderName2}' and file '${pdfFileNew}'
    And Extract the main card count in '${ConveyorLevel}' page for '${FileManager}'
    And   Delete multiple file inside folder '${FolderName2}'
    Then  Verify the deleted file '${pdfFileNew}' inside folder '${FolderName2}'
    Then  Verify the deleted file '${FolderNameNestedNew}' inside folder '${FolderName2}'
    And Verify the main card count after operation '${Deletion}' for '${FileManager}' with count '${multipleValue}' at module level '${ConveyorLevel}'


  @Regression18
  @dataFile:resources/data/FileManagerRegressionHP.json
  Scenario:  Verify user should be able to preview and download the uploaded files,multiple downloads should be allowed, duplicate files should not be uploaded,default folders should not be deleted, from site and conveyor level.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to file manager for conveyor '${Market_FM_ConveyorName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And Open file with name '${videoFile}' inside folder '${FolderName}'
    And Open file with name '${wordFile}' inside folder '${FolderName}'
    And Open file with name '${excelFile}' inside folder '${FolderName}'
    And Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted

    Then  Navigate to file manager for site '${Market_FM_SiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And Open file with name '${videoFile}' inside folder '${FolderName}'
    And Open file with name '${wordFile}' inside folder '${FolderName}'
    And Open file with name '${excelFile}' inside folder '${FolderName}'
    And Open file with name '${csvFile}' inside folder '${FolderName}'
    Then  Verify the multi files download folder '${FolderName}'
    When  Delete the folder '${defaultFolder}' and verify default folders cannot be deleted




  @Regression19
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to add heavy equipment for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentNameMarket}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}'
    And Search for the heavy equipment '${HeavyEquipmentNameMarket}'


  @Regression20
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify heavy equipment should be displayed on home page, Distributor corporate and shop details page only for Market

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Verify navigation to '${DistShopName}' detail screen
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page


  @Regression21
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able edit heavy equipment for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Search for the heavy equipment '${HeavyEquipmentNameMarket}'
    And Navigate to edit heavy equipment page
    And Edit the Heavy Equipment '${HeavyEquipmentNameMarket_Edit}' '${Category}'
    And Click on add Icon and upload the file '${ImageName}'
    And Click on add Icon and upload the file '${PdfFile}'
    And Click on save button and verify the Heavy Equipment '${HeavyEquipmentNameMarket_Edit}' is edited



  @Regression22
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to see image and pdf file in review mode on view details page of heavy equipment

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${HeavyEquipmentNameMaster_Edit}'
    And Click on view more icon
    And Verify and view the image uploaded '${ImageName}'
    And Verify and view the pdf file uploaded '${PdfFile}'


  @Regression23
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to delete image and pdf file for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then Navigate to the Heavy Equipment list page
    And Search for the heavy equipment '${HeavyEquipmentNameMarket_Edit}'
    And Click on view more icon
    And Click on the edit button
    And Verify search and delete document '${ImageName}' functionality
    And Verify search and delete document '${PdfFile}' functionality


  @Regression24
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario: Verify user is able to delete heavy equipment record and card count should also get updated for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Verify user is on home page of the application
    And Verify heavy equipment card visibility
    And Extract the main card count in '${HomeLevel}' page for '${HeavyEquipments}'
    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify search and delete '${HeavyEquipmentNameMarket_Edit}' functionality
    And Refresh the screen
    And Verify heavy equipment card visibility
    And Verify the main card count after operation '${Deletion}' for '${HeavyEquipments}' with count '${SingleValue}' at module level '${HomeLevel}'


  @Regression25
  @dataFile:resources/data/HeavyEquipmentHP.json
  Scenario:Verify correct count should display in heavy equipment record for market

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Navigate to the Heavy Equipment list page
    And Navigate to heavy equipment page and wait
    And Verify the heavy equipment count with respect to pagination
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Verify navigation to '${DistShopName}' detail screen
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the heavy equipment count with respect to pagination
    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the heavy equipment count with respect to pagination



  @Regression4
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression_HP
  @key:FreeTools_BreadCrumb
  Scenario: Verify all the free tools functionality with bread crumbs validation for distributor.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Navigate to free tools capacity and verify the breadcrumb  for '${Capacity}'
    Then  Navigate to free tools troughability and verify the breadcrumb for '${Troughability}'
    And Navigate to free tools Roll Length and verify the breadcrumb for '${RollLength}'
    And Navigate to free tools Safety factor and verify the breadcrumb for '${SafetyFactor}'
    And Navigate to free tools Units Converter and verify the breadcrumb for '${UnitsConverter}'
    And Navigate to free tools Belt Revolution and verify the breadcrumb for '${BeltRevolution}'
    And Navigate to free tools Wrap Angle and verify the breadcrumb for '${WrapAngle}'






  @Regression7
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Conveyor all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Create a Customer site '${CustSiteNameGeneric}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    When  Create a conveyor with '${GenericConveyorName1}' and '${DistShopIndName}' and '${CustSiteNameGeneric}'
    When  Create a conveyor with '${GenericConveyorName2}' and '${DistShopIndName}' and '${CustSiteNameGeneric}'

    When  Add Cover Wear for conveyor '${GenericConveyorName1}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName1}'

    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName1}' is present in list screen

    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName1}'
    And Click on save button and verify device '${DeviceName}' is created successfully

    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen

    When  Delete Conveyor from Conveyor list screen '${GenericConveyorName1}'
    Then  Verify Deleted Conveyor '${GenericConveyorName1}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName1}'
    And Refresh the screen

    Then  Verify the deleted Belt Scan '${GenericConveyorName1}' in list screen
    Then  Verify the deleted monitoring device '${DeviceName}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationName}' in list screen


  @Regression26
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Site all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'

    When  Add Cover Wear for conveyor '${GenericConveyorName2}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName2}'

    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName2}' is present in list screen

    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceNameSite}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName2}'
    And Click on save button and verify device '${DeviceNameSite}' is created successfully

    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationNameSite}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationNameSite}' in list screen

    When  Delete Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Conveyor '${GenericConveyorName2}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName2}'
    And Refresh the screen
    Then  Verify the deleted Belt Scan '${GenericConveyorName2}' in list screen
    Then  Verify the deleted monitoring device '${DeviceNameSite}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationNameSite}' in list screen






  @Regression27
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Conveyor all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    Given User is at Login page
    When  Login with '${UserNameCustomer}' and '${Password}'
    And Create a Customer site '${CustSiteNameGeneric}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${TerritoryInd}'
    When  Create a conveyor with '${GenericConveyorName1}' and '${DistShopName}' and '${CustSiteNameGeneric}'
    When  Create a conveyor with '${GenericConveyorName2}' and '${DistShopName}' and '${CustSiteNameGeneric}'

    When  Add Cover Wear for conveyor '${GenericConveyorName1}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName1}'

    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName1}' is present in list screen

    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceName}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName1}'
    And Click on save button and verify device '${DeviceName}' is created successfully

    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationName}' '${CustSiteNameGeneric}' '${GenericConveyorName1}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationName}' in list screen

    When  Delete Conveyor from Conveyor list screen '${GenericConveyorName1}'
    Then  Verify Deleted Conveyor '${GenericConveyorName1}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName1}'

    Then  Verify the deleted Belt Scan '${GenericConveyorName1}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationName}' in list screen
    And Refresh the screen
    Then  Verify the deleted monitoring device '${DeviceName}' in list screen



  @Regression28
  @dataFile:resources/data/Generic_HP.json
  Scenario: Verify user delete a Site all the records linked to the conveyor from cover wear, inspection, Belt scan, Monitoring Device, Heavy Equipments, Minutema(Conveyor and Elevator calculation should be deleted upon on hard refresh

    Given User is at Login page
    When  Login with '${UserNameCustomer}' and '${Password}'

    When  Add Cover Wear for conveyor '${GenericConveyorName2}' and site '${CustSiteNameGeneric}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
    Then  Verify Cover wear measurement for conveyor '${GenericConveyorName2}'

    Then Click on Belt Scan card and verify it navigates to BeltScan listing page
    And Click on add button and verify navigation to Add BeltScan page
    And Add Belt Scan details with '${DateOfScan}' '${DeviceType}' '${ReasonForScan}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${NotifyCCM}' '${File1}' and '${File2}'
    Then  Verify the belt scan for '${GenericConveyorName2}' is present in list screen

    Then  Navigate to Belt Monitoring List screen
    And Navigate to Add monitoring device screen
    And Add the device details with mandatory field '${DeviceNameSite}' '${DeviceType_MD}' '${Status}' and '${GenericConveyorName2}'
    And Click on save button and verify device '${DeviceNameSite}' is created successfully

    And   User is at add minuteman conveyor page
    When  User enters general info '${CalculationNameSite}' '${CustSiteNameGeneric}' '${GenericConveyorName2}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
    And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
    And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
    And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
    And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
    And   User should see all the calculated data of capacity page and click on next
    When  Click on create button for minuteman calculation
    Then  Verify the minuteman calculation '${CalculationNameSite}' in list screen

    When  Delete Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Customer site with '${CustSiteNameGeneric}'
    Then  Verify Deleted Conveyor '${GenericConveyorName2}' from Conveyor list screen
    Then  Verify Delete Cover wear measurement for conveyor '${GenericConveyorName2}'
    Then  Verify the deleted Belt Scan '${GenericConveyorName2}' in list screen
    Then  Verify the deleted minuteman calculation '${CalculationNameSite}' in list screen
    And Refresh the screen
    Then  Verify the deleted monitoring device '${DeviceNameSite}' in list screen

  @Regression29
  @dataFile:resources/data/BeltMonitoringHP.json
  Scenario: Verify search and filter functionality for default columns in Monitoring device list page for market manager user.

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    Then  Navigate to Belt Monitoring List screen
    And Click on each column header and verify filter icon fields




















































