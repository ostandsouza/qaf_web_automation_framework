Feature: SteelcordTestingWorkflowD

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcordmm2


Scenario: Verify the steelcordtestingworkflowD

     
    When  Login with Test Approver2.SC '${UserName}' and '${Password}' 
    And   Select Steel cord Splice Generator on the Navigation Pane
    And   Register List 
    And   Input D
    And   Output Preview
    And   Comments Log
    And   Register Edit
    And   Register View 
    And   Logout as Test Approver 2.SC
    
 
    