package com.testautomation.util;

import java.awt.*;
import java.io.File;

public class TearDownUtils {

    public static void openHtmlReport() throws Exception {
        File htmlFile = new File("target/cucumber-html-reports/overview-features.html");
        if(htmlFile.exists()){
            Desktop.getDesktop().browse(htmlFile.toURI());
        }
    }

    public static void killDrivers() throws Exception {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
        Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");
        Runtime.getRuntime().exec("taskkill /F /IM operadriver.exe");
    }
}
