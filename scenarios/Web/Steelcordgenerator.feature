Feature: Steelcordgeneratorflow

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord


Scenario: Verify the steelcordgenerator flow

    Given User is at Login page 
    When  Login with '${UserName}' and '${Password}' 
    And   Check profile
    And   Create a new steel cord generator