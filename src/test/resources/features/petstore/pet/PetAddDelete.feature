@all @api @petstore @pet
Feature: Pet-Add then delete pet on petstore

  Creates a new pet for the petstore then updates it

  Scenario Outline: Add then update pet on petstore
    Given I create a new pet with name:"<name>", category:"<category>", tag:"<tag>"
    Then I check the pet
    Then I delete the pet
    Then I check that pet is deleted
    Examples:
      | name  | category | tag   |
      | Rocky | dogs     | brown |