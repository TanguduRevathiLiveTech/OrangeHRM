package com.UserDefinedMethods;

public class Methodexample3 {
	
 private void multiplication() {
	 
	 int var1=10;
	 int var2 =20;
	 int var3;
	 var3=var1*var2;
	 System.out.println("The multiplication of 2 numbers - "+var3);
	 
	 
 }
	public static void main(String[] args) {
		
		
		Methodexample3 hello=new Methodexample3();
		hello.multiplication();
       //Multiplication Method is a Private Method -- the Private methods cannot be accessed
	   // from other different class
	   //Private Methods can be accessed in the same Class in which they are Created and
	   //can be accessed for any number of times within the class
	   //m3.addition();
	   // MethodExample2 class Addition User defined Method is required in MethodExample3	
       // Creating an Object for Another Class in the Current Class which contains Addition Method
		
		Methodexample2 hi=new Methodexample2();
		hi.addition();
		
	}
	
	
}
