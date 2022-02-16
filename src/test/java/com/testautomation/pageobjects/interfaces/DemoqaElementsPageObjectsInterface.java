package com.testautomation.pageobjects.interfaces;

public interface DemoqaElementsPageObjectsInterface extends PageObjectInterface {


    void typeName(String name) throws Exception;

    void typeEmail(String email) throws Exception;

    void typeCurrentAddress(String address) throws Exception;

    void typePermanentAddress(String address) throws Exception;

    void pressSubmit() throws Exception;

    void checkOutput() throws Exception;

    void unwindNodes(int i) throws Exception;

    void toggleNodes(int i) throws Exception;

    void checkSelectedNodes() throws Exception;

    void checkAButton(int i) throws Exception;

    void checkRadioButtons() throws Exception;

    void clickAddRegistration() throws Exception;

    void fillFirstName(String name) throws Exception;

    void fillLastName(String name) throws Exception;

    void fillEmail(String email) throws Exception;

    void fillAge(String age) throws Exception;

    void fillSalary(String salary) throws Exception;

    void fillDepartment(String department) throws Exception;

    void submitRegistration() throws Exception;

    boolean checkTableBody(String text) throws Exception;

    String getRow(int i) throws Exception;

    void deleteRow(int i) throws Exception;

    void updateEntry(int i) throws Exception;

    void recordRow(String text) throws Exception;

    void doDoubleClick() throws Exception;

    void doRightClick() throws Exception;

    void doNormalClick() throws Exception;

    void writeClickResults() throws Exception;

    boolean clickApiCallLinkAndRecordStatus(String api) throws Exception;
}
