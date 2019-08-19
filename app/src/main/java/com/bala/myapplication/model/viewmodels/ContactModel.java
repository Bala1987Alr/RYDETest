package com.bala.myapplication.model.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.bala.myapplication.model.daos.Contact;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.daos.SingleContact;
import com.bala.myapplication.service.ContactService;

public class ContactModel extends AndroidViewModel {

    MutableLiveData<SingleContact> contact;

    public ContactModel(@NonNull Application application) {
        super(application);

    }

    public void getC(int id)
    {
        contact = ContactService.getInstance().getContact(id);
    }

    public MutableLiveData<SingleContact> getContact()
    {
        return contact;
    }
}
