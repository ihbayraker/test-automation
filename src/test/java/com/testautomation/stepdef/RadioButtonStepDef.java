package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RadioButtonStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public RadioButtonStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Radio Button")
    public void iClickRadioButton() throws Exception {
        demoqaHomePageObjects.selectItem(3);
    }

    @And("I check a button")
    public void iCheckAButton() throws Exception {
        demoqaElementsPageObjects.checkAButton(2);

    }

    @Then("I validate the checked button")
    public void iValidateTheCheckedButton() throws Exception {
        demoqaElementsPageObjects.checkRadioButtons();
    }
}
