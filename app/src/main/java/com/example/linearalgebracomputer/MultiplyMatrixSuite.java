package com.example.linearalgebracomputer;

public class MultiplyMatrixSuite {
	
	public void MultiplyMatrix(float[][] A, float[][] B, float[][] R)
	{
		if(A[0].length != B.length) {
			System.out.println("Multiply not possible");
			return;
		}
		
		for(int row = 0; row < R.length; row++)
			for(int col = 0; col < R[0].length; col++)
				R[row][col] = 0;
		
		int pas = A[0].length;
		for(int row = 0; row < R.length; row++)		
			for(int col = 0; col < R[0].length; col++)			
				for(int i = 0; i < pas; i++)				
					R[row][col] += A[row][i] * B[i][col];
	}
}
