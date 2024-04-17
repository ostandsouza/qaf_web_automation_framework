Feature: Regression for Login feature

  Background:
  Launch the application through '/'

@Regression1 @CTCP-1363
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserManagement_Master
Scenario: Verify the breadcrumb functionality of the page

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then Verify user is on the home page of the application
    And Click on coverWear card and verify it navigates to coverWear list page
    And Verify the breadCrumb of coverWear page
    And Click on home link in breadCrumb and verify it navigates to home page

@Regression2 @CTCP-1374
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify search functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    Then Look for the searchBar in the table and verify search icon and search placeholder is visible
    When Enter the text '${searchItem}' to search
    And Verify the matching result is displayed or No record found message should display

@Regression3 @CTCP-1376
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of clear filter

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    When Apply sorting or filter on column name
    Then Verify that the filter is applied
    And Click on clear filter and verify filter is removed

@Regression4 @CTCP-1373
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of column name

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    Then Click on the column name and verify the column names
    And Select any column name to be displayed and verify the column is displayed


@Regression5 @CTCP-1375
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Item
Scenario: Verify the functionality of sorting

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    Then Click on column header and verify sorting should be in increasing order
    And Click on column header again and verify sorting should be in decreasing order


@Regression6 @CTCP-1364
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:CoverWear_Durometer
Scenario: Verify the count displayed in cover wear card

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to cover wear listing screen
    Then Look for the count displayed in yellow of durometer and verify the count
    And Look for the count displayed in red of durometer and verify the count
    Look for the count displayed in green of durometer and verify the count



