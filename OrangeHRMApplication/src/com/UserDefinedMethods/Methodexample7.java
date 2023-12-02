package com.UserDefinedMethods;

public class Methodexample7 {
	
	public static void main(String[] args) {
		Methodexample2 m2=new Methodexample2();
		m2.addition();//Public modifier
		System.out.println("Addition method of methodexample2");
		m2.subtraction();//Public modifier
		System.out.println("Subtraction method of methodexample2");

		Methodexample3 m3=new Methodexample3();//Private modifier
		System.out.println("Multiplication method of methodexample3");
		//	Multiplication Method is a Private Method -- the Private methods cannot be accessed
		//  from other different class
    	// Private Methods can be accessed in the same Class in which they are Created and
		//   can be accessed for any number of times within the class
	
		
		Methodexample5 m5=new Methodexample5();//Protected modifier
		System.out.println("Division method of methodexample5");
		 
		Methodexample6 m6=new Methodexample6();//Default modifier
		m6.addition();
		System.out.println("Addition method of methodexample6");
		
		
		
	}
	

}
