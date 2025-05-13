Feature: Inspectionflow

Background: 
Launch the application through '/'


@Regression
@dataFile:resources/data/TestData.xls 
@key:Inspection

Scenario: Inspectionflow

     Given Login with '${UserName}' and '${Password}' 
     And   Select Inspection on the Navigation Pane
     And   Verify list page
     And   Create add inspection '${Inspectionname}'
     And   Create add inspection item  '${Inspectionname}'
     And   Download PDF
     And   Inspection Delete
     