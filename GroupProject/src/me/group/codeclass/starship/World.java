package me.group.codeclass.starship;

import me.group.codeclass.starship.entity.Entity;
import me.group.codeclass.starship.entity.Turtle;

import java.util.ArrayList;
import java.util.List;

public class World {

	public int tilesize = 32;
	public double gravity = 1;

	public Tile[][] tiles;
	public List<Entity> entities = new ArrayList<>();
	public Player player;

	public World(int width, int height){
		tiles = new Tile[width][height];
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				if(x==0||y==0||x==width-1||y==height-1) {
					tiles[x][y] = new Tile(this, Material.SPACESHIP_TILE);
				}else{
					tiles[x][y] = new Tile(this, Material.AIR);
				}
			}
		}


		tiles[2][1].setType(Material.SPACESHIP_TILE);
		tiles[3][1].setType(Material.SPACESHIP_TILE);
		tiles[4][1].setType(Material.SPACESHIP_TILE);
		tiles[3][2].setType(Material.SPACESHIP_TILE);
		tiles[4][2].setType(Material.SPACESHIP_TILE);
		tiles[4][3].setType(Material.SPACESHIP_TILE);
		tiles[10][3].setType(Material.SPACESHIP_TILE);



		Turtle turtle = new Turtle(this,tilesize*7,80);
	}
	public void spawnPlayer(int x, int y){
		player = new Player(this,x,y);
	}
	public Tile getTile(int x, int y){
		return tiles[x][y];
	}
	public void setTile(Material material, int x, int y){
		tiles[x][y].material = material;
	}
	public Tile getTileAtPoint(int x, int y){
		if(y < 0 || x < 0)
			return null;
		return tiles[x/tilesize][y/tilesize];
	}

	public void tick() {
		player.tick();
		for(Entity e : entities){
			e.tick();
		}
	}
}
