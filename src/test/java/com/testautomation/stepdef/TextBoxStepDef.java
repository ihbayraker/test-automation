package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TextBoxStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public TextBoxStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @Given("I navigate to elements page")
    public void iNavigateToElementsPage() throws Exception {
        demoqaHomePageObjects.navigateToElements();
    }

    @And("I click Text box")
    public void iClickTextBox() throws Exception {
        demoqaHomePageObjects.selectItem(1);
    }

    @Then("I fill Full Name with {string}")
    public void iFillFullNameWith(String name) throws Exception {
        demoqaElementsPageObjects.typeName(name);

    }

    @And("I fill Email with {string}")
    public void iFillEmailWith(String email) throws Exception {
        demoqaElementsPageObjects.typeEmail(email);
    }

    @And("I fill Current Address with {string}")
    public void iFillCurrentAddressWith(String address) throws Exception {
        demoqaElementsPageObjects.typeCurrentAddress(address);
    }

    @And("I fill Permanent Address with {string}")
    public void iFillPermanentAddressWith(String address) throws Exception {
        demoqaElementsPageObjects.typePermanentAddress(address);
    }

    @Then("I press submit")
    public void iPressSubmit() throws Exception {
        demoqaElementsPageObjects.pressSubmit();
    }

    @Then("I validate that i filled the boxes correctly")
    public void iValidateThatIFilledTheBoxesCorrectly() throws Exception {
        demoqaElementsPageObjects.checkOutput();
    }
}
