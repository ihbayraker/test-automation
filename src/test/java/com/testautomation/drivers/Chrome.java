package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        options.merge(caps);
        this.driver = new ChromeDriver(options);
    }
}
