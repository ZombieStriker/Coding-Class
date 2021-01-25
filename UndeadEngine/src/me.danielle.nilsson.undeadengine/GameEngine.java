package me.danielle.nilsson.undeadengine;

import me.danielle.nilsson.undeadengine.Game;
import me.danielle.nilsson.undeadengine.GraphicsWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameEngine extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private Thread thread;
	private boolean running = false;

	private int WIDTH = 1000;
	private int HEIGHT = 1000;

	private Game game;

	public GameEngine(Game game){
		this.game = game;
	}



	public void init(){
		thread = new Thread(this);

		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

		setTitle("UndeadEngine v0.1");
		this.setSize(new Dimension(WIDTH, HEIGHT));
		setSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		setResizable(true);
		pack();
	}

	public void start(){
		running = true;
		thread.start();
	}

	@Override
	public void run() {

		while(running) {
			game.tick();
			BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			game.render(new GraphicsWrapper((Graphics2D) bi.getGraphics()));

			Graphics2D thisGraph = (Graphics2D) getGraphics();
			if (thisGraph != null)
				thisGraph.drawImage(bi, 0, 0, WIDTH, HEIGHT, null);
			try {
				thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setVisible(false);
		dispose();
		thread.stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.keyPressed(Key.getKey(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.keyReleased(Key.getKey(e.getKeyCode()));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.mouseClick(new Location(e.getX(),e.getY()), MouseClickType.getTypeFrom(e));
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		game.mouseMove(new Location(e.getX(),e.getY()));

	}
}
