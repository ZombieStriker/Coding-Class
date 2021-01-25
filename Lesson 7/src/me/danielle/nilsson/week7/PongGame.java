package me.danielle.nilsson.week7;

import me.danielle.nilsson.undeadengine.*;

import java.awt.image.BufferedImage;

public class PongGame implements Game {

	double ballX = 40;
	double ballY = 550;
	double ballXDir = 1;
	double ballYDir = 1;

	int ballsize = 30;

	int paddleX = 30;
	int paddleY = 500;
	int paddleSize = 50;
	int paddleWidth = 16;

	private int ballspeed = 10;

	@Override
	public void tick() {
		for (int ticks = 0; ticks < ballspeed; ticks++) {
			//If the ball is going above the top of the screen, change its direction
			if (ballY-ballsize <= 0)
				ballYDir = -ballYDir;
			//If the ball is going below the screen, change the direction
			if (ballY+ballsize >= 1000)
				ballYDir = -ballYDir;

			//If the ball goes to the left of the screen, reset the ball
			if (ballX <= 0) {
				ballX=40;
				ballY=500;
				ballXDir=1;
				ballYDir=1;
			}
			//If the ball hits the right of the screen, send it back
			if (ballX+ballsize >= 1000)
				ballXDir = -ballXDir;

			//This is the paddle code. Is the ball is within the paddle limits...
			if (ballY>=paddleY  && ballY <= paddleY+paddleSize) {
				//If the ball is about to hit the paddle
				if (ballX + ballXDir <= paddleX + paddleWidth) {
					//This is here in case the ball has already changed direction, this make sure it is only setting
					//The direction if the x direction is negative
					if(ballXDir<0) {
						ballXDir = -ballXDir;
						ballYDir = (Math.random()*2 )-1;
					}
				}
			}

			//Add the direction to the ball to make it move
			ballX += ballXDir;
			ballY += ballYDir;
		}
	}

	@Override
	public void render(GraphicsWrapper graphics) {

		BufferedImage ball = Sprite.BALL.getImage();
		BufferedImage paddle = Sprite.PADDLE.getImage();

		graphics.drawImage(ball, (int)ballX, (int)ballY, ballsize, ballsize);

		graphics.drawImage(paddle, paddleX, paddleY);
	}

	@Override
	public void keyPressed(Key key) {
		if (key == Key.UP_ARROW) {
			if (paddleY > 0)
				paddleY -= paddleSize;
		}
		if (key == Key.DOWN_ARROW) {
			if (paddleY < 900)
				paddleY += paddleSize;
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
