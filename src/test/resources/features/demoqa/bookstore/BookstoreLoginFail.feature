@all @web @demoqa @bookstore
Feature: Bookstore-Check login fail

  Tries to login to bookstore with false credentials

  Scenario Outline: Check login fail
    Given I navigate to Bookstore page
    And I click Login
    Then I Type "<username>" to username and "<password>" to password and login
    Then I validate that i wasn't allowed to login
    Examples:
      | username | password |
      | FailTest | Pass123  |