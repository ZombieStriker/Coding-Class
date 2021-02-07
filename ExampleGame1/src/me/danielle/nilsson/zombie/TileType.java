package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.Sprite;

import java.awt.image.BufferedImage;

public enum TileType {
	AIR(null, false),
	STONE(Sprite.STONE.getImage(),true),
	GRASS(Sprite.GRASS.getImage(),true),
	DIRT(Sprite.DIRT.getImage(),true),
	LAVA(Sprite.LAVA.getImage(),true),
	CONCRETE(Sprite.CONCRETE.getImage(),true),
	;

	private boolean solid;
	private BufferedImage image;

	TileType(BufferedImage bi, boolean isSolid){
		this.image = bi;
		this.solid = isSolid;
	}
	public boolean isSolid(){
		return solid;
	}
	public BufferedImage getImage(){
		return image;
	}
}
