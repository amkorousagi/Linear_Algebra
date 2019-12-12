package com.example.linearalgebracomputer;

public class LUFactorizationSuite {
	
	public void GetLU(float[][] A, float[][] L, float[][] U)
	{	
		if(A.length > A[0].length) {
			System.out.println("LU factorization not possible");
			return;
		}
		
		int row, col, lcol, i;
		
		for(row = 0; row < A.length; row++)
			for(col = 0; col < A.length; col++)
			{
				if(row == col)
					L[row][col] = 1;
				else
					L[row][col] = 0;
			}
		
		for(row = 0; row < A.length; row++)		
			for(col = 0; col < A[0].length; col++)
				U[row][col] = A[row][col];
		
		for(row = col = lcol = 0; row < U.length && col < U[0].length; row++, col++)
		{			
			for(i = row + 1; i < U.length && U[row][col] == 0; i++)	//����� ���� col��° ���� 0�� ��, 0�� �ƴ� ��� ��ü		
				RowOperation.Interchange(U, row, i);		
			
			if(i == U.length && i != row + 1) {	//��� ���� col��° ���� 0�� ��, col++
				row--;
				continue;
			}			
			
			for(i = row; i < U.length; i++)
				L[i][lcol] = U[i][col] / U[row][col];			
			lcol++;
			
			for(i = row + 1; i < U.length; i++)			
				RowOperation.MultipleAndAddition(U, row, i, -1 * U[i][col] / U[row][col]);			
		}
		
		if(row != U.length) {
			System.out.println("LU factorization not possible");
			return;
		}
	}
}
