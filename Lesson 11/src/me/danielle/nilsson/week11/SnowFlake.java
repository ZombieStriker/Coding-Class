package me.danielle.nilsson.week11;

public class SnowFlake {

	private int x;
	private int y;

	public SnowFlake(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tick(){
		y++;
	}

	public int getY() {
		return y;
	}
	public int getX(){
		return x;
	}
}
