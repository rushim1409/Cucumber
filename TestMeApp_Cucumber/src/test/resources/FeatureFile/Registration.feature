Feature: User Registration
  As a new user
  I want to be able to register on the TestMeApp website
  So that I can access the services provided

  Scenario: Register with valid information
    Given I am on the registration page of TestMeApp
    When I fill out the registration form with valid information
      | Fields           | Value                  |
      | username         | RushYT                 |
      | firstName        | Rushi                  |
      | lastName         | Magar                  |
      | password         | Test123                |
      | confirmPassword  | est123                 |
      | email            | test@example.com       |
      | mobileNumber     | 1234567890             |
      | birthDate        | 09/14/1999             |
      | address          | 123 Test Maharashtra   |
      | securityQuestion | What is your Pet Name? |
      | answer           | carry                  |
    And I submit the registration form
    Then I should be redirected to the login page
