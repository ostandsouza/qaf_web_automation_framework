Feature: Regression of P1 Conveyor module

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