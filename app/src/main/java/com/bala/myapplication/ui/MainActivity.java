package com.bala.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bala.myapplication.R;
import com.bala.myapplication.databinding.ActivityMainBinding;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.viewmodels.ContactViewModel;
import com.bala.myapplication.ui.adapters.ContactAdapter;

public class MainActivity extends AppCompatActivity {


    private ContactListFragment contactListFragment;
    private FragmentTransaction fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            contactListFragment = new ContactListFragment();
            fragmentManager = getSupportFragmentManager().beginTransaction();
            fragmentManager.add(R.id.content_layout,contactListFragment);
            fragmentManager.commit();
        }


    }
}
