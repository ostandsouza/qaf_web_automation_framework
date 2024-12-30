Feature: Regression of P1 Corporates module

Background:
Launch the application through '/'

@Regression1
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify with add company navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Navigate to Add Company screen

@Regression2
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorCorp
Scenario: Verify the distributor corporate creation

    When  Add Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'

@Regression3
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopCount
Scenario: Verify the distributor corporate Shop count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression4
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_MarketType
Scenario: Verify the distributor corporate Market type for newly added corporate

    Then  Verify market type '${Type}' for Corporate with name '${DistCorpName}'

@Regression5
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShop
Scenario: Verify the distributor Shop creation

    When  Add Distributor shop with '${DistShopName}' and '${DistShopAddress}' and '${DistCorpName}' and '${FullName}' and '${Territory}'

@Regression6
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopCountAfterAdd
Scenario: Verify the distributor Shop count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression7
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_MarketTypeShop
Scenario: Verify the distributor Shop Market type for newly added shop under corporate

    Then  Verify market type '${Type}' for Corporate with name '${DistCorpName}'

@Regression8
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerCorp
Scenario: Verify the customer corporate creation

    When  Add Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression9
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteCount
Scenario: Verify the customer Site count in corporate details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression10
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerSite
Scenario: Verify the Customer Site creation

    When  Add Customer site '${CustSiteName}' and '${CustSiteAddress}' and '${CustCorpName}' and '${DistShopName}' and '${FullName}' and '${Territory}'

@Regression11
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteCountAfterAdd
Scenario: Verify the Customer Site count in corporate details screen after adding new site

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify expected card count in details screen is '${Count}'

@Regression12
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify navigation to corporate list screen

    Then  Navigation of corporate list screen

@Regression13
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify navigation from corporate list to corporate details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'

@Regression14
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteDetail
Scenario: Verify navigation from corporate details screen to site details page

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Verify navigation to '${CustSiteName}' detail screen

@Regression15
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShopNav
Scenario: Verify navigation from corporate details screen to shop details page

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Verify navigation to '${DistShopName}' detail screen

@Regression16
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_imageUpload
Scenario: Verify image upload functionality

    When  Navigate to Add Company screen
    Then  Verify image upload functionality with '${ImageName}'

@Regression17
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistCorpDetails
Scenario: Verify distributor corporate dropdown in site creation flow

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    And   Go to add Corporates from details screen
    Then  Verify distributor corporate dropdown contains '${DistCorpName}'

@Regression18
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify customer corporate dropdown in site creation flow

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Go to add Corporates from details screen
    Then  Verify customer corporate dropdown contains '${CustCorpName}'

@Regression19
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_AddConveyor
Scenario: Verify Navigation to add conveyor from site details screen

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    When  Create a conveyor with '${ConveyorName}' and '${CustSiteName}'


@Regression20
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_AddConveyor
Scenario: Verify Navigation to Conveyor details screen from site page

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    Then  Verify navigation from site detail to conveyor details screen of '${ConveyorName}'

@Regression21
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CustomerSiteEdit
Scenario: Verify Edit site details

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    Then  Edit Customer site with '${CustSiteName}' and '${EditCustSiteName}' using corporate '${CustCorpName}'
    Then  Save edited Corporate changes

@Regression22
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistributorShopEdit
Scenario: Verify Edit shop details

    When  Navigate to Corporate details screen for corporate '${DistCorpName}'
    Then  Edit Customer shop with '${DistShopName}' and '${EditDistShopName}' using corporate '${DistCorpName}'

@Regression23
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_EditConveyor
Scenario: Verify Edit conveyor details

    When  Navigate to Corporate details screen for corporate '${CustCorpName}'
    And   Verify navigation to '${CustSiteName}' detail screen
    Then  Verify navigation from site detail to conveyor details screen of '${ConveyorName}'
    When  Edit Conveyor '${ConveyorName}' to '${EditConveyorName}'
    Then  Verify Edited conveyor details with '${EditConveyorName}' for Corporate '${CustSiteName}'

@Regression24
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_ShopDelete
Scenario: Verify Delete distributor shop from corporate

    When  Delete Distributor Shop for Corporate '${DistCorpName}' with '${EditDistShopName}'
    Then  Verify Deleted Distributor shop with '${DistCorpName}' with '${EditDistShopName}'

@Regression25
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_SiteDelete
Scenario: Verify Delete Customer site from corporate

    When  Delete Distributor Shop for Corporate '${CustCorpName}' with '${EditCustSiteName}'
    Then  Verify Deleted Distributor shop with '${CustCorpName}' with '${EditCustSiteName}'

@Regression26
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DeleteConveyor
Scenario: Verify Delete conveyor from site details

    When  Delete conveyor '${EditConveyorName}' customer site '${EditCustSiteName}' with Corporate name '${CustCorpName}'
    Then  Verify Deleted conveyor '${EditConveyorName}' customer site '${EditCustSiteName}' with Corporate name '${CustCorpName}'

