@all @demoqa @alertswindows
Feature: Check alert buttons

  Checks all alert buttons in found in alert page

  Scenario Outline: Check alert buttons
    Given I navigate Alerts, Frame and Windows page
    And I click Alerts
    Then I click on alert button and see the alert
    And I click on timed alert button and see the alert after 5 seconds
    Then I click on confirm box button and select an option
    And I validate my selected option for confirm box
    Then I click prompt box button and type "<name>"
    And I validate my entered name for prompt box
    Examples:
      | name   |
      | Hannah |