package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddNewContactActivity extends AppCompatActivity {

    private ContactAppDatabase contactAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
    }
}