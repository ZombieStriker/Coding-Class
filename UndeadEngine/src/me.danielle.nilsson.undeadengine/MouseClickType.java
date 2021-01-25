package me.danielle.nilsson.undeadengine;

import java.awt.event.MouseEvent;

public enum MouseClickType {
	RIGHTCLICK,
	LEFTCLICK,
	;

	public static MouseClickType getTypeFrom(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON1){
			return LEFTCLICK;
		}
		if(e.getButton() == MouseEvent.BUTTON2){
			return RIGHTCLICK;
		}
		return null;
	}
}
