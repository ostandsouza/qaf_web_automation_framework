Feature: Regression of P1 Corporates module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify with add company navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Add Company screen

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_imageUpload
Scenario: Verify image upload functionality

    When  Navigate to Add Company screen
    Then  Verify image upload functionality with '${ImageName}'

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorCorp
Scenario: Verify the distributor corporate creation

    When  Add Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_MarketType
Scenario: Verify the distributor corporate Market type for newly added corporate

    Then  Verify market type '${Type}' for Corporate with name '${DistCorpName}'

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopCount
Scenario: Verify the distributor corporate Shop count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShop
Scenario: Verify the distributor Shop creation

    When  Add Distributor shop with '${DistShopName}' and '${DistShopAddress}' and '${DistCorpName}' and '${FullName}' and '${Territory}'

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_MarketTypeShop
Scenario: Verify the distributor Shop Market type for newly added shop under corporate

    Then  Verify market type '${Type}' for Corporate with name '${DistCorpName}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopCountAfterAdd
Scenario: Verify the distributor Shop count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify expected card count in details screen is '${Count}'


@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerCorp
Scenario: Verify the customer corporate creation

    When  Add Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteCount
Scenario: Verify the customer Site count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerSite
Scenario: Verify the Customer Site creation

    When  Add Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${Territory}'

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteCountAfterAdd
Scenario: Verify the Customer Site count in corporate details screen after adding new site

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify navigation to corporate list screen

    Then  Navigation of corporate list screen

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify navigation from corporate list to corporate details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShopNav
Scenario: Verify navigation from corporate details screen to shop details page

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify navigation to '${DistShopName}' detail screen

@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify customer corporate dropdown in site creation flow

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Go to add Corporates from details screen
    Then  Verify customer corporate dropdown contains '${CustCorpName}'

@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistCorpDetails
Scenario: Verify distributor corporate dropdown in site creation flow

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    And   Go to add Corporates from details screen
    Then  Verify distributor corporate dropdown contains '${DistCorpName}'

@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteDetail
Scenario: Verify navigation from corporate details screen to site details page

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify navigation to '${CustSiteName}' detail screen

@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_AddConveyor
Scenario: Verify Navigation to add conveyor from site details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    When  Create a conveyor with '${ConveyorName}' and '${CustSiteName}'


@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_AddConveyor
Scenario: Verify Navigation to Conveyor details screen from site page

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    Then  Verify navigation from site detail to conveyor details screen of '${ConveyorName}'


@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_EditConveyor
Scenario: Verify Edit conveyor details

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    Then  Verify navigation from site detail to conveyor details screen of '${ConveyorName}'
    When  Edit Conveyor '${ConveyorName}' from site list screen to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${CustSiteName}'

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShopEdit
Scenario: Verify Edit shop details

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Edit Customer shop with '${DistShopName}' and '${EditDistShopName}' using corporate '${DistCorpName}'

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerSiteEdit
Scenario: Verify Edit site details

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Edit Customer site with '${CustSiteName}' and '${EditCustSiteName}' using corporate '${CustCorpName}'

@Regression24
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DeleteConveyor
Scenario: Verify Delete conveyor from site details

    When  Delete conveyor '${EditConveyorName}' customer site '${EditCustSiteName}' with Corporate name '${CustCorpName}'
    Then  Verify Deleted conveyor '${EditConveyorName}' customer site '${EditCustSiteName}' with Corporate name '${CustCorpName}'

@Regression25
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopDelete
Scenario: Verify Delete distributor shop from corporate

    When  Delete Distributor Shop for Corporate '${DistCorpName}' with '${EditDistShopName}'
    Then  Verify Deleted Distributor shop with '${DistCorpName}' with '${EditDistShopName}'

@Regression26
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteDelete
Scenario: Verify Delete Customer site from corporate

    When  Delete Distributor Shop for Corporate '${CustCorpName}' with '${EditCustSiteName}'
    Then  Verify Deleted Distributor shop with '${CustCorpName}' with '${EditCustSiteName}'

@Regression27
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistCorpDetails
Scenario: Verify Company deletion from corporate list screen

    When  Delete Corporate with name '${DistCorpName}'
    Then  Verify Deleted corporate '${DistCorpName}'

@Regression28
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify Company deletion from corporate list screen

    When  Delete Corporate with name '${CustCorpName}'
    Then  Verify Deleted corporate '${CustCorpName}'
