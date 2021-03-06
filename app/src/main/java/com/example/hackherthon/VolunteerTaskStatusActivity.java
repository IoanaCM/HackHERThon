package com.example.hackherthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VolunteerTaskStatusActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    private TextView textSearch;
    private TextView textPending;
    private TextView textComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_task_status);

        textSearch = (TextView) findViewById(R.id.text_volunteersearchtask);
        textPending = (TextView) findViewById(R.id.text_volunteerpendingtasks);
        textComplete = (TextView) findViewById(R.id.text_volunteercompletedtasks);

        navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.volunteer_searchtask:
                                textSearch.setVisibility(View.VISIBLE);
                                textPending.setVisibility(View.GONE);
                                textComplete.setVisibility(View.GONE);
                                break;

                            case R.id.volunteer_pendingtasks:
                                textSearch.setVisibility(View.GONE);
                                textPending.setVisibility(View.VISIBLE);
                                textComplete.setVisibility(View.GONE);
                                break;

                            case R.id.volunteer_completedtasks:
                                textSearch.setVisibility(View.GONE);
                                textPending.setVisibility(View.GONE);
                                textComplete.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });
    }
}