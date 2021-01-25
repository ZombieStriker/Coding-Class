package me.danielle.nilsson.week9;

public class Tile {

	TileType type = TileType.AIR;

	public TileType getType(){
		return type;
	}
	public void setType(TileType type){
		this.type = type;
	}
}
