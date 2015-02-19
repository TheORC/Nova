/**
 * 
 */
package com.Gamesareme.nova.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.Gamesareme.nova.Game;



/**
 * @author Oliver
 *
 */
public class Renderer {

	public void renderBackground(Graphics g){
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			Game.getInstance().getMenu().renderer(g);
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UKNOWN Gamestate", 150, 150);
			break;
		
		}
	}
	
	public void renderForeground(Graphics g){
		switch(Game.state){
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UKNOWN Gamestate", 150, 150);
			break;
		
		}
	}

}
