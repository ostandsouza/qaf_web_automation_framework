Feature: Regression of P1 Heavy Equipment module

Background:
Launch the application through '/'

@Regression1 @CTCP-3727
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_Add
Scenario: ZVerify add button functionality

    Given User is at Login page
    When  Login with '${UserName}' and '${Password}'
    And Navigate to the Heavy Equipment list page
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentName}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}'
    And Search for the heavy equipment '${HeavyEquipmentName}'
    And Navigate to the Heavy Equipment add page
    And Create a heavy equipment with '${HeavyEquipmentName}' '${Category}' '${Model}' '${Year}' '${SerialNumber}' '${DistShopName}' '${ImageName}' and click on cancel

@Regression2 @CTCP-3713
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_DistCount
Scenario: Verify visibility of heavy equipment tile on distributor corporate page


    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page

@Regression3 @CTCP-3714
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_DistCount
Scenario: Verify visibility of heavy equipment tile on distributor shop page


    Then Navigate to Corporate details screen for corporate '${DistCorpName}'
    Verify navigation to '${DistShopName}' detail screen
    And Click on the Heavy Equipment card and verify navigation to Heavy Equipment list page
    And Verify the count of records linked to the Distributor Shops in the Heavy Equipment Listing page

@Regression4 @CTCP-3715
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_CustCorp
Scenario: Verify visibility of heavy equipment tile on customer corporate page


    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Verify Heavy Equipment card is not visible in customer corporate page

@Regression5 @CTCP-3716
@dataFile:resources/data/TestData.xls
@sheetName:Regression
@key:HeavyEquipment_CustCorp
Scenario: Verify visibility of heavy equipment tile on customer site page


    Then Navigate to Corporate details screen for corporate '${CustCorpName}'
    And Verify navigation to '${CustSiteName}' detail screen
    And Verify Heavy Equipment card is not visible in customer corporate page





