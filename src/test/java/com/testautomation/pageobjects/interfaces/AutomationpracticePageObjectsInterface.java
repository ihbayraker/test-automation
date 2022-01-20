package com.testautomation.pageobjects.interfaces;

public interface AutomationpracticePageObjectsInterface extends PageObjectInterface {

    void navigateToHomepage() throws Exception;

    void searchKeyword(String keyword) throws Exception;

    String getFirstProduct() throws Exception;
}
