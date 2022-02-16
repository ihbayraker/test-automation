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
    public void iClickWebTable() throws Exception {
        demoqaHomePageObjects.selectItem(4);
    }

    @Then("I press add new registration")
    public void iPressAddNewRegistration() throws Exception {
        demoqaElementsPageObjects.clickAddRegistration();
    }

    @And("I fill First Name with {string}")
    public void iFillFirstNameWith(String name) throws Exception {
        demoqaElementsPageObjects.fillFirstName(name);
    }

    @And("I fill Last Name with {string}")
    public void iFillLastNameWith(String name) throws Exception {
        demoqaElementsPageObjects.fillLastName(name);
    }

    @And("I fill userEmail with {string}")
    public void iFillUserEmailWith(String email) throws Exception {
        demoqaElementsPageObjects.fillEmail(email);
    }

    @And("I fill Age with {string}")
    public void iFillAgeWith(String age) throws Exception {
        demoqaElementsPageObjects.fillAge(age);
    }

    @And("I fill Salary with {string}")
    public void iFillSalaryWith(String salary) throws Exception {
        demoqaElementsPageObjects.fillSalary(salary);
    }

    @And("I fill Department with {string}")
    public void iFillDepartmentWith(String department) throws Exception {
        demoqaElementsPageObjects.fillDepartment(department);
    }

    @Then("I press submit the registration form")
    public void iPressSubmitTheRegistrationForm() throws Exception {
        demoqaElementsPageObjects.submitRegistration();
    }

    @And("I validate that table contains {string} and {string}")
    public void iValidateThatTableContainsAnd(String firstName, String LastName) throws Exception {
        Assert.assertTrue("Couldn't find registered First Name in the table",demoqaElementsPageObjects.checkTableBody(firstName));
        Assert.assertTrue("Couldn't find registered Last Name in the table",demoqaElementsPageObjects.checkTableBody(LastName));
    }

    @Then("I record the row that contains {string}")
    public void iRecordTheRowThatContains(String email) throws Exception {
        demoqaElementsPageObjects.recordRow(email);
    }
}
