package com.testautomation.stepdef;

import com.testautomation.pageobjects.demoqa.web.DemoqaElementsPageObjects;
import com.testautomation.pageobjects.demoqa.web.DemoqaHomePageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

public class ElementsStepDef {

    private final DemoqaHomePageObjects demoqaHomePageObjects;
    private final DemoqaElementsPageObjects demoqaElementsPageObjects;

    private ArrayList<String> nodes = new ArrayList<>();
    private String radioButton;
    private String entry;
    private String name;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public ElementsStepDef() throws Exception {
        demoqaHomePageObjects = new DemoqaHomePageObjects();
        demoqaElementsPageObjects = new DemoqaElementsPageObjects();
    }

    @And("I click Buttons")
    public void iClickButtons() {
        demoqaHomePageObjects.selectItem(5);
    }

    @Then("I double click the button")
    public void iDoubleClickTheButton(){
        demoqaElementsPageObjects.doDoubleClick();
    }

    @And("I right click the button")
    public void iRightClickTheButton(){
        demoqaElementsPageObjects.doRightClick();
    }

    @And("I click the button")
    public void iClickTheButton(){
        demoqaElementsPageObjects.doNormalClick();
    }

    @Then("I validate that I clicked all buttons")
    public void iValidateThatIClickedAllButtons(){
        String output = demoqaElementsPageObjects.writeClickResults();
        Assert.assertTrue("Double click was a failure",output.contains("double click"));
        Assert.assertTrue("right click was a failure",output.contains("right click"));
        Assert.assertTrue("dynamic click was a failure",output.contains("dynamic click"));
    }

    @And("I click Check box")
    public void iClickCheckBox(){
        demoqaHomePageObjects.selectItem(2);
    }

    @And("I unwind tree nodes")
    public void iUnwindTreeNodes(){
        demoqaElementsPageObjects.unwindNodes(1);
        demoqaElementsPageObjects.unwindNodes(2);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(3);
        demoqaElementsPageObjects.unwindNodes(4);
        demoqaElementsPageObjects.unwindNodes(5);
    }

    @Then("I toggle few nodes")
    public void iToggleFewNodes(){
        nodes.add(demoqaElementsPageObjects.toggleNodes(7));
        nodes.add(demoqaElementsPageObjects.toggleNodes(13));

    }

    @Then("I validate the checked nodes")
    public void iValidateTheCheckedNodes(){
        String Output = demoqaElementsPageObjects.checkSelectedNodes();
        Assert.assertTrue((nodes.get(0))+" was supposed to be toggled",Output.contains(nodes.get(0)));
        Assert.assertTrue((nodes.get(1))+" was supposed to be toggled",Output.contains(nodes.get(1)));
    }

    @And("I click Download and Upload")
    public void iClickDownloadAndUpload(){
        demoqaHomePageObjects.selectItem(8);
    }

    @Then("I press download button")
    public void iPressDownloadButton() {
        demoqaElementsPageObjects.pressDownloadFile();
    }

    @And("I validate that i downloaded the file")
    public void iValidateThatIDownloadedTheFile() throws Exception {
        Assert.assertTrue("Couldn't find the downloaded file",demoqaElementsPageObjects.checkFileDownloaded("sampleFile.jpeg"));
    }

    @Then("I upload the downloaded file back")
    public void iUploadTheDownloadedFileBack(){
        demoqaElementsPageObjects.uploadDownloadedFile("sampleFile.jpeg");
    }

    @And("I validate that i uploaded the file")
    public void iValidateThatIUploadedTheFile(){
        Assert.assertTrue("The upload was unsuccessful",demoqaElementsPageObjects.checkFileUploadedAndErase("sampleFile.jpeg"));
    }

    @And("I click Links")
    public void iClickLinks() {
        demoqaHomePageObjects.selectItem(6);
    }

    @Then("I click created then check its api call")
    public void iClickCreatedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 201 Created",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("created"));
    }

    @And("I click No content then check its api call")
    public void iClickNoContentThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 204 No Content",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("no-content"));
    }

    @And("I click Moved then check its api call")
    public void iClickMovedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 301 Moved Permanently",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("moved"));
    }

    @And("I click Bad Request then check its api call")
    public void iClickBadRequestThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 400 Bad Request",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("bad-request"));
    }

    @And("I click Unauthorized then check its api call")
    public void iClickUnauthorizedThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 401 Unauthorized",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("unauthorized"));
    }

    @And("I click Forbidden then check its api call")
    public void iClickForbiddenThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 403 Forbidden",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("forbidden"));
    }

    @And("I click Not Found then check its api call")
    public void iClickNotFoundThenCheckItsApiCall() throws Exception {
        Assert.assertTrue("Status code was not 404 Not Found",demoqaElementsPageObjects.clickApiCallLinkAndRecordStatus("invalid-url"));
    }

    @And("I click Radio Button")
    public void iClickRadioButton(){
        demoqaHomePageObjects.selectItem(3);
    }

    @And("I check a button")
    public void iCheckAButton(){
        radioButton = demoqaElementsPageObjects.checkAButton(2);

    }

    @Then("I validate the checked button")
    public void iValidateTheCheckedButton(){
        Assert.assertTrue(radioButton+" was supposed to be selected",demoqaElementsPageObjects.checkRadioButtons().contains(radioButton));
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

    @Then("I record an entry")
    public void iRecordAnEntry(){
        entry = demoqaElementsPageObjects.getRow(1);
    }

    @And("I delete the recorded entry")
    public void iDeleteTheRecordedEntry(){
        demoqaElementsPageObjects.deleteRow(1);
    }

    @Then("I check that the entry is deleted")
    public void iCheckThatTheEntryIsDeleted() throws Exception {
        Assert.assertFalse("The deleted row was still available",demoqaElementsPageObjects.checkTableBody(entry));
    }

    @Then("I press update for recorded entry")
    public void iPressUpdateForRecordedEntry(){
        demoqaElementsPageObjects.updateEntry(1);
    }
}
