package com.bala.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bala.myapplication.R;
import com.bala.myapplication.databinding.ContactListFragmentBinding;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.viewmodels.ContactViewModel;
import com.bala.myapplication.ui.adapters.ContactAdapter;

public class ContactListFragment extends Fragment {
    private static final String TAG = "ContactListFragment";
    ContactViewModel contactViewModel;
    ContactAdapter contactAdapter;
    ContactListFragmentBinding contactListFragmentBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        contactListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.contact_list_fragment,container,false);

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);

        contactViewModel.getContacts().observe(this,new_contacts ->
        {
            ContactList contacts = new_contacts;
            Log.d(TAG, "contacts: "+contacts.getTotal_pages());
            Log.d(TAG, "contacts: "+contacts.getContacts());
            Log.d(TAG, "contacts: "+contacts.getPage());
            contactAdapter = new ContactAdapter(contacts.getContacts());
            contactListFragmentBinding.setContactAdapter(contactAdapter);
        });


        return contactListFragmentBinding.getRoot();
    }
}
