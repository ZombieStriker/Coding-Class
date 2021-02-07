package me.group.codeclass.starship.entity;

import me.danielle.nilsson.undeadengine.UndeadSpriteUtil;
import me.group.codeclass.starship.World;
import me.group.codeclass.starship.entity.ai.BasicLeftRightAI;

import java.awt.image.BufferedImage;

public class Turtle extends Entity{

	private BasicLeftRightAI ai = new BasicLeftRightAI();
	public static BufferedImage TURTLE = UndeadSpriteUtil.getImage("/textures/turtle.png");

	public Turtle(World world, int x, int y) {
		super(world, x, y);
	}

	@Override
	public void tick() {
		ai.tick(this);
	}

	@Override
	public BufferedImage getImage() {
		return TURTLE;
	}

	@Override
	public int getWidth() {
		return 16;
	}

	@Override
	public int getHeight() {
		return 16;
	}

}
