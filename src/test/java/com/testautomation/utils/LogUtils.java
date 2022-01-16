package com.testautomation.utils;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

public class LogUtils {
    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void initLogger(){
        String log4jConfPath = "src/test/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    public static void logInfo(String text){
        logger.info(text);
    }
}
