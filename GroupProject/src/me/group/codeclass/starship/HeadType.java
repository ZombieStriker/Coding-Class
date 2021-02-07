package me.group.codeclass.starship;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.danielle.nilsson.undeadengine.UndeadSpriteUtil;

import java.awt.image.BufferedImage;

public enum HeadType {

	HEAD1("/textures/player/head1.png"),
	HEAD2("/textures/player/head2.png"),
	HEAD3("/textures/player/head3.png"),
	;

	BufferedImage bi;
	BufferedImage bi_inverted;

	HeadType(String path){
		bi = UndeadSpriteUtil.getImage(path);
		bi_inverted = GraphicsWrapper.getYFlippedImage(bi);
	}
	public BufferedImage getImage(){
		return bi;
	}
	public BufferedImage getInvertedImage(){
		return bi_inverted;
	}

}
