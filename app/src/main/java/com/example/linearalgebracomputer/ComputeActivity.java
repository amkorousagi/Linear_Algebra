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
        new writeclass().init();


        final Context c = this;
        String[] arr_kinds_operation = {"inverse matrix", "add matrix", "multiply matrix",
                "Row reduced form matrix", "Eigenvalue & vector matrix", "Determinant matrix", "Transpose matrix", "LU factorization matrix","Echlen form"};

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

                    case "multiply matrix":
                        String[] arr_algorithm_used3 = {"A X B", "A X A"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used3);
                        break;

                    case "Row reduced form matrix":
                        String[] arr_algorithm_used4 = {"Gauss-Jordan elimination"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used4);
                        break;
                    case "Echlen form":
                        String[] arr_algorithm_used9 = {"Gauss-Jordan elimination"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used9);
                        break;
                    case "Eigenvalue & vector matrix":
                        String[] arr_algorithm_used5 = {"standard"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used5);
                        break;
                    case "Determinant matrix":
                        String[] arr_algorithm_used6 = {"standard"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used6);
                        break;
                    case "Transpose matrix":
                        String[] arr_algorithm_used7 = {"standard"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used7);
                        break;
                    case "LU factorization matrix":
                        String[] arr_algorithm_used8 = {"standard"};
                        spinnerAdapter_algorithm_used = new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item,arr_algorithm_used8);
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


                //행렬끼리 더할때
                if(intent_algorithm.equals("standard") && intent_operation.equals("add matrix")){
                    Intent intent = new Intent(getApplicationContext(), InputActivity_plus.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //행렬끼리 곱할때(서로 다른 행렬이다)
                if(intent_algorithm.equals("A X B") && intent_operation.equals("multiply matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_mult.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //행렬끼리 곱할때(거듭제곱)
                if(intent_algorithm.equals("A X A") && intent_operation.equals("multiply matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single_power.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //역행렬
                if(intent_algorithm.equals("Gauss-Jordan elimination") && intent_operation.equals("inverse matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //축소된 에클론 폼 행렬 만들때
                if(intent_operation.equals("Row reduced form matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //고유값&고유벡터 행렬 값 만들때
                if(intent_operation.equals("Eigenvalue & vector matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //행렬값 만들때
                if(intent_operation.equals("Determinant matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //전치행렬 만들때
                if(intent_operation.equals("Transpose matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                //행렬값 만들때
                if(intent_operation.equals("LU factorization matrix")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
                if(intent_operation.equals("Echlen form")) {
                    Intent intent = new Intent(getApplicationContext(), InputActivity_single.class);
                    intent.putExtra("operation",intent_operation);
                    intent.putExtra("algorithm",intent_algorithm);
                    intent.putExtra("visible",intent_visible);
                    startActivity(intent);
                }
            }
        });




    }
}
