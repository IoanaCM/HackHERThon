package com.example.hackherthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IsolatingTaskStatusActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    private TextView textAdd;
    private TextView textPending;
    private TextView textComplete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isolating_task_status);

        textAdd = (TextView) findViewById(R.id.text_isolatingnewtask);
        textPending = (TextView) findViewById(R.id.text_isolatingpendingtasks);
        textComplete = (TextView) findViewById(R.id.text_isolatingcompletedtasks);

        navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.isolating_newtask:
                                textAdd.setVisibility(View.VISIBLE);
                                textPending.setVisibility(View.GONE);
                                textComplete.setVisibility(View.GONE);
                                break;

                            case R.id.isolating_pendingtasks:
                                textAdd.setVisibility(View.GONE);
                                textPending.setVisibility(View.VISIBLE);
                                textComplete.setVisibility(View.GONE);
                                break;

                            case R.id.isolating_completedtasks:
                                textAdd.setVisibility(View.GONE);
                                textPending.setVisibility(View.GONE);
                                textComplete.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });
    }
}