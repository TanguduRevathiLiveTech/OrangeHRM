package com.UserDefinedMethods;

public class Methodexample8 {
int var1=30;//Global Variables
int var2=10;
	public void addition()
	{   //Local Variables
		int var1=10;
		int var2=20;
		int var3;
		var3=var1+var2;
		System.out.println("The addition of 2 numbers - "+var3);
	}
	//Global variables cannot be interact or disturbed local variables which is within a user defined method
	public static void main(String[] args) {
		Methodexample8 m8=new Methodexample8();
		m8.addition();
		m8.subtraction();
		
	}
	//Global variables can be declare any where with in class that is above the user defined method or below user defined method
	public void subtraction() {
	    int var3;
		var3=var1-var2;
		System.out.println("The subtraction of 2 numbers - "+var3);
		
	}	
		
		
	
}
