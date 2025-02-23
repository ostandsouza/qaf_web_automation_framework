Feature: Regression High Priority cases Corporates module

Background:
Launch the application through '/'







@Regression4
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






@Regression12
@dataFile:resources/data/CorporatesRegressionHP.json
Scenario: Verify user is able to map sites to customer corporate and it reflecting in view mode post addition for Market user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Create a Customer site '${CustSite_HP_Market}' and '${CustCorpAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify navigation to '${CustSite_HP_Market}' detail screen



@Regression14
@dataFile:resources/data/CorporatesRegressionHP.json
Scenario: Verify user is able to map shop to Distributor corporate and it reflecting in view mode post addition for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And   Create a Distributor shop with '${DistShop_HP_Market}' and '${DistShopIndAddress}' and '${DistCorpName}' and '${FullName}' and '${TerritoryInd}'
    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify navigation to '${DistShop_HP_Market}' detail screen







@Regression18
@dataFile:resources/data/CorporatesRegressionHP.json
Scenario: Verify action button Edit functionality is working as expected for market manager user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    When  Edit Customer Corporate with '${DistCorporateMarket}' and '${EditDistCorporateMarket}'
    And   Add '${CorpImageName}' image to Corporate and save changes
    Then  Verify the Distributor Corp details with '${EditDistCorporateMarket}' and '${CorpImageName}'






@Regression22
@dataFile:resources/data/CorporatesRegressionHP.json
Scenario: Verify search functionality is working as expected for market manager

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    And Navigate to Corporate List screen and wait
    And Search for the record '${EditDistCorporateMarket}'








@Regression26
@dataFile:resources/data/CorporatesRegressionHP.json
Scenario: Verify on deleting site, the count should update in site card count on corporate details screen for market user

    Given User is at Login page
    When  Login with '${UserNameMarket}' and '${Password}'
    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Extract the main card count in '${CorporateLevel}' page for '${Sites}'
    And Verify search and delete '${CustSite_HP_Market}' functionality
    And Verify the main card count after operation '${Deletion}' for '${Sites}' with count '${SingleValue}' at module level '${CorporateLevel}'







