package com.example.linearalgebracomputer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, Loading.class));

        setContentView(R.layout.activity_main);

        //implement compute button
        //if clicked, go to ComputeActivity
        Button button_compute = (Button)findViewById(R.id.compute);
        button_compute.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ComputeActivity.class);
                startActivity(intent);

            }
        });

        //implement compute button
        //if clicked, go to PastComputeActivity
        Button button_past_compute = (Button)findViewById(R.id.past_compute);
        button_past_compute.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,PastComputeActivity.class);
                startActivity(intent);
            }
        });

        Button button_quit = (Button)findViewById(R.id.quit);
        button_quit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }
}
