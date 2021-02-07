package me.danielle.nilsson.textadventure;

public class AdventureGame {

	public WorldLocations[][] tiles = new WorldLocations[7][7];

	public int xLocation = 3;
	public int yLocation = 3;

	public AdventureGame(){
		for(int i = 0; i < 7; i++){
			tiles[0][i] = WorldLocations.MOUNTAINS;
			tiles[6][i] = WorldLocations.MOUNTAINS;
			tiles[i][0] = WorldLocations.MOUNTAINS;
			tiles[i][6] = WorldLocations.MOUNTAINS;
		}
		for(int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				tiles[i][j] = WorldLocations.WASTELAND;
			}
		}

		tiles[2][3] = WorldLocations.GAS_STATION;
		tiles[3][3] = WorldLocations.DESTROYED_TOWN;
		tiles[2][4] = WorldLocations.RIVER;
		tiles[3][2] = WorldLocations.DESTROYED_TOWN;
		tiles[3][4] = WorldLocations.DESTROYED_TOWN;
	}
	public WorldLocations getWorldLocation(){
		return tiles[xLocation][yLocation];
	}
	public WorldLocations getWorldLocation(int x, int y){
		return tiles[x][y];
	}
	public int getX(){
		return xLocation;
	}
	public int getY(){
		return yLocation;
	}
	public void setY(int y ){
		this.yLocation = y;
	}
	public void setX(int x){
		this.xLocation = x;
	}
}
