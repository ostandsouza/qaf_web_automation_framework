Feature: Sanity Flow for Web

Background:
Launch the application through '/'

@Sanity1
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Usermanagement_MarketUser
Scenario: Verify the create market manager with all permission

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Create a Market manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And   Add territory as '${Region}' for the user
    And   Add territory as '${Region1}' for the user
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  Verify '${FullName}' user with market manager for market as '${Region}' and permission rights as '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@Sanity2
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Usermanagement_DistributorUser
Scenario: Verify the create Distributor user with limited permission

    When  Create a Distributor User '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${DistShopName}' and '${CustSiteName}'
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  Verify '${FullName}' user with distributor user for market as '${Region}' and permission rights as '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@Sanity3
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:CorporateMangement_Create
Scenario: Verify with create corporate scenario

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Create a Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
    And   Create a Distributor shop with '${DistShopIndName}' and '${DistShopIndAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a Distributor shop with '${DistShopAusName}' and '${DistShopAusAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryAus}'
    And   Create a Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'
    And   Create a Customer site '${CustSiteIndName}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    And   Create a Customer site '${CustSiteNZName}' and '${CustSiteNZAddress}' and '${CustCorpName}' and '${DistShopAusName}' and '${FullName}' and '${TerritoryNZ}'
    And   Create a Customer site '${CustSiteAusName}' and '${CustSiteAusAddress}' and '${CustCorpName}' and '${DistShopAusName}' and '${FullName}' and '${TerritoryAus}'


@Sanity4
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:CorporateMangement_Edit
Scenario: Verify with Edit corporate scenario

    When  Edit Customer Corporate with '${CustCorpName}' and '${EditCustCorpName}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    Then  Verify the Distributor Corp details with '${EditCustCorpName}' and '${CorpImageName}'
    When  Edit Customer site with '${CustSiteName}' and '${EditCustSiteName}' using corporate '${EditCustCorpName}'
    And   Add '${CustSiteImageName}' image to Corporate and save changes
    Then  Verify the Customer site details with '${EditCustSiteName}' and '${CustSiteImageName}' using corporate '${EditCustCorpName}'

@Sanity5
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:CorporateMangement_Delete
Scenario: Verify with Delete corporate scenario

    When  Delete Customer site with '${CustSiteName}'
    Then  Verify Deleted Customer site with '${CustSiteName}'
    When  Delete Distributor Shop for Corporate '${DistCorpName}' with '${DistShopIndName}'
    Then  Verify Deleted Distributor shop with '${DistCorpName}' with '${DistShopIndName}'

@Sanity6
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Conveyor_Management
Scenario: Verify the conveyor management

    When  Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName2}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName3}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName4}' and '${DistShopAusName}' and '${CustSiteAusName}'
    And   Create a conveyor with '${ConveyorName5}' and '${DistShopAusName}' and '${CustSiteAusName}'
    And   Create a conveyor with '${ConveyorName6}' and '${DistShopAusName}' and '${CustSiteAusName}'
    Then  Verify conveyor technical data with '${ConveyorName1}'
    Then  Verify conveyor history screen for '${ConveyorName1}'
    When  Delete Conveyor from Conveyor list screen '${ConveyorName1}'
    Then  Verify Deleted Conveyor '${ConveyorName1}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName4}'
    Then  Verify Deleted Conveyor '${ConveyorName4}' from Conveyor list screen
    When  Verify red pin on conveyor list with '${ConveyorName2}' and '${ConveyorName5}'
    When  Export PDF and CSV data for '${ConveyorName2}' and '${ConveyorName3}' and '${ConveyorName5}' and '${ConveyorName6}'

@Sanity7
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Conveyor_BulkUpload
Scenario: Verify the conveyor bulk upload

    And   Close warning popup
    When  Download bulk upload template for distributor '${DistCorpName}' and with sites '${CustSiteName}' and '${CustSite2Name}'
    And   Add two conveyor via bulk upload in site '${CustSiteName}' with file '${FileName}'
    Then  Validate conveyor '${CustSiteName}' should display in list with same data as filled in exel sheet '${FileName}'

