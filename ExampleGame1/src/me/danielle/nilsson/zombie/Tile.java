package me.danielle.nilsson.zombie;

public class Tile {

	private ZombieGame game;
	private int x;
	private int y;

	private TileType type = TileType.DIRT;

	public Tile(ZombieGame game, int x,  int y){
		this.game = game;
		this.x = x;
		this.y = y;
	}

	public void setTileType(TileType type){
		this.type = type;
	}

	public TileType getType() {
		return type;
	}

	public int getY() {
		return y;
	}
	public int getX(){
		return x;
	}
}
