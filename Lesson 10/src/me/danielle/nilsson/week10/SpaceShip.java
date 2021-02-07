package me.danielle.nilsson.week10;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.danielle.nilsson.undeadengine.Sprite;

public class SpaceShip {


	public SpaceShip(SpaceshipGame game, int x, int y){
		this.game= game;
		spaceshipX = x;
		spaceshipY = y;
	}


	public double spaceshipX = 500;
	public double spaceshipY = 100;
	public double spaceship_velocity_x = 0;
	public double spaceship_velocity_y = 0;
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	private SpaceshipGame game;

	public void tick() {
		double blackhole_spaceship_distance_squared =
				(spaceshipX - game.blackholex) * (spaceshipX - game.blackholex) + (spaceshipY - game.blackholey) * (spaceshipY - game.blackholey);

		double delta_xvelo = (game.blackholex - spaceshipX) * game.blackhole_gravity / blackhole_spaceship_distance_squared;
		double delta_yvelo = (game.blackholey - spaceshipY) * game.blackhole_gravity / blackhole_spaceship_distance_squared;

		if (up) {
			delta_yvelo -= game.thrusterSpeed;
		}
		if (down) {
			delta_yvelo += game.thrusterSpeed;
		}
		if (left) {
			delta_xvelo -=game. thrusterSpeed;
		}
		if (right) {
			delta_xvelo += game.thrusterSpeed;
		}

		spaceship_velocity_x += delta_xvelo;
		spaceship_velocity_y += delta_yvelo;

		spaceshipX += spaceship_velocity_x;
		spaceshipY += spaceship_velocity_y;
	}

	public void render(GraphicsWrapper graphics) {
		graphics.drawImage(Sprite.SPACESHIP_1.getImage(),(int)spaceshipX,(int)spaceshipY);
	}
	public void setVelocity(int x, int y){
		this.spaceship_velocity_x = x;
		this.spaceship_velocity_y = y;
	}
}
