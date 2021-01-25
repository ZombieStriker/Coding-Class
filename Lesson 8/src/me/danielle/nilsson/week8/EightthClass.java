package me.danielle.nilsson.week8;

import me.danielle.nilsson.undeadengine.GameEngine;

public class EightthClass {

	public static void main (String... args){
		GameEngine engine = new GameEngine(new MesasagerGame());
		engine.init();
		engine.start();
	}
}
