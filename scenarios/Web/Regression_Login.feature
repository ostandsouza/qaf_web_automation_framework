Feature: Regression for Login feature

Background:
  Launch the application through '/'

@LoginRegression1 @Regression
Scenario: Verify Login Screen
  Given User is at Login screen

@LoginRegression2 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Login with valid email and valid password
  Given User is at Login screen
  When Login with '${UserName}' and '${Password}'
  Then Verify Home page is displayed

@LoginRegression3 @Regression
Scenario: Verify forgot password link
  Given User is at Login screen
  And Forgot password link is present
  When User Clicks on Forgot password link
  Then User should see forgot password screen

@LoginRegression4 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify get verification code with valid email
  Given User is at Forgot password screen
  When User clicks on Get verification code with valid '${UserName}'
  Then User should land on Reset password page


@LoginRegression5 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify reset password page
  Given User is at Forgot password screen
  When User clicks on Get verification code with valid '${UserName}'
  Then Verify reset password page

@LoginRegression6 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify submit button
  Given User is at Forgot password screen
  When User clicks on Get verification code with valid '${UserName}'
  And User enters '${UserName}' Secret Code '${Password}'
  And Click on submit
  Then User should see login screen

@LoginRegression7 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify reset password link in email (with in 24 hours)
  Given User is at Forgot password screen
  When User clicks on Get verification code with valid '${UserName}'
#  Then User should see Reset password link in email

@LoginRegression8 @Regression
Scenario: Verify verify link on login page
  Given User is at Login screen
  And Verify link is present
  When User clicks on verify link
  Then User should see Verify screen

@LoginRegression9 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify submit button with valid email/secret code
  Given User is at Login screen
  And User clicks on verify link
  When User enters '${UserName}' and secret code
  Then User should be able to click on submit button

@LoginRegression10 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify user profile after login
  Given Login with '${UserName}' and '${Password}'
  And User is at home page
  When User clicks on Profile
  Then User Profile should be seen

@LoginRegression11 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Profile_Image
Scenario: Verify profile picture
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User click on image '${ImageName}'

  @LoginRegression12 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Actions button
  Given User is at Login screen
  And Login with '${UserName}' and '${Password}'
  When User clicks on Profile
  Then User should see Action button

@LoginRegression13 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify delete profile panel
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User clicks on Action button dropdown
  Then User should see delete option

@LoginRegression14 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Message on delete profile
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Delete option in Profile page
  Then User should see Popup with message


@LoginRegression15 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify text input field (Yes)
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Delete option in Profile page
  And User enters the text in the text box as shown in the message
  Then Yes button should be enabled


@LoginRegression16 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Logout
  Given Login with '${UserName}' and '${Password}'
  When User click on Logout
  Then User should see login screen

@LoginRegression17 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify change password
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Profile
  Then User should see Change password

@LoginRegression18 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Update button
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User enters New Password '${Password}' and Confirm New Password
  Then Update button should be enabled

@LoginRegression19
Scenario: Verify reset password link in email (morethan in 24 hours)

@LoginRegression20 @Regression
Scenario: Verify Terms of use link on login page
  When User clicks on Terms of use link
  Then User should see Terms of use page

@LoginRegression21 @Regression
Scenario: Verify Privacy policy link on login page
  When User clicks on Privacy policy link
  Then User should see Privacy policy page

@LoginRegression22 @Regression
Scenario: Verify Imprint link on login page
  When User clicks on Imprint link
  Then User should see Imprint page

@LoginRegression23 @Regression
Scenario: Verify Legal Notice on login page
  When User clicks on Legal Notice link
  Then User should see Legal Notice page

@LoginRegression24 @Regression
Scenario: Verify browser back button
  Given User clicks on Legal Notice link
  When User clicks on browser back button
  Then User should see login screen

@LoginRegression25 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify profile navigation
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Profile
  Then User should see profile page

@LoginRegression26 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify bread crumb of the page
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Profile
  Then User should see user profile bread crumb

@LoginRegression27 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify text input field (No)
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Delete option in Profile page
  And  User clicks on No button
  Then User should see profile page

@LoginRegression28 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify cookie settings in profile menu
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Cookie Settings
  Then User should see Cookie Settings page

@LoginRegression29 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Terms of use link in profile menu
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Terms of use
  Then User should see Terms of Service page

@LoginRegression30 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Privacy policy link in profile menu
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Privacy policy
  Then User should see Privacy policy page

@LoginRegression31 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Imprint link in profile menu
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Imprint
  Then User should see Imprint page


@LoginRegression32 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify reset button
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  And User enters Current '${Password}' and NewPassword and ConfirmPassword
  When User clicks on Reset button
  Then All entered password feild should get cleared

@LoginRegression33  @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_ErrorPassword
Scenario: Verify error message on password update
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User enters '${CurrentPassword}' and '${NewPassword}' and '${ConfirmNewPassword}'
  Then Verify the error message shown

@LoginRegression34 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_DifferentNewAndConfirmPassword
Scenario: Verify Update button when New and Confirm New passwords are not matching.
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User Enters Current '${Password}' and New Password and different '${ConfirmPassword}'
  Then Update button should be disabled

@LoginRegression35
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_WrongCurrentPassword # Error message is not clear
Scenario: Click on Update button and verify the functionality when 'Current Password' is invalid and both New & Confirm New passwords are valid.
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User enters '${CurrentPassword}' and New '${Password}' and ConfirmPassword and clicks on Update
  Then User should see error toast message