@Regression27
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_DistCorpDetails
Scenario: Verify Company Distributor deletion from corporate list screen

    When  Delete Corporate with name '${DistCorpName}'
    Then  Verify Deleted corporate '${DistCorpName}'

@Regression28
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_CorpDetails
Scenario: Verify Company Customer deletion from corporate list screen

    When  Delete Corporate with name '${CustCorpName}'
    Then  Verify Deleted corporate '${CustCorpName}'

@Regression29 @CTCP-567
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:UserManagement_Master_Upload
Scenario: ZdVerify the image upload functionality

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And User navigates to Add coporates page
    Then Verify the default image is displayed and on hover camera icon is displayed
    And Verify on click of cameraIcon the Image viewer panel is displayed with upload preview cancel and save button
    When User clicks on Upload Image
    Then Verify that the user is able to upload the image '${imgName}' from the system
    When Crop the Image using the dots
    Then Click on Save and Verify the image is displayed

@Regression30 @CTCP-573
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Mandatory_Field
Scenario: ZcVerify mandantory field

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And User navigates to Add coporates page
    Then Verify '${mandatoryCount}' mandatory fields
    And Add Corporate fields '${companyName}' '${address}'
    Then Verify mandatory fields is filled

@Regression31 @CTCP-575
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Mandatory_Field
Scenario: ZbVerify BreadCrumb for coporates

    And User navigates to Add coporates page
    Then Verify the corporate bread crumb
    When Navigate to Add Company screen
    Then Verify the corporate bread crumb

@Regression32 @CTCP-576
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Blank_Field
Scenario: ZaVerify Company name as blank

    Then User navigates to Add coporates page
    And Add Corporate fields '${companyName}' '${address}'
    Then Verify company name as blank

@Regression33 @CTCP-2851
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_User_Creation
Scenario: WVerify the Territory and markets in ascending order

    Given User is at Login page
    When Login with '${UserName}' and '${Password}'
    And  Create a User with '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And  Add territory as '${Region1}' '${Region2}' '${Region3}' '${Region4}' for the user
    And  Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    And Logout from the current user
    And Login with normal user '${Email}' and '${UserPassword}'
    Then Verify territorys are in ascending order for '${FullName}'
    And Logout from the current user
    When Login with '${UserName}' and '${Password}'
    When  Delete User with name '${FullName}'
    Then  Verify user '${FullName}' is deleted


@Regression34 @CTCP-2852
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Usermanagement_User_Creation
Scenario: Verify the Territory and markets in ascending order after Edit

    And  Create a User with '${FullName}' and '${Phone}' and '${Email}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And  Add territory as '${Region}' for the user
    And  Add permission rights with '${Add}' '${Edit}' '${Delete}' '${View}' '${Download}' and create user
    Then  Edit assignments '${Region1}' '${Region2}' '${Region3}' and Markets for user '${FullName}'
    And  Logout from the current user
    And  Login with normal user '${Email}' and '${UserPassword}'
    Then Verify territorys are in ascending order for '${FullName}'
    And Logout from the current user
    When Login with '${UserName}' and '${Password}'
    When  Delete User with name '${FullName}'
    Then  Verify user '${FullName}' is deleted

@Regression29 @CTCP-1133
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Company_Navigation
Scenario: Verify with add company navigation

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    Then  Verify that site card is displayed in home page
    And Click on the site card and verify it navigates to site list screen

@Regression29 @CTCP-1142
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site
Scenario: Verify notification order after login with other user and try to update the data on multiple subscribed sites

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And subscribe the sites for the user '${Site1}' and '${Site2}'
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    Then Edit the subscribed sites '${Site1}' and '${ConveyorName}'
    And Edit the subscribed sites '${Site2}' and '${ConveyorName2}'
    And Logout from the current user
    And Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Verify user is getting notification in last in first out format
    And Unsubscribe the sites '${Site1}' and '${Site2}'

@Regression29 @CTCP-1135
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site
Scenario: Verify user to get the notification under bell icon after subscription of site

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Verify the notification count in bellIcon
    And subscribe the sites for the user '${Site1}' and '${Site2}'
    And Verify the notification count in bellIcon after subscription and verify user is not getting any notification
    And Unsubscribe the sites '${Site1}' and '${Site2}'

@Regression29 @CTCP-1143
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the functionality for login with admin and delete the site/conveyor that is subscribed

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And subscribe one site '${Site1}' for the user
    Then Verify the notification count in bellIcon
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Delete Customer site with '${Site1}'
    And Logout from the current user
    And Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Verify Deleted Customer site with '${Site1}'
    And Verify the notification count in bellIcon after subscription and verify user is not getting any notification

@Regression29 @CTCP-1145
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the page after click on view more from Notification bell icon

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Navigate to siteListPage and click on bellIcon
    And Click on View more button and verify the fields in notification list page

@Regression29 @CTCP-1146
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the page after click on view more from Notification bell icon

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Navigate to siteListPage and click on bellIcon
    Then Navigate to notifications List page
    And Verify the result after providing notification list value as conveyor/site '${NotificationFilter}'

