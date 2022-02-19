package com.testautomation.pageobjects.demoqa.web;

import com.testautomation.pageobjects.demoqa.interfaces.DemoqaHomePageObjectsInterface;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

public class DemoqaHomePageObjects extends PageObject implements DemoqaHomePageObjectsInterface {

    public DemoqaHomePageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void navigateToHomepage() {
        browser.navigate().to(PropertiesUtils.getEnvironmentProperty("homepage"));
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("googleAdXpath"),browser);
    }

    @Override
    public void navigateToElements() {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[1]",browser);
    }

    @Override
    public void navigateToForms() {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[2]",browser);
    }

    @Override
    public void navigateToAlertsFrameWindows() {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[3]",browser);
    }

    @Override
    public void navigateToBookStoreApplication() {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[6]",browser);
    }

    @Override
    public void selectItem(int i) {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("itemSelectionXpath")+"["+i+"]",browser);
    }
}
