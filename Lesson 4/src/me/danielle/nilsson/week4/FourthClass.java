package me.danielle.nilsson.week4;

public class FourthClass {




	public static void main(String... args){

		//An array is a variable that can hold multiple values

		//This array is an int array, which will hold 10 different values
		int[] array = new int[10];

		//The first value in the array, at index 0, will be equal to 1
		array[0] = 1;
		//The second value, at index 1, will be equal to 2
		array[1] = 2;

		array[2] = 3;
		array[3] = 4;
		array[4] = 5;
		array[5] = 6;
		array[6] = 7;
		array[7] = 8;
		array[8] = 9;

		//The tenth value, at index 9, will be equal to 10
		array[9] = 10;


		//A for loop is a function that allows you to loop over a peace of code multiple times

		int addition = 0;

		// "the int index is equal to 0. while the index is less than 10, increase the index by 1"
		for (int index = 0; index < 10; index++){

			//This is the same ass addition = addition + array[index]+
			addition += array[index];
		}

		System.out.println("The addition of the first 10 values is equal to "+addition);
	}
}
