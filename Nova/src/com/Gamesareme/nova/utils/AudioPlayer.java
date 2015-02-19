 /**
 * 
 */
package com.Gamesareme.nova.utils;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.Gamesareme.nova.libs.Reference;
import com.Gamesareme.nova.screens.LoadScreen;

/**
 * @author Oliver
 *
 */
public class AudioPlayer {

	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	
	private static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static boolean hasPlayedHover = false;
	
	public static void addSound(String key, String path){
		LoadScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);
		try {
			soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			System.out.println("Failed to find the image: " + path);
			e.printStackTrace();
		}
	}
	
	public static void addMusic(String key, String path){
		LoadScreen.setMessage("Loading music from " + Reference.SOUND_LOCATION);
		try {
			musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Sound getSound(String key){
		return soundMap.get(key);
	}
	
	public static Music getMusic(String key){
		return musicMap.get(key);
	}
	
	public static void playSound(String key){
		soundMap.get(key).play();
	}
	
	public static void playMusic(String key){
		musicMap.get(key).loop();
	}

}
