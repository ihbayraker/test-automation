package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaBookstorePageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BookstoreLoginFailStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaBookstorePageObjects demoqaBookstorePageObjects;

    public BookstoreLoginFailStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaBookstorePageObjects = new DemoqaBookstorePageObjects();
    }

    @Given("I navigate to Bookstore page")
    public void iNavigateToBookstorePage() {
        demoqaHomePageObjects.navigateToBookStoreApplication();
    }

    @And("I click Login")
    public void iClickLogin() {
        demoqaHomePageObjects.selectItem(1);
    }

    @Then("I Type {string} to username and {string} to password and login")
    public void iTypeToUsernameAndToPasswordAndLogin(String username, String password) {
        demoqaBookstorePageObjects.login(username,password);
    }

    @Then("I validate that i wasn't allowed to login")
    public void iValidateThatIWasnTAllowedToLogin() {
        Assert.assertTrue("Successfully logged in or fail error did not display properly",demoqaBookstorePageObjects.checkLoginFailMessage());
    }

}
