package com.example.hackherthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IsolatingMainActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_status);

        ImageButton settingsButton = (ImageButton) findViewById(R.id.isolating_settings);

        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // TODO add intent to move to Isolating User Settings
            }
        });

        navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.isolating_newtask:
                                Intent intent = new Intent(IsolatingMainActivity.this, AddNewTask.class);
                                startActivity(intent);
                                break;

                            case R.id.isolating_pendingtasks:
                                break;

                            case R.id.isolating_completedtasks:
                                // TODO add code to move to Completed Tasks window
                                break;
                        }
                        return false;
                    }
                });

        //IMPLEMENT ONCE ATHENA ADDS THE NAVIGATION BAR AND WE HAVE THE ADD TASK PAGE WORKING

    /*    Button nextTask = (Button) findViewById(R.id.addNextTask);

        //add the onClick listener
        nextTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNewTaskIntent = new Intent(IsolatingMainActivity.this, AddNewTask.class);
                startActivity(addNewTaskIntent);
            }
        });*/


    }
}