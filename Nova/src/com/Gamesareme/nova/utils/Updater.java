/**
 * 
 */
package com.Gamesareme.nova.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.libs.Reference;
import com.Gamesareme.nova.utils.files.TextFile;


/**
 * @author Oliver
 *
 */
public class Updater {
	
	private static String currentVersion, newVersion;
	public static int update = 0;

	public static void checkForUpdate(boolean isAuto){
		currentVersion = TextFile.readFile("./version.txt");
		
		try{
			URL site = new URL("https://raw.githubusercontent.com/TheORC/Nova/master/Nova/version.txt"); 
			ReadableByteChannel rbc = Channels.newChannel(site.openStream());
			FileOutputStream fos = new FileOutputStream("./version.txt");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		newVersion = TextFile.readFile("./version.txt");
		
		if(currentVersion.equals(newVersion)){
			if(!isAuto){
				doNotUpdate();
			}
			TextFile.writeFile("./version.txt", currentVersion);
			return;
		}else{
			Object[] options = 
				{
					"Update",
					"Do Not Update"
				};
			int temp = JOptionPane.showOptionDialog(null, "An Has Been Found For Nova! (current version: " + currentVersion + " new version: " + newVersion + 
					")\nUpdate Several minutes!\nDo not close the game while updating!\n A window will pop up when the update is complete!", "Updater", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(temp == 1){
				TextFile.writeFile("./version.txt", currentVersion);
				return;
			}else{
				TextFile.writeFile("./version.txt", newVersion);
				try{
					URL site = new URL("https://raw.githubusercontent.com/TheORC/Nova/master/Nova/resources/sprites/Char.png"); 
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "Char.png");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				try{
					URL site = new URL("https://github.com/TheORC/Nova/raw/master/Nova/resources/fonts/Montague.ttf"); 
					ReadableByteChannel rbc = Channels.newChannel(site.openStream());
					FileOutputStream fos = new FileOutputStream(Reference.FONT_LOCATION + "Montague.ttf");
					fos.getChannel().transferFrom(rbc, 0, 1 << 24);
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
				finishUpdate();
				return;
				
			}
		}
	}
	
	private static void finishUpdate(){
		JOptionPane.showMessageDialog(null, "Game has been updated to version: " + newVersion + "/nGame will noew close!", "Update Copleated", JOptionPane.INFORMATION_MESSAGE);
		Game.exit();
	}
	
	private static void doNotUpdate(){
		JOptionPane.showMessageDialog(null , "No Update Found!", "Updater", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
}