package com.testautomation;

import com.testautomation.util.TearDownUtils;

public class TearDown {

    public static void main(String[] args) throws Exception {
        TearDownUtils.killDrivers();
        TearDownUtils.openHtmlReport();
    }
}
