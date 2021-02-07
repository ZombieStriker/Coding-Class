package me.danielle.nilsson.week11;

import me.danielle.nilsson.undeadengine.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;
import java.util.Iterator;

public class SnowGlobe implements Game {

	public ArrayList<SnowFlake> snowflakes = new ArrayList<SnowFlake>();

	public SnowGlobe(){
		AudioPlayer.playLoop(Sound.MUSIC_SNOWY);
	}

	@Override
	public void tick() {
		SnowFlake newSnowFlake = new SnowFlake((int)(Math.random()*1000),0);
		snowflakes.add(newSnowFlake);


		for(SnowFlake snowflake : snowflakes){
			snowflake.tick();
		}

		Iterator<SnowFlake> iterator = snowflakes.iterator();
		while(iterator.hasNext()) {
			SnowFlake check = iterator.next();
			if (check.getY() > 1000) {
				iterator.remove();
			}
		}

	}

	@Override
	public void render(GraphicsWrapper graphics) {
		for(SnowFlake snowFlake : snowflakes){
			graphics.setPixel(snowFlake.getX(),snowFlake.getY(),new Color(255,255,255));
		}
	}

	@Override
	public void keyPressed(Key key) {

	}

	@Override
	public void keyReleased(Key key) {

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
