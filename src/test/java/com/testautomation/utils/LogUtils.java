package com.testautomation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void logInfo(String text){
        logger.info(text);
    }
}
