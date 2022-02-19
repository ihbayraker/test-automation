@all @api @petstore @user
Feature: User-Add and update the user on petstore

  Creates a new user user for the petstore then updates it

  Scenario Outline: Add and update the user on petstore
    Given I create a new user with name:"<firstName>", lastName:"<lastName>", email:"<email>", password:"<password>", number:"<Phone>",
    Then I check the user
    And I login to my user
    And I update the user
    Then I check the user
    Examples:
      | firstName | lastName  | email                  | password     | Phone        |
      | Hakan     | Bayraker  | hbayraker@petstore.com | Petstore123* | 5555555555   |