@Sanity8
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_Card
Scenario: Verify scenario for corporate card data

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify card count in details screen for '${CustCorpName}'

@Sanity9
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Conveyor_Edit
Scenario: Verify the conveyor Edit

    When  Edit Conveyor '${ConveyorName}' from conveyor list screen to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${CustSiteName}'

@Sanity10
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Inspection_Management
Scenario: Verify Inspection management

    When  Add inspection Event for conveyor '${EditInspectionName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor '${ConveyorName}' for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor '${ConveyorName1}' for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    Then  Verify And validate the changes for '${InspectionName}' with '${ItemCount}'
    When  Edit inspection Event from '${InspectionName}' to '${EditInspectionName}'
    And   Edit inspection Item status for '${ConveyorName}' '${AssetName}' to '${EditStatus}'
    And   Delete inspection Item for '${ConveyorName1}'
    Then  Verify And validate the changes for '${EditInspectionName}' with '${ActionItemCount}'

@Sanity11
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Inspection_Report
Scenario: Verify Inspection Report

    When  Download inspection '${InspectionName}' from inspection list with '${CustSiteName}' '${ConveyorName}'
    Then  Verify data displayed in report for '${FullName}' '${CustSiteName}' '${ConveyorName}' '${InspectionName}'

@Sanity12
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Inspection_Delete
Scenario: Verify Inspection Delete

    When  Delete inspection '${InspectionName}' from inspection list
    Then  Verify inspection '${InspectionName}' is deleted from inspection list


@Sanity13
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:CoverWear_Management
Scenario: Verify Cover Wear Management

       When  Add Cover Wear for conveyor '${ConveyorName}' and site '${CustSiteName}' with data '${FullName}' '${PositionName}' '${TopCoverThickness}' '${BottomCoverThickness}' '${Durometer}' '${TopCoverCompound}' '${BottomCoverCompound}'
       Then  Verify Cover wear measurement for conveyor '${ConveyorName}'
       When  Add Cover wear position for conveyor '${ConveyorName}' with data '${SegmentName}' '${TopBottom}' '${TonsCovered}' '${PositionDurometer}'
       Then  Verify Cover wear position for conveyor '${ConveyorName}' and segment '${SegmentName}' with durometer as '${PositionDurometer}'
       When  Edit Cover wear position for conveyor '${ConveyorName}' with data '${SegmentName}' to '${EditSegmentName}'
       Then  Verify Cover wear position for conveyor '${ConveyorName}' and segment '${EditSegmentName}' with durometer as '${PositionDurometer}'
       When  Delete Cover wear position for conveyor '${ConveyorName}' with data '${EditSegmentName}'
       Then  Verify Delete Cover wear position for conveyor '${ConveyorName}' and segment '${EditSegmentName}'
       When  Edit Cover wear measurement for conveyor '${ConveyorName}'
       When  Delete Cover wear measurement for conveyor '${ConveyorName}'
       Then  Verify Delete Cover wear measurement for conveyor '${ConveyorName}'

@Sanity14
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:File_Manager
Scenario: Verify File manager

    When  Add Folder by the name '${FolderName}' under site '${CustSiteName}'
    And   Upload file '${ImgName}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${ImgName}'
    When  Upload file '${pdfFile}' into the folder "root"
    And   Move the file with '${pdfFile}' inside folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${pdfFile}'
    When  Upload file '${videoFile}' into the folder '${FolderName}'
    Then  Verify folder '${FolderName}' and file '${videoFile}'
    When  Open image with name '${ImgName}' inside folder '${FolderName}'
    And   Open pdf with name '${pdfFile}' inside folder '${FolderName}'
    And   Open file with name '${videoFile}' inside folder '${FolderName}'
    And   Delete file with name '${ImgName}' inside folder '${FolderName}'
    And   Delete file with name '${pdfFile}' inside folder '${FolderName}'
    And   Delete file with name '${videoFile}' inside folder '${FolderName}'
    Then  Verify the deleted file '${ImgName}' '${pdfFile}' '${videoFile}' inside folder '${FolderName}'
    When  Delete the folder '${FolderName}'
    Then  Verify the deleted folder '${FolderName}'


