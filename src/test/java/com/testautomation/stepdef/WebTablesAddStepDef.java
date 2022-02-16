package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class WebTablesAddStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    public WebTablesAddStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Web Table")
    public void iClickWebTable(){
        demoqaHomePageObjects.selectItem(4);
    }

    @Then("I press add new registration")
    public void iPressAddNewRegistration(){
        demoqaElementsPageObjects.clickAddRegistration();
    }

    @And("I fill First Name with {string}")
    public void iFillFirstNameWith(String name){
        demoqaElementsPageObjects.fillFirstName(name);
    }

    @And("I fill Last Name with {string}")
    public void iFillLastNameWith(String name){
        demoqaElementsPageObjects.fillLastName(name);
    }

    @And("I fill userEmail with {string}")
    public void iFillUserEmailWith(String email){
        demoqaElementsPageObjects.fillEmail(email);
    }

    @And("I fill Age with {string}")
    public void iFillAgeWith(String age){
        demoqaElementsPageObjects.fillAge(age);
    }

    @And("I fill Salary with {string}")
    public void iFillSalaryWith(String salary){
        demoqaElementsPageObjects.fillSalary(salary);
    }

    @And("I fill Department with {string}")
    public void iFillDepartmentWith(String department){
        demoqaElementsPageObjects.fillDepartment(department);
    }

    @Then("I press submit the registration form")
    public void iPressSubmitTheRegistrationForm(){
        demoqaElementsPageObjects.submitRegistration();
    }

    @And("I validate that table contains {string} and {string}")
    public void iValidateThatTableContainsAnd(String firstName, String LastName) throws Exception {
        Assert.assertTrue("Couldn't find registered First Name in the table",demoqaElementsPageObjects.checkTableBody(firstName));
        Assert.assertTrue("Couldn't find registered Last Name in the table",demoqaElementsPageObjects.checkTableBody(LastName));
    }

    @Then("I record the row that contains {string}")
    public void iRecordTheRowThatContains(String email){
        demoqaElementsPageObjects.recordRow(email);
    }
}
