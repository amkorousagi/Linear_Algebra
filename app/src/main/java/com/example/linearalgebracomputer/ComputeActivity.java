package com.example.linearalgebracomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.*;




public class ComputeActivity extends AppCompatActivity {


    String intent_operation;
    String intent_algorithm;
    boolean intent_visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);



        final Context c = this;
        String[] arr_kinds_operation = {"inverse matrix", "add matrix"};

        ArrayAdapter spinnerAdapter_kinds_operation;
        spinnerAdapter_kinds_operation = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_kinds_operation);

        final Spinner spinner_kinds_operation = (Spinner)findViewById(R.id.spinner_kinds_compute);
        spinner_kinds_operation.setAdapter(spinnerAdapter_kinds_operation);
        spinner_kinds_operation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id){
                intent_operation ="" + spinner_kinds_operation.getItemAtPosition(position);

                SpinnerAdapter spinnerAdapter_algorithm_used = null;
                switch(intent_operation){
                    case "inverse matrix":
                        String[] arr_algorithm_used = {"Gauss-Jordan elimination", "strassen algorithm", "Coppersmith-Winograd algorithm", "optomized CW-like algorithms"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used);

                        break;
                    case "add matrix":
                        String[] arr_algorithm_used2 = {"standard"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used2);
                        break;

                    default:
                        Toast.makeText(c,"Error: it is value not expected",Toast.LENGTH_SHORT).show();
                }

                final Spinner spinner_algorithm_used = (Spinner)findViewById(R.id.spinner_algorism);
                spinner_algorithm_used.setAdapter(spinnerAdapter_algorithm_used);
                spinner_algorithm_used.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView <?> parent, View view, int position, long id){
                        intent_algorithm = "" + spinner_algorithm_used.getItemAtPosition(position);
                    }
                    @Override
                    public void onNothingSelected(AdapterView <?> parent){}
                });

            }

           @Override
            public void onNothingSelected(AdapterView <?> parent){}

        });

        final CheckBox checkBox = (CheckBox)findViewById(R.id.is_step_visible);
        checkBox.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(checkBox.isChecked() == false){
                    checkBox.setChecked(true);
                    intent_visible = true;
                }
                else{
                    checkBox.setChecked(false);
                    intent_visible = false;
                }
            }
        });

        Button button_next = (Button)findViewById(R.id.button_next);
        button_next.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent intent = new Intent(getApplicationContext(), InputActivity_mult.class);
                //Intent intent = new Intent(getApplicationContext(), InputActivity_plus.class);
                Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                intent.putExtra("operation",intent_operation);
                intent.putExtra("algorithm",intent_algorithm);
                intent.putExtra("visible",intent_visible);

                startActivity(intent);
            }
        });




    }
}
