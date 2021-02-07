package me.danielle.nilsson.week6;

import me.danielle.nilsson.undeadengine.*;

public class TestGame implements Game {

	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	private int snowmanX = 500;
	private int snowmanY = 500;
	private int speed = 10;

	public TestGame(){
		AudioPlayer.playLoop(Sound.MUSIC_CORE);
	}

	@Override
	public void tick() {
		if (up) {
			snowmanY -= speed;
		}
		if (down) {
			snowmanY += speed;
		}
		if (left) {
			snowmanX -= speed;
		}
		if (right) {
			snowmanX += speed;
		}
	}

	@Override
	public void render(GraphicsWrapper graphics) {

		graphics.drawImage(Sprite.BACKGROUND_1.getImage(), 0, 0);

		graphics.drawImage(Sprite.SNOWMAN.getImage(), snowmanX, snowmanY);

	}

	@Override
	public void keyPressed(Key key) {
		if (key == Key.UP_ARROW) {
			up = true;
		}
		if (key == Key.DOWN_ARROW) {
			down = true;
		}
		if (key == Key.LEFT_ARROW) {
			left = true;
		}
		if (key == Key.RIGHT_ARROW) {
			right = true;
		}
	}

	@Override
	public void keyReleased(Key key) {
		if (key == Key.UP_ARROW) {
			up = false;
		}
		if (key == Key.DOWN_ARROW) {
			down = false;
		}
		if (key == Key.LEFT_ARROW) {
			left = false;
		}
		if (key == Key.RIGHT_ARROW) {
			right = false;
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
