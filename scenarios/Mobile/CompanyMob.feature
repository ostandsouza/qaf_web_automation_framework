Feature: Regression Flow for Mob

@CTCP-2171
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Mandatory_Field
Scenario: Verify navigation to add corprate Page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Click on corporate symbol and verify it navigates to corporate list page
    Then Navigate to Add Corporate Page
    And Verify default type of company field
    And Go back to conveyor list screen
    Then Navigate to Add Site Page
    And Verify default type of company field


@Regression1 @CTCP-2164
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Navigate to corporate list table

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Verify the heading of corporate list page
    And Verify the fields in the header of the corporate list page


@Regression2 @CTCP-2180
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify back button functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Navigate to Add Corporate Page
    And Verify back button is visible next to add corporate heading
    And Click on back button and verify it navigates to corporate list page


@Regression3 @CTCP-2182
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Add_DistributorCorporate
Scenario: Add Distributor Corporate

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then User navigates to the Add Corporate Page with '${DistCorpName}'
    And Click on type of company and verify the dropdown
    And Verify user is able to select distributor corporate from the dropdown
    And Create a distributor corporate with '${DistCorpName}' '${Address}' and logo '${CompanyLogo}'
    And Navigate to corporate list and verify '${DistCorpName}' is present
    And Click on '${DistCorpName}' company name and verify it navigates to details screen and verify the heading
    And Click on corporate card and verify it navigates to company detail page
    And Verify the user filled details in company page '${DistCorpName}'

@Regression4 @CTCP-2184
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Add_DistributorCorporate
Scenario: Add Customer Corporate

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then User navigates to the Add Corporate Page with '${CustCorpName}'
    And Click on type of company and verify the dropdown
    And Verify user is able to select customer corporate from the dropdown
    And Create a distributor corporate with '${CustCorpName}' '${Address}' and logo '${CompanyLogo}'
    And Navigate to corporate list and verify '${DistCorpName}' is present
    And Click on '${CustCorpName}' company name and verify it navigates to details screen and verify the heading
    And Click on corporate card and verify it navigates to company detail page
    And Verify the user filled details in company page '${CustCorpName}'



@Regression5 @CTCP-2165
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_MobCustomerSite
Scenario: Verify Search functionality in corporate list page

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Verify the heading of corporate list page
    And Click on search icon and verify the placeholder and back button
    And Search for the corporate '${CustCorpName}' and verify matched string is displayed
    And Click on '${CustCorpName}' corporate  and verify it navigates to corporate details screen

@Regression6 @CTCP-2168
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_MobCustomerSite
Scenario: Verify fields displayed in corporate list screen

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Verify the heading of corporate list page
    And Search for a corporate '${CustCorpName}' and verify the fields in corporate list screen

@Regression7 @CTCP-2172
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_MobCustomerSite
Scenario: Verify links displayed in the footer

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Verify the links displayed in the footer
    And Click on the links in the footer and verify it navigates to respective pages


@Regression8 @CTCP-2174
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Filter
Scenario: Verify filter when all fields are selected

    Given Verify user is on continental login page
    And   Login to the application with '${Email}' and '${Password}'
    Then Verify that the corporate symbol is visible in the footer
    And Click on corporate symbol and verify it navigates to corporate list page
    And Click on the filter Icon and select the corporate type and territory '${Territory}' from the dropdown
    And Select the corporates '${CustCorp}' and '${CustCorp2}'  via checkbox and save and verify redirection to Corporate list page
    And Look for the data in Corporate List page and verify it shows only filtered data '${CustCorp}' and '${CustCorp2}'

@CTCP-2181
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify fields displayed in add corporate screen

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    Then Navigate to add corporate page from Corporate list page
    And Verify add corporate heading
    And Verify add corporate fields

@CTCP-2183
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify duplicate corporate check

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    Then Navigate to add corporate page from Corporate list page
    And Add a Distributor corporate with '${CorpName}' '${Address}'
    And Verify duplicate corporate creation

@CTCP-2167
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_List_Data
Scenario: Verify data displayed in corporate list screen

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    And Verify data displayed in the Corporate list screen
    Then Verify navigation to corporate details screen for '${CorpName}'

@CTCP-2169
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_List_Data
Scenario: Verify count of site/shop displayed on corporate list

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    And Navigate to corporate list and verify '${CorpName}' is present
    And Extract the site count from corporate list page
    Then Navigate to '${CorpName}' detail Page and verify the site count in the corporate detail page

@CTCP-2173
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Verify filter functionality

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    And Click on filter icon
    And Verify fields in the filter pop up for corporate list

@CTCP-2179
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Navigate to add corporate page from Home Page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Navigate to add corporate page via Home and verify navigation
    And Verify add corporate heading
    And Verify default type of company field for Corporate

@CTCP-2176
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Corporate_Mandatory_Field
Scenario: Remove filter functionality check

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And  Click on corporate symbol and verify it navigates to corporate list page
    And Click on filter icon
    And Add descending order filter
    And Click on filter icon
#    And Verify filter is applied
    And Click clear filter
    And Verify clear filter
