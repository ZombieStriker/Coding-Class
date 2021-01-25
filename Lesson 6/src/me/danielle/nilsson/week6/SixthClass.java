package me.danielle.nilsson.week6;

import me.danielle.nilsson.undeadengine.GameEngine;

public class SixthClass {
	public static void main(String... args){
		GameEngine engine = new GameEngine(new TestGame());
		engine.init();
		engine.start();
	}
}
