package com.DecisionMakingStatements;

public class SwitchExample {

	public static void main(String[] args) {
		int weekday=3;
        switch(weekday){
                case 1:
                   System.out.println("monday");
                break;
                case 2:
                   System.out.println("Tuesday");
                break;
                case 3:
                   System.out.println("Wednesday");
                   break;

                case 4:
                    System.out.println("Friday");
                    break;

                case 5:
                    System.out.println("Saturday");
                    break;

                case 6:
                    System.out.println("sunday");
                    break;

                default:
                System.out.println("Hello");
                break;
        }
	}

}
