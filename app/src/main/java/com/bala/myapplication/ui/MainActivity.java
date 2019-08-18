package com.bala.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bala.myapplication.R;
import com.bala.myapplication.databinding.ActivityMainBinding;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.viewmodels.ContactViewModel;
import com.bala.myapplication.ui.adapters.ContactAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ContactViewModel contactViewModel;
    private ActivityMainBinding activityMainBinding;
    private ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        contactViewModel.getContacts().observe(this,new_contacts ->
        {
            ContactList contacts = new_contacts;
            Log.d(TAG, "contacts: "+contacts.getTotal_pages());
            Log.d(TAG, "contacts: "+contacts.getContacts());
            Log.d(TAG, "contacts: "+contacts.getPage());
            adapter = new ContactAdapter(contacts.getContacts());
            activityMainBinding.setContactAdapter(adapter);
        });



    }
}
