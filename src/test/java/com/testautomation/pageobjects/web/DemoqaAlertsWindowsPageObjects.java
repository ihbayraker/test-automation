package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaAlertsWindowsPageObjectsInterface;
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
}
