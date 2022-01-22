package com.testautomation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.testautomation.utils.PropertiesUtils;


public abstract class DriverManager {

    protected WebDriver driver;
    protected DesiredCapabilities caps = new DesiredCapabilities();
    protected boolean isHeadless;

    public abstract void createWebDriver() throws Exception;

    public WebDriver getWebDriver() throws Exception {
        if (null == driver){
            caps.setJavascriptEnabled(true);
            caps.setAcceptInsecureCerts(true);
            caps.setCapability(CapabilityType.TAKES_SCREENSHOT,true);

            if(PropertiesUtils.getPomProperty("headless").equals("true")){
                isHeadless = true;
            }

            createWebDriver();
        }
        return driver;

    }
}
