Feature: SteelcordTestingWorkflowG

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord


Scenario: Verify the steelcordtestingworkflowG

   
    When  Login with Test Approver1.SC '${UserName}' and '${Password}' 
    And   Select Steel cord Splice Generator on the Navigation Pane
    And   Click on more on the tab that says in review.
    And   Select approve in the comments section
    And   Navigate back to register to see the name of the line item which is approved to reflect the naming convention tested above and rev 0
    And   Logout as test Approver 1.SC
 
    