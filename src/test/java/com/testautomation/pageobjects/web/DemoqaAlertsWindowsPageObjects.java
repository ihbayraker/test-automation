package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaAlertsWindowsPageObjectsInterface;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

public class DemoqaAlertsWindowsPageObjects extends PageObject implements DemoqaAlertsWindowsPageObjectsInterface {

    public DemoqaAlertsWindowsPageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void clickNewTab() {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("windowNewTabButtonXpath"), browser);
    }

    @Override
    public Boolean checkNewTabUrl(String text) throws Exception {
        Helper.SwitchTab(1, browser);
        return Helper.getUrl(browser).contains(text);
    }

    @Override
    public void clickNewWindow() {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("windowNewPageButtonXpath"), browser);
    }

    @Override
    public void clickNewMessage() {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("windowNewWMessageButtonXpath"), browser);
    }

    @Override
    public boolean checkNewMessage() throws Exception {
        if(Helper.getWindowHandlers(browser).size() > 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean clickAndCheckAlert(int wait) throws Exception {
        if(wait>0){
            Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("AlertTimedButtonXpath"), browser);
            wait=wait*1000;
            Thread.sleep(wait);
        }else {
            Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("AlertTriggerButtonXpath"), browser);
        }

        boolean status = Helper.isAlertPresent(browser);
        if(status){
            Helper.acceptAlert(browser);
        }
        return status;
    }

    @Override
    public boolean clickAndCancelAlert(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("AlertConfirmBoxButtonXpath"), browser);
        boolean status = Helper.isAlertPresent(browser);
        if(status){
            Helper.cancelAlert(browser);
        }
        return status;
    }

    @Override
    public boolean clickAndTypeInAlert(String text) {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("AlertPromptBoxButtonXpath"), browser);
        boolean status = Helper.isAlertPresent(browser);
        if(status){
            Helper.typeInAlert(text,browser);
        }
        return status;
    }


    @Override
    public String validateConfirmBoxResult(){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("AlertConfirmBoxResultXpath"), browser);
        String output =  Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("AlertConfirmBoxResultXpath"), browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

    @Override
    public String validatePromptBoxResult(){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("AlertPromptBoxResultXpath"), browser);
        String output =  Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("AlertPromptBoxResultXpath"), browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

}
