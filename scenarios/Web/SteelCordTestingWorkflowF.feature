Feature: SteelcordTestingWorkflowF

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord


Scenario: Verify the steelcordtestingworkflowF

    When  Login with Test Designer.SC '${UserName}' and '${Password}' 
    And   Select Steel cord Splice Generator on the Navigation Pane
    And   Add input fields 
    And   Logout as TestDesigner.SC
    
    
 
    