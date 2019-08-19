package com.bala.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bala.myapplication.BR;
import com.bala.myapplication.R;
import com.bala.myapplication.databinding.ContactListFragmentBinding;
import com.bala.myapplication.ui.callback.ContactClickCallback;
import com.bala.myapplication.model.daos.Contact;
import com.bala.myapplication.model.daos.ContactList;
import com.bala.myapplication.model.viewmodels.ContactViewModel;
import com.bala.myapplication.ui.adapters.ContactAdapter;

public class ContactListFragment extends Fragment  {
    private static final String TAG = "ContactListFragment";
    ContactViewModel contactViewModel;
    ContactAdapter contactAdapter;
    ContactListFragmentBinding contactListFragmentBinding;
    FragmentTransaction fragmentManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        contactListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.contact_list_fragment,container,false);

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);

        contactViewModel.getContacts().observe(this,new_contacts ->
        {
            ContactList contacts = new_contacts;
//            Log.d(TAG, "contacts: "+contacts.getTotal_pages());
//            Log.d(TAG, "contacts: "+contacts.getContacts());
//            Log.d(TAG, "contacts: "+contacts.getPage());
            contactAdapter = new ContactAdapter(contacts.getContacts(),contactClickCallback);
            contactListFragmentBinding.setContactAdapter(contactAdapter);
            contactListFragmentBinding.setVariable(BR.click_listener,bookClickListener);

        });



        return contactListFragmentBinding.getRoot();
    }


    private View.OnClickListener bookClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentManager.replace(R.id.content_layout,new AddContact());
            fragmentManager.addToBackStack(null);
            fragmentManager.commit();

        }
    };


    private final ContactClickCallback contactClickCallback = new ContactClickCallback() {
        @Override
        public void onContactClicked(Contact contact) {

            Toast.makeText(getActivity(),contact.getFirst_name(),Toast.LENGTH_LONG).show();;
            fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
            Bundle args = new Bundle();

            ContactDetail contactDetail = new ContactDetail();
            args.putInt("ID", contact.getId());
            contactDetail.setArguments(args);
            fragmentManager.replace(R.id.content_layout,contactDetail);
            fragmentManager.addToBackStack(null);
            fragmentManager.commit();

        }
    };

}
