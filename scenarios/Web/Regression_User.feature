Feature: Regression for Login feature

  Background:
  Launch the application through '/'

@UserRegression1 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario: Verify Navigation to Add users page
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  And Clicks on add user button
  Then User can view add user page

@UserRegression2 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Create continental user as "Master"
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create a Master '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page

@UserRegression3 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MarketManagerUser
Scenario:  Create continental user as "Market Manager"
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create Market manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page

@UserRegression4 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_TerritoryManagerUser
Scenario: Create continental user as "Territory Manager"
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create a Territory Manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page

@UserRegression5 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_StandardContinentalUser
Scenario:  Create continental user as "Standard continental user"
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create a Standard continental user '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page

@UserRegression6 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_DistributorUser
Scenario:  Create continental user as "Distributor user"
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When  Create Distributor User '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${DistShopName}' and '${CustSiteName}'
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page


@UserRegression7 @Regression @Create
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_CustomerUser
Scenario:  Create continental user as "Customer user"
    Given Login with '${UserName}' and '${Password}'
    And User is in add user page
    When  Create a Customer user '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${CustSiteName}'
    And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  The user '${FullName}' should get save and redirect to user list page

@UserRegression8 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_TemplateName
Scenario:  Verify Create Template functionality
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When  Create Customer user '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${CustSiteName}'
  And Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and Click on save template
  Then user enters '${TemplateName}' and click on save button
  When Click on template dropdown and check for created '${TemplateName}'
  Then User should see preferred permission'${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@UserRegression9 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_TemplateName
Scenario:  Verify delete template functionality
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When  Create Customer user '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${CustSiteName}'
  And   Add territory as '${Region}' for the user
  And select the '${TemplateName}' form dropdown and click on delete
  Then User should see delete popup

@UserRegression10 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Verify the assignments for a master user
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see entered '${Region}' for the user

@UserRegression11 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MarketManagerUser
Scenario:  Verify the assignments for a Market Manager
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see entered '${Region}' for the user

@UserRegression12 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_TerritoryManagerUser
Scenario:  Verify the assignments for a Territory Manager
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see entered '${Region}' for the user

@UserRegression13 #has bug
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_StandardContinentalUser
Scenario:  Verify the assignments for a Standard Continental user
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see the entered '${Region}' for the user

@UserRegression14 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_DistributorUser
Scenario:  Verify the assignments for a distributor user
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see the entered '${DistShopName}' and '${CustSiteName}' for the user

@UserRegression15 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_CustomerUser
Scenario:  Verify the assignments for a customer user
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see the entered '${CustSiteName}' for the user

@UserRegression16 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MarketManagerUser
Scenario:  Verify the permissions for a market manager user
  Given Login with '${UserName}' and '${Password}'
  When User search for '${FullName}' and click on arrow
  Then User should see entered Permissions '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'

@UserRegression17 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MarketManagerUser
Scenario:  Verify the permissions of Inspection module
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create Market manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user and clikc on next
  And Click on Inspection Arrow
  Then User should see available modules


@UserRegression18 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MarketManagerUser
Scenario:  Verify master user can create any other type of user
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When Create a Territory Manager '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
  And   Add territory as '${Region}' for the user
  And   Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
  Then  The user '${FullName}' should get save and redirect to user list page
  When User click on Logout
  Then User should see login screen
  When User clicks on verify link
  And User enters '${Email}' and secret code and click submit
  When Login with Created user '${Email}' and '${UserPassword}'
  Then Verify Home page is displayed


@UserRegression19 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_EditDelete
Scenario:  Verify same user can edit/delete account
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Users link present in navigation bar
  When User search for '${FullName}' and click on check box
  And Click on Action button and edit option
  And User enters new phone number and clicks on Update
  Then Changes should apply and user should be directed to user list page
  When User search for '${FullName}' and click on check box
  And click on Action button and delete option
  Then User should see Delete popup

@UserRegression20 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario:  Navigate to Users List page
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  Then User can view list of users page

@UserRegression21 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Login_Credential
Scenario:  Add user from Users list table
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  And Clicks on add user button
  Then User can view add user page

@UserRegression22 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Delete user from list table
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  Then Action button should not be clickable
  When User search for '${FullName}' and click on check box
  And click on Action button and delete option
  Then User should see Delete popup

@UserRegression23 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Update user from list table
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  Then Action button should not be clickable
  When User search for '${FullName}' and click on check box
  And Click on Action button and edit option
  And User enters new phone number and clicks on Update
  Then Changes should apply and user should be directed to user list page

@UserRegression24 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Verify save as template button (Bydefault)
  Given Login with '${UserName}' and '${Password}'
  When User clicks on Users link present in navigation bar
  Then Action button should not be clickable
  When User search for '${FullName}' and click on check box
  And Click on Action button and update permission option
  Then Verify save as template button should be disabled


@UserRegression25 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  Verify save as template button (After selection)
    Given Login with '${UserName}' and '${Password}'
    When User clicks on Users link present in navigation bar
    Then Action button should not be clickable
    When User search for '${FullName}' and click on check box
    And Click on Action button and update permission option
    And Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}'
    Then Verify save as template button should be enabled


@UserRegression26 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_MasterUser
Scenario:  verify user is able to generate the password on users screen
  Given Login with '${UserName}' and '${Password}'
  And User is in add user page
  When User Clicks on Generate Password
  Then Password should be generated

@UserRegression27 @Regression
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_ChangePassword
Scenario: Verify the user is able to update the password
  Given Login with '${UserName}' and '${Password}'
  And User clicks on Profile
  When User enters New Password '${Password}' and Confirm '${UserPassword}' and click on Update
  And User click on Logout
  Then User should see login screen
  When Login with '${UserName}' and '${UserPassword}'
  Then Verify Home page is displayed





