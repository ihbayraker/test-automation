package com.testautomation.api.petstore.requests;

import com.google.gson.GsonBuilder;
import com.testautomation.api.petstore.interfaces.UserRequestInterface;
import com.testautomation.pojo.ApiResponse;
import com.testautomation.pojo.User;
import com.testautomation.stepdef.Hooks;
import com.testautomation.utils.Helper;
import com.testautomation.utils.PropertiesUtils;

import java.net.http.HttpResponse;

public class UserRequest extends Request implements UserRequestInterface {

    public UserRequest() throws Exception {
        PropertiesUtils.setEnvironment("petstore");
    }

    @Override
    public ApiResponse createUser(String username, String firstName, String lastName, String email, String password, String Phone) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(Phone);

        String post = new GsonBuilder().create().toJson(user);

        HttpResponse<String> response = postRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserApi"),post);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        return new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
    }

    @Override
    public ApiResponse updateUser(String username, String updatedUsername, String firstName, String lastName, String email, String password, String Phone) throws Exception {
        User user = new User();
        user.setUsername(updatedUsername);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(Phone);

        String post = new GsonBuilder().create().toJson(user);

        HttpResponse<String> response = putRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserApi")+"/"+username,post);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        return new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
    }

    @Override
    public User getUser(String username, int x) throws Exception {
        User user;
        HttpResponse<String> response = null;

        for(int i = 0; i < x; i++){
            response = getRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserApi")+"/"+username);
            if(response.statusCode()==200){
                break;
            }
        }

        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");
        user = new GsonBuilder().create().fromJson(response.body(), User.class);
        user.setCode(response.statusCode());

        return user;
    }

    @Override
    public ApiResponse loginUser(String username, String password) throws Exception {
        String append = "?username="+username+"&password="+password;
        HttpResponse<String> response = getRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserLoginApi")+append);
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        return new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
    }

    @Override
    public ApiResponse logoutUser() throws Exception {
        HttpResponse<String> response = getRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserLogoutApi"));
        Helper.scenarioWrite(Hooks.getScenario(),response.body(),"Response");

        return new GsonBuilder().create().fromJson(response.body(), ApiResponse.class);
    }

    @Override
    public boolean deleteUser(String username, int x) throws Exception {

        for(int i = 0; i < x; i++){
            HttpResponse<String> response = deleteRequest(PropertiesUtils.getEnvironmentProperty("petstoreUserApi")+"/"+username);
            if(response.statusCode()==200){
                Helper.scenarioWrite(Hooks.getScenario(), response.body(), "Response");
                return true;
            }else{
                Helper.scenarioWrite(Hooks.getScenario(), "{\"code\":404}", "Response");
            }
        }

        return false;
    }
}
