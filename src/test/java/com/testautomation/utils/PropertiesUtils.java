package com.testautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Properties pom = new Properties();
    private static final Properties environment = new Properties();

    private static void setPom() throws Exception {
        File file = new File("target/test-classes/pom.properties");

        FileInputStream fileInputStream = new FileInputStream(file);
        pom.load(fileInputStream);
        fileInputStream.close();
    }

    public static void setEnvironment(String env) throws Exception {
        File file = new File("target/test-classes/"+env+".properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        environment.load(fileInputStream);
        fileInputStream.close();
    }

    public static String getPomProperty(String key) throws Exception {
        if(pom.isEmpty()){
            setPom();
        }
        return pom.getProperty(key);
    }

    public static String getEnvironmentProperty(String key) {
        return environment.getProperty(key);
    }
}
