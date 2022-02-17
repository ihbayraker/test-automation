package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LinksStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public LinksStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Links")
    public void iClickLinks() {
        demoqaHomePageObjects.selectItem(6);
    }

    @Then("I click created then check its api call")
    public void iClickCreatedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 201 Created",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("created"));
    }

    @And("I click No content then check its api call")
    public void iClickNoContentThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 204 No Content",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("no-content"));
    }

    @And("I click Moved then check its api call")
    public void iClickMovedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 301 Moved Permanently",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("moved"));
    }

    @And("I click Bad Request then check its api call")
    public void iClickBadRequestThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 400 Bad Request",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("bad-request"));
    }

    @And("I click Unauthorized then check its api call")
    public void iClickUnauthorizedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 401 Unauthorized",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("unauthorized"));
    }

    @And("I click Forbidden then check its api call")
    public void iClickForbiddenThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 403 Forbidden",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("forbidden"));
    }

    @And("I click Not Found then check its api call")
    public void iClickNotFoundThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 404 Not Found",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("invalid-url"));
    }
}
