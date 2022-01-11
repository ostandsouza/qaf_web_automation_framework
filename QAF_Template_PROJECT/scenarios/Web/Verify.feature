Feature: Verify 

Background: 
Launch the application through '/'


@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_TM 

Scenario: Verify the email with secret code
   Given User is at Login page  
   And Click on verify link
   When  Verify with '${Randomemail}' and '${Secret}' 
   Then  Verify Success message is displayed
