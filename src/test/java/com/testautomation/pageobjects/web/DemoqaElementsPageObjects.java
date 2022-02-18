package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaElementsPageObjectsInterface;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

import java.io.File;
import java.nio.file.FileSystems;

public class DemoqaElementsPageObjects extends PageObject implements DemoqaElementsPageObjectsInterface {

    private final String targetPath = FileSystems.getDefault().getPath("").toAbsolutePath() + File.separator + "target";

    public DemoqaElementsPageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void typeName(String name) {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxUsernameXpath"),browser,name,true);
    }

    @Override
    public void typeEmail(String email){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxUserEmailXpath"),browser,email,true);
    }

    @Override
    public void typeCurrentAddress(String address){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxCurrentAddressXpath"),browser,address,true);
    }

    @Override
    public void typePermanentAddress(String address){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxPermanentAddressXpath"),browser,address,true);
    }

    @Override
    public void pressSubmit(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("textBoxSubmitButtonXpath"),browser);
    }

    @Override
    public String checkOutput(){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("textBoxOutputXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("textBoxOutputXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

    @Override
    public void unwindNodes(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxToggleXpath")+"["+i+"]",browser);
    }

    @Override
    public String toggleNodes(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxNodeXpath")+"["+i+"]",browser);
        return Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxNodeXpath")+"["+i+"]",browser).toLowerCase();
    }

    @Override
    public String checkSelectedNodes(){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxResultXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxResultXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

    @Override
    public String checkAButton(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSelectionXpath")+"["+i+"]",browser);
        return Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSelectionXpath")+"["+i+"]",browser);
    }

    @Override
    public String checkRadioButtons(){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSuccessXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSuccessXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

    @Override
    public void clickAddRegistration(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesAddXpath"),browser);
    }

    @Override
    public void fillFirstName(String name){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterFirstNameXpath"),browser,name,true);
    }

    @Override
    public void fillLastName(String name){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterLastNameXpath"),browser,name,true);
    }

    @Override
    public void fillEmail(String email){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterEmailXpath"),browser,email,true);
    }

    @Override
    public void fillAge(String age){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterAgeXpath"),browser,age,true);
    }

    @Override
    public void fillSalary(String salary){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRegisterSalaryXpath"),browser,salary,true);
    }

    @Override
    public void fillDepartment(String department){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRegisterDepartmentXpath"),browser,department,true);
    }

    @Override
    public void submitRegistration(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRegisterSubmitXpath"),browser);
    }


    @Override
    public boolean checkTableBody(String text) throws Exception {
        String body;
        for(int i = 0; i<10; i++){
            body = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesBodyXpath"),browser);
            if(body.contains(text)){
                return true;
            }else{
                Thread.sleep(100);
            }
        }
        return false;
    }

    @Override
    public String getRow(int i) {
        return Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRowXpath")+"["+i+"]",browser);
    }

    @Override
    public void deleteRow(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesDeleteXpath")+"["+i+"]",browser);
    }

    @Override
    public void updateEntry(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesEditXpath")+"["+i+"]",browser);
    }

    @Override
    public void recordRow(String text){
        String row = null;
        int rowCount = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("WebTablesRowXpath"),browser);

        for(int i = 1; i<=rowCount; i++){
            row = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRowXpath")+"["+i+"]",browser);
            if(row.contains(text)){
                break;
            }
        }

        Helper.scenarioWrite(Hooks.getScenario(),row,"Output");
    }

    @Override
    public void doDoubleClick(){
        Helper.doubleClickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsDoubleClickXpath"),browser);
    }

    @Override
    public void doRightClick(){
        Helper.rightClickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsRightClickXpath"),browser);
    }

    @Override
    public void doNormalClick(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsClickXpath"),browser);
    }

    @Override
    public String writeClickResults() {
        StringBuilder stringBuilder = new StringBuilder();
        int messageCount = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("buttonsClickMessageXpath"),browser);
        for(int i = 1; i<=messageCount; i++){
            Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("buttonsClickMessageXpath")+"["+i+"]",browser);
            String message = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("buttonsClickMessageXpath")+"["+i+"]",browser);
            stringBuilder.append(message);
            stringBuilder.append("\n");
        }
        String output = stringBuilder.toString();
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        return output;
    }

    @Override
    public boolean clickApiCallLinkAndRecordStatus(String api) throws Exception {
        String key = null;
        int status = 0;
        String response = null;
        switch (api){
            case "created":
                key = "linksCreatedXpath";
                status = 201;
                break;
            case "no-content":
                key = "linksNoContentXpath";
                status = 204;
                break;
            case "moved":
                key = "linksMovedXpath";
                status = 301;
                break;
            case "bad-request":
                key = "linksBadRequestXpath";
                status = 400;
                break;
            case "unauthorized":
                key = "linksUnauthorizedXpath";
                status = 401;
                break;
            case "forbidden":
                key = "linksForbiddenXpath";
                status = 403;
                break;
            case "invalid-url":
                key = "linksNotFoundXpath";
                status = 404;
                break;
            default:
                return false;
        }
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty(key),browser);

        for(int i=0; i<10; i++){
            response = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("LinksResponseXpath"),browser);
            if(response.contains(String.valueOf(status))){
                Helper.scenarioWrite(Hooks.getScenario(),response,"Output");
                return true;
            }else {
                Thread.sleep(100);
                response = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("LinksResponseXpath"),browser);
            }
        }
        return false;
    }

    @Override
    public void pressDownloadFile() {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("fileDownloadButtonXpath"),browser);
    }

    @Override
    public boolean checkFileDownloaded(String fileName) throws Exception {
        File downloadedFile = new File(targetPath + File.separator + fileName);
        for(int i=0; i<10; i++){
            if(downloadedFile.exists()){
                return true;
            }else{
                Thread.sleep(100);
            }
        }
        return false;
    }

    @Override
    public void uploadDownloadedFile(String fileName) {
        String filePath = targetPath + File.separator + fileName;
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("fileUploadButtonXpath"),browser,filePath,true);
    }

    @Override
    public boolean checkFileUploadedAndErase(String fileName) {
        File downloadedFile = new File(targetPath + File.separator + fileName);
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("fileUploadedMessageXpath"),browser);

        downloadedFile.delete();
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("fileUploadedMessageXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");

        if(output.contains(fileName)){
            return true;
        }else{
            return false;
        }

    }
}
