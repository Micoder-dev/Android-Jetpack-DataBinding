package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public class MainActivity4ClickHandler {

        Context context;

        public MainActivity4ClickHandler(Context context) {
            this.context = context;
        }

        public void onFABClicked(View view) {
            Intent intent = new Intent(MainActivity4.this, AddNewContactActivity.class);
            startActivityForResult(intent, 1);
        }

    }

}