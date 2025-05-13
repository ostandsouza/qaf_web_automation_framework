Feature: Login 

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_02

Scenario: Login with correct credentials with parameters
    Given User is at Login page  
	When  Login with '${UserName}' and '${Password}' 
	Then  Verify Home page is displayed 
	Given User is at home page
	And Click on users link
	Then User can view list of users page
	And Click on Add button
	Then User can view add user page
	When User enter all required details '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}' 
	And Click on Save and close button
	Then Admin navigated to user page with created new user
	And Click on profile and select logout button
	Then User is at login page
	
	
#Background: 
#Launch the application through '/'
	
#@Regression
#@dataFile:resources/data/TestData.xls 
#@key:Login_03

#Scenario: Login with correct credentials with parameters
#    Given User is at Login page  
#	When  Login with '${UserName}' and '${Password}' 
#	Then  Verify Home page is displayed 
#	Given User is at home page
#	And Click on users link
#	Then User can view list of users page
#	And Click on Add button
#	Then User can view add user page
#	When User enter the required details '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}' 
#	And Click on Save and close button
#	Then Admin navigated to user page with created new user
	
#@Regression
#@dataFile:resources/data/TestData.xls 
#@key:Login_04


#Scenario: Login with correct credentials with parameters
 #   Given User is at Login page  
#	When  Login with '${UserName}' and '${Password}' 
#	Then  Verify Home page is displayed 
#	Given User is at home page
#	And Click on users link
#	Then User can view list of users page
#	And Click on Add button	Then User can view add user page
#	When User enter required details '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}' 
#	And Click on Save and close button
#	Then Admin navigated to user page with created new user	
	
#@Regression
#@dataFile:resources/data/TestData.xls 
#@key:Login_05


#Scenario: Login with correct credentials with parameters
 #   Given User is at Login page  
#	When  Login with '${UserName}' and '${Password}' 
#	Then  Verify Home page is displayed 
#	Given User is at home page
#	And Click on users link
#	Then User can view list of users page
#	And Click on Add button
#	Then User can view add user page
#	When User enter required details '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}' 
#	And Click on Save and close button
#	Then Admin navigated to user page with created new user		
	
#@Regression
#@dataFile:resources/data/TestData.xls 
#@key:Login_06


#Scenario: Login with correct credentials with parameters
#    Given User is at Login page  
#	When  Login with '${UserName}' and '${Password}' 
#	Then  Verify Home page is displayed 
#	Given User is at home page
#	And Click on users link
#	Then User can view list of users page
#	And Click on Add button
#	Then User can view add user page
#	When User enter required details '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}' 
#	And Click on Save and close button
#	Then Admin navigated to user page with created new user		
	
	