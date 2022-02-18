@all @demoqa @elements
Feature: Check Radio Buttons

  Checks all radio buttons in radio button page

  Scenario: Check Radio Buttons
    Given I navigate to elements page
    And I click Radio Button
    And I check a button
    Then I validate the checked button