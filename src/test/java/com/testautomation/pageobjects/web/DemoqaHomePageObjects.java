package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaHomePageObjectsInterface;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

public class DemoqaHomePageObjects extends PageObject implements DemoqaHomePageObjectsInterface {

    public DemoqaHomePageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void navigateToHomepage() throws Exception {
        browser.navigate().to(PropertiesUtils.getEnvironmentProperty("homepage"));
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("GoogleAdXpath"),browser);
    }

    @Override
    public void navigateToElements() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[1]",browser);
    }

    @Override
    public void navigateToForms() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[2]",browser);
    }

    @Override
    public void navigateToAlertsFrameWindows() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[3]",browser);
    }

    @Override
    public void navigateToWidgets() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[4]",browser);
    }

    @Override
    public void navigateToInteractions() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[5]",browser);
    }

    @Override
    public void navigateToBookStoreApplication() throws Exception {
        navigateToHomepage();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("homepageCardXpath")+"[6]",browser);
    }

    @Override
    public void selectItem(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("itemSelectionXpath")+"["+i+"]",browser);
    }
}
