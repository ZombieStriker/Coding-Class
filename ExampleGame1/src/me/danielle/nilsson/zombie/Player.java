package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.danielle.nilsson.undeadengine.Sprite;

import java.awt.image.BufferedImage;

public class Player {

	protected int x = 0;
	protected int y = 0;
	private ZombieGame game;

	private int movespeed = 10;

	private int playerwidth = 32;
	private int playerheight = 32;

	private static BufferedImage player = Sprite.PLAYER_TOPDOWN.getImage();

	public Player(ZombieGame game, int x ,int y){
		this.x= x;
		this.y = y;
		this.game =game;
	}

	public boolean left=false;
	public boolean right=false;
	public boolean up=false;
	public boolean down=false;

	public void tick() {
		if(left){
			if(x-movespeed > 0){
				x-=movespeed;
			}
		}
		if(right){
			if(x-movespeed < 1000-playerwidth){
				x+=movespeed;
			}
		}
		if(up){
			if(y-movespeed > 0){
				y-=movespeed;
			}
		}
		if(down){
			if(y-movespeed < 1000-playerheight){
				y+=movespeed;
			}
		}
	}

	public void render(GraphicsWrapper graphics) {
		double radiuans = Math.PI/4;
		if(up && right){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans);
		}else if(down && right){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*3);
		} else if(down && left){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*5);
		} else if(up && left){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*7);
		}else if(right){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*2);
		}else if(down){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*4);
		}else if(left){
			graphics.drawRotatedImage(player,this.x,this.y,playerwidth,playerheight,radiuans*6);
		}else if(up){
			graphics.drawImage(player,this.x,this.y,playerwidth,playerheight);
		}else{
			graphics.drawImage(player,this.x,this.y,playerwidth,playerheight);
		}
	}
}
