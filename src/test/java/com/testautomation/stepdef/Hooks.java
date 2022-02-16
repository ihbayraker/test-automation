package com.testautomation.stepdef;

import com.testautomation.utils.LogUtils;
import com.testautomation.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static Scenario scenario;

    public static Scenario getScenario(){
        return scenario;
    }

    public static String getScenarioName(){
        return scenario.getName();
    }

    public static String getScenarioTags(){
        return scenario.getSourceTagNames().toString();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
        LogUtils.logInfo("Running Scenario: "+getScenarioName());
    }

    @After
    public void afterScenario() throws Exception {
        try{
            if (scenario.isFailed()) {
                LogUtils.logInfo("Scenario Failed: "+getScenarioName());
                WebDriverUtils.takeScreenshot(scenario,"Screenshot");
            }else{
                LogUtils.logInfo("Scenario Passed: "+getScenarioName());
            }
        }finally {
            WebDriverUtils.quitWebDriver();
        }
    }
}
