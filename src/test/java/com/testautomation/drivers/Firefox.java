package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends DriverManager{

    @Override
    public void createWebDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        if(isHeadless){
            options.setHeadless(true);
        }
        options.merge(caps);
        this.driver = new FirefoxDriver(options);
    }
}
