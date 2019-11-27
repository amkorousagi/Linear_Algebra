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

    float[][] matrix_1;
    float[][] matrix_2;
    float[][] matrix_result;
    String algorithm, operation;
    int row, col,colb;
    float[] matrix;
    float[] matrix2;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        Intent intent = getIntent();
        row = intent.getIntExtra("row", row);
        col = intent.getIntExtra("col", col);
        colb = intent.getIntExtra("colb", colb);
        matrix = intent.getFloatArrayExtra("matrixa");
        matrix2 = intent.getFloatArrayExtra("matrixb");
        algorithm = intent.getStringExtra("algorithm");
        operation = intent.getStringExtra("operation");

        if(algorithm.equals("standard") && operation.equals("add matrix")) {
            matrix_1 = new float[row][col];
            matrix_2 = new float[row][col];
            matrix_result = new float[row][col];
            int s = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_1[i][j] = matrix[i*col+j];
                }
            }
            s = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_2[i][j] = matrix2[i*col+j];
                }
            }

            //matrix_2 : 두번째 행렬
            //matrix_1 : 첫번째 행렬
            for(int i=0; i<row; i++)
            {
                for(int j=0; j<col; j++) {
                    TextView proceed = (TextView)findViewById(R.id.proceed);
                    matrix_result[i][j] = matrix_1[i][j] + matrix_2[i][j];
                    proceed.append("matrix["+(i+1)+"]["+(j+1)+"]= "+matrix_1[i][j]+ " + " + matrix_2[i][j] + " = "+ matrix_result[i][j] + "\n");

                }
            }
        }//더하기 계산
        if(algorithm.equals("A X B") && operation.equals("multiply matrix")) {
            matrix_1 = new float[row][col];
            matrix_2 = new float[col][colb];
            matrix_result = new float[row][colb];
            int s = 0;
            float sum;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix_1[i][j] = matrix[i*col+j];
                }
            }
            s = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < colb; j++) {
                    matrix_2[i][j] = matrix2[i*colb+j];
                }
            }
            //proceed.append("matrix["+(i+1)+"]["+(j+1)+"]= "+matrix_1[i][j]+ " + " + matrix_2[i][j] + " = "+ matrix_result[i][j] + "\n");

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colb; j++) {
                    TextView proceed = (TextView)findViewById(R.id.proceed);
                    sum = 0;
                    proceed.append("matrix["+(i+1)+"]["+(j+1)+"]= ");
                    for (s = 0; s < col; s++) {
                        if( s != 0) {
                            proceed.append(" + ");
                        }
                        sum += matrix_1[i][s] * matrix_2[s][j];
                        proceed.append("" +matrix_1[i][s]+ "*" + matrix_2[s][j] );
                    }
                    proceed.append("= "+sum+"\n");
                    matrix_result[i][j] = sum;


                }
            }
            col = colb;
        }//곱하기 계산
        if(algorithm.equals("A X A") && operation.equals("multiply matrix")){
            matrix_1 = new float[row][row];
            matrix_2 = new float[row][row];
            matrix_result = new float[row][row];
            col = row;

            int s = 0;
            float sum=0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    matrix_1[i][j] = matrix[i*row+j];
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    matrix_2[i][j] = matrix[i*row+j];
                }
            }


            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    sum = 0;
                    for (s = 0; s < row; s++) {
                        sum += matrix_1[i][s] * matrix_2[s][j];
                    }
                    matrix_result[i][j] = sum;
                }
            }
            for(int z = 0; z < colb-2; z++) {


                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < row; j++) {
                        matrix_1[i][j] = matrix_result[i][j];
                    }
                }
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < row; j++) {
                        sum = 0;
                        for (s = 0; s < row; s++) {
                            sum += matrix_1[i][s] * matrix_2[s][j];
                        }
                        matrix_result[i][j] = sum;
                    }
                }

            }
        }



        for (int i = 0; i < row; i++) {
            for(int j = 0; j< col; j++) {
                TextView input = (TextView) findViewById(idNumbers[i][j]);
                input.setText(""+ matrix_result[i][j]);
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


