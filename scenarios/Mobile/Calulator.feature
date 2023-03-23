Feature: Addition

  @Testthis
  Scenario: Calculate addition of two numbers

    Given Application is installed
    When  Application is launched
    Then  Enter number '555'
    And   Enter operation '+'
    And   Enter number '666'
    When  Calculate
    Then  verify '1221' in result
    And   Close application