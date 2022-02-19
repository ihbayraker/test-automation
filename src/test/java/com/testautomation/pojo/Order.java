package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

    @SerializedName("id")
    int id;
    @SerializedName("petId")
    int petId;
    @SerializedName("quantity")
    int quantity;
    @SerializedName("shipDate")
    int shipDate;
    @SerializedName("status")
    String status;
    @SerializedName("complete")
    boolean complete;
}
