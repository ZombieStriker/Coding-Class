package me.group.codeclass.starship.entity;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.group.codeclass.starship.World;

import java.awt.image.BufferedImage;

public abstract class Entity {

	protected int x;
	protected int y;
	protected int xdir=0;
	protected int ydir =0;
	protected World world;

	public Entity(World world, int x ,int y){
		this.world=  world;
		this.x = x;
		this.y = y;
		world.entities.add(this);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public abstract void tick();

	public abstract BufferedImage getImage();

	public void setX(int x){
		this.x =x ;
	}
	public void setY(int y){
		this.y = y;
	}

	public World getWorld(){
		return world;
	}

	public abstract int getWidth();

	public abstract int getHeight();

	public int getXDir(){
		return xdir;
	}
	public int getYDir(){
		return ydir;
	}
	public void setXDir(int xdir){
		this.xdir = xdir;
	}
	public void setYDir(int ydir){
		this.ydir = ydir;
	}
}
