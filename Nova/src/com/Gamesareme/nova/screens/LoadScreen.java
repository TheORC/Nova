/**
 * 
 */
package com.Gamesareme.nova.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.Gamesareme.nova.Game;

/**
 * @author Oliver
 *
 */
public class LoadScreen {

	private static int width = 540;
	private static int numRecources = 8;
	
	private static int loadAdd = width/numRecources;
	private static int loadStatus = 0;
	
	private static String msg = "Loading Rescources...";
	
	public static void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.RED);
		g.drawRect(49, 399, width, 51);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString(msg, 51, 395);
		g.setColor(Color.BLUE);
		g.fillRect(50, 400, loadStatus, 50);
	}
	
	public static void loadMore(){
		loadStatus += loadAdd;
		
	}
	
	public static void setMessage(String message){
		LoadScreen.msg = message;
	}
}
