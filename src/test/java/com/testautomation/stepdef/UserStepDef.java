package com.testautomation.stepdef;

import com.testautomation.api.petstore.requests.UserRequest;
import com.testautomation.pojo.ApiResponse;
import com.testautomation.pojo.User;
import com.testautomation.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserStepDef {

    private final UserRequest userRequest;

    private String username;
    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private String phone;

    public UserStepDef() throws Exception {
        userRequest = new UserRequest();
        username = Helper.generateString(8);
    }


    @Given("I create a new user with name:{string}, lastName:{string}, email:{string}, password:{string}, number:{string},")
    public void iCreateANewUserWithNameLastNameEmailPasswordNumber(String firstName, String lastname, String email, String password, String phone) throws Exception {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;

        ApiResponse apiResponse = userRequest.createUser(username,firstName,lastname,email,password,phone);
        Assert.assertEquals("Account creation was a failure", 200, apiResponse.getCode());
    }

    @Then("I check the user")
    public void iCheckTheUser() throws Exception {
        User user = userRequest.getUser(username,10);

        Assert.assertEquals("Could not find the account", 200, user.getCode());
        Assert.assertEquals("First name of the user was wrong", firstName, user.getFirstName());
        Assert.assertEquals("Last name of the user was wrong", lastname, user.getLastName());
        Assert.assertEquals("email of the user was wrong", email, user.getEmail());
        Assert.assertEquals("password of the user was wrong", password, user.getPassword());
        Assert.assertEquals("Phone number of the user was wrong", phone, user.getPhone());
    }

    @And("I login to my user")
    public void iLoginToMyAccount() throws Exception {
        ApiResponse apiResponse = userRequest.loginUser(username,password);
        Assert.assertEquals("Login was a failure", 200, apiResponse.getCode());
    }

    @And("I delete the user")
    public void iDeleteTheUser() throws Exception {
        Assert.assertTrue("Couldn't delete the user", userRequest.deleteUser(username,10));

    }

    @Then("I check that the user is no longer available")
    public void iCheckThatTheUserIsNoLongerAvailable() throws Exception {
        User user = userRequest.getUser(username,1);

        Assert.assertNotEquals("The user was still available", 200, user.getCode());
    }

    @And("I update the user")
    public void iUpdateTheUser() throws Exception {
        String oldUsername = username;

        username = username+"Updated";
        firstName = firstName+"Updated";
        lastname = lastname+"Updated";
        email = email+"Updated";
        password = password+"Updated";
        phone = phone+"Updated";

        ApiResponse apiResponse = userRequest.updateUser(oldUsername,username, firstName, lastname, email, password, phone);
        Assert.assertEquals("Could not update the user", 200, apiResponse.getCode());
    }
}
