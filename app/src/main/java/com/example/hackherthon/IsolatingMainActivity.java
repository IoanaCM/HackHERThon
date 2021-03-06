package com.example.hackherthon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class IsolatingMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_status);

        //IMPLEMENT ONCE ATHENA ADDS THE NAVIGATION BAR AND WE HAVE THE ADD TASK PAGE WORKING

    /*    Button nextTask = (Button) findViewById(R.id.addNextTask);

        //add the onClick listener
        nextTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acceptedTaskIntent = new Intent(IsolatingMainActivity.this, UserTaskAccepted.class);

                startActivity(acceptedTaskIntent);
            }
        });*/


    }
}