@Sanity15
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Conveyor_Inspect
Scenario: Verify Files upload for Conveyor Inspect

    When  Assign Object detection model '${DetectionModel}' for Corporate '${CustCorpName}' with site '${CustSiteName}' and conveyor '${ConveyorName}'
    And   Upload drone files with '${Side}' '${colorMap}' '${irName}' '${rgbName}'


@Sanity16
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Delete_Functionality
Scenario: Verify the Delete functionality across the application

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    When  Delete Conveyor from Conveyor list screen '${ConveyorName3}'
    Then  Verify Deleted Conveyor '${ConveyorName3}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName5}'
    Then  Verify Deleted Conveyor '${ConveyorName5}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName6}'
    Then  Verify Deleted Conveyor '${ConveyorName6}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName7}'
    Then  Verify Deleted Conveyor '${ConveyorName7}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName8}'
    Then  Verify Deleted Conveyor '${ConveyorName8}' from Conveyor list screen
    And   Delete Customer site with '${CustSiteAusName}'
    Then  Verify Deleted Customer site with '${CustSiteAusName}'
    And   Delete Customer site with '${CustSiteNZName}'
    Then  Verify Deleted Customer site with '${CustSiteNZName}'
    And   Delete Distributor Shop for Corporate '${DistCorpName}' with '${DistShopAusName}'
    Then  Verify Deleted Distributor shop with '${DistCorpName}' with '${DistShopAusName}'
    When  Delete Corporate with name '${CustCorpName}'
    Then  Verify Deleted corporate '${CustCorpName}'
    When  Delete Corporate with name '${DistCorpName}'
    Then  Verify Deleted corporate '${DistCorpName}'
    When  Delete User with name '${FullName}'
    Then  Verify user '${FullName}' is deleted
    When  Delete User with name '${FullName1}'
    Then  Verify user '${FullName1}' is deleted

 @Sanity17
 @dataFile:resources/data/LegacyMetricSanity.json
 Scenario: Verify Complete minuteman functionality

     And   Close warning popup
     And   User is at add minuteman conveyor page '${CalculationName}'
     When  User enters general info '${CalculationName}' '${Site}' '${ConveyorName}' '${Description}' '${Program}' '${ManufacturingLocation}' '${Units}' and click on next
     And   User enters inputs '${BeltWidth}' '${BeltSpeed}' '${TonsPerHourPeak}' '${PickMaterialName}' '${MaterialDensity}' '${AngleOfIdler}' '${CarrySideIdlerSpacing}' '${DriveWrapAngle}' '${FrictionFactor}' '${LengthFactor}' '${SurchargeAngle}' '${IdlerOffset}' '${DriverDetails}' '${TakeUpDetails}' '${SpliceType}' and click on next
     And   User enters stations '${Stations}' '${DriveLocation}' '${TakeUpLocation}' and click on next
     And   User enters flight info for '${Stations}' '${HorzOffset}' '${ElevOffset}' and click on calculate and next
     And   User enters select belt details '${TradeName}' '${CoverGrade}' '${Rating}' '${Plies}' '${CoverGaugeUnits}' '${GaugeTopCover}' '${GaugePulleyCover}'
     And   User should see all the calculated data of capacity page and click on next
     And   User should see all the calculated data of Roll data page and click on next
     And   User should see all the calculated data of pulleys page and click on next
     And   User should see all the calculated data Add '${TransitionLengthHead}' '${TransitionLengthTail}' of transition page and click on next
     And   User should see all the calculated data Add '${TakeUpTensionIfKnown}' of take up page and click on next
     And   User should see all the calculated data Add '${CurveRadius1}' '${CurveRadius2}' '${CurveRadius3}' '${CurveRadius4}' of curves and click on next
     Then  Verify all the data shown in the reports with calculated and entered data '${CalculationName}' '${Site}' '${ConveyorName}' '${TonsPerHourPeak}' '${MaterialDensity}' '${SurchargeAngle}' '${BeltWidth}' '${BeltSpeed}' '${CarrySideIdlerSpacing}' '${DriveLocation}' '${TakeUpLocation}' '${TakeUpDetails}'
     Then  Verify download report option on final report '${CalculationName}'
     When  Click on create button for minuteman calculation
     Then  Verify the minuteman calculation '${CalculationName}' in list screen
     When  Edit minuteman calculation '${CalculationName}' to '${NewCalculationName}'
     Then  Verify the minuteman calculation '${NewCalculationName}' in list screen
     When  Delete minuteman calculation '${NewCalculationName}'
     Then  Verify the deleted minuteman calculation '${NewCalculationName}' in list screen

 @Sanity18
 @dataFile:resources/data/TestData.xls
 @sheetName:Sanity
 @key:BeltMonitoring
 Scenario: Verify Complete monitoring device functionality

    Then  Navigate to Belt Monitoring List page for '${DeviceName}'
    And   Navigate to Add monitoring device screen
    And   Add the device details with mandatory field '${DeviceName}' '${DeviceType}' '${Status}' and '${ConveyorName}'
    And   Click on save button and verify device '${DeviceName}' is created successfully
    When  Edit monitoring device '${DeviceName}' to '${NewDeviceName}'
    Then  Verify the monitoring device '${NewDeviceName}' in list screen
    When  Delete monitoring device '${NewDeviceName}'
    Then  Verify the deleted monitoring device '${NewDeviceName}' in list screen


 @Sanity19
 @dataFile:resources/data/TestData.xls
 @sheetName:Sanity
 @key:CordProtect
 Scenario: Verify Cord protect functionality

    And   Navigate to Belt Monitoring List screen
    Then  Verify the monitoring device '${DeviceName}' in list screen
    When  Navigate to cord protect iot window
    Then  Verify the cord protect details page

 @Sanity20
 @dataFile:resources/data/TestData.xls
 @sheetName:Sanity
 @key:BeltScan
 Scenario: Verify Belt Scan functionality

    And   Navigate to Belt Scan List page
    Then  Navigate to Add Belt Scan Page and verify navigation
    When  Add Belt Scan general Info with '${DateOfScan}' '${ScanReason}' '${CustSiteAusName}' '${ConveyorName}' '${NotifyCCM}' '${File1}' and '${File2}'
    When  Submit the belt scan form
    Then  Verify the belt scan for '${ConveyorName}' is present in list screen
    When  Edit belt scan '${ConveyorName}' date scan to '${NewScanReason}'
    And   Delete belt scan '${ConveyorName}'
    Then  Verify the deleted Belt Scan '${ConveyorName}' in list screen

