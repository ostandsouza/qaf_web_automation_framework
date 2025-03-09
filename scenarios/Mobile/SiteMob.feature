Feature: Regression Flow for Mob

@Regression1 @CTCP-2227
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify Add Site back button functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Navigate to Add Site Page
    And Verify back button is visible next to add site heading
    And Click on Add Site back button and verify it navigates to corporate list page


@Sanity2 @CTCP-2229
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_MobCustomerSite
Scenario: Add Customer Site

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to add site/shop screen with '${CustSiteName}'
     And   Add customer site with '${CustSiteName}' '${CustSiteAddress}' '${CustCorpName}' '${DistShopName}' '${Territory}' '${Manager}'
     Then  Navigate to site list and verify '${CustSiteName}' is present
     And Click on '${CustSiteName}' site name and verify it navigates to details screen and verify the heading
     And Click on corporate card and verify it navigates to company detail page
     And Verify the user filled details in company page '${CustSiteName}'


@Sanity3 @CTCP-2234
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_MobCustomerSite
Scenario: Verify map functionality

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to add site/shop screen with '${CustSiteName}'
     And   Add customer site with '${CustSiteName}' '${CustSiteAddress}' '${CustCorpName}' '${Territory}' and verify that selected address  is displayed in the map

@Sanity4 @CTCP-2237
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_EditCustomerSite
Scenario: Verify edit Site Flow

         Given Verify user is on continental login page
         And   Login to the application with '${Email}' and '${Password}'
         When  User navigates to add site/shop screen with '${CustSiteName}' and '${EditCustSiteName}'
         And   Add customer site with '${CustSiteName}' '${CustSiteAddress}' '${CustCorpName}' '${DistShopName}' '${Territory}' '${Manager}'
         Then  Navigate to corporate list and verify '${CustCorpName}' is present
         And   Navigate to corporate details screen and verify '${CustSiteName}' is present and associated count '${Associatedcount}'
         And   Verify user is able to edit shop name '${CustSiteName}' to '${EditCustSiteName}' and '${EditCustSiteAddress}' and '${EditTerritoryManager}'
         And   Verify the corporate count
         When  Go back from corporate card screen
         And   Close search box from site/shop screen
         And   Apply filter with corporate type as '${EditCustSiteName}'
         Then  Verify the site filter result for '${EditCustSiteName}'


@Sanity5 @CTCP-2243
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Site_EditConveyor
Scenario: Verify edit Conveyor Functionality of conveyor listed on site details page

         Given Verify user is on continental login page
         And   Login to the application with '${Email}' and '${Password}'
         Then Navigate to the site list and verify '${CustSiteName}' is present
         And Click on '${CustSiteName}' site name and verify it navigates to details screen and verify the heading
         And Click on three dots next to conveyors '${ConveyorName}' and verify edit/delete option is visible
         And Click on edit button and verify it navigates to edit conveyor page
         And Change the conveyor name '${EditConveyorName}' and save then verify user navigates to '${CustSiteName}' site details page
         And Verify updated conveyor name '${EditConveyorName}' is present in the list

@CTCP-2226
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Navigate to Add site via Home page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Verify user present in home screen
    Then Navigate to add site page via Home and verify navigation
    And Verify default type of company field for Site
    And Verify add site heading

@CTCP-2228
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify fields displayed in add site screen

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to add site page via Home and verify navigation
    And Verify add site heading
    And Verify add site fields

@CTCP-2230
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify duplicate corporate check

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to add site page via Home and verify navigation
    And Add a customer site with '${CustSiteName}' '${CustSiteAddress}' '${CustCorpName}' '${DistShopName}' '${Territory}' '${Manager}'
    And Verify duplicate site creation

@CTCP-2231
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Add distributor Shop

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    Then Navigate to add site page from Corporate list page
    And Add a distributor shop with '${DistShopName}' '${CustSiteAddress}' '${CustCorpName}' '${Territory}' '${Manager}'
    And Verify company creation success message and navigation to corporate lisiting page
    And Navigate to corporate list and verify '${CustCorpName}' is present
    And Navigate to corporate details screen and verify shop name '${DistShopName}' is present
    And Navigate to site details screen and verify header of shop name '${DistShopName}' is present
    Then Verify data '${DistShopName}' '${CustSiteAddress}' '${Manager}' in site details screen

@CTCP-2242
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_List_Data
Scenario: Verify duplicate check in edit site

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Navigate to corporate list and verify '${CorpName}' is present
    And Navigate to corporate details screen and verify shop name '${DistShopName}' is present
    And Navigate to site details screen and verify header of shop name '${DistShopName}' is present
    Then Verify site details fields are disabled
    And Verify user is unable to edit duplicate corporate name from '${DistShopName}' to '${EditDistShopName}'



