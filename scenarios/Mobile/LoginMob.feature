Feature: Regression Flow for Mob

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
    Then Click on filter fun

  @CTCP-2041
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario: Login Page Validation

    Given Verify user is on continental login page
    And  Verify UserName and Password field is present

  @CTCP-2043
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario: Validating back button in welcome Page

    Given Verify user is on continental login page
    And  Verify UserName and Password field is present
    And Click on back button
    Then Verify user is in welcome page

  @CTCP-2047
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials_Blank_Email
  Scenario: Email and password validation with blank email-id and correct password

    Given Verify user is on continental login page
    And  Verify UserName and Password field is present
    And User login to the application with '${UserName}' and '${Password}'
    Then Verify Email field error message

  @CTCP-2049
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario: Validating forgot password button

    Given Verify user is on continental login page
    And  Verify UserName and Password field is present
    And Click and Verify Forget Password button
    And Enter email '${ForgottenEmail}' for Forgot Password

  @CTCP-2099
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario: Validating settings button

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Click and Verify navigation to Settings Screen

  @CTCP-2108
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario: Validating back button

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Navigate back to Home screen from My Profile Page

  @dataFile:resources/data/TestData.xls
  @sheetName:Regression

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Navigate to user My Information screen
    And Verify Fields of My Information screen

  @CTCP-2120
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario:Enter different password in new,confirm password and submit button in verification page

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    Then Navigate to user My Profile screen
    And Verify change password from '${Password}' to '${NewPassword}' and '${RetypeNewPassword}'
    And Verify Retype password error message

  @CTCP-2270
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Inspection_Mobile
  Scenario: Validating + button functionality

    Given Verify user is on continental login page
    And  Login to the application with '${UserName}' and '${Password}'
    And Verify user present in home screen
    And Verify add button functionality in home screen