package com.testautomation.stepdef;

import com.testautomation.utils.LogUtils;
import com.testautomation.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;

import java.util.logging.Level;

public class Hooks {
    private static Scenario scenario;

    public static Scenario getScenario(){
        return scenario;
    }

    public static String getScenarioName(){
        return scenario.getName();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String log4jConfPath = "src/test/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

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
