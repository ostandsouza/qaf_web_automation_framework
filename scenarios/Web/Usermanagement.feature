Feature: Usermanagement

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:UserManagement

Scenario: User Management flow
    Given User is at Login page  
	When  Login with '${UserName}' and '${Password}' 
	#Then  Verify Home page is displayed 
	And  Click on users link
	Then User can view list of users page
	And Click on Add button
	Then User can view add user page
	When User enter required details '${FullnameMaster}' and '${Phone}' and '${Profiletypemaster}' and '${Userpassword}' and '${Retypepassword}' and '${Templatename}'
	And Verify Edit user
	And Verify Delete user '${FullnameMaster}'
	And Click on Add button
	When User enter required detail '${FullnameMarketManager}' and '${Phone}' and '${Profiletypemarketmanager}' and '${Userpassword}' and '${Retypepassword}' and '${Templatename}'
	#Then Admin navigated to user page with created new user	
	And Click on Add button
	When User enter all required details '${Fullnametr}' and '${Phone}' and '${Profiletypetr}' and '${Userpassword}' and '${Retypepassword}' 
	And Click on Add button
	#And Click on Save and close button
	#Then Admin navigated to user page with created new user
	#And Click on profile and select logout button
	#And Click on Add button
	#Then User can view add user page
	When User enter the required details '${Fullnamescu}' and '${Phone}' and '${Profiletypescu}' and '${Userpassword}' and '${Retypepassword}'	
	And Click on Add button 
	#And Click on Save and close button
#	Then Admin navigated to user page with created new user
    When User enter the required details db user '${Fullnamedb}' and '${Phone}' and '${Profiletypedb}' and '${Userpassword}' and '${Retypepassword}' 
	#And Click on Add button
	#When User enter the required details cu user '${Fullnamecu}' and '${Phone}' and '${Profiletypecu}' and '${Userpassword}' and '${Retypepassword}'
	
	
