/**
 * 
 */
package com.Gamesareme.nova.utils;

import java.io.IOException;

import com.Gamesareme.nova.libs.Audio;
import com.Gamesareme.nova.libs.Images;

/**
 * @author Oliver
 *
 */
public class ResourceLoader {

	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void preLoad(){
		try{
			Images.title = imageLoader.loadImage("The Game.png");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadImages(){
		
		try{
			Images.spritesheetBlock = imageLoader.loadImage("Blocks2.png");
			//Images.blocksHD = imageLoader.loadImage("Blocks2.png");
			//Images.spritesheetBlock = ImageModifier.resizeImage(Images.blocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 1);
			//Use this method, to make HD images.
			Images.spritesheetChar = imageLoader.loadImage("Char.png");
			Images.level1 = imageLoader.loadImage("Levels/Level1.png");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadFonts(){
		Fonts.addFont(new Fonts("Montague.ttf"));
	}
	
	public static void loadSounds(){
		System.out.println("loading sounds");
		AudioPlayer.addSound(Audio.SOUND_CLICK, "CLICK20A.ogg");
		AudioPlayer.addSound(Audio.SOUND_CLICK_PLAY_GAME, "sound_decoupler_fire.wav");
		AudioPlayer.addMusic(Audio.MUSIC_FEELING, "_loop_Feeling_Watched.ogg");
	}
}
