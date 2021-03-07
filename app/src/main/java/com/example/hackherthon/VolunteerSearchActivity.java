package com.example.hackherthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VolunteerSearchActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_search);

        ImageButton settingsButton = (ImageButton) findViewById(R.id.volunteer_settings);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VolunteerSearchActivity.this, VolunteerSettingsActivity.class);
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
                                break;

                            case R.id.volunteer_pendingtasks:
                                Intent pendingIntent = new Intent(VolunteerSearchActivity.this, VolunteerMainActivity.class);
                                startActivity(pendingIntent);
                                break;

                            case R.id.volunteer_completedtasks:
                                Intent completed = new Intent(VolunteerSearchActivity.this, CompletedVolunteerTasksActivity.class);
                                break;
                        }
                        return false;
                    }
                });
    }
}