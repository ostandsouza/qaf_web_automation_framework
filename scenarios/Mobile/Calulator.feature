Feature: ContiPlus scenario

  @Testthis
  @dataFile:resources/data/TestData.xls
  @key:Create_Flow
  Scenario: Verify new corporate creation

    Given   Login to the application with '${UserName}' and '${Password}'
    When    User navigates to add corporate screen
    When    Add Distributor corporate with '${CorpName}' '${Address}'
    Then    Navigate to corporate list and verify '${CorpName}' is present