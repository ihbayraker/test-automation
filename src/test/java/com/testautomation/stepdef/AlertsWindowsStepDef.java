package com.testautomation.stepdef;

import com.testautomation.pageobjects.demoqa.web.DemoqaAlertsWindowsPageObjects;
import com.testautomation.pageobjects.demoqa.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AlertsWindowsStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaAlertsWindowsPageObjects demoqaAlertsWindowsPageObjects;
    private String name;

    public AlertsWindowsStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaAlertsWindowsPageObjects = new DemoqaAlertsWindowsPageObjects();
    }

    @And("I click Alerts")
    public void iClickAlerts() {
        demoqaHomePageObjects.selectItem(2);
    }

    @Then("I click on alert button and see the alert")
    public void iClickOnAlertButtonAndSeeTheAlert() throws Exception {
        Assert.assertTrue("Couldn't detect the alert",demoqaAlertsWindowsPageObjects.clickAndCheckAlert(0));
    }

    @And("I click on timed alert button and see the alert after {int} seconds")
    public void iClickOnTimedAlertButtonAndSeeTheAlertAfterSeconds(int time) throws Exception {
        Assert.assertTrue("Couldn't detect the alert",demoqaAlertsWindowsPageObjects.clickAndCheckAlert(time));
    }

    @Then("I click on confirm box button and select an option")
    public void iClickOnConfirmBoxButtonAndSelectAnOption() throws Exception {
        Assert.assertTrue("Couldn't detect the alert",demoqaAlertsWindowsPageObjects.clickAndCancelAlert());
    }

    @And("I validate my selected option for confirm box")
    public void iValidateMySelectedOptionForConfirmBox() {
        Assert.assertTrue("Couldn't detect the confirm box result",demoqaAlertsWindowsPageObjects.validateConfirmBoxResult().contains("Cancel"));
    }

    @Then("I click prompt box button and type {string}")
    public void iClickPromptBoxButtonAndType(String name) throws Exception {
        this.name = name;
        Assert.assertTrue("Couldn't detect the alert",demoqaAlertsWindowsPageObjects.clickAndTypeInAlert(name));
    }

    @And("I validate my entered name for prompt box")
    public void iValidateMyEnteredNameForPromptBox() {
        Assert.assertTrue("Couldn't detect the confirm box result",demoqaAlertsWindowsPageObjects.validatePromptBoxResult().contains(name));
    }

    @Then("I click new message")
    public void iClickNewMessage() {
        demoqaAlertsWindowsPageObjects.clickNewMessage();
    }

    @And("I see that new message window is open")
    public void iSeeThatNewMessageWindowIsOpen() throws Exception {
        Assert.assertTrue("Couldn't detect the new message window",demoqaAlertsWindowsPageObjects.checkNewMessage());
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

    @Then("I click new window")
    public void iClickNewWindow() {
        demoqaAlertsWindowsPageObjects.clickNewWindow();
    }
}
