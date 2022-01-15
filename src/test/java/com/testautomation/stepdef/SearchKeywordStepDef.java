package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.AutomationpracticePageObjects;
import com.testautomation.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchKeywordStepDef {

    private AutomationpracticePageObjects automationpracticePageObjects;

    public SearchKeywordStepDef() throws Exception {
        automationpracticePageObjects = new AutomationpracticePageObjects();
    }

    @Given("I go to the homepage")
    public void iGoToTheHomepage(){
        automationpracticePageObjects.navigateToHomepage();
    }

    @And("i search the {string}")
    public void iSearchThe(String keyword){
        automationpracticePageObjects.searchKeyword(keyword);
    }

    @Then("I record the first product")
    public void iRecordTheFirstProduct(){
        Helper.scenarioWrite(Hooks.getScenario(),automationpracticePageObjects.getFirstProduct(),"Product Name");
    }

}
