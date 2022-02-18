package com.testautomation.pageobjects.web;

import com.testautomation.pageobjects.interfaces.DemoqaBookstorePageObjectsInterface;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.ApiUtils;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;

import java.net.http.HttpResponse;

public class DemoqaBookstorePageObjects extends PageObject implements DemoqaBookstorePageObjectsInterface {

    public DemoqaBookstorePageObjects() throws Exception {
        super();
        PropertiesUtils.setEnvironment("demoqa");
    }

    @Override
    public Boolean createAccount(String username, String password) throws Exception {
        JSONObject post=new JSONObject();
        post.put("userName",username);
        post.put("password",password);

        HttpResponse<String> response = ApiUtils.postRequest("https://demoqa.com/Account/v1/User",post.toString());
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Output");

        return response.statusCode() == 201;
    }

    @Override
    public void login(String username, String Password){
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreUsernameXpath"),browser,username,true);
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("bookstorePasswordXpath"),browser,Password,true);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLoginButtonXpath"),browser);
    }

    @Override
    public boolean checkLoginFailMessage(){
        try{
            Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLoginFailureXpath"),browser);
        }catch (NoSuchElementException ignored){
            return false;
        }
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLoginFailureXpath"),browser);
        Helper.scenarioWrite(Hooks.getScenario(),output,"Output");
        return true;
    }

    @Override
    public boolean checkLoginSuccess(String username){
        try{
            Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLoginSuccessXpath"),browser);
        }catch (NoSuchElementException ignored){
            return false;
        }
        String output = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLoginSuccessXpath"),browser);
        return output.contains(username);
    }

    @Override
    public void clickGoToBookstore(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreGoToStoreButtonXpath"),browser);
    }

    @Override
    public void searchAndClickBook(String book) throws Exception {
        Helper.sendKeysByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreSearchXpath"),browser,book,true);
        Thread.sleep(250);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreBookTitleXpath")+"[1]",browser);
    }

    @Override
    public void addBookToCollection() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreAddBookButtonXpath"),browser);
        Helper.checkAlertThenAccept(browser);
    }

    @Override
    public void ClickGoBackToBookstore(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreGoBackXpath"),browser);
    }

    @Override
    public void deleteBook(String book) throws Exception {
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreBodyXpath"),browser);

        int rowCount = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("BookstoreRowXpath"),browser);
        for(int i = 1; i<=rowCount; i++){
            String row = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreRowXpath")+"["+i+"]",browser);

            if(row.contains(book)){
                Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreDeleteXpath")+"["+i+"]",browser);
                Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstorePopupAcceptButtonXpath"),browser);
                Helper.checkAlertThenAccept(browser);
                break;
            }
        }
    }

    @Override
    public String getBookFromTable(String book){
        Helper.WaitForElementPresentByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreBodyXpath"),browser);

        int rowCount = Helper.getElementCount(PropertiesUtils.getEnvironmentProperty("BookstoreRowXpath"),browser);
        for(int i = 1; i<=rowCount; i++){
            String row = Helper.getTextByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreRowXpath")+"["+i+"]",browser);

            if(row.contains(book)){
                Helper.scenarioWrite(Hooks.getScenario(),row,"Output");
                return row;
            }
        }
        return null;
    }

    @Override
    public void deleteAllBooks() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreDeleteAllBooksButtonXpath"), browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstorePopupAcceptButtonXpath"), browser);
        Helper.checkAlertThenAccept(browser);
    }

    @Override
    public void logout(){
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("bookstoreLogoutButtonXpath"), browser);
    }

    @Override
    public boolean deleteAccount() throws Exception {
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstoreDeleteAccountButtonXpath"),browser);
        Helper.clickByXpath(PropertiesUtils.getEnvironmentProperty("BookstorePopupAcceptButtonXpath"),browser);
        Helper.checkAlertThenAccept(browser);

        for(int i = 0; i<=10; i++){
            if(Helper.getUrl(browser).contains("login")){
                return true;
            }else{
                Thread.sleep(100);
            }
        }
        return false;
    }
}
