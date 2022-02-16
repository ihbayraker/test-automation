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
    public void iClickButtons() {
        demoqaHomePageObjects.selectItem(5);
    }

    @Then("I double click the button")
    public void iDoubleClickTheButton(){
        demoqaElementsPageObjects.doDoubleClick();
    }

    @And("I right click the button")
    public void iRightClickTheButton(){
        demoqaElementsPageObjects.doRightClick();
    }

    @And("I click the button")
    public void iClickTheButton(){
        demoqaElementsPageObjects.doNormalClick();
    }

    @Then("I validate that I clicked all buttons")
    public void iValidateThatIClickedAllButtons(){
        demoqaElementsPageObjects.writeClickResults();
    }
}
