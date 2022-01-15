package com.testautomation;

import com.testautomation.util.TearDownUtils;

public class TearDown {

    public static void main(String[] args) throws Exception {
        TearDownUtils.killDrivers();

        //Enable to automatically open the report after an execution
        //TearDownUtils.openHtmlReport();
    }
}
