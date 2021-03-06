package com.example.hackherthon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button isolating = (Button) findViewById(R.id.isolatingButton);

        //add the onClick listener
        isolating.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent isolatingIntent = new Intent(MainActivity.this, IsolatingMainActivity.class);

                startActivity(isolatingIntent);
            }
        });
    }


}