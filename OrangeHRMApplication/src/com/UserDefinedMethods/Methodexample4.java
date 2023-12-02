package com.UserDefinedMethods;

public class Methodexample4 {
	private void divison() {
		//local variables
		
		int var1=10;
		int var2=1;
		int var3;
		var3=var1/var2;
		System.out.println("The division of 2 numbers - "+var3);
	}
	
public static void main(String[] args) {
	
	Methodexample2 m2=new Methodexample2();
	m2.addition();
	m2.subtraction();
	Methodexample3 m3=new Methodexample3();
   //Multiplication Method is a Private Method -- the Private methods cannot be accessed
   // from other different class
   // Private Methods can be accessed in the same Class in which they are Created and
  //  can be accessed for any number of times within the class
		
	
	System.out.println("The multiplication of 2 numbers - ");
	Methodexample4 m4 =new Methodexample4();
	m4.divison();
	
}
}
