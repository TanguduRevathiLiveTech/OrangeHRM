package com.StringCamparsion;

public class StringCantainsExample {

	public static void main(String[] args) {
		String i="LiveTech";
		String j="Live";// in equals comparison case sensitive also consider
		if(i.contains(j))
		{
			System.out.println("string i variable is contains j variable");
		}
		else {
			System.out.println("string i variable does not caontains  j variable");
		}
		
		String x="LiveTech";
		String y="Live";// in equals comparison case sensitive also consider
		if(y.contains(x))
		{
			System.out.println("string x variable is contains y variable");
		}
		else {
			System.out.println("string x variable does not caontains  y variable");
		}
	}



	}


