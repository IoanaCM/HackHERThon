package com.example.hackherthon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VolunteerMainActivity extends AppCompatActivity{

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_main);

        ImageButton settingsButton = (ImageButton) findViewById(R.id.volunteer_settings);

        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VolunteerMainActivity.this, VolunteerSettingsActivity.class);
                startActivity(intent);
            }
        });

        navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        Button view1 = (Button) findViewById(R.id.btn_act2);

        view1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog();
            }
        });

        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.volunteer_searchtask:
                                // TODO add code to move to Search window
                                break;

                            case R.id.volunteer_pendingtasks:
                                break;

                            case R.id.volunteer_completedtasks:
                                // TODO add code to move to Completed Tasks window
                                break;
                        }
                        return false;
                    }
                });
    }

    public void openDialog() {
        ViewTaskDialog dialog = new ViewTaskDialog();
        dialog.show(getSupportFragmentManager(), "taskDialog");
    }

}
