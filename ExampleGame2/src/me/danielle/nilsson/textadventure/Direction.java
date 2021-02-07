package me.danielle.nilsson.textadventure;

public enum Direction {
	WEST(-1,0, "West"),
	EAST(1,0, "East"),
	NORTH(0,1, "North"),
	SOUTH(0,-1,"South"),
	;

	int xDir;
	int ydir;
	String name;

	Direction(int xdir, int ydir, String name){
		this.xDir = xdir;
		this.ydir = ydir;
		this.name = name;
	}
	public int getxDir(){
		return xDir;
	}
	public int getYDir(){
		return ydir;
	}
	public static Direction getDirectionFromName(String name){
		for(Direction d : values()){
			if(d.name.equalsIgnoreCase(name))
				return d;
		}
		return null;
	}
}
