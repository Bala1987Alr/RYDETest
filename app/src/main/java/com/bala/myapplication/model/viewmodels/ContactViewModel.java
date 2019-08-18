package com.bala.myapplication.model.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.service.ContactService;

public class ContactViewModel extends AndroidViewModel {

     MutableLiveData<ContactList> contacts;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        contacts = ContactService.getInstance().getContacts(2);
    }

    public MutableLiveData<ContactList> getContacts()
    {
        return contacts;
    }
}
