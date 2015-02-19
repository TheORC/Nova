/**
 * 
 */
package com.Gamesareme.nova.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.enums.GameState;
import com.Gamesareme.nova.libs.Audio;
import com.Gamesareme.nova.screens.Menu;
import com.Gamesareme.nova.utils.AudioPlayer;

/**
 * @author Oliver
 *
 */
public class MouseInput extends MouseAdapter {
	
	public static boolean presses = false;
	
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE =  new Rectangle(1, 1, 1, 1);
	
	private Menu menu = Game.getInstance().getMenu();

	
	@Override
	public void mouseClicked(MouseEvent event){
		int mouse = event.getButton();
		
		Rectangle rect = new Rectangle(event.getX(), event.getY(), 1, 1);
		presses = true;
		
		if(mouse == MouseEvent.BUTTON1){
			switch(Game.state){
			case GAME:
				break;
			case MENU:
				if(rect.intersects(menu.play)){
					AudioPlayer.playSound(Audio.SOUND_CLICK_PLAY_GAME);
					Game.getInstance().level1.loadLevel();
					Game.getInstance().initCamera();
					Game.getInstance().addKeys();
					Game.state = GameState.GAME;
				}else if(rect.intersects(menu.quit)){
					AudioPlayer.playSound(Audio.SOUND_CLICK_PLAY_GAME);
					while(AudioPlayer.getSound(Audio.SOUND_CLICK_PLAY_GAME).playing());
					Game.exit();
				}else if(rect.intersects(menu.options)){
					AudioPlayer.playSound(Audio.SOUND_CLICK_PLAY_GAME);
					Game.state = GameState.OPTIONS;
				}
				break;
			case OPTIONS:
				break;
			case PAUSE:
				break;
			default:
				break;
			
			}
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		presses = true;
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		presses = false;
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		
		switch(Game.state){
		case GAME:
			break;
		case MENU:
			if((MOUSE.intersects(menu.play) || MOUSE.intersects(menu.options) || MOUSE.intersects(menu.quit)) && !AudioPlayer.hasPlayedHover){
				AudioPlayer.getSound(Audio.SOUND_CLICK).play();
				AudioPlayer.hasPlayedHover = true;
			}else if(!(MOUSE.intersects(menu.play) || MOUSE.intersects(menu.options) || MOUSE.intersects(menu.quit)) && AudioPlayer.hasPlayedHover){
				AudioPlayer.hasPlayedHover = false;
			}
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}
	
}
