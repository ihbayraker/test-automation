package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaBookstorePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BookstoreAddLogoutStepDef {

    private final DemoqaBookstorePageObjects demoqaBookstorePageObjects;

    public BookstoreAddLogoutStepDef() throws Exception {
        demoqaBookstorePageObjects = new DemoqaBookstorePageObjects();
    }

    @And("I log out of the account")
    public void iLogOutOfTheAccount() {
        demoqaBookstorePageObjects.logout();
    }
}
