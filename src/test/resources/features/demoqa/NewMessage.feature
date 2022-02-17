@all @demoqa
Feature: Open a new message page via button

  Scenario: Open a new message page via button
    Given I navigate Alerts, Frame and Windows page
    And I click browser Windows
    Then I click new message
    And I see that new message window is open
