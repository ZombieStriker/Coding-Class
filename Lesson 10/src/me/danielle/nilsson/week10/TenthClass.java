package me.danielle.nilsson.week10;

import me.danielle.nilsson.undeadengine.GameEngine;

public class TenthClass {

	public static void main (String... args){
		GameEngine engine = new GameEngine(new SpaceshipGame());
		engine.init();
		engine.start();
	}
}
