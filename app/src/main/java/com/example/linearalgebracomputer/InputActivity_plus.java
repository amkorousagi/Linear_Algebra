package com.example.linearalgebracomputer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class InputActivity_plus extends AppCompatActivity {


    int idNumbers[][]={{R.id.a_1, R.id.a_2, R.id.a_3, R.id.a_4, R.id.a_5, R.id.a_6},
            {R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6},
            {R.id.c_1, R.id.c_2, R.id.c_3, R.id.c_4, R.id.c_5, R.id.c_6},
            {R.id.d_1, R.id.d_2, R.id.d_3, R.id.d_4, R.id.d_5, R.id.d_6},
            {R.id.e_1, R.id.e_2, R.id.e_3, R.id.e_4, R.id.e_5, R.id.e_6},
            {R.id.f_1, R.id.f_2, R.id.f_3, R.id.f_4, R.id.f_5, R.id.f_6}};

    int idNumbers2[][]={{R.id.a_11, R.id.a_21, R.id.a_31, R.id.a_41, R.id.a_51, R.id.a_61},
            {R.id.b_11, R.id.b_21, R.id.b_31, R.id.b_41, R.id.b_51, R.id.b_61},
            {R.id.c_11, R.id.c_21, R.id.c_31, R.id.c_41, R.id.c_51, R.id.c_61},
            {R.id.d_11, R.id.d_21, R.id.d_31, R.id.d_41, R.id.d_51, R.id.d_61},
            {R.id.e_11, R.id.e_21, R.id.e_31, R.id.e_41, R.id.e_51, R.id.e_61},
            {R.id.f_11, R.id.f_21, R.id.f_31, R.id.f_41, R.id.f_51, R.id.f_61}};

    static int store[][] = new int[6][6];
    static int row=6, col=6, colb = 6;
    String algorithm, operation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_plus);


        Intent intent = getIntent();
        algorithm = intent.getStringExtra("algorithm");
        operation = intent.getStringExtra("operation");
        //행 스피너 인자에 따라 행렬 유동적으로 조정
        final Spinner spinner_field = (Spinner)findViewById(R.id.spinner_field);
        String[] str = getResources().getStringArray(R.array.spinnerArray);
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,str);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_field.setAdapter(adapter);
        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_field.getSelectedItemPosition() > 0) {
                    row = parseInt(spinner_field.getSelectedItem().toString());
                    Log.v("알림", spinner_field.getSelectedItem().toString() + "is selected");
                    for (int s = 0; s < idNumbers.length; s++) {
                        for(int j=0; j<idNumbers[0].length; j++) {
                            EditText input = (EditText) findViewById(idNumbers[s][j]);
                            EditText input2 = (EditText) findViewById(idNumbers2[s][j]);
                            input.setVisibility((View.INVISIBLE));
                            input2.setVisibility((View.INVISIBLE));
                        }
                    }
                    for (int s = 0; s < row; s++) {
                        for(int j=0; j<col; j++) {
                            EditText input = (EditText) findViewById(idNumbers[s][j]);
                            EditText input2 = (EditText) findViewById(idNumbers2[s][j]);
                            input.setVisibility(View.VISIBLE);
                            input2.setVisibility((View.VISIBLE));
                        }
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //열 스피너 인자에 따라 행렬 유동적으로 조정
        final Spinner spinner_field2 = (Spinner)findViewById(R.id.spinner_field2);
        String[] str2 = getResources().getStringArray(R.array.spinnerArray4);
        final ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,str2);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_field2.setAdapter(adapter2);
        spinner_field2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_field2.getSelectedItemPosition() > 0) {
                    Log.v("알림", spinner_field2.getSelectedItem().toString() + "is selected");
                    col = parseInt(spinner_field2.getSelectedItem().toString());
                    for (int s = 0; s < idNumbers.length; s++) {
                        for(int j=0; j<idNumbers[0].length; j++) {
                            EditText input = (EditText) findViewById(idNumbers[s][j]);
                            EditText input2 = (EditText) findViewById(idNumbers2[s][j]);
                            input.setVisibility((View.INVISIBLE));
                            input2.setVisibility((View.INVISIBLE));
                        }
                    }

                    for (int s = 0; s < row ; s++) {
                        for(int j=0; j < col; j++) {
                            EditText input = (EditText) findViewById(idNumbers[s][j]);
                            EditText input2 = (EditText) findViewById(idNumbers2[s][j]);
                            input.setVisibility(View.VISIBLE);
                            input2.setVisibility((View.VISIBLE));}}
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });





        //matrix A,B글자 출력 크기 조정
        TextView m1,m2,m3;
        m1 = (TextView)findViewById(R.id.m1);
        m1.setTextSize(20);
        m2 = (TextView)findViewById(R.id.m2);
        m2.setTextSize(20);
        m3 = (TextView)findViewById(R.id.m3);
        m3.setTextSize(40);


        //result 버튼에 대한 행동(2019.11.17수정 및 보완)
        Button result = (Button)findViewById(R.id.cal);
        result.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                ArrayList<Integer> matrix = new ArrayList<Integer>();
                ArrayList<Integer> matrix2 = new ArrayList<Integer>();

                for (int i = 0; i < row; i++) {
                    for(int j=0; j<col; j++) {
                        EditText input = (EditText) findViewById(idNumbers[i][j]);
                        matrix.add(parseInt(input.getText().toString()));
                    }
                }for (int i = 0; i < col; i++) {
                    for(int j=0; j<colb; j++) {
                        EditText input = (EditText) findViewById(idNumbers2[i][j]);
                        matrix2.add(parseInt(input.getText().toString()));
                    }
                }
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putIntegerArrayListExtra("matrixa", matrix);
                intent.putIntegerArrayListExtra("matrixb", matrix2);
                intent.putExtra("row", row);
                intent.putExtra("col", col);
                intent.putExtra("colb",colb);
                intent.putExtra("operation",operation);
                intent.putExtra("algorithm",algorithm);
                startActivity(intent);
            }
        });





        Button reset = (Button)findViewById(R.id.reset); //reset 버튼에 대한 행동
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "초기화합니다.", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < idNumbers.length; i++) {
                    for(int j=0; j<idNumbers[0].length; j++) {
                        EditText input = (EditText) findViewById(idNumbers[i][j]);
                        input.setText("0");
                    }
                }
            }
        });
        Button reset2 = (Button)findViewById(R.id.reset2); //reset2 버튼에 대한 행동
        reset2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "초기화합니다.", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < idNumbers2.length; i++) {
                    for(int j=0; j<idNumbers2[0].length; j++) {
                        EditText input = (EditText) findViewById(idNumbers2[i][j]);
                        input.setText("0");
                    }
                }
            }
        });
    }
}
