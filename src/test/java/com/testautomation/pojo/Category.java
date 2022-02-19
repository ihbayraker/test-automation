package com.testautomation.pojo;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Category {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
}

