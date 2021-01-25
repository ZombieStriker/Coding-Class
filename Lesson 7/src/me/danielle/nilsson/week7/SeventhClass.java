package me.danielle.nilsson.week7;

import me.danielle.nilsson.undeadengine.*;

public class SeventhClass {

	public static void main(String... args){
		GameEngine engine = new GameEngine(new PongGame());
		engine.init();
		engine.start();
	}
}
