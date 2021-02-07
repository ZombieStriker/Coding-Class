package me.group.codeclass.starship;

import me.danielle.nilsson.undeadengine.GameEngine;

public class Main {

	public static void main (String... args){
		int width = 1000;
		int height = 1000;
		GameEngine game = new GameEngine(new StarShipSimulatorGame(width,height));
		game.init(width,height);
		game.start();
	}
}
