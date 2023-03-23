Feature: TestingWorkFlowD


Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_MM2


Scenario: TestingWorkFlowD

    Given User is at Login page  
	When  Login with '${UserName}' and '${Password}' 
	Then  Verify Home page is displayed 
	And   Click on FabricSpliceGenerator on left menu
	Then  Verify user is at Fabric splice list page
	And   List of previous designs should be available
	And   User should only see Approved status items at this stage 
	And   User should see Download button Next to Approved status Items 
	Then  User should use COLUMN SELECTION button to ensure the table is customizable
	And   User Should see Add button
	Then  Verify user navigate to input Page
	And   Designer Name should be Auto populated as Test Approver 2.FS
	And   Splice Drawing Number Should be Empty
	And   Calculate button should be disabled
	And   Customer Name : The results should be all the customer corporates in Contiplus grouped by Market with search function
	And   Conveyor Name: The results should display all the conveyors of the corporate selected grouped by the sites
	And   Approver Name: The results should display
	Then  Enter the required data into all fields
	And   Click on clear button
	And   Click on No button on popup
	And   Click on Calculate button
	And   The output fields results should be editable 
	And   Click on generate PDF button
