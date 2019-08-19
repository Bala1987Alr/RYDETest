package com.bala.myapplication.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bala.myapplication.BR;
import com.bala.myapplication.R;
import com.bala.myapplication.ui.callback.ContactClickCallback;
import com.bala.myapplication.model.daos.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contacts;
    private ContactClickCallback contactClickCallback;


    public ContactAdapter(List<Contact> contacts,ContactClickCallback contactClickCallback)
    {
        this.contacts = contacts;
        this.contactClickCallback = contactClickCallback;

    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,R.layout.item_contact,viewGroup,false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {

        Contact contact = contacts.get(i);
        contactViewHolder.bind(contact);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder
    {
        ViewDataBinding binding;
        public ContactViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Contact contact)
        {
            this.binding.setVariable(BR.contact,contact);
            binding.setVariable(BR.callback,contactClickCallback);
            this.binding.executePendingBindings();
        }
    }
}
