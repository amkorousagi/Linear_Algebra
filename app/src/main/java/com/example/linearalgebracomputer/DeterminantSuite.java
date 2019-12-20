package com.example.linearalgebracomputer;

public class DeterminantSuite {
	
	float determinant;
	
	public float GetDeterminant(float[][] A)
	{
		determinant = 0;
		
		if(A.length != A[0].length) {
			System.out.println("Can not get determinant");
			return 0;
		}
				
		boolean[] objectIndex = new boolean[A.length];
		
		for(int i = 0; i < A.length; i++) {
			objectIndex[i] = true;
			determinant += (i % 2 == 0 ? 1 : -1) * A[0][i] * CalculateDeterminant(A, A.length - 1, objectIndex);
			objectIndex[i] = false;
		}
				
		return determinant; 
	}
	
	public float CalculateDeterminant(float[][] A, int len, boolean[] objectIndex)
	{
		if(len <= 2)
		{
			int index = 0;
			int[] calIndex = {0 , 0};
			
			for(int i = 0; i < objectIndex.length; i++) {
				if(objectIndex[i] != true)
					calIndex[index++] = i;
			}
			
			return A[A.length - len][calIndex[0]] * A[A.length - len + 1][calIndex[1]]
					- A[A.length - len + 1][calIndex[0]] * A[A.length - len][calIndex[1]]; 
		}
		else
		{
			float sum = 0;
			int m = 0;
			for(int i = 0; i < objectIndex.length; i++) {
				if(objectIndex[i] == true)
					continue;
				
				objectIndex[i] = true;
				sum += (m % 2 == 0 ? 1 : -1) * A[A.length - len][i] * CalculateDeterminant(A, len - 1, objectIndex);
				m++;
				objectIndex[i] = false;
			}
			
			return sum;
		}
	}
}
