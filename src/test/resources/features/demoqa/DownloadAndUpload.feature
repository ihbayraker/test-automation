@all @demoqa
Feature: Download and upload files

  Scenario: Download and upload files
    Given I navigate to elements page
    And I click Download and Upload
    Then I press download button
    And I validate that i downloaded the file
    Then I upload the downloaded file back
    And I validate that i uploaded the file