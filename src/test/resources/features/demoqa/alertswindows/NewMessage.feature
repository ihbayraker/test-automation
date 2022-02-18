@all @demoqa @alertswindows
Feature: AlertsWindows-Open a new message page via button

  Checks the new message button in browser windows page

  Scenario: Open a new message page via button
    Given I navigate Alerts, Frame and Windows page
    And I click browser Windows
    Then I click new message
    And I see that new message window is open
