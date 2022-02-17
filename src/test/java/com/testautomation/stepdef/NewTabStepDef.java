package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaAlertsWindowsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NewTabStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaAlertsWindowsPageObjects demoqaAlertsWindowsPageObjects;

    public NewTabStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaAlertsWindowsPageObjects = new DemoqaAlertsWindowsPageObjects();
    }

    @Given("I navigate Alerts, Frame and Windows page")
    public void iNavigateAlertsFrameAndWindowsPage() {
        demoqaHomePageObjects.navigateToAlertsFrameWindows();
    }

    @And("I click browser Windows")
    public void iClickBrowserWindows() {
        demoqaHomePageObjects.selectItem(1);
    }

    @Then("I click new tab")
    public void iClickNewTab() {
        demoqaAlertsWindowsPageObjects.clickNewTab();
    }

    @And("I see that new tab is opened")
    public void iSeeThatNewTabIsOpened() throws Exception {
        Assert.assertTrue("Could not detect new tab",demoqaAlertsWindowsPageObjects.checkNewTabUrl("sample"));
    }
}
