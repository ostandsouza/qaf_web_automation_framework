Feature: Rehression Flow for Mob

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

#@CTCP-2171 downoaddddd
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Company_Mandatory_Field
#Scenario: Verify navigation to add corprate Page
#
#    Given Verify user is on continental login page
#    And  Login to the application with '${UserName}' and '${Password}'
#    And  Click on corporate symbol and verify it navigates to corporate list page
#    Then Navigate to Add Corporate Page