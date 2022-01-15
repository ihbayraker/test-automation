package com.testautomation.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
        options.merge(caps);
        this.driver = new EdgeDriver(options);
    }
}
