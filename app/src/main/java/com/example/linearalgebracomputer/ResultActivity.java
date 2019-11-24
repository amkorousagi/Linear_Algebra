package com.example.linearalgebracomputer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends Activity {


    int idNumbers[][]={{R.id.a_1, R.id.a_2, R.id.a_3, R.id.a_4, R.id.a_5, R.id.a_6},
            {R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6},
            {R.id.c_1, R.id.c_2, R.id.c_3, R.id.c_4, R.id.c_5, R.id.c_6},
            {R.id.d_1, R.id.d_2, R.id.d_3, R.id.d_4, R.id.d_5, R.id.d_6},
            {R.id.e_1, R.id.e_2, R.id.e_3, R.id.e_4, R.id.e_5, R.id.e_6},
            {R.id.f_1, R.id.f_2, R.id.f_3, R.id.f_4, R.id.f_5, R.id.f_6}};

    int[][] matrix_1;
    int[][] matrix_2;
    int[][] matrix_result;
    String algorithm, operation;
    int row, col,colb;
    ArrayList<Integer> matrix = new ArrayList<Integer>();
    ArrayList<Integer> matrix2 = new ArrayList<Integer>();




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        row = intent.getIntExtra("row", row);
        col = intent.getIntExtra("col", col);
        colb = intent.getIntExtra("colb", colb);
        matrix = intent.getIntegerArrayListExtra("matrixa");
        matrix2 = intent.getIntegerArrayListExtra("matrixb");
        algorithm = intent.getStringExtra("algorithm");
        operation = intent.getStringExtra("operation");

        if(algorithm.equals("standard")) {
            matrix_1 = new int[row][col];
            matrix_2 = new int[col][colb];
            matrix_result = new int[row][colb];
            int s = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_1[i][j] = matrix.get(s++);
                }
            }
            s = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < colb; j++) {
                    matrix_2[i][j] = matrix2.get(s++);
                }
            }

            //matrix_2 : 두번째 행렬
            //matrix_1 : 첫번째 행렬

            //계산과정
            int sum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colb; j++) {
                    sum = 0;
                    for (s = 0; s < col; s++) {
                        sum += matrix_1[i][s] * matrix_2[s][j];
                    }
                    matrix_result[i][j] = sum;
                }
            }




        for (int i = 0; i < row; i++) {
            for(int j = 0; j< colb; j++) {
                TextView input = (TextView) findViewById(idNumbers[i][j]);
                input.setText(""+ matrix_result[i][j]);
            }
        }
        }//곱하기 계산


        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


