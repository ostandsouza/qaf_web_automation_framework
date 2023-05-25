Feature: Regression of P1 User bulk Upload module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Navigation
Scenario: Verify with User Bulk Upload Navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to User Bulk Upload

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Navigation
Scenario: Verify the sections in bulk import

    And   Navigate to User Bulk Upload
    Then  Verify the sections is bulk import

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Navigation
Scenario: Verify template for different users

    And   Navigate to User Bulk Upload
    Then  Select '${UserType}' and verify the UI

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify the download template

    And   Navigate to User Bulk Upload
    Then  Download bulk upload template for '${UserType}' and '${Corp}'

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify the file upload selection

    And   Navigate to User Bulk Upload
    Then  Upload file with name '${File}'

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify success message after file upload

    And   Navigate to User Bulk Upload
    Then  Verify the success message after uploading file with name '${File}'

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify the analyze results for user upload

    And   Navigate to User Bulk Upload
    Then  Verify bulk upload analysis result after uploading file with name '${File}' having count '${Count}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify success message after file upload

    And   Navigate to User Bulk Upload
    Then  Verify bulk upload analysis toast message after uploading file with name '${File}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify bulk user import functionality

    And   Navigate to User Bulk Upload
    Then  Verify bulk user import functionality after uploading file with name '${File}' and user type '${UserType}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify the header in the template

    And   Navigate to User Bulk Upload
    Then  Verify bulk upload template Columns for '${UserType}' and file '${File}'

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify bulk creation of the user

    Then  Validate User '${File}' should display in list with same data as filled in excel sheet '${UserType}'

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserBulkUpload_Users
Scenario: Verify bulk upload permission

    Then   Navigate to User Bulk Upload