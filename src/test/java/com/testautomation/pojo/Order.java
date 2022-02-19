package com.testautomation.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Order extends ApiResponse {

    @SerializedName("id")
    int id;
    @SerializedName("petId")
    int petId;
    @SerializedName("quantity")
    int quantity;
    @SerializedName("shipDate")
    String shipDate;
    @SerializedName("status")
    String status;
    @SerializedName("complete")
    boolean complete;
}
