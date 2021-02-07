package me.danielle.nilsson.week11;

import me.danielle.nilsson.undeadengine.GameEngine;

public class EleventhClass {

	public static void main (String... args){
		GameEngine engine = new GameEngine(new SnowGlobe());
		engine.init();
		engine.start();
	}
}
