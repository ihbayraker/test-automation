package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends ApiResponse {

    @SerializedName("id")
    int id;
    @SerializedName("userStatus")
    int userStatus;
    @SerializedName("username")
    String username;
    @SerializedName("firstName")
    String firstName;
    @SerializedName("lastName")
    String lastName;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("phone")
    String phone;
}
