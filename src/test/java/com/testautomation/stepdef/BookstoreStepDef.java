package com.testautomation.stepdef;

import com.testautomation.pageobjects.demoqa.web.DemoqaBookstorePageObjects;
import com.testautomation.pageobjects.demoqa.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BookstoreStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaBookstorePageObjects demoqaBookstorePageObjects;

    public BookstoreStepDef() throws Exception {
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

    @Then("I delete all books")
    public void iDeleteAllBooks() throws Exception {
        demoqaBookstorePageObjects.deleteAllBooks();
    }

    @And("I validate that i have no books in the table")
    public void iValidateThatIHaveNoBooksInTheTable() {
        Assert.assertNull("There was still books in the table",demoqaBookstorePageObjects.getBookFromTable("null"));
    }

    @And("I log out of the account")
    public void iLogOutOfTheAccount() {
        demoqaBookstorePageObjects.logout();
    }

}
