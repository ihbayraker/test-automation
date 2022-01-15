package com.testautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFactory {
    private static Properties testFramework = new Properties();
    private static Properties environment = new Properties();

    private static void setTestFramework() throws Exception {
        File file = new File("src/test/resources/testframework.properties");

        FileInputStream fileInputStream = new FileInputStream(file);
        testFramework.load(fileInputStream);
    }

    public static void setEnvironment(String env) throws Exception {
        File file = new File("src/test/resources/properties/"+env+".properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        environment.load(fileInputStream);
    }

    public static String getTestFramework(String key) throws Exception {
        if(testFramework.isEmpty()){
            setTestFramework();
        }
        return testFramework.getProperty(key);
    }

    public static String getEnvironment(String key){
        return environment.getProperty(key);
    }
}
