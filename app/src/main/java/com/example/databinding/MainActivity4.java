package com.example.databinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.databinding.databinding.ActivityMain4Binding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity4 extends AppCompatActivity {

    private ContactAppDatabase contactAppDatabase;
    private ArrayList<Contact> contactArrayList;
    private ContactDataAdapter contactDataAdapter;

    // Binding
    private ActivityMain4Binding activityMain4Binding;
    private MainActivity4ClickHandler handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Data Binding
        activityMain4Binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);

        handlers = new MainActivity4ClickHandler(this);
        activityMain4Binding.setClickHandler(handlers);

        // Recycler View
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Adapter
        contactDataAdapter = new ContactDataAdapter();
        recyclerView.setAdapter(contactDataAdapter);

        // Database
        contactAppDatabase = Room.databaseBuilder(
                getApplicationContext(),
                ContactAppDatabase.class,
                "ContactDB"
        ).build();

        // Add Data
        LoadData();

        // Handling Swiping
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Contact contact = contactArrayList.get(viewHolder.getAdapterPosition());
                DeleteContact(contact);

            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("NAME");
            String email = data.getStringExtra("EMAIL");

            Contact contact = new Contact(name, email);

            AddNewContact(contact);

        }

    }

    private void DeleteContact(Contact contact) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // onBackground
                contactAppDatabase.getContactDao().delete(contact);


                // on post execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        LoadData();
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

    private void LoadData() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // onBackground
                contactArrayList = (ArrayList<Contact>) contactAppDatabase.getContactDao().getAllContacts();


                // on post execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        contactDataAdapter.setContacts(contactArrayList);
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

    private void AddNewContact(Contact contact) {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // onBackground
                contactAppDatabase.getContactDao().insert(contact);


                // on post execution
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        LoadData();
                        contactDataAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

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