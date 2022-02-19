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
    private long id;
    @SerializedName("petId")
    private int petId;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("shipDate")
    private String shipDate;
    @SerializedName("status")
    private String status;
    @SerializedName("complete")
    private boolean complete;
}
