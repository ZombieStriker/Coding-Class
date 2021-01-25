package me.danielle.nilsson.week2;

public class SecondClass {

	public static void main(String... args){

		//The basic format to all objects are
		//
		// [Variable] [name] = [Value] ;
		//
		// Where:
		//  [Variable] is the type of object you are creating
		//  [name] is the name you want to call that object (can be called almost anything)
		//  [Value] is the object you are setting the variable to
		//  And the whole statement ends with a semicolon ( ; )
		//

		//Example
		//This creates an "Integer" (number) called "number", and sets it to the value 42
		int number = 42;

		//This is a double (number with a decimal point). called decimal. It is set to 3.14
		double decimal = 3.14;

		//This creates a char (character/letter) called lowercase_a and sets it to 'a'
		char lowercase_a = 'a';

		//This creates a String (a series or characters/ words) called message and sets it to a new message
		String messagee = "Hello class";

		//This creates a boolean (true or false) called bool, and it will be set to true
		boolean bool = true;



		//Lets create and add some objects together.
		//
		//First, lets add two values together.
		int number_1 = 1;
		int number_2 = 2;

		//This should now be set to the result of 1 + 2, which should be 3
		int number_result = number_1 + number_2;



		//Now lets do some subtraction
		int number_55 = 55;
		int number_44 = 44;

		//This will now subtract 44 from 55, which should produce 11
		int new_Result = number_55 - number_44;


		//You can also do addition or subtraction without creating variables
		int math = 11 + 12 - 13;



		//Multiplication is done byh using the asterisk ( * ) character
		int square_of_5 = 5 * 5;

		//Division is done through using the slash ( / ) character
		double half_of_PI = 3.1415926 / 2;




		//Now lets add some words together
		String hello = "Hello";
		String world = "-World";

		//This will now store the value "Hello-World"
		String hello_world = hello + world;




		//Now lets cover the null value
		//
		// Null means nothing. When you set an object to null, that means it is not currently set to anything
		//
		// The null value is useful for when you don't have a value to set an object to, or need to return nothing

		Object someNullObject = null;
		String null_text = null;





		//Now lets compare some values
		boolean isCool = true;

		//This will check if isCool is equal to true
		if(isCool == true){
			//This code will only print out if the isCool variable is set to true
			//If you change isCool to false, this will not print to the console
			System.out.println("The author of this code is cool.");
		}

		//Lets compare numbers
		int int_42 = 42;

		//This will check if the value of int_42 is equal to 42
		if(int_42 == 42){
			System.out.println("The number int_42 is equal to 42");

			//This else statement will only be called if you change int_42
		}else{
			System.out.println("The number of int_42 is not 42");
		}


		//We are now going to print these values out into the console
		System.out.println("-==============-");
		System.out.println("The value Math is equal to = "+math);
		System.out.println("The square of 5 is equal to = "+square_of_5);
		System.out.println("Half_of_PI is equal to = "+half_of_PI);
		System.out.println("Hello_World is equal to = "+hello_world);


	}
}
