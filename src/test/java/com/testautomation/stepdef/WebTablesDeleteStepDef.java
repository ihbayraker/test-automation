package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class WebTablesDeleteStepDef {

    private final DemoqaElementsPageObjects demoqaElementsPageObjects;
    String entry;

    public WebTablesDeleteStepDef() throws Exception {
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @Then("I record an entry")
    public void iRecordAnEntry() throws Exception {
        entry = demoqaElementsPageObjects.getRow(1);
    }

    @And("I delete the recorded entry")
    public void iDeleteTheRecordedEntry() throws Exception {
        demoqaElementsPageObjects.deleteRow(1);
    }

    @Then("I check that the entry is deleted")
    public void iCheckThatTheEntryIsDeleted() throws Exception {
        Assert.assertFalse("The deleted row was still available",demoqaElementsPageObjects.checkTableBody(entry));
    }
}
