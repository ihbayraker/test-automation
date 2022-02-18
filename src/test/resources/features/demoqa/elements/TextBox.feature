@all @demoqa @elements
Feature: Elements-Fill the Text Boxes then Submit

  Fills the text boxes in text box page with given example then submits

  Scenario Outline: Fill the Text Boxes then Submit
    Given I navigate to elements page
    And I click Text box
    Then I fill Full Name with "<name>"
    And I fill Email with "<email>"
    And I fill Current Address with "<currentAddress>"
    And I fill Permanent Address with "<permanentAddress>"
    Then I press submit
    Then I validate that i filled the boxes correctly
    Examples:
      | name     | email               | currentAddress  | permanentAddress       |
      | John Doe | johnDoe@example.com | Istanbul Turkey | Amsterdam Netherlands  |