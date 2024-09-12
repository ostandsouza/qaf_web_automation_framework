@Regression1 @CTCP-2042
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Email and password Validation with correct userName,correct password and login button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'

@Regression2 @CTCP-2045
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_IncorrectEmail
Scenario: Email and password validation with incorrect email-id and correct password

    Given Verify user is on continental login page
    And   Login to the application with email-Id '${UserName}' and password '${Password}'
    Then Click on the login button and verify error message is displayed

@Regression3 @CTCP-2048
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Email and password validation with incorrect email-id and blank password

    Given Verify user is on continental login page
    And   Login to the application with email-Id '${UserName}' and blank password
    Then Click on the login button and verify error message is displayed for blank password

@Regression4 @CTCP-2059
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Validating the terms and conditions

    Given Verify user is on continental login page
    Then Click on the terms and conditions and verify user is navigated to terms and conditions page and view the details

@Regression5 @CTCP-2103
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Validating back arrow button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Click on the settings icon in the My Profile page and verify it navigates to Settings page
    And Navigate back to My profile screen

@Regression6 @CTCP-2109
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Validating profile field

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Verify the profile type for user '${UserName}'

@Regression7 @CTCP-2116
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Validating change password button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Go to profile information page and click on change pwd button and verify navigation

@Regression8 @CTCP-2121
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Validating logout button

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Verify user is able to logout from app

@Regression9 @CTCP-2072
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify Navigation to site list page

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Click on site card and verify navigation to site list page


@Regression10 @CTCP-2073
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify Navigation to conveyor list page

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Verify that the conveyor tile is visible in home page and click on it

@Regression11 @CTCP-2074
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify Navigation to inspection list page

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Click on inspections and verify user is able to open inspections

@Regression12 @CTCP-2076
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario:  Validating Filter functionality

    Given Verify user is on continental login page
    And   Login to the application with '${UserName}' and '${Password}'
    Then Click on filter functionality and verify user is able to see the popup with header as filter