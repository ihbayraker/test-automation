package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class Pet extends ApiResponse  {

    @SerializedName("id")
    private long id;
    @SerializedName("category")
    private Category category;
    @SerializedName("name")
    private String name;
    @SerializedName("photoUrls")
    private List<String> photoUrls = null;
    @SerializedName("tags")
    private List<Tag> tags = null;
    @SerializedName("status")
    private String status;
}
