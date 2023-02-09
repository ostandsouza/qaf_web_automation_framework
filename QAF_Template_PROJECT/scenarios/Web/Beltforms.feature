Feature: Beltforms

Background: 
Launch the application through '/'


@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord

Scenario: Beltforms
     
     Given Login with '${UserName}' and '${Password}' 
     And   Select Belt textile on the Navigation Pane
     And   Input Data
     And   Generate PDF
     And   Select Belt Steel on the Navigation Pane
     And   Input Data Steel
     And   Generate PDF
