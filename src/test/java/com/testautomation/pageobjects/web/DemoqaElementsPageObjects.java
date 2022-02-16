package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaElementsPageObjectsInterface;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

public class DemoqaElementsPageObjects extends PageObject implements DemoqaElementsPageObjectsInterface {

    public DemoqaElementsPageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void typeName(String name) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxUsernameXpath"),browser,name);
    }

    @Override
    public void typeEmail(String email) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxUserEmailXpath"),browser,email);
    }

    @Override
    public void typeCurrentAddress(String address) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxCurrentAddressXpath"),browser,address);
    }

    @Override
    public void typePermanentAddress(String address) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("textBoxPermanentAddressXpath"),browser,address);
    }

    @Override
    public void pressSubmit() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("textBoxSubmitButtonXpath"),browser);
    }

    @Override
    public void checkOutput() throws Exception {
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("textBoxOutputXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("textBoxOutputXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");
    }

    @Override
    public void unwindNodes(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxToggleXpath")+"["+i+"]",browser);
    }

    @Override
    public void toggleNodes(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxNodeXpath")+"["+i+"]",browser);
    }

    @Override
    public void checkSelectedNodes() throws Exception {
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxResultXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("checkBoxResultXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");
    }

    @Override
    public void checkAButton(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSelectionXpath")+"["+i+"]",browser);
    }

    @Override
    public void checkRadioButtons() throws Exception {
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSuccessXpath"),browser);
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("radioButtonSuccessXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");
    }

    @Override
    public void clickAddRegistration() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesAddXpath"),browser);
    }

    @Override
    public void fillFirstName(String name) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterFirstNameXpath"),browser,name);
    }

    @Override
    public void fillLastName(String name) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterLastNameXpath"),browser,name);
    }

    @Override
    public void fillEmail(String email) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterEmailXpath"),browser,email);
    }

    @Override
    public void fillAge(String age) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("webTablesRegisterAgeXpath"),browser,age);
    }

    @Override
    public void fillSalary(String salary) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRegisterSalaryXpath"),browser,salary);
    }

    @Override
    public void fillDepartment(String department) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRegisterDepartmentXpath"),browser,department);
    }

    @Override
    public void submitRegistration() throws Exception {
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
    public String getRow(int i) throws Exception {
        return Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("WebTablesRowXpath")+"["+i+"]",browser);
    }

    @Override
    public void deleteRow(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesDeleteXpath")+"["+i+"]",browser);
    }

    @Override
    public void updateEntry(int i) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("webTablesEditXpath")+"["+i+"]",browser);
    }

    @Override
    public void recordRow(String text) throws Exception {
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
    public void doDoubleClick() throws Exception {
        Helper.doubleClickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsDoubleClickXpath"),browser);
    }

    @Override
    public void doRightClick() throws Exception {
        Helper.rightClickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsRightClickXpath"),browser);
    }

    @Override
    public void doNormalClick() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("buttonsClickXpath"),browser);
    }

    @Override
    public void writeClickResults() throws Exception {
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
}
