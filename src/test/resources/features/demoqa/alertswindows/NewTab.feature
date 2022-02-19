@all @web @demoqa @alertswindows
Feature: AlertsWindows-Open a new tab via button

  Checks the new tab button in browser windows page

  Scenario: Open a new tab via button
    Given I navigate Alerts, Frame and Windows page
    And I click browser Windows
    Then I click new tab
    And I see that new tab is opened
