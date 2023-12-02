package com.arrays;

public class SingleDimensionaArrays {

	public static void main(String[] args) {
		//syntax - DataType ArrayName = new DataType[Size];
	      int array1[]=new int[3];
	      array1[0]=1;
	      array1[1]=4;
	   
	      /*here not declare any value for index 2 but print statement 
	       * is written as array1[2] to print the value 
	        of index 2.in this example the value of index 2
	         is taken by default value is nothing but "0".
	       */
	      System.out.println(array1[0]);
	      System.out.println(array1[1]);
	      System.out.println(array1[2]);
	      
	      System.out.println("********************************************************");
	      


	      
	      /* In this example it print the output still the size of array exists then it 
	        throw an exception in 34 line ,because the index number is out of range
	       */
	      
	     
	      System.out.println(array1[0]);
	      System.out.println(array1[1]);
	      System.out.println(array1[2]);
	      System.out.println(array1[3]);
	   
	      System.out.println("***********************************************************");
	      
	      
	      
	    /* array1[0]=1;
	      array1[1]=4;
	      array1[2]=5;
	     
	      //Example of one dimensional array
	      System.out.println(array1[0]);
	      System.out.println(array1[1]);
	      System.out.println(array1[2]);
	      */
	      
	      
	}

}
