package com.StringCamparsion;

public class StringequalsIgnoreCaseExample {

	public static void main(String[] args) {
		String i="LiveTech";
		String j="Livetech";// in equalsIgnoreCase comparison case sensitive will not be consider
		if(i.equalsIgnoreCase(j))
		{
			System.out.println("string i variable is equal to j variable");
		}
		else {
			System.out.println("string i is not equal to j variable");
		}
		
	



	}

}
