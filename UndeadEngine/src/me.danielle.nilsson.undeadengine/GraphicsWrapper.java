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
	public static GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}
	public static BufferedImage getYFlippedImage(BufferedImage image)
	{
		AffineTransform at = new AffineTransform();
		at.concatenate(AffineTransform.getScaleInstance(-1, 1));
		at.concatenate(AffineTransform.getTranslateInstance(-image.getWidth(),0));
		return createTransformed(image, at);
	}

	public static BufferedImage getXFlippedImage(BufferedImage image)
	{
		AffineTransform at = new AffineTransform();
		at.concatenate(AffineTransform.getScaleInstance(1, -1));
		at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
		return createTransformed(image, at);
	}
	private static BufferedImage createTransformed(
			BufferedImage image, AffineTransform at)
	{
		BufferedImage newImage = new BufferedImage(
				image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.transform(at);
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}
	public static BufferedImage getRotatedImage(BufferedImage image, double degrees) {
		int w = image.getWidth(), h = image.getHeight();
		GraphicsConfiguration gc = getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(w, h);
		Graphics2D g = result.createGraphics();
		g.rotate(Math.toRadians(degrees), w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	public void drawText(String text, int x, int y){
		if(text!=null)
		graphics.drawString(text,x,y);
	}
	public void drawColoredText(String text, int x, int y, Color color){
		Color c = graphics.getColor();
		graphics.setColor(color);
		drawText(text,x,y);
		graphics.setColor(c);
	}

	public void setFont(Font font){
		graphics.setFont(font);
	}
	public void setColor(Color color){
		graphics.setColor(color);
	}
}
