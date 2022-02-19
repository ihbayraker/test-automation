package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class Pet {

    private int httpStatusCode;
    private String responseMessage;

    @SerializedName("id")
    public int id;
    @SerializedName("category")
    public Category category;
    @SerializedName("name")
    public String name;
    @SerializedName("photoUrls")
    public List<String> photoUrls = null;
    @SerializedName("tags")
    public List<Tag> tags = null;
    @SerializedName("status")
    public String status;
}
