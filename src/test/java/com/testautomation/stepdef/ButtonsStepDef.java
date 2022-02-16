package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ButtonsStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public ButtonsStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Buttons")
    public void iClickButtons() throws Exception {
        demoqaHomePageObjects.selectItem(5);
    }

    @Then("I double click the button")
    public void iDoubleClickTheButton() throws Exception {
        demoqaElementsPageObjects.doDoubleClick();
    }

    @And("I right click the button")
    public void iRightClickTheButton() throws Exception {
        demoqaElementsPageObjects.doRightClick();
    }

    @And("I click the button")
    public void iClickTheButton() throws Exception {
        demoqaElementsPageObjects.doNormalClick();
    }

    @Then("I validate that I clicked all buttons")
    public void iValidateThatIClickedAllButtons() throws Exception {
        demoqaElementsPageObjects.writeClickResults();
    }
}
