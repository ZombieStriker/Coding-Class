package me.group.codeclass.starship.entity.ai;

import me.group.codeclass.starship.Tile;
import me.group.codeclass.starship.entity.Entity;

public class BasicLeftRightAI extends EntityAI{

	boolean goingleft = true;

	@Override
	public void tick(Entity e) {
		if(goingleft){
			if(e.getWorld().getTileAtPoint(e.getX()-1,e.getY()).material.isSolid()){
				goingleft=!goingleft;
			}else {
				e.setX(e.getX() - 1);
			}
		}else{
			if(e.getWorld().getTileAtPoint(e.getX()+1,e.getY()).material.isSolid()){
				goingleft=!goingleft;
			}else {
				e.setX(e.getX() + 1);
			}
		}

		int ydir = e.getYDir();
		if(e.getWorld().getTileAtPoint(e.getX(),e.getY()-e.getHeight()).material.isSolid()){
			ydir=0;
		}else{
			ydir-=e.getWorld().gravity;
		}

		if(ydir < 0) {
			for (int i = 0; i < e.getWorld().tilesize; i++) {
				Tile floortile = e.getWorld().getTileAtPoint(e.getX(), e.getY() + ydir - e.getHeight());
				if (floortile != null && floortile.material.isSolid()) {
					ydir++;
				} else {
					break;
				}
			}
		}

		e.setYDir(ydir);
		e.setY(e.getY()+ydir);
	}
}
