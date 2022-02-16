package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class Chrome extends DriverManager{

    @Override
    public void createWebDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("no-sandbox");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        if(isHeadless){
            options.addArguments("headless");
        }

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("browser.setDownloadBehavior", "allow");
        options.setExperimentalOption("prefs", chromePrefs);

        options.merge(caps);
        this.driver = new ChromeDriver(options);
    }
}