@Sanity21
@dataFile:resources/data/FabricSpliceSanity.json
Scenario: Verify Add fabric splice screen

    Then User is at Add Fabric splice Screen
    And Add a design with '${DesignerName}' '${Market}' '${SpliceKit}' '${CustomerName}' '${ConveyorName}' '${ApproverName}' '${BeltConstruction}'
    And Add the design details '${BeltWidth}' '${BeltType}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}' '${OverAllBeltThickness}' '${BiasAngle}'
    And Select Splice Type '${SpliceType}'
    And Click on calculate button and verify preview tab is displayed
    And Verify the Preview Design tab with calculations '${FingerWidthVal}' '${PullBackLengthVal}' '${BreakerGapVal}' '${TopOverlapVal}' '${BottomOverlapVal}' '${CoverOffsetVal}' '${CoverCutsetVal}' '${FingerEdgeWidthVal}' '${CarcassWidthVal}' '${BeltType}' '${TopCoverThickness}' '${BottomCoverThickness}' '${TopCoverCompoundName}'
    And Verify the Preview Design Notes with calculations '${CureTemperature}' '${CurePressure}' '${CureTime}' '${DimensionUnit}'
    And Click on Splice kit BOM tab and verify
    And Click on Comments log and save as draft
    And Search for fabric-splice design and verify the status of the design '${DraftStatus}'
    And Navigate to edit the fabric splice design
    And Click on Comments Log tab and add comments '${Comments}' and send For Review
    And Search for fabric-splice design and verify the status of the design '${InReviewStatus}'
    And Logout from the current user
    When Login with '${MarketUserName}' and '${MarketPassword}'
    And Navigate to fabric splice list screen
    And Search for fabric-splice design and verify the status of the design '${ToReviewStatus}'
    And Click on view icon
    And Click on Comments Log tab and add approve comments '${ApproveComments}' and approve
    And Search for fabric-splice design and verify the status of the design '${ApprovedStatus}'
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Navigate to fabric splice list screen
    And Search for fabric-splice design and verify the status of the design '${ApprovedStatus}'
    And Verify pdf download functionality for Splice Design with '${CustomerName}' '${ConveyorName}'
    Then Verify delete functionality for Splice Design

