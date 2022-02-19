@all @api @petstore @user
Feature: User-Create user for the petstore then update credentials

  Creates a new user for the petstore then updates its credentials

  Scenario Outline: Create user for the petstore then update credentials
    Given I create a new user with name:"<firstName>", lastName:"<lastName>", email:"<email>", password:"<password>", number:"<Phone>",
    Then I check the user
    And I login to my user
    And I update the user
    Then I check the user
    And I logout from the user
    Examples:
      | firstName | lastName  | email                  | password     | Phone        |
      | Hakan     | Bayraker  | hbayraker@petstore.com | Petstore123* | 5555555555   |