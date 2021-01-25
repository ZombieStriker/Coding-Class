package me.danielle.nilsson.undeadengine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UndeadSpriteUtil {

	public static BufferedImage getImage(String path) {
		if (path == null)
			return null;
		InputStream stream = UndeadSpriteUtil.class.getResourceAsStream(path);
		if(stream==null)
			return null;
		try {
			return ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}



}
