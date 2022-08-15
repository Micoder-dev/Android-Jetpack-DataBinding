package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;
    private MainActivityClickHandlers onClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Text View
        PersonModel personModel = new PersonModel("Micoder", "micoder.com@gmail.com");
        mActivityMainBinding.setPerson(personModel);

        //Binding the handler
        onClickHandler = new MainActivityClickHandlers(this);
        mActivityMainBinding.setOnClickHandler(onClickHandler);

    }

    public class MainActivityClickHandlers{

        Context mContext;

        public MainActivityClickHandlers(Context context) {
            mContext = context;
        }

        public void onHelloBtnClick(View view) {
            Toast.makeText(mContext, "Hello btn clicked", Toast.LENGTH_SHORT).show();
        }
        
        public void onByeBtnClick(View view) {
            Toast.makeText(mContext, "Bye btn clicked", Toast.LENGTH_SHORT).show();
        }

        public void goToMainActivity2(View view) {
            Intent intent = new Intent(mContext, MainActivity2.class);
            startActivity(intent);
        }

        public void goToMainActivity3(View view) {
            Intent intent = new Intent(mContext, MainActivity3.class);
            startActivity(intent);
        }

    }

}