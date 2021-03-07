package com.example.hackherthon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VolunteerCompletedTasksActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_tasks);

        ImageButton settingsButton = (ImageButton) findViewById(R.id.volunteer_settings);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VolunteerCompletedTasksActivity.this, VolunteerSettingsActivity.class);
                startActivity(intent);
            }
        });

        navView = (BottomNavigationView) findViewById(R.id.volunteer_bottom_navigation);
        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.volunteer_searchtask:
                                Intent searchIntent = new Intent(VolunteerCompletedTasksActivity.this, VolunteerSearchActivity.class);
                                startActivity(searchIntent);
                                break;

                            case R.id.volunteer_pendingtasks:
                                Intent pendingIntent = new Intent(VolunteerCompletedTasksActivity.this, VolunteerMainActivity.class);
                                startActivity(pendingIntent);
                                break;

                            case R.id.volunteer_completedtasks:
                                break;
                        }
                        return false;
                    }
                });
    }

}
