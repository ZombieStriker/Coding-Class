package me.group.codeclass.starship;

import me.danielle.nilsson.undeadengine.*;
import me.group.codeclass.starship.entity.Entity;

import java.awt.image.BufferedImage;

public class StarShipSimulatorGame implements Game {


	public World world = new World( 20, 20);

	public int cameraXOffset = 0;
	public int cameraYOffset = 0;
	public int cameraWidth = 1000;
	public int cameraHeight = 1000;


	public StarShipSimulatorGame(int width, int height) {
		this.cameraWidth = width;
		this.cameraHeight = height;
		world.spawnPlayer(50, 80);
	}

	@Override
	public void tick() {
		world.tick();
		cameraXOffset = world.player.getX() - (cameraWidth / 2);
		cameraYOffset = -world.player.getY() - (cameraHeight / 2);
		if(cameraYOffset > -1000){
			cameraYOffset=-1000;
		}
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		for (int x = 0; x < world.tiles.length; x++) {
			for (int y = 0; y < world.tiles[x].length; y++) {
				if (world.tiles[x][y] != null)
					draw(graphics, world.tiles[x][y].material.getImage(),  x * world.tilesize, -(y+1) * world.tilesize, world.tilesize, world.tilesize);
			}
		}
		for(Entity e : world.entities){
			draw(graphics,e.getImage(),e.getX(),-e.getY(),e.getWidth(),e.getHeight());
		}


		if(world.player.goingLeft){
			draw(graphics, world.player.body_left, world.player.getX(), -world.player.getY(), 16, 32);
			draw(graphics, world.player.headtype.getInvertedImage(), world.player.getX(), -world.player.getY() - 16, 16, 16);
		}else {
			draw(graphics, world.player.body, world.player.getX(), -world.player.getY(), 16, 32);
			draw(graphics, world.player.headtype.getImage(), world.player.getX(), -world.player.getY() - 16, 16, 16);
		}
	}

	public void draw(GraphicsWrapper graphics, BufferedImage bi, int x, int y, int width, int height) {
		graphics.drawImage(bi, x - cameraXOffset, y - cameraYOffset, width, height);
	}

	@Override
	public void keyPressed(Key key) {
		if(key == Key.D){
			world.player.right = true;
			world.player.goingLeft=false;
		}
		if(key == Key.A){
			world.player.left = true;
			world.player.goingLeft=true;
		}
		if(key == Key.SPACE){
			world.player.jump = true;
		}
	}

	@Override
	public void keyReleased(Key key) {
		if(key == Key.D){
			world.player.right = false;
		}
		if(key == Key.A){
			world.player.left = false;
		}
		if(key == Key.SPACE){
			world.player.jump = false;
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
