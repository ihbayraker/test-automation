package com.testautomation.pageobjects.interfaces;

public interface DemoqaElementsPageObjectsInterface extends PageObjectInterface {


    void typeName(String name);

    void typeEmail(String email);

    void typeCurrentAddress(String address);

    void typePermanentAddress(String address);

    void pressSubmit();

    String checkOutput();

    void unwindNodes(int i);

    String toggleNodes(int i);

    String checkSelectedNodes();

    String checkAButton(int i);

    String checkRadioButtons();

    void clickAddRegistration();

    void fillFirstName(String name);

    void fillLastName(String name);

    void fillEmail(String email);

    void fillAge(String age);

    void fillSalary(String salary);

    void fillDepartment(String department);

    void submitRegistration();

    boolean checkTableBody(String text) throws Exception;

    String getRow(int i);

    void deleteRow(int i);

    void updateEntry(int i);

    void  recordRow(String text);

    void doDoubleClick();

    void doRightClick();

    void doNormalClick();

    String writeClickResults();

    boolean clickApiCallLinkAndRecordStatus(String api) throws Exception;

    void pressDownloadFile();

    boolean checkFileDownloaded(String fileName) throws Exception;

    void uploadDownloadedFile(String fileName);

    boolean checkFileUploadedAndErase(String fileName);
}
