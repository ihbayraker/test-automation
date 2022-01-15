Feature: Search a keyword

  Scenario Outline: Search "<keyword>"
    Given I go to the homepage
    And i search the "<keyword>"
    Then I record the first product
    @demo
    Examples:
      | keyword  |
      | Shirt    |
    @demo @fail
    Examples:
      | keyword  |
      | ABC    |