@Sanity22
@dataFile:resources/data/SteelCord.json
Scenario: Verify Add Steel Cord Calculation functionality across the application

    And Navigate to the Steel Cord Splice Generator list page
    And Navigate to the Steel Cord Splice Generator add page
    Then Create and Calculate The Steel Cord Splice with values '${Market}' '${SpliceKit}' '${CustomerName}' '${ConveyorName}' '${ApproverName}' '${BeltRating}' '${BeltWidth}' '${TopCoverCompound}' '${BottomCoverCompound}' '${TopCoverThickness}' '${BottomCoverThickness}' '${OverAllBeltThickness}' '${CordDiameter}' '${CordPitch}' '${NumberOfCords}'
    And Click on calculate button and verify preview tab is displayed
#   And Verify the Preview Design tab header with values for Steel Cord '${BeltWidth}' '${BeltRating}' '${TopCoverThickness}' '${BottomCoverThickness}' '${TopCoverCompound}'
    And Verify the Preview Design tab dimensions calculation values for Steel Cord '${NoOfSteps}' '${BeltWidth}' '${OverAllBeltThickness}' '${SplicePattern}' '${SpliceType}' '${NumberOfRepeatsA}' '${NumberOfRepeatsB}' '${CoverCut}' '${CordButtGap}' '${TransitionLength}' '${BiasLength}' '${BiasAngle}' '${StepLength}' '${SpliceLength}' '${OverAllSpliceLength}'
    And Verify the Preview Design tab Table and Note values for Steel Cord '${CordDiameterBelt}' '${CordDiameterSplice}' '${NoOfCordsBelt}' '${NoOfCordsSplice}' '${CordSpacingBelt}' '${CordSpacingSplice}' '${CordPitchBelt}' '${CordPitchSplice}' '${AllDimension}'
    And Navigate to Vulcanization Chart Tab and verify calculation values '${Temperature}' '${Pressure}' '${VulcanizationTime}'
    And Navigate to Comment Log and verify calculation values
    And Click on Comments log and save as draft
    And Search for steel cord design and verify the status of the design '${DraftStatus}'
    And Navigate to edit the Steel Cord Design
    And Click on Comments Log tab and add comments '${Comments}' and send For Review
    And Search for steel cord design and verify the status of the design '${InReviewStatus}'
    And Logout from the current user
    And Login with '${ApproverUserName}' and '${ApproverPassword}'
#    When Login with normal user '${ApproverUserName}' and '${ApproverPassword}'
    And Navigate to the Steel Cord Splice Generator list page
    And Search for steel cord design and verify the status of the design '${ToReviewStatus}'
    And Click on view icon
    And Click on Comments Log tab and add approve comments '${ApproveComments}' and approve
    And Search for steel cord design and verify the status of the design '${ApprovedStatus}'
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Navigate to the Steel Cord Splice Generator list page
    And Search for steel cord design and verify the status of the design '${ApprovedStatus}'
    And Verify pdf download functionality for Splice Design with '${CustomerName}' '${ConveyorName}'
    Then Verify delete functionality for Splice Design

