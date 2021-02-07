package me.group.codeclass.starship;

public class Tile {

	private World world;
	public Material material;

	public Tile(World world, Material material){
		this.world= world;
		this.material = material;
	}

	public void setType(Material spaceshipTile) {
		this.material = spaceshipTile;
	}
}
