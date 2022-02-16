@all @web @demoqa
Feature: Delete an entry from the Web table

  Scenario: Delete an entry from the Web table
    Given I navigate to elements page
    And I click Web Table
    Then I record an entry
    And I delete the recorded entry
    Then I check that the entry is deleted