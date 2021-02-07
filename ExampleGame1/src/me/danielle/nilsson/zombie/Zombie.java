package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.GraphicsWrapper;
import me.danielle.nilsson.undeadengine.Sprite;

public class Zombie extends Entity{

	private int movespeed =2;

	public Zombie(ZombieGame game, int x, int y) {
		super(game, x, y, Sprite.ZOMBIE_TOPDOWN.getImage());
	}

	@Override
	public void tick() {
		super.tick();

		Player player = game.player;

		int xdif = player.x-x;
		int ydif = player.y-y;

		left = xdif < -width;
		right = xdif > width;
		up = ydif < -height;
		down = ydif > height;

		if(left)
			x-=movespeed;
		if(right)
			x+=movespeed;
		if(up)
			y-=movespeed;
		if(down)
			y+=movespeed;
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		super.render(graphics);
	}
}
