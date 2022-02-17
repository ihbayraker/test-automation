package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaAlertsWindowsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NewWindowStepDef {

    private final DemoqaAlertsWindowsPageObjects demoqaAlertsWindowsPageObjects;

    public NewWindowStepDef() throws Exception {
        demoqaAlertsWindowsPageObjects = new DemoqaAlertsWindowsPageObjects();
    }

    @Then("I click new window")
    public void iClickNewWindow() {
        demoqaAlertsWindowsPageObjects.clickNewWindow();
    }
}
