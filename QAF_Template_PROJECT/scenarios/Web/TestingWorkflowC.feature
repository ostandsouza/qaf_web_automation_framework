Feature: TestingWorkFlowC


Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_MM1


Scenario: TestingWorkFlowC

    Given User is at Login page  
	When  Login with '${UserName}' and '${Password}' 
	Then  Verify Home page is displayed 
	And   Click on FabricSpliceGenerator on left menu
	Then  Verify user is at Fabric splice list page
	And   List of previous designs should be available
	And   User should see Approved status items and In review
	And   User should see Download button Next to Approved status Items
	Then  User should use COLUMN SELECTION button to ensure the table is customizable
	And   User Should see Add button
	Then  Verify user navigate to input Page
	And   User should be able to click on View button and see the whole input and out put areas. - View Only
	And   The user should be able to see Save as PDF button, but not Save as Draft 
	And   The user should see the designer's name and his comments
	And   The user should see comments box to type in his comments
	And   The user should see Approve or Reject Button
	And   This selection should navigate him back to register/list and update the status bar accordingly
	