package com.arrays;

public class MultiDimensionalArrays {
	public static void main(String[] args) {
		
	
	//Syntax - DataType ArrayName[][] = new DataType[][];
	/*	String array1[][]=new String[3][3];
		array1[0][0]="hello";
		array1[0][1]="hello";
		array1[0][2]="hello";
		array1[1][0]="hello";
		array1[1][1]="hello";
		array1[1][2]="hello";
		array1[2][0]="hello";
		array1[2][1]="hello";
		array1[2][2]="hello";
		
		
		for(int rowindex=0;rowindex<=array1.length;rowindex++)
		{
			
			for(int rowofcellindex=0;rowofcellindex<=array1.length;rowofcellindex++ )
			{
				System.out.print(array1[rowindex][rowofcellindex]);
			}
			System.out.println();
		
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	String array1[][][]=new String[2][3][3];
	array1[0][0][0]="revathi";
	array1[0][0][1]="revathi";
	array1[0][0][2]="revathi";
	array1[0][1][0]="revathi";
	array1[0][1][1]="revathi";
	array1[0][1][2]="revathi";
	array1[0][2][0]="revathi";
	array1[0][2][1]="revathi";
	array1[0][2][2]="revathi";
	
	array1[1][0][0]="revathi";
	array1[1][0][1]="revathi";
	array1[1][0][2]="revathi";
	array1[1][1][0]="revathi";
	array1[1][1][1]="revathi";
	array1[1][1][2]="revathi";
	array1[1][2][0]="revathi";
	array1[1][2][1]="revathi";
	array1[1][2][2]="revathi";
	
	for(int boxes=0;boxes<=1;boxes++)
	{
		System.out.println();
		
		for(int rowindex=0;rowindex<3;rowindex++)
		{
			
			for(int rowofcellindex=0;rowofcellindex<3;rowofcellindex++ )
			{
				System.out.print(array1[boxes][rowindex][rowofcellindex]);
			}
			System.out.println();
		}
		
		
	}	
 
   

}
}
