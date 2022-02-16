package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;

public class Edge extends DriverManager{

    @Override
    public void createWebDriver(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("no-sandbox");
        System.setProperty("webdriver.edge.silentOutput", "true");
        if(isHeadless){
            options.addArguments("headless");
        }

        HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
        edgePrefs.put("profile.default_content_settings.popups", 0);
        edgePrefs.put("download.default_directory", downloadFilepath);
        edgePrefs.put("browser.setDownloadBehavior", "allow");
        options.setExperimentalOption("prefs", edgePrefs);

        options.merge(caps);
        this.driver = new EdgeDriver(options);
    }
}
