package com.example.linearalgebracomputer;

public class InverseMatrixSuite {
	
	public void GetInverse(float[][] A, float[][] R)
	{		
		if(A.length != A[0].length) {
			System.out.println("Inverse not possible");
			return;
		}			
		
		float[][] L = new float[A.length][A.length];
		float[][] U = new float[A.length][A.length];
		
		new LUFactorizationSuite().GetLU(A, L, U);
		
		if(L[0][0] == 0) {
			System.out.println("Inverse not possible");
			return;
		}	
			
		float[][] revL = new float[A.length][A.length];
		float[][] revU = new float[A.length][A.length];
		float temp;
		int row, col, i;
		
		for(row = 0; row < A.length; row++)
			for(col = 0; col < A.length; col++)
			{
				if(row == col) {
					revL[row][col] = 1;
					revU[row][col] = 1;
				}
				else {
					revL[row][col] = 0;
					revU[row][col] = 0;
				}
			}
		
		for(row = col = 0; row < A.length; row++, col++)
		{
			for(i = row + 1; i < A.length; i++)
			{
				temp = -1 * L[i][col];
				RowOperation.MultipleAndAddition(L, row, i, temp);
				RowOperation.MultipleAndAddition(revL, row, i, temp);
			}
		}
		for(row = col = A.length - 1; row >= 0; row--, col--)
		{
			for(i = row - 1; i >= 0; i--)
			{
				temp = -1 * U[i][col] / U[row][col];
				RowOperation.MultipleAndAddition(U, row, i, temp);
				RowOperation.MultipleAndAddition(revU, row, i, temp);
			}
			RowOperation.MultipleRow(revU, row, 1 / U[row][col]);
			RowOperation.MultipleRow(U, row, 1 / U[row][col]);
		}
		
		new MultiplyMatrixSuite().MultiplyMatrix(revU, revL, R);
	}
}
