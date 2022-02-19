@all @api @petstore @user
Feature: User-Create user for the petstore then delete it

  Creates a new user for the petstore then deletes it

  Scenario Outline: Create user for the petstore then delete it
    Given I create a new user with name:"<firstName>", lastName:"<lastName>", email:"<email>", password:"<password>", number:"<Phone>",
    Then I check the user
    And I login to my user
    And I delete the user
    Then I check that the user is no longer available
    Examples:
      | firstName | lastName  | email                  | password     | Phone        |
      | Hakan     | Bayraker  | hbayraker@petstore.com | Petstore123* | 5555555555   |