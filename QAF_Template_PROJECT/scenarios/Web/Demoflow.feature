Feature: Demo1flow

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_Demo


Scenario: Verify the business demo flow

    Given User is at Login page 
    When  Login with '${UserName}' and '${Password}' 
    And   Check profile
    And   Create a Territory manager for India John Doe '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}'
    And   Create a Territory manager for Germany Max Mustermann '${Fullname1}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}'
    And   Create a Distributor Corporate Belt Associates Corp '${companyname}'
    And   Create a Distributor shop in India Belt Associates India with TM John Doe
    And   Create a Distributor shop in Germany Belt Associates Germany with TM Max Mustermann
	And   Create a Customer Corporate Mining Corp
	And   Create a Customer site in India  Mining Corp. India with Distrib Belt Associates India
	And   Create a Customer site in Germany Mining Corp. Germany with Distrib Belt Associates Germany
	And   Create a conveyor C1 Germany at Mining Corp. Germany
	And   Create a conveyor C1 India at Mining Corp. India
	And   Show list of conveyors, sites, corporates and users as an admin 
	And   Show site page, conveyor page
    