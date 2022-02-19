package com.testautomation.pageobjects.demoqa.interfaces;

public interface DemoqaFormsObjectsInterface extends PageObjectInterface {

    void typeNameAndSurname(String name, String Surname);

    void typeEmail(String email);

    void selectGender(int i);

    void typeMobileNumber(String number);

    void ChooseDateOfBirth(int day, int month, int year) throws Exception;

    void typeSubject(String subject);

    void selectHobbies(int i);

    void generateAndUploadImage() throws Exception;

    void typeAddress(String address);

    void selectStateAndCity(int state, int city);

    void submitForm();

    void checkAndReportForm();
}
