package com.example.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactDataAdapter extends RecyclerView.Adapter<ContactDataAdapter.ContactViewHolder> {

    private ArrayList<Contact> contacts;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_iitem, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact currentContact = contacts.get(position);

        holder.name.setText(currentContact.getName());
        holder.email.setText(currentContact.getEmail());

    }

    @Override
    public int getItemCount() {
        if (contacts != null) {
            return contacts.size();
        }else {
            return 0;
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView name, email;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.tvName);
            this.email = itemView.findViewById(R.id.tvEmail);
        }
    }

}
