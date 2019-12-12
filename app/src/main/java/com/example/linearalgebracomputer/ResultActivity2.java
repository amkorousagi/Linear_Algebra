package com.example.linearalgebracomputer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity2 extends Activity {


    int idNumbers[][]={{R.id.a_1, R.id.a_2, R.id.a_3, R.id.a_4, R.id.a_5, R.id.a_6},
            {R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6},
            {R.id.c_1, R.id.c_2, R.id.c_3, R.id.c_4, R.id.c_5, R.id.c_6},
            {R.id.d_1, R.id.d_2, R.id.d_3, R.id.d_4, R.id.d_5, R.id.d_6},
            {R.id.e_1, R.id.e_2, R.id.e_3, R.id.e_4, R.id.e_5, R.id.e_6},
            {R.id.f_1, R.id.f_2, R.id.f_3, R.id.f_4, R.id.f_5, R.id.f_6}};
    int idNumbers2[][]={{R.id.a_11, R.id.a_22, R.id.a_33, R.id.a_44, R.id.a_55, R.id.a_66},
            {R.id.b_11, R.id.b_22, R.id.b_33, R.id.b_44, R.id.b_55, R.id.b_66},
            {R.id.c_11, R.id.c_22, R.id.c_33, R.id.c_44, R.id.c_55, R.id.c_66},
            {R.id.d_11, R.id.d_22, R.id.d_33, R.id.d_44, R.id.d_55, R.id.d_66},
            {R.id.e_11, R.id.e_22, R.id.e_33, R.id.e_44, R.id.e_55, R.id.e_66},
            {R.id.f_11, R.id.f_22, R.id.f_33, R.id.f_44, R.id.f_55, R.id.f_66}};

    float[][] matrix_1;
    float[][] matrix_2;
    float[][] matrix_result;
    String algorithm, operation;
    int row, col,colb;
    float[] matrix;
    float[] matrix2;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);



        Intent intent = getIntent();
        row = intent.getIntExtra("row", row);
        col = intent.getIntExtra("col", col);
        colb = intent.getIntExtra("colb", colb);
        matrix = intent.getFloatArrayExtra("matrixa");
        matrix2 = intent.getFloatArrayExtra("matrixb");
        algorithm = intent.getStringExtra("algorithm");
        operation = intent.getStringExtra("operation");

        matrix_1 = new float[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_1[i][j] = matrix[i*col+j];
                }
            }


        float[][] L = new float[matrix_1.length][matrix_1[0].length];
        float[][] U = new float[matrix_1.length][matrix_1[0].length];

        LUFactorizationSuite luf = new LUFactorizationSuite();
        luf.GetLU(matrix_1, L, U);


        for (int i = 0; i < L.length; i++) {
            for(int j = 0; j< L[0].length; j++) {
                TextView input = (TextView) findViewById(idNumbers[i][j]);
                input.setText(""+ L[i][j]);
            }
        }
        for (int i = 0; i < U.length; i++) {
            for(int j = 0; j< U[0].length; j++) {
                TextView input = (TextView) findViewById(idNumbers2[i][j]);
                input.setText(""+ U[i][j]);
            }
        }


        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


