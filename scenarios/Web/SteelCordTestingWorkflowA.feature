Feature: SteelcordTestingWorkflowA

Background: 
Launch the application through '/'

@Regression
@dataFile:resources/data/TestData.xls 
@key:Steelcord


Scenario: Verify the steelcordtestingworkflowA

    Given User is at Login page 
    When  Login with '${UserName}' and '${Password}' 
    And   Create territorymanager TestDesigner.SC '${Fullname}' and '${Phone}' and '${Profiletype}' and '${Userpassword}' and '${Retypepassword}'
    And   Create Standard Continental User TestUser.SC '${Fullnametu}' and '${Phone}' and '${Profiletypetu}' and '${Userpassword}' and '${Retypepassword}'
    And   Create MarketManager Test Approver '${Fullnameta1}' and '${Phone}' and '${Profiletypeta1}' and '${Userpassword}' and '${Retypepassword}'
    And   Create MarketManager Test Approver '${Fullnameta2}' and '${Phone}' and '${Profiletypeta1}' and '${Userpassword}' and '${Retypepassword}'
    And   Create MarketUser Test admin.SC  '${Fullnameta}' and '${Phone}' and '${Profiletypeta}' and '${Userpassword}' and '${Retypepassword}'
    