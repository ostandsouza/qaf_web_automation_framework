Feature: TestingWorkFlowB


Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Login_TM


Scenario: TestingWorkFlowB

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
	And   Designer Name should be Auto populated as Test Designer.FS
	And   Splice Drawing Number Should be Empty
	And   Calculate button should be disabled
	And   Customer Name : The results should be all the customer corporates in Contiplus grouped by Market with search function
	And   Conveyor Name: The results should display all the conveyors of the corporate selected grouped by the sites
	And   Approver Name: The results should display
	Then  Enter the required data into all fields
	And   Click on clear button
	And   Click on No button on popup
	And   Click on Calculate button
	Then  Deisgn drawing no with preview results
	And   Click on generate PDF button
	Then  Click on save as draft button
	Then  User navigated to Register Page and the line item should be created with status DRAFT
	And   Click on Splice Kit BOM tab
	Then  Click on comments log tab
	And   Click on commentbox and enter the comments
	And   Click on send for review
	Then  User should be able to navigated to Register/List page and the Status card should say In Review
	And   Select the checkbox of the line item to make the Actions button to appear update and delete
	And   Click on update button
	Then  The form should come up and Just the input fields and Comments Log should be Editable
	And   Click on view button
