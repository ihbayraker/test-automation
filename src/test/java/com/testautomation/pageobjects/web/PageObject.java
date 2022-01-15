package com.testautomation.pageobjects.web;

import com.testautomation.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import com.testautomation.pageobjects.interfaces.PageObjectInterface;

public class PageObject implements PageObjectInterface {
    protected WebDriver browser;

    public PageObject(WebDriver browser) throws Exception {
        if (browser == null) {
            this.browser = WebDriverUtils.startDriver();
            WebDriverUtils.manageDriver(20,10);
        } else{
            this.browser = browser;
        }
    }

    public PageObject() throws Exception {
        this(null);
    }
}
