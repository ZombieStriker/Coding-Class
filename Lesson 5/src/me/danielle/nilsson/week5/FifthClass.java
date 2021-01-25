package me.danielle.nilsson.week5;

public class FifthClass {

	public static void main(String... args) {

		NewClass newClass = new NewClass();

		newClass.setNumber(42);

		newClass.incrementBy1();

		System.out.println("The number from the new class is: "+newClass.getNumber());






		SecondNewClass newClass2 = new SecondNewClass();

		newClass2.setNumber(14);

		newClass2.subtract1();

		System.out.println("The second class number is equal to: "+newClass2.getNumber());

	}
}
