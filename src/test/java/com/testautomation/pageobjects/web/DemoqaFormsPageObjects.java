package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaFormsObjectsInterface;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static java.lang.Integer.parseInt;

public class DemoqaFormsPageObjects extends PageObject implements DemoqaFormsObjectsInterface {

    public DemoqaFormsPageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public void typeNameAndSurname(String name, String Surname){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formFirstNameXpath"),browser,name,true);
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formLastNameXpath"),browser,Surname,true);
    }

    @Override
    public void typeEmail(String email){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formEmailXpath"),browser,email,true);
    }

    @Override
    public void selectGender(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formGenderSelectionXpath")+"["+i+"]",browser);
    }

    @Override
    public void typeMobileNumber(String number){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formMobileXpath"),browser,number,true);
    }

    @Override
    public void ChooseDateOfBirth(int day, int month, int year) throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formBirthdayXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerMonthXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerMonthOptionsXpath")+"["+month+"]",browser);

        year = year-1899;
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerYearXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerYearOptionsXpath")+"["+year+"]",browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerYearXpath"),browser);

        Thread.sleep(250);
        int elementDay;
        boolean inRightMonth = false;
        int count = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("formDatePickerDayXpath"),browser);
        for(int i=1; i<=count; i++){
            elementDay = parseInt(Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerDayXpath")+"["+i+"]",browser));

            if(elementDay==1 & !inRightMonth){
                inRightMonth = true;
            }

            if(elementDay==day && inRightMonth){
                Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formDatePickerDayXpath")+"["+i+"]",browser);
                break;
            }
        }
        Thread.sleep(500);
    }

    @Override
    public void typeSubject(String subject){
        Actions act = new Actions(browser);

        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formSubjectXpath"),browser);
        act.sendKeys(subject).perform();
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formSubjectOptionsXpath"),browser);
    }

    @Override
    public void selectHobbies(int i){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formHobbiesXpath")+"["+i+"]",browser);
    }

    @Override
    public void generateAndUploadImage() throws Exception {
        Helper.generateDummyImage(500,500,"img");

        String filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "img.jpg";
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formUploadPictureXpath"),browser,filePath,true);
    }

    @Override
    public void typeAddress(String address) {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("formCurrentAddressXpath"),browser,address,true);
    }

    @Override
    public void selectStateAndCity(int state, int city) {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formStateXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formStateOptionsXpath")+"["+state+"]",browser);

        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formCityXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formCityOptionsXpath")+"["+city+"]",browser);
    }

    @Override
    public void submitForm() {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("formSubmitButtonXpath"), browser);
    }

    @Override
    public void checkAndReportForm() {
        StringBuilder stringBuilder = new StringBuilder();
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("formResultsPopupXpath"),browser);

        int itemCount = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("formResultsPopupXpath"),browser);

        for(int i = 1; i<=itemCount; i++){
            if(i%2==0){
                String item = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("formResultsPopupXpath")+"["+i+"]",browser);
                stringBuilder.append(item);
                stringBuilder.append("\n");
            }
        }

        String output = stringBuilder.toString();
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");
    }
}
