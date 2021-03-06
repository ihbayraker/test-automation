@all @web @demoqa @elements
Feature: Elements-Update an existing entry in Web Table

  Updates one of the default rows in table in table page with given example

  Scenario Outline: Update an existing entry in Web Table
    Given I navigate to elements page
    And I click Web Table
    Then I record an entry
    Then I press update for recorded entry
    And I fill First Name with "<firstName>"
    And I fill Last Name with "<lastName>"
    And I fill userEmail with "<email>"
    And I fill Age with "<age>"
    And I fill Salary with "<salary>"
    And I fill Department with "<department>"
    Then I press submit the registration form
    Then I check that the entry is deleted
    And I validate that table contains "<firstName>" and "<lastName>"
    Then I record the row that contains "<email>"
    Examples:
      | firstName | lastName | email               | age | salary | department |
      | Jane      | Doe      | JaneDoe@example.com | 21  | 2000   | QA         |