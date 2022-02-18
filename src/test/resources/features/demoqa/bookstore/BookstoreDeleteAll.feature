@all @demoqa @bookstore
Feature: Bookstore-Add books then delete all

  Creates a new account then logins to bookstore
  Adds three books to the table
  Deletes all books using delete all button
  After everything is verified deletes the created account

  Scenario Outline: Add books then delete all
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
    And I go back to bookstore
    And I search "<book3>" in bookstore and click on title
    Then I add the book to my collection
    And I go to profile
    Then I delete all books
    And I validate that i have no books in the table
    Then I delete the account I created
    Examples:
      | username   | password   | book1             | book2               | book3            |
      | ihbayraker | Demoqa123* | You Don't Know JS | Speaking JavaScript | Git Pocket Guide |