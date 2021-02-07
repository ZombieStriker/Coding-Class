package me.danielle.nilsson.week10;

import me.danielle.nilsson.undeadengine.*;
import java.awt.*;

public class SpaceshipGame implements Game {


	private SpaceShip spaceShip = new SpaceShip(this, 500, 100);

	public int blackholex = 500;
	public int blackholey = 500;
	public double blackhole_gravity = 50;
	private int blackholeRadius = 10;

	public double thrusterSpeed = 0.1;


	public SpaceshipGame(){
		spaceShip.setVelocity(6,0);
		AudioPlayer.playLoop(Sound.MUSIC_EXPLORING_SPACE);
	}

	@Override
	public void tick() {
		spaceShip.tick();
	}

	@Override
	public void render(GraphicsWrapper graphics) {

		graphics.drawImage(Sprite.BACKGROUND_4.getImage(),0,0);

		graphics.fillRectangle(blackholex-blackholeRadius,blackholey-blackholeRadius,2*blackholeRadius,2*blackholeRadius,new Color(0,0,0));

		spaceShip.render(graphics);
	}

	@Override
	public void keyPressed(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			spaceShip.right = true;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			spaceShip.left = true;
		}
		if(key == Key.W || key == Key.UP_ARROW){
			spaceShip.up = true;
		}
		if(key == Key.S || key == Key.DOWN_ARROW){
			spaceShip.down = true;
		}

	}

	@Override
	public void keyReleased(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			spaceShip.right = false;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			spaceShip.left = false;
		}
		if(key == Key.W || key == Key.UP_ARROW){
			spaceShip.up = false;
		}
		if(key == Key.S || key == Key.DOWN_ARROW){
			spaceShip.down = false;
		}
	}

	@Override
	public void mouseClick(Location location, MouseClickType button) {

	}

	@Override
	public void mouseMove(Location location) {

	}

	@Override
	public void mouseRelease(Location location, MouseClickType typeFrom) {

	}
}
