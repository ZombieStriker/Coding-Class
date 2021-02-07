package me.danielle.nilsson.week9;

import me.danielle.nilsson.undeadengine.*;

public class PlatformerGame implements Game {

	public Tile[][] tiles = new Tile[100][50];

	private double player_x=0;
	private double player_y = 500;
	private double player_velocity_x = 0;
	private double player_velocity_y = 0;

	private int tilesize = 32;
	private int move_speed = 10;
	private int player_height = 64;
	private int player_width = tilesize;

	private double gravity = 0.4;


	private boolean left=false;
	private boolean right=false;
	private boolean jumping=false;


	public PlatformerGame(){

		//Initialize all of the tiles first
		for(int x = 0; x < 100; x++){
			for(int y = 0; y < 50; y++) {
				tiles[x][y] = new Tile();
			}
		}


		for(int x = 0; x < 100; x++){
			tiles[x][0].setType(TileType.STONE);
			tiles[x][1].setType(TileType.DIRT);
			tiles[x][2].setType(TileType.GRASS);

			if(x % 6 == 5){
				tiles[x][3].setType(TileType.GRASS);
			}
		}

		AudioPlayer.playLoop(Sound.MUSIC_DATE);

	}

	public Tile getTileAt(int x, int y){
		int xtile = x / tilesize;
		int ytile = (1000-y) / tilesize;
		return tiles[xtile][ytile];
	}


	@Override
	public void tick() {
		Tile playerTile = getTileAt((int)player_x,(int)player_y);
		//Remember, 0 for the Y is the top left corner, so you have to add to get what is below the player
		Tile belowPlayer = getTileAt((int)player_x,(int)(player_y+ player_height));
		Tile belowPlayer_OtherCorner = getTileAt((int)player_x+player_width,(int)(player_y+ player_height));

		if(left){
			if(player_x-move_speed > 0) {
				player_velocity_x = -move_speed;
			}else{
				player_velocity_x=0;
			}
		}else if(right){
			if(player_x+move_speed<1000-player_width){
				player_velocity_x = move_speed;
			}else{
				player_velocity_x=0;
			}
		}else{
			player_velocity_x = 0;
		}

		//If the player is standing on top of a solid block
		if(belowPlayer.getType().isSolid() || belowPlayer_OtherCorner.getType().isSolid()){
			if(jumping) {
				player_velocity_y=10;
			}else{
				player_velocity_y = 0;
			}
		}else{
			//else, if the player is not on a solid block
			if(player_velocity_y>-9)
			player_velocity_y -= gravity;

		}




		player_x+=player_velocity_x;
		//Remember, Y=0 is the top of the screen, so we need to subtract the negative velocity (make it positive) to go down
		player_y-=player_velocity_y;
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		graphics.drawImage(Sprite.BACKGROUND_3.getImage(),0,0);
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 50; y++) {
				Tile tile = tiles[x][y];
				if(tile.getType()!=TileType.AIR){
					graphics.drawImage(tile.getType().getImage(),x* tilesize, (1000-tilesize)-(y* tilesize), tilesize, tilesize);
				}
			}
		}
		graphics.drawImage(Sprite.ZOMBIE_SIDE.getImage(),(int)player_x,(int)player_y,player_width, player_height);
	}

	@Override
	public void keyPressed(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			right = true;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			left = true;
		}
		if(key == Key.SPACE){
			jumping = true;
		}
	}

	@Override
	public void keyReleased(Key key) {
		if(key == Key.D || key == Key.RIGHT_ARROW){
			right = false;
		}
		if(key == Key.A || key == Key.LEFT_ARROW){
			left = false;
		}
		if(key == Key.SPACE){
			jumping = false;
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
