@all @demoqa @bookstore
Feature: Login fail on bookstore

  Tries to login to bookstore with false credentials

  Scenario Outline: Login fail on bookstore
    Given I navigate to Bookstore page
    And I click Login
    Then I Type "<username>" to username and "<password>" to password and login
    Then I validate that i wasn't allowed to login
    Examples:
      | username | password |
      | FailTest | Pass123  |