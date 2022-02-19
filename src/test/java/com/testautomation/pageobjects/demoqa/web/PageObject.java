package com.testautomation.pageobjects.demoqa.web;

import com.testautomation.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import com.testautomation.pageobjects.demoqa.interfaces.PageObjectInterface;

public class PageObject implements PageObjectInterface {
    protected WebDriver browser;

    public PageObject() throws Exception {
        browser = WebDriverUtils.startDriver();
    }
}
