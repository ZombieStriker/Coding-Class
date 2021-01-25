package me.danielle.nilsson.week9;

import me.danielle.nilsson.undeadengine.GameEngine;
import me.danielle.nilsson.week8.MesasagerGame;

public class NinethClass {

	public static void main (String... args){
		GameEngine engine = new GameEngine(new PlatformerGame());
		engine.init();
		engine.start();
	}
}
