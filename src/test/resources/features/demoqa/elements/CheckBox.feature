@all @demoqa @elements
Feature: Toggle Check Boxes

  Unwinds the nodes in checkbox page then toggles some

  Scenario: Toggle check Boxes
    Given I navigate to elements page
    And I click Check box
    And I unwind tree nodes
    Then I toggle few nodes
    Then I validate the checked nodes