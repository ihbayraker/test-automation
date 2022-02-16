package com.testautomation.pageobjects.web;

import com.testautomation.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import com.testautomation.pageobjects.interfaces.PageObjectInterface;

public class PageObject implements PageObjectInterface {
    protected WebDriver browser;

    public PageObject() throws Exception {
        browser = WebDriverUtils.startDriver();
    }
}
