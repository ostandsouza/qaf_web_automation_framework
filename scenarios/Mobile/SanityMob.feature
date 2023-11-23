Feature: Sanity Flow for Web

@Sanity1
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:UserManagement_Customer
Scenario: Verify the create customer user flow

    Given Create as customer user account from via with '${UserName}' '${Email}' '${Password}' '${Phone}' '${SiteName}' and '${UserType}'
    When  Verify user is on continental login page
    Then  Now verify the '${Email}' user from mobile via Activate account flow
    When  Login to the application with '${Email}' and '${Password}'
    And   Navigate to user My Profile screen
    Then  Verify changing of phone number from '${Phone}' to '${NewPhone}'
    When  Navigate back to My profile screen
    Then  Verify change update password from '${Password}' to '${NewPassword}'
    And   Navigate back to My profile screen
    Then  Verify user is able to logout from app


@Sanity2
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Permission_territory
Scenario: Verify the permission flow

    Given Create as territory user account from via with '${UserName}' '${Email}' '${Password}' '${Phone}' and '${UserType}'
    When  Verify user is on continental login page
    Then  Now verify the '${Email}' user from mobile via Activate account flow
    When  Login to the application with '${Email}' and '${Password}'
    And   User navigates to add corporate screen with '${DistCorpName}'
    And   Add Distributor corporate with '${DistCorpName}' '${DistCorpAddress}'
    Then  Navigate to corporate list and verify '${DistCorpName}' is present
    And   Verify user is able to edit corporate with '${DistCorpName}'

@Sanity3
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_DistCorp
Scenario: Verify the add distributor corporate flow

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    When  User navigates to add corporate screen with '${DistCorpName}' and '${EditDistCorpName}'
    And   Add Distributor corporate with '${DistCorpName}' '${DistCorpAddress}'
    Then  Navigate to corporate list and verify '${DistCorpName}' is present
    And   Verify user is able to edit corporate name '${EditDistCorpName}' and '${EditDistCorpAddress}'
    And   Verify the corporate count
    When  Go back from corporate details screen
    And   Close search box from list screen
    And   Apply filter with distributor corporate type as '${EditDistCorpName}'
    Then  Verify the corporate result count with filter
    When  Reset the filter
    Then  Verify the corporate result count without filter


@Sanity4
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_CustCorp
Scenario: Verify the add customer corporate flow

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    When  User navigates to add corporate screen with '${CustCorpName}' and '${EditCustCorpName}'
    And   Add Customer corporate with '${CustCorpName}' '${CustCorpAddress}'
    Then  Navigate to corporate list and verify '${CustCorpName}' is present
    And   Verify user is able to edit corporate name '${EditCustCorpName}' and '${EditCustCorpAddress}'
    And   Verify the corporate count
    When  Go back from corporate details screen
    And   Close search box from list screen
    And   Apply filter with customer corporate type as '${EditCustCorpName}'
    Then  Verify the corporate result count with filter
    When  Reset the filter
    Then  Verify the corporate result count without filter

@Sanity5
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_distributorShop
Scenario: Verify the Shop corporate flow

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    When  User navigates to add site/shop screen with '${DistShopName}' and '${EditDistShopName}'
    And   Add distributor shop with '${DistShopName}' '${DistShopAddress}' '${DistCorpName}' '${Territory}' '${Manager}'
    Then  Navigate to corporate list and verify '${DistCorpName}' is present
    And   Navigate to corporate details screen and verify '${DistShopName}' is present and associated count '${Associatedcount}'
    And   Verify user is able to edit shop name '${DistShopName}' to '${EditDistShopName}' and '${EditDistShopAddress}'
    And   Verify the corporate count
    When  Go back from corporate card screen
    And   Close search box from site/shop screen
    And   Apply filter with corporate type as '${EditDistShopName}'
    Then  Verify the site filter result for '${EditDistShopName}'
    When  Reset the filter
    Then  Verify the site filter result for '${EditDistShopName}'

@Sanity6
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_customerSite
Scenario: Verify the Site corporate flow

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to add site/shop screen with '${CustSiteName}' and '${EditCustSiteName}'
     And   Add customer site with '${CustSiteName}' '${CustSiteAddress}' '${CustCorpName}' '${DistShopName}' '${Territory}' '${Manager}'
     Then  Navigate to corporate list and verify '${CustCorpName}' is present
     And   Navigate to corporate details screen and verify '${CustSiteName}' is present and associated count '${Associatedcount}'
     And   Verify user is able to edit shop name '${CustSiteName}' to '${EditCustSiteName}' and '${EditCustSiteAddress}'
     And   Verify the corporate count
     When  Go back from corporate card screen
     And   Close search box from site/shop screen
     And   Apply filter with corporate type as '${EditCustSiteName}'
     Then  Verify the site filter result for '${EditCustSiteName}'
     When  Reset the filter
     Then  Verify the site filter result for '${EditCustSiteName}'

@Sanity7
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_conveyor
Scenario: Verify the Conveyor flow

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to add conveyor with '${ConveyorName}' '${EditConveyorName}'
     And   Add conveyor with '${ConveyorName}' '${CustSiteName}' '${DistShopName}'
     Then  Navigate to conveyor list and verify '${ConveyorName}' is present
     And   Navigate to conveyor details screen
     When  Go back from conveyor details screen
     And   Verify user is able to edit conveyor name '${ConveyorName}' to '${EditConveyorName}' '${EditCustSiteName}' and '${EditDistShopName}'
     And   Navigate back to dashboard screen
     And   Navigate to conveyor list and verify '${EditConveyorName}' is present
     And   Close search box from list screen
     And   Apply conveyor filter with corporate type as '${EditCustSiteName}'
     Then  Verify the corporate result count with filter
     When  Reset the filter
     Then  Verify the corporate result count without filter

@Sanity8
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_inspection
Scenario: Verify the Inspection flow

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to add inspection with '${InspectionName}' '${EditInspectionName}'
     And   Add inspection with '${InspectionName}' '${ConveyorName}' '${CustSiteName}'
     Then  Navigate to inspection list and verify '${InspectionName}' is present
     And   Verify user is able to edit inspection name '${InspectionName}' to '${EditInspectionName}'
     And   Navigate to inspection list and verify '${EditInspectionName}' is present
     And   Apply filter with customer corporate type as '${CustCorpName}'
     Then  Verify the site filter result for '${InspectionName}'
     When  Reset the filter
     Then  Verify the site filter result for '${InspectionName}'
     When  Verify user is able to delete inspection name '${InspectionName}'
     Then  Verify the deleted inspection '${InspectionName}'

@Sanity9
@dataFile:resources/data/TestData.xls
@sheetName:Sanity
@key:Corporate_coverWear
Scenario: Verify the Cover Wear flow

     Given Verify user is on continental login page
     And   Login to the application with '${Email}' and '${Password}'
     When  User navigates to cover wear from conveyor tile details with '${ConveyorName}' '${CustCorpName}' '${CustSiteName}'
     And   Fill Cover Wear specifications
     Then  Verify the default positions
     And   Add position
     And   Edit Position with measurement
     Then  Verify edited position
     And   Download report
     And   Delete position
     And   Verify deleted position
     And   Navigate back to dashboard from cover wear
     And   Go to cover wear list screen
     And   Apply filter with customer corporate type as '${CustCorpName}'
     Then  Verify the site filter result for '${InspectionName}'
     When  Reset the filter
     Then  Verify the site filter result for '${InspectionName}'
     When  Verify user is able to delete inspection name '${InspectionName}'
     Then  Verify the deleted inspection '${InspectionName}'
