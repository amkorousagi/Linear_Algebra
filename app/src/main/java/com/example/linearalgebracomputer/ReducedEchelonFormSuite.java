package com.example.linearalgebracomputer;

public class ReducedEchelonFormSuite	//������ : row * col ���� row > col�� ��, ��� �ȵ�
{
	public void LowEchelonForm(float[][] A, float[][] R)
	{
		EchelonForm(A, R);
		
		int row, col, i;
		
		for(row = R.length - 1; row >= 0; row--)
		{
			for(col = 0; col < R[0].length && R[row][col] == 0; col++);
			
			if(col == R[0].length)
				continue;
			
			RowOperation.MultipleRow(R, row, 1 / R[row][col]);
			
			for(i = row - 1; i >= 0; i--)			
				RowOperation.MultipleAndAddition(R, row, i, -1 * R[i][col]);
		}
	}
	
	public void EchelonForm(float[][] A, float[][] R)
	{
		int row, col, i, j, min;
		
		for(row = 0; row < A.length; row++)		
			for(col = 0; col < A[0].length; col++)
				R[row][col] = A[row][col];
		
		for(row = col = 0; row < R.length && col < R[0].length; row++, col++)
		{			
			for(i = row; i < R.length; i++)		//�� ���� ���ҵ��� �ּҷ� ���δ�.
			{
				min = FindMin(R[i]);			//�� ���� ���ҵ� �� �ּڰ��� ���Ѵ�.
				if(min == 0)
					continue;				

				for(int d = 2; d <= min; d++)	//d�� 2���� ������ ���� ���ҵ��� d�� ���������� Ȯ�� �� ���� ���� d�� �ٽ� 2�� ����� Ȯ���ϰ� �ƴϸ� d�� min�� �� ������ Ȯ��
				{
					for(j = 0; j < R[0].length; j++)
						if(R[i][j] % d != 0)
							break;
					
					if(j == R[0].length) {					
						RowOperation.MultipleRow(R, i, 1 / (float)d);					
						min /= d;	d = 1;
					}				
				}
			}
			
			for(i = row + 1; i < R.length && R[row][col] == 0; i++)	//����� ���� col��° ���� 0�� ��, 0�� �ƴ� ��� ��ü		
				RowOperation.Interchange(R, row, i);					
			
			if(i == R.length && i != row + 1) {	//��� ���� col��° ���� 0�� ��, col++
				row--;
				continue;
			}			
			
			for(i = row + 1; i < R.length; i++)			
				RowOperation.MultipleAndAddition(R, row, i, -1 * R[i][col] / R[row][col]);			
		}
	}	
	
	int FindMin(float[] A)
	{
		float min = 0, temp;
		
		for(int i = 0; i < A.length; i++)
		{
			temp = Math.abs(A[i]);
			if(temp == 0)
				continue;
			
			while(temp != (int)temp) temp *= 10;
			
			if(temp < min || min == 0)
				min = temp;
		}
		
		return (int)min;
	}
}
