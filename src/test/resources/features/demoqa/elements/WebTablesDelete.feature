@all @demoqa @elements
Feature: Delete an entry from the Web table

  Deletes one of the rows in the table in table page

  Scenario: Delete an entry from the Web table
    Given I navigate to elements page
    And I click Web Table
    Then I record an entry
    And I delete the recorded entry
    Then I check that the entry is deleted