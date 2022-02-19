@all @web @demoqa @elements
Feature: Elements-Click links to get api calls

  Checks all links found in links page

  Scenario: Click links to get api calls
    Given I navigate to elements page
    And I click Links
    Then I click created then check its api call
    And I click No content then check its api call
    And I click Moved then check its api call
    And I click Bad Request then check its api call
    And I click Unauthorized then check its api call
    And I click Forbidden then check its api call
    And I click Not Found then check its api call