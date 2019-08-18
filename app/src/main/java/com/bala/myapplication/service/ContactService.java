package com.bala.myapplication.service;

import android.arch.lifecycle.MutableLiveData;

import com.bala.myapplication.model.daos.ContactList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactService {

    private static ContactService contactService;
    private ContactRepository repository;

    private ContactService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ContactRepository.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repository = retrofit.create(ContactRepository.class);
    }

    public synchronized static ContactService getInstance()
    {
        if(contactService == null)
        {
            contactService = new ContactService();
        }
        return contactService;
    }

    public MutableLiveData<ContactList> getContacts(int page)
    {
        MutableLiveData<ContactList> contacts= new MutableLiveData<>();

        repository.getContactList(2).enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {

                contacts.setValue(response.body());

            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {

                contacts.setValue(null);

            }
        });

        return contacts;
    }

}
