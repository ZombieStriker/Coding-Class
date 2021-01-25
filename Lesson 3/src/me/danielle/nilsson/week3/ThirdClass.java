package me.danielle.nilsson.week3;

import java.util.Scanner;

public class ThirdClass {

	public static void main(String... args){
		// Create a Scanner object
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");

		String input = scanner.nextLine();

		//Lets convert this string into an integer
		int number = Integer.parseInt(input);

		System.out.println("The square of "+number+" is "+ (number * number));
	}
}
