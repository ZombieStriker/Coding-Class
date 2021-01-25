package me.danielle.nilsson.undeadengine;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class GraphicsWrapper {

	private Graphics2D graphics;

	public GraphicsWrapper(Graphics2D graphics){
		this.graphics = graphics;
	}

	public void drawImage(BufferedImage bufferedImage, int x, int y, int xSize, int ySize){
		graphics.drawImage(bufferedImage,x,y,xSize,ySize,null);
	}
	public void drawImage(BufferedImage bufferedImage, int x, int y){
		drawImage(bufferedImage,x,y,bufferedImage.getWidth(),bufferedImage.getHeight());
	}
	public void setPixel(int x, int y, Color color){
		Color color2 = graphics.getColor();
		graphics.setColor(color);
		graphics.fill3DRect(x,y,1,1,false);
		graphics.setColor(color2);
	}
	public void fillRectangle(int x, int y, int width, int height, Color color){
		Color color2 = graphics.getColor();
		graphics.setColor(color);
		graphics.fill3DRect(x,y,width,height,false);
		graphics.setColor(color2);
	}

	public void drawRotatedImage(BufferedImage bi, int x, int y, double radians){
		AffineTransform transform = new AffineTransform();
		transform.rotate(radians, bi.getWidth()/2, bi.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage bufferedImage = op.filter(bi, null);
		drawImage(bufferedImage,x,y);
	}
	public void drawRotatedImage(BufferedImage bi, int x, int y, int xSize, int ySize, double radians){
		AffineTransform transform = new AffineTransform();
		transform.rotate(radians, bi.getWidth()/2, bi.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage bufferedImage = op.filter(bi, null);
		drawImage(bufferedImage,x,y,xSize,ySize);
	}


	public void drawText(String text, int x, int y){
		if(text!=null)
		graphics.drawString(text,x,y);
	}

	public void setFont(Font font){
		graphics.setFont(font);
	}
	public void setColor(Color color){
		graphics.setColor(color);
	}
}
