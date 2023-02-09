Feature: SteelcordTestingWorkflowC

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcordmm


Scenario: Verify the steelcordtestingworkflowC

    
    When  Login with Test Approver1.SC '${UserName}' and '${Password}' 
    And   Select Steel cord Splice Generator on the Navigation Pane
    And   Register List
    And   User should be able to click on View button and see the whole input and out put areas 	
    And   Output Preview C
    And   Comments Log C
 
    