package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Opera extends DriverManager{

    @Override
    public void createWebDriver(){
        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("no-sandbox");
        System.setProperty("webdriver.opera.silentOutput", "true");
        if(isHeadless){
            options.addArguments("headless");
        }
        options.merge(caps);
        this.driver = new OperaDriver(options);
    }
}
