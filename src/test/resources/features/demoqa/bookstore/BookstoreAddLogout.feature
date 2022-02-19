@all @web @demoqa @bookstore
Feature: Bookstore-Add books then logout

  Creates a new account then logins to bookstore
  Adds a single book to the table
  Logs out and logins again
  Verifies that the added book is still there and deletes the created account

  Scenario Outline: Add books then logout
    Given I navigate to Bookstore page
    And I click Login
    Then I create a new bookstore account with "<username>" and "<password>"
    Then I Type "<username>" to username and "<password>" to password and login
    And I validate that i Successfully logged in with "<username>"
    Then I click on go to Bookstore button
    And I search "<book1>" in bookstore and click on title
    Then I add the book to my collection
    And I log out of the account
    Then I Type "<username>" to username and "<password>" to password and login
    And I validate that i only have "<book1>"
    Then I delete the account I created
    Examples:
      | username   | password   | book1             |
      | ihbayraker | Demoqa123* | You Don't Know JS |