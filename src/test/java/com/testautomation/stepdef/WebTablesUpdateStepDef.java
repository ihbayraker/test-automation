package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import io.cucumber.java.en.Then;

public class WebTablesUpdateStepDef {

    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public WebTablesUpdateStepDef() throws Exception {
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @Then("I press update for recorded entry")
    public void iPressUpdateForRecordedEntry() throws Exception {
        demoqaElementsPageObjects.updateEntry(1);
    }
}
