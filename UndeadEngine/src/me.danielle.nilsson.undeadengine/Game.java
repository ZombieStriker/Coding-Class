package me.danielle.nilsson.undeadengine;

import java.awt.*;

public interface Game {

	public void tick();
	public void render(GraphicsWrapper graphics);
	void keyPressed(Key key);
	void keyReleased(Key key);
	void mouseClick(Location location, MouseClickType button);
	void mouseMove(Location location);
	void mouseRelease(Location location, MouseClickType typeFrom);
}
