package com.UserDefinedMethods;

public class Methodexample6 {
void addition() {// default userdefined method acts same as public it can take as default method and it can be use any class
	int var1=10;
	int var2=20;
	int var3;
	var3=var1+var2;
	System.out.println("The addtion of 2 numbers - "+var3);
	
	
}
	public static void main(String[] args) {
		
		Methodexample6 m6=new Methodexample6();
		m6.addition();
		Methodexample5 m5=new Methodexample5();//protected user defined method is used in other different class but in same package
		m5.division();
		
	}
	
}
