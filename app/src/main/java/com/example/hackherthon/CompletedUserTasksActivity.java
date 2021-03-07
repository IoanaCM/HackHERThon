package com.example.hackherthon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CompletedUserTasksActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_completed_tasks);

        ImageButton settingsButton = (ImageButton) findViewById(R.id.isolating_settings);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(CompletedUserTasksActivity.this, IsolatingSettingsActivity.class);
                startActivity(intent);
            }
        });

        navView = (BottomNavigationView) findViewById(R.id.isolating_bottom_navigation);
        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.isolating_newtask:
                                Intent searchIntent = new Intent(CompletedUserTasksActivity.this, AddNewTask.class);
                                startActivity(searchIntent);
                                break;

                            case R.id.isolating_pendingtasks:
                                Intent pendingIntent = new Intent(CompletedUserTasksActivity.this, IsolatingMainActivity.class);
                                startActivity(pendingIntent);
                                break;

                            case R.id.isolating_completedtasks:
                                break;
                        }
                        return false;
                    }
                });
    }

}
