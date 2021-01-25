package me.danielle.nilsson.week8;

import me.danielle.nilsson.undeadengine.*;

public class MesasagerGame implements Game {


	private String[] messages = new String[100];

	private StringBuilder typingMessage = new StringBuilder();


	boolean addUnderscore = true;

	int timer = 0;
	int maxTimeToBlinkingUnderscore = 30;

	@Override
	public void tick() {
		timer++;
		if(timer >= maxTimeToBlinkingUnderscore){
			timer=0;
			if(addUnderscore) {
				addUnderscore = false;
			}else{
				addUnderscore=true;
			}
		}
	}

	@Override
	public void render(GraphicsWrapper graphics) {

		if(addUnderscore){
			graphics.drawText(typingMessage.toString()+"_", 20, 900);
		}else {
			graphics.drawText(typingMessage.toString(), 20, 900);
		}

		for(int i = 0; i <messages.length ; i++){
			graphics.drawText(messages[i], 20, 890 - (i*10) );
		}
	}

	@Override
	public void keyPressed(Key key) {
		if (key == Key.BACKSPACE) {
			if(typingMessage.length()>0)
			typingMessage.delete(typingMessage.length() - 1, typingMessage.length());


		} else if (key == Key.ENTER) {
			//int i equals (the size of all of the messages, minus 2). While i is greater than OR equal to 0, subtract 1
			for (int i = messages.length-2; i >= 0; i--) {
				messages[i + 1] = messages[i];
			}
			messages[0] = typingMessage.toString();
			typingMessage = new StringBuilder();


		} else {
			if (key.isCharacter())
				typingMessage.append(key.getCharacter());
		}
	}

	@Override
	public void keyReleased(Key key) {

	}

	@Override
	public void mouseClick(Location location, MouseClickType button) {

	}

	@Override
	public void mouseMove(Location location) {

	}
}
