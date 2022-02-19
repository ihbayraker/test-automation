package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse {

    @SerializedName("code")
    int code;
    @SerializedName("type")
    String type;
    @SerializedName("message")
    String message;

}
