package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

public class Firefox extends DriverManager{

    @Override
    public void createWebDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        if(isHeadless){
            options.setHeadless(true);
        }

        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.download.dir",downloadFilepath);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpeg");

        options.merge(caps);
        options.setProfile(profile);
        this.driver = new FirefoxDriver(options);
    }
}
