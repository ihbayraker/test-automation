package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaBookstorePageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BookstoreDeleteAllStepDef {

    private final DemoqaBookstorePageObjects demoqaBookstorePageObjects;

    public BookstoreDeleteAllStepDef() throws Exception {
        demoqaBookstorePageObjects = new DemoqaBookstorePageObjects();
    }

    @Then("I delete all books")
    public void iDeleteAllBooks() throws Exception {
        demoqaBookstorePageObjects.deleteAllBooks();
    }

    @And("I validate that i have no books in the table")
    public void iValidateThatIHaveNoBooksInTheTable() {
        Assert.assertNull("There was still books in the table",demoqaBookstorePageObjects.getBookFromTable("null"));
    }
}
