package com.UserDefinedMethods;

public class Methodexample9 {

	// Method names should be always Unique
	// Method withOut parameters
	public void addition() {
		
		int var1=10;//Local Variables
		int var2=20;
		int var3;
		var3=var1+var2;
		System.out.println("Addition of 2 numbers"+var3);
		
		
	}
	
	public static void main(String[] args) {
		
		Methodexample9 m9=new Methodexample9();
		m9.addition();
		System.out.println(" Calling the Addition Method - WithOut Parameters ");
		m9.subtraction(50, 10);
        System.out.println(" Calling the Addition Method - With 2 Parameters ");
		m9.addition(34, 45, 20);
		System.out.println(" Calling the Addition Method - With 3 Parameters ");
		m9.addition(30, 10, 30);
		System.out.println(" Calling the Addition Method - With 3 Parameters ");
		m9.addition(30,20,10.3456);
		System.out.println(" Calling the Addition Method - With 3 Parameters with different dataTypes ");
		m9.addition("hi", 1, 3);
	}
// Its Method OverLoading - Methods are similar but Method with different Signature
//  Method with Parameters
	
	public void subtraction(int var1,int var2) {
		
		int var3;
		var3=var1-var2;
		System.out.println("Subtraction of 2 number -"+var3);
		
	}
	public void addition(String var1,int var2,int var3)
	{
	// Local Variables
	//int var1=30;
	//int var2=50;

	
	//var3=var1+var2+var3;
	System.out.println(" The value of the variable var3 after Addition is :- "+var1);
	
	}
	public void addition(int var1,int var2,double var3 )
	{
	// Local Variables
	//int var1=30;
	//int var2=50;

	//int var1;
	//int var2;

	double var4;
	var4=var1+var2+var3;
	System.out.println(" The value of the variable var3 after Addition is :- "+var4);
	}
}
