package me.danielle.nilsson.week4;

import java.util.Scanner;

public class FourthClass {

	public static void main(String... args){
		// Create a Scanner object
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");

		int input = scanner.nextInt();

		int square = input * input;

		System.out.println("The square of "+input+" is "+ square);
	}
}
