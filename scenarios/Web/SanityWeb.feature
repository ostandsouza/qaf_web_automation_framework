Feature: Sanity Flow for Web

Background:
Launch the application through '/'

@Sanity1
@dataFile:resources/data/TestData.xls
@key:Usermanagement_MarketUser
Scenario: Verify the create market manager with all permission

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Create a Market manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And   Add territory as '${Region}' for the user
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  Verify '${FullName}' user with market manager for market as '${Region}' and permission rights as '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@Sanity2
@dataFile:resources/data/TestData.xls
@key:Usermanagement_DistributorUser
Scenario: Verify the create distributor user with limited permission

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Create a Distributor User '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${DistShopName}' and '${CustSiteName}'
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  Verify '${FullName}' user with distributor user for market as '${Region}' and permission rights as '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@Sanity3
@dataFile:resources/data/TestData.xls
@key:CorporateMangement_Create
Scenario: Verify the create corporate scenario

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
@key:CorporateMangement_Edit
Scenario: Verify the edit corporate scenario

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Edit Customer Corporate with '${CustCorpName}' and '${EditCustCorpName}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    Then  Verify the Distributor Corp details with '${EditCustCorpName}' and '${CorpImageName}'
    When  Edit Customer site with '${CustSiteName}' and '${EditCustSiteName}' using corporate '${EditCustCorpName}'
    And   Add '${CustSiteImageName}' image to Corporate and save changes
    Then  Verify the Customer site details with '${EditCustSiteName}' and '${CustSiteImageName}' using corporate '${EditCustCorpName}'

@Sanity5
@dataFile:resources/data/TestData.xls
@key:CorporateMangement_Delete
Scenario: Verify the Delete corporate scenario

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Delete Customer site with '${CustSiteName}'
    Then  Verify Deleted Customer site with '${CustSiteName}'
    When  Delete Distributor Shop for Corporate '${DistCorpName}' with '${DistShopIndName}'
    Then  Verify Deleted Distributor shop with '${DistCorpName}' with '${DistShopIndName}'

@Sanity6
@dataFile:resources/data/TestData.xls
@key:Conveyor_Management
Scenario: Verify the Conveyor management

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Create a conveyor with '${ConveyorName1}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName2}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName3}' and '${DistShopAusName}' and '${CustSiteNZName}'
    And   Create a conveyor with '${ConveyorName4}' and '${DistShopAusName}' and '${CustSiteAusName}'
    And   Create a conveyor with '${ConveyorName5}' and '${DistShopAusName}' and '${CustSiteAusName}'
    And   Create a conveyor with '${ConveyorName6}' and '${DistShopAusName}' and '${CustSiteAusName}'
    Then  Verify conveyor technical data with '${ConveyorName1}'
    When  Delete Conveyor from Conveyor list screen '${ConveyorName1}'
    Then  Verify Deleted Conveyor '${ConveyorName1}' from Conveyor list screen
    When  Delete Conveyor from Conveyor list screen '${ConveyorName4}'
    Then  Verify Deleted Conveyor '${ConveyorName4}' from Conveyor list screen
    When  Verify red pin on conveyor list with '${ConveyorName2}' and '${ConveyorName5}'
    When  Export PDF and CSV data for '${ConveyorName2}' and '${ConveyorName3}' and '${ConveyorName5}' and '${ConveyorName6}'

@Sanity7
@dataFile:resources/data/TestData.xls
@key:Conveyor_BulkUpload
Scenario: Verify the Conveyor Bulk Upload

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Download bulk upload template for distributor '${DistCorpName}' and with sites '${CustSiteName}' and '${CustSite2Name}'
    And   Add two conveyor via bulk upload in site '${CustSiteName}' with file '${FileName}'
    Then  Validate conveyor '${CustSiteName}' should display in list with same data as filled in exel sheet '${FileName}'

@Sanity8
@dataFile:resources/data/TestData.xls
@key:Corporate_Card
Scenario: Verify corporate card data

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify card count in details screen for '${CustCorpName}'

@Sanity9
@dataFile:resources/data/TestData.xls
@key:Conveyor_Edit
Scenario: Verify conveyor edit

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Edit Conveyor '${ConveyorName}' from conveyor list screen to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${CustSiteName}'
    When  Edit inspection Event from '${InspectionName}' to '${EditInspectionName}'
    And   Edit inspection Item from '${Status}' to '${EditStatus}'
    Then  Verify And validate the changes for '${EditInspectionName}'

@Sanity10
@dataFile:resources/data/TestData.xls
@key:Inspection_Management
Scenario: Verify the inspection management

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Add inspection Event for conveyor '${ConveyorName}' with '${InspectionName}' '${CustSiteName}' '${FullName}'
    And   Add inspection Item for conveyor for '${InspectionName}' with '${AssetName}' '${AssetDetail}' '${FailureMode}' '${Condition}' '${Status}'
    And   Add inspection Item for conveyor for '${InspectionName}' with '${AssetName2}' '${AssetDetail2}' '${FailureMode2}' '${Condition2}' '${Status}'
    Then  Verify And validate the changes for '${InspectionName}'

@Sanity11
@dataFile:resources/data/TestData.xls
@key:Inspection_Report
Scenario: Verify the inspection Report

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Download inspection '${InspectionName}' from inspection list
    Then  Verify data displayed in report for '${FullName}' '${CustSiteName}' '${ConveyorName}' '${InspectionName}'

@Sanity12
@dataFile:resources/data/TestData.xls
@key:Inspection_Delete
Scenario: Verify the inspection Report

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Delete inspection '${InspectionName}' from inspection list
    Then  Verify inspection '${InspectionName}' is deleted from inspection list