@Regression29 @CTCP-1148
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the result after providing dates under fromDate toDate

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Navigate to siteListPage and click on bellIcon
    And Navigate to notifications List page
    And Verify user is unable to add toDate '${ToDate}' less than fromDate '${FromDate}'

@Regression29 @CTCP-1149
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the result after click on sort button from notification List page

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Navigate to siteListPage and click on bellIcon
    And Navigate to notifications List page
    And Click on sort button and verify that user is able to get notification in ascending/descending order

@Regression29 @CTCP-1151
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_AdminUser
Scenario: Verify the result after click on refresh button from notification List page

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Navigate to siteListPage and click on bellIcon
    And Navigate to notifications List page
    And Click on refresh button and verify that data is getting refreshed

@CTCP-1152
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: Verify result after click on 'New' link for latest Notification under Notifications list page.

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And subscribe one site '${Site1}' for the user
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Edit the subscribed sites '${Site1}' and '${ConveyorName1}'
    And Logout from the current user
    When Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Navigate to siteListPage and click on bellIcon
    Then Navigate to notifications List page
    And Verify new link is avaiable for the latest updated site/conveyor '${Site1}'
    And Click on view icon for the new notification
    Then Verify user can only see conveyor history of the particular subscribed conveyor '${ConveyorName1}' notification
    And Navigate to site list screen
    And Unsubscribe the site '${Site1}'

@CTCP-1164
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: Verify the functionality for Login with other user at Account level contains sam

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And subscribe the sites for the user '${Site1}' and '${Site2}'
    And Click on Clear filter Icon
    Then Verify the pinned subscription list '${Site1}'
    And Verify the pinned subscription list '${Site2}'
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Search and verify the '${Site1}' is present
    Then Verify the unPinned subscription list '${Site1}'
    And Search and verify the '${Site2}' is present
    And Verify the unPinned subscription list '${Site2}'
    And Logout from the current user
    And Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Unsubscribe the sites '${Site1}' and '${Site2}'

@CTCP-1203 @CTCP-2637 @CTCP-2643
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: ZVerify the user un-read notification count over bell icon after reading all the Notifications.

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Verify the notification count is present in bellIcon
    And Navigate to siteListPage and click on bellIcon
    Then Click on Mark all as Read for notification
    Then Verify the notification count is zero in bellIcon


@CTCP-2639 @CTCP-2641 @CTCP-2645 @CTCP-2647
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: Verify the 'Actions' button under Notifications list page.

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
#    And subscribe one conveyor '${ConveyorName1}' for the user
    And subscribe one site '${Site1}' for the user
    Then Verify the notification count in bellIcon
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Navigate to conveyor details screen for conveyor '${ConveyorName1}'
    And Edit Conveyor belt width value '${BeltWidth1}'
    And Logout from the current user
    And Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Verify the notification count in bellIcon after subscription and verify user is getting any notification
    Then Navigate to siteListPage and click on bellIcon
    And Navigate to notifications List page
    And Verify Action button is visible under notification list page
    And Verify action button is enabled when user has new notification
    And Click on the action button and verify user can see Mark all as read with eye symbol
    And Click on the action button mark all as read button
    And Verify action button is disabled when user has no new notification
    And Verify all notifications are moved to read status
#    And wait for conveyors to load
#    And Unsubscribe the site '${ConveyorName1}'
    And Navigate to site list screen
    And Unsubscribe the site '${Site1}'

@CTCP-2649
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: Click on 'Mark all as read' link at Notification popup and verify the functionality(Territory Manager).

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    And Verify the notification count is present in bellIcon
    And Navigate to siteListPage and click on bellIcon
    Then Click on Mark all as Read for notification
    Then Verify the notification count is zero in bellIcon

@CTCP-2651 @CTCP-2653
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:Notification_Site_Update
Scenario: Click on 'Mark all as Read' from Actions dropdown under Notifications list page then verify the functionality (Territory Manager).

    Given User is at Login page
    When  Login with '${UserNameTerritory}' and '${PasswordTerritory}'
#    And subscribe one conveyor '${ConveyorName1}' for the user
    And subscribe one site '${Site1}' for the user
    Then Verify the notification count in bellIcon
    And Logout from the current user
    And Login with '${UserName}' and '${Password}'
    And Navigate to conveyor details screen for conveyor '${ConveyorName1}'
    And Edit Conveyor belt width value '${BeltWidth1}'
    And Click on home link in breadCrumb and verify it navigates to home page
    And Logout from the current user
    And Login with '${UserNameTerritory}' and '${PasswordTerritory}'
    Then Verify the notification count in bellIcon after subscription and verify user is getting any notification
    Then Navigate to siteListPage and click on bellIcon
    And Navigate to notifications List page
    And Verify Action button is visible under notification list page
    And Verify action button is enabled when user has new notification
    And Click on the action button and verify user can see Mark all as read with eye symbol
    And Click on the action button mark all as read button
    And Verify action button is disabled when user has no new notification
    And Verify all notifications are moved to read status
#    And wait for conveyors to load
#    And Unsubscribe the site '${ConveyorName1}'
    And Navigate to site list screen
    And Unsubscribe the site '${Site1}'