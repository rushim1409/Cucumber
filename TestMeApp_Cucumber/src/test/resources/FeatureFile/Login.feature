Feature: Login Functionality Test
  As a user
  I want to be able to login to the TestMeApp website
  So that I can access my account

  Scenario: Valid Login
    Given I navigate to the TestMeApp login page
    When I enter valid username "Rushikesh" and password "Test123"
    And I click on the login button
    Then I should be logged in successfully and go to homepage

  Scenario: Invalid Login
    Given I navigate to the TestMeApp login page
    When I enter invalid username "Neha" and password "Neha123"
    And I click on the login button
    Then I should see an error message indicating unsuccessful login
