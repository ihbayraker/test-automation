@all @web @demoqa
Feature: Toggle Check Boxes

  Scenario: Toggle check Boxes
    Given I navigate to elements page
    And I click Check box
    And I unwind tree nodes
    Then I toggle few nodes
    Then I validate the checked nodes