package com.LoopsStatements;

public class NestedLoopExample {

	public static void main(String[] args) {
		int i,j;
		for(i=0;i<=5;i++)//outer loop
		{
			for(j=0;j<i;j++)//inner loop
			{
			System.out.println(i);//(the outer loop will execute still the inner loop get into false block)
		}
	}

}
}
