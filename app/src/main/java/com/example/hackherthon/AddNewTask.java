package com.example.hackherthon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddNewTask extends AppCompatActivity implements OnItemSelectedListener {

    private FirebaseAuth mAuth;
    private DatabaseReference mTasksDatabase;
    private String userID;

    private CheckBox
    private EditText mStreet, mCity, mPostcode, mComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_task);

        Button nextTaskSubmit = (Button) findViewById(R.id.submitTaskButton);

        //add the onClick listener
        nextTaskSubmit.setOnClickListener(new View.OnClickListener() {
            // TODO: Link submit button to UserTaskAccepted
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                userID = mAuth.getCurrentUser().getUid();
                mTasksDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Tasks");
                Intent acceptedTaskIntent = new Intent(AddNewTask.this, UserTaskAccepted.class);

                startActivity(acceptedTaskIntent);
            }
        });

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_hours, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Spinner click listener
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.isolating_newtask:
                                break;

                            case R.id.isolating_pendingtasks:
                                Intent intent = new Intent(AddNewTask.this, IsolatingMainActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.isolating_completedtasks:
                                // TODO add code to move to Completed Tasks window
                                break;
                        }
                        return false;
                    }
                });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        if (item.equals("Now")) {
            Toast.makeText(parent.getContext(), "Arriving soon", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
