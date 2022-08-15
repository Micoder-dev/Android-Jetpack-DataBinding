package com.example.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    int contactId;
    String name, email;

    @Ignore
    public Contact() {
    }

    public Contact(String name, String email, int contactId) {
        this.name = name;
        this.email = email;
        this.contactId = contactId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
