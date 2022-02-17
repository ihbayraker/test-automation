package com.testautomation.stepdef;

import com.testautomation.pageobjects.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TextBoxStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;
    private String name;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public TextBoxStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @Given("I navigate to elements page")
    public void iNavigateToElementsPage(){
        demoqaHomePageObjects.navigateToElements();
    }

    @And("I click Text box")
    public void iClickTextBox(){
        demoqaHomePageObjects.selectItem(1);
    }

    @Then("I fill Full Name with {string}")
    public void iFillFullNameWith(String name){
        this.name=name;
        demoqaElementsPageObjects.typeName(name);

    }

    @And("I fill Email with {string}")
    public void iFillEmailWith(String email){
        this.email=email;
        demoqaElementsPageObjects.typeEmail(email);
    }

    @And("I fill Current Address with {string}")
    public void iFillCurrentAddressWith(String address){
        currentAddress = address;
        demoqaElementsPageObjects.typeCurrentAddress(address);
    }

    @And("I fill Permanent Address with {string}")
    public void iFillPermanentAddressWith(String address){
        permanentAddress = address;
        demoqaElementsPageObjects.typePermanentAddress(address);
    }

    @Then("I press submit")
    public void iPressSubmit(){
        demoqaElementsPageObjects.pressSubmit();
    }

    @Then("I validate that i filled the boxes correctly")
    public void iValidateThatIFilledTheBoxesCorrectly(){
        String output = demoqaElementsPageObjects.checkOutput();

        Assert.assertTrue("Couldn't find entered name in output("+name+")",output.contains(name));
        Assert.assertTrue("Couldn't find entered email in output("+email+")",output.contains(email));
        Assert.assertTrue("Couldn't find entered current address in output("+currentAddress+")",output.contains(currentAddress));
        Assert.assertTrue("Couldn't find entered permanent address in output("+permanentAddress+")",output.contains(permanentAddress));
    }
}
