package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.AutomationpracticePageObjectsInterface;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesFactory;

public class AutomationpracticePageObjects extends PageObject implements AutomationpracticePageObjectsInterface {

    public AutomationpracticePageObjects() throws Exception {
        super();
        PropertiesFactory.setEnvironment("automationpractice");
    }

    @Override
    public void navigateToHomepage(){
        browser.navigate().to(PropertiesFactory.getEnvironment("homepage"));
    }

    @Override
    public void searchKeyword(String keyword){
        Helper.sendKeysByXpath(PropertiesFactory.getEnvironment("searchBoxXpath"),browser,keyword);
        Helper.clickByXpath(PropertiesFactory.getEnvironment("searchButtonXpath"),browser);
    }

    @Override
    public String getFirstProduct() {
        Helper.WaitForElementPresentByXpath(PropertiesFactory.getEnvironment("productNameXpath")+"[1]",browser);
        return Helper.getTextByXpath(PropertiesFactory.getEnvironment("productNameXpath"),browser);
    }
}
