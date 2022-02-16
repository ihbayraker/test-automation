package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaFormsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static java.lang.Integer.parseInt;

public class FillFormStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaFormsPageObjects demoqaFormsPageObjects;

    public FillFormStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaFormsPageObjects = new DemoqaFormsPageObjects();
    }

    @Given("I navigate to forms page")
    public void iNavigateToFormsPage() {
        demoqaHomePageObjects.navigateToForms();
    }

    @And("I click practice form")
    public void iClickPracticeForm() {
        demoqaHomePageObjects.selectItem(1);
    }

    @Then("I type Name with {string} and {string}")
    public void iTypeNameWithAnd(String name, String surname) {
        demoqaFormsPageObjects.typeNameAndSurname(name, surname);
    }

    @And("I type Email with {string}")
    public void iTypeEmailWith(String email) {
        demoqaFormsPageObjects.typeEmail(email);
    }

    @Then("I select a gender")
    public void iSelectAGender() {
        demoqaFormsPageObjects.selectGender(2);
    }

    @And("I type Mobile number with {string}")
    public void iTypeMobileNumberWith(String number) {
        demoqaFormsPageObjects.typeMobileNumber(number);
    }

    @And("I select date of birth as {string}-{string}-{string}")
    public void iSelectDateOfBirthAs(String day, String month, String year) throws Exception {
        demoqaFormsPageObjects.ChooseDateOfBirth(parseInt(day),parseInt(month),parseInt(year));
    }

    @Then("I type subject with {string}")
    public void iTypeSubjectWith(String subject) {
        demoqaFormsPageObjects.typeSubject(subject);
    }

    @And("I select hobbies")
    public void iSelectHobbies() {
        demoqaFormsPageObjects.selectHobbies(2);
        demoqaFormsPageObjects.selectHobbies(3);
    }

    @And("I upload an image for picture")
    public void iUploadAnImageForPicture() throws Exception {
        demoqaFormsPageObjects.generateAndUploadImage();
    }

    @Then("I type current address with {string}")
    public void iTypeCurrentAddressWith(String address) {
        demoqaFormsPageObjects.typeAddress(address);
    }

    @And("I select a State and City")
    public void iSelectAStateAndCity() {
        demoqaFormsPageObjects.selectStateAndCity(1,1);
    }

    @Then("I press submit form")
    public void iPressSubmitForm() {
        demoqaFormsPageObjects.submitForm();
    }

    @And("I validate the form is registered")
    public void iValidateTheFormIsRegistered() {
        demoqaFormsPageObjects.checkAndReportForm();
    }

}
