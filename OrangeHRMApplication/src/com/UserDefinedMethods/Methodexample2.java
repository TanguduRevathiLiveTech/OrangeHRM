package com.UserDefinedMethods;

public class Methodexample2 {

	// Method names should be always Unique
	public void addition()
	{
		// Local Variables
		int var1=10;
		int var2=20;
		int var3;
		var3=var1+var2;
		System.out.println("The addition of 2 numbers - "+var3);
	
	}
	
	
	
	public static void main(String[] args) {
		
		Methodexample2 hello=new Methodexample2();
		hello.addition();
		hello.addition();
		hello.subtraction();
	}

	public void subtraction() {
		
		
		int var1=30;
		int var2=50;
		int var3;
		
		var3=var1-var2;
		System.out.println("The subtraction of 2 number - "+var3);
	}
	
}
