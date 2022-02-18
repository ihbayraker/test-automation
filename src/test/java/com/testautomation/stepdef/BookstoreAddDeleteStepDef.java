package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaBookstorePageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BookstoreAddDeleteStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaBookstorePageObjects demoqaBookstorePageObjects;

    public BookstoreAddDeleteStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaBookstorePageObjects = new DemoqaBookstorePageObjects();
    }

    @Then("I create a new bookstore account with {string} and {string}")
    public void iCreateANewBookstoreAccountWithAnd(String username, String password) throws Exception {
        Assert.assertTrue("Couldn't create an account with api", demoqaBookstorePageObjects.createAccount(username,password));
    }

    @And("I validate that i Successfully logged in with {string}")
    public void iValidateThatISuccessfullyLoggedInWith(String username) {
        Assert.assertTrue("Login was a failure", demoqaBookstorePageObjects.checkLoginSuccess(username));
    }

    @Then("I click on go to Bookstore button")
    public void iClickOnGoToBookstoreButton() {
        demoqaBookstorePageObjects.clickGoToBookstore();
    }

    @And("I search {string} in bookstore and click on title")
    public void iSearchInBookstoreAndClickOnTitle(String book) throws Exception {
        demoqaBookstorePageObjects.searchAndClickBook(book);
    }

    @Then("I add the book to my collection")
    public void iAddTheBookToMyCollection() throws Exception {
        demoqaBookstorePageObjects.addBookToCollection();
    }

    @And("I go back to bookstore")
    public void iGoBackToBookstore() {
        demoqaBookstorePageObjects.ClickGoBackToBookstore();
    }

    @And("I go to profile")
    public void iGoToProfile() {
        demoqaHomePageObjects.selectItem(3);
    }

    @Then("I delete {string}")
    public void iDelete(String book) throws Exception {
        demoqaBookstorePageObjects.deleteBook(book);
    }

    @And("I validate that i only have {string}")
    public void iValidateThatIOnlyHave(String book) {
        Assert.assertTrue("The book wasn't deleted("+book+")", demoqaBookstorePageObjects.getBookFromTable(book).contains(book));
    }

    @Then("I delete the account I created")
    public void iDeleteTheAccountICreated() throws Exception {
        Assert.assertTrue("Couldn't delete the created account please delete it manually", demoqaBookstorePageObjects.deleteAccount());
    }

}
