package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RadioButtonStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;
    private String radioButton;

    public RadioButtonStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Radio Button")
    public void iClickRadioButton(){
        demoqaHomePageObjects.selectItem(3);
    }

    @And("I check a button")
    public void iCheckAButton(){
       radioButton = demoqaElementsPageObjects.checkAButton(2);

    }

    @Then("I validate the checked button")
    public void iValidateTheCheckedButton(){
        Assert.assertTrue(radioButton+" was supposed to be selected",demoqaElementsPageObjects.checkRadioButtons().contains(radioButton));
    }
}
