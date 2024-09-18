Feature: Regression Flow for Mob

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

  @CTCP-2113
  @dataFile:resources/data/TestData.xls
  @sheetName:Regression
  @key:Login_Credentials
  Scenario:Validating fields in my information page

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