package me.danielle.nilsson.textadventure;

import java.util.Scanner;

public class Adventure {


	public static AdventureGame adventureGame = new AdventureGame();

	public static void main (String... args){
		// Create a Scanner object
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====================");
		System.out.println("Welcome to Project Adventure");
		System.out.println("");
		System.out.println("When you're done, type 'exit' to exit");
		System.out.println("======================");
		System.out.println(adventureGame.getWorldLocation().getTravelToMessage());
		while(true) {
			System.out.print(">");
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("exit")){
				break;
			}
			String response = getResponse(input);
			System.out.println(response);
		}
	}


	public static String getResponse(String input){
		String[] words = input.split("\\s+");
		if(words[0].equalsIgnoreCase("help")){
			System.out.println("Commands and Usages:");
			System.out.println("Go <Direction> : Move in a direction");
			System.out.println("Look <Direction>: Looks over to the next tile in a direction.");
		}
		if(words[0].equalsIgnoreCase("go")){
			if(words.length == 1){
				return "Please specify a direction";
			}
			Direction dir = Direction.getDirectionFromName(words[1]);
			if(dir == null){
				return "Direction must either be North, South, East, or West";
			}
			WorldLocations tileUp = adventureGame.getWorldLocation(adventureGame.getX()+dir.getxDir(), adventureGame.getY()+ dir.getYDir());
			if(tileUp.traverseable){
				adventureGame.setX(adventureGame.getX()+dir.getxDir());
				adventureGame.setY(adventureGame.getY()+dir.getYDir());
				WorldLocations currentSpot = adventureGame.getWorldLocation();
				return currentSpot.travelToMessage;
			}else{
				return "Cannot go "+dir.name+", as it is not traversable.";
			}
		}
		if(words[0].equalsIgnoreCase("look")){
			if(words.length == 1){
				return "Please specify a direction";
			}
			Direction dir = Direction.getDirectionFromName(words[1]);
			if(dir == null){
				return "Direction must either be North, South, East, or West";
			}
			WorldLocations tileUp = adventureGame.getWorldLocation(adventureGame.getX()+dir.getxDir(), adventureGame.getY()+ dir.getYDir());
				return "You see "+tileUp.locationName;
		}
		return "Invalid input: Valid options are \"Go <Direction>\", \"Look <Direction>\"";
	}
}
