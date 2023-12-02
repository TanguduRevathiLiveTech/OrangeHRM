package com.StringCamparsion;

public class StringEqualsExample {

	public static void main(String[] args) {
	
		String x="LiveTech";
		String y="LiveTech";
		if(x.equals(y))
		{
			System.out.println("string x variable is equal to y");
		}
		else {
			System.out.println("string x is not equal to y variable");
		}
		String a="   LiveTech";
		String b="LiveTech";
		if(a.equals(b))//before text,after text and between text space will also be consider as text
		{
			System.out.println("string a variable is equal to b");
		}
		else {
			System.out.println("string a is not equal to b variable");
		}
		String i="LiveTech";
		String j="Livetech";// in equals comparison case sensitive also consider
		if(i.equals(j))
		{
			System.out.println("string i variable is equal to j variable");
		}
		else {
			System.out.println("string i is not equal to j variable");
		}
		
	}

}
