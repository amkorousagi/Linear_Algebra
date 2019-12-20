package com.example.linearalgebracomputer;

import java.util.Arrays;

public class EigenSuite {

	boolean canComputeEigenvector;

	public void Eigenvalue(float[][] A, float[] eigenvalue, float[] complexEigenvalue)
	{
		if(A.length != A[0].length || A.length != 2) {
			System.out.println("Can not compute eigenvalue");
			canComputeEigenvector = false;
			return;
		}
		
		float b = -1 * (A[0][0] + A[1][1]);
		float c = A[0][0] * A[1][1] - A[0][1] * A[1][0];
		
		float d = b * b - 4 * c;
		if(d < 0) {
			complexEigenvalue[0] = -1 * d;
			complexEigenvalue[1] = d;
		}
		else
			complexEigenvalue[0] = complexEigenvalue[1] = 0;
		
		eigenvalue[0] = (-1 * b + (float)Math.sqrt(d)) / 2;
		eigenvalue[1] = (-1 * b - (float)Math.sqrt(d)) / 2;
	}
	
	public void Eigenvector(float[][] A, float[] eigenvalue, float[] complexEigenvalue, float[][] eigenvector)
	{
		if(A.length != A[0].length || A.length != 2) {
			System.out.println("Can not compute eigenvector");
			return;
		}
	
		canComputeEigenvector = true;			
		Eigenvalue(A, eigenvalue, complexEigenvalue);
		
		if(canComputeEigenvector  == false) {
			System.out.println("Can not compute eigenvector");
			return;
		}
		
		int row, col;
		
		for(row = 0; row < eigenvector.length; row++)
			for(col = 0; col < eigenvector[0].length; col++)
				eigenvector[row][col] = 0;
		
		Arrays.sort(eigenvalue);
		
		boolean isZeroVector = true;
		int eigenvectorIndex = 0;
		float prevval = 0;
		float[][] temp = new float[A.length][A.length];	float caltemp;
		ReducedEchelonFormSuite ref = new ReducedEchelonFormSuite();
		
		for(int i = 0; i < eigenvalue.length; i++)
		{
			if(eigenvalue[i] == prevval)
				continue;
			prevval = eigenvalue[i];
				
			for(row = 0; row < eigenvector.length; row++)
				for(col = 0; col < eigenvector[0].length; col++)
					temp[row][col] = 0;
			
			for(int j = 0; j < A.length; j++)
				A[j][j] -= eigenvalue[i];
			
			ref.EchelonForm(A, temp);

			for(row = 0; row < temp.length; row++)
			{
				if(temp[row][row] == 0)
				{
					for(col = 0; col < temp.length; col++)
						temp[row][col] = 0;
					temp[row][row] = 1;
				}
				else
				{
					caltemp = -1 * temp[row][row];
					for(col = 0; col < temp.length; col++)
						temp[row][col] /= caltemp;
					temp[row][row] = 0;
				}
			}

			for(col = 0; col < temp.length; col++)
			{
				for(row = 0; row < eigenvector.length; row++)
				{
					if(temp[row][col] != 0)
						isZeroVector = false;
					eigenvector[row][eigenvectorIndex] = temp[row][col];
				}
				
				if(isZeroVector == false)
					eigenvectorIndex++;
				isZeroVector = true;
			}

			for(int j = 0; j < A.length; j++)
				A[j][j] += eigenvalue[i];
		}
	}
}
