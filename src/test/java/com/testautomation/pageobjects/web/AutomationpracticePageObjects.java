package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.AutomationpracticePageObjectsInterface;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

public class AutomationpracticePageObjects extends PageObject implements AutomationpracticePageObjectsInterface {

    public AutomationpracticePageObjects() throws Exception {
        super();
    }

    @Override
    public void navigateToHomepage() throws Exception {
        browser.navigate().to(PropertiesUtils.getEnvironmentProperty("homepage"));
    }

    @Override
    public void searchKeyword(String keyword) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("searchBoxXpath"),browser,keyword);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("searchButtonXpath"),browser);
    }

    @Override
    public String getFirstProduct() throws Exception {
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("productNameXpath")+"[1]",browser);
        return Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("productNameXpath"),browser);
    }
}
