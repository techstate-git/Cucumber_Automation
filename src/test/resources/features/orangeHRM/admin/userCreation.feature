Feature: Admin Creation of User

Background: User is logged in
  Given the user is on the login page
  When the user enters a valid username and password
  And the user clicks the login button
  Then the user should be logged in

Scenario: Successful User Creation
  Given user is on home page
  When the user clicks admin menu section
  Then user should be on admin page
  When user clicks add button
  Then user should be on user creation page
  When user enters all credentials and clicks save button
  Then user should be created




Scenario: User Created with empty credentials
  Given

