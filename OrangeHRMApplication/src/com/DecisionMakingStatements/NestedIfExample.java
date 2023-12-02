package com.DecisionMakingStatements;

public class NestedIfExample {

	public static void main(String[] args) {
		int x=40;
		int y=80;
		int z=100;
	    
		System.out.println("The value of int in x variable is :- "+x);
		System.out.println("The value of int in y variable is :- "+y);
		System.out.println("The value of int in z variable is :- "+z);

		if(x<y)
		{
			System.out.println("The value of x is less than value of y");
		 if(y<z) {
			System.out.println("The value of y is less than than value of z");
	
		}
		 
			System.out.println("hi everyone ");
		}

		else {
			System.out.println("The value of z is greater than value of x and y ");

		}

	}

}
