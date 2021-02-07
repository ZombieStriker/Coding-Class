package me.group.codeclass.starship;

import me.danielle.nilsson.undeadengine.UndeadSpriteUtil;

import java.awt.image.BufferedImage;

public enum Material {

	SPACESHIP_TILE("/textures/spaceship_tile.png"),
	AIR("/textures/transparent.png",false),

	;

	BufferedImage bi;

	public boolean isSolid = true;
	public boolean isSolid(){
		return isSolid;
	}
	Material(String path){
		bi = UndeadSpriteUtil.getImage(path);
	}
	Material(String path,boolean solid){
		bi = UndeadSpriteUtil.getImage(path);
		this.isSolid = solid;
	}
	public BufferedImage getImage(){
		return bi;
	}

}
