package com.bala.myapplication.service;

import com.bala.myapplication.model.daos.Contact;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.daos.NewContactResponse;
import com.bala.myapplication.model.daos.SingleContact;

import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContactRepository {

    String base_url = "https://reqres.in/api/";

    @GET("users")
    Call<ContactList> getContactList(@Query("page")  int page);

    @GET("users/{id}")
    Call<SingleContact> getContact(@Path("id") int id);

    @POST("users")
    Call<NewContactResponse> addContact(TreeMap<String,String> treeMap);
}
