@all @demoqa
Feature: I click on all types of buttons

  Scenario: I click on all types of buttons
    Given I navigate to elements page
    And I click Buttons
    Then I double click the button
    And I right click the button
    And I click the button
    Then I validate that I clicked all buttons
