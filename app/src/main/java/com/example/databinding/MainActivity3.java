package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding activityMain3Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        PersonModel3 personModel3 = new PersonModel3("MINETHUNTER");

        activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);

        activityMain3Binding.setPerson3(personModel3);

    }
}