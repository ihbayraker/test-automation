package com.testautomation;

import java.awt.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File htmlFile = new File("target/cucumber-html-reports/overview-features.html");
        if(htmlFile.exists()){
            Desktop.getDesktop().browse(htmlFile.toURI());
        }
    }
}
