package me.danielle.nilsson.zombie;

import me.danielle.nilsson.undeadengine.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ZombieGame implements Game {

	private Tile[][] tiles = new Tile[100][100];

	private int tilesize = 32;
	protected Player player;

	private List<Entity> entityList  = new ArrayList<>();

	private boolean game_over = false;

	private int score = 0;
	private int tick = 0;

	public ZombieGame(){
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[x].length;y++){
				tiles[x][y] = new Tile(this,x,y);
			}
		}

		for(int x = 4; x < 27; x++){
			for(int y = 4; y < 27; y++){
				tiles[x][y].setTileType(TileType.CONCRETE);
			}
		}


		init();
	}

	public void init(){
		game_over=false;
		player = new Player(this,500,500);

		score = 0;
		tick = 0;

		entityList.clear();
		entityList.add(new Zombie(this,100,200));
	}


	@Override
	public void tick() {
		if(!game_over) {
			tick++;
			score+=1;

			player.tick();


			if(tick%(150)==149){
				int side = (int)(Math.random()*4);
				if(side==0){
					entityList.add(new Zombie(this,(int)(Math.random()*1000),0));
				}else if(side==1){
					entityList.add(new Zombie(this,(int)(Math.random()*1000),1000));
				}else if(side==2){
					entityList.add(new Zombie(this,0,(int)(Math.random()*1000)));
				}else{
					entityList.add(new Zombie(this,1000,(int)(Math.random()*1000)));
				}
			}



			for (Entity e : entityList) {
				e.tick();
				int xdif = e.x - player.x;
				xdif*=xdif;
				int ydif = e.y - player.y;
				ydif*=ydif;

				if(xdif+ydif < tilesize*tilesize*2){
					game_over=true;
				}
			}
		}
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[x].length;y++) {
				Tile tile = tiles[x][y];
				graphics.drawImage(tile.getType().getImage(),tile.getX()*tilesize,tile.getY()*tilesize,tilesize,tilesize);
			}
		}
		player.render(graphics);

		for(Entity e : entityList){
			e.render(graphics);
		}

		if(game_over){
			graphics.drawImage(Sprite.GAME_OVER.getImage(), 256,256,500,500);
		}

		graphics.drawColoredText("Score: "+score,30,50,new Color(255,255,255));
	}

	@Override
	public void keyPressed(Key key) {
		if(key == Key.R){
			init();
		}
		if(!game_over) {
			if (key == Key.UP_ARROW || key == Key.W) {
				player.up = true;
			}
			if (key == Key.DOWN_ARROW || key == Key.S) {
				player.down = true;
			}
			if (key == Key.LEFT_ARROW || key == Key.A) {
				player.left = true;
			}
			if (key == Key.RIGHT_ARROW || key == Key.D) {
				player.right = true;
			}
		}
	}

	@Override
	public void keyReleased(Key key) {
		if(key == Key.UP_ARROW || key == Key.W){
			player.up = false;
		}
		if(key == Key.DOWN_ARROW || key == Key.S){
			player.down = false;
		}
		if(key == Key.LEFT_ARROW || key == Key.A){
			player.left = false;
		}
		if(key == Key.RIGHT_ARROW || key == Key.D){
			player.right = false;
		}
	}

	@Override
	public void mouseClick(Location location, MouseClickType button) {

	}

	@Override
	public void mouseMove(Location location) {

	}

	@Override
	public void mouseRelease(Location location, MouseClickType typeFrom) {

	}
}
