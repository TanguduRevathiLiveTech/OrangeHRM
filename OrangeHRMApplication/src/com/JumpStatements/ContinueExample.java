package com.JumpStatements;

public class ContinueExample {

	public static void main(String[] args) {
		int i,j;
		for(i=0;i<=5;i++)
		{
			System.out.println("hello");
			if(i==3) {
				System.out.println("hii");
				continue;
			}
			System.out.println("hlo");
		}
	}

}
