package me.danielle.nilsson.undeadengine;

public enum Sound {

	ACCESS_DENIED("/sounds/Access_Denied.wav"),
	ACCESS_GRANTED("/sounds/Access_Granted.wav"),
	AMMO("/sounds/Ammo.wav"),
	BEEP("/sounds/Beep.wav"),
	BEEP_DENY("/sounds/Beep_Deny.wav"),
	BEEP_MOVE("/sounds/Beep_Move.wav"),
	BEEP_OFF("/sounds/Beep_Off.wav"),
	BEEP_SELECT("/sounds/Beep_Select.wav"),
	BUTTON("/sounds/Button.wav"),
	DIRT("/sounds/Dirt.wav"),
	ERROR("/sounds/Error.wav"),
	EXPLOSION("/sounds/Explosion.wav"),
	GAMECUBE_START("/sounds/GameCubeStart.wav"),
	GRASS("/sounds/Grass.wav"),
	GUN("/sounds/Gun.wav"),
	DOOR("/sounds/Door.wav"),
	HEAVY_DOOR("/sounds/Heavy_Door.wav"),
	INTRUDER_ALERT("/sounds/Intruder_Alert.wav"),
	SAND("/sounds/Sand.wav"),
	WOOD("/sounds/Wood.wav"),

	MUSIC_BOSS1("/music/mus_boss1.wav"),
	MUSIC_CORE("/music/mus_core.wav"),
	MUSIC_DATE("/music/mus_date.wav"),
	MUSIC_DATE_FIGHT("/music/mus_date_fight.wav"),
	MUSIC_DOG_SONG("/music/mus_dogsong.wav"),
	MUSIC_DUMMY_BATTLE("/music/mus_dummybattle.wav"),
	MUSIC_FINALE("/music/mus_f_finale_3.wav"),
	MUSIC_FINALE_FIGHT("/music/mus_f_part1.wav"),
	MUSIC_FALLEN_DOWN("/music/mus_fallendown2.wav"),
	MUSIC_FLOWEY("/music/mus_flowey.wav"),
	MUSIC_HOTEL_BATTLE("/music/mus_hotel_battle.wav"),
	MUSIC_METTATON_BATTLE("/music/mus_mettatonbattle.wav"),
	MUSIC_NEWS_BATTLE("/music/mus_news_battle.wav"),
	MUSIC_RUINS("/music/mus_ruins.wav"),
	MUSIC_SHOP("/music/mus_shop.wav"),
	MUSIC_SNOWY("/music/mus_snowy.wav"),
	MUSIC_SPIDER("/music/mus_spider.wav"),
	MUSIC_TEMSHOP("/music/mus_temshop.wav"),
	MUSIC_TEMVILLAGE("/music/mus_temvillage.wav"),
	MUSIC_UNDYNE_BOSS("/music/mus_undyneboss.wav"),
	MUSIC_ASGORE("/music/mus_vsasgore.wav"),
	MUSIC_MEGALOVANIA("/music/mus_zz_megalovania.wav"),
	MUSIC_BENNYHILL("/music/bennyhill.wav"),
	MUSIC_BRAZIL("/music/Brazil.wav"),
	MUSIC_CLOSER("/music/Closer.wav"),
	MUSIC_CREEPY("/music/Creepy.wav"),
	MUSIC_DEREZZED("/music/Derezzed.wav"),
	MUSIC_END_OF_THE_LINE("/music/EndOfTheLine.wav"),
	MUSIC_EXPLORING_SPACE("/music/ExploringSpace.wav"),
	MUSIC_FALL("/music/Fall.wav"),
	MUSIC_HARDER_BETTER_FASTER_STRONGER("/music/HBFS.wav"),
	MUSIC_INTO_THE_WASTELAND("/music/IntotheWasteland.wav"),
	MUSIC_SEINFELD("/music/Intro.wav"),
	MUSIC_KIRBY_THEME("/music/KirbyTheme.wav"),
	MUSIC_LOST_WOODS("/music/LostWoods.wav"),
	MUSIC_OLD_RECORDS("/music/OldRecords.wav"),
	MUSIC_PORTAL_RADIO("/music/PortalRadio.wav"),
	MUSIC_ROBOT_ROCK("/music/RobotRock.wav"),
	MUSIC_SUPER_MARIO_64("/music/SuperMario64.wav"),
	MUSIC_STARWARS_CANTINA("/music/SWCantina.wav"),
	MUSIC_STARWARS_IMPERIAL_MARCH("/music/SWImperialMarch.wav"),
	MUSIC_STARWARS_THE_FORCE("/music/SWTheForce.wav"),
	MUSIC_STARWARS_TIEFIGHTER("/music/SWTieFighter.wav"),
	MUSIC_TAVERN("/music/Tavern.wav"),
	MUSIC_TETRIS_THEME("/music/TetrisTheme.wav"),
	MUSIC_TETRIS_TRANCE("/music/TetrisTrance.wav"),
	MUSIC_TF2_THEME("/music/TF2Theme.wav"),
	MUSIC_WII_SHOP("/music/WIIShop.wav"),
	MUSIC_WIND_MILL("/music/Wind_Mill.wav"),

	;

	private String path;

	Sound(String p){
		this.path = p;
	}
	public String getPath(){
		return path;
	}
}
