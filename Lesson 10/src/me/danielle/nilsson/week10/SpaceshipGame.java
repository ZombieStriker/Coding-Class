package me.danielle.nilsson.week10;

import me.danielle.nilsson.undeadengine.*;
import java.awt.*;

public class SpaceshipGame implements Game {


	private double spaceshipX=500;
	private double spaceshipY=100;
	private double spaceship_velocity_x=6;
	private double spaceship_velocity_y=0;

	private int blackholex = 500;
	private int blackholey = 500;
	private double blackhole_gravity = 50;
	private int blackholeRadius = 10;

	private boolean left=false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private double thrusterSpeed = 0.1;


	@Override
	public void tick() {
		double blackhole_spaceship_distance_squared =
				(spaceshipX-blackholex)*(spaceshipX-blackholex)	+ (spaceshipY-blackholey)*(spaceshipY-blackholey);

		double delta_xvelo = (blackholex-spaceshipX) * blackhole_gravity / blackhole_spaceship_distance_squared;
		double delta_yvelo = (blackholey-spaceshipY) * blackhole_gravity / blackhole_spaceship_distance_squared;

		if(up){
			delta_yvelo-=thrusterSpeed;
		}
		if(down){
			delta_yvelo+=thrusterSpeed;
		}
		if(left){
			delta_xvelo-=thrusterSpeed;
		}
		if(right){
			delta_xvelo+=thrusterSpeed;
		}

		spaceship_velocity_x += delta_xvelo;
		spaceship_velocity_y += delta_yvelo;

		spaceshipX+=spaceship_velocity_x;
		spaceshipY+=spaceship_velocity_y;

	}

	@Override
	public void render(GraphicsWrapper graphics) {

		graphics.drawImage(Sprite.BACKGROUND_4.getImage(),0,0);

		graphics.fillRectangle(blackholex-blackholeRadius,blackholey-blackholeRadius,2*blackholeRadius,2*blackholeRadius,new Color(0,0,0));


		graphics.drawImage(Sprite.SPACESHIP_1.getImage(),(int)spaceshipX,(int)spaceshipY);
	}

	@Override
	public void keyPressed(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			right = true;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			left = true;
		}
		if(key == Key.W || key == Key.UP_ARROW){
			up = true;
		}
		if(key == Key.S || key == Key.DOWN_ARROW){
			down = true;
		}

	}

	@Override
	public void keyReleased(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			right = false;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			left = false;
		}
		if(key == Key.W || key == Key.UP_ARROW){
			up = false;
		}
		if(key == Key.S || key == Key.DOWN_ARROW){
			down = false;
		}
	}

	@Override
	public void mouseClick(Location location, MouseClickType button) {

	}

	@Override
	public void mouseMove(Location location) {

	}
}