@Sanity23
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Heavy_Equipment
Scenario: Verify Add Heavy Equipment Calculation functionality across the application

    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentName}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}'
    And Search for the heavy equipment '${HeavyEquipmentName}'
    And Navigate to edit heavy equipment page
    And Edit the Heavy Equipment '${EditHeavyEquipmentName}' '${Category}'
    And Click on add Icon and upload the file '${ImageName}'
    And Click on add Icon and upload the file '${PdfFile}'
    And Click on save button and verify the Heavy Equipment '${EditHeavyEquipmentName}' is edited
    And Click on view more icon
    And Verify and view the image uploaded '${ImageName}'
    And Verify file download functionality for '${ImageName}'
    And Verify and view the pdf file uploaded '${PdfFile}'
    And Verify file download functionality for '${PdfFile}'
    And Verify search and delete document '${ImageName}' functionality
    And Navigate to the Heavy Equipment list page
    And Verify search and delete '${EditHeavyEquipmentName}' functionality

@Sanity24
@dataFile:resources/data/BeltFormTextileSanity.json
Scenario: Verify Add Belt-Info Textile functionality

    And Navigate to the Belt Info Steel list page
    And Navigate to the Belt Info Textile sheet
    And Enter the Belt Form data '${Market}' '${STDReqByCustomer}' '${BeltConstruction}' '${CarcassConstruction}' '${TopCoverCompound}' '${TopCoverGauge}' '${BottomCoverCompound}' '${BottomCoverGauge}' '${BeltWidth}' '${BreakerItems}' '${BreakerItems}' '${Overallbeltthickness}' '${Comment}'
    And Export PDF and verify the PDF is downloaded

@Sanity25
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:FreeTools
Scenario: Verify Calculations in free tools

     And   Close warning popup
     And   Navigate to free tools capacity and verify the fields
     Then  Verify all the calculated data for conveyor capacity for entered data '${BeltWidth}' '${Density}' '${SurchrgeAngle}' '${BeltSpeed}' '${Tonnage}' '${TroughAngle}' '${ConveyorLoad}'
     Then  Navigate to free tools troughability and verify the fields
     Then  Verify all the calculated data for troughability for entered data '${RollerInclination}' '${Ratio}'
     When  Navigate to free tools roll length and verify the fields
     Then  Verify all the calculated data for roll length for entered data '${ReelShape}' '${InnerDiameter}' '${RaceTrack}' '${ReelWeight}' '${BeltThickness}' '${BeltLength}' '${BeltWeight}' '${ReelDiameter}' '${ReelLength}' '${Revolutions}' '${TotalWeight}'
     When  Navigate to free tools safety factor and verify the fields
     Then  Verify all the calculated data for safety calculator for entered data '${BeltType}' '${BeltWidth}' '${BreakingStrength}' '${BreakingForce}' '${BeltTension}' '${SafetyFactor}' '${SafetyFactorMinimum}' '${StartUpMinimum}'
     Then  Navigate to free tools units converter and verify the fields
     Then  Verify all the calculated data for PIW converter for entered data '${SafetyFactor}' '${SafetyFactorPN}' '${SafetyFactorST}' '${BreakingStrength}' '${OperatingTension1}' '${BreakingStrength1}' '${OperatingTension}'
     When  Navigate to free tools belt revolution and verify the fields
     Then  Verify all the calculated data for belt revolution for entered data '${TapedLength}' '${BeltSpeed}' '${TimeRevolutions}'
     And   Navigate to free tools wrap angle and verify the fields
     Then  Verify all the calculated data for wrap angle for entered data '${Direction}' '${Point1}' '${Point2}' '${WrapAngle}'
