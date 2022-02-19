@all @api @petstore @pet
Feature: Pet-Add and update pet on petstore

  Creates a new pet, adds an image to it then updates it

  Scenario Outline: Add then update pet on petstore
    Given I create a new pet with name:"<name>", category:"<category>", tag:"<tag>"
    Then I check the pet
    And I upload an image for the pet
    Then I update the pet
    Then I check the pet
    Examples:
      | name  | category | tag  |
      | Dusty | cats     | gray |