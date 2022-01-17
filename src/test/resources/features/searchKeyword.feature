@demo
Feature: Search a keyword

  Scenario Outline: Search "<keyword>"
    Given I go to the homepage
    And i search the "<keyword>"
    Then I record the first product
    @pass1
    Examples:
      | keyword  |
      | Shirt    |
    @pass2
    Examples:
      | keyword  |
      | Blouse    |
    @fail
    Examples:
      | keyword  |
      | ABC      |