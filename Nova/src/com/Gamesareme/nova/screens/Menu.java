/**
 * 
 */
package com.Gamesareme.nova.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.libs.Images;
import com.Gamesareme.nova.libs.Reference;
import com.Gamesareme.nova.utils.Button;

/**
 * @author Oliver
 *
 */
public class Menu {
	
	public Button play, options, quit;
	
	public Menu(){
		int fillerY = 150;
		play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play");
		options = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50).setText("Options");
		quit = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50).setText("Quit");
	}

	
	public void renderer(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(Images.title, 120, 20, 400, 120, null);
		
		Font font = new Font("Montague", Font.BOLD, 45);
		g.setFont(font);
		
		play.drawButton(g, 45);
		options.drawButton(g, 15);
		quit.drawButton(g, 55);

	}

}
