package com.testautomation.pageobjects.interfaces;

public interface DemoqaBookstorePageObjectsInterface extends PageObjectInterface {


    Boolean createAccount(String username, String password) throws Exception;

    void login(String username, String Password);

    boolean checkLoginFailMessage();

    boolean checkLoginSuccess(String username);

    void clickGoToBookstore();

    void searchAndClickBook(String book) throws Exception;

    void addBookToCollection() throws Exception;

    void ClickGoBackToBookstore();

    void deleteBook(String book) throws Exception;

    String getBookFromTable(String book);

    void deleteAllBooks() throws Exception;

    void logout();

    boolean deleteAccount() throws Exception;
}
