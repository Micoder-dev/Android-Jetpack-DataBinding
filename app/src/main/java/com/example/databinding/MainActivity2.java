package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PersonModel2 personModel2 = new PersonModel2("Micoder");

        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        activityMain2Binding.setPerson2(personModel2);

    }
}