package com.testautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Properties testFramework = new Properties();
    private static final Properties environment = new Properties();

    private static void setTestFramework() throws Exception {
        File file = new File("testframework.properties");

        FileInputStream fileInputStream = new FileInputStream(file);
        testFramework.load(fileInputStream);
        fileInputStream.close();
    }

    private static void setEnvironment(String env) throws Exception {
        File file = new File("target/test-classes/properties/"+env+".properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        environment.load(fileInputStream);
        fileInputStream.close();
    }

    public static String getTestFrameworkProperty(String key) throws Exception {
        if(testFramework.isEmpty()){
            setTestFramework();
        }
        return testFramework.getProperty(key);
    }

    public static String getEnvironmentProperty(String key) throws Exception {
        if(environment.isEmpty()){
            setEnvironment(getTestFrameworkProperty("environment"));
        }
        return environment.getProperty(key);
    }
}
