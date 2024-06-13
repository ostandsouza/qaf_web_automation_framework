Feature: Regression of P2 Conveyor bulk Upload module

Background:
Launch the application through '/'

#@CTCP-153
#@dataFile:resources/data/TestData.xls
#@sheetName:Regression
#@key:Conveyor_Bulk_Upload
#Scenario: Download template sheet without selecting Distributor
#
#    Given User is at Login page
#    When Login with '${UserName}' and '${Password}'
#    And  Navigate to Conveyor Bulk Upload
#    Then Click on distributor dropdown and select name '${Distributor}'

@CTCP-155
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Upload file having wrong file format

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify the failure message after uploading wrong format file with name '${File2}'

@CTCP-156
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Upload file having correct file format

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify the success message after uploading file with name '${File}'


@CTCP-162
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Verify Analysis bar

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'

@CTCP-163
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Verify bulk import report page

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'
    And Verify import Report page data

@CTCP-164
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Verify back button

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify upload back button functionality after uploading file with name '${File}'



@CTCP-159
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Verify back button functionality on Import screen

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'
    And Select the update radio button in import report page
    And Click continue and Analysis Page is displayed
    Then Verify Back button and Imports Page is displayed

@CTCP-169
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Upload the file with more than 25 seconds

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify the failure message after uploading wrong format file with name '${File3}'

@CTCP-153
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Conveyor_Bulk_Upload
Scenario: Download template sheet without selecting Distributor

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then Navigate to Conveyor Bulk Upload
    And Click on site dropdown and select sites with '${Site1}' '${Site2}'
    Then Verify the excel data for '${Site1}' '${Site2}' with file '${FileName}'


