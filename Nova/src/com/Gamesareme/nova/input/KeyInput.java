/**
 * 
 */
package com.Gamesareme.nova.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.core.CoreObject;
import com.Gamesareme.nova.entity.Player;
import com.Gamesareme.nova.libs.Identities;
import com.sun.javafx.scene.traversal.Direction;

/**
 * @author Oliver
 *
 */
public class KeyInput extends KeyAdapter{

	private Player player;
	
	private boolean[] keyDown = new boolean[3];
	
	public KeyInput(){
		for(CoreObject obj : Game.getInstance().getController().getObjects()){
			if(obj.getId() == Identities.PLAYER){
				player = (Player) obj;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W && !player.isJumping()){
				player.setVely(-16);
				player.setJumping(true);
				keyDown[2] = true;
			}
			if(key == KeyEvent.VK_D){
				player.setVelx(5);
				player.setMoving(true);
				player.setDirection(Direction.RIGHT);
				keyDown[1] = true;
			}
			if(key == KeyEvent.VK_A){
				player.setVelx(-5);
				player.setMoving(true);
				player.setDirection(Direction.LEFT);
				keyDown[0] = true;
			}
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(Game.state){
		case GAME:
			if(key == KeyEvent.VK_W && !player.isJumping()){
				keyDown[2] = false;
				player.setJumping(false);
			}
			if(key == KeyEvent.VK_D){
				keyDown[1] = false;
				player.setMoving(false);
			}
			if(key == KeyEvent.VK_A){
				keyDown[0] = false;
				player.setMoving(false);
			}
			
			if(keyDown[0] && !keyDown[1]){
				player.setVelx(-5);
			}
			if(!keyDown[0] && keyDown[1]){
				player.setVelx(5);
			}
			if(!keyDown[0] && !keyDown[1]){
				player.setVelx(0);
			}
			break;
		case MENU:
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
