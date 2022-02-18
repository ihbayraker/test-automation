@all @demoqa @bookstore
Feature: Bookstore-Add books then delete

  Creates a new account then logins to bookstore
  Adds two books to the table
  Deletes one of the books
  After everything is verified deletes the created account

  Scenario Outline: Add books then delete
    Given I navigate to Bookstore page
    And I click Login
    Then I create a new bookstore account with "<username>" and "<password>"
    Then I Type "<username>" to username and "<password>" to password and login
    And I validate that i Successfully logged in with "<username>"
    Then I click on go to Bookstore button
    And I search "<book1>" in bookstore and click on title
    Then I add the book to my collection
    And I go back to bookstore
    And I search "<book2>" in bookstore and click on title
    Then I add the book to my collection
    And I go to profile
    Then I delete "<book2>"
    And I validate that i only have "<book1>"
    Then I delete the account I created
    Examples:
      | username   | password   | book1             | book2               |
      | ihbayraker | Demoqa123* | You Don't Know JS | Speaking JavaScript |