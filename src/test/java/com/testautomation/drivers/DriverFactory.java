package com.testautomation.drivers;

import com.testautomation.utils.PropertiesUtils;

public class DriverFactory {

    public static DriverManager getDriverManager() throws Exception {
        String browser = PropertiesUtils.getTestFrameworkProperty("browser");
        return switch (browser) {
            case "firefox" -> new Firefox();
            case "opera" -> new Opera();
            case "edge" -> new Edge();
            default -> new Chrome();
        };
    }
}
