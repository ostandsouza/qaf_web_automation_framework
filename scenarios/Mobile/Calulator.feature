Feature: ContiPlus scenario

  @Testthis
  @dataFile:resources/data/TestData.xls
  @key:Create_Flow
  Scenario: Verify new corporate creation

    Given   Verify user is on continental login page
    When    Login to the application with "isolated@maildrop.cc" and "Abc@123456"
    And     User navigates to add corporate screen with "Test Mobile Corp" and "Test Mobile Corp"
    And     Add Distributor corporate with "Test Mobile Corp" "Manque Global - Luggage Storage In Mumbai Airport, Chhatrapati Shivaji Maharaj International Airport Road, Navpada, Vile Parle East, Vile Parle, Mumbai, Maharashtra, India"
    Then    Navigate to corporate list and verify "Test Mobile Corp" is present