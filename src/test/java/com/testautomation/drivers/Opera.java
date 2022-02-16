package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.HashMap;

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

        HashMap<String, Object> operaPrefs = new HashMap<String, Object>();
        operaPrefs.put("profile.default_content_settings.popups", 0);
        operaPrefs.put("download.default_directory", downloadFilepath);
        operaPrefs.put("browser.setDownloadBehavior", "allow");
        options.setExperimentalOption("prefs", operaPrefs);

        options.merge(caps);
        this.driver = new OperaDriver(options);
    }
}
