@all @demoqa @elements
Feature: Elements-Download then upload files

  Downloads the file in download and upload page
  Uploads the downloaded file back

  Scenario: Download and upload files
    Given I navigate to elements page
    And I click Download and Upload
    Then I press download button
    And I validate that i downloaded the file
    Then I upload the downloaded file back
    And I validate that i uploaded the file