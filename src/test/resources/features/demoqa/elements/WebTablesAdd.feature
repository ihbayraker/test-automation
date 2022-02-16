@all @demoqa
Feature: Add a new entry to Web Table

  Scenario Outline: Add a new entry to Web Table
    Given I navigate to elements page
    And I click Web Table
    Then I press add new registration
    And I fill First Name with "<firstName>"
    And I fill Last Name with "<lastName>"
    And I fill userEmail with "<email>"
    And I fill Age with "<age>"
    And I fill Salary with "<salary>"
    And I fill Department with "<department>"
    Then I press submit the registration form
    And I validate that table contains "<firstName>" and "<lastName>"
    Then I record the row that contains "<email>"
    Examples:
      | firstName | lastName | email               | age | salary | department |
      | John      | Doe      | johnDoe@example.com | 25  | 2000   | QA         |