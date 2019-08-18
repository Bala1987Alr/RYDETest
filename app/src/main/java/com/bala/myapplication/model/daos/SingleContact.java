package com.bala.myapplication.model.daos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleContact {

    @SerializedName("data")
    @Expose
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
