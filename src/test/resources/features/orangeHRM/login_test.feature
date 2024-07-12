Feature: Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the user should be logged in

  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the login page
    When the user enters an invalid username and password
    And the user clicks the login button
    Then the user should not be logged in





