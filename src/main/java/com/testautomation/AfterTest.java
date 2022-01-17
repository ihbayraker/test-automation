package com.testautomation;

import com.testautomation.util.TearDownUtils;

public class AfterTest {

    public static void main(String[] args) throws Exception {
        TearDownUtils.killDrivers();
        TearDownUtils.openHtmlReport();
    }
}
