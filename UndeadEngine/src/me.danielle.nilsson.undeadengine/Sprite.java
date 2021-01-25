package me.danielle.nilsson.undeadengine;


import java.awt.image.BufferedImage;

public enum Sprite {
	PADDLE("/textures/paddle.png"),
	BALL("/textures/ball.png"),
	SNOWMAN("/textures/snowman.png"),
	BACKGROUND_1("/textures/background_1.png"),
	BACKGROUND_2("/textures/background_2.png"),
	BACKGROUND_3("/textures/background_3.png"),
	BACKGROUND_4("/textures/background_4.png"),
	DIRT("/textures/dirt.png"),
	STONE("/textures/stone.png"),
	GRASS("/textures/grass.png"),
	LAVA("/textures/lava.png"),
	SPACESHIP_1("/textures/spaceship_1.png"),
	;

	String path;
	BufferedImage image;

	Sprite(String path) {
		this.path = path;
		this.image = UndeadSpriteUtil.getImage(path);
	}
	public BufferedImage getImage(){
		return image;
	}
}