Feature: This feature for testing home page

  Scenario: Verify items price not more than $40.00
    Given the user is on the login page [SauceDemo]
    When the user enters a valid username and password [SauceDemo]
    And the user clicks the login button [SauceDemo]
    Then the user should be logged in [SauceDemo]
    Then prices are not exceed $ 50