package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaAlertsWindowsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NewMessageStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaAlertsWindowsPageObjects demoqaAlertsWindowsPageObjects;

    public NewMessageStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaAlertsWindowsPageObjects = new DemoqaAlertsWindowsPageObjects();
    }

    @Then("I click new message")
    public void iClickNewMessage() {
        demoqaAlertsWindowsPageObjects.clickNewMessage();
    }

    @And("I see that new message window is open")
    public void iSeeThatNewMessageWindowIsOpen() throws Exception {
        Assert.assertTrue("Couldn't detect the new message window",demoqaAlertsWindowsPageObjects.checkNewMessage());
    }
}
