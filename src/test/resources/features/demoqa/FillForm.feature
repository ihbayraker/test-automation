@all @web @demoqa
Feature: Fill student registration form

  Scenario Outline: Fill student registration form
    Given I navigate to forms page
    And I click practice form
    Then I type Name with "<mame>" and "<surname>"
    And I type Email with "<email>"
    Then I select a gender
    And I type Mobile number with "<mobileNumber>"
    And I select date of birth as "<day>"-"<month>"-"<year>"
    Then I type subject with "<subject>"
    And I select hobbies
    And I upload an image for picture
    Then I type current address with "<Address>"
    And I select a State and City
    Then I press submit form
    And I validate the form is registered
    Examples:
      | mame    | surname  | email                  | mobileNumber | day | month | year | subject          | Address |
      | Richard | Roe      | RichardRoe@example.com | 5555555555   | 6   | 9     | 1996 | Computer Science | India   |