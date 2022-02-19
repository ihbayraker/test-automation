package com.testautomation.api.petstore.interfaces;

import com.testautomation.pojo.ApiResponse;
import com.testautomation.pojo.User;

public interface UserRequestInterface extends RequestInterface {

    ApiResponse createUser(String username, String firstName, String lastName, String email, String password, String Phone) throws Exception;

    ApiResponse updateUser(String username, String updatedUsername, String firstName, String lastName, String email, String password, String Phone) throws Exception;

    User getUser(String username, int i) throws Exception;

    ApiResponse loginUser(String username, String password) throws Exception;

    ApiResponse logoutUser() throws Exception;

    boolean deleteUser(String username, int x) throws Exception;
}
