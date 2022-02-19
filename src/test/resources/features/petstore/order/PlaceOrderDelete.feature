@all @api @petstore @order
Feature: Order-Place an Order then delete it

  Creates a new pet, places it to an order then deletes the order

  Scenario Outline: Place an Order then delete it
    Given I create a new pet with name:"<name>", category:"<category>", tag:"<tag>"
    Then I check the pet
    Then I place an order for the created pet
    And I validate my order is registered
    Then I delete the order I put
    And I check that order is not available
    Examples:
      | name   | category  | tag   |
      | Waffle | cats     | orange |