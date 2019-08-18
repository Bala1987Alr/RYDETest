package com.bala.myapplication.model.daos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewContactResponse {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;
}
