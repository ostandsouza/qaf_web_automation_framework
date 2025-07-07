@dataProvider:CSV_DataProvider
@dataProviderClass:com.common.utils.CSVDataProvider

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
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: zzzUpload file having wrong file format

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And Verify the failure message after uploading wrong format file with name '${File2}'

@CTCP-156
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Upload file having correct file format

    Then  Navigate to Conveyor Bulk Upload
    And Verify the success message after uploading file with name '${File}'


@CTCP-162
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify Analysis bar

    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'

@CTCP-163
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify bulk import report page

    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'
    And Verify import Report page data

@CTCP-164
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify back button

    Then  Navigate to Conveyor Bulk Upload
    And Verify upload back button functionality after uploading file with name '${File}'

@CTCP-159
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify back button functionality on Import screen

    Then  Navigate to Conveyor Bulk Upload
    And Verify conveyor analysis bar is displayed uploading file with name '${File}'
    And Select the update radio button in import report page
    And Click continue and Analysis Page is displayed
    Then Verify Back button and Imports Page is displayed

@CTCP-169
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Upload the file with more than 25 seconds

    Then  Navigate to Conveyor Bulk Upload
    And Verify the failure message after uploading wrong format file with name '${File3}'

@CTCP-153
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Download template sheet without selecting Distributor

    Then Navigate to Conveyor Bulk Upload
    And Click on site dropdown and select sites with '${Site1}' '${Site2}'
    Then Verify the excel data for '${Site1}' '${Site2}' with file '${FileName}'

@CTCP-149 @Regression9
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: zVerify the breadcrumb for conveyor bulk import

#    Given User is at Login page
#    When Login with '${UserName}' and '${Password}'
    Then Navigate to Conveyor Bulk Upload
    And  Verify the Conveyor Bulk Import bread crumb

@CTCP-157 @Regression10
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify deselecting the conveyor uploaded file

#    Given User is at Login page
#    When Login with '${UserName}' and '${Password}'
    Then Navigate to Conveyor Bulk Upload
    And  Verify user is able to upload file with name '${File}'
    When Delete the conveyor uploaded file
    And  Verify user is able to upload file with name '${File2}'

@CTCP-168 @Regression11
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify bulk upload conveyor in list screen

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Navigate to Conveyor Bulk Upload
    And   Add two conveyor via bulk upload in site '${CustSiteName}' with file '${FileUpload}'
    Then  Validate conveyor '${CustSiteName}' should display in list with same data as filled in exel sheet '${FileUpload}'

@CTCP-170 @Regression12
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify uploading conveyor files with no records

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And   Verify the failure message after uploading wrong format file with name '${File2}'

@CTCP-174 @Regression13
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify multiple site section for template download

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Download bulk upload template for distributor '${DistShop}' and with sites '${CustSiteName}' and '${CustSite2Name}'

@CTCP-176 @Regression14
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify all site section for template download

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Download bulk upload template for all sites

@CTCP-177 @Regression15
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify the cross mark functionality for multi site section dropdown

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Verify the multi site selection when close button is clicked

@CTCP-178 @Regression16
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify the scroll functionality for multi site section dropdown

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And   Verify the scroll functionality in multi dropdown

@CTCP-179 @Regression17
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify the conveyor import header arrow functionality

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Conveyor Bulk Upload
    And   Verify the bulk import arrow functionality

@CTCP-3495 @Regression18
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify conveyor profile column in single site template dropdown

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Download single site template for distributor '${DistShop}' and with sites '${CustSiteName}'
    Then  Verify the conveyor profile column is not present in bulk import template '${FileName}' for site '${CustSiteName}'

@CTCP-3625 @Regression19
@csvDataFile:resources/data/ConveyorBulkImport.csv
@filter:Env.equalsIgnoreCase('${env.setup}')
@key:CBI_001
Scenario: Verify conveyor profile column in multi site template dropdown

#    Given User is at Login page
#    When  Login with '${UserName}' and '${Password}'
    And   Download multi site template for distributor '${DistShop}' and with sites '${CustSiteName}' and '${CustSite2Name}'
    Then  Verify the conveyor profile column is not present in bulk import template '${FileName}' for site '${CustSite2Name}'


