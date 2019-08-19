package com.bala.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bala.myapplication.R;
import com.bala.myapplication.databinding.ContactDetailFragmentBinding;
import com.bala.myapplication.model.daos.Contact;
import com.bala.myapplication.model.viewmodels.ContactModel;

public class ContactDetail extends Fragment {

    private static final String TAG = "ContactDetail";
    ContactDetailFragmentBinding contactDetailFragmentBinding;
    ContactModel contactModel;
    int contactID;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        contactID = getArguments().getInt("ID");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int id = getArguments().getInt("ID");
        contactDetailFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.contact_detail_fragment,container,false);
        contactModel = ViewModelProviders.of(this).get(ContactModel.class);
        contactModel.getC(id);
        contactModel.getContact().observe(this,contact ->
        {
            Toast.makeText(getActivity(),String.valueOf(id),Toast.LENGTH_LONG).show();

            contactDetailFragmentBinding.setContact(contact.getContact());
            contactDetailFragmentBinding.executePendingBindings();
        });

        return contactDetailFragmentBinding.getRoot();
    }
}
