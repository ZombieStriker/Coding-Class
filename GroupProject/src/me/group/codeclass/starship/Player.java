package me.group.codeclass.starship;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.danielle.nilsson.undeadengine.UndeadSpriteUtil;

import java.awt.image.BufferedImage;

public class Player {

	private int x;
	private int y;
	private int height = 48;
	private int width = 16;
	private int bodyheight = 32;
	private int xdir = 0;
	private int ydir = 0;
	private World world;

	public int movespeed = 5;
	public int jumpheight = 14;

	public boolean left = false;
	public boolean right = false;
	public boolean jump = false;

	public boolean goingLeft = false;

	public BufferedImage body = UndeadSpriteUtil.getImage("/textures/player/playerbody.png");
	public BufferedImage body_left = GraphicsWrapper.getYFlippedImage(body);
	public HeadType headtype = HeadType.HEAD3;

	public Player(World world, int x, int y){
		this.world= world;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}

	public void tick(){
		xdir = 0;
		if(right){
			if(!world.getTileAtPoint(x+width+movespeed,y).material.isSolid() && !world.getTileAtPoint(x+width+movespeed,y- world.tilesize).material.isSolid()) {
				xdir = movespeed;
			}else{
				xdir = 0;
			}
		}
		if(left){
			if(!world.getTileAtPoint(x-movespeed,y).material.isSolid() && !world.getTileAtPoint(x-movespeed,y- world.tilesize).material.isSolid()) {
				xdir = -movespeed;
			}else{
				xdir = 0;
			}
		}
		this.x += xdir;
		if(world.getTileAtPoint(x,y+ydir).material.isSolid() || world.getTileAtPoint(x+width,y+ydir).material.isSolid()){
			ydir = 0;
		}

		if(world.getTileAtPoint(x,y-bodyheight-1).material.isSolid() || world.getTileAtPoint(x+width,y-bodyheight-1).material.isSolid()){
			if(jump){
				ydir+=jumpheight;
			}else{
				ydir=0;
			}
		}else{
			ydir-=world.gravity;
		}

		//Make sure the player does not go in the ground
		if(ydir < 0) {
			for (int i = 0; i < world.tilesize; i++) {
				Tile floortile = world.getTileAtPoint(x + width, y + ydir - bodyheight);
				if (floortile != null && floortile.material.isSolid()) {
					ydir++;
				} else {
					break;
				}
			}
		}


		this.y +=ydir;

	}
}
