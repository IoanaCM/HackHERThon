package com.example.hackherthon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserTaskAccepted extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_request_accepted);

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.isolating_newtask:
                                Intent intent1 = new Intent(UserTaskAccepted.this, AddNewTask.class);
                                startActivity(intent1);
                                break;

                            case R.id.isolating_pendingtasks:
                                Intent intent2 = new Intent(UserTaskAccepted.this, IsolatingMainActivity.class);
                                startActivity(intent2);
                                break;

                            case R.id.isolating_completedtasks:
                                // TODO add code to move to Completed Tasks window
                                break;
                        }
                        return false;
                    }
                });


    }
}
