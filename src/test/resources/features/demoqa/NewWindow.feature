@all @web @demoqa
Feature: Open a new window via button

  Scenario: Open a new window via button
    Given I navigate Alerts, Frame and Windows page
    And I click browser Windows
    Then I click new window
    And I see that new tab is opened
