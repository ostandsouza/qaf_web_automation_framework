Feature: SteelcordTestingWorkflowB

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcordtm



Scenario: Verify the steelcordtestingworkflowB

     
     When  Login with Test Designer.SC '${UserName}' and '${Password}' 
     And   Select Steel cord Splice Generator on the Navigation Pane
     And   Register List
     And   Input
     And   Output Preview B
     And   Comments Log
     And   Register Edit
     And   Register View
    Then  Logout as Test Designer.SC
    