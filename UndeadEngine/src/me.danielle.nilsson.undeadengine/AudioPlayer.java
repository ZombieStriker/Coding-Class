package me.danielle.nilsson.undeadengine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

	public static synchronized Sound playSound(me.danielle.nilsson.undeadengine.Sound sound) {
		return playSound(sound.getPath(), false);
	}

	public static synchronized Sound playLoop(me.danielle.nilsson.undeadengine.Sound sound) {
		return playSound(sound.getPath(), true);
	}


	public static synchronized Sound playSound(String path, boolean loop) {
		Sound sound = new Sound(path,loop);
		new Thread(sound).start();
		return sound;
	}

	public static class Sound implements Runnable {

		public String path;
		public boolean loop;
		private Clip clip;

		public Sound(String path, boolean loop) {
			this.path = path;
			this.loop = loop;
		}

		// The wrapper thread is unnecessary, unless it blocks on the
		// Clip finishing; see comments.
		public void run() {
			try {
				clip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(
						AudioPlayer.class.getResourceAsStream(path));
				clip.open(inputStream);
				clip.start();
				if (loop) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		public void stop() {
			clip.stop();
		}
	}
}
