Feature: SteelcordTestingWorkflowE

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord


Scenario: Verify the steelcordtestingworkflowE

  
    When  Login with Test admin.SC '${UserName}' and '${Password}' 
    And   Select Steel cord Splice Generator on the Navigation Pane
    And   Register List
    And   User should be able to click on View button and see the whole input and out put areas 	
    And   Output Preview
    And   Comments Log
    And   Logout as Test admin.SC
 
    