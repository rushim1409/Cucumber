@tag
Feature: login functianality

  @tag1
  Scenario: login successfully
    Given user is on login page
    When user enter "rushikesh" and "Test123"
    And user click on login button
    Then user should be login successfully
