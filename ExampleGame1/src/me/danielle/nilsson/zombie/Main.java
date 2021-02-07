package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.GameEngine;

public class Main {

	public static void main (String... args){
		GameEngine game = new GameEngine(new ZombieGame());
		game.init();
		game.start();
	}
}
