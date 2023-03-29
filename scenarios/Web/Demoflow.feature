Feature: Business Flow for Web

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Create_Flow
Scenario: Verify the create flow with admin user

    Given User is at Login page 
    When  Login with '${UserName}' and '${Password}'
    And   Check profile
    And   Create a Territory manager for India '${FullNameInd}' and '${Phone}' and '${EmailInd}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And   Create a Territory manager for Germany '${FullNameGer}' and '${Phone}' and '${EmailGer}' and '${ProfileType}' and '${UserPassword}' and '${RetypePassword}'
    And   Create a Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
    And   Create a Distributor shop in India with '${DistShopIndName}' and '${DistShopIndAddress}' and '${DistCorpName}' and '${FullNameInd}'
    And   Create a Distributor shop in Germany with '${DistShopGerName}' and '${DistShopGerAddress}' and '${DistCorpName}' and '${FullNameGer}'
    And   Create a Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'
    And   Create a Customer site in India '${CustSiteIndName}' and '${CustSiteIndAddress}' and '${CustCorpName}' and '${DistShopIndName}' and '${FullNameInd}'
    And   Create a Customer site in Germany with '${CustSiteGerName}' and '${CustSiteGerAddress}' and '${CustCorpName}' and '${DistShopGerName}' and '${FullNameGer}'
    And   Create a conveyor Germany with '${ConveyorNameGer}' and '${DistShopGerName}' and '${CustSiteGerName}'
    And   Create a conveyor India with '${ConveyorNameInd}' and '${DistShopIndName}' and '${CustSiteIndName}'
    And   Create a Distributor User for Germany '${FullNameDistGer}' and '${Phone}' and '${EmailDistGer}' and '${ProfileTypeDist}' and '${UserPassword}' and '${RetypePassword}' and '${CoporateRole}' and '${DistCorpName}' and '${DistShopGerName}' and '${CustSiteGerName}'
    Then  Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
	And   Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression
@dataFile:resources/data/TestData.xls
@key:Edit_Flow
Scenario: Verify the edit flow with admin user

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Check profile
    And   Create a conveyor Germany with '${ConveyorNameGer2}' and '${DistShopGerName}' and '${CustSiteGerName}'
    And   Edit '${ConveyorNameGer1}' to '${ConveyorNameGer1Edit}'
    And   Check '${ConveyorNameGer2}' at '${CustCorpName}'
    And   Edit '${ConveyorNameGer2}' into '${ConveyorNameGer2Edit}'
    And   Check '${ConveyorNameGer1}' at '${CustCorpName}'
    And   Edit '${ConveyorNameGer1Edit}' name to '${ConveyorNameGer1}'
    And   Check '${ConveyorNameGer1}' at '${CustCorpName}'
    And   Check '${ConveyorNameGer2Edit}' at '${CustCorpName}'
    And   Edit '${ConveyorNameGer2Edit}' name to '${ConveyorNameGer2}'
    Then  Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression
@dataFile:resources/data/TestData.xls
@key:John_Flow
    Scenario: Verify the list and create flow with John Doe user

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
	And   Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'
	And   Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
    And   Create a conveyor India with '${ConveyorNameInd}' and '${DistShopIndName}' and '${CustSiteIndName}'
    Then  Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression
@dataFile:resources/data/TestData.xls
@key:Max_Flow
    Scenario: Verify the list and create flow with Max Mustermann user

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
    And   Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'
    And   Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'
    And   Create a conveyor Germany with '${ConveyorNameGer}' and '${DistShopGerName}' and '${CustSiteGerName}'
    Then  Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'

@Regression
@dataFile:resources/data/TestData.xls
@key:Anna_Flow
    Scenario: Verify the list flow with Anna Mueller user

    Given User is at Login page
    When  Login with normal user '${UserName}' and '${Password}'
	Then  Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'
	And   Show list of conveyors, sites, corporates and users as an admin for Distributor Corporate with '${DistCorpName}' and '${DistCorpAddress}'

@Regression
@dataFile:resources/data/TestData.xls
@key:Permission_Flow
    Scenario: Verify the permission flow

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
	And   Change permission for '${FullNameGer}' to see "APAC"
	And   Logout from the current user
	And   Login with normal user '${UserNameTer}' and '${PasswordTer}'
    Then  Show list of conveyors, sites, corporates and users as an admin for Customer Corporate with '${CustCorpName}' and '${CustCorpAddress}'


@Regression
@dataFile:resources/data/TestData.xls
@key:Delete_Flow
    Scenario: Verify the Delete flow with admin user

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And   Delete everything '${DistCorpName}' and '${DistShopIndName}' and '${DistShopGerName}' and '${CustCorpName}' and '${CustSiteIndName}' and '${CustSiteGerName}' and '${ConveyorNameGer}' and '${ConveyorNameInd}' and '${ConveyorNameGerWeb}' and '${ConveyorNameInd2}' and '${ConveyorNameGer2}' and '${FullNameInd}' and '${FullNameGer}' and '${FullNameDistGer}'
