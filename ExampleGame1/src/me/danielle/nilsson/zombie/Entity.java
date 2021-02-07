package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;

import java.awt.image.BufferedImage;

public class Entity {

	public int x;
	public int y;
	public ZombieGame game;

	public boolean left;
	public boolean right;
	public boolean up;
	public boolean down;

	public int width = 32;
	public int height = 32;

	public BufferedImage image = null;
	public Entity(ZombieGame game, int x, int y, BufferedImage image){
		this.game= game;
		this.x = x;
		this.y= y;
		this.image = image;
	}

	public void tick(){

	}

	public void render(GraphicsWrapper graphics){
		if(image!=null){
			double radiuans = Math.PI/4;
			if(up && right){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans);
			}else if(down && right){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*3);
			} else if(down && left){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*5);
			} else if(up && left){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*7);
			}else if(right){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*2);
			}else if(down){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*4);
			}else if(left){
				graphics.drawRotatedImage(image,this.x,this.y,width,height,radiuans*6);
			}else if(up){
				graphics.drawImage(image,this.x,this.y,width,height);
			}else{
				graphics.drawImage(image,this.x,this.y,width,height);
			}
		}
	}
}
