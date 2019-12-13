package com.example.linearalgebracomputer;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.io.FileOutputStream;


public class RowOperation extends Activity {


	static public void Interchange(float[][] R, int row1, int row2)
	{
		float[] temp = R[row1];
		R[row1] = R[row2];
		R[row2] = temp;
	}
	
	static public void MultipleRow(float[][] R, int row, float multipleNum)
	{
		for(int i = 0; i < R[row].length; i++)
			R[row][i] *= multipleNum;
	}
	
	static public void MultipleAndAddition(float[][] R, int row1, int row2, float multipleNum)
	{
		for(int i = 0; i < R[row2].length; i++)
			R[row2][i] += R[row1][i] * multipleNum;
	}
}
