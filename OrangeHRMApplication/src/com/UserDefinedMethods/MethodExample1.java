package com.UserDefinedMethods;

public class MethodExample1 {
	
	
           // * User defined Methods are created for Re-Usability Purpose
	
			// User Defined Method
			// User defined methods can be created either Above the Main Method OR below the Main method
			// User defined Methods should never be created within the Main
			
			
	public void revathi() {
		
		System.out.println("hello everyone");
	}
		
		
		
	public static void main(String[] args) {
		
		// * User defined Methods are created for Re-Usability Purpose
		
		// User Defined Method
		// User defined methods can be created either Above the Main Method OR below the Main method
		// User defined Methods should never be created within the Main
		
		// The execution Process always starts from the Main method
     	// Creating an Object for the Current Class
		
		MethodExample1 hello =new MethodExample1();
		hello.revathi();
				
		// using the Object - calling the User defined Method
				
				
         //	MethodExample1 test = new MethodExample1();
	     //	test.srinivas();
	
	     // It is not mandatory to create a new object always to call different User defined methods
	     // using the existing Object calling another user defined method	
		hello.Tangudu();
		
	}


public void Tangudu() {
	
	System.out.println("hello every one iam revathi");
}
}
