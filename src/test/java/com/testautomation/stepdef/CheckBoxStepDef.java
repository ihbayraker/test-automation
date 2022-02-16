package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckBoxStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public CheckBoxStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Check box")
    public void iClickCheckBox() throws Exception {
        demoqaHomePageObjects.selectItem(2);
    }

    @And("I unwind tree nodes")
    public void iUnwindTreeNodes() throws Exception {
        demoqaElementsPageObjects.unwindNodes(1);
        demoqaElementsPageObjects.unwindNodes(2);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(3);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(5);
    }

    @Then("I toggle few nodes")
    public void iToggleFewNodes() throws Exception {
        demoqaElementsPageObjects.toggleNodes(6);
        demoqaElementsPageObjects.toggleNodes(10);
    }

    @Then("I validate the checked nodes")
    public void iValidateTheCheckedNodes() throws Exception {
        demoqaElementsPageObjects.checkSelectedNodes();
    }

}
