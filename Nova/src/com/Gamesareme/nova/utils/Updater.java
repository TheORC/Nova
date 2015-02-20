/**
 * 
 */
package com.Gamesareme.nova.utils;

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
			URL site = new URL("")
		}
	}
}