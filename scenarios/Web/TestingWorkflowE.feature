Feature: TestingWorkFlowE


Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_MU


Scenario: TestingWorkFlowE

    Given User is at Login page  
	When  Login with '${UserName}' and '${Password}' 
	Then  Verify Home page is displayed 
	And   Click on FabricSpliceGenerator on left menu
	Then  Verify user is at Fabric splice list page
	And   List of previous designs should be available
	And   User should see all Approved status items and In review irrespective of who is the designer, approver and status
	And   User Should see Add button
	Then  Verify user navigate to input Page
	And   User should be able to click on View button and see the whole input and out put areas. - View Only
	And   The user should be able to see Save as PDF button and Save as Draft 
	And   The user should see the designer's name and his comments
#	And   The user should see comments box to type in his comments
#	And   The user should see Approve or Reject Button
#	And   This selection should navigate him back to register/list and update the status bar accordingly.
#	And   Logout as Test admin.FS