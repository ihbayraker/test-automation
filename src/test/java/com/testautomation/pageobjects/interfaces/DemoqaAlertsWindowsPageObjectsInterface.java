package com.testautomation.pageobjects.interfaces;

public interface DemoqaAlertsWindowsPageObjectsInterface extends PageObjectInterface {

    void clickNewTab();

    Boolean checkNewTabUrl(String text) throws Exception;

    void clickNewWindow();

    void clickNewMessage();

    boolean checkNewMessage() throws Exception;

    boolean clickAndCheckAlert(int wait) throws Exception;

    boolean clickAndCancelAlert();

    boolean clickAndTypeInAlert(String text);

    String validateConfirmBoxResult();

    String validatePromptBoxResult();